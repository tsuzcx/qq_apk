package com.tencent.mm.ipcinvoker.f;

import android.os.IBinder.DeathRecipient;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.h.c;

public final class a
  implements IBinder.DeathRecipient
{
  private final String jZi;
  
  public a(String paramString)
  {
    this.jZi = paramString;
  }
  
  public final void binderDied()
  {
    AppMethodBeat.i(158820);
    c.i("IPC.DeathRecipientImpl", "binderDied(%s)", new Object[] { this.jZi });
    if ((this.jZi == null) || (this.jZi.length() == 0))
    {
      AppMethodBeat.o(158820);
      return;
    }
    b.Mt(this.jZi);
    AppMethodBeat.o(158820);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ipcinvoker.f.a
 * JD-Core Version:    0.7.0.1
 */