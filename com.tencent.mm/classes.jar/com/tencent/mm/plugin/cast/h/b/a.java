package com.tencent.mm.plugin.cast.h.b;

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
import kotlin.ResultKt;
import kotlin.d.b.a.j;
import kotlin.d.f;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;
import kotlinx.coroutines.ak;
import kotlinx.coroutines.bc;
import kotlinx.coroutines.br;
import kotlinx.coroutines.g;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/cast/transportclient/reader/RemoteReader;", "Lcom/tencent/mm/plugin/cast/transportclient/reader/RemoteReaderImp;", "()V", "handlers", "", "Lcom/tencent/mm/plugin/cast/transportclient/reader/handlers/HandlerImp;", "isReading", "", "reader", "Ljava/io/BufferedReader;", "addHandlers", "", "", "createReader", "socket", "Ljava/net/Socket;", "destroyReader", "startTrackingInputString", "plugin-cast_release"})
public final class a
  implements b
{
  private BufferedReader bjf;
  final List<Object> tKi;
  boolean tKy;
  
  public a()
  {
    AppMethodBeat.i(190143);
    this.tKi = ((List)new ArrayList());
    AppMethodBeat.o(190143);
  }
  
  public final void c(Socket paramSocket)
  {
    AppMethodBeat.i(190138);
    p.k(paramSocket, "socket");
    paramSocket = paramSocket.getInputStream();
    p.j(paramSocket, "socket.getInputStream()");
    this.bjf = new BufferedReader((Reader)new InputStreamReader(paramSocket, kotlin.n.d.UTF_8), 8192);
    this.tKy = true;
    g.b((ak)br.abxo, null, (m)new a(this, null), 3);
    AppMethodBeat.o(190138);
  }
  
  public final void cLU()
  {
    AppMethodBeat.i(190133);
    this.tKy = false;
    this.tKi.clear();
    if ((((a)this).bjf != null) && (this.tKy)) {
      g.b((ak)br.abxo, (f)bc.iRs(), (m)new b(this, null), 2);
    }
    AppMethodBeat.o(190133);
  }
  
  public final void cX(List<? extends Object> paramList)
  {
    AppMethodBeat.i(190128);
    p.k(paramList, "handlers");
    this.tKi.addAll((Collection)paramList);
    AppMethodBeat.o(190128);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"})
  static final class a
    extends j
    implements m<ak, kotlin.d.d<? super x>, Object>
  {
    int label;
    private ak p$;
    
    a(a parama, kotlin.d.d paramd)
    {
      super(paramd);
    }
    
    public final kotlin.d.d<x> create(Object paramObject, kotlin.d.d<?> paramd)
    {
      AppMethodBeat.i(189364);
      p.k(paramd, "completion");
      paramd = new a(this.tKz, paramd);
      paramd.p$ = ((ak)paramObject);
      AppMethodBeat.o(189364);
      return paramd;
    }
    
    public final Object invoke(Object paramObject1, Object paramObject2)
    {
      AppMethodBeat.i(189367);
      paramObject1 = ((a)create(paramObject1, (kotlin.d.d)paramObject2)).invokeSuspend(x.aazN);
      AppMethodBeat.o(189367);
      return paramObject1;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(189361);
      Object localObject = kotlin.d.a.a.aaAA;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(189361);
        throw paramObject;
      }
      ResultKt.throwOnFailure(paramObject);
      paramObject = this.tKz;
      localObject = a.a(this.tKz);
      while (paramObject.tKy) {
        try
        {
          if (((BufferedReader)localObject).ready())
          {
            String str = ((BufferedReader)localObject).readLine();
            Iterator localIterator = ((Iterable)paramObject.tKi).iterator();
            while (localIterator.hasNext())
            {
              localIterator.next();
              p.j(str, "line");
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
      paramObject = x.aazN;
      AppMethodBeat.o(189361);
      return paramObject;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"})
  static final class b
    extends j
    implements m<ak, kotlin.d.d<? super x>, Object>
  {
    int label;
    private ak p$;
    
    b(a parama, kotlin.d.d paramd)
    {
      super(paramd);
    }
    
    public final kotlin.d.d<x> create(Object paramObject, kotlin.d.d<?> paramd)
    {
      AppMethodBeat.i(190809);
      p.k(paramd, "completion");
      paramd = new b(this.tKz, paramd);
      paramd.p$ = ((ak)paramObject);
      AppMethodBeat.o(190809);
      return paramd;
    }
    
    public final Object invoke(Object paramObject1, Object paramObject2)
    {
      AppMethodBeat.i(190811);
      paramObject1 = ((b)create(paramObject1, (kotlin.d.d)paramObject2)).invokeSuspend(x.aazN);
      AppMethodBeat.o(190811);
      return paramObject1;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(190803);
      kotlin.d.a.a locala = kotlin.d.a.a.aaAA;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(190803);
        throw paramObject;
      }
      ResultKt.throwOnFailure(paramObject);
      a.a(this.tKz).close();
      paramObject = x.aazN;
      AppMethodBeat.o(190803);
      return paramObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.cast.h.b.a
 * JD-Core Version:    0.7.0.1
 */