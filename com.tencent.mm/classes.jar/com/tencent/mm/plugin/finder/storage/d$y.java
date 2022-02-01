package com.tencent.mm.plugin.finder.storage;

import android.app.Activity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.b;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"<anonymous>", "", "it", "Landroid/app/Activity;"}, k=3, mv={1, 5, 1}, xi=48)
final class d$y
  extends u
  implements b<Activity, ah>
{
  public static final y FJf;
  
  static
  {
    AppMethodBeat.i(338970);
    FJf = new y();
    AppMethodBeat.o(338970);
  }
  
  d$y()
  {
    super(1);
  }
  
  private static final void k(boolean paramBoolean, String paramString)
  {
    AppMethodBeat.i(338961);
    if (paramBoolean) {
      h.baE().ban().set(at.a.adbk, Integer.valueOf(Util.safeParseInt(paramString)));
    }
    AppMethodBeat.o(338961);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.storage.d.y
 * JD-Core Version:    0.7.0.1
 */