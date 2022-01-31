package com.tencent.mm.console;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.h.a.ij;
import com.tencent.mm.h.a.ij.a;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.y;

final class Shell$11
  implements Shell.a
{
  public final void g(Intent paramIntent)
  {
    ij localij = new ij();
    localij.bQz.bQE = paramIntent.getExtras().getString("path", "/data/local/tmp/test.apk");
    y.w("MicroMsg.Shell", "hotpatch test [%s]", new Object[] { localij.bQz.bQE });
    a.udP.m(localij);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.console.Shell.11
 * JD-Core Version:    0.7.0.1
 */