package com.tencent.mm.plugin.appbrand.widget.b;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.ArrayList;
import java.util.LinkedList;

final class c$2
  implements View.OnClickListener
{
  c$2(c paramc, LinkedList paramLinkedList, c.a parama, b paramb) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(102350);
    paramView = new ArrayList();
    int i = 0;
    while (i < this.hDM.size())
    {
      if ((((c.c)this.hDM.get(i)).state == 2) || (((c.c)this.hDM.get(i)).state == 3)) {
        paramView.add(((c.c)this.hDM.get(i)).scope);
      }
      i += 1;
    }
    ab.i("MicroMsg.AppBrandAuthorizeDialog", "stev rejectButton click!");
    this.jjb.b(2, paramView);
    this.jjc.dismiss();
    AppMethodBeat.o(102350);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.b.c.2
 * JD-Core Version:    0.7.0.1
 */