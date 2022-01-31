package com.tencent.mm.plugin.fingerprint.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.ma;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fingerprint.a;
import com.tencent.mm.sdk.platformtools.ab;

public final class j
  extends com.tencent.mm.sdk.b.c<ma>
{
  private String cnI;
  boolean mFK;
  private j.a mGe;
  ma mGf;
  private com.tencent.mm.pluginsdk.wallet.l mGg;
  private Runnable mGh;
  
  public j()
  {
    AppMethodBeat.i(41491);
    this.mGg = null;
    this.mGh = null;
    this.mFK = false;
    this.cnI = "";
    this.__eventId = ma.class.getName().hashCode();
    AppMethodBeat.o(41491);
  }
  
  public static void bzx()
  {
    AppMethodBeat.i(41493);
    a.byD();
    if (a.byE() != null)
    {
      a.byD();
      a.byE();
      c.abort();
      a.byD();
      a.byE();
      c.release();
      a.byD();
      a.byE();
      if (((com.tencent.mm.pluginsdk.l)g.E(com.tencent.mm.pluginsdk.l.class)).type() != 2) {
        break label88;
      }
    }
    label88:
    for (boolean bool = true;; bool = false)
    {
      ab.i("MicroMsg.OpenFingerPrintAuthEventListener", "stopIdentify() isSoter: %b", new Object[] { Boolean.valueOf(bool) });
      AppMethodBeat.o(41493);
      return;
    }
  }
  
  final void S(int paramInt, String paramString)
  {
    AppMethodBeat.i(41495);
    ab.i("MicroMsg.OpenFingerPrintAuthEventListener", "onFail()");
    a.byD();
    a.byE();
    c.a(this.mGf, paramInt, paramString);
    if (this.mFK) {
      this.mGf = null;
    }
    ab.i("MicroMsg.OpenFingerPrintAuthEventListener", "callback OpenFingerPrintAuthEvent onFail()");
    AppMethodBeat.o(41495);
  }
  
  final boolean hM(boolean paramBoolean)
  {
    AppMethodBeat.i(41494);
    bzx();
    a.byD();
    a.byE();
    if (!c.byY())
    {
      ab.e("MicroMsg.OpenFingerPrintAuthEventListener", "no fingerprints enrolled, use settings to enroll fingerprints first");
      release();
      this.mFK = true;
      S(1, "");
      AppMethodBeat.o(41494);
      return false;
    }
    a.byD();
    a.byE();
    if (c.a(this.mGe, paramBoolean) != 0)
    {
      ab.e("MicroMsg.OpenFingerPrintAuthEventListener", "failed to start identify");
      release();
      this.mFK = true;
      S(1, "");
      AppMethodBeat.o(41494);
      return false;
    }
    ab.i("MicroMsg.OpenFingerPrintAuthEventListener", "startIdentify()");
    AppMethodBeat.o(41494);
    return true;
  }
  
  public final void release()
  {
    AppMethodBeat.i(41492);
    a.byD();
    if (a.byE() != null)
    {
      a.byD();
      a.byE();
      c.release();
    }
    this.mGf = null;
    AppMethodBeat.o(41492);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.fingerprint.b.j
 * JD-Core Version:    0.7.0.1
 */