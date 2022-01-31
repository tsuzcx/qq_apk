package com.tencent.mm.plugin.brandservice.ui;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.ui.applet.q.a;
import com.tencent.mm.protocal.protobuf.me;

final class EnterpriseBizContactPlainListUI$4
  implements q.a
{
  EnterpriseBizContactPlainListUI$4(EnterpriseBizContactPlainListUI paramEnterpriseBizContactPlainListUI, me paramme) {}
  
  public final void a(boolean paramBoolean, String paramString, int paramInt)
  {
    AppMethodBeat.i(13983);
    if (paramBoolean)
    {
      paramString = this.jUA.getIntent();
      paramString.putExtra("enterprise_biz_name", this.jUB.userName);
      this.jUA.setResult(-1, paramString);
      this.jUA.finish();
    }
    AppMethodBeat.o(13983);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.EnterpriseBizContactPlainListUI.4
 * JD-Core Version:    0.7.0.1
 */