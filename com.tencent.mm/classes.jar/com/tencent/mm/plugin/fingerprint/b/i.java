package com.tencent.mm.plugin.fingerprint.b;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.nv;
import com.tencent.mm.g.a.nv.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;

public final class i
  extends com.tencent.mm.sdk.b.c<nv>
{
  private String dac;
  boolean sjX;
  private a sks;
  nv skt;
  private Runnable sku;
  
  public i()
  {
    AppMethodBeat.i(160796);
    this.sku = null;
    this.sjX = false;
    this.dac = "";
    this.__eventId = nv.class.getName().hashCode();
    AppMethodBeat.o(160796);
  }
  
  public static void cHw()
  {
    AppMethodBeat.i(64339);
    ((com.tencent.mm.plugin.fingerprint.b.a.i)g.ab(com.tencent.mm.plugin.fingerprint.b.a.i.class)).cancel();
    AppMethodBeat.o(64339);
  }
  
  final void af(int paramInt, String paramString)
  {
    AppMethodBeat.i(64341);
    ac.i("MicroMsg.OpenFingerPrintAuthEventListener", "onFail()");
    ((com.tencent.mm.plugin.fingerprint.d.a)g.ab(com.tencent.mm.plugin.fingerprint.d.a.class)).a(this.skt, paramInt, paramString);
    if (this.sjX) {
      this.skt = null;
    }
    ac.i("MicroMsg.OpenFingerPrintAuthEventListener", "callback OpenFingerPrintAuthEvent onFail()");
    AppMethodBeat.o(64341);
  }
  
  final boolean mm(boolean paramBoolean)
  {
    AppMethodBeat.i(64340);
    cHw();
    if (!((com.tencent.mm.plugin.fingerprint.b.a.i)g.ab(com.tencent.mm.plugin.fingerprint.b.a.i.class)).cHC())
    {
      ac.e("MicroMsg.OpenFingerPrintAuthEventListener", "no fingerprints enrolled, use settings to enroll fingerprints first");
      release();
      this.sjX = true;
      af(1, "");
      AppMethodBeat.o(64340);
      return false;
    }
    ((com.tencent.mm.plugin.fingerprint.d.a)g.ab(com.tencent.mm.plugin.fingerprint.d.a.class)).a(this.sks, paramBoolean);
    ac.i("MicroMsg.OpenFingerPrintAuthEventListener", "startIdentify()");
    AppMethodBeat.o(64340);
    return true;
  }
  
  public final void release()
  {
    AppMethodBeat.i(64338);
    ((com.tencent.mm.plugin.fingerprint.b.a.i)g.ab(com.tencent.mm.plugin.fingerprint.b.a.i.class)).cancel();
    this.skt = null;
    AppMethodBeat.o(64338);
  }
  
  public final class a
    implements com.tencent.mm.plugin.fingerprint.d.c
  {
    public a() {}
    
    public final void fL(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(64337);
      if (i.this.sjX)
      {
        ac.e("MicroMsg.OpenFingerPrintAuthEventListener", "hy: event already end. ignore");
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
        ac.i("MicroMsg.OpenFingerPrintAuthEventListener", "hy: identify FingerPrintConst.RESULT_SUCCESS");
        Object localObject = i.this;
        ac.i("MicroMsg.OpenFingerPrintAuthEventListener", "onSuccess()");
        ((i)localObject).sjX = true;
        ((com.tencent.mm.plugin.fingerprint.d.a)g.ab(com.tencent.mm.plugin.fingerprint.d.a.class)).a(((i)localObject).skt, paramInt2);
        if (((i)localObject).sjX) {
          ((i)localObject).skt = null;
        }
        ac.i("MicroMsg.OpenFingerPrintAuthEventListener", "callback OpenFingerPrintAuthEvent onSuccess()");
        i.cHw();
        AppMethodBeat.o(64337);
        return;
        ac.i("MicroMsg.OpenFingerPrintAuthEventListener", "hy: identify FingerPrintConst.RESULT_NO_MATCH");
        i.this.sjX = false;
        i.cHw();
        i.this.mm(true);
        i.this.af(1, "");
        AppMethodBeat.o(64337);
        return;
        i.this.mm(false);
        ac.i("MicroMsg.OpenFingerPrintAuthEventListener", "hy: identify FingerPrintConst.RESULT_TIMEOUT");
        AppMethodBeat.o(64337);
        return;
        ac.i("MicroMsg.OpenFingerPrintAuthEventListener", "hy: identify timeout");
        AppMethodBeat.o(64337);
        return;
        ac.i("MicroMsg.OpenFingerPrintAuthEventListener", "hy: on error: %d", new Object[] { Integer.valueOf(paramInt1) });
        i.this.sjX = true;
        localObject = ai.getContext().getString(2131764095);
        if (paramInt1 == 10308) {
          localObject = ai.getContext().getString(2131764096);
        }
        for (;;)
        {
          i.cHw();
          i.this.af(2, (String)localObject);
          AppMethodBeat.o(64337);
          return;
          if (paramInt1 == 2007) {
            p.skJ.skL = true;
          } else if (paramInt1 == 2005) {
            localObject = ai.getContext().getString(2131764097);
          }
        }
        ac.i("MicroMsg.OpenFingerPrintAuthEventListener", "hy: on error: %d", new Object[] { Integer.valueOf(paramInt1) });
        if (i.this.skt != null) {
          com.tencent.mm.plugin.soter.d.a.Ql(i.this.skt.dqj.dqm);
        }
        i.this.sjX = true;
        localObject = ai.getContext().getString(2131764095);
        i.cHw();
        i.this.af(paramInt1, (String)localObject);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fingerprint.b.i
 * JD-Core Version:    0.7.0.1
 */