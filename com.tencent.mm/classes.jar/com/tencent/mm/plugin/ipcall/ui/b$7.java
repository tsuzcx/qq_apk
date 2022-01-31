package com.tencent.mm.plugin.ipcall.ui;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.ipcall.b.a;
import com.tencent.mm.plugin.ipcall.b.c;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;

final class b$7
  implements View.OnClickListener
{
  b$7(b paramb) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(21977);
    b localb = this.nQQ;
    localb.nQF = localb.nQx.getText().toString();
    localb.nQG = localb.nQy.getText().toString();
    if ((!bo.isNullOrNil(localb.nQF)) && (!bo.isNullOrNil(localb.nQG)))
    {
      localb.nQF = localb.nQx.getText().toString().replace("+", "");
      localb.nQH = a.aE(localb.cmc, localb.nQF + localb.nQG);
      localb.fmP = a.aG(localb.cmc, localb.nQH);
      paramView = c.RK(localb.nQG);
      Object localObject = ah.getContext().getSharedPreferences("IPCall_LastInputPref", 0).edit();
      ((SharedPreferences.Editor)localObject).putString("IPCall_LastInputPhoneNumber", paramView);
      ((SharedPreferences.Editor)localObject).apply();
      String str = localb.nQx.getText().toString();
      localObject = localb.nQE;
      if (!bo.isNullOrNil(str))
      {
        paramView = (View)localObject;
        if (bo.isNullOrNil((String)localObject)) {
          paramView = "";
        }
        localObject = ah.getContext().getSharedPreferences("IPCall_LastInputPref", 0).edit();
        ((SharedPreferences.Editor)localObject).putString("IPCall_LastInputCountryCode", str.replace("+", ""));
        ((SharedPreferences.Editor)localObject).putString("IPCall_LastInputCountryName", paramView);
        ((SharedPreferences.Editor)localObject).apply();
      }
      if (localb.nQv != null)
      {
        localb.nQv.p(localb.nQF, c.RK(localb.nQG), localb.nQH, localb.fmP);
        AppMethodBeat.o(21977);
      }
    }
    else
    {
      paramView = ah.getContext().getSharedPreferences("IPCall_LastInputPref", 0).getString("IPCall_LastInputPhoneNumber", "");
      if (!bo.isNullOrNil(paramView))
      {
        paramView = c.RK(paramView);
        localb.nQG = b.eT(localb.nQx.getText().toString().replace("+", ""), paramView);
        localb.cy(localb.nQG, -1);
        localb.bJZ();
      }
    }
    AppMethodBeat.o(21977);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.b.7
 * JD-Core Version:    0.7.0.1
 */