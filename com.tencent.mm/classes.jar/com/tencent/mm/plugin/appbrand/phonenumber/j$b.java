package com.tencent.mm.plugin.appbrand.phonenumber;

import a.l;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Iterator;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
final class j$b
  implements View.OnClickListener
{
  j$b(j paramj, PhoneItem paramPhoneItem) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(134793);
    paramView = this.iDn.iDe.iterator();
    while (paramView.hasNext()) {
      ((PhoneItem)paramView.next()).iDt = false;
    }
    this.iDk.iDt = true;
    this.iDn.notifyDataSetChanged();
    AppMethodBeat.o(134793);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.phonenumber.j.b
 * JD-Core Version:    0.7.0.1
 */