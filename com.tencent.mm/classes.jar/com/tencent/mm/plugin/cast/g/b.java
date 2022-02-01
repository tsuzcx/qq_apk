package com.tencent.mm.plugin.cast.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.cast.g.a.a.a;
import com.tencent.mm.sdk.platformtools.Log;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.ah;
import kotlin.d.d;
import kotlin.d.f;
import kotlin.g.a.m;
import kotlin.g.b.s;
import kotlinx.coroutines.aq;
import kotlinx.coroutines.bg;
import kotlinx.coroutines.bu;
import kotlinx.coroutines.j;
import kotlinx.coroutines.l;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/cast/transportclient/TransportClient;", "", "()V", "audioSend", "", "connectStatus", "Lcom/tencent/mm/plugin/cast/transportclient/connection/Status;", "connection", "Lcom/tencent/mm/plugin/cast/transportclient/connection/Connection;", "handlers", "", "Lcom/tencent/mm/plugin/cast/transportclient/reader/handlers/HandlerImp;", "magicNum", "remoteReader", "Lcom/tencent/mm/plugin/cast/transportclient/reader/RemoteReaderImp;", "remoteWriter", "Lcom/tencent/mm/plugin/cast/transportclient/writer/RemoteWriterImp;", "videoSend", "addHandlers", "", "", "connect", "address", "", "port", "callback", "Lcom/tencent/mm/plugin/cast/transportclient/ConnectListener;", "disconnect", "getConnectStatus", "removeHandlers", "send", "dataType", "", "data", "", "direction", "startReadingAndWriting", "socket", "Ljava/net/Socket;", "toHexString", "plugin-cast_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
{
  private int wNA;
  final List<Object> wNB;
  private final com.tencent.mm.plugin.cast.g.a.b wNC;
  private final int wNv;
  public final com.tencent.mm.plugin.cast.g.a.a wNw;
  public final com.tencent.mm.plugin.cast.g.b.b wNx;
  public final com.tencent.mm.plugin.cast.g.c.b wNy;
  private int wNz;
  
  public b()
  {
    AppMethodBeat.i(274273);
    this.wNv = 617;
    this.wNw = new com.tencent.mm.plugin.cast.g.a.a();
    this.wNx = ((com.tencent.mm.plugin.cast.g.b.b)new com.tencent.mm.plugin.cast.g.b.a());
    this.wNy = ((com.tencent.mm.plugin.cast.g.c.b)new com.tencent.mm.plugin.cast.g.c.a());
    this.wNB = ((List)new ArrayList());
    this.wNC = this.wNw.wNC;
    AppMethodBeat.o(274273);
  }
  
  public final int a(byte paramByte, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(274288);
    s.u(paramArrayOfByte, "data");
    int i = paramArrayOfByte.length + 12;
    byte[] arrayOfByte = new byte[12];
    arrayOfByte[0] = ((byte)(this.wNv & 0xFF));
    arrayOfByte[1] = ((byte)(this.wNv >>> 8 & 0xFF));
    arrayOfByte[2] = ((byte)(i & 0xFF));
    arrayOfByte[3] = ((byte)(i >>> 8 & 0xFF));
    arrayOfByte[4] = ((byte)(i >>> 16 & 0xFF));
    arrayOfByte[5] = ((byte)(i >>> 24 & 0xFF));
    arrayOfByte[6] = 12;
    arrayOfByte[7] = 0;
    arrayOfByte[8] = paramByte;
    if (paramByte == 1)
    {
      this.wNA += 1;
      arrayOfByte[9] = ((byte)(this.wNA & 0xFF));
      arrayOfByte[10] = ((byte)(this.wNA >>> 8 & 0xFF));
      Log.d("ScreenRecord.Main", "headlen:12 pktlen:" + i + " dataType:" + paramByte + " typeSeq:" + this.wNA + " direction:0");
    }
    if (paramByte == 2)
    {
      this.wNz += 1;
      arrayOfByte[9] = ((byte)(this.wNz & 0xFF));
      arrayOfByte[10] = ((byte)(this.wNz >>> 8 & 0xFF));
      Log.d("ScreenRecord.Main", "headlen:12 pktlen:" + i + " dataType:" + paramByte + " typeSeq:" + this.wNz);
    }
    arrayOfByte[11] = 0;
    paramArrayOfByte = kotlin.a.k.u(arrayOfByte, paramArrayOfByte);
    i = this.wNy.bt(paramArrayOfByte);
    AppMethodBeat.o(274288);
    return i;
  }
  
  public final void a(String paramString, final int paramInt, final a parama)
  {
    AppMethodBeat.i(274279);
    s.u(paramString, "address");
    s.u(parama, "callback");
    Log.i("ScreenRecord.Main", "try connect to server " + paramString + ':' + paramInt);
    j.a((aq)bu.ajwo, null, null, (m)new a(paramString, paramInt, this, parama, null), 3);
    AppMethodBeat.o(274279);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends kotlin.d.b.a.k
    implements m<aq, d<? super ah>, Object>
  {
    int label;
    
    a(String paramString, int paramInt, b paramb, a parama, d<? super a> paramd)
    {
      super(paramd);
    }
    
    public final d<ah> create(Object paramObject, d<?> paramd)
    {
      AppMethodBeat.i(274293);
      paramObject = (d)new a(this.wND, paramInt, jdField_this, parama, paramd);
      AppMethodBeat.o(274293);
      return paramObject;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(274286);
      kotlin.d.a.a locala = kotlin.d.a.a.aiwj;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(274286);
        throw paramObject;
      case 0: 
        ResultKt.throwOnFailure(paramObject);
        Log.i("ScreenRecord.Main", "thread try connect to server " + this.wND + ':' + paramInt);
        paramObject = jdField_this.wNw;
        localObject = this.wND;
        int i = paramInt;
        d locald = (d)this;
        this.label = 1;
        localObject = l.a((f)bg.kCg(), (m)new a.a(paramObject, (String)localObject, i, null), locald);
        paramObject = localObject;
        if (localObject != kotlin.d.a.a.aiwj) {
          paramObject = ah.aiuX;
        }
        if (paramObject == locala)
        {
          AppMethodBeat.o(274286);
          return locala;
        }
        break;
      case 1: 
        ResultKt.throwOnFailure(paramObject);
      }
      paramObject = new StringBuilder("Socket:").append(jdField_this.wNw.wNH).append("status:");
      Object localObject = jdField_this.wNw.wNH;
      s.checkNotNull(localObject);
      Log.i("ScreenRecord.Main", ((Socket)localObject).isConnected());
      if (jdField_this.wNw.wNH != null)
      {
        paramObject = jdField_this.wNw.wNH;
        s.checkNotNull(paramObject);
        if (paramObject.isConnected())
        {
          paramObject = jdField_this;
          localObject = jdField_this.wNw.wNH;
          s.checkNotNull(localObject);
          paramObject.wNx.c((Socket)localObject);
          paramObject.wNy.d((Socket)localObject);
          jdField_this.wNx.eS(jdField_this.wNB);
        }
      }
      parama.a(jdField_this.wNw.wNC);
      paramObject = ah.aiuX;
      AppMethodBeat.o(274286);
      return paramObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.cast.g.b
 * JD-Core Version:    0.7.0.1
 */