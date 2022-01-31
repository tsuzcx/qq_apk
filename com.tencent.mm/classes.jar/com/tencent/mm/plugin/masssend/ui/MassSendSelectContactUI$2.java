package com.tencent.mm.plugin.masssend.ui;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.HeaderViewListAdapter;
import android.widget.ListView;
import com.tencent.mm.R.l;
import com.tencent.mm.h.c.ao;
import com.tencent.mm.pluginsdk.ui.MultiSelectContactView;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.contact.a.a;
import com.tencent.mm.ui.contact.n;
import java.util.HashSet;
import java.util.Iterator;

final class MassSendSelectContactUI$2
  implements View.OnClickListener
{
  MassSendSelectContactUI$2(MassSendSelectContactUI paramMassSendSelectContactUI) {}
  
  public final void onClick(View paramView)
  {
    y.i("MicroMsg.MassSendSelectContactUI", "Click SelectAll");
    paramView = (n)((HeaderViewListAdapter)this.mbS.getContentLV().getAdapter()).getWrappedAdapter();
    if (!MassSendSelectContactUI.b(this.mbS))
    {
      MassSendSelectContactUI.c(this.mbS).setText(R.l.mass_send_clear_all);
      int j = paramView.getCount();
      int i = 0;
      while (i < j)
      {
        localObject = paramView.HK(i);
        if ((localObject != null) && (((a)localObject).dnp != null) && (!MassSendSelectContactUI.a(this.mbS).contains(((a)localObject).dnp.field_username)))
        {
          MassSendSelectContactUI.a(this.mbS).add(((a)localObject).dnp.field_username);
          MassSendSelectContactUI.d(this.mbS).Wv(((a)localObject).dnp.field_username);
        }
        i += 1;
      }
    }
    MassSendSelectContactUI.c(this.mbS).setText(R.l.mass_send_select_all);
    Object localObject = MassSendSelectContactUI.a(this.mbS).iterator();
    while (((Iterator)localObject).hasNext())
    {
      String str = (String)((Iterator)localObject).next();
      MassSendSelectContactUI.d(this.mbS).Wv(str);
    }
    MassSendSelectContactUI.a(this.mbS).clear();
    localObject = this.mbS;
    if (!MassSendSelectContactUI.b(this.mbS)) {}
    for (boolean bool = true;; bool = false)
    {
      MassSendSelectContactUI.a((MassSendSelectContactUI)localObject, bool);
      MassSendSelectContactUI.a(this.mbS, MassSendSelectContactUI.a(this.mbS).size());
      paramView.notifyDataSetChanged();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.masssend.ui.MassSendSelectContactUI.2
 * JD-Core Version:    0.7.0.1
 */