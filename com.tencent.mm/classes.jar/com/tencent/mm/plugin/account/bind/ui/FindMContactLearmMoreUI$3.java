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

final class FindMContactLearmMoreUI$3
  implements f
{
  FindMContactLearmMoreUI$3(FindMContactLearmMoreUI paramFindMContactLearmMoreUI) {}
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    if (FindMContactLearmMoreUI.c(this.fdq) != null)
    {
      FindMContactLearmMoreUI.c(this.fdq).dismiss();
      FindMContactLearmMoreUI.d(this.fdq);
    }
    if (FindMContactLearmMoreUI.e(this.fdq) != null)
    {
      g.Dk().b(431, FindMContactLearmMoreUI.e(this.fdq));
      FindMContactLearmMoreUI.f(this.fdq);
    }
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      paramString = ((ag)paramm).Xd();
      ((com.tencent.mm.plugin.account.a.a.a)g.t(com.tencent.mm.plugin.account.a.a.a.class)).setFriendData(paramString);
      if ((paramString == null) || (paramString.size() <= 0)) {
        break label373;
      }
      paramm = paramString.iterator();
      paramInt1 = 0;
      while (paramm.hasNext())
      {
        auc localauc = (auc)paramm.next();
        if (localauc != null)
        {
          if (localauc.hQq != 1) {
            break label370;
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
        y.d("MicroMsg.FindMContactLearmMoreUI", "tigerreg data size=%d, addcount=%s", new Object[] { Integer.valueOf(i), Integer.valueOf(paramInt1) });
        if ((FindMContactLearmMoreUI.g(this.fdq) == null) || (!FindMContactLearmMoreUI.g(this.fdq).contains("1")) || (paramInt2 == 0)) {
          break label315;
        }
        com.tencent.mm.plugin.b.a.qj("R300_300_phone");
        paramString = new Intent(this.fdq, FindMContactAddUI.class);
        paramString.putExtra("regsetinfo_ticket", FindMContactLearmMoreUI.h(this.fdq));
        paramString.putExtra("regsetinfo_NextStep", FindMContactLearmMoreUI.g(this.fdq));
        paramString.putExtra("regsetinfo_NextStyle", FindMContactLearmMoreUI.i(this.fdq));
        paramString.putExtra("login_type", 0);
        MMWizardActivity.C(this.fdq, paramString);
        return;
        paramInt2 = 0;
        break;
      }
      label315:
      FindMContactLearmMoreUI.b(this.fdq);
      return;
      Toast.makeText(this.fdq, this.fdq.getString(a.i.app_err_system_busy_tip, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }), 0).show();
      FindMContactLearmMoreUI.b(this.fdq);
      return;
      label370:
      break;
      label373:
      paramInt2 = 0;
      paramInt1 = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.account.bind.ui.FindMContactLearmMoreUI.3
 * JD-Core Version:    0.7.0.1
 */