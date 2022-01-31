package com.tencent.mm.console;

import android.content.Intent;
import com.tencent.mm.platformtools.ae;
import com.tencent.mm.sdk.platformtools.y;

final class Shell$9
  implements Shell.a
{
  public final void g(Intent paramIntent)
  {
    ae.eST = paramIntent.getStringExtra("acc");
    ae.eSU = paramIntent.getStringExtra("pass");
    y.w("MicroMsg.Shell", "dkwt shell [%s %s]", new Object[] { ae.eST, ae.eSU });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.console.Shell.9
 * JD-Core Version:    0.7.0.1
 */