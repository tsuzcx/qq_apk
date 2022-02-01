package com.tencent.mm.plugin.ext.d;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.a.bn;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.ext.openapi.provider.ExtControlProviderOpenApi;
import com.tencent.mm.pluginsdk.j.a.a.m;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.vfs.k;
import com.tencent.mm.vfs.o;
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
  private static com.tencent.mm.sdk.b.c jkx;
  private static HashSet<String> rmr;
  private static HashSet<String> rms;
  private static ArrayList<a> rmt;
  private static HashMap<String, e.a> rmu;
  
  static
  {
    AppMethodBeat.i(24489);
    rmr = new HashSet();
    rms = new HashSet();
    rmt = new ArrayList();
    jkx = new com.tencent.mm.sdk.b.c() {};
    rmu = new HashMap();
    AppMethodBeat.o(24489);
  }
  
  public static void a(String paramString, e.a parama)
  {
    AppMethodBeat.i(24481);
    rmu.put(paramString, parama);
    AppMethodBeat.o(24481);
  }
  
  public static void agH(String paramString)
  {
    AppMethodBeat.i(24479);
    rmr.add(paramString);
    AppMethodBeat.o(24479);
  }
  
  public static void agI(String paramString)
  {
    AppMethodBeat.i(24480);
    rms.add(paramString);
    AppMethodBeat.o(24480);
  }
  
  public static e.a agJ(String paramString)
  {
    AppMethodBeat.i(24482);
    paramString = (e.a)rmu.get(paramString);
    AppMethodBeat.o(24482);
    return paramString;
  }
  
  public static boolean agK(String paramString)
  {
    AppMethodBeat.i(24484);
    if (bu.isNullOrNil(paramString))
    {
      ae.w("MicroMsg.ExtQbarDataManager", "hy: null in fastJudgeInWhitelist");
      AppMethodBeat.o(24484);
      return false;
    }
    if (rmr.contains(paramString))
    {
      ae.i("MicroMsg.ExtQbarDataManager", "hy: %s already in whitelist", new Object[] { paramString });
      AppMethodBeat.o(24484);
      return true;
    }
    AppMethodBeat.o(24484);
    return false;
  }
  
  public static boolean agL(String paramString)
  {
    AppMethodBeat.i(24485);
    if (bu.isNullOrNil(paramString))
    {
      ae.w("MicroMsg.ExtQbarDataManager", "hy: null in fastJudgeInBlacklist");
      AppMethodBeat.o(24485);
      return false;
    }
    if (rms.contains(paramString))
    {
      ae.i("MicroMsg.ExtQbarDataManager", "hy: %s already in blacklist", new Object[] { paramString });
      AppMethodBeat.o(24485);
      return true;
    }
    AppMethodBeat.o(24485);
    return false;
  }
  
  public static b.b agM(String paramString)
  {
    AppMethodBeat.i(24486);
    if (bu.isNullOrNil(paramString))
    {
      ae.w("MicroMsg.ExtQbarDataManager", "hy: url is null when get config");
      paramString = b.b.rmp;
      AppMethodBeat.o(24486);
      return paramString;
    }
    Iterator localIterator = rmt.iterator();
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
        if (locala.rmh == b.a.rmj)
        {
          if (paramString.startsWith(locala.url))
          {
            ae.i("MicroMsg.ExtQbarDataManager", "hy: match prefix: %s", new Object[] { locala.url });
            paramString = locala.rmi;
            AppMethodBeat.o(24486);
            return paramString;
          }
        }
        else
        {
          try
          {
            localObject = new URL(paramString).getHost();
            ae.d("MicroMsg.ExtQbarDataManager", "hy: host is %s", new Object[] { localObject });
            if (!bu.V(new String[0])) {
              break label189;
            }
            ae.w("MicroMsg.ExtQbarDataManager", "hy: no valid host");
          }
          catch (MalformedURLException localMalformedURLException)
          {
            ae.printErrStackTrace("MicroMsg.ExtQbarDataManager", localMalformedURLException, "hy: error in url convert: %s", new Object[] { paramString });
          }
          continue;
          if (localMalformedURLException.rmh == b.a.rml)
          {
            if (localMalformedURLException.url.equals(localObject))
            {
              ae.i("MicroMsg.ExtQbarDataManager", "hy: match domain: %s", new Object[] { localMalformedURLException.rmh });
              localb = localMalformedURLException.rmi;
              AppMethodBeat.o(24486);
              return localb;
            }
          }
          else if (localb.rmh == b.a.rmk)
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
        ae.i("MicroMsg.ExtQbarDataManager", "hy: match %s subdomain: %s", new Object[] { paramString, localb.url });
        localb = localb.rmi;
        AppMethodBeat.o(24486);
        return localb;
        ae.e("MicroMsg.ExtQbarDataManager", "hy: damn it impossible!");
        break;
        paramString = b.b.rmp;
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
    rmu.clear();
    AppMethodBeat.o(24483);
  }
  
  private static String ctR()
  {
    AppMethodBeat.i(24475);
    if (ExtControlProviderOpenApi.IS_DEBUG) {}
    for (String str = ak.getContext().getExternalCacheDir().getParent() + "/extqbar";; str = ak.getContext().getFilesDir().getParent() + "/extqbar")
    {
      k localk = new k(str);
      if (!localk.exists())
      {
        ae.i("MicroMsg.ExtQbarDataManager", "hy: face dir not exist. mk dir");
        localk.mkdirs();
      }
      str = str + "/ext_qbar_config.csv";
      AppMethodBeat.o(24475);
      return str;
    }
  }
  
  private static void ctS()
  {
    AppMethodBeat.i(24476);
    if (!o.fB(ctR()))
    {
      ae.w("MicroMsg.ExtQbarDataManager", "hy: not found csv file");
      g.ajj().a(new m(46), 0);
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
        Object localObject1 = o.aZT(ctR());
        ae.i("MicroMsg.ExtQbarDataManager", "hy: found qrcode config");
        ae.v("MicroMsg.ExtQbarDataManager", "hy: qrcode config is %s", new Object[] { localObject1 });
        if (bu.isNullOrNil((String)localObject1)) {
          ae.w("MicroMsg.ExtQbarDataManager", "hy: no preset black/white config");
        }
        localObject1 = new BufferedReader(new StringReader((String)localObject1));
        long l = bu.HQ();
        try
        {
          localObject2 = ((BufferedReader)localObject1).readLine();
          if (localObject2 != null)
          {
            ae.d("MicroMsg.ExtQbarDataManager", "hy: retrieving line");
            arrayOfString = ((String)localObject2).split(",");
            if (arrayOfString.length >= 3) {
              continue;
            }
            ae.w("MicroMsg.ExtQbarDataManager", "hy: line %s not qualified length!", new Object[] { localObject2 });
          }
          localObject2 = new a();
        }
        catch (Exception localException)
        {
          ae.printErrStackTrace("MicroMsg.ExtQbarDataManager", localException, "hy: exception when parse config!", new Object[0]);
          ae.i("MicroMsg.ExtQbarDataManager", "hy: qrcode config retrieved using %d ms", new Object[] { Long.valueOf(bu.aO(l)) });
          AppMethodBeat.o(24476);
          return;
        }
        ((a)localObject2).url = arrayOfString[2].toUpperCase();
        if (!"white".equalsIgnoreCase(arrayOfString[0])) {
          break label390;
        }
        ((a)localObject2).rmi = b.b.rmo;
        if ("prefix".equalsIgnoreCase(arrayOfString[1]))
        {
          ((a)localObject2).rmh = b.a.rmj;
          i = 1;
          if (i == 0) {
            continue;
          }
          rmt.add(localObject2);
          continue;
        }
        if (!"subdomain".equalsIgnoreCase(arrayOfString[1])) {
          break label340;
        }
      }
      catch (IOException localIOException)
      {
        ae.printErrStackTrace("MicroMsg.ExtQbarDataManager", localIOException, "hy: read config file failed!", new Object[0]);
        AppMethodBeat.o(24476);
        return;
      }
      ((a)localObject2).rmh = b.a.rmk;
      int i = 1;
      continue;
      label340:
      if ("domain".equalsIgnoreCase(arrayOfString[1]))
      {
        ((a)localObject2).rmh = b.a.rml;
        i = 1;
      }
      else
      {
        ae.w("MicroMsg.ExtQbarDataManager", "hy: [white] 2nd not qualified! %s", new Object[] { arrayOfString[1] });
        i = 0;
        continue;
        if ("black".equalsIgnoreCase(arrayOfString[0]))
        {
          ((a)localObject2).rmi = b.b.rmn;
          if ("prefix".equalsIgnoreCase(arrayOfString[1]))
          {
            ((a)localObject2).rmh = b.a.rmj;
            i = 1;
          }
          else if ("subdomain".equalsIgnoreCase(arrayOfString[1]))
          {
            ((a)localObject2).rmh = b.a.rmk;
            i = 1;
          }
          else if ("domain".equalsIgnoreCase(arrayOfString[1]))
          {
            ((a)localObject2).rmh = b.a.rml;
            i = 1;
          }
          else
          {
            ae.w("MicroMsg.ExtQbarDataManager", "hy: [black] 2nd not qualified! %s", new Object[] { arrayOfString[1] });
            i = 0;
          }
        }
        else
        {
          ae.w("MicroMsg.ExtQbarDataManager", "hy: 1st not qualified! %s", new Object[] { arrayOfString[0] });
          i = 0;
        }
      }
    }
  }
  
  public static void ctT()
  {
    AppMethodBeat.i(24477);
    ctS();
    com.tencent.mm.sdk.b.a.IvT.c(jkx);
    AppMethodBeat.o(24477);
  }
  
  public static void ctU()
  {
    AppMethodBeat.i(24478);
    com.tencent.mm.sdk.b.a.IvT.d(jkx);
    AppMethodBeat.o(24478);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.ext.d.c
 * JD-Core Version:    0.7.0.1
 */