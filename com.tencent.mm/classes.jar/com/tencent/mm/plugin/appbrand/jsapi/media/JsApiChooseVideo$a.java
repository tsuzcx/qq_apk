package com.tencent.mm.plugin.appbrand.jsapi.media;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.content.res.Resources;
import android.media.MediaMetadataRetriever;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.i.d;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.plugin.appbrand.ac.m.a;
import com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalMediaObjectManager;
import com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalVideoObject;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessRequest;
import com.tencent.mm.plugin.appbrand.utils.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.q;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.vfs.o;
import java.util.List;

final class JsApiChooseVideo$a
  extends AppBrandProxyUIProcessTask
{
  private q gxX;
  private String mcN;
  private DialogInterface.OnCancelListener mcu;
  private JsApiChooseVideo.ChooseResult mdt;
  private JsApiChooseVideo.ChooseRequest mdu;
  
  private JsApiChooseVideo$a()
  {
    AppMethodBeat.i(46560);
    this.mdt = new JsApiChooseVideo.ChooseResult();
    AppMethodBeat.o(46560);
  }
  
  private AppBrandLocalVideoObject as(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(46565);
    String str1 = paramString;
    if (paramBoolean) {}
    try
    {
      str1 = t.aaf(paramString);
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
          Log.e("MicroMsg.JsApiChooseVideo", "addVideoItem, null meta data");
          AppMethodBeat.o(46565);
          return null;
          localException = localException;
          Log.e("MicroMsg.JsApiChooseVideo", "addVideoItem, remux failed, exp = %s", new Object[] { Util.stackTraceToString(localException) });
          str2 = paramString;
        }
      }
      catch (Exception paramString)
      {
        String str2;
        for (;;)
        {
          Log.e("MicroMsg.JsApiChooseVideo", "addVideoItem, MetaDataRetriever setDataSource failed, e = %s", new Object[] { paramString });
          paramString = null;
        }
        int i = Util.getInt(paramString.extractMetadata(24), 0);
        int j;
        if ((i == 90) || (i == 270)) {
          j = Util.getInt(paramString.extractMetadata(19), 0);
        }
        int k;
        for (i = Util.getInt(paramString.extractMetadata(18), 0);; i = Util.getInt(paramString.extractMetadata(19), 0))
        {
          k = Util.getInt(paramString.extractMetadata(9), 0);
          paramString.release();
          paramString = AppBrandLocalMediaObjectManager.O(this.mdu.appId, str2);
          if (paramString != null) {
            break;
          }
          AppMethodBeat.o(46565);
          return null;
          j = Util.getInt(paramString.extractMetadata(18), 0);
        }
        paramString.duration = ((k + 500) / 1000);
        paramString.width = j;
        paramString.height = i;
        paramString.size = com.tencent.mm.vfs.s.boW(str2);
        Log.i("MicroMsg.JsApiChooseVideo", "addVideoItem, return %s", new Object[] { paramString });
        AppMethodBeat.o(46565);
      }
    }
    return paramString;
  }
  
  private void bHv()
  {
    AppMethodBeat.i(46563);
    this.mcu = new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(46557);
        JsApiChooseVideo.a.a(JsApiChooseVideo.a.this).resultCode = 0;
        JsApiChooseVideo.a.a(JsApiChooseVideo.a.this, JsApiChooseVideo.a.a(JsApiChooseVideo.a.this));
        AppMethodBeat.o(46557);
      }
    };
    MMActivity localMMActivity = bDF();
    MMApplicationContext.getResources().getString(2131755998);
    this.gxX = h.a(localMMActivity, MMApplicationContext.getResources().getString(2131755397), true, this.mcu);
    AppMethodBeat.o(46563);
  }
  
  public final void a(AppBrandProxyUIProcessTask.ProcessRequest paramProcessRequest)
  {
    AppMethodBeat.i(46561);
    this.mdu = ((JsApiChooseVideo.ChooseRequest)paramProcessRequest);
    this.mdu.maxDuration = Math.min(Math.max(this.mdu.maxDuration, 60), 0);
    if (Util.getAvailableMemoryMB(bDF()) > 200L) {}
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        u.makeText(bDF(), MMApplicationContext.getResources().getString(2131755397), 1).show();
      }
      bDF().mmSetOnActivityResultCallback(this);
      paramProcessRequest = new Intent();
      paramProcessRequest.putExtra("key_send_raw_image", false);
      paramProcessRequest.putExtra("query_media_type", 2);
      paramProcessRequest.putExtra("GalleryUI_SkipVideoSizeLimit", true);
      paramProcessRequest.putExtra("gallery_report_tag", 16);
      if ((!this.mdu.mch) || (!this.mdu.mci)) {
        break;
      }
      this.mcN = com.tencent.mm.vfs.s.k(b.aKV() + "microMsg." + System.currentTimeMillis() + ".mp4", false);
      paramProcessRequest.putExtra("record_video_force_sys_camera", true);
      paramProcessRequest.putExtra("record_video_quality", 1);
      paramProcessRequest.putExtra("record_video_time_limit", this.mdu.maxDuration);
      paramProcessRequest.putExtra("video_full_path", this.mcN);
      com.tencent.mm.pluginsdk.ui.tools.s.e(bDF(), 1, 7, paramProcessRequest);
      AppMethodBeat.o(46561);
      return;
    }
    if (this.mdu.mch)
    {
      this.mcN = com.tencent.mm.vfs.s.k(b.aKV() + "microMsg." + System.currentTimeMillis() + ".mp4", false);
      i = this.mdu.maxDuration;
      com.tencent.mm.pluginsdk.ui.tools.s.a(bDF(), this.mcN, 5, i, 1, false);
      AppMethodBeat.o(46561);
      return;
    }
    if (this.mdu.mci)
    {
      paramProcessRequest.putExtra("show_header_view", false);
      com.tencent.mm.pluginsdk.ui.tools.s.e(bDF(), 1, 16, paramProcessRequest);
      AppMethodBeat.o(46561);
      return;
    }
    this.mdt.resultCode = -2;
    b(this.mdt);
    AppMethodBeat.o(46561);
  }
  
  public final void bDM()
  {
    AppMethodBeat.i(46562);
    super.bDM();
    if (this.gxX != null)
    {
      this.gxX.dismiss();
      this.gxX = null;
    }
    AppMethodBeat.o(46562);
  }
  
  public final void d(int paramInt1, int paramInt2, final Intent paramIntent)
  {
    AppMethodBeat.i(46564);
    if (paramInt2 == 0)
    {
      this.mdt.resultCode = 0;
      b(this.mdt);
      AppMethodBeat.o(46564);
      return;
    }
    if (-1 != paramInt2)
    {
      this.mdt.resultCode = -2;
      b(this.mdt);
      AppMethodBeat.o(46564);
      return;
    }
    switch (paramInt1)
    {
    }
    do
    {
      do
      {
        this.mdt.resultCode = -2;
        b(this.mdt);
        AppMethodBeat.o(46564);
        return;
      } while (Util.isNullOrNil(this.mcN));
      bHv();
      f.bZn().postToWorker(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(46558);
          if (new o(JsApiChooseVideo.a.b(JsApiChooseVideo.a.this)).exists())
          {
            JsApiChooseVideo.a.a(JsApiChooseVideo.a.this).resultCode = -1;
            JsApiChooseVideo.a.a(JsApiChooseVideo.a.this).mds = JsApiChooseVideo.a.a(JsApiChooseVideo.a.this, JsApiChooseVideo.a.b(JsApiChooseVideo.a.this), JsApiChooseVideo.a.c(JsApiChooseVideo.a.this).mdr);
            JsApiChooseVideo.a.b(JsApiChooseVideo.a.this, JsApiChooseVideo.a.a(JsApiChooseVideo.a.this));
            AppMethodBeat.o(46558);
            return;
          }
          JsApiChooseVideo.a.a(JsApiChooseVideo.a.this).resultCode = -2;
          JsApiChooseVideo.a.c(JsApiChooseVideo.a.this, JsApiChooseVideo.a.a(JsApiChooseVideo.a.this));
          AppMethodBeat.o(46558);
        }
      });
      AppMethodBeat.o(46564);
      return;
      paramIntent = paramIntent.getStringArrayListExtra("key_select_video_list");
    } while (Util.isNullOrNil(paramIntent));
    paramIntent = com.tencent.mm.vfs.s.k((String)paramIntent.get(0), false);
    bHv();
    f.bZn().postToWorker(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(46559);
        JsApiChooseVideo.a.a(JsApiChooseVideo.a.this).resultCode = -1;
        JsApiChooseVideo.a.a(JsApiChooseVideo.a.this).mds = JsApiChooseVideo.a.a(JsApiChooseVideo.a.this, paramIntent, JsApiChooseVideo.a.c(JsApiChooseVideo.a.this).mdr);
        JsApiChooseVideo.a.d(JsApiChooseVideo.a.this, JsApiChooseVideo.a.a(JsApiChooseVideo.a.this));
        AppMethodBeat.o(46559);
      }
    });
    AppMethodBeat.o(46564);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.media.JsApiChooseVideo.a
 * JD-Core Version:    0.7.0.1
 */