package com.tencent.mm.plugin.appbrand.jsapi.e;

import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import com.tencent.luggage.a.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.k;
import com.tencent.mm.plugin.appbrand.utils.b.a;
import com.tencent.mm.sdk.d.d;
import com.tencent.mm.sdk.platformtools.ad;

public class q
  extends d
  implements k
{
  volatile boolean hDJ;
  Bundle hsl;
  public volatile boolean iXN;
  private final com.tencent.mm.sdk.d.c jSA;
  private final com.tencent.mm.sdk.d.c jSB;
  private final com.tencent.mm.sdk.d.c jSC;
  private final b jSx;
  public volatile boolean jSy;
  q.a jSz;
  
  q(com.tencent.mm.plugin.appbrand.jsapi.c paramc)
  {
    super("RuntimeLocationUpdateStateManager[" + paramc.getAppId() + "]", Looper.getMainLooper());
    AppMethodBeat.i(143645);
    this.hDJ = false;
    this.iXN = false;
    this.jSy = false;
    this.jSA = new com.tencent.mm.sdk.d.c()
    {
      public final void enter()
      {
        AppMethodBeat.i(143637);
        super.enter();
        ad.i("MicroMsg.RuntimeLocationUpdateStateManager", "enter stateNotListening");
        ((a)e.K(a.class)).c("gcj02", q.b(q.this), q.c(q.this));
        q.a(q.this, false);
        q.this.If("StateNotListening");
        AppMethodBeat.o(143637);
      }
      
      public final String getName()
      {
        AppMethodBeat.i(143635);
        String str = q.this.mName + "$StateListening";
        AppMethodBeat.o(143635);
        return str;
      }
      
      public final boolean k(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(143636);
        if (1 == paramAnonymousMessage.what)
        {
          q.a(q.this, q.a(q.this));
          AppMethodBeat.o(143636);
          return true;
        }
        if (4 == paramAnonymousMessage.what)
        {
          q.b(q.this, q.a(q.this));
          AppMethodBeat.o(143636);
          return true;
        }
        boolean bool = super.k(paramAnonymousMessage);
        AppMethodBeat.o(143636);
        return bool;
      }
    };
    this.jSB = new com.tencent.mm.sdk.d.c()
    {
      public final void enter()
      {
        AppMethodBeat.i(143639);
        super.enter();
        ad.i("MicroMsg.RuntimeLocationUpdateStateManager", "enter stateListening");
        ((a)e.K(a.class)).b("gcj02", q.b(q.this), q.c(q.this));
        q.a(q.this, true);
        q.this.If("StateListening");
        AppMethodBeat.o(143639);
      }
      
      public final void exit()
      {
        AppMethodBeat.i(143640);
        super.exit();
        ((a)e.K(a.class)).c("gcj02", q.b(q.this), q.c(q.this));
        q.a(q.this, false);
        q.this.If("StateNotListening");
        AppMethodBeat.o(143640);
      }
      
      public final String getName()
      {
        AppMethodBeat.i(143638);
        String str = q.this.mName + "$StateNotListening";
        AppMethodBeat.o(143638);
        return str;
      }
      
      public final boolean k(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(143641);
        if (2 == paramAnonymousMessage.what)
        {
          q.c(q.this, q.d(q.this));
          AppMethodBeat.o(143641);
          return true;
        }
        if (3 == paramAnonymousMessage.what)
        {
          q.d(q.this, q.e(q.this));
          AppMethodBeat.o(143641);
          return true;
        }
        boolean bool = super.k(paramAnonymousMessage);
        AppMethodBeat.o(143641);
        return bool;
      }
    };
    this.jSC = new com.tencent.mm.sdk.d.c()
    {
      public final void enter()
      {
        AppMethodBeat.i(143644);
        super.enter();
        ad.i("MicroMsg.RuntimeLocationUpdateStateManager", "enter stateSuspend");
        q.this.If("StateSuspend");
        AppMethodBeat.o(143644);
      }
      
      public final String getName()
      {
        AppMethodBeat.i(143642);
        String str = q.this.mName + "$StateSuspend";
        AppMethodBeat.o(143642);
        return str;
      }
      
      public final boolean k(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(143643);
        if (2 == paramAnonymousMessage.what)
        {
          q.e(q.this, q.d(q.this));
          AppMethodBeat.o(143643);
          return true;
        }
        if (4 == paramAnonymousMessage.what)
        {
          q.f(q.this, q.a(q.this));
          AppMethodBeat.o(143643);
          return true;
        }
        boolean bool = super.k(paramAnonymousMessage);
        AppMethodBeat.o(143643);
        return bool;
      }
    };
    this.jSx = new b(paramc);
    a(this.jSA);
    a(this.jSB);
    a(this.jSC);
    b(this.jSA);
    AppMethodBeat.o(143645);
  }
  
  public final void If(String paramString)
  {
    AppMethodBeat.i(143646);
    if (this.jSz != null) {
      this.jSz.Ie(paramString);
    }
    AppMethodBeat.o(143646);
  }
  
  public final void bae()
  {
    AppMethodBeat.i(143647);
    this.hDJ = false;
    Wm(3);
    AppMethodBeat.o(143647);
  }
  
  public final void baf()
  {
    AppMethodBeat.i(143648);
    if (!this.hDJ)
    {
      Wm(4);
      AppMethodBeat.o(143648);
      return;
    }
    this.hDJ = false;
    AppMethodBeat.o(143648);
  }
  
  public final void bag()
  {
    AppMethodBeat.i(143650);
    this.hDJ = true;
    Wm(2);
    AppMethodBeat.o(143650);
  }
  
  public final void stopListening()
  {
    AppMethodBeat.i(143649);
    this.hDJ = false;
    Wm(2);
    AppMethodBeat.o(143649);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.e.q
 * JD-Core Version:    0.7.0.1
 */