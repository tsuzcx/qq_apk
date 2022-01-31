package com.tencent.mm.plugin.fingerprint.faceid.auth;

import android.app.Dialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatDialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

public class WalletFaceIdAuthFragment
  extends AppCompatDialogFragment
{
  private Dialog mDialog;
  private a mFj;
  private Bundle mFk;
  
  public Dialog onCreateDialog(Bundle paramBundle)
  {
    AppMethodBeat.i(41363);
    this.mDialog = new WalletFaceIdDialog(getActivity(), this.mFj, this.mFk);
    this.mDialog.setCancelable(false);
    paramBundle = this.mDialog;
    AppMethodBeat.o(41363);
    return paramBundle;
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    AppMethodBeat.i(41362);
    getDialog().requestWindowFeature(1);
    paramLayoutInflater = super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    AppMethodBeat.o(41362);
    return paramLayoutInflater;
  }
  
  public void onPause()
  {
    AppMethodBeat.i(41364);
    super.onPause();
    ab.d("MicroMsg.WalletFaceIdAuthFragment", "on pause");
    AppMethodBeat.o(41364);
  }
  
  public void onStop()
  {
    AppMethodBeat.i(41365);
    super.onStop();
    ab.d("MicroMsg.WalletFaceIdAuthFragment", "on stop");
    if (this.mDialog != null) {
      this.mDialog.dismiss();
    }
    AppMethodBeat.o(41365);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.fingerprint.faceid.auth.WalletFaceIdAuthFragment
 * JD-Core Version:    0.7.0.1
 */