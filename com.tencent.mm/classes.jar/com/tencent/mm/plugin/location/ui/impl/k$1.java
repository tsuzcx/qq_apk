package com.tencent.mm.plugin.location.ui.impl;

import android.app.Activity;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.ef;
import com.tencent.mm.g.a.ef.b;
import com.tencent.mm.pluginsdk.model.app.h;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.base.o.f;

final class k$1
  implements o.f
{
  k$1(k paramk) {}
  
  public final void onCreateMMMenu(m paramm)
  {
    AppMethodBeat.i(56200);
    paramm.b(1, this.yOp.getString(2131755985), 0);
    if (this.yOp.type == 1) {
      paramm.b(3, this.yOp.getString(2131763947), 0);
    }
    for (;;)
    {
      ef localef = new ef();
      localef.dHy.msgId = this.yOp.msgId;
      EventCenter.instance.publish(localef);
      if ((localef.dHz.dGX) || (h.s(MMApplicationContext.getContext(), 4L))) {
        paramm.b(6, this.yOp.getString(2131758382), 0);
      }
      AppMethodBeat.o(56200);
      return;
      if (this.yOp.type == 2)
      {
        if (this.yOp.activity.getIntent().getBooleanExtra("kFavCanDel", true))
        {
          paramm.b(7, this.yOp.getString(2131759314), 0);
          paramm.b(5, this.yOp.getString(2131759200), 0);
          paramm.b(4, this.yOp.getString(2131755778), 0);
        }
      }
      else if (this.yOp.type == 10) {
        paramm.b(8, this.yOp.getString(2131763947), 0);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.location.ui.impl.k.1
 * JD-Core Version:    0.7.0.1
 */