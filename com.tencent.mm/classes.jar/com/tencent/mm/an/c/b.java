package com.tencent.mm.an.c;

import android.app.Activity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.n;
import com.tencent.mm.protocal.protobuf.gdu;

public final class b
{
  private boolean oyL = false;
  private gdu oyM;
  
  public final void B(Activity paramActivity)
  {
    AppMethodBeat.i(239439);
    if (this.oyM == null)
    {
      AppMethodBeat.o(239439);
      return;
    }
    switch (this.oyM.DnR)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(239439);
      return;
      a.a(paramActivity, this.oyM.acbz);
      AppMethodBeat.o(239439);
      return;
      a.a(paramActivity, this.oyM.acbA);
    }
  }
  
  public final void hT(String paramString)
  {
    AppMethodBeat.i(239438);
    if (this.oyM != null)
    {
      AppMethodBeat.o(239438);
      return;
    }
    if (!this.oyL)
    {
      n.MP(paramString);
      this.oyL = true;
    }
    this.oyM = n.MO(paramString);
    AppMethodBeat.o(239438);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.an.c.b
 * JD-Core Version:    0.7.0.1
 */