package com.tencent.mm.by;

import android.content.Intent;
import androidx.fragment.app.Fragment;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

final class c$4
  implements a
{
  c$4(Intent paramIntent, String paramString1, String paramString2, Fragment paramFragment, int paramInt) {}
  
  public final void onDone()
  {
    AppMethodBeat.i(133699);
    Intent localIntent;
    if (this.val$intent == null)
    {
      localIntent = new Intent();
      str = MMApplicationContext.getSourcePackageName() + ".plugin." + this.RzJ;
      if (!this.RzO.startsWith(".")) {
        break label136;
      }
    }
    label136:
    for (String str = str + this.RzO;; str = this.RzO)
    {
      localIntent.setClassName(MMApplicationContext.getPackageName(), str);
      this.val$fragment.startActivityForResult(localIntent, this.val$requestCode);
      c.g(this.val$fragment.getActivity(), this.RzO, this.val$intent);
      AppMethodBeat.o(133699);
      return;
      localIntent = this.val$intent;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.by.c.4
 * JD-Core Version:    0.7.0.1
 */