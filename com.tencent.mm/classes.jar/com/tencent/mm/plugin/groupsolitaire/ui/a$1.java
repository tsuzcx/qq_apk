package com.tencent.mm.plugin.groupsolitaire.ui;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.telephony.TelephonyManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aw.b;
import com.tencent.mm.aw.b.a;
import com.tencent.mm.plugin.account.bind.ui.BindMContactUI;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import junit.framework.Assert;

final class a$1
  implements DialogInterface.OnClickListener
{
  a$1(a parama) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(110412);
    Intent localIntent = new Intent(this.tzc.mContext, BindMContactUI.class);
    localIntent.putExtra("bind_scene", 0);
    paramDialogInterface = ((TelephonyManager)this.tzc.mContext.getSystemService("phone")).getSimCountryIso();
    if (!bs.isNullOrNil(paramDialogInterface))
    {
      paramDialogInterface = b.bp(paramDialogInterface, this.tzc.mContext.getString(2131757950));
      if (paramDialogInterface != null)
      {
        localIntent.putExtra("country_name", paramDialogInterface.hLr);
        localIntent.putExtra("couttry_code", paramDialogInterface.hLq);
      }
    }
    Context localContext = this.tzc.mContext;
    ac.i("MicroMsg.TiemDatePicker", "startWizardActivity()");
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.groupsolitaire.ui.a.1
 * JD-Core Version:    0.7.0.1
 */