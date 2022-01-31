package com.tencent.mm.br;

import android.content.Intent;
import android.support.v4.app.Fragment;
import com.tencent.mm.sdk.platformtools.ae;

final class d$4
  implements a
{
  d$4(Intent paramIntent, String paramString1, String paramString2, Fragment paramFragment, int paramInt) {}
  
  public final void onDone()
  {
    Intent localIntent;
    if (this.val$intent == null)
    {
      localIntent = new Intent();
      str = ae.cqQ() + ".plugin." + this.soo;
      if (!this.sot.startsWith(".")) {
        break label126;
      }
    }
    label126:
    for (String str = str + this.sot;; str = this.sot)
    {
      localIntent.setClassName(ae.getPackageName(), str);
      this.val$fragment.startActivityForResult(localIntent, this.val$requestCode);
      d.f(this.val$fragment.getActivity(), this.sot, this.val$intent);
      return;
      localIntent = this.val$intent;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.br.d.4
 * JD-Core Version:    0.7.0.1
 */