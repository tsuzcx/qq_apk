package com.tencent.mm.plugin.aa.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

final class AASelectContactUI$4$1
  implements DialogInterface.OnClickListener
{
  AASelectContactUI$4$1(AASelectContactUI.4 param4) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(40752);
    if (AASelectContactUI.b(this.gpX.gpV).size() > AASelectContactUI.d(this.gpX.gpV))
    {
      com.tencent.mm.ui.base.h.b(this.gpX.gpV.getContext(), this.gpX.gpV.getString(2131301037, new Object[] { Long.valueOf(AASelectContactUI.d(this.gpX.gpV)) }), "", true);
      com.tencent.mm.plugin.report.service.h.qsU.e(13722, new Object[] { Integer.valueOf(3) });
      AppMethodBeat.o(40752);
      return;
    }
    paramDialogInterface = new LinkedList();
    paramDialogInterface.addAll(AASelectContactUI.b(this.gpX.gpV));
    paramDialogInterface = bo.d(paramDialogInterface, ",");
    this.gpX.gpV.setResult(-1, this.gpX.gpV.getIntent().putExtra("Select_Contact", paramDialogInterface));
    this.gpX.gpV.finish();
    com.tencent.mm.plugin.report.service.h.qsU.e(13721, new Object[] { Integer.valueOf(2), Integer.valueOf(11) });
    AppMethodBeat.o(40752);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.ui.AASelectContactUI.4.1
 * JD-Core Version:    0.7.0.1
 */