package com.tencent.mm.plugin.appbrand.ui.recents;

import android.content.Context;
import android.view.View;
import android.view.ViewParent;
import com.tencent.mm.ui.widget.b.a;

final class e$d$1
  extends a
{
  e$d$1(e.d paramd, Context paramContext)
  {
    super(paramContext);
  }
  
  public final boolean ch(int paramInt1, int paramInt2)
  {
    if (this.hih.aie.getParent() != null) {
      this.hih.aie.getParent().requestDisallowInterceptTouchEvent(true);
    }
    return super.ch(paramInt1, paramInt2);
  }
  
  public final void onDismiss()
  {
    if (this.hih.aie.getParent() != null) {
      this.hih.aie.getParent().requestDisallowInterceptTouchEvent(false);
    }
    super.onDismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.recents.e.d.1
 * JD-Core Version:    0.7.0.1
 */