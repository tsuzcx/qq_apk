package com.tencent.mm.plugin.brandservice.ui;

import android.content.Intent;
import com.tencent.mm.pluginsdk.ui.applet.q.a;
import com.tencent.mm.protocal.c.jt;

final class EnterpriseBizContactPlainListUI$4
  implements q.a
{
  EnterpriseBizContactPlainListUI$4(EnterpriseBizContactPlainListUI paramEnterpriseBizContactPlainListUI, jt paramjt) {}
  
  public final void a(boolean paramBoolean, String paramString, int paramInt)
  {
    if (paramBoolean)
    {
      paramString = this.idM.getIntent();
      paramString.putExtra("enterprise_biz_name", this.idN.userName);
      this.idM.setResult(-1, paramString);
      this.idM.finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.EnterpriseBizContactPlainListUI.4
 * JD-Core Version:    0.7.0.1
 */