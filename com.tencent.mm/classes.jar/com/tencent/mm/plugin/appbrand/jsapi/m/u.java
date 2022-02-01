package com.tencent.mm.plugin.appbrand.jsapi.m;

import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import com.tencent.luggage.a.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.bc;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.jsapi.n;
import com.tencent.mm.plugin.appbrand.utils.b.a;
import com.tencent.mm.plugin.appbrand.utils.b.a.a;
import com.tencent.mm.plugin.appbrand.utils.b.a.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.statemachine.State;
import com.tencent.mm.sdk.statemachine.StateMachine;
import java.util.HashMap;
import java.util.Map;

public class u
  extends StateMachine
  implements n
{
  Bundle oSS;
  volatile boolean pfd;
  public volatile boolean qSk;
  private final State saA;
  private final State saB;
  private final b sau;
  private final c sav;
  private final a.b saw;
  public volatile boolean sax;
  u.a say;
  private final State saz;
  String type;
  
  u(f paramf)
  {
    super("RuntimeLocationUpdateStateManager[" + paramf.getAppId() + "]", Looper.getMainLooper());
    AppMethodBeat.i(143645);
    this.saw = new a.b()
    {
      public final void a(int paramAnonymousInt, String paramAnonymousString, a.a paramAnonymousa)
      {
        AppMethodBeat.i(329218);
        if (paramAnonymousInt == 0)
        {
          u.a(u.this).a(paramAnonymousInt, paramAnonymousString, paramAnonymousa);
          AppMethodBeat.o(329218);
          return;
        }
        paramAnonymousa = u.b(u.this);
        HashMap localHashMap = new HashMap(2);
        localHashMap.put("errCode", Integer.valueOf(paramAnonymousInt));
        localHashMap.put("errStr", paramAnonymousString);
        try
        {
          paramAnonymousa.i(paramAnonymousa.rZU).L(localHashMap).cpV();
          return;
        }
        finally
        {
          AppMethodBeat.o(329218);
        }
      }
    };
    this.pfd = false;
    this.qSk = false;
    this.sax = false;
    this.saz = new State()
    {
      public final void enter()
      {
        AppMethodBeat.i(143639);
        super.enter();
        Log.i("MicroMsg.RuntimeLocationUpdateStateManager", "enter stateNotListening");
        ((a)e.T(a.class)).c(u.d(u.this), u.e(u.this), u.f(u.this));
        u.a(u.this, false);
        u.this.aaC("StateNotListening");
        AppMethodBeat.o(143639);
      }
      
      public final String getName()
      {
        AppMethodBeat.i(143638);
        String str = u.this.getName() + "$StateListening";
        AppMethodBeat.o(143638);
        return str;
      }
      
      public final boolean processMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(143641);
        if (1 == paramAnonymousMessage.what)
        {
          u.a(u.this, u.c(u.this));
          AppMethodBeat.o(143641);
          return true;
        }
        if (4 == paramAnonymousMessage.what)
        {
          u.b(u.this, u.c(u.this));
          AppMethodBeat.o(143641);
          return true;
        }
        boolean bool = super.processMessage(paramAnonymousMessage);
        AppMethodBeat.o(143641);
        return bool;
      }
    };
    this.saA = new State()
    {
      public final void enter()
      {
        AppMethodBeat.i(143644);
        super.enter();
        Log.i("MicroMsg.RuntimeLocationUpdateStateManager", "enter stateListening");
        ((a)e.T(a.class)).b(u.d(u.this), u.e(u.this), u.f(u.this));
        u.a(u.this, true);
        u.this.aaC("StateListening");
        AppMethodBeat.o(143644);
      }
      
      public final void exit()
      {
        AppMethodBeat.i(329222);
        super.exit();
        ((a)e.T(a.class)).c(u.d(u.this), u.e(u.this), u.f(u.this));
        u.a(u.this, false);
        u.this.aaC("StateNotListening");
        AppMethodBeat.o(329222);
      }
      
      public final String getName()
      {
        AppMethodBeat.i(143642);
        String str = u.this.getName() + "$StateNotListening";
        AppMethodBeat.o(143642);
        return str;
      }
      
      public final boolean processMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(143643);
        if (2 == paramAnonymousMessage.what)
        {
          u.c(u.this, u.g(u.this));
          AppMethodBeat.o(143643);
          return true;
        }
        if (3 == paramAnonymousMessage.what)
        {
          u.d(u.this, u.h(u.this));
          AppMethodBeat.o(143643);
          return true;
        }
        boolean bool = super.processMessage(paramAnonymousMessage);
        AppMethodBeat.o(143643);
        return bool;
      }
    };
    this.saB = new State()
    {
      public final void enter()
      {
        AppMethodBeat.i(329230);
        super.enter();
        Log.i("MicroMsg.RuntimeLocationUpdateStateManager", "enter stateSuspend");
        u.this.aaC("StateSuspend");
        AppMethodBeat.o(329230);
      }
      
      public final String getName()
      {
        AppMethodBeat.i(329223);
        String str = u.this.getName() + "$StateSuspend";
        AppMethodBeat.o(329223);
        return str;
      }
      
      public final boolean processMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(329226);
        if (2 == paramAnonymousMessage.what)
        {
          u.e(u.this, u.g(u.this));
          AppMethodBeat.o(329226);
          return true;
        }
        if (4 == paramAnonymousMessage.what)
        {
          u.f(u.this, u.c(u.this));
          AppMethodBeat.o(329226);
          return true;
        }
        boolean bool = super.processMessage(paramAnonymousMessage);
        AppMethodBeat.o(329226);
        return bool;
      }
    };
    this.sau = new b(paramf);
    this.sav = new c(paramf);
    addState(this.saz);
    addState(this.saA);
    addState(this.saB);
    setInitialState(this.saz);
    AppMethodBeat.o(143645);
  }
  
  public final void aaC(String paramString)
  {
    AppMethodBeat.i(143646);
    u.a locala = this.say;
    if (locala != null) {
      locala.aaB(paramString);
    }
    AppMethodBeat.o(143646);
  }
  
  public final void cst()
  {
    AppMethodBeat.i(143647);
    this.pfd = false;
    sendMessage(3);
    AppMethodBeat.o(143647);
  }
  
  public final void csu()
  {
    AppMethodBeat.i(143648);
    if (!this.pfd)
    {
      sendMessage(4);
      AppMethodBeat.o(143648);
      return;
    }
    this.pfd = false;
    AppMethodBeat.o(143648);
  }
  
  public final void csv()
  {
    AppMethodBeat.i(143649);
    this.pfd = false;
    sendMessage(2);
    AppMethodBeat.o(143649);
  }
  
  public final void csw()
  {
    AppMethodBeat.i(143650);
    this.pfd = true;
    sendMessage(2);
    AppMethodBeat.o(143650);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.m.u
 * JD-Core Version:    0.7.0.1
 */