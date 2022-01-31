package com.tencent.mm.plugin.brandservice.ui;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.ui.applet.q.a;

final class EnterpriseBizContactPlainListUI$5
  implements q.a
{
  EnterpriseBizContactPlainListUI$5(EnterpriseBizContactPlainListUI paramEnterpriseBizContactPlainListUI, String paramString) {}
  
  public final void a(boolean paramBoolean, String paramString, int paramInt)
  {
    AppMethodBeat.i(13984);
    if (!paramBoolean)
    {
      AppMethodBeat.o(13984);
      return;
    }
    if (EnterpriseBizContactPlainListUI.b(this.jUA) == 3)
    {
      paramString = this.jUA.getIntent();
      paramString.putExtra("enterprise_biz_name", this.jUC);
      this.jUA.setResult(-1, paramString);
      this.jUA.finish();
    }
    AppMethodBeat.o(13984);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.EnterpriseBizContactPlainListUI.5
 * JD-Core Version:    0.7.0.1
 */