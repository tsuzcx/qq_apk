package com.tencent.mm.plugin.ipcall.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.ui.MMActivity;

final class b$6
  implements View.OnClickListener
{
  b$6(b paramb) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(25593);
    Object localObject = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramView);
    a.b("com/tencent/mm/plugin/ipcall/ui/DialPadController$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
    h.CyF.a(12061, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0) });
    paramView = this.ytr.ysY.getText().toString().replace("+", "");
    localObject = new Intent(this.ytr.gte, IPCallCountryCodeSelectUI.class);
    ((Intent)localObject).putExtra("couttry_code", paramView);
    ((Intent)localObject).putExtra("CountryCodeUI_isShowCountryCode", true);
    this.ytr.gte.startActivityForResult((Intent)localObject, 100);
    this.ytr.gte.overridePendingTransition(2130772132, -1);
    a.a(this, "com/tencent/mm/plugin/ipcall/ui/DialPadController$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(25593);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.b.6
 * JD-Core Version:    0.7.0.1
 */