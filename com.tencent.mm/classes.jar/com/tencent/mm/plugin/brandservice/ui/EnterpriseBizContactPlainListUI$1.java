package com.tencent.mm.plugin.brandservice.ui;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class EnterpriseBizContactPlainListUI$1
  implements AdapterView.OnItemClickListener
{
  EnterpriseBizContactPlainListUI$1(EnterpriseBizContactPlainListUI paramEnterpriseBizContactPlainListUI) {}
  
  public final void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(13980);
    ab.i("MicroMsg.BrandService.EnterpriseBizContactPlainListUI", "onItemClick position = %s", new Object[] { Integer.valueOf(paramInt) });
    EnterpriseBizContactPlainListUI.a(this.jUA, paramInt);
    AppMethodBeat.o(13980);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.EnterpriseBizContactPlainListUI.1
 * JD-Core Version:    0.7.0.1
 */