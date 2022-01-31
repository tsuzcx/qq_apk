package com.tencent.mm.plugin.appbrand.jsapi.media;

import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import android.text.TextUtils;
import android.widget.Toast;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalMediaObject;
import com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalMediaObjectManager;
import com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalVideoObject;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessRequest;
import com.tencent.mm.plugin.appbrand.y.j;
import com.tencent.mm.plugin.mmsight.SightCaptureResult;
import com.tencent.mm.plugin.mmsight.SightParams;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.pluginsdk.ui.tools.l;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.base.s;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONStringer;

final class JsApiChooseMedia$a
  extends AppBrandProxyUIProcessTask
{
  private p dpF;
  private JsApiChooseMedia.ChooseResult gvJ = new JsApiChooseMedia.ChooseResult();
  private JsApiChooseMedia.ChooseRequest gvK;
  private String gvL;
  private com.tencent.mm.ui.tools.j gvM;
  int gvt;
  private DialogInterface.OnCancelListener gvu;
  private String mVideoFilePath;
  
  private void aju()
  {
    y.i("MicroMsg.JsApiChooseMedia", "chooseMediaFromCamera");
    int i;
    if ((this.gvK.gvH) && (this.gvK.gvG)) {
      i = 0;
    }
    for (;;)
    {
      Intent localIntent = new Intent();
      String str1 = "microMsg_" + System.currentTimeMillis();
      this.mVideoFilePath = (com.tencent.mm.compatible.util.e.dzD + "microMsg." + str1 + ".mp4");
      this.gvL = (com.tencent.mm.compatible.util.e.dzD + "microMsg." + str1 + ".jpeg");
      int k = this.gvK.maxDuration;
      SightParams localSightParams = new SightParams(3, 1);
      if (this.gvK.isFront) {}
      for (int j = 1;; j = 2)
      {
        localSightParams.mfq = j;
        localSightParams.mode = i;
        if (localSightParams.mfr == null) {
          localSightParams.mfr = new VideoTransPara();
        }
        localSightParams.mfr.duration = k;
        localSightParams.mfy = false;
        String str2 = com.tencent.mm.compatible.util.e.dzD + String.format("%s%d.%s", new Object[] { "capture", Long.valueOf(System.currentTimeMillis()), "jpg" });
        localSightParams.o(str1, this.mVideoFilePath, this.gvL, str2);
        localIntent.putExtra("KEY_SIGHT_PARAMS", localSightParams);
        l.a(ahy(), 7, localIntent, 3, i);
        return;
        if (this.gvK.gvH)
        {
          i = 1;
          break;
        }
        if (!this.gvK.gvG) {
          break label333;
        }
        i = 2;
        break;
      }
      label333:
      i = 0;
    }
  }
  
  private void ajv()
  {
    int i = 3;
    boolean bool = true;
    y.i("MicroMsg.JsApiChooseMedia", "chooseMediaFromAlbum");
    Intent localIntent;
    if ((this.gvK.gvG) && (this.gvK.gvH))
    {
      localIntent = new Intent();
      localIntent.putExtra("key_can_select_video_and_pic", true);
      if (this.gvK.gvo) {
        break label119;
      }
    }
    for (;;)
    {
      localIntent.putExtra("key_send_raw_image", bool);
      l.a(ahy(), 8, this.gvK.count, this.gvt, i, false, localIntent);
      return;
      if (this.gvK.gvG)
      {
        i = 1;
        break;
      }
      if (!this.gvK.gvH) {
        break;
      }
      i = 2;
      break;
      label119:
      bool = false;
    }
  }
  
  private void ajw()
  {
    this.gvu = new JsApiChooseMedia.a.8(this);
    MMActivity localMMActivity = ahy();
    int i = y.j.app_tip;
    ae.getResources().getString(i);
    i = y.j.app_brand_choose_media_video_compressing;
    this.dpF = h.b(localMMActivity, ae.getResources().getString(i), true, this.gvu);
  }
  
  private static String c(String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (bk.bl(paramString1))
    {
      y.e("MicroMsg.JsApiChooseMedia", "parseVideoItemToJson localId is null");
      return "";
    }
    y.i("MicroMsg.JsApiChooseMedia", "parseVideoItemToJson()");
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
      return paramString1;
    }
    catch (Exception paramString1)
    {
      y.printErrStackTrace("MicroMsg.JsApiChooseMedia", paramString1, "", new Object[0]);
    }
    return "";
  }
  
  private static String g(ArrayList<String> paramArrayList, ArrayList<Long> paramArrayList1)
  {
    if ((paramArrayList == null) || (paramArrayList.size() == 0))
    {
      y.e("MicroMsg.JsApiChooseMedia", "parseImageItemToJson localIds is null");
      return "";
    }
    y.i("MicroMsg.JsApiChooseMedia", "parseImageItemToJson()");
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
      return paramArrayList;
    }
    catch (Exception paramArrayList)
    {
      y.printErrStackTrace("MicroMsg.JsApiChooseMedia", paramArrayList, "", new Object[0]);
    }
    return "";
  }
  
  private static String um(String paramString)
  {
    String str = com.tencent.mm.compatible.util.e.dzD + "microMsg." + System.currentTimeMillis() + ".jpg";
    for (;;)
    {
      Bitmap localBitmap;
      try
      {
        localBitmap = MMBitmapFactory.decodeFile(paramString, 0);
        if (localBitmap == null)
        {
          y.e("MicroMsg.JsApiChooseMedia", "doCompressImage, decode bmp return null");
          paramString = null;
          return paramString;
        }
      }
      catch (OutOfMemoryError paramString)
      {
        y.e("MicroMsg.JsApiChooseMedia", "doCompressImage, decode bmp oom");
        return null;
      }
      long l = bk.UY();
      int i = com.tencent.mm.sdk.platformtools.n.a(localBitmap, 70, str);
      y.i("MicroMsg.JsApiChooseMedia", "doCompressImage, ret = %d, cost = %d, %s (%d) -> %s (%d)", new Object[] { Integer.valueOf(i), Long.valueOf(bk.UY() - l), paramString, Long.valueOf(new File(paramString).length()), str, Long.valueOf(new File(str).length()) });
      if (i == 1) {}
      try
      {
        com.tencent.mm.plugin.appbrand.h.b.bv(paramString, str);
        if (i != 1) {
          continue;
        }
        return str;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          y.e("MicroMsg.JsApiChooseMedia", "doCompressImage, duplicateExif e = %s", new Object[] { localException });
        }
      }
    }
  }
  
  private AppBrandLocalVideoObject up(String paramString)
  {
    boolean bool;
    try
    {
      bool = com.tencent.mm.plugin.a.c.pp(paramString);
      y.i("MicroMsg.JsApiChooseMedia", "checkRemux, isMp4 = %b", new Object[] { Boolean.valueOf(bool) });
      i = -10000;
      if (!bool) {
        break label490;
      }
      i = SightVideoJNI.shouldRemuxing(paramString, 660, 500, 26214400, 300000.0D, 1000000);
      y.i("MicroMsg.JsApiChooseMedia", "checkRemux, ret = %d", new Object[] { Integer.valueOf(i) });
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
          y.e("MicroMsg.JsApiChooseMedia", "addVideoItem, null meta data");
          return null;
          i = 1;
          break label503;
          i = 1;
          continue;
          i = -50006;
          continue;
          i = -50002;
          continue;
          localObject = new int[2];
          com.tencent.mm.pluginsdk.model.j.c(paramString, (int[])localObject);
          i = localObject[0];
          j = localObject[1];
          localObject = com.tencent.mm.compatible.util.e.dzD + "microMsg." + System.currentTimeMillis() + ".mp4";
          y.i("MicroMsg.JsApiChooseMedia", "remuxIfNeed [%s] to [%s], result %d, resolution:[%d, %d]", new Object[] { paramString, localObject, Integer.valueOf(SightVideoJNI.remuxing(paramString, (String)localObject, i, j, com.tencent.mm.plugin.sight.base.b.oeb, com.tencent.mm.plugin.sight.base.b.oea, 8, 2, 25.0F, com.tencent.mm.plugin.sight.base.b.oec, null, 0, false)), Integer.valueOf(i), Integer.valueOf(j) });
          paramString = (String)localObject;
          continue;
          localException1 = localException1;
          y.e("MicroMsg.JsApiChooseMedia", "addVideoItem, remux failed, exp = %s", new Object[] { bk.j(localException1) });
        }
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          y.e("MicroMsg.JsApiChooseMedia", "addVideoItem, MetaDataRetriever setDataSource failed, e = %s", new Object[] { localException2 });
          localAppBrandLocalVideoObject = null;
        }
        i = bk.getInt(localAppBrandLocalVideoObject.extractMetadata(18), 0);
        j = bk.getInt(localAppBrandLocalVideoObject.extractMetadata(19), 0);
        k = bk.getInt(localAppBrandLocalVideoObject.extractMetadata(9), 0);
        localAppBrandLocalVideoObject.release();
        localAppBrandLocalVideoObject = AppBrandLocalMediaObjectManager.attachVideo(this.gvK.appId, paramString);
        if (localAppBrandLocalVideoObject != null) {
          break label434;
        }
        y.e("MicroMsg.JsApiChooseMedia", "attachVideo error, return null");
        return null;
        localAppBrandLocalVideoObject.duration = ((k + 500) / 1000);
        localAppBrandLocalVideoObject.width = i;
        localAppBrandLocalVideoObject.height = j;
        localAppBrandLocalVideoObject.size = com.tencent.mm.a.e.bJ(paramString);
        y.i("MicroMsg.JsApiChooseMedia", "addVideoItem, return %s", new Object[] { localAppBrandLocalVideoObject });
        return localAppBrandLocalVideoObject;
      }
    }
    int i = com.tencent.mm.a.e.bJ(paramString);
    y.i("MicroMsg.JsApiChooseMedia", "fileLength = %d", new Object[] { Integer.valueOf(i) });
    if (i > 26214400) {
      i = -1;
    }
    for (;;)
    {
      y.e("MicroMsg.JsApiChooseMedia", "unknown check type");
      i = -50001;
      if (i != -50006) {}
      Object localObject;
      int j;
      AppBrandLocalVideoObject localAppBrandLocalVideoObject;
      int k;
      label434:
      label490:
      if ((i == -1) || (!bool)) {
        break;
      }
      label503:
      switch (i)
      {
      }
    }
  }
  
  private static boolean uq(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      File localFile = new File(paramString);
      y.i("MicroMsg.JsApiChooseMedia", "thumbFilePath:%s", new Object[] { paramString });
      if (localFile.exists())
      {
        y.i("MicroMsg.JsApiChooseMedia", "video thumb file is exist");
        return true;
      }
      y.e("MicroMsg.JsApiChooseMedia", "video thumb file is not exist");
      return false;
    }
    y.e("MicroMsg.JsApiChooseMedia", "video thumb file path is null");
    return false;
  }
  
  protected final void a(AppBrandProxyUIProcessTask.ProcessRequest paramProcessRequest)
  {
    this.gvK = ((JsApiChooseMedia.ChooseRequest)paramProcessRequest);
    if ((this.gvK.gvo & this.gvK.gvp))
    {
      i = 8;
      this.gvt = i;
      if (bk.fQ(ahy()) <= 200L) {
        break label191;
      }
    }
    label191:
    for (int i = 1;; i = 0)
    {
      if (i == 0)
      {
        y.e("MicroMsg.JsApiChooseMedia", "memory is not enough!");
        paramProcessRequest = ahy();
        i = y.j.app_brand_choose_media_memory_check_message;
        s.makeText(paramProcessRequest, ae.getResources().getString(i), 1).show();
      }
      y.i("MicroMsg.JsApiChooseMedia", "goVideo");
      ahy().gJb = this;
      if ((!this.gvK.gvE) || (!this.gvK.gvF)) {
        break label196;
      }
      this.gvM = new com.tencent.mm.ui.tools.j(ahy());
      this.gvM.b(null, new JsApiChooseMedia.a.1(this), new JsApiChooseMedia.a.2(this));
      this.gvM.d(new JsApiChooseMedia.a.3(this));
      this.gvM.bJQ();
      return;
      i = 7;
      break;
    }
    label196:
    if (this.gvK.gvE)
    {
      ajv();
      return;
    }
    if (this.gvK.gvF)
    {
      aju();
      return;
    }
    this.gvJ.aYY = -2;
    y.e("MicroMsg.JsApiChooseMedia", "parameter is invalid, fail and finish process");
    a(this.gvJ);
  }
  
  protected final void ahE()
  {
    super.ahE();
    if (this.dpF != null)
    {
      this.dpF.dismiss();
      this.dpF = null;
    }
    if (this.gvM != null)
    {
      this.gvM.dismiss();
      this.gvM = null;
    }
  }
  
  public final void c(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt2 == 0)
    {
      y.e("MicroMsg.JsApiChooseMedia", "mmOnActivityResult resultCode is canceled");
      this.gvJ.aYY = 0;
      a(this.gvJ);
      return;
    }
    if (-1 != paramInt2)
    {
      y.e("MicroMsg.JsApiChooseMedia", "mmOnActivityResult resultCode is not RESULT_OK");
      this.gvJ.aYY = -2;
      a(this.gvJ);
      return;
    }
    switch (paramInt1)
    {
    }
    for (;;)
    {
      this.gvJ.aYY = -2;
      a(this.gvJ);
      return;
      y.i("MicroMsg.JsApiChooseMedia", "REQUEST_CODE_TAKE_MEDIA_LOCAL");
      Object localObject = paramIntent.getStringArrayListExtra("key_select_video_list");
      if ((localObject != null) && (((ArrayList)localObject).size() > 0))
      {
        this.mVideoFilePath = ((String)((ArrayList)localObject).get(0));
        if (bk.bl(this.mVideoFilePath))
        {
          y.e("MicroMsg.JsApiChooseMedia", "take media local, mVideoFilePath is  null, fail");
        }
        else
        {
          ajw();
          com.tencent.mm.plugin.appbrand.v.c.DS().O(new JsApiChooseMedia.a.4(this));
        }
      }
      else
      {
        localObject = paramIntent.getStringArrayListExtra("CropImage_OutputPath_List");
        if ((localObject == null) || (((List)localObject).size() == 0))
        {
          y.e("MicroMsg.JsApiChooseMedia", "chosen is null,  fail");
          this.gvJ.aYY = -2;
          a(this.gvJ);
          return;
        }
        boolean bool = paramIntent.getBooleanExtra("CropImage_Compress_Img", false);
        final int i = this.gvK.gvo;
        if (!this.gvK.gvp)
        {
          paramInt1 = 1;
          if (((paramInt1 & i) == 0) && (!(this.gvK.gvo & this.gvK.gvp & bool))) {
            break label393;
          }
        }
        label393:
        for (i = 1;; i = 0)
        {
          y.i("MicroMsg.JsApiChooseMedia", "onActivityResult, fromCamera = %b, canCompress = %b, canOriginal = %b, CropImageUI.KCompressImg = %b, doCompress = %b", new Object[] { Boolean.valueOf(false), Boolean.valueOf(this.gvK.gvo), Boolean.valueOf(this.gvK.gvp), Boolean.valueOf(bool), Boolean.valueOf(i) });
          if (i != 0) {
            ajw();
          }
          com.tencent.mm.plugin.appbrand.u.n.DS().O(new Runnable()
          {
            public final void run()
            {
              ArrayList localArrayList1 = new ArrayList(this.gvw.size());
              ArrayList localArrayList2 = new ArrayList(this.gvw.size());
              Iterator localIterator = this.gvw.iterator();
              while (localIterator.hasNext())
              {
                Object localObject2 = (String)localIterator.next();
                Object localObject1 = localObject2;
                if (i) {
                  localObject1 = JsApiChooseMedia.a.um((String)localObject2);
                }
                localObject2 = AppBrandLocalMediaObjectManager.attach(JsApiChooseMedia.a.h(JsApiChooseMedia.a.this).appId, (String)localObject1, i | false);
                if (localObject2 != null)
                {
                  localArrayList1.add(Long.valueOf(((AppBrandLocalMediaObject)localObject2).eUd));
                  localArrayList2.add(((AppBrandLocalMediaObject)localObject2).bMB);
                }
                else
                {
                  y.e("MicroMsg.JsApiChooseMedia", "handle image from album, get null obj from path: %s", new Object[] { localObject1 });
                }
              }
              if (localArrayList2.size() == 0)
              {
                y.e("MicroMsg.JsApiChooseMedia", "handle image from album, get null obj");
                JsApiChooseMedia.a.e(JsApiChooseMedia.a.this).aYY = -2;
                JsApiChooseMedia.a.e(JsApiChooseMedia.a.this, JsApiChooseMedia.a.e(JsApiChooseMedia.a.this));
                return;
              }
              ai.d(new JsApiChooseMedia.a.5.1(this, localArrayList2, localArrayList1));
            }
          });
          return;
          paramInt1 = 0;
          break;
        }
        y.i("MicroMsg.JsApiChooseMedia", "REQUEST_CODE_TAKE_MEDIA_CAMERA");
        if (paramIntent != null)
        {
          y.i("MicroMsg.JsApiChooseMedia", "data is valid!");
          localObject = (SightCaptureResult)paramIntent.getParcelableExtra("key_req_result");
          if (localObject == null)
          {
            y.e("MicroMsg.JsApiChooseMedia", "sight capture result is null!");
            this.gvJ.aYY = -2;
            a(this.gvJ);
            return;
          }
          if (((SightCaptureResult)localObject).mfh)
          {
            localObject = ((SightCaptureResult)localObject).mfp;
            if (bk.bl((String)localObject))
            {
              y.e("MicroMsg.JsApiChooseMedia", "picture_picturePath file is not exist! path:%s", new Object[] { localObject });
              this.gvJ.aYY = -2;
              a(this.gvJ);
              return;
            }
            bool = paramIntent.getBooleanExtra("CropImage_Compress_Img", false);
            int j = this.gvK.gvo;
            if (!this.gvK.gvp)
            {
              paramInt1 = 1;
              if (((paramInt1 & j) == 0) && (!(this.gvK.gvo & this.gvK.gvp & bool))) {
                break label677;
              }
            }
            label677:
            for (j = 1;; j = 0)
            {
              y.d("MicroMsg.JsApiChooseMedia", "onActivityResult, fromCamera = %b, canCompress = %b, canOriginal = %b, CropImageUI.KCompressImg = %b, doCompress = %b", new Object[] { Boolean.valueOf(true), Boolean.valueOf(this.gvK.gvo), Boolean.valueOf(this.gvK.gvp), Boolean.valueOf(bool), Boolean.valueOf(j) });
              if (j != 0) {
                ajw();
              }
              com.tencent.mm.plugin.appbrand.u.n.DS().O(new JsApiChooseMedia.a.6(this, j, (String)localObject));
              return;
              paramInt1 = 0;
              break;
            }
          }
          this.mVideoFilePath = ((SightCaptureResult)localObject).mfj;
          if (bk.bl(this.mVideoFilePath))
          {
            y.e("MicroMsg.JsApiChooseMedia", "mVideoFilePath is null");
          }
          else
          {
            y.i("MicroMsg.JsApiChooseMedia", "mVideoFilePath:%s", new Object[] { this.mVideoFilePath });
            if ((!uq(this.gvL)) && (uq(((SightCaptureResult)localObject).mfk))) {
              this.gvL = ((SightCaptureResult)localObject).mfk;
            }
            ajw();
            com.tencent.mm.plugin.appbrand.u.n.DS().O(new Runnable()
            {
              public final void run()
              {
                if (new File(JsApiChooseMedia.a.f(JsApiChooseMedia.a.this)).exists())
                {
                  y.i("MicroMsg.JsApiChooseMedia", "take media camera, the mVideoFilePath file exist, success");
                  JsApiChooseMedia.a.e(JsApiChooseMedia.a.this).aYY = -1;
                  JsApiChooseMedia.a.e(JsApiChooseMedia.a.this).type = "video";
                  AppBrandLocalVideoObject localAppBrandLocalVideoObject = JsApiChooseMedia.a.a(JsApiChooseMedia.a.this, JsApiChooseMedia.a.f(JsApiChooseMedia.a.this));
                  if (localAppBrandLocalVideoObject == null)
                  {
                    y.e("MicroMsg.JsApiChooseMedia", "addVideoItem fail ,mVideoFilePath is %s", new Object[] { JsApiChooseMedia.a.f(JsApiChooseMedia.a.this) });
                    JsApiChooseMedia.a.e(JsApiChooseMedia.a.this).aYY = -2;
                    JsApiChooseMedia.a.i(JsApiChooseMedia.a.this, JsApiChooseMedia.a.e(JsApiChooseMedia.a.this));
                    return;
                  }
                  JsApiChooseMedia.a.b(JsApiChooseMedia.a.this, JsApiChooseMedia.a.f(JsApiChooseMedia.a.this));
                  String str = JsApiChooseMedia.a.g(JsApiChooseMedia.a.this);
                  JsApiChooseMedia.a.e(JsApiChooseMedia.a.this).gvI = JsApiChooseMedia.a.d(localAppBrandLocalVideoObject.bMB, str, localAppBrandLocalVideoObject.duration, localAppBrandLocalVideoObject.height, localAppBrandLocalVideoObject.width, localAppBrandLocalVideoObject.size);
                  JsApiChooseMedia.a.j(JsApiChooseMedia.a.this, JsApiChooseMedia.a.e(JsApiChooseMedia.a.this));
                  return;
                }
                y.e("MicroMsg.JsApiChooseMedia", "take media camera, mVideoFilePath is %s, the file not exist, fail", new Object[] { JsApiChooseMedia.a.f(JsApiChooseMedia.a.this) });
                JsApiChooseMedia.a.e(JsApiChooseMedia.a.this).aYY = -2;
                JsApiChooseMedia.a.k(JsApiChooseMedia.a.this, JsApiChooseMedia.a.e(JsApiChooseMedia.a.this));
              }
            });
          }
        }
        else
        {
          y.e("MicroMsg.JsApiChooseMedia", "data is null!");
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.media.JsApiChooseMedia.a
 * JD-Core Version:    0.7.0.1
 */