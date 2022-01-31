package com.tencent.mm.plugin.label.ui;

import android.app.Activity;
import android.app.ProgressDialog;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;

public class ContactLabelBaseUI
  extends MMActivity
{
  private ProgressDialog gsr;
  
  public final void La(String paramString)
  {
    AppMethodBeat.i(22539);
    h.a(this, paramString, "", new ContactLabelBaseUI.2(this));
    AppMethodBeat.o(22539);
  }
  
  public final void RS(String paramString)
  {
    AppMethodBeat.i(22537);
    getString(2131297087);
    this.gsr = h.b(this, paramString, true, new ContactLabelBaseUI.1(this));
    AppMethodBeat.o(22537);
  }
  
  public int getLayoutId()
  {
    return 0;
  }
  
  public final void hideLoading()
  {
    AppMethodBeat.i(22538);
    if ((this.gsr != null) && (this.gsr.isShowing())) {
      this.gsr.dismiss();
    }
    AppMethodBeat.o(22538);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.label.ui.ContactLabelBaseUI
 * JD-Core Version:    0.7.0.1
 */