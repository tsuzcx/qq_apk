package com.tencent.mm.plugin.ipcall.ui;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.d;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.bu;

final class IPCallMsgUI$4
  implements AdapterView.OnItemClickListener
{
  IPCallMsgUI$4(IPCallMsgUI paramIPCallMsgUI) {}
  
  public final void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(25808);
    b localb = new b();
    localb.bd(paramAdapterView);
    localb.bd(paramView);
    localb.mu(paramInt);
    localb.rl(paramLong);
    a.b("com/tencent/mm/plugin/ipcall/ui/IPCallMsgUI$4", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.ahF());
    paramAdapterView = (com.tencent.mm.plugin.ipcall.model.h.g)IPCallMsgUI.b(this.vdV).getItem(paramInt);
    if (!bu.isNullOrNil(paramAdapterView.field_descUrl))
    {
      paramInt = paramAdapterView.field_msgType;
      com.tencent.mm.plugin.report.service.g.yxI.f(13780, new Object[] { Integer.valueOf(paramInt) });
      paramView = new Intent();
      paramView.putExtra("rawUrl", paramAdapterView.field_descUrl);
      paramView.putExtra("showShare", false);
      d.b(this.vdV, "webview", ".ui.tools.WebViewUI", paramView);
    }
    a.a(this, "com/tencent/mm/plugin/ipcall/ui/IPCallMsgUI$4", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
    AppMethodBeat.o(25808);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.IPCallMsgUI.4
 * JD-Core Version:    0.7.0.1
 */