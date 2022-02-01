package com.bumptech.glide.c.d.e;

import android.content.Context;
import android.graphics.Bitmap.Config;
import android.util.Log;
import com.bumptech.glide.b.d;
import com.bumptech.glide.c.f;
import com.bumptech.glide.c.k;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;

public final class a
  implements k<ByteBuffer, c>
{
  private static final a aJh;
  private static final b aJi;
  private final List<f> aCZ;
  private final b aJj;
  private final a aJk;
  private final b aJl;
  private final Context context;
  
  static
  {
    AppMethodBeat.i(77475);
    aJh = new a();
    aJi = new b();
    AppMethodBeat.o(77475);
  }
  
  public a(Context paramContext, List<f> paramList, com.bumptech.glide.c.b.a.e parame, com.bumptech.glide.c.b.a.b paramb)
  {
    this(paramContext, paramList, parame, paramb, aJi, aJh);
  }
  
  private a(Context paramContext, List<f> paramList, com.bumptech.glide.c.b.a.e parame, com.bumptech.glide.c.b.a.b paramb, b paramb1, a parama)
  {
    AppMethodBeat.i(77470);
    this.context = paramContext.getApplicationContext();
    this.aCZ = paramList;
    this.aJk = parama;
    this.aJl = new b(parame, paramb);
    this.aJj = paramb1;
    AppMethodBeat.o(77470);
  }
  
  private e a(ByteBuffer paramByteBuffer, int paramInt1, int paramInt2, d paramd, com.bumptech.glide.c.j paramj)
  {
    AppMethodBeat.i(77472);
    long l = com.bumptech.glide.h.e.pO();
    try
    {
      if (paramd.aBG == null)
      {
        paramByteBuffer = new IllegalStateException("You must call setData() before parseHeader()");
        AppMethodBeat.o(77472);
        throw paramByteBuffer;
      }
    }
    finally
    {
      if (Log.isLoggable("BufferGifDecoder", 2)) {
        new StringBuilder("Decoded GIF from stream in ").append(com.bumptech.glide.h.e.n(l));
      }
      AppMethodBeat.o(77472);
    }
    if (!paramd.nH())
    {
      paramd.nE();
      if (!paramd.nH())
      {
        paramd.nC();
        if (paramd.aBH.frameCount < 0) {
          paramd.aBH.status = 1;
        }
      }
    }
    com.bumptech.glide.b.c localc = paramd.aBH;
    if (localc.frameCount > 0)
    {
      i = localc.status;
      if (i == 0) {}
    }
    else
    {
      if (Log.isLoggable("BufferGifDecoder", 2)) {
        new StringBuilder("Decoded GIF from stream in ").append(com.bumptech.glide.h.e.n(l));
      }
      AppMethodBeat.o(77472);
      return null;
    }
    if (paramj.a(i.aID) == com.bumptech.glide.c.b.aCf)
    {
      paramd = Bitmap.Config.RGB_565;
      i = Math.min(localc.height / paramInt2, localc.width / paramInt1);
      if (i != 0) {
        break label396;
      }
    }
    label396:
    for (int i = 0;; i = Integer.highestOneBit(i))
    {
      i = Math.max(1, i);
      if ((Log.isLoggable("BufferGifDecoder", 2)) && (i > 1)) {
        new StringBuilder("Downsampling GIF, sampleSize: ").append(i).append(", target dimens: [").append(paramInt1).append("x").append(paramInt2).append("], actual dimens: [").append(localc.width).append("x").append(localc.height).append("]");
      }
      paramByteBuffer = new com.bumptech.glide.b.e(this.aJl, localc, paramByteBuffer, i);
      paramByteBuffer.a(paramd);
      paramByteBuffer.advance();
      paramd = paramByteBuffer.nB();
      if (paramd != null) {
        break label406;
      }
      if (Log.isLoggable("BufferGifDecoder", 2)) {
        new StringBuilder("Decoded GIF from stream in ").append(com.bumptech.glide.h.e.n(l));
      }
      AppMethodBeat.o(77472);
      return null;
      paramd = Bitmap.Config.ARGB_8888;
      break;
    }
    label406:
    paramj = com.bumptech.glide.c.d.b.oQ();
    paramByteBuffer = new e(new c(this.context, paramByteBuffer, paramj, paramInt1, paramInt2, paramd));
    if (Log.isLoggable("BufferGifDecoder", 2)) {
      new StringBuilder("Decoded GIF from stream in ").append(com.bumptech.glide.h.e.n(l));
    }
    AppMethodBeat.o(77472);
    return paramByteBuffer;
  }
  
  private e a(ByteBuffer paramByteBuffer, int paramInt1, int paramInt2, com.bumptech.glide.c.j paramj)
  {
    AppMethodBeat.i(77471);
    d locald = this.aJj.b(paramByteBuffer);
    try
    {
      paramByteBuffer = a(paramByteBuffer, paramInt1, paramInt2, locald, paramj);
      return paramByteBuffer;
    }
    finally
    {
      this.aJj.a(locald);
      AppMethodBeat.o(77471);
    }
  }
  
  static final class a {}
  
  static final class b
  {
    private final Queue<d> aGt;
    
    b()
    {
      AppMethodBeat.i(77467);
      this.aGt = com.bumptech.glide.h.j.dy(0);
      AppMethodBeat.o(77467);
    }
    
    final void a(d paramd)
    {
      try
      {
        AppMethodBeat.i(77469);
        paramd.aBG = null;
        paramd.aBH = null;
        this.aGt.offer(paramd);
        AppMethodBeat.o(77469);
        return;
      }
      finally
      {
        paramd = finally;
        throw paramd;
      }
    }
    
    final d b(ByteBuffer paramByteBuffer)
    {
      try
      {
        AppMethodBeat.i(77468);
        d locald2 = (d)this.aGt.poll();
        d locald1 = locald2;
        if (locald2 == null) {
          locald1 = new d();
        }
        locald1.aBG = null;
        Arrays.fill(locald1.aBF, (byte)0);
        locald1.aBH = new com.bumptech.glide.b.c();
        locald1.blockSize = 0;
        locald1.aBG = paramByteBuffer.asReadOnlyBuffer();
        locald1.aBG.position(0);
        locald1.aBG.order(ByteOrder.LITTLE_ENDIAN);
        AppMethodBeat.o(77468);
        return locald1;
      }
      finally {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.bumptech.glide.c.d.e.a
 * JD-Core Version:    0.7.0.1
 */