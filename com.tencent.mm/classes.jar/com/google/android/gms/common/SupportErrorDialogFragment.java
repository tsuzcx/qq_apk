package com.google.android.gms.common;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.g;
import com.google.android.gms.common.internal.Preconditions;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class SupportErrorDialogFragment
  extends DialogFragment
{
  private Dialog mDialog = null;
  private DialogInterface.OnCancelListener zzap = null;
  
  public static SupportErrorDialogFragment newInstance(Dialog paramDialog)
  {
    AppMethodBeat.i(10966);
    paramDialog = newInstance(paramDialog, null);
    AppMethodBeat.o(10966);
    return paramDialog;
  }
  
  public static SupportErrorDialogFragment newInstance(Dialog paramDialog, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    AppMethodBeat.i(10967);
    SupportErrorDialogFragment localSupportErrorDialogFragment = new SupportErrorDialogFragment();
    paramDialog = (Dialog)Preconditions.checkNotNull(paramDialog, "Cannot display null dialog");
    paramDialog.setOnCancelListener(null);
    paramDialog.setOnDismissListener(null);
    localSupportErrorDialogFragment.mDialog = paramDialog;
    if (paramOnCancelListener != null) {
      localSupportErrorDialogFragment.zzap = paramOnCancelListener;
    }
    AppMethodBeat.o(10967);
    return localSupportErrorDialogFragment;
  }
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(10965);
    if (this.zzap != null) {
      this.zzap.onCancel(paramDialogInterface);
    }
    AppMethodBeat.o(10965);
  }
  
  public Dialog onCreateDialog(Bundle paramBundle)
  {
    AppMethodBeat.i(10964);
    if (this.mDialog == null) {
      setShowsDialog(false);
    }
    paramBundle = this.mDialog;
    AppMethodBeat.o(10964);
    return paramBundle;
  }
  
  public void show(g paramg, String paramString)
  {
    AppMethodBeat.i(10968);
    super.show(paramg, paramString);
    AppMethodBeat.o(10968);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.google.android.gms.common.SupportErrorDialogFragment
 * JD-Core Version:    0.7.0.1
 */