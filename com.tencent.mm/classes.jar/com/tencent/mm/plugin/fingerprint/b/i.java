package com.tencent.mm.plugin.fingerprint.b;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.nm;
import com.tencent.mm.g.a.nm.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;

public final class i
  extends com.tencent.mm.sdk.b.c<nm>
{
  private String dcE;
  boolean rbD;
  private a rbY;
  nm rbZ;
  private Runnable rca;
  
  public i()
  {
    AppMethodBeat.i(160796);
    this.rca = null;
    this.rbD = false;
    this.dcE = "";
    this.__eventId = nm.class.getName().hashCode();
    AppMethodBeat.o(160796);
  }
  
  public static void cuk()
  {
    AppMethodBeat.i(64339);
    ((com.tencent.mm.plugin.fingerprint.b.a.i)g.ab(com.tencent.mm.plugin.fingerprint.b.a.i.class)).cancel();
    AppMethodBeat.o(64339);
  }
  
  final void ae(int paramInt, String paramString)
  {
    AppMethodBeat.i(64341);
    ad.i("MicroMsg.OpenFingerPrintAuthEventListener", "onFail()");
    ((com.tencent.mm.plugin.fingerprint.d.a)g.ab(com.tencent.mm.plugin.fingerprint.d.a.class)).a(this.rbZ, paramInt, paramString);
    if (this.rbD) {
      this.rbZ = null;
    }
    ad.i("MicroMsg.OpenFingerPrintAuthEventListener", "callback OpenFingerPrintAuthEvent onFail()");
    AppMethodBeat.o(64341);
  }
  
  final boolean lu(boolean paramBoolean)
  {
    AppMethodBeat.i(64340);
    cuk();
    if (!((com.tencent.mm.plugin.fingerprint.b.a.i)g.ab(com.tencent.mm.plugin.fingerprint.b.a.i.class)).cuq())
    {
      ad.e("MicroMsg.OpenFingerPrintAuthEventListener", "no fingerprints enrolled, use settings to enroll fingerprints first");
      release();
      this.rbD = true;
      ae(1, "");
      AppMethodBeat.o(64340);
      return false;
    }
    ((com.tencent.mm.plugin.fingerprint.d.a)g.ab(com.tencent.mm.plugin.fingerprint.d.a.class)).a(this.rbY, paramBoolean);
    ad.i("MicroMsg.OpenFingerPrintAuthEventListener", "startIdentify()");
    AppMethodBeat.o(64340);
    return true;
  }
  
  public final void release()
  {
    AppMethodBeat.i(64338);
    ((com.tencent.mm.plugin.fingerprint.b.a.i)g.ab(com.tencent.mm.plugin.fingerprint.b.a.i.class)).cancel();
    this.rbZ = null;
    AppMethodBeat.o(64338);
  }
  
  public final class a
    implements com.tencent.mm.plugin.fingerprint.d.c
  {
    public a() {}
    
    public final void fE(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(64337);
      if (i.this.rbD)
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
        ((i)localObject).rbD = true;
        ((com.tencent.mm.plugin.fingerprint.d.a)g.ab(com.tencent.mm.plugin.fingerprint.d.a.class)).a(((i)localObject).rbZ, paramInt2);
        if (((i)localObject).rbD) {
          ((i)localObject).rbZ = null;
        }
        ad.i("MicroMsg.OpenFingerPrintAuthEventListener", "callback OpenFingerPrintAuthEvent onSuccess()");
        i.cuk();
        AppMethodBeat.o(64337);
        return;
        ad.i("MicroMsg.OpenFingerPrintAuthEventListener", "hy: identify FingerPrintConst.RESULT_NO_MATCH");
        i.this.rbD = false;
        i.cuk();
        i.this.lu(true);
        i.this.ae(1, "");
        AppMethodBeat.o(64337);
        return;
        i.this.lu(false);
        ad.i("MicroMsg.OpenFingerPrintAuthEventListener", "hy: identify FingerPrintConst.RESULT_TIMEOUT");
        AppMethodBeat.o(64337);
        return;
        ad.i("MicroMsg.OpenFingerPrintAuthEventListener", "hy: identify timeout");
        AppMethodBeat.o(64337);
        return;
        ad.i("MicroMsg.OpenFingerPrintAuthEventListener", "hy: on error: %d", new Object[] { Integer.valueOf(paramInt1) });
        i.this.rbD = true;
        localObject = aj.getContext().getString(2131764095);
        if (paramInt1 == 10308) {
          localObject = aj.getContext().getString(2131764096);
        }
        for (;;)
        {
          i.cuk();
          i.this.ae(2, (String)localObject);
          AppMethodBeat.o(64337);
          return;
          if (paramInt1 == 2007) {
            p.rcp.rcr = true;
          } else if (paramInt1 == 2005) {
            localObject = aj.getContext().getString(2131764097);
          }
        }
        ad.i("MicroMsg.OpenFingerPrintAuthEventListener", "hy: on error: %d", new Object[] { Integer.valueOf(paramInt1) });
        if (i.this.rbZ != null) {
          com.tencent.mm.plugin.soter.d.a.Og(i.this.rbZ.dsz.dsC);
        }
        i.this.rbD = true;
        localObject = aj.getContext().getString(2131764095);
        i.cuk();
        i.this.ae(paramInt1, (String)localObject);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fingerprint.b.i
 * JD-Core Version:    0.7.0.1
 */