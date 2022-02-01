package com.tencent.mm.plugin.honey_pay.ui;

import android.content.Intent;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.plugin.honey_pay.a.c;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.bkc;
import com.tencent.mm.protocal.protobuf.zv;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.wallet_core.c.r.a;

final class HoneyPayCheckPwdUI$13
  implements r.a
{
  HoneyPayCheckPwdUI$13(HoneyPayCheckPwdUI paramHoneyPayCheckPwdUI, c paramc) {}
  
  public final void d(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(64735);
    ac.i("MicroMsg.HoneyPayCheckPwdUI", "create success");
    paramn = new Intent(this.tEe.getContext(), HoneyPayMainUI.class);
    paramn.putExtra("key_create_succ", true);
    if (this.tEi.tCz.Euc != null)
    {
      paramn.putExtra("key_card_no", this.tEi.tCz.Euc.EPH);
      paramn.putExtra("key_card_type", this.tEi.tCz.Euc.nVJ);
    }
    Toast.makeText(this.tEe.getContext(), 2131760261, 1).show();
    paramString = this.tEe;
    paramn = new com.tencent.mm.hellhoundlib.b.a().ba(paramn);
    com.tencent.mm.hellhoundlib.a.a.a(paramString, paramn.aeD(), "com/tencent/mm/plugin/honey_pay/ui/HoneyPayCheckPwdUI$5", "onCallback", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramString.startActivity((Intent)paramn.lR(0));
    com.tencent.mm.hellhoundlib.a.a.a(paramString, "com/tencent/mm/plugin/honey_pay/ui/HoneyPayCheckPwdUI$5", "onCallback", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    h.wUl.n(875L, 2L, 1L);
    AppMethodBeat.o(64735);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.honey_pay.ui.HoneyPayCheckPwdUI.13
 * JD-Core Version:    0.7.0.1
 */