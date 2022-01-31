package com.tencent.mm.plugin.fts.ui;

import android.content.Intent;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.p;
import com.tencent.mm.api.j;
import com.tencent.mm.bq.d;
import com.tencent.mm.h.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.protocal.protobuf.bxf;
import com.tencent.mm.protocal.protobuf.bxg;
import com.tencent.mm.protocal.protobuf.bxh;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.base.h;
import java.io.IOException;
import java.util.LinkedList;

final class FTSAddFriendUI$5
  implements com.tencent.mm.ai.f
{
  FTSAddFriendUI$5(FTSAddFriendUI paramFTSAddFriendUI) {}
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(61729);
    g.Rc().b(106, this);
    FTSAddFriendUI.d(this.mWA);
    if ((paramInt1 != 0) || (paramInt2 != 0)) {
      switch (paramInt2)
      {
      default: 
        FTSAddFriendUI.e(this.mWA).setText(2131301859);
        label68:
        FTSAddFriendUI.a(this.mWA, -1);
        FTSAddFriendUI.b(this.mWA, 1);
      }
    }
    for (;;)
    {
      FTSAddFriendUI.h(this.mWA);
      AppMethodBeat.o(61729);
      return;
      if (paramInt1 == 4) {
        break;
      }
      FTSAddFriendUI.e(this.mWA).setText(this.mWA.getString(2131302978));
      break label68;
      paramString = a.kO(paramString);
      if (paramString != null)
      {
        FTSAddFriendUI.e(this.mWA).setText(paramString.desc);
        break label68;
      }
      FTSAddFriendUI.e(this.mWA).setText(2131301859);
      break label68;
      FTSAddFriendUI.a(this.mWA, ((com.tencent.mm.plugin.messenger.a.f)paramm).bPI());
      FTSAddFriendUI localFTSAddFriendUI = this.mWA;
      paramString = (bxg)((com.tencent.mm.plugin.messenger.a.f)paramm).rr.fsV.fta;
      if (paramString != null) {}
      for (paramString = aa.a(paramString.wOT);; paramString = "")
      {
        FTSAddFriendUI.a(localFTSAddFriendUI, paramString);
        if (FTSAddFriendUI.f(this.mWA).xaS <= 0) {
          break label407;
        }
        if (!FTSAddFriendUI.f(this.mWA).xaT.isEmpty()) {
          break;
        }
        h.a(this.mWA, 2131302983, 0, true, null);
        AppMethodBeat.o(61729);
        return;
      }
      paramString = new Intent();
      paramString.putExtra("add_more_friend_search_scene", 3);
      if (FTSAddFriendUI.f(this.mWA).xaT.size() > 1) {
        try
        {
          paramString.putExtra("result", FTSAddFriendUI.f(this.mWA).toByteArray());
          d.b(this.mWA.getContext(), "subapp", ".ui.pluginapp.ContactSearchResultUI", paramString);
          AppMethodBeat.o(61729);
          return;
        }
        catch (IOException paramString)
        {
          ab.printErrStackTrace("MicroMsg.FTS.FTSAddFriendUI", paramString, "", new Object[0]);
          AppMethodBeat.o(61729);
          return;
        }
      }
      ((j)g.E(j.class)).a(paramString, (bxf)FTSAddFriendUI.f(this.mWA).xaT.getFirst(), this.mWA.mWz);
      label407:
      FTSAddFriendUI.a(this.mWA, 1);
      FTSAddFriendUI.g(this.mWA);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.FTSAddFriendUI.5
 * JD-Core Version:    0.7.0.1
 */