package com.tencent.mm.plugin.messenger.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.j;
import com.tencent.mm.am.k;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.d.c;
import com.tencent.mm.an.i;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.c.a;
import com.tencent.mm.protocal.protobuf.eaf;
import com.tencent.mm.protocal.protobuf.ebn;
import com.tencent.mm.protocal.protobuf.ebo;
import com.tencent.mm.protocal.protobuf.ebp;
import com.tencent.mm.protocal.protobuf.ecg;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Iterator;
import java.util.LinkedList;

public final class f
  extends com.tencent.mm.an.q
  implements m
{
  public final boolean EUK;
  private i callback;
  public final d rr;
  
  public f(String paramString)
  {
    this(paramString, 0);
  }
  
  public f(String paramString, int paramInt)
  {
    this(paramString, paramInt, (byte)0);
  }
  
  private f(String paramString, int paramInt, byte paramByte)
  {
    this(paramString, 1, paramInt, false);
  }
  
  public f(String paramString, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    AppMethodBeat.i(94802);
    this.EUK = paramBoolean;
    Object localObject = new d.a();
    ((d.a)localObject).lBU = new ebo();
    ((d.a)localObject).lBV = new ebp();
    ((d.a)localObject).uri = "/cgi-bin/micromsg-bin/searchcontact";
    ((d.a)localObject).funcId = 106;
    ((d.a)localObject).lBW = 34;
    ((d.a)localObject).respCmdId = 1000000034;
    this.rr = ((d.a)localObject).bgN();
    Log.d("MicroMsg.NetSceneSearchContact", "search username [%s], scene [%s]", new Object[] { paramString, Integer.valueOf(paramInt2) });
    localObject = (ebo)d.b.b(this.rr.lBR);
    ((ebo)localObject).SrH = new eaf().btQ(paramString);
    ((ebo)localObject).TUY = paramInt1;
    ((ebo)localObject).Ugu = paramInt2;
    AppMethodBeat.o(94802);
  }
  
  public final int doScene(com.tencent.mm.network.g paramg, i parami)
  {
    AppMethodBeat.i(94803);
    this.callback = parami;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(94803);
    return i;
  }
  
  public final ebp eRV()
  {
    AppMethodBeat.i(94805);
    ebp localebp = (ebp)d.c.b(this.rr.lBS);
    if (localebp != null)
    {
      Iterator localIterator = localebp.Tdk.iterator();
      while (localIterator.hasNext())
      {
        ebn localebn = (ebn)localIterator.next();
        a.bBt().bcn().nG(localebn.SrH.Ufy, localebn.Tav);
      }
    }
    AppMethodBeat.o(94805);
    return localebp;
  }
  
  public final int getType()
  {
    return 106;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(94804);
    params = (ebp)d.c.b(this.rr.lBS);
    if ((params != null) && (params.Tdj > 0)) {
      paramArrayOfByte = params.Tdk.iterator();
    }
    Object localObject;
    while (paramArrayOfByte.hasNext())
    {
      localObject = (ebn)paramArrayOfByte.next();
      Log.d("MicroMsg.NetSceneSearchContact", "search RES username [%s]", new Object[] { ((ebn)localObject).SrH });
      j localj = new j();
      localj.username = z.a(((ebn)localObject).SrH);
      localj.lBe = ((ebn)localObject).SjI;
      localj.lBd = ((ebn)localObject).SjJ;
      localj.cUP = -1;
      Log.d("MicroMsg.NetSceneSearchContact", "dkhurl search %s b[%s] s[%s]", new Object[] { localj.getUsername(), localj.bhH(), localj.bhI() });
      localj.hDc = 3;
      localj.gg(true);
      com.tencent.mm.am.q.bhP().b(localj);
      continue;
      if ((params != null) && (!Util.isNullOrNil(z.a(params.SrH))))
      {
        paramArrayOfByte = z.a(params.SrH);
        localObject = new j();
        ((j)localObject).username = paramArrayOfByte;
        ((j)localObject).lBe = params.SjI;
        ((j)localObject).lBd = params.SjJ;
        ((j)localObject).cUP = -1;
        Log.d("MicroMsg.NetSceneSearchContact", "dkhurl search %s b[%s] s[%s]", new Object[] { ((j)localObject).getUsername(), ((j)localObject).bhH(), ((j)localObject).bhI() });
        ((j)localObject).hDc = 3;
        ((j)localObject).gg(true);
        com.tencent.mm.am.q.bhP().b((j)localObject);
      }
    }
    if (params != null)
    {
      params = params.Ugz.iterator();
      while (params.hasNext())
      {
        paramArrayOfByte = (ecg)params.next();
        localObject = new j();
        ((j)localObject).username = paramArrayOfByte.UserName;
        ((j)localObject).lBe = paramArrayOfByte.SjI;
        ((j)localObject).lBd = paramArrayOfByte.SjJ;
        ((j)localObject).cUP = -1;
        Log.d("MicroMsg.NetSceneSearchContact", "dkhurl search %s b[%s] s[%s]", new Object[] { ((j)localObject).getUsername(), ((j)localObject).bhH(), ((j)localObject).bhI() });
        ((j)localObject).hDc = 3;
        ((j)localObject).gg(true);
        com.tencent.mm.am.q.bhP().b((j)localObject);
      }
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(94804);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.messenger.a.f
 * JD-Core Version:    0.7.0.1
 */