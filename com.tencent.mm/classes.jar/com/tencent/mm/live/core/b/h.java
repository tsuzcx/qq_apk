package com.tencent.mm.live.core.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.live.core.c.b;
import com.tencent.mm.media.i.b.d;
import com.tencent.mm.media.i.b.f;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.av.a;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/live/core/render/LiveVisitorRenderer;", "", "userId", "", "streamType", "", "(Ljava/lang/String;I)V", "drawHeight", "drawWidth", "mCost", "", "mFps", "mRendererAnchorTimerCount", "Lcom/tencent/mm/sdk/platformtools/MTimerHandler;", "renderType", "getStreamType", "()I", "setStreamType", "(I)V", "textureRenderProc", "Lcom/tencent/mm/media/render/proc/GLTextureRenderProcTexture;", "getUserId", "()Ljava/lang/String;", "setUserId", "(Ljava/lang/String;)V", "yuvRenderProc", "Lcom/tencent/mm/media/render/proc/GLTextureRenderProcI420ToRgb;", "release", "", "render", "frame", "Lcom/tencent/trtc/TRTCCloudDef$TRTCVideoFrame;", "updateDrawSize", "width", "height", "Companion", "plugin-core_release"})
public final class h
{
  public static final a qUl;
  int guK;
  int guL;
  int qST;
  d qUb;
  f qUg;
  av qUj;
  long qUk;
  private int streamType;
  private String userId;
  int zyg;
  
  static
  {
    AppMethodBeat.i(205792);
    qUl = new a((byte)0);
    AppMethodBeat.o(205792);
  }
  
  public h(String paramString, int paramInt)
  {
    AppMethodBeat.i(205791);
    this.userId = paramString;
    this.streamType = paramInt;
    this.zyg = 1;
    this.qUj = new av("LiveVisitorRendererCounter", (av.a)new b(this), true);
    AppMethodBeat.o(205791);
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/live/core/render/LiveVisitorRenderer$Companion;", "", "()V", "RENDER_TYPE_I420", "", "RENDER_TYPE_TEXTURE", "TAG", "", "plugin-core_release"})
  public static final class a {}
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "onTimerExpired"})
  static final class b
    implements av.a
  {
    b(h paramh) {}
    
    public final boolean onTimerExpired()
    {
      AppMethodBeat.i(205790);
      if (h.a(this.qUm) <= 5) {
        b.dqi();
      }
      for (;;)
      {
        b.Dd(h.a(this.qUm));
        h.b(this.qUm);
        AppMethodBeat.o(205790);
        return true;
        if (h.a(this.qUm) <= 10) {
          b.dPs();
        } else if (h.a(this.qUm) > 10) {
          b.dQX();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.live.core.b.h
 * JD-Core Version:    0.7.0.1
 */