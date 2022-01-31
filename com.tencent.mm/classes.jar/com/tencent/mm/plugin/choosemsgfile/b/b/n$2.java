package com.tencent.mm.plugin.choosemsgfile.b.b;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class n$2
  implements View.OnClickListener
{
  n$2(n paramn) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(54332);
    paramView = (a)paramView.getTag();
    if (paramView == null)
    {
      AppMethodBeat.o(54332);
      return;
    }
    if (!this.kFq.kFl.isChecked()) {}
    for (boolean bool = true;; bool = false)
    {
      if (paramView.isEnable())
      {
        this.kFq.kFl.setChecked(bool);
        paramView.a(bool, paramView, this.kFq);
      }
      AppMethodBeat.o(54332);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.choosemsgfile.b.b.n.2
 * JD-Core Version:    0.7.0.1
 */