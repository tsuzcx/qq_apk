package com.tencent.mm.plugin.appbrand.appstorage;

import android.support.annotation.Keep;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.e;
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
import java.util.List;
import org.apache.commons.a.b;

public final class LuggageLocalFileObjectManager
{
  private static final v hah;
  private final String gZQ;
  private final String gZR;
  private final String gZS;
  private final Collection<LuggageLocalFileObjectManager.a> hag;
  
  static
  {
    AppMethodBeat.i(105438);
    hah = new v()
    {
      public final String toString()
      {
        return "AppBrandLocalMediaObject::Nil";
      }
    };
    AppMethodBeat.o(105438);
  }
  
  LuggageLocalFileObjectManager(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(105423);
    this.gZQ = (new File(paramString1).getAbsolutePath() + "/");
    this.gZR = paramString2;
    this.gZS = paramString3;
    paramString1 = new LinkedList();
    paramString1.add(new LuggageLocalFileObjectManager.b(this, (byte)0));
    this.hag = Collections.unmodifiableCollection(paramString1);
    AppMethodBeat.o(105423);
  }
  
  private <T extends v> T a(String paramString1, Class<T> paramClass, String paramString2, boolean paramBoolean)
  {
    AppMethodBeat.i(105428);
    if (!e.cN(paramString1))
    {
      AppMethodBeat.o(105428);
      return null;
    }
    String str = b.azG(paramString1);
    if (bo.isNullOrNil(str))
    {
      str = paramString2;
      Iterator localIterator = this.hag.iterator();
      paramString2 = null;
      while (localIterator.hasNext())
      {
        a locala = ((LuggageLocalFileObjectManager.a)localIterator.next()).bF(paramString1, str);
        paramString2 = locala;
        if (locala != null) {
          paramString2 = locala;
        }
      }
      if ((paramString2 != null) && (paramString2.size() >= 2)) {
        break label147;
      }
      if (paramString2 != null) {
        break label138;
      }
    }
    label138:
    for (int i = -1;; i = paramString2.size())
    {
      ab.e("MicroMsg.AppBrand.LuggageLocalFileObjectManager", "attachCast, no handler return correct info, attach.size = %d", new Object[] { Integer.valueOf(i) });
      AppMethodBeat.o(105428);
      return null;
      break;
    }
    try
    {
      label147:
      paramClass = (v)paramClass.newInstance();
      paramClass.ctV = ((String)paramString2.get(0));
      paramClass.mimeType = c.aqq(str);
      paramClass.fod = ((String)paramString2.get(1));
      if (bo.isNullOrNil(paramClass.fod))
      {
        ab.e("MicroMsg.AppBrand.LuggageLocalFileObjectManager", "attachCast appId %s, Null Or Nil fileFullPath");
        AppMethodBeat.o(105428);
        return null;
      }
      paramClass.elt = bo.bf((String)paramString2.get(3), bo.bf(str, "unknown"));
      paramString2 = paramClass.fod;
      if ((paramBoolean) && (i.bA(paramString1, paramString2))) {
        i = 1;
      }
      while (i != 0)
      {
        paramString1 = new File(paramClass.fod);
        paramClass.gmb = paramString1.length();
        paramClass.gZn = paramString1.lastModified();
        AppMethodBeat.o(105428);
        return paramClass;
        if (!paramBoolean)
        {
          paramBoolean = m.copyFile(paramString1, paramString2);
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
      ab.printErrStackTrace("MicroMsg.AppBrand.LuggageLocalFileObjectManager", paramString1, "", new Object[0]);
      AppMethodBeat.o(105428);
    }
  }
  
  private String awN()
  {
    AppMethodBeat.i(105430);
    j.akQ(this.gZQ);
    try
    {
      new File(this.gZQ, ".nomedia").createNewFile();
      label30:
      String str = this.gZQ;
      AppMethodBeat.o(105430);
      return str;
    }
    catch (Exception localException)
    {
      break label30;
    }
  }
  
  public final v a(v paramv)
  {
    AppMethodBeat.i(105431);
    Object localObject = null;
    Iterator localIterator = this.hag.iterator();
    while (localIterator.hasNext())
    {
      v localv = ((LuggageLocalFileObjectManager.a)localIterator.next()).a(paramv);
      localObject = localv;
      if (localv != null) {
        localObject = localv;
      }
    }
    AppMethodBeat.o(105431);
    return localObject;
  }
  
  public final List<v> awK()
  {
    AppMethodBeat.i(105425);
    File[] arrayOfFile = awL();
    if ((arrayOfFile == null) || (arrayOfFile.length <= 0))
    {
      AppMethodBeat.o(105425);
      return null;
    }
    LinkedList localLinkedList = new LinkedList();
    int j = arrayOfFile.length;
    int i = 0;
    while (i < j)
    {
      v localv = zo(arrayOfFile[i].getName());
      if (localv != null) {
        localLinkedList.add(localv);
      }
      i += 1;
    }
    AppMethodBeat.o(105425);
    return localLinkedList;
  }
  
  final File[] awL()
  {
    AppMethodBeat.i(105426);
    Object localObject = new File(awN());
    if ((!((File)localObject).exists()) || (!((File)localObject).isDirectory()))
    {
      AppMethodBeat.o(105426);
      return null;
    }
    localObject = ((File)localObject).listFiles(new LuggageLocalFileObjectManager.1(this));
    AppMethodBeat.o(105426);
    return localObject;
  }
  
  public final List<v> awM()
  {
    AppMethodBeat.i(105427);
    Object localObject = new File(awN());
    if ((!((File)localObject).exists()) || (!((File)localObject).isDirectory())) {}
    for (localObject = null; (localObject == null) || (localObject.length <= 0); localObject = ((File)localObject).listFiles(new LuggageLocalFileObjectManager.2(this)))
    {
      AppMethodBeat.o(105427);
      return null;
    }
    LinkedList localLinkedList = new LinkedList();
    int j = localObject.length;
    int i = 0;
    while (i < j)
    {
      v localv = zo(localObject[i].getName());
      if (localv != null) {
        localLinkedList.add(localv);
      }
      i += 1;
    }
    AppMethodBeat.o(105427);
    return localLinkedList;
  }
  
  @Keep
  public final String genMediaFilePath(String paramString)
  {
    AppMethodBeat.i(105424);
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(105424);
      return null;
    }
    paramString = awN() + paramString;
    AppMethodBeat.o(105424);
    return paramString;
  }
  
  public final v k(String paramString1, String paramString2, boolean paramBoolean)
  {
    AppMethodBeat.i(105429);
    paramString1 = a(paramString1, v.class, paramString2, paramBoolean);
    AppMethodBeat.o(105429);
    return paramString1;
  }
  
  final v zo(String paramString)
  {
    Object localObject = null;
    AppMethodBeat.i(105432);
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(105432);
      return null;
    }
    Iterator localIterator = this.hag.iterator();
    while (localIterator.hasNext())
    {
      v localv = ((LuggageLocalFileObjectManager.a)localIterator.next()).zs(paramString);
      localObject = localv;
      if (localv != null) {
        localObject = localv;
      }
    }
    AppMethodBeat.o(105432);
    return localObject;
  }
  
  @Deprecated
  public final v zp(String paramString)
  {
    AppMethodBeat.i(105433);
    if ((bo.isNullOrNil(paramString)) || (!paramString.startsWith(this.gZS)))
    {
      ab.e("MicroMsg.AppBrand.LuggageLocalFileObjectManager", "getItemByLocalId, invalid args, localId(%s)", new Object[] { paramString });
      AppMethodBeat.o(105433);
      return null;
    }
    String str = paramString.substring(this.gZS.length());
    Iterator localIterator = this.hag.iterator();
    paramString = null;
    if (localIterator.hasNext())
    {
      LuggageLocalFileObjectManager.a locala = (LuggageLocalFileObjectManager.a)localIterator.next();
      paramString = locala.zr(str);
      if (paramString != null) {
        ab.i("MicroMsg.AppBrand.LuggageLocalFileObjectManager", "getItemByLocalId, handled by %s, result = %s", new Object[] { locala.toString(), paramString });
      }
    }
    for (;;)
    {
      if (hah == paramString)
      {
        AppMethodBeat.o(105433);
        return null;
        break;
      }
      AppMethodBeat.o(105433);
      return paramString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appstorage.LuggageLocalFileObjectManager
 * JD-Core Version:    0.7.0.1
 */