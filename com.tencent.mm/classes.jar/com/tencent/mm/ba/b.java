package com.tencent.mm.ba;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.o;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.q.b;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.messenger.foundation.a.a.k.b;
import com.tencent.mm.protocal.l.b;
import com.tencent.mm.protocal.l.d;
import com.tencent.mm.protocal.l.e;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.abn;
import com.tencent.mm.protocal.protobuf.abo;
import com.tencent.mm.protocal.protobuf.cxm;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class b
  extends q
  implements m
{
  private i callback;
  public a jgb;
  public final List<k.b> jgc;
  
  public b(List<k.b> paramList)
  {
    AppMethodBeat.i(43049);
    this.jgc = new ArrayList();
    this.jgc.addAll(paramList);
    this.jgb = new a();
    ((b)this.jgb.getReqObj()).jgf.MyZ = az(paramList);
    AppMethodBeat.o(43049);
  }
  
  private static abo az(List<k.b> paramList)
  {
    AppMethodBeat.i(43050);
    abo localabo = new abo();
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      k.b localb = (k.b)localIterator.next();
      byte[] arrayOfByte = localb.getBuffer();
      abn localabn = new abn();
      localabn.Lms = localb.getCmdId();
      localabn.Lmt = new SKBuiltinBuffer_t().setBuffer(arrayOfByte);
      localabo.oTA.add(localabn);
    }
    localabo.oTz = paramList.size();
    Log.d("MicroMsg.NetSceneOplog", "summeroplog oplogs size=" + paramList.size());
    AppMethodBeat.o(43050);
    return localabo;
  }
  
  public int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(43051);
    this.callback = parami;
    int i = dispatch(paramg, this.jgb, this);
    AppMethodBeat.o(43051);
    return i;
  }
  
  public int getType()
  {
    return 681;
  }
  
  public void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(43052);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(43052);
  }
  
  public int securityLimitCount()
  {
    return 5;
  }
  
  public q.b securityVerificationChecked(s params)
  {
    return q.b.iMq;
  }
  
  public static final class a
    extends o
  {
    private final b.b jgd;
    private final b.c jge;
    
    public a()
    {
      AppMethodBeat.i(43044);
      this.jgd = new b.b();
      this.jge = new b.c();
      AppMethodBeat.o(43044);
    }
    
    public final l.d getReqObjImp()
    {
      return this.jgd;
    }
    
    public final l.e getRespObj()
    {
      return this.jge;
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
    public cxm jgf;
    
    b()
    {
      AppMethodBeat.i(43045);
      this.jgf = new cxm();
      AppMethodBeat.o(43045);
    }
    
    public final int getFuncId()
    {
      return 681;
    }
    
    public final byte[] toProtoBuf()
    {
      AppMethodBeat.i(43046);
      byte[] arrayOfByte = this.jgf.toByteArray();
      AppMethodBeat.o(43046);
      return arrayOfByte;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ba.b
 * JD-Core Version:    0.7.0.1
 */