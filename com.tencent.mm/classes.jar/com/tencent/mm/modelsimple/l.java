package com.tencent.mm.modelsimple;

import android.net.Uri;
import android.os.Bundle;
import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.e;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.aey;
import com.tencent.mm.protocal.protobuf.bhi;
import com.tencent.mm.protocal.protobuf.bhj;
import com.tencent.mm.protocal.protobuf.ccc;
import com.tencent.mm.protocal.protobuf.dqi;
import com.tencent.mm.protocal.protobuf.px;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import com.tencent.mm.storage.ao;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class l
  extends q
  implements m
{
  private i callback;
  private final long jjh;
  private final long jji;
  public final Bundle jjj;
  public final d rr;
  public Object tag;
  
  private l()
  {
    AppMethodBeat.i(150923);
    this.jjh = SystemClock.elapsedRealtime();
    this.jji = System.currentTimeMillis();
    this.jjj = new Bundle();
    this.rr = a.f(a.a(l.a.a.jjm));
    AppMethodBeat.o(150923);
  }
  
  public l(int paramInt1, int paramInt2)
  {
    this();
    AppMethodBeat.i(150930);
    bhi localbhi = (bhi)this.rr.iLK.iLR;
    localbhi.OpCode = 3;
    localbhi.Scene = 5;
    localbhi.LRz = paramInt1;
    localbhi.LRB = paramInt2;
    Log.d("MicroMsg.NetSceneGetA8Key", "dkwt geta8key friendQQNum:%d  a2key-len:%d requestId", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(localbhi.KLh.getILen()), Integer.valueOf(paramInt2) });
    AppMethodBeat.o(150930);
  }
  
  private l(l.a.a parama)
  {
    AppMethodBeat.i(150925);
    this.jjh = SystemClock.elapsedRealtime();
    this.jji = System.currentTimeMillis();
    this.jjj = new Bundle();
    this.rr = a.a(parama);
    AppMethodBeat.o(150925);
  }
  
  private l(String paramString, int paramInt)
  {
    AppMethodBeat.i(150924);
    this.jjh = SystemClock.elapsedRealtime();
    this.jji = System.currentTimeMillis();
    this.jjj = new Bundle();
    this.rr = a.at(paramString, paramInt);
    AppMethodBeat.o(150924);
  }
  
  public l(String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4, byte[] paramArrayOfByte)
  {
    this(paramString, 0);
    AppMethodBeat.i(223638);
    bhi localbhi = (bhi)this.rr.iLK.iLR;
    localbhi.OpCode = 2;
    localbhi.LRx = new dqi().bhy(paramString);
    localbhi.Scene = paramInt1;
    localbhi.UserName = null;
    localbhi.KMd = 0;
    localbhi.Ljb = paramInt2;
    localbhi.Ljc = paramInt3;
    localbhi.LRB = paramInt4;
    localbhi.LRu = new dqi().bhy(null);
    localbhi.LRE = new SKBuiltinBuffer_t().setBuffer(paramArrayOfByte);
    Log.d("MicroMsg.NetSceneGetA8Key", "get a8key reqUrl = " + paramString + ", username = " + null + ", scene = " + paramInt1 + ", reason = 0, codeType = " + paramInt2 + ", codeVersion = " + paramInt3 + ", requestId = " + paramInt4);
    Log.d("MicroMsg.NetSceneGetA8Key", "a8KeyCookie = %s", new Object[] { Util.encodeHexString(paramArrayOfByte) });
    AppMethodBeat.o(223638);
  }
  
  public l(String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, String paramString3, int paramInt4, String paramString4, String paramString5, int paramInt5, byte[] paramArrayOfByte)
  {
    this(paramString1, paramInt2);
    AppMethodBeat.i(150929);
    bhi localbhi = (bhi)this.rr.iLK.iLR;
    localbhi.OpCode = 2;
    localbhi.LRx = new dqi().bhy(paramString1);
    localbhi.Scene = paramInt1;
    localbhi.UserName = paramString2;
    localbhi.KMd = paramInt2;
    localbhi.KHa = paramInt3;
    localbhi.pLm = paramString3;
    localbhi.LRB = paramInt4;
    localbhi.LRC = paramString5;
    localbhi.LRD = paramInt5;
    localbhi.LRu = new dqi().bhy(paramString4);
    localbhi.LRE = new SKBuiltinBuffer_t().setBuffer(paramArrayOfByte);
    Log.i("MicroMsg.NetSceneGetA8Key", "get a8key reqUrl = %s, username = %s, scene = %d, reason = %d, flag = %d, netType = %s, requestId = %d, appId = %s, functionId = %s, wallentRegion = %d, a8KeyCookie = %s", new Object[] { paramString1, paramString2, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString3, Integer.valueOf(paramInt4), paramString4, paramString5, Integer.valueOf(paramInt5), Util.encodeHexString(paramArrayOfByte) });
    AppMethodBeat.o(150929);
  }
  
  public l(String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, String paramString3, int paramInt4, byte[] paramArrayOfByte, String paramString4, String paramString5)
  {
    this(paramString1, 0);
    AppMethodBeat.i(223639);
    bhi localbhi = (bhi)this.rr.iLK.iLR;
    localbhi.OpCode = 2;
    localbhi.LRx = new dqi().bhy(paramString1);
    localbhi.Scene = paramInt1;
    localbhi.UserName = paramString2;
    localbhi.LRF = paramString4;
    localbhi.LRG = paramString5;
    localbhi.KMd = 0;
    localbhi.Ljb = paramInt2;
    localbhi.Ljc = paramInt3;
    localbhi.LRB = paramInt4;
    localbhi.LRu = new dqi().bhy(paramString3);
    localbhi.LRE = new SKBuiltinBuffer_t().setBuffer(paramArrayOfByte);
    Log.d("MicroMsg.NetSceneGetA8Key", "get a8key reqUrl = " + paramString1 + ", username = " + paramString2 + ", scene = " + paramInt1 + ", reason = 0, codeType = " + paramInt2 + ", codeVersion = " + paramInt3 + ", requestId = " + paramInt4 + ",msgUsername = " + paramString4 + ", svrMsgId = " + paramString5);
    Log.d("MicroMsg.NetSceneGetA8Key", "a8KeyCookie = %s", new Object[] { Util.encodeHexString(paramArrayOfByte) });
    AppMethodBeat.o(223639);
  }
  
  public l(String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, byte[] paramArrayOfByte)
  {
    this(paramString1, paramInt2);
    AppMethodBeat.i(150927);
    bhi localbhi = (bhi)this.rr.iLK.iLR;
    localbhi.OpCode = 2;
    localbhi.LRx = new dqi().bhy(paramString1);
    localbhi.Scene = paramInt1;
    localbhi.UserName = paramString2;
    localbhi.KMd = paramInt2;
    localbhi.LRB = paramInt3;
    localbhi.LRE = new SKBuiltinBuffer_t().setBuffer(paramArrayOfByte);
    Log.d("MicroMsg.NetSceneGetA8Key", "get a8key reqUrl = " + paramString1 + ", username = " + paramString2 + ", scene = " + paramInt1 + ", reason = " + paramInt2 + ", requestId = " + paramInt3);
    Log.d("MicroMsg.NetSceneGetA8Key", "a8KeyCookie = %s", new Object[] { Util.encodeHexString(paramArrayOfByte) });
    AppMethodBeat.o(150927);
  }
  
  public l(String paramString1, String paramString2, String paramString3, int paramInt)
  {
    this(l.a.a.jjn);
    AppMethodBeat.i(150926);
    bhi localbhi = (bhi)this.rr.iLK.iLR;
    localbhi.OpCode = 1;
    localbhi.LRu = new dqi().bhy(paramString1);
    localbhi.LRv = new dqi().bhy(paramString2);
    localbhi.LRw = new dqi().bhy(paramString3);
    localbhi.LRB = paramInt;
    Log.d("MicroMsg.NetSceneGetA8Key", "get a8key appid=%s requestId=%d", new Object[] { paramString1, Integer.valueOf(paramInt) });
    AppMethodBeat.o(150926);
  }
  
  public static final int beZ()
  {
    AppMethodBeat.i(150935);
    int i = (int)System.currentTimeMillis();
    AppMethodBeat.o(150935);
    return i;
  }
  
  public final void Pz(String paramString)
  {
    ((bhi)this.rr.iLK.iLR).LRe = paramString;
  }
  
  public final String beQ()
  {
    return ((bhj)this.rr.iLL.iLR).LRH;
  }
  
  public final String beR()
  {
    dqi localdqi = ((bhi)this.rr.iLK.iLR).LRx;
    if (localdqi != null) {
      return localdqi.MTo;
    }
    return null;
  }
  
  public final int beS()
  {
    return ((bhj)this.rr.iLL.iLR).KCD;
  }
  
  public final byte[] beT()
  {
    AppMethodBeat.i(150933);
    Object localObject = (bhj)this.rr.iLL.iLR;
    if (((bhj)localObject).LRQ == null)
    {
      AppMethodBeat.o(150933);
      return null;
    }
    try
    {
      localObject = z.a(((bhj)localObject).LRQ);
      AppMethodBeat.o(150933);
      return localObject;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(150933);
    }
    return null;
  }
  
  public final String beU()
  {
    return ((bhj)this.rr.iLL.iLR).LRL;
  }
  
  public final ArrayList<byte[]> beV()
  {
    AppMethodBeat.i(150934);
    Object localObject = (bhj)this.rr.iLL.iLR;
    ArrayList localArrayList = new ArrayList();
    if ((localObject == null) || (((bhj)localObject).LRN == null))
    {
      AppMethodBeat.o(150934);
      return localArrayList;
    }
    localObject = ((bhj)localObject).LRN.iterator();
    while (((Iterator)localObject).hasNext())
    {
      px localpx = (px)((Iterator)localObject).next();
      try
      {
        localArrayList.add(localpx.toByteArray());
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
  
  public final long beW()
  {
    bhj localbhj = (bhj)this.rr.iLL.iLR;
    if (localbhj.LRP != null) {
      return localbhj.LRP.Lqi;
    }
    return -1L;
  }
  
  public final List<ccc> beX()
  {
    return ((bhj)this.rr.iLL.iLR).LRq;
  }
  
  public final int beY()
  {
    return ((bhi)this.rr.iLK.iLR).LRB;
  }
  
  public final byte[] bfa()
  {
    AppMethodBeat.i(150936);
    Object localObject = (bhj)this.rr.iLL.iLR;
    if (((bhj)localObject).LRE == null)
    {
      AppMethodBeat.o(150936);
      return new byte[0];
    }
    try
    {
      localObject = z.a(((bhj)localObject).LRE);
      AppMethodBeat.o(150936);
      return localObject;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(150936);
    }
    return new byte[0];
  }
  
  public final int doScene(com.tencent.mm.network.g paramg, i parami)
  {
    AppMethodBeat.i(150931);
    this.callback = parami;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(150931);
    return i;
  }
  
  public final String getContent()
  {
    return ((bhj)this.rr.iLL.iLR).iAc;
  }
  
  public final String getTitle()
  {
    return ((bhj)this.rr.iLL.iLR).Title;
  }
  
  public final int getType()
  {
    return 233;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(150932);
    Log.d("MicroMsg.NetSceneGetA8Key", "dkwt geta8key onGYNetEnd:[%d,%d] url:[%s]  a8key:[%s]", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), beQ(), ((bhj)this.rr.iLL.iLR).LRI });
    Log.d("MicroMsg.NetSceneGetA8Key", "a8KeyCookie:%s", new Object[] { Util.encodeHexString(bfa()) });
    this.jjj.putLong("CgiSpeedOutSideStructStartTimeStamp", this.jji);
    this.jjj.putLong("CgiSpeedOutSideStructEndTimeStamp", System.currentTimeMillis());
    this.jjj.putLong("CgiSpeedOutSideStructCostTime", SystemClock.elapsedRealtime() - this.jjh);
    this.jjj.putInt("CgiSpeedOutSideStructCgiNo", 233);
    this.jjj.putInt("CgiSpeedOutSideStructRet", paramInt3);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(150932);
  }
  
  public final void setSubScene(int paramInt)
  {
    ((bhi)this.rr.iLK.iLR).KJS = paramInt;
  }
  
  public static final class a
  {
    static d a(a parama)
    {
      AppMethodBeat.i(150920);
      d.a locala = new d.a();
      locala.iLN = new bhi();
      locala.iLO = new bhj();
      switch (l.1.jjk[parama.ordinal()])
      {
      default: 
        locala.uri = "/cgi-bin/micromsg-bin/3rd-geta8key";
        locala.funcId = 226;
        locala.iLP = 388;
        locala.respCmdId = 1000000388;
      }
      for (;;)
      {
        parama = locala.aXF();
        AppMethodBeat.o(150920);
        return parama;
        locala.uri = "/cgi-bin/micromsg-bin/geta8key";
        locala.funcId = 233;
        locala.iLP = 155;
        locala.respCmdId = 1000000155;
        continue;
        locala.uri = "/cgi-bin/micromsg-bin/mp-geta8key";
        locala.funcId = 238;
        locala.iLP = 345;
        locala.respCmdId = 1000000345;
        continue;
        locala.uri = "/cgi-bin/micromsg-bin/pay-geta8key";
        locala.funcId = 835;
        locala.iLP = 346;
        locala.respCmdId = 1000000346;
        continue;
        locala.uri = "/cgi-bin/micromsg-bin/minor-geta8key";
        locala.funcId = 812;
        locala.iLP = 387;
        locala.respCmdId = 1000000387;
        continue;
        locala.uri = "/cgi-bin/micromsg-bin/3rd-geta8key";
        locala.funcId = 226;
        locala.iLP = 388;
        locala.respCmdId = 1000000388;
      }
    }
    
    private static d a(a parama, String paramString, int paramInt)
    {
      AppMethodBeat.i(223636);
      a locala = parama;
      if (parama == a.jjl) {
        locala = au(paramString, paramInt);
      }
      Log.i("MicroMsg.NetSceneGetA8Key", "getCommReqRespFromReqUrl reqUrl=%s, type=%s, reason=%d", new Object[] { paramString, locala, Integer.valueOf(paramInt) });
      parama = f(a(locala));
      AppMethodBeat.o(223636);
      return parama;
    }
    
    public static d at(String paramString, int paramInt)
    {
      AppMethodBeat.i(223637);
      paramString = a(a.jjl, paramString, paramInt);
      AppMethodBeat.o(223637);
      return paramString;
    }
    
    private static a au(String paramString, int paramInt)
    {
      AppMethodBeat.i(150921);
      if (paramInt == 5)
      {
        paramString = a.jjp;
        AppMethodBeat.o(150921);
        return paramString;
      }
      if (Util.isNullOrNil(paramString))
      {
        Log.i("MicroMsg.NetSceneGetA8Key", "getTypeFromUrl reqUrl is null, getA8Key");
        paramString = a.jjm;
        AppMethodBeat.o(150921);
        return paramString;
      }
      try
      {
        Object localObject = Uri.parse(paramString);
        if (localObject == null)
        {
          paramString = a.jjq;
          AppMethodBeat.o(150921);
          return paramString;
        }
        String str = Util.nullAsNil(((Uri)localObject).getHost()).toLowerCase();
        if (Util.isNullOrNil(((Uri)localObject).getFragment())) {}
        for (localObject = "";; localObject = "#" + ((Uri)localObject).getFragment())
        {
          Log.d("MicroMsg.NetSceneGetA8Key", "get TypeFromUrl domain:%s, fragment:%s", new Object[] { str, localObject });
          if ((!str.equals(WeChatHosts.domainString(2131761728))) && (!str.equals(WeChatHosts.domainString(2131761726))) && (!str.equals("mp.weixinbridge.com"))) {
            break;
          }
          paramString = a.jjn;
          AppMethodBeat.o(150921);
          return paramString;
        }
        if (((String)localObject).contains("wechat_pay"))
        {
          paramString = a.jjo;
          AppMethodBeat.o(150921);
          return paramString;
        }
        if ((str.contains(".qq.com")) || (str.equals("qq.com")) || (str.contains(".wechat.com")) || (str.equals("wechat.com")) || (str.contains(".tenpay.com")) || (str.equals("tenpay.com")) || (str.contains(".url.cn")) || (str.equals("url.com")) || ((!paramString.startsWith("http://")) && (!paramString.startsWith("https://"))))
        {
          paramString = a.jjm;
          AppMethodBeat.o(150921);
          return paramString;
        }
        paramString = a.jjq;
        AppMethodBeat.o(150921);
        return paramString;
      }
      catch (Exception paramString)
      {
        Log.e("MicroMsg.NetSceneGetA8Key", "getTypeFromUrl parse uri fail %s", new Object[] { paramString.getMessage() });
        paramString = a.jjm;
        AppMethodBeat.o(150921);
      }
      return paramString;
    }
    
    public static d f(d paramd)
    {
      AppMethodBeat.i(150922);
      if ((MMApplicationContext.isMainProcess()) && (com.tencent.mm.kernel.g.aAc()))
      {
        bhi localbhi = (bhi)paramd.iLK.iLR;
        com.tencent.mm.kernel.g.aAi();
        String str1 = Util.nullAsNil((String)com.tencent.mm.kernel.g.aAh().azQ().get(46, null));
        localbhi.KLh = new SKBuiltinBuffer_t().setBuffer(Util.decodeHexString(str1));
        com.tencent.mm.kernel.g.aAi();
        String str2 = Util.nullAsNil((String)com.tencent.mm.kernel.g.aAh().azQ().get(72, null));
        localbhi.LRA = new SKBuiltinBuffer_t().setBuffer(Util.decodeHexString(str2));
        Log.d("MicroMsg.NetSceneGetA8Key", "dkwt get a2=" + str1 + " newa2=" + str2);
      }
      AppMethodBeat.o(150922);
      return paramd;
    }
    
    public static enum a
    {
      static
      {
        AppMethodBeat.i(150919);
        jjl = new a("AutoRoute", 0);
        jjm = new a("GetA8Key", 1);
        jjn = new a("MpGetA8Key", 2);
        jjo = new a("PayGetA8Key", 3);
        jjp = new a("MinorGetA8Key", 4);
        jjq = new a("ThridGetA8Key", 5);
        jjr = new a[] { jjl, jjm, jjn, jjo, jjp, jjq };
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