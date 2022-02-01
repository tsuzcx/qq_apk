package com.tencent.mm.emoji.decode;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import d.g.b.p;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/emoji/decode/EmptyDecoder;", "Lcom/tencent/mm/emoji/decode/IGIFDecoder;", "()V", "TAG", "", "emptyFrame", "Landroid/graphics/Bitmap;", "decodeNextFrame", "", "destroy", "drawFrameBitmap", "", "bitmap", "frameCount", "", "frameHeight", "frameTime", "frameWidth", "getFrame", "seekTo", "timeMs", "", "plugin-emojisdk_release"})
public final class b
  implements d
{
  private final String TAG;
  private Bitmap gib;
  
  public b()
  {
    AppMethodBeat.i(105365);
    this.TAG = "MicroMsg.EmptyDecoder";
    ad.w(this.TAG, "init: should not call this, something error");
    Bitmap localBitmap = Bitmap.createBitmap(1, 1, Bitmap.Config.ARGB_8888);
    p.g(localBitmap, "Bitmap.createBitmap(1, 1, Bitmap.Config.ARGB_8888)");
    this.gib = localBitmap;
    AppMethodBeat.o(105365);
  }
  
  public final void aeu() {}
  
  public final Bitmap aev()
  {
    return this.gib;
  }
  
  public final int aew()
  {
    return 1;
  }
  
  public final int aex()
  {
    return 2147483647;
  }
  
  public final int aey()
  {
    AppMethodBeat.i(105363);
    int i = this.gib.getWidth();
    AppMethodBeat.o(105363);
    return i;
  }
  
  public final int aez()
  {
    AppMethodBeat.i(105364);
    int i = this.gib.getHeight();
    AppMethodBeat.o(105364);
    return i;
  }
  
  public final void destroy() {}
  
  public final void seekTo(long paramLong) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.emoji.decode.b
 * JD-Core Version:    0.7.0.1
 */