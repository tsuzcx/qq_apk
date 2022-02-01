package com.tencent.mm.plugin.appbrand.jsapi.i;

import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import com.tencent.luggage.a.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.jsapi.n;
import com.tencent.mm.plugin.appbrand.utils.b.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.statemachine.State;
import com.tencent.mm.sdk.statemachine.StateMachine;

public class s
  extends StateMachine
  implements n
{
  Bundle jkf;
  volatile boolean jvO;
  public volatile boolean kYn;
  private final b lXt;
  public volatile boolean lXu;
  a lXv;
  private final State lXw;
  private final State lXx;
  private final State lXy;
  
  s(f paramf)
  {
    super("RuntimeLocationUpdateStateManager[" + paramf.getAppId() + "]", Looper.getMainLooper());
    AppMethodBeat.i(143645);
    this.jvO = false;
    this.kYn = false;
    this.lXu = false;
    this.lXw = new State()
    {
      public final void enter()
      {
        AppMethodBeat.i(143637);
        super.enter();
        Log.i("MicroMsg.RuntimeLocationUpdateStateManager", "enter stateNotListening");
        ((a)e.M(a.class)).c("gcj02", s.b(s.this), s.c(s.this));
        s.a(s.this, false);
        s.this.ZP("StateNotListening");
        AppMethodBeat.o(143637);
      }
      
      public final String getName()
      {
        AppMethodBeat.i(143635);
        String str = s.this.getName() + "$StateListening";
        AppMethodBeat.o(143635);
        return str;
      }
      
      public final boolean processMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(143636);
        if (1 == paramAnonymousMessage.what)
        {
          s.a(s.this, s.a(s.this));
          AppMethodBeat.o(143636);
          return true;
        }
        if (4 == paramAnonymousMessage.what)
        {
          s.b(s.this, s.a(s.this));
          AppMethodBeat.o(143636);
          return true;
        }
        boolean bool = super.processMessage(paramAnonymousMessage);
        AppMethodBeat.o(143636);
        return bool;
      }
    };
    this.lXx = new State()
    {
      public final void enter()
      {
        AppMethodBeat.i(143639);
        super.enter();
        Log.i("MicroMsg.RuntimeLocationUpdateStateManager", "enter stateListening");
        ((a)e.M(a.class)).b("gcj02", s.b(s.this), s.c(s.this));
        s.a(s.this, true);
        s.this.ZP("StateListening");
        AppMethodBeat.o(143639);
      }
      
      public final void exit()
      {
        AppMethodBeat.i(143640);
        super.exit();
        ((a)e.M(a.class)).c("gcj02", s.b(s.this), s.c(s.this));
        s.a(s.this, false);
        s.this.ZP("StateNotListening");
        AppMethodBeat.o(143640);
      }
      
      public final String getName()
      {
        AppMethodBeat.i(143638);
        String str = s.this.getName() + "$StateNotListening";
        AppMethodBeat.o(143638);
        return str;
      }
      
      public final boolean processMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(143641);
        if (2 == paramAnonymousMessage.what)
        {
          s.c(s.this, s.d(s.this));
          AppMethodBeat.o(143641);
          return true;
        }
        if (3 == paramAnonymousMessage.what)
        {
          s.d(s.this, s.e(s.this));
          AppMethodBeat.o(143641);
          return true;
        }
        boolean bool = super.processMessage(paramAnonymousMessage);
        AppMethodBeat.o(143641);
        return bool;
      }
    };
    this.lXy = new State()
    {
      public final void enter()
      {
        AppMethodBeat.i(143644);
        super.enter();
        Log.i("MicroMsg.RuntimeLocationUpdateStateManager", "enter stateSuspend");
        s.this.ZP("StateSuspend");
        AppMethodBeat.o(143644);
      }
      
      public final String getName()
      {
        AppMethodBeat.i(143642);
        String str = s.this.getName() + "$StateSuspend";
        AppMethodBeat.o(143642);
        return str;
      }
      
      public final boolean processMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(143643);
        if (2 == paramAnonymousMessage.what)
        {
          s.e(s.this, s.d(s.this));
          AppMethodBeat.o(143643);
          return true;
        }
        if (4 == paramAnonymousMessage.what)
        {
          s.f(s.this, s.a(s.this));
          AppMethodBeat.o(143643);
          return true;
        }
        boolean bool = super.processMessage(paramAnonymousMessage);
        AppMethodBeat.o(143643);
        return bool;
      }
    };
    this.lXt = new b(paramf);
    addState(this.lXw);
    addState(this.lXx);
    addState(this.lXy);
    setInitialState(this.lXw);
    AppMethodBeat.o(143645);
  }
  
  public final void ZP(String paramString)
  {
    AppMethodBeat.i(143646);
    if (this.lXv != null) {
      this.lXv.ZO(paramString);
    }
    AppMethodBeat.o(143646);
  }
  
  public final void bGI()
  {
    AppMethodBeat.i(143647);
    this.jvO = false;
    sendMessage(3);
    AppMethodBeat.o(143647);
  }
  
  public final void bGJ()
  {
    AppMethodBeat.i(143648);
    if (!this.jvO)
    {
      sendMessage(4);
      AppMethodBeat.o(143648);
      return;
    }
    this.jvO = false;
    AppMethodBeat.o(143648);
  }
  
  public final void bGK()
  {
    AppMethodBeat.i(143650);
    this.jvO = true;
    sendMessage(2);
    AppMethodBeat.o(143650);
  }
  
  public final void stopListening()
  {
    AppMethodBeat.i(143649);
    this.jvO = false;
    sendMessage(2);
    AppMethodBeat.o(143649);
  }
  
  public static abstract interface a
  {
    public abstract void ZO(String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.i.s
 * JD-Core Version:    0.7.0.1
 */