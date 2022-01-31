package com.tencent.mm.emoji.decode;

import a.f.b.j;
import a.l;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/emoji/decode/EmptyDecoder;", "Lcom/tencent/mm/emoji/decode/IGIFDecoder;", "()V", "TAG", "", "emptyFrame", "Landroid/graphics/Bitmap;", "decodeNextFrame", "", "destroy", "drawFrameBitmap", "", "bitmap", "frameCount", "", "frameHeight", "frameTime", "frameWidth", "getFrame", "plugin-emojisdk_release"})
public final class a
  implements b
{
  private final String TAG;
  private Bitmap eva;
  
  public a()
  {
    AppMethodBeat.i(63136);
    this.TAG = "MicroMsg.EmptyDecoder";
    ab.w(this.TAG, "init: should not call this, something error");
    Bitmap localBitmap = Bitmap.createBitmap(1, 1, Bitmap.Config.ARGB_8888);
    j.p(localBitmap, "Bitmap.createBitmap(1, 1, Bitmap.Config.ARGB_8888)");
    this.eva = localBitmap;
    AppMethodBeat.o(63136);
  }
  
  public final void Om() {}
  
  public final Bitmap On()
  {
    return this.eva;
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
    AppMethodBeat.i(63134);
    int i = this.eva.getWidth();
    AppMethodBeat.o(63134);
    return i;
  }
  
  public final int Or()
  {
    AppMethodBeat.i(63135);
    int i = this.eva.getHeight();
    AppMethodBeat.o(63135);
    return i;
  }
  
  public final void destroy() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.emoji.decode.a
 * JD-Core Version:    0.7.0.1
 */