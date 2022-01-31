package com.tencent.mm.plugin.appbrand.ui;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.ui.base.i;

public final class d$a
  extends i
{
  public d$a(Context paramContext)
  {
    super(paramContext, 2131493043);
  }
  
  public final void dismiss()
  {
    AppMethodBeat.i(143593);
    if (al.isMainThread())
    {
      super.dismiss();
      AppMethodBeat.o(143593);
      return;
    }
    al.d(new d.a.1(this));
    AppMethodBeat.o(143593);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.d.a
 * JD-Core Version:    0.7.0.1
 */