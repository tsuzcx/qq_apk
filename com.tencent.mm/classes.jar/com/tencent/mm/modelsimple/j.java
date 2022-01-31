package com.tencent.mm.modelsimple;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.aff;
import com.tencent.mm.protocal.protobuf.afg;
import com.tencent.mm.protocal.protobuf.avl;
import com.tencent.mm.protocal.protobuf.bwc;
import com.tencent.mm.protocal.protobuf.ls;
import com.tencent.mm.protocal.protobuf.wi;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class j
  extends m
  implements k
{
  private f callback;
  public final b rr;
  public Object tag;
  
  private j()
  {
    AppMethodBeat.i(78571);
    this.rr = j.a.d(j.a.a(j.a.a.fOO));
    AppMethodBeat.o(78571);
  }
  
  public j(int paramInt1, int paramInt2)
  {
    this();
    AppMethodBeat.i(78578);
    aff localaff = (aff)this.rr.fsV.fta;
    localaff.OpCode = 3;
    localaff.Scene = 5;
    localaff.wYe = paramInt1;
    localaff.wYi = paramInt2;
    ab.d("MicroMsg.NetSceneGetA8Key", "dkwt geta8key friendQQNum:%d  a2key-len:%d requestId", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(localaff.wrT.getILen()), Integer.valueOf(paramInt2) });
    AppMethodBeat.o(78578);
  }
  
  private j(j.a.a parama)
  {
    AppMethodBeat.i(78573);
    this.rr = j.a.a(parama);
    AppMethodBeat.o(78573);
  }
  
  private j(String paramString, int paramInt)
  {
    AppMethodBeat.i(78572);
    j.a.a locala2 = j.a.a.fON;
    j.a.a locala1 = locala2;
    if (locala2 == j.a.a.fON) {
      locala1 = j.a.aa(paramString, paramInt);
    }
    ab.i("MicroMsg.NetSceneGetA8Key", "getCommReqRespFromReqUrl reqUrl=%s, type=%s, reason=%d", new Object[] { paramString, locala1, Integer.valueOf(paramInt) });
    this.rr = j.a.d(j.a.a(locala1));
    AppMethodBeat.o(78572);
  }
  
  public j(String paramString1, int paramInt1, int paramInt2, int paramInt3, String paramString2, int paramInt4, byte[] paramArrayOfByte)
  {
    this(paramString1, 0);
    AppMethodBeat.i(78576);
    aff localaff = (aff)this.rr.fsV.fta;
    localaff.OpCode = 2;
    localaff.wYc = new bwc().aoF(paramString1);
    localaff.Scene = paramInt1;
    localaff.jJA = null;
    localaff.wsD = 0;
    localaff.wJM = paramInt2;
    localaff.wJN = paramInt3;
    localaff.wYi = paramInt4;
    localaff.wXZ = new bwc().aoF(paramString2);
    localaff.wYl = new SKBuiltinBuffer_t().setBuffer(paramArrayOfByte);
    ab.d("MicroMsg.NetSceneGetA8Key", "get a8key reqUrl = " + paramString1 + ", username = " + null + ", scene = " + paramInt1 + ", reason = 0, codeType = " + paramInt2 + ", codeVersion = " + paramInt3 + ", requestId = " + paramInt4);
    ab.d("MicroMsg.NetSceneGetA8Key", "a8KeyCookie = %s", new Object[] { bo.cg(paramArrayOfByte) });
    AppMethodBeat.o(78576);
  }
  
  public j(String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, String paramString3, int paramInt4, String paramString4, String paramString5, int paramInt5, byte[] paramArrayOfByte)
  {
    this(paramString1, paramInt2);
    AppMethodBeat.i(78577);
    aff localaff = (aff)this.rr.fsV.fta;
    localaff.OpCode = 2;
    localaff.wYc = new bwc().aoF(paramString1);
    localaff.Scene = paramInt1;
    localaff.jJA = paramString2;
    localaff.wsD = paramInt2;
    localaff.woE = paramInt3;
    localaff.wuH = paramString3;
    localaff.wYi = paramInt4;
    localaff.wYj = paramString5;
    localaff.wYk = paramInt5;
    localaff.wXZ = new bwc().aoF(paramString4);
    localaff.wYl = new SKBuiltinBuffer_t().setBuffer(paramArrayOfByte);
    ab.i("MicroMsg.NetSceneGetA8Key", "get a8key reqUrl = %s, username = %s, scene = %d, reason = %d, flag = %d, netType = %s, requestId = %d, appId = %s, functionId = %s, wallentRegion = %d, a8KeyCookie = %s", new Object[] { paramString1, paramString2, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString3, Integer.valueOf(paramInt4), paramString4, paramString5, Integer.valueOf(paramInt5), bo.cg(paramArrayOfByte) });
    AppMethodBeat.o(78577);
  }
  
  public j(String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, byte[] paramArrayOfByte)
  {
    this(paramString1, paramInt2);
    AppMethodBeat.i(78575);
    aff localaff = (aff)this.rr.fsV.fta;
    localaff.OpCode = 2;
    localaff.wYc = new bwc().aoF(paramString1);
    localaff.Scene = paramInt1;
    localaff.jJA = paramString2;
    localaff.wsD = paramInt2;
    localaff.wYi = paramInt3;
    localaff.wYl = new SKBuiltinBuffer_t().setBuffer(paramArrayOfByte);
    ab.d("MicroMsg.NetSceneGetA8Key", "get a8key reqUrl = " + paramString1 + ", username = " + paramString2 + ", scene = " + paramInt1 + ", reason = " + paramInt2 + ", requestId = " + paramInt3);
    ab.d("MicroMsg.NetSceneGetA8Key", "a8KeyCookie = %s", new Object[] { bo.cg(paramArrayOfByte) });
    AppMethodBeat.o(78575);
  }
  
  public j(String paramString1, String paramString2, String paramString3, int paramInt)
  {
    this(j.a.a.fOP);
    AppMethodBeat.i(78574);
    aff localaff = (aff)this.rr.fsV.fta;
    localaff.OpCode = 1;
    localaff.wXZ = new bwc().aoF(paramString1);
    localaff.wYa = new bwc().aoF(paramString2);
    localaff.wYb = new bwc().aoF(paramString3);
    localaff.wYi = paramInt;
    ab.d("MicroMsg.NetSceneGetA8Key", "get a8key appid=%s requestId=%d", new Object[] { paramString1, Integer.valueOf(paramInt) });
    AppMethodBeat.o(78574);
  }
  
  public static final int aju()
  {
    AppMethodBeat.i(151568);
    int i = (int)System.currentTimeMillis();
    AppMethodBeat.o(151568);
    return i;
  }
  
  public final String ajl()
  {
    return ((afg)this.rr.fsW.fta).wYn;
  }
  
  public final String ajm()
  {
    bwc localbwc = ((aff)this.rr.fsV.fta).wYc;
    if (localbwc != null) {
      return localbwc.xJE;
    }
    return null;
  }
  
  public final int ajn()
  {
    return ((afg)this.rr.fsW.fta).wld;
  }
  
  public final byte[] ajo()
  {
    AppMethodBeat.i(78581);
    Object localObject = (afg)this.rr.fsW.fta;
    if (((afg)localObject).wYw == null)
    {
      AppMethodBeat.o(78581);
      return null;
    }
    try
    {
      localObject = aa.a(((afg)localObject).wYw);
      AppMethodBeat.o(78581);
      return localObject;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(78581);
    }
    return null;
  }
  
  public final String ajp()
  {
    return ((afg)this.rr.fsW.fta).wYr;
  }
  
  public final ArrayList<byte[]> ajq()
  {
    AppMethodBeat.i(78582);
    Object localObject = (afg)this.rr.fsW.fta;
    ArrayList localArrayList = new ArrayList();
    if ((localObject == null) || (((afg)localObject).wYt == null))
    {
      AppMethodBeat.o(78582);
      return localArrayList;
    }
    localObject = ((afg)localObject).wYt.iterator();
    while (((Iterator)localObject).hasNext())
    {
      ls localls = (ls)((Iterator)localObject).next();
      try
      {
        localArrayList.add(localls.toByteArray());
      }
      catch (IOException localIOException)
      {
        ab.e("MicroMsg.NetSceneGetA8Key", "exception:%s", new Object[] { bo.l(localIOException) });
      }
    }
    ab.d("MicroMsg.NetSceneGetA8Key", "ScopeList size = %s", new Object[] { Integer.valueOf(localArrayList.size()) });
    AppMethodBeat.o(78582);
    return localArrayList;
  }
  
  public final long ajr()
  {
    afg localafg = (afg)this.rr.fsW.fta;
    if (localafg.wYv != null) {
      return localafg.wYv.wOR;
    }
    return -1L;
  }
  
  public final List<avl> ajs()
  {
    return ((afg)this.rr.fsW.fta).wYy;
  }
  
  public final int ajt()
  {
    return ((aff)this.rr.fsV.fta).wYi;
  }
  
  public final byte[] ajv()
  {
    AppMethodBeat.i(78583);
    Object localObject = (afg)this.rr.fsW.fta;
    if (((afg)localObject).wYl == null)
    {
      AppMethodBeat.o(78583);
      return new byte[0];
    }
    try
    {
      localObject = aa.a(((afg)localObject).wYl);
      AppMethodBeat.o(78583);
      return localObject;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(78583);
    }
    return new byte[0];
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(78579);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(78579);
    return i;
  }
  
  public final String getContent()
  {
    return ((afg)this.rr.fsW.fta).ntu;
  }
  
  public final String getTitle()
  {
    return ((afg)this.rr.fsW.fta).Title;
  }
  
  public final int getType()
  {
    return 233;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(78580);
    ab.d("MicroMsg.NetSceneGetA8Key", "dkwt geta8key onGYNetEnd:[%d,%d] url:[%s]  a8key:[%s]", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), ajl(), ((afg)this.rr.fsW.fta).wYo });
    ab.d("MicroMsg.NetSceneGetA8Key", "a8KeyCookie:%s", new Object[] { bo.cg(ajv()) });
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(78580);
  }
  
  public final void setSubScene(int paramInt)
  {
    ((aff)this.rr.fsV.fta).wqO = paramInt;
  }
  
  public final void uo(String paramString)
  {
    ((aff)this.rr.fsV.fta).wYm = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.modelsimple.j
 * JD-Core Version:    0.7.0.1
 */