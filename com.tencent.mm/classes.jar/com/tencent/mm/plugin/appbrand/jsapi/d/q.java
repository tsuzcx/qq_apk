package com.tencent.mm.plugin.appbrand.jsapi.d;

import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import com.tencent.luggage.a.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.k;
import com.tencent.mm.plugin.appbrand.utils.b.a;
import com.tencent.mm.sdk.d.d;
import com.tencent.mm.sdk.platformtools.ac;

public class q
  extends d
  implements k
{
  Bundle hSN;
  volatile boolean iel;
  public volatile boolean jyd;
  private final b ktj;
  public volatile boolean ktk;
  a ktl;
  private final com.tencent.mm.sdk.d.c ktm;
  private final com.tencent.mm.sdk.d.c ktn;
  private final com.tencent.mm.sdk.d.c kto;
  
  q(com.tencent.mm.plugin.appbrand.jsapi.c paramc)
  {
    super("RuntimeLocationUpdateStateManager[" + paramc.getAppId() + "]", Looper.getMainLooper());
    AppMethodBeat.i(143645);
    this.iel = false;
    this.jyd = false;
    this.ktk = false;
    this.ktm = new com.tencent.mm.sdk.d.c()
    {
      public final void enter()
      {
        AppMethodBeat.i(143637);
        super.enter();
        ac.i("MicroMsg.RuntimeLocationUpdateStateManager", "enter stateNotListening");
        ((a)e.K(a.class)).c("gcj02", q.b(q.this), q.c(q.this));
        q.a(q.this, false);
        q.this.Mk("StateNotListening");
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
    this.ktn = new com.tencent.mm.sdk.d.c()
    {
      public final void enter()
      {
        AppMethodBeat.i(143639);
        super.enter();
        ac.i("MicroMsg.RuntimeLocationUpdateStateManager", "enter stateListening");
        ((a)e.K(a.class)).b("gcj02", q.b(q.this), q.c(q.this));
        q.a(q.this, true);
        q.this.Mk("StateListening");
        AppMethodBeat.o(143639);
      }
      
      public final void exit()
      {
        AppMethodBeat.i(143640);
        super.exit();
        ((a)e.K(a.class)).c("gcj02", q.b(q.this), q.c(q.this));
        q.a(q.this, false);
        q.this.Mk("StateNotListening");
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
    this.kto = new com.tencent.mm.sdk.d.c()
    {
      public final void enter()
      {
        AppMethodBeat.i(143644);
        super.enter();
        ac.i("MicroMsg.RuntimeLocationUpdateStateManager", "enter stateSuspend");
        q.this.Mk("StateSuspend");
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
    this.ktj = new b(paramc);
    a(this.ktm);
    a(this.ktn);
    a(this.kto);
    b(this.ktm);
    AppMethodBeat.o(143645);
  }
  
  public final void Mk(String paramString)
  {
    AppMethodBeat.i(143646);
    if (this.ktl != null) {
      this.ktl.Mj(paramString);
    }
    AppMethodBeat.o(143646);
  }
  
  public final void bgX()
  {
    AppMethodBeat.i(143647);
    this.iel = false;
    Yv(3);
    AppMethodBeat.o(143647);
  }
  
  public final void bgY()
  {
    AppMethodBeat.i(143648);
    if (!this.iel)
    {
      Yv(4);
      AppMethodBeat.o(143648);
      return;
    }
    this.iel = false;
    AppMethodBeat.o(143648);
  }
  
  public final void bgZ()
  {
    AppMethodBeat.i(143650);
    this.iel = true;
    Yv(2);
    AppMethodBeat.o(143650);
  }
  
  public final void stopListening()
  {
    AppMethodBeat.i(143649);
    this.iel = false;
    Yv(2);
    AppMethodBeat.o(143649);
  }
  
  public static abstract interface a
  {
    public abstract void Mj(String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.d.q
 * JD-Core Version:    0.7.0.1
 */