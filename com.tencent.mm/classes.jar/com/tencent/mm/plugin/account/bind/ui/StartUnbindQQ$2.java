package com.tencent.mm.plugin.account.bind.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.widget.b.c;

final class StartUnbindQQ$2
  implements View.OnClickListener
{
  StartUnbindQQ$2(StartUnbindQQ paramStartUnbindQQ) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(13763);
    if (StartUnbindQQ.a(this.gws) == null)
    {
      StartUnbindQQ.a(this.gws, h.a(this.gws, this.gws.getString(2131303175), null, new StartUnbindQQ.2.1(this), new StartUnbindQQ.2.2(this)));
      AppMethodBeat.o(13763);
      return;
    }
    StartUnbindQQ.a(this.gws).show();
    AppMethodBeat.o(13763);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.account.bind.ui.StartUnbindQQ.2
 * JD-Core Version:    0.7.0.1
 */