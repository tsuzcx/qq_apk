package com.tencent.mm.by;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

final class c$11
  implements a
{
  c$11(Intent paramIntent, String paramString1, String paramString2, Context paramContext, int paramInt) {}
  
  public final void onDone()
  {
    AppMethodBeat.i(133706);
    Intent localIntent;
    if (this.val$intent == null)
    {
      localIntent = new Intent();
      str = MMApplicationContext.getSourcePackageName() + ".plugin." + this.RzJ;
      if (!this.RzO.startsWith(".")) {
        break label143;
      }
    }
    label143:
    for (String str = str + this.RzO;; str = this.RzO)
    {
      localIntent.setClassName(MMApplicationContext.getPackageName(), str);
      if (!(this.val$context instanceof Activity)) {
        break label151;
      }
      ((Activity)this.val$context).startActivityForResult(localIntent, this.val$requestCode);
      c.g(this.val$context, this.RzO, localIntent);
      AppMethodBeat.o(133706);
      return;
      localIntent = this.val$intent;
      break;
    }
    label151:
    Log.f("MicroMsg.PluginHelper", "context not activity, skipped");
    AppMethodBeat.o(133706);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.by.c.11
 * JD-Core Version:    0.7.0.1
 */