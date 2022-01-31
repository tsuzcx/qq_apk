package com.tencent.mm.plugin.fav.ui.gallery;

import android.widget.ImageView;
import android.widget.PopupWindow.OnDismissListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class f$d$4$1
  implements PopupWindow.OnDismissListener
{
  f$d$4$1(f.d.4 param4) {}
  
  public final void onDismiss()
  {
    AppMethodBeat.i(74572);
    if ((this.mCG.mCF.mCA != null) && (!this.mCG.mCF.mCs.mCr)) {
      this.mCG.mCF.mCA.setVisibility(8);
    }
    AppMethodBeat.o(74572);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.gallery.f.d.4.1
 * JD-Core Version:    0.7.0.1
 */