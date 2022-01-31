package com.tencent.mm.plugin.ext.c;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.e;
import com.tencent.mm.ai.p;
import com.tencent.mm.compatible.util.h;
import com.tencent.mm.g.a.bg;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.ext.openapi.provider.ExtControlProviderOpenApi;
import com.tencent.mm.pluginsdk.g.a.a.m;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
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
  private static com.tencent.mm.sdk.b.c gAV;
  private static HashSet<String> mfe;
  private static HashSet<String> mff;
  private static ArrayList<a> mfg;
  private static HashMap<String, e.a> mfh;
  
  static
  {
    AppMethodBeat.i(20411);
    mfe = new HashSet();
    mff = new HashSet();
    mfg = new ArrayList();
    gAV = new com.tencent.mm.sdk.b.c() {};
    mfh = new HashMap();
    AppMethodBeat.o(20411);
  }
  
  public static void Nf(String paramString)
  {
    AppMethodBeat.i(20401);
    mfe.add(paramString);
    AppMethodBeat.o(20401);
  }
  
  public static void Ng(String paramString)
  {
    AppMethodBeat.i(20402);
    mff.add(paramString);
    AppMethodBeat.o(20402);
  }
  
  public static e.a Nh(String paramString)
  {
    AppMethodBeat.i(20404);
    paramString = (e.a)mfh.get(paramString);
    AppMethodBeat.o(20404);
    return paramString;
  }
  
  public static boolean Ni(String paramString)
  {
    AppMethodBeat.i(20406);
    if (bo.isNullOrNil(paramString))
    {
      ab.w("MicroMsg.ExtQbarDataManager", "hy: null in fastJudgeInWhitelist");
      AppMethodBeat.o(20406);
      return false;
    }
    if (mfe.contains(paramString))
    {
      ab.i("MicroMsg.ExtQbarDataManager", "hy: %s already in whitelist", new Object[] { paramString });
      AppMethodBeat.o(20406);
      return true;
    }
    AppMethodBeat.o(20406);
    return false;
  }
  
  public static boolean Nj(String paramString)
  {
    AppMethodBeat.i(20407);
    if (bo.isNullOrNil(paramString))
    {
      ab.w("MicroMsg.ExtQbarDataManager", "hy: null in fastJudgeInBlacklist");
      AppMethodBeat.o(20407);
      return false;
    }
    if (mff.contains(paramString))
    {
      ab.i("MicroMsg.ExtQbarDataManager", "hy: %s already in blacklist", new Object[] { paramString });
      AppMethodBeat.o(20407);
      return true;
    }
    AppMethodBeat.o(20407);
    return false;
  }
  
  public static b.b Nk(String paramString)
  {
    AppMethodBeat.i(20408);
    if (bo.isNullOrNil(paramString))
    {
      ab.w("MicroMsg.ExtQbarDataManager", "hy: url is null when get config");
      paramString = b.b.mfc;
      AppMethodBeat.o(20408);
      return paramString;
    }
    Iterator localIterator = mfg.iterator();
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
        if (locala.meU == b.a.meW)
        {
          if (paramString.startsWith(locala.url))
          {
            ab.i("MicroMsg.ExtQbarDataManager", "hy: match prefix: %s", new Object[] { locala.url });
            paramString = locala.meV;
            AppMethodBeat.o(20408);
            return paramString;
          }
        }
        else
        {
          try
          {
            localObject = new URL(paramString).getHost();
            ab.d("MicroMsg.ExtQbarDataManager", "hy: host is %s", new Object[] { localObject });
            if (!bo.Q(new String[0])) {
              break label189;
            }
            ab.w("MicroMsg.ExtQbarDataManager", "hy: no valid host");
          }
          catch (MalformedURLException localMalformedURLException)
          {
            ab.printErrStackTrace("MicroMsg.ExtQbarDataManager", localMalformedURLException, "hy: error in url convert: %s", new Object[] { paramString });
          }
          continue;
          if (localMalformedURLException.meU == b.a.meY)
          {
            if (localMalformedURLException.url.equals(localObject))
            {
              ab.i("MicroMsg.ExtQbarDataManager", "hy: match domain: %s", new Object[] { localMalformedURLException.meU });
              localb = localMalformedURLException.meV;
              AppMethodBeat.o(20408);
              return localb;
            }
          }
          else if (localb.meU == b.a.meX)
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
        ab.i("MicroMsg.ExtQbarDataManager", "hy: match %s subdomain: %s", new Object[] { paramString, localb.url });
        localb = localb.meV;
        AppMethodBeat.o(20408);
        return localb;
        ab.e("MicroMsg.ExtQbarDataManager", "hy: damn it impossible!");
        break;
        paramString = b.b.mfc;
        AppMethodBeat.o(20408);
        return paramString;
      }
      j -= 1;
      i -= 1;
    }
  }
  
  public static void a(String paramString, e.a parama)
  {
    AppMethodBeat.i(20403);
    mfh.put(paramString, parama);
    AppMethodBeat.o(20403);
  }
  
  private static String btJ()
  {
    AppMethodBeat.i(20397);
    if (ExtControlProviderOpenApi.mdS) {}
    for (String str = h.getExternalStorageDirectory().getAbsolutePath() + File.separator + "extqbar";; str = ah.getContext().getFilesDir().getParent() + File.separator + "extqbar")
    {
      File localFile = new File(str);
      if (!localFile.exists())
      {
        ab.i("MicroMsg.ExtQbarDataManager", "hy: face dir not exist. mk dir");
        localFile.mkdirs();
      }
      str = str + File.separator + "ext_qbar_config.csv";
      AppMethodBeat.o(20397);
      return str;
    }
  }
  
  private static void btK()
  {
    AppMethodBeat.i(20398);
    if (!e.cN(btJ()))
    {
      ab.w("MicroMsg.ExtQbarDataManager", "hy: not found csv file");
      g.Rc().a(new m(46), 0);
      AppMethodBeat.o(20398);
      return;
    }
    label390:
    for (;;)
    {
      Object localObject2;
      String[] arrayOfString;
      try
      {
        Object localObject1 = e.cS(btJ());
        ab.i("MicroMsg.ExtQbarDataManager", "hy: found qrcode config");
        ab.v("MicroMsg.ExtQbarDataManager", "hy: qrcode config is %s", new Object[] { localObject1 });
        if (bo.isNullOrNil((String)localObject1)) {
          ab.w("MicroMsg.ExtQbarDataManager", "hy: no preset black/white config");
        }
        localObject1 = new BufferedReader(new StringReader((String)localObject1));
        long l = bo.yB();
        try
        {
          localObject2 = ((BufferedReader)localObject1).readLine();
          if (localObject2 != null)
          {
            ab.d("MicroMsg.ExtQbarDataManager", "hy: retrieving line");
            arrayOfString = ((String)localObject2).split(",");
            if (arrayOfString.length >= 3) {
              continue;
            }
            ab.w("MicroMsg.ExtQbarDataManager", "hy: line %s not qualified length!", new Object[] { localObject2 });
          }
          localObject2 = new a();
        }
        catch (Exception localException)
        {
          ab.printErrStackTrace("MicroMsg.ExtQbarDataManager", localException, "hy: exception when parse config!", new Object[0]);
          ab.i("MicroMsg.ExtQbarDataManager", "hy: qrcode config retrieved using %d ms", new Object[] { Long.valueOf(bo.av(l)) });
          AppMethodBeat.o(20398);
          return;
        }
        ((a)localObject2).url = arrayOfString[2].toUpperCase();
        if (!"white".equalsIgnoreCase(arrayOfString[0])) {
          break label390;
        }
        ((a)localObject2).meV = b.b.mfb;
        if ("prefix".equalsIgnoreCase(arrayOfString[1]))
        {
          ((a)localObject2).meU = b.a.meW;
          i = 1;
          if (i == 0) {
            continue;
          }
          mfg.add(localObject2);
          continue;
        }
        if (!"subdomain".equalsIgnoreCase(arrayOfString[1])) {
          break label340;
        }
      }
      catch (IOException localIOException)
      {
        ab.printErrStackTrace("MicroMsg.ExtQbarDataManager", localIOException, "hy: read config file failed!", new Object[0]);
        AppMethodBeat.o(20398);
        return;
      }
      ((a)localObject2).meU = b.a.meX;
      int i = 1;
      continue;
      label340:
      if ("domain".equalsIgnoreCase(arrayOfString[1]))
      {
        ((a)localObject2).meU = b.a.meY;
        i = 1;
      }
      else
      {
        ab.w("MicroMsg.ExtQbarDataManager", "hy: [white] 2nd not qualified! %s", new Object[] { arrayOfString[1] });
        i = 0;
        continue;
        if ("black".equalsIgnoreCase(arrayOfString[0]))
        {
          ((a)localObject2).meV = b.b.mfa;
          if ("prefix".equalsIgnoreCase(arrayOfString[1]))
          {
            ((a)localObject2).meU = b.a.meW;
            i = 1;
          }
          else if ("subdomain".equalsIgnoreCase(arrayOfString[1]))
          {
            ((a)localObject2).meU = b.a.meX;
            i = 1;
          }
          else if ("domain".equalsIgnoreCase(arrayOfString[1]))
          {
            ((a)localObject2).meU = b.a.meY;
            i = 1;
          }
          else
          {
            ab.w("MicroMsg.ExtQbarDataManager", "hy: [black] 2nd not qualified! %s", new Object[] { arrayOfString[1] });
            i = 0;
          }
        }
        else
        {
          ab.w("MicroMsg.ExtQbarDataManager", "hy: 1st not qualified! %s", new Object[] { arrayOfString[0] });
          i = 0;
        }
      }
    }
  }
  
  public static void btL()
  {
    AppMethodBeat.i(20399);
    btK();
    com.tencent.mm.sdk.b.a.ymk.c(gAV);
    AppMethodBeat.o(20399);
  }
  
  public static void btM()
  {
    AppMethodBeat.i(20400);
    com.tencent.mm.sdk.b.a.ymk.d(gAV);
    AppMethodBeat.o(20400);
  }
  
  public static void clearCache()
  {
    AppMethodBeat.i(20405);
    mfh.clear();
    AppMethodBeat.o(20405);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.ext.c.c
 * JD-Core Version:    0.7.0.1
 */