package com.tencent.mm.plugin.fts.ui;

import android.content.Intent;
import android.widget.Toast;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.p;
import com.tencent.mm.api.i;
import com.tencent.mm.br.d;
import com.tencent.mm.i.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.protocal.c.bnk;
import com.tencent.mm.protocal.c.bnm;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.base.h;
import java.util.LinkedList;

final class FTSMainUI$6
  implements com.tencent.mm.ah.f
{
  FTSMainUI$6(FTSMainUI paramFTSMainUI, String paramString) {}
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    g.Dk().b(106, this);
    if ((paramInt1 == 4) && (paramInt2 == -4))
    {
      FTSMainUI.p(this.kCm);
      h.a(this.kCm, n.g.search_contact_not_found, 0, true, null);
    }
    do
    {
      return;
      FTSMainUI.p(this.kCm);
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        switch (paramInt2)
        {
        }
        for (;;)
        {
          y.w("MicroMsg.FTS.FTSMainUI", String.format("Search contact failed: %d, %d.", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }));
          return;
          Toast.makeText(this.kCm, this.kCm.getString(n.g.search_contact_err_no_code), 0).show();
          continue;
          paramString = a.eI(paramString);
          if (paramString != null) {
            h.a(this.kCm, paramString.desc, paramString.bGw, true, null);
          }
        }
      }
      paramString = ((com.tencent.mm.plugin.messenger.a.f)paramm).bhH();
      if (paramString.tcA > 0)
      {
        if (paramString.tcB.isEmpty())
        {
          h.a(this.kCm, n.g.search_contact_not_found, 0, true, null);
          return;
        }
        paramm = new Intent();
        ((i)g.r(i.class)).a(paramm, (bnk)paramString.tcB.getFirst(), this.kCm.kAH);
        d.b(this.kCm, "profile", ".ui.ContactInfoUI", paramm);
        return;
      }
    } while (bk.pm(aa.a(paramString.sQs)).length() <= 0);
    if (2 == paramString.tGq) {
      this.kCm.kAH = 15;
    }
    for (;;)
    {
      paramm = new Intent();
      ((i)g.r(i.class)).a(paramm, paramString, this.kCm.kAH);
      if (this.kCm.kAH == 15) {
        paramm.putExtra("Contact_Search_Mobile", this.BG.trim());
      }
      paramm.putExtra("add_more_friend_search_scene", 2);
      d.b(this.kCm, "profile", ".ui.ContactInfoUI", paramm);
      return;
      if (1 == paramString.tGq) {
        this.kCm.kAH = 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.FTSMainUI.6
 * JD-Core Version:    0.7.0.1
 */