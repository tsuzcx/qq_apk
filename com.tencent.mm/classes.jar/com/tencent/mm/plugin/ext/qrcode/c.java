package com.tencent.mm.plugin.ext.qrcode;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.s;
import com.tencent.mm.app.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.ext.openapi.provider.ExtControlProviderOpenApi;
import com.tencent.mm.pluginsdk.res.downloader.checkresupdate.m;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.u;
import com.tencent.mm.vfs.y;
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
  private static IListener pWI;
  private static HashSet<String> zPX;
  private static HashSet<String> zPY;
  private static ArrayList<a> zPZ;
  private static HashMap<String, e.a> zQa;
  
  static
  {
    AppMethodBeat.i(24489);
    zPX = new HashSet();
    zPY = new HashSet();
    zPZ = new ArrayList();
    pWI = new ExtQbarDataManager.1(f.hfK);
    zQa = new HashMap();
    AppMethodBeat.o(24489);
  }
  
  public static void a(String paramString, e.a parama)
  {
    AppMethodBeat.i(24481);
    zQa.put(paramString, parama);
    AppMethodBeat.o(24481);
  }
  
  public static void atA(String paramString)
  {
    AppMethodBeat.i(24480);
    zPY.add(paramString);
    AppMethodBeat.o(24480);
  }
  
  public static e.a atB(String paramString)
  {
    AppMethodBeat.i(24482);
    paramString = (e.a)zQa.get(paramString);
    AppMethodBeat.o(24482);
    return paramString;
  }
  
  public static boolean atC(String paramString)
  {
    AppMethodBeat.i(24484);
    if (Util.isNullOrNil(paramString))
    {
      Log.w("MicroMsg.ExtQbarDataManager", "hy: null in fastJudgeInWhitelist");
      AppMethodBeat.o(24484);
      return false;
    }
    if (zPX.contains(paramString))
    {
      Log.i("MicroMsg.ExtQbarDataManager", "hy: %s already in whitelist", new Object[] { paramString });
      AppMethodBeat.o(24484);
      return true;
    }
    AppMethodBeat.o(24484);
    return false;
  }
  
  public static boolean atD(String paramString)
  {
    AppMethodBeat.i(24485);
    if (Util.isNullOrNil(paramString))
    {
      Log.w("MicroMsg.ExtQbarDataManager", "hy: null in fastJudgeInBlacklist");
      AppMethodBeat.o(24485);
      return false;
    }
    if (zPY.contains(paramString))
    {
      Log.i("MicroMsg.ExtQbarDataManager", "hy: %s already in blacklist", new Object[] { paramString });
      AppMethodBeat.o(24485);
      return true;
    }
    AppMethodBeat.o(24485);
    return false;
  }
  
  public static b.b atE(String paramString)
  {
    AppMethodBeat.i(24486);
    if (Util.isNullOrNil(paramString))
    {
      Log.w("MicroMsg.ExtQbarDataManager", "hy: url is null when get config");
      paramString = b.b.zPV;
      AppMethodBeat.o(24486);
      return paramString;
    }
    Iterator localIterator = zPZ.iterator();
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
        if (locala.zPN == b.a.zPP)
        {
          if (paramString.startsWith(locala.url))
          {
            Log.i("MicroMsg.ExtQbarDataManager", "hy: match prefix: %s", new Object[] { locala.url });
            paramString = locala.zPO;
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
          if (localMalformedURLException.zPN == b.a.zPR)
          {
            if (localMalformedURLException.url.equals(localObject))
            {
              Log.i("MicroMsg.ExtQbarDataManager", "hy: match domain: %s", new Object[] { localMalformedURLException.zPN });
              localb = localMalformedURLException.zPO;
              AppMethodBeat.o(24486);
              return localb;
            }
          }
          else if (localb.zPN == b.a.zPQ)
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
        localb = localb.zPO;
        AppMethodBeat.o(24486);
        return localb;
        Log.e("MicroMsg.ExtQbarDataManager", "hy: damn it impossible!");
        break;
        paramString = b.b.zPV;
        AppMethodBeat.o(24486);
        return paramString;
      }
      j -= 1;
      i -= 1;
    }
  }
  
  public static void atz(String paramString)
  {
    AppMethodBeat.i(24479);
    zPX.add(paramString);
    AppMethodBeat.o(24479);
  }
  
  public static void clearCache()
  {
    AppMethodBeat.i(24483);
    zQa.clear();
    AppMethodBeat.o(24483);
  }
  
  private static String dOk()
  {
    AppMethodBeat.i(24475);
    if (ExtControlProviderOpenApi.cBm) {}
    for (String str = MMApplicationContext.getContext().getExternalCacheDir().getParent() + "/extqbar";; str = MMApplicationContext.getContext().getFilesDir().getParent() + "/extqbar")
    {
      u localu = new u(str);
      if (!localu.jKS())
      {
        Log.i("MicroMsg.ExtQbarDataManager", "hy: face dir not exist. mk dir");
        localu.jKY();
      }
      str = str + "/ext_qbar_config.csv";
      AppMethodBeat.o(24475);
      return str;
    }
  }
  
  private static void dOl()
  {
    AppMethodBeat.i(24476);
    if (!y.ZC(dOk()))
    {
      Log.w("MicroMsg.ExtQbarDataManager", "hy: not found csv file");
      h.aZW().a(new m(46), 0);
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
        Object localObject1 = y.bEn(dOk());
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
          break label390;
        }
        ((a)localObject2).zPO = b.b.zPU;
        if ("prefix".equalsIgnoreCase(arrayOfString[1]))
        {
          ((a)localObject2).zPN = b.a.zPP;
          i = 1;
          if (i == 0) {
            continue;
          }
          zPZ.add(localObject2);
          continue;
        }
        if (!"subdomain".equalsIgnoreCase(arrayOfString[1])) {
          break label340;
        }
      }
      catch (IOException localIOException)
      {
        Log.printErrStackTrace("MicroMsg.ExtQbarDataManager", localIOException, "hy: read config file failed!", new Object[0]);
        AppMethodBeat.o(24476);
        return;
      }
      ((a)localObject2).zPN = b.a.zPQ;
      int i = 1;
      continue;
      label340:
      if ("domain".equalsIgnoreCase(arrayOfString[1]))
      {
        ((a)localObject2).zPN = b.a.zPR;
        i = 1;
      }
      else
      {
        Log.w("MicroMsg.ExtQbarDataManager", "hy: [white] 2nd not qualified! %s", new Object[] { arrayOfString[1] });
        i = 0;
        continue;
        if ("black".equalsIgnoreCase(arrayOfString[0]))
        {
          ((a)localObject2).zPO = b.b.zPT;
          if ("prefix".equalsIgnoreCase(arrayOfString[1]))
          {
            ((a)localObject2).zPN = b.a.zPP;
            i = 1;
          }
          else if ("subdomain".equalsIgnoreCase(arrayOfString[1]))
          {
            ((a)localObject2).zPN = b.a.zPQ;
            i = 1;
          }
          else if ("domain".equalsIgnoreCase(arrayOfString[1]))
          {
            ((a)localObject2).zPN = b.a.zPR;
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
  
  public static void dOm()
  {
    AppMethodBeat.i(24477);
    dOl();
    pWI.alive();
    AppMethodBeat.o(24477);
  }
  
  public static void dOn()
  {
    AppMethodBeat.i(24478);
    pWI.dead();
    AppMethodBeat.o(24478);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.ext.qrcode.c
 * JD-Core Version:    0.7.0.1
 */