package com.tencent.mm.plugin.fingerprint.faceid.auth;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.app.AppCompatDialogFragment;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;

public class WalletFaceIdAuthFragment
  extends AppCompatDialogFragment
{
  private a Bxu;
  private Bundle Bxv;
  private Dialog mDialog;
  
  public Dialog onCreateDialog(Bundle paramBundle)
  {
    AppMethodBeat.i(64227);
    this.mDialog = new WalletFaceIdDialog(getActivity(), this.Bxu, this.Bxv);
    this.mDialog.setCancelable(false);
    paramBundle = this.mDialog;
    AppMethodBeat.o(64227);
    return paramBundle;
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    AppMethodBeat.i(64226);
    getDialog().requestWindowFeature(1);
    paramLayoutInflater = super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    AppMethodBeat.o(64226);
    return paramLayoutInflater;
  }
  
  public void onPause()
  {
    AppMethodBeat.i(64228);
    super.onPause();
    Log.d("MicroMsg.WalletFaceIdAuthFragment", "on pause");
    AppMethodBeat.o(64228);
  }
  
  public void onStop()
  {
    AppMethodBeat.i(64229);
    super.onStop();
    Log.d("MicroMsg.WalletFaceIdAuthFragment", "on stop");
    if (this.mDialog != null) {
      this.mDialog.dismiss();
    }
    AppMethodBeat.o(64229);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.fingerprint.faceid.auth.WalletFaceIdAuthFragment
 * JD-Core Version:    0.7.0.1
 */