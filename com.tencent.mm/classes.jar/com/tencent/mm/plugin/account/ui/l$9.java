package com.tencent.mm.plugin.account.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.ui.base.MMFormVerifyCodeInputView;

final class l$9
  implements View.OnClickListener
{
  l$9(l paraml) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(125142);
    this.gFF.gFq.gEs[1] = 2;
    this.gFF.gFq.fme = 7;
    this.gFF.gFq.gFL.reset();
    g.Rc().b(145, this.gFF);
    l.a(this.gFF);
    AppMethodBeat.o(125142);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.l.9
 * JD-Core Version:    0.7.0.1
 */