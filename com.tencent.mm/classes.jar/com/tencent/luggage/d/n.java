package com.tencent.luggage.d;

import com.tencent.luggage.bridge.k;
import com.tencent.luggage.bridge.l;
import com.tencent.luggage.bridge.o;
import com.tencent.luggage.d.a.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

public abstract class n
  implements c
{
  final ConcurrentHashMap<String, Class<? extends b>> ejx = new ConcurrentHashMap();
  public a ejy;
  
  public final void a(final d paramd)
  {
    com.tencent.luggage.d.a.c local3 = new com.tencent.luggage.d.a.c()
    {
      public final void a(com.tencent.luggage.d.a.b paramAnonymousb)
      {
        AppMethodBeat.i(219940);
        if (paramd == null)
        {
          Log.e("Luggage.LuggageRuntime", "Null Event, Ignore");
          AppMethodBeat.o(219940);
          return;
        }
        if (paramAnonymousb == com.tencent.luggage.d.a.b.eka) {
          n.this.getBridge().b(paramd.name(), paramd.aoe());
        }
        AppMethodBeat.o(219940);
      }
    };
    a locala = aoA();
    paramd.name();
    locala.a(local3);
  }
  
  public final void a(Class<? extends b> paramClass, c paramc)
  {
    try
    {
      final b localb = (b)paramClass.newInstance();
      Object localObject = paramc;
      if (paramc == null) {
        localObject = this;
      }
      return;
    }
    catch (Exception paramc)
    {
      try
      {
        localb.eiX = ((c)localObject);
        this.ejx.put(localb.name(), paramClass);
        getBridge().a(localb.name(), new l()
        {
          public final void a(k paramAnonymousk)
          {
            AppMethodBeat.i(219941);
            n localn = n.this;
            b localb = localb;
            paramAnonymousk = new n.2(localn, localb, paramAnonymousk);
            localn.aoA().a(localb.name(), paramAnonymousk);
            AppMethodBeat.o(219941);
          }
        });
        return;
      }
      catch (Exception paramClass)
      {
        Log.e("Luggage.LuggageRuntime", "registerJsApi: ".concat(String.valueOf(paramClass)));
      }
      paramc = paramc;
      Log.e("Luggage.LuggageRuntime", "JsApi Initialize failed, %s, %s", new Object[] { paramClass.getName(), paramc });
      return;
    }
  }
  
  public final void a(List<Class<? extends b>> paramList, c paramc)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      a((Class)paramList.next(), paramc);
    }
  }
  
  public final a aoA()
  {
    if (this.ejy == null) {
      return a.ejX;
    }
    return this.ejy;
  }
  
  public final void b(final String paramString, final JSONObject paramJSONObject)
  {
    paramString = new com.tencent.luggage.d.a.c()
    {
      public final void a(com.tencent.luggage.d.a.b paramAnonymousb)
      {
        AppMethodBeat.i(219939);
        if (paramAnonymousb == com.tencent.luggage.d.a.b.eka) {
          n.this.getBridge().b(paramString, paramJSONObject);
        }
        AppMethodBeat.o(219939);
      }
    };
    aoA().a(paramString);
  }
  
  public void destroy() {}
  
  public abstract o getBridge();
  
  public abstract String getUserAgent();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.luggage.d.n
 * JD-Core Version:    0.7.0.1
 */