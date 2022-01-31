package com.tencent.mm.emoji.decode;

import a.f.b.j;
import a.l;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.d;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/emoji/decode/MMBitmapDecoder;", "Lcom/tencent/mm/emoji/decode/IGIFDecoder;", "bytes", "", "([B)V", "bitmap", "Landroid/graphics/Bitmap;", "(Landroid/graphics/Bitmap;)V", "lastValidFrame", "decodeNextFrame", "", "destroy", "drawFrameBitmap", "", "frameCount", "", "frameHeight", "frameTime", "frameWidth", "getFrame", "plugin-emojisdk_release"})
public final class c
  implements b
{
  private Bitmap evb;
  
  public c(Bitmap paramBitmap)
  {
    AppMethodBeat.i(63139);
    Bitmap localBitmap = paramBitmap;
    if (paramBitmap == null)
    {
      localBitmap = Bitmap.createBitmap(1, 1, Bitmap.Config.ARGB_8888);
      j.p(localBitmap, "Bitmap.createBitmap(1, 1, Bitmap.Config.ARGB_8888)");
    }
    this.evb = localBitmap;
    this.evb.setDensity(320);
    AppMethodBeat.o(63139);
  }
  
  public c(byte[] paramArrayOfByte)
  {
    this(d.bT(paramArrayOfByte));
    AppMethodBeat.i(63140);
    AppMethodBeat.o(63140);
  }
  
  public final void Om() {}
  
  public final Bitmap On()
  {
    return this.evb;
  }
  
  public final int Oo()
  {
    return 1;
  }
  
  public final int Op()
  {
    return 2147483647;
  }
  
  public final int Oq()
  {
    AppMethodBeat.i(63137);
    int i = this.evb.getWidth();
    AppMethodBeat.o(63137);
    return i;
  }
  
  public final int Or()
  {
    AppMethodBeat.i(63138);
    int i = this.evb.getHeight();
    AppMethodBeat.o(63138);
    return i;
  }
  
  public final void destroy() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.emoji.decode.c
 * JD-Core Version:    0.7.0.1
 */