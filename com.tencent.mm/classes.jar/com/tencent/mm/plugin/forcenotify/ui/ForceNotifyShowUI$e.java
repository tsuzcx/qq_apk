package com.tencent.mm.plugin.forcenotify.ui;

import a.f.b.j;
import a.l;
import android.media.MediaPlayer;
import android.os.Vibrator;
import android.view.View;
import android.view.Window;
import com.tencent.matrix.trace.core.AppMethodBeat;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "run"})
final class ForceNotifyShowUI$e
  implements Runnable
{
  ForceNotifyShowUI$e(ForceNotifyShowUI paramForceNotifyShowUI) {}
  
  public final void run()
  {
    AppMethodBeat.i(51087);
    try
    {
      Object localObject = ForceNotifyShowUI.b(this.mHX);
      if (localObject != null) {
        ((Vibrator)localObject).cancel();
      }
      localObject = ForceNotifyShowUI.a(this.mHX);
      if (localObject != null) {
        ((MediaPlayer)localObject).stop();
      }
      localObject = ForceNotifyShowUI.a(this.mHX);
      if (localObject != null) {
        ((MediaPlayer)localObject).release();
      }
      localObject = this.mHX.getWindow();
      j.p(localObject, "window");
      localObject = ((Window)localObject).getDecorView();
      j.p(localObject, "window.decorView");
      ((View)localObject).setKeepScreenOn(false);
      AppMethodBeat.o(51087);
      return;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(51087);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.forcenotify.ui.ForceNotifyShowUI.e
 * JD-Core Version:    0.7.0.1
 */