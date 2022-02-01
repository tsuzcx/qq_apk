package com.tencent.mm.plugin.gallery.ui;

import android.graphics.Rect;
import android.view.TouchDelegate;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cb.a;

final class a$a$1
  implements Runnable
{
  a$a$1(a.a parama, View paramView1, View paramView2) {}
  
  public final void run()
  {
    AppMethodBeat.i(111390);
    Rect localRect = new Rect();
    this.tWu.getHitRect(localRect);
    localRect.left -= a.fromDPToPix(this.tWu.getContext(), 20);
    localRect.top -= a.fromDPToPix(this.tWu.getContext(), 20);
    localRect.right += a.fromDPToPix(this.tWu.getContext(), 20);
    localRect.bottom += a.fromDPToPix(this.tWu.getContext(), 20);
    this.val$parent.setTouchDelegate(new TouchDelegate(localRect, this.tWu));
    AppMethodBeat.o(111390);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.ui.a.a.1
 * JD-Core Version:    0.7.0.1
 */