package com.tencent.luggage.sdk.processes.client;

import com.tencent.luggage.sdk.e.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/luggage/sdk/processes/client/LuggageClientProcessMessageDispatcher;", "", "()V", "TAG", "", "runtimeList", "Ljava/util/ArrayList;", "Lcom/tencent/luggage/sdk/runtime/AppBrandRuntimeLU;", "Lkotlin/collections/ArrayList;", "dispatch", "", "message", "Lcom/tencent/luggage/sdk/processes/client/LuggageClientProcessMessage;", "register", "rt", "unregister", "luggage-wechat-full-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
{
  public static final a euD;
  private static final ArrayList<d> euE;
  
  static
  {
    AppMethodBeat.i(220428);
    euD = new a();
    euE = new ArrayList();
    AppMethodBeat.o(220428);
  }
  
  public static void a(LuggageClientProcessMessage<? super d> paramLuggageClientProcessMessage)
  {
    AppMethodBeat.i(220423);
    s.u(paramLuggageClientProcessMessage, "message");
    Iterator localIterator = ((Iterable)euE).iterator();
    Object localObject;
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
      localObject = localIterator.next();
    } while (!s.p(((d)localObject).mAppId, paramLuggageClientProcessMessage.getAppId()));
    for (;;)
    {
      localObject = (d)localObject;
      if (localObject == null) {
        break;
      }
      paramLuggageClientProcessMessage.a((d)localObject);
      AppMethodBeat.o(220423);
      return;
      localObject = null;
    }
    Log.w("Luggage.LuggageClientProcessMessageDispatcher", "dispatch: dispatch message[%s]appId[%s] fail", new Object[] { paramLuggageClientProcessMessage.getClass().getSimpleName(), paramLuggageClientProcessMessage.getAppId() });
    AppMethodBeat.o(220423);
  }
  
  public static void b(d paramd)
  {
    AppMethodBeat.i(220409);
    s.u(paramd, "rt");
    euE.add(paramd);
    AppMethodBeat.o(220409);
  }
  
  public static void c(d paramd)
  {
    AppMethodBeat.i(220416);
    s.u(paramd, "rt");
    euE.remove(paramd);
    AppMethodBeat.o(220416);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.luggage.sdk.processes.client.a
 * JD-Core Version:    0.7.0.1
 */