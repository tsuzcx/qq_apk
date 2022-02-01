package com.tencent.mm.ao.c;

import android.app.Activity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ao.n;
import com.tencent.mm.protocal.protobuf.fhi;

public final class b
{
  private boolean lHe = false;
  private fhi lHf;
  
  public final void gt(String paramString)
  {
    AppMethodBeat.i(205329);
    if (this.lHf != null)
    {
      AppMethodBeat.o(205329);
      return;
    }
    if (!this.lHe)
    {
      n.UQ(paramString);
      this.lHe = true;
    }
    this.lHf = n.UP(paramString);
    AppMethodBeat.o(205329);
  }
  
  public final void y(Activity paramActivity)
  {
    AppMethodBeat.i(205331);
    if (this.lHf == null)
    {
      AppMethodBeat.o(205331);
      return;
    }
    switch (this.lHf.yAT)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(205331);
      return;
      a.a(paramActivity, this.lHf.UHp);
      AppMethodBeat.o(205331);
      return;
      a.a(paramActivity, this.lHf.UHq);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ao.c.b
 * JD-Core Version:    0.7.0.1
 */