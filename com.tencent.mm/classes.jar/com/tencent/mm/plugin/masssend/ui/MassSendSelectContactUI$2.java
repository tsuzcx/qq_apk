package com.tencent.mm.plugin.masssend.ui;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.HeaderViewListAdapter;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.pluginsdk.ui.MultiSelectContactView;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.contact.a.a;
import com.tencent.mm.ui.contact.o;
import java.util.HashSet;

final class MassSendSelectContactUI$2
  implements View.OnClickListener
{
  MassSendSelectContactUI$2(MassSendSelectContactUI paramMassSendSelectContactUI) {}
  
  public final void onClick(View paramView)
  {
    boolean bool = false;
    AppMethodBeat.i(22875);
    ab.i("MicroMsg.MassSendSelectContactUI", "Click SelectAll");
    paramView = (o)((HeaderViewListAdapter)this.oCt.getContentLV().getAdapter()).getWrappedAdapter();
    Object localObject;
    if (!MassSendSelectContactUI.b(this.oCt))
    {
      MassSendSelectContactUI.c(this.oCt).setText(2131301523);
      int j = paramView.getCount();
      int i = 0;
      while (i < j)
      {
        localObject = paramView.Qt(i);
        if ((localObject != null) && (((a)localObject).contact != null)) {
          MassSendSelectContactUI.a(this.oCt).add(((a)localObject).contact.field_username);
        }
        i += 1;
      }
      MassSendSelectContactUI.d(this.oCt).g(MassSendSelectContactUI.a(this.oCt));
    }
    for (;;)
    {
      localObject = this.oCt;
      if (!MassSendSelectContactUI.b(this.oCt)) {
        bool = true;
      }
      MassSendSelectContactUI.a((MassSendSelectContactUI)localObject, bool);
      MassSendSelectContactUI.a(this.oCt, MassSendSelectContactUI.a(this.oCt).size());
      paramView.notifyDataSetChanged();
      AppMethodBeat.o(22875);
      return;
      MassSendSelectContactUI.c(this.oCt).setText(2131301535);
      MassSendSelectContactUI.d(this.oCt).g(new HashSet(0));
      MassSendSelectContactUI.a(this.oCt).clear();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.masssend.ui.MassSendSelectContactUI.2
 * JD-Core Version:    0.7.0.1
 */