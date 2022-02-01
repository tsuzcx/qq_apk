package com.tencent.mm.plugin.appbrand.ui;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.ui.widget.a.i;

public final class g$a
  extends i
{
  public g$a(Context paramContext, int paramInt)
  {
    super(paramContext, paramInt);
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
        g.a.a(g.a.this);
        AppMethodBeat.o(48656);
      }
    });
    AppMethodBeat.o(48657);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.g.a
 * JD-Core Version:    0.7.0.1
 */