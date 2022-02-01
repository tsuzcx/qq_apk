package com.tencent.mm.plugin.flutter.voip.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.voip.model.x;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/flutter/voip/service/ClearFlutterEngineOnShutdown;", "Lcom/tencent/mm/plugin/voip/model/VoipUiCallBacks;", "engineId", "", "(Ljava/lang/String;)V", "adjustHWViewAspectRatio", "", "w", "", "h", "onAccept", "onConnected", "onError", "errCode", "errMsg", "onNewSimulCallAutoAccept", "callType", "onNoResp", "onPreConnect", "onPretreatmentForStartDev", "onReject", "onRemoteOrientationChanged", "orientation", "onRemoteVoipModeChanged", "cmd", "onRoomReady", "onSessionBeingCalled", "onShutDown", "withTip", "", "onStartRecordFailed", "onStartTalk", "onVideoDecodeReady", "outlen", "outData", "", "", "requestRender", "setHWDecMode", "mode", "setSpatiotemporalDenosing", "setSurfaceTexture", "texture", "Landroid/graphics/SurfaceTexture;", "texId", "Lcom/tencent/mm/media/globject/GLTextureObject;", "setVoipBeauty", "showRikTips", "tips", "totalDeviceNearTime", "", "uninitGLRender", "Companion", "plugin-flutter-voip_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  implements x
{
  public static final a.a HnF;
  private final String engineId;
  
  static
  {
    AppMethodBeat.i(263389);
    HnF = new a.a((byte)0);
    AppMethodBeat.o(263389);
  }
  
  public a(String paramString)
  {
    AppMethodBeat.i(263384);
    this.engineId = paramString;
    AppMethodBeat.o(263384);
  }
  
  public final void VQ(int paramInt) {}
  
  public final void VR(int paramInt) {}
  
  public final void VS(int paramInt) {}
  
  public final void VT(int paramInt) {}
  
  public final void aDH(String paramString) {}
  
  public final void c(int paramInt1, int paramInt2, byte[] paramArrayOfByte) {}
  
  public final void fvW() {}
  
  public final void fwd() {}
  
  public final void fwi() {}
  
  public final void fwj() {}
  
  public final void fwk() {}
  
  public final void fwl() {}
  
  public final void fwm() {}
  
  public final long fwn()
  {
    return 0L;
  }
  
  public final void iS(int paramInt1, int paramInt2) {}
  
  public final void onConnected() {}
  
  public final void onError(int paramInt, String paramString) {}
  
  public final void setHWDecMode(int paramInt) {}
  
  public final void setSpatiotemporalDenosing(int paramInt) {}
  
  public final void setVoipBeauty(int paramInt) {}
  
  public final void vI(boolean paramBoolean)
  {
    AppMethodBeat.i(263445);
    Log.i("MicroMsg.ClearFlutterEngineOnShutdown", "onShutDown: " + paramBoolean + ", engineId=" + this.engineId);
    Object localObject = b.HnG;
    b.dispose();
    localObject = com.tencent.mm.plugin.flutter.b.b.Hke;
    com.tencent.mm.plugin.flutter.b.b.clear(this.engineId);
    AppMethodBeat.o(263445);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.flutter.voip.c.a
 * JD-Core Version:    0.7.0.1
 */