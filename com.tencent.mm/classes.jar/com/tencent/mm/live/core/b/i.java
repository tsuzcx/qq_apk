package com.tencent.mm.live.core.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.live.core.c.c;
import com.tencent.mm.media.j.b.d;
import com.tencent.mm.media.j.b.e;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/live/core/render/LiveVisitorRenderer;", "", "userId", "", "streamType", "", "(Ljava/lang/String;I)V", "drawHeight", "drawWidth", "mCost", "", "mFps", "mRendererAnchorTimerCount", "Lcom/tencent/mm/sdk/platformtools/MTimerHandler;", "renderMode", "renderType", "getStreamType", "()I", "setStreamType", "(I)V", "textureRenderProc", "Lcom/tencent/mm/media/render/proc/GLTextureRenderProcTexture;", "getUserId", "()Ljava/lang/String;", "setUserId", "(Ljava/lang/String;)V", "yuvRenderProc", "Lcom/tencent/mm/media/render/proc/GLTextureRenderProcI420ToRgb;", "release", "", "render", "frame", "Lcom/tencent/trtc/TRTCCloudDef$TRTCVideoFrame;", "updateDrawSize", "width", "height", "updateRenderMode", "Companion", "plugin-core_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class i
{
  public static final i.a mWj;
  int mVW;
  int mWg;
  int mWk;
  e mWl;
  d mWm;
  int mWn;
  int mWo;
  MTimerHandler mWp;
  long mWq;
  private int streamType;
  private String userId;
  
  static
  {
    AppMethodBeat.i(247690);
    mWj = new i.a((byte)0);
    AppMethodBeat.o(247690);
  }
  
  public i(String paramString, int paramInt)
  {
    AppMethodBeat.i(247669);
    this.userId = paramString;
    this.streamType = paramInt;
    this.mWk = 1;
    this.mWg = 2;
    this.mWp = new MTimerHandler("LiveVisitorRendererCounter", new i..ExternalSyntheticLambda0(this), true);
    AppMethodBeat.o(247669);
  }
  
  private static final boolean a(i parami)
  {
    AppMethodBeat.i(247683);
    s.u(parami, "this$0");
    if (parami.mVW <= 5) {
      c.bgP();
    }
    for (;;)
    {
      c.tp(parami.mVW);
      parami.mVW = 0;
      AppMethodBeat.o(247683);
      return true;
      if (parami.mVW <= 10) {
        c.bgQ();
      } else if (parami.mVW > 10) {
        c.bgR();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.live.core.b.i
 * JD-Core Version:    0.7.0.1
 */