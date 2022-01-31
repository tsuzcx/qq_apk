package com.tencent.mm.plugin.appbrand.jsapi.media;

import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.content.res.Resources;
import android.media.MediaMetadataRetriever;
import android.widget.Toast;
import com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalMediaObjectManager;
import com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalVideoObject;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessRequest;
import com.tencent.mm.plugin.appbrand.y.j;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.plugin.sight.base.b;
import com.tencent.mm.pluginsdk.model.j;
import com.tencent.mm.pluginsdk.ui.tools.l;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.base.s;
import java.util.List;

final class JsApiChooseVideo$a
  extends AppBrandProxyUIProcessTask
{
  private p dpF;
  private JsApiChooseVideo.ChooseResult gvX = new JsApiChooseVideo.ChooseResult();
  private JsApiChooseVideo.ChooseRequest gvY;
  private DialogInterface.OnCancelListener gvu;
  private String mVideoFilePath;
  
  private AppBrandLocalVideoObject af(String paramString, boolean paramBoolean)
  {
    Object localObject = paramString;
    if (paramBoolean) {}
    try
    {
      paramBoolean = com.tencent.mm.plugin.a.c.pp(paramString);
      y.i("MicroMsg.JsApiChooseVideo", "checkRemux, isMp4 = %b", new Object[] { Boolean.valueOf(paramBoolean) });
      i = -10000;
      if (!paramBoolean) {
        break label462;
      }
      i = SightVideoJNI.shouldRemuxing(paramString, 660, 500, 26214400, 300000.0D, 1000000);
      y.i("MicroMsg.JsApiChooseVideo", "checkRemux, ret = %d", new Object[] { Integer.valueOf(i) });
    }
    catch (Exception localException)
    {
      try
      {
        for (;;)
        {
          paramString = new MediaMetadataRetriever();
          paramString.setDataSource((String)localObject);
          if (paramString != null) {
            break;
          }
          y.e("MicroMsg.JsApiChooseVideo", "addVideoItem, null meta data");
          return null;
          i = 1;
          break label474;
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
          localObject = com.tencent.mm.compatible.util.e.dzD + "microMsg." + System.currentTimeMillis() + ".mp4";
          y.i("MicroMsg.JsApiChooseVideo", "remuxIfNeed [%s] to [%s], result %d, resolution:[%d, %d]", new Object[] { paramString, localObject, Integer.valueOf(SightVideoJNI.remuxing(paramString, (String)localObject, i, j, b.oeb, b.oea, 8, 2, 25.0F, b.oec, null, 0, false)), Integer.valueOf(i), Integer.valueOf(j) });
          continue;
          localException = localException;
          y.e("MicroMsg.JsApiChooseVideo", "addVideoItem, remux failed, exp = %s", new Object[] { bk.j(localException) });
          str = paramString;
        }
      }
      catch (Exception paramString)
      {
        for (;;)
        {
          y.e("MicroMsg.JsApiChooseVideo", "addVideoItem, MetaDataRetriever setDataSource failed, e = %s", new Object[] { paramString });
          paramString = null;
        }
        i = bk.getInt(paramString.extractMetadata(18), 0);
        j = bk.getInt(paramString.extractMetadata(19), 0);
        k = bk.getInt(paramString.extractMetadata(9), 0);
        paramString.release();
        paramString = AppBrandLocalMediaObjectManager.attachVideo(this.gvY.appId, str);
        if (paramString != null) {
          break label411;
        }
        return null;
        paramString.duration = ((k + 500) / 1000);
        paramString.width = i;
        paramString.height = j;
        paramString.size = com.tencent.mm.a.e.bJ(str);
        y.i("MicroMsg.JsApiChooseVideo", "addVideoItem, return %s", new Object[] { paramString });
        return paramString;
      }
    }
    int i = com.tencent.mm.a.e.bJ(paramString);
    y.i("MicroMsg.JsApiChooseVideo", "fileLength = %d", new Object[] { Integer.valueOf(i) });
    if (i > 26214400) {
      i = -1;
    }
    for (;;)
    {
      y.e("MicroMsg.JsApiChooseVideo", "unknown check type");
      i = -50001;
      if (i != -50006) {
        localObject = paramString;
      }
      int j;
      String str;
      int k;
      label411:
      label462:
      if ((i == -1) || (!paramBoolean)) {
        break;
      }
      label474:
      switch (i)
      {
      }
    }
  }
  
  private void ajw()
  {
    this.gvu = new JsApiChooseVideo.a.1(this);
    MMActivity localMMActivity = ahy();
    int i = y.j.app_tip;
    ae.getResources().getString(i);
    i = y.j.app_brand_choose_media_video_processing;
    this.dpF = h.b(localMMActivity, ae.getResources().getString(i), true, this.gvu);
  }
  
  protected final void a(AppBrandProxyUIProcessTask.ProcessRequest paramProcessRequest)
  {
    this.gvY = ((JsApiChooseVideo.ChooseRequest)paramProcessRequest);
    this.gvY.maxDuration = Math.min(Math.max(this.gvY.maxDuration, 60), 0);
    if (bk.fQ(ahy()) > 200L) {}
    for (int i = 1;; i = 0)
    {
      if (i == 0)
      {
        paramProcessRequest = ahy();
        i = y.j.app_brand_choose_media_video_processing;
        s.makeText(paramProcessRequest, ae.getResources().getString(i), 1).show();
      }
      ahy().gJb = this;
      paramProcessRequest = new Intent();
      paramProcessRequest.putExtra("key_send_raw_image", false);
      paramProcessRequest.putExtra("query_media_type", 2);
      paramProcessRequest.putExtra("GalleryUI_SkipVideoSizeLimit", true);
      if ((!this.gvY.gvm) || (!this.gvY.gvn)) {
        break;
      }
      this.mVideoFilePath = (com.tencent.mm.compatible.util.e.dzD + "microMsg." + System.currentTimeMillis() + ".mp4");
      paramProcessRequest.putExtra("record_video_force_sys_camera", true);
      paramProcessRequest.putExtra("record_video_quality", 1);
      paramProcessRequest.putExtra("record_video_time_limit", this.gvY.maxDuration);
      paramProcessRequest.putExtra("video_full_path", this.mVideoFilePath);
      l.d(ahy(), 1, 7, paramProcessRequest);
      return;
    }
    if (this.gvY.gvm)
    {
      this.mVideoFilePath = (com.tencent.mm.compatible.util.e.dzD + "microMsg." + System.currentTimeMillis() + ".mp4");
      i = this.gvY.maxDuration;
      l.a(ahy(), this.mVideoFilePath, 5, i, 1, false);
      return;
    }
    if (this.gvY.gvn)
    {
      paramProcessRequest.putExtra("show_header_view", false);
      l.d(ahy(), 1, 7, paramProcessRequest);
      return;
    }
    this.gvX.aYY = -2;
    a(this.gvX);
  }
  
  protected final void ahE()
  {
    super.ahE();
    if (this.dpF != null)
    {
      this.dpF.dismiss();
      this.dpF = null;
    }
  }
  
  public final void c(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt2 == 0)
    {
      this.gvX.aYY = 0;
      a(this.gvX);
      return;
    }
    if (-1 != paramInt2)
    {
      this.gvX.aYY = -2;
      a(this.gvX);
      return;
    }
    switch (paramInt1)
    {
    }
    do
    {
      do
      {
        this.gvX.aYY = -2;
        a(this.gvX);
        return;
      } while (bk.bl(this.mVideoFilePath));
      ajw();
      com.tencent.mm.plugin.appbrand.v.c.DS().O(new JsApiChooseVideo.a.2(this));
      return;
      paramIntent = paramIntent.getStringArrayListExtra("key_select_video_list");
    } while (bk.dk(paramIntent));
    paramIntent = (String)paramIntent.get(0);
    ajw();
    com.tencent.mm.plugin.appbrand.v.c.DS().O(new JsApiChooseVideo.a.3(this, paramIntent));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.media.JsApiChooseVideo.a
 * JD-Core Version:    0.7.0.1
 */