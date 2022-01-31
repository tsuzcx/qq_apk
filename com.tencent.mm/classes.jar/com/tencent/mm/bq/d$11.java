package com.tencent.mm.bq;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;

final class d$11
  implements a
{
  d$11(Intent paramIntent, String paramString1, String paramString2, Context paramContext, int paramInt) {}
  
  public final void onDone()
  {
    AppMethodBeat.i(114695);
    Intent localIntent;
    if (this.val$intent == null)
    {
      localIntent = new Intent();
      str = ah.dsO() + ".plugin." + this.wgS;
      if (!this.wgX.startsWith(".")) {
        break label143;
      }
    }
    label143:
    for (String str = str + this.wgX;; str = this.wgX)
    {
      localIntent.setClassName(ah.getPackageName(), str);
      if (!(this.val$context instanceof Activity)) {
        break label151;
      }
      ((Activity)this.val$context).startActivityForResult(localIntent, this.val$requestCode);
      d.g(this.val$context, this.wgX, localIntent);
      AppMethodBeat.o(114695);
      return;
      localIntent = this.val$intent;
      break;
    }
    label151:
    ab.f("MicroMsg.PluginHelper", "context not activity, skipped");
    AppMethodBeat.o(114695);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.bq.d.11
 * JD-Core Version:    0.7.0.1
 */