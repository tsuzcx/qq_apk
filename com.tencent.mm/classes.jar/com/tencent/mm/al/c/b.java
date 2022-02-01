package com.tencent.mm.al.c;

import android.app.Activity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.protocal.protobuf.eco;

public final class b
{
  private boolean hVQ = false;
  private eco hVR;
  
  public final void eW(String paramString)
  {
    AppMethodBeat.i(188910);
    if (this.hVR != null)
    {
      AppMethodBeat.o(188910);
      return;
    }
    if (!this.hVQ)
    {
      n.EG(paramString);
      this.hVQ = true;
    }
    this.hVR = n.EF(paramString);
    AppMethodBeat.o(188910);
  }
  
  public final void z(Activity paramActivity)
  {
    AppMethodBeat.i(188911);
    if (this.hVR == null)
    {
      AppMethodBeat.o(188911);
      return;
    }
    switch (this.hVR.AiS)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(188911);
      return;
      a.a(paramActivity, this.hVR.IhL);
      AppMethodBeat.o(188911);
      return;
      a.a(paramActivity, this.hVR.IhM);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.al.c.b
 * JD-Core Version:    0.7.0.1
 */