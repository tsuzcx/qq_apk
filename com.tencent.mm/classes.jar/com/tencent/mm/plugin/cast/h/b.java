package com.tencent.mm.plugin.cast.h;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.cast.h.a.a.a;
import com.tencent.mm.sdk.platformtools.Log;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import kotlin.ResultKt;
import kotlin.a.e;
import kotlin.d.b.a.j;
import kotlin.d.d;
import kotlin.d.f;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;
import kotlinx.coroutines.ak;
import kotlinx.coroutines.bc;
import kotlinx.coroutines.br;
import kotlinx.coroutines.g;
import kotlinx.coroutines.i;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/cast/transportclient/TransportClient;", "", "()V", "audioSend", "", "connectStatus", "Lcom/tencent/mm/plugin/cast/transportclient/connection/Status;", "connection", "Lcom/tencent/mm/plugin/cast/transportclient/connection/Connection;", "handlers", "", "Lcom/tencent/mm/plugin/cast/transportclient/reader/handlers/HandlerImp;", "magicNum", "remoteReader", "Lcom/tencent/mm/plugin/cast/transportclient/reader/RemoteReaderImp;", "remoteWriter", "Lcom/tencent/mm/plugin/cast/transportclient/writer/RemoteWriterImp;", "videoSend", "addHandlers", "", "", "connect", "address", "", "port", "callback", "Lcom/tencent/mm/plugin/cast/transportclient/ConnectListener;", "disconnect", "getConnectStatus", "removeHandlers", "send", "dataType", "", "data", "", "direction", "startReadingAndWriting", "socket", "Ljava/net/Socket;", "toHexString", "plugin-cast_release"})
public final class b
{
  private final int tKc;
  final com.tencent.mm.plugin.cast.h.a.a tKd;
  final com.tencent.mm.plugin.cast.h.b.b tKe;
  final com.tencent.mm.plugin.cast.h.c.b tKf;
  private int tKg;
  private int tKh;
  final List<Object> tKi;
  private final com.tencent.mm.plugin.cast.h.a.b tKj;
  
  public b()
  {
    AppMethodBeat.i(190672);
    this.tKc = 617;
    this.tKd = new com.tencent.mm.plugin.cast.h.a.a();
    this.tKe = ((com.tencent.mm.plugin.cast.h.b.b)new com.tencent.mm.plugin.cast.h.b.a());
    this.tKf = ((com.tencent.mm.plugin.cast.h.c.b)new com.tencent.mm.plugin.cast.h.c.a());
    this.tKi = ((List)new ArrayList());
    this.tKj = this.tKd.tKj;
    AppMethodBeat.o(190672);
  }
  
  public final int a(byte paramByte, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(190666);
    p.k(paramArrayOfByte, "data");
    int i = paramArrayOfByte.length + 12;
    byte[] arrayOfByte = new byte[12];
    arrayOfByte[0] = ((byte)(this.tKc & 0xFF));
    arrayOfByte[1] = ((byte)(this.tKc >>> 8 & 0xFF));
    arrayOfByte[2] = ((byte)(i & 0xFF));
    arrayOfByte[3] = ((byte)(i >>> 8 & 0xFF));
    arrayOfByte[4] = ((byte)(i >>> 16 & 0xFF));
    arrayOfByte[5] = ((byte)(i >>> 24 & 0xFF));
    arrayOfByte[6] = 12;
    arrayOfByte[7] = 0;
    arrayOfByte[8] = paramByte;
    if (paramByte == 1)
    {
      this.tKh += 1;
      arrayOfByte[9] = ((byte)(this.tKh & 0xFF));
      arrayOfByte[10] = ((byte)(this.tKh >>> 8 & 0xFF));
      Log.d("ScreenRecord.Main", "headlen:12 pktlen:" + i + " dataType:" + paramByte + " typeSeq:" + this.tKh + " direction:0");
    }
    if (paramByte == 2)
    {
      this.tKg += 1;
      arrayOfByte[9] = ((byte)(this.tKg & 0xFF));
      arrayOfByte[10] = ((byte)(this.tKg >>> 8 & 0xFF));
      Log.d("ScreenRecord.Main", "headlen:12 pktlen:" + i + " dataType:" + paramByte + " typeSeq:" + this.tKg);
    }
    arrayOfByte[11] = 0;
    paramArrayOfByte = e.t(arrayOfByte, paramArrayOfByte);
    i = this.tKf.bt(paramArrayOfByte);
    AppMethodBeat.o(190666);
    return i;
  }
  
  public final void a(final String paramString, final int paramInt, final a parama)
  {
    AppMethodBeat.i(190646);
    p.k(paramString, "address");
    p.k(parama, "callback");
    Log.i("ScreenRecord.Main", "try connect to server " + paramString + ":" + paramInt);
    g.b((ak)br.abxo, null, (m)new a(this, paramString, paramInt, parama, null), 3);
    AppMethodBeat.o(190646);
  }
  
  public final void disconnect()
  {
    AppMethodBeat.i(190650);
    this.tKe.cLU();
    this.tKf.ase("EXIT");
    Thread.sleep(50L);
    this.tKd.disconnect();
    AppMethodBeat.o(190650);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"})
  static final class a
    extends j
    implements m<ak, d<? super x>, Object>
  {
    Object L$0;
    int label;
    private ak p$;
    
    a(b paramb, String paramString, int paramInt, a parama, d paramd)
    {
      super(paramd);
    }
    
    public final d<x> create(Object paramObject, d<?> paramd)
    {
      AppMethodBeat.i(190492);
      p.k(paramd, "completion");
      paramd = new a(this.tKk, paramString, paramInt, parama, paramd);
      paramd.p$ = ((ak)paramObject);
      AppMethodBeat.o(190492);
      return paramd;
    }
    
    public final Object invoke(Object paramObject1, Object paramObject2)
    {
      AppMethodBeat.i(190493);
      paramObject1 = ((a)create(paramObject1, (d)paramObject2)).invokeSuspend(x.aazN);
      AppMethodBeat.o(190493);
      return paramObject1;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(190488);
      kotlin.d.a.a locala = kotlin.d.a.a.aaAA;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(190488);
        throw paramObject;
      case 0: 
        ResultKt.throwOnFailure(paramObject);
        paramObject = this.p$;
        Log.i("ScreenRecord.Main", "thread try connect to server " + paramString + ":" + paramInt);
        localObject = this.tKk.tKd;
        String str = paramString;
        int i = paramInt;
        this.L$0 = paramObject;
        this.label = 1;
        localObject = i.a((f)bc.iRq(), (m)new a.a((com.tencent.mm.plugin.cast.h.a.a)localObject, str, i, null), this);
        paramObject = localObject;
        if (localObject != kotlin.d.a.a.aaAA) {
          paramObject = x.aazN;
        }
        if (paramObject == locala)
        {
          AppMethodBeat.o(190488);
          return locala;
        }
        break;
      case 1: 
        ResultKt.throwOnFailure(paramObject);
      }
      paramObject = new StringBuilder("Socket:").append(this.tKk.tKd.tKo).append("status:");
      Object localObject = this.tKk.tKd.tKo;
      if (localObject == null) {
        p.iCn();
      }
      Log.i("ScreenRecord.Main", ((Socket)localObject).isConnected());
      if (this.tKk.tKd.tKo != null)
      {
        paramObject = this.tKk.tKd.tKo;
        if (paramObject == null) {
          p.iCn();
        }
        if (paramObject.isConnected())
        {
          paramObject = this.tKk;
          localObject = this.tKk.tKd.tKo;
          if (localObject == null) {
            p.iCn();
          }
          paramObject.tKe.c((Socket)localObject);
          paramObject.tKf.d((Socket)localObject);
          this.tKk.tKe.cX(this.tKk.tKi);
        }
      }
      parama.a(this.tKk.tKd.tKj);
      paramObject = x.aazN;
      AppMethodBeat.o(190488);
      return paramObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.cast.h.b
 * JD-Core Version:    0.7.0.1
 */