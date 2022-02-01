package com.tencent.mm.plugin.cast.b;

import android.media.MediaCodec.BufferInfo;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.e.f;
import com.tencent.mm.plugin.cast.h.d.a;
import com.tencent.mm.sdk.platformtools.Log;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.m;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/cast/encoder/ScreenCastVideoEncoder;", "", "encodeConfig", "Lcom/tencent/mm/plugin/cast/config/ScreenRecordConfig;", "init", "Lcom/tencent/mm/plugin/cast/utils/RecordHelper$IMediaCodecCallback;", "(Lcom/tencent/mm/plugin/cast/config/ScreenRecordConfig;Lcom/tencent/mm/plugin/cast/utils/RecordHelper$IMediaCodecCallback;)V", "getEncodeConfig", "()Lcom/tencent/mm/plugin/cast/config/ScreenRecordConfig;", "setEncodeConfig", "(Lcom/tencent/mm/plugin/cast/config/ScreenRecordConfig;)V", "encoder", "Lcom/tencent/mm/media/encoder/IMediaCodecTransEncoder;", "getInit", "()Lcom/tencent/mm/plugin/cast/utils/RecordHelper$IMediaCodecCallback;", "setInit", "(Lcom/tencent/mm/plugin/cast/utils/RecordHelper$IMediaCodecCallback;)V", "mEncoderFirstTime", "", "outputStream", "Ljava/io/FileOutputStream;", "onEncodeData", "", "onEncodeInit", "codec", "onEncodedSample", "info", "Landroid/media/MediaCodec$BufferInfo;", "encodeData", "Ljava/nio/ByteBuffer;", "startRecord", "stopRecord", "Companion", "plugin-cast_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
{
  public static final b.a wMG;
  public com.tencent.mm.media.e.b nCh;
  private FileOutputStream outputStream;
  private com.tencent.mm.plugin.cast.a.b wMH;
  private d.a wMI;
  private long wMJ;
  
  static
  {
    AppMethodBeat.i(274275);
    wMG = new b.a((byte)0);
    AppMethodBeat.o(274275);
  }
  
  public b(com.tencent.mm.plugin.cast.a.b paramb, d.a parama)
  {
    AppMethodBeat.i(274248);
    this.wMH = paramb;
    this.wMI = parama;
    this.wMJ = -1L;
    parama = this.wMH;
    if (parama != null) {
      try
      {
        if (com.tencent.mm.compatible.util.d.rb(23))
        {
          paramb = com.tencent.mm.plugin.cast.h.e.wOn;
          if (!com.tencent.mm.plugin.cast.h.e.dpI()) {}
        }
        for (paramb = (com.tencent.mm.media.e.b)new f((com.tencent.mm.media.b.d)parama, (kotlin.g.a.b)new b(this));; paramb = (com.tencent.mm.media.e.b)new com.tencent.mm.media.e.e((com.tencent.mm.media.b.d)parama, (kotlin.g.a.b)new c(this)))
        {
          this.nCh = paramb;
          AppMethodBeat.o(274248);
          return;
        }
        int i;
        return;
      }
      catch (Exception paramb)
      {
        Log.printErrStackTrace("MicroMsg.ScreenCastVideoEncoder", (Throwable)paramb, "encoder  error", new Object[0]);
        if (parama != null) {}
        try
        {
          i = (int)(720.0F * (parama.nxO / parama.nxP));
          parama.nxP = 720;
          parama.nxO = (i / 16 * 16);
          paramb = com.tencent.mm.plugin.cast.h.e.wOn;
          parama.bitrate = (com.tencent.mm.plugin.cast.h.e.dpO() * 1000);
          paramb = com.tencent.mm.plugin.cast.h.e.wOn;
          parama.nxQ = com.tencent.mm.plugin.cast.h.e.dpP();
          if (parama != null)
          {
            if (com.tencent.mm.compatible.util.d.rb(23))
            {
              paramb = com.tencent.mm.plugin.cast.h.e.wOn;
              if (!com.tencent.mm.plugin.cast.h.e.dpI()) {}
            }
            for (paramb = (com.tencent.mm.media.e.b)new f((com.tencent.mm.media.b.d)parama, (kotlin.g.a.b)new d(this));; paramb = (com.tencent.mm.media.e.b)new com.tencent.mm.media.e.e((com.tencent.mm.media.b.d)parama, (kotlin.g.a.b)new e(this)))
            {
              this.nCh = paramb;
              AppMethodBeat.o(274248);
              return;
            }
          }
          AppMethodBeat.o(274248);
        }
        catch (Exception paramb)
        {
          Log.printErrStackTrace("MicroMsg.ScreenCastVideoEncoder", (Throwable)paramb, "still happened crash %s", new Object[] { String.valueOf(parama) });
          paramb = com.tencent.mm.plugin.cast.f.a.wNt;
          com.tencent.mm.plugin.cast.f.a.dpz();
          this.wMI.dph();
        }
      }
    }
  }
  
  public final void stopRecord()
  {
    AppMethodBeat.i(274280);
    Object localObject = this.nCh;
    if (localObject != null) {
      ((com.tencent.mm.media.e.b)localObject).bpa();
    }
    localObject = this.outputStream;
    if (localObject != null) {
      try
      {
        ((FileOutputStream)localObject).close();
        AppMethodBeat.o(274280);
        return;
      }
      catch (IOException localIOException)
      {
        RuntimeException localRuntimeException = new RuntimeException((Throwable)localIOException);
        AppMethodBeat.o(274280);
        throw localRuntimeException;
      }
    }
    AppMethodBeat.o(274280);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Lcom/tencent/mm/media/encoder/IMediaCodecTransEncoder;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.b<com.tencent.mm.media.e.b, ah>
  {
    b(b paramb)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Lcom/tencent/mm/media/encoder/IMediaCodecTransEncoder;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements kotlin.g.a.b<com.tencent.mm.media.e.b, ah>
  {
    c(b paramb)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Lcom/tencent/mm/media/encoder/IMediaCodecTransEncoder;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements kotlin.g.a.b<com.tencent.mm.media.e.b, ah>
  {
    d(b paramb)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Lcom/tencent/mm/media/encoder/IMediaCodecTransEncoder;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends u
    implements kotlin.g.a.b<com.tencent.mm.media.e.b, ah>
  {
    e(b paramb)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.cast.b.b
 * JD-Core Version:    0.7.0.1
 */