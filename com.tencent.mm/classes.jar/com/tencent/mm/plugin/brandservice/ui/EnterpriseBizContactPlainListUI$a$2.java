package com.tencent.mm.plugin.brandservice.ui;

import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.kernel.g;
import com.tencent.mm.n.a;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;

final class EnterpriseBizContactPlainListUI$a$2
  implements Runnable
{
  EnterpriseBizContactPlainListUI$a$2(EnterpriseBizContactPlainListUI.a parama) {}
  
  public final void run()
  {
    AppMethodBeat.i(13986);
    this.jUD.Kv();
    TextView localTextView = (TextView)this.jUD.jUA.findViewById(2131823734);
    if ((EnterpriseBizContactPlainListUI.a(this.jUD.jUA) != null) && (localTextView != null))
    {
      ad localad = ((j)g.E(j.class)).YA().arw(EnterpriseBizContactPlainListUI.c(this.jUD.jUA));
      if ((localad != null) && (a.je(localad.field_type))) {
        break label123;
      }
      EnterpriseBizContactPlainListUI.a(this.jUD.jUA).setVisibility(8);
      localTextView.setVisibility(0);
    }
    for (;;)
    {
      this.jUD.notifyDataSetChanged();
      AppMethodBeat.o(13986);
      return;
      label123:
      if (EnterpriseBizContactPlainListUI.d(this.jUD.jUA).getCount() <= 0)
      {
        EnterpriseBizContactPlainListUI.a(this.jUD.jUA).setVisibility(8);
        localTextView.setVisibility(0);
      }
      else
      {
        EnterpriseBizContactPlainListUI.a(this.jUD.jUA).setVisibility(0);
        localTextView.setVisibility(8);
        EnterpriseBizContactPlainListUI.a(this.jUD.jUA).setAdapter(EnterpriseBizContactPlainListUI.d(this.jUD.jUA));
        EnterpriseBizContactPlainListUI.a(this.jUD.jUA).setOnItemClickListener(EnterpriseBizContactPlainListUI.e(this.jUD.jUA));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.EnterpriseBizContactPlainListUI.a.2
 * JD-Core Version:    0.7.0.1
 */