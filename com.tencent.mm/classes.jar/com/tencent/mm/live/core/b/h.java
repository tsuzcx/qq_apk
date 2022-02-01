package com.tencent.mm.live.core.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.live.core.c.b;
import com.tencent.mm.media.i.b.d;
import com.tencent.mm.media.i.b.e;
import com.tencent.mm.sdk.platformtools.au;
import com.tencent.mm.sdk.platformtools.au.a;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/live/core/render/LiveVisitorRenderer;", "", "userId", "", "streamType", "", "(Ljava/lang/String;I)V", "drawHeight", "drawWidth", "mCost", "", "mFps", "mRendererAnchorTimerCount", "Lcom/tencent/mm/sdk/platformtools/MTimerHandler;", "renderType", "getStreamType", "()I", "setStreamType", "(I)V", "textureRenderProc", "Lcom/tencent/mm/media/render/proc/GLTextureRenderProcTexture;", "getUserId", "()Ljava/lang/String;", "setUserId", "(Ljava/lang/String;)V", "yuvRenderProc", "Lcom/tencent/mm/media/render/proc/GLTextureRenderProcI420ToRgb;", "release", "", "render", "frame", "Lcom/tencent/trtc/TRTCCloudDef$TRTCVideoFrame;", "updateDrawSize", "width", "height", "Companion", "plugin-core_release"})
public final class h
{
  public static final h.a grZ;
  int grG;
  int grS;
  e grT;
  d grU;
  int grV;
  int grW;
  au grX;
  long grY;
  private int streamType;
  private String userId;
  
  static
  {
    AppMethodBeat.i(209330);
    grZ = new h.a((byte)0);
    AppMethodBeat.o(209330);
  }
  
  public h(String paramString, int paramInt)
  {
    AppMethodBeat.i(209329);
    this.userId = paramString;
    this.streamType = paramInt;
    this.grS = 1;
    this.grX = new au("LiveVisitorRendererCounter", (au.a)new b(this), true);
    AppMethodBeat.o(209329);
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "onTimerExpired"})
  static final class b
    implements au.a
  {
    b(h paramh) {}
    
    public final boolean onTimerExpired()
    {
      AppMethodBeat.i(209328);
      if (h.a(this.gsa) <= 5) {
        b.ajR();
      }
      for (;;)
      {
        b.mL(h.a(this.gsa));
        h.b(this.gsa);
        AppMethodBeat.o(209328);
        return true;
        if (h.a(this.gsa) <= 10) {
          b.ajS();
        } else if (h.a(this.gsa) > 10) {
          b.ajT();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.live.core.b.h
 * JD-Core Version:    0.7.0.1
 */