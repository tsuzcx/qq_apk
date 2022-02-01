package com.tencent.mm.plugin.lite.a;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi.a;
import com.tencent.mm.modelsimple.n.a;
import com.tencent.mm.protocal.protobuf.cde;
import com.tencent.mm.protocal.protobuf.cdf;
import com.tencent.mm.protocal.protobuf.dam;
import com.tencent.mm.protocal.protobuf.etl;
import com.tencent.mm.protocal.protobuf.gol;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public enum a
{
  private byte[] JZn;
  private Map<String, a> onK;
  
  static
  {
    AppMethodBeat.i(271514);
    JZm = new a("INSTANCE");
    JZo = new a[] { JZm };
    AppMethodBeat.o(271514);
  }
  
  private a()
  {
    AppMethodBeat.i(271490);
    this.JZn = new byte[0];
    this.onK = new ConcurrentHashMap();
    AppMethodBeat.o(271490);
  }
  
  private c aJW(String paramString)
  {
    AppMethodBeat.i(271499);
    int i = (int)System.currentTimeMillis();
    c localc = n.a.aW(paramString, 0);
    cde localcde = (cde)c.b.b(localc.otB);
    localcde.YIq = 2;
    localcde.aana = new etl().btH(paramString);
    localcde.IJG = 0;
    localcde.UserName = "";
    localcde.YKo = 0;
    localcde.YFu = 0;
    localcde.vYk = fTX();
    localcde.aane = i;
    localcde.aanf = "";
    localcde.aang = 0;
    localcde.aamX = new etl().btH("");
    localcde.aanh = new gol().df(this.JZn);
    AppMethodBeat.o(271499);
    return localc;
  }
  
  private static String fTX()
  {
    AppMethodBeat.i(271503);
    Object localObject = (ConnectivityManager)MMApplicationContext.getContext().getSystemService("connectivity");
    if (localObject == null)
    {
      AppMethodBeat.o(271503);
      return "no";
    }
    localObject = ((ConnectivityManager)localObject).getActiveNetworkInfo();
    if (localObject == null)
    {
      AppMethodBeat.o(271503);
      return "no";
    }
    if (((NetworkInfo)localObject).getType() == 1)
    {
      AppMethodBeat.o(271503);
      return "WIFI";
    }
    if (((NetworkInfo)localObject).getExtraInfo() != null)
    {
      localObject = ((NetworkInfo)localObject).getExtraInfo().toLowerCase();
      AppMethodBeat.o(271503);
      return localObject;
    }
    AppMethodBeat.o(271503);
    return "no";
  }
  
  public final void a(final String paramString, final b paramb)
  {
    AppMethodBeat.i(271524);
    c localc = aJW(paramString);
    Log.i("LiteApp.LiteAppGetA8Key", "url:".concat(String.valueOf(paramString)));
    IPCRunCgi.a(localc, new IPCRunCgi.a()
    {
      public final void callback(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, c paramAnonymousc)
      {
        AppMethodBeat.i(271488);
        Log.i("LiteApp.LiteAppGetA8Key", "errType:%d errCode:%d ", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
        if ((c.c.b(paramAnonymousc.otC) instanceof cdf))
        {
          paramAnonymousc = (cdf)c.c.b(paramAnonymousc.otC);
          Log.i("LiteApp.LiteAppGetA8Key", "fullurl:" + paramAnonymousc.aanm);
          if (paramAnonymousc.aanm == null)
          {
            if (paramb != null) {
              paramb.atR();
            }
            AppMethodBeat.o(271488);
            return;
          }
          paramAnonymousInt1 = paramAnonymousc.aanm.indexOf("?");
          if ((paramAnonymousInt1 < 0) || (paramAnonymousInt1 + 1 >= paramAnonymousc.aanm.length()))
          {
            Log.e("LiteApp.LiteAppGetA8Key", "paramPos invalid");
            if (paramb != null) {
              paramb.atR();
            }
            AppMethodBeat.o(271488);
            return;
          }
          Object localObject = paramAnonymousc.aanm.substring(paramAnonymousInt1 + 1).split("&");
          if (localObject == null)
          {
            Log.e("LiteApp.LiteAppGetA8Key", "params invalid");
            if (paramb != null) {
              paramb.atR();
            }
            AppMethodBeat.o(271488);
            return;
          }
          paramAnonymousString = new a.a(a.this);
          paramAnonymousInt2 = localObject.length;
          paramAnonymousInt1 = 0;
          if (paramAnonymousInt1 < paramAnonymousInt2)
          {
            String str2 = localObject[paramAnonymousInt1];
            if (paramAnonymousString.JZr == null) {}
            for (paramAnonymousString.JZr = str2;; paramAnonymousString.JZr = (paramAnonymousString.JZr + "&" + str2))
            {
              int i = str2.indexOf('=');
              if (i >= 0)
              {
                String str1 = str2.substring(0, i).trim();
                str2 = str2.substring(i + 1).trim();
                paramAnonymousString.JZs.put(str1, str2);
              }
              paramAnonymousInt1 += 1;
              break;
            }
          }
          paramAnonymousc = paramAnonymousc.aamS.iterator();
          while (paramAnonymousc.hasNext())
          {
            localObject = (dam)paramAnonymousc.next();
            paramAnonymousString.mHeaders.put(((dam)localObject).ILw, ((dam)localObject).OzQ);
          }
          a.a(a.this).put(paramString, paramAnonymousString);
          if (paramb != null) {
            paramb.a(paramAnonymousString);
          }
          AppMethodBeat.o(271488);
          return;
        }
        Log.e("LiteApp.LiteAppGetA8Key", "getA8Key call back resp is null");
        if (paramb != null) {
          paramb.atR();
        }
        AppMethodBeat.o(271488);
      }
    });
    AppMethodBeat.o(271524);
  }
  
  public final class a
  {
    public String JZr;
    public Map<String, String> JZs;
    public Map<String, String> mHeaders;
    
    public a()
    {
      AppMethodBeat.i(271480);
      this.mHeaders = new HashMap();
      this.JZs = new HashMap();
      AppMethodBeat.o(271480);
    }
  }
  
  public static abstract interface b
  {
    public abstract void a(a.a parama);
    
    public abstract void atR();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.lite.a.a
 * JD-Core Version:    0.7.0.1
 */