package com.tencent.mm.emoji.decode;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/emoji/decode/MMBitmapDecoder;", "Lcom/tencent/mm/emoji/decode/IGIFDecoder;", "bytes", "", "([B)V", "bitmap", "Landroid/graphics/Bitmap;", "(Landroid/graphics/Bitmap;)V", "lastValidFrame", "decodeNextFrame", "", "destroy", "drawFrameBitmap", "", "frameCount", "", "frameHeight", "frameTime", "frameWidth", "getFrame", "seekTo", "timeMs", "", "plugin-emojisdk_release"})
public final class e
  implements d
{
  private Bitmap gUK;
  
  public e(Bitmap paramBitmap)
  {
    AppMethodBeat.i(105368);
    Bitmap localBitmap = paramBitmap;
    if (paramBitmap == null)
    {
      localBitmap = Bitmap.createBitmap(1, 1, Bitmap.Config.ARGB_8888);
      p.g(localBitmap, "Bitmap.createBitmap(1, 1, Bitmap.Config.ARGB_8888)");
    }
    this.gUK = localBitmap;
    this.gUK.setDensity(320);
    AppMethodBeat.o(105368);
  }
  
  public e(byte[] paramArrayOfByte)
  {
    this(BitmapUtil.decodeByteArray(paramArrayOfByte));
    AppMethodBeat.i(105369);
    AppMethodBeat.o(105369);
  }
  
  public final void auo() {}
  
  public final int aup()
  {
    return 1;
  }
  
  public final int auq()
  {
    return 2147483647;
  }
  
  public final int aur()
  {
    AppMethodBeat.i(105366);
    int i = this.gUK.getWidth();
    AppMethodBeat.o(105366);
    return i;
  }
  
  public final int aus()
  {
    AppMethodBeat.i(105367);
    int i = this.gUK.getHeight();
    AppMethodBeat.o(105367);
    return i;
  }
  
  public final void destroy() {}
  
  public final Bitmap getFrame()
  {
    return this.gUK;
  }
  
  public final void seekTo(long paramLong) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.emoji.decode.e
 * JD-Core Version:    0.7.0.1
 */