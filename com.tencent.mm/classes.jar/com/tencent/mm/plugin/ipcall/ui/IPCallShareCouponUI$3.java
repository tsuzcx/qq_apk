package com.tencent.mm.plugin.ipcall.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.R.l;
import com.tencent.mm.br.d;
import com.tencent.mm.plugin.ipcall.b.a;
import com.tencent.mm.sdk.platformtools.bk;
import java.util.List;

final class IPCallShareCouponUI$3
  implements View.OnClickListener
{
  IPCallShareCouponUI$3(IPCallShareCouponUI paramIPCallShareCouponUI) {}
  
  public final void onClick(View paramView)
  {
    Intent localIntent = new Intent();
    paramView = this.lyX.getString(R.l.ip_call_recharge_price_url) + "&usedcc=";
    Object localObject = com.tencent.mm.plugin.ipcall.a.c.bbS().bbV();
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
        String str = a.FZ(((Integer)((List)localObject).get(j)).toString());
        if (bk.bl(str)) {
          break label230;
        }
        paramView = paramView + str + "|";
      }
    }
    label230:
    for (;;)
    {
      j += 1;
      break;
      localObject = paramView;
      if (paramView.endsWith("|")) {}
      for (localObject = paramView.substring(0, paramView.length() - 1);; localObject = paramView + a.FZ(com.tencent.mm.plugin.ipcall.b.c.bdr()))
      {
        localIntent.putExtra("rawUrl", (String)localObject);
        localIntent.putExtra("showShare", false);
        d.b(this.lyX, "webview", ".ui.tools.WebViewUI", localIntent);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.IPCallShareCouponUI.3
 * JD-Core Version:    0.7.0.1
 */