package com.tencent.mm.plugin.ext.d;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.t;
import com.tencent.mm.f.a.bu;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.ext.openapi.provider.ExtControlProviderOpenApi;
import com.tencent.mm.pluginsdk.k.a.a.m;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.q;
import com.tencent.mm.vfs.u;
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
  private static IListener mZZ;
  private static HashSet<String> wtR;
  private static HashSet<String> wtS;
  private static ArrayList<a> wtT;
  private static HashMap<String, e.a> wtU;
  
  static
  {
    AppMethodBeat.i(24489);
    wtR = new HashSet();
    wtS = new HashSet();
    wtT = new ArrayList();
    mZZ = new IListener() {};
    wtU = new HashMap();
    AppMethodBeat.o(24489);
  }
  
  public static void a(String paramString, e.a parama)
  {
    AppMethodBeat.i(24481);
    wtU.put(paramString, parama);
    AppMethodBeat.o(24481);
  }
  
  public static void azs(String paramString)
  {
    AppMethodBeat.i(24479);
    wtR.add(paramString);
    AppMethodBeat.o(24479);
  }
  
  public static void azt(String paramString)
  {
    AppMethodBeat.i(24480);
    wtS.add(paramString);
    AppMethodBeat.o(24480);
  }
  
  public static e.a azu(String paramString)
  {
    AppMethodBeat.i(24482);
    paramString = (e.a)wtU.get(paramString);
    AppMethodBeat.o(24482);
    return paramString;
  }
  
  public static boolean azv(String paramString)
  {
    AppMethodBeat.i(24484);
    if (Util.isNullOrNil(paramString))
    {
      Log.w("MicroMsg.ExtQbarDataManager", "hy: null in fastJudgeInWhitelist");
      AppMethodBeat.o(24484);
      return false;
    }
    if (wtR.contains(paramString))
    {
      Log.i("MicroMsg.ExtQbarDataManager", "hy: %s already in whitelist", new Object[] { paramString });
      AppMethodBeat.o(24484);
      return true;
    }
    AppMethodBeat.o(24484);
    return false;
  }
  
  public static boolean azw(String paramString)
  {
    AppMethodBeat.i(24485);
    if (Util.isNullOrNil(paramString))
    {
      Log.w("MicroMsg.ExtQbarDataManager", "hy: null in fastJudgeInBlacklist");
      AppMethodBeat.o(24485);
      return false;
    }
    if (wtS.contains(paramString))
    {
      Log.i("MicroMsg.ExtQbarDataManager", "hy: %s already in blacklist", new Object[] { paramString });
      AppMethodBeat.o(24485);
      return true;
    }
    AppMethodBeat.o(24485);
    return false;
  }
  
  public static b.b azx(String paramString)
  {
    AppMethodBeat.i(24486);
    if (Util.isNullOrNil(paramString))
    {
      Log.w("MicroMsg.ExtQbarDataManager", "hy: url is null when get config");
      paramString = b.b.wtP;
      AppMethodBeat.o(24486);
      return paramString;
    }
    Iterator localIterator = wtT.iterator();
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
        if (locala.wtH == b.a.wtJ)
        {
          if (paramString.startsWith(locala.url))
          {
            Log.i("MicroMsg.ExtQbarDataManager", "hy: match prefix: %s", new Object[] { locala.url });
            paramString = locala.wtI;
            AppMethodBeat.o(24486);
            return paramString;
          }
        }
        else
        {
          try
          {
            localObject = new URL(paramString).getHost();
            Log.d("MicroMsg.ExtQbarDataManager", "hy: host is %s", new Object[] { localObject });
            if (!Util.isNullOrNil(new String[0])) {
              break label189;
            }
            Log.w("MicroMsg.ExtQbarDataManager", "hy: no valid host");
          }
          catch (MalformedURLException localMalformedURLException)
          {
            Log.printErrStackTrace("MicroMsg.ExtQbarDataManager", localMalformedURLException, "hy: error in url convert: %s", new Object[] { paramString });
          }
          continue;
          if (localMalformedURLException.wtH == b.a.wtL)
          {
            if (localMalformedURLException.url.equals(localObject))
            {
              Log.i("MicroMsg.ExtQbarDataManager", "hy: match domain: %s", new Object[] { localMalformedURLException.wtH });
              localb = localMalformedURLException.wtI;
              AppMethodBeat.o(24486);
              return localb;
            }
          }
          else if (localb.wtH == b.a.wtK)
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
        Log.i("MicroMsg.ExtQbarDataManager", "hy: match %s subdomain: %s", new Object[] { paramString, localb.url });
        localb = localb.wtI;
        AppMethodBeat.o(24486);
        return localb;
        Log.e("MicroMsg.ExtQbarDataManager", "hy: damn it impossible!");
        break;
        paramString = b.b.wtP;
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
    wtU.clear();
    AppMethodBeat.o(24483);
  }
  
  private static void dhA()
  {
    AppMethodBeat.i(24476);
    if (!u.agG(dhz()))
    {
      Log.w("MicroMsg.ExtQbarDataManager", "hy: not found csv file");
      h.aGY().a(new m(46), 0);
      AppMethodBeat.o(24476);
      return;
    }
    label387:
    for (;;)
    {
      Object localObject2;
      String[] arrayOfString;
      try
      {
        Object localObject1 = u.bBS(dhz());
        Log.i("MicroMsg.ExtQbarDataManager", "hy: found qrcode config");
        Log.v("MicroMsg.ExtQbarDataManager", "hy: qrcode config is %s", new Object[] { localObject1 });
        if (Util.isNullOrNil((String)localObject1)) {
          Log.w("MicroMsg.ExtQbarDataManager", "hy: no preset black/white config");
        }
        localObject1 = new BufferedReader(new StringReader((String)localObject1));
        long l = Util.currentTicks();
        try
        {
          localObject2 = ((BufferedReader)localObject1).readLine();
          if (localObject2 != null)
          {
            Log.d("MicroMsg.ExtQbarDataManager", "hy: retrieving line");
            arrayOfString = ((String)localObject2).split(",");
            if (arrayOfString.length >= 3) {
              continue;
            }
            Log.w("MicroMsg.ExtQbarDataManager", "hy: line %s not qualified length!", new Object[] { localObject2 });
          }
          localObject2 = new a();
        }
        catch (Exception localException)
        {
          Log.printErrStackTrace("MicroMsg.ExtQbarDataManager", localException, "hy: exception when parse config!", new Object[0]);
          Log.i("MicroMsg.ExtQbarDataManager", "hy: qrcode config retrieved using %d ms", new Object[] { Long.valueOf(Util.ticksToNow(l)) });
          AppMethodBeat.o(24476);
          return;
        }
        ((a)localObject2).url = arrayOfString[2].toUpperCase();
        if (!"white".equalsIgnoreCase(arrayOfString[0])) {
          break label387;
        }
        ((a)localObject2).wtI = b.b.wtO;
        if ("prefix".equalsIgnoreCase(arrayOfString[1]))
        {
          ((a)localObject2).wtH = b.a.wtJ;
          i = 1;
          if (i == 0) {
            continue;
          }
          wtT.add(localObject2);
          continue;
        }
        if (!"subdomain".equalsIgnoreCase(arrayOfString[1])) {
          break label337;
        }
      }
      catch (IOException localIOException)
      {
        Log.printErrStackTrace("MicroMsg.ExtQbarDataManager", localIOException, "hy: read config file failed!", new Object[0]);
        AppMethodBeat.o(24476);
        return;
      }
      ((a)localObject2).wtH = b.a.wtK;
      int i = 1;
      continue;
      label337:
      if ("domain".equalsIgnoreCase(arrayOfString[1]))
      {
        ((a)localObject2).wtH = b.a.wtL;
        i = 1;
      }
      else
      {
        Log.w("MicroMsg.ExtQbarDataManager", "hy: [white] 2nd not qualified! %s", new Object[] { arrayOfString[1] });
        i = 0;
        continue;
        if ("black".equalsIgnoreCase(arrayOfString[0]))
        {
          ((a)localObject2).wtI = b.b.wtN;
          if ("prefix".equalsIgnoreCase(arrayOfString[1]))
          {
            ((a)localObject2).wtH = b.a.wtJ;
            i = 1;
          }
          else if ("subdomain".equalsIgnoreCase(arrayOfString[1]))
          {
            ((a)localObject2).wtH = b.a.wtK;
            i = 1;
          }
          else if ("domain".equalsIgnoreCase(arrayOfString[1]))
          {
            ((a)localObject2).wtH = b.a.wtL;
            i = 1;
          }
          else
          {
            Log.w("MicroMsg.ExtQbarDataManager", "hy: [black] 2nd not qualified! %s", new Object[] { arrayOfString[1] });
            i = 0;
          }
        }
        else
        {
          Log.w("MicroMsg.ExtQbarDataManager", "hy: 1st not qualified! %s", new Object[] { arrayOfString[0] });
          i = 0;
        }
      }
    }
  }
  
  public static void dhB()
  {
    AppMethodBeat.i(24477);
    dhA();
    EventCenter.instance.addListener(mZZ);
    AppMethodBeat.o(24477);
  }
  
  public static void dhC()
  {
    AppMethodBeat.i(24478);
    EventCenter.instance.removeListener(mZZ);
    AppMethodBeat.o(24478);
  }
  
  private static String dhz()
  {
    AppMethodBeat.i(24475);
    if (ExtControlProviderOpenApi.aFB) {}
    for (String str = MMApplicationContext.getContext().getExternalCacheDir().getParent() + "/extqbar";; str = MMApplicationContext.getContext().getFilesDir().getParent() + "/extqbar")
    {
      q localq = new q(str);
      if (!localq.ifE())
      {
        Log.i("MicroMsg.ExtQbarDataManager", "hy: face dir not exist. mk dir");
        localq.ifL();
      }
      str = str + "/ext_qbar_config.csv";
      AppMethodBeat.o(24475);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.ext.d.c
 * JD-Core Version:    0.7.0.1
 */