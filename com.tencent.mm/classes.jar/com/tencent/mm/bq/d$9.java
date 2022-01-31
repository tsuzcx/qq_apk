package com.tencent.mm.bq;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;

final class d$9
  implements a
{
  d$9(String paramString1, String paramString2, Intent paramIntent, Context paramContext, Bundle paramBundle) {}
  
  public final void onDone()
  {
    AppMethodBeat.i(114693);
    ab.d("MicroMsg.PluginHelper", "[DEBUG] onDone Load %s:%s", new Object[] { this.wgS, this.wgX });
    try
    {
      Intent localIntent;
      if (this.val$intent == null)
      {
        localIntent = new Intent();
        str = ah.dsO() + ".plugin." + this.wgS;
        if (!this.wgX.startsWith(".")) {
          break label166;
        }
      }
      label166:
      for (String str = str + this.wgX;; str = this.wgX)
      {
        localIntent.setClassName(ah.getPackageName(), str);
        Class.forName(str, false, this.val$context.getClassLoader());
        if (!(this.val$context instanceof Activity)) {
          break label174;
        }
        this.val$context.startActivity(localIntent, this.val$options);
        AppMethodBeat.o(114693);
        return;
        localIntent = this.val$intent;
        break;
      }
      label174:
      localIntent.addFlags(268435456);
      this.val$context.startActivity(localIntent, this.val$options);
      AppMethodBeat.o(114693);
      return;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      ab.e("MicroMsg.PluginHelper", "Class Not Found when startActivity %s", new Object[] { localClassNotFoundException });
      AppMethodBeat.o(114693);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.bq.d.9
 * JD-Core Version:    0.7.0.1
 */