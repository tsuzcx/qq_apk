package com.tencent.mm.plugin.fts.ui;

import android.content.Intent;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.api.m;
import com.tencent.mm.br.d;
import com.tencent.mm.h.a;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.protocal.protobuf.csq;
import com.tencent.mm.protocal.protobuf.css;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.base.h;
import java.util.LinkedList;

final class FTSMainUI$12
  implements com.tencent.mm.ak.g
{
  FTSMainUI$12(FTSMainUI paramFTSMainUI, String paramString) {}
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(111975);
    com.tencent.mm.kernel.g.agi().b(106, this);
    if ((paramInt1 == 4) && (paramInt2 == -4))
    {
      FTSMainUI.f(this.sDB);
      h.a(this.sDB, 2131762921, 0, true, null);
      AppMethodBeat.o(111975);
      return;
    }
    FTSMainUI.f(this.sDB);
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      switch (paramInt2)
      {
      }
      for (;;)
      {
        ac.w("MicroMsg.FTS.FTSMainUI", String.format("Search contact failed: %d, %d.", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }));
        AppMethodBeat.o(111975);
        return;
        Toast.makeText(this.sDB, this.sDB.getString(2131762916), 0).show();
        continue;
        paramString = a.rM(paramString);
        if (paramString != null) {
          h.a(this.sDB, paramString.desc, paramString.Title, true, null);
        }
      }
    }
    paramString = ((com.tencent.mm.plugin.messenger.a.g)paramn).dcj();
    if (paramString.ENQ > 0)
    {
      if (paramString.ENR.isEmpty())
      {
        h.a(this.sDB, 2131762921, 0, true, null);
        AppMethodBeat.o(111975);
        return;
      }
      paramn = new Intent();
      ((m)com.tencent.mm.kernel.g.ab(m.class)).a(paramn, (csq)paramString.ENR.getFirst(), this.sDB.sCi);
      d.b(this.sDB, "profile", ".ui.ContactInfoUI", paramn);
      AppMethodBeat.o(111975);
      return;
    }
    if (bs.nullAsNil(z.a(paramString.EuE)).length() > 0)
    {
      if (2 != paramString.FEO) {
        break label419;
      }
      this.sDB.sCi = 15;
    }
    for (;;)
    {
      paramn = new Intent();
      ((m)com.tencent.mm.kernel.g.ab(m.class)).a(paramn, paramString, this.sDB.sCi);
      if (this.sDB.sCi == 15) {
        paramn.putExtra("Contact_Search_Mobile", this.JZ.trim());
      }
      paramn.putExtra("Contact_Scene", this.sDB.sCi);
      paramn.putExtra("add_more_friend_search_scene", 2);
      d.b(this.sDB, "profile", ".ui.ContactInfoUI", paramn);
      AppMethodBeat.o(111975);
      return;
      label419:
      if (1 == paramString.FEO) {
        this.sDB.sCi = 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.FTSMainUI.12
 * JD-Core Version:    0.7.0.1
 */