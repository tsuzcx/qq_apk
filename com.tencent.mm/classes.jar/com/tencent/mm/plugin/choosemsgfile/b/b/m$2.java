package com.tencent.mm.plugin.choosemsgfile.b.b;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class m$2
  implements View.OnClickListener
{
  m$2(m paramm) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(54328);
    paramView = (a)paramView.getTag();
    if (paramView == null)
    {
      AppMethodBeat.o(54328);
      return;
    }
    boolean bool;
    if (!this.kFo.kFl.isChecked()) {
      bool = true;
    }
    while (paramView.isEnable())
    {
      this.kFo.kFl.setChecked(bool);
      paramView.a(bool, paramView, this.kFo);
      if (!bool)
      {
        this.kFo.kFk.setVisibility(0);
        AppMethodBeat.o(54328);
        return;
        bool = false;
      }
      else
      {
        this.kFo.kFk.setVisibility(8);
      }
    }
    AppMethodBeat.o(54328);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.choosemsgfile.b.b.m.2
 * JD-Core Version:    0.7.0.1
 */