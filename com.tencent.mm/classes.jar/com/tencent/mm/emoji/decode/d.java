package com.tencent.mm.emoji.decode;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.f;
import d.g.b.k;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/emoji/decode/MMBitmapDecoder;", "Lcom/tencent/mm/emoji/decode/IGIFDecoder;", "bytes", "", "([B)V", "bitmap", "Landroid/graphics/Bitmap;", "(Landroid/graphics/Bitmap;)V", "lastValidFrame", "decodeNextFrame", "", "destroy", "drawFrameBitmap", "", "frameCount", "", "frameHeight", "frameTime", "frameWidth", "getFrame", "seekTo", "timeMs", "", "plugin-emojisdk_release"})
public final class d
  implements c
{
  private Bitmap fKU;
  
  public d(Bitmap paramBitmap)
  {
    AppMethodBeat.i(105368);
    Bitmap localBitmap = paramBitmap;
    if (paramBitmap == null)
    {
      localBitmap = Bitmap.createBitmap(1, 1, Bitmap.Config.ARGB_8888);
      k.g(localBitmap, "Bitmap.createBitmap(1, 1, Bitmap.Config.ARGB_8888)");
    }
    this.fKU = localBitmap;
    this.fKU.setDensity(320);
    AppMethodBeat.o(105368);
  }
  
  public d(byte[] paramArrayOfByte)
  {
    this(f.cl(paramArrayOfByte));
    AppMethodBeat.i(105369);
    AppMethodBeat.o(105369);
  }
  
  public final void aaR() {}
  
  public final Bitmap aaS()
  {
    return this.fKU;
  }
  
  public final int aaT()
  {
    return 1;
  }
  
  public final int aaU()
  {
    return 2147483647;
  }
  
  public final int aaV()
  {
    AppMethodBeat.i(105366);
    int i = this.fKU.getWidth();
    AppMethodBeat.o(105366);
    return i;
  }
  
  public final int aaW()
  {
    AppMethodBeat.i(105367);
    int i = this.fKU.getHeight();
    AppMethodBeat.o(105367);
    return i;
  }
  
  public final void destroy() {}
  
  public final void seekTo(long paramLong) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.emoji.decode.d
 * JD-Core Version:    0.7.0.1
 */