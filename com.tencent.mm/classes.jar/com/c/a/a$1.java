package com.c.a;

import android.os.IBinder.DeathRecipient;

final class a$1
  implements IBinder.DeathRecipient
{
  a$1(a parama) {}
  
  public final void binderDied()
  {
    if (this.aUX.aUU != null) {
      this.aUX.aUU.aR(2101, -1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.c.a.a.1
 * JD-Core Version:    0.7.0.1
 */