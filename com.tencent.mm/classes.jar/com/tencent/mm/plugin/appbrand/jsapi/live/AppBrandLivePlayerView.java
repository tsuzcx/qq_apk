package com.tencent.mm.plugin.appbrand.jsapi.live;

import android.content.Context;
import android.util.AttributeSet;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.rtmp.ITXLivePlayListener;
import com.tencent.rtmp.TXLivePlayer.ITXAudioVolumeEvaluationListener;
import com.tencent.rtmp.TXLivePlayer.ITXSnapshotListener;
import com.tencent.rtmp.ui.TXCloudVideoView;
import org.json.JSONObject;

public class AppBrandLivePlayerView
  extends TXCloudVideoView
{
  boolean cGk;
  a oVp;
  a oVq;
  private AppBrandLivePlayerView.c oVr;
  int oVs;
  private b oVt;
  
  public AppBrandLivePlayerView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(145822);
    init(paramContext);
    AppMethodBeat.o(145822);
  }
  
  public AppBrandLivePlayerView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(145823);
    init(paramContext);
    AppMethodBeat.o(145823);
  }
  
  private void init(Context paramContext)
  {
    AppMethodBeat.i(145828);
    this.oVp = new o(paramContext, (byte)0);
    AppMethodBeat.o(145828);
  }
  
  public final void iW(int paramInt)
  {
    AppMethodBeat.i(145826);
    k localk = this.oVp.iY(paramInt);
    Log.i("MicroMsg.AppBrandLivePlayerView", "onBackground code:%d info:%s", new Object[] { Integer.valueOf(localk.errorCode), localk.errorInfo });
    AppMethodBeat.o(145826);
  }
  
  final void ik(boolean paramBoolean)
  {
    AppMethodBeat.i(145827);
    if ((this.cGk) && (this.oVr != null)) {
      this.oVr.q(paramBoolean, this.oVs);
    }
    AppMethodBeat.o(145827);
  }
  
  public final boolean j(String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(145824);
    paramString = this.oVp.d(paramString, paramJSONObject);
    Log.i("MicroMsg.AppBrandLivePlayerView", "onOperate code:%d info:%s", new Object[] { Integer.valueOf(paramString.errorCode), paramString.errorInfo });
    if (paramString.errorCode == 0)
    {
      AppMethodBeat.o(145824);
      return true;
    }
    AppMethodBeat.o(145824);
    return false;
  }
  
  public final void onExit()
  {
    AppMethodBeat.i(145825);
    k localk = this.oVp.Tz();
    Log.i("MicroMsg.AppBrandLivePlayerView", "onDestroy code:%d info:%s", new Object[] { Integer.valueOf(localk.errorCode), localk.errorInfo });
    if (this.oVt != null) {
      this.oVt.bSt();
    }
    AppMethodBeat.o(145825);
  }
  
  public void setAudioVolumeEventListener(TXLivePlayer.ITXAudioVolumeEvaluationListener paramITXAudioVolumeEvaluationListener)
  {
    AppMethodBeat.i(213024);
    this.oVp.setAudioVolumeListener(paramITXAudioVolumeEvaluationListener);
    AppMethodBeat.o(213024);
  }
  
  public void setExitListener(b paramb)
  {
    this.oVt = paramb;
  }
  
  public void setFullScreenDelegate(a parama)
  {
    this.oVq = parama;
  }
  
  public void setNeedEvent(boolean paramBoolean)
  {
    this.cGk = paramBoolean;
  }
  
  public void setOnFullScreenChangeListener(AppBrandLivePlayerView.c paramc)
  {
    this.oVr = paramc;
  }
  
  public void setPlayEventListener(ITXLivePlayListener paramITXLivePlayListener)
  {
    AppMethodBeat.i(213022);
    this.oVp.setPlayListener(paramITXLivePlayListener);
    AppMethodBeat.o(213022);
  }
  
  public void setSnapshotListener(TXLivePlayer.ITXSnapshotListener paramITXSnapshotListener)
  {
    AppMethodBeat.i(213032);
    this.oVp.setSnapshotListener(paramITXSnapshotListener);
    AppMethodBeat.o(213032);
  }
  
  public static abstract interface a
  {
    public abstract void Az(int paramInt);
    
    public abstract boolean QT();
    
    public abstract void bSs();
  }
  
  public static abstract interface b
  {
    public abstract void bSt();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.live.AppBrandLivePlayerView
 * JD-Core Version:    0.7.0.1
 */