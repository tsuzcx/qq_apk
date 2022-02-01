package com.tencent.mm.live.core.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.live.core.c.c;
import com.tencent.mm.media.j.b.d;
import com.tencent.mm.media.j.b.e;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/live/core/render/LiveVisitorRenderer;", "", "userId", "", "streamType", "", "(Ljava/lang/String;I)V", "drawHeight", "drawWidth", "mCost", "", "mFps", "mRendererAnchorTimerCount", "Lcom/tencent/mm/sdk/platformtools/MTimerHandler;", "renderMode", "renderType", "getStreamType", "()I", "setStreamType", "(I)V", "textureRenderProc", "Lcom/tencent/mm/media/render/proc/GLTextureRenderProcTexture;", "getUserId", "()Ljava/lang/String;", "setUserId", "(Ljava/lang/String;)V", "yuvRenderProc", "Lcom/tencent/mm/media/render/proc/GLTextureRenderProcI420ToRgb;", "release", "", "render", "frame", "Lcom/tencent/trtc/TRTCCloudDef$TRTCVideoFrame;", "updateDrawSize", "width", "height", "updateRenderMode", "Companion", "plugin-core_release"})
public final class l
{
  public static final a ksy;
  int ksc;
  int ksn;
  int ksr;
  e kss;
  d kst;
  int ksu;
  int ksv;
  MTimerHandler ksw;
  long ksx;
  private int streamType;
  private String userId;
  
  static
  {
    AppMethodBeat.i(200153);
    ksy = new a((byte)0);
    AppMethodBeat.o(200153);
  }
  
  public l(String paramString, int paramInt)
  {
    AppMethodBeat.i(200151);
    this.userId = paramString;
    this.streamType = paramInt;
    this.ksr = 1;
    this.ksn = 2;
    this.ksw = new MTimerHandler("LiveVisitorRendererCounter", (MTimerHandler.CallBack)new b(this), true);
    AppMethodBeat.o(200151);
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/live/core/render/LiveVisitorRenderer$Companion;", "", "()V", "RENDER_TYPE_I420", "", "RENDER_TYPE_TEXTURE", "TAG", "", "plugin-core_release"})
  public static final class a {}
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "onTimerExpired"})
  static final class b
    implements MTimerHandler.CallBack
  {
    b(l paraml) {}
    
    public final boolean onTimerExpired()
    {
      AppMethodBeat.i(199031);
      if (l.a(this.ksz) <= 5) {
        c.aNf();
      }
      for (;;)
      {
        c.tu(l.a(this.ksz));
        l.b(this.ksz);
        AppMethodBeat.o(199031);
        return true;
        if (l.a(this.ksz) <= 10) {
          c.aNg();
        } else if (l.a(this.ksz) > 10) {
          c.aNh();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.live.core.b.l
 * JD-Core Version:    0.7.0.1
 */