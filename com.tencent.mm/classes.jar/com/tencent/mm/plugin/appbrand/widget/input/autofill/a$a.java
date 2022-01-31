package com.tencent.mm.plugin.appbrand.widget.input.autofill;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.luggage.l.a.a.c;
import com.tencent.luggage.l.a.a.d;
import com.tencent.mm.plugin.appbrand.widget.input.aa;
import com.tencent.mm.plugin.appbrand.widget.input.d.a.b;

final class a$a
  implements View.OnClickListener
{
  View aie;
  View eYp;
  TextView hwG;
  TextView hwH;
  View hwI;
  a.b hwJ;
  
  a$a(a parama, View paramView)
  {
    this.aie = paramView;
    this.hwG = ((TextView)paramView.findViewById(a.d.title));
    this.hwH = ((TextView)paramView.findViewById(a.d.content));
    this.hwI = paramView.findViewById(a.d.close);
    this.eYp = paramView.findViewById(a.d.divider);
    paramView.setBackgroundResource(a.c.popup_menu_selector);
    paramView.setOnClickListener(this);
    this.hwI.setOnClickListener(this);
  }
  
  public final void onClick(View paramView)
  {
    if (this.hwJ != null)
    {
      if (paramView.getId() != a.d.close) {
        break label61;
      }
      this.hwF.remove(this.hwJ);
      if (a.a(this.hwF) != null) {
        a.a(this.hwF).a(this.hwJ.id, h.a.hxp);
      }
    }
    label61:
    do
    {
      do
      {
        return;
      } while ((paramView != this.aie) || (a.a(this.hwF) == null));
      if (this.hwJ != null) {
        a.a(this.hwF).a(this.hwJ.id, h.a.hxq);
      }
      a.c(this.hwF);
    } while (a.d(this.hwF) == null);
    a.d(this.hwF).hwK.getView().clearFocus();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.autofill.a.a
 * JD-Core Version:    0.7.0.1
 */