package com.tencent.mm.plugin.fingerprint.b;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fingerprint.faceid.auth.WalletFaceIdAuthUI;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.base.i;

final class r$3
  implements View.OnClickListener
{
  r$3(r paramr, Activity paramActivity, Bundle paramBundle, i parami) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(41563);
    ab.i("MicroMsg.WalletSoterService", "click faceid btn");
    paramView = new Intent(this.gjR, WalletFaceIdAuthUI.class);
    paramView.putExtra("pwd", this.mGx.getString("key_pwd1"));
    paramView.putExtra("key_scene", 1);
    this.gjR.startActivity(paramView);
    this.iMU.dismiss();
    AppMethodBeat.o(41563);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.fingerprint.b.r.3
 * JD-Core Version:    0.7.0.1
 */