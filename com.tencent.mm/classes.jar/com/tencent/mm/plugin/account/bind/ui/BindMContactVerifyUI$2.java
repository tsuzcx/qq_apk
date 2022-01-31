package com.tencent.mm.plugin.account.bind.ui;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.h;

final class BindMContactVerifyUI$2
  implements View.OnClickListener
{
  BindMContactVerifyUI$2(BindMContactVerifyUI paramBindMContactVerifyUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(13480);
    paramView = BindMContactVerifyUI.a(this.gtS).getText().toString().trim();
    if (bo.isNullOrNil(paramView))
    {
      h.h(this.gtS, 2131297622, 2131297087);
      AppMethodBeat.o(13480);
      return;
    }
    this.gtS.hideVKB();
    BindMContactVerifyUI.a(this.gtS, paramView);
    AppMethodBeat.o(13480);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.account.bind.ui.BindMContactVerifyUI.2
 * JD-Core Version:    0.7.0.1
 */