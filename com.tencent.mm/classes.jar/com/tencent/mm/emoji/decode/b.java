package com.tencent.mm.emoji.decode;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import d.g.b.k;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/emoji/decode/EmptyDecoder;", "Lcom/tencent/mm/emoji/decode/IGIFDecoder;", "()V", "TAG", "", "emptyFrame", "Landroid/graphics/Bitmap;", "decodeNextFrame", "", "destroy", "drawFrameBitmap", "", "bitmap", "frameCount", "", "frameHeight", "frameTime", "frameWidth", "getFrame", "seekTo", "timeMs", "", "plugin-emojisdk_release"})
public final class b
  implements c
{
  private final String TAG;
  private Bitmap fKT;
  
  public b()
  {
    AppMethodBeat.i(105365);
    this.TAG = "MicroMsg.EmptyDecoder";
    ad.w(this.TAG, "init: should not call this, something error");
    Bitmap localBitmap = Bitmap.createBitmap(1, 1, Bitmap.Config.ARGB_8888);
    k.g(localBitmap, "Bitmap.createBitmap(1, 1, Bitmap.Config.ARGB_8888)");
    this.fKT = localBitmap;
    AppMethodBeat.o(105365);
  }
  
  public final void aaR() {}
  
  public final Bitmap aaS()
  {
    return this.fKT;
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
    AppMethodBeat.i(105363);
    int i = this.fKT.getWidth();
    AppMethodBeat.o(105363);
    return i;
  }
  
  public final int aaW()
  {
    AppMethodBeat.i(105364);
    int i = this.fKT.getHeight();
    AppMethodBeat.o(105364);
    return i;
  }
  
  public final void destroy() {}
  
  public final void seekTo(long paramLong) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.emoji.decode.b
 * JD-Core Version:    0.7.0.1
 */