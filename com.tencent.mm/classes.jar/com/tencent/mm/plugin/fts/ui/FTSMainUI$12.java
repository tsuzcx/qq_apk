package com.tencent.mm.plugin.fts.ui;

import android.content.Intent;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.api.m;
import com.tencent.mm.br.d;
import com.tencent.mm.h.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.protocal.protobuf.cyu;
import com.tencent.mm.protocal.protobuf.cyw;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.base.h;
import java.util.LinkedList;

final class FTSMainUI$12
  implements com.tencent.mm.ak.f
{
  FTSMainUI$12(FTSMainUI paramFTSMainUI, String paramString) {}
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(111975);
    g.ajj().b(106, this);
    if ((paramInt1 == 4) && (paramInt2 == -4))
    {
      FTSMainUI.f(this.tLh);
      h.a(this.tLh, 2131762921, 0, true, null);
      AppMethodBeat.o(111975);
      return;
    }
    FTSMainUI.f(this.tLh);
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      switch (paramInt2)
      {
      }
      for (;;)
      {
        ae.w("MicroMsg.FTS.FTSMainUI", String.format("Search contact failed: %d, %d.", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }));
        AppMethodBeat.o(111975);
        return;
        Toast.makeText(this.tLh, this.tLh.getString(2131762916), 0).show();
        continue;
        paramString = a.uU(paramString);
        if (paramString != null) {
          h.a(this.tLh, paramString.desc, paramString.Title, true, null);
        }
      }
    }
    paramString = ((com.tencent.mm.plugin.messenger.a.f)paramn).doB();
    if (paramString.GQu > 0)
    {
      if (paramString.GQv.isEmpty())
      {
        h.a(this.tLh, 2131762921, 0, true, null);
        AppMethodBeat.o(111975);
        return;
      }
      paramn = new Intent();
      ((m)g.ab(m.class)).a(paramn, (cyu)paramString.GQv.getFirst(), this.tLh.tJA);
      d.b(this.tLh, "profile", ".ui.ContactInfoUI", paramn);
      AppMethodBeat.o(111975);
      return;
    }
    if (bu.nullAsNil(z.a(paramString.GuF)).length() > 0)
    {
      if (2 != paramString.HIP) {
        break label419;
      }
      this.tLh.tJA = 15;
    }
    for (;;)
    {
      paramn = new Intent();
      ((m)g.ab(m.class)).a(paramn, paramString, this.tLh.tJA);
      if (this.tLh.tJA == 15) {
        paramn.putExtra("Contact_Search_Mobile", this.LP.trim());
      }
      paramn.putExtra("Contact_Scene", this.tLh.tJA);
      paramn.putExtra("add_more_friend_search_scene", 2);
      d.b(this.tLh, "profile", ".ui.ContactInfoUI", paramn);
      AppMethodBeat.o(111975);
      return;
      label419:
      if (1 == paramString.HIP) {
        this.tLh.tJA = 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.FTSMainUI.12
 * JD-Core Version:    0.7.0.1
 */