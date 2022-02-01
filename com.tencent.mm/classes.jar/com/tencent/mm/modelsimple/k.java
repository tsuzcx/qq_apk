package com.tencent.mm.modelsimple;

import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.aam;
import com.tencent.mm.protocal.protobuf.arm;
import com.tencent.mm.protocal.protobuf.arn;
import com.tencent.mm.protocal.protobuf.bki;
import com.tencent.mm.protocal.protobuf.crm;
import com.tencent.mm.protocal.protobuf.nt;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class k
  extends n
  implements com.tencent.mm.network.k
{
  private com.tencent.mm.ak.g callback;
  public final b rr;
  public Object tag;
  
  private k()
  {
    AppMethodBeat.i(150923);
    this.rr = a.f(a.a(k.a.a.hRU));
    AppMethodBeat.o(150923);
  }
  
  public k(int paramInt1, int paramInt2)
  {
    this();
    AppMethodBeat.i(150930);
    arm localarm = (arm)this.rr.hvr.hvw;
    localarm.OpCode = 3;
    localarm.Scene = 5;
    localarm.EKS = paramInt1;
    localarm.EKV = paramInt2;
    ac.d("MicroMsg.NetSceneGetA8Key", "dkwt geta8key friendQQNum:%d  a2key-len:%d requestId", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(localarm.DTI.getILen()), Integer.valueOf(paramInt2) });
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
    this.rr = a.am(paramString, paramInt);
    AppMethodBeat.o(150924);
  }
  
  public k(String paramString1, int paramInt1, int paramInt2, int paramInt3, String paramString2, int paramInt4, byte[] paramArrayOfByte)
  {
    this(paramString1, 0);
    AppMethodBeat.i(150928);
    arm localarm = (arm)this.rr.hvr.hvw;
    localarm.OpCode = 2;
    localarm.EKQ = new crm().aJV(paramString1);
    localarm.Scene = paramInt1;
    localarm.ncR = null;
    localarm.DUB = 0;
    localarm.EoF = paramInt2;
    localarm.EoG = paramInt3;
    localarm.EKV = paramInt4;
    localarm.EKN = new crm().aJV(paramString2);
    localarm.EKY = new SKBuiltinBuffer_t().setBuffer(paramArrayOfByte);
    ac.d("MicroMsg.NetSceneGetA8Key", "get a8key reqUrl = " + paramString1 + ", username = " + null + ", scene = " + paramInt1 + ", reason = 0, codeType = " + paramInt2 + ", codeVersion = " + paramInt3 + ", requestId = " + paramInt4);
    ac.d("MicroMsg.NetSceneGetA8Key", "a8KeyCookie = %s", new Object[] { bs.cx(paramArrayOfByte) });
    AppMethodBeat.o(150928);
  }
  
  public k(String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, String paramString3, int paramInt4, String paramString4, String paramString5, int paramInt5, byte[] paramArrayOfByte)
  {
    this(paramString1, paramInt2);
    AppMethodBeat.i(150929);
    arm localarm = (arm)this.rr.hvr.hvw;
    localarm.OpCode = 2;
    localarm.EKQ = new crm().aJV(paramString1);
    localarm.Scene = paramInt1;
    localarm.ncR = paramString2;
    localarm.DUB = paramInt2;
    localarm.DPI = paramInt3;
    localarm.nOG = paramString3;
    localarm.EKV = paramInt4;
    localarm.EKW = paramString5;
    localarm.EKX = paramInt5;
    localarm.EKN = new crm().aJV(paramString4);
    localarm.EKY = new SKBuiltinBuffer_t().setBuffer(paramArrayOfByte);
    ac.i("MicroMsg.NetSceneGetA8Key", "get a8key reqUrl = %s, username = %s, scene = %d, reason = %d, flag = %d, netType = %s, requestId = %d, appId = %s, functionId = %s, wallentRegion = %d, a8KeyCookie = %s", new Object[] { paramString1, paramString2, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString3, Integer.valueOf(paramInt4), paramString4, paramString5, Integer.valueOf(paramInt5), bs.cx(paramArrayOfByte) });
    AppMethodBeat.o(150929);
  }
  
  public k(String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, byte[] paramArrayOfByte)
  {
    this(paramString1, paramInt2);
    AppMethodBeat.i(150927);
    arm localarm = (arm)this.rr.hvr.hvw;
    localarm.OpCode = 2;
    localarm.EKQ = new crm().aJV(paramString1);
    localarm.Scene = paramInt1;
    localarm.ncR = paramString2;
    localarm.DUB = paramInt2;
    localarm.EKV = paramInt3;
    localarm.EKY = new SKBuiltinBuffer_t().setBuffer(paramArrayOfByte);
    ac.d("MicroMsg.NetSceneGetA8Key", "get a8key reqUrl = " + paramString1 + ", username = " + paramString2 + ", scene = " + paramInt1 + ", reason = " + paramInt2 + ", requestId = " + paramInt3);
    ac.d("MicroMsg.NetSceneGetA8Key", "a8KeyCookie = %s", new Object[] { bs.cx(paramArrayOfByte) });
    AppMethodBeat.o(150927);
  }
  
  public k(String paramString1, String paramString2, String paramString3, int paramInt)
  {
    this(k.a.a.hRV);
    AppMethodBeat.i(150926);
    arm localarm = (arm)this.rr.hvr.hvw;
    localarm.OpCode = 1;
    localarm.EKN = new crm().aJV(paramString1);
    localarm.EKO = new crm().aJV(paramString2);
    localarm.EKP = new crm().aJV(paramString3);
    localarm.EKV = paramInt;
    ac.d("MicroMsg.NetSceneGetA8Key", "get a8key appid=%s requestId=%d", new Object[] { paramString1, Integer.valueOf(paramInt) });
    AppMethodBeat.o(150926);
  }
  
  public static final int aHp()
  {
    AppMethodBeat.i(150935);
    int i = (int)System.currentTimeMillis();
    AppMethodBeat.o(150935);
    return i;
  }
  
  public final void Dg(String paramString)
  {
    ((arm)this.rr.hvr.hvw).EKy = paramString;
  }
  
  public final String aHg()
  {
    return ((arn)this.rr.hvs.hvw).EKZ;
  }
  
  public final String aHh()
  {
    crm localcrm = ((arm)this.rr.hvr.hvw).EKQ;
    if (localcrm != null) {
      return localcrm.FEm;
    }
    return null;
  }
  
  public final int aHi()
  {
    return ((arn)this.rr.hvs.hvw).DLI;
  }
  
  public final byte[] aHj()
  {
    AppMethodBeat.i(150933);
    Object localObject = (arn)this.rr.hvs.hvw;
    if (((arn)localObject).ELi == null)
    {
      AppMethodBeat.o(150933);
      return null;
    }
    try
    {
      localObject = z.a(((arn)localObject).ELi);
      AppMethodBeat.o(150933);
      return localObject;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(150933);
    }
    return null;
  }
  
  public final String aHk()
  {
    return ((arn)this.rr.hvs.hvw).ELd;
  }
  
  public final ArrayList<byte[]> aHl()
  {
    AppMethodBeat.i(150934);
    Object localObject = (arn)this.rr.hvs.hvw;
    ArrayList localArrayList = new ArrayList();
    if ((localObject == null) || (((arn)localObject).ELf == null))
    {
      AppMethodBeat.o(150934);
      return localArrayList;
    }
    localObject = ((arn)localObject).ELf.iterator();
    while (((Iterator)localObject).hasNext())
    {
      nt localnt = (nt)((Iterator)localObject).next();
      try
      {
        localArrayList.add(localnt.toByteArray());
      }
      catch (IOException localIOException)
      {
        ac.e("MicroMsg.NetSceneGetA8Key", "exception:%s", new Object[] { bs.m(localIOException) });
      }
    }
    ac.d("MicroMsg.NetSceneGetA8Key", "ScopeList size = %s", new Object[] { Integer.valueOf(localArrayList.size()) });
    AppMethodBeat.o(150934);
    return localArrayList;
  }
  
  public final long aHm()
  {
    arn localarn = (arn)this.rr.hvs.hvw;
    if (localarn.ELh != null) {
      return localarn.ELh.EuC;
    }
    return -1L;
  }
  
  public final List<bki> aHn()
  {
    return ((arn)this.rr.hvs.hvw).EKJ;
  }
  
  public final int aHo()
  {
    return ((arm)this.rr.hvr.hvw).EKV;
  }
  
  public final byte[] aHq()
  {
    AppMethodBeat.i(150936);
    Object localObject = (arn)this.rr.hvs.hvw;
    if (((arn)localObject).EKY == null)
    {
      AppMethodBeat.o(150936);
      return new byte[0];
    }
    try
    {
      localObject = z.a(((arn)localObject).EKY);
      AppMethodBeat.o(150936);
      return localObject;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(150936);
    }
    return new byte[0];
  }
  
  public final int doScene(com.tencent.mm.network.e parame, com.tencent.mm.ak.g paramg)
  {
    AppMethodBeat.i(150931);
    this.callback = paramg;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(150931);
    return i;
  }
  
  public final String getContent()
  {
    return ((arn)this.rr.hvs.hvw).hkR;
  }
  
  public final String getTitle()
  {
    return ((arn)this.rr.hvs.hvw).Title;
  }
  
  public final int getType()
  {
    return 233;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(150932);
    ac.d("MicroMsg.NetSceneGetA8Key", "dkwt geta8key onGYNetEnd:[%d,%d] url:[%s]  a8key:[%s]", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), aHg(), ((arn)this.rr.hvs.hvw).ELa });
    ac.d("MicroMsg.NetSceneGetA8Key", "a8KeyCookie:%s", new Object[] { bs.cx(aHq()) });
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(150932);
  }
  
  public final void setSubScene(int paramInt)
  {
    ((arm)this.rr.hvr.hvw).DSv = paramInt;
  }
  
  public static final class a
  {
    static b a(a parama)
    {
      AppMethodBeat.i(150920);
      b.a locala = new b.a();
      locala.hvt = new arm();
      locala.hvu = new arn();
      switch (k.1.hRS[parama.ordinal()])
      {
      default: 
        locala.uri = "/cgi-bin/micromsg-bin/3rd-geta8key";
        locala.funcId = 226;
        locala.reqCmdId = 388;
        locala.respCmdId = 1000000388;
      }
      for (;;)
      {
        parama = locala.aAz();
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
      AppMethodBeat.i(192612);
      a locala = parama;
      if (parama == a.hRT) {
        locala = an(paramString, paramInt);
      }
      ac.i("MicroMsg.NetSceneGetA8Key", "getCommReqRespFromReqUrl reqUrl=%s, type=%s, reason=%d", new Object[] { paramString, locala, Integer.valueOf(paramInt) });
      parama = f(a(locala));
      AppMethodBeat.o(192612);
      return parama;
    }
    
    public static b am(String paramString, int paramInt)
    {
      AppMethodBeat.i(192613);
      paramString = a(a.hRT, paramString, paramInt);
      AppMethodBeat.o(192613);
      return paramString;
    }
    
    private static a an(String paramString, int paramInt)
    {
      AppMethodBeat.i(150921);
      if (paramInt == 5)
      {
        paramString = a.hRX;
        AppMethodBeat.o(150921);
        return paramString;
      }
      if (bs.isNullOrNil(paramString))
      {
        ac.i("MicroMsg.NetSceneGetA8Key", "getTypeFromUrl reqUrl is null, getA8Key");
        paramString = a.hRU;
        AppMethodBeat.o(150921);
        return paramString;
      }
      try
      {
        Object localObject = Uri.parse(paramString);
        if (localObject == null)
        {
          paramString = a.hRY;
          AppMethodBeat.o(150921);
          return paramString;
        }
        String str = bs.nullAsNil(((Uri)localObject).getHost()).toLowerCase();
        if (bs.isNullOrNil(((Uri)localObject).getFragment())) {}
        for (localObject = "";; localObject = "#" + ((Uri)localObject).getFragment())
        {
          ac.d("MicroMsg.NetSceneGetA8Key", "get TypeFromUrl domain:%s, fragment:%s", new Object[] { str, localObject });
          if ((!str.equals("open.weixin.qq.com")) && (!str.equals("mp.weixin.qq.com")) && (!str.equals("mp.weixinbridge.com"))) {
            break;
          }
          paramString = a.hRV;
          AppMethodBeat.o(150921);
          return paramString;
        }
        if (((String)localObject).contains("wechat_pay"))
        {
          paramString = a.hRW;
          AppMethodBeat.o(150921);
          return paramString;
        }
        if ((str.contains(".qq.com")) || (str.equals("qq.com")) || (str.contains(".wechat.com")) || (str.equals("wechat.com")) || (str.contains(".tenpay.com")) || (str.equals("tenpay.com")) || (str.contains(".url.cn")) || (str.equals("url.com")) || ((!paramString.startsWith("http://")) && (!paramString.startsWith("https://"))))
        {
          paramString = a.hRU;
          AppMethodBeat.o(150921);
          return paramString;
        }
        paramString = a.hRY;
        AppMethodBeat.o(150921);
        return paramString;
      }
      catch (Exception paramString)
      {
        ac.e("MicroMsg.NetSceneGetA8Key", "getTypeFromUrl parse uri fail %s", new Object[] { paramString.getMessage() });
        paramString = a.hRU;
        AppMethodBeat.o(150921);
      }
      return paramString;
    }
    
    public static b f(b paramb)
    {
      AppMethodBeat.i(150922);
      if ((ai.cin()) && (com.tencent.mm.kernel.g.agM()))
      {
        arm localarm = (arm)paramb.hvr.hvw;
        com.tencent.mm.kernel.g.agS();
        String str1 = bs.nullAsNil((String)com.tencent.mm.kernel.g.agR().agA().get(46, null));
        localarm.DTI = new SKBuiltinBuffer_t().setBuffer(bs.aLu(str1));
        com.tencent.mm.kernel.g.agS();
        String str2 = bs.nullAsNil((String)com.tencent.mm.kernel.g.agR().agA().get(72, null));
        localarm.EKU = new SKBuiltinBuffer_t().setBuffer(bs.aLu(str2));
        ac.d("MicroMsg.NetSceneGetA8Key", "dkwt get a2=" + str1 + " newa2=" + str2);
      }
      AppMethodBeat.o(150922);
      return paramb;
    }
    
    public static enum a
    {
      static
      {
        AppMethodBeat.i(150919);
        hRT = new a("AutoRoute", 0);
        hRU = new a("GetA8Key", 1);
        hRV = new a("MpGetA8Key", 2);
        hRW = new a("PayGetA8Key", 3);
        hRX = new a("MinorGetA8Key", 4);
        hRY = new a("ThridGetA8Key", 5);
        hRZ = new a[] { hRT, hRU, hRV, hRW, hRX, hRY };
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