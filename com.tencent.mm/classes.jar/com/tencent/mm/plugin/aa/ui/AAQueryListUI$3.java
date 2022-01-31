package com.tencent.mm.plugin.aa.ui;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bq.d;
import com.tencent.mm.model.r;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.k;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

final class AAQueryListUI$3
  implements AdapterView.OnItemClickListener
{
  AAQueryListUI$3(AAQueryListUI paramAAQueryListUI) {}
  
  public final void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(40730);
    int i;
    if (AAQueryListUI.f(this.gpD) != null)
    {
      if ((paramInt < 0) || (paramInt >= AAQueryListUI.f(this.gpD).getCount()))
      {
        ab.i("MicroMsg.AAQueryListUI", "click out of bound! %s", new Object[] { Integer.valueOf(paramInt) });
        AppMethodBeat.o(40730);
        return;
      }
      i = paramView.getTop();
      paramView = (k)AAQueryListUI.f(this.gpD).getItem(paramInt);
      if (paramView != null)
      {
        if (bo.isNullOrNil(paramView.wki)) {
          break label156;
        }
        paramAdapterView = new Intent();
        paramAdapterView.putExtra("rawUrl", paramView.wki);
        d.b(this.gpD, "webview", ".ui.tools.WebViewUI", paramAdapterView);
      }
    }
    for (;;)
    {
      h.qsU.e(13721, new Object[] { Integer.valueOf(5), Integer.valueOf(3) });
      AppMethodBeat.o(40730);
      return;
      label156:
      if (!bo.isNullOrNil(paramView.wjW))
      {
        paramAdapterView = null;
        if (paramView.wkh == 2) {
          paramAdapterView = r.Zn();
        }
        Intent localIntent = new Intent(this.gpD, PaylistAAUI.class);
        localIntent.putExtra("bill_no", paramView.wjW);
        localIntent.putExtra("launcher_user_name", paramAdapterView);
        localIntent.putExtra("enter_scene", 4);
        localIntent.putExtra("chatroom", paramView.wjX);
        localIntent.putExtra("item_position", paramInt);
        localIntent.putExtra("item_offset", i);
        this.gpD.startActivityForResult(localIntent, 1);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.ui.AAQueryListUI.3
 * JD-Core Version:    0.7.0.1
 */