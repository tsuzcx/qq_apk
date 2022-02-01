package com.tencent.mm.bb;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.g;
import com.tencent.mm.al.l;
import com.tencent.mm.al.n;
import com.tencent.mm.al.n.b;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.messenger.foundation.a.a.j.b;
import com.tencent.mm.protocal.l.b;
import com.tencent.mm.protocal.l.c;
import com.tencent.mm.protocal.l.d;
import com.tencent.mm.protocal.l.e;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.bxa;
import com.tencent.mm.protocal.protobuf.bxb;
import com.tencent.mm.protocal.protobuf.xd;
import com.tencent.mm.protocal.protobuf.xe;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class b
  extends n
  implements k
{
  private g callback;
  public a hos;
  public final List<j.b> hot;
  
  public b(List<j.b> paramList)
  {
    AppMethodBeat.i(43049);
    this.hot = new ArrayList();
    this.hot.addAll(paramList);
    this.hos = new a();
    ((b)this.hos.getReqObj()).how.DQS = as(paramList);
    AppMethodBeat.o(43049);
  }
  
  private static xe as(List<j.b> paramList)
  {
    AppMethodBeat.i(43050);
    xe localxe = new xe();
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      j.b localb = (j.b)localIterator.next();
      byte[] arrayOfByte = localb.getBuffer();
      xd localxd = new xd();
      localxd.CYY = localb.getCmdId();
      localxd.CYZ = new SKBuiltinBuffer_t().setBuffer(arrayOfByte);
      localxe.mAL.add(localxd);
    }
    localxe.mAK = paramList.size();
    ad.d("MicroMsg.NetSceneOplog", "summeroplog oplogs size=" + paramList.size());
    AppMethodBeat.o(43050);
    return localxe;
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(43051);
    this.callback = paramg;
    int i = dispatch(parame, this.hos, this);
    AppMethodBeat.o(43051);
    return i;
  }
  
  public final int getType()
  {
    return 681;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(43052);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(43052);
  }
  
  public final int securityLimitCount()
  {
    return 5;
  }
  
  public final n.b securityVerificationChecked(q paramq)
  {
    return n.b.gVB;
  }
  
  public static final class a
    extends l
  {
    private final b.b hou;
    private final b.c hov;
    
    public a()
    {
      AppMethodBeat.i(43044);
      this.hou = new b.b();
      this.hov = new b.c();
      AppMethodBeat.o(43044);
    }
    
    public final l.d getReqObjImp()
    {
      return this.hou;
    }
    
    public final l.e getRespObj()
    {
      return this.hov;
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
    public bxa how;
    
    b()
    {
      AppMethodBeat.i(43045);
      this.how = new bxa();
      AppMethodBeat.o(43045);
    }
    
    public final int getFuncId()
    {
      return 681;
    }
    
    public final byte[] toProtoBuf()
    {
      AppMethodBeat.i(43046);
      byte[] arrayOfByte = this.how.toByteArray();
      AppMethodBeat.o(43046);
      return arrayOfByte;
    }
  }
  
  public static final class c
    extends l.e
    implements l.c
  {
    public bxb hox;
    
    public c()
    {
      AppMethodBeat.i(43047);
      this.hox = new bxb();
      AppMethodBeat.o(43047);
    }
    
    public final int fromProtoBuf(byte[] paramArrayOfByte)
    {
      AppMethodBeat.i(43048);
      this.hox = ((bxb)new bxb().parseFrom(paramArrayOfByte));
      int i = this.hox.Ret;
      AppMethodBeat.o(43048);
      return i;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.bb.b
 * JD-Core Version:    0.7.0.1
 */