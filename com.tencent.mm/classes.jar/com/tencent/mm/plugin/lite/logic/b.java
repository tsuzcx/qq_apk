package com.tencent.mm.plugin.lite.logic;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi.a;
import com.tencent.mm.modelsimple.l.a;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.avy;
import com.tencent.mm.protocal.protobuf.avz;
import com.tencent.mm.protocal.protobuf.bpk;
import com.tencent.mm.protocal.protobuf.cxn;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public enum b
{
  private Map<String, a> rkV;
  private byte[] vkz;
  
  static
  {
    AppMethodBeat.i(217798);
    vky = new b("INSTANCE");
    vkA = new b[] { vky };
    AppMethodBeat.o(217798);
  }
  
  private b()
  {
    AppMethodBeat.i(217794);
    this.vkz = new byte[0];
    this.rkV = new ConcurrentHashMap();
    AppMethodBeat.o(217794);
  }
  
  private com.tencent.mm.ak.b apB(String paramString)
  {
    AppMethodBeat.i(217796);
    int i = (int)System.currentTimeMillis();
    com.tencent.mm.ak.b localb = l.a.ap(paramString, 0);
    avy localavy = (avy)localb.hQD.hQJ;
    localavy.OpCode = 2;
    localavy.GNs = new cxn().aQV(paramString);
    localavy.Scene = 0;
    localavy.nIJ = "";
    localavy.FSu = 0;
    localavy.FNv = 0;
    localavy.oxI = diy();
    localavy.GNx = i;
    localavy.GNy = "";
    localavy.GNz = 0;
    localavy.GNp = new cxn().aQV("");
    localavy.GNA = new SKBuiltinBuffer_t().setBuffer(this.vkz);
    AppMethodBeat.o(217796);
    return localb;
  }
  
  private static String diy()
  {
    AppMethodBeat.i(217797);
    Object localObject = (ConnectivityManager)ak.getContext().getSystemService("connectivity");
    if (localObject == null)
    {
      AppMethodBeat.o(217797);
      return "no";
    }
    localObject = ((ConnectivityManager)localObject).getActiveNetworkInfo();
    if (localObject == null)
    {
      AppMethodBeat.o(217797);
      return "no";
    }
    if (((NetworkInfo)localObject).getType() == 1)
    {
      AppMethodBeat.o(217797);
      return "WIFI";
    }
    if (((NetworkInfo)localObject).getExtraInfo() != null)
    {
      localObject = ((NetworkInfo)localObject).getExtraInfo().toLowerCase();
      AppMethodBeat.o(217797);
      return localObject;
    }
    AppMethodBeat.o(217797);
    return "no";
  }
  
  public final void a(final String paramString, final b paramb)
  {
    AppMethodBeat.i(217795);
    com.tencent.mm.ak.b localb = apB(paramString);
    ae.i("LiteApp.LiteAppGetA8Key", "url:".concat(String.valueOf(paramString)));
    IPCRunCgi.a(localb, null, new IPCRunCgi.a()
    {
      public final void a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.ak.b paramAnonymousb)
      {
        AppMethodBeat.i(217790);
        ae.i("LiteApp.LiteAppGetA8Key", "errType:%d errCode:%d ", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
        if ((paramAnonymousb.hQE.hQJ instanceof avz))
        {
          paramAnonymousb = (avz)paramAnonymousb.hQE.hQJ;
          ae.i("LiteApp.LiteAppGetA8Key", "fullurl:" + paramAnonymousb.GNB);
          if (paramAnonymousb.GNB == null)
          {
            if (paramb != null) {
              paramb.onError();
            }
            AppMethodBeat.o(217790);
            return;
          }
          paramAnonymousInt1 = paramAnonymousb.GNB.indexOf("?");
          if ((paramAnonymousInt1 < 0) || (paramAnonymousInt1 + 1 >= paramAnonymousb.GNB.length()))
          {
            ae.e("LiteApp.LiteAppGetA8Key", "paramPos invalid");
            if (paramb != null) {
              paramb.onError();
            }
            AppMethodBeat.o(217790);
            return;
          }
          Object localObject = paramAnonymousb.GNB.substring(paramAnonymousInt1 + 1).split("&");
          if (localObject == null)
          {
            ae.e("LiteApp.LiteAppGetA8Key", "params invalid");
            if (paramb != null) {
              paramb.onError();
            }
            AppMethodBeat.o(217790);
            return;
          }
          paramAnonymousString = new b.a(b.this);
          paramAnonymousInt2 = localObject.length;
          paramAnonymousInt1 = 0;
          if (paramAnonymousInt1 < paramAnonymousInt2)
          {
            String str2 = localObject[paramAnonymousInt1];
            if ((str2.startsWith("key")) || (str2.startsWith("uin")) || (str2.startsWith("pass_ticket"))) {
              if (paramAnonymousString.vkD != null) {
                break label356;
              }
            }
            label356:
            for (paramAnonymousString.vkD = str2;; paramAnonymousString.vkD = (paramAnonymousString.vkD + "&" + str2))
            {
              int i = str2.indexOf('=');
              if (i >= 0)
              {
                String str1 = str2.substring(0, i).trim();
                str2 = str2.substring(i + 1).trim();
                paramAnonymousString.vkE.put(str1, str2);
              }
              paramAnonymousInt1 += 1;
              break;
            }
          }
          paramAnonymousb = paramAnonymousb.GNl.iterator();
          while (paramAnonymousb.hasNext())
          {
            localObject = (bpk)paramAnonymousb.next();
            paramAnonymousString.mHeaders.put(((bpk)localObject).uuW, ((bpk)localObject).yxn);
          }
          b.a(b.this).put(paramString, paramAnonymousString);
          if (paramb != null) {
            paramb.a(paramAnonymousString);
          }
          AppMethodBeat.o(217790);
          return;
        }
        ae.e("LiteApp.LiteAppGetA8Key", "getA8Key call back resp is null");
        if (paramb != null) {
          paramb.onError();
        }
        AppMethodBeat.o(217790);
      }
    });
    AppMethodBeat.o(217795);
  }
  
  public final class a
  {
    public Map<String, String> mHeaders;
    public String vkD;
    public Map<String, String> vkE;
    
    public a()
    {
      AppMethodBeat.i(217791);
      this.mHeaders = new HashMap();
      this.vkE = new HashMap();
      AppMethodBeat.o(217791);
    }
  }
  
  public static abstract interface b
  {
    public abstract void a(b.a parama);
    
    public abstract void onError();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.lite.logic.b
 * JD-Core Version:    0.7.0.1
 */