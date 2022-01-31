package com.tencent.mm.plugin.account.bind.ui;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.account.friend.ui.i.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.MMWizardActivity;

final class BindMContactUI$7
  implements i.a
{
  BindMContactUI$7(BindMContactUI paramBindMContactUI, String paramString) {}
  
  public final void g(int paramInt, Bundle paramBundle)
  {
    AppMethodBeat.i(13467);
    if (paramInt == 1)
    {
      ab.i("MicroMsg.BindMContactUI", "next to BindMContactVerifyUI for bind mobile");
      paramBundle = new Intent(this.gtN, BindMContactVerifyUI.class);
      paramBundle.putExtra("bindmcontact_mobile", this.gtC);
      paramBundle.putExtra("KEnterFromBanner", BindMContactUI.i(this.gtN));
      paramBundle.putExtra("bind_scene", BindMContactUI.j(this.gtN));
      MMWizardActivity.J(this.gtN, paramBundle);
    }
    AppMethodBeat.o(13467);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.account.bind.ui.BindMContactUI.7
 * JD-Core Version:    0.7.0.1
 */