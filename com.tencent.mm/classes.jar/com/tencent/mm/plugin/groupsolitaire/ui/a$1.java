package com.tencent.mm.plugin.groupsolitaire.ui;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.telephony.TelephonyManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ax.b;
import com.tencent.mm.ax.b.a;
import com.tencent.mm.plugin.account.bind.ui.BindMContactUI;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import junit.framework.Assert;

final class a$1
  implements DialogInterface.OnClickListener
{
  a$1(a parama) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(110412);
    Intent localIntent = new Intent(this.srl.mContext, BindMContactUI.class);
    localIntent.putExtra("bind_scene", 0);
    paramDialogInterface = ((TelephonyManager)this.srl.mContext.getSystemService("phone")).getSimCountryIso();
    if (!bt.isNullOrNil(paramDialogInterface))
    {
      paramDialogInterface = b.bh(paramDialogInterface, this.srl.mContext.getString(2131757950));
      if (paramDialogInterface != null)
      {
        localIntent.putExtra("country_name", paramDialogInterface.hkO);
        localIntent.putExtra("couttry_code", paramDialogInterface.hkN);
      }
    }
    Context localContext = this.srl.mContext;
    ad.i("MicroMsg.TiemDatePicker", "startWizardActivity()");
    Assert.assertTrue("startWizardActivity: Param context should be a Activity :" + localContext.toString(), localContext instanceof Activity);
    paramDialogInterface = ((Activity)localContext).getIntent();
    String str;
    if (paramDialogInterface != null)
    {
      str = paramDialogInterface.getStringExtra("WizardRootClass");
      paramDialogInterface = paramDialogInterface.getStringExtra("WizardTransactionId");
    }
    for (;;)
    {
      localIntent.putExtra("WizardRootClass", str);
      if (paramDialogInterface != null) {
        localIntent.putExtra("WizardTransactionId", paramDialogInterface);
      }
      ((Activity)localContext).startActivityForResult(localIntent, 4098);
      AppMethodBeat.o(110412);
      return;
      paramDialogInterface = null;
      str = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.groupsolitaire.ui.a.1
 * JD-Core Version:    0.7.0.1
 */