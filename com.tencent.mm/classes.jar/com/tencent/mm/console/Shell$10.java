package com.tencent.mm.console;

import android.content.Intent;
import com.tencent.mm.platformtools.ae;
import com.tencent.mm.sdk.platformtools.y;

final class Shell$10
  implements Shell.a
{
  public final void g(Intent paramIntent)
  {
    ae.eTv = paramIntent.getIntExtra("flag", 0);
    y.w("MicroMsg.Shell", "dkwt shell [%d]", new Object[] { Integer.valueOf(ae.eTv) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.console.Shell.10
 * JD-Core Version:    0.7.0.1
 */