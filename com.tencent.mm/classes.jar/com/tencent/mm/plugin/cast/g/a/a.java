package com.tencent.mm.plugin.cast.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.SocketTimeoutException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.ah;
import kotlin.d.b.a.k;
import kotlin.d.d;
import kotlin.g.a.m;
import kotlin.g.b.s;
import kotlinx.coroutines.aq;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/cast/transportclient/connection/Connection;", "Lcom/tencent/mm/plugin/cast/transportclient/connection/ConnectInt;", "()V", "connectSocket", "Ljava/net/Socket;", "getConnectSocket", "()Ljava/net/Socket;", "setConnectSocket", "(Ljava/net/Socket;)V", "connectStatus", "Lcom/tencent/mm/plugin/cast/transportclient/connection/Status;", "connect", "", "address", "", "port", "", "(Ljava/lang/String;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "connectToTheServer", "disconnect", "getConnectStatus", "plugin-cast_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
{
  public b wNC;
  public Socket wNH;
  
  public a()
  {
    AppMethodBeat.i(274274);
    this.wNC = b.wNJ;
    Log.i("ScreenRecord.Main", "try socket init ");
    this.wNC = b.wNJ;
    Socket localSocket = new Socket();
    this.wNH = localSocket;
    Log.i("ScreenRecord.Main", "socket:" + this.wNH + ',' + localSocket);
    AppMethodBeat.o(274274);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
  public static final class a
    extends k
    implements m<aq, d<? super ah>, Object>
  {
    int label;
    
    public a(a parama, String paramString, int paramInt, d<? super a> paramd)
    {
      super(paramd);
    }
    
    public final d<ah> create(Object paramObject, d<?> paramd)
    {
      AppMethodBeat.i(274290);
      paramObject = (d)new a(this.wNI, this.wND, this.wNE, paramd);
      AppMethodBeat.o(274290);
      return paramObject;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(274283);
      Object localObject = kotlin.d.a.a.aiwj;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(274283);
        throw paramObject;
      }
      ResultKt.throwOnFailure(paramObject);
      paramObject = this.wNI;
      localObject = this.wND;
      int i = this.wNE;
      if ((paramObject.wNC == b.wNJ) || (paramObject.wNC == b.wNN) || (paramObject.wNC == b.wNM)) {}
      try
      {
        paramObject.wNC = b.wNK;
        Socket localSocket = paramObject.wNH;
        s.checkNotNull(localSocket);
        localSocket.connect((SocketAddress)new InetSocketAddress((String)localObject, i), 2000);
        paramObject.wNC = b.wNL;
        Log.d("TCP Client", "C: Connected...");
        paramObject = ah.aiuX;
        AppMethodBeat.o(274283);
        return paramObject;
      }
      catch (SocketTimeoutException localSocketTimeoutException)
      {
        for (;;)
        {
          Log.e("client_connection", "connection timeout", new Object[] { localSocketTimeoutException });
          paramObject.wNC = b.wNM;
          paramObject.wNH = new Socket();
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Log.e("client_connection", "Fail connection", new Object[] { localException });
          paramObject.wNC = b.wNN;
          paramObject.wNH = new Socket();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.cast.g.a.a
 * JD-Core Version:    0.7.0.1
 */