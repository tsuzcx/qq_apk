package com.tencent.mm.am.c;

import android.app.Activity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.n;
import com.tencent.mm.protocal.protobuf.eax;

public final class b
{
  private boolean hSY = false;
  private eax hSZ;
  
  public final void eR(String paramString)
  {
    AppMethodBeat.i(207212);
    if (this.hSZ != null)
    {
      AppMethodBeat.o(207212);
      return;
    }
    if (!this.hSY)
    {
      n.Ee(paramString);
      this.hSY = true;
    }
    this.hSZ = n.Ed(paramString);
    AppMethodBeat.o(207212);
  }
  
  public final void z(Activity paramActivity)
  {
    AppMethodBeat.i(207213);
    if (this.hSZ == null)
    {
      AppMethodBeat.o(207213);
      return;
    }
    switch (this.hSZ.zRL)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(207213);
      return;
      a.a(paramActivity, this.hSZ.HNE);
      AppMethodBeat.o(207213);
      return;
      a.a(paramActivity, this.hSZ.HNF);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.am.c.b
 * JD-Core Version:    0.7.0.1
 */