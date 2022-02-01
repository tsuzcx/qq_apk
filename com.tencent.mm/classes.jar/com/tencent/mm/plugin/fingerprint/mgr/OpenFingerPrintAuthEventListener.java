package com.tencent.mm.plugin.fingerprint.mgr;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.f;
import com.tencent.mm.autogen.a.rg;
import com.tencent.mm.autogen.a.rg.a;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.fingerprint.c.c;
import com.tencent.mm.plugin.fingerprint.mgr.a.i;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

public class OpenFingerPrintAuthEventListener
  extends IListener<rg>
{
  private a HfT;
  private rg HfU;
  private boolean Hfz;
  private String hAT;
  
  public OpenFingerPrintAuthEventListener()
  {
    super(f.hfK);
    AppMethodBeat.i(160796);
    this.Hfz = false;
    this.hAT = "";
    this.__eventId = rg.class.getName().hashCode();
    AppMethodBeat.o(160796);
  }
  
  private void aw(int paramInt, String paramString)
  {
    AppMethodBeat.i(64341);
    Log.i("MicroMsg.OpenFingerPrintAuthEventListener", "onFail()");
    ((com.tencent.mm.plugin.fingerprint.c.a)h.ax(com.tencent.mm.plugin.fingerprint.c.a.class)).a(this.HfU, paramInt, paramString);
    if (this.Hfz) {
      this.HfU = null;
    }
    Log.i("MicroMsg.OpenFingerPrintAuthEventListener", "callback OpenFingerPrintAuthEvent onFail()");
    AppMethodBeat.o(64341);
  }
  
  public static void ftN()
  {
    AppMethodBeat.i(64339);
    ((i)h.ax(i.class)).cancel();
    AppMethodBeat.o(64339);
  }
  
  private boolean vz(boolean paramBoolean)
  {
    AppMethodBeat.i(64340);
    ftN();
    if (!((i)h.ax(i.class)).ftS())
    {
      Log.e("MicroMsg.OpenFingerPrintAuthEventListener", "no fingerprints enrolled, use settings to enroll fingerprints first");
      release();
      this.Hfz = true;
      aw(1, "");
      AppMethodBeat.o(64340);
      return false;
    }
    if (((com.tencent.mm.plugin.fingerprint.c.a)h.ax(com.tencent.mm.plugin.fingerprint.c.a.class)).a(this.HfT, paramBoolean) != 0)
    {
      Log.e("MicroMsg.OpenFingerPrintAuthEventListener", "failed to start identify");
      release();
      this.Hfz = true;
      aw(1, "");
      AppMethodBeat.o(64340);
      return false;
    }
    Log.i("MicroMsg.OpenFingerPrintAuthEventListener", "startIdentify()");
    AppMethodBeat.o(64340);
    return true;
  }
  
  public final void release()
  {
    AppMethodBeat.i(64338);
    ((i)h.ax(i.class)).cancel();
    this.HfU = null;
    AppMethodBeat.o(64338);
  }
  
  public final class a
    implements c
  {
    public a() {}
    
    public final void iP(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(64337);
      if (OpenFingerPrintAuthEventListener.a(OpenFingerPrintAuthEventListener.this))
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
        OpenFingerPrintAuthEventListener.a(OpenFingerPrintAuthEventListener.this, paramInt2);
        OpenFingerPrintAuthEventListener.ftN();
        AppMethodBeat.o(64337);
        return;
        Log.i("MicroMsg.OpenFingerPrintAuthEventListener", "hy: identify FingerPrintConst.RESULT_NO_MATCH");
        OpenFingerPrintAuthEventListener.a(OpenFingerPrintAuthEventListener.this, false);
        OpenFingerPrintAuthEventListener.ftN();
        OpenFingerPrintAuthEventListener.b(OpenFingerPrintAuthEventListener.this, true);
        OpenFingerPrintAuthEventListener.b(OpenFingerPrintAuthEventListener.this);
        AppMethodBeat.o(64337);
        return;
        OpenFingerPrintAuthEventListener.b(OpenFingerPrintAuthEventListener.this, false);
        Log.i("MicroMsg.OpenFingerPrintAuthEventListener", "hy: identify FingerPrintConst.RESULT_TIMEOUT");
        AppMethodBeat.o(64337);
        return;
        Log.i("MicroMsg.OpenFingerPrintAuthEventListener", "hy: identify timeout");
        AppMethodBeat.o(64337);
        return;
        Log.i("MicroMsg.OpenFingerPrintAuthEventListener", "hy: on error: %d", new Object[] { Integer.valueOf(paramInt1) });
        OpenFingerPrintAuthEventListener.a(OpenFingerPrintAuthEventListener.this, true);
        Object localObject = MMApplicationContext.getContext().getString(a.i.soter_on_error_common);
        if (paramInt1 == 10308) {
          localObject = MMApplicationContext.getContext().getString(a.i.soter_on_error_max_trial);
        }
        for (;;)
        {
          OpenFingerPrintAuthEventListener.ftN();
          OpenFingerPrintAuthEventListener.a(OpenFingerPrintAuthEventListener.this, 2, (String)localObject);
          AppMethodBeat.o(64337);
          return;
          if (paramInt1 == 2007)
          {
            if (OpenFingerPrintAuthEventListener.c(OpenFingerPrintAuthEventListener.this) != null) {
              OpenFingerPrintAuthEventListener.c(OpenFingerPrintAuthEventListener.this);
            }
            j.Hgj.Hgl = true;
          }
          else if (paramInt1 == 2005)
          {
            String str = MMApplicationContext.getContext().getString(a.i.soter_on_sensor_error);
            localObject = str;
            if (OpenFingerPrintAuthEventListener.c(OpenFingerPrintAuthEventListener.this) != null)
            {
              OpenFingerPrintAuthEventListener.c(OpenFingerPrintAuthEventListener.this);
              localObject = str;
            }
          }
        }
        Log.i("MicroMsg.OpenFingerPrintAuthEventListener", "hy: on error: %d", new Object[] { Integer.valueOf(paramInt1) });
        if (OpenFingerPrintAuthEventListener.c(OpenFingerPrintAuthEventListener.this) != null) {
          com.tencent.mm.plugin.soter.model.a.amR(OpenFingerPrintAuthEventListener.c(OpenFingerPrintAuthEventListener.this).hUl.hUo);
        }
        OpenFingerPrintAuthEventListener.a(OpenFingerPrintAuthEventListener.this, true);
        localObject = MMApplicationContext.getContext().getString(a.i.soter_on_error_common);
        OpenFingerPrintAuthEventListener.ftN();
        OpenFingerPrintAuthEventListener.a(OpenFingerPrintAuthEventListener.this, paramInt1, (String)localObject);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.fingerprint.mgr.OpenFingerPrintAuthEventListener
 * JD-Core Version:    0.7.0.1
 */