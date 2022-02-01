package com.tencent.mm.plugin.forcenotify.ui;

import android.app.Activity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.MMActivity;
import kotlin.l;
import kotlin.n;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/forcenotify/ui/ForceNotifyRequestPermissionDialog;", "Lcom/tencent/mm/ui/MMActivity;", "()V", "getLayoutId", "", "plugin-force-notify_release"})
public final class ForceNotifyRequestPermissionDialog
  extends MMActivity
{
  public final int getLayoutId()
  {
    AppMethodBeat.i(199476);
    Throwable localThrowable = (Throwable)new n("An operation is not implemented: ".concat(String.valueOf("Not yet implemented")));
    AppMethodBeat.o(199476);
    throw localThrowable;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.forcenotify.ui.ForceNotifyRequestPermissionDialog
 * JD-Core Version:    0.7.0.1
 */