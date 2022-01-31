package com.tencent.mm.plugin.gallery.ui;

import android.graphics.Bitmap;
import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.f;
import com.tencent.mm.plugin.gallery.model.k;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.az.a;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.HashMap;

final class d$3
  implements az.a
{
  private Bitmap nfX = null;
  
  d$3(d paramd, String paramString) {}
  
  public final boolean acS()
  {
    AppMethodBeat.i(21487);
    if ((this.nfW.nfU == null) || (TextUtils.isEmpty(this.nfY)))
    {
      AppMethodBeat.o(21487);
      return false;
    }
    String str = this.nfY;
    long l = bo.yB();
    Bitmap localBitmap = k.PC(str);
    ab.v("MicroMsg.ImageAdapter", "test decode: %d filePath:%s", new Object[] { Long.valueOf(bo.av(l)), str });
    this.nfX = localBitmap;
    AppMethodBeat.o(21487);
    return true;
  }
  
  public final boolean acT()
  {
    AppMethodBeat.i(21486);
    this.nfW.nfV = false;
    int i;
    if (this.nfW.nfO.containsKey(this.nfY))
    {
      i = ((Integer)this.nfW.nfO.get(this.nfY)).intValue();
      if (this.nfW.bEz()) {
        break label117;
      }
      this.nfW.nfQ.put(i, this.nfX);
    }
    for (;;)
    {
      this.nfW.nfR.f(this.nfY, this.nfX);
      this.nfX = null;
      this.nfW.Dh();
      AppMethodBeat.o(21486);
      return false;
      label117:
      d.a(this.nfW, i, this.nfX);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.ui.d.3
 * JD-Core Version:    0.7.0.1
 */