package com.tencent.mm.plugin.aa.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

final class AASelectContactUI$4$1
  implements DialogInterface.OnClickListener
{
  AASelectContactUI$4$1(AASelectContactUI.4 param4) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (AASelectContactUI.b(this.eYa.eXY).size() > AASelectContactUI.d(this.eYa.eXY))
    {
      com.tencent.mm.ui.base.h.b(this.eYa.eXY.mController.uMN, this.eYa.eXY.getString(a.i.launch_aa_by_person_number_exceed_limit_alert, new Object[] { Long.valueOf(AASelectContactUI.d(this.eYa.eXY)) }), "", true);
      com.tencent.mm.plugin.report.service.h.nFQ.f(13722, new Object[] { Integer.valueOf(3) });
      return;
    }
    paramDialogInterface = new LinkedList();
    paramDialogInterface.addAll(AASelectContactUI.b(this.eYa.eXY));
    paramDialogInterface = bk.c(paramDialogInterface, ",");
    this.eYa.eXY.setResult(-1, this.eYa.eXY.getIntent().putExtra("Select_Contact", paramDialogInterface));
    this.eYa.eXY.finish();
    com.tencent.mm.plugin.report.service.h.nFQ.f(13721, new Object[] { Integer.valueOf(2), Integer.valueOf(11) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.ui.AASelectContactUI.4.1
 * JD-Core Version:    0.7.0.1
 */