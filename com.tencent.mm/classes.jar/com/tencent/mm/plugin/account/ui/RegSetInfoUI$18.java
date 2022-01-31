package com.tencent.mm.plugin.account.ui;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.EditText;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.o;

final class RegSetInfoUI$18
  implements AdapterView.OnItemClickListener
{
  RegSetInfoUI$18(RegSetInfoUI paramRegSetInfoUI, String[] paramArrayOfString) {}
  
  public final void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(125526);
    if (RegSetInfoUI.t(this.gJQ) != null)
    {
      RegSetInfoUI.t(this.gJQ).dismiss();
      RegSetInfoUI.u(this.gJQ);
    }
    RegSetInfoUI.a(this.gJQ).setText(this.gJV[paramInt]);
    RegSetInfoUI.a(this.gJQ).postDelayed(new RegSetInfoUI.18.1(this), 50L);
    RegSetInfoUI.r(this.gJQ).setText(this.gJQ.getString(2131302501));
    AppMethodBeat.o(125526);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.RegSetInfoUI.18
 * JD-Core Version:    0.7.0.1
 */