package com.tencent.mm.plugin.appbrand.game.b;

import com.tencent.magicbrush.a.c.a;
import com.tencent.mm.compatible.util.k;
import com.tencent.mm.plugin.appbrand.game.f.d;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.y;

final class c$1
  implements c.a
{
  public final void loadLibrary(String paramString)
  {
    try
    {
      y.i("MicroMsg.MBLoadDelegateRegistery", "loadLibrary libName:%s", new Object[] { paramString });
      k.b(paramString, c.class.getClassLoader());
      return;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      y.printErrStackTrace("MicroMsg.MBLoadDelegateRegistery", localUnsatisfiedLinkError, "hy: link %s error!!", new Object[] { paramString });
      d.ci(ae.getContext());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.game.b.c.1
 * JD-Core Version:    0.7.0.1
 */