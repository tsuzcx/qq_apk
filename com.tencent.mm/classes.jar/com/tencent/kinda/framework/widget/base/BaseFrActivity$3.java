package com.tencent.kinda.framework.widget.base;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

class BaseFrActivity$3
  implements View.OnClickListener
{
  BaseFrActivity$3(BaseFrActivity paramBaseFrActivity) {}
  
  public void onClick(View paramView)
  {
    AppMethodBeat.i(144644);
    this.this$0.hideTenpayKB();
    if (BaseFrActivity.access$000(this.this$0) != null)
    {
      BaseFrActivity.access$000(this.this$0).scrollTo(0, 0);
      BaseFrActivity.access$002(this.this$0, null);
    }
    AppMethodBeat.o(144644);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.kinda.framework.widget.base.BaseFrActivity.3
 * JD-Core Version:    0.7.0.1
 */