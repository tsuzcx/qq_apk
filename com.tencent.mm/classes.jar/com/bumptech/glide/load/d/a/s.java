package com.bumptech.glide.load.d.a;

import android.annotation.TargetApi;
import android.content.res.AssetFileDescriptor;
import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import android.os.Build.VERSION;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import com.bumptech.glide.load.b.a.e;
import com.bumptech.glide.load.b.v;
import com.bumptech.glide.load.h;
import com.bumptech.glide.load.h.a;
import com.bumptech.glide.load.i;
import com.bumptech.glide.load.j;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.IOException;
import java.nio.ByteBuffer;

public final class s<T>
  implements j<T, Bitmap>
{
  public static final h<Long> aLA;
  public static final h<Integer> aLB;
  private static final b aLC;
  private final e aCj;
  private final c<T> aLD;
  private final b aLE;
  
  static
  {
    AppMethodBeat.i(77449);
    aLA = h.a("com.bumptech.glide.load.resource.bitmap.VideoBitmapDecode.TargetFrame", Long.valueOf(-1L), new h.a()
    {
      private final ByteBuffer buffer;
    });
    aLB = h.a("com.bumptech.glide.load.resource.bitmap.VideoBitmapDecode.FrameOption", Integer.valueOf(2), new h.a()
    {
      private final ByteBuffer buffer;
    });
    aLC = new b();
    AppMethodBeat.o(77449);
  }
  
  private s(e parame, c<T> paramc)
  {
    this(parame, paramc, aLC);
  }
  
  private s(e parame, c<T> paramc, b paramb)
  {
    this.aCj = parame;
    this.aLD = paramc;
    this.aLE = paramb;
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
  
  public static j<AssetFileDescriptor, Bitmap> a(e parame)
  {
    AppMethodBeat.i(77445);
    parame = new s(parame, new a((byte)0));
    AppMethodBeat.o(77445);
    return parame;
  }
  
  public static j<ParcelFileDescriptor, Bitmap> b(e parame)
  {
    AppMethodBeat.i(77446);
    parame = new s(parame, new d());
    AppMethodBeat.o(77446);
    return parame;
  }
  
  public final v<Bitmap> a(T paramT, int paramInt1, int paramInt2, i parami)
  {
    AppMethodBeat.i(77447);
    long l = ((Long)parami.a(aLA)).longValue();
    if ((l < 0L) && (l != -1L))
    {
      paramT = new IllegalArgumentException("Requested frame must be non-negative, or DEFAULT_FRAME, given: ".concat(String.valueOf(l)));
      AppMethodBeat.o(77447);
      throw paramT;
    }
    Integer localInteger = (Integer)parami.a(aLB);
    if (localInteger == null) {
      localInteger = Integer.valueOf(2);
    }
    for (;;)
    {
      parami = (g)parami.a(g.aKY);
      if (parami == null) {
        parami = g.aKX;
      }
      for (;;)
      {
        MediaMetadataRetriever localMediaMetadataRetriever = new MediaMetadataRetriever();
        try
        {
          this.aLD.a(localMediaMetadataRetriever, paramT);
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
                if (parami != g.aKW) {
                  paramT = a(localMediaMetadataRetriever, l, i, paramInt1, paramInt2, parami);
                }
              }
            }
          }
          parami = paramT;
          if (paramT == null) {
            parami = localMediaMetadataRetriever.getFrameAtTime(l, i);
          }
          localMediaMetadataRetriever.release();
          paramT = d.a(parami, this.aCj);
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
  
  public final boolean a(T paramT, i parami)
  {
    return true;
  }
  
  static final class a
    implements s.c<AssetFileDescriptor>
  {}
  
  static final class b {}
  
  static abstract interface c<T>
  {
    public abstract void a(MediaMetadataRetriever paramMediaMetadataRetriever, T paramT);
  }
  
  static final class d
    implements s.c<ParcelFileDescriptor>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.bumptech.glide.load.d.a.s
 * JD-Core Version:    0.7.0.1
 */