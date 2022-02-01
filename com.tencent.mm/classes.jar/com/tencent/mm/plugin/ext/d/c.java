package com.tencent.mm.plugin.ext.d;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.a.bk;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.ext.openapi.provider.ExtControlProviderOpenApi;
import com.tencent.mm.pluginsdk.h.a.a.m;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bs;
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
  private static com.tencent.mm.sdk.b.c iOv;
  private static ArrayList<a> quA;
  private static HashMap<String, e.a> quB;
  private static HashSet<String> quy;
  private static HashSet<String> quz;
  
  static
  {
    AppMethodBeat.i(24489);
    quy = new HashSet();
    quz = new HashSet();
    quA = new ArrayList();
    iOv = new com.tencent.mm.sdk.b.c() {};
    quB = new HashMap();
    AppMethodBeat.o(24489);
  }
  
  public static void a(String paramString, e.a parama)
  {
    AppMethodBeat.i(24481);
    quB.put(paramString, parama);
    AppMethodBeat.o(24481);
  }
  
  public static void abW(String paramString)
  {
    AppMethodBeat.i(24479);
    quy.add(paramString);
    AppMethodBeat.o(24479);
  }
  
  public static void abX(String paramString)
  {
    AppMethodBeat.i(24480);
    quz.add(paramString);
    AppMethodBeat.o(24480);
  }
  
  public static e.a abY(String paramString)
  {
    AppMethodBeat.i(24482);
    paramString = (e.a)quB.get(paramString);
    AppMethodBeat.o(24482);
    return paramString;
  }
  
  public static boolean abZ(String paramString)
  {
    AppMethodBeat.i(24484);
    if (bs.isNullOrNil(paramString))
    {
      ac.w("MicroMsg.ExtQbarDataManager", "hy: null in fastJudgeInWhitelist");
      AppMethodBeat.o(24484);
      return false;
    }
    if (quy.contains(paramString))
    {
      ac.i("MicroMsg.ExtQbarDataManager", "hy: %s already in whitelist", new Object[] { paramString });
      AppMethodBeat.o(24484);
      return true;
    }
    AppMethodBeat.o(24484);
    return false;
  }
  
  public static boolean aca(String paramString)
  {
    AppMethodBeat.i(24485);
    if (bs.isNullOrNil(paramString))
    {
      ac.w("MicroMsg.ExtQbarDataManager", "hy: null in fastJudgeInBlacklist");
      AppMethodBeat.o(24485);
      return false;
    }
    if (quz.contains(paramString))
    {
      ac.i("MicroMsg.ExtQbarDataManager", "hy: %s already in blacklist", new Object[] { paramString });
      AppMethodBeat.o(24485);
      return true;
    }
    AppMethodBeat.o(24485);
    return false;
  }
  
  public static b.b acb(String paramString)
  {
    AppMethodBeat.i(24486);
    if (bs.isNullOrNil(paramString))
    {
      ac.w("MicroMsg.ExtQbarDataManager", "hy: url is null when get config");
      paramString = b.b.quw;
      AppMethodBeat.o(24486);
      return paramString;
    }
    Iterator localIterator = quA.iterator();
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
        if (locala.quo == b.a.quq)
        {
          if (paramString.startsWith(locala.url))
          {
            ac.i("MicroMsg.ExtQbarDataManager", "hy: match prefix: %s", new Object[] { locala.url });
            paramString = locala.qup;
            AppMethodBeat.o(24486);
            return paramString;
          }
        }
        else
        {
          try
          {
            localObject = new URL(paramString).getHost();
            ac.d("MicroMsg.ExtQbarDataManager", "hy: host is %s", new Object[] { localObject });
            if (!bs.T(new String[0])) {
              break label189;
            }
            ac.w("MicroMsg.ExtQbarDataManager", "hy: no valid host");
          }
          catch (MalformedURLException localMalformedURLException)
          {
            ac.printErrStackTrace("MicroMsg.ExtQbarDataManager", localMalformedURLException, "hy: error in url convert: %s", new Object[] { paramString });
          }
          continue;
          if (localMalformedURLException.quo == b.a.qus)
          {
            if (localMalformedURLException.url.equals(localObject))
            {
              ac.i("MicroMsg.ExtQbarDataManager", "hy: match domain: %s", new Object[] { localMalformedURLException.quo });
              localb = localMalformedURLException.qup;
              AppMethodBeat.o(24486);
              return localb;
            }
          }
          else if (localb.quo == b.a.qur)
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
        ac.i("MicroMsg.ExtQbarDataManager", "hy: match %s subdomain: %s", new Object[] { paramString, localb.url });
        localb = localb.qup;
        AppMethodBeat.o(24486);
        return localb;
        ac.e("MicroMsg.ExtQbarDataManager", "hy: damn it impossible!");
        break;
        paramString = b.b.quw;
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
    quB.clear();
    AppMethodBeat.o(24483);
  }
  
  private static String cmK()
  {
    AppMethodBeat.i(24475);
    if (ExtControlProviderOpenApi.IS_DEBUG) {}
    for (String str = ai.getContext().getExternalCacheDir().getParent() + "/extqbar";; str = ai.getContext().getFilesDir().getParent() + "/extqbar")
    {
      e locale = new e(str);
      if (!locale.exists())
      {
        ac.i("MicroMsg.ExtQbarDataManager", "hy: face dir not exist. mk dir");
        locale.mkdirs();
      }
      str = str + "/ext_qbar_config.csv";
      AppMethodBeat.o(24475);
      return str;
    }
  }
  
  private static void cmL()
  {
    AppMethodBeat.i(24476);
    if (!i.eA(cmK()))
    {
      ac.w("MicroMsg.ExtQbarDataManager", "hy: not found csv file");
      g.agi().a(new m(46), 0);
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
        Object localObject1 = i.aSr(cmK());
        ac.i("MicroMsg.ExtQbarDataManager", "hy: found qrcode config");
        ac.v("MicroMsg.ExtQbarDataManager", "hy: qrcode config is %s", new Object[] { localObject1 });
        if (bs.isNullOrNil((String)localObject1)) {
          ac.w("MicroMsg.ExtQbarDataManager", "hy: no preset black/white config");
        }
        localObject1 = new BufferedReader(new StringReader((String)localObject1));
        long l = bs.Gn();
        try
        {
          localObject2 = ((BufferedReader)localObject1).readLine();
          if (localObject2 != null)
          {
            ac.d("MicroMsg.ExtQbarDataManager", "hy: retrieving line");
            arrayOfString = ((String)localObject2).split(",");
            if (arrayOfString.length >= 3) {
              continue;
            }
            ac.w("MicroMsg.ExtQbarDataManager", "hy: line %s not qualified length!", new Object[] { localObject2 });
          }
          localObject2 = new a();
        }
        catch (Exception localException)
        {
          ac.printErrStackTrace("MicroMsg.ExtQbarDataManager", localException, "hy: exception when parse config!", new Object[0]);
          ac.i("MicroMsg.ExtQbarDataManager", "hy: qrcode config retrieved using %d ms", new Object[] { Long.valueOf(bs.aO(l)) });
          AppMethodBeat.o(24476);
          return;
        }
        ((a)localObject2).url = arrayOfString[2].toUpperCase();
        if (!"white".equalsIgnoreCase(arrayOfString[0])) {
          break label390;
        }
        ((a)localObject2).qup = b.b.quv;
        if ("prefix".equalsIgnoreCase(arrayOfString[1]))
        {
          ((a)localObject2).quo = b.a.quq;
          i = 1;
          if (i == 0) {
            continue;
          }
          quA.add(localObject2);
          continue;
        }
        if (!"subdomain".equalsIgnoreCase(arrayOfString[1])) {
          break label340;
        }
      }
      catch (IOException localIOException)
      {
        ac.printErrStackTrace("MicroMsg.ExtQbarDataManager", localIOException, "hy: read config file failed!", new Object[0]);
        AppMethodBeat.o(24476);
        return;
      }
      ((a)localObject2).quo = b.a.qur;
      int i = 1;
      continue;
      label340:
      if ("domain".equalsIgnoreCase(arrayOfString[1]))
      {
        ((a)localObject2).quo = b.a.qus;
        i = 1;
      }
      else
      {
        ac.w("MicroMsg.ExtQbarDataManager", "hy: [white] 2nd not qualified! %s", new Object[] { arrayOfString[1] });
        i = 0;
        continue;
        if ("black".equalsIgnoreCase(arrayOfString[0]))
        {
          ((a)localObject2).qup = b.b.quu;
          if ("prefix".equalsIgnoreCase(arrayOfString[1]))
          {
            ((a)localObject2).quo = b.a.quq;
            i = 1;
          }
          else if ("subdomain".equalsIgnoreCase(arrayOfString[1]))
          {
            ((a)localObject2).quo = b.a.qur;
            i = 1;
          }
          else if ("domain".equalsIgnoreCase(arrayOfString[1]))
          {
            ((a)localObject2).quo = b.a.qus;
            i = 1;
          }
          else
          {
            ac.w("MicroMsg.ExtQbarDataManager", "hy: [black] 2nd not qualified! %s", new Object[] { arrayOfString[1] });
            i = 0;
          }
        }
        else
        {
          ac.w("MicroMsg.ExtQbarDataManager", "hy: 1st not qualified! %s", new Object[] { arrayOfString[0] });
          i = 0;
        }
      }
    }
  }
  
  public static void cmM()
  {
    AppMethodBeat.i(24477);
    cmL();
    com.tencent.mm.sdk.b.a.GpY.c(iOv);
    AppMethodBeat.o(24477);
  }
  
  public static void cmN()
  {
    AppMethodBeat.i(24478);
    com.tencent.mm.sdk.b.a.GpY.d(iOv);
    AppMethodBeat.o(24478);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.ext.d.c
 * JD-Core Version:    0.7.0.1
 */