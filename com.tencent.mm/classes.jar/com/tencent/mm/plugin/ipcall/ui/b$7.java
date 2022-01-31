package com.tencent.mm.plugin.ipcall.ui;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.TextView;
import com.tencent.mm.plugin.ipcall.b.a;
import com.tencent.mm.plugin.ipcall.b.c;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bk;

final class b$7
  implements View.OnClickListener
{
  b$7(b paramb) {}
  
  public final void onClick(View paramView)
  {
    b localb = this.ltx;
    localb.ltm = localb.lte.getText().toString();
    localb.ltn = localb.ltf.getText().toString();
    if ((!bk.bl(localb.ltm)) && (!bk.bl(localb.ltn)))
    {
      localb.ltm = localb.lte.getText().toString().replace("+", "");
      localb.lto = a.av(localb.bER, localb.ltm + localb.ltn);
      localb.dWH = a.ax(localb.bER, localb.lto);
      paramView = c.Gi(localb.ltn);
      Object localObject = ae.getContext().getSharedPreferences("IPCall_LastInputPref", 0).edit();
      ((SharedPreferences.Editor)localObject).putString("IPCall_LastInputPhoneNumber", paramView);
      ((SharedPreferences.Editor)localObject).apply();
      String str = localb.lte.getText().toString();
      localObject = localb.ltl;
      if (!bk.bl(str))
      {
        paramView = (View)localObject;
        if (bk.bl((String)localObject)) {
          paramView = "";
        }
        localObject = ae.getContext().getSharedPreferences("IPCall_LastInputPref", 0).edit();
        ((SharedPreferences.Editor)localObject).putString("IPCall_LastInputCountryCode", str.replace("+", ""));
        ((SharedPreferences.Editor)localObject).putString("IPCall_LastInputCountryName", paramView);
        ((SharedPreferences.Editor)localObject).apply();
      }
      if (localb.ltc != null) {
        localb.ltc.n(localb.ltm, c.Gi(localb.ltn), localb.lto, localb.dWH);
      }
    }
    do
    {
      return;
      paramView = ae.getContext().getSharedPreferences("IPCall_LastInputPref", 0).getString("IPCall_LastInputPhoneNumber", "");
    } while (bk.bl(paramView));
    paramView = c.Gi(paramView);
    localb.ltn = b.dB(localb.lte.getText().toString().replace("+", ""), paramView);
    localb.bL(localb.ltn, -1);
    localb.bcQ();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.b.7
 * JD-Core Version:    0.7.0.1
 */