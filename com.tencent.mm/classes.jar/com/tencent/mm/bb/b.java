package com.tencent.mm.bb;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.f;
import com.tencent.mm.al.l;
import com.tencent.mm.al.n;
import com.tencent.mm.al.n.b;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.messenger.foundation.a.a.k.b;
import com.tencent.mm.protocal.l.b;
import com.tencent.mm.protocal.l.c;
import com.tencent.mm.protocal.l.d;
import com.tencent.mm.protocal.l.e;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.cgl;
import com.tencent.mm.protocal.protobuf.cgm;
import com.tencent.mm.protocal.protobuf.zu;
import com.tencent.mm.protocal.protobuf.zv;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class b
  extends n
  implements k
{
  private f callback;
  public a iij;
  public final List<k.b> iik;
  
  public b(List<k.b> paramList)
  {
    AppMethodBeat.i(43049);
    this.iik = new ArrayList();
    this.iik.addAll(paramList);
    this.iij = new a();
    ((b)this.iij.getReqObj()).iin.GWT = aq(paramList);
    AppMethodBeat.o(43049);
  }
  
  private static zv aq(List<k.b> paramList)
  {
    AppMethodBeat.i(43050);
    zv localzv = new zv();
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      k.b localb = (k.b)localIterator.next();
      byte[] arrayOfByte = localb.getBuffer();
      zu localzu = new zu();
      localzu.FYU = localb.getCmdId();
      localzu.FYV = new SKBuiltinBuffer_t().setBuffer(arrayOfByte);
      localzv.nDj.add(localzu);
    }
    localzv.nDi = paramList.size();
    ad.d("MicroMsg.NetSceneOplog", "summeroplog oplogs size=" + paramList.size());
    AppMethodBeat.o(43050);
    return localzv;
  }
  
  public int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(43051);
    this.callback = paramf;
    int i = dispatch(parame, this.iij, this);
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
    return n.b.hOp;
  }
  
  public static final class a
    extends l
  {
    private final b.b iil;
    private final b.c iim;
    
    public a()
    {
      AppMethodBeat.i(43044);
      this.iil = new b.b();
      this.iim = new b.c();
      AppMethodBeat.o(43044);
    }
    
    public final l.d getReqObjImp()
    {
      return this.iil;
    }
    
    public final l.e getRespObj()
    {
      return this.iim;
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
    public cgl iin;
    
    b()
    {
      AppMethodBeat.i(43045);
      this.iin = new cgl();
      AppMethodBeat.o(43045);
    }
    
    public final int getFuncId()
    {
      return 681;
    }
    
    public final byte[] toProtoBuf()
    {
      AppMethodBeat.i(43046);
      byte[] arrayOfByte = this.iin.toByteArray();
      AppMethodBeat.o(43046);
      return arrayOfByte;
    }
  }
  
  public static final class c
    extends l.e
    implements l.c
  {
    public cgm iio;
    
    public c()
    {
      AppMethodBeat.i(43047);
      this.iio = new cgm();
      AppMethodBeat.o(43047);
    }
    
    public final int fromProtoBuf(byte[] paramArrayOfByte)
    {
      AppMethodBeat.i(43048);
      this.iio = ((cgm)new cgm().parseFrom(paramArrayOfByte));
      int i = this.iio.Ret;
      AppMethodBeat.o(43048);
      return i;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.bb.b
 * JD-Core Version:    0.7.0.1
 */