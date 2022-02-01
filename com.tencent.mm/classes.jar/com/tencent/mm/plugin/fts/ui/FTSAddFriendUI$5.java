package com.tencent.mm.plugin.fts.ui;

import android.content.Intent;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.api.m;
import com.tencent.mm.bs.d;
import com.tencent.mm.h.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.protocal.protobuf.cya;
import com.tencent.mm.protocal.protobuf.cyb;
import com.tencent.mm.protocal.protobuf.cyc;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.base.h;
import java.io.IOException;
import java.util.LinkedList;

final class FTSAddFriendUI$5
  implements com.tencent.mm.al.f
{
  FTSAddFriendUI$5(FTSAddFriendUI paramFTSAddFriendUI) {}
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(111822);
    g.aiU().b(106, this);
    FTSAddFriendUI.d(this.tyK);
    if ((paramInt1 != 0) || (paramInt2 != 0)) {
      switch (paramInt2)
      {
      default: 
        FTSAddFriendUI.e(this.tyK).setText(2131761619);
        label68:
        FTSAddFriendUI.a(this.tyK, -1);
        FTSAddFriendUI.b(this.tyK, 1);
      }
    }
    for (;;)
    {
      FTSAddFriendUI.h(this.tyK);
      AppMethodBeat.o(111822);
      return;
      if (paramInt1 == 4) {
        break;
      }
      FTSAddFriendUI.e(this.tyK).setText(this.tyK.getString(2131762916));
      break label68;
      paramString = a.uz(paramString);
      if (paramString != null)
      {
        FTSAddFriendUI.e(this.tyK).setText(paramString.desc);
        break label68;
      }
      FTSAddFriendUI.e(this.tyK).setText(2131761619);
      break label68;
      FTSAddFriendUI.a(this.tyK, ((com.tencent.mm.plugin.messenger.a.f)paramn).dlC());
      FTSAddFriendUI localFTSAddFriendUI = this.tyK;
      paramString = (cyb)((com.tencent.mm.plugin.messenger.a.f)paramn).rr.hNK.hNQ;
      if (paramString != null) {}
      for (paramString = z.a(paramString.GbY);; paramString = "")
      {
        FTSAddFriendUI.a(localFTSAddFriendUI, paramString);
        if (FTSAddFriendUI.f(this.tyK).GwU <= 0) {
          break label407;
        }
        if (!FTSAddFriendUI.f(this.tyK).GwV.isEmpty()) {
          break;
        }
        h.a(this.tyK, 2131762921, 0, true, null);
        AppMethodBeat.o(111822);
        return;
      }
      paramString = new Intent();
      paramString.putExtra("add_more_friend_search_scene", 3);
      if (FTSAddFriendUI.f(this.tyK).GwV.size() > 1) {
        try
        {
          paramString.putExtra("result", FTSAddFriendUI.f(this.tyK).toByteArray());
          d.b(this.tyK.getContext(), "subapp", ".ui.pluginapp.ContactSearchResultUI", paramString);
          AppMethodBeat.o(111822);
          return;
        }
        catch (IOException paramString)
        {
          ad.printErrStackTrace("MicroMsg.FTS.FTSAddFriendUI", paramString, "", new Object[0]);
          AppMethodBeat.o(111822);
          return;
        }
      }
      ((m)g.ab(m.class)).a(paramString, (cya)FTSAddFriendUI.f(this.tyK).GwV.getFirst(), this.tyK.tyJ);
      label407:
      FTSAddFriendUI.a(this.tyK, 1);
      FTSAddFriendUI.g(this.tyK);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.FTSAddFriendUI.5
 * JD-Core Version:    0.7.0.1
 */