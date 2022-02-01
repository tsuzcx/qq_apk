package com.tencent.mm.plugin.ext.d;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.q;
import com.tencent.mm.g.a.bk;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.ext.openapi.provider.ExtControlProviderOpenApi;
import com.tencent.mm.pluginsdk.h.a.a.m;
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
  private static com.tencent.mm.sdk.b.c iop;
  private static HashSet<String> pLQ;
  private static HashSet<String> pLR;
  private static ArrayList<a> pLS;
  private static HashMap<String, e.a> pLT;
  
  static
  {
    AppMethodBeat.i(24489);
    pLQ = new HashSet();
    pLR = new HashSet();
    pLS = new ArrayList();
    iop = new com.tencent.mm.sdk.b.c() {};
    pLT = new HashMap();
    AppMethodBeat.o(24489);
  }
  
  public static void XA(String paramString)
  {
    AppMethodBeat.i(24480);
    pLR.add(paramString);
    AppMethodBeat.o(24480);
  }
  
  public static e.a XB(String paramString)
  {
    AppMethodBeat.i(24482);
    paramString = (e.a)pLT.get(paramString);
    AppMethodBeat.o(24482);
    return paramString;
  }
  
  public static boolean XC(String paramString)
  {
    AppMethodBeat.i(24484);
    if (bt.isNullOrNil(paramString))
    {
      ad.w("MicroMsg.ExtQbarDataManager", "hy: null in fastJudgeInWhitelist");
      AppMethodBeat.o(24484);
      return false;
    }
    if (pLQ.contains(paramString))
    {
      ad.i("MicroMsg.ExtQbarDataManager", "hy: %s already in whitelist", new Object[] { paramString });
      AppMethodBeat.o(24484);
      return true;
    }
    AppMethodBeat.o(24484);
    return false;
  }
  
  public static boolean XD(String paramString)
  {
    AppMethodBeat.i(24485);
    if (bt.isNullOrNil(paramString))
    {
      ad.w("MicroMsg.ExtQbarDataManager", "hy: null in fastJudgeInBlacklist");
      AppMethodBeat.o(24485);
      return false;
    }
    if (pLR.contains(paramString))
    {
      ad.i("MicroMsg.ExtQbarDataManager", "hy: %s already in blacklist", new Object[] { paramString });
      AppMethodBeat.o(24485);
      return true;
    }
    AppMethodBeat.o(24485);
    return false;
  }
  
  public static b.b XE(String paramString)
  {
    AppMethodBeat.i(24486);
    if (bt.isNullOrNil(paramString))
    {
      ad.w("MicroMsg.ExtQbarDataManager", "hy: url is null when get config");
      paramString = b.b.pLO;
      AppMethodBeat.o(24486);
      return paramString;
    }
    Iterator localIterator = pLS.iterator();
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
        if (locala.pLG == b.a.pLI)
        {
          if (paramString.startsWith(locala.url))
          {
            ad.i("MicroMsg.ExtQbarDataManager", "hy: match prefix: %s", new Object[] { locala.url });
            paramString = locala.pLH;
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
            if (!bt.T(new String[0])) {
              break label189;
            }
            ad.w("MicroMsg.ExtQbarDataManager", "hy: no valid host");
          }
          catch (MalformedURLException localMalformedURLException)
          {
            ad.printErrStackTrace("MicroMsg.ExtQbarDataManager", localMalformedURLException, "hy: error in url convert: %s", new Object[] { paramString });
          }
          continue;
          if (localMalformedURLException.pLG == b.a.pLK)
          {
            if (localMalformedURLException.url.equals(localObject))
            {
              ad.i("MicroMsg.ExtQbarDataManager", "hy: match domain: %s", new Object[] { localMalformedURLException.pLG });
              localb = localMalformedURLException.pLH;
              AppMethodBeat.o(24486);
              return localb;
            }
          }
          else if (localb.pLG == b.a.pLJ)
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
        localb = localb.pLH;
        AppMethodBeat.o(24486);
        return localb;
        ad.e("MicroMsg.ExtQbarDataManager", "hy: damn it impossible!");
        break;
        paramString = b.b.pLO;
        AppMethodBeat.o(24486);
        return paramString;
      }
      j -= 1;
      i -= 1;
    }
  }
  
  public static void Xz(String paramString)
  {
    AppMethodBeat.i(24479);
    pLQ.add(paramString);
    AppMethodBeat.o(24479);
  }
  
  public static void a(String paramString, e.a parama)
  {
    AppMethodBeat.i(24481);
    pLT.put(paramString, parama);
    AppMethodBeat.o(24481);
  }
  
  private static String cfd()
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
  
  private static void cfe()
  {
    AppMethodBeat.i(24476);
    if (!i.eK(cfd()))
    {
      ad.w("MicroMsg.ExtQbarDataManager", "hy: not found csv file");
      g.aeS().a(new m(46), 0);
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
        Object localObject1 = i.aMP(cfd());
        ad.i("MicroMsg.ExtQbarDataManager", "hy: found qrcode config");
        ad.v("MicroMsg.ExtQbarDataManager", "hy: qrcode config is %s", new Object[] { localObject1 });
        if (bt.isNullOrNil((String)localObject1)) {
          ad.w("MicroMsg.ExtQbarDataManager", "hy: no preset black/white config");
        }
        localObject1 = new BufferedReader(new StringReader((String)localObject1));
        long l = bt.GC();
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
          ad.i("MicroMsg.ExtQbarDataManager", "hy: qrcode config retrieved using %d ms", new Object[] { Long.valueOf(bt.aS(l)) });
          AppMethodBeat.o(24476);
          return;
        }
        ((a)localObject2).url = arrayOfString[2].toUpperCase();
        if (!"white".equalsIgnoreCase(arrayOfString[0])) {
          break label390;
        }
        ((a)localObject2).pLH = b.b.pLN;
        if ("prefix".equalsIgnoreCase(arrayOfString[1]))
        {
          ((a)localObject2).pLG = b.a.pLI;
          i = 1;
          if (i == 0) {
            continue;
          }
          pLS.add(localObject2);
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
      ((a)localObject2).pLG = b.a.pLJ;
      int i = 1;
      continue;
      label340:
      if ("domain".equalsIgnoreCase(arrayOfString[1]))
      {
        ((a)localObject2).pLG = b.a.pLK;
        i = 1;
      }
      else
      {
        ad.w("MicroMsg.ExtQbarDataManager", "hy: [white] 2nd not qualified! %s", new Object[] { arrayOfString[1] });
        i = 0;
        continue;
        if ("black".equalsIgnoreCase(arrayOfString[0]))
        {
          ((a)localObject2).pLH = b.b.pLM;
          if ("prefix".equalsIgnoreCase(arrayOfString[1]))
          {
            ((a)localObject2).pLG = b.a.pLI;
            i = 1;
          }
          else if ("subdomain".equalsIgnoreCase(arrayOfString[1]))
          {
            ((a)localObject2).pLG = b.a.pLJ;
            i = 1;
          }
          else if ("domain".equalsIgnoreCase(arrayOfString[1]))
          {
            ((a)localObject2).pLG = b.a.pLK;
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
  
  public static void cff()
  {
    AppMethodBeat.i(24477);
    cfe();
    com.tencent.mm.sdk.b.a.ESL.c(iop);
    AppMethodBeat.o(24477);
  }
  
  public static void cfg()
  {
    AppMethodBeat.i(24478);
    com.tencent.mm.sdk.b.a.ESL.d(iop);
    AppMethodBeat.o(24478);
  }
  
  public static void clearCache()
  {
    AppMethodBeat.i(24483);
    pLT.clear();
    AppMethodBeat.o(24483);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.ext.d.c
 * JD-Core Version:    0.7.0.1
 */