package com.tencent.mm.plugin.appbrand.ui;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.ui.base.i;

public final class j$a
  extends i
{
  public j$a(Context paramContext)
  {
    super(paramContext, 2131820561);
  }
  
  public final void dismiss()
  {
    AppMethodBeat.i(48657);
    if (MMHandlerThread.isMainThread())
    {
      super.dismiss();
      AppMethodBeat.o(48657);
      return;
    }
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(48656);
        j.a.a(j.a.this);
        AppMethodBeat.o(48656);
      }
    });
    AppMethodBeat.o(48657);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.j.a
 * JD-Core Version:    0.7.0.1
 */