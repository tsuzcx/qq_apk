package com.tencent.mm.plugin.appbrand.jsapi.media;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.content.res.Resources;
import android.media.MediaMetadataRetriever;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalMediaObjectManager;
import com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalVideoObject;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessRequest;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.base.t;
import java.util.List;

final class JsApiChooseVideo$a
  extends AppBrandProxyUIProcessTask
{
  private p ehb;
  private DialogInterface.OnCancelListener hQL;
  private JsApiChooseVideo.ChooseResult hRI;
  private JsApiChooseVideo.ChooseRequest hRJ;
  private String mVideoFilePath;
  
  private JsApiChooseVideo$a()
  {
    AppMethodBeat.i(131285);
    this.hRI = new JsApiChooseVideo.ChooseResult();
    AppMethodBeat.o(131285);
  }
  
  private void aDM()
  {
    AppMethodBeat.i(131288);
    this.hQL = new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(131282);
        JsApiChooseVideo.a.a(JsApiChooseVideo.a.this).bpE = 0;
        JsApiChooseVideo.a.a(JsApiChooseVideo.a.this, JsApiChooseVideo.a.a(JsApiChooseVideo.a.this));
        AppMethodBeat.o(131282);
      }
    };
    MMActivity localMMActivity = aBf();
    ah.getResources().getString(2131297087);
    this.ehb = h.b(localMMActivity, ah.getResources().getString(2131296595), true, this.hQL);
    AppMethodBeat.o(131288);
  }
  
  private AppBrandLocalVideoObject ak(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(131290);
    String str1 = paramString;
    if (paramBoolean) {}
    try
    {
      str1 = n.Cu(paramString);
    }
    catch (Exception localException)
    {
      try
      {
        for (;;)
        {
          paramString = new MediaMetadataRetriever();
          paramString.setDataSource(str1);
          if (paramString != null) {
            break;
          }
          ab.e("MicroMsg.JsApiChooseVideo", "addVideoItem, null meta data");
          AppMethodBeat.o(131290);
          return null;
          localException = localException;
          ab.e("MicroMsg.JsApiChooseVideo", "addVideoItem, remux failed, exp = %s", new Object[] { bo.l(localException) });
          str2 = paramString;
        }
      }
      catch (Exception paramString)
      {
        String str2;
        for (;;)
        {
          ab.e("MicroMsg.JsApiChooseVideo", "addVideoItem, MetaDataRetriever setDataSource failed, e = %s", new Object[] { paramString });
          paramString = null;
        }
        int i = bo.getInt(paramString.extractMetadata(24), 0);
        int j;
        if ((i == 90) || (i == 270)) {
          j = bo.getInt(paramString.extractMetadata(19), 0);
        }
        int k;
        for (i = bo.getInt(paramString.extractMetadata(18), 0);; i = bo.getInt(paramString.extractMetadata(19), 0))
        {
          k = bo.getInt(paramString.extractMetadata(9), 0);
          paramString.release();
          paramString = AppBrandLocalMediaObjectManager.bv(this.hRJ.appId, str2);
          if (paramString != null) {
            break;
          }
          AppMethodBeat.o(131290);
          return null;
          j = bo.getInt(paramString.extractMetadata(18), 0);
        }
        paramString.duration = ((k + 500) / 1000);
        paramString.width = j;
        paramString.height = i;
        paramString.size = com.tencent.mm.a.e.cM(str2);
        ab.i("MicroMsg.JsApiChooseVideo", "addVideoItem, return %s", new Object[] { paramString });
        AppMethodBeat.o(131290);
      }
    }
    return paramString;
  }
  
  public final void a(AppBrandProxyUIProcessTask.ProcessRequest paramProcessRequest)
  {
    AppMethodBeat.i(131286);
    this.hRJ = ((JsApiChooseVideo.ChooseRequest)paramProcessRequest);
    this.hRJ.maxDuration = Math.min(Math.max(this.hRJ.maxDuration, 60), 0);
    if (bo.hg(aBf()) > 200L) {}
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        t.makeText(aBf(), ah.getResources().getString(2131296595), 1).show();
      }
      aBf().mmSetOnActivityResultCallback(this);
      paramProcessRequest = new Intent();
      paramProcessRequest.putExtra("key_send_raw_image", false);
      paramProcessRequest.putExtra("query_media_type", 2);
      paramProcessRequest.putExtra("GalleryUI_SkipVideoSizeLimit", true);
      if ((!this.hRJ.hQD) || (!this.hRJ.hQE)) {
        break;
      }
      this.mVideoFilePath = (com.tencent.mm.compatible.util.e.esr + "microMsg." + System.currentTimeMillis() + ".mp4");
      paramProcessRequest.putExtra("record_video_force_sys_camera", true);
      paramProcessRequest.putExtra("record_video_quality", 1);
      paramProcessRequest.putExtra("record_video_time_limit", this.hRJ.maxDuration);
      paramProcessRequest.putExtra("video_full_path", this.mVideoFilePath);
      com.tencent.mm.pluginsdk.ui.tools.n.e(aBf(), 1, 7, paramProcessRequest);
      AppMethodBeat.o(131286);
      return;
    }
    if (this.hRJ.hQD)
    {
      this.mVideoFilePath = (com.tencent.mm.compatible.util.e.esr + "microMsg." + System.currentTimeMillis() + ".mp4");
      i = this.hRJ.maxDuration;
      com.tencent.mm.pluginsdk.ui.tools.n.a(aBf(), this.mVideoFilePath, 5, i, 1, false);
      AppMethodBeat.o(131286);
      return;
    }
    if (this.hRJ.hQE)
    {
      paramProcessRequest.putExtra("show_header_view", false);
      com.tencent.mm.pluginsdk.ui.tools.n.e(aBf(), 1, 7, paramProcessRequest);
      AppMethodBeat.o(131286);
      return;
    }
    this.hRI.bpE = -2;
    a(this.hRI);
    AppMethodBeat.o(131286);
  }
  
  public final void aBl()
  {
    AppMethodBeat.i(131287);
    super.aBl();
    if (this.ehb != null)
    {
      this.ehb.dismiss();
      this.ehb = null;
    }
    AppMethodBeat.o(131287);
  }
  
  public final void c(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(131289);
    if (paramInt2 == 0)
    {
      this.hRI.bpE = 0;
      a(this.hRI);
      AppMethodBeat.o(131289);
      return;
    }
    if (-1 != paramInt2)
    {
      this.hRI.bpE = -2;
      a(this.hRI);
      AppMethodBeat.o(131289);
      return;
    }
    switch (paramInt1)
    {
    }
    do
    {
      do
      {
        this.hRI.bpE = -2;
        a(this.hRI);
        AppMethodBeat.o(131289);
        return;
      } while (bo.isNullOrNil(this.mVideoFilePath));
      aDM();
      com.tencent.mm.plugin.appbrand.t.e.aNS().ac(new JsApiChooseVideo.a.2(this));
      AppMethodBeat.o(131289);
      return;
      paramIntent = paramIntent.getStringArrayListExtra("key_select_video_list");
    } while (bo.es(paramIntent));
    paramIntent = (String)paramIntent.get(0);
    aDM();
    com.tencent.mm.plugin.appbrand.t.e.aNS().ac(new JsApiChooseVideo.a.3(this, paramIntent));
    AppMethodBeat.o(131289);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.media.JsApiChooseVideo.a
 * JD-Core Version:    0.7.0.1
 */