package com.tencent.mm.plugin.cast.h.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.SocketTimeoutException;
import kotlin.ResultKt;
import kotlin.d.b.a.j;
import kotlin.d.d;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;
import kotlinx.coroutines.ak;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/cast/transportclient/connection/Connection;", "Lcom/tencent/mm/plugin/cast/transportclient/connection/ConnectInt;", "()V", "connectSocket", "Ljava/net/Socket;", "getConnectSocket", "()Ljava/net/Socket;", "setConnectSocket", "(Ljava/net/Socket;)V", "connectStatus", "Lcom/tencent/mm/plugin/cast/transportclient/connection/Status;", "connect", "", "address", "", "port", "", "(Ljava/lang/String;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "connectToTheServer", "disconnect", "getConnectStatus", "plugin-cast_release"})
public final class a
{
  public b tKj;
  public Socket tKo;
  
  public a()
  {
    AppMethodBeat.i(190431);
    this.tKj = b.tKq;
    Log.i("ScreenRecord.Main", "try socket init ");
    this.tKj = b.tKq;
    Socket localSocket = new Socket();
    this.tKo = localSocket;
    Log.i("ScreenRecord.Main", "socket:" + this.tKo + "," + localSocket);
    AppMethodBeat.o(190431);
  }
  
  public final void disconnect()
  {
    AppMethodBeat.i(190420);
    if (this.tKj == b.tKs)
    {
      Socket localSocket = this.tKo;
      if (localSocket == null) {
        p.iCn();
      }
      localSocket.close();
      this.tKj = b.tKq;
      this.tKo = new Socket();
    }
    AppMethodBeat.o(190420);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"})
  public static final class a
    extends j
    implements m<ak, d<? super x>, Object>
  {
    int label;
    private ak p$;
    
    public a(a parama, String paramString, int paramInt, d paramd)
    {
      super(paramd);
    }
    
    public final d<x> create(Object paramObject, d<?> paramd)
    {
      AppMethodBeat.i(190291);
      p.k(paramd, "completion");
      paramd = new a(this.tKp, this.tKl, this.tKm, paramd);
      paramd.p$ = ((ak)paramObject);
      AppMethodBeat.o(190291);
      return paramd;
    }
    
    public final Object invoke(Object paramObject1, Object paramObject2)
    {
      AppMethodBeat.i(190296);
      paramObject1 = ((a)create(paramObject1, (d)paramObject2)).invokeSuspend(x.aazN);
      AppMethodBeat.o(190296);
      return paramObject1;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(190236);
      Object localObject = kotlin.d.a.a.aaAA;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(190236);
        throw paramObject;
      }
      ResultKt.throwOnFailure(paramObject);
      paramObject = this.tKp;
      localObject = this.tKl;
      int i = this.tKm;
      if ((paramObject.tKj == b.tKq) || (paramObject.tKj == b.tKu) || (paramObject.tKj == b.tKt)) {}
      try
      {
        paramObject.tKj = b.tKr;
        Socket localSocket = paramObject.tKo;
        if (localSocket == null) {
          p.iCn();
        }
        localSocket.connect((SocketAddress)new InetSocketAddress((String)localObject, i), 2000);
        paramObject.tKj = b.tKs;
        Log.d("TCP Client", "C: Connected...");
      }
      catch (SocketTimeoutException localSocketTimeoutException)
      {
        for (;;)
        {
          Log.e("client_connection", "connection timeout", new Object[] { localSocketTimeoutException });
          paramObject.tKj = b.tKt;
          paramObject.tKo = new Socket();
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Log.e("client_connection", "Fail connection", new Object[] { localException });
          paramObject.tKj = b.tKu;
          paramObject.tKo = new Socket();
        }
      }
      paramObject = x.aazN;
      AppMethodBeat.o(190236);
      return paramObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.cast.h.a.a
 * JD-Core Version:    0.7.0.1
 */