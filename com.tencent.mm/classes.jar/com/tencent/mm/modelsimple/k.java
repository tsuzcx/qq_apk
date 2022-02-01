package com.tencent.mm.modelsimple;

import android.net.Uri;
import android.os.Bundle;
import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.acm;
import com.tencent.mm.protocal.protobuf.avi;
import com.tencent.mm.protocal.protobuf.avj;
import com.tencent.mm.protocal.protobuf.bos;
import com.tencent.mm.protocal.protobuf.cwt;
import com.tencent.mm.protocal.protobuf.oy;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class k
  extends n
  implements com.tencent.mm.network.k
{
  private f callback;
  private final long ilg;
  private final long ilh;
  public final Bundle ili;
  public final b rr;
  public Object tag;
  
  private k()
  {
    AppMethodBeat.i(150923);
    this.ilg = SystemClock.elapsedRealtime();
    this.ilh = System.currentTimeMillis();
    this.ili = new Bundle();
    this.rr = a.f(a.a(k.a.a.ill));
    AppMethodBeat.o(150923);
  }
  
  public k(int paramInt1, int paramInt2)
  {
    this();
    AppMethodBeat.i(150930);
    avi localavi = (avi)this.rr.hNK.hNQ;
    localavi.OpCode = 3;
    localavi.Scene = 5;
    localavi.GtV = paramInt1;
    localavi.GtY = paramInt2;
    ad.d("MicroMsg.NetSceneGetA8Key", "dkwt geta8key friendQQNum:%d  a2key-len:%d requestId", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(localavi.Fzc.getILen()), Integer.valueOf(paramInt2) });
    AppMethodBeat.o(150930);
  }
  
  private k(k.a.a parama)
  {
    AppMethodBeat.i(150925);
    this.ilg = SystemClock.elapsedRealtime();
    this.ilh = System.currentTimeMillis();
    this.ili = new Bundle();
    this.rr = a.a(parama);
    AppMethodBeat.o(150925);
  }
  
  private k(String paramString, int paramInt)
  {
    AppMethodBeat.i(150924);
    this.ilg = SystemClock.elapsedRealtime();
    this.ilh = System.currentTimeMillis();
    this.ili = new Bundle();
    this.rr = a.ao(paramString, paramInt);
    AppMethodBeat.o(150924);
  }
  
  public k(String paramString1, int paramInt1, int paramInt2, int paramInt3, String paramString2, int paramInt4, byte[] paramArrayOfByte)
  {
    this(paramString1, 0);
    AppMethodBeat.i(150928);
    avi localavi = (avi)this.rr.hNK.hNQ;
    localavi.OpCode = 2;
    localavi.GtT = new cwt().aPy(paramString1);
    localavi.Scene = paramInt1;
    localavi.nDo = null;
    localavi.FzW = 0;
    localavi.FVR = paramInt2;
    localavi.FVS = paramInt3;
    localavi.GtY = paramInt4;
    localavi.GtQ = new cwt().aPy(paramString2);
    localavi.Gub = new SKBuiltinBuffer_t().setBuffer(paramArrayOfByte);
    ad.d("MicroMsg.NetSceneGetA8Key", "get a8key reqUrl = " + paramString1 + ", username = " + null + ", scene = " + paramInt1 + ", reason = 0, codeType = " + paramInt2 + ", codeVersion = " + paramInt3 + ", requestId = " + paramInt4);
    ad.d("MicroMsg.NetSceneGetA8Key", "a8KeyCookie = %s", new Object[] { bt.cE(paramArrayOfByte) });
    AppMethodBeat.o(150928);
  }
  
  public k(String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, String paramString3, int paramInt4, String paramString4, String paramString5, int paramInt5, byte[] paramArrayOfByte)
  {
    this(paramString1, paramInt2);
    AppMethodBeat.i(150929);
    avi localavi = (avi)this.rr.hNK.hNQ;
    localavi.OpCode = 2;
    localavi.GtT = new cwt().aPy(paramString1);
    localavi.Scene = paramInt1;
    localavi.nDo = paramString2;
    localavi.FzW = paramInt2;
    localavi.FuX = paramInt3;
    localavi.orm = paramString3;
    localavi.GtY = paramInt4;
    localavi.GtZ = paramString5;
    localavi.Gua = paramInt5;
    localavi.GtQ = new cwt().aPy(paramString4);
    localavi.Gub = new SKBuiltinBuffer_t().setBuffer(paramArrayOfByte);
    ad.i("MicroMsg.NetSceneGetA8Key", "get a8key reqUrl = %s, username = %s, scene = %d, reason = %d, flag = %d, netType = %s, requestId = %d, appId = %s, functionId = %s, wallentRegion = %d, a8KeyCookie = %s", new Object[] { paramString1, paramString2, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString3, Integer.valueOf(paramInt4), paramString4, paramString5, Integer.valueOf(paramInt5), bt.cE(paramArrayOfByte) });
    AppMethodBeat.o(150929);
  }
  
  public k(String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, byte[] paramArrayOfByte)
  {
    this(paramString1, paramInt2);
    AppMethodBeat.i(150927);
    avi localavi = (avi)this.rr.hNK.hNQ;
    localavi.OpCode = 2;
    localavi.GtT = new cwt().aPy(paramString1);
    localavi.Scene = paramInt1;
    localavi.nDo = paramString2;
    localavi.FzW = paramInt2;
    localavi.GtY = paramInt3;
    localavi.Gub = new SKBuiltinBuffer_t().setBuffer(paramArrayOfByte);
    ad.d("MicroMsg.NetSceneGetA8Key", "get a8key reqUrl = " + paramString1 + ", username = " + paramString2 + ", scene = " + paramInt1 + ", reason = " + paramInt2 + ", requestId = " + paramInt3);
    ad.d("MicroMsg.NetSceneGetA8Key", "a8KeyCookie = %s", new Object[] { bt.cE(paramArrayOfByte) });
    AppMethodBeat.o(150927);
  }
  
  public k(String paramString1, String paramString2, String paramString3, int paramInt)
  {
    this(k.a.a.ilm);
    AppMethodBeat.i(150926);
    avi localavi = (avi)this.rr.hNK.hNQ;
    localavi.OpCode = 1;
    localavi.GtQ = new cwt().aPy(paramString1);
    localavi.GtR = new cwt().aPy(paramString2);
    localavi.GtS = new cwt().aPy(paramString3);
    localavi.GtY = paramInt;
    ad.d("MicroMsg.NetSceneGetA8Key", "get a8key appid=%s requestId=%d", new Object[] { paramString1, Integer.valueOf(paramInt) });
    AppMethodBeat.o(150926);
  }
  
  public static final int aKA()
  {
    AppMethodBeat.i(150935);
    int i = (int)System.currentTimeMillis();
    AppMethodBeat.o(150935);
    return i;
  }
  
  public final void Gl(String paramString)
  {
    ((avi)this.rr.hNK.hNQ).GtA = paramString;
  }
  
  public final byte[] aKB()
  {
    AppMethodBeat.i(150936);
    Object localObject = (avj)this.rr.hNL.hNQ;
    if (((avj)localObject).Gub == null)
    {
      AppMethodBeat.o(150936);
      return new byte[0];
    }
    try
    {
      localObject = z.a(((avj)localObject).Gub);
      AppMethodBeat.o(150936);
      return localObject;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(150936);
    }
    return new byte[0];
  }
  
  public final String aKr()
  {
    return ((avj)this.rr.hNL.hNQ).Guc;
  }
  
  public final String aKs()
  {
    cwt localcwt = ((avi)this.rr.hNK.hNQ).GtT;
    if (localcwt != null) {
      return localcwt.HoB;
    }
    return null;
  }
  
  public final int aKt()
  {
    return ((avj)this.rr.hNL.hNQ).FqN;
  }
  
  public final byte[] aKu()
  {
    AppMethodBeat.i(150933);
    Object localObject = (avj)this.rr.hNL.hNQ;
    if (((avj)localObject).Gul == null)
    {
      AppMethodBeat.o(150933);
      return null;
    }
    try
    {
      localObject = z.a(((avj)localObject).Gul);
      AppMethodBeat.o(150933);
      return localObject;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(150933);
    }
    return null;
  }
  
  public final String aKv()
  {
    return ((avj)this.rr.hNL.hNQ).Gug;
  }
  
  public final ArrayList<byte[]> aKw()
  {
    AppMethodBeat.i(150934);
    Object localObject = (avj)this.rr.hNL.hNQ;
    ArrayList localArrayList = new ArrayList();
    if ((localObject == null) || (((avj)localObject).Gui == null))
    {
      AppMethodBeat.o(150934);
      return localArrayList;
    }
    localObject = ((avj)localObject).Gui.iterator();
    while (((Iterator)localObject).hasNext())
    {
      oy localoy = (oy)((Iterator)localObject).next();
      try
      {
        localArrayList.add(localoy.toByteArray());
      }
      catch (IOException localIOException)
      {
        ad.e("MicroMsg.NetSceneGetA8Key", "exception:%s", new Object[] { bt.n(localIOException) });
      }
    }
    ad.d("MicroMsg.NetSceneGetA8Key", "ScopeList size = %s", new Object[] { Integer.valueOf(localArrayList.size()) });
    AppMethodBeat.o(150934);
    return localArrayList;
  }
  
  public final long aKx()
  {
    avj localavj = (avj)this.rr.hNL.hNQ;
    if (localavj.Guk != null) {
      return localavj.Guk.GbW;
    }
    return -1L;
  }
  
  public final List<bos> aKy()
  {
    return ((avj)this.rr.hNL.hNQ).GtM;
  }
  
  public final int aKz()
  {
    return ((avi)this.rr.hNK.hNQ).GtY;
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
    return ((avj)this.rr.hNL.hNQ).hDa;
  }
  
  public final String getTitle()
  {
    return ((avj)this.rr.hNL.hNQ).Title;
  }
  
  public final int getType()
  {
    return 233;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(150932);
    ad.d("MicroMsg.NetSceneGetA8Key", "dkwt geta8key onGYNetEnd:[%d,%d] url:[%s]  a8key:[%s]", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), aKr(), ((avj)this.rr.hNL.hNQ).Gud });
    ad.d("MicroMsg.NetSceneGetA8Key", "a8KeyCookie:%s", new Object[] { bt.cE(aKB()) });
    this.ili.putLong("CgiSpeedOutSideStructStartTimeStamp", this.ilh);
    this.ili.putLong("CgiSpeedOutSideStructEndTimeStamp", System.currentTimeMillis());
    this.ili.putLong("CgiSpeedOutSideStructCostTime", SystemClock.elapsedRealtime() - this.ilg);
    this.ili.putInt("CgiSpeedOutSideStructCgiNo", 233);
    this.ili.putInt("CgiSpeedOutSideStructRet", paramInt3);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(150932);
  }
  
  public final void setSubScene(int paramInt)
  {
    ((avi)this.rr.hNK.hNQ).FxO = paramInt;
  }
  
  public static final class a
  {
    static b a(a parama)
    {
      AppMethodBeat.i(150920);
      b.a locala = new b.a();
      locala.hNM = new avi();
      locala.hNN = new avj();
      switch (k.1.ilj[parama.ordinal()])
      {
      default: 
        locala.uri = "/cgi-bin/micromsg-bin/3rd-geta8key";
        locala.funcId = 226;
        locala.hNO = 388;
        locala.respCmdId = 1000000388;
      }
      for (;;)
      {
        parama = locala.aDC();
        AppMethodBeat.o(150920);
        return parama;
        locala.uri = "/cgi-bin/micromsg-bin/geta8key";
        locala.funcId = 233;
        locala.hNO = 155;
        locala.respCmdId = 1000000155;
        continue;
        locala.uri = "/cgi-bin/micromsg-bin/mp-geta8key";
        locala.funcId = 238;
        locala.hNO = 345;
        locala.respCmdId = 1000000345;
        continue;
        locala.uri = "/cgi-bin/micromsg-bin/pay-geta8key";
        locala.funcId = 835;
        locala.hNO = 346;
        locala.respCmdId = 1000000346;
        continue;
        locala.uri = "/cgi-bin/micromsg-bin/minor-geta8key";
        locala.funcId = 812;
        locala.hNO = 387;
        locala.respCmdId = 1000000387;
        continue;
        locala.uri = "/cgi-bin/micromsg-bin/3rd-geta8key";
        locala.funcId = 226;
        locala.hNO = 388;
        locala.respCmdId = 1000000388;
      }
    }
    
    private static b a(a parama, String paramString, int paramInt)
    {
      AppMethodBeat.i(195290);
      a locala = parama;
      if (parama == a.ilk) {
        locala = ap(paramString, paramInt);
      }
      ad.i("MicroMsg.NetSceneGetA8Key", "getCommReqRespFromReqUrl reqUrl=%s, type=%s, reason=%d", new Object[] { paramString, locala, Integer.valueOf(paramInt) });
      parama = f(a(locala));
      AppMethodBeat.o(195290);
      return parama;
    }
    
    public static b ao(String paramString, int paramInt)
    {
      AppMethodBeat.i(195291);
      paramString = a(a.ilk, paramString, paramInt);
      AppMethodBeat.o(195291);
      return paramString;
    }
    
    private static a ap(String paramString, int paramInt)
    {
      AppMethodBeat.i(150921);
      if (paramInt == 5)
      {
        paramString = a.ilo;
        AppMethodBeat.o(150921);
        return paramString;
      }
      if (bt.isNullOrNil(paramString))
      {
        ad.i("MicroMsg.NetSceneGetA8Key", "getTypeFromUrl reqUrl is null, getA8Key");
        paramString = a.ill;
        AppMethodBeat.o(150921);
        return paramString;
      }
      try
      {
        Object localObject = Uri.parse(paramString);
        if (localObject == null)
        {
          paramString = a.ilp;
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
          paramString = a.ilm;
          AppMethodBeat.o(150921);
          return paramString;
        }
        if (((String)localObject).contains("wechat_pay"))
        {
          paramString = a.iln;
          AppMethodBeat.o(150921);
          return paramString;
        }
        if ((str.contains(".qq.com")) || (str.equals("qq.com")) || (str.contains(".wechat.com")) || (str.equals("wechat.com")) || (str.contains(".tenpay.com")) || (str.equals("tenpay.com")) || (str.contains(".url.cn")) || (str.equals("url.com")) || ((!paramString.startsWith("http://")) && (!paramString.startsWith("https://"))))
        {
          paramString = a.ill;
          AppMethodBeat.o(150921);
          return paramString;
        }
        paramString = a.ilp;
        AppMethodBeat.o(150921);
        return paramString;
      }
      catch (Exception paramString)
      {
        ad.e("MicroMsg.NetSceneGetA8Key", "getTypeFromUrl parse uri fail %s", new Object[] { paramString.getMessage() });
        paramString = a.ill;
        AppMethodBeat.o(150921);
      }
      return paramString;
    }
    
    public static b f(b paramb)
    {
      AppMethodBeat.i(150922);
      if ((aj.cmR()) && (g.ajx()))
      {
        avi localavi = (avi)paramb.hNK.hNQ;
        g.ajD();
        String str1 = bt.nullAsNil((String)g.ajC().ajl().get(46, null));
        localavi.Fzc = new SKBuiltinBuffer_t().setBuffer(bt.aRa(str1));
        g.ajD();
        String str2 = bt.nullAsNil((String)g.ajC().ajl().get(72, null));
        localavi.GtX = new SKBuiltinBuffer_t().setBuffer(bt.aRa(str2));
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
        ilk = new a("AutoRoute", 0);
        ill = new a("GetA8Key", 1);
        ilm = new a("MpGetA8Key", 2);
        iln = new a("PayGetA8Key", 3);
        ilo = new a("MinorGetA8Key", 4);
        ilp = new a("ThridGetA8Key", 5);
        ilq = new a[] { ilk, ill, ilm, iln, ilo, ilp };
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