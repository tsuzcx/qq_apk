package com.tencent.mm.plugin.appbrand.jsapi.media;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.media.MediaMetadataRetriever;
import android.text.TextUtils;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.i.d;
import com.tencent.mm.loader.i.b;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.appbrand.af.o;
import com.tencent.mm.plugin.appbrand.af.o.a;
import com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalMediaObject;
import com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalMediaObjectManager;
import com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalVideoObject;
import com.tencent.mm.plugin.appbrand.ba.i;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessRequest;
import com.tencent.mm.plugin.appbrand.utils.l;
import com.tencent.mm.plugin.mmsight.SightCaptureResult;
import com.tencent.mm.plugin.mmsight.SightParams;
import com.tencent.mm.pluginsdk.ui.tools.t;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.aa;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.base.w;
import com.tencent.mm.vfs.y;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONStringer;

final class JsApiChooseMedia$a
  extends AppBrandProxyUIProcessTask
{
  private w lKp;
  private boolean rPj;
  int sfB;
  private DialogInterface.OnCancelListener sfD;
  private JsApiChooseMedia.ChooseResult sfV;
  private JsApiChooseMedia.ChooseRequest sfW;
  private String sfX;
  private String sfY;
  
  private JsApiChooseMedia$a()
  {
    AppMethodBeat.i(46453);
    this.sfV = new JsApiChooseMedia.ChooseResult();
    this.rPj = true;
    AppMethodBeat.o(46453);
  }
  
  private void AR(int paramInt)
  {
    AppMethodBeat.i(329373);
    this.sfD = new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(329267);
        Log.e("MicroMsg.JsApiChooseMedia", "cancel show the progress dialog and finish progress");
        JsApiChooseMedia.a.a(JsApiChooseMedia.a.this).resultCode = 0;
        JsApiChooseMedia.a.n(JsApiChooseMedia.a.this, JsApiChooseMedia.a.a(JsApiChooseMedia.a.this));
        AppMethodBeat.o(329267);
      }
    };
    MMActivity localMMActivity = getActivityContext();
    getString(ba.i.app_tip);
    this.lKp = k.a(localMMActivity, getString(paramInt), true, this.sfD);
    AppMethodBeat.o(329373);
  }
  
  private static String a(String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, long paramLong)
  {
    AppMethodBeat.i(329391);
    if (Util.isNullOrNil(paramString1))
    {
      Log.e("MicroMsg.JsApiChooseMedia", "parseVideoItemToJson localId is null");
      AppMethodBeat.o(329391);
      return "";
    }
    Log.i("MicroMsg.JsApiChooseMedia", "parseVideoItemToJson()");
    JSONStringer localJSONStringer = new JSONStringer();
    try
    {
      localJSONStringer.array();
      a(localJSONStringer, paramString1, paramString2, paramInt1, paramInt2, paramInt3, paramLong);
      localJSONStringer.endArray();
      paramString1 = localJSONStringer.toString();
      AppMethodBeat.o(329391);
      return paramString1;
    }
    catch (Exception paramString1)
    {
      Log.printErrStackTrace("MicroMsg.JsApiChooseMedia", paramString1, "", new Object[0]);
      AppMethodBeat.o(329391);
    }
    return "";
  }
  
  private static void a(JSONStringer paramJSONStringer, String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, long paramLong)
  {
    AppMethodBeat.i(329396);
    if (Util.isNullOrNil(paramString1))
    {
      Log.e("MicroMsg.JsApiChooseMedia", "parseVideoItemToJson localId is null");
      AppMethodBeat.o(329396);
      return;
    }
    Log.i("MicroMsg.JsApiChooseMedia", "parseVideoItemToJson()");
    try
    {
      paramJSONStringer.object();
      paramJSONStringer.key("tempFilePath");
      paramJSONStringer.value(paramString1);
      paramJSONStringer.key("thumbTempFilePath");
      paramJSONStringer.value(paramString2);
      paramJSONStringer.key("duration");
      paramJSONStringer.value(String.valueOf(paramInt1));
      paramJSONStringer.key("height");
      paramJSONStringer.value(String.valueOf(paramInt2));
      paramJSONStringer.key("width");
      paramJSONStringer.value(String.valueOf(paramInt3));
      paramJSONStringer.key("size");
      paramJSONStringer.value(String.valueOf(paramLong));
      paramJSONStringer.key("fileType");
      paramJSONStringer.value("video");
      paramJSONStringer.endObject();
      AppMethodBeat.o(329396);
      return;
    }
    catch (Exception paramJSONStringer)
    {
      Log.printErrStackTrace("MicroMsg.JsApiChooseMedia", paramJSONStringer, "", new Object[0]);
      AppMethodBeat.o(329396);
    }
  }
  
  private static void a(JSONStringer paramJSONStringer, ArrayList<String> paramArrayList, ArrayList<Long> paramArrayList1)
  {
    AppMethodBeat.i(329388);
    if ((paramArrayList == null) || (paramArrayList.size() == 0))
    {
      Log.e("MicroMsg.JsApiChooseMedia", "_parseImageItemToJson localIds is null");
      AppMethodBeat.o(329388);
      return;
    }
    Log.i("MicroMsg.JsApiChooseMedia", "_parseImageItemToJson()");
    int i = 0;
    try
    {
      while (i < paramArrayList.size())
      {
        paramJSONStringer.object();
        String str = (String)paramArrayList.get(i);
        Long localLong = (Long)paramArrayList1.get(i);
        paramJSONStringer.key("tempFilePath");
        paramJSONStringer.value(str);
        paramJSONStringer.key("size");
        paramJSONStringer.value(String.valueOf(localLong.longValue()));
        paramJSONStringer.key("fileType");
        paramJSONStringer.value("image");
        paramJSONStringer.endObject();
        i += 1;
      }
      AppMethodBeat.o(329388);
      return;
    }
    catch (Exception paramJSONStringer)
    {
      Log.printErrStackTrace("MicroMsg.JsApiChooseMedia", paramJSONStringer, "", new Object[0]);
      AppMethodBeat.o(329388);
    }
  }
  
  private AppBrandLocalVideoObject aF(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(329377);
    String str1 = paramString;
    if (paramBoolean) {}
    String str2;
    int i;
    int j;
    int m;
    int k;
    try
    {
      str1 = u.aaU(paramString);
    }
    catch (Exception localException)
    {
      try
      {
        for (;;)
        {
          paramString = new d();
          paramString.setDataSource(str1);
          if (paramString != null) {
            break;
          }
          Log.e("MicroMsg.JsApiChooseMedia", "addVideoItem, null meta data");
          AppMethodBeat.o(329377);
          return null;
          localException = localException;
          Log.e("MicroMsg.JsApiChooseMedia", "addVideoItem, remux failed, exp = %s", new Object[] { Util.stackTraceToString(localException) });
          str2 = paramString;
        }
      }
      catch (Exception paramString)
      {
        for (;;)
        {
          Log.e("MicroMsg.JsApiChooseMedia", "addVideoItem, MetaDataRetriever setDataSource failed, e = %s", new Object[] { paramString });
          paramString = null;
        }
        i = Util.getInt(paramString.extractMetadata(18), 0);
        j = Util.getInt(paramString.extractMetadata(19), 0);
        m = Util.getInt(paramString.extractMetadata(9), 0);
        k = Util.getInt(paramString.extractMetadata(24), 0);
        Log.i("MicroMsg.JsApiChooseMedia", "outputWidth:%d, outputHeight:%d, rotation:%d", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k) });
        if (k == 90) {
          break label200;
        }
      }
    }
    if (k == 270) {}
    for (;;)
    {
      label200:
      paramString.release();
      paramString = AppBrandLocalMediaObjectManager.cW(this.sfW.appId, str2);
      if (paramString == null)
      {
        Log.e("MicroMsg.JsApiChooseMedia", "attachVideo error, return null");
        AppMethodBeat.o(329377);
        return null;
      }
      paramString.duration = ((m + 500) / 1000);
      paramString.width = j;
      paramString.height = i;
      paramString.size = y.bEl(str2);
      Log.i("MicroMsg.JsApiChooseMedia", "addVideoItem, return %s", new Object[] { paramString });
      AppMethodBeat.o(329377);
      return paramString;
      k = i;
      i = j;
      j = k;
    }
  }
  
  private static boolean aaS(String paramString)
  {
    AppMethodBeat.i(46463);
    if (!TextUtils.isEmpty(paramString))
    {
      com.tencent.mm.vfs.u localu = new com.tencent.mm.vfs.u(paramString);
      Log.i("MicroMsg.JsApiChooseMedia", "thumbFilePath:%s", new Object[] { paramString });
      if (localu.jKS())
      {
        Log.i("MicroMsg.JsApiChooseMedia", "video thumb file is exist");
        AppMethodBeat.o(46463);
        return true;
      }
      Log.e("MicroMsg.JsApiChooseMedia", "video thumb file is not exist");
      AppMethodBeat.o(46463);
      return false;
    }
    Log.e("MicroMsg.JsApiChooseMedia", "video thumb file path is null");
    AppMethodBeat.o(46463);
    return false;
  }
  
  private static String b(ArrayList<String> paramArrayList, ArrayList<Long> paramArrayList1)
  {
    AppMethodBeat.i(329385);
    if ((paramArrayList == null) || (paramArrayList.size() == 0))
    {
      Log.e("MicroMsg.JsApiChooseMedia", "parseImageItemToJson localIds is null");
      AppMethodBeat.o(329385);
      return "";
    }
    Log.i("MicroMsg.JsApiChooseMedia", "parseImageItemToJson()");
    JSONStringer localJSONStringer = new JSONStringer();
    try
    {
      localJSONStringer.array();
      a(localJSONStringer, paramArrayList, paramArrayList1);
      localJSONStringer.endArray();
      paramArrayList = localJSONStringer.toString();
      AppMethodBeat.o(329385);
      return paramArrayList;
    }
    catch (Exception paramArrayList)
    {
      Log.printErrStackTrace("MicroMsg.JsApiChooseMedia", paramArrayList, "", new Object[0]);
      AppMethodBeat.o(329385);
    }
    return "";
  }
  
  public final void handleRequest(AppBrandProxyUIProcessTask.ProcessRequest paramProcessRequest)
  {
    int k = 3;
    int j = 1;
    boolean bool3 = true;
    AppMethodBeat.i(46454);
    this.sfW = ((JsApiChooseMedia.ChooseRequest)paramProcessRequest);
    this.sfB = 16;
    int i;
    boolean bool2;
    if (Util.getAvailableMemoryMB(getActivityContext()) > 200L)
    {
      i = 1;
      if (i == 0)
      {
        Log.e("MicroMsg.JsApiChooseMedia", "memory is not enough!");
        aa.makeText(getActivityContext(), getString(ba.i.app_brand_choose_media_memory_check_message), 1).show();
      }
      if (this.sfW.sfQ)
      {
        this.rPj = this.sfW.sfy;
        Log.i("MicroMsg.JsApiChooseMedia", "has external storage permission: %b", new Object[] { Boolean.valueOf(this.rPj) });
      }
      Log.i("MicroMsg.JsApiChooseMedia", "goVideo");
      getActivityContext().mmSetOnActivityResultCallback(this);
      if (!this.sfW.sfP) {
        break label421;
      }
      Log.i("MicroMsg.JsApiChooseMedia", "chooseMediaFromAlbum");
      bool2 = this.sfW.sfw;
      if (!this.sfW.sfT) {
        break label338;
      }
      i = k;
      bool1 = bool2;
      label177:
      paramProcessRequest = new Intent();
      if (!this.sfW.sfT) {
        paramProcessRequest.putExtra("key_can_select_video_and_pic", true);
      }
      if (this.sfW.sfv) {
        break label409;
      }
      bool2 = true;
      label217:
      paramProcessRequest.putExtra("key_send_raw_image", bool2);
      paramProcessRequest.putExtra("key_force_show_raw_image_button", bool1);
      if ((!this.sfW.sfw) || (this.sfW.sfv)) {
        break label415;
      }
    }
    label409:
    label415:
    for (boolean bool1 = bool3;; bool1 = false)
    {
      paramProcessRequest.putExtra("key_is_raw_image_button_disable", bool1);
      paramProcessRequest.putExtra("gallery_report_tag", 16);
      paramProcessRequest.putExtra("album_video_max_duration", 86400);
      paramProcessRequest.putExtra("album_business_tag", "album_business_bubble_media_by_jsapi_choosevideo");
      t.a(getActivityContext(), 8, this.sfW.count, this.sfB, i, false, paramProcessRequest);
      AppMethodBeat.o(46454);
      return;
      i = 0;
      break;
      label338:
      if (this.sfW.sfR)
      {
        bool1 = bool2;
        i = k;
        if (this.sfW.sfS) {
          break label177;
        }
      }
      if (this.sfW.sfR)
      {
        i = 1;
        bool1 = bool2;
        break label177;
      }
      bool1 = bool2;
      i = k;
      if (!this.sfW.sfS) {
        break label177;
      }
      i = 2;
      bool1 = false;
      break label177;
      bool2 = false;
      break label217;
    }
    label421:
    if (this.sfW.sfQ)
    {
      Log.i("MicroMsg.JsApiChooseMedia", "chooseMediaFromCamera");
      if ((this.sfW.sfS) && (this.sfW.sfR)) {
        i = 0;
      }
    }
    for (;;)
    {
      Intent localIntent = new Intent();
      String str = "microMsg." + System.currentTimeMillis() + ".jpg";
      label585:
      SightParams localSightParams;
      if (this.rPj)
      {
        this.sfX = y.n(b.bmL() + "microMsg." + str + ".mp4", false);
        this.sfY = y.n(b.bmL() + "microMsg." + str + ".jpeg", true);
        k = this.sfW.maxDuration;
        localSightParams = new SightParams(3, 1);
        if (!this.sfW.isFront) {
          break label837;
        }
        label615:
        localSightParams.KTU = j;
        localSightParams.mode = i;
        if (localSightParams.nLH == null) {
          localSightParams.nLH = new VideoTransPara();
        }
        localSightParams.nLH.duration = k;
        localSightParams.KUb = false;
        if (!this.rPj) {
          break label842;
        }
      }
      label837:
      label842:
      for (paramProcessRequest = b.bmL();; paramProcessRequest = b.bmx())
      {
        localSightParams.D(str, this.sfX, this.sfY, paramProcessRequest);
        localIntent.putExtra("KEY_SIGHT_PARAMS", localSightParams);
        t.a(getActivityContext(), 7, localIntent, 3, i);
        AppMethodBeat.o(46454);
        return;
        if (this.sfW.sfS)
        {
          i = 1;
          break;
        }
        if (!this.sfW.sfR) {
          break label881;
        }
        i = 2;
        break;
        this.sfX = y.n(b.bmx() + "microMsg." + str + ".mp4", false);
        this.sfY = y.n(b.bmx() + "microMsg." + str + ".jpeg", true);
        break label585;
        j = 2;
        break label615;
      }
      this.sfV.resultCode = -2;
      Log.e("MicroMsg.JsApiChooseMedia", "parameter is invalid, fail and finish process");
      finishProcess(this.sfV);
      AppMethodBeat.o(46454);
      return;
      label881:
      i = 0;
    }
  }
  
  public final void mmOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(46459);
    if (paramInt2 == 0)
    {
      Log.e("MicroMsg.JsApiChooseMedia", "mmOnActivityResult resultCode is canceled");
      this.sfV.resultCode = 0;
      finishProcess(this.sfV);
      AppMethodBeat.o(46459);
      return;
    }
    if (-1 != paramInt2)
    {
      Log.e("MicroMsg.JsApiChooseMedia", "mmOnActivityResult resultCode is not RESULT_OK");
      this.sfV.resultCode = -2;
      finishProcess(this.sfV);
      AppMethodBeat.o(46459);
      return;
    }
    Object localObject;
    final ArrayList localArrayList;
    final boolean bool1;
    final boolean bool2;
    final int i;
    label254:
    final boolean bool3;
    switch (paramInt1)
    {
    default: 
      this.sfV.resultCode = -2;
      finishProcess(this.sfV);
      AppMethodBeat.o(46459);
      return;
    case 8: 
      Log.i("MicroMsg.JsApiChooseMedia", "REQUEST_CODE_TAKE_MEDIA_LOCAL");
      if (this.sfW.sfT)
      {
        localObject = paramIntent.getStringArrayListExtra("key_select_video_list");
        localArrayList = paramIntent.getStringArrayListExtra("CropImage_OutputPath_List");
        if ((localObject != null) && (((ArrayList)localObject).size() > 0))
        {
          bool1 = true;
          if ((localArrayList == null) || (localArrayList.size() <= 0)) {
            break label254;
          }
        }
        for (bool2 = true;; bool2 = false)
        {
          i = 0;
          paramInt1 = 0;
          if (bool1) {
            paramInt1 = 1;
          }
          if ((bool1) || (bool2)) {
            break label260;
          }
          Log.e("MicroMsg.JsApiChooseMedia", "none select any image or video");
          this.sfV.resultCode = -2;
          finishProcess(this.sfV);
          AppMethodBeat.o(46459);
          return;
          bool1 = false;
          break;
        }
        label260:
        if (bool2)
        {
          bool3 = paramIntent.getBooleanExtra("CropImage_Compress_Img", false);
          i = this.sfW.sfv;
          if (!this.sfW.sfw)
          {
            paramInt2 = 1;
            if (((paramInt2 & i) == 0) && (!(this.sfW.sfv & this.sfW.sfw & bool3))) {
              break label477;
            }
            i = 1;
            label327:
            Log.i("MicroMsg.JsApiChooseMedia", "onActivityResult, fromCamera = %b, canCompress = %b, canOriginal = %b, CropImageUI.KCompressImg = %b, doCompress = %b", new Object[] { Boolean.FALSE, Boolean.valueOf(this.sfW.sfv), Boolean.valueOf(this.sfW.sfw), Boolean.valueOf(bool3), Boolean.valueOf(i) });
          }
        }
        else
        {
          if (i == 0) {
            break label1276;
          }
          paramInt1 = 1;
        }
      }
      break;
    }
    label477:
    label1004:
    label1137:
    label1143:
    label1276:
    for (;;)
    {
      if (paramInt1 != 0) {
        AR(ba.i.app_brand_choose_media_video_compressing);
      }
      if ((i == 0) && (localArrayList != null) && (s.dn(localArrayList))) {}
      for (bool3 = true;; bool3 = false)
      {
        if (bool3) {
          AR(ba.i.app_brand_choose_media_video_processing);
        }
        l.cNm().postToWorker(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(329255);
            JsApiChooseMedia.a.a(JsApiChooseMedia.a.this).resultCode = -2;
            JSONStringer localJSONStringer = new JSONStringer();
            Object localObject3;
            Object localObject2;
            for (;;)
            {
              try
              {
                localJSONStringer.array();
                if (!bool1) {
                  break;
                }
                Iterator localIterator1 = this.sga.iterator();
                if (!localIterator1.hasNext()) {
                  break;
                }
                localObject3 = (String)localIterator1.next();
                if (!new com.tencent.mm.vfs.u((String)localObject3).jKS()) {
                  break label260;
                }
                Log.i("MicroMsg.JsApiChooseMedia", "take media local, the path file exist, success, path:%s", new Object[] { localObject3 });
                JsApiChooseMedia.a.a(JsApiChooseMedia.a.this).resultCode = -1;
                JsApiChooseMedia.a.a(JsApiChooseMedia.a.this).type = "mix";
                localObject2 = JsApiChooseMedia.a.a(JsApiChooseMedia.a.this, (String)localObject3, JsApiChooseMedia.a.b(JsApiChooseMedia.a.this).sfv);
                if (localObject2 != null) {
                  break label212;
                }
                Log.e("MicroMsg.JsApiChooseMedia", "addVideoItem fail ,videoFilePath is %s", new Object[] { localObject3 });
                continue;
                JsApiChooseMedia.a.a(JsApiChooseMedia.a.this).sfU = localJSONStringer.toString();
              }
              catch (Exception localException)
              {
                Log.printErrStackTrace("MicroMsg.JsApiChooseMedia", localException, "", new Object[0]);
              }
              JsApiChooseMedia.a.a(JsApiChooseMedia.a.this, JsApiChooseMedia.a.a(JsApiChooseMedia.a.this));
              AppMethodBeat.o(329255);
              return;
              label212:
              JsApiChooseMedia.a.a(JsApiChooseMedia.a.this, (String)localObject3);
              localObject3 = JsApiChooseMedia.a.c(JsApiChooseMedia.a.this);
              JsApiChooseMedia.a.b(localJSONStringer, ((AppBrandLocalVideoObject)localObject2).hHB, (String)localObject3, ((AppBrandLocalVideoObject)localObject2).duration, ((AppBrandLocalVideoObject)localObject2).height, ((AppBrandLocalVideoObject)localObject2).width, ((AppBrandLocalVideoObject)localObject2).size);
              continue;
              label260:
              Log.e("MicroMsg.JsApiChooseMedia", "take media local, videoFilePath is %s, the file not exist, fail", new Object[] { localObject3 });
            }
            ArrayList localArrayList;
            label333:
            Object localObject1;
            boolean bool;
            if (bool2)
            {
              localObject3 = new ArrayList(localArrayList.size());
              localArrayList = new ArrayList(localArrayList.size());
              Iterator localIterator2 = localArrayList.iterator();
              if (localIterator2.hasNext())
              {
                localObject1 = (String)localIterator2.next();
                if (i)
                {
                  localObject2 = s.aaW((String)localObject1);
                  if ((localObject2 == null) || (((String)localObject2).equals(localObject1))) {
                    break label539;
                  }
                  bool = true;
                  localObject1 = localObject2;
                }
              }
            }
            for (;;)
            {
              localObject2 = AppBrandLocalMediaObjectManager.m(JsApiChooseMedia.a.b(JsApiChooseMedia.a.this).appId, (String)localObject1, bool);
              if (localObject2 != null)
              {
                ((ArrayList)localObject3).add(Long.valueOf(((AppBrandLocalMediaObject)localObject2).fileLength));
                localArrayList.add(((AppBrandLocalMediaObject)localObject2).hHB);
                break label333;
                if (!bool3) {
                  break label539;
                }
                localObject2 = s.aaX((String)localObject1);
                if (((String)localObject2).equals(localObject1)) {
                  break label539;
                }
                bool = true;
                localObject1 = localObject2;
                continue;
              }
              Log.e("MicroMsg.JsApiChooseMedia", "handle image from album, get null obj from path: %s", new Object[] { localObject1 });
              break label333;
              if (localArrayList.size() == 0) {
                Log.e("MicroMsg.JsApiChooseMedia", "handle image from album, get null obj");
              }
              for (;;)
              {
                localJSONStringer.endArray();
                break;
                Log.i("MicroMsg.JsApiChooseMedia", "handle images success");
                JsApiChooseMedia.a.a(JsApiChooseMedia.a.this).resultCode = -1;
                JsApiChooseMedia.a.a(JsApiChooseMedia.a.this).type = "mix";
                JsApiChooseMedia.a.b(localJSONStringer, localArrayList, (ArrayList)localObject3);
              }
              label539:
              bool = false;
            }
          }
        });
        AppMethodBeat.o(46459);
        return;
        paramInt2 = 0;
        break;
        i = 0;
        break label327;
      }
      localObject = paramIntent.getStringArrayListExtra("key_select_video_list");
      if ((localObject != null) && (((ArrayList)localObject).size() > 0))
      {
        AR(ba.i.app_brand_choose_media_video_compressing);
        l.cNm().postToWorker(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(329252);
            Object localObject1;
            Object localObject2;
            if (this.sga.size() == 1)
            {
              JsApiChooseMedia.a.b(JsApiChooseMedia.a.this, y.n((String)this.sga.get(0), false));
              if (Util.isNullOrNil(JsApiChooseMedia.a.d(JsApiChooseMedia.a.this)))
              {
                Log.e("MicroMsg.JsApiChooseMedia", "take media local, mVideoFilePath is  null, fail");
                JsApiChooseMedia.a.a(JsApiChooseMedia.a.this).resultCode = -2;
                JsApiChooseMedia.a.b(JsApiChooseMedia.a.this, JsApiChooseMedia.a.a(JsApiChooseMedia.a.this));
                AppMethodBeat.o(329252);
                return;
              }
              if (new com.tencent.mm.vfs.u(JsApiChooseMedia.a.d(JsApiChooseMedia.a.this)).jKS())
              {
                Log.i("MicroMsg.JsApiChooseMedia", "take media local, the mVideoFilePath file exist, success");
                JsApiChooseMedia.a.a(JsApiChooseMedia.a.this).resultCode = -1;
                JsApiChooseMedia.a.a(JsApiChooseMedia.a.this).type = "video";
                localObject1 = JsApiChooseMedia.a.a(JsApiChooseMedia.a.this, JsApiChooseMedia.a.d(JsApiChooseMedia.a.this), JsApiChooseMedia.a.b(JsApiChooseMedia.a.this).sfv);
                if (localObject1 == null)
                {
                  Log.e("MicroMsg.JsApiChooseMedia", "addVideoItem fail ,mVideoFilePath is %s", new Object[] { JsApiChooseMedia.a.d(JsApiChooseMedia.a.this) });
                  JsApiChooseMedia.a.a(JsApiChooseMedia.a.this).resultCode = -2;
                  JsApiChooseMedia.a.c(JsApiChooseMedia.a.this, JsApiChooseMedia.a.a(JsApiChooseMedia.a.this));
                  AppMethodBeat.o(329252);
                  return;
                }
                JsApiChooseMedia.a.a(JsApiChooseMedia.a.this, JsApiChooseMedia.a.d(JsApiChooseMedia.a.this));
                localObject2 = JsApiChooseMedia.a.c(JsApiChooseMedia.a.this);
                JsApiChooseMedia.a.a(JsApiChooseMedia.a.this).sfU = JsApiChooseMedia.a.b(((AppBrandLocalVideoObject)localObject1).hHB, (String)localObject2, ((AppBrandLocalVideoObject)localObject1).duration, ((AppBrandLocalVideoObject)localObject1).height, ((AppBrandLocalVideoObject)localObject1).width, ((AppBrandLocalVideoObject)localObject1).size);
                JsApiChooseMedia.a.d(JsApiChooseMedia.a.this, JsApiChooseMedia.a.a(JsApiChooseMedia.a.this));
                AppMethodBeat.o(329252);
                return;
              }
              Log.e("MicroMsg.JsApiChooseMedia", "take media local, mVideoFilePath is %s, the file not exist, fail", new Object[] { JsApiChooseMedia.a.d(JsApiChooseMedia.a.this) });
              JsApiChooseMedia.a.a(JsApiChooseMedia.a.this).resultCode = -2;
              JsApiChooseMedia.a.e(JsApiChooseMedia.a.this, JsApiChooseMedia.a.a(JsApiChooseMedia.a.this));
              AppMethodBeat.o(329252);
              return;
            }
            String str;
            AppBrandLocalVideoObject localAppBrandLocalVideoObject;
            if (this.sga.size() > 1)
            {
              JsApiChooseMedia.a.a(JsApiChooseMedia.a.this).resultCode = -2;
              localObject1 = new JSONStringer();
              try
              {
                ((JSONStringer)localObject1).array();
                localObject2 = this.sga.iterator();
                for (;;)
                {
                  if (((Iterator)localObject2).hasNext())
                  {
                    str = (String)((Iterator)localObject2).next();
                    if (new com.tencent.mm.vfs.u(str).jKS())
                    {
                      Log.i("MicroMsg.JsApiChooseMedia", "take media local, the path file exist, success, path:%s", new Object[] { str });
                      JsApiChooseMedia.a.a(JsApiChooseMedia.a.this).resultCode = -1;
                      JsApiChooseMedia.a.a(JsApiChooseMedia.a.this).type = "video";
                      localAppBrandLocalVideoObject = JsApiChooseMedia.a.a(JsApiChooseMedia.a.this, str, JsApiChooseMedia.a.b(JsApiChooseMedia.a.this).sfv);
                      if (localAppBrandLocalVideoObject == null)
                      {
                        Log.e("MicroMsg.JsApiChooseMedia", "addVideoItem fail ,videoFilePath is %s", new Object[] { str });
                        continue;
                        JsApiChooseMedia.a.a(JsApiChooseMedia.a.this).sfU = ((JSONStringer)localObject1).toString();
                      }
                    }
                  }
                }
              }
              catch (Exception localException)
              {
                Log.printErrStackTrace("MicroMsg.JsApiChooseMedia", localException, "", new Object[0]);
              }
            }
            for (;;)
            {
              JsApiChooseMedia.a.f(JsApiChooseMedia.a.this, JsApiChooseMedia.a.a(JsApiChooseMedia.a.this));
              AppMethodBeat.o(329252);
              return;
              JsApiChooseMedia.a.a(JsApiChooseMedia.a.this, str);
              str = JsApiChooseMedia.a.c(JsApiChooseMedia.a.this);
              JsApiChooseMedia.a.b((JSONStringer)localObject1, localAppBrandLocalVideoObject.hHB, str, localAppBrandLocalVideoObject.duration, localAppBrandLocalVideoObject.height, localAppBrandLocalVideoObject.width, localAppBrandLocalVideoObject.size);
              break;
              Log.e("MicroMsg.JsApiChooseMedia", "take media local, videoFilePath is %s, the file not exist, fail", new Object[] { str });
              break;
              ((JSONStringer)localObject1).endArray();
            }
          }
        });
        AppMethodBeat.o(46459);
        return;
      }
      localObject = paramIntent.getStringArrayListExtra("CropImage_OutputPath_List");
      if ((localObject == null) || (((List)localObject).size() == 0))
      {
        Log.e("MicroMsg.JsApiChooseMedia", "chosen is null,  fail");
        this.sfV.resultCode = -2;
        finishProcess(this.sfV);
        AppMethodBeat.o(46459);
        return;
      }
      bool1 = paramIntent.getBooleanExtra("CropImage_Compress_Img", false);
      final int j = this.sfW.sfv;
      if (!this.sfW.sfw)
      {
        paramInt1 = 1;
        if (((paramInt1 & j) == 0) && (!(this.sfW.sfv & this.sfW.sfw & bool1))) {
          break label793;
        }
        j = 1;
        Log.i("MicroMsg.JsApiChooseMedia", "onActivityResult, fromCamera = %b, canCompress = %b, canOriginal = %b, CropImageUI.KCompressImg = %b, doCompress = %b", new Object[] { Boolean.FALSE, Boolean.valueOf(this.sfW.sfv), Boolean.valueOf(this.sfW.sfw), Boolean.valueOf(bool1), Boolean.valueOf(j) });
        if (j != 0) {
          AR(ba.i.app_brand_choose_media_video_compressing);
        }
        if ((j != 0) || (!s.dn((List)localObject))) {
          break label799;
        }
      }
      for (bool1 = true;; bool1 = false)
      {
        if (bool1) {
          AR(ba.i.app_brand_choose_media_video_processing);
        }
        o.cNm().postToWorker(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(329261);
            final ArrayList localArrayList1 = new ArrayList(this.sfF.size());
            final ArrayList localArrayList2 = new ArrayList(this.sfF.size());
            Iterator localIterator = this.sfF.iterator();
            Object localObject1;
            Object localObject2;
            boolean bool;
            if (localIterator.hasNext())
            {
              localObject1 = (String)localIterator.next();
              if (j)
              {
                localObject2 = s.aaW((String)localObject1);
                if ((localObject2 == null) || (((String)localObject2).equals(localObject1))) {
                  break label260;
                }
                bool = true;
                localObject1 = localObject2;
              }
            }
            for (;;)
            {
              localObject2 = AppBrandLocalMediaObjectManager.m(JsApiChooseMedia.a.b(JsApiChooseMedia.a.this).appId, (String)localObject1, bool);
              if (localObject2 != null)
              {
                localArrayList1.add(Long.valueOf(((AppBrandLocalMediaObject)localObject2).fileLength));
                localArrayList2.add(((AppBrandLocalMediaObject)localObject2).hHB);
                break;
                if (!bool1) {
                  break label260;
                }
                localObject2 = s.aaX((String)localObject1);
                if (((String)localObject2).equals(localObject1)) {
                  break label260;
                }
                bool = true;
                localObject1 = localObject2;
                continue;
              }
              Log.e("MicroMsg.JsApiChooseMedia", "handle image from album, get null obj from path: %s", new Object[] { localObject1 });
              break;
              if (localArrayList2.size() == 0)
              {
                Log.e("MicroMsg.JsApiChooseMedia", "handle image from album, get null obj");
                JsApiChooseMedia.a.a(JsApiChooseMedia.a.this).resultCode = -2;
                JsApiChooseMedia.a.g(JsApiChooseMedia.a.this, JsApiChooseMedia.a.a(JsApiChooseMedia.a.this));
                AppMethodBeat.o(329261);
                return;
              }
              MMHandlerThread.postToMainThread(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(329256);
                  Log.i("MicroMsg.JsApiChooseMedia", "handle image from album is ok");
                  JsApiChooseMedia.a.a(JsApiChooseMedia.a.this).resultCode = -1;
                  JsApiChooseMedia.a.a(JsApiChooseMedia.a.this).type = "image";
                  JsApiChooseMedia.ChooseResult localChooseResult = JsApiChooseMedia.a.a(JsApiChooseMedia.a.this);
                  ArrayList localArrayList1 = localArrayList2;
                  ArrayList localArrayList2 = localArrayList1;
                  JsApiChooseMedia.a.b(JsApiChooseMedia.a.this);
                  localChooseResult.sfU = JsApiChooseMedia.a.c(localArrayList1, localArrayList2);
                  JsApiChooseMedia.a.h(JsApiChooseMedia.a.this, JsApiChooseMedia.a.a(JsApiChooseMedia.a.this));
                  AppMethodBeat.o(329256);
                }
              });
              AppMethodBeat.o(329261);
              return;
              label260:
              bool = false;
            }
          }
        });
        AppMethodBeat.o(46459);
        return;
        paramInt1 = 0;
        break;
        j = 0;
        break label660;
      }
      Log.i("MicroMsg.JsApiChooseMedia", "REQUEST_CODE_TAKE_MEDIA_CAMERA");
      if (paramIntent != null)
      {
        Log.i("MicroMsg.JsApiChooseMedia", "data is valid!");
        localObject = (SightCaptureResult)paramIntent.getParcelableExtra("key_req_result");
        if (localObject == null)
        {
          Log.e("MicroMsg.JsApiChooseMedia", "sight capture result is null!");
          this.sfV.resultCode = -2;
          finishProcess(this.sfV);
          AppMethodBeat.o(46459);
          return;
        }
        if (((SightCaptureResult)localObject).KTL)
        {
          localObject = y.n(((SightCaptureResult)localObject).KTT, false);
          if (Util.isNullOrNil((String)localObject))
          {
            Log.e("MicroMsg.JsApiChooseMedia", "picture_picturePath file is not exist! path:%s", new Object[] { localObject });
            this.sfV.resultCode = -2;
            finishProcess(this.sfV);
            AppMethodBeat.o(46459);
            return;
          }
          bool1 = paramIntent.getBooleanExtra("CropImage_Compress_Img", false);
          final int k = this.sfW.sfv;
          if (!this.sfW.sfw)
          {
            paramInt1 = 1;
            if (((paramInt1 & k) == 0) && (!(this.sfW.sfv & this.sfW.sfw & bool1))) {
              break label1137;
            }
            k = 1;
            Log.d("MicroMsg.JsApiChooseMedia", "onActivityResult, fromCamera = %b, canCompress = %b, canOriginal = %b, CropImageUI.KCompressImg = %b, doCompress = %b", new Object[] { Boolean.TRUE, Boolean.valueOf(this.sfW.sfv), Boolean.valueOf(this.sfW.sfw), Boolean.valueOf(bool1), Boolean.valueOf(k) });
            if (k != 0) {
              AR(ba.i.app_brand_choose_media_video_compressing);
            }
            if ((k != 0) || (!s.abb((String)localObject))) {
              break label1143;
            }
          }
          for (bool1 = true;; bool1 = false)
          {
            if (bool1) {
              AR(ba.i.app_brand_choose_media_video_processing);
            }
            o.cNm().postToWorker(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(329260);
                Object localObject2 = this.val$filePath;
                Object localObject1;
                if (k)
                {
                  localObject1 = s.aaW((String)localObject2);
                  if ((localObject1 == null) || (((String)localObject1).equals(localObject2))) {
                    break label189;
                  }
                }
                for (;;)
                {
                  localObject2 = new ArrayList();
                  Object localObject3 = new ArrayList();
                  localObject1 = AppBrandLocalMediaObjectManager.m(JsApiChooseMedia.a.b(JsApiChooseMedia.a.this).appId, (String)localObject1, true);
                  if (localObject1 != null)
                  {
                    ((ArrayList)localObject2).add(Long.valueOf(((AppBrandLocalMediaObject)localObject1).fileLength));
                    ((ArrayList)localObject3).add(((AppBrandLocalMediaObject)localObject1).hHB);
                    MMHandlerThread.postToMainThread(new Runnable()
                    {
                      public final void run()
                      {
                        AppMethodBeat.i(329322);
                        Log.i("MicroMsg.JsApiChooseMedia", "handle image from album is ok");
                        JsApiChooseMedia.a.a(JsApiChooseMedia.a.this).resultCode = -1;
                        if (JsApiChooseMedia.a.b(JsApiChooseMedia.a.this).sfT) {}
                        for (JsApiChooseMedia.a.a(JsApiChooseMedia.a.this).type = "mix";; JsApiChooseMedia.a.a(JsApiChooseMedia.a.this).type = "image")
                        {
                          JsApiChooseMedia.ChooseResult localChooseResult = JsApiChooseMedia.a.a(JsApiChooseMedia.a.this);
                          ArrayList localArrayList1 = this.sgd;
                          ArrayList localArrayList2 = this.sgg;
                          JsApiChooseMedia.a.b(JsApiChooseMedia.a.this);
                          localChooseResult.sfU = JsApiChooseMedia.a.c(localArrayList1, localArrayList2);
                          JsApiChooseMedia.a.i(JsApiChooseMedia.a.this, JsApiChooseMedia.a.a(JsApiChooseMedia.a.this));
                          AppMethodBeat.o(329322);
                          return;
                        }
                      }
                    });
                    AppMethodBeat.o(329260);
                    return;
                    localObject1 = localObject2;
                    if (bool1)
                    {
                      localObject3 = s.aaX((String)localObject2);
                      localObject1 = localObject2;
                      if (!((String)localObject3).equals(localObject2)) {
                        localObject1 = localObject3;
                      }
                    }
                  }
                  else
                  {
                    Log.e("MicroMsg.JsApiChooseMedia", "handle image from mm-sight camera, get null obj from path: %s", new Object[] { this.val$filePath });
                    JsApiChooseMedia.a.a(JsApiChooseMedia.a.this).resultCode = -2;
                    JsApiChooseMedia.a.j(JsApiChooseMedia.a.this, JsApiChooseMedia.a.a(JsApiChooseMedia.a.this));
                    AppMethodBeat.o(329260);
                    return;
                    label189:
                    localObject1 = localObject2;
                  }
                }
              }
            });
            AppMethodBeat.o(46459);
            return;
            paramInt1 = 0;
            break;
            k = 0;
            break label1004;
          }
        }
        this.sfX = y.n(((SightCaptureResult)localObject).KTN, false);
        if (Util.isNullOrNil(this.sfX))
        {
          Log.e("MicroMsg.JsApiChooseMedia", "mVideoFilePath is null");
          break;
        }
        Log.i("MicroMsg.JsApiChooseMedia", "mVideoFilePath:%s", new Object[] { this.sfX });
        if ((!aaS(this.sfY)) && (aaS(((SightCaptureResult)localObject).KTO))) {
          this.sfY = y.n(((SightCaptureResult)localObject).KTO, true);
        }
        AR(ba.i.app_brand_choose_media_video_compressing);
        o.cNm().postToWorker(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(46446);
            if (new com.tencent.mm.vfs.u(JsApiChooseMedia.a.d(JsApiChooseMedia.a.this)).jKS())
            {
              Log.i("MicroMsg.JsApiChooseMedia", "take media camera, the mVideoFilePath file exist, success");
              JsApiChooseMedia.a.a(JsApiChooseMedia.a.this).resultCode = -1;
              if (JsApiChooseMedia.a.b(JsApiChooseMedia.a.this).sfT) {}
              AppBrandLocalVideoObject localAppBrandLocalVideoObject;
              for (JsApiChooseMedia.a.a(JsApiChooseMedia.a.this).type = "mix";; JsApiChooseMedia.a.a(JsApiChooseMedia.a.this).type = "video")
              {
                localAppBrandLocalVideoObject = JsApiChooseMedia.a.a(JsApiChooseMedia.a.this, JsApiChooseMedia.a.d(JsApiChooseMedia.a.this), JsApiChooseMedia.a.b(JsApiChooseMedia.a.this).sfv);
                if (localAppBrandLocalVideoObject != null) {
                  break;
                }
                Log.e("MicroMsg.JsApiChooseMedia", "addVideoItem fail ,mVideoFilePath is %s", new Object[] { JsApiChooseMedia.a.d(JsApiChooseMedia.a.this) });
                JsApiChooseMedia.a.a(JsApiChooseMedia.a.this).resultCode = -2;
                JsApiChooseMedia.a.k(JsApiChooseMedia.a.this, JsApiChooseMedia.a.a(JsApiChooseMedia.a.this));
                AppMethodBeat.o(46446);
                return;
              }
              JsApiChooseMedia.a.a(JsApiChooseMedia.a.this, JsApiChooseMedia.a.d(JsApiChooseMedia.a.this));
              String str = JsApiChooseMedia.a.c(JsApiChooseMedia.a.this);
              JsApiChooseMedia.a.a(JsApiChooseMedia.a.this).sfU = JsApiChooseMedia.a.b(localAppBrandLocalVideoObject.hHB, str, localAppBrandLocalVideoObject.duration, localAppBrandLocalVideoObject.height, localAppBrandLocalVideoObject.width, localAppBrandLocalVideoObject.size);
              JsApiChooseMedia.a.l(JsApiChooseMedia.a.this, JsApiChooseMedia.a.a(JsApiChooseMedia.a.this));
              AppMethodBeat.o(46446);
              return;
            }
            Log.e("MicroMsg.JsApiChooseMedia", "take media camera, mVideoFilePath is %s, the file not exist, fail", new Object[] { JsApiChooseMedia.a.d(JsApiChooseMedia.a.this) });
            JsApiChooseMedia.a.a(JsApiChooseMedia.a.this).resultCode = -2;
            JsApiChooseMedia.a.m(JsApiChooseMedia.a.this, JsApiChooseMedia.a.a(JsApiChooseMedia.a.this));
            AppMethodBeat.o(46446);
          }
        });
        AppMethodBeat.o(46459);
        return;
      }
      Log.e("MicroMsg.JsApiChooseMedia", "data is null!");
      break;
    }
  }
  
  public final void onProcessInterrupted()
  {
    AppMethodBeat.i(46455);
    super.onProcessInterrupted();
    if (this.lKp != null)
    {
      this.lKp.dismiss();
      this.lKp = null;
    }
    AppMethodBeat.o(46455);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.media.JsApiChooseMedia.a
 * JD-Core Version:    0.7.0.1
 */