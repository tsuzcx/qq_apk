package com.tencent.mm.plugin.card.ui.view;

import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.card.d.c;
import com.tencent.mm.plugin.card.d.d;
import com.tencent.mm.plugin.card.d.l;
import com.tencent.mm.ui.MMActivity;

final class n$1
  implements View.OnClickListener
{
  n$1(n paramn, ViewGroup paramViewGroup) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(88762);
    paramView = (Button)this.kBq.findViewById(2131822023);
    View localView = this.kBq.findViewById(2131822019);
    if ((paramView.getVisibility() == 0) && (localView.getVisibility() == 0))
    {
      AppMethodBeat.o(88762);
      return;
    }
    if (localView.getVisibility() == 0)
    {
      if (!l.isNetworkAvailable(this.kBr.jpX.getContext()))
      {
        d.a(this.kBr.jpX, this.kBr.jpX.getString(2131297910), false);
        AppMethodBeat.o(88762);
        return;
      }
      localView.setVisibility(8);
      this.kBq.findViewById(2131822018).setVisibility(0);
    }
    this.kBr.kBe.d(c.kCb);
    AppMethodBeat.o(88762);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.view.n.1
 * JD-Core Version:    0.7.0.1
 */