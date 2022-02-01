package com.tencent.mm.plugin.fts.ui;

import android.content.Intent;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.api.m;
import com.tencent.mm.bs.d;
import com.tencent.mm.h.a;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.protocal.protobuf.cnj;
import com.tencent.mm.protocal.protobuf.cnl;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.base.h;
import java.util.LinkedList;

final class FTSMainUI$12
  implements com.tencent.mm.al.g
{
  FTSMainUI$12(FTSMainUI paramFTSMainUI, String paramString) {}
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(111975);
    com.tencent.mm.kernel.g.aeS().b(106, this);
    if ((paramInt1 == 4) && (paramInt2 == -4))
    {
      FTSMainUI.f(this.ruJ);
      h.a(this.ruJ, 2131762921, 0, true, null);
      AppMethodBeat.o(111975);
      return;
    }
    FTSMainUI.f(this.ruJ);
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      switch (paramInt2)
      {
      }
      for (;;)
      {
        ad.w("MicroMsg.FTS.FTSMainUI", String.format("Search contact failed: %d, %d.", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }));
        AppMethodBeat.o(111975);
        return;
        Toast.makeText(this.ruJ, this.ruJ.getString(2131762916), 0).show();
        continue;
        paramString = a.oG(paramString);
        if (paramString != null) {
          h.a(this.ruJ, paramString.desc, paramString.Title, true, null);
        }
      }
    }
    paramString = ((com.tencent.mm.plugin.messenger.a.g)paramn).cOA();
    if (paramString.DsM > 0)
    {
      if (paramString.DsN.isEmpty())
      {
        h.a(this.ruJ, 2131762921, 0, true, null);
        AppMethodBeat.o(111975);
        return;
      }
      paramn = new Intent();
      ((m)com.tencent.mm.kernel.g.ab(m.class)).a(paramn, (cnj)paramString.DsN.getFirst(), this.ruJ.rto);
      d.b(this.ruJ, "profile", ".ui.ContactInfoUI", paramn);
      AppMethodBeat.o(111975);
      return;
    }
    if (bt.nullAsNil(z.a(paramString.Dby)).length() > 0)
    {
      if (2 != paramString.EhQ) {
        break label419;
      }
      this.ruJ.rto = 15;
    }
    for (;;)
    {
      paramn = new Intent();
      ((m)com.tencent.mm.kernel.g.ab(m.class)).a(paramn, paramString, this.ruJ.rto);
      if (this.ruJ.rto == 15) {
        paramn.putExtra("Contact_Search_Mobile", this.Je.trim());
      }
      paramn.putExtra("Contact_Scene", this.ruJ.rto);
      paramn.putExtra("add_more_friend_search_scene", 2);
      d.b(this.ruJ, "profile", ".ui.ContactInfoUI", paramn);
      AppMethodBeat.o(111975);
      return;
      label419:
      if (1 == paramString.EhQ) {
        this.ruJ.rto = 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.FTSMainUI.12
 * JD-Core Version:    0.7.0.1
 */