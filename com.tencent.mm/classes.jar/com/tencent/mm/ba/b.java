package com.tencent.mm.ba;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.l;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.n.b;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.messenger.foundation.a.a.j.b;
import com.tencent.mm.protocal.l.b;
import com.tencent.mm.protocal.l.c;
import com.tencent.mm.protocal.l.d;
import com.tencent.mm.protocal.l.e;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.cbu;
import com.tencent.mm.protocal.protobuf.cbv;
import com.tencent.mm.protocal.protobuf.xv;
import com.tencent.mm.protocal.protobuf.xw;
import com.tencent.mm.sdk.platformtools.ac;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class b
  extends n
  implements k
{
  private g callback;
  public a hOV;
  public final List<j.b> hOW;
  
  public b(List<j.b> paramList)
  {
    AppMethodBeat.i(43049);
    this.hOW = new ArrayList();
    this.hOW.addAll(paramList);
    this.hOV = new a();
    ((b)this.hOV.getReqObj()).hOZ.Fnk = ap(paramList);
    AppMethodBeat.o(43049);
  }
  
  private static xw ap(List<j.b> paramList)
  {
    AppMethodBeat.i(43050);
    xw localxw = new xw();
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      j.b localb = (j.b)localIterator.next();
      byte[] arrayOfByte = localb.getBuffer();
      xv localxv = new xv();
      localxv.ErL = localb.getCmdId();
      localxv.ErM = new SKBuiltinBuffer_t().setBuffer(arrayOfByte);
      localxw.ncM.add(localxv);
    }
    localxw.ncL = paramList.size();
    ac.d("MicroMsg.NetSceneOplog", "summeroplog oplogs size=" + paramList.size());
    AppMethodBeat.o(43050);
    return localxw;
  }
  
  public int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(43051);
    this.callback = paramg;
    int i = dispatch(parame, this.hOV, this);
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
    return n.b.hwa;
  }
  
  public static final class a
    extends l
  {
    private final b.b hOX;
    private final b.c hOY;
    
    public a()
    {
      AppMethodBeat.i(43044);
      this.hOX = new b.b();
      this.hOY = new b.c();
      AppMethodBeat.o(43044);
    }
    
    public final l.d getReqObjImp()
    {
      return this.hOX;
    }
    
    public final l.e getRespObj()
    {
      return this.hOY;
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
    public cbu hOZ;
    
    b()
    {
      AppMethodBeat.i(43045);
      this.hOZ = new cbu();
      AppMethodBeat.o(43045);
    }
    
    public final int getFuncId()
    {
      return 681;
    }
    
    public final byte[] toProtoBuf()
    {
      AppMethodBeat.i(43046);
      byte[] arrayOfByte = this.hOZ.toByteArray();
      AppMethodBeat.o(43046);
      return arrayOfByte;
    }
  }
  
  public static final class c
    extends l.e
    implements l.c
  {
    public cbv hPa;
    
    public c()
    {
      AppMethodBeat.i(43047);
      this.hPa = new cbv();
      AppMethodBeat.o(43047);
    }
    
    public final int fromProtoBuf(byte[] paramArrayOfByte)
    {
      AppMethodBeat.i(43048);
      this.hPa = ((cbv)new cbv().parseFrom(paramArrayOfByte));
      int i = this.hPa.Ret;
      AppMethodBeat.o(43048);
      return i;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ba.b
 * JD-Core Version:    0.7.0.1
 */