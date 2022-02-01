package com.tencent.kinda.framework.widget.base;

import android.view.View;
import android.view.View.OnLongClickListener;
import com.tencent.kinda.gen.KViewOnLongClickCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

class MMKView$4
  implements View.OnLongClickListener
{
  private byte _hellAccFlag_;
  
  MMKView$4(MMKView paramMMKView) {}
  
  public boolean onLongClick(View paramView)
  {
    AppMethodBeat.i(226613);
    b localb = new b();
    localb.cH(paramView);
    a.c("com/tencent/kinda/framework/widget/base/MMKView$4", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, localb.aYj());
    if (MMKView.access$700(this.this$0) != null) {
      MMKView.access$700(this.this$0).onLongClick(this.this$0);
    }
    a.a(false, this, "com/tencent/kinda/framework/widget/base/MMKView$4", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
    AppMethodBeat.o(226613);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.kinda.framework.widget.base.MMKView.4
 * JD-Core Version:    0.7.0.1
 */