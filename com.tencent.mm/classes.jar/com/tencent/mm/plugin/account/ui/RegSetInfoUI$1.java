package com.tencent.mm.plugin.account.ui;

import android.widget.EditText;
import android.widget.ProgressBar;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.account.friend.a.ad;
import com.tencent.mm.sdk.platformtools.am.a;
import com.tencent.mm.sdk.platformtools.bk;

final class RegSetInfoUI$1
  implements am.a
{
  RegSetInfoUI$1(RegSetInfoUI paramRegSetInfoUI) {}
  
  public final boolean tC()
  {
    String str = RegSetInfoUI.a(this.fso).getText().toString().trim();
    Object localObject2 = RegSetInfoUI.b(this.fso).getText().toString().trim();
    Object localObject1 = str;
    if (bk.bl(str))
    {
      localObject1 = str;
      if (!bk.bl((String)localObject2)) {
        if (((String)localObject2).length() <= 5) {
          break label193;
        }
      }
    }
    label193:
    for (localObject1 = ((String)localObject2).substring(0, 5);; localObject1 = localObject2)
    {
      if ((!bk.bl((String)localObject1)) && (bk.bl((String)localObject2))) {
        localObject2 = localObject1;
      }
      for (;;)
      {
        if ((!bk.bl((String)localObject1)) && (RegSetInfoUI.c(this.fso)) && (RegSetInfoUI.d(this.fso)))
        {
          int i = RegSetInfoUI.e(this.fso);
          str = RegSetInfoUI.f(this.fso);
          g.Dk().a(429, this.fso);
          localObject1 = new ad(str, RegSetInfoUI.g(this.fso), i, (String)localObject2, (String)localObject1, "", "");
          g.Dk().a((m)localObject1, 0);
          RegSetInfoUI.h(this.fso).setVisibility(0);
        }
        return false;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.RegSetInfoUI.1
 * JD-Core Version:    0.7.0.1
 */