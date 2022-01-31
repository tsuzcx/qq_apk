package com.tencent.mm.plugin.appbrand.jsapi.media;

import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import android.text.TextUtils;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.graphics.MMBitmapFactory;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.a.c;
import com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalMediaObject;
import com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalMediaObjectManager;
import com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalVideoObject;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessRequest;
import com.tencent.mm.plugin.appbrand.s.m;
import com.tencent.mm.plugin.mmsight.SightCaptureResult;
import com.tencent.mm.plugin.mmsight.SightParams;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.pluginsdk.model.j;
import com.tencent.mm.pluginsdk.ui.tools.n;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.q;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.base.t;
import com.tencent.mm.ui.tools.l;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONStringer;

final class JsApiChooseMedia$a
  extends AppBrandProxyUIProcessTask
{
  private p ehb;
  int hQK;
  private DialogInterface.OnCancelListener hQL;
  private JsApiChooseMedia.ChooseResult hRa;
  private JsApiChooseMedia.ChooseRequest hRb;
  private String hRc;
  private l hRd;
  private String mVideoFilePath;
  
  private JsApiChooseMedia$a()
  {
    AppMethodBeat.i(131178);
    this.hRa = new JsApiChooseMedia.ChooseResult();
    AppMethodBeat.o(131178);
  }
  
  private static String Co(String paramString)
  {
    AppMethodBeat.i(131186);
    String str = com.tencent.mm.compatible.util.e.esr + "microMsg." + System.currentTimeMillis() + ".jpg";
    Bitmap localBitmap;
    try
    {
      localBitmap = MMBitmapFactory.decodeFile(paramString);
      if (localBitmap == null)
      {
        ab.e("MicroMsg.JsApiChooseMedia", "doCompressImage, decode bmp return null");
        AppMethodBeat.o(131186);
        return null;
      }
    }
    catch (OutOfMemoryError paramString)
    {
      ab.e("MicroMsg.JsApiChooseMedia", "doCompressImage, decode bmp oom");
      AppMethodBeat.o(131186);
      return null;
    }
    long l = bo.aoy();
    int i = q.b(localBitmap, 70, str);
    ab.i("MicroMsg.JsApiChooseMedia", "doCompressImage, ret = %d, cost = %d, %s (%d) -> %s (%d)", new Object[] { Integer.valueOf(i), Long.valueOf(bo.aoy() - l), paramString, Long.valueOf(new File(paramString).length()), str, Long.valueOf(new File(str).length()) });
    if (i == 1) {}
    try
    {
      com.tencent.mm.plugin.appbrand.h.b.bZ(paramString, str);
      if (i == 1)
      {
        AppMethodBeat.o(131186);
        return str;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ab.e("MicroMsg.JsApiChooseMedia", "doCompressImage, duplicateExif e = %s", new Object[] { localException });
      }
      AppMethodBeat.o(131186);
    }
    return paramString;
  }
  
  private AppBrandLocalVideoObject Cr(String paramString)
  {
    AppMethodBeat.i(131187);
    boolean bool;
    try
    {
      bool = c.wE(paramString);
      ab.i("MicroMsg.JsApiChooseMedia", "checkRemux, isMp4 = %b", new Object[] { Boolean.valueOf(bool) });
      i = -10000;
      if (!bool) {
        break label497;
      }
      i = SightVideoJNI.shouldRemuxing(paramString, 660, 500, 26214400, 300000.0D, 1000000);
      ab.i("MicroMsg.JsApiChooseMedia", "checkRemux, ret = %d", new Object[] { Integer.valueOf(i) });
    }
    catch (Exception localException1)
    {
      try
      {
        for (;;)
        {
          localObject = new MediaMetadataRetriever();
          ((MediaMetadataRetriever)localObject).setDataSource(paramString);
          if (localObject != null) {
            break;
          }
          ab.e("MicroMsg.JsApiChooseMedia", "addVideoItem, null meta data");
          AppMethodBeat.o(131187);
          return null;
          i = 1;
          break label510;
          i = 1;
          continue;
          i = -50006;
          continue;
          i = -50002;
          continue;
          localObject = new int[2];
          j.c(paramString, (int[])localObject);
          i = localObject[0];
          j = localObject[1];
          localObject = com.tencent.mm.compatible.util.e.esr + "microMsg." + System.currentTimeMillis() + ".mp4";
          ab.i("MicroMsg.JsApiChooseMedia", "remuxIfNeed [%s] to [%s], result %d, resolution:[%d, %d]", new Object[] { paramString, localObject, Integer.valueOf(SightVideoJNI.remuxing(paramString, (String)localObject, i, j, com.tencent.mm.plugin.sight.base.b.qSq, com.tencent.mm.plugin.sight.base.b.qSp, 8, 2, 25.0F, com.tencent.mm.plugin.sight.base.b.qSr, null, 0, false, 0, 51)), Integer.valueOf(i), Integer.valueOf(j) });
          paramString = (String)localObject;
          continue;
          localException1 = localException1;
          ab.e("MicroMsg.JsApiChooseMedia", "addVideoItem, remux failed, exp = %s", new Object[] { bo.l(localException1) });
        }
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          ab.e("MicroMsg.JsApiChooseMedia", "addVideoItem, MetaDataRetriever setDataSource failed, e = %s", new Object[] { localException2 });
          localAppBrandLocalVideoObject = null;
        }
        i = bo.getInt(localAppBrandLocalVideoObject.extractMetadata(18), 0);
        j = bo.getInt(localAppBrandLocalVideoObject.extractMetadata(19), 0);
        k = bo.getInt(localAppBrandLocalVideoObject.extractMetadata(9), 0);
        localAppBrandLocalVideoObject.release();
        localAppBrandLocalVideoObject = AppBrandLocalMediaObjectManager.bv(this.hRb.appId, paramString);
        if (localAppBrandLocalVideoObject != null) {
          break label436;
        }
        ab.e("MicroMsg.JsApiChooseMedia", "attachVideo error, return null");
        AppMethodBeat.o(131187);
        return null;
        localAppBrandLocalVideoObject.duration = ((k + 500) / 1000);
        localAppBrandLocalVideoObject.width = i;
        localAppBrandLocalVideoObject.height = j;
        localAppBrandLocalVideoObject.size = com.tencent.mm.a.e.cM(paramString);
        ab.i("MicroMsg.JsApiChooseMedia", "addVideoItem, return %s", new Object[] { localAppBrandLocalVideoObject });
        AppMethodBeat.o(131187);
        return localAppBrandLocalVideoObject;
      }
    }
    int i = com.tencent.mm.a.e.cM(paramString);
    ab.i("MicroMsg.JsApiChooseMedia", "fileLength = %d", new Object[] { Integer.valueOf(i) });
    if (i > 26214400) {
      i = -1;
    }
    for (;;)
    {
      ab.e("MicroMsg.JsApiChooseMedia", "unknown check type");
      i = -50001;
      if (i != -50006) {}
      Object localObject;
      int j;
      AppBrandLocalVideoObject localAppBrandLocalVideoObject;
      int k;
      label436:
      label497:
      if ((i == -1) || (!bool)) {
        break;
      }
      label510:
      switch (i)
      {
      }
    }
  }
  
  private static boolean Cs(String paramString)
  {
    AppMethodBeat.i(131188);
    if (!TextUtils.isEmpty(paramString))
    {
      File localFile = new File(paramString);
      ab.i("MicroMsg.JsApiChooseMedia", "thumbFilePath:%s", new Object[] { paramString });
      if (localFile.exists())
      {
        ab.i("MicroMsg.JsApiChooseMedia", "video thumb file is exist");
        AppMethodBeat.o(131188);
        return true;
      }
      ab.e("MicroMsg.JsApiChooseMedia", "video thumb file is not exist");
      AppMethodBeat.o(131188);
      return false;
    }
    ab.e("MicroMsg.JsApiChooseMedia", "video thumb file path is null");
    AppMethodBeat.o(131188);
    return false;
  }
  
  private void aDK()
  {
    int i = 0;
    AppMethodBeat.i(131181);
    ab.i("MicroMsg.JsApiChooseMedia", "chooseMediaFromCamera");
    if ((this.hRb.hQY) && (this.hRb.hQX)) {}
    for (;;)
    {
      Intent localIntent = new Intent();
      localIntent.putExtra("KEY_SIGHT_PARAMS", og(i));
      n.a(aBf(), 7, localIntent, 3, i);
      AppMethodBeat.o(131181);
      return;
      if (this.hRb.hQY) {
        i = 1;
      } else if (this.hRb.hQX) {
        i = 2;
      }
    }
  }
  
  private void aDL()
  {
    int i = 3;
    boolean bool = true;
    AppMethodBeat.i(131183);
    ab.i("MicroMsg.JsApiChooseMedia", "chooseMediaFromAlbum");
    Intent localIntent;
    if ((this.hRb.hQX) && (this.hRb.hQY))
    {
      localIntent = new Intent();
      localIntent.putExtra("key_can_select_video_and_pic", true);
      if (this.hRb.hQF) {
        break label133;
      }
    }
    for (;;)
    {
      localIntent.putExtra("key_send_raw_image", bool);
      n.a(aBf(), 8, this.hRb.count, this.hQK, i, localIntent);
      AppMethodBeat.o(131183);
      return;
      if (this.hRb.hQX)
      {
        i = 1;
        break;
      }
      if (!this.hRb.hQY) {
        break;
      }
      i = 2;
      break;
      label133:
      bool = false;
    }
  }
  
  private void aDM()
  {
    AppMethodBeat.i(131185);
    this.hQL = new JsApiChooseMedia.a.8(this);
    MMActivity localMMActivity = aBf();
    ah.getResources().getString(2131297087);
    this.ehb = h.b(localMMActivity, ah.getResources().getString(2131296594), true, this.hQL);
    AppMethodBeat.o(131185);
  }
  
  private static String b(String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(131190);
    if (bo.isNullOrNil(paramString1))
    {
      ab.e("MicroMsg.JsApiChooseMedia", "parseVideoItemToJson localId is null");
      AppMethodBeat.o(131190);
      return "";
    }
    ab.i("MicroMsg.JsApiChooseMedia", "parseVideoItemToJson()");
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
      AppMethodBeat.o(131190);
      return paramString1;
    }
    catch (Exception paramString1)
    {
      ab.printErrStackTrace("MicroMsg.JsApiChooseMedia", paramString1, "", new Object[0]);
      AppMethodBeat.o(131190);
    }
    return "";
  }
  
  private static String b(ArrayList<String> paramArrayList, ArrayList<Long> paramArrayList1)
  {
    AppMethodBeat.i(131189);
    if ((paramArrayList == null) || (paramArrayList.size() == 0))
    {
      ab.e("MicroMsg.JsApiChooseMedia", "parseImageItemToJson localIds is null");
      AppMethodBeat.o(131189);
      return "";
    }
    ab.i("MicroMsg.JsApiChooseMedia", "parseImageItemToJson()");
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
      AppMethodBeat.o(131189);
      return paramArrayList;
    }
    catch (Exception paramArrayList)
    {
      ab.printErrStackTrace("MicroMsg.JsApiChooseMedia", paramArrayList, "", new Object[0]);
      AppMethodBeat.o(131189);
    }
    return "";
  }
  
  private SightParams og(int paramInt)
  {
    AppMethodBeat.i(131182);
    String str1 = "microMsg_" + System.currentTimeMillis();
    this.mVideoFilePath = (com.tencent.mm.compatible.util.e.esr + "microMsg." + str1 + ".mp4");
    this.hRc = (com.tencent.mm.compatible.util.e.esr + "microMsg." + str1 + ".jpeg");
    int j = this.hRb.maxDuration;
    SightParams localSightParams = new SightParams(3, 1);
    if (this.hRb.isFront) {}
    for (int i = 1;; i = 2)
    {
      localSightParams.oFP = i;
      localSightParams.mode = paramInt;
      if (localSightParams.fcu == null) {
        localSightParams.fcu = new VideoTransPara();
      }
      localSightParams.fcu.duration = j;
      localSightParams.oFW = false;
      String str2 = com.tencent.mm.compatible.util.e.esr + String.format("%s%d.%s", new Object[] { "capture", Long.valueOf(System.currentTimeMillis()), "jpg" });
      localSightParams.q(str1, this.mVideoFilePath, this.hRc, str2);
      AppMethodBeat.o(131182);
      return localSightParams;
    }
  }
  
  public final void a(AppBrandProxyUIProcessTask.ProcessRequest paramProcessRequest)
  {
    AppMethodBeat.i(131179);
    this.hRb = ((JsApiChooseMedia.ChooseRequest)paramProcessRequest);
    if ((this.hRb.hQF & this.hRb.hQG))
    {
      i = 8;
      this.hQK = i;
      if (bo.hg(aBf()) <= 200L) {
        break label199;
      }
    }
    label199:
    for (int i = 1;; i = 0)
    {
      if (i == 0)
      {
        ab.e("MicroMsg.JsApiChooseMedia", "memory is not enough!");
        t.makeText(aBf(), ah.getResources().getString(2131296593), 1).show();
      }
      ab.i("MicroMsg.JsApiChooseMedia", "goVideo");
      aBf().mmSetOnActivityResultCallback(this);
      if ((!this.hRb.hQV) || (!this.hRb.hQW)) {
        break label204;
      }
      this.hRd = new l(aBf());
      this.hRd.b(null, new JsApiChooseMedia.a.1(this), new JsApiChooseMedia.a.2(this));
      this.hRd.setOnCancelListener(new JsApiChooseMedia.a.3(this));
      this.hRd.cwt();
      AppMethodBeat.o(131179);
      return;
      i = 7;
      break;
    }
    label204:
    if (this.hRb.hQV)
    {
      aDL();
      AppMethodBeat.o(131179);
      return;
    }
    if (this.hRb.hQW)
    {
      aDK();
      AppMethodBeat.o(131179);
      return;
    }
    this.hRa.bpE = -2;
    ab.e("MicroMsg.JsApiChooseMedia", "parameter is invalid, fail and finish process");
    a(this.hRa);
    AppMethodBeat.o(131179);
  }
  
  public final void aBl()
  {
    AppMethodBeat.i(131180);
    super.aBl();
    if (this.ehb != null)
    {
      this.ehb.dismiss();
      this.ehb = null;
    }
    if (this.hRd != null)
    {
      this.hRd.dismiss();
      this.hRd = null;
    }
    AppMethodBeat.o(131180);
  }
  
  public final void c(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(131184);
    if (paramInt2 == 0)
    {
      ab.e("MicroMsg.JsApiChooseMedia", "mmOnActivityResult resultCode is canceled");
      this.hRa.bpE = 0;
      a(this.hRa);
      AppMethodBeat.o(131184);
      return;
    }
    if (-1 != paramInt2)
    {
      ab.e("MicroMsg.JsApiChooseMedia", "mmOnActivityResult resultCode is not RESULT_OK");
      this.hRa.bpE = -2;
      a(this.hRa);
      AppMethodBeat.o(131184);
      return;
    }
    switch (paramInt1)
    {
    }
    for (;;)
    {
      this.hRa.bpE = -2;
      a(this.hRa);
      AppMethodBeat.o(131184);
      return;
      ab.i("MicroMsg.JsApiChooseMedia", "REQUEST_CODE_TAKE_MEDIA_LOCAL");
      Object localObject = paramIntent.getStringArrayListExtra("key_select_video_list");
      if ((localObject != null) && (((ArrayList)localObject).size() > 0))
      {
        this.mVideoFilePath = ((String)((ArrayList)localObject).get(0));
        if (bo.isNullOrNil(this.mVideoFilePath))
        {
          ab.e("MicroMsg.JsApiChooseMedia", "take media local, mVideoFilePath is  null, fail");
        }
        else
        {
          aDM();
          com.tencent.mm.plugin.appbrand.t.e.aNS().ac(new JsApiChooseMedia.a.4(this));
          AppMethodBeat.o(131184);
        }
      }
      else
      {
        localObject = paramIntent.getStringArrayListExtra("CropImage_OutputPath_List");
        if ((localObject == null) || (((List)localObject).size() == 0))
        {
          ab.e("MicroMsg.JsApiChooseMedia", "chosen is null,  fail");
          this.hRa.bpE = -2;
          a(this.hRa);
          AppMethodBeat.o(131184);
          return;
        }
        boolean bool = paramIntent.getBooleanExtra("CropImage_Compress_Img", false);
        final int i = this.hRb.hQF;
        if (!this.hRb.hQG)
        {
          paramInt1 = 1;
          if (((paramInt1 & i) == 0) && (!(this.hRb.hQF & this.hRb.hQG & bool))) {
            break label432;
          }
        }
        label432:
        for (i = 1;; i = 0)
        {
          ab.i("MicroMsg.JsApiChooseMedia", "onActivityResult, fromCamera = %b, canCompress = %b, canOriginal = %b, CropImageUI.KCompressImg = %b, doCompress = %b", new Object[] { Boolean.FALSE, Boolean.valueOf(this.hRb.hQF), Boolean.valueOf(this.hRb.hQG), Boolean.valueOf(bool), Boolean.valueOf(i) });
          if (i != 0) {
            aDM();
          }
          m.aNS().ac(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(131173);
              ArrayList localArrayList1 = new ArrayList(this.hQN.size());
              ArrayList localArrayList2 = new ArrayList(this.hQN.size());
              Iterator localIterator = this.hQN.iterator();
              while (localIterator.hasNext())
              {
                Object localObject2 = (String)localIterator.next();
                Object localObject1 = localObject2;
                if (i) {
                  localObject1 = JsApiChooseMedia.a.access$1500((String)localObject2);
                }
                localObject2 = AppBrandLocalMediaObjectManager.j(JsApiChooseMedia.a.h(JsApiChooseMedia.a.this).appId, (String)localObject1, i | false);
                if (localObject2 != null)
                {
                  localArrayList1.add(Long.valueOf(((AppBrandLocalMediaObject)localObject2).gmb));
                  localArrayList2.add(((AppBrandLocalMediaObject)localObject2).ctV);
                }
                else
                {
                  ab.e("MicroMsg.JsApiChooseMedia", "handle image from album, get null obj from path: %s", new Object[] { localObject1 });
                }
              }
              if (localArrayList2.size() == 0)
              {
                ab.e("MicroMsg.JsApiChooseMedia", "handle image from album, get null obj");
                JsApiChooseMedia.a.e(JsApiChooseMedia.a.this).bpE = -2;
                JsApiChooseMedia.a.e(JsApiChooseMedia.a.this, JsApiChooseMedia.a.e(JsApiChooseMedia.a.this));
                AppMethodBeat.o(131173);
                return;
              }
              al.d(new JsApiChooseMedia.a.5.1(this, localArrayList2, localArrayList1));
              AppMethodBeat.o(131173);
            }
          });
          AppMethodBeat.o(131184);
          return;
          paramInt1 = 0;
          break;
        }
        ab.i("MicroMsg.JsApiChooseMedia", "REQUEST_CODE_TAKE_MEDIA_CAMERA");
        if (paramIntent != null)
        {
          ab.i("MicroMsg.JsApiChooseMedia", "data is valid!");
          localObject = (SightCaptureResult)paramIntent.getParcelableExtra("key_req_result");
          if (localObject == null)
          {
            ab.e("MicroMsg.JsApiChooseMedia", "sight capture result is null!");
            this.hRa.bpE = -2;
            a(this.hRa);
            AppMethodBeat.o(131184);
            return;
          }
          if (((SightCaptureResult)localObject).oFG)
          {
            localObject = ((SightCaptureResult)localObject).oFO;
            if (bo.isNullOrNil((String)localObject))
            {
              ab.e("MicroMsg.JsApiChooseMedia", "picture_picturePath file is not exist! path:%s", new Object[] { localObject });
              this.hRa.bpE = -2;
              a(this.hRa);
              AppMethodBeat.o(131184);
              return;
            }
            bool = paramIntent.getBooleanExtra("CropImage_Compress_Img", false);
            int j = this.hRb.hQF;
            if (!this.hRb.hQG)
            {
              paramInt1 = 1;
              if (((paramInt1 & j) == 0) && (!(this.hRb.hQF & this.hRb.hQG & bool))) {
                break label733;
              }
            }
            label733:
            for (j = 1;; j = 0)
            {
              ab.d("MicroMsg.JsApiChooseMedia", "onActivityResult, fromCamera = %b, canCompress = %b, canOriginal = %b, CropImageUI.KCompressImg = %b, doCompress = %b", new Object[] { Boolean.TRUE, Boolean.valueOf(this.hRb.hQF), Boolean.valueOf(this.hRb.hQG), Boolean.valueOf(bool), Boolean.valueOf(j) });
              if (j != 0) {
                aDM();
              }
              m.aNS().ac(new JsApiChooseMedia.a.6(this, j, (String)localObject));
              AppMethodBeat.o(131184);
              return;
              paramInt1 = 0;
              break;
            }
          }
          this.mVideoFilePath = ((SightCaptureResult)localObject).oFI;
          if (bo.isNullOrNil(this.mVideoFilePath))
          {
            ab.e("MicroMsg.JsApiChooseMedia", "mVideoFilePath is null");
          }
          else
          {
            ab.i("MicroMsg.JsApiChooseMedia", "mVideoFilePath:%s", new Object[] { this.mVideoFilePath });
            if ((!Cs(this.hRc)) && (Cs(((SightCaptureResult)localObject).oFJ))) {
              this.hRc = ((SightCaptureResult)localObject).oFJ;
            }
            aDM();
            m.aNS().ac(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(131176);
                if (new File(JsApiChooseMedia.a.f(JsApiChooseMedia.a.this)).exists())
                {
                  ab.i("MicroMsg.JsApiChooseMedia", "take media camera, the mVideoFilePath file exist, success");
                  JsApiChooseMedia.a.e(JsApiChooseMedia.a.this).bpE = -1;
                  JsApiChooseMedia.a.e(JsApiChooseMedia.a.this).type = "video";
                  AppBrandLocalVideoObject localAppBrandLocalVideoObject = JsApiChooseMedia.a.a(JsApiChooseMedia.a.this, JsApiChooseMedia.a.f(JsApiChooseMedia.a.this));
                  if (localAppBrandLocalVideoObject == null)
                  {
                    ab.e("MicroMsg.JsApiChooseMedia", "addVideoItem fail ,mVideoFilePath is %s", new Object[] { JsApiChooseMedia.a.f(JsApiChooseMedia.a.this) });
                    JsApiChooseMedia.a.e(JsApiChooseMedia.a.this).bpE = -2;
                    JsApiChooseMedia.a.i(JsApiChooseMedia.a.this, JsApiChooseMedia.a.e(JsApiChooseMedia.a.this));
                    AppMethodBeat.o(131176);
                    return;
                  }
                  JsApiChooseMedia.a.b(JsApiChooseMedia.a.this, JsApiChooseMedia.a.f(JsApiChooseMedia.a.this));
                  String str = JsApiChooseMedia.a.g(JsApiChooseMedia.a.this);
                  JsApiChooseMedia.a.e(JsApiChooseMedia.a.this).hQZ = JsApiChooseMedia.a.c(localAppBrandLocalVideoObject.ctV, str, localAppBrandLocalVideoObject.duration, localAppBrandLocalVideoObject.height, localAppBrandLocalVideoObject.width, localAppBrandLocalVideoObject.size);
                  JsApiChooseMedia.a.j(JsApiChooseMedia.a.this, JsApiChooseMedia.a.e(JsApiChooseMedia.a.this));
                  AppMethodBeat.o(131176);
                  return;
                }
                ab.e("MicroMsg.JsApiChooseMedia", "take media camera, mVideoFilePath is %s, the file not exist, fail", new Object[] { JsApiChooseMedia.a.f(JsApiChooseMedia.a.this) });
                JsApiChooseMedia.a.e(JsApiChooseMedia.a.this).bpE = -2;
                JsApiChooseMedia.a.k(JsApiChooseMedia.a.this, JsApiChooseMedia.a.e(JsApiChooseMedia.a.this));
                AppMethodBeat.o(131176);
              }
            });
            AppMethodBeat.o(131184);
          }
        }
        else
        {
          ab.e("MicroMsg.JsApiChooseMedia", "data is null!");
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.media.JsApiChooseMedia.a
 * JD-Core Version:    0.7.0.1
 */