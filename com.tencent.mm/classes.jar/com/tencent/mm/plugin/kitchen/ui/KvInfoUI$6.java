package com.tencent.mm.plugin.kitchen.ui;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import com.tencent.mm.plugin.kitchen.b.d;
import com.tencent.mm.plugin.report.service.d;
import com.tencent.mm.plugin.report.service.j;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.widget.a.c;
import java.util.HashMap;

final class KvInfoUI$6
  implements AdapterView.OnItemClickListener
{
  KvInfoUI$6(KvInfoUI paramKvInfoUI) {}
  
  public final void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = (d)KvInfoUI.b(this.lAA).getItem(paramInt);
    if (paramAdapterView == null) {}
    do
    {
      return;
      if ((paramAdapterView.bIW == null) || (paramAdapterView.bIW.length() <= 0)) {
        paramAdapterView.bIW = ad.bB(paramAdapterView.value);
      }
      paramAdapterView = paramAdapterView.bIW;
      paramAdapterView = (String)j.bxa().nGj.get(paramAdapterView);
      if (KvInfoUI.c(this.lAA) != null) {
        KvInfoUI.c(this.lAA).dismiss();
      }
    } while (bk.bl(paramAdapterView));
    KvInfoUI.a(this.lAA, h.a(this.lAA, paramAdapterView, "", this.lAA.getString(b.d.app_ok), this.lAA.getString(b.d.app_copy), true, new KvInfoUI.6.1(this), new KvInfoUI.6.2(this, paramAdapterView), -1));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.kitchen.ui.KvInfoUI.6
 * JD-Core Version:    0.7.0.1
 */