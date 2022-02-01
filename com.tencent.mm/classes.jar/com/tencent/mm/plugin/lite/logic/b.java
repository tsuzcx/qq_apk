package com.tencent.mm.plugin.lite.logic;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi.a;
import com.tencent.mm.modelsimple.k.a;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.arm;
import com.tencent.mm.protocal.protobuf.arn;
import com.tencent.mm.protocal.protobuf.bki;
import com.tencent.mm.protocal.protobuf.crm;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public enum b
{
  private Map<String, a> qtb;
  private byte[] tWa;
  
  static
  {
    AppMethodBeat.i(205708);
    tVZ = new b("INSTANCE");
    tWb = new b[] { tVZ };
    AppMethodBeat.o(205708);
  }
  
  private b()
  {
    AppMethodBeat.i(205704);
    this.tWa = new byte[0];
    this.qtb = new ConcurrentHashMap();
    AppMethodBeat.o(205704);
  }
  
  private com.tencent.mm.ak.b ajK(String paramString)
  {
    AppMethodBeat.i(205706);
    int i = (int)System.currentTimeMillis();
    com.tencent.mm.ak.b localb = k.a.am(paramString, 0);
    arm localarm = (arm)localb.hvr.hvw;
    localarm.OpCode = 2;
    localarm.EKQ = new crm().aJV(paramString);
    localarm.Scene = 0;
    localarm.ncR = "";
    localarm.DUB = 0;
    localarm.DPI = 0;
    localarm.nOG = cWt();
    localarm.EKV = i;
    localarm.EKW = "";
    localarm.EKX = 0;
    localarm.EKN = new crm().aJV("");
    localarm.EKY = new SKBuiltinBuffer_t().setBuffer(this.tWa);
    AppMethodBeat.o(205706);
    return localb;
  }
  
  private static String cWt()
  {
    AppMethodBeat.i(205707);
    Object localObject = (ConnectivityManager)ai.getContext().getSystemService("connectivity");
    if (localObject == null)
    {
      AppMethodBeat.o(205707);
      return "no";
    }
    localObject = ((ConnectivityManager)localObject).getActiveNetworkInfo();
    if (localObject == null)
    {
      AppMethodBeat.o(205707);
      return "no";
    }
    if (((NetworkInfo)localObject).getType() == 1)
    {
      AppMethodBeat.o(205707);
      return "WIFI";
    }
    if (((NetworkInfo)localObject).getExtraInfo() != null)
    {
      localObject = ((NetworkInfo)localObject).getExtraInfo().toLowerCase();
      AppMethodBeat.o(205707);
      return localObject;
    }
    AppMethodBeat.o(205707);
    return "no";
  }
  
  public final void a(final String paramString, final b paramb)
  {
    AppMethodBeat.i(205705);
    com.tencent.mm.ak.b localb = ajK(paramString);
    ac.i("LiteApp.LiteAppGetA8Key", "url:".concat(String.valueOf(paramString)));
    IPCRunCgi.a(localb, null, new IPCRunCgi.a()
    {
      public final void a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.ak.b paramAnonymousb)
      {
        AppMethodBeat.i(205700);
        ac.i("LiteApp.LiteAppGetA8Key", "errType:%d errCode:%d ", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
        if ((paramAnonymousb.hvs.hvw instanceof arn))
        {
          paramAnonymousb = (arn)paramAnonymousb.hvs.hvw;
          ac.i("LiteApp.LiteAppGetA8Key", "fullurl:" + paramAnonymousb.EKZ);
          if (paramAnonymousb.EKZ == null)
          {
            if (paramb != null) {
              paramb.onError();
            }
            AppMethodBeat.o(205700);
            return;
          }
          paramAnonymousInt1 = paramAnonymousb.EKZ.indexOf("?");
          if ((paramAnonymousInt1 < 0) || (paramAnonymousInt1 + 1 >= paramAnonymousb.EKZ.length()))
          {
            ac.e("LiteApp.LiteAppGetA8Key", "paramPos invalid");
            if (paramb != null) {
              paramb.onError();
            }
            AppMethodBeat.o(205700);
            return;
          }
          Object localObject = paramAnonymousb.EKZ.substring(paramAnonymousInt1 + 1).split("&");
          if (localObject == null)
          {
            ac.e("LiteApp.LiteAppGetA8Key", "params invalid");
            if (paramb != null) {
              paramb.onError();
            }
            AppMethodBeat.o(205700);
            return;
          }
          paramAnonymousString = new b.a(b.this);
          paramAnonymousInt2 = localObject.length;
          paramAnonymousInt1 = 0;
          if (paramAnonymousInt1 < paramAnonymousInt2)
          {
            String str2 = localObject[paramAnonymousInt1];
            if ((str2.startsWith("key")) || (str2.startsWith("uin")) || (str2.startsWith("pass_ticket"))) {
              if (paramAnonymousString.tWe != null) {
                break label356;
              }
            }
            label356:
            for (paramAnonymousString.tWe = str2;; paramAnonymousString.tWe = (paramAnonymousString.tWe + "&" + str2))
            {
              int i = str2.indexOf('=');
              if (i >= 0)
              {
                String str1 = str2.substring(0, i).trim();
                str2 = str2.substring(i + 1).trim();
                paramAnonymousString.tWf.put(str1, str2);
              }
              paramAnonymousInt1 += 1;
              break;
            }
          }
          paramAnonymousb = paramAnonymousb.EKJ.iterator();
          while (paramAnonymousb.hasNext())
          {
            localObject = (bki)paramAnonymousb.next();
            paramAnonymousString.mHeaders.put(((bki)localObject).tlp, ((bki)localObject).wTM);
          }
          b.a(b.this).put(paramString, paramAnonymousString);
          if (paramb != null) {
            paramb.onSuccess(paramAnonymousString);
          }
          AppMethodBeat.o(205700);
          return;
        }
        ac.e("LiteApp.LiteAppGetA8Key", "getA8Key call back resp is null");
        if (paramb != null) {
          paramb.onError();
        }
        AppMethodBeat.o(205700);
      }
    });
    AppMethodBeat.o(205705);
  }
  
  public final class a
  {
    public Map<String, String> mHeaders;
    public String tWe;
    public Map<String, String> tWf;
    
    public a()
    {
      AppMethodBeat.i(205701);
      this.mHeaders = new HashMap();
      this.tWf = new HashMap();
      AppMethodBeat.o(205701);
    }
  }
  
  public static abstract interface b
  {
    public abstract void onError();
    
    public abstract void onSuccess(b.a parama);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.lite.logic.b
 * JD-Core Version:    0.7.0.1
 */