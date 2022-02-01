package com.tencent.mm.am.c;

import android.app.Activity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.m;
import com.tencent.mm.protocal.protobuf.dpm;

public final class b
{
  private boolean hae = false;
  private dpm haf;
  
  public final void eh(String paramString)
  {
    AppMethodBeat.i(191083);
    if (this.haf != null)
    {
      AppMethodBeat.o(191083);
      return;
    }
    if (!this.hae)
    {
      m.wZ(paramString);
      this.hae = true;
    }
    this.haf = m.wY(paramString);
    AppMethodBeat.o(191083);
  }
  
  public final void z(Activity paramActivity)
  {
    AppMethodBeat.i(191084);
    if (this.haf == null)
    {
      AppMethodBeat.o(191084);
      return;
    }
    switch (this.haf.xnE)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(191084);
      return;
      a.a(paramActivity, this.haf.EFv);
      AppMethodBeat.o(191084);
      return;
      a.a(paramActivity, this.haf.EFw);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.am.c.b
 * JD-Core Version:    0.7.0.1
 */