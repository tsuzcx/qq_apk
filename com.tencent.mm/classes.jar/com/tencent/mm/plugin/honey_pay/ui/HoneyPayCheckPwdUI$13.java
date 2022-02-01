package com.tencent.mm.plugin.honey_pay.ui;

import android.content.Intent;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.plugin.honey_pay.a.c;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.protobuf.ace;
import com.tencent.mm.protocal.protobuf.bpe;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.wallet_core.c.r.a;

final class HoneyPayCheckPwdUI$13
  implements r.a
{
  HoneyPayCheckPwdUI$13(HoneyPayCheckPwdUI paramHoneyPayCheckPwdUI, c paramc) {}
  
  public final void d(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(64735);
    ae.i("MicroMsg.HoneyPayCheckPwdUI", "create success");
    paramn = new Intent(this.uSA.getContext(), HoneyPayMainUI.class);
    paramn.putExtra("key_create_succ", true);
    if (this.uSE.uQV.Guc != null)
    {
      paramn.putExtra("key_card_no", this.uSE.uQV.Guc.GSy);
      paramn.putExtra("key_card_type", this.uSE.uQV.Guc.oFF);
    }
    Toast.makeText(this.uSA.getContext(), 2131760261, 1).show();
    paramString = this.uSA;
    paramn = new com.tencent.mm.hellhoundlib.b.a().bc(paramn);
    com.tencent.mm.hellhoundlib.a.a.a(paramString, paramn.ahE(), "com/tencent/mm/plugin/honey_pay/ui/HoneyPayCheckPwdUI$5", "onCallback", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramString.startActivity((Intent)paramn.mt(0));
    com.tencent.mm.hellhoundlib.a.a.a(paramString, "com/tencent/mm/plugin/honey_pay/ui/HoneyPayCheckPwdUI$5", "onCallback", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    g.yxI.n(875L, 2L, 1L);
    AppMethodBeat.o(64735);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.honey_pay.ui.HoneyPayCheckPwdUI.13
 * JD-Core Version:    0.7.0.1
 */