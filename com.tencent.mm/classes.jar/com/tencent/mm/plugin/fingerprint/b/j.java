package com.tencent.mm.plugin.fingerprint.b;

import com.tencent.mm.h.a.ll;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fingerprint.a;
import com.tencent.mm.sdk.platformtools.y;

public final class j
  extends com.tencent.mm.sdk.b.c<ll>
{
  private String bMX = "";
  boolean kkX = false;
  private j.a klq;
  ll klr;
  private com.tencent.mm.pluginsdk.wallet.k kls = null;
  private Runnable klt = null;
  
  public j()
  {
    this.udX = ll.class.getName().hashCode();
  }
  
  public static void aTc()
  {
    a.aSf();
    if (a.aSg() != null)
    {
      a.aSf();
      a.aSg();
      c.abort();
      a.aSf();
      a.aSg();
      c.release();
      a.aSf();
      a.aSg();
      if (((com.tencent.mm.pluginsdk.k)g.r(com.tencent.mm.pluginsdk.k.class)).type() != 2) {
        break label78;
      }
    }
    label78:
    for (boolean bool = true;; bool = false)
    {
      y.i("MicroMsg.OpenFingerPrintAuthEventListener", "stopIdentify() isSoter: %b", new Object[] { Boolean.valueOf(bool) });
      return;
    }
  }
  
  final void U(int paramInt, String paramString)
  {
    y.i("MicroMsg.OpenFingerPrintAuthEventListener", "onFail()");
    a.aSf();
    a.aSg();
    ll localll = this.klr;
    ((com.tencent.mm.pluginsdk.k)g.r(com.tencent.mm.pluginsdk.k.class)).a(localll, paramInt, paramString);
    if (this.kkX) {
      this.klr = null;
    }
    y.i("MicroMsg.OpenFingerPrintAuthEventListener", "callback OpenFingerPrintAuthEvent onFail()");
  }
  
  final boolean gk(boolean paramBoolean)
  {
    aTc();
    a.aSf();
    a.aSg();
    if (!c.aSD())
    {
      y.e("MicroMsg.OpenFingerPrintAuthEventListener", "no fingerprints enrolled, use settings to enroll fingerprints first");
      release();
      this.kkX = true;
      U(1, "");
      return false;
    }
    a.aSf();
    a.aSg();
    if (c.a(this.klq, paramBoolean) != 0)
    {
      y.e("MicroMsg.OpenFingerPrintAuthEventListener", "failed to start identify");
      release();
      this.kkX = true;
      U(1, "");
      return false;
    }
    y.i("MicroMsg.OpenFingerPrintAuthEventListener", "startIdentify()");
    return true;
  }
  
  public final void release()
  {
    a.aSf();
    if (a.aSg() != null)
    {
      a.aSf();
      a.aSg();
      c.release();
    }
    this.klr = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.fingerprint.b.j
 * JD-Core Version:    0.7.0.1
 */