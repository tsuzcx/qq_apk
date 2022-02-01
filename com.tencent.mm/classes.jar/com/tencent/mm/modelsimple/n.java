package com.tencent.mm.modelsimple;

import android.net.Uri;
import android.os.Bundle;
import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.p;
import com.tencent.mm.kernel.f;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.platformtools.w;
import com.tencent.mm.plugin.comm.c.h;
import com.tencent.mm.protocal.protobuf.aht;
import com.tencent.mm.protocal.protobuf.ccm;
import com.tencent.mm.protocal.protobuf.cde;
import com.tencent.mm.protocal.protobuf.cdf;
import com.tencent.mm.protocal.protobuf.dam;
import com.tencent.mm.protocal.protobuf.etl;
import com.tencent.mm.protocal.protobuf.gol;
import com.tencent.mm.protocal.protobuf.rd;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import com.tencent.mm.storage.aq;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class n
  extends p
  implements m
{
  private com.tencent.mm.am.h callback;
  private final long oSm;
  private final long oSn;
  public final Bundle oSo;
  public final c rr;
  public Object tag;
  
  private n()
  {
    AppMethodBeat.i(150923);
    this.oSm = SystemClock.elapsedRealtime();
    this.oSn = System.currentTimeMillis();
    this.oSo = new Bundle();
    this.rr = a.f(a.a(n.a.a.oSr));
    AppMethodBeat.o(150923);
  }
  
  public n(int paramInt1, int paramInt2)
  {
    this();
    AppMethodBeat.i(150930);
    cde localcde = (cde)c.b.b(this.rr.otB);
    localcde.YIq = 3;
    localcde.IJG = 5;
    localcde.aanc = paramInt1;
    localcde.aane = paramInt2;
    Log.d("MicroMsg.NetSceneGetA8Key", "dkwt geta8key friendQQNum:%d  a2key-len:%d requestId", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(localcde.YJr.abwJ), Integer.valueOf(paramInt2) });
    AppMethodBeat.o(150930);
  }
  
  private n(n.a.a parama)
  {
    AppMethodBeat.i(150925);
    this.oSm = SystemClock.elapsedRealtime();
    this.oSn = System.currentTimeMillis();
    this.oSo = new Bundle();
    this.rr = a.a(parama);
    AppMethodBeat.o(150925);
  }
  
  private n(String paramString, int paramInt)
  {
    AppMethodBeat.i(150924);
    this.oSm = SystemClock.elapsedRealtime();
    this.oSn = System.currentTimeMillis();
    this.oSo = new Bundle();
    this.rr = a.aW(paramString, paramInt);
    AppMethodBeat.o(150924);
  }
  
  public n(String paramString, int paramInt1, int paramInt2, int paramInt3, byte[] paramArrayOfByte)
  {
    this(paramString, 0);
    AppMethodBeat.i(236739);
    cde localcde = (cde)c.b.b(this.rr.otB);
    localcde.YIq = 2;
    localcde.aana = new etl().btH(paramString);
    localcde.IJG = 36;
    localcde.UserName = null;
    localcde.YKo = 0;
    localcde.ZiC = paramInt1;
    localcde.ZiD = paramInt2;
    localcde.aane = paramInt3;
    localcde.aamX = new etl().btH(null);
    localcde.aanh = new gol().df(paramArrayOfByte);
    Log.d("MicroMsg.NetSceneGetA8Key", "get a8key reqUrl = " + paramString + ", username = " + null + ", scene = 36, reason = 0, codeType = " + paramInt1 + ", codeVersion = " + paramInt2 + ", requestId = " + paramInt3);
    Log.d("MicroMsg.NetSceneGetA8Key", "a8KeyCookie = %s", new Object[] { Util.encodeHexString(paramArrayOfByte) });
    AppMethodBeat.o(236739);
  }
  
  public n(String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, String paramString3, int paramInt4, String paramString4, String paramString5, int paramInt5, byte[] paramArrayOfByte)
  {
    this(paramString1, paramInt2);
    AppMethodBeat.i(150929);
    cde localcde = (cde)c.b.b(this.rr.otB);
    localcde.YIq = 2;
    localcde.aana = new etl().btH(paramString1);
    localcde.IJG = paramInt1;
    localcde.UserName = paramString2;
    localcde.YKo = paramInt2;
    localcde.YFu = paramInt3;
    localcde.vYk = paramString3;
    localcde.aane = paramInt4;
    localcde.aanf = paramString5;
    localcde.aang = paramInt5;
    localcde.aamX = new etl().btH(paramString4);
    localcde.aanh = new gol().df(paramArrayOfByte);
    Log.i("MicroMsg.NetSceneGetA8Key", "get a8key reqUrl = %s, username = %s, scene = %d, reason = %d, flag = %d, netType = %s, requestId = %d, appId = %s, functionId = %s, wallentRegion = %d, a8KeyCookie = %s", new Object[] { paramString1, paramString2, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString3, Integer.valueOf(paramInt4), paramString4, paramString5, Integer.valueOf(paramInt5), Util.encodeHexString(paramArrayOfByte) });
    AppMethodBeat.o(150929);
  }
  
  public n(String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, String paramString3, int paramInt4, byte[] paramArrayOfByte, String paramString4, String paramString5)
  {
    this(paramString1, 0);
    AppMethodBeat.i(236744);
    cde localcde = (cde)c.b.b(this.rr.otB);
    localcde.YIq = 2;
    localcde.aana = new etl().btH(paramString1);
    localcde.IJG = paramInt1;
    localcde.UserName = paramString2;
    localcde.aani = paramString4;
    localcde.aanj = paramString5;
    localcde.YKo = 0;
    localcde.ZiC = paramInt2;
    localcde.ZiD = paramInt3;
    localcde.aane = paramInt4;
    localcde.aamX = new etl().btH(paramString3);
    localcde.aanh = new gol().df(paramArrayOfByte);
    Log.d("MicroMsg.NetSceneGetA8Key", "get a8key reqUrl = " + paramString1 + ", username = " + paramString2 + ", scene = " + paramInt1 + ", reason = 0, codeType = " + paramInt2 + ", codeVersion = " + paramInt3 + ", requestId = " + paramInt4 + ",msgUsername = " + paramString4 + ", svrMsgId = " + paramString5);
    Log.d("MicroMsg.NetSceneGetA8Key", "a8KeyCookie = %s", new Object[] { Util.encodeHexString(paramArrayOfByte) });
    AppMethodBeat.o(236744);
  }
  
  public n(String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, byte[] paramArrayOfByte)
  {
    this(paramString1, paramInt2);
    AppMethodBeat.i(150927);
    cde localcde = (cde)c.b.b(this.rr.otB);
    localcde.YIq = 2;
    localcde.aana = new etl().btH(paramString1);
    localcde.IJG = paramInt1;
    localcde.UserName = paramString2;
    localcde.YKo = paramInt2;
    localcde.aane = paramInt3;
    localcde.aanh = new gol().df(paramArrayOfByte);
    Log.d("MicroMsg.NetSceneGetA8Key", "get a8key reqUrl = " + paramString1 + ", username = " + paramString2 + ", scene = " + paramInt1 + ", reason = " + paramInt2 + ", requestId = " + paramInt3);
    Log.d("MicroMsg.NetSceneGetA8Key", "a8KeyCookie = %s", new Object[] { Util.encodeHexString(paramArrayOfByte) });
    AppMethodBeat.o(150927);
  }
  
  public n(String paramString1, String paramString2, String paramString3, int paramInt)
  {
    this(n.a.a.oSs);
    AppMethodBeat.i(150926);
    cde localcde = (cde)c.b.b(this.rr.otB);
    localcde.YIq = 1;
    localcde.aamX = new etl().btH(paramString1);
    localcde.aamY = new etl().btH(paramString2);
    localcde.aamZ = new etl().btH(paramString3);
    localcde.aane = paramInt;
    Log.d("MicroMsg.NetSceneGetA8Key", "get a8key appid=%s requestId=%d", new Object[] { paramString1, Integer.valueOf(paramInt) });
    AppMethodBeat.o(150926);
  }
  
  public static final int bMd()
  {
    AppMethodBeat.i(150935);
    int i = (int)System.currentTimeMillis();
    AppMethodBeat.o(150935);
    return i;
  }
  
  public final void OW(String paramString)
  {
    AppMethodBeat.i(236775);
    ((cde)c.b.b(this.rr.otB)).aamF = paramString;
    AppMethodBeat.o(236775);
  }
  
  public final void OX(String paramString)
  {
    AppMethodBeat.i(236776);
    ((cde)c.b.b(this.rr.otB)).aank = paramString;
    AppMethodBeat.o(236776);
  }
  
  public final String bLT()
  {
    AppMethodBeat.i(236759);
    String str = ((cdf)c.c.b(this.rr.otC)).aanm;
    AppMethodBeat.o(236759);
    return str;
  }
  
  public final String bLU()
  {
    AppMethodBeat.i(236760);
    Object localObject = ((cde)c.b.b(this.rr.otB)).aana;
    if (localObject != null)
    {
      localObject = ((etl)localObject).abwM;
      AppMethodBeat.o(236760);
      return localObject;
    }
    AppMethodBeat.o(236760);
    return null;
  }
  
  public final int bLV()
  {
    AppMethodBeat.i(236764);
    int i = ((cdf)c.c.b(this.rr.otC)).aamK;
    AppMethodBeat.o(236764);
    return i;
  }
  
  public final byte[] bLW()
  {
    AppMethodBeat.i(150933);
    Object localObject = (cdf)c.c.b(this.rr.otC);
    if (((cdf)localObject).aanx == null)
    {
      AppMethodBeat.o(150933);
      return null;
    }
    try
    {
      localObject = w.a(((cdf)localObject).aanx);
      AppMethodBeat.o(150933);
      return localObject;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(150933);
    }
    return null;
  }
  
  public final ccm bLX()
  {
    AppMethodBeat.i(236766);
    ccm localccm = ((cdf)c.c.b(this.rr.otC)).aanp;
    AppMethodBeat.o(236766);
    return localccm;
  }
  
  public final String bLY()
  {
    AppMethodBeat.i(236768);
    String str = ((cdf)c.c.b(this.rr.otC)).aanq;
    AppMethodBeat.o(236768);
    return str;
  }
  
  public final ArrayList<byte[]> bLZ()
  {
    AppMethodBeat.i(150934);
    Object localObject = (cdf)c.c.b(this.rr.otC);
    ArrayList localArrayList = new ArrayList();
    if ((localObject == null) || (((cdf)localObject).aans == null))
    {
      AppMethodBeat.o(150934);
      return localArrayList;
    }
    localObject = ((cdf)localObject).aans.iterator();
    while (((Iterator)localObject).hasNext())
    {
      rd localrd = (rd)((Iterator)localObject).next();
      try
      {
        localArrayList.add(localrd.toByteArray());
      }
      catch (IOException localIOException)
      {
        Log.e("MicroMsg.NetSceneGetA8Key", "exception:%s", new Object[] { Util.stackTraceToString(localIOException) });
      }
    }
    Log.d("MicroMsg.NetSceneGetA8Key", "ScopeList size = %s", new Object[] { Integer.valueOf(localArrayList.size()) });
    AppMethodBeat.o(150934);
    return localArrayList;
  }
  
  public final long bMa()
  {
    AppMethodBeat.i(236769);
    cdf localcdf = (cdf)c.c.b(this.rr.otC);
    if (localcdf.aanw != null)
    {
      long l = localcdf.aanw.ZqI;
      AppMethodBeat.o(236769);
      return l;
    }
    AppMethodBeat.o(236769);
    return -1L;
  }
  
  public final List<dam> bMb()
  {
    AppMethodBeat.i(236771);
    LinkedList localLinkedList = ((cdf)c.c.b(this.rr.otC)).aamS;
    AppMethodBeat.o(236771);
    return localLinkedList;
  }
  
  public final int bMc()
  {
    AppMethodBeat.i(236774);
    int i = ((cde)c.b.b(this.rr.otB)).aane;
    AppMethodBeat.o(236774);
    return i;
  }
  
  public final byte[] bMe()
  {
    AppMethodBeat.i(150936);
    Object localObject = (cdf)c.c.b(this.rr.otC);
    if (((cdf)localObject).aanh == null)
    {
      AppMethodBeat.o(150936);
      return new byte[0];
    }
    try
    {
      localObject = w.a(((cdf)localObject).aanh);
      AppMethodBeat.o(150936);
      return localObject;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(150936);
    }
    return new byte[0];
  }
  
  public final int doScene(g paramg, com.tencent.mm.am.h paramh)
  {
    AppMethodBeat.i(150931);
    this.callback = paramh;
    Log.d("MicroMsg.NetSceneGetA8Key", "doScene, url:[%s], requestId:[%d]", new Object[] { bLU(), Integer.valueOf(bMc()) });
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(150931);
    return i;
  }
  
  public final String getContent()
  {
    AppMethodBeat.i(236763);
    String str = ((cdf)c.c.b(this.rr.otC)).nUB;
    AppMethodBeat.o(236763);
    return str;
  }
  
  public final String getTitle()
  {
    AppMethodBeat.i(236761);
    String str = ((cdf)c.c.b(this.rr.otC)).hAP;
    AppMethodBeat.o(236761);
    return str;
  }
  
  public final int getType()
  {
    return 233;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(150932);
    Log.d("MicroMsg.NetSceneGetA8Key", "dkwt geta8key onGYNetEnd:[%d,%d] url:[%s]  a8key:[%s], requestId:[%d]", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), bLT(), ((cdf)c.c.b(this.rr.otC)).aann, Integer.valueOf(bMc()) });
    Log.d("MicroMsg.NetSceneGetA8Key", "a8KeyCookie:%s", new Object[] { Util.encodeHexString(bMe()) });
    this.oSo.putLong("CgiSpeedOutSideStructStartTimeStamp", this.oSn);
    this.oSo.putLong("CgiSpeedOutSideStructEndTimeStamp", System.currentTimeMillis());
    this.oSo.putLong("CgiSpeedOutSideStructCostTime", SystemClock.elapsedRealtime() - this.oSm);
    this.oSo.putInt("CgiSpeedOutSideStructCgiNo", 233);
    this.oSo.putInt("CgiSpeedOutSideStructRet", paramInt3);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(150932);
  }
  
  public final void setSubScene(int paramInt)
  {
    AppMethodBeat.i(236777);
    ((cde)c.b.b(this.rr.otB)).YIc = paramInt;
    AppMethodBeat.o(236777);
  }
  
  public static final class a
  {
    static c a(a parama)
    {
      AppMethodBeat.i(150920);
      c.a locala = new c.a();
      locala.otE = new cde();
      locala.otF = new cdf();
      switch (n.1.oSp[parama.ordinal()])
      {
      default: 
        locala.uri = "/cgi-bin/micromsg-bin/3rd-geta8key";
        locala.funcId = 226;
        locala.otG = 388;
        locala.respCmdId = 1000000388;
      }
      for (;;)
      {
        parama = locala.bEF();
        AppMethodBeat.o(150920);
        return parama;
        locala.uri = "/cgi-bin/micromsg-bin/geta8key";
        locala.funcId = 233;
        locala.otG = 155;
        locala.respCmdId = 1000000155;
        continue;
        locala.uri = "/cgi-bin/micromsg-bin/mp-geta8key";
        locala.funcId = 238;
        locala.otG = 345;
        locala.respCmdId = 1000000345;
        continue;
        locala.uri = "/cgi-bin/micromsg-bin/pay-geta8key";
        locala.funcId = 835;
        locala.otG = 346;
        locala.respCmdId = 1000000346;
        continue;
        locala.uri = "/cgi-bin/micromsg-bin/minor-geta8key";
        locala.funcId = 812;
        locala.otG = 387;
        locala.respCmdId = 1000000387;
        continue;
        locala.uri = "/cgi-bin/micromsg-bin/3rd-geta8key";
        locala.funcId = 226;
        locala.otG = 388;
        locala.respCmdId = 1000000388;
      }
    }
    
    private static c a(a parama, String paramString, int paramInt)
    {
      AppMethodBeat.i(236750);
      a locala = parama;
      if (parama == a.oSq) {
        locala = aX(paramString, paramInt);
      }
      Log.i("MicroMsg.NetSceneGetA8Key", "getCommReqRespFromReqUrl reqUrl=%s, type=%s, reason=%d", new Object[] { paramString, locala, Integer.valueOf(paramInt) });
      parama = f(a(locala));
      AppMethodBeat.o(236750);
      return parama;
    }
    
    public static c aW(String paramString, int paramInt)
    {
      AppMethodBeat.i(236756);
      paramString = a(a.oSq, paramString, paramInt);
      AppMethodBeat.o(236756);
      return paramString;
    }
    
    private static a aX(String paramString, int paramInt)
    {
      AppMethodBeat.i(150921);
      if (paramInt == 5)
      {
        paramString = a.oSu;
        AppMethodBeat.o(150921);
        return paramString;
      }
      if (Util.isNullOrNil(paramString))
      {
        Log.i("MicroMsg.NetSceneGetA8Key", "getTypeFromUrl reqUrl is null, getA8Key");
        paramString = a.oSr;
        AppMethodBeat.o(150921);
        return paramString;
      }
      try
      {
        Object localObject = Uri.parse(paramString);
        if (localObject == null)
        {
          paramString = a.oSv;
          AppMethodBeat.o(150921);
          return paramString;
        }
        String str = Util.nullAsNil(((Uri)localObject).getHost()).toLowerCase();
        if (Util.isNullOrNil(((Uri)localObject).getFragment())) {}
        for (localObject = "";; localObject = "#" + ((Uri)localObject).getFragment())
        {
          Log.d("MicroMsg.NetSceneGetA8Key", "get TypeFromUrl domain:%s, fragment:%s", new Object[] { str, localObject });
          if ((!str.equals(WeChatHosts.domainString(c.h.host_open_weixin_qq_com))) && (!str.equals(WeChatHosts.domainString(c.h.host_mp_weixin_qq_com))) && (!str.equals("mp.weixinbridge.com"))) {
            break;
          }
          paramString = a.oSs;
          AppMethodBeat.o(150921);
          return paramString;
        }
        if (((String)localObject).contains("wechat_pay"))
        {
          paramString = a.oSt;
          AppMethodBeat.o(150921);
          return paramString;
        }
        if ((str.contains(".qq.com")) || (str.equals("qq.com")) || (str.contains(".wechat.com")) || (str.equals("wechat.com")) || (str.contains(".tenpay.com")) || (str.equals("tenpay.com")) || (str.contains(".url.cn")) || (str.equals("url.com")) || ((!paramString.startsWith("http://")) && (!paramString.startsWith("https://"))))
        {
          paramString = a.oSr;
          AppMethodBeat.o(150921);
          return paramString;
        }
        paramString = a.oSv;
        AppMethodBeat.o(150921);
        return paramString;
      }
      catch (Exception paramString)
      {
        Log.e("MicroMsg.NetSceneGetA8Key", "getTypeFromUrl parse uri fail %s", new Object[] { paramString.getMessage() });
        paramString = a.oSr;
        AppMethodBeat.o(150921);
      }
      return paramString;
    }
    
    public static c f(c paramc)
    {
      AppMethodBeat.i(150922);
      if ((MMApplicationContext.isMainProcess()) && (com.tencent.mm.kernel.h.baz()))
      {
        cde localcde = (cde)c.b.b(paramc.otB);
        com.tencent.mm.kernel.h.baF();
        String str1 = Util.nullAsNil((String)com.tencent.mm.kernel.h.baE().ban().d(46, null));
        localcde.YJr = new gol().df(Util.decodeHexString(str1));
        com.tencent.mm.kernel.h.baF();
        String str2 = Util.nullAsNil((String)com.tencent.mm.kernel.h.baE().ban().d(72, null));
        localcde.aand = new gol().df(Util.decodeHexString(str2));
        Log.d("MicroMsg.NetSceneGetA8Key", "dkwt get a2=" + str1 + " newa2=" + str2);
      }
      AppMethodBeat.o(150922);
      return paramc;
    }
    
    public static enum a
    {
      static
      {
        AppMethodBeat.i(150919);
        oSq = new a("AutoRoute", 0);
        oSr = new a("GetA8Key", 1);
        oSs = new a("MpGetA8Key", 2);
        oSt = new a("PayGetA8Key", 3);
        oSu = new a("MinorGetA8Key", 4);
        oSv = new a("ThridGetA8Key", 5);
        oSw = new a[] { oSq, oSr, oSs, oSt, oSu, oSv };
        AppMethodBeat.o(150919);
      }
      
      private a() {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.modelsimple.n
 * JD-Core Version:    0.7.0.1
 */