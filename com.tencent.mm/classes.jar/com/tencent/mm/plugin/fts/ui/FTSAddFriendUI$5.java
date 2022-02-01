package com.tencent.mm.plugin.fts.ui;

import android.content.Intent;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.api.m;
import com.tencent.mm.br.d;
import com.tencent.mm.h.a;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.protocal.protobuf.csq;
import com.tencent.mm.protocal.protobuf.csr;
import com.tencent.mm.protocal.protobuf.css;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.ui.base.h;
import java.io.IOException;
import java.util.LinkedList;

final class FTSAddFriendUI$5
  implements com.tencent.mm.ak.g
{
  FTSAddFriendUI$5(FTSAddFriendUI paramFTSAddFriendUI) {}
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(111822);
    com.tencent.mm.kernel.g.agi().b(106, this);
    FTSAddFriendUI.d(this.sCj);
    if ((paramInt1 != 0) || (paramInt2 != 0)) {
      switch (paramInt2)
      {
      default: 
        FTSAddFriendUI.e(this.sCj).setText(2131761619);
        label68:
        FTSAddFriendUI.a(this.sCj, -1);
        FTSAddFriendUI.b(this.sCj, 1);
      }
    }
    for (;;)
    {
      FTSAddFriendUI.h(this.sCj);
      AppMethodBeat.o(111822);
      return;
      if (paramInt1 == 4) {
        break;
      }
      FTSAddFriendUI.e(this.sCj).setText(this.sCj.getString(2131762916));
      break label68;
      paramString = a.rM(paramString);
      if (paramString != null)
      {
        FTSAddFriendUI.e(this.sCj).setText(paramString.desc);
        break label68;
      }
      FTSAddFriendUI.e(this.sCj).setText(2131761619);
      break label68;
      FTSAddFriendUI.a(this.sCj, ((com.tencent.mm.plugin.messenger.a.g)paramn).dcj());
      FTSAddFriendUI localFTSAddFriendUI = this.sCj;
      paramString = (csr)((com.tencent.mm.plugin.messenger.a.g)paramn).rr.hvr.hvw;
      if (paramString != null) {}
      for (paramString = z.a(paramString.EuE);; paramString = "")
      {
        FTSAddFriendUI.a(localFTSAddFriendUI, paramString);
        if (FTSAddFriendUI.f(this.sCj).ENQ <= 0) {
          break label407;
        }
        if (!FTSAddFriendUI.f(this.sCj).ENR.isEmpty()) {
          break;
        }
        h.a(this.sCj, 2131762921, 0, true, null);
        AppMethodBeat.o(111822);
        return;
      }
      paramString = new Intent();
      paramString.putExtra("add_more_friend_search_scene", 3);
      if (FTSAddFriendUI.f(this.sCj).ENR.size() > 1) {
        try
        {
          paramString.putExtra("result", FTSAddFriendUI.f(this.sCj).toByteArray());
          d.b(this.sCj.getContext(), "subapp", ".ui.pluginapp.ContactSearchResultUI", paramString);
          AppMethodBeat.o(111822);
          return;
        }
        catch (IOException paramString)
        {
          ac.printErrStackTrace("MicroMsg.FTS.FTSAddFriendUI", paramString, "", new Object[0]);
          AppMethodBeat.o(111822);
          return;
        }
      }
      ((m)com.tencent.mm.kernel.g.ab(m.class)).a(paramString, (csq)FTSAddFriendUI.f(this.sCj).ENR.getFirst(), this.sCj.sCi);
      label407:
      FTSAddFriendUI.a(this.sCj, 1);
      FTSAddFriendUI.g(this.sCj);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.FTSAddFriendUI.5
 * JD-Core Version:    0.7.0.1
 */