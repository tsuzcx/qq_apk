package com.tencent.mm.plugin.account.bind.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.account.a.a;
import com.tencent.mm.pluginsdk.n;

final class BindMobileVerifyUI$4
  implements View.OnClickListener
{
  BindMobileVerifyUI$4(BindMobileVerifyUI paramBindMobileVerifyUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(13532);
    this.guw.hideVKB();
    paramView = new Intent();
    Bundle localBundle = new Bundle();
    localBundle.putString("bindmcontact_mobile", BindMobileVerifyUI.b(this.guw));
    localBundle.putInt("voice_verify_type", 4);
    paramView.putExtras(localBundle);
    a.gmO.f(this.guw, paramView);
    AppMethodBeat.o(13532);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.account.bind.ui.BindMobileVerifyUI.4
 * JD-Core Version:    0.7.0.1
 */