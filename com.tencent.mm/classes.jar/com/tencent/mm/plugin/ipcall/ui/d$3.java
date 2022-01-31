package com.tencent.mm.plugin.ipcall.ui;

import android.graphics.Bitmap;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.ipcall.b.a;
import com.tencent.mm.sdk.platformtools.az.a;

final class d$3
  implements az.a
{
  d$3(d paramd, String paramString1, ImageView paramImageView, String paramString2) {}
  
  public final boolean acS()
  {
    AppMethodBeat.i(22018);
    Bitmap localBitmap = a.aH(this.nRw.context, this.nRv);
    d.a(this.nRw, this.mPw, this.val$key, localBitmap);
    AppMethodBeat.o(22018);
    return true;
  }
  
  public final boolean acT()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.d.3
 * JD-Core Version:    0.7.0.1
 */