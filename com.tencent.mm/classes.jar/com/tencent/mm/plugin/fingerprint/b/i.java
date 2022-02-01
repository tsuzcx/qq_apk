package com.tencent.mm.plugin.fingerprint.b;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.a.pt;
import com.tencent.mm.f.a.pt.a;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.fingerprint.d.c;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

public final class i
  extends IListener<pt>
{
  private boolean BxW;
  private a Byr;
  private pt Bys;
  private String fwv;
  
  public i()
  {
    AppMethodBeat.i(160796);
    this.BxW = false;
    this.fwv = "";
    this.__eventId = pt.class.getName().hashCode();
    AppMethodBeat.o(160796);
  }
  
  private void am(int paramInt, String paramString)
  {
    AppMethodBeat.i(64341);
    Log.i("MicroMsg.OpenFingerPrintAuthEventListener", "onFail()");
    ((com.tencent.mm.plugin.fingerprint.d.a)h.ae(com.tencent.mm.plugin.fingerprint.d.a.class)).a(this.Bys, paramInt, paramString);
    if (this.BxW) {
      this.Bys = null;
    }
    Log.i("MicroMsg.OpenFingerPrintAuthEventListener", "callback OpenFingerPrintAuthEvent onFail()");
    AppMethodBeat.o(64341);
  }
  
  public static void eoK()
  {
    AppMethodBeat.i(64339);
    ((com.tencent.mm.plugin.fingerprint.b.a.i)h.ae(com.tencent.mm.plugin.fingerprint.b.a.i.class)).cancel();
    AppMethodBeat.o(64339);
  }
  
  private boolean rI(boolean paramBoolean)
  {
    AppMethodBeat.i(64340);
    eoK();
    if (!((com.tencent.mm.plugin.fingerprint.b.a.i)h.ae(com.tencent.mm.plugin.fingerprint.b.a.i.class)).eoQ())
    {
      Log.e("MicroMsg.OpenFingerPrintAuthEventListener", "no fingerprints enrolled, use settings to enroll fingerprints first");
      release();
      this.BxW = true;
      am(1, "");
      AppMethodBeat.o(64340);
      return false;
    }
    ((com.tencent.mm.plugin.fingerprint.d.a)h.ae(com.tencent.mm.plugin.fingerprint.d.a.class)).a(this.Byr, paramBoolean);
    Log.i("MicroMsg.OpenFingerPrintAuthEventListener", "startIdentify()");
    AppMethodBeat.o(64340);
    return true;
  }
  
  public final void release()
  {
    AppMethodBeat.i(64338);
    ((com.tencent.mm.plugin.fingerprint.b.a.i)h.ae(com.tencent.mm.plugin.fingerprint.b.a.i.class)).cancel();
    this.Bys = null;
    AppMethodBeat.o(64338);
  }
  
  public final class a
    implements c
  {
    public a() {}
    
    public final void hu(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(64337);
      if (i.a(i.this))
      {
        Log.e("MicroMsg.OpenFingerPrintAuthEventListener", "hy: event already end. ignore");
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
        Log.i("MicroMsg.OpenFingerPrintAuthEventListener", "hy: identify FingerPrintConst.RESULT_SUCCESS");
        i.a(i.this, paramInt2);
        i.eoK();
        AppMethodBeat.o(64337);
        return;
        Log.i("MicroMsg.OpenFingerPrintAuthEventListener", "hy: identify FingerPrintConst.RESULT_NO_MATCH");
        i.a(i.this, false);
        i.eoK();
        i.b(i.this, true);
        i.b(i.this);
        AppMethodBeat.o(64337);
        return;
        i.b(i.this, false);
        Log.i("MicroMsg.OpenFingerPrintAuthEventListener", "hy: identify FingerPrintConst.RESULT_TIMEOUT");
        AppMethodBeat.o(64337);
        return;
        Log.i("MicroMsg.OpenFingerPrintAuthEventListener", "hy: identify timeout");
        AppMethodBeat.o(64337);
        return;
        Log.i("MicroMsg.OpenFingerPrintAuthEventListener", "hy: on error: %d", new Object[] { Integer.valueOf(paramInt1) });
        i.a(i.this, true);
        Object localObject = MMApplicationContext.getContext().getString(a.i.soter_on_error_common);
        if (paramInt1 == 10308) {
          localObject = MMApplicationContext.getContext().getString(a.i.soter_on_error_max_trial);
        }
        for (;;)
        {
          i.eoK();
          i.a(i.this, 2, (String)localObject);
          AppMethodBeat.o(64337);
          return;
          if (paramInt1 == 2007)
          {
            if (i.c(i.this) != null) {
              i.c(i.this);
            }
            p.ByH.ByJ = true;
          }
          else if (paramInt1 == 2005)
          {
            String str = MMApplicationContext.getContext().getString(a.i.soter_on_sensor_error);
            localObject = str;
            if (i.c(i.this) != null)
            {
              i.c(i.this);
              localObject = str;
            }
          }
        }
        Log.i("MicroMsg.OpenFingerPrintAuthEventListener", "hy: on error: %d", new Object[] { Integer.valueOf(paramInt1) });
        if (i.c(i.this) != null) {
          com.tencent.mm.plugin.soter.d.a.ahQ(i.c(i.this).fOs.fOv);
        }
        i.a(i.this, true);
        localObject = MMApplicationContext.getContext().getString(a.i.soter_on_error_common);
        i.eoK();
        i.a(i.this, paramInt1, (String)localObject);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fingerprint.b.i
 * JD-Core Version:    0.7.0.1
 */