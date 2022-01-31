package com.tencent.mm.bq;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.ui.MMWizardActivity;

final class d$7
  implements a
{
  d$7(Intent paramIntent1, String paramString1, String paramString2, Context paramContext, Intent paramIntent2) {}
  
  public final void onDone()
  {
    AppMethodBeat.i(114691);
    Intent localIntent;
    if (this.val$intent == null)
    {
      localIntent = new Intent();
      str = ah.dsO() + ".plugin." + this.wgS;
      if (!this.wgX.startsWith(".")) {
        break label118;
      }
    }
    label118:
    for (String str = str + this.wgX;; str = this.wgX)
    {
      localIntent.setClassName(ah.getPackageName(), str);
      MMWizardActivity.b(this.val$context, localIntent, this.wha);
      AppMethodBeat.o(114691);
      return;
      localIntent = this.val$intent;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.bq.d.7
 * JD-Core Version:    0.7.0.1
 */