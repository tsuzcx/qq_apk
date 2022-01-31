package com.tencent.mm.plugin.honey_pay.ui;

import android.content.Intent;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.plugin.honey_pay.a.c;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.avf;
import com.tencent.mm.protocal.protobuf.vw;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.wallet_core.c.p.a;

final class HoneyPayCheckPwdUI$13
  implements p.a
{
  HoneyPayCheckPwdUI$13(HoneyPayCheckPwdUI paramHoneyPayCheckPwdUI, c paramc) {}
  
  public final void d(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(41846);
    ab.i("MicroMsg.HoneyPayCheckPwdUI", "create success");
    paramString = new Intent(this.nII.getContext(), HoneyPayMainUI.class);
    paramString.putExtra("key_create_succ", true);
    if (this.nIM.nHd.wOz != null)
    {
      paramString.putExtra("key_card_no", this.nIM.nHd.wOz.xcf);
      paramString.putExtra("key_card_type", this.nIM.nHd.wOz.knv);
    }
    Toast.makeText(this.nII.getContext(), 2131300664, 1).show();
    this.nII.startActivity(paramString);
    h.qsU.j(875L, 2L, 1L);
    AppMethodBeat.o(41846);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.honey_pay.ui.HoneyPayCheckPwdUI.13
 * JD-Core Version:    0.7.0.1
 */