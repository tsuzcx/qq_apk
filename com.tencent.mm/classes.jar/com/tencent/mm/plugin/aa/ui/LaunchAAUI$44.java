package com.tencent.mm.plugin.aa.ui;

import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.view.inputmethod.InputMethodManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cb.a;
import com.tencent.mm.ui.widget.MMEditText;

final class LaunchAAUI$44
  implements View.OnFocusChangeListener
{
  LaunchAAUI$44(LaunchAAUI paramLaunchAAUI) {}
  
  public final void onFocusChange(View paramView, boolean paramBoolean)
  {
    AppMethodBeat.i(213069);
    if (paramView.isFocused())
    {
      LaunchAAUI.a(this.jXQ).setPadding(0, a.fromDPToPix(this.jXQ.getContext(), 12), 0, a.fromDPToPix(this.jXQ.getContext(), 16));
      LaunchAAUI.a(this.jXQ).setHint("");
      ((InputMethodManager)this.jXQ.getContext().getSystemService("input_method")).showSoftInput(LaunchAAUI.a(this.jXQ), 0);
      AppMethodBeat.o(213069);
      return;
    }
    if (LaunchAAUI.a(this.jXQ).getText().length() > 0)
    {
      LaunchAAUI.a(this.jXQ).setPadding(0, a.fromDPToPix(this.jXQ.getContext(), 12), 0, a.fromDPToPix(this.jXQ.getContext(), 16));
      AppMethodBeat.o(213069);
      return;
    }
    LaunchAAUI.a(this.jXQ).setPadding(0, a.fromDPToPix(this.jXQ.getContext(), 28), 0, a.fromDPToPix(this.jXQ.getContext(), 16));
    LaunchAAUI.a(this.jXQ).setHint(this.jXQ.getString(2131762174));
    AppMethodBeat.o(213069);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.ui.LaunchAAUI.44
 * JD-Core Version:    0.7.0.1
 */