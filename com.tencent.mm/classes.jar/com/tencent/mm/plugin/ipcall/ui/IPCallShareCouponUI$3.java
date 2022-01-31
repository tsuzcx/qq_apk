package com.tencent.mm.plugin.ipcall.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bq.d;
import com.tencent.mm.plugin.ipcall.b.a;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.List;

final class IPCallShareCouponUI$3
  implements View.OnClickListener
{
  IPCallShareCouponUI$3(IPCallShareCouponUI paramIPCallShareCouponUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(22319);
    Intent localIntent = new Intent();
    paramView = this.nWj.getString(2131300879) + "&usedcc=";
    Object localObject = com.tencent.mm.plugin.ipcall.a.c.bIZ().bJc();
    int j;
    if ((localObject != null) && (((List)localObject).size() > 0))
    {
      j = ((List)localObject).size();
      int i = j;
      if (j > 5) {
        i = 5;
      }
      j = 0;
      if (j < i)
      {
        String str = a.RB(((Integer)((List)localObject).get(j)).toString());
        if (bo.isNullOrNil(str)) {
          break label241;
        }
        paramView = paramView + str + "|";
      }
    }
    label241:
    for (;;)
    {
      j += 1;
      break;
      localObject = paramView;
      if (paramView.endsWith("|")) {}
      for (localObject = paramView.substring(0, paramView.length() - 1);; localObject = paramView + a.RB(com.tencent.mm.plugin.ipcall.b.c.bKM()))
      {
        localIntent.putExtra("rawUrl", (String)localObject);
        localIntent.putExtra("showShare", false);
        d.b(this.nWj, "webview", ".ui.tools.WebViewUI", localIntent);
        AppMethodBeat.o(22319);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.IPCallShareCouponUI.3
 * JD-Core Version:    0.7.0.1
 */