package com.tencent.mm.plugin.appbrand.jsapi.j;

import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.az;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.plugin.appbrand.utils.b.a;
import com.tencent.mm.plugin.appbrand.utils.b.a.a;
import com.tencent.mm.plugin.appbrand.utils.b.a.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.statemachine.State;
import com.tencent.mm.sdk.statemachine.StateMachine;
import java.util.HashMap;
import java.util.Map;

public class t
  extends StateMachine
  implements m
{
  Bundle mab;
  volatile boolean mlr;
  public volatile boolean nSz;
  private final b oVe;
  private final c oVf;
  private final a.b oVg;
  public volatile boolean oVh;
  a oVi;
  private final State oVj;
  private final State oVk;
  private final State oVl;
  String type;
  
  t(com.tencent.mm.plugin.appbrand.jsapi.e parame)
  {
    super("RuntimeLocationUpdateStateManager[" + parame.getAppId() + "]", Looper.getMainLooper());
    AppMethodBeat.i(143645);
    this.oVg = new a.b()
    {
      public final void a(int paramAnonymousInt, String paramAnonymousString, a.a paramAnonymousa)
      {
        AppMethodBeat.i(192729);
        if (paramAnonymousInt == 0)
        {
          t.a(t.this).a(paramAnonymousInt, paramAnonymousString, paramAnonymousa);
          AppMethodBeat.o(192729);
          return;
        }
        paramAnonymousa = t.b(t.this);
        HashMap localHashMap = new HashMap(2);
        localHashMap.put("errCode", Integer.valueOf(paramAnonymousInt));
        localHashMap.put("errStr", paramAnonymousString);
        try
        {
          paramAnonymousa.j(paramAnonymousa.oUF).E(localHashMap).bPO();
          return;
        }
        finally
        {
          AppMethodBeat.o(192729);
        }
      }
    };
    this.mlr = false;
    this.nSz = false;
    this.oVh = false;
    this.oVj = new State()
    {
      public final void enter()
      {
        AppMethodBeat.i(143639);
        super.enter();
        Log.i("MicroMsg.RuntimeLocationUpdateStateManager", "enter stateNotListening");
        ((a)com.tencent.luggage.a.e.K(a.class)).c(t.d(t.this), t.e(t.this), t.f(t.this));
        t.a(t.this, false);
        t.this.ahF("StateNotListening");
        AppMethodBeat.o(143639);
      }
      
      public final String getName()
      {
        AppMethodBeat.i(143638);
        String str = t.this.getName() + "$StateListening";
        AppMethodBeat.o(143638);
        return str;
      }
      
      public final boolean processMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(143641);
        if (1 == paramAnonymousMessage.what)
        {
          t.a(t.this, t.c(t.this));
          AppMethodBeat.o(143641);
          return true;
        }
        if (4 == paramAnonymousMessage.what)
        {
          t.b(t.this, t.c(t.this));
          AppMethodBeat.o(143641);
          return true;
        }
        boolean bool = super.processMessage(paramAnonymousMessage);
        AppMethodBeat.o(143641);
        return bool;
      }
    };
    this.oVk = new State()
    {
      public final void enter()
      {
        AppMethodBeat.i(143644);
        super.enter();
        Log.i("MicroMsg.RuntimeLocationUpdateStateManager", "enter stateListening");
        ((a)com.tencent.luggage.a.e.K(a.class)).b(t.d(t.this), t.e(t.this), t.f(t.this));
        t.a(t.this, true);
        t.this.ahF("StateListening");
        AppMethodBeat.o(143644);
      }
      
      public final void exit()
      {
        AppMethodBeat.i(193097);
        super.exit();
        ((a)com.tencent.luggage.a.e.K(a.class)).c(t.d(t.this), t.e(t.this), t.f(t.this));
        t.a(t.this, false);
        t.this.ahF("StateNotListening");
        AppMethodBeat.o(193097);
      }
      
      public final String getName()
      {
        AppMethodBeat.i(143642);
        String str = t.this.getName() + "$StateNotListening";
        AppMethodBeat.o(143642);
        return str;
      }
      
      public final boolean processMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(143643);
        if (2 == paramAnonymousMessage.what)
        {
          t.c(t.this, t.g(t.this));
          AppMethodBeat.o(143643);
          return true;
        }
        if (3 == paramAnonymousMessage.what)
        {
          t.d(t.this, t.h(t.this));
          AppMethodBeat.o(143643);
          return true;
        }
        boolean bool = super.processMessage(paramAnonymousMessage);
        AppMethodBeat.o(143643);
        return bool;
      }
    };
    this.oVl = new State()
    {
      public final void enter()
      {
        AppMethodBeat.i(192570);
        super.enter();
        Log.i("MicroMsg.RuntimeLocationUpdateStateManager", "enter stateSuspend");
        t.this.ahF("StateSuspend");
        AppMethodBeat.o(192570);
      }
      
      public final String getName()
      {
        AppMethodBeat.i(192562);
        String str = t.this.getName() + "$StateSuspend";
        AppMethodBeat.o(192562);
        return str;
      }
      
      public final boolean processMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(192569);
        if (2 == paramAnonymousMessage.what)
        {
          t.e(t.this, t.g(t.this));
          AppMethodBeat.o(192569);
          return true;
        }
        if (4 == paramAnonymousMessage.what)
        {
          t.f(t.this, t.c(t.this));
          AppMethodBeat.o(192569);
          return true;
        }
        boolean bool = super.processMessage(paramAnonymousMessage);
        AppMethodBeat.o(192569);
        return bool;
      }
    };
    this.oVe = new b(parame);
    this.oVf = new c(parame);
    addState(this.oVj);
    addState(this.oVk);
    addState(this.oVl);
    setInitialState(this.oVj);
    AppMethodBeat.o(143645);
  }
  
  public final void ahF(String paramString)
  {
    AppMethodBeat.i(143646);
    if (this.oVi != null) {
      this.oVi.ahE(paramString);
    }
    AppMethodBeat.o(143646);
  }
  
  public final void bSo()
  {
    AppMethodBeat.i(143647);
    this.mlr = false;
    sendMessage(3);
    AppMethodBeat.o(143647);
  }
  
  public final void bSp()
  {
    AppMethodBeat.i(143648);
    if (!this.mlr)
    {
      sendMessage(4);
      AppMethodBeat.o(143648);
      return;
    }
    this.mlr = false;
    AppMethodBeat.o(143648);
  }
  
  public final void bSq()
  {
    AppMethodBeat.i(143649);
    this.mlr = false;
    sendMessage(2);
    AppMethodBeat.o(143649);
  }
  
  public final void bSr()
  {
    AppMethodBeat.i(143650);
    this.mlr = true;
    sendMessage(2);
    AppMethodBeat.o(143650);
  }
  
  public static abstract interface a
  {
    public abstract void ahE(String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.j.t
 * JD-Core Version:    0.7.0.1
 */