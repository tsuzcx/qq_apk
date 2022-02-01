package com.tencent.mm.ba;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.l;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.n.b;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.messenger.foundation.a.a.k.b;
import com.tencent.mm.protocal.l.b;
import com.tencent.mm.protocal.l.c;
import com.tencent.mm.protocal.l.d;
import com.tencent.mm.protocal.l.e;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.chf;
import com.tencent.mm.protocal.protobuf.chg;
import com.tencent.mm.protocal.protobuf.zx;
import com.tencent.mm.protocal.protobuf.zy;
import com.tencent.mm.sdk.platformtools.ae;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class b
  extends n
  implements k
{
  private f callback;
  public a ilc;
  public final List<k.b> ild;
  
  public b(List<k.b> paramList)
  {
    AppMethodBeat.i(43049);
    this.ild = new ArrayList();
    this.ild.addAll(paramList);
    this.ilc = new a();
    ((b)this.ilc.getReqObj()).ilg.Hqt = aq(paramList);
    AppMethodBeat.o(43049);
  }
  
  private static zy aq(List<k.b> paramList)
  {
    AppMethodBeat.i(43050);
    zy localzy = new zy();
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      k.b localb = (k.b)localIterator.next();
      byte[] arrayOfByte = localb.getBuffer();
      zx localzx = new zx();
      localzx.Gru = localb.getCmdId();
      localzx.Grv = new SKBuiltinBuffer_t().setBuffer(arrayOfByte);
      localzy.nIE.add(localzx);
    }
    localzy.nID = paramList.size();
    ae.d("MicroMsg.NetSceneOplog", "summeroplog oplogs size=" + paramList.size());
    AppMethodBeat.o(43050);
    return localzy;
  }
  
  public int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(43051);
    this.callback = paramf;
    int i = dispatch(parame, this.ilc, this);
    AppMethodBeat.o(43051);
    return i;
  }
  
  public int getType()
  {
    return 681;
  }
  
  public void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(43052);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(43052);
  }
  
  public int securityLimitCount()
  {
    return 5;
  }
  
  public n.b securityVerificationChecked(q paramq)
  {
    return n.b.hRi;
  }
  
  public static final class a
    extends l
  {
    private final b.b ile;
    private final b.c ilf;
    
    public a()
    {
      AppMethodBeat.i(43044);
      this.ile = new b.b();
      this.ilf = new b.c();
      AppMethodBeat.o(43044);
    }
    
    public final l.d getReqObjImp()
    {
      return this.ile;
    }
    
    public final l.e getRespObj()
    {
      return this.ilf;
    }
    
    public final int getType()
    {
      return 681;
    }
    
    public final String getUri()
    {
      return "/cgi-bin/micromsg-bin/oplog";
    }
  }
  
  static final class b
    extends l.d
    implements l.b
  {
    public chf ilg;
    
    b()
    {
      AppMethodBeat.i(43045);
      this.ilg = new chf();
      AppMethodBeat.o(43045);
    }
    
    public final int getFuncId()
    {
      return 681;
    }
    
    public final byte[] toProtoBuf()
    {
      AppMethodBeat.i(43046);
      byte[] arrayOfByte = this.ilg.toByteArray();
      AppMethodBeat.o(43046);
      return arrayOfByte;
    }
  }
  
  public static final class c
    extends l.e
    implements l.c
  {
    public chg ilh;
    
    public c()
    {
      AppMethodBeat.i(43047);
      this.ilh = new chg();
      AppMethodBeat.o(43047);
    }
    
    public final int fromProtoBuf(byte[] paramArrayOfByte)
    {
      AppMethodBeat.i(43048);
      this.ilh = ((chg)new chg().parseFrom(paramArrayOfByte));
      int i = this.ilh.Ret;
      AppMethodBeat.o(43048);
      return i;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ba.b
 * JD-Core Version:    0.7.0.1
 */