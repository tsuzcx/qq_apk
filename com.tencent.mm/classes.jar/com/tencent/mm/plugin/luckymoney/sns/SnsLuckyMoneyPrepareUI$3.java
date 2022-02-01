package com.tencent.mm.plugin.luckymoney.sns;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyMyRecordUI;

final class SnsLuckyMoneyPrepareUI$3
  implements DialogInterface.OnClickListener
{
  SnsLuckyMoneyPrepareUI$3(SnsLuckyMoneyPrepareUI paramSnsLuckyMoneyPrepareUI) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(65365);
    Object localObject = new Intent();
    ((Intent)localObject).setClass(this.vrK.getContext(), LuckyMoneyMyRecordUI.class);
    ((Intent)localObject).putExtra("key_type", 1);
    paramDialogInterface = this.vrK;
    localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
    com.tencent.mm.hellhoundlib.a.a.a(paramDialogInterface, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahp(), "com/tencent/mm/plugin/luckymoney/sns/SnsLuckyMoneyPrepareUI$12", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramDialogInterface.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mq(0));
    com.tencent.mm.hellhoundlib.a.a.a(paramDialogInterface, "com/tencent/mm/plugin/luckymoney/sns/SnsLuckyMoneyPrepareUI$12", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(65365);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.sns.SnsLuckyMoneyPrepareUI.3
 * JD-Core Version:    0.7.0.1
 */