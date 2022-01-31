package com.tencent.mm.plugin.account.ui;

import android.widget.EditText;
import android.widget.ProgressBar;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.account.friend.a.ad;
import com.tencent.mm.sdk.platformtools.ap.a;
import com.tencent.mm.sdk.platformtools.bo;

final class RegSetInfoUI$1
  implements ap.a
{
  RegSetInfoUI$1(RegSetInfoUI paramRegSetInfoUI) {}
  
  public final boolean onTimerExpired()
  {
    AppMethodBeat.i(125507);
    String str = RegSetInfoUI.a(this.gJQ).getText().toString().trim();
    Object localObject2 = RegSetInfoUI.b(this.gJQ).getText().toString().trim();
    Object localObject1 = str;
    if (bo.isNullOrNil(str))
    {
      localObject1 = str;
      if (!bo.isNullOrNil((String)localObject2)) {
        if (((String)localObject2).length() <= 5) {
          break label203;
        }
      }
    }
    label203:
    for (localObject1 = ((String)localObject2).substring(0, 5);; localObject1 = localObject2)
    {
      if ((!bo.isNullOrNil((String)localObject1)) && (bo.isNullOrNil((String)localObject2))) {
        localObject2 = localObject1;
      }
      for (;;)
      {
        if ((!bo.isNullOrNil((String)localObject1)) && (RegSetInfoUI.c(this.gJQ)) && (RegSetInfoUI.d(this.gJQ)))
        {
          int i = RegSetInfoUI.e(this.gJQ);
          str = RegSetInfoUI.f(this.gJQ);
          g.Rc().a(429, this.gJQ);
          localObject1 = new ad(str, RegSetInfoUI.g(this.gJQ), i, (String)localObject2, (String)localObject1, "", "");
          g.Rc().a((m)localObject1, 0);
          RegSetInfoUI.h(this.gJQ).setVisibility(0);
        }
        AppMethodBeat.o(125507);
        return false;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.RegSetInfoUI.1
 * JD-Core Version:    0.7.0.1
 */