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
    AppMethodBeat.i(60474);
    paramDialog = newInstance(paramDialog, null);
    AppMethodBeat.o(60474);
    return paramDialog;
  }
  
  public static SupportErrorDialogFragment newInstance(Dialog paramDialog, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    AppMethodBeat.i(60475);
    SupportErrorDialogFragment localSupportErrorDialogFragment = new SupportErrorDialogFragment();
    paramDialog = (Dialog)Preconditions.checkNotNull(paramDialog, "Cannot display null dialog");
    paramDialog.setOnCancelListener(null);
    paramDialog.setOnDismissListener(null);
    localSupportErrorDialogFragment.mDialog = paramDialog;
    if (paramOnCancelListener != null) {
      localSupportErrorDialogFragment.zzap = paramOnCancelListener;
    }
    AppMethodBeat.o(60475);
    return localSupportErrorDialogFragment;
  }
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(60473);
    if (this.zzap != null) {
      this.zzap.onCancel(paramDialogInterface);
    }
    AppMethodBeat.o(60473);
  }
  
  public Dialog onCreateDialog(Bundle paramBundle)
  {
    AppMethodBeat.i(60472);
    if (this.mDialog == null) {
      setShowsDialog(false);
    }
    paramBundle = this.mDialog;
    AppMethodBeat.o(60472);
    return paramBundle;
  }
  
  public void show(g paramg, String paramString)
  {
    AppMethodBeat.i(60476);
    super.show(paramg, paramString);
    AppMethodBeat.o(60476);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.google.android.gms.common.SupportErrorDialogFragment
 * JD-Core Version:    0.7.0.1
 */