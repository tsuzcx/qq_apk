package com.tencent.kinda.framework.widget.base;

import android.view.View;
import android.view.View.OnLongClickListener;
import com.tencent.kinda.gen.KViewOnLongClickCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;

class MMKView$3
  implements View.OnLongClickListener
{
  MMKView$3(MMKView paramMMKView) {}
  
  public boolean onLongClick(View paramView)
  {
    AppMethodBeat.i(19123);
    if (MMKView.access$400(this.this$0) != null) {
      MMKView.access$400(this.this$0).onLongClick(this.this$0);
    }
    AppMethodBeat.o(19123);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.kinda.framework.widget.base.MMKView.3
 * JD-Core Version:    0.7.0.1
 */