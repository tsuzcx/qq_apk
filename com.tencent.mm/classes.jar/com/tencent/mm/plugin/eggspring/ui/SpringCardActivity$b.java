package com.tencent.mm.plugin.eggspring.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.q;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"com/tencent/mm/plugin/eggspring/ui/SpringCardActivity$onCreate$1", "Lcom/tencent/mm/app/IAppForegroundListener;", "onAppBackground", "", "activity", "", "onAppForeground", "plugin-eggspring_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class SpringCardActivity$b
  implements q
{
  public final void onAppBackground(String paramString)
  {
    AppMethodBeat.i(266552);
    Log.d("MicroMsg.SpringCardActivity", "onAppBackground");
    AppMethodBeat.o(266552);
  }
  
  public final void onAppForeground(String paramString)
  {
    AppMethodBeat.i(266545);
    Log.d("MicroMsg.SpringCardActivity", "onAppForeground");
    AppMethodBeat.o(266545);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.eggspring.ui.SpringCardActivity.b
 * JD-Core Version:    0.7.0.1
 */