package com.tencent.luggage.sdk.processes.client;

import com.tencent.luggage.sdk.e.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/luggage/sdk/processes/client/LuggageClientProcessMessageDispatcher;", "", "()V", "TAG", "", "runtimeList", "Ljava/util/ArrayList;", "Lcom/tencent/luggage/sdk/runtime/AppBrandRuntimeLU;", "Lkotlin/collections/ArrayList;", "dispatch", "", "message", "Lcom/tencent/luggage/sdk/processes/client/LuggageClientProcessMessage;", "register", "rt", "unregister", "luggage-wechat-full-sdk_release"})
public final class a
{
  private static final ArrayList<d> cBY;
  public static final a cBZ;
  
  static
  {
    AppMethodBeat.i(238124);
    cBZ = new a();
    cBY = new ArrayList();
    AppMethodBeat.o(238124);
  }
  
  public static void a(LuggageClientProcessMessage<? super d> paramLuggageClientProcessMessage)
  {
    AppMethodBeat.i(238121);
    p.k(paramLuggageClientProcessMessage, "message");
    Iterator localIterator = ((Iterable)cBY).iterator();
    Object localObject;
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
      localObject = localIterator.next();
    } while (!p.h(((d)localObject).getAppId(), paramLuggageClientProcessMessage.getAppId()));
    for (;;)
    {
      localObject = (d)localObject;
      if (localObject == null) {
        break;
      }
      paramLuggageClientProcessMessage.a((d)localObject);
      AppMethodBeat.o(238121);
      return;
      localObject = null;
    }
    Log.w("Luggage.LuggageClientProcessMessageDispatcher", "dispatch: dispatch message[%s]appId[%s] fail", new Object[] { paramLuggageClientProcessMessage.getClass().getSimpleName(), paramLuggageClientProcessMessage.getAppId() });
    AppMethodBeat.o(238121);
  }
  
  public static void b(d paramd)
  {
    AppMethodBeat.i(238118);
    p.k(paramd, "rt");
    cBY.add(paramd);
    AppMethodBeat.o(238118);
  }
  
  public static void c(d paramd)
  {
    AppMethodBeat.i(238120);
    p.k(paramd, "rt");
    cBY.remove(paramd);
    AppMethodBeat.o(238120);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.luggage.sdk.processes.client.a
 * JD-Core Version:    0.7.0.1
 */