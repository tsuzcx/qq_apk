package com.tencent.mm.plugin.appbrand.jsapi.media;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import android.text.TextUtils;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnCreateContextMenuListener;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.h.d;
import com.tencent.mm.graphics.MMBitmapFactory;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.appbrand.aa.l.a;
import com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalMediaObject;
import com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalMediaObjectManager;
import com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalVideoObject;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessRequest;
import com.tencent.mm.plugin.mmsight.SightCaptureResult;
import com.tencent.mm.plugin.mmsight.SightParams;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.pluginsdk.ui.tools.q;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.s;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.base.t;
import com.tencent.mm.ui.widget.a.e.b;
import com.tencent.mm.vfs.i;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONStringer;

final class JsApiChooseMedia$a
  extends AppBrandProxyUIProcessTask
{
  private p ftP;
  int jWF;
  private DialogInterface.OnCancelListener jWJ;
  private JsApiChooseMedia.ChooseResult jWZ;
  private JsApiChooseMedia.ChooseRequest jXa;
  private String jXb;
  private String jXc;
  private com.tencent.mm.ui.tools.l jXd;
  
  private JsApiChooseMedia$a()
  {
    AppMethodBeat.i(46453);
    this.jWZ = new JsApiChooseMedia.ChooseResult();
    AppMethodBeat.o(46453);
  }
  
  private static String Ir(String paramString)
  {
    AppMethodBeat.i(46461);
    String str = com.tencent.mm.loader.j.b.ais() + "microMsg." + System.currentTimeMillis() + ".jpg";
    Bitmap localBitmap;
    try
    {
      localBitmap = MMBitmapFactory.decodeFile(paramString);
      if (localBitmap == null)
      {
        ad.e("MicroMsg.JsApiChooseMedia", "doCompressImage, decode bmp return null");
        AppMethodBeat.o(46461);
        return null;
      }
    }
    catch (OutOfMemoryError paramString)
    {
      ad.e("MicroMsg.JsApiChooseMedia", "doCompressImage, decode bmp oom");
      AppMethodBeat.o(46461);
      return null;
    }
    long l = bt.eGO();
    int i = s.c(localBitmap, 70, str);
    ad.i("MicroMsg.JsApiChooseMedia", "doCompressImage, ret = %d, cost = %d, %s (%d) -> %s (%d)", new Object[] { Integer.valueOf(i), Long.valueOf(bt.eGO() - l), paramString, Long.valueOf(i.aMN(paramString)), str, Long.valueOf(i.aMN(str)) });
    if (i == 1) {}
    try
    {
      com.tencent.mm.plugin.appbrand.m.b.cH(paramString, str);
      if (i == 1)
      {
        AppMethodBeat.o(46461);
        return str;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ad.e("MicroMsg.JsApiChooseMedia", "doCompressImage, duplicateExif e = %s", new Object[] { localException });
      }
      AppMethodBeat.o(46461);
    }
    return paramString;
  }
  
  private AppBrandLocalVideoObject Iu(String paramString)
  {
    AppMethodBeat.i(46462);
    boolean bool;
    try
    {
      bool = com.tencent.mm.plugin.a.c.BH(paramString);
      ad.i("MicroMsg.JsApiChooseMedia", "checkRemux, isMp4 = %b", new Object[] { Boolean.valueOf(bool) });
      i = -10000;
      if (!bool) {
        break label499;
      }
      i = SightVideoJNI.shouldRemuxingVFS(paramString, 660, 500, 26214400, 300000.0D, 1000000);
      ad.i("MicroMsg.JsApiChooseMedia", "checkRemux, ret = %d", new Object[] { Integer.valueOf(i) });
    }
    catch (Exception localException1)
    {
      try
      {
        for (;;)
        {
          localObject = new d();
          ((MediaMetadataRetriever)localObject).setDataSource(paramString);
          if (localObject != null) {
            break;
          }
          ad.e("MicroMsg.JsApiChooseMedia", "addVideoItem, null meta data");
          AppMethodBeat.o(46462);
          return null;
          i = 1;
          break label512;
          i = 1;
          continue;
          i = -50006;
          continue;
          i = -50002;
          continue;
          localObject = new int[2];
          com.tencent.mm.pluginsdk.model.l.d(paramString, (int[])localObject);
          i = localObject[0];
          j = localObject[1];
          localObject = com.tencent.mm.loader.j.b.ais() + "microMsg." + System.currentTimeMillis() + ".mp4";
          ad.i("MicroMsg.JsApiChooseMedia", "remuxIfNeed [%s] to [%s], result %d, resolution:[%d, %d]", new Object[] { paramString, localObject, Integer.valueOf(SightVideoJNI.remuxingVFS(paramString, (String)localObject, i, j, com.tencent.mm.plugin.sight.base.c.wrb, com.tencent.mm.plugin.sight.base.c.wra, 8, 2, 25.0F, com.tencent.mm.plugin.sight.base.c.wrc, null, 0, false, 0, 51)), Integer.valueOf(i), Integer.valueOf(j) });
          paramString = (String)localObject;
          continue;
          localException1 = localException1;
          ad.e("MicroMsg.JsApiChooseMedia", "addVideoItem, remux failed, exp = %s", new Object[] { bt.m(localException1) });
        }
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          ad.e("MicroMsg.JsApiChooseMedia", "addVideoItem, MetaDataRetriever setDataSource failed, e = %s", new Object[] { localException2 });
          localAppBrandLocalVideoObject = null;
        }
        i = bt.getInt(localAppBrandLocalVideoObject.extractMetadata(18), 0);
        j = bt.getInt(localAppBrandLocalVideoObject.extractMetadata(19), 0);
        k = bt.getInt(localAppBrandLocalVideoObject.extractMetadata(9), 0);
        localAppBrandLocalVideoObject.release();
        localAppBrandLocalVideoObject = AppBrandLocalMediaObjectManager.fT(this.jXa.appId, paramString);
        if (localAppBrandLocalVideoObject != null) {
          break label437;
        }
        ad.e("MicroMsg.JsApiChooseMedia", "attachVideo error, return null");
        AppMethodBeat.o(46462);
        return null;
        localAppBrandLocalVideoObject.duration = ((k + 500) / 1000);
        localAppBrandLocalVideoObject.width = i;
        localAppBrandLocalVideoObject.height = j;
        localAppBrandLocalVideoObject.size = ((int)i.aMN(paramString));
        ad.i("MicroMsg.JsApiChooseMedia", "addVideoItem, return %s", new Object[] { localAppBrandLocalVideoObject });
        AppMethodBeat.o(46462);
        return localAppBrandLocalVideoObject;
      }
    }
    int i = (int)i.aMN(paramString);
    ad.i("MicroMsg.JsApiChooseMedia", "fileLength = %d", new Object[] { Integer.valueOf(i) });
    if (i > 26214400) {
      i = -1;
    }
    for (;;)
    {
      ad.e("MicroMsg.JsApiChooseMedia", "unknown check type");
      i = -50001;
      if (i != -50006) {}
      Object localObject;
      int j;
      AppBrandLocalVideoObject localAppBrandLocalVideoObject;
      int k;
      label437:
      label499:
      if ((i == -1) || (!bool)) {
        break;
      }
      label512:
      switch (i)
      {
      }
    }
  }
  
  private static boolean Iv(String paramString)
  {
    AppMethodBeat.i(46463);
    if (!TextUtils.isEmpty(paramString))
    {
      com.tencent.mm.vfs.e locale = new com.tencent.mm.vfs.e(paramString);
      ad.i("MicroMsg.JsApiChooseMedia", "thumbFilePath:%s", new Object[] { paramString });
      if (locale.exists())
      {
        ad.i("MicroMsg.JsApiChooseMedia", "video thumb file is exist");
        AppMethodBeat.o(46463);
        return true;
      }
      ad.e("MicroMsg.JsApiChooseMedia", "video thumb file is not exist");
      AppMethodBeat.o(46463);
      return false;
    }
    ad.e("MicroMsg.JsApiChooseMedia", "video thumb file path is null");
    AppMethodBeat.o(46463);
    return false;
  }
  
  private static String b(String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(46465);
    if (bt.isNullOrNil(paramString1))
    {
      ad.e("MicroMsg.JsApiChooseMedia", "parseVideoItemToJson localId is null");
      AppMethodBeat.o(46465);
      return "";
    }
    ad.i("MicroMsg.JsApiChooseMedia", "parseVideoItemToJson()");
    JSONStringer localJSONStringer = new JSONStringer();
    try
    {
      localJSONStringer.array();
      localJSONStringer.object();
      localJSONStringer.key("tempFilePath");
      localJSONStringer.value(paramString1);
      localJSONStringer.key("thumbTempFilePath");
      localJSONStringer.value(paramString2);
      localJSONStringer.key("duration");
      localJSONStringer.value(String.valueOf(paramInt1));
      localJSONStringer.key("height");
      localJSONStringer.value(String.valueOf(paramInt2));
      localJSONStringer.key("width");
      localJSONStringer.value(String.valueOf(paramInt3));
      localJSONStringer.key("size");
      localJSONStringer.value(String.valueOf(paramInt4));
      localJSONStringer.endObject();
      localJSONStringer.endArray();
      paramString1 = localJSONStringer.toString();
      AppMethodBeat.o(46465);
      return paramString1;
    }
    catch (Exception paramString1)
    {
      ad.printErrStackTrace("MicroMsg.JsApiChooseMedia", paramString1, "", new Object[0]);
      AppMethodBeat.o(46465);
    }
    return "";
  }
  
  private static String b(ArrayList<String> paramArrayList, ArrayList<Long> paramArrayList1)
  {
    AppMethodBeat.i(46464);
    if ((paramArrayList == null) || (paramArrayList.size() == 0))
    {
      ad.e("MicroMsg.JsApiChooseMedia", "parseImageItemToJson localIds is null");
      AppMethodBeat.o(46464);
      return "";
    }
    ad.i("MicroMsg.JsApiChooseMedia", "parseImageItemToJson()");
    JSONStringer localJSONStringer = new JSONStringer();
    try
    {
      localJSONStringer.array();
      int i = 0;
      while (i < paramArrayList.size())
      {
        localJSONStringer.object();
        String str = (String)paramArrayList.get(i);
        Long localLong = (Long)paramArrayList1.get(i);
        localJSONStringer.key("tempFilePath");
        localJSONStringer.value(str);
        localJSONStringer.key("size");
        localJSONStringer.value(String.valueOf(localLong.longValue()));
        localJSONStringer.endObject();
        i += 1;
      }
      localJSONStringer.endArray();
      paramArrayList = localJSONStringer.toString();
      AppMethodBeat.o(46464);
      return paramArrayList;
    }
    catch (Exception paramArrayList)
    {
      ad.printErrStackTrace("MicroMsg.JsApiChooseMedia", paramArrayList, "", new Object[0]);
      AppMethodBeat.o(46464);
    }
    return "";
  }
  
  private void baK()
  {
    int i = 0;
    AppMethodBeat.i(46456);
    ad.i("MicroMsg.JsApiChooseMedia", "chooseMediaFromCamera");
    if ((this.jXa.jWX) && (this.jXa.jWW)) {}
    for (;;)
    {
      Intent localIntent = new Intent();
      localIntent.putExtra("KEY_SIGHT_PARAMS", rQ(i));
      q.a(aXi(), 7, localIntent, 3, i);
      AppMethodBeat.o(46456);
      return;
      if (this.jXa.jWX) {
        i = 1;
      } else if (this.jXa.jWW) {
        i = 2;
      }
    }
  }
  
  private void baL()
  {
    int i = 3;
    boolean bool = true;
    AppMethodBeat.i(46458);
    ad.i("MicroMsg.JsApiChooseMedia", "chooseMediaFromAlbum");
    Intent localIntent;
    if ((this.jXa.jWW) && (this.jXa.jWX))
    {
      localIntent = new Intent();
      localIntent.putExtra("key_can_select_video_and_pic", true);
      if (this.jXa.jWy) {
        break label143;
      }
    }
    for (;;)
    {
      localIntent.putExtra("key_send_raw_image", bool);
      localIntent.putExtra("gallery_report_tag", 16);
      q.a(aXi(), 8, this.jXa.count, this.jWF, i, localIntent);
      AppMethodBeat.o(46458);
      return;
      if (this.jXa.jWW)
      {
        i = 1;
        break;
      }
      if (!this.jXa.jWX) {
        break;
      }
      i = 2;
      break;
      label143:
      bool = false;
    }
  }
  
  private void baM()
  {
    AppMethodBeat.i(46460);
    this.jWJ = new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(46452);
        ad.e("MicroMsg.JsApiChooseMedia", "cancel show the progress dialog and finish progress");
        JsApiChooseMedia.a.a(JsApiChooseMedia.a.this).bRZ = 0;
        JsApiChooseMedia.a.m(JsApiChooseMedia.a.this, JsApiChooseMedia.a.a(JsApiChooseMedia.a.this));
        AppMethodBeat.o(46452);
      }
    };
    MMActivity localMMActivity = aXi();
    aj.getResources().getString(2131755906);
    this.ftP = h.b(localMMActivity, aj.getResources().getString(2131755359), true, this.jWJ);
    AppMethodBeat.o(46460);
  }
  
  private SightParams rQ(int paramInt)
  {
    AppMethodBeat.i(46457);
    String str1 = "microMsg_" + System.currentTimeMillis();
    this.jXb = i.k(com.tencent.mm.loader.j.b.ais() + "microMsg." + str1 + ".mp4", false);
    this.jXc = i.k(com.tencent.mm.loader.j.b.ais() + "microMsg." + str1 + ".jpeg", true);
    int j = this.jXa.maxDuration;
    SightParams localSightParams = new SightParams(3, 1);
    if (this.jXa.isFront) {}
    for (int i = 1;; i = 2)
    {
      localSightParams.tAY = i;
      localSightParams.mode = paramInt;
      if (localSightParams.gCB == null) {
        localSightParams.gCB = new VideoTransPara();
      }
      localSightParams.gCB.duration = j;
      localSightParams.tBf = false;
      String str2 = com.tencent.mm.loader.j.b.ais() + String.format("%s%d.%s", new Object[] { "capture", Long.valueOf(System.currentTimeMillis()), "jpg" });
      localSightParams.p(str1, this.jXb, this.jXc, str2);
      AppMethodBeat.o(46457);
      return localSightParams;
    }
  }
  
  public final void a(AppBrandProxyUIProcessTask.ProcessRequest paramProcessRequest)
  {
    AppMethodBeat.i(46454);
    this.jXa = ((JsApiChooseMedia.ChooseRequest)paramProcessRequest);
    if ((this.jXa.jWy & this.jXa.jWz))
    {
      i = 8;
      this.jWF = i;
      if (bt.iJ(aXi()) <= 200L) {
        break label199;
      }
    }
    label199:
    for (int i = 1;; i = 0)
    {
      if (i == 0)
      {
        ad.e("MicroMsg.JsApiChooseMedia", "memory is not enough!");
        t.makeText(aXi(), aj.getResources().getString(2131755358), 1).show();
      }
      ad.i("MicroMsg.JsApiChooseMedia", "goVideo");
      aXi().mmSetOnActivityResultCallback(this);
      if ((!this.jXa.jWU) || (!this.jXa.jWV)) {
        break label204;
      }
      this.jXd = new com.tencent.mm.ui.tools.l(aXi());
      this.jXd.a(new e.b()
      {
        public final void onDismiss()
        {
          AppMethodBeat.i(160599);
          ad.e("MicroMsg.JsApiChooseMedia", "cancel chooseMedia, and finish process!");
          JsApiChooseMedia.a.a(JsApiChooseMedia.a.this).bRZ = 0;
          JsApiChooseMedia.a.a(JsApiChooseMedia.a.this, JsApiChooseMedia.a.a(JsApiChooseMedia.a.this));
          AppMethodBeat.o(160599);
        }
      });
      this.jXd.a(null, new View.OnCreateContextMenuListener()new n.d
      {
        public final void onCreateContextMenu(ContextMenu paramAnonymousContextMenu, View paramAnonymousView, ContextMenu.ContextMenuInfo paramAnonymousContextMenuInfo)
        {
          AppMethodBeat.i(46443);
          paramAnonymousContextMenu.add(0, 1, 0, JsApiChooseMedia.a.b(JsApiChooseMedia.a.this).getString(2131755747));
          paramAnonymousContextMenu.add(0, 2, 1, JsApiChooseMedia.a.c(JsApiChooseMedia.a.this).getString(2131755754));
          AppMethodBeat.o(46443);
        }
      }, new n.d()new e.b
      {
        public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
        {
          AppMethodBeat.i(46444);
          switch (paramAnonymousMenuItem.getItemId())
          {
          }
          for (;;)
          {
            AppMethodBeat.o(46444);
            return;
            JsApiChooseMedia.a.d(JsApiChooseMedia.a.this);
            AppMethodBeat.o(46444);
            return;
            JsApiChooseMedia.a.e(JsApiChooseMedia.a.this);
          }
        }
      }, new e.b()
      {
        public final void onDismiss()
        {
          AppMethodBeat.i(46445);
          ad.e("MicroMsg.JsApiChooseMedia", "cancel chooseMedia, and finish process!");
          JsApiChooseMedia.a.a(JsApiChooseMedia.a.this).bRZ = 0;
          JsApiChooseMedia.a.b(JsApiChooseMedia.a.this, JsApiChooseMedia.a.a(JsApiChooseMedia.a.this));
          AppMethodBeat.o(46445);
        }
      });
      AppMethodBeat.o(46454);
      return;
      i = 7;
      break;
    }
    label204:
    if (this.jXa.jWU)
    {
      baL();
      AppMethodBeat.o(46454);
      return;
    }
    if (this.jXa.jWV)
    {
      baK();
      AppMethodBeat.o(46454);
      return;
    }
    this.jWZ.bRZ = -2;
    ad.e("MicroMsg.JsApiChooseMedia", "parameter is invalid, fail and finish process");
    b(this.jWZ);
    AppMethodBeat.o(46454);
  }
  
  public final void aXp()
  {
    AppMethodBeat.i(46455);
    super.aXp();
    if (this.ftP != null)
    {
      this.ftP.dismiss();
      this.ftP = null;
    }
    if (this.jXd != null)
    {
      this.jXd.dismiss();
      this.jXd = null;
    }
    AppMethodBeat.o(46455);
  }
  
  public final void c(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(46459);
    if (paramInt2 == 0)
    {
      ad.e("MicroMsg.JsApiChooseMedia", "mmOnActivityResult resultCode is canceled");
      this.jWZ.bRZ = 0;
      b(this.jWZ);
      AppMethodBeat.o(46459);
      return;
    }
    if (-1 != paramInt2)
    {
      ad.e("MicroMsg.JsApiChooseMedia", "mmOnActivityResult resultCode is not RESULT_OK");
      this.jWZ.bRZ = -2;
      b(this.jWZ);
      AppMethodBeat.o(46459);
      return;
    }
    switch (paramInt1)
    {
    }
    for (;;)
    {
      this.jWZ.bRZ = -2;
      b(this.jWZ);
      AppMethodBeat.o(46459);
      return;
      ad.i("MicroMsg.JsApiChooseMedia", "REQUEST_CODE_TAKE_MEDIA_LOCAL");
      Object localObject = paramIntent.getStringArrayListExtra("key_select_video_list");
      if ((localObject != null) && (((ArrayList)localObject).size() > 0))
      {
        this.jXb = i.k((String)((ArrayList)localObject).get(0), false);
        if (bt.isNullOrNil(this.jXb))
        {
          ad.e("MicroMsg.JsApiChooseMedia", "take media local, mVideoFilePath is  null, fail");
        }
        else
        {
          baM();
          com.tencent.mm.plugin.appbrand.utils.e.bqm().postToWorker(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(46446);
              if (new com.tencent.mm.vfs.e(JsApiChooseMedia.a.f(JsApiChooseMedia.a.this)).exists())
              {
                ad.i("MicroMsg.JsApiChooseMedia", "take media local, the mVideoFilePath file exist, success");
                JsApiChooseMedia.a.a(JsApiChooseMedia.a.this).bRZ = -1;
                JsApiChooseMedia.a.a(JsApiChooseMedia.a.this).type = "video";
                AppBrandLocalVideoObject localAppBrandLocalVideoObject = JsApiChooseMedia.a.a(JsApiChooseMedia.a.this, JsApiChooseMedia.a.f(JsApiChooseMedia.a.this));
                if (localAppBrandLocalVideoObject == null)
                {
                  ad.e("MicroMsg.JsApiChooseMedia", "addVideoItem fail ,mVideoFilePath is %s", new Object[] { JsApiChooseMedia.a.f(JsApiChooseMedia.a.this) });
                  JsApiChooseMedia.a.a(JsApiChooseMedia.a.this).bRZ = -2;
                  JsApiChooseMedia.a.c(JsApiChooseMedia.a.this, JsApiChooseMedia.a.a(JsApiChooseMedia.a.this));
                  AppMethodBeat.o(46446);
                  return;
                }
                JsApiChooseMedia.a.b(JsApiChooseMedia.a.this, JsApiChooseMedia.a.f(JsApiChooseMedia.a.this));
                String str = JsApiChooseMedia.a.g(JsApiChooseMedia.a.this);
                JsApiChooseMedia.a.a(JsApiChooseMedia.a.this).jWY = JsApiChooseMedia.a.c(localAppBrandLocalVideoObject.diQ, str, localAppBrandLocalVideoObject.duration, localAppBrandLocalVideoObject.height, localAppBrandLocalVideoObject.width, localAppBrandLocalVideoObject.size);
                JsApiChooseMedia.a.d(JsApiChooseMedia.a.this, JsApiChooseMedia.a.a(JsApiChooseMedia.a.this));
                AppMethodBeat.o(46446);
                return;
              }
              ad.e("MicroMsg.JsApiChooseMedia", "take media local, mVideoFilePath is %s, the file not exist, fail", new Object[] { JsApiChooseMedia.a.f(JsApiChooseMedia.a.this) });
              JsApiChooseMedia.a.a(JsApiChooseMedia.a.this).bRZ = -2;
              JsApiChooseMedia.a.e(JsApiChooseMedia.a.this, JsApiChooseMedia.a.a(JsApiChooseMedia.a.this));
              AppMethodBeat.o(46446);
            }
          });
          AppMethodBeat.o(46459);
        }
      }
      else
      {
        localObject = paramIntent.getStringArrayListExtra("CropImage_OutputPath_List");
        if ((localObject == null) || (((List)localObject).size() == 0))
        {
          ad.e("MicroMsg.JsApiChooseMedia", "chosen is null,  fail");
          this.jWZ.bRZ = -2;
          b(this.jWZ);
          AppMethodBeat.o(46459);
          return;
        }
        boolean bool = paramIntent.getBooleanExtra("CropImage_Compress_Img", false);
        final int i = this.jXa.jWy;
        if (!this.jXa.jWz)
        {
          paramInt1 = 1;
          if (((paramInt1 & i) == 0) && (!(this.jXa.jWy & this.jXa.jWz & bool))) {
            break label436;
          }
        }
        label436:
        for (i = 1;; i = 0)
        {
          ad.i("MicroMsg.JsApiChooseMedia", "onActivityResult, fromCamera = %b, canCompress = %b, canOriginal = %b, CropImageUI.KCompressImg = %b, doCompress = %b", new Object[] { Boolean.FALSE, Boolean.valueOf(this.jXa.jWy), Boolean.valueOf(this.jXa.jWz), Boolean.valueOf(bool), Boolean.valueOf(i) });
          if (i != 0) {
            baM();
          }
          com.tencent.mm.plugin.appbrand.aa.l.bqm().postToWorker(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(46448);
              final ArrayList localArrayList1 = new ArrayList(this.jWL.size());
              final ArrayList localArrayList2 = new ArrayList(this.jWL.size());
              Iterator localIterator = this.jWL.iterator();
              while (localIterator.hasNext())
              {
                Object localObject2 = (String)localIterator.next();
                Object localObject1 = localObject2;
                if (i) {
                  localObject1 = JsApiChooseMedia.a.Iw((String)localObject2);
                }
                localObject2 = AppBrandLocalMediaObjectManager.h(JsApiChooseMedia.a.h(JsApiChooseMedia.a.this).appId, (String)localObject1, i | false);
                if (localObject2 != null)
                {
                  localArrayList1.add(Long.valueOf(((AppBrandLocalMediaObject)localObject2).hWY));
                  localArrayList2.add(((AppBrandLocalMediaObject)localObject2).diQ);
                }
                else
                {
                  ad.e("MicroMsg.JsApiChooseMedia", "handle image from album, get null obj from path: %s", new Object[] { localObject1 });
                }
              }
              if (localArrayList2.size() == 0)
              {
                ad.e("MicroMsg.JsApiChooseMedia", "handle image from album, get null obj");
                JsApiChooseMedia.a.a(JsApiChooseMedia.a.this).bRZ = -2;
                JsApiChooseMedia.a.f(JsApiChooseMedia.a.this, JsApiChooseMedia.a.a(JsApiChooseMedia.a.this));
                AppMethodBeat.o(46448);
                return;
              }
              aq.f(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(46447);
                  ad.i("MicroMsg.JsApiChooseMedia", "handle image from album is ok");
                  JsApiChooseMedia.a.a(JsApiChooseMedia.a.this).bRZ = -1;
                  JsApiChooseMedia.a.a(JsApiChooseMedia.a.this).type = "image";
                  JsApiChooseMedia.a.a(JsApiChooseMedia.a.this).jWY = JsApiChooseMedia.a.c(localArrayList2, localArrayList1);
                  JsApiChooseMedia.a.g(JsApiChooseMedia.a.this, JsApiChooseMedia.a.a(JsApiChooseMedia.a.this));
                  AppMethodBeat.o(46447);
                }
              });
              AppMethodBeat.o(46448);
            }
          });
          AppMethodBeat.o(46459);
          return;
          paramInt1 = 0;
          break;
        }
        ad.i("MicroMsg.JsApiChooseMedia", "REQUEST_CODE_TAKE_MEDIA_CAMERA");
        if (paramIntent != null)
        {
          ad.i("MicroMsg.JsApiChooseMedia", "data is valid!");
          localObject = (SightCaptureResult)paramIntent.getParcelableExtra("key_req_result");
          if (localObject == null)
          {
            ad.e("MicroMsg.JsApiChooseMedia", "sight capture result is null!");
            this.jWZ.bRZ = -2;
            b(this.jWZ);
            AppMethodBeat.o(46459);
            return;
          }
          if (((SightCaptureResult)localObject).tAP)
          {
            localObject = i.k(((SightCaptureResult)localObject).tAX, false);
            if (bt.isNullOrNil((String)localObject))
            {
              ad.e("MicroMsg.JsApiChooseMedia", "picture_picturePath file is not exist! path:%s", new Object[] { localObject });
              this.jWZ.bRZ = -2;
              b(this.jWZ);
              AppMethodBeat.o(46459);
              return;
            }
            bool = paramIntent.getBooleanExtra("CropImage_Compress_Img", false);
            final int j = this.jXa.jWy;
            if (!this.jXa.jWz)
            {
              paramInt1 = 1;
              if (((paramInt1 & j) == 0) && (!(this.jXa.jWy & this.jXa.jWz & bool))) {
                break label741;
              }
            }
            label741:
            for (j = 1;; j = 0)
            {
              ad.d("MicroMsg.JsApiChooseMedia", "onActivityResult, fromCamera = %b, canCompress = %b, canOriginal = %b, CropImageUI.KCompressImg = %b, doCompress = %b", new Object[] { Boolean.TRUE, Boolean.valueOf(this.jXa.jWy), Boolean.valueOf(this.jXa.jWz), Boolean.valueOf(bool), Boolean.valueOf(j) });
              if (j != 0) {
                baM();
              }
              com.tencent.mm.plugin.appbrand.aa.l.bqm().postToWorker(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(46450);
                  if (j) {}
                  for (Object localObject = JsApiChooseMedia.a.Iw(this.val$filePath);; localObject = this.val$filePath)
                  {
                    final ArrayList localArrayList1 = new ArrayList();
                    final ArrayList localArrayList2 = new ArrayList();
                    localObject = AppBrandLocalMediaObjectManager.h(JsApiChooseMedia.a.h(JsApiChooseMedia.a.this).appId, (String)localObject, j | true);
                    if (localObject == null) {
                      break;
                    }
                    localArrayList1.add(Long.valueOf(((AppBrandLocalMediaObject)localObject).hWY));
                    localArrayList2.add(((AppBrandLocalMediaObject)localObject).diQ);
                    aq.f(new Runnable()
                    {
                      public final void run()
                      {
                        AppMethodBeat.i(46449);
                        ad.i("MicroMsg.JsApiChooseMedia", "handle image from album is ok");
                        JsApiChooseMedia.a.a(JsApiChooseMedia.a.this).bRZ = -1;
                        JsApiChooseMedia.a.a(JsApiChooseMedia.a.this).type = "image";
                        JsApiChooseMedia.a.a(JsApiChooseMedia.a.this).jWY = JsApiChooseMedia.a.c(localArrayList2, localArrayList1);
                        JsApiChooseMedia.a.h(JsApiChooseMedia.a.this, JsApiChooseMedia.a.a(JsApiChooseMedia.a.this));
                        AppMethodBeat.o(46449);
                      }
                    });
                    AppMethodBeat.o(46450);
                    return;
                  }
                  ad.e("MicroMsg.JsApiChooseMedia", "handle image from mm-sight camera, get null obj from path: %s", new Object[] { this.val$filePath });
                  JsApiChooseMedia.a.a(JsApiChooseMedia.a.this).bRZ = -2;
                  JsApiChooseMedia.a.i(JsApiChooseMedia.a.this, JsApiChooseMedia.a.a(JsApiChooseMedia.a.this));
                  AppMethodBeat.o(46450);
                }
              });
              AppMethodBeat.o(46459);
              return;
              paramInt1 = 0;
              break;
            }
          }
          this.jXb = i.k(((SightCaptureResult)localObject).tAR, false);
          if (bt.isNullOrNil(this.jXb))
          {
            ad.e("MicroMsg.JsApiChooseMedia", "mVideoFilePath is null");
          }
          else
          {
            ad.i("MicroMsg.JsApiChooseMedia", "mVideoFilePath:%s", new Object[] { this.jXb });
            if ((!Iv(this.jXc)) && (Iv(((SightCaptureResult)localObject).tAS))) {
              this.jXc = i.k(((SightCaptureResult)localObject).tAS, true);
            }
            baM();
            com.tencent.mm.plugin.appbrand.aa.l.bqm().postToWorker(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(46451);
                if (new com.tencent.mm.vfs.e(JsApiChooseMedia.a.f(JsApiChooseMedia.a.this)).exists())
                {
                  ad.i("MicroMsg.JsApiChooseMedia", "take media camera, the mVideoFilePath file exist, success");
                  JsApiChooseMedia.a.a(JsApiChooseMedia.a.this).bRZ = -1;
                  JsApiChooseMedia.a.a(JsApiChooseMedia.a.this).type = "video";
                  AppBrandLocalVideoObject localAppBrandLocalVideoObject = JsApiChooseMedia.a.a(JsApiChooseMedia.a.this, JsApiChooseMedia.a.f(JsApiChooseMedia.a.this));
                  if (localAppBrandLocalVideoObject == null)
                  {
                    ad.e("MicroMsg.JsApiChooseMedia", "addVideoItem fail ,mVideoFilePath is %s", new Object[] { JsApiChooseMedia.a.f(JsApiChooseMedia.a.this) });
                    JsApiChooseMedia.a.a(JsApiChooseMedia.a.this).bRZ = -2;
                    JsApiChooseMedia.a.j(JsApiChooseMedia.a.this, JsApiChooseMedia.a.a(JsApiChooseMedia.a.this));
                    AppMethodBeat.o(46451);
                    return;
                  }
                  JsApiChooseMedia.a.b(JsApiChooseMedia.a.this, JsApiChooseMedia.a.f(JsApiChooseMedia.a.this));
                  String str = JsApiChooseMedia.a.g(JsApiChooseMedia.a.this);
                  JsApiChooseMedia.a.a(JsApiChooseMedia.a.this).jWY = JsApiChooseMedia.a.c(localAppBrandLocalVideoObject.diQ, str, localAppBrandLocalVideoObject.duration, localAppBrandLocalVideoObject.height, localAppBrandLocalVideoObject.width, localAppBrandLocalVideoObject.size);
                  JsApiChooseMedia.a.k(JsApiChooseMedia.a.this, JsApiChooseMedia.a.a(JsApiChooseMedia.a.this));
                  AppMethodBeat.o(46451);
                  return;
                }
                ad.e("MicroMsg.JsApiChooseMedia", "take media camera, mVideoFilePath is %s, the file not exist, fail", new Object[] { JsApiChooseMedia.a.f(JsApiChooseMedia.a.this) });
                JsApiChooseMedia.a.a(JsApiChooseMedia.a.this).bRZ = -2;
                JsApiChooseMedia.a.l(JsApiChooseMedia.a.this, JsApiChooseMedia.a.a(JsApiChooseMedia.a.this));
                AppMethodBeat.o(46451);
              }
            });
            AppMethodBeat.o(46459);
          }
        }
        else
        {
          ad.e("MicroMsg.JsApiChooseMedia", "data is null!");
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.media.JsApiChooseMedia.a
 * JD-Core Version:    0.7.0.1
 */