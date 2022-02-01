package com.tencent.mm.plugin.honey_pay.ui;

import android.content.Intent;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.plugin.honey_pay.a.c;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.bgk;
import com.tencent.mm.protocal.protobuf.za;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.wallet_core.c.r.a;

final class HoneyPayCheckPwdUI$13
  implements r.a
{
  HoneyPayCheckPwdUI$13(HoneyPayCheckPwdUI paramHoneyPayCheckPwdUI, c paramc) {}
  
  public final void d(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(64735);
    ad.i("MicroMsg.HoneyPayCheckPwdUI", "create success");
    paramn = new Intent(this.swp.getContext(), HoneyPayMainUI.class);
    paramn.putExtra("key_create_succ", true);
    if (this.swt.suK.Dbf != null)
    {
      paramn.putExtra("key_card_no", this.swt.suK.Dbf.Duy);
      paramn.putExtra("key_card_type", this.swt.suK.Dbf.nsJ);
    }
    Toast.makeText(this.swp.getContext(), 2131760261, 1).show();
    paramString = this.swp;
    paramn = new com.tencent.mm.hellhoundlib.b.a().bd(paramn);
    com.tencent.mm.hellhoundlib.a.a.a(paramString, paramn.adn(), "com/tencent/mm/plugin/honey_pay/ui/HoneyPayCheckPwdUI$5", "onCallback", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramString.startActivity((Intent)paramn.lS(0));
    com.tencent.mm.hellhoundlib.a.a.a(paramString, "com/tencent/mm/plugin/honey_pay/ui/HoneyPayCheckPwdUI$5", "onCallback", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    h.vKh.m(875L, 2L, 1L);
    AppMethodBeat.o(64735);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.honey_pay.ui.HoneyPayCheckPwdUI.13
 * JD-Core Version:    0.7.0.1
 */