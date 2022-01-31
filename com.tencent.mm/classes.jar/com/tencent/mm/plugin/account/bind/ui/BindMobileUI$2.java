package com.tencent.mm.plugin.account.bind.ui;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

final class BindMobileUI$2
  implements View.OnClickListener
{
  BindMobileUI$2(BindMobileUI paramBindMobileUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(13510);
    if ((BindMobileUI.a(this.gus).getText().toString() == null) || (BindMobileUI.a(this.gus).getText().toString().length() == 0))
    {
      Toast.makeText(this.gus, this.gus.getString(2131297569), 0).show();
      AppMethodBeat.o(13510);
      return;
    }
    BindMobileUI.b(this.gus, BindMobileUI.b(this.gus).getText().toString().trim() + bo.RK(BindMobileUI.a(this.gus).getText().toString()));
    ab.i("MicroMsg.BindMContactUI", "do next, send sms to self");
    BindMobileUI.c(this.gus, BindMobileUI.c(this.gus));
    AppMethodBeat.o(13510);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.account.bind.ui.BindMobileUI.2
 * JD-Core Version:    0.7.0.1
 */