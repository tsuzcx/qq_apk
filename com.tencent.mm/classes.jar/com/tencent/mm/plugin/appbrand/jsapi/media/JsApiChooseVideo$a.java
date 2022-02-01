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
import com.tencent.mm.plugin.appbrand.z.m.a;
import com.tencent.mm.pluginsdk.ui.tools.q;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.vfs.i;
import java.util.List;

final class JsApiChooseVideo$a
  extends AppBrandProxyUIProcessTask
{
  private p fQJ;
  private DialogInterface.OnCancelListener kTB;
  private String kTU;
  private JsApiChooseVideo.ChooseResult kUA;
  private JsApiChooseVideo.ChooseRequest kUB;
  
  private JsApiChooseVideo$a()
  {
    AppMethodBeat.i(46560);
    this.kUA = new JsApiChooseVideo.ChooseResult();
    AppMethodBeat.o(46560);
  }
  
  private AppBrandLocalVideoObject aq(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(46565);
    String str1 = paramString;
    if (paramBoolean) {}
    try
    {
      str1 = t.PV(paramString);
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
          ad.e("MicroMsg.JsApiChooseVideo", "addVideoItem, null meta data");
          AppMethodBeat.o(46565);
          return null;
          localException = localException;
          ad.e("MicroMsg.JsApiChooseVideo", "addVideoItem, remux failed, exp = %s", new Object[] { bt.n(localException) });
          str2 = paramString;
        }
      }
      catch (Exception paramString)
      {
        String str2;
        for (;;)
        {
          ad.e("MicroMsg.JsApiChooseVideo", "addVideoItem, MetaDataRetriever setDataSource failed, e = %s", new Object[] { paramString });
          paramString = null;
        }
        int i = bt.getInt(paramString.extractMetadata(24), 0);
        int j;
        if ((i == 90) || (i == 270)) {
          j = bt.getInt(paramString.extractMetadata(19), 0);
        }
        int k;
        for (i = bt.getInt(paramString.extractMetadata(18), 0);; i = bt.getInt(paramString.extractMetadata(19), 0))
        {
          k = bt.getInt(paramString.extractMetadata(9), 0);
          paramString.release();
          paramString = AppBrandLocalMediaObjectManager.ck(this.kUB.appId, str2);
          if (paramString != null) {
            break;
          }
          AppMethodBeat.o(46565);
          return null;
          j = bt.getInt(paramString.extractMetadata(18), 0);
        }
        paramString.duration = ((k + 500) / 1000);
        paramString.width = j;
        paramString.height = i;
        paramString.size = ((int)i.aYo(str2));
        ad.i("MicroMsg.JsApiChooseVideo", "addVideoItem, return %s", new Object[] { paramString });
        AppMethodBeat.o(46565);
      }
    }
    return paramString;
  }
  
  private void blo()
  {
    AppMethodBeat.i(46563);
    this.kTB = new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(46557);
        JsApiChooseVideo.a.a(JsApiChooseVideo.a.this).bZU = 0;
        JsApiChooseVideo.a.a(JsApiChooseVideo.a.this, JsApiChooseVideo.a.a(JsApiChooseVideo.a.this));
        AppMethodBeat.o(46557);
      }
    };
    MMActivity localMMActivity = bhJ();
    aj.getResources().getString(2131755906);
    this.fQJ = h.b(localMMActivity, aj.getResources().getString(2131755360), true, this.kTB);
    AppMethodBeat.o(46563);
  }
  
  public final void a(AppBrandProxyUIProcessTask.ProcessRequest paramProcessRequest)
  {
    AppMethodBeat.i(46561);
    this.kUB = ((JsApiChooseVideo.ChooseRequest)paramProcessRequest);
    this.kUB.maxDuration = Math.min(Math.max(this.kUB.maxDuration, 60), 0);
    if (bt.je(bhJ()) > 200L) {}
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        com.tencent.mm.ui.base.t.makeText(bhJ(), aj.getResources().getString(2131755360), 1).show();
      }
      bhJ().mmSetOnActivityResultCallback(this);
      paramProcessRequest = new Intent();
      paramProcessRequest.putExtra("key_send_raw_image", false);
      paramProcessRequest.putExtra("query_media_type", 2);
      paramProcessRequest.putExtra("GalleryUI_SkipVideoSizeLimit", true);
      paramProcessRequest.putExtra("gallery_report_tag", 16);
      if ((!this.kUB.kTo) || (!this.kUB.kTp)) {
        break;
      }
      this.kTU = i.k(b.asg() + "microMsg." + System.currentTimeMillis() + ".mp4", false);
      paramProcessRequest.putExtra("record_video_force_sys_camera", true);
      paramProcessRequest.putExtra("record_video_quality", 1);
      paramProcessRequest.putExtra("record_video_time_limit", this.kUB.maxDuration);
      paramProcessRequest.putExtra("video_full_path", this.kTU);
      q.d(bhJ(), 1, 7, paramProcessRequest);
      AppMethodBeat.o(46561);
      return;
    }
    if (this.kUB.kTo)
    {
      this.kTU = i.k(b.asg() + "microMsg." + System.currentTimeMillis() + ".mp4", false);
      i = this.kUB.maxDuration;
      q.a(bhJ(), this.kTU, 5, i, 1, false);
      AppMethodBeat.o(46561);
      return;
    }
    if (this.kUB.kTp)
    {
      paramProcessRequest.putExtra("show_header_view", false);
      q.d(bhJ(), 1, 7, paramProcessRequest);
      AppMethodBeat.o(46561);
      return;
    }
    this.kUA.bZU = -2;
    b(this.kUA);
    AppMethodBeat.o(46561);
  }
  
  public final void bhQ()
  {
    AppMethodBeat.i(46562);
    super.bhQ();
    if (this.fQJ != null)
    {
      this.fQJ.dismiss();
      this.fQJ = null;
    }
    AppMethodBeat.o(46562);
  }
  
  public final void c(int paramInt1, int paramInt2, final Intent paramIntent)
  {
    AppMethodBeat.i(46564);
    if (paramInt2 == 0)
    {
      this.kUA.bZU = 0;
      b(this.kUA);
      AppMethodBeat.o(46564);
      return;
    }
    if (-1 != paramInt2)
    {
      this.kUA.bZU = -2;
      b(this.kUA);
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
        this.kUA.bZU = -2;
        b(this.kUA);
        AppMethodBeat.o(46564);
        return;
      } while (bt.isNullOrNil(this.kTU));
      blo();
      com.tencent.mm.plugin.appbrand.utils.e.bBp().postToWorker(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(46558);
          if (new com.tencent.mm.vfs.e(JsApiChooseVideo.a.b(JsApiChooseVideo.a.this)).exists())
          {
            JsApiChooseVideo.a.a(JsApiChooseVideo.a.this).bZU = -1;
            JsApiChooseVideo.a.a(JsApiChooseVideo.a.this).kUz = JsApiChooseVideo.a.a(JsApiChooseVideo.a.this, JsApiChooseVideo.a.b(JsApiChooseVideo.a.this), JsApiChooseVideo.a.c(JsApiChooseVideo.a.this).kUy);
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
    } while (bt.hj(paramIntent));
    paramIntent = i.k((String)paramIntent.get(0), false);
    blo();
    com.tencent.mm.plugin.appbrand.utils.e.bBp().postToWorker(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(46559);
        JsApiChooseVideo.a.a(JsApiChooseVideo.a.this).bZU = -1;
        JsApiChooseVideo.a.a(JsApiChooseVideo.a.this).kUz = JsApiChooseVideo.a.a(JsApiChooseVideo.a.this, paramIntent, JsApiChooseVideo.a.c(JsApiChooseVideo.a.this).kUy);
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