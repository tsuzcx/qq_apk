package com.tencent.mm.plugin.fts.ui;

import android.content.Intent;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.api.m;
import com.tencent.mm.bs.d;
import com.tencent.mm.h.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.protocal.protobuf.cya;
import com.tencent.mm.protocal.protobuf.cyc;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.base.h;
import java.util.LinkedList;

final class FTSMainUI$12
  implements com.tencent.mm.al.f
{
  FTSMainUI$12(FTSMainUI paramFTSMainUI, String paramString) {}
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(111975);
    g.aiU().b(106, this);
    if ((paramInt1 == 4) && (paramInt2 == -4))
    {
      FTSMainUI.f(this.tAq);
      h.a(this.tAq, 2131762921, 0, true, null);
      AppMethodBeat.o(111975);
      return;
    }
    FTSMainUI.f(this.tAq);
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
        Toast.makeText(this.tAq, this.tAq.getString(2131762916), 0).show();
        continue;
        paramString = a.uz(paramString);
        if (paramString != null) {
          h.a(this.tAq, paramString.desc, paramString.Title, true, null);
        }
      }
    }
    paramString = ((com.tencent.mm.plugin.messenger.a.f)paramn).dlC();
    if (paramString.GwU > 0)
    {
      if (paramString.GwV.isEmpty())
      {
        h.a(this.tAq, 2131762921, 0, true, null);
        AppMethodBeat.o(111975);
        return;
      }
      paramn = new Intent();
      ((m)g.ab(m.class)).a(paramn, (cya)paramString.GwV.getFirst(), this.tAq.tyJ);
      d.b(this.tAq, "profile", ".ui.ContactInfoUI", paramn);
      AppMethodBeat.o(111975);
      return;
    }
    if (bt.nullAsNil(z.a(paramString.GbY)).length() > 0)
    {
      if (2 != paramString.Hpn) {
        break label419;
      }
      this.tAq.tyJ = 15;
    }
    for (;;)
    {
      paramn = new Intent();
      ((m)g.ab(m.class)).a(paramn, paramString, this.tAq.tyJ);
      if (this.tAq.tyJ == 15) {
        paramn.putExtra("Contact_Search_Mobile", this.LP.trim());
      }
      paramn.putExtra("Contact_Scene", this.tAq.tyJ);
      paramn.putExtra("add_more_friend_search_scene", 2);
      d.b(this.tAq, "profile", ".ui.ContactInfoUI", paramn);
      AppMethodBeat.o(111975);
      return;
      label419:
      if (1 == paramString.Hpn) {
        this.tAq.tyJ = 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.FTSMainUI.12
 * JD-Core Version:    0.7.0.1
 */