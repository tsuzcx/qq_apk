package com.tencent.mm.emoji.decode;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/emoji/decode/EmptyDecoder;", "Lcom/tencent/mm/emoji/decode/IGIFDecoder;", "()V", "TAG", "", "emptyFrame", "Landroid/graphics/Bitmap;", "decodeNextFrame", "", "destroy", "drawFrameBitmap", "", "bitmap", "frameCount", "", "frameHeight", "frameTime", "frameWidth", "getFrame", "seekTo", "timeMs", "", "plugin-emojisdk_release"})
public final class b
  implements d
{
  private final String TAG;
  private Bitmap gUG;
  
  public b()
  {
    AppMethodBeat.i(105365);
    this.TAG = "MicroMsg.EmptyDecoder";
    Log.w(this.TAG, "init: should not call this, something error");
    Bitmap localBitmap = Bitmap.createBitmap(1, 1, Bitmap.Config.ARGB_8888);
    p.g(localBitmap, "Bitmap.createBitmap(1, 1, Bitmap.Config.ARGB_8888)");
    this.gUG = localBitmap;
    AppMethodBeat.o(105365);
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
    AppMethodBeat.i(105363);
    int i = this.gUG.getWidth();
    AppMethodBeat.o(105363);
    return i;
  }
  
  public final int aus()
  {
    AppMethodBeat.i(105364);
    int i = this.gUG.getHeight();
    AppMethodBeat.o(105364);
    return i;
  }
  
  public final void destroy() {}
  
  public final Bitmap getFrame()
  {
    return this.gUG;
  }
  
  public final void seekTo(long paramLong) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.emoji.decode.b
 * JD-Core Version:    0.7.0.1
 */