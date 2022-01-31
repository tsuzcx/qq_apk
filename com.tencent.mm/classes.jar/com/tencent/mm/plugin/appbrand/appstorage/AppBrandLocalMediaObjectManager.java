package com.tencent.mm.plugin.appbrand.appstorage;

import android.support.annotation.Keep;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.f.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.j;
import com.tencent.mm.sdk.platformtools.m;
import com.tencent.mm.vending.j.a;
import java.io.File;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import org.apache.commons.a.b;

@Deprecated
public final class AppBrandLocalMediaObjectManager
{
  public static final String gZo;
  private static final Collection<a> gZp;
  private static final AppBrandLocalMediaObject gZq;
  
  static
  {
    AppMethodBeat.i(105359);
    String str = com.tencent.mm.compatible.util.e.eQz;
    Object localObject = str;
    if (!str.endsWith("/")) {
      localObject = str + "/";
    }
    gZo = (String)localObject + "wxafiles/";
    localObject = new LinkedList();
    ((Collection)localObject).add(new AppBrandLocalMediaObjectManager.b((byte)0));
    gZp = Collections.unmodifiableCollection((Collection)localObject);
    gZq = new AppBrandLocalMediaObjectManager.3();
    AppMethodBeat.o(105359);
  }
  
  private static <T extends AppBrandLocalMediaObject> T a(String paramString1, String paramString2, Class<T> paramClass, String paramString3, boolean paramBoolean)
  {
    AppMethodBeat.i(105350);
    if (bo.isNullOrNil(paramString1))
    {
      AppMethodBeat.o(105350);
      return null;
    }
    if (!com.tencent.mm.a.e.cN(paramString2))
    {
      AppMethodBeat.o(105350);
      return null;
    }
    String str = b.azG(paramString2);
    if (bo.isNullOrNil(str))
    {
      str = paramString3;
      Iterator localIterator = gZp.iterator();
      paramString3 = null;
      while (localIterator.hasNext())
      {
        a locala = ((a)localIterator.next()).C(paramString1, paramString2, str);
        paramString3 = locala;
        if (locala != null) {
          paramString3 = locala;
        }
      }
      if ((paramString3 != null) && (paramString3.size() >= 2)) {
        break label161;
      }
      if (paramString3 != null) {
        break label152;
      }
    }
    label152:
    for (int i = -1;; i = paramString3.size())
    {
      ab.e("MicroMsg.AppBrand.LocalMediaObjectManager", "attachCast, no handler return correct info, attach.size = %d", new Object[] { Integer.valueOf(i) });
      AppMethodBeat.o(105350);
      return null;
      break;
    }
    try
    {
      label161:
      paramClass = (AppBrandLocalMediaObject)paramClass.newInstance();
      paramClass.ctV = ((String)paramString3.get(0));
      paramClass.mimeType = c.aqq(str);
      paramClass.fod = ((String)paramString3.get(1));
      if (bo.isNullOrNil(paramClass.fod))
      {
        ab.e("MicroMsg.AppBrand.LocalMediaObjectManager", "attachCast appId %s, Null Or Nil fileFullPath");
        AppMethodBeat.o(105350);
        return null;
      }
      paramClass.elt = bo.bf((String)paramString3.get(3), bo.bf(str, "unknown"));
      paramString3 = paramClass.fod;
      if ((paramBoolean) && (i.bA(paramString2, paramString3))) {
        i = 1;
      }
      while (i != 0)
      {
        paramString2 = new File(paramClass.fod);
        paramClass.gmb = paramString2.length();
        paramClass.gZn = paramString2.lastModified();
        paramString3 = (p)com.tencent.luggage.a.e.r(p.class);
        if (paramString3 != null) {
          paramString3.c(paramString1, paramString2);
        }
        AppMethodBeat.o(105350);
        return paramClass;
        if (!paramBoolean)
        {
          paramBoolean = m.copyFile(paramString2, paramString3);
          if (paramBoolean)
          {
            i = 1;
            continue;
          }
        }
        i = 0;
      }
      return null;
    }
    catch (Exception paramString1)
    {
      ab.printErrStackTrace("MicroMsg.AppBrand.LocalMediaObjectManager", paramString1, "", new Object[0]);
      AppMethodBeat.o(105350);
    }
  }
  
  public static AppBrandLocalMediaObject b(String paramString1, String paramString2, String paramString3, boolean paramBoolean)
  {
    AppMethodBeat.i(105352);
    paramString1 = a(paramString1, paramString2, AppBrandLocalMediaObject.class, paramString3, paramBoolean);
    AppMethodBeat.o(105352);
    return paramString1;
  }
  
  public static AppBrandLocalVideoObject bv(String paramString1, String paramString2)
  {
    AppMethodBeat.i(105349);
    paramString1 = (AppBrandLocalVideoObject)a(paramString1, paramString2, AppBrandLocalVideoObject.class, "mp4", false);
    AppMethodBeat.o(105349);
    return paramString1;
  }
  
  @Deprecated
  public static AppBrandLocalMediaObject bw(String paramString1, String paramString2)
  {
    AppMethodBeat.i(105354);
    if ((bo.isNullOrNil(paramString2)) || (!paramString2.startsWith("wxfile://")) || (bo.isNullOrNil(paramString1)))
    {
      ab.e("MicroMsg.AppBrand.LocalMediaObjectManager", "getItemByLocalId, invalid args, localId(%s), appId(%s) ", new Object[] { paramString2, paramString1 });
      AppMethodBeat.o(105354);
      return null;
    }
    String str = paramString2.substring(9);
    Iterator localIterator = gZp.iterator();
    paramString2 = null;
    if (localIterator.hasNext())
    {
      a locala = (a)localIterator.next();
      paramString2 = locala.bz(paramString1, str);
      if (paramString2 != null) {
        ab.i("MicroMsg.AppBrand.LocalMediaObjectManager", "getItemByLocalId, handled by %s, result = %s", new Object[] { locala.toString(), paramString2 });
      }
    }
    for (;;)
    {
      if (gZq == paramString2)
      {
        AppMethodBeat.o(105354);
        return null;
        break;
      }
      AppMethodBeat.o(105354);
      return paramString2;
    }
  }
  
  @Keep
  public static String genMediaFilePath(String paramString1, String paramString2)
  {
    AppMethodBeat.i(105346);
    if ((bo.isNullOrNil(paramString1)) || (bo.isNullOrNil(paramString2)))
    {
      AppMethodBeat.o(105346);
      return null;
    }
    paramString1 = yY(paramString1) + paramString2;
    AppMethodBeat.o(105346);
    return paramString1;
  }
  
  public static AppBrandLocalMediaObject j(String paramString1, String paramString2, boolean paramBoolean)
  {
    AppMethodBeat.i(105351);
    paramString1 = b(paramString1, paramString2, null, paramBoolean);
    AppMethodBeat.o(105351);
    return paramString1;
  }
  
  public static long yW(String paramString)
  {
    long l = 0L;
    AppMethodBeat.i(105347);
    paramString = new File(yY(paramString));
    if ((!paramString.exists()) || (!paramString.isDirectory())) {}
    for (paramString = null; (paramString == null) || (paramString.length <= 0); paramString = paramString.listFiles(new AppBrandLocalMediaObjectManager.2()))
    {
      AppMethodBeat.o(105347);
      return 0L;
    }
    int j = paramString.length;
    int i = 0;
    while (i < j)
    {
      l += paramString[i].length();
      i += 1;
    }
    AppMethodBeat.o(105347);
    return l;
  }
  
  public static long yX(String paramString)
  {
    long l = 0L;
    AppMethodBeat.i(105348);
    paramString = new File(yY(paramString));
    if ((!paramString.exists()) || (!paramString.isDirectory())) {}
    for (paramString = null; (paramString == null) || (paramString.length <= 0); paramString = paramString.listFiles(new AppBrandLocalMediaObjectManager.1()))
    {
      AppMethodBeat.o(105348);
      return 0L;
    }
    int j = paramString.length;
    int i = 0;
    while (i < j)
    {
      l += paramString[i].length();
      i += 1;
    }
    AppMethodBeat.o(105348);
    return l;
  }
  
  private static String yY(String paramString)
  {
    AppMethodBeat.i(105353);
    paramString = gZo + paramString + "/";
    j.akQ(paramString);
    try
    {
      new File(paramString, ".nomedia").createNewFile();
      label52:
      AppMethodBeat.o(105353);
      return paramString;
    }
    catch (Exception localException)
    {
      break label52;
    }
  }
  
  static abstract interface a
  {
    public abstract a C(String paramString1, String paramString2, String paramString3);
    
    public abstract AppBrandLocalMediaObject bz(String paramString1, String paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalMediaObjectManager
 * JD-Core Version:    0.7.0.1
 */