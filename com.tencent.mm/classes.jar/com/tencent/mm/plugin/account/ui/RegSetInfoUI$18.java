package com.tencent.mm.plugin.account.ui;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.EditText;
import android.widget.TextView;
import com.tencent.mm.ui.base.o;

final class RegSetInfoUI$18
  implements AdapterView.OnItemClickListener
{
  RegSetInfoUI$18(RegSetInfoUI paramRegSetInfoUI, String[] paramArrayOfString) {}
  
  public final void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (RegSetInfoUI.t(this.fso) != null)
    {
      RegSetInfoUI.t(this.fso).dismiss();
      RegSetInfoUI.u(this.fso);
    }
    RegSetInfoUI.a(this.fso).setText(this.fst[paramInt]);
    RegSetInfoUI.a(this.fso).postDelayed(new Runnable()
    {
      public final void run()
      {
        RegSetInfoUI.a(RegSetInfoUI.18.this.fso).clearFocus();
        RegSetInfoUI.a(RegSetInfoUI.18.this.fso).requestFocus();
      }
    }, 50L);
    RegSetInfoUI.r(this.fso).setText(this.fso.getString(q.j.regsetinfo_tip));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.RegSetInfoUI.18
 * JD-Core Version:    0.7.0.1
 */