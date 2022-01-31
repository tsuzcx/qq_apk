package com.tencent.mm.bq;

import android.content.Intent;
import android.support.v4.app.Fragment;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ah;

final class d$4
  implements a
{
  d$4(Intent paramIntent, String paramString1, String paramString2, Fragment paramFragment, int paramInt) {}
  
  public final void onDone()
  {
    AppMethodBeat.i(114688);
    Intent localIntent;
    if (this.val$intent == null)
    {
      localIntent = new Intent();
      str = ah.dsO() + ".plugin." + this.wgS;
      if (!this.wgX.startsWith(".")) {
        break label136;
      }
    }
    label136:
    for (String str = str + this.wgX;; str = this.wgX)
    {
      localIntent.setClassName(ah.getPackageName(), str);
      this.val$fragment.startActivityForResult(localIntent, this.val$requestCode);
      d.g(this.val$fragment.getActivity(), this.wgX, this.val$intent);
      AppMethodBeat.o(114688);
      return;
      localIntent = this.val$intent;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.bq.d.4
 * JD-Core Version:    0.7.0.1
 */