package com.tencent.mm.br;

import android.content.Context;
import android.content.Intent;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.ui.MMWizardActivity;

final class d$7
  implements a
{
  d$7(Intent paramIntent1, String paramString1, String paramString2, Context paramContext, Intent paramIntent2) {}
  
  public final void onDone()
  {
    Intent localIntent;
    if (this.val$intent == null)
    {
      localIntent = new Intent();
      str = ae.cqQ() + ".plugin." + this.soo;
      if (!this.sot.startsWith(".")) {
        break label108;
      }
    }
    label108:
    for (String str = str + this.sot;; str = this.sot)
    {
      localIntent.setClassName(ae.getPackageName(), str);
      MMWizardActivity.b(this.val$context, localIntent, this.sow);
      return;
      localIntent = this.val$intent;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.br.d.7
 * JD-Core Version:    0.7.0.1
 */