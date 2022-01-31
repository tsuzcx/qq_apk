package com.tencent.kinda.framework.widget.base;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.kinda.gen.KViewOnClickCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;

class MMKView$2
  implements View.OnClickListener
{
  MMKView$2(MMKView paramMMKView) {}
  
  public void onClick(View paramView)
  {
    AppMethodBeat.i(144963);
    if (MMKView.access$300(this.this$0) != null) {
      MMKView.access$300(this.this$0).onClick(this.this$0);
    }
    AppMethodBeat.o(144963);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.kinda.framework.widget.base.MMKView.2
 * JD-Core Version:    0.7.0.1
 */