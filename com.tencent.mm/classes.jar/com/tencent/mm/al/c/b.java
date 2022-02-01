package com.tencent.mm.al.c;

import android.app.Activity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.protocal.protobuf.eww;

public final class b
{
  private boolean iQO = false;
  private eww iQP;
  
  public final void fI(String paramString)
  {
    AppMethodBeat.i(212208);
    if (this.iQP != null)
    {
      AppMethodBeat.o(212208);
      return;
    }
    if (!this.iQO)
    {
      n.Nu(paramString);
      this.iQO = true;
    }
    this.iQP = n.Nt(paramString);
    AppMethodBeat.o(212208);
  }
  
  public final void z(Activity paramActivity)
  {
    AppMethodBeat.i(212209);
    if (this.iQP == null)
    {
      AppMethodBeat.o(212209);
      return;
    }
    switch (this.iQP.vjQ)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(212209);
      return;
      a.a(paramActivity, this.iQP.Nup);
      AppMethodBeat.o(212209);
      return;
      a.a(paramActivity, this.iQP.Nuq);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.al.c.b
 * JD-Core Version:    0.7.0.1
 */