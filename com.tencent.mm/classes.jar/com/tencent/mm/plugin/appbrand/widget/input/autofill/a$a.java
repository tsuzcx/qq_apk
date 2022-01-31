package com.tencent.mm.plugin.appbrand.widget.input.autofill;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.widget.input.ab;
import com.tencent.mm.plugin.appbrand.widget.input.d.a.b;

final class a$a
  implements View.OnClickListener
{
  View aku;
  View gqg;
  TextView joQ;
  TextView joR;
  View joS;
  a.b joT;
  
  a$a(a parama, View paramView)
  {
    AppMethodBeat.i(123873);
    this.aku = paramView;
    this.joQ = ((TextView)paramView.findViewById(2131820680));
    this.joR = ((TextView)paramView.findViewById(2131820946));
    this.joS = paramView.findViewById(2131821244);
    this.gqg = paramView.findViewById(2131821148);
    paramView.setBackgroundResource(2130839962);
    paramView.setOnClickListener(this);
    this.joS.setOnClickListener(this);
    AppMethodBeat.o(123873);
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(123874);
    if (this.joT != null) {
      if (paramView.getId() == 2131821244)
      {
        this.joP.remove(this.joT);
        if (a.a(this.joP) != null)
        {
          a.a(this.joP).a(this.joT.id, h.a.jpz);
          AppMethodBeat.o(123874);
        }
      }
      else if ((paramView == this.aku) && (a.a(this.joP) != null))
      {
        if (this.joT != null) {
          a.a(this.joP).a(this.joT.id, h.a.jpA);
        }
        a.c(this.joP);
        if (a.d(this.joP) != null) {
          a.d(this.joP).joU.getView().clearFocus();
        }
      }
    }
    AppMethodBeat.o(123874);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.autofill.a.a
 * JD-Core Version:    0.7.0.1
 */