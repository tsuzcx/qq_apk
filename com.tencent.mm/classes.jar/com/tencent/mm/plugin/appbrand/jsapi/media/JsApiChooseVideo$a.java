package com.tencent.mm.plugin.appbrand.jsapi.media;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.content.res.Resources;
import android.media.MediaMetadataRetriever;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.h.d;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalMediaObjectManager;
import com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalVideoObject;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessRequest;
import com.tencent.mm.plugin.appbrand.utils.f;
import com.tencent.mm.plugin.appbrand.y.m.a;
import com.tencent.mm.pluginsdk.ui.tools.q;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.vfs.k;
import com.tencent.mm.vfs.o;
import java.util.List;

final class JsApiChooseVideo$a
  extends AppBrandProxyUIProcessTask
{
  private p fSP;
  private String kXD;
  private DialogInterface.OnCancelListener kXk;
  private JsApiChooseVideo.ChooseResult kYj;
  private JsApiChooseVideo.ChooseRequest kYk;
  
  private JsApiChooseVideo$a()
  {
    AppMethodBeat.i(46560);
    this.kYj = new JsApiChooseVideo.ChooseResult();
    AppMethodBeat.o(46560);
  }
  
  private AppBrandLocalVideoObject aq(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(46565);
    String str1 = paramString;
    if (paramBoolean) {}
    try
    {
      str1 = t.QE(paramString);
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
          ae.e("MicroMsg.JsApiChooseVideo", "addVideoItem, null meta data");
          AppMethodBeat.o(46565);
          return null;
          localException = localException;
          ae.e("MicroMsg.JsApiChooseVideo", "addVideoItem, remux failed, exp = %s", new Object[] { bu.o(localException) });
          str2 = paramString;
        }
      }
      catch (Exception paramString)
      {
        String str2;
        for (;;)
        {
          ae.e("MicroMsg.JsApiChooseVideo", "addVideoItem, MetaDataRetriever setDataSource failed, e = %s", new Object[] { paramString });
          paramString = null;
        }
        int i = bu.getInt(paramString.extractMetadata(24), 0);
        int j;
        if ((i == 90) || (i == 270)) {
          j = bu.getInt(paramString.extractMetadata(19), 0);
        }
        int k;
        for (i = bu.getInt(paramString.extractMetadata(18), 0);; i = bu.getInt(paramString.extractMetadata(19), 0))
        {
          k = bu.getInt(paramString.extractMetadata(9), 0);
          paramString.release();
          paramString = AppBrandLocalMediaObjectManager.cl(this.kYk.appId, str2);
          if (paramString != null) {
            break;
          }
          AppMethodBeat.o(46565);
          return null;
          j = bu.getInt(paramString.extractMetadata(18), 0);
        }
        paramString.duration = ((k + 500) / 1000);
        paramString.width = j;
        paramString.height = i;
        paramString.size = o.aZR(str2);
        ae.i("MicroMsg.JsApiChooseVideo", "addVideoItem, return %s", new Object[] { paramString });
        AppMethodBeat.o(46565);
      }
    }
    return paramString;
  }
  
  private void blX()
  {
    AppMethodBeat.i(46563);
    this.kXk = new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(46557);
        JsApiChooseVideo.a.a(JsApiChooseVideo.a.this).bZU = 0;
        JsApiChooseVideo.a.a(JsApiChooseVideo.a.this, JsApiChooseVideo.a.a(JsApiChooseVideo.a.this));
        AppMethodBeat.o(46557);
      }
    };
    MMActivity localMMActivity = bis();
    ak.getResources().getString(2131755906);
    this.fSP = h.b(localMMActivity, ak.getResources().getString(2131755360), true, this.kXk);
    AppMethodBeat.o(46563);
  }
  
  public final void a(AppBrandProxyUIProcessTask.ProcessRequest paramProcessRequest)
  {
    AppMethodBeat.i(46561);
    this.kYk = ((JsApiChooseVideo.ChooseRequest)paramProcessRequest);
    this.kYk.maxDuration = Math.min(Math.max(this.kYk.maxDuration, 60), 0);
    if (bu.jk(bis()) > 200L) {}
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        com.tencent.mm.ui.base.t.makeText(bis(), ak.getResources().getString(2131755360), 1).show();
      }
      bis().mmSetOnActivityResultCallback(this);
      paramProcessRequest = new Intent();
      paramProcessRequest.putExtra("key_send_raw_image", false);
      paramProcessRequest.putExtra("query_media_type", 2);
      paramProcessRequest.putExtra("GalleryUI_SkipVideoSizeLimit", true);
      paramProcessRequest.putExtra("gallery_report_tag", 16);
      if ((!this.kYk.kWX) || (!this.kYk.kWY)) {
        break;
      }
      this.kXD = o.k(b.asv() + "microMsg." + System.currentTimeMillis() + ".mp4", false);
      paramProcessRequest.putExtra("record_video_force_sys_camera", true);
      paramProcessRequest.putExtra("record_video_quality", 1);
      paramProcessRequest.putExtra("record_video_time_limit", this.kYk.maxDuration);
      paramProcessRequest.putExtra("video_full_path", this.kXD);
      q.e(bis(), 1, 7, paramProcessRequest);
      AppMethodBeat.o(46561);
      return;
    }
    if (this.kYk.kWX)
    {
      this.kXD = o.k(b.asv() + "microMsg." + System.currentTimeMillis() + ".mp4", false);
      i = this.kYk.maxDuration;
      q.a(bis(), this.kXD, 5, i, 1, false);
      AppMethodBeat.o(46561);
      return;
    }
    if (this.kYk.kWY)
    {
      paramProcessRequest.putExtra("show_header_view", false);
      q.e(bis(), 1, 7, paramProcessRequest);
      AppMethodBeat.o(46561);
      return;
    }
    this.kYj.bZU = -2;
    b(this.kYj);
    AppMethodBeat.o(46561);
  }
  
  public final void biz()
  {
    AppMethodBeat.i(46562);
    super.biz();
    if (this.fSP != null)
    {
      this.fSP.dismiss();
      this.fSP = null;
    }
    AppMethodBeat.o(46562);
  }
  
  public final void c(int paramInt1, int paramInt2, final Intent paramIntent)
  {
    AppMethodBeat.i(46564);
    if (paramInt2 == 0)
    {
      this.kYj.bZU = 0;
      b(this.kYj);
      AppMethodBeat.o(46564);
      return;
    }
    if (-1 != paramInt2)
    {
      this.kYj.bZU = -2;
      b(this.kYj);
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
        this.kYj.bZU = -2;
        b(this.kYj);
        AppMethodBeat.o(46564);
        return;
      } while (bu.isNullOrNil(this.kXD));
      blX();
      f.bCj().postToWorker(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(46558);
          if (new k(JsApiChooseVideo.a.b(JsApiChooseVideo.a.this)).exists())
          {
            JsApiChooseVideo.a.a(JsApiChooseVideo.a.this).bZU = -1;
            JsApiChooseVideo.a.a(JsApiChooseVideo.a.this).kYi = JsApiChooseVideo.a.a(JsApiChooseVideo.a.this, JsApiChooseVideo.a.b(JsApiChooseVideo.a.this), JsApiChooseVideo.a.c(JsApiChooseVideo.a.this).kYh);
            JsApiChooseVideo.a.b(JsApiChooseVideo.a.this, JsApiChooseVideo.a.a(JsApiChooseVideo.a.this));
            AppMethodBeat.o(46558);
            return;
          }
          JsApiChooseVideo.a.a(JsApiChooseVideo.a.this).bZU = -2;
          JsApiChooseVideo.a.c(JsApiChooseVideo.a.this, JsApiChooseVideo.a.a(JsApiChooseVideo.a.this));
          AppMethodBeat.o(46558);
        }
      });
      AppMethodBeat.o(46564);
      return;
      paramIntent = paramIntent.getStringArrayListExtra("key_select_video_list");
    } while (bu.ht(paramIntent));
    paramIntent = o.k((String)paramIntent.get(0), false);
    blX();
    f.bCj().postToWorker(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(46559);
        JsApiChooseVideo.a.a(JsApiChooseVideo.a.this).bZU = -1;
        JsApiChooseVideo.a.a(JsApiChooseVideo.a.this).kYi = JsApiChooseVideo.a.a(JsApiChooseVideo.a.this, paramIntent, JsApiChooseVideo.a.c(JsApiChooseVideo.a.this).kYh);
        JsApiChooseVideo.a.d(JsApiChooseVideo.a.this, JsApiChooseVideo.a.a(JsApiChooseVideo.a.this));
        AppMethodBeat.o(46559);
      }
    });
    AppMethodBeat.o(46564);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.media.JsApiChooseVideo.a
 * JD-Core Version:    0.7.0.1
 */