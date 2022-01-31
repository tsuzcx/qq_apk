package com.tencent.mm.plugin.aa.ui;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mm.br.d;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.c.k;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

final class AAQueryListUI$3
  implements AdapterView.OnItemClickListener
{
  AAQueryListUI$3(AAQueryListUI paramAAQueryListUI) {}
  
  public final void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    int i;
    if (AAQueryListUI.f(this.eXG) != null)
    {
      if ((paramInt < 0) || (paramInt >= AAQueryListUI.f(this.eXG).getCount()))
      {
        y.i("MicroMsg.AAQueryListUI", "click out of bound! %s", new Object[] { Integer.valueOf(paramInt) });
        return;
      }
      i = paramView.getTop();
      paramView = (k)AAQueryListUI.f(this.eXG).getItem(paramInt);
      if (paramView != null)
      {
        if (bk.bl(paramView.srC)) {
          break label141;
        }
        paramAdapterView = new Intent();
        paramAdapterView.putExtra("rawUrl", paramView.srC);
        d.b(this.eXG, "webview", ".ui.tools.WebViewUI", paramAdapterView);
      }
    }
    for (;;)
    {
      h.nFQ.f(13721, new Object[] { Integer.valueOf(5), Integer.valueOf(3) });
      return;
      label141:
      if (!bk.bl(paramView.srq))
      {
        paramAdapterView = null;
        if (paramView.srB == 2) {
          paramAdapterView = q.Gj();
        }
        Intent localIntent = new Intent(this.eXG, PaylistAAUI.class);
        localIntent.putExtra("bill_no", paramView.srq);
        localIntent.putExtra("launcher_user_name", paramAdapterView);
        localIntent.putExtra("enter_scene", 4);
        localIntent.putExtra("chatroom", paramView.srr);
        localIntent.putExtra("item_position", paramInt);
        localIntent.putExtra("item_offset", i);
        this.eXG.startActivityForResult(localIntent, 1);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.ui.AAQueryListUI.3
 * JD-Core Version:    0.7.0.1
 */