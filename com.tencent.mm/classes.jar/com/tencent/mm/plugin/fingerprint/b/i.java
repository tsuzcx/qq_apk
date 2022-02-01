package com.tencent.mm.plugin.fingerprint.b;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.oe;
import com.tencent.mm.g.a.oe.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;

public final class i
  extends com.tencent.mm.sdk.b.c<oe>
{
  private String dmw;
  private a trN;
  oe trO;
  private Runnable trP;
  boolean trs;
  
  public i()
  {
    AppMethodBeat.i(160796);
    this.trP = null;
    this.trs = false;
    this.dmw = "";
    this.__eventId = oe.class.getName().hashCode();
    AppMethodBeat.o(160796);
  }
  
  public static void cSq()
  {
    AppMethodBeat.i(64339);
    ((com.tencent.mm.plugin.fingerprint.b.a.i)g.ab(com.tencent.mm.plugin.fingerprint.b.a.i.class)).cancel();
    AppMethodBeat.o(64339);
  }
  
  final void ah(int paramInt, String paramString)
  {
    AppMethodBeat.i(64341);
    ae.i("MicroMsg.OpenFingerPrintAuthEventListener", "onFail()");
    ((com.tencent.mm.plugin.fingerprint.d.a)g.ab(com.tencent.mm.plugin.fingerprint.d.a.class)).a(this.trO, paramInt, paramString);
    if (this.trs) {
      this.trO = null;
    }
    ae.i("MicroMsg.OpenFingerPrintAuthEventListener", "callback OpenFingerPrintAuthEvent onFail()");
    AppMethodBeat.o(64341);
  }
  
  final boolean mH(boolean paramBoolean)
  {
    AppMethodBeat.i(64340);
    cSq();
    if (!((com.tencent.mm.plugin.fingerprint.b.a.i)g.ab(com.tencent.mm.plugin.fingerprint.b.a.i.class)).cSw())
    {
      ae.e("MicroMsg.OpenFingerPrintAuthEventListener", "no fingerprints enrolled, use settings to enroll fingerprints first");
      release();
      this.trs = true;
      ah(1, "");
      AppMethodBeat.o(64340);
      return false;
    }
    ((com.tencent.mm.plugin.fingerprint.d.a)g.ab(com.tencent.mm.plugin.fingerprint.d.a.class)).a(this.trN, paramBoolean);
    ae.i("MicroMsg.OpenFingerPrintAuthEventListener", "startIdentify()");
    AppMethodBeat.o(64340);
    return true;
  }
  
  public final void release()
  {
    AppMethodBeat.i(64338);
    ((com.tencent.mm.plugin.fingerprint.b.a.i)g.ab(com.tencent.mm.plugin.fingerprint.b.a.i.class)).cancel();
    this.trO = null;
    AppMethodBeat.o(64338);
  }
  
  public final class a
    implements com.tencent.mm.plugin.fingerprint.d.c
  {
    public a() {}
    
    public final void gb(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(64337);
      if (i.this.trs)
      {
        ae.e("MicroMsg.OpenFingerPrintAuthEventListener", "hy: event already end. ignore");
        AppMethodBeat.o(64337);
        return;
      }
      switch (paramInt1)
      {
      }
      for (;;)
      {
        AppMethodBeat.o(64337);
        return;
        ae.i("MicroMsg.OpenFingerPrintAuthEventListener", "hy: identify FingerPrintConst.RESULT_SUCCESS");
        Object localObject = i.this;
        ae.i("MicroMsg.OpenFingerPrintAuthEventListener", "onSuccess()");
        ((i)localObject).trs = true;
        ((com.tencent.mm.plugin.fingerprint.d.a)g.ab(com.tencent.mm.plugin.fingerprint.d.a.class)).a(((i)localObject).trO, paramInt2);
        if (((i)localObject).trs) {
          ((i)localObject).trO = null;
        }
        ae.i("MicroMsg.OpenFingerPrintAuthEventListener", "callback OpenFingerPrintAuthEvent onSuccess()");
        i.cSq();
        AppMethodBeat.o(64337);
        return;
        ae.i("MicroMsg.OpenFingerPrintAuthEventListener", "hy: identify FingerPrintConst.RESULT_NO_MATCH");
        i.this.trs = false;
        i.cSq();
        i.this.mH(true);
        i.this.ah(1, "");
        AppMethodBeat.o(64337);
        return;
        i.this.mH(false);
        ae.i("MicroMsg.OpenFingerPrintAuthEventListener", "hy: identify FingerPrintConst.RESULT_TIMEOUT");
        AppMethodBeat.o(64337);
        return;
        ae.i("MicroMsg.OpenFingerPrintAuthEventListener", "hy: identify timeout");
        AppMethodBeat.o(64337);
        return;
        ae.i("MicroMsg.OpenFingerPrintAuthEventListener", "hy: on error: %d", new Object[] { Integer.valueOf(paramInt1) });
        i.this.trs = true;
        localObject = ak.getContext().getString(2131764095);
        if (paramInt1 == 10308) {
          localObject = ak.getContext().getString(2131764096);
        }
        for (;;)
        {
          i.cSq();
          i.this.ah(2, (String)localObject);
          AppMethodBeat.o(64337);
          return;
          if (paramInt1 == 2007) {
            p.tse.tsg = true;
          } else if (paramInt1 == 2005) {
            localObject = ak.getContext().getString(2131764097);
          }
        }
        ae.i("MicroMsg.OpenFingerPrintAuthEventListener", "hy: on error: %d", new Object[] { Integer.valueOf(paramInt1) });
        if (i.this.trO != null) {
          com.tencent.mm.plugin.soter.d.a.SA(i.this.trO.dDb.dDe);
        }
        i.this.trs = true;
        localObject = ak.getContext().getString(2131764095);
        i.cSq();
        i.this.ah(paramInt1, (String)localObject);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fingerprint.b.i
 * JD-Core Version:    0.7.0.1
 */