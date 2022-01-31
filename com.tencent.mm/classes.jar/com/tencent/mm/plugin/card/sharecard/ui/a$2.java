package com.tencent.mm.plugin.card.sharecard.ui;

import android.view.View;
import android.view.View.OnLongClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.card.base.b;
import com.tencent.mm.plugin.card.d.p;
import com.tencent.mm.protocal.protobuf.oj;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;

final class a$2
  implements View.OnLongClickListener
{
  a$2(a parama) {}
  
  public final boolean onLongClick(View paramView)
  {
    AppMethodBeat.i(88090);
    if (paramView.getId() == 2131822013)
    {
      p.xJ(this.kqA.klk.bbe().code);
      h.bO(this.kqA.jpX, this.kqA.jpX.getString(2131296896));
    }
    AppMethodBeat.o(88090);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.card.sharecard.ui.a.2
 * JD-Core Version:    0.7.0.1
 */