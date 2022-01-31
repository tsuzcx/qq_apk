package com.tencent.mm.plugin.mall.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.wallet_core.model.mall.MallFunction;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;

final class MallIndexBaseUI$2$1
  implements DialogInterface.OnClickListener
{
  MallIndexBaseUI$2$1(MallIndexBaseUI.2 param2, MallFunction paramMallFunction, int paramInt) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    int j = 0;
    AppMethodBeat.i(43166);
    String str1 = this.ozD.pUM;
    String str2;
    if (!bo.isNullOrNil(str1))
    {
      g.RM();
      str2 = (String)g.RL().Ru().get(ac.a.yBp, null);
      if (!bo.isNullOrNil(str2)) {
        break label99;
      }
    }
    for (paramDialogInterface = str1;; paramDialogInterface = str1)
    {
      g.RM();
      g.RL().Ru().set(ac.a.yBp, paramDialogInterface);
      this.ozF.ozC.a(this.ozD, this.ozE);
      AppMethodBeat.o(43166);
      return;
      label99:
      paramDialogInterface = str2.split(",");
      if ((paramDialogInterface != null) && (paramDialogInterface.length != 0)) {
        break;
      }
    }
    paramInt = 0;
    for (;;)
    {
      int i = j;
      if (paramInt < paramDialogInterface.length)
      {
        if (paramDialogInterface[paramInt].equals(str1)) {
          i = 1;
        }
      }
      else
      {
        paramDialogInterface = str2;
        if (i != 0) {
          break;
        }
        paramDialogInterface = str2 + "," + str1;
        break;
      }
      paramInt += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.mall.ui.MallIndexBaseUI.2.1
 * JD-Core Version:    0.7.0.1
 */