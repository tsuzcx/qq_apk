package com.tencent.mm.plugin.forcenotify.ui;

import a.f.b.j;
import a.l;
import android.content.Context;
import android.os.Vibrator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.forcenotify.b.c;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.ay.b;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "run"})
final class ForceNotifyShowUI$c
  implements Runnable
{
  ForceNotifyShowUI$c(ForceNotifyShowUI paramForceNotifyShowUI) {}
  
  public final void run()
  {
    AppMethodBeat.i(51085);
    Object localObject = c.mHu;
    localObject = this.mHX.getContext();
    j.p(localObject, "context");
    if (!c.isSilentMode((Context)localObject)) {
      ForceNotifyShowUI.a(this.mHX, ay.a((Context)this.mHX.getContext(), 2131306167, ay.b.ypy, 2, true, null));
    }
    localObject = c.mHu;
    localObject = this.mHX.getContext();
    j.p(localObject, "context");
    if (c.dX((Context)localObject))
    {
      localObject = ForceNotifyShowUI.b(this.mHX);
      if (localObject == null) {
        j.ebi();
      }
      ((Vibrator)localObject).vibrate(new long[] { 1000L, 1000L, 1000L, 1000L }, 0);
    }
    AppMethodBeat.o(51085);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.forcenotify.ui.ForceNotifyShowUI.c
 * JD-Core Version:    0.7.0.1
 */