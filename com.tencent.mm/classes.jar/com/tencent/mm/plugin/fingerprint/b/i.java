package com.tencent.mm.plugin.fingerprint.b;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.od;
import com.tencent.mm.g.a.od.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;

public final class i
  extends com.tencent.mm.sdk.b.c<od>
{
  private String dlu;
  private a tgU;
  od tgV;
  private Runnable tgW;
  boolean tgz;
  
  public i()
  {
    AppMethodBeat.i(160796);
    this.tgW = null;
    this.tgz = false;
    this.dlu = "";
    this.__eventId = od.class.getName().hashCode();
    AppMethodBeat.o(160796);
  }
  
  public static void cPL()
  {
    AppMethodBeat.i(64339);
    ((com.tencent.mm.plugin.fingerprint.b.a.i)g.ab(com.tencent.mm.plugin.fingerprint.b.a.i.class)).cancel();
    AppMethodBeat.o(64339);
  }
  
  final void ah(int paramInt, String paramString)
  {
    AppMethodBeat.i(64341);
    ad.i("MicroMsg.OpenFingerPrintAuthEventListener", "onFail()");
    ((com.tencent.mm.plugin.fingerprint.d.a)g.ab(com.tencent.mm.plugin.fingerprint.d.a.class)).a(this.tgV, paramInt, paramString);
    if (this.tgz) {
      this.tgV = null;
    }
    ad.i("MicroMsg.OpenFingerPrintAuthEventListener", "callback OpenFingerPrintAuthEvent onFail()");
    AppMethodBeat.o(64341);
  }
  
  final boolean mD(boolean paramBoolean)
  {
    AppMethodBeat.i(64340);
    cPL();
    if (!((com.tencent.mm.plugin.fingerprint.b.a.i)g.ab(com.tencent.mm.plugin.fingerprint.b.a.i.class)).cPR())
    {
      ad.e("MicroMsg.OpenFingerPrintAuthEventListener", "no fingerprints enrolled, use settings to enroll fingerprints first");
      release();
      this.tgz = true;
      ah(1, "");
      AppMethodBeat.o(64340);
      return false;
    }
    ((com.tencent.mm.plugin.fingerprint.d.a)g.ab(com.tencent.mm.plugin.fingerprint.d.a.class)).a(this.tgU, paramBoolean);
    ad.i("MicroMsg.OpenFingerPrintAuthEventListener", "startIdentify()");
    AppMethodBeat.o(64340);
    return true;
  }
  
  public final void release()
  {
    AppMethodBeat.i(64338);
    ((com.tencent.mm.plugin.fingerprint.b.a.i)g.ab(com.tencent.mm.plugin.fingerprint.b.a.i.class)).cancel();
    this.tgV = null;
    AppMethodBeat.o(64338);
  }
  
  public final class a
    implements com.tencent.mm.plugin.fingerprint.d.c
  {
    public a() {}
    
    public final void gb(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(64337);
      if (i.this.tgz)
      {
        ad.e("MicroMsg.OpenFingerPrintAuthEventListener", "hy: event already end. ignore");
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
        ad.i("MicroMsg.OpenFingerPrintAuthEventListener", "hy: identify FingerPrintConst.RESULT_SUCCESS");
        Object localObject = i.this;
        ad.i("MicroMsg.OpenFingerPrintAuthEventListener", "onSuccess()");
        ((i)localObject).tgz = true;
        ((com.tencent.mm.plugin.fingerprint.d.a)g.ab(com.tencent.mm.plugin.fingerprint.d.a.class)).a(((i)localObject).tgV, paramInt2);
        if (((i)localObject).tgz) {
          ((i)localObject).tgV = null;
        }
        ad.i("MicroMsg.OpenFingerPrintAuthEventListener", "callback OpenFingerPrintAuthEvent onSuccess()");
        i.cPL();
        AppMethodBeat.o(64337);
        return;
        ad.i("MicroMsg.OpenFingerPrintAuthEventListener", "hy: identify FingerPrintConst.RESULT_NO_MATCH");
        i.this.tgz = false;
        i.cPL();
        i.this.mD(true);
        i.this.ah(1, "");
        AppMethodBeat.o(64337);
        return;
        i.this.mD(false);
        ad.i("MicroMsg.OpenFingerPrintAuthEventListener", "hy: identify FingerPrintConst.RESULT_TIMEOUT");
        AppMethodBeat.o(64337);
        return;
        ad.i("MicroMsg.OpenFingerPrintAuthEventListener", "hy: identify timeout");
        AppMethodBeat.o(64337);
        return;
        ad.i("MicroMsg.OpenFingerPrintAuthEventListener", "hy: on error: %d", new Object[] { Integer.valueOf(paramInt1) });
        i.this.tgz = true;
        localObject = aj.getContext().getString(2131764095);
        if (paramInt1 == 10308) {
          localObject = aj.getContext().getString(2131764096);
        }
        for (;;)
        {
          i.cPL();
          i.this.ah(2, (String)localObject);
          AppMethodBeat.o(64337);
          return;
          if (paramInt1 == 2007) {
            p.thl.thn = true;
          } else if (paramInt1 == 2005) {
            localObject = aj.getContext().getString(2131764097);
          }
        }
        ad.i("MicroMsg.OpenFingerPrintAuthEventListener", "hy: on error: %d", new Object[] { Integer.valueOf(paramInt1) });
        if (i.this.tgV != null) {
          com.tencent.mm.plugin.soter.d.a.RT(i.this.tgV.dBW.dBZ);
        }
        i.this.tgz = true;
        localObject = aj.getContext().getString(2131764095);
        i.cPL();
        i.this.ah(paramInt1, (String)localObject);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fingerprint.b.i
 * JD-Core Version:    0.7.0.1
 */