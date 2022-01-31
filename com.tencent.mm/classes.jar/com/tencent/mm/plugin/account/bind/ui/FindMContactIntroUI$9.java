package com.tencent.mm.plugin.account.bind.ui;

import android.app.ProgressDialog;
import android.content.Intent;
import android.widget.Toast;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.account.bind.a.i;
import com.tencent.mm.plugin.account.friend.a.ag;
import com.tencent.mm.plugin.account.friend.ui.FindMContactAddUI;
import com.tencent.mm.protocal.c.auc;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMWizardActivity;
import java.util.Iterator;
import java.util.LinkedList;

final class FindMContactIntroUI$9
  implements f
{
  FindMContactIntroUI$9(FindMContactIntroUI paramFindMContactIntroUI) {}
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    if (FindMContactIntroUI.g(this.fdm) != null)
    {
      FindMContactIntroUI.g(this.fdm).dismiss();
      FindMContactIntroUI.h(this.fdm);
    }
    if (FindMContactIntroUI.i(this.fdm) != null)
    {
      g.Dk().b(431, FindMContactIntroUI.i(this.fdm));
      FindMContactIntroUI.j(this.fdm);
    }
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      paramString = ((ag)paramm).Xd();
      ((com.tencent.mm.plugin.account.a.a.a)g.t(com.tencent.mm.plugin.account.a.a.a.class)).setFriendData(paramString);
      if ((paramString == null) || (paramString.size() <= 0)) {
        break label366;
      }
      paramm = paramString.iterator();
      paramInt1 = 0;
      while (paramm.hasNext())
      {
        auc localauc = (auc)paramm.next();
        if (localauc != null)
        {
          if (localauc.hQq != 1) {
            break label363;
          }
          paramInt1 += 1;
        }
      }
      if (paramInt1 > 0) {
        paramInt2 = 1;
      }
    }
    for (;;)
    {
      if (paramString == null) {}
      for (int i = 0;; i = paramString.size())
      {
        y.d("MicroMsg.FindMContactIntroUI", "tigerreg data size=%d, addcount=%s", new Object[] { Integer.valueOf(i), Integer.valueOf(paramInt1) });
        if ((FindMContactIntroUI.d(this.fdm) == null) || (!FindMContactIntroUI.d(this.fdm).contains("1")) || (paramInt2 == 0)) {
          break label315;
        }
        com.tencent.mm.plugin.b.a.qj("R300_300_phone");
        paramString = new Intent(this.fdm, FindMContactAddUI.class);
        paramString.putExtra("regsetinfo_ticket", FindMContactIntroUI.c(this.fdm));
        paramString.putExtra("regsetinfo_NextStep", FindMContactIntroUI.d(this.fdm));
        paramString.putExtra("regsetinfo_NextStyle", FindMContactIntroUI.e(this.fdm));
        paramString.putExtra("login_type", 0);
        MMWizardActivity.C(this.fdm, paramString);
        return;
        paramInt2 = 0;
        break;
      }
      label315:
      FindMContactIntroUI.b(this.fdm);
      return;
      Toast.makeText(this.fdm, this.fdm.getString(a.i.app_err_system_busy_tip, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }), 0).show();
      return;
      label363:
      break;
      label366:
      paramInt2 = 0;
      paramInt1 = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.account.bind.ui.FindMContactIntroUI.9
 * JD-Core Version:    0.7.0.1
 */