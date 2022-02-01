package com.tencent.mm.by;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.MMWizardActivity;

final class c$1
  implements a
{
  c$1(Intent paramIntent, String paramString1, String paramString2, Context paramContext) {}
  
  public final void onDone()
  {
    AppMethodBeat.i(133696);
    Intent localIntent;
    if (this.val$intent == null)
    {
      localIntent = new Intent();
      str = MMApplicationContext.getSourcePackageName() + ".plugin." + this.RzJ;
      if (!this.RzO.startsWith(".")) {
        break label114;
      }
    }
    label114:
    for (String str = str + this.RzO;; str = this.RzO)
    {
      localIntent.setClassName(MMApplicationContext.getPackageName(), str);
      MMWizardActivity.aH(this.val$context, localIntent);
      AppMethodBeat.o(133696);
      return;
      localIntent = this.val$intent;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.by.c.1
 * JD-Core Version:    0.7.0.1
 */