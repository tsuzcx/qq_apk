package com.tencent.mm.plugin.appbrand.ui;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.ui.base.i;

public final class h$a
  extends i
{
  public h$a(Context paramContext, int paramInt)
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
        h.a.a(h.a.this);
        AppMethodBeat.o(48656);
      }
    });
    AppMethodBeat.o(48657);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.h.a
 * JD-Core Version:    0.7.0.1
 */