package com.tencent.mm.plugin.finder.storage;

import android.app.Activity;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.findersdk.a.cn;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.base.aa;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.b;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"<anonymous>", "", "it", "Landroid/app/Activity;"}, k=3, mv={1, 5, 1}, xi=48)
final class d$p
  extends u
  implements b<Activity, ah>
{
  public static final p FIV;
  
  static
  {
    AppMethodBeat.i(338833);
    FIV = new p();
    AppMethodBeat.o(338833);
  }
  
  d$p()
  {
    super(1);
  }
  
  private static final void k(boolean paramBoolean, String paramString)
  {
    AppMethodBeat.i(338822);
    if (paramBoolean)
    {
      String str = paramString;
      if (paramString == null) {
        str = "";
      }
      try
      {
        ((cn)h.az(cn.class)).createAccount(MMApplicationContext.getContext(), null, str, null);
        AppMethodBeat.o(338822);
        return;
      }
      catch (Exception paramString)
      {
        aa.makeText(MMApplicationContext.getContext(), (CharSequence)s.X("报错了：", paramString.getMessage()), 0).show();
      }
    }
    AppMethodBeat.o(338822);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.storage.d.p
 * JD-Core Version:    0.7.0.1
 */