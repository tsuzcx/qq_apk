package com.tencent.kinda.framework.widget.base;

import android.view.View;
import android.view.View.OnLongClickListener;
import com.tencent.kinda.gen.KViewOnLongClickCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

class MMKView$3
  implements View.OnLongClickListener
{
  private byte _hellAccFlag_;
  
  MMKView$3(MMKView paramMMKView) {}
  
  public boolean onLongClick(View paramView)
  {
    AppMethodBeat.i(19123);
    b localb = new b();
    localb.bd(paramView);
    a.b("com/tencent/kinda/framework/widget/base/MMKView$3", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, localb.ahF());
    if (MMKView.access$600(this.this$0) != null) {
      MMKView.access$600(this.this$0).onLongClick(this.this$0);
    }
    a.a(false, this, "com/tencent/kinda/framework/widget/base/MMKView$3", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
    AppMethodBeat.o(19123);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.kinda.framework.widget.base.MMKView.3
 * JD-Core Version:    0.7.0.1
 */