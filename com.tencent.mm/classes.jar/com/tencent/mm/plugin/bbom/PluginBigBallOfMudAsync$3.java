package com.tencent.mm.plugin.bbom;

import android.content.Context;
import android.content.DialogInterface.OnDismissListener;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.ui.span.e;
import com.tencent.mm.pluginsdk.ui.span.r;
import com.tencent.mm.pluginsdk.ui.span.r.3;
import com.tencent.mm.pluginsdk.ui.span.r.4;
import com.tencent.mm.ui.tools.l;
import com.tencent.mm.ui.widget.a.f.b;
import java.util.List;

final class PluginBigBallOfMudAsync$3
  implements e
{
  PluginBigBallOfMudAsync$3(PluginBigBallOfMudAsync paramPluginBigBallOfMudAsync) {}
  
  public final void a(Context paramContext, String paramString, DialogInterface.OnDismissListener paramOnDismissListener, Bundle paramBundle)
  {
    AppMethodBeat.i(22421);
    r.a(paramContext, paramString, paramOnDismissListener, paramBundle);
    AppMethodBeat.o(22421);
  }
  
  public final void a(Context paramContext, List<String> paramList, f.b paramb)
  {
    AppMethodBeat.i(22420);
    if ((paramList.isEmpty()) || (paramContext == null))
    {
      AppMethodBeat.o(22420);
      return;
    }
    new l(paramContext).a(null, new r.3(paramList), new r.4(paramContext), paramb);
    AppMethodBeat.o(22420);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.bbom.PluginBigBallOfMudAsync.3
 * JD-Core Version:    0.7.0.1
 */