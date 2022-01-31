package com.tencent.mm.plugin.fav.ui.gallery;

import android.support.v7.widget.RecyclerView.v;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class f$1
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  f$1(f paramf, RecyclerView.v paramv) {}
  
  public final void onGlobalLayout()
  {
    AppMethodBeat.i(74565);
    ((f.d)this.acv).mCy.getViewTreeObserver().removeOnGlobalLayoutListener(this);
    ((f.d)this.acv).mCA.setLayoutParams(new RelativeLayout.LayoutParams(((f.d)this.acv).mCy.getWidth(), ((f.d)this.acv).mCy.getHeight()));
    AppMethodBeat.o(74565);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.gallery.f.1
 * JD-Core Version:    0.7.0.1
 */