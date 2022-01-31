package com.tencent.mm.plugin.ipcall.ui;

import android.graphics.Bitmap;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.b;
import com.tencent.mm.ah.o;
import com.tencent.mm.sdk.platformtools.az.a;

final class d$4
  implements az.a
{
  d$4(d paramd, String paramString1, ImageView paramImageView, String paramString2) {}
  
  public final boolean acS()
  {
    AppMethodBeat.i(22019);
    Bitmap localBitmap2 = b.b(this.efI, false, -1);
    Bitmap localBitmap1 = localBitmap2;
    if (localBitmap2 == null)
    {
      o.acQ();
      localBitmap1 = com.tencent.mm.ah.d.ra(this.efI);
    }
    d.a(this.nRw, this.mPw, this.val$key, localBitmap1);
    AppMethodBeat.o(22019);
    return true;
  }
  
  public final boolean acT()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.d.4
 * JD-Core Version:    0.7.0.1
 */