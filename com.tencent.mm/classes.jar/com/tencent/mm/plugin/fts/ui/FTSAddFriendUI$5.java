package com.tencent.mm.plugin.fts.ui;

import android.content.Intent;
import android.widget.TextView;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.p;
import com.tencent.mm.api.i;
import com.tencent.mm.br.d;
import com.tencent.mm.i.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.protocal.c.bnk;
import com.tencent.mm.protocal.c.bnm;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.s;
import java.io.IOException;
import java.util.LinkedList;

final class FTSAddFriendUI$5
  implements com.tencent.mm.ah.f
{
  FTSAddFriendUI$5(FTSAddFriendUI paramFTSAddFriendUI) {}
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    g.Dk().b(106, this);
    FTSAddFriendUI.d(this.kAI);
    if ((paramInt1 != 0) || (paramInt2 != 0)) {
      switch (paramInt2)
      {
      default: 
        FTSAddFriendUI.e(this.kAI).setText(n.g.no_contact_result);
        label65:
        FTSAddFriendUI.a(this.kAI, -1);
        FTSAddFriendUI.b(this.kAI, 1);
      }
    }
    for (;;)
    {
      FTSAddFriendUI.h(this.kAI);
      return;
      if (paramInt1 == 4) {
        break;
      }
      FTSAddFriendUI.e(this.kAI).setText(this.kAI.getString(n.g.search_contact_err_no_code));
      break label65;
      paramString = a.eI(paramString);
      if (paramString != null)
      {
        FTSAddFriendUI.e(this.kAI).setText(paramString.desc);
        break label65;
      }
      FTSAddFriendUI.e(this.kAI).setText(n.g.no_contact_result);
      break label65;
      FTSAddFriendUI.a(this.kAI, ((com.tencent.mm.plugin.messenger.a.f)paramm).bhH());
      if (FTSAddFriendUI.f(this.kAI).tcA > 0)
      {
        if (FTSAddFriendUI.f(this.kAI).tcB.isEmpty())
        {
          h.a(this.kAI, n.g.search_contact_not_found, 0, true, null);
          return;
        }
        paramString = new Intent();
        paramString.putExtra("add_more_friend_search_scene", 3);
        if (FTSAddFriendUI.f(this.kAI).tcB.size() > 1) {
          try
          {
            paramString.putExtra("result", FTSAddFriendUI.f(this.kAI).toByteArray());
            d.b(this.kAI.mController.uMN, "subapp", ".ui.pluginapp.ContactSearchResultUI", paramString);
            return;
          }
          catch (IOException paramString)
          {
            y.printErrStackTrace("MicroMsg.FTS.FTSAddFriendUI", paramString, "", new Object[0]);
            return;
          }
        }
        ((i)g.r(i.class)).a(paramString, (bnk)FTSAddFriendUI.f(this.kAI).tcB.getFirst(), this.kAI.kAH);
      }
      FTSAddFriendUI.a(this.kAI, 1);
      FTSAddFriendUI.g(this.kAI);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.FTSAddFriendUI.5
 * JD-Core Version:    0.7.0.1
 */