package com.tencent.mm.plugin.account.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.account.bind.ui.BindMContactUI;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.base.h;

final class RegByMobileSetPwdUI$1
  implements View.OnClickListener
{
  RegByMobileSetPwdUI$1(RegByMobileSetPwdUI paramRegByMobileSetPwdUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(125438);
    paramView = (String)g.RL().Ru().get(6, null);
    if (bo.isNullOrNil(paramView))
    {
      ab.i("MicorMsg.RegByMobileSetPwdUI", "has not bind mobile");
      paramView = new Intent(this.gIO, BindMContactUI.class);
      paramView.putExtra("bind_scene", 4);
      h.a(this.gIO, this.gIO.getString(2131302451), "", this.gIO.getString(2131297657), this.gIO.getString(2131296888), true, new RegByMobileSetPwdUI.1.1(this, paramView), null);
      AppMethodBeat.o(125438);
      return;
    }
    ab.i("MicorMsg.RegByMobileSetPwdUI", "has bind mobile");
    h.a(this.gIO, this.gIO.getString(2131302449, new Object[] { paramView }), "", this.gIO.getString(2131297067), this.gIO.getString(2131296888), true, new RegByMobileSetPwdUI.1.2(this, paramView), null);
    AppMethodBeat.o(125438);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.RegByMobileSetPwdUI.1
 * JD-Core Version:    0.7.0.1
 */