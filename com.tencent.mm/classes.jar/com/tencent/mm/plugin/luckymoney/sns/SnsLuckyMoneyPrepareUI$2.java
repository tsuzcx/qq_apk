package com.tencent.mm.plugin.luckymoney.sns;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyIndexUI;

final class SnsLuckyMoneyPrepareUI$2
  implements Runnable
{
  SnsLuckyMoneyPrepareUI$2(SnsLuckyMoneyPrepareUI paramSnsLuckyMoneyPrepareUI) {}
  
  public final void run()
  {
    AppMethodBeat.i(283873);
    Object localObject = new Intent();
    ((Intent)localObject).setClass(this.Kwc.getContext(), LuckyMoneyIndexUI.class);
    ((Intent)localObject).addFlags(67108864);
    AppCompatActivity localAppCompatActivity = this.Kwc.getContext();
    localObject = new com.tencent.mm.hellhoundlib.b.a().cG(localObject);
    com.tencent.mm.hellhoundlib.a.a.b(localAppCompatActivity, ((com.tencent.mm.hellhoundlib.b.a)localObject).aYi(), "com/tencent/mm/plugin/luckymoney/sns/SnsLuckyMoneyPrepareUI$10", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    localAppCompatActivity.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sb(0));
    com.tencent.mm.hellhoundlib.a.a.c(localAppCompatActivity, "com/tencent/mm/plugin/luckymoney/sns/SnsLuckyMoneyPrepareUI$10", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    this.Kwc.finish();
    AppMethodBeat.o(283873);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.sns.SnsLuckyMoneyPrepareUI.2
 * JD-Core Version:    0.7.0.1
 */