package com.bumptech.glide.c.d.a;

import android.annotation.TargetApi;
import android.content.res.AssetFileDescriptor;
import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import android.os.Build.VERSION;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import com.bumptech.glide.c.b.a.e;
import com.bumptech.glide.c.b.u;
import com.bumptech.glide.c.i;
import com.bumptech.glide.c.i.a;
import com.bumptech.glide.c.j;
import com.bumptech.glide.c.k;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.IOException;
import java.nio.ByteBuffer;

public final class r<T>
  implements k<T, Bitmap>
{
  public static final i<Long> aLI;
  public static final i<Integer> aLJ;
  private static final b aLK;
  private final e aCk;
  private final r.c<T> aLL;
  private final b aLM;
  
  static
  {
    AppMethodBeat.i(77449);
    aLI = i.a("com.bumptech.glide.load.resource.bitmap.VideoBitmapDecode.TargetFrame", Long.valueOf(-1L), new i.a()
    {
      private final ByteBuffer buffer;
    });
    aLJ = i.a("com.bumptech.glide.load.resource.bitmap.VideoBitmapDecode.FrameOption", Integer.valueOf(2), new i.a()
    {
      private final ByteBuffer buffer;
    });
    aLK = new b();
    AppMethodBeat.o(77449);
  }
  
  private r(e parame, r.c<T> paramc)
  {
    this(parame, paramc, aLK);
  }
  
  private r(e parame, r.c<T> paramc, b paramb)
  {
    this.aCk = parame;
    this.aLL = paramc;
    this.aLM = paramb;
  }
  
  @TargetApi(27)
  private static Bitmap a(MediaMetadataRetriever paramMediaMetadataRetriever, long paramLong, int paramInt1, int paramInt2, int paramInt3, g paramg)
  {
    AppMethodBeat.i(77448);
    label133:
    for (;;)
    {
      try
      {
        i = Integer.parseInt(paramMediaMetadataRetriever.extractMetadata(18));
        j = Integer.parseInt(paramMediaMetadataRetriever.extractMetadata(19));
        k = Integer.parseInt(paramMediaMetadataRetriever.extractMetadata(24));
        if (k == 90) {
          break label133;
        }
        if (k != 270) {
          break label118;
        }
      }
      catch (Throwable paramMediaMetadataRetriever)
      {
        float f;
        Log.isLoggable("VideoDecoder", 3);
        AppMethodBeat.o(77448);
        return null;
      }
      f = paramg.l(j, i, paramInt2, paramInt3);
      paramMediaMetadataRetriever = paramMediaMetadataRetriever.getScaledFrameAtTime(paramLong, paramInt1, Math.round(j * f), Math.round(i * f));
      AppMethodBeat.o(77448);
      return paramMediaMetadataRetriever;
      label118:
      int k = i;
      int i = j;
      int j = k;
    }
  }
  
  public static k<AssetFileDescriptor, Bitmap> a(e parame)
  {
    AppMethodBeat.i(77445);
    parame = new r(parame, new r.a((byte)0));
    AppMethodBeat.o(77445);
    return parame;
  }
  
  public static k<ParcelFileDescriptor, Bitmap> b(e parame)
  {
    AppMethodBeat.i(77446);
    parame = new r(parame, new d());
    AppMethodBeat.o(77446);
    return parame;
  }
  
  public final u<Bitmap> a(T paramT, int paramInt1, int paramInt2, j paramj)
  {
    AppMethodBeat.i(77447);
    long l = ((Long)paramj.a(aLI)).longValue();
    if ((l < 0L) && (l != -1L))
    {
      paramT = new IllegalArgumentException("Requested frame must be non-negative, or DEFAULT_FRAME, given: ".concat(String.valueOf(l)));
      AppMethodBeat.o(77447);
      throw paramT;
    }
    Integer localInteger = (Integer)paramj.a(aLJ);
    if (localInteger == null) {
      localInteger = Integer.valueOf(2);
    }
    for (;;)
    {
      paramj = (g)paramj.a(g.aLg);
      if (paramj == null) {
        paramj = g.aLf;
      }
      for (;;)
      {
        MediaMetadataRetriever localMediaMetadataRetriever = new MediaMetadataRetriever();
        try
        {
          this.aLL.a(localMediaMetadataRetriever, paramT);
          int i = localInteger.intValue();
          localInteger = null;
          paramT = localInteger;
          if (Build.VERSION.SDK_INT >= 27)
          {
            paramT = localInteger;
            if (paramInt1 != -2147483648)
            {
              paramT = localInteger;
              if (paramInt2 != -2147483648)
              {
                paramT = localInteger;
                if (paramj != g.aLe) {
                  paramT = a(localMediaMetadataRetriever, l, i, paramInt1, paramInt2, paramj);
                }
              }
            }
          }
          paramj = paramT;
          if (paramT == null) {
            paramj = localMediaMetadataRetriever.getFrameAtTime(l, i);
          }
          localMediaMetadataRetriever.release();
          paramT = d.a(paramj, this.aCk);
          AppMethodBeat.o(77447);
          return paramT;
        }
        catch (RuntimeException paramT)
        {
          paramT = new IOException(paramT);
          AppMethodBeat.o(77447);
          throw paramT;
        }
        finally
        {
          localMediaMetadataRetriever.release();
          AppMethodBeat.o(77447);
        }
      }
    }
  }
  
  public final boolean a(T paramT, j paramj)
  {
    return true;
  }
  
  static final class b {}
  
  static final class d
    implements r.c<ParcelFileDescriptor>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.bumptech.glide.c.d.a.r
 * JD-Core Version:    0.7.0.1
 */