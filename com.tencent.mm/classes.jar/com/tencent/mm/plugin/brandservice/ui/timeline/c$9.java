package com.tencent.mm.plugin.brandservice.ui.timeline;

import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.au;
import com.tencent.mm.kernel.g;
import com.tencent.mm.n.b;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.storage.af;
import com.tencent.mm.storage.bg;
import com.tencent.mm.storage.s;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.c;

final class c$9
  implements n.c
{
  c$9(c paramc) {}
  
  public final void onCreateMMMenu(l paraml)
  {
    AppMethodBeat.i(175420);
    af localaf = ((k)g.ab(k.class)).apM().aHY(this.mXd.mWL.field_talker);
    paraml.jj(10, 2131756602);
    if ((localaf != null) && (b.ls(localaf.field_type))) {
      paraml.a(2, c.a(this.mXd).getResources().getColor(2131099803), c.a(this.mXd).getString(2131761049));
    }
    AppMethodBeat.o(175420);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.c.9
 * JD-Core Version:    0.7.0.1
 */