package com.tencent.mm.bd;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.i;
import com.tencent.mm.an.o;
import com.tencent.mm.an.q;
import com.tencent.mm.an.q.b;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.messenger.foundation.a.a.k.b;
import com.tencent.mm.protocal.l.b;
import com.tencent.mm.protocal.l.c;
import com.tencent.mm.protocal.l.d;
import com.tencent.mm.protocal.l.e;
import com.tencent.mm.protocal.protobuf.abu;
import com.tencent.mm.protocal.protobuf.abv;
import com.tencent.mm.protocal.protobuf.dgw;
import com.tencent.mm.protocal.protobuf.dgx;
import com.tencent.mm.protocal.protobuf.eae;
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
  public a lWE;
  public final List<k.b> lWF;
  
  public b(List<k.b> paramList)
  {
    AppMethodBeat.i(43049);
    this.lWF = new ArrayList();
    this.lWF.addAll(paramList);
    this.lWE = new a();
    ((b)this.lWE.getReqObj()).lWI.TKA = ax(paramList);
    AppMethodBeat.o(43049);
  }
  
  private static abv ax(List<k.b> paramList)
  {
    AppMethodBeat.i(43050);
    abv localabv = new abv();
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      k.b localb = (k.b)localIterator.next();
      byte[] arrayOfByte = localb.getBuffer();
      abu localabu = new abu();
      localabu.SnG = localb.getCmdId();
      localabu.SnH = new eae().dc(arrayOfByte);
      localabv.rVy.add(localabu);
    }
    localabv.rVx = paramList.size();
    Log.d("MicroMsg.NetSceneOplog", "summeroplog oplogs size=" + paramList.size());
    AppMethodBeat.o(43050);
    return localabv;
  }
  
  public int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(43051);
    this.callback = parami;
    int i = dispatch(paramg, this.lWE, this);
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
    return q.b.lCx;
  }
  
  public static final class a
    extends o
  {
    private final b.b lWG;
    private final b.c lWH;
    
    public a()
    {
      AppMethodBeat.i(43044);
      this.lWG = new b.b();
      this.lWH = new b.c();
      AppMethodBeat.o(43044);
    }
    
    public final l.d getReqObjImp()
    {
      return this.lWG;
    }
    
    public final l.e getRespObj()
    {
      return this.lWH;
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
    public dgw lWI;
    
    b()
    {
      AppMethodBeat.i(43045);
      this.lWI = new dgw();
      AppMethodBeat.o(43045);
    }
    
    public final int getFuncId()
    {
      return 681;
    }
    
    public final byte[] toProtoBuf()
    {
      AppMethodBeat.i(43046);
      byte[] arrayOfByte = this.lWI.toByteArray();
      AppMethodBeat.o(43046);
      return arrayOfByte;
    }
  }
  
  public static final class c
    extends l.e
    implements l.c
  {
    public dgx lWJ;
    
    public c()
    {
      AppMethodBeat.i(43047);
      this.lWJ = new dgx();
      AppMethodBeat.o(43047);
    }
    
    public final int fromProtoBuf(byte[] paramArrayOfByte)
    {
      AppMethodBeat.i(43048);
      this.lWJ = ((dgx)new dgx().parseFrom(paramArrayOfByte));
      int i = this.lWJ.CqV;
      AppMethodBeat.o(43048);
      return i;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.bd.b
 * JD-Core Version:    0.7.0.1
 */