package com.tencent.kinda.framework.widget.base;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.kinda.gen.KViewOnClickCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

class MMKView$2
  implements View.OnClickListener
{
  private byte _hellAccFlag_;
  
  MMKView$2(MMKView paramMMKView) {}
  
  public void onClick(View paramView)
  {
    AppMethodBeat.i(19122);
    b localb = new b();
    localb.bm(paramView);
    a.b("com/tencent/kinda/framework/widget/base/MMKView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
    if (MMKView.access$500(this.this$0) != null) {
      MMKView.access$500(this.this$0).onClick(this.this$0);
    }
    a.a(this, "com/tencent/kinda/framework/widget/base/MMKView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(19122);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.kinda.framework.widget.base.MMKView.2
 * JD-Core Version:    0.7.0.1
 */