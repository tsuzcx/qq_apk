package com.tencent.mm.live.core.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.j.b.d;
import com.tencent.mm.media.j.b.e;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/live/core/render/LiveVisitorRenderer;", "", "userId", "", "streamType", "", "(Ljava/lang/String;I)V", "drawHeight", "drawWidth", "mCost", "", "mFps", "mRendererAnchorTimerCount", "Lcom/tencent/mm/sdk/platformtools/MTimerHandler;", "renderMode", "renderType", "getStreamType", "()I", "setStreamType", "(I)V", "textureRenderProc", "Lcom/tencent/mm/media/render/proc/GLTextureRenderProcTexture;", "getUserId", "()Ljava/lang/String;", "setUserId", "(Ljava/lang/String;)V", "yuvRenderProc", "Lcom/tencent/mm/media/render/proc/GLTextureRenderProcI420ToRgb;", "release", "", "render", "frame", "Lcom/tencent/trtc/TRTCCloudDef$TRTCVideoFrame;", "updateDrawSize", "width", "height", "updateRenderMode", "Companion", "plugin-core_release"})
public final class j
{
  public static final j.a hEt;
  int hDX;
  int hEi;
  int hEm;
  e hEn;
  d hEo;
  int hEp;
  int hEq;
  MTimerHandler hEr;
  long hEs;
  private int streamType;
  private String userId;
  
  static
  {
    AppMethodBeat.i(196688);
    hEt = new j.a((byte)0);
    AppMethodBeat.o(196688);
  }
  
  public j(String paramString, int paramInt)
  {
    AppMethodBeat.i(196687);
    this.userId = paramString;
    this.streamType = paramInt;
    this.hEm = 1;
    this.hEi = 2;
    this.hEr = new MTimerHandler("LiveVisitorRendererCounter", (MTimerHandler.CallBack)new j.b(this), true);
    AppMethodBeat.o(196687);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.live.core.b.j
 * JD-Core Version:    0.7.0.1
 */