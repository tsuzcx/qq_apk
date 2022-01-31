package com.tencent.mm.console;

import android.content.Intent;
import com.tencent.mm.platformtools.ae;
import com.tencent.mm.sdk.platformtools.y;

final class Shell$1
  implements Shell.a
{
  public final void g(Intent paramIntent)
  {
    int i = paramIntent.getIntExtra("type", 2147483647);
    int j = paramIntent.getIntExtra("error", 0);
    if ((i == 2147483647) || (j == 0)) {
      return;
    }
    y.w("MicroMsg.Shell", "kiro set Test.pushNextErrorRet(type=%d, err=%d)", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
    ae.bB(i, j);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.console.Shell.1
 * JD-Core Version:    0.7.0.1
 */