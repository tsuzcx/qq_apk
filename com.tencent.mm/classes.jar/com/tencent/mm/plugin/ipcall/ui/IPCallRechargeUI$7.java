package com.tencent.mm.plugin.ipcall.ui;

import android.content.Intent;
import android.content.res.Resources;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.TextView;
import com.tencent.mm.R.e;
import com.tencent.mm.R.l;
import com.tencent.mm.br.d;
import com.tencent.mm.plugin.ipcall.b.a;
import com.tencent.mm.sdk.platformtools.bk;
import java.util.List;

final class IPCallRechargeUI$7
  extends ClickableSpan
{
  IPCallRechargeUI$7(IPCallRechargeUI paramIPCallRechargeUI) {}
  
  public final void onClick(View paramView)
  {
    ((TextView)paramView).setHighlightColor(this.lxJ.getResources().getColor(R.e.transparent));
    Intent localIntent = new Intent();
    paramView = this.lxJ.getString(R.l.ip_call_recharge_price_url) + "&usedcc=";
    Object localObject = com.tencent.mm.plugin.ipcall.a.c.bbS().bbV();
    int j;
    if (((List)localObject).size() > 0)
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
          break label245;
        }
        paramView = paramView + str + "|";
      }
    }
    label245:
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
        d.b(this.lxJ, "webview", ".ui.tools.WebViewUI", localIntent);
        return;
      }
    }
  }
  
  public final void updateDrawState(TextPaint paramTextPaint)
  {
    paramTextPaint.setColor(this.lxJ.getResources().getColor(R.e.link_color));
    paramTextPaint.setUnderlineText(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.IPCallRechargeUI.7
 * JD-Core Version:    0.7.0.1
 */