package com.tencent.mm.plugin.appbrand.jsapi.live;

import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.rtmp.ITXLivePushListener;
import com.tencent.rtmp.TXLivePusher;
import com.tencent.rtmp.TXLivePusher.ITXSnapshotListener;
import com.tencent.rtmp.TXLivePusher.OnBGMNotify;
import com.tencent.rtmp.ui.TXCloudVideoView;
import java.util.HashMap;
import org.json.JSONObject;

public class AppBrandLivePusherView
  extends TXCloudVideoView
{
  m gsc;
  private ITXLivePushListener gsd;
  private AppBrandLivePusherView.b gse;
  private AppBrandLivePusherView.a gsf;
  
  public AppBrandLivePusherView(Context paramContext)
  {
    super(paramContext);
    init(paramContext);
  }
  
  public AppBrandLivePusherView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init(paramContext);
  }
  
  private void init(Context paramContext)
  {
    this.gsc = new m(paramContext);
    setBackgroundColor(-16777216);
  }
  
  public final void a(int paramInt, String paramString, HashMap<String, Object> paramHashMap)
  {
    y.w("MicroMsg.AppBrandLivePusherView.javayhu", "onError code:%d msg:%s", new Object[] { Integer.valueOf(paramInt), paramString });
    if (this.gsf != null) {
      this.gsf.a(paramInt, paramString, paramHashMap);
    }
  }
  
  public final boolean b(String paramString, JSONObject paramJSONObject)
  {
    paramString = this.gsc.c(paramString, paramJSONObject);
    y.i("MicroMsg.AppBrandLivePusherView.javayhu", "onOperate code:%d info:%s", new Object[] { Integer.valueOf(paramString.errorCode), paramString.gst });
    return paramString.errorCode == 0;
  }
  
  public final void rX()
  {
    Object localObject = this.gsc;
    if (!((m)localObject).mInited) {}
    for (localObject = new j(-3, "uninited livePusher");; localObject = new j())
    {
      y.i("MicroMsg.AppBrandLivePusherView.javayhu", "onDestroy code:%d info:%s", new Object[] { Integer.valueOf(((j)localObject).errorCode), ((j)localObject).gst });
      if (this.gse != null) {
        this.gse.ajb();
      }
      return;
      ((m)localObject).gsK.stopBGM();
      ((m)localObject).gsK.stopCameraPreview(true);
      ((m)localObject).gsK.stopPusher();
      ((m)localObject).gsK.setPushListener(null);
      ((m)localObject).mInited = false;
    }
  }
  
  public void setBGMNotifyListener(TXLivePusher.OnBGMNotify paramOnBGMNotify)
  {
    this.gsc.gsQ = paramOnBGMNotify;
  }
  
  public void setOnErrorListener(AppBrandLivePusherView.a parama)
  {
    this.gsf = parama;
  }
  
  public void setOnExitListener(AppBrandLivePusherView.b paramb)
  {
    this.gse = paramb;
  }
  
  public void setOnPushEventListener(ITXLivePushListener paramITXLivePushListener)
  {
    this.gsd = paramITXLivePushListener;
    this.gsc.gsL = this.gsd;
  }
  
  public void setSnapshotListener(TXLivePusher.ITXSnapshotListener paramITXSnapshotListener)
  {
    this.gsc.gsP = paramITXSnapshotListener;
  }
  
  public final void u(Bundle paramBundle)
  {
    m localm = this.gsc;
    if (paramBundle == null) {
      paramBundle = new j(-1, "invalid params");
    }
    for (;;)
    {
      y.i("MicroMsg.AppBrandLivePusherView.javayhu", "onUpdate code:%d info:%s", new Object[] { Integer.valueOf(paramBundle.errorCode), paramBundle.gst });
      return;
      m.h("updateLivePusher", paramBundle);
      if (!localm.mInited)
      {
        paramBundle = new j(-3, "uninited livePusher");
      }
      else
      {
        localm.c(paramBundle, false);
        String str = paramBundle.getString("pushUrl", localm.gsM);
        if ((str != null) && (!str.isEmpty()) && (localm.gsM != null) && (!localm.gsM.equalsIgnoreCase(str)) && (localm.gsK.isPushing()))
        {
          y.i("TXLivePusherJSAdapter.javayhu", "updateLivePusher: stopPusher");
          localm.gsK.stopCameraPreview(true);
          localm.gsK.stopPusher();
        }
        localm.gsM = str;
        localm.gsT = paramBundle.getBoolean("autopush", localm.gsT);
        if ((localm.gsT) && (localm.gsM != null) && (!localm.gsM.isEmpty()) && (!localm.gsK.isPushing()))
        {
          y.i("TXLivePusherJSAdapter.javayhu", "updateLivePusher: startPusher");
          localm.gsv.setVisibility(0);
          if (localm.gsY) {
            localm.gsK.startCameraPreview(localm.gsv);
          }
          localm.gsK.startPusher(localm.gsM);
        }
        paramBundle = new j();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.live.AppBrandLivePusherView
 * JD-Core Version:    0.7.0.1
 */