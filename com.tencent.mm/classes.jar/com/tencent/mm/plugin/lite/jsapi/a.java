package com.tencent.mm.plugin.lite.jsapi;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi.a;
import com.tencent.mm.modelsimple.l.a;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.bhi;
import com.tencent.mm.protocal.protobuf.bhj;
import com.tencent.mm.protocal.protobuf.ccc;
import com.tencent.mm.protocal.protobuf.dqi;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public enum a
{
  private Map<String, a> iGj;
  private byte[] yEg;
  
  static
  {
    AppMethodBeat.i(198828);
    yEf = new a("INSTANCE");
    yEh = new a[] { yEf };
    AppMethodBeat.o(198828);
  }
  
  private a()
  {
    AppMethodBeat.i(198826);
    this.yEg = new byte[0];
    this.iGj = new ConcurrentHashMap();
    AppMethodBeat.o(198826);
  }
  
  public final void a(final String paramString, final b paramb)
  {
    AppMethodBeat.i(198827);
    int i = (int)System.currentTimeMillis();
    d locald = l.a.at(paramString, 0);
    bhi localbhi = (bhi)locald.iLK.iLR;
    localbhi.OpCode = 2;
    localbhi.LRx = new dqi().bhy(paramString);
    localbhi.Scene = 0;
    localbhi.UserName = "";
    localbhi.KMd = 0;
    localbhi.KHa = 0;
    Object localObject = (ConnectivityManager)MMApplicationContext.getContext().getSystemService("connectivity");
    if (localObject != null)
    {
      localObject = ((ConnectivityManager)localObject).getActiveNetworkInfo();
      if (localObject != null) {
        if (((NetworkInfo)localObject).getType() == 1) {
          localObject = "WIFI";
        }
      }
    }
    for (;;)
    {
      localbhi.pLm = ((String)localObject);
      localbhi.LRB = i;
      localbhi.LRC = "";
      localbhi.LRD = 0;
      localbhi.LRu = new dqi().bhy("");
      localbhi.LRE = new SKBuiltinBuffer_t().setBuffer(this.yEg);
      Log.i("LiteApp.LiteAppGetA8Key", "url:".concat(String.valueOf(paramString)));
      IPCRunCgi.a(locald, null, new IPCRunCgi.a()
      {
        public final void a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, d paramAnonymousd)
        {
          AppMethodBeat.i(198822);
          Log.i("LiteApp.LiteAppGetA8Key", "errType:%d errCode:%d ", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
          if ((paramAnonymousd.iLL.iLR instanceof bhj))
          {
            paramAnonymousd = (bhj)paramAnonymousd.iLL.iLR;
            Log.i("LiteApp.LiteAppGetA8Key", "fullurl:" + paramAnonymousd.LRH);
            if (paramAnonymousd.LRH == null)
            {
              if (paramb != null) {
                paramb.onError();
              }
              AppMethodBeat.o(198822);
              return;
            }
            paramAnonymousInt1 = paramAnonymousd.LRH.indexOf("?");
            if ((paramAnonymousInt1 < 0) || (paramAnonymousInt1 + 1 >= paramAnonymousd.LRH.length()))
            {
              Log.e("LiteApp.LiteAppGetA8Key", "paramPos invalid");
              if (paramb != null) {
                paramb.onError();
              }
              AppMethodBeat.o(198822);
              return;
            }
            Object localObject = paramAnonymousd.LRH.substring(paramAnonymousInt1 + 1).split("&");
            if (localObject == null)
            {
              Log.e("LiteApp.LiteAppGetA8Key", "params invalid");
              if (paramb != null) {
                paramb.onError();
              }
              AppMethodBeat.o(198822);
              return;
            }
            paramAnonymousString = new a.a(a.this);
            paramAnonymousInt2 = localObject.length;
            paramAnonymousInt1 = 0;
            if (paramAnonymousInt1 < paramAnonymousInt2)
            {
              String str2 = localObject[paramAnonymousInt1];
              if ((str2.startsWith("key")) || (str2.startsWith("uin")) || (str2.startsWith("pass_ticket"))) {
                if (paramAnonymousString.yEk != null) {
                  break label356;
                }
              }
              label356:
              for (paramAnonymousString.yEk = str2;; paramAnonymousString.yEk = (paramAnonymousString.yEk + "&" + str2))
              {
                int i = str2.indexOf('=');
                if (i >= 0)
                {
                  String str1 = str2.substring(0, i).trim();
                  str2 = str2.substring(i + 1).trim();
                  paramAnonymousString.yEl.put(str1, str2);
                }
                paramAnonymousInt1 += 1;
                break;
              }
            }
            paramAnonymousd = paramAnonymousd.LRq.iterator();
            while (paramAnonymousd.hasNext())
            {
              localObject = (ccc)paramAnonymousd.next();
              paramAnonymousString.mHeaders.put(((ccc)localObject).xMX, ((ccc)localObject).Cyk);
            }
            a.a(a.this).put(paramString, paramAnonymousString);
            if (paramb != null) {
              paramb.a(paramAnonymousString);
            }
            AppMethodBeat.o(198822);
            return;
          }
          Log.e("LiteApp.LiteAppGetA8Key", "getA8Key call back resp is null");
          if (paramb != null) {
            paramb.onError();
          }
          AppMethodBeat.o(198822);
        }
      });
      AppMethodBeat.o(198827);
      return;
      if (((NetworkInfo)localObject).getExtraInfo() != null) {
        localObject = ((NetworkInfo)localObject).getExtraInfo().toLowerCase();
      } else {
        localObject = "no";
      }
    }
  }
  
  public final class a
  {
    public Map<String, String> mHeaders;
    public String yEk;
    public Map<String, String> yEl;
    
    public a()
    {
      AppMethodBeat.i(198823);
      this.mHeaders = new HashMap();
      this.yEl = new HashMap();
      AppMethodBeat.o(198823);
    }
  }
  
  public static abstract interface b
  {
    public abstract void a(a.a parama);
    
    public abstract void onError();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.lite.jsapi.a
 * JD-Core Version:    0.7.0.1
 */