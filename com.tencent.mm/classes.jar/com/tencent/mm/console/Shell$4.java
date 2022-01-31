package com.tencent.mm.console;

import android.content.Intent;
import com.tencent.mm.sdk.platformtools.y;

final class Shell$4
  implements Shell.a
{
  public final void g(Intent paramIntent)
  {
    int i = paramIntent.getIntExtra("level", 0);
    y.w("MicroMsg.Shell", "kiro set Log.level=%d", new Object[] { Integer.valueOf(y.getLogLevel()) });
    y.Fc(i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.console.Shell.4
 * JD-Core Version:    0.7.0.1
 */