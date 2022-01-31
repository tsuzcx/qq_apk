package com.tencent.mm.console;

import android.content.Intent;
import com.tencent.mm.platformtools.ae;
import com.tencent.mm.sdk.platformtools.y;

final class Shell$8
  implements Shell.a
{
  public final void g(Intent paramIntent)
  {
    ae.eSS = paramIntent.getStringExtra("errmsg");
    y.w("MicroMsg.Shell", "tiger set tigerIDCErrMsg =%s", new Object[] { ae.eSS });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.console.Shell.8
 * JD-Core Version:    0.7.0.1
 */