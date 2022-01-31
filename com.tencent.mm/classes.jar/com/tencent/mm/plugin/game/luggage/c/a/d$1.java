package com.tencent.mm.plugin.game.luggage.c.a;

import android.content.Context;
import android.widget.Toast;
import com.tencent.luggage.d.k;
import com.tencent.luggage.d.n;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.game.luggage.ipc.AddShortcutTask;
import com.tencent.mm.plugin.webview.luggage.e;
import com.tencent.mm.ui.base.h;

final class d$1
  implements Runnable
{
  d$1(d paramd, AddShortcutTask paramAddShortcutTask, e parame, Context paramContext) {}
  
  public final void run()
  {
    AppMethodBeat.i(135899);
    this.njZ.aBk();
    this.nka.bzs.a(new d.1.1(this));
    if (this.njZ.success)
    {
      h.a(this.val$context, 2131305996, 2131297087, false, new d.1.2(this));
      AppMethodBeat.o(135899);
      return;
    }
    Toast.makeText(this.val$context, this.val$context.getString(2131305995), 0).show();
    AppMethodBeat.o(135899);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.c.a.d.1
 * JD-Core Version:    0.7.0.1
 */