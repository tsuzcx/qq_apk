package com.tencent.mm.plugin.brandservice.ui;

import android.content.Intent;
import com.tencent.mm.pluginsdk.ui.applet.q.a;

final class EnterpriseBizContactPlainListUI$5
  implements q.a
{
  EnterpriseBizContactPlainListUI$5(EnterpriseBizContactPlainListUI paramEnterpriseBizContactPlainListUI, String paramString) {}
  
  public final void a(boolean paramBoolean, String paramString, int paramInt)
  {
    if (!paramBoolean) {}
    while (EnterpriseBizContactPlainListUI.b(this.idM) != 3) {
      return;
    }
    paramString = this.idM.getIntent();
    paramString.putExtra("enterprise_biz_name", this.idO);
    this.idM.setResult(-1, paramString);
    this.idM.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.EnterpriseBizContactPlainListUI.5
 * JD-Core Version:    0.7.0.1
 */