package com.tencent.mm.al.c;

import android.app.Activity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.m;
import com.tencent.mm.protocal.protobuf.dvd;

public final class b
{
  private boolean hAD = false;
  private dvd hAE;
  
  public final void dW(String paramString)
  {
    AppMethodBeat.i(209559);
    if (this.hAE != null)
    {
      AppMethodBeat.o(209559);
      return;
    }
    if (!this.hAD)
    {
      m.Bf(paramString);
      this.hAD = true;
    }
    this.hAE = m.Be(paramString);
    AppMethodBeat.o(209559);
  }
  
  public final void z(Activity paramActivity)
  {
    AppMethodBeat.i(209560);
    if (this.hAE == null)
    {
      AppMethodBeat.o(209560);
      return;
    }
    switch (this.hAE.yAv)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(209560);
      return;
      a.a(paramActivity, this.hAE.GcH);
      AppMethodBeat.o(209560);
      return;
      a.a(paramActivity, this.hAE.GcI);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.al.c.b
 * JD-Core Version:    0.7.0.1
 */