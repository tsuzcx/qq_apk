package com.tencent.mm.plugin.account.friend.ui;

import android.app.ProgressDialog;
import android.content.Intent;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMWizardActivity;

final class FindMContactAddUI$2
  implements f
{
  FindMContactAddUI$2(FindMContactAddUI paramFindMContactAddUI) {}
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(108514);
    if (FindMContactAddUI.a(this.gzd) != null)
    {
      FindMContactAddUI.a(this.gzd).dismiss();
      FindMContactAddUI.b(this.gzd);
    }
    if (FindMContactAddUI.o(this.gzd) != null)
    {
      g.Rc().b(30, FindMContactAddUI.o(this.gzd));
      FindMContactAddUI.p(this.gzd);
    }
    if ((paramInt1 == 4) && (paramInt2 == -24) && (!bo.isNullOrNil(paramString)))
    {
      Toast.makeText(this.gzd.getContext(), paramString, 1).show();
      AppMethodBeat.o(108514);
      return;
    }
    if ((FindMContactAddUI.k(this.gzd) != null) && (FindMContactAddUI.k(this.gzd).contains("2")))
    {
      paramString = new Intent(this.gzd, FindMContactInviteUI.class);
      paramString.putExtra("regsetinfo_ticket", FindMContactAddUI.l(this.gzd));
      paramString.putExtra("login_type", FindMContactAddUI.m(this.gzd));
      paramString.putExtra("regsetinfo_NextStyle", FindMContactAddUI.e(this.gzd));
      MMWizardActivity.J(this.gzd, paramString);
      AppMethodBeat.o(108514);
      return;
    }
    FindMContactAddUI.n(this.gzd);
    AppMethodBeat.o(108514);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.ui.FindMContactAddUI.2
 * JD-Core Version:    0.7.0.1
 */