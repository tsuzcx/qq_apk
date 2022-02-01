package com.tencent.mm.plugin.appbrand.jsapi.media;

import android.content.ContentResolver;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Parcelable;
import android.provider.MediaStore.Images.Media;
import android.view.View;
import android.view.Window;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.loader.i.b;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.appbrand.af.o;
import com.tencent.mm.plugin.appbrand.af.o.a;
import com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalMediaObjectManager;
import com.tencent.mm.plugin.appbrand.ba.a;
import com.tencent.mm.plugin.appbrand.ba.i;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessRequest;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.plugin.mmsight.SightCaptureResult;
import com.tencent.mm.plugin.mmsight.SightParams;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager.CaptureVideoNormalModel;
import com.tencent.mm.plugin.recordvideo.jumper.RecordConfigProvider;
import com.tencent.mm.plugin.recordvideo.jumper.a;
import com.tencent.mm.pluginsdk.ui.tools.t;
import com.tencent.mm.sdk.platformtools.ImgUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.base.aa;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.base.w;
import com.tencent.mm.vfs.y;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

final class JsApiChooseImage$a
  extends AppBrandProxyUIProcessTask
{
  private w lKp;
  private boolean rPj;
  final int sfA;
  int sfB;
  String sfC;
  private DialogInterface.OnCancelListener sfD;
  JsApiChooseImage.ChooseRequest sfp;
  JsApiChooseImage.ChooseResult sfz;
  
  private JsApiChooseImage$a()
  {
    AppMethodBeat.i(46412);
    this.sfz = new JsApiChooseImage.ChooseResult();
    this.sfA = (hashCode() % 10000);
    this.rPj = true;
    AppMethodBeat.o(46412);
  }
  
  private void AR(int paramInt)
  {
    AppMethodBeat.i(46414);
    this.sfD = new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(329352);
        JsApiChooseImage.a.this.sfz.resultCode = 0;
        JsApiChooseImage.a.a(JsApiChooseImage.a.this, JsApiChooseImage.a.this.sfz);
        AppMethodBeat.o(329352);
      }
    };
    MMActivity localMMActivity = getActivityContext();
    getString(ba.i.app_tip);
    this.lKp = k.a(localMMActivity, getString(paramInt), true, this.sfD);
    AppMethodBeat.o(46414);
  }
  
  public final void handleRequest(AppBrandProxyUIProcessTask.ProcessRequest paramProcessRequest)
  {
    AppMethodBeat.i(46413);
    this.sfp = ((JsApiChooseImage.ChooseRequest)paramProcessRequest);
    this.sfp.sfx = true;
    this.sfp.count = Math.max(1, Math.min(9, this.sfp.count));
    this.sfB = 16;
    int i;
    if (Util.getAvailableMemoryMB(getActivityContext()) > 200L)
    {
      i = 1;
      if (i == 0) {
        aa.makeText(getActivityContext(), getString(ba.i.app_brand_choose_media_memory_check_message), 1).show();
      }
      this.rPj = this.sfp.sfy;
      Log.i("MicroMsg.JsApiChooseImage", "has external storage permission: %b", new Object[] { Boolean.valueOf(this.rPj) });
      getActivityContext().mmSetOnActivityResultCallback(this);
      paramProcessRequest = new Intent();
      if (this.sfp.sfv) {
        break label289;
      }
      bool = true;
      label148:
      paramProcessRequest.putExtra("key_send_raw_image", bool);
      paramProcessRequest.putExtra("key_force_show_raw_image_button", this.sfp.sfw);
      if ((!this.sfp.sfw) || (this.sfp.sfv)) {
        break label294;
      }
    }
    label289:
    label294:
    for (boolean bool = true;; bool = false)
    {
      paramProcessRequest.putExtra("key_is_raw_image_button_disable", bool);
      paramProcessRequest.putExtra("query_media_type", 1);
      paramProcessRequest.putExtra("key_force_hide_edit_image_button_after_album_take_image", true);
      paramProcessRequest.putExtra("album_business_tag", "album_business_bubble_media_by_jsapi_chooseimage");
      paramProcessRequest.putExtra("gallery_report_tag", 16);
      if ((!this.sfp.sft) || (!this.sfp.sfu)) {
        break label299;
      }
      Log.e("MicroMsg.JsApiChooseImage", "illegal scene, ignore this request");
      this.sfz.resultCode = -2;
      finishProcess(this.sfz);
      AppMethodBeat.o(46413);
      return;
      i = 0;
      break;
      bool = false;
      break label148;
    }
    label299:
    if (this.sfp.sfu)
    {
      paramProcessRequest.putExtra("show_header_view", false);
      t.a(getActivityContext(), 1, this.sfp.count, this.sfB, paramProcessRequest);
      AppMethodBeat.o(46413);
      return;
    }
    if (this.sfp.sft)
    {
      o.cNm().postToWorker(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(329354);
          boolean bool1 = ((com.tencent.mm.plugin.expt.b.c)h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.yVi, true);
          Log.i("MicroMsg.JsApiChooseImage", "jump to record new: %b, use new record impl: %b", new Object[] { Boolean.valueOf(bool1), Boolean.TRUE });
          Object localObject1 = GetSightParamsIPCTask.sfl;
          localObject1 = GetSightParamsIPCTask.a.q(2, 0, false);
          ((SightParams)localObject1).KUc = false;
          ((SightParams)localObject1).KUb = false;
          if (!JsApiChooseImage.a.a(JsApiChooseImage.a.this)) {
            ((SightParams)localObject1).KTY = b.bmx();
          }
          int i = com.tencent.g.c.c.getScreenOrientation(JsApiChooseImage.a.b(JsApiChooseImage.a.this));
          boolean bool2 = aw.ato();
          Log.i("MicroMsg.JsApiChooseImage", "screen orientation: %d, is foldable device: %b", new Object[] { Integer.valueOf(i), Boolean.valueOf(bool2) });
          if (((i == 1) || (bool2)) && (bool1))
          {
            localObject2 = RecordConfigProvider.a(((SightParams)localObject1).KTX, ((SightParams)localObject1).KTY, ((SightParams)localObject1).nLH, ((SightParams)localObject1).nLH.duration * 1000, 9);
            if (((SightParams)localObject1).KTY != null) {
              if (((SightParams)localObject1).KTY.endsWith(File.separator)) {
                break label295;
              }
            }
            label295:
            for (((RecordConfigProvider)localObject2).NIf = (((SightParams)localObject1).KTY + File.separator + ((SightParams)localObject1).KTX);; ((RecordConfigProvider)localObject2).NIf = (((SightParams)localObject1).KTY + ((SightParams)localObject1).KTX))
            {
              ((RecordConfigProvider)localObject2).NHW = Boolean.FALSE;
              ((RecordConfigProvider)localObject2).NHY = Boolean.FALSE;
              ((RecordConfigProvider)localObject2).NIb = true;
              ((RecordConfigProvider)localObject2).NIp = true;
              localObject1 = a.NIr;
              a.a(JsApiChooseImage.a.c(JsApiChooseImage.a.this), 4, ba.a.sight_slide_bottom_in, ba.a.sight_slide_bottom_out, (RecordConfigProvider)localObject2);
              AppMethodBeat.o(329354);
              return;
            }
          }
          Object localObject2 = new Intent();
          ((Intent)localObject2).setClassName(JsApiChooseImage.a.d(JsApiChooseImage.a.this), "com.tencent.mm.plugin.mmsight.ui.SightCaptureUI");
          ((Intent)localObject2).putExtra("KEY_SIGHT_PARAMS", (Parcelable)localObject1);
          JsApiChooseImage.a.a(JsApiChooseImage.a.this, (Intent)localObject2);
          AppMethodBeat.o(329354);
        }
      });
      AppMethodBeat.o(46413);
      return;
    }
    Log.e("MicroMsg.JsApiChooseImage", "unknown scene, ignore this request");
    this.sfz.resultCode = -2;
    finishProcess(this.sfz);
    AppMethodBeat.o(46413);
  }
  
  public final void mmOnActivityResult(int paramInt1, int paramInt2, final Intent paramIntent)
  {
    AppMethodBeat.i(46418);
    if (paramInt2 == 0)
    {
      if (((paramInt1 == 1) || (paramInt1 == 3)) && (!Util.isNullOrNil(this.sfC)))
      {
        y.deleteFile(this.sfC);
        this.sfC = null;
      }
      this.sfz.resultCode = 0;
      finishProcess(this.sfz);
      AppMethodBeat.o(46418);
      return;
    }
    switch (paramInt1)
    {
    default: 
      this.sfz.resultCode = -2;
      finishProcess(this.sfz);
      AppMethodBeat.o(46418);
      return;
    case 1: 
    case 3: 
      if (paramIntent == null)
      {
        this.sfz.resultCode = 0;
        finishProcess(this.sfz);
        AppMethodBeat.o(46418);
        return;
      }
      final ArrayList localArrayList = paramIntent.getStringArrayListExtra("CropImage_OutputPath_List");
      final boolean bool2 = paramIntent.getBooleanExtra("CropImage_Compress_Img", false);
      final int i = this.sfp.sfv;
      label218:
      final boolean bool1;
      if (!this.sfp.sfw)
      {
        paramInt1 = 1;
        if (((paramInt1 & i) == 0) && (!(this.sfp.sfv & this.sfp.sfw & bool2))) {
          break label380;
        }
        i = 1;
        if ((!paramIntent.getBooleanExtra("isTakePhoto", false)) && (!paramIntent.getBooleanExtra("isPreviewPhoto", false))) {
          break label386;
        }
        bool1 = true;
        label243:
        Log.d("MicroMsg.JsApiChooseImage", "onActivityResult, fromCamera = %b, canCompress = %b, canOriginal = %b, CropImageUI.KCompressImg = %b, doCompress = %b", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(this.sfp.sfv), Boolean.valueOf(this.sfp.sfw), Boolean.valueOf(bool2), Boolean.valueOf(i) });
        if (i != 0) {
          AR(ba.i.app_brand_choose_media_video_compressing);
        }
        if ((i != 0) || (!s.dn(localArrayList))) {
          break label392;
        }
      }
      label386:
      label392:
      for (bool2 = true;; bool2 = false)
      {
        if (bool2) {
          AR(ba.i.app_brand_jsapi_choose_image_processing);
        }
        o.cNm().postToWorker(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(46411);
            final ArrayList localArrayList = new ArrayList(localArrayList.size());
            Iterator localIterator = localArrayList.iterator();
            for (;;)
            {
              Object localObject2;
              boolean bool1;
              boolean bool2;
              String str;
              Object localObject1;
              if (localIterator.hasNext())
              {
                localObject2 = (String)localIterator.next();
                bool1 = ImgUtil.isGif((String)localObject2);
                bool2 = bool1;
                if (!bool1) {
                  if (i)
                  {
                    str = s.aaW((String)localObject2);
                    localObject1 = localObject2;
                    bool1 = bool2;
                    if (str != null)
                    {
                      localObject1 = localObject2;
                      bool1 = bool2;
                      if (!str.equals(localObject2))
                      {
                        if (Util.nullAsNil((String)localObject2).equals(JsApiChooseImage.a.this.sfC)) {
                          y.deleteFile((String)localObject2);
                        }
                        bool1 = true;
                        localObject1 = str;
                      }
                    }
                    label139:
                    localObject2 = AppBrandLocalMediaObjectManager.m(JsApiChooseImage.a.this.sfp.appId, (String)localObject1, bool1);
                    if ((localObject2 != null) && (!bool1)) {}
                  }
                }
              }
              try
              {
                JsApiChooseImage.a.e(JsApiChooseImage.a.this).getContentResolver().delete(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, "_data=?", new String[] { localObject1 });
                label192:
                localArrayList.add(localObject2);
                continue;
                localObject1 = localObject2;
                bool1 = bool2;
                if (!bool2) {
                  break label139;
                }
                str = s.aaX((String)localObject2);
                localObject1 = localObject2;
                bool1 = bool2;
                if (str.equals(localObject2)) {
                  break label139;
                }
                if (Util.nullAsNil((String)localObject2).equals(JsApiChooseImage.a.this.sfC)) {
                  y.deleteFile((String)localObject2);
                }
                bool1 = true;
                localObject1 = str;
                break label139;
                Log.i("MicroMsg.JsApiChooseImage", "path: %s is a GIF file", new Object[] { localObject2 });
                localObject1 = localObject2;
                bool1 = bool2;
                break label139;
                Log.e("MicroMsg.JsApiChooseImage", "handle chosen list from gallery, get null obj from path: %s", new Object[] { localObject1 });
                continue;
                MMHandlerThread.postToMainThread(new Runnable()
                {
                  public final void run()
                  {
                    AppMethodBeat.i(329335);
                    JsApiChooseImage.a.this.sfz.resultCode = -1;
                    JsApiChooseImage.a.this.sfz.resultList = localArrayList;
                    JsApiChooseImage.a.b(JsApiChooseImage.a.this, JsApiChooseImage.a.this.sfz);
                    AppMethodBeat.o(329335);
                  }
                });
                AppMethodBeat.o(46411);
                return;
              }
              catch (Exception localException)
              {
                break label192;
              }
            }
          }
        });
        AppMethodBeat.o(46418);
        return;
        paramInt1 = 0;
        break;
        label380:
        i = 0;
        break label218;
        bool1 = false;
        break label243;
      }
    }
    if (paramIntent == null)
    {
      this.sfz.resultCode = 0;
      finishProcess(this.sfz);
      AppMethodBeat.o(46418);
      return;
    }
    if (paramInt1 == 2)
    {
      paramIntent = (SightCaptureResult)paramIntent.getParcelableExtra("key_req_result");
      if (paramIntent == null)
      {
        this.sfz.resultCode = 0;
        finishProcess(this.sfz);
        AppMethodBeat.o(46418);
        return;
      }
    }
    for (paramIntent = paramIntent.KTT;; paramIntent = paramIntent.thumbPath)
    {
      this.sfC = paramIntent;
      if (!Util.isNullOrNil(paramIntent)) {
        break;
      }
      Log.w("MicroMsg.JsApiChooseImage", "take photo, but result is null");
      this.sfz.resultCode = -2;
      finishProcess(this.sfz);
      AppMethodBeat.o(46418);
      return;
      paramIntent = (CaptureDataManager.CaptureVideoNormalModel)paramIntent.getParcelableExtra("KSEGMENTMEDIAINFO");
      if (paramIntent == null)
      {
        this.sfz.resultCode = 0;
        finishProcess(this.sfz);
        AppMethodBeat.o(46418);
        return;
      }
    }
    if ((getActivityContext() != null) && (getActivityContext().getWindow() != null)) {
      getActivityContext().getWindow().getDecorView().setBackgroundColor(-16777216);
    }
    o.cNm().postToWorker(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(329358);
        Log.i("MicroMsg.JsApiChooseImage", "take photo, result[%s]", new Object[] { paramIntent });
        MMHandlerThread.postToMainThread(new Runnable()
        {
          public final void run()
          {
            boolean bool2 = false;
            AppMethodBeat.i(329248);
            Intent localIntent = new Intent();
            if (!JsApiChooseImage.a.this.sfp.sfv) {}
            for (boolean bool1 = true;; bool1 = false)
            {
              localIntent.putExtra("key_send_raw_image", bool1);
              localIntent.putExtra("key_force_show_raw_image_button", JsApiChooseImage.a.this.sfp.sfw);
              bool1 = bool2;
              if (JsApiChooseImage.a.this.sfp.sfw)
              {
                bool1 = bool2;
                if (!JsApiChooseImage.a.this.sfp.sfv) {
                  bool1 = true;
                }
              }
              localIntent.putExtra("key_is_raw_image_button_disable", bool1);
              localIntent.putExtra("max_select_count", JsApiChooseImage.a.this.sfp.count);
              localIntent.putExtra("query_source_type", JsApiChooseImage.a.this.sfB);
              localIntent.putExtra("isPreviewPhoto", true);
              localIntent.putExtra("max_select_count", 1);
              ArrayList localArrayList = new ArrayList(1);
              localArrayList.add(JsApiChooseImage.a.4.this.val$filePath);
              localIntent.putStringArrayListExtra("preview_image_list", localArrayList);
              localIntent.putExtra("preview_image", true);
              localIntent.putExtra("key_force_hide_edit_image_button", true);
              localIntent.addFlags(67108864);
              JsApiChooseImage.a.a(JsApiChooseImage.a.this, "gallery", ".ui.GalleryEntryUI", localIntent);
              AppMethodBeat.o(329248);
              return;
            }
          }
        });
        AppMethodBeat.o(329358);
      }
    });
    AppMethodBeat.o(46418);
  }
  
  public final void onProcessInterrupted()
  {
    AppMethodBeat.i(46417);
    super.onProcessInterrupted();
    if (this.lKp != null)
    {
      this.lKp.dismiss();
      this.lKp = null;
    }
    AppMethodBeat.o(46417);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.media.JsApiChooseImage.a
 * JD-Core Version:    0.7.0.1
 */