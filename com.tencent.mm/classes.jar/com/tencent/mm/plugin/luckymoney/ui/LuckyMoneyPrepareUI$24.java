package com.tencent.mm.plugin.luckymoney.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class LuckyMoneyPrepareUI$24
  implements Runnable
{
  LuckyMoneyPrepareUI$24(LuckyMoneyPrepareUI paramLuckyMoneyPrepareUI) {}
  
  public final void run()
  {
    AppMethodBeat.i(65853);
    Object localObject = new Intent();
    ((Intent)localObject).setClass(this.vAO.getContext(), LuckyMoneyIndexUI.class);
    ((Intent)localObject).addFlags(67108864);
    AppCompatActivity localAppCompatActivity = this.vAO.getContext();
    localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
    com.tencent.mm.hellhoundlib.a.a.a(localAppCompatActivity, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahp(), "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyPrepareUI$31", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    localAppCompatActivity.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mq(0));
    com.tencent.mm.hellhoundlib.a.a.a(localAppCompatActivity, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyPrepareUI$31", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    this.vAO.finish();
    AppMethodBeat.o(65853);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyPrepareUI.24
 * JD-Core Version:    0.7.0.1
 */