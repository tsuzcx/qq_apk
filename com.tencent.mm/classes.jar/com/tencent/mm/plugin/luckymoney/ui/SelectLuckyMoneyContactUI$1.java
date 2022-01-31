package com.tencent.mm.plugin.luckymoney.ui;

import android.content.Intent;
import com.tencent.mm.pluginsdk.ui.applet.q.a;

final class SelectLuckyMoneyContactUI$1
  implements q.a
{
  SelectLuckyMoneyContactUI$1(SelectLuckyMoneyContactUI paramSelectLuckyMoneyContactUI, Intent paramIntent) {}
  
  public final void a(boolean paramBoolean, String paramString, int paramInt)
  {
    if (paramBoolean)
    {
      this.lYd.setResult(-1, this.hSF);
      this.lYd.finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.SelectLuckyMoneyContactUI.1
 * JD-Core Version:    0.7.0.1
 */