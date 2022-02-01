package com.tencent.mm.plugin.cast.c;

import android.media.MediaCodec.BufferInfo;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.e.f;
import com.tencent.mm.media.e.g;
import com.tencent.mm.plugin.cast.i.d.a;
import com.tencent.mm.plugin.cast.i.e;
import com.tencent.mm.sdk.platformtools.Log;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import kotlin.g.a.m;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/cast/encoder/ScreenCastVideoEncoder;", "", "encodeConfig", "Lcom/tencent/mm/plugin/cast/config/ScreenRecordConfig;", "init", "Lcom/tencent/mm/plugin/cast/utils/RecordHelper$IMediaCodecCallback;", "(Lcom/tencent/mm/plugin/cast/config/ScreenRecordConfig;Lcom/tencent/mm/plugin/cast/utils/RecordHelper$IMediaCodecCallback;)V", "getEncodeConfig", "()Lcom/tencent/mm/plugin/cast/config/ScreenRecordConfig;", "setEncodeConfig", "(Lcom/tencent/mm/plugin/cast/config/ScreenRecordConfig;)V", "encoder", "Lcom/tencent/mm/media/encoder/IMediaCodecTransEncoder;", "getInit", "()Lcom/tencent/mm/plugin/cast/utils/RecordHelper$IMediaCodecCallback;", "setInit", "(Lcom/tencent/mm/plugin/cast/utils/RecordHelper$IMediaCodecCallback;)V", "mEncoderFirstTime", "", "outputStream", "Ljava/io/FileOutputStream;", "onEncodeData", "", "onEncodeInit", "codec", "onEncodedSample", "info", "Landroid/media/MediaCodec$BufferInfo;", "encodeData", "Ljava/nio/ByteBuffer;", "startRecord", "stopRecord", "Companion", "plugin-cast_release"})
public final class c
{
  public static final c.a tJd;
  public com.tencent.mm.media.e.b kWH;
  private FileOutputStream outputStream;
  private long tJa;
  private com.tencent.mm.plugin.cast.b.b tJb;
  private d.a tJc;
  
  static
  {
    AppMethodBeat.i(189916);
    tJd = new c.a((byte)0);
    AppMethodBeat.o(189916);
  }
  
  public c(com.tencent.mm.plugin.cast.b.b paramb, d.a parama)
  {
    AppMethodBeat.i(189914);
    this.tJb = paramb;
    this.tJc = parama;
    this.tJa = -1L;
    parama = this.tJb;
    if (parama != null) {}
    try
    {
      if (com.tencent.mm.compatible.util.d.qV(23))
      {
        paramb = e.tKY;
        if (!e.cMe()) {}
      }
      for (paramb = (com.tencent.mm.media.e.b)new g((com.tencent.mm.media.b.d)parama, (kotlin.g.a.b)new b(this));; paramb = (com.tencent.mm.media.e.b)new f((com.tencent.mm.media.b.d)parama, (kotlin.g.a.b)new c(this)))
      {
        this.kWH = paramb;
        AppMethodBeat.o(189914);
        return;
      }
      AppMethodBeat.o(189914);
      return;
    }
    catch (Exception paramb)
    {
      Log.printErrStackTrace("MicroMsg.ScreenCastVideoEncoder", (Throwable)paramb, "encoder  error", new Object[0]);
      if (parama != null) {}
      for (;;)
      {
        try
        {
          int i = (int)(720.0F * (parama.targetWidth / parama.targetHeight));
          parama.targetHeight = 720;
          parama.targetWidth = (i / 16 * 16);
          paramb = e.tKY;
          parama.bitrate = (e.cMk() * 1000);
          paramb = e.tKY;
          parama.kSh = e.cMl();
          if (parama == null) {
            break;
          }
          if (com.tencent.mm.compatible.util.d.qV(23))
          {
            paramb = e.tKY;
            if (e.cMe())
            {
              paramb = (com.tencent.mm.media.e.b)new g((com.tencent.mm.media.b.d)parama, (kotlin.g.a.b)new d(this));
              this.kWH = paramb;
              AppMethodBeat.o(189914);
              return;
            }
          }
        }
        catch (Exception paramb)
        {
          Log.printErrStackTrace("MicroMsg.ScreenCastVideoEncoder", (Throwable)paramb, "still happened crash %s", new Object[] { String.valueOf(parama) });
          paramb = com.tencent.mm.plugin.cast.g.a.tKa;
          com.tencent.mm.plugin.cast.g.a.cLT();
          this.tJc.cLA();
          AppMethodBeat.o(189914);
          return;
        }
        paramb = (com.tencent.mm.media.e.b)new f((com.tencent.mm.media.b.d)parama, (kotlin.g.a.b)new e(this));
      }
      AppMethodBeat.o(189914);
    }
  }
  
  public final void stopRecord()
  {
    AppMethodBeat.i(189902);
    Object localObject = this.kWH;
    if (localObject != null) {
      ((com.tencent.mm.media.e.b)localObject).aUy();
    }
    localObject = this.outputStream;
    if (localObject != null) {
      try
      {
        ((FileOutputStream)localObject).close();
        AppMethodBeat.o(189902);
        return;
      }
      catch (IOException localIOException)
      {
        Throwable localThrowable = (Throwable)new RuntimeException((Throwable)localIOException);
        AppMethodBeat.o(189902);
        throw localThrowable;
      }
    }
    AppMethodBeat.o(189902);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "Lcom/tencent/mm/media/encoder/IMediaCodecTransEncoder;", "invoke", "com/tencent/mm/plugin/cast/encoder/ScreenCastVideoEncoder$startRecord$1$1"})
  static final class b
    extends q
    implements kotlin.g.a.b<com.tencent.mm.media.e.b, x>
  {
    b(c paramc)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "Lcom/tencent/mm/media/encoder/IMediaCodecTransEncoder;", "invoke", "com/tencent/mm/plugin/cast/encoder/ScreenCastVideoEncoder$startRecord$1$2"})
  static final class c
    extends q
    implements kotlin.g.a.b<com.tencent.mm.media.e.b, x>
  {
    c(c paramc)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "Lcom/tencent/mm/media/encoder/IMediaCodecTransEncoder;", "invoke", "com/tencent/mm/plugin/cast/encoder/ScreenCastVideoEncoder$startRecord$2$1"})
  static final class d
    extends q
    implements kotlin.g.a.b<com.tencent.mm.media.e.b, x>
  {
    d(c paramc)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "Lcom/tencent/mm/media/encoder/IMediaCodecTransEncoder;", "invoke", "com/tencent/mm/plugin/cast/encoder/ScreenCastVideoEncoder$startRecord$2$2"})
  static final class e
    extends q
    implements kotlin.g.a.b<com.tencent.mm.media.e.b, x>
  {
    e(c paramc)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.cast.c.c
 * JD-Core Version:    0.7.0.1
 */