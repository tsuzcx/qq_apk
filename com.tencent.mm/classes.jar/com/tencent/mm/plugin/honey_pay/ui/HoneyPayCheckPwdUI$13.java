package com.tencent.mm.plugin.honey_pay.ui;

import android.content.Intent;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.plugin.honey_pay.a.c;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.aeg;
import com.tencent.mm.protocal.protobuf.cbw;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.wallet_core.c.r.a;

final class HoneyPayCheckPwdUI$13
  implements r.a
{
  HoneyPayCheckPwdUI$13(HoneyPayCheckPwdUI paramHoneyPayCheckPwdUI, c paramc) {}
  
  public final void d(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(64735);
    Log.i("MicroMsg.HoneyPayCheckPwdUI", "create success");
    paramq = new Intent(this.ylc.getContext(), HoneyPayMainUI.class);
    paramq.putExtra("key_create_succ", true);
    if (this.ylg.yjz.LpE != null)
    {
      paramq.putExtra("key_card_no", this.ylg.yjz.LpE.LWD);
      paramq.putExtra("key_card_type", this.ylg.yjz.LpE.pTn);
    }
    Toast.makeText(this.ylc.getContext(), 2131761647, 1).show();
    paramString = this.ylc;
    paramq = new com.tencent.mm.hellhoundlib.b.a().bl(paramq);
    com.tencent.mm.hellhoundlib.a.a.a(paramString, paramq.axQ(), "com/tencent/mm/plugin/honey_pay/ui/HoneyPayCheckPwdUI$5", "onCallback", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramString.startActivity((Intent)paramq.pG(0));
    com.tencent.mm.hellhoundlib.a.a.a(paramString, "com/tencent/mm/plugin/honey_pay/ui/HoneyPayCheckPwdUI$5", "onCallback", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    h.CyF.n(875L, 2L, 1L);
    AppMethodBeat.o(64735);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.honey_pay.ui.HoneyPayCheckPwdUI.13
 * JD-Core Version:    0.7.0.1
 */