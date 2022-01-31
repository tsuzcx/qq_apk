package com.tencent.mm.bq;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ah;

final class d$2
  implements a
{
  d$2(Intent paramIntent, String paramString1, String paramString2, d.b paramb, int paramInt, d.a parama) {}
  
  public final void onDone()
  {
    AppMethodBeat.i(114686);
    Intent localIntent;
    if (this.val$intent == null)
    {
      localIntent = new Intent();
      str = ah.dsO() + ".plugin." + this.wgS;
      if (!this.wgX.startsWith(".")) {
        break label144;
      }
    }
    label144:
    for (String str = str + this.wgX;; str = this.wgX)
    {
      localIntent.setClassName(ah.getPackageName(), str);
      this.wgY.a(localIntent, this.val$requestCode, this.wgZ);
      d.g(this.wgY.getContext(), this.wgX, this.val$intent);
      AppMethodBeat.o(114686);
      return;
      localIntent = this.val$intent;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.bq.d.2
 * JD-Core Version:    0.7.0.1
 */