package com.tencent.mm.plugin.ipcall.ui;

import android.content.Intent;
import android.content.res.Resources;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.e;
import com.tencent.mm.R.l;
import com.tencent.mm.plugin.ipcall.a.a;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.List;

final class IPCallRechargeUI$7
  extends ClickableSpan
{
  IPCallRechargeUI$7(IPCallRechargeUI paramIPCallRechargeUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(25877);
    ((TextView)paramView).setHighlightColor(this.DXz.getResources().getColor(R.e.transparent));
    Intent localIntent = new Intent();
    paramView = this.DXz.getString(R.l.eJe) + "&usedcc=";
    Object localObject = com.tencent.mm.plugin.ipcall.model.c.eJb().eJe();
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
        String str = a.aMD(((Integer)((List)localObject).get(j)).toString());
        if (Util.isNullOrNil(str)) {
          break label257;
        }
        paramView = paramView + str + "|";
      }
    }
    label257:
    for (;;)
    {
      j += 1;
      break;
      localObject = paramView;
      if (paramView.endsWith("|")) {}
      for (localObject = paramView.substring(0, paramView.length() - 1);; localObject = paramView + a.aMD(com.tencent.mm.plugin.ipcall.a.c.eKM()))
      {
        localIntent.putExtra("rawUrl", (String)localObject);
        localIntent.putExtra("showShare", false);
        com.tencent.mm.by.c.b(this.DXz, "webview", ".ui.tools.WebViewUI", localIntent);
        AppMethodBeat.o(25877);
        return;
      }
    }
  }
  
  public final void updateDrawState(TextPaint paramTextPaint)
  {
    AppMethodBeat.i(25878);
    paramTextPaint.setColor(this.DXz.getResources().getColor(R.e.link_color));
    paramTextPaint.setUnderlineText(false);
    AppMethodBeat.o(25878);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.IPCallRechargeUI.7
 * JD-Core Version:    0.7.0.1
 */