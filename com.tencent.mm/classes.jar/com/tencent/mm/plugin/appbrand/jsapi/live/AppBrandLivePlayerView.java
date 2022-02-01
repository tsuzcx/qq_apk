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
  boolean ezy;
  a saM;
  a saN;
  private AppBrandLivePlayerView.c saO;
  int saP;
  private b saQ;
  
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
    this.saM = new o(paramContext, (byte)0);
    AppMethodBeat.o(145828);
  }
  
  final void jo(boolean paramBoolean)
  {
    AppMethodBeat.i(145827);
    if ((this.ezy) && (this.saO != null)) {
      this.saO.o(paramBoolean, this.saP);
    }
    AppMethodBeat.o(145827);
  }
  
  public final boolean k(String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(145824);
    paramString = this.saM.d(paramString, paramJSONObject);
    Log.i("MicroMsg.AppBrandLivePlayerView", "onOperate code:%d info:%s", new Object[] { Integer.valueOf(paramString.errorCode), paramString.errorInfo });
    if (paramString.errorCode == 0)
    {
      AppMethodBeat.o(145824);
      return true;
    }
    AppMethodBeat.o(145824);
    return false;
  }
  
  public final void my(int paramInt)
  {
    AppMethodBeat.i(145826);
    k localk = this.saM.mA(paramInt);
    Log.i("MicroMsg.AppBrandLivePlayerView", "onBackground code:%d info:%s", new Object[] { Integer.valueOf(localk.errorCode), localk.errorInfo });
    AppMethodBeat.o(145826);
  }
  
  public final void onExit()
  {
    AppMethodBeat.i(145825);
    k localk = this.saM.aue();
    Log.i("MicroMsg.AppBrandLivePlayerView", "onDestroy code:%d info:%s", new Object[] { Integer.valueOf(localk.errorCode), localk.errorInfo });
    if (this.saQ != null) {
      this.saQ.csA();
    }
    AppMethodBeat.o(145825);
  }
  
  public void setAudioVolumeEventListener(TXLivePlayer.ITXAudioVolumeEvaluationListener paramITXAudioVolumeEvaluationListener)
  {
    AppMethodBeat.i(326131);
    this.saM.setAudioVolumeListener(paramITXAudioVolumeEvaluationListener);
    AppMethodBeat.o(326131);
  }
  
  public void setExitListener(b paramb)
  {
    this.saQ = paramb;
  }
  
  public void setFullScreenDelegate(a parama)
  {
    this.saN = parama;
  }
  
  public void setNeedEvent(boolean paramBoolean)
  {
    this.ezy = paramBoolean;
  }
  
  public void setOnFullScreenChangeListener(AppBrandLivePlayerView.c paramc)
  {
    this.saO = paramc;
  }
  
  public void setPlayEventListener(ITXLivePlayListener paramITXLivePlayListener)
  {
    AppMethodBeat.i(326130);
    this.saM.setPlayListener(paramITXLivePlayListener);
    AppMethodBeat.o(326130);
  }
  
  public void setSnapshotListener(TXLivePlayer.ITXSnapshotListener paramITXSnapshotListener)
  {
    AppMethodBeat.i(326142);
    this.saM.setSnapshotListener(paramITXSnapshotListener);
    AppMethodBeat.o(326142);
  }
  
  public static abstract interface a
  {
    public abstract void AM(int paramInt);
    
    public abstract void csz();
    
    public abstract boolean isFullScreen();
  }
  
  public static abstract interface b
  {
    public abstract void csA();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.live.AppBrandLivePlayerView
 * JD-Core Version:    0.7.0.1
 */