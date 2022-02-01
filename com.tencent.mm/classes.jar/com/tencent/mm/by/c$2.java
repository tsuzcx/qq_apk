package com.tencent.mm.by;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;

final class c$2
  implements a
{
  c$2(Intent paramIntent, String paramString1, String paramString2, c.b paramb, int paramInt, c.a parama) {}
  
  public final void onDone()
  {
    AppMethodBeat.i(133697);
    Intent localIntent;
    if (this.val$intent == null)
    {
      localIntent = new Intent();
      if ((!Util.isNullOrNil(this.RzO)) && (!Util.isNullOrNil(this.RzJ)))
      {
        str = MMApplicationContext.getSourcePackageName() + ".plugin." + this.RzJ;
        if (!this.RzO.startsWith(".")) {
          break label164;
        }
      }
    }
    label164:
    for (String str = str + this.RzO;; str = this.RzO)
    {
      localIntent.setClassName(MMApplicationContext.getPackageName(), str);
      this.RzP.a(localIntent, this.val$requestCode, this.RzQ);
      c.g(this.RzP.getContext(), this.RzO, this.val$intent);
      AppMethodBeat.o(133697);
      return;
      localIntent = this.val$intent;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.by.c.2
 * JD-Core Version:    0.7.0.1
 */