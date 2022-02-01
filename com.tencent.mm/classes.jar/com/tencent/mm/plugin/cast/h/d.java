package com.tencent.mm.plugin.cast.h;

import android.view.Surface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.cast.a.b;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/cast/utils/RecordHelper;", "", "()V", "TAG", "", "getRenderFps", "", "config", "Lcom/tencent/mm/plugin/cast/config/ScreenRecordConfig;", "getScreenBitRate", "IMediaCodecCallback", "plugin-cast_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d
{
  public static final d wOm;
  
  static
  {
    AppMethodBeat.i(274209);
    wOm = new d();
    AppMethodBeat.o(274209);
  }
  
  public static int a(b paramb)
  {
    AppMethodBeat.i(274194);
    s.u(paramb, "config");
    if (paramb.bitrate == 0)
    {
      e locale = e.wOn;
      paramb.bitrate = (e.dpO() * 1000);
      paramb = e.wOn;
      i = e.dpO();
      AppMethodBeat.o(274194);
      return i * 1000;
    }
    int i = paramb.bitrate;
    AppMethodBeat.o(274194);
    return i;
  }
  
  public static int b(b paramb)
  {
    AppMethodBeat.i(274201);
    s.u(paramb, "config");
    if (paramb.frameRate == 0)
    {
      AppMethodBeat.o(274201);
      return 30;
    }
    int i = paramb.frameRate;
    AppMethodBeat.o(274201);
    return i;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/cast/utils/RecordHelper$IMediaCodecCallback;", "", "onFrameDataReady", "", "byteArray", "", "onMediaCodecInitFailed", "onSurfaceReady", "surface", "Landroid/view/Surface;", "plugin-cast_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract interface a
  {
    public abstract void bs(byte[] paramArrayOfByte);
    
    public abstract void dph();
    
    public abstract void o(Surface paramSurface);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.cast.h.d
 * JD-Core Version:    0.7.0.1
 */