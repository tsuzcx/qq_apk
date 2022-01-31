package com.tencent.mm.plugin.ipcall.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.ui.MMActivity;

final class b$6
  implements View.OnClickListener
{
  b$6(b paramb) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(21976);
    h.qsU.e(12061, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0) });
    paramView = this.nQQ.nQx.getText().toString().replace("+", "");
    Intent localIntent = new Intent(this.nQQ.cmc, IPCallCountryCodeSelectUI.class);
    localIntent.putExtra("couttry_code", paramView);
    localIntent.putExtra("CountryCodeUI_isShowCountryCode", true);
    this.nQQ.cmc.startActivityForResult(localIntent, 100);
    this.nQQ.cmc.overridePendingTransition(2131034230, -1);
    AppMethodBeat.o(21976);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.b.6
 * JD-Core Version:    0.7.0.1
 */