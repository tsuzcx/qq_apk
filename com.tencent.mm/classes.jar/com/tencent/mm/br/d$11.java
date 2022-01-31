package com.tencent.mm.br;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.y;

final class d$11
  implements a
{
  d$11(Intent paramIntent, String paramString1, String paramString2, Context paramContext, int paramInt) {}
  
  public final void onDone()
  {
    Intent localIntent;
    if (this.val$intent == null)
    {
      localIntent = new Intent();
      str = ae.cqQ() + ".plugin." + this.soo;
      if (!this.sot.startsWith(".")) {
        break label133;
      }
    }
    label133:
    for (String str = str + this.sot;; str = this.sot)
    {
      localIntent.setClassName(ae.getPackageName(), str);
      if (!(this.val$context instanceof Activity)) {
        break label141;
      }
      ((Activity)this.val$context).startActivityForResult(localIntent, this.val$requestCode);
      d.f(this.val$context, this.sot, localIntent);
      return;
      localIntent = this.val$intent;
      break;
    }
    label141:
    y.f("MicroMsg.PluginHelper", "context not activity, skipped");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.br.d.11
 * JD-Core Version:    0.7.0.1
 */