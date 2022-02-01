package com.tencent.mm.plugin.appbrand.jsapi.g;

import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import com.tencent.luggage.a.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.k;
import com.tencent.mm.plugin.appbrand.utils.b.a;
import com.tencent.mm.sdk.d.d;
import com.tencent.mm.sdk.platformtools.ae;

public class r
  extends d
  implements k
{
  volatile boolean iAz;
  Bundle ioY;
  public volatile boolean jVr;
  private final b kSn;
  public volatile boolean kSo;
  a kSp;
  private final com.tencent.mm.sdk.d.c kSq;
  private final com.tencent.mm.sdk.d.c kSr;
  private final com.tencent.mm.sdk.d.c kSs;
  
  r(com.tencent.mm.plugin.appbrand.jsapi.c paramc)
  {
    super("RuntimeLocationUpdateStateManager[" + paramc.getAppId() + "]", Looper.getMainLooper());
    AppMethodBeat.i(143645);
    this.iAz = false;
    this.jVr = false;
    this.kSo = false;
    this.kSq = new com.tencent.mm.sdk.d.c()
    {
      public final void enter()
      {
        AppMethodBeat.i(143637);
        super.enter();
        ae.i("MicroMsg.RuntimeLocationUpdateStateManager", "enter stateNotListening");
        ((a)e.K(a.class)).c("gcj02", r.b(r.this), r.c(r.this));
        r.a(r.this, false);
        r.this.Qo("StateNotListening");
        AppMethodBeat.o(143637);
      }
      
      public final String getName()
      {
        AppMethodBeat.i(143635);
        String str = r.this.mName + "$StateListening";
        AppMethodBeat.o(143635);
        return str;
      }
      
      public final boolean k(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(143636);
        if (1 == paramAnonymousMessage.what)
        {
          r.a(r.this, r.a(r.this));
          AppMethodBeat.o(143636);
          return true;
        }
        if (4 == paramAnonymousMessage.what)
        {
          r.b(r.this, r.a(r.this));
          AppMethodBeat.o(143636);
          return true;
        }
        boolean bool = super.k(paramAnonymousMessage);
        AppMethodBeat.o(143636);
        return bool;
      }
    };
    this.kSr = new com.tencent.mm.sdk.d.c()
    {
      public final void enter()
      {
        AppMethodBeat.i(143639);
        super.enter();
        ae.i("MicroMsg.RuntimeLocationUpdateStateManager", "enter stateListening");
        ((a)e.K(a.class)).b("gcj02", r.b(r.this), r.c(r.this));
        r.a(r.this, true);
        r.this.Qo("StateListening");
        AppMethodBeat.o(143639);
      }
      
      public final void exit()
      {
        AppMethodBeat.i(143640);
        super.exit();
        ((a)e.K(a.class)).c("gcj02", r.b(r.this), r.c(r.this));
        r.a(r.this, false);
        r.this.Qo("StateNotListening");
        AppMethodBeat.o(143640);
      }
      
      public final String getName()
      {
        AppMethodBeat.i(143638);
        String str = r.this.mName + "$StateNotListening";
        AppMethodBeat.o(143638);
        return str;
      }
      
      public final boolean k(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(143641);
        if (2 == paramAnonymousMessage.what)
        {
          r.c(r.this, r.d(r.this));
          AppMethodBeat.o(143641);
          return true;
        }
        if (3 == paramAnonymousMessage.what)
        {
          r.d(r.this, r.e(r.this));
          AppMethodBeat.o(143641);
          return true;
        }
        boolean bool = super.k(paramAnonymousMessage);
        AppMethodBeat.o(143641);
        return bool;
      }
    };
    this.kSs = new com.tencent.mm.sdk.d.c()
    {
      public final void enter()
      {
        AppMethodBeat.i(143644);
        super.enter();
        ae.i("MicroMsg.RuntimeLocationUpdateStateManager", "enter stateSuspend");
        r.this.Qo("StateSuspend");
        AppMethodBeat.o(143644);
      }
      
      public final String getName()
      {
        AppMethodBeat.i(143642);
        String str = r.this.mName + "$StateSuspend";
        AppMethodBeat.o(143642);
        return str;
      }
      
      public final boolean k(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(143643);
        if (2 == paramAnonymousMessage.what)
        {
          r.e(r.this, r.d(r.this));
          AppMethodBeat.o(143643);
          return true;
        }
        if (4 == paramAnonymousMessage.what)
        {
          r.f(r.this, r.a(r.this));
          AppMethodBeat.o(143643);
          return true;
        }
        boolean bool = super.k(paramAnonymousMessage);
        AppMethodBeat.o(143643);
        return bool;
      }
    };
    this.kSn = new b(paramc);
    a(this.kSq);
    a(this.kSr);
    a(this.kSs);
    b(this.kSq);
    AppMethodBeat.o(143645);
  }
  
  public final void Qo(String paramString)
  {
    AppMethodBeat.i(143646);
    if (this.kSp != null) {
      this.kSp.Qn(paramString);
    }
    AppMethodBeat.o(143646);
  }
  
  public final void blm()
  {
    AppMethodBeat.i(143647);
    this.iAz = false;
    abg(3);
    AppMethodBeat.o(143647);
  }
  
  public final void bln()
  {
    AppMethodBeat.i(143648);
    if (!this.iAz)
    {
      abg(4);
      AppMethodBeat.o(143648);
      return;
    }
    this.iAz = false;
    AppMethodBeat.o(143648);
  }
  
  public final void blo()
  {
    AppMethodBeat.i(143650);
    this.iAz = true;
    abg(2);
    AppMethodBeat.o(143650);
  }
  
  public final void stopListening()
  {
    AppMethodBeat.i(143649);
    this.iAz = false;
    abg(2);
    AppMethodBeat.o(143649);
  }
  
  public static abstract interface a
  {
    public abstract void Qn(String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.g.r
 * JD-Core Version:    0.7.0.1
 */