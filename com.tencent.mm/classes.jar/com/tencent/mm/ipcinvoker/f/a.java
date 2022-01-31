package com.tencent.mm.ipcinvoker.f;

import android.os.IBinder.DeathRecipient;

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
    com.tencent.mm.ipcinvoker.h.b.i("IPC.DeathRecipientImpl", "binderDied(%s)", new Object[] { this.process });
    if ((this.process == null) || (this.process.length() == 0)) {
      return;
    }
    b.fI(this.process);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ipcinvoker.f.a
 * JD-Core Version:    0.7.0.1
 */