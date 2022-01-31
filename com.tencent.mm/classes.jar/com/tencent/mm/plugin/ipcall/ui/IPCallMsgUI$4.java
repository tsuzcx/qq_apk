package com.tencent.mm.plugin.ipcall.ui;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bq.d;
import com.tencent.mm.plugin.ipcall.a.g.g;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.bo;

final class IPCallMsgUI$4
  implements AdapterView.OnItemClickListener
{
  IPCallMsgUI$4(IPCallMsgUI paramIPCallMsgUI) {}
  
  public final void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(22189);
    paramAdapterView = (g)IPCallMsgUI.b(this.nTV).getItem(paramInt);
    if (!bo.isNullOrNil(paramAdapterView.field_descUrl))
    {
      paramInt = paramAdapterView.field_msgType;
      h.qsU.e(13780, new Object[] { Integer.valueOf(paramInt) });
      paramView = new Intent();
      paramView.putExtra("rawUrl", paramAdapterView.field_descUrl);
      paramView.putExtra("showShare", false);
      d.b(this.nTV, "webview", ".ui.tools.WebViewUI", paramView);
    }
    AppMethodBeat.o(22189);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.IPCallMsgUI.4
 * JD-Core Version:    0.7.0.1
 */