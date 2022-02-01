package com.tencent.mm.plugin.ext.d;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.q;
import com.tencent.mm.g.a.bn;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.ext.openapi.provider.ExtControlProviderOpenApi;
import com.tencent.mm.pluginsdk.j.a.a.m;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.vfs.e;
import com.tencent.mm.vfs.i;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.StringReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public final class c
{
  private static com.tencent.mm.sdk.b.c jhE;
  private static HashSet<String> rem;
  private static HashSet<String> ren;
  private static ArrayList<a> reo;
  private static HashMap<String, e.a> rep;
  
  static
  {
    AppMethodBeat.i(24489);
    rem = new HashSet();
    ren = new HashSet();
    reo = new ArrayList();
    jhE = new com.tencent.mm.sdk.b.c() {};
    rep = new HashMap();
    AppMethodBeat.o(24489);
  }
  
  public static void a(String paramString, e.a parama)
  {
    AppMethodBeat.i(24481);
    rep.put(paramString, parama);
    AppMethodBeat.o(24481);
  }
  
  public static void afL(String paramString)
  {
    AppMethodBeat.i(24479);
    rem.add(paramString);
    AppMethodBeat.o(24479);
  }
  
  public static void afM(String paramString)
  {
    AppMethodBeat.i(24480);
    ren.add(paramString);
    AppMethodBeat.o(24480);
  }
  
  public static e.a afN(String paramString)
  {
    AppMethodBeat.i(24482);
    paramString = (e.a)rep.get(paramString);
    AppMethodBeat.o(24482);
    return paramString;
  }
  
  public static boolean afO(String paramString)
  {
    AppMethodBeat.i(24484);
    if (bt.isNullOrNil(paramString))
    {
      ad.w("MicroMsg.ExtQbarDataManager", "hy: null in fastJudgeInWhitelist");
      AppMethodBeat.o(24484);
      return false;
    }
    if (rem.contains(paramString))
    {
      ad.i("MicroMsg.ExtQbarDataManager", "hy: %s already in whitelist", new Object[] { paramString });
      AppMethodBeat.o(24484);
      return true;
    }
    AppMethodBeat.o(24484);
    return false;
  }
  
  public static boolean afP(String paramString)
  {
    AppMethodBeat.i(24485);
    if (bt.isNullOrNil(paramString))
    {
      ad.w("MicroMsg.ExtQbarDataManager", "hy: null in fastJudgeInBlacklist");
      AppMethodBeat.o(24485);
      return false;
    }
    if (ren.contains(paramString))
    {
      ad.i("MicroMsg.ExtQbarDataManager", "hy: %s already in blacklist", new Object[] { paramString });
      AppMethodBeat.o(24485);
      return true;
    }
    AppMethodBeat.o(24485);
    return false;
  }
  
  public static b.b afQ(String paramString)
  {
    AppMethodBeat.i(24486);
    if (bt.isNullOrNil(paramString))
    {
      ad.w("MicroMsg.ExtQbarDataManager", "hy: url is null when get config");
      paramString = b.b.rek;
      AppMethodBeat.o(24486);
      return paramString;
    }
    Iterator localIterator = reo.iterator();
    Object localObject;
    label189:
    b.b localb;
    String[] arrayOfString;
    int j;
    int i;
    int k;
    for (;;)
    {
      if (localIterator.hasNext())
      {
        a locala = (a)localIterator.next();
        if (locala.reb == b.a.red)
        {
          if (paramString.startsWith(locala.url))
          {
            ad.i("MicroMsg.ExtQbarDataManager", "hy: match prefix: %s", new Object[] { locala.url });
            paramString = locala.rec;
            AppMethodBeat.o(24486);
            return paramString;
          }
        }
        else
        {
          try
          {
            localObject = new URL(paramString).getHost();
            ad.d("MicroMsg.ExtQbarDataManager", "hy: host is %s", new Object[] { localObject });
            if (!bt.V(new String[0])) {
              break label189;
            }
            ad.w("MicroMsg.ExtQbarDataManager", "hy: no valid host");
          }
          catch (MalformedURLException localMalformedURLException)
          {
            ad.printErrStackTrace("MicroMsg.ExtQbarDataManager", localMalformedURLException, "hy: error in url convert: %s", new Object[] { paramString });
          }
          continue;
          if (localMalformedURLException.reb == b.a.reg)
          {
            if (localMalformedURLException.url.equals(localObject))
            {
              ad.i("MicroMsg.ExtQbarDataManager", "hy: match domain: %s", new Object[] { localMalformedURLException.reb });
              localb = localMalformedURLException.rec;
              AppMethodBeat.o(24486);
              return localb;
            }
          }
          else if (localb.reb == b.a.ree)
          {
            arrayOfString = localb.url.split("\\.");
            localObject = ((String)localObject).split("\\.");
            if ((arrayOfString.length <= 0) || (localObject.length <= 0) || (arrayOfString.length > localObject.length)) {
              continue;
            }
            j = arrayOfString.length - 1;
            i = localObject.length - 1;
            k = 1;
          }
        }
      }
    }
    for (;;)
    {
      if ((j >= 0) && (i >= 0))
      {
        if (!arrayOfString[j].equals(localObject[i])) {
          k = 0;
        }
      }
      else
      {
        if (k == 0) {
          break;
        }
        ad.i("MicroMsg.ExtQbarDataManager", "hy: match %s subdomain: %s", new Object[] { paramString, localb.url });
        localb = localb.rec;
        AppMethodBeat.o(24486);
        return localb;
        ad.e("MicroMsg.ExtQbarDataManager", "hy: damn it impossible!");
        break;
        paramString = b.b.rek;
        AppMethodBeat.o(24486);
        return paramString;
      }
      j -= 1;
      i -= 1;
    }
  }
  
  public static void clearCache()
  {
    AppMethodBeat.i(24483);
    rep.clear();
    AppMethodBeat.o(24483);
  }
  
  private static String csp()
  {
    AppMethodBeat.i(24475);
    if (ExtControlProviderOpenApi.IS_DEBUG) {}
    for (String str = aj.getContext().getExternalCacheDir().getParent() + "/extqbar";; str = aj.getContext().getFilesDir().getParent() + "/extqbar")
    {
      e locale = new e(str);
      if (!locale.exists())
      {
        ad.i("MicroMsg.ExtQbarDataManager", "hy: face dir not exist. mk dir");
        locale.mkdirs();
      }
      str = str + "/ext_qbar_config.csv";
      AppMethodBeat.o(24475);
      return str;
    }
  }
  
  private static void csq()
  {
    AppMethodBeat.i(24476);
    if (!i.fv(csp()))
    {
      ad.w("MicroMsg.ExtQbarDataManager", "hy: not found csv file");
      g.aiU().a(new m(46), 0);
      AppMethodBeat.o(24476);
      return;
    }
    label390:
    for (;;)
    {
      Object localObject2;
      String[] arrayOfString;
      try
      {
        Object localObject1 = i.aYq(csp());
        ad.i("MicroMsg.ExtQbarDataManager", "hy: found qrcode config");
        ad.v("MicroMsg.ExtQbarDataManager", "hy: qrcode config is %s", new Object[] { localObject1 });
        if (bt.isNullOrNil((String)localObject1)) {
          ad.w("MicroMsg.ExtQbarDataManager", "hy: no preset black/white config");
        }
        localObject1 = new BufferedReader(new StringReader((String)localObject1));
        long l = bt.HI();
        try
        {
          localObject2 = ((BufferedReader)localObject1).readLine();
          if (localObject2 != null)
          {
            ad.d("MicroMsg.ExtQbarDataManager", "hy: retrieving line");
            arrayOfString = ((String)localObject2).split(",");
            if (arrayOfString.length >= 3) {
              continue;
            }
            ad.w("MicroMsg.ExtQbarDataManager", "hy: line %s not qualified length!", new Object[] { localObject2 });
          }
          localObject2 = new a();
        }
        catch (Exception localException)
        {
          ad.printErrStackTrace("MicroMsg.ExtQbarDataManager", localException, "hy: exception when parse config!", new Object[0]);
          ad.i("MicroMsg.ExtQbarDataManager", "hy: qrcode config retrieved using %d ms", new Object[] { Long.valueOf(bt.aO(l)) });
          AppMethodBeat.o(24476);
          return;
        }
        ((a)localObject2).url = arrayOfString[2].toUpperCase();
        if (!"white".equalsIgnoreCase(arrayOfString[0])) {
          break label390;
        }
        ((a)localObject2).rec = b.b.rej;
        if ("prefix".equalsIgnoreCase(arrayOfString[1]))
        {
          ((a)localObject2).reb = b.a.red;
          i = 1;
          if (i == 0) {
            continue;
          }
          reo.add(localObject2);
          continue;
        }
        if (!"subdomain".equalsIgnoreCase(arrayOfString[1])) {
          break label340;
        }
      }
      catch (IOException localIOException)
      {
        ad.printErrStackTrace("MicroMsg.ExtQbarDataManager", localIOException, "hy: read config file failed!", new Object[0]);
        AppMethodBeat.o(24476);
        return;
      }
      ((a)localObject2).reb = b.a.ree;
      int i = 1;
      continue;
      label340:
      if ("domain".equalsIgnoreCase(arrayOfString[1]))
      {
        ((a)localObject2).reb = b.a.reg;
        i = 1;
      }
      else
      {
        ad.w("MicroMsg.ExtQbarDataManager", "hy: [white] 2nd not qualified! %s", new Object[] { arrayOfString[1] });
        i = 0;
        continue;
        if ("black".equalsIgnoreCase(arrayOfString[0]))
        {
          ((a)localObject2).rec = b.b.rei;
          if ("prefix".equalsIgnoreCase(arrayOfString[1]))
          {
            ((a)localObject2).reb = b.a.red;
            i = 1;
          }
          else if ("subdomain".equalsIgnoreCase(arrayOfString[1]))
          {
            ((a)localObject2).reb = b.a.ree;
            i = 1;
          }
          else if ("domain".equalsIgnoreCase(arrayOfString[1]))
          {
            ((a)localObject2).reb = b.a.reg;
            i = 1;
          }
          else
          {
            ad.w("MicroMsg.ExtQbarDataManager", "hy: [black] 2nd not qualified! %s", new Object[] { arrayOfString[1] });
            i = 0;
          }
        }
        else
        {
          ad.w("MicroMsg.ExtQbarDataManager", "hy: 1st not qualified! %s", new Object[] { arrayOfString[0] });
          i = 0;
        }
      }
    }
  }
  
  public static void csr()
  {
    AppMethodBeat.i(24477);
    csq();
    com.tencent.mm.sdk.b.a.IbL.c(jhE);
    AppMethodBeat.o(24477);
  }
  
  public static void css()
  {
    AppMethodBeat.i(24478);
    com.tencent.mm.sdk.b.a.IbL.d(jhE);
    AppMethodBeat.o(24478);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.ext.d.c
 * JD-Core Version:    0.7.0.1
 */