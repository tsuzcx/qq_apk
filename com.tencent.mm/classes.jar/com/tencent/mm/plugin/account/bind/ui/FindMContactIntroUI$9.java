package com.tencent.mm.plugin.account.bind.ui;

import android.app.ProgressDialog;
import android.content.Intent;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.account.friend.a.ag;
import com.tencent.mm.plugin.account.friend.ui.FindMContactAddUI;
import com.tencent.mm.protocal.protobuf.bai;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.MMWizardActivity;
import java.util.Iterator;
import java.util.LinkedList;

final class FindMContactIntroUI$9
  implements f
{
  FindMContactIntroUI$9(FindMContactIntroUI paramFindMContactIntroUI) {}
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(13605);
    if (FindMContactIntroUI.g(this.guX) != null)
    {
      FindMContactIntroUI.g(this.guX).dismiss();
      FindMContactIntroUI.h(this.guX);
    }
    if (FindMContactIntroUI.i(this.guX) != null)
    {
      g.Rc().b(431, FindMContactIntroUI.i(this.guX));
      FindMContactIntroUI.j(this.guX);
    }
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      paramString = ((ag)paramm).aqH();
      ((com.tencent.mm.plugin.account.a.a.a)g.G(com.tencent.mm.plugin.account.a.a.a.class)).setFriendData(paramString);
      if ((paramString == null) || (paramString.size() <= 0)) {
        break label389;
      }
      paramm = paramString.iterator();
      paramInt1 = 0;
      while (paramm.hasNext())
      {
        bai localbai = (bai)paramm.next();
        if (localbai != null)
        {
          if (localbai.jJS != 1) {
            break label386;
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
        ab.d("MicroMsg.FindMContactIntroUI", "tigerreg data size=%d, addcount=%s", new Object[] { Integer.valueOf(i), Integer.valueOf(paramInt1) });
        if ((FindMContactIntroUI.d(this.guX) == null) || (!FindMContactIntroUI.d(this.guX).contains("1")) || (paramInt2 == 0)) {
          break label327;
        }
        com.tencent.mm.plugin.b.a.xD("R300_300_phone");
        paramString = new Intent(this.guX, FindMContactAddUI.class);
        paramString.putExtra("regsetinfo_ticket", FindMContactIntroUI.c(this.guX));
        paramString.putExtra("regsetinfo_NextStep", FindMContactIntroUI.d(this.guX));
        paramString.putExtra("regsetinfo_NextStyle", FindMContactIntroUI.e(this.guX));
        paramString.putExtra("login_type", 0);
        MMWizardActivity.J(this.guX, paramString);
        AppMethodBeat.o(13605);
        return;
        paramInt2 = 0;
        break;
      }
      label327:
      FindMContactIntroUI.b(this.guX);
      AppMethodBeat.o(13605);
      return;
      Toast.makeText(this.guX, this.guX.getString(2131296926, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }), 0).show();
      AppMethodBeat.o(13605);
      return;
      label386:
      break;
      label389:
      paramInt2 = 0;
      paramInt1 = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.account.bind.ui.FindMContactIntroUI.9
 * JD-Core Version:    0.7.0.1
 */