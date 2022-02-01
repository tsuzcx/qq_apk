package com.tencent.mm.by;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.MMWizardActivity;

final class c$7
  implements a
{
  c$7(Intent paramIntent1, String paramString1, String paramString2, Context paramContext, Intent paramIntent2) {}
  
  public final void onDone()
  {
    AppMethodBeat.i(133702);
    Intent localIntent;
    if (this.val$intent == null)
    {
      localIntent = new Intent();
      str = MMApplicationContext.getSourcePackageName() + ".plugin." + this.RzJ;
      if (!this.RzO.startsWith(".")) {
        break label118;
      }
    }
    label118:
    for (String str = str + this.RzO;; str = this.RzO)
    {
      localIntent.setClassName(MMApplicationContext.getPackageName(), str);
      MMWizardActivity.b(this.val$context, localIntent, this.RzR);
      AppMethodBeat.o(133702);
      return;
      localIntent = this.val$intent;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.by.c.7
 * JD-Core Version:    0.7.0.1
 */