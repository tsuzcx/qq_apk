package com.tencent.mm.emoji.decode;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.f;
import d.g.b.k;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/emoji/decode/MMBitmapDecoder;", "Lcom/tencent/mm/emoji/decode/IGIFDecoder;", "bytes", "", "([B)V", "bitmap", "Landroid/graphics/Bitmap;", "(Landroid/graphics/Bitmap;)V", "lastValidFrame", "decodeNextFrame", "", "destroy", "drawFrameBitmap", "", "frameCount", "", "frameHeight", "frameTime", "frameWidth", "getFrame", "seekTo", "timeMs", "", "plugin-emojisdk_release"})
public final class e
  implements d
{
  private Bitmap fOF;
  
  public e(Bitmap paramBitmap)
  {
    AppMethodBeat.i(105368);
    Bitmap localBitmap = paramBitmap;
    if (paramBitmap == null)
    {
      localBitmap = Bitmap.createBitmap(1, 1, Bitmap.Config.ARGB_8888);
      k.g(localBitmap, "Bitmap.createBitmap(1, 1, Bitmap.Config.ARGB_8888)");
    }
    this.fOF = localBitmap;
    this.fOF.setDensity(320);
    AppMethodBeat.o(105368);
  }
  
  public e(byte[] paramArrayOfByte)
  {
    this(f.ck(paramArrayOfByte));
    AppMethodBeat.i(105369);
    AppMethodBeat.o(105369);
  }
  
  public final void abQ() {}
  
  public final Bitmap abR()
  {
    return this.fOF;
  }
  
  public final int abS()
  {
    return 1;
  }
  
  public final int abT()
  {
    return 2147483647;
  }
  
  public final int abU()
  {
    AppMethodBeat.i(105366);
    int i = this.fOF.getWidth();
    AppMethodBeat.o(105366);
    return i;
  }
  
  public final int abV()
  {
    AppMethodBeat.i(105367);
    int i = this.fOF.getHeight();
    AppMethodBeat.o(105367);
    return i;
  }
  
  public final void destroy() {}
  
  public final void seekTo(long paramLong) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.emoji.decode.e
 * JD-Core Version:    0.7.0.1
 */