package com.tencent.mm.modelsimple;

import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.protocal.c.aan;
import com.tencent.mm.protocal.c.aao;
import com.tencent.mm.protocal.c.apm;
import com.tencent.mm.protocal.c.bmk;
import com.tencent.mm.protocal.c.bml;
import com.tencent.mm.protocal.c.jn;
import com.tencent.mm.protocal.c.sj;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class h
  extends m
  implements k
{
  public final b dmK;
  private f dmL;
  public Object tag;
  
  private h()
  {
    this.dmK = h.a.d(h.a.a(h.a.a.eyZ));
  }
  
  public h(int paramInt1, int paramInt2)
  {
    this();
    aan localaan = (aan)this.dmK.ecE.ecN;
    localaan.ssq = 3;
    localaan.pyo = 5;
    localaan.sZL = paramInt1;
    localaan.sZR = paramInt2;
    y.d("MicroMsg.NetSceneGetA8Key", "dkwt geta8key friendQQNum:%d  a2key-len:%d requestId", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(localaan.syq.tFK), Integer.valueOf(paramInt2) });
  }
  
  private h(h.a.a parama)
  {
    this.dmK = h.a.a(parama);
  }
  
  private h(String paramString, int paramInt)
  {
    h.a.a locala2 = h.a.a.eyY;
    h.a.a locala1 = locala2;
    if (locala2 == h.a.a.eyY) {
      locala1 = h.a.S(paramString, paramInt);
    }
    y.i("MicroMsg.NetSceneGetA8Key", "getCommReqRespFromReqUrl reqUrl=%s, type=%s, reason=%d", new Object[] { paramString, locala1, Integer.valueOf(paramInt) });
    this.dmK = h.a.d(h.a.a(locala1));
  }
  
  public h(String paramString1, int paramInt1, int paramInt2, int paramInt3, String paramString2, int paramInt4, byte[] paramArrayOfByte)
  {
    this(paramString1, 0);
    aan localaan = (aan)this.dmK.ecE.ecN;
    localaan.ssq = 2;
    localaan.sZJ = new bml().YI(paramString1);
    localaan.pyo = paramInt1;
    localaan.hPY = null;
    localaan.sZO = 0;
    localaan.sLZ = paramInt2;
    localaan.sMa = paramInt3;
    localaan.sZR = paramInt4;
    localaan.sZG = new bml().YI(paramString2);
    localaan.sZU = new bmk().bs(paramArrayOfByte);
    y.d("MicroMsg.NetSceneGetA8Key", "get a8key reqUrl = " + paramString1 + ", username = " + null + ", scene = " + paramInt1 + ", reason = 0, codeType = " + paramInt2 + ", codeVersion = " + paramInt3 + ", requestId = " + paramInt4);
    y.d("MicroMsg.NetSceneGetA8Key", "a8KeyCookie = %s", new Object[] { bk.bG(paramArrayOfByte) });
  }
  
  public h(String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, String paramString3, int paramInt4, String paramString4, String paramString5, int paramInt5, byte[] paramArrayOfByte)
  {
    this(paramString1, paramInt2);
    aan localaan = (aan)this.dmK.ecE.ecN;
    localaan.ssq = 2;
    localaan.sZJ = new bml().YI(paramString1);
    localaan.pyo = paramInt1;
    localaan.hPY = paramString2;
    localaan.sZO = paramInt2;
    localaan.svx = paramInt3;
    localaan.sZQ = paramString3;
    localaan.sZR = paramInt4;
    localaan.sZS = paramString5;
    localaan.sZT = paramInt5;
    localaan.sZG = new bml().YI(paramString4);
    localaan.sZU = new bmk().bs(paramArrayOfByte);
    y.i("MicroMsg.NetSceneGetA8Key", "get a8key reqUrl = %s, username = %s, scene = %d, reason = %d, flag = %d, netType = %s, requestId = %d, appId = %s, functionId = %s, wallentRegion = %d, a8KeyCookie = %s", new Object[] { paramString1, paramString2, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString3, Integer.valueOf(paramInt4), paramString4, paramString5, Integer.valueOf(paramInt5), bk.bG(paramArrayOfByte) });
  }
  
  public h(String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, byte[] paramArrayOfByte)
  {
    this(paramString1, paramInt2);
    aan localaan = (aan)this.dmK.ecE.ecN;
    localaan.ssq = 2;
    localaan.sZJ = new bml().YI(paramString1);
    localaan.pyo = paramInt1;
    localaan.hPY = paramString2;
    localaan.sZO = paramInt2;
    localaan.sZR = paramInt3;
    localaan.sZU = new bmk().bs(paramArrayOfByte);
    y.d("MicroMsg.NetSceneGetA8Key", "get a8key reqUrl = " + paramString1 + ", username = " + paramString2 + ", scene = " + paramInt1 + ", reason = " + paramInt2 + ", requestId = " + paramInt3);
    y.d("MicroMsg.NetSceneGetA8Key", "a8KeyCookie = %s", new Object[] { bk.bG(paramArrayOfByte) });
  }
  
  public h(String paramString1, String paramString2, String paramString3, int paramInt)
  {
    this(h.a.a.eza);
    aan localaan = (aan)this.dmK.ecE.ecN;
    localaan.ssq = 1;
    localaan.sZG = new bml().YI(paramString1);
    localaan.sZH = new bml().YI(paramString2);
    localaan.sZI = new bml().YI(paramString3);
    localaan.sZR = paramInt;
    y.d("MicroMsg.NetSceneGetA8Key", "get a8key appid=%s requestId=%d", new Object[] { paramString1, Integer.valueOf(paramInt) });
  }
  
  public final String Qf()
  {
    return ((aao)this.dmK.ecF.ecN).sZV;
  }
  
  public final String Qg()
  {
    bml localbml = ((aan)this.dmK.ecE.ecN).sZJ;
    if (localbml != null) {
      return localbml.tFO;
    }
    return null;
  }
  
  public final int Qh()
  {
    return ((aao)this.dmK.ecF.ecN).ssy;
  }
  
  public final byte[] Qi()
  {
    Object localObject = (aao)this.dmK.ecF.ecN;
    if (((aao)localObject).tae == null) {
      return null;
    }
    try
    {
      localObject = aa.a(((aao)localObject).tae);
      return localObject;
    }
    catch (Exception localException) {}
    return null;
  }
  
  public final String Qj()
  {
    return ((aao)this.dmK.ecF.ecN).sZZ;
  }
  
  public final ArrayList<byte[]> Qk()
  {
    Object localObject = (aao)this.dmK.ecF.ecN;
    ArrayList localArrayList = new ArrayList();
    if ((localObject == null) || (((aao)localObject).tab == null)) {
      return localArrayList;
    }
    localObject = ((aao)localObject).tab.iterator();
    while (((Iterator)localObject).hasNext())
    {
      jn localjn = (jn)((Iterator)localObject).next();
      try
      {
        localArrayList.add(localjn.toByteArray());
      }
      catch (IOException localIOException)
      {
        y.e("MicroMsg.NetSceneGetA8Key", "exception:%s", new Object[] { bk.j(localIOException) });
      }
    }
    y.d("MicroMsg.NetSceneGetA8Key", "ScopeList size = %s", new Object[] { Integer.valueOf(localArrayList.size()) });
    return localArrayList;
  }
  
  public final long Ql()
  {
    aao localaao = (aao)this.dmK.ecF.ecN;
    if (localaao.tad != null) {
      return localaao.tad.sQq;
    }
    return -1L;
  }
  
  public final List<apm> Qm()
  {
    return ((aao)this.dmK.ecF.ecN).tah;
  }
  
  public final int Qn()
  {
    return ((aan)this.dmK.ecE.ecN).sZR;
  }
  
  public final byte[] Qo()
  {
    Object localObject = (aao)this.dmK.ecF.ecN;
    if (((aao)localObject).sZU == null) {
      return new byte[0];
    }
    try
    {
      localObject = aa.a(((aao)localObject).sZU);
      return localObject;
    }
    catch (Exception localException) {}
    return new byte[0];
  }
  
  public final int a(e parame, f paramf)
  {
    this.dmL = paramf;
    return a(parame, this.dmK, this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    y.d("MicroMsg.NetSceneGetA8Key", "dkwt geta8key onGYNetEnd:[%d,%d] url:[%s]  a8key:[%s]", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Qf(), ((aao)this.dmK.ecF.ecN).sZW });
    y.d("MicroMsg.NetSceneGetA8Key", "a8KeyCookie:%s", new Object[] { bk.bG(Qo()) });
    this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
  }
  
  public final String getContent()
  {
    return ((aao)this.dmK.ecF.ecN).kVs;
  }
  
  public final String getTitle()
  {
    return ((aao)this.dmK.ecF.ecN).bGw;
  }
  
  public final int getType()
  {
    return 233;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.modelsimple.h
 * JD-Core Version:    0.7.0.1
 */