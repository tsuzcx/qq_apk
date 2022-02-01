package com.tencent.mm.modelsimple;

import android.net.Uri;
import android.os.Bundle;
import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.d.c;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.comm.c.h;
import com.tencent.mm.protocal.protobuf.afh;
import com.tencent.mm.protocal.protobuf.bob;
import com.tencent.mm.protocal.protobuf.bos;
import com.tencent.mm.protocal.protobuf.bot;
import com.tencent.mm.protocal.protobuf.ckf;
import com.tencent.mm.protocal.protobuf.eae;
import com.tencent.mm.protocal.protobuf.eaf;
import com.tencent.mm.protocal.protobuf.pt;
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
  private final long lZd;
  private final long lZe;
  public final Bundle lZf;
  public final d rr;
  public Object tag;
  
  private l()
  {
    AppMethodBeat.i(150923);
    this.lZd = SystemClock.elapsedRealtime();
    this.lZe = System.currentTimeMillis();
    this.lZf = new Bundle();
    this.rr = a.g(a.a(l.a.a.lZi));
    AppMethodBeat.o(150923);
  }
  
  public l(int paramInt1, int paramInt2)
  {
    this();
    AppMethodBeat.i(150930);
    bos localbos = (bos)d.b.b(this.rr.lBR);
    localbos.RLe = 3;
    localbos.CPw = 5;
    localbos.Tae = paramInt1;
    localbos.Tag = paramInt2;
    Log.d("MicroMsg.NetSceneGetA8Key", "dkwt geta8key friendQQNum:%d  a2key-len:%d requestId", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(localbos.RMd.Ufv), Integer.valueOf(paramInt2) });
    AppMethodBeat.o(150930);
  }
  
  private l(l.a.a parama)
  {
    AppMethodBeat.i(150925);
    this.lZd = SystemClock.elapsedRealtime();
    this.lZe = System.currentTimeMillis();
    this.lZf = new Bundle();
    this.rr = a.a(parama);
    AppMethodBeat.o(150925);
  }
  
  private l(String paramString, int paramInt)
  {
    AppMethodBeat.i(150924);
    this.lZd = SystemClock.elapsedRealtime();
    this.lZe = System.currentTimeMillis();
    this.lZf = new Bundle();
    this.rr = a.aL(paramString, paramInt);
    AppMethodBeat.o(150924);
  }
  
  public l(String paramString, int paramInt1, int paramInt2, int paramInt3, byte[] paramArrayOfByte)
  {
    this(paramString, 0);
    AppMethodBeat.i(242857);
    bos localbos = (bos)d.b.b(this.rr.lBR);
    localbos.RLe = 2;
    localbos.Tac = new eaf().btQ(paramString);
    localbos.CPw = 36;
    localbos.UserName = null;
    localbos.RNa = 0;
    localbos.Sks = paramInt1;
    localbos.Skt = paramInt2;
    localbos.Tag = paramInt3;
    localbos.SZZ = new eaf().btQ(null);
    localbos.Taj = new eae().dc(paramArrayOfByte);
    Log.d("MicroMsg.NetSceneGetA8Key", "get a8key reqUrl = " + paramString + ", username = " + null + ", scene = 36, reason = 0, codeType = " + paramInt1 + ", codeVersion = " + paramInt2 + ", requestId = " + paramInt3);
    Log.d("MicroMsg.NetSceneGetA8Key", "a8KeyCookie = %s", new Object[] { Util.encodeHexString(paramArrayOfByte) });
    AppMethodBeat.o(242857);
  }
  
  public l(String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, String paramString3, int paramInt4, String paramString4, String paramString5, int paramInt5, byte[] paramArrayOfByte)
  {
    this(paramString1, paramInt2);
    AppMethodBeat.i(150929);
    bos localbos = (bos)d.b.b(this.rr.lBR);
    localbos.RLe = 2;
    localbos.Tac = new eaf().btQ(paramString1);
    localbos.CPw = paramInt1;
    localbos.UserName = paramString2;
    localbos.RNa = paramInt2;
    localbos.RIs = paramInt3;
    localbos.sSU = paramString3;
    localbos.Tag = paramInt4;
    localbos.Tah = paramString5;
    localbos.Tai = paramInt5;
    localbos.SZZ = new eaf().btQ(paramString4);
    localbos.Taj = new eae().dc(paramArrayOfByte);
    Log.i("MicroMsg.NetSceneGetA8Key", "get a8key reqUrl = %s, username = %s, scene = %d, reason = %d, flag = %d, netType = %s, requestId = %d, appId = %s, functionId = %s, wallentRegion = %d, a8KeyCookie = %s", new Object[] { paramString1, paramString2, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString3, Integer.valueOf(paramInt4), paramString4, paramString5, Integer.valueOf(paramInt5), Util.encodeHexString(paramArrayOfByte) });
    AppMethodBeat.o(150929);
  }
  
  public l(String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, String paramString3, int paramInt4, byte[] paramArrayOfByte, String paramString4, String paramString5)
  {
    this(paramString1, 0);
    AppMethodBeat.i(242858);
    bos localbos = (bos)d.b.b(this.rr.lBR);
    localbos.RLe = 2;
    localbos.Tac = new eaf().btQ(paramString1);
    localbos.CPw = paramInt1;
    localbos.UserName = paramString2;
    localbos.Tak = paramString4;
    localbos.Tal = paramString5;
    localbos.RNa = 0;
    localbos.Sks = paramInt2;
    localbos.Skt = paramInt3;
    localbos.Tag = paramInt4;
    localbos.SZZ = new eaf().btQ(paramString3);
    localbos.Taj = new eae().dc(paramArrayOfByte);
    Log.d("MicroMsg.NetSceneGetA8Key", "get a8key reqUrl = " + paramString1 + ", username = " + paramString2 + ", scene = " + paramInt1 + ", reason = 0, codeType = " + paramInt2 + ", codeVersion = " + paramInt3 + ", requestId = " + paramInt4 + ",msgUsername = " + paramString4 + ", svrMsgId = " + paramString5);
    Log.d("MicroMsg.NetSceneGetA8Key", "a8KeyCookie = %s", new Object[] { Util.encodeHexString(paramArrayOfByte) });
    AppMethodBeat.o(242858);
  }
  
  public l(String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, byte[] paramArrayOfByte)
  {
    this(paramString1, paramInt2);
    AppMethodBeat.i(150927);
    bos localbos = (bos)d.b.b(this.rr.lBR);
    localbos.RLe = 2;
    localbos.Tac = new eaf().btQ(paramString1);
    localbos.CPw = paramInt1;
    localbos.UserName = paramString2;
    localbos.RNa = paramInt2;
    localbos.Tag = paramInt3;
    localbos.Taj = new eae().dc(paramArrayOfByte);
    Log.d("MicroMsg.NetSceneGetA8Key", "get a8key reqUrl = " + paramString1 + ", username = " + paramString2 + ", scene = " + paramInt1 + ", reason = " + paramInt2 + ", requestId = " + paramInt3);
    Log.d("MicroMsg.NetSceneGetA8Key", "a8KeyCookie = %s", new Object[] { Util.encodeHexString(paramArrayOfByte) });
    AppMethodBeat.o(150927);
  }
  
  public l(String paramString1, String paramString2, String paramString3, int paramInt)
  {
    this(l.a.a.lZj);
    AppMethodBeat.i(150926);
    bos localbos = (bos)d.b.b(this.rr.lBR);
    localbos.RLe = 1;
    localbos.SZZ = new eaf().btQ(paramString1);
    localbos.Taa = new eaf().btQ(paramString2);
    localbos.Tab = new eaf().btQ(paramString3);
    localbos.Tag = paramInt;
    Log.d("MicroMsg.NetSceneGetA8Key", "get a8key appid=%s requestId=%d", new Object[] { paramString1, Integer.valueOf(paramInt) });
    AppMethodBeat.o(150926);
  }
  
  public static final int boo()
  {
    AppMethodBeat.i(150935);
    int i = (int)System.currentTimeMillis();
    AppMethodBeat.o(150935);
    return i;
  }
  
  public final void WW(String paramString)
  {
    AppMethodBeat.i(242875);
    ((bos)d.b.b(this.rr.lBR)).SZI = paramString;
    AppMethodBeat.o(242875);
  }
  
  public final void WX(String paramString)
  {
    AppMethodBeat.i(242876);
    ((bos)d.b.b(this.rr.lBR)).Tam = paramString;
    AppMethodBeat.o(242876);
  }
  
  public final bob bAm()
  {
    AppMethodBeat.i(293058);
    bob localbob = ((bot)d.c.b(this.rr.lBS)).Tar;
    AppMethodBeat.o(293058);
    return localbob;
  }
  
  public final String bof()
  {
    AppMethodBeat.i(242860);
    String str = ((bot)d.c.b(this.rr.lBS)).Tao;
    AppMethodBeat.o(242860);
    return str;
  }
  
  public final String bog()
  {
    AppMethodBeat.i(242861);
    Object localObject = ((bos)d.b.b(this.rr.lBR)).Tac;
    if (localObject != null)
    {
      localObject = ((eaf)localObject).Ufy;
      AppMethodBeat.o(242861);
      return localObject;
    }
    AppMethodBeat.o(242861);
    return null;
  }
  
  public final int boh()
  {
    AppMethodBeat.i(242867);
    int i = ((bot)d.c.b(this.rr.lBS)).SZN;
    AppMethodBeat.o(242867);
    return i;
  }
  
  public final byte[] boi()
  {
    AppMethodBeat.i(150933);
    Object localObject = (bot)d.c.b(this.rr.lBS);
    if (((bot)localObject).Taz == null)
    {
      AppMethodBeat.o(150933);
      return null;
    }
    try
    {
      localObject = z.a(((bot)localObject).Taz);
      AppMethodBeat.o(150933);
      return localObject;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(150933);
    }
    return null;
  }
  
  public final String boj()
  {
    AppMethodBeat.i(242869);
    String str = ((bot)d.c.b(this.rr.lBS)).Tas;
    AppMethodBeat.o(242869);
    return str;
  }
  
  public final ArrayList<byte[]> bok()
  {
    AppMethodBeat.i(150934);
    Object localObject = (bot)d.c.b(this.rr.lBS);
    ArrayList localArrayList = new ArrayList();
    if ((localObject == null) || (((bot)localObject).Tau == null))
    {
      AppMethodBeat.o(150934);
      return localArrayList;
    }
    localObject = ((bot)localObject).Tau.iterator();
    while (((Iterator)localObject).hasNext())
    {
      pt localpt = (pt)((Iterator)localObject).next();
      try
      {
        localArrayList.add(localpt.toByteArray());
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
  
  public final long bol()
  {
    AppMethodBeat.i(242870);
    bot localbot = (bot)d.c.b(this.rr.lBS);
    if (localbot.Tay != null)
    {
      long l = localbot.Tay.SrF;
      AppMethodBeat.o(242870);
      return l;
    }
    AppMethodBeat.o(242870);
    return -1L;
  }
  
  public final List<ckf> bom()
  {
    AppMethodBeat.i(242871);
    LinkedList localLinkedList = ((bot)d.c.b(this.rr.lBS)).SZV;
    AppMethodBeat.o(242871);
    return localLinkedList;
  }
  
  public final int bon()
  {
    AppMethodBeat.i(242873);
    int i = ((bos)d.b.b(this.rr.lBR)).Tag;
    AppMethodBeat.o(242873);
    return i;
  }
  
  public final byte[] bop()
  {
    AppMethodBeat.i(150936);
    Object localObject = (bot)d.c.b(this.rr.lBS);
    if (((bot)localObject).Taj == null)
    {
      AppMethodBeat.o(150936);
      return new byte[0];
    }
    try
    {
      localObject = z.a(((bot)localObject).Taj);
      AppMethodBeat.o(150936);
      return localObject;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(150936);
    }
    return new byte[0];
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(150931);
    this.callback = parami;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(150931);
    return i;
  }
  
  public final String getContent()
  {
    AppMethodBeat.i(242864);
    String str = ((bot)d.c.b(this.rr.lBS)).lpy;
    AppMethodBeat.o(242864);
    return str;
  }
  
  public final String getTitle()
  {
    AppMethodBeat.i(242862);
    String str = ((bot)d.c.b(this.rr.lBS)).fwr;
    AppMethodBeat.o(242862);
    return str;
  }
  
  public final int getType()
  {
    return 233;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(150932);
    Log.d("MicroMsg.NetSceneGetA8Key", "dkwt geta8key onGYNetEnd:[%d,%d] url:[%s]  a8key:[%s]", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), bof(), ((bot)d.c.b(this.rr.lBS)).Tap });
    Log.d("MicroMsg.NetSceneGetA8Key", "a8KeyCookie:%s", new Object[] { Util.encodeHexString(bop()) });
    this.lZf.putLong("CgiSpeedOutSideStructStartTimeStamp", this.lZe);
    this.lZf.putLong("CgiSpeedOutSideStructEndTimeStamp", System.currentTimeMillis());
    this.lZf.putLong("CgiSpeedOutSideStructCostTime", SystemClock.elapsedRealtime() - this.lZd);
    this.lZf.putInt("CgiSpeedOutSideStructCgiNo", 233);
    this.lZf.putInt("CgiSpeedOutSideStructRet", paramInt3);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(150932);
  }
  
  public final void setSubScene(int paramInt)
  {
    AppMethodBeat.i(242877);
    ((bos)d.b.b(this.rr.lBR)).RKI = paramInt;
    AppMethodBeat.o(242877);
  }
  
  public static final class a
  {
    static d a(a parama)
    {
      AppMethodBeat.i(150920);
      d.a locala = new d.a();
      locala.lBU = new bos();
      locala.lBV = new bot();
      switch (l.1.lZg[parama.ordinal()])
      {
      default: 
        locala.uri = "/cgi-bin/micromsg-bin/3rd-geta8key";
        locala.funcId = 226;
        locala.lBW = 388;
        locala.respCmdId = 1000000388;
      }
      for (;;)
      {
        parama = locala.bgN();
        AppMethodBeat.o(150920);
        return parama;
        locala.uri = "/cgi-bin/micromsg-bin/geta8key";
        locala.funcId = 233;
        locala.lBW = 155;
        locala.respCmdId = 1000000155;
        continue;
        locala.uri = "/cgi-bin/micromsg-bin/mp-geta8key";
        locala.funcId = 238;
        locala.lBW = 345;
        locala.respCmdId = 1000000345;
        continue;
        locala.uri = "/cgi-bin/micromsg-bin/pay-geta8key";
        locala.funcId = 835;
        locala.lBW = 346;
        locala.respCmdId = 1000000346;
        continue;
        locala.uri = "/cgi-bin/micromsg-bin/minor-geta8key";
        locala.funcId = 812;
        locala.lBW = 387;
        locala.respCmdId = 1000000387;
        continue;
        locala.uri = "/cgi-bin/micromsg-bin/3rd-geta8key";
        locala.funcId = 226;
        locala.lBW = 388;
        locala.respCmdId = 1000000388;
      }
    }
    
    private static d a(a parama, String paramString, int paramInt)
    {
      AppMethodBeat.i(190675);
      a locala = parama;
      if (parama == a.lZh) {
        locala = aM(paramString, paramInt);
      }
      Log.i("MicroMsg.NetSceneGetA8Key", "getCommReqRespFromReqUrl reqUrl=%s, type=%s, reason=%d", new Object[] { paramString, locala, Integer.valueOf(paramInt) });
      parama = g(a(locala));
      AppMethodBeat.o(190675);
      return parama;
    }
    
    public static d aL(String paramString, int paramInt)
    {
      AppMethodBeat.i(190678);
      paramString = a(a.lZh, paramString, paramInt);
      AppMethodBeat.o(190678);
      return paramString;
    }
    
    private static a aM(String paramString, int paramInt)
    {
      AppMethodBeat.i(150921);
      if (paramInt == 5)
      {
        paramString = a.lZl;
        AppMethodBeat.o(150921);
        return paramString;
      }
      if (Util.isNullOrNil(paramString))
      {
        Log.i("MicroMsg.NetSceneGetA8Key", "getTypeFromUrl reqUrl is null, getA8Key");
        paramString = a.lZi;
        AppMethodBeat.o(150921);
        return paramString;
      }
      try
      {
        Object localObject = Uri.parse(paramString);
        if (localObject == null)
        {
          paramString = a.lZm;
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
          paramString = a.lZj;
          AppMethodBeat.o(150921);
          return paramString;
        }
        if (((String)localObject).contains("wechat_pay"))
        {
          paramString = a.lZk;
          AppMethodBeat.o(150921);
          return paramString;
        }
        if ((str.contains(".qq.com")) || (str.equals("qq.com")) || (str.contains(".wechat.com")) || (str.equals("wechat.com")) || (str.contains(".tenpay.com")) || (str.equals("tenpay.com")) || (str.contains(".url.cn")) || (str.equals("url.com")) || ((!paramString.startsWith("http://")) && (!paramString.startsWith("https://"))))
        {
          paramString = a.lZi;
          AppMethodBeat.o(150921);
          return paramString;
        }
        paramString = a.lZm;
        AppMethodBeat.o(150921);
        return paramString;
      }
      catch (Exception paramString)
      {
        Log.e("MicroMsg.NetSceneGetA8Key", "getTypeFromUrl parse uri fail %s", new Object[] { paramString.getMessage() });
        paramString = a.lZi;
        AppMethodBeat.o(150921);
      }
      return paramString;
    }
    
    public static d g(d paramd)
    {
      AppMethodBeat.i(150922);
      if ((MMApplicationContext.isMainProcess()) && (h.aHB()))
      {
        bos localbos = (bos)d.b.b(paramd.lBR);
        h.aHH();
        String str1 = Util.nullAsNil((String)h.aHG().aHp().b(46, null));
        localbos.RMd = new eae().dc(Util.decodeHexString(str1));
        h.aHH();
        String str2 = Util.nullAsNil((String)h.aHG().aHp().b(72, null));
        localbos.Taf = new eae().dc(Util.decodeHexString(str2));
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
        lZh = new a("AutoRoute", 0);
        lZi = new a("GetA8Key", 1);
        lZj = new a("MpGetA8Key", 2);
        lZk = new a("PayGetA8Key", 3);
        lZl = new a("MinorGetA8Key", 4);
        lZm = new a("ThridGetA8Key", 5);
        lZn = new a[] { lZh, lZi, lZj, lZk, lZl, lZm };
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