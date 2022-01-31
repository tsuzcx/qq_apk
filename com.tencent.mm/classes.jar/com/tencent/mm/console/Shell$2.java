package com.tencent.mm.console;

import android.content.Intent;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ai;

final class Shell$2
  implements Shell.a
{
  public final void g(Intent paramIntent)
  {
    if (!ae.cqV()) {}
    do
    {
      return;
      String str = paramIntent.getStringExtra("sql");
      paramIntent = paramIntent.getStringExtra("file");
      if ((str != null) && (str.length() > 0))
      {
        g.DS().O(new Shell.2.1(this, str));
        return;
      }
    } while ((paramIntent == null) || (paramIntent.length() <= 0));
    g.DS().O(new Shell.2.2(this, paramIntent));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.console.Shell.2
 * JD-Core Version:    0.7.0.1
 */