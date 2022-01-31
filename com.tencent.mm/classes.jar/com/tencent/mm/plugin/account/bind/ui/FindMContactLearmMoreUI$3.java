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

final class FindMContactLearmMoreUI$3
  implements f
{
  FindMContactLearmMoreUI$3(FindMContactLearmMoreUI paramFindMContactLearmMoreUI) {}
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(13624);
    if (FindMContactLearmMoreUI.c(this.gvb) != null)
    {
      FindMContactLearmMoreUI.c(this.gvb).dismiss();
      FindMContactLearmMoreUI.d(this.gvb);
    }
    if (FindMContactLearmMoreUI.e(this.gvb) != null)
    {
      g.Rc().b(431, FindMContactLearmMoreUI.e(this.gvb));
      FindMContactLearmMoreUI.f(this.gvb);
    }
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      paramString = ((ag)paramm).aqH();
      ((com.tencent.mm.plugin.account.a.a.a)g.G(com.tencent.mm.plugin.account.a.a.a.class)).setFriendData(paramString);
      if ((paramString == null) || (paramString.size() <= 0)) {
        break label396;
      }
      paramm = paramString.iterator();
      paramInt1 = 0;
      while (paramm.hasNext())
      {
        bai localbai = (bai)paramm.next();
        if (localbai != null)
        {
          if (localbai.jJS != 1) {
            break label393;
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
        ab.d("MicroMsg.FindMContactLearmMoreUI", "tigerreg data size=%d, addcount=%s", new Object[] { Integer.valueOf(i), Integer.valueOf(paramInt1) });
        if ((FindMContactLearmMoreUI.g(this.gvb) == null) || (!FindMContactLearmMoreUI.g(this.gvb).contains("1")) || (paramInt2 == 0)) {
          break label327;
        }
        com.tencent.mm.plugin.b.a.xD("R300_300_phone");
        paramString = new Intent(this.gvb, FindMContactAddUI.class);
        paramString.putExtra("regsetinfo_ticket", FindMContactLearmMoreUI.h(this.gvb));
        paramString.putExtra("regsetinfo_NextStep", FindMContactLearmMoreUI.g(this.gvb));
        paramString.putExtra("regsetinfo_NextStyle", FindMContactLearmMoreUI.i(this.gvb));
        paramString.putExtra("login_type", 0);
        MMWizardActivity.J(this.gvb, paramString);
        AppMethodBeat.o(13624);
        return;
        paramInt2 = 0;
        break;
      }
      label327:
      FindMContactLearmMoreUI.b(this.gvb);
      AppMethodBeat.o(13624);
      return;
      Toast.makeText(this.gvb, this.gvb.getString(2131296926, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }), 0).show();
      FindMContactLearmMoreUI.b(this.gvb);
      AppMethodBeat.o(13624);
      return;
      label393:
      break;
      label396:
      paramInt2 = 0;
      paramInt1 = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.account.bind.ui.FindMContactLearmMoreUI.3
 * JD-Core Version:    0.7.0.1
 */