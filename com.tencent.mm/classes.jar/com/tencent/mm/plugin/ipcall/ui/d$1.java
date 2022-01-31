package com.tencent.mm.plugin.ipcall.ui;

import android.graphics.Bitmap;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.ipcall.b.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.az;
import com.tencent.mm.sdk.platformtools.az.a;
import java.lang.ref.WeakReference;

final class d$1
  implements az.a
{
  private boolean eLd = false;
  
  d$1(d paramd, String paramString1, String paramString2, ImageView paramImageView, String paramString3) {}
  
  public final boolean acS()
  {
    AppMethodBeat.i(22015);
    Bitmap localBitmap = a.aH(this.nRw.context, this.nRv);
    if (localBitmap != null)
    {
      this.nRw.evq.put(this.val$key, new WeakReference(localBitmap));
      this.eLd = true;
      d.a(this.nRw, this.mPw, this.val$key, localBitmap);
    }
    AppMethodBeat.o(22015);
    return true;
  }
  
  public final boolean acT()
  {
    AppMethodBeat.i(22016);
    if (!this.eLd)
    {
      d locald = this.nRw;
      String str2 = this.nRv;
      String str1 = this.efI;
      ImageView localImageView = this.mPw;
      str2 = d.eU(str2, str1);
      locald.nRu.e(new d.2(locald, str1, localImageView, str2));
    }
    AppMethodBeat.o(22016);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.d.1
 * JD-Core Version:    0.7.0.1
 */