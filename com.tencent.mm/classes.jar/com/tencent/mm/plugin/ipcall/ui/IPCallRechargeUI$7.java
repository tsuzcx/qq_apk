package com.tencent.mm.plugin.ipcall.ui;

import android.content.Intent;
import android.content.res.Resources;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bq.d;
import com.tencent.mm.plugin.ipcall.b.a;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.List;

final class IPCallRechargeUI$7
  extends ClickableSpan
{
  IPCallRechargeUI$7(IPCallRechargeUI paramIPCallRechargeUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(22257);
    ((TextView)paramView).setHighlightColor(this.nUW.getResources().getColor(2131690605));
    Intent localIntent = new Intent();
    paramView = this.nUW.getString(2131300879) + "&usedcc=";
    Object localObject = com.tencent.mm.plugin.ipcall.a.c.bIZ().bJc();
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
        String str = a.RB(((Integer)((List)localObject).get(j)).toString());
        if (bo.isNullOrNil(str)) {
          break label255;
        }
        paramView = paramView + str + "|";
      }
    }
    label255:
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
        d.b(this.nUW, "webview", ".ui.tools.WebViewUI", localIntent);
        AppMethodBeat.o(22257);
        return;
      }
    }
  }
  
  public final void updateDrawState(TextPaint paramTextPaint)
  {
    AppMethodBeat.i(22258);
    paramTextPaint.setColor(this.nUW.getResources().getColor(2131690214));
    paramTextPaint.setUnderlineText(false);
    AppMethodBeat.o(22258);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.IPCallRechargeUI.7
 * JD-Core Version:    0.7.0.1
 */