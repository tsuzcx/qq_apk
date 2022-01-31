package com.tencent.mm.plugin.collect.ui;

import android.view.MenuItem;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.so;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.bda;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.wallet_core.ui.e;
import java.util.List;

final class CollectMainUI$14$2
  implements n.d
{
  CollectMainUI$14$2(CollectMainUI.14 param14) {}
  
  public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
  {
    AppMethodBeat.i(142005);
    switch (paramMenuItem.getItemId())
    {
    default: 
      paramInt = paramMenuItem.getItemId() - 1 - 1;
      if (paramInt < 0)
      {
        ab.w("MicroMsg.CollectMainUI", "illegal pos: %s", new Object[] { Integer.valueOf(paramInt) });
        AppMethodBeat.o(142005);
        return;
      }
      break;
    case 1: 
      com.tencent.mm.plugin.collect.a.a.bhw();
      if (com.tencent.mm.plugin.collect.a.a.bhy())
      {
        CollectMainUI.y(this.kSF.kSz);
        Toast.makeText(this.kSF.kSz.getContext(), 2131298446, 1).show();
        h.qsU.e(13944, new Object[] { Integer.valueOf(8) });
        AppMethodBeat.o(142005);
        return;
      }
      CollectMainUI.z(this.kSF.kSz);
      Toast.makeText(this.kSF.kSz.getContext(), 2131298456, 1).show();
      com.tencent.mm.plugin.collect.model.voice.a.bhJ().bhK();
      h.qsU.e(13944, new Object[] { Integer.valueOf(7) });
      AppMethodBeat.o(142005);
      return;
    }
    paramMenuItem = (bda)this.kSF.gEz.get(paramInt);
    if (paramMenuItem.type == 1)
    {
      ab.w("MicroMsg.CollectMainUI", "wrong native type: %s", new Object[] { paramMenuItem.url });
      h.qsU.e(14526, new Object[] { Integer.valueOf(2), Integer.valueOf(1), paramMenuItem.cyA, "", "", "", Integer.valueOf(2) });
      AppMethodBeat.o(142005);
      return;
    }
    if (paramMenuItem.type == 2)
    {
      if (!bo.isNullOrNil(paramMenuItem.url))
      {
        e.m(this.kSF.kSz.getContext(), paramMenuItem.url, false);
        h.qsU.e(14526, new Object[] { Integer.valueOf(2), Integer.valueOf(2), paramMenuItem.cyA, "", "", paramMenuItem.url, Integer.valueOf(2) });
        AppMethodBeat.o(142005);
      }
    }
    else if (paramMenuItem.type == 3)
    {
      so localso = new so();
      localso.cIQ.userName = paramMenuItem.xtb;
      localso.cIQ.cIS = bo.bf(paramMenuItem.xtc, "");
      localso.cIQ.scene = 1072;
      localso.cIQ.cIT = 0;
      com.tencent.mm.sdk.b.a.ymk.l(localso);
      h.qsU.e(14526, new Object[] { Integer.valueOf(2), Integer.valueOf(3), paramMenuItem.cyA, paramMenuItem.xtb, paramMenuItem.xtc, "", Integer.valueOf(2) });
    }
    AppMethodBeat.o(142005);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.ui.CollectMainUI.14.2
 * JD-Core Version:    0.7.0.1
 */