package com.tencent.mm.plugin.label.ui;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.model.bc;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;

public class ContactLabelBaseUI
  extends MMActivity
{
  private ProgressDialog jbE;
  
  public final void acP(String paramString)
  {
    AppMethodBeat.i(26161);
    h.d(this, paramString, "", new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
    });
    AppMethodBeat.o(26161);
  }
  
  public final void aps(String paramString)
  {
    AppMethodBeat.i(26159);
    getString(2131755906);
    this.jbE = h.b(this, paramString, true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(26158);
        bc.ajj().cancel(636);
        AppMethodBeat.o(26158);
      }
    });
    AppMethodBeat.o(26159);
  }
  
  public int getLayoutId()
  {
    return 0;
  }
  
  public final void hideLoading()
  {
    AppMethodBeat.i(26160);
    if ((this.jbE != null) && (this.jbE.isShowing())) {
      this.jbE.dismiss();
    }
    AppMethodBeat.o(26160);
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