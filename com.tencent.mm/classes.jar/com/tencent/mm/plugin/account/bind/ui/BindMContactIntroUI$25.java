package com.tencent.mm.plugin.account.bind.ui;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.ug;
import com.tencent.mm.model.r;
import com.tencent.mm.plugin.account.friend.ui.i.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.n;
import com.tencent.mm.ui.MMWizardActivity;

final class BindMContactIntroUI$25
  implements i.a
{
  BindMContactIntroUI$25(BindMContactIntroUI paramBindMContactIntroUI, String paramString) {}
  
  public final void g(int paramInt, Bundle paramBundle)
  {
    AppMethodBeat.i(13435);
    if (paramInt == 2)
    {
      if (BindMContactIntroUI.f(this.gtw) == 1)
      {
        if (!r.Zv())
        {
          paramBundle = new ug();
          paramBundle.cKJ.cKK = true;
          paramBundle.cKJ.cKL = true;
          com.tencent.mm.sdk.b.a.ymk.l(paramBundle);
        }
        BindMContactIntroUI.g(this.gtw);
        paramBundle = new Intent();
        paramBundle.addFlags(67108864);
        com.tencent.mm.plugin.account.a.a.gmO.e(this.gtw, paramBundle);
        AppMethodBeat.o(13435);
        return;
      }
      MMWizardActivity.J(this.gtw, new Intent(this.gtw, BindMContactStatusUI.class).putExtra("bind_scene", BindMContactIntroUI.f(this.gtw)));
      if (BindMContactIntroUI.h(this.gtw))
      {
        if (BindMContactIntroUI.f(this.gtw) == 2)
        {
          h.qsU.e(11002, new Object[] { Integer.valueOf(3), Integer.valueOf(3) });
          AppMethodBeat.o(13435);
          return;
        }
        h.qsU.e(11002, new Object[] { Integer.valueOf(1), Integer.valueOf(2) });
        AppMethodBeat.o(13435);
      }
    }
    else if (paramInt == 1)
    {
      paramBundle = new Intent(this.gtw, BindMContactVerifyUI.class);
      paramBundle.putExtra("bindmcontact_mobile", this.gtC);
      paramBundle.putExtra("bind_scene", BindMContactIntroUI.f(this.gtw));
      paramBundle.putExtra("KEnterFromBanner", BindMContactIntroUI.h(this.gtw));
      MMWizardActivity.J(this.gtw, paramBundle);
    }
    AppMethodBeat.o(13435);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.account.bind.ui.BindMContactIntroUI.25
 * JD-Core Version:    0.7.0.1
 */