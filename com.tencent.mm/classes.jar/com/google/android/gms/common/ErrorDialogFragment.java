package com.google.android.gms.common;

import android.app.Dialog;
import android.app.DialogFragment;
import android.app.FragmentManager;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.os.Bundle;
import com.google.android.gms.common.internal.Preconditions;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class ErrorDialogFragment
  extends DialogFragment
{
  private Dialog mDialog = null;
  private DialogInterface.OnCancelListener zzap = null;
  
  public static ErrorDialogFragment newInstance(Dialog paramDialog)
  {
    AppMethodBeat.i(60412);
    paramDialog = newInstance(paramDialog, null);
    AppMethodBeat.o(60412);
    return paramDialog;
  }
  
  public static ErrorDialogFragment newInstance(Dialog paramDialog, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    AppMethodBeat.i(60413);
    ErrorDialogFragment localErrorDialogFragment = new ErrorDialogFragment();
    paramDialog = (Dialog)Preconditions.checkNotNull(paramDialog, "Cannot display null dialog");
    paramDialog.setOnCancelListener(null);
    paramDialog.setOnDismissListener(null);
    localErrorDialogFragment.mDialog = paramDialog;
    if (paramOnCancelListener != null) {
      localErrorDialogFragment.zzap = paramOnCancelListener;
    }
    AppMethodBeat.o(60413);
    return localErrorDialogFragment;
  }
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(60411);
    if (this.zzap != null) {
      this.zzap.onCancel(paramDialogInterface);
    }
    AppMethodBeat.o(60411);
  }
  
  public Dialog onCreateDialog(Bundle paramBundle)
  {
    AppMethodBeat.i(60410);
    if (this.mDialog == null) {
      setShowsDialog(false);
    }
    paramBundle = this.mDialog;
    AppMethodBeat.o(60410);
    return paramBundle;
  }
  
  public void show(FragmentManager paramFragmentManager, String paramString)
  {
    AppMethodBeat.i(60414);
    super.show(paramFragmentManager, paramString);
    AppMethodBeat.o(60414);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.google.android.gms.common.ErrorDialogFragment
 * JD-Core Version:    0.7.0.1
 */