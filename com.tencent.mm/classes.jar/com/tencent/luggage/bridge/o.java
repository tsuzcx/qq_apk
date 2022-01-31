package com.tencent.luggage.bridge;

import com.tencent.luggage.g.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONException;

public final class o
{
  s byk;
  n byl;
  public f bym;
  public p byn;
  public ConcurrentHashMap<String, l> byo;
  private ConcurrentHashMap<String, j> byp;
  private ConcurrentHashMap<Integer, h> byq;
  private AtomicInteger byr;
  
  public o(s params)
  {
    AppMethodBeat.i(90736);
    this.byo = new ConcurrentHashMap();
    this.byp = new ConcurrentHashMap();
    this.byq = new ConcurrentHashMap();
    this.byr = new AtomicInteger(1);
    this.byk = params;
    this.byl = new n(this);
    this.bym = new f(this.byk);
    this.byn = new q(this);
    this.byk.addJavascriptInterface(new r(this.byl), "_luggageBridgeNative");
    AppMethodBeat.o(90736);
  }
  
  private void a(i parami)
  {
    AppMethodBeat.i(90740);
    if ((j)this.byp.get(parami.bxZ) == null)
    {
      d.e("LuggageBridge", "no listener for event: %s", new Object[] { parami.bxZ });
      AppMethodBeat.o(90740);
      return;
    }
    AppMethodBeat.o(90740);
  }
  
  final e a(m paramm, boolean paramBoolean)
  {
    AppMethodBeat.i(90738);
    for (;;)
    {
      try
      {
        paramm = new k(this.bym, paramm, paramBoolean);
        l locall = (l)this.byo.get(paramm.bxW);
        if (locall != null)
        {
          locall.a(paramm);
          if (!paramm.byc) {
            break;
          }
          paramm = paramm.tV();
          AppMethodBeat.o(90738);
          return paramm;
        }
      }
      catch (JSONException paramm)
      {
        d.e("LuggageBridge", "inflate Js2JavaInvokeContext failed: %s", new Object[] { paramm });
        AppMethodBeat.o(90738);
        return null;
      }
      d.e("LuggageBridge", "Invoke Listener Not Found: %s", new Object[] { paramm.bxW });
      paramm.a("system:function_not_exist", null);
    }
    AppMethodBeat.o(90738);
    return null;
  }
  
  final void a(m paramm)
  {
    AppMethodBeat.i(90739);
    try
    {
      paramm = new i(paramm);
      d.i("LuggageBridge", "processEventFromJs, EventName = %s", new Object[] { paramm.bxZ });
      a(paramm);
      AppMethodBeat.o(90739);
      return;
    }
    catch (JSONException paramm)
    {
      d.e("LuggageBridge", "inflate Js2JavaEventContext failed: %s", new Object[] { paramm });
      AppMethodBeat.o(90739);
    }
  }
  
  final void b(m paramm)
  {
    AppMethodBeat.i(90741);
    try
    {
      paramm = new g(paramm);
      if ((h)this.byq.get(Integer.valueOf(paramm.bxX)) == null)
      {
        d.e("LuggageBridge", "no listener for callback: %d", new Object[] { Integer.valueOf(paramm.bxX) });
        AppMethodBeat.o(90741);
        return;
      }
    }
    catch (JSONException paramm)
    {
      d.e("LuggageBridge", "inflate Js2JavaEventContext failed: %s", new Object[] { paramm });
      AppMethodBeat.o(90741);
      return;
    }
    if (!paramm.bxY) {
      this.byq.remove(Integer.valueOf(paramm.bxX));
    }
    AppMethodBeat.o(90741);
  }
  
  public final void bw(String paramString)
  {
    AppMethodBeat.i(90737);
    this.byk.by(paramString);
    AppMethodBeat.o(90737);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.luggage.bridge.o
 * JD-Core Version:    0.7.0.1
 */