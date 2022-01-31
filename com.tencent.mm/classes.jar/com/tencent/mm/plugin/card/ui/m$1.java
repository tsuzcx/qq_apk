package com.tencent.mm.plugin.card.ui;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.h;

final class m$1
  implements View.OnClickListener
{
  m$1(m paramm) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(88683);
    paramView = (String)paramView.getTag();
    if (!TextUtils.isEmpty(paramView))
    {
      if (!paramView.contains(";")) {
        break label96;
      }
      paramView = paramView.substring(0, paramView.indexOf(";"));
    }
    label96:
    for (;;)
    {
      h.a(m.a(this.kys), true, paramView, "", m.a(this.kys).getString(2131297891), m.a(this.kys).getString(2131298499), new m.1.1(this, paramView), null);
      AppMethodBeat.o(88683);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.m.1
 * JD-Core Version:    0.7.0.1
 */