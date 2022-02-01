package com.tencent.mm.plugin.lite.logic;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.c;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi.a;
import com.tencent.mm.modelsimple.k.a;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.avi;
import com.tencent.mm.protocal.protobuf.avj;
import com.tencent.mm.protocal.protobuf.bos;
import com.tencent.mm.protocal.protobuf.cwt;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public enum b
{
  private Map<String, a> rcP;
  private byte[] uYJ;
  
  static
  {
    AppMethodBeat.i(217185);
    uYI = new b("INSTANCE");
    uYK = new b[] { uYI };
    AppMethodBeat.o(217185);
  }
  
  private b()
  {
    AppMethodBeat.i(217181);
    this.uYJ = new byte[0];
    this.rcP = new ConcurrentHashMap();
    AppMethodBeat.o(217181);
  }
  
  private com.tencent.mm.al.b aox(String paramString)
  {
    AppMethodBeat.i(217183);
    int i = (int)System.currentTimeMillis();
    com.tencent.mm.al.b localb = k.a.ao(paramString, 0);
    avi localavi = (avi)localb.hNK.hNQ;
    localavi.OpCode = 2;
    localavi.GtT = new cwt().aPy(paramString);
    localavi.Scene = 0;
    localavi.nDo = "";
    localavi.FzW = 0;
    localavi.FuX = 0;
    localavi.orm = dfE();
    localavi.GtY = i;
    localavi.GtZ = "";
    localavi.Gua = 0;
    localavi.GtQ = new cwt().aPy("");
    localavi.Gub = new SKBuiltinBuffer_t().setBuffer(this.uYJ);
    AppMethodBeat.o(217183);
    return localb;
  }
  
  private static String dfE()
  {
    AppMethodBeat.i(217184);
    Object localObject = (ConnectivityManager)aj.getContext().getSystemService("connectivity");
    if (localObject == null)
    {
      AppMethodBeat.o(217184);
      return "no";
    }
    localObject = ((ConnectivityManager)localObject).getActiveNetworkInfo();
    if (localObject == null)
    {
      AppMethodBeat.o(217184);
      return "no";
    }
    if (((NetworkInfo)localObject).getType() == 1)
    {
      AppMethodBeat.o(217184);
      return "WIFI";
    }
    if (((NetworkInfo)localObject).getExtraInfo() != null)
    {
      localObject = ((NetworkInfo)localObject).getExtraInfo().toLowerCase();
      AppMethodBeat.o(217184);
      return localObject;
    }
    AppMethodBeat.o(217184);
    return "no";
  }
  
  public final void a(final String paramString, final b paramb)
  {
    AppMethodBeat.i(217182);
    com.tencent.mm.al.b localb = aox(paramString);
    ad.i("LiteApp.LiteAppGetA8Key", "url:".concat(String.valueOf(paramString)));
    IPCRunCgi.a(localb, null, new IPCRunCgi.a()
    {
      public final void a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.al.b paramAnonymousb)
      {
        AppMethodBeat.i(217177);
        ad.i("LiteApp.LiteAppGetA8Key", "errType:%d errCode:%d ", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
        if ((paramAnonymousb.hNL.hNQ instanceof avj))
        {
          paramAnonymousb = (avj)paramAnonymousb.hNL.hNQ;
          ad.i("LiteApp.LiteAppGetA8Key", "fullurl:" + paramAnonymousb.Guc);
          if (paramAnonymousb.Guc == null)
          {
            if (paramb != null) {
              paramb.onError();
            }
            AppMethodBeat.o(217177);
            return;
          }
          paramAnonymousInt1 = paramAnonymousb.Guc.indexOf("?");
          if ((paramAnonymousInt1 < 0) || (paramAnonymousInt1 + 1 >= paramAnonymousb.Guc.length()))
          {
            ad.e("LiteApp.LiteAppGetA8Key", "paramPos invalid");
            if (paramb != null) {
              paramb.onError();
            }
            AppMethodBeat.o(217177);
            return;
          }
          Object localObject = paramAnonymousb.Guc.substring(paramAnonymousInt1 + 1).split("&");
          if (localObject == null)
          {
            ad.e("LiteApp.LiteAppGetA8Key", "params invalid");
            if (paramb != null) {
              paramb.onError();
            }
            AppMethodBeat.o(217177);
            return;
          }
          paramAnonymousString = new b.a(b.this);
          paramAnonymousInt2 = localObject.length;
          paramAnonymousInt1 = 0;
          if (paramAnonymousInt1 < paramAnonymousInt2)
          {
            String str2 = localObject[paramAnonymousInt1];
            if ((str2.startsWith("key")) || (str2.startsWith("uin")) || (str2.startsWith("pass_ticket"))) {
              if (paramAnonymousString.uYN != null) {
                break label356;
              }
            }
            label356:
            for (paramAnonymousString.uYN = str2;; paramAnonymousString.uYN = (paramAnonymousString.uYN + "&" + str2))
            {
              int i = str2.indexOf('=');
              if (i >= 0)
              {
                String str1 = str2.substring(0, i).trim();
                str2 = str2.substring(i + 1).trim();
                paramAnonymousString.uYO.put(str1, str2);
              }
              paramAnonymousInt1 += 1;
              break;
            }
          }
          paramAnonymousb = paramAnonymousb.GtM.iterator();
          while (paramAnonymousb.hasNext())
          {
            localObject = (bos)paramAnonymousb.next();
            paramAnonymousString.mHeaders.put(((bos)localObject).ujy, ((bos)localObject).yhw);
          }
          b.a(b.this).put(paramString, paramAnonymousString);
          if (paramb != null) {
            paramb.a(paramAnonymousString);
          }
          AppMethodBeat.o(217177);
          return;
        }
        ad.e("LiteApp.LiteAppGetA8Key", "getA8Key call back resp is null");
        if (paramb != null) {
          paramb.onError();
        }
        AppMethodBeat.o(217177);
      }
    });
    AppMethodBeat.o(217182);
  }
  
  public final class a
  {
    public Map<String, String> mHeaders;
    public String uYN;
    public Map<String, String> uYO;
    
    public a()
    {
      AppMethodBeat.i(217178);
      this.mHeaders = new HashMap();
      this.uYO = new HashMap();
      AppMethodBeat.o(217178);
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