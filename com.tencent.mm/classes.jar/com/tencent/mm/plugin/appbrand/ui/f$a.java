package com.tencent.mm.plugin.appbrand.ui;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.ui.base.i;

public final class f$a
  extends i
{
  public f$a(Context paramContext)
  {
    super(paramContext, 2131820560);
  }
  
  public final void dismiss()
  {
    AppMethodBeat.i(48657);
    if (ap.isMainThread())
    {
      super.dismiss();
      AppMethodBeat.o(48657);
      return;
    }
    ap.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(48656);
        f.a.a(f.a.this);
        AppMethodBeat.o(48656);
      }
    });
    AppMethodBeat.o(48657);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.f.a
 * JD-Core Version:    0.7.0.1
 */