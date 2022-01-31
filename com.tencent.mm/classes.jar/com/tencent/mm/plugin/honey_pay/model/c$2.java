package com.tencent.mm.plugin.honey_pay.model;

import android.graphics.Color;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.bdb;
import com.tencent.mm.protocal.protobuf.bvv;
import com.tencent.mm.protocal.protobuf.ckm;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.widget.b.d;
import java.util.Iterator;
import java.util.LinkedList;

final class c$2
  implements MenuItem.OnMenuItemClickListener
{
  c$2(MMActivity paramMMActivity, bvv parambvv, String paramString, ckm paramckm, int paramInt) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(41755);
    paramMenuItem = new d(this.val$activity, 1, false);
    paramMenuItem.sao = new n.c()
    {
      public final void onCreateMMMenu(l paramAnonymousl)
      {
        AppMethodBeat.i(41753);
        Iterator localIterator = c.2.this.nHs.xJr.iterator();
        int i = 0;
        bdb localbdb;
        if (localIterator.hasNext())
        {
          localbdb = (bdb)localIterator.next();
          if (bo.isNullOrNil(localbdb.jVh)) {
            break label109;
          }
          if (!bo.isNullOrNil(localbdb.color))
          {
            paramAnonymousl.a(i, Color.parseColor(localbdb.color), localbdb.jVh);
            label82:
            i += 1;
          }
        }
        label109:
        for (;;)
        {
          break;
          paramAnonymousl.e(i, localbdb.jVh);
          break label82;
          AppMethodBeat.o(41753);
          return;
        }
      }
    };
    paramMenuItem.sap = new c.2.2(this);
    paramMenuItem.crd();
    AppMethodBeat.o(41755);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.honey_pay.model.c.2
 * JD-Core Version:    0.7.0.1
 */