package com.tencent.mm.ay;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.h;
import com.tencent.mm.am.n;
import com.tencent.mm.am.p;
import com.tencent.mm.am.p.b;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.messenger.foundation.a.a.k.b;
import com.tencent.mm.protocal.l.b;
import com.tencent.mm.protocal.l.c;
import com.tencent.mm.protocal.l.d;
import com.tencent.mm.protocal.l.e;
import com.tencent.mm.protocal.protobuf.adw;
import com.tencent.mm.protocal.protobuf.adx;
import com.tencent.mm.protocal.protobuf.dzd;
import com.tencent.mm.protocal.protobuf.dze;
import com.tencent.mm.protocal.protobuf.gol;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class b
  extends p
  implements m
{
  private h callback;
  public a oPG;
  public final List<k.b> oPH;
  
  public b(List<k.b> paramList)
  {
    AppMethodBeat.i(43049);
    this.oPH = new ArrayList();
    this.oPH.addAll(paramList);
    this.oPG = new a();
    ((b)this.oPG.getReqObj()).oPK.abat = cc(paramList);
    AppMethodBeat.o(43049);
  }
  
  private static adx cc(List<k.b> paramList)
  {
    AppMethodBeat.i(43050);
    adx localadx = new adx();
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      k.b localb = (k.b)localIterator.next();
      byte[] arrayOfByte = localb.getBuffer();
      adw localadw = new adw();
      localadw.Zmc = localb.getCmdId();
      localadw.Zmd = new gol().df(arrayOfByte);
      localadx.vgO.add(localadw);
    }
    localadx.vgN = paramList.size();
    Log.d("MicroMsg.NetSceneOplog", "summeroplog oplogs size=" + paramList.size());
    AppMethodBeat.o(43050);
    return localadx;
  }
  
  public int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(43051);
    this.callback = paramh;
    int i = dispatch(paramg, this.oPG, this);
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
  
  public p.b securityVerificationChecked(s params)
  {
    return p.b.ouh;
  }
  
  public static final class a
    extends n
  {
    private final b.b oPI;
    private final b.c oPJ;
    
    public a()
    {
      AppMethodBeat.i(43044);
      this.oPI = new b.b();
      this.oPJ = new b.c();
      AppMethodBeat.o(43044);
    }
    
    public final l.d getReqObjImp()
    {
      return this.oPI;
    }
    
    public final l.e getRespObj()
    {
      return this.oPJ;
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
    public dzd oPK;
    
    b()
    {
      AppMethodBeat.i(43045);
      this.oPK = new dzd();
      AppMethodBeat.o(43045);
    }
    
    public final int getFuncId()
    {
      return 681;
    }
    
    public final byte[] toProtoBuf()
    {
      AppMethodBeat.i(43046);
      byte[] arrayOfByte = this.oPK.toByteArray();
      AppMethodBeat.o(43046);
      return arrayOfByte;
    }
  }
  
  public static final class c
    extends l.e
    implements l.c
  {
    public dze oPL;
    
    public c()
    {
      AppMethodBeat.i(43047);
      this.oPL = new dze();
      AppMethodBeat.o(43047);
    }
    
    public final int fromProtoBuf(byte[] paramArrayOfByte)
    {
      AppMethodBeat.i(43048);
      this.oPL = ((dze)new dze().parseFrom(paramArrayOfByte));
      int i = this.oPL.Idd;
      AppMethodBeat.o(43048);
      return i;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ay.b
 * JD-Core Version:    0.7.0.1
 */