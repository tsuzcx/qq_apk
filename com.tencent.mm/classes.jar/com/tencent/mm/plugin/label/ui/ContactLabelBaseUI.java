package com.tencent.mm.plugin.label.ui;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.t;
import com.tencent.mm.model.bg;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;

public class ContactLabelBaseUI
  extends MMActivity
{
  private ProgressDialog jZH;
  
  public final void aCL(String paramString)
  {
    AppMethodBeat.i(26159);
    getString(2131755998);
    this.jZH = h.a(this, paramString, true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(26158);
        bg.azz().cancel(636);
        AppMethodBeat.o(26158);
      }
    });
    AppMethodBeat.o(26159);
  }
  
  public final void amW(String paramString)
  {
    AppMethodBeat.i(26161);
    h.d(this, paramString, "", new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
    });
    AppMethodBeat.o(26161);
  }
  
  public int getLayoutId()
  {
    return 0;
  }
  
  public final void hideLoading()
  {
    AppMethodBeat.i(26160);
    if ((this.jZH != null) && (this.jZH.isShowing())) {
      this.jZH.dismiss();
    }
    AppMethodBeat.o(26160);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.label.ui.ContactLabelBaseUI
 * JD-Core Version:    0.7.0.1
 */