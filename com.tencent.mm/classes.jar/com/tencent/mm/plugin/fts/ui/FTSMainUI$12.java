package com.tencent.mm.plugin.fts.ui;

import android.content.Intent;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.t;
import com.tencent.mm.api.n;
import com.tencent.mm.br.c;
import com.tencent.mm.h.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.messenger.a.f;
import com.tencent.mm.protocal.protobuf.drr;
import com.tencent.mm.protocal.protobuf.drt;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.h;
import java.util.LinkedList;

final class FTSMainUI$12
  implements i
{
  FTSMainUI$12(FTSMainUI paramFTSMainUI, String paramString) {}
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(111975);
    g.azz().b(106, this);
    if ((paramInt1 == 4) && (paramInt2 == -4))
    {
      FTSMainUI.g(this.xci);
      h.a(this.xci, 2131765057, 0, true, null);
      AppMethodBeat.o(111975);
      return;
    }
    FTSMainUI.g(this.xci);
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      switch (paramInt2)
      {
      }
      for (;;)
      {
        Log.w("MicroMsg.FTS.FTSMainUI", String.format("Search contact failed: %d, %d.", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }));
        AppMethodBeat.o(111975);
        return;
        Toast.makeText(this.xci, this.xci.getString(2131765052), 0).show();
        continue;
        paramString = a.Dk(paramString);
        if (paramString != null) {
          h.a(this.xci, paramString.desc, paramString.Title, true, null);
        }
      }
    }
    paramString = ((f)paramq).eiq();
    if (paramString.LUB > 0)
    {
      if (paramString.LUC.isEmpty())
      {
        h.a(this.xci, 2131765057, 0, true, null);
        AppMethodBeat.o(111975);
        return;
      }
      paramq = new Intent();
      ((n)g.af(n.class)).a(paramq, (drr)paramString.LUC.getFirst(), this.xci.xaz);
      c.b(this.xci, "profile", ".ui.ContactInfoUI", paramq);
      AppMethodBeat.o(111975);
      return;
    }
    if (Util.nullAsNil(z.a(paramString.Lqk)).length() > 0)
    {
      if (2 != paramString.MUk) {
        break label419;
      }
      this.xci.xaz = 15;
    }
    for (;;)
    {
      paramq = new Intent();
      ((n)g.af(n.class)).a(paramq, paramString, this.xci.xaz);
      if (this.xci.xaz == 15) {
        paramq.putExtra("Contact_Search_Mobile", this.LZ.trim());
      }
      paramq.putExtra("Contact_Scene", this.xci.xaz);
      paramq.putExtra("add_more_friend_search_scene", 2);
      c.b(this.xci, "profile", ".ui.ContactInfoUI", paramq);
      AppMethodBeat.o(111975);
      return;
      label419:
      if (1 == paramString.MUk) {
        this.xci.xaz = 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.FTSMainUI.12
 * JD-Core Version:    0.7.0.1
 */