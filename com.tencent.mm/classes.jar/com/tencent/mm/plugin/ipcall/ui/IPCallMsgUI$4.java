package com.tencent.mm.plugin.ipcall.ui;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.c;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.ipcall.model.h.g;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Util;

final class IPCallMsgUI$4
  implements AdapterView.OnItemClickListener
{
  IPCallMsgUI$4(IPCallMsgUI paramIPCallMsgUI) {}
  
  public final void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(25808);
    b localb = new b();
    localb.cH(paramAdapterView);
    localb.cH(paramView);
    localb.sc(paramInt);
    localb.hB(paramLong);
    a.c("com/tencent/mm/plugin/ipcall/ui/IPCallMsgUI$4", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.aYj());
    paramAdapterView = (g)IPCallMsgUI.b(this.JNI).getItem(paramInt);
    if (!Util.isNullOrNil(paramAdapterView.field_descUrl))
    {
      paramInt = paramAdapterView.field_msgType;
      h.OAn.b(13780, new Object[] { Integer.valueOf(paramInt) });
      paramView = new Intent();
      paramView.putExtra("rawUrl", paramAdapterView.field_descUrl);
      paramView.putExtra("showShare", false);
      c.b(this.JNI, "webview", ".ui.tools.WebViewUI", paramView);
    }
    a.a(this, "com/tencent/mm/plugin/ipcall/ui/IPCallMsgUI$4", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
    AppMethodBeat.o(25808);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.IPCallMsgUI.4
 * JD-Core Version:    0.7.0.1
 */