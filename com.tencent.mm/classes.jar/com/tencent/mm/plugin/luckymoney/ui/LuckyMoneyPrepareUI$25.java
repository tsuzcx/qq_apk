package com.tencent.mm.plugin.luckymoney.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class LuckyMoneyPrepareUI$25
  implements DialogInterface.OnClickListener
{
  LuckyMoneyPrepareUI$25(LuckyMoneyPrepareUI paramLuckyMoneyPrepareUI) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(65854);
    Object localObject = new Intent();
    ((Intent)localObject).setClass(this.vAO.getContext(), LuckyMoneyMyRecordUI.class);
    ((Intent)localObject).putExtra("key_type", 1);
    paramDialogInterface = this.vAO;
    localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
    com.tencent.mm.hellhoundlib.a.a.a(paramDialogInterface, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahp(), "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyPrepareUI$32", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramDialogInterface.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mq(0));
    com.tencent.mm.hellhoundlib.a.a.a(paramDialogInterface, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyPrepareUI$32", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(65854);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyPrepareUI.25
 * JD-Core Version:    0.7.0.1
 */