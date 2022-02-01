package com.tencent.mm.modelsimple;

import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.n;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.aoi;
import com.tencent.mm.protocal.protobuf.aoj;
import com.tencent.mm.protocal.protobuf.bgq;
import com.tencent.mm.protocal.protobuf.cmf;
import com.tencent.mm.protocal.protobuf.nm;
import com.tencent.mm.protocal.protobuf.zn;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class k
  extends n
  implements com.tencent.mm.network.k
{
  private com.tencent.mm.al.g callback;
  public final b rr;
  public Object tag;
  
  private k()
  {
    AppMethodBeat.i(150923);
    this.rr = a.f(a.a(k.a.a.hrs));
    AppMethodBeat.o(150923);
  }
  
  public k(int paramInt1, int paramInt2)
  {
    this();
    AppMethodBeat.i(150930);
    aoi localaoi = (aoi)this.rr.gUS.gUX;
    localaoi.OpCode = 3;
    localaoi.Scene = 5;
    localaoi.DpP = paramInt1;
    localaoi.DpS = paramInt2;
    ad.d("MicroMsg.NetSceneGetA8Key", "dkwt geta8key friendQQNum:%d  a2key-len:%d requestId", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(localaoi.CBk.getILen()), Integer.valueOf(paramInt2) });
    AppMethodBeat.o(150930);
  }
  
  private k(k.a.a parama)
  {
    AppMethodBeat.i(150925);
    this.rr = a.a(parama);
    AppMethodBeat.o(150925);
  }
  
  private k(String paramString, int paramInt)
  {
    AppMethodBeat.i(150924);
    this.rr = a.ai(paramString, paramInt);
    AppMethodBeat.o(150924);
  }
  
  public k(String paramString1, int paramInt1, int paramInt2, int paramInt3, String paramString2, int paramInt4, byte[] paramArrayOfByte)
  {
    this(paramString1, 0);
    AppMethodBeat.i(150928);
    aoi localaoi = (aoi)this.rr.gUS.gUX;
    localaoi.OpCode = 2;
    localaoi.DpN = new cmf().aEE(paramString1);
    localaoi.Scene = paramInt1;
    localaoi.mAQ = null;
    localaoi.CCe = 0;
    localaoi.CVW = paramInt2;
    localaoi.CVX = paramInt3;
    localaoi.DpS = paramInt4;
    localaoi.DpK = new cmf().aEE(paramString2);
    localaoi.DpV = new SKBuiltinBuffer_t().setBuffer(paramArrayOfByte);
    ad.d("MicroMsg.NetSceneGetA8Key", "get a8key reqUrl = " + paramString1 + ", username = " + null + ", scene = " + paramInt1 + ", reason = 0, codeType = " + paramInt2 + ", codeVersion = " + paramInt3 + ", requestId = " + paramInt4);
    ad.d("MicroMsg.NetSceneGetA8Key", "a8KeyCookie = %s", new Object[] { bt.cy(paramArrayOfByte) });
    AppMethodBeat.o(150928);
  }
  
  public k(String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, String paramString3, int paramInt4, String paramString4, String paramString5, int paramInt5, byte[] paramArrayOfByte)
  {
    this(paramString1, paramInt2);
    AppMethodBeat.i(150929);
    aoi localaoi = (aoi)this.rr.gUS.gUX;
    localaoi.OpCode = 2;
    localaoi.DpN = new cmf().aEE(paramString1);
    localaoi.Scene = paramInt1;
    localaoi.mAQ = paramString2;
    localaoi.CCe = paramInt2;
    localaoi.Cxm = paramInt3;
    localaoi.nlG = paramString3;
    localaoi.DpS = paramInt4;
    localaoi.DpT = paramString5;
    localaoi.DpU = paramInt5;
    localaoi.DpK = new cmf().aEE(paramString4);
    localaoi.DpV = new SKBuiltinBuffer_t().setBuffer(paramArrayOfByte);
    ad.i("MicroMsg.NetSceneGetA8Key", "get a8key reqUrl = %s, username = %s, scene = %d, reason = %d, flag = %d, netType = %s, requestId = %d, appId = %s, functionId = %s, wallentRegion = %d, a8KeyCookie = %s", new Object[] { paramString1, paramString2, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString3, Integer.valueOf(paramInt4), paramString4, paramString5, Integer.valueOf(paramInt5), bt.cy(paramArrayOfByte) });
    AppMethodBeat.o(150929);
  }
  
  public k(String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, byte[] paramArrayOfByte)
  {
    this(paramString1, paramInt2);
    AppMethodBeat.i(150927);
    aoi localaoi = (aoi)this.rr.gUS.gUX;
    localaoi.OpCode = 2;
    localaoi.DpN = new cmf().aEE(paramString1);
    localaoi.Scene = paramInt1;
    localaoi.mAQ = paramString2;
    localaoi.CCe = paramInt2;
    localaoi.DpS = paramInt3;
    localaoi.DpV = new SKBuiltinBuffer_t().setBuffer(paramArrayOfByte);
    ad.d("MicroMsg.NetSceneGetA8Key", "get a8key reqUrl = " + paramString1 + ", username = " + paramString2 + ", scene = " + paramInt1 + ", reason = " + paramInt2 + ", requestId = " + paramInt3);
    ad.d("MicroMsg.NetSceneGetA8Key", "a8KeyCookie = %s", new Object[] { bt.cy(paramArrayOfByte) });
    AppMethodBeat.o(150927);
  }
  
  public k(String paramString1, String paramString2, String paramString3, int paramInt)
  {
    this(k.a.a.hrt);
    AppMethodBeat.i(150926);
    aoi localaoi = (aoi)this.rr.gUS.gUX;
    localaoi.OpCode = 1;
    localaoi.DpK = new cmf().aEE(paramString1);
    localaoi.DpL = new cmf().aEE(paramString2);
    localaoi.DpM = new cmf().aEE(paramString3);
    localaoi.DpS = paramInt;
    ad.d("MicroMsg.NetSceneGetA8Key", "get a8key appid=%s requestId=%d", new Object[] { paramString1, Integer.valueOf(paramInt) });
    AppMethodBeat.o(150926);
  }
  
  public static final int aAz()
  {
    AppMethodBeat.i(150935);
    int i = (int)System.currentTimeMillis();
    AppMethodBeat.o(150935);
    return i;
  }
  
  public final byte[] aAA()
  {
    AppMethodBeat.i(150936);
    Object localObject = (aoj)this.rr.gUT.gUX;
    if (((aoj)localObject).DpV == null)
    {
      AppMethodBeat.o(150936);
      return new byte[0];
    }
    try
    {
      localObject = z.a(((aoj)localObject).DpV);
      AppMethodBeat.o(150936);
      return localObject;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(150936);
    }
    return new byte[0];
  }
  
  public final String aAq()
  {
    return ((aoj)this.rr.gUT.gUX).DpW;
  }
  
  public final String aAr()
  {
    cmf localcmf = ((aoi)this.rr.gUS.gUX).DpN;
    if (localcmf != null) {
      return localcmf.Ehn;
    }
    return null;
  }
  
  public final int aAs()
  {
    return ((aoj)this.rr.gUT.gUX).Ctr;
  }
  
  public final byte[] aAt()
  {
    AppMethodBeat.i(150933);
    Object localObject = (aoj)this.rr.gUT.gUX;
    if (((aoj)localObject).Dqf == null)
    {
      AppMethodBeat.o(150933);
      return null;
    }
    try
    {
      localObject = z.a(((aoj)localObject).Dqf);
      AppMethodBeat.o(150933);
      return localObject;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(150933);
    }
    return null;
  }
  
  public final String aAu()
  {
    return ((aoj)this.rr.gUT.gUX).Dqa;
  }
  
  public final ArrayList<byte[]> aAv()
  {
    AppMethodBeat.i(150934);
    Object localObject = (aoj)this.rr.gUT.gUX;
    ArrayList localArrayList = new ArrayList();
    if ((localObject == null) || (((aoj)localObject).Dqc == null))
    {
      AppMethodBeat.o(150934);
      return localArrayList;
    }
    localObject = ((aoj)localObject).Dqc.iterator();
    while (((Iterator)localObject).hasNext())
    {
      nm localnm = (nm)((Iterator)localObject).next();
      try
      {
        localArrayList.add(localnm.toByteArray());
      }
      catch (IOException localIOException)
      {
        ad.e("MicroMsg.NetSceneGetA8Key", "exception:%s", new Object[] { bt.m(localIOException) });
      }
    }
    ad.d("MicroMsg.NetSceneGetA8Key", "ScopeList size = %s", new Object[] { Integer.valueOf(localArrayList.size()) });
    AppMethodBeat.o(150934);
    return localArrayList;
  }
  
  public final long aAw()
  {
    aoj localaoj = (aoj)this.rr.gUT.gUX;
    if (localaoj.Dqe != null) {
      return localaoj.Dqe.Dbw;
    }
    return -1L;
  }
  
  public final List<bgq> aAx()
  {
    return ((aoj)this.rr.gUT.gUX).Dqh;
  }
  
  public final int aAy()
  {
    return ((aoi)this.rr.gUS.gUX).DpS;
  }
  
  public final int doScene(com.tencent.mm.network.e parame, com.tencent.mm.al.g paramg)
  {
    AppMethodBeat.i(150931);
    this.callback = paramg;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(150931);
    return i;
  }
  
  public final String getContent()
  {
    return ((aoj)this.rr.gUT.gUX).gKr;
  }
  
  public final String getTitle()
  {
    return ((aoj)this.rr.gUT.gUX).Title;
  }
  
  public final int getType()
  {
    return 233;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(150932);
    ad.d("MicroMsg.NetSceneGetA8Key", "dkwt geta8key onGYNetEnd:[%d,%d] url:[%s]  a8key:[%s]", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), aAq(), ((aoj)this.rr.gUT.gUX).DpX });
    ad.d("MicroMsg.NetSceneGetA8Key", "a8KeyCookie:%s", new Object[] { bt.cy(aAA()) });
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(150932);
  }
  
  public final void setSubScene(int paramInt)
  {
    ((aoi)this.rr.gUS.gUX).CzZ = paramInt;
  }
  
  public final void zb(String paramString)
  {
    ((aoi)this.rr.gUS.gUX).Dpx = paramString;
  }
  
  public static final class a
  {
    static b a(a parama)
    {
      AppMethodBeat.i(150920);
      b.a locala = new b.a();
      locala.gUU = new aoi();
      locala.gUV = new aoj();
      switch (k.1.hrq[parama.ordinal()])
      {
      default: 
        locala.uri = "/cgi-bin/micromsg-bin/3rd-geta8key";
        locala.funcId = 226;
        locala.reqCmdId = 388;
        locala.respCmdId = 1000000388;
      }
      for (;;)
      {
        parama = locala.atI();
        AppMethodBeat.o(150920);
        return parama;
        locala.uri = "/cgi-bin/micromsg-bin/geta8key";
        locala.funcId = 233;
        locala.reqCmdId = 155;
        locala.respCmdId = 1000000155;
        continue;
        locala.uri = "/cgi-bin/micromsg-bin/mp-geta8key";
        locala.funcId = 238;
        locala.reqCmdId = 345;
        locala.respCmdId = 1000000345;
        continue;
        locala.uri = "/cgi-bin/micromsg-bin/pay-geta8key";
        locala.funcId = 835;
        locala.reqCmdId = 346;
        locala.respCmdId = 1000000346;
        continue;
        locala.uri = "/cgi-bin/micromsg-bin/minor-geta8key";
        locala.funcId = 812;
        locala.reqCmdId = 387;
        locala.respCmdId = 1000000387;
        continue;
        locala.uri = "/cgi-bin/micromsg-bin/3rd-geta8key";
        locala.funcId = 226;
        locala.reqCmdId = 388;
        locala.respCmdId = 1000000388;
      }
    }
    
    private static b a(a parama, String paramString, int paramInt)
    {
      AppMethodBeat.i(190715);
      a locala = parama;
      if (parama == a.hrr) {
        locala = aj(paramString, paramInt);
      }
      ad.i("MicroMsg.NetSceneGetA8Key", "getCommReqRespFromReqUrl reqUrl=%s, type=%s, reason=%d", new Object[] { paramString, locala, Integer.valueOf(paramInt) });
      parama = f(a(locala));
      AppMethodBeat.o(190715);
      return parama;
    }
    
    public static b ai(String paramString, int paramInt)
    {
      AppMethodBeat.i(190716);
      paramString = a(a.hrr, paramString, paramInt);
      AppMethodBeat.o(190716);
      return paramString;
    }
    
    private static a aj(String paramString, int paramInt)
    {
      AppMethodBeat.i(150921);
      if (paramInt == 5)
      {
        paramString = a.hrv;
        AppMethodBeat.o(150921);
        return paramString;
      }
      if (bt.isNullOrNil(paramString))
      {
        ad.i("MicroMsg.NetSceneGetA8Key", "getTypeFromUrl reqUrl is null, getA8Key");
        paramString = a.hrs;
        AppMethodBeat.o(150921);
        return paramString;
      }
      try
      {
        Object localObject = Uri.parse(paramString);
        if (localObject == null)
        {
          paramString = a.hrw;
          AppMethodBeat.o(150921);
          return paramString;
        }
        String str = bt.nullAsNil(((Uri)localObject).getHost()).toLowerCase();
        if (bt.isNullOrNil(((Uri)localObject).getFragment())) {}
        for (localObject = "";; localObject = "#" + ((Uri)localObject).getFragment())
        {
          ad.d("MicroMsg.NetSceneGetA8Key", "get TypeFromUrl domain:%s, fragment:%s", new Object[] { str, localObject });
          if ((!str.equals("open.weixin.qq.com")) && (!str.equals("mp.weixin.qq.com")) && (!str.equals("mp.weixinbridge.com"))) {
            break;
          }
          paramString = a.hrt;
          AppMethodBeat.o(150921);
          return paramString;
        }
        if (((String)localObject).contains("wechat_pay"))
        {
          paramString = a.hru;
          AppMethodBeat.o(150921);
          return paramString;
        }
        if ((str.contains(".qq.com")) || (str.equals("qq.com")) || (str.contains(".wechat.com")) || (str.equals("wechat.com")) || (str.contains(".tenpay.com")) || (str.equals("tenpay.com")) || (str.contains(".url.cn")) || (str.equals("url.com")) || ((!paramString.startsWith("http://")) && (!paramString.startsWith("https://"))))
        {
          paramString = a.hrs;
          AppMethodBeat.o(150921);
          return paramString;
        }
        paramString = a.hrw;
        AppMethodBeat.o(150921);
        return paramString;
      }
      catch (Exception paramString)
      {
        ad.e("MicroMsg.NetSceneGetA8Key", "getTypeFromUrl parse uri fail %s", new Object[] { paramString.getMessage() });
        paramString = a.hrs;
        AppMethodBeat.o(150921);
      }
      return paramString;
    }
    
    public static b f(b paramb)
    {
      AppMethodBeat.i(150922);
      if ((aj.cbe()) && (com.tencent.mm.kernel.g.afw()))
      {
        aoi localaoi = (aoi)paramb.gUS.gUX;
        com.tencent.mm.kernel.g.afC();
        String str1 = bt.nullAsNil((String)com.tencent.mm.kernel.g.afB().afk().get(46, null));
        localaoi.CBk = new SKBuiltinBuffer_t().setBuffer(bt.aGd(str1));
        com.tencent.mm.kernel.g.afC();
        String str2 = bt.nullAsNil((String)com.tencent.mm.kernel.g.afB().afk().get(72, null));
        localaoi.DpR = new SKBuiltinBuffer_t().setBuffer(bt.aGd(str2));
        ad.d("MicroMsg.NetSceneGetA8Key", "dkwt get a2=" + str1 + " newa2=" + str2);
      }
      AppMethodBeat.o(150922);
      return paramb;
    }
    
    public static enum a
    {
      static
      {
        AppMethodBeat.i(150919);
        hrr = new a("AutoRoute", 0);
        hrs = new a("GetA8Key", 1);
        hrt = new a("MpGetA8Key", 2);
        hru = new a("PayGetA8Key", 3);
        hrv = new a("MinorGetA8Key", 4);
        hrw = new a("ThridGetA8Key", 5);
        hrx = new a[] { hrr, hrs, hrt, hru, hrv, hrw };
        AppMethodBeat.o(150919);
      }
      
      private a() {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.modelsimple.k
 * JD-Core Version:    0.7.0.1
 */