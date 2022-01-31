package com.tencent.mm.plugin.fav.ui;

import android.graphics.Bitmap;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.aca;
import com.tencent.mm.sdk.platformtools.al;

final class l$6
  implements Runnable
{
  l$6(String paramString, int paramInt1, int paramInt2, com.tencent.mm.plugin.fav.a.g paramg, aca paramaca, boolean paramBoolean, ImageView paramImageView) {}
  
  public final void run()
  {
    AppMethodBeat.i(74198);
    Bitmap localBitmap = l.b(this.val$path, this.myC, this.myD, false);
    if (localBitmap == null)
    {
      l.c(this.msL, this.mxT, this.myB);
      AppMethodBeat.o(74198);
      return;
    }
    String str = (String)this.lHj.getTag();
    if ((str != null) && (str.equals(this.val$path)))
    {
      com.tencent.mm.kernel.g.RO();
      al.d(new l.6.1(this, localBitmap));
    }
    AppMethodBeat.o(74198);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.l.6
 * JD-Core Version:    0.7.0.1
 */