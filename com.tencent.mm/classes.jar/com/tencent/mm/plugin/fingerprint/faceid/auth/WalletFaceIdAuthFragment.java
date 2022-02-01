package com.tencent.mm.plugin.fingerprint.faceid.auth;

import android.app.Dialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatDialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;

public class WalletFaceIdAuthFragment
  extends AppCompatDialogFragment
{
  private Dialog mDialog;
  private a tfX;
  private Bundle tfY;
  
  public Dialog onCreateDialog(Bundle paramBundle)
  {
    AppMethodBeat.i(64227);
    this.mDialog = new WalletFaceIdDialog(getActivity(), this.tfX, this.tfY);
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
    ad.d("MicroMsg.WalletFaceIdAuthFragment", "on pause");
    AppMethodBeat.o(64228);
  }
  
  public void onStop()
  {
    AppMethodBeat.i(64229);
    super.onStop();
    ad.d("MicroMsg.WalletFaceIdAuthFragment", "on stop");
    if (this.mDialog != null) {
      this.mDialog.dismiss();
    }
    AppMethodBeat.o(64229);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fingerprint.faceid.auth.WalletFaceIdAuthFragment
 * JD-Core Version:    0.7.0.1
 */