package com.tencent.mm.plugin.cast.i;

import android.view.Surface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.cast.b.b;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/cast/utils/RecordHelper;", "", "()V", "TAG", "", "getRenderFps", "", "config", "Lcom/tencent/mm/plugin/cast/config/ScreenRecordConfig;", "getScreenBitRate", "IMediaCodecCallback", "plugin-cast_release"})
public final class d
{
  public static final d tKX;
  
  static
  {
    AppMethodBeat.i(189639);
    tKX = new d();
    AppMethodBeat.o(189639);
  }
  
  public static int a(b paramb)
  {
    AppMethodBeat.i(189634);
    p.k(paramb, "config");
    if (paramb.bitrate == 0)
    {
      e locale = e.tKY;
      paramb.bitrate = (e.cMk() * 1000);
      paramb = e.tKY;
      i = e.cMk();
      AppMethodBeat.o(189634);
      return i * 1000;
    }
    int i = paramb.bitrate;
    AppMethodBeat.o(189634);
    return i;
  }
  
  public static int b(b paramb)
  {
    AppMethodBeat.i(189636);
    p.k(paramb, "config");
    if (paramb.frameRate == 0)
    {
      AppMethodBeat.o(189636);
      return 30;
    }
    int i = paramb.frameRate;
    AppMethodBeat.o(189636);
    return i;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/cast/utils/RecordHelper$IMediaCodecCallback;", "", "onFrameDataReady", "", "byteArray", "", "onMediaCodecInitFailed", "onSurfaceReady", "surface", "Landroid/view/Surface;", "plugin-cast_release"})
  public static abstract interface a
  {
    public abstract void bs(byte[] paramArrayOfByte);
    
    public abstract void cLA();
    
    public abstract void k(Surface paramSurface);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.cast.i.d
 * JD-Core Version:    0.7.0.1
 */