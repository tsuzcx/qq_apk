package com.tencent.mm.plugin.cast.g.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.ah;
import kotlin.d.b.a.k;
import kotlin.d.f;
import kotlin.g.a.m;
import kotlin.g.b.s;
import kotlinx.coroutines.aq;
import kotlinx.coroutines.bg;
import kotlinx.coroutines.bu;
import kotlinx.coroutines.j;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/cast/transportclient/reader/RemoteReader;", "Lcom/tencent/mm/plugin/cast/transportclient/reader/RemoteReaderImp;", "()V", "handlers", "", "Lcom/tencent/mm/plugin/cast/transportclient/reader/handlers/HandlerImp;", "isReading", "", "reader", "Ljava/io/BufferedReader;", "addHandlers", "", "", "createReader", "socket", "Ljava/net/Socket;", "destroyReader", "startTrackingInputString", "plugin-cast_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  implements b
{
  BufferedReader dcZ;
  final List<Object> wNB;
  boolean wNR;
  
  public a()
  {
    AppMethodBeat.i(274285);
    this.wNB = ((List)new ArrayList());
    AppMethodBeat.o(274285);
  }
  
  public final void c(Socket paramSocket)
  {
    AppMethodBeat.i(274312);
    s.u(paramSocket, "socket");
    paramSocket = paramSocket.getInputStream();
    s.s(paramSocket, "socket.getInputStream()");
    this.dcZ = new BufferedReader((Reader)new InputStreamReader(paramSocket, kotlin.n.d.UTF_8), 8192);
    this.wNR = true;
    j.a((aq)bu.ajwo, null, null, (m)new a(this, null), 3);
    AppMethodBeat.o(274312);
  }
  
  public final void dpA()
  {
    AppMethodBeat.i(274303);
    this.wNR = false;
    this.wNB.clear();
    if ((this.dcZ != null) && (this.wNR)) {
      j.a((aq)bu.ajwo, (f)bg.kCi(), null, (m)new b(this, null), 2);
    }
    AppMethodBeat.o(274303);
  }
  
  public final void eS(List<? extends Object> paramList)
  {
    AppMethodBeat.i(274292);
    s.u(paramList, "handlers");
    this.wNB.addAll((Collection)paramList);
    AppMethodBeat.o(274292);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends k
    implements m<aq, kotlin.d.d<? super ah>, Object>
  {
    int label;
    
    a(a parama, kotlin.d.d<? super a> paramd)
    {
      super(paramd);
    }
    
    public final kotlin.d.d<ah> create(Object paramObject, kotlin.d.d<?> paramd)
    {
      AppMethodBeat.i(274309);
      paramObject = (kotlin.d.d)new a(this.wNS, paramd);
      AppMethodBeat.o(274309);
      return paramObject;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(274298);
      Object localObject = kotlin.d.a.a.aiwj;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(274298);
        throw paramObject;
      }
      ResultKt.throwOnFailure(paramObject);
      localObject = this.wNS;
      paramObject = this.wNS.dcZ;
      if (paramObject == null)
      {
        s.bIx("reader");
        paramObject = null;
      }
      while (((a)localObject).wNR) {
        try
        {
          if (paramObject.ready())
          {
            String str = paramObject.readLine();
            Iterator localIterator = ((Iterable)((a)localObject).wNB).iterator();
            while (localIterator.hasNext())
            {
              localIterator.next();
              s.s(str, "line");
            }
          }
        }
        catch (NullPointerException localNullPointerException)
        {
          Log.e("reader", "No elements come", new Object[] { localNullPointerException });
        }
        catch (Exception localException)
        {
          Log.e("reader", "Unknown error", new Object[] { localException });
        }
      }
      paramObject = ah.aiuX;
      AppMethodBeat.o(274298);
      return paramObject;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends k
    implements m<aq, kotlin.d.d<? super ah>, Object>
  {
    int label;
    
    b(a parama, kotlin.d.d<? super b> paramd)
    {
      super(paramd);
    }
    
    public final kotlin.d.d<ah> create(Object paramObject, kotlin.d.d<?> paramd)
    {
      AppMethodBeat.i(274304);
      paramObject = (kotlin.d.d)new b(this.wNS, paramd);
      AppMethodBeat.o(274304);
      return paramObject;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(274294);
      Object localObject = kotlin.d.a.a.aiwj;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(274294);
        throw paramObject;
      }
      ResultKt.throwOnFailure(paramObject);
      localObject = this.wNS.dcZ;
      paramObject = localObject;
      if (localObject == null)
      {
        s.bIx("reader");
        paramObject = null;
      }
      paramObject.close();
      paramObject = ah.aiuX;
      AppMethodBeat.o(274294);
      return paramObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.cast.g.b.a
 * JD-Core Version:    0.7.0.1
 */