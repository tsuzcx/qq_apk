package com.tencent.mm.console;

import android.content.Intent;
import com.tencent.mm.h.a.go;
import com.tencent.mm.modelmulti.n;
import com.tencent.mm.modelmulti.o;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.y;

final class Shell$6
  implements Shell.a
{
  public final void g(Intent paramIntent)
  {
    com.tencent.mm.platformtools.ae.eSP = paramIntent.getIntExtra("key", 0);
    com.tencent.mm.platformtools.ae.eSQ = paramIntent.getIntExtra("val", 0);
    com.tencent.mm.platformtools.ae.eSR = paramIntent.getStringExtra("str");
    y.w("MicroMsg.Shell", "dkshell set [%d %d] [%s]", new Object[] { Integer.valueOf(com.tencent.mm.platformtools.ae.eSP), Integer.valueOf(com.tencent.mm.platformtools.ae.eSQ), com.tencent.mm.platformtools.ae.eSR });
    if (10009 == com.tencent.mm.platformtools.ae.eSP)
    {
      int i = com.tencent.mm.platformtools.ae.eSQ;
      Shell.AC();
    }
    do
    {
      return;
      if ((10014 == com.tencent.mm.platformtools.ae.eSP) && (com.tencent.mm.sdk.platformtools.ae.cqV()))
      {
        n.Pm().a(7L, 1, "");
        return;
      }
    } while ((10015 != com.tencent.mm.platformtools.ae.eSP) || (!com.tencent.mm.sdk.platformtools.ae.cqW()));
    paramIntent = new go();
    paramIntent.bOp.type = 13;
    a.udP.m(paramIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.console.Shell.6
 * JD-Core Version:    0.7.0.1
 */