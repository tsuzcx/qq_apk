package com.tencent.mm.live.core.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.live.core.c.b;
import com.tencent.mm.media.j.b.d;
import com.tencent.mm.media.j.b.e;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.av.a;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/live/core/render/LiveVisitorRenderer;", "", "userId", "", "streamType", "", "(Ljava/lang/String;I)V", "drawHeight", "drawWidth", "mCost", "", "mFps", "mRendererAnchorTimerCount", "Lcom/tencent/mm/sdk/platformtools/MTimerHandler;", "renderType", "getStreamType", "()I", "setStreamType", "(I)V", "textureRenderProc", "Lcom/tencent/mm/media/render/proc/GLTextureRenderProcTexture;", "getUserId", "()Ljava/lang/String;", "setUserId", "(Ljava/lang/String;)V", "yuvRenderProc", "Lcom/tencent/mm/media/render/proc/GLTextureRenderProcI420ToRgb;", "release", "", "render", "frame", "Lcom/tencent/trtc/TRTCCloudDef$TRTCVideoFrame;", "updateDrawSize", "width", "height", "Companion", "plugin-core_release"})
public final class h
{
  public static final h.a gLH;
  int gLA;
  e gLB;
  d gLC;
  int gLD;
  int gLE;
  av gLF;
  long gLG;
  int gLo;
  private int streamType;
  private String userId;
  
  static
  {
    AppMethodBeat.i(216988);
    gLH = new h.a((byte)0);
    AppMethodBeat.o(216988);
  }
  
  public h(String paramString, int paramInt)
  {
    AppMethodBeat.i(216987);
    this.userId = paramString;
    this.streamType = paramInt;
    this.gLA = 1;
    this.gLF = new av("LiveVisitorRendererCounter", (av.a)new b(this), true);
    AppMethodBeat.o(216987);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "onTimerExpired"})
  static final class b
    implements av.a
  {
    b(h paramh) {}
    
    public final boolean onTimerExpired()
    {
      AppMethodBeat.i(216986);
      if (h.a(this.gLI) <= 5) {
        b.amD();
      }
      for (;;)
      {
        b.nk(h.a(this.gLI));
        h.b(this.gLI);
        AppMethodBeat.o(216986);
        return true;
        if (h.a(this.gLI) <= 10) {
          b.amE();
        } else if (h.a(this.gLI) > 10) {
          b.amF();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.live.core.b.h
 * JD-Core Version:    0.7.0.1
 */