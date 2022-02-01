package com.tencent.mm.live.core.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.live.core.c.b;
import com.tencent.mm.media.j.b.d;
import com.tencent.mm.media.j.b.e;
import com.tencent.mm.sdk.platformtools.aw;
import com.tencent.mm.sdk.platformtools.aw.a;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/live/core/render/LiveVisitorRenderer;", "", "userId", "", "streamType", "", "(Ljava/lang/String;I)V", "drawHeight", "drawWidth", "mCost", "", "mFps", "mRendererAnchorTimerCount", "Lcom/tencent/mm/sdk/platformtools/MTimerHandler;", "renderType", "getStreamType", "()I", "setStreamType", "(I)V", "textureRenderProc", "Lcom/tencent/mm/media/render/proc/GLTextureRenderProcTexture;", "getUserId", "()Ljava/lang/String;", "setUserId", "(Ljava/lang/String;)V", "yuvRenderProc", "Lcom/tencent/mm/media/render/proc/GLTextureRenderProcI420ToRgb;", "release", "", "render", "frame", "Lcom/tencent/trtc/TRTCCloudDef$TRTCVideoFrame;", "updateDrawSize", "width", "height", "Companion", "plugin-core_release"})
public final class h
{
  public static final h.a gOq;
  int gNX;
  int gOj;
  e gOk;
  d gOl;
  int gOm;
  int gOn;
  aw gOo;
  long gOp;
  private int streamType;
  private String userId;
  
  static
  {
    AppMethodBeat.i(197000);
    gOq = new h.a((byte)0);
    AppMethodBeat.o(197000);
  }
  
  public h(String paramString, int paramInt)
  {
    AppMethodBeat.i(196999);
    this.userId = paramString;
    this.streamType = paramInt;
    this.gOj = 1;
    this.gOo = new aw("LiveVisitorRendererCounter", (aw.a)new b(this), true);
    AppMethodBeat.o(196999);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "onTimerExpired"})
  static final class b
    implements aw.a
  {
    b(h paramh) {}
    
    public final boolean onTimerExpired()
    {
      AppMethodBeat.i(196998);
      if (h.a(this.gOr) <= 5) {
        b.amS();
      }
      for (;;)
      {
        b.nn(h.a(this.gOr));
        h.b(this.gOr);
        AppMethodBeat.o(196998);
        return true;
        if (h.a(this.gOr) <= 10) {
          b.amT();
        } else if (h.a(this.gOr) > 10) {
          b.amU();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.live.core.b.h
 * JD-Core Version:    0.7.0.1
 */