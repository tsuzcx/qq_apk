package com.tencent.mm.ipcinvoker.f;

import android.os.IBinder.DeathRecipient;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a
  implements IBinder.DeathRecipient
{
  private String process;
  
  public a(String paramString)
  {
    this.process = paramString;
  }
  
  public final void binderDied()
  {
    AppMethodBeat.i(158820);
    com.tencent.mm.ipcinvoker.h.b.i("IPC.DeathRecipientImpl", "binderDied(%s)", new Object[] { this.process });
    if ((this.process == null) || (this.process.length() == 0))
    {
      AppMethodBeat.o(158820);
      return;
    }
    b.xh(this.process);
    AppMethodBeat.o(158820);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ipcinvoker.f.a
 * JD-Core Version:    0.7.0.1
 */