package com.tencent.mm.plugin.messenger.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.modelavatar.j;
import com.tencent.mm.modelavatar.k;
import com.tencent.mm.modelavatar.q;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.platformtools.w;
import com.tencent.mm.plugin.c.a;
import com.tencent.mm.protocal.protobuf.etl;
import com.tencent.mm.protocal.protobuf.eve;
import com.tencent.mm.protocal.protobuf.evf;
import com.tencent.mm.protocal.protobuf.evg;
import com.tencent.mm.protocal.protobuf.evx;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Iterator;
import java.util.LinkedList;

public final class f
  extends p
  implements m
{
  public final boolean KPI;
  private h callback;
  public final c rr;
  
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
    this.KPI = paramBoolean;
    Object localObject = new c.a();
    ((c.a)localObject).otE = new evf();
    ((c.a)localObject).otF = new evg();
    ((c.a)localObject).uri = "/cgi-bin/micromsg-bin/searchcontact";
    ((c.a)localObject).funcId = 106;
    ((c.a)localObject).otG = 34;
    ((c.a)localObject).respCmdId = 1000000034;
    this.rr = ((c.a)localObject).bEF();
    Log.d("MicroMsg.NetSceneSearchContact", "search username [%s], scene [%s]", new Object[] { paramString, Integer.valueOf(paramInt2) });
    localObject = (evf)c.b.b(this.rr.otB);
    ((evf)localObject).ZqL = new etl().btH(paramString);
    ((evf)localObject).ZvF = paramInt1;
    ((evf)localObject).abxV = paramInt2;
    AppMethodBeat.o(94802);
  }
  
  public final int doScene(com.tencent.mm.network.g paramg, h paramh)
  {
    AppMethodBeat.i(94803);
    this.callback = paramh;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(94803);
    return i;
  }
  
  public final evg gaH()
  {
    AppMethodBeat.i(94805);
    evg localevg = (evg)c.c.b(this.rr.otC);
    if (localevg != null)
    {
      Iterator localIterator = localevg.aaqz.iterator();
      while (localIterator.hasNext())
      {
        eve localeve = (eve)localIterator.next();
        a.caJ().bAc().pE(localeve.ZqL.abwM, localeve.aant);
      }
    }
    AppMethodBeat.o(94805);
    return localevg;
  }
  
  public final int getType()
  {
    return 106;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(94804);
    params = (evg)c.c.b(this.rr.otC);
    if ((params != null) && (params.aaqy > 0)) {
      paramArrayOfByte = params.aaqz.iterator();
    }
    Object localObject;
    while (paramArrayOfByte.hasNext())
    {
      localObject = (eve)paramArrayOfByte.next();
      Log.d("MicroMsg.NetSceneSearchContact", "search RES username [%s]", new Object[] { ((eve)localObject).ZqL });
      j localj = new j();
      localj.username = w.a(((eve)localObject).ZqL);
      localj.osN = ((eve)localObject).ZhO;
      localj.osM = ((eve)localObject).ZhP;
      localj.eQp = -1;
      Log.d("MicroMsg.NetSceneSearchContact", "dkhurl search %s b[%s] s[%s]", new Object[] { localj.getUsername(), localj.bFw(), localj.bFx() });
      localj.jZY = 3;
      localj.gX(true);
      q.bFE().b(localj);
      continue;
      if ((params != null) && (!Util.isNullOrNil(w.a(params.ZqL))))
      {
        paramArrayOfByte = w.a(params.ZqL);
        localObject = new j();
        ((j)localObject).username = paramArrayOfByte;
        ((j)localObject).osN = params.ZhO;
        ((j)localObject).osM = params.ZhP;
        ((j)localObject).eQp = -1;
        Log.d("MicroMsg.NetSceneSearchContact", "dkhurl search %s b[%s] s[%s]", new Object[] { ((j)localObject).getUsername(), ((j)localObject).bFw(), ((j)localObject).bFx() });
        ((j)localObject).jZY = 3;
        ((j)localObject).gX(true);
        q.bFE().b((j)localObject);
      }
    }
    if (params != null)
    {
      params = params.abya.iterator();
      while (params.hasNext())
      {
        paramArrayOfByte = (evx)params.next();
        localObject = new j();
        ((j)localObject).username = paramArrayOfByte.UserName;
        ((j)localObject).osN = paramArrayOfByte.ZhO;
        ((j)localObject).osM = paramArrayOfByte.ZhP;
        ((j)localObject).eQp = -1;
        Log.d("MicroMsg.NetSceneSearchContact", "dkhurl search %s b[%s] s[%s]", new Object[] { ((j)localObject).getUsername(), ((j)localObject).bFw(), ((j)localObject).bFx() });
        ((j)localObject).jZY = 3;
        ((j)localObject).gX(true);
        q.bFE().b((j)localObject);
      }
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(94804);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.messenger.a.f
 * JD-Core Version:    0.7.0.1
 */