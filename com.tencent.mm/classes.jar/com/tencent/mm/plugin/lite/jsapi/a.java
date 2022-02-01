package com.tencent.mm.plugin.lite.jsapi;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.d.c;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi.a;
import com.tencent.mm.modelsimple.l.a;
import com.tencent.mm.protocal.protobuf.bos;
import com.tencent.mm.protocal.protobuf.bot;
import com.tencent.mm.protocal.protobuf.ckf;
import com.tencent.mm.protocal.protobuf.eae;
import com.tencent.mm.protocal.protobuf.eaf;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public enum a
{
  private byte[] EfT;
  private Map<String, a> lwl;
  
  static
  {
    AppMethodBeat.i(233967);
    EfS = new a("INSTANCE");
    EfU = new a[] { EfS };
    AppMethodBeat.o(233967);
  }
  
  private a()
  {
    AppMethodBeat.i(233961);
    this.EfT = new byte[0];
    this.lwl = new ConcurrentHashMap();
    AppMethodBeat.o(233961);
  }
  
  public final void a(final String paramString, final b paramb)
  {
    AppMethodBeat.i(233964);
    int i = (int)System.currentTimeMillis();
    d locald = l.a.aL(paramString, 0);
    bos localbos = (bos)d.b.b(locald.lBR);
    localbos.RLe = 2;
    localbos.Tac = new eaf().btQ(paramString);
    localbos.CPw = 0;
    localbos.UserName = "";
    localbos.RNa = 0;
    localbos.RIs = 0;
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
      localbos.sSU = ((String)localObject);
      localbos.Tag = i;
      localbos.Tah = "";
      localbos.Tai = 0;
      localbos.SZZ = new eaf().btQ("");
      localbos.Taj = new eae().dc(this.EfT);
      Log.i("LiteApp.LiteAppGetA8Key", "url:".concat(String.valueOf(paramString)));
      IPCRunCgi.a(locald, new IPCRunCgi.a()
      {
        public final void a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, d paramAnonymousd)
        {
          AppMethodBeat.i(233687);
          Log.i("LiteApp.LiteAppGetA8Key", "errType:%d errCode:%d ", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
          if ((d.c.b(paramAnonymousd.lBS) instanceof bot))
          {
            paramAnonymousd = (bot)d.c.b(paramAnonymousd.lBS);
            Log.i("LiteApp.LiteAppGetA8Key", "fullurl:" + paramAnonymousd.Tao);
            if (paramAnonymousd.Tao == null)
            {
              if (paramb != null) {
                paramb.onError();
              }
              AppMethodBeat.o(233687);
              return;
            }
            paramAnonymousInt1 = paramAnonymousd.Tao.indexOf("?");
            if ((paramAnonymousInt1 < 0) || (paramAnonymousInt1 + 1 >= paramAnonymousd.Tao.length()))
            {
              Log.e("LiteApp.LiteAppGetA8Key", "paramPos invalid");
              if (paramb != null) {
                paramb.onError();
              }
              AppMethodBeat.o(233687);
              return;
            }
            Object localObject = paramAnonymousd.Tao.substring(paramAnonymousInt1 + 1).split("&");
            if (localObject == null)
            {
              Log.e("LiteApp.LiteAppGetA8Key", "params invalid");
              if (paramb != null) {
                paramb.onError();
              }
              AppMethodBeat.o(233687);
              return;
            }
            paramAnonymousString = new a.a(a.this);
            paramAnonymousInt2 = localObject.length;
            paramAnonymousInt1 = 0;
            if (paramAnonymousInt1 < paramAnonymousInt2)
            {
              String str2 = localObject[paramAnonymousInt1];
              if ((str2.startsWith("key")) || (str2.startsWith("uin")) || (str2.startsWith("pass_ticket"))) {
                if (paramAnonymousString.EfX != null) {
                  break label356;
                }
              }
              label356:
              for (paramAnonymousString.EfX = str2;; paramAnonymousString.EfX = (paramAnonymousString.EfX + "&" + str2))
              {
                int i = str2.indexOf('=');
                if (i >= 0)
                {
                  String str1 = str2.substring(0, i).trim();
                  str2 = str2.substring(i + 1).trim();
                  paramAnonymousString.EfY.put(str1, str2);
                }
                paramAnonymousInt1 += 1;
                break;
              }
            }
            paramAnonymousd = paramAnonymousd.SZV.iterator();
            while (paramAnonymousd.hasNext())
            {
              localObject = (ckf)paramAnonymousd.next();
              paramAnonymousString.mHeaders.put(((ckf)localObject).CRg, ((ckf)localObject).Izj);
            }
            a.a(a.this).put(paramString, paramAnonymousString);
            if (paramb != null) {
              paramb.a(paramAnonymousString);
            }
            AppMethodBeat.o(233687);
            return;
          }
          Log.e("LiteApp.LiteAppGetA8Key", "getA8Key call back resp is null");
          if (paramb != null) {
            paramb.onError();
          }
          AppMethodBeat.o(233687);
        }
      });
      AppMethodBeat.o(233964);
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
    public String EfX;
    public Map<String, String> EfY;
    public Map<String, String> mHeaders;
    
    public a()
    {
      AppMethodBeat.i(233635);
      this.mHeaders = new HashMap();
      this.EfY = new HashMap();
      AppMethodBeat.o(233635);
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