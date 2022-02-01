package com.tencent.luggage.d;

import com.tencent.luggage.bridge.f;
import com.tencent.luggage.bridge.k;
import com.tencent.luggage.bridge.l;
import com.tencent.luggage.bridge.o;
import com.tencent.luggage.d.a.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public abstract class n
  implements c
{
  final ConcurrentHashMap<String, Class<? extends b>> ctA = new ConcurrentHashMap();
  public a ctB;
  
  public final a LC()
  {
    if (this.ctB == null) {
      return a.ctX;
    }
    return this.ctB;
  }
  
  public final void a(final d paramd)
  {
    com.tencent.luggage.d.a.c local3 = new com.tencent.luggage.d.a.c()
    {
      public final void a(com.tencent.luggage.d.a.b paramAnonymousb)
      {
        AppMethodBeat.i(221187);
        if (paramd == null)
        {
          Log.e("Luggage.LuggageRuntime", "Null Event, Ignore");
          AppMethodBeat.o(221187);
          return;
        }
        if (paramAnonymousb == com.tencent.luggage.d.a.b.cua)
        {
          paramAnonymousb = n.this.getBridge();
          com.tencent.luggage.bridge.d locald = new com.tencent.luggage.bridge.d(paramd.name(), paramd.Ld());
          paramAnonymousb.csJ.a(locald);
        }
        AppMethodBeat.o(221187);
      }
    };
    a locala = LC();
    paramd.name();
    locala.a(local3);
  }
  
  public final void a(List<Class<? extends b>> paramList, c paramc)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Object localObject2 = (Class)paramList.next();
      try
      {
        localObject1 = (b)((Class)localObject2).newInstance();
      }
      catch (Exception localException1)
      {
        try
        {
          ((b)localObject1).csZ = paramc;
          this.ctA.put(((b)localObject1).name(), localObject2);
          localObject2 = getBridge();
          String str = ((b)localObject1).name();
          Object localObject1 = new l()
          {
            public final void a(k paramAnonymousk)
            {
              AppMethodBeat.i(221185);
              n localn = n.this;
              b localb = this.ctC;
              paramAnonymousk = new n.2(localn, localb, paramAnonymousk);
              localn.LC().a(localb.name(), paramAnonymousk);
              AppMethodBeat.o(221185);
            }
          };
          ((o)localObject2).csL.put(str, localObject1);
        }
        catch (Exception localException2)
        {
          Log.e("Luggage.LuggageRuntime", "registerJsApi: ".concat(String.valueOf(localException2)));
        }
        localException1 = localException1;
        Log.e("Luggage.LuggageRuntime", "JsApi Initialize failed, %s, %s", new Object[] { ((Class)localObject2).getName(), localException1 });
      }
    }
  }
  
  public void destroy() {}
  
  abstract o getBridge();
  
  public abstract String getUserAgent();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.luggage.d.n
 * JD-Core Version:    0.7.0.1
 */