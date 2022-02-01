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
import com.tencent.mm.platformtools.z;
import com.tencent.mm.protocal.protobuf.cnj;
import com.tencent.mm.protocal.protobuf.cnk;
import com.tencent.mm.protocal.protobuf.cnl;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.base.h;
import java.io.IOException;
import java.util.LinkedList;

final class FTSAddFriendUI$5
  implements com.tencent.mm.al.g
{
  FTSAddFriendUI$5(FTSAddFriendUI paramFTSAddFriendUI) {}
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(111822);
    com.tencent.mm.kernel.g.aeS().b(106, this);
    FTSAddFriendUI.d(this.rtp);
    if ((paramInt1 != 0) || (paramInt2 != 0)) {
      switch (paramInt2)
      {
      default: 
        FTSAddFriendUI.e(this.rtp).setText(2131761619);
        label68:
        FTSAddFriendUI.a(this.rtp, -1);
        FTSAddFriendUI.b(this.rtp, 1);
      }
    }
    for (;;)
    {
      FTSAddFriendUI.h(this.rtp);
      AppMethodBeat.o(111822);
      return;
      if (paramInt1 == 4) {
        break;
      }
      FTSAddFriendUI.e(this.rtp).setText(this.rtp.getString(2131762916));
      break label68;
      paramString = a.oG(paramString);
      if (paramString != null)
      {
        FTSAddFriendUI.e(this.rtp).setText(paramString.desc);
        break label68;
      }
      FTSAddFriendUI.e(this.rtp).setText(2131761619);
      break label68;
      FTSAddFriendUI.a(this.rtp, ((com.tencent.mm.plugin.messenger.a.g)paramn).cOA());
      FTSAddFriendUI localFTSAddFriendUI = this.rtp;
      paramString = (cnk)((com.tencent.mm.plugin.messenger.a.g)paramn).rr.gUS.gUX;
      if (paramString != null) {}
      for (paramString = z.a(paramString.Dby);; paramString = "")
      {
        FTSAddFriendUI.a(localFTSAddFriendUI, paramString);
        if (FTSAddFriendUI.f(this.rtp).DsM <= 0) {
          break label407;
        }
        if (!FTSAddFriendUI.f(this.rtp).DsN.isEmpty()) {
          break;
        }
        h.a(this.rtp, 2131762921, 0, true, null);
        AppMethodBeat.o(111822);
        return;
      }
      paramString = new Intent();
      paramString.putExtra("add_more_friend_search_scene", 3);
      if (FTSAddFriendUI.f(this.rtp).DsN.size() > 1) {
        try
        {
          paramString.putExtra("result", FTSAddFriendUI.f(this.rtp).toByteArray());
          d.b(this.rtp.getContext(), "subapp", ".ui.pluginapp.ContactSearchResultUI", paramString);
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
      ((m)com.tencent.mm.kernel.g.ab(m.class)).a(paramString, (cnj)FTSAddFriendUI.f(this.rtp).DsN.getFirst(), this.rtp.rto);
      label407:
      FTSAddFriendUI.a(this.rtp, 1);
      FTSAddFriendUI.g(this.rtp);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.FTSAddFriendUI.5
 * JD-Core Version:    0.7.0.1
 */