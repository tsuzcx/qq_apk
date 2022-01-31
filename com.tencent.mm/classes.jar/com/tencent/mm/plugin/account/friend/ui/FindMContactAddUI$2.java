package com.tencent.mm.plugin.account.friend.ui;

import android.app.ProgressDialog;
import android.content.Intent;
import android.widget.Toast;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.s;

final class FindMContactAddUI$2
  implements f
{
  FindMContactAddUI$2(FindMContactAddUI paramFindMContactAddUI) {}
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    if (FindMContactAddUI.a(this.fhv) != null)
    {
      FindMContactAddUI.a(this.fhv).dismiss();
      FindMContactAddUI.b(this.fhv);
    }
    if (FindMContactAddUI.o(this.fhv) != null)
    {
      g.Dk().b(30, FindMContactAddUI.o(this.fhv));
      FindMContactAddUI.p(this.fhv);
    }
    if ((paramInt1 == 4) && (paramInt2 == -24) && (!bk.bl(paramString)))
    {
      Toast.makeText(this.fhv.mController.uMN, paramString, 1).show();
      return;
    }
    if ((FindMContactAddUI.k(this.fhv) != null) && (FindMContactAddUI.k(this.fhv).contains("2")))
    {
      paramString = new Intent(this.fhv, FindMContactInviteUI.class);
      paramString.putExtra("regsetinfo_ticket", FindMContactAddUI.l(this.fhv));
      paramString.putExtra("login_type", FindMContactAddUI.m(this.fhv));
      paramString.putExtra("regsetinfo_NextStyle", FindMContactAddUI.e(this.fhv));
      MMWizardActivity.C(this.fhv, paramString);
      return;
    }
    FindMContactAddUI.n(this.fhv);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.ui.FindMContactAddUI.2
 * JD-Core Version:    0.7.0.1
 */