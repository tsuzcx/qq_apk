package com.tencent.mm.plugin.base.model;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.sdk.platformtools.ab;

public final class c$6
  implements c.b
{
  public c$6(Context paramContext, String paramString1, String paramString2) {}
  
  public final void aVB()
  {
    AppMethodBeat.i(155983);
    b.q(this.val$context, c.a(this.val$context, this.val$name, this.jLq, false, this.jLr));
    AppMethodBeat.o(155983);
  }
  
  public final void aVC()
  {
    AppMethodBeat.i(155984);
    if (this.val$context == null)
    {
      ab.e("MicroMsg.ShortcutUtil", "add fail, invalid argument");
      AppMethodBeat.o(155984);
      return;
    }
    Intent localIntent = c.a(this.val$context, this.val$name, this.jLq, true, this.jLr);
    String str1 = null;
    String str2 = b.dc(this.val$name, q.LD());
    if (str2 != null) {
      str1 = b.S(str2.getBytes());
    }
    ab.i("MicroMsg.ShortcutUtil", "addShortCut() shortcutId: %s", new Object[] { str1 });
    b.a(this.val$context, localIntent, str1, this.jLs);
    AppMethodBeat.o(155984);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.base.model.c.6
 * JD-Core Version:    0.7.0.1
 */