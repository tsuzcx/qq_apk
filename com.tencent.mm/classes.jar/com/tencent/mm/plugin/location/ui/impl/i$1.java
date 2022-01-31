package com.tencent.mm.plugin.location.ui.impl;

import android.app.Activity;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.dr;
import com.tencent.mm.g.a.dr.b;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.c;

final class i$1
  implements n.c
{
  i$1(i parami) {}
  
  public final void onCreateMMMenu(l paraml)
  {
    AppMethodBeat.i(113738);
    paraml.a(1, this.ohX.getString(2131297075), 0);
    if (this.ohX.type == 1) {
      paraml.a(3, this.ohX.getString(2131302102), 0);
    }
    for (;;)
    {
      dr localdr = new dr();
      localdr.crt.cpO = this.ohX.cpO;
      com.tencent.mm.sdk.b.a.ymk.l(localdr);
      if ((localdr.cru.cqS) || (g.o(ah.getContext(), 4L))) {
        paraml.a(6, this.ohX.getString(2131299012), 0);
      }
      AppMethodBeat.o(113738);
      return;
      if (this.ohX.type == 2)
      {
        if (this.ohX.activity.getIntent().getBooleanExtra("kFavCanDel", true))
        {
          paraml.a(7, this.ohX.getString(2131299815), 0);
          paraml.a(5, this.ohX.getString(2131299704), 0);
          paraml.a(4, this.ohX.getString(2131296901), 0);
        }
      }
      else if (this.ohX.type == 10) {
        paraml.a(8, this.ohX.getString(2131302102), 0);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.location.ui.impl.i.1
 * JD-Core Version:    0.7.0.1
 */