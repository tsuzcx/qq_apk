package com.tencent.mm.plugin.honey_pay.ui;

import android.content.Intent;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.q;
import com.tencent.mm.plugin.honey_pay.a.c;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.protocal.protobuf.aen;
import com.tencent.mm.protocal.protobuf.cjz;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.wallet_core.c.r.a;

final class HoneyPayCheckPwdUI$13
  implements r.a
{
  HoneyPayCheckPwdUI$13(HoneyPayCheckPwdUI paramHoneyPayCheckPwdUI, c paramc) {}
  
  public final void e(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(64735);
    Log.i("MicroMsg.HoneyPayCheckPwdUI", "create success");
    paramq = new Intent(this.DLe.getContext(), HoneyPayMainUI.class);
    paramq.putExtra("key_create_succ", true);
    if (this.DLi.DJB.Sra != null)
    {
      paramq.putExtra("key_card_no", this.DLi.DJB.Sra.TfK);
      paramq.putExtra("key_card_type", this.DLi.DJB.Sra.tpo);
    }
    Toast.makeText(this.DLe.getContext(), a.i.honey_pay_create_card_success_word, 1).show();
    paramString = this.DLe;
    paramq = new com.tencent.mm.hellhoundlib.b.a().bm(paramq);
    com.tencent.mm.hellhoundlib.a.a.b(paramString, paramq.aFh(), "com/tencent/mm/plugin/honey_pay/ui/HoneyPayCheckPwdUI$5", "onCallback", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramString.startActivity((Intent)paramq.sf(0));
    com.tencent.mm.hellhoundlib.a.a.c(paramString, "com/tencent/mm/plugin/honey_pay/ui/HoneyPayCheckPwdUI$5", "onCallback", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    h.IzE.p(875L, 2L, 1L);
    AppMethodBeat.o(64735);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.honey_pay.ui.HoneyPayCheckPwdUI.13
 * JD-Core Version:    0.7.0.1
 */