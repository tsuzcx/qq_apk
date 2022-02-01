package com.tencent.mm.plugin.luckymoney.sns;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyIndexUI;

final class SnsLuckyMoneyPrepareUI$2
  implements Runnable
{
  SnsLuckyMoneyPrepareUI$2(SnsLuckyMoneyPrepareUI paramSnsLuckyMoneyPrepareUI) {}
  
  public final void run()
  {
    AppMethodBeat.i(65364);
    Object localObject = new Intent();
    ((Intent)localObject).setClass(this.vrK.getContext(), LuckyMoneyIndexUI.class);
    ((Intent)localObject).addFlags(67108864);
    AppCompatActivity localAppCompatActivity = this.vrK.getContext();
    localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
    com.tencent.mm.hellhoundlib.a.a.a(localAppCompatActivity, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahp(), "com/tencent/mm/plugin/luckymoney/sns/SnsLuckyMoneyPrepareUI$11", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    localAppCompatActivity.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mq(0));
    com.tencent.mm.hellhoundlib.a.a.a(localAppCompatActivity, "com/tencent/mm/plugin/luckymoney/sns/SnsLuckyMoneyPrepareUI$11", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    this.vrK.finish();
    AppMethodBeat.o(65364);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.sns.SnsLuckyMoneyPrepareUI.2
 * JD-Core Version:    0.7.0.1
 */