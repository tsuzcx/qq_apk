package com.tencent.mm.modelsimple;

import android.net.Uri;
import android.os.Bundle;
import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.acv;
import com.tencent.mm.protocal.protobuf.avy;
import com.tencent.mm.protocal.protobuf.avz;
import com.tencent.mm.protocal.protobuf.bpk;
import com.tencent.mm.protocal.protobuf.cxn;
import com.tencent.mm.protocal.protobuf.pa;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class l
  extends n
  implements k
{
  private f callback;
  private final long inZ;
  private final long ioa;
  public final Bundle iob;
  public final b rr;
  public Object tag;
  
  private l()
  {
    AppMethodBeat.i(150923);
    this.inZ = SystemClock.elapsedRealtime();
    this.ioa = System.currentTimeMillis();
    this.iob = new Bundle();
    this.rr = a.f(a.a(l.a.a.ioe));
    AppMethodBeat.o(150923);
  }
  
  public l(int paramInt1, int paramInt2)
  {
    this();
    AppMethodBeat.i(150930);
    avy localavy = (avy)this.rr.hQD.hQJ;
    localavy.OpCode = 3;
    localavy.Scene = 5;
    localavy.GNu = paramInt1;
    localavy.GNx = paramInt2;
    ae.d("MicroMsg.NetSceneGetA8Key", "dkwt geta8key friendQQNum:%d  a2key-len:%d requestId", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(localavy.FRA.getILen()), Integer.valueOf(paramInt2) });
    AppMethodBeat.o(150930);
  }
  
  private l(l.a.a parama)
  {
    AppMethodBeat.i(150925);
    this.inZ = SystemClock.elapsedRealtime();
    this.ioa = System.currentTimeMillis();
    this.iob = new Bundle();
    this.rr = a.a(parama);
    AppMethodBeat.o(150925);
  }
  
  private l(String paramString, int paramInt)
  {
    AppMethodBeat.i(150924);
    this.inZ = SystemClock.elapsedRealtime();
    this.ioa = System.currentTimeMillis();
    this.iob = new Bundle();
    this.rr = a.ap(paramString, paramInt);
    AppMethodBeat.o(150924);
  }
  
  public l(String paramString1, int paramInt1, int paramInt2, int paramInt3, String paramString2, int paramInt4, byte[] paramArrayOfByte)
  {
    this(paramString1, 0);
    AppMethodBeat.i(150928);
    avy localavy = (avy)this.rr.hQD.hQJ;
    localavy.OpCode = 2;
    localavy.GNs = new cxn().aQV(paramString1);
    localavy.Scene = paramInt1;
    localavy.nIJ = null;
    localavy.FSu = 0;
    localavy.Goq = paramInt2;
    localavy.Gor = paramInt3;
    localavy.GNx = paramInt4;
    localavy.GNp = new cxn().aQV(paramString2);
    localavy.GNA = new SKBuiltinBuffer_t().setBuffer(paramArrayOfByte);
    ae.d("MicroMsg.NetSceneGetA8Key", "get a8key reqUrl = " + paramString1 + ", username = " + null + ", scene = " + paramInt1 + ", reason = 0, codeType = " + paramInt2 + ", codeVersion = " + paramInt3 + ", requestId = " + paramInt4);
    ae.d("MicroMsg.NetSceneGetA8Key", "a8KeyCookie = %s", new Object[] { bu.cH(paramArrayOfByte) });
    AppMethodBeat.o(150928);
  }
  
  public l(String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, String paramString3, int paramInt4, String paramString4, String paramString5, int paramInt5, byte[] paramArrayOfByte)
  {
    this(paramString1, paramInt2);
    AppMethodBeat.i(150929);
    avy localavy = (avy)this.rr.hQD.hQJ;
    localavy.OpCode = 2;
    localavy.GNs = new cxn().aQV(paramString1);
    localavy.Scene = paramInt1;
    localavy.nIJ = paramString2;
    localavy.FSu = paramInt2;
    localavy.FNv = paramInt3;
    localavy.oxI = paramString3;
    localavy.GNx = paramInt4;
    localavy.GNy = paramString5;
    localavy.GNz = paramInt5;
    localavy.GNp = new cxn().aQV(paramString4);
    localavy.GNA = new SKBuiltinBuffer_t().setBuffer(paramArrayOfByte);
    ae.i("MicroMsg.NetSceneGetA8Key", "get a8key reqUrl = %s, username = %s, scene = %d, reason = %d, flag = %d, netType = %s, requestId = %d, appId = %s, functionId = %s, wallentRegion = %d, a8KeyCookie = %s", new Object[] { paramString1, paramString2, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString3, Integer.valueOf(paramInt4), paramString4, paramString5, Integer.valueOf(paramInt5), bu.cH(paramArrayOfByte) });
    AppMethodBeat.o(150929);
  }
  
  public l(String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, byte[] paramArrayOfByte)
  {
    this(paramString1, paramInt2);
    AppMethodBeat.i(150927);
    avy localavy = (avy)this.rr.hQD.hQJ;
    localavy.OpCode = 2;
    localavy.GNs = new cxn().aQV(paramString1);
    localavy.Scene = paramInt1;
    localavy.nIJ = paramString2;
    localavy.FSu = paramInt2;
    localavy.GNx = paramInt3;
    localavy.GNA = new SKBuiltinBuffer_t().setBuffer(paramArrayOfByte);
    ae.d("MicroMsg.NetSceneGetA8Key", "get a8key reqUrl = " + paramString1 + ", username = " + paramString2 + ", scene = " + paramInt1 + ", reason = " + paramInt2 + ", requestId = " + paramInt3);
    ae.d("MicroMsg.NetSceneGetA8Key", "a8KeyCookie = %s", new Object[] { bu.cH(paramArrayOfByte) });
    AppMethodBeat.o(150927);
  }
  
  public l(String paramString1, String paramString2, String paramString3, int paramInt)
  {
    this(l.a.a.iof);
    AppMethodBeat.i(150926);
    avy localavy = (avy)this.rr.hQD.hQJ;
    localavy.OpCode = 1;
    localavy.GNp = new cxn().aQV(paramString1);
    localavy.GNq = new cxn().aQV(paramString2);
    localavy.GNr = new cxn().aQV(paramString3);
    localavy.GNx = paramInt;
    ae.d("MicroMsg.NetSceneGetA8Key", "get a8key appid=%s requestId=%d", new Object[] { paramString1, Integer.valueOf(paramInt) });
    AppMethodBeat.o(150926);
  }
  
  public static final int aKX()
  {
    AppMethodBeat.i(150935);
    int i = (int)System.currentTimeMillis();
    AppMethodBeat.o(150935);
    return i;
  }
  
  public final void GN(String paramString)
  {
    ((avy)this.rr.hQD.hQJ).GMZ = paramString;
  }
  
  public final String aKO()
  {
    return ((avz)this.rr.hQE.hQJ).GNB;
  }
  
  public final String aKP()
  {
    cxn localcxn = ((avy)this.rr.hQD.hQJ).GNs;
    if (localcxn != null) {
      return localcxn.HId;
    }
    return null;
  }
  
  public final int aKQ()
  {
    return ((avz)this.rr.hQE.hQJ).FJl;
  }
  
  public final byte[] aKR()
  {
    AppMethodBeat.i(150933);
    Object localObject = (avz)this.rr.hQE.hQJ;
    if (((avz)localObject).GNK == null)
    {
      AppMethodBeat.o(150933);
      return null;
    }
    try
    {
      localObject = z.a(((avz)localObject).GNK);
      AppMethodBeat.o(150933);
      return localObject;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(150933);
    }
    return null;
  }
  
  public final String aKS()
  {
    return ((avz)this.rr.hQE.hQJ).GNF;
  }
  
  public final ArrayList<byte[]> aKT()
  {
    AppMethodBeat.i(150934);
    Object localObject = (avz)this.rr.hQE.hQJ;
    ArrayList localArrayList = new ArrayList();
    if ((localObject == null) || (((avz)localObject).GNH == null))
    {
      AppMethodBeat.o(150934);
      return localArrayList;
    }
    localObject = ((avz)localObject).GNH.iterator();
    while (((Iterator)localObject).hasNext())
    {
      pa localpa = (pa)((Iterator)localObject).next();
      try
      {
        localArrayList.add(localpa.toByteArray());
      }
      catch (IOException localIOException)
      {
        ae.e("MicroMsg.NetSceneGetA8Key", "exception:%s", new Object[] { bu.o(localIOException) });
      }
    }
    ae.d("MicroMsg.NetSceneGetA8Key", "ScopeList size = %s", new Object[] { Integer.valueOf(localArrayList.size()) });
    AppMethodBeat.o(150934);
    return localArrayList;
  }
  
  public final long aKU()
  {
    avz localavz = (avz)this.rr.hQE.hQJ;
    if (localavz.GNJ != null) {
      return localavz.GNJ.GuD;
    }
    return -1L;
  }
  
  public final List<bpk> aKV()
  {
    return ((avz)this.rr.hQE.hQJ).GNl;
  }
  
  public final int aKW()
  {
    return ((avy)this.rr.hQD.hQJ).GNx;
  }
  
  public final byte[] aKY()
  {
    AppMethodBeat.i(150936);
    Object localObject = (avz)this.rr.hQE.hQJ;
    if (((avz)localObject).GNA == null)
    {
      AppMethodBeat.o(150936);
      return new byte[0];
    }
    try
    {
      localObject = z.a(((avz)localObject).GNA);
      AppMethodBeat.o(150936);
      return localObject;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(150936);
    }
    return new byte[0];
  }
  
  public final int doScene(com.tencent.mm.network.e parame, f paramf)
  {
    AppMethodBeat.i(150931);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(150931);
    return i;
  }
  
  public final String getContent()
  {
    return ((avz)this.rr.hQE.hQJ).hFS;
  }
  
  public final String getTitle()
  {
    return ((avz)this.rr.hQE.hQJ).Title;
  }
  
  public final int getType()
  {
    return 233;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(150932);
    ae.d("MicroMsg.NetSceneGetA8Key", "dkwt geta8key onGYNetEnd:[%d,%d] url:[%s]  a8key:[%s]", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), aKO(), ((avz)this.rr.hQE.hQJ).GNC });
    ae.d("MicroMsg.NetSceneGetA8Key", "a8KeyCookie:%s", new Object[] { bu.cH(aKY()) });
    this.iob.putLong("CgiSpeedOutSideStructStartTimeStamp", this.ioa);
    this.iob.putLong("CgiSpeedOutSideStructEndTimeStamp", System.currentTimeMillis());
    this.iob.putLong("CgiSpeedOutSideStructCostTime", SystemClock.elapsedRealtime() - this.inZ);
    this.iob.putInt("CgiSpeedOutSideStructCgiNo", 233);
    this.iob.putInt("CgiSpeedOutSideStructRet", paramInt3);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(150932);
  }
  
  public final void setSubScene(int paramInt)
  {
    ((avy)this.rr.hQD.hQJ).FQm = paramInt;
  }
  
  public static final class a
  {
    static b a(a parama)
    {
      AppMethodBeat.i(150920);
      b.a locala = new b.a();
      locala.hQF = new avy();
      locala.hQG = new avz();
      switch (l.1.ioc[parama.ordinal()])
      {
      default: 
        locala.uri = "/cgi-bin/micromsg-bin/3rd-geta8key";
        locala.funcId = 226;
        locala.hQH = 388;
        locala.respCmdId = 1000000388;
      }
      for (;;)
      {
        parama = locala.aDS();
        AppMethodBeat.o(150920);
        return parama;
        locala.uri = "/cgi-bin/micromsg-bin/geta8key";
        locala.funcId = 233;
        locala.hQH = 155;
        locala.respCmdId = 1000000155;
        continue;
        locala.uri = "/cgi-bin/micromsg-bin/mp-geta8key";
        locala.funcId = 238;
        locala.hQH = 345;
        locala.respCmdId = 1000000345;
        continue;
        locala.uri = "/cgi-bin/micromsg-bin/pay-geta8key";
        locala.funcId = 835;
        locala.hQH = 346;
        locala.respCmdId = 1000000346;
        continue;
        locala.uri = "/cgi-bin/micromsg-bin/minor-geta8key";
        locala.funcId = 812;
        locala.hQH = 387;
        locala.respCmdId = 1000000387;
        continue;
        locala.uri = "/cgi-bin/micromsg-bin/3rd-geta8key";
        locala.funcId = 226;
        locala.hQH = 388;
        locala.respCmdId = 1000000388;
      }
    }
    
    private static b a(a parama, String paramString, int paramInt)
    {
      AppMethodBeat.i(218741);
      a locala = parama;
      if (parama == a.iod) {
        locala = aq(paramString, paramInt);
      }
      ae.i("MicroMsg.NetSceneGetA8Key", "getCommReqRespFromReqUrl reqUrl=%s, type=%s, reason=%d", new Object[] { paramString, locala, Integer.valueOf(paramInt) });
      parama = f(a(locala));
      AppMethodBeat.o(218741);
      return parama;
    }
    
    public static b ap(String paramString, int paramInt)
    {
      AppMethodBeat.i(218742);
      paramString = a(a.iod, paramString, paramInt);
      AppMethodBeat.o(218742);
      return paramString;
    }
    
    private static a aq(String paramString, int paramInt)
    {
      AppMethodBeat.i(150921);
      if (paramInt == 5)
      {
        paramString = a.ioh;
        AppMethodBeat.o(150921);
        return paramString;
      }
      if (bu.isNullOrNil(paramString))
      {
        ae.i("MicroMsg.NetSceneGetA8Key", "getTypeFromUrl reqUrl is null, getA8Key");
        paramString = a.ioe;
        AppMethodBeat.o(150921);
        return paramString;
      }
      try
      {
        Object localObject = Uri.parse(paramString);
        if (localObject == null)
        {
          paramString = a.ioi;
          AppMethodBeat.o(150921);
          return paramString;
        }
        String str = bu.nullAsNil(((Uri)localObject).getHost()).toLowerCase();
        if (bu.isNullOrNil(((Uri)localObject).getFragment())) {}
        for (localObject = "";; localObject = "#" + ((Uri)localObject).getFragment())
        {
          ae.d("MicroMsg.NetSceneGetA8Key", "get TypeFromUrl domain:%s, fragment:%s", new Object[] { str, localObject });
          if ((!str.equals("open.weixin.qq.com")) && (!str.equals("mp.weixin.qq.com")) && (!str.equals("mp.weixinbridge.com"))) {
            break;
          }
          paramString = a.iof;
          AppMethodBeat.o(150921);
          return paramString;
        }
        if (((String)localObject).contains("wechat_pay"))
        {
          paramString = a.iog;
          AppMethodBeat.o(150921);
          return paramString;
        }
        if ((str.contains(".qq.com")) || (str.equals("qq.com")) || (str.contains(".wechat.com")) || (str.equals("wechat.com")) || (str.contains(".tenpay.com")) || (str.equals("tenpay.com")) || (str.contains(".url.cn")) || (str.equals("url.com")) || ((!paramString.startsWith("http://")) && (!paramString.startsWith("https://"))))
        {
          paramString = a.ioe;
          AppMethodBeat.o(150921);
          return paramString;
        }
        paramString = a.ioi;
        AppMethodBeat.o(150921);
        return paramString;
      }
      catch (Exception paramString)
      {
        ae.e("MicroMsg.NetSceneGetA8Key", "getTypeFromUrl parse uri fail %s", new Object[] { paramString.getMessage() });
        paramString = a.ioe;
        AppMethodBeat.o(150921);
      }
      return paramString;
    }
    
    public static b f(b paramb)
    {
      AppMethodBeat.i(150922);
      if ((ak.coh()) && (g.ajM()))
      {
        avy localavy = (avy)paramb.hQD.hQJ;
        g.ajS();
        String str1 = bu.nullAsNil((String)g.ajR().ajA().get(46, null));
        localavy.FRA = new SKBuiltinBuffer_t().setBuffer(bu.aSx(str1));
        g.ajS();
        String str2 = bu.nullAsNil((String)g.ajR().ajA().get(72, null));
        localavy.GNw = new SKBuiltinBuffer_t().setBuffer(bu.aSx(str2));
        ae.d("MicroMsg.NetSceneGetA8Key", "dkwt get a2=" + str1 + " newa2=" + str2);
      }
      AppMethodBeat.o(150922);
      return paramb;
    }
    
    public static enum a
    {
      static
      {
        AppMethodBeat.i(150919);
        iod = new a("AutoRoute", 0);
        ioe = new a("GetA8Key", 1);
        iof = new a("MpGetA8Key", 2);
        iog = new a("PayGetA8Key", 3);
        ioh = new a("MinorGetA8Key", 4);
        ioi = new a("ThridGetA8Key", 5);
        ioj = new a[] { iod, ioe, iof, iog, ioh, ioi };
        AppMethodBeat.o(150919);
      }
      
      private a() {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.modelsimple.l
 * JD-Core Version:    0.7.0.1
 */