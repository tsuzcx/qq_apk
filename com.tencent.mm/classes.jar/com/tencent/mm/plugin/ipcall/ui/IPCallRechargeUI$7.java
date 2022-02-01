package com.tencent.mm.plugin.ipcall.ui;

import android.content.Intent;
import android.content.res.Resources;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.d;
import com.tencent.mm.plugin.ipcall.a.a;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.List;

final class IPCallRechargeUI$7
  extends ClickableSpan
{
  IPCallRechargeUI$7(IPCallRechargeUI paramIPCallRechargeUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(25877);
    ((TextView)paramView).setHighlightColor(this.veW.getResources().getColor(2131101053));
    Intent localIntent = new Intent();
    paramView = this.veW.getString(2131760480) + "&usedcc=";
    Object localObject = com.tencent.mm.plugin.ipcall.model.c.dgj().dgm();
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
        String str = a.apc(((Integer)((List)localObject).get(j)).toString());
        if (bu.isNullOrNil(str)) {
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
      for (localObject = paramView.substring(0, paramView.length() - 1);; localObject = paramView + a.apc(com.tencent.mm.plugin.ipcall.a.c.dhX()))
      {
        localIntent.putExtra("rawUrl", (String)localObject);
        localIntent.putExtra("showShare", false);
        d.b(this.veW, "webview", ".ui.tools.WebViewUI", localIntent);
        AppMethodBeat.o(25877);
        return;
      }
    }
  }
  
  public final void updateDrawState(TextPaint paramTextPaint)
  {
    AppMethodBeat.i(25878);
    paramTextPaint.setColor(this.veW.getResources().getColor(2131100547));
    paramTextPaint.setUnderlineText(false);
    AppMethodBeat.o(25878);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.IPCallRechargeUI.7
 * JD-Core Version:    0.7.0.1
 */