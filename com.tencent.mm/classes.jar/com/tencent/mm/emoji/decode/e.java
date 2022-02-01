package com.tencent.mm.emoji.decode;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.h;
import d.g.b.p;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/emoji/decode/MMBitmapDecoder;", "Lcom/tencent/mm/emoji/decode/IGIFDecoder;", "bytes", "", "([B)V", "bitmap", "Landroid/graphics/Bitmap;", "(Landroid/graphics/Bitmap;)V", "lastValidFrame", "decodeNextFrame", "", "destroy", "drawFrameBitmap", "", "frameCount", "", "frameHeight", "frameTime", "frameWidth", "getFrame", "seekTo", "timeMs", "", "plugin-emojisdk_release"})
public final class e
  implements d
{
  private Bitmap gkx;
  
  public e(Bitmap paramBitmap)
  {
    AppMethodBeat.i(105368);
    Bitmap localBitmap = paramBitmap;
    if (paramBitmap == null)
    {
      localBitmap = Bitmap.createBitmap(1, 1, Bitmap.Config.ARGB_8888);
      p.g(localBitmap, "Bitmap.createBitmap(1, 1, Bitmap.Config.ARGB_8888)");
    }
    this.gkx = localBitmap;
    this.gkx.setDensity(320);
    AppMethodBeat.o(105368);
  }
  
  public e(byte[] paramArrayOfByte)
  {
    this(h.cu(paramArrayOfByte));
    AppMethodBeat.i(105369);
    AppMethodBeat.o(105369);
  }
  
  public final void aeG() {}
  
  public final Bitmap aeH()
  {
    return this.gkx;
  }
  
  public final int aeI()
  {
    return 1;
  }
  
  public final int aeJ()
  {
    return 2147483647;
  }
  
  public final int aeK()
  {
    AppMethodBeat.i(105366);
    int i = this.gkx.getWidth();
    AppMethodBeat.o(105366);
    return i;
  }
  
  public final int aeL()
  {
    AppMethodBeat.i(105367);
    int i = this.gkx.getHeight();
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