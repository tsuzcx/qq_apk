package com.tencent.mm.plugin.bbom;

import android.content.Context;
import android.content.DialogInterface.OnDismissListener;
import android.os.Bundle;
import com.tencent.mm.pluginsdk.ui.d.c;
import com.tencent.mm.pluginsdk.ui.d.l;
import com.tencent.mm.pluginsdk.ui.d.l.3;
import com.tencent.mm.pluginsdk.ui.d.l.4;
import com.tencent.mm.ui.tools.j;
import java.util.List;

final class PluginBigBallOfMudAsync$3
  implements c
{
  PluginBigBallOfMudAsync$3(PluginBigBallOfMudAsync paramPluginBigBallOfMudAsync) {}
  
  public final void a(Context paramContext, String paramString, DialogInterface.OnDismissListener paramOnDismissListener, Bundle paramBundle)
  {
    l.a(paramContext, paramString, paramOnDismissListener, paramBundle);
  }
  
  public final void a(Context paramContext, List<String> paramList, DialogInterface.OnDismissListener paramOnDismissListener)
  {
    if ((paramList.isEmpty()) || (paramContext == null)) {
      return;
    }
    new j(paramContext).a(null, new l.3(paramList), new l.4(paramContext), paramOnDismissListener);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.bbom.PluginBigBallOfMudAsync.3
 * JD-Core Version:    0.7.0.1
 */