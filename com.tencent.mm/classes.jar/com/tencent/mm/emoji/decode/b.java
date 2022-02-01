package com.tencent.mm.emoji.decode;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/emoji/decode/EmptyDecoder;", "Lcom/tencent/mm/emoji/decode/IGIFDecoder;", "()V", "TAG", "", "emptyFrame", "Landroid/graphics/Bitmap;", "decodeNextFrame", "", "destroy", "drawFrameBitmap", "", "bitmap", "frameCount", "", "frameHeight", "frameTime", "frameWidth", "getFrame", "seekTo", "timeMs", "", "plugin-emojisdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  implements d
{
  private final String TAG;
  private Bitmap mfk;
  
  public b()
  {
    AppMethodBeat.i(105365);
    this.TAG = "MicroMsg.EmptyDecoder";
    Log.w(this.TAG, "init: should not call this, something error");
    Bitmap localBitmap = Bitmap.createBitmap(1, 1, Bitmap.Config.ARGB_8888);
    s.s(localBitmap, "createBitmap(1, 1, Bitmap.Config.ARGB_8888)");
    this.mfk = localBitmap;
    AppMethodBeat.o(105365);
  }
  
  public final void aUe() {}
  
  public final int aUf()
  {
    return 1;
  }
  
  public final int aUg()
  {
    return 2147483647;
  }
  
  public final int aUh()
  {
    AppMethodBeat.i(105363);
    int i = this.mfk.getWidth();
    AppMethodBeat.o(105363);
    return i;
  }
  
  public final int aUi()
  {
    AppMethodBeat.i(105364);
    int i = this.mfk.getHeight();
    AppMethodBeat.o(105364);
    return i;
  }
  
  public final void destroy() {}
  
  public final Bitmap getFrame()
  {
    return this.mfk;
  }
  
  public final void seekTo(long paramLong) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.emoji.decode.b
 * JD-Core Version:    0.7.0.1
 */