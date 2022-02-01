package com.tencent.mm.aa;

import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Random;
import java.util.Set;

public final class b
{
  SparseArray<a> mxB;
  HashMap<at.a, a> mxC;
  SparseArray<b> mxD;
  HashMap<at.a, b> mxE;
  private Random mxF;
  aq mxG;
  
  public b()
  {
    AppMethodBeat.i(150060);
    this.mxB = new SparseArray();
    this.mxC = new HashMap();
    this.mxD = new SparseArray();
    this.mxE = new HashMap();
    this.mxF = new Random();
    this.mxG = null;
    AppMethodBeat.o(150060);
  }
  
  private static String EQ(String paramString)
  {
    AppMethodBeat.i(150061);
    paramString = paramString.replaceAll("\\|", "%7C");
    AppMethodBeat.o(150061);
    return paramString;
  }
  
  private static boolean ER(String paramString)
  {
    AppMethodBeat.i(150067);
    if ((!Util.isNullOrNil(paramString)) && (paramString.matches("^[\\d]+$")))
    {
      AppMethodBeat.o(150067);
      return true;
    }
    AppMethodBeat.o(150067);
    return false;
  }
  
  private a a(int paramInt1, int paramInt2, String paramString1, String paramString2)
  {
    AppMethodBeat.i(150073);
    a locala = new a();
    locala.mxx = paramInt1;
    locala.type = paramInt2;
    locala.value = paramString1;
    locala.hFb = paramString2;
    AppMethodBeat.o(150073);
    return locala;
  }
  
  private a a(at.a parama, int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(150074);
    a locala = new a();
    locala.mxy = parama;
    locala.type = paramInt;
    locala.value = paramString1;
    locala.hFb = paramString2;
    AppMethodBeat.o(150074);
    return locala;
  }
  
  private void a(a parama)
  {
    AppMethodBeat.i(150063);
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append(parama.type);
    localStringBuffer.append("|");
    localStringBuffer.append(EQ(parama.value));
    localStringBuffer.append("|");
    localStringBuffer.append(EQ(parama.hFb));
    if (parama.mxy != null)
    {
      this.mxG.set(parama.mxy, localStringBuffer.toString());
      AppMethodBeat.o(150063);
      return;
    }
    this.mxG.B(parama.mxx, localStringBuffer.toString());
    AppMethodBeat.o(150063);
  }
  
  private a c(at.a parama)
  {
    AppMethodBeat.i(150066);
    String str = (String)this.mxG.get(parama, null);
    if (str == null)
    {
      AppMethodBeat.o(150066);
      return null;
    }
    String[] arrayOfString = str.split("\\|");
    if (arrayOfString.length != 3)
    {
      Log.e("MicroMsg.NewBadgeDecoder", "loadDataSource array.length != 3 content %s", new Object[] { str });
      AppMethodBeat.o(150066);
      return null;
    }
    try
    {
      parama = a(parama, Integer.valueOf(arrayOfString[0]).intValue(), unescape(arrayOfString[1]), unescape(arrayOfString[2]));
      AppMethodBeat.o(150066);
      return parama;
    }
    catch (Exception parama)
    {
      Log.e("MicroMsg.NewBadgeDecoder", "exception:%s", new Object[] { Util.stackTraceToString(parama) });
      Log.e("MicroMsg.NewBadgeDecoder", "loadDataSource exception content %s", new Object[] { str });
      AppMethodBeat.o(150066);
    }
    return null;
  }
  
  private a c(at.a parama, int paramInt)
  {
    AppMethodBeat.i(150076);
    a locala2 = f(parama);
    a locala1 = locala2;
    if (locala2 == null)
    {
      locala1 = a(parama, paramInt, "", "");
      this.mxC.put(parama, locala1);
      a(locala1);
    }
    AppMethodBeat.o(150076);
    return locala1;
  }
  
  private b d(at.a parama)
  {
    AppMethodBeat.i(150069);
    String str = (String)this.mxG.get(parama, null);
    if (str == null)
    {
      parama = e(parama);
      AppMethodBeat.o(150069);
      return parama;
    }
    String[] arrayOfString = str.split("\\|");
    if (arrayOfString.length % 2 != 0)
    {
      Log.e("MicroMsg.NewBadgeDecoder", "loadWatcher array.length %% 2 != 0 content %s", new Object[] { str });
      AppMethodBeat.o(150069);
      return null;
    }
    for (;;)
    {
      int i;
      try
      {
        parama = e(parama);
        i = 0;
        if (i < arrayOfString.length) {
          if (ER(arrayOfString[i])) {
            parama.mxJ.put(Integer.valueOf(arrayOfString[i]).intValue(), unescape(arrayOfString[(i + 1)]));
          } else {
            parama.mxK.put(arrayOfString[i], unescape(arrayOfString[(i + 1)]));
          }
        }
      }
      catch (Exception parama)
      {
        Log.e("MicroMsg.NewBadgeDecoder", "exception:%s", new Object[] { Util.stackTraceToString(parama) });
        Log.e("MicroMsg.NewBadgeDecoder", "loadWatcher exception content %s", new Object[] { str });
        AppMethodBeat.o(150069);
        return null;
      }
      AppMethodBeat.o(150069);
      return parama;
      i += 2;
    }
  }
  
  private a dY(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(150075);
    a locala2 = sg(paramInt1);
    a locala1 = locala2;
    if (locala2 == null)
    {
      locala1 = a(paramInt1, paramInt2, "", "");
      this.mxB.put(paramInt1, locala1);
      a(locala1);
    }
    AppMethodBeat.o(150075);
    return locala1;
  }
  
  private b e(at.a parama)
  {
    AppMethodBeat.i(150072);
    b localb = new b();
    localb.mxA = parama;
    AppMethodBeat.o(150072);
    return localb;
  }
  
  private b g(at.a parama)
  {
    AppMethodBeat.i(150080);
    b localb2 = (b)this.mxE.get(parama);
    b localb1 = localb2;
    if (localb2 == null)
    {
      localb1 = d(parama);
      if (localb1 == null)
      {
        Log.e("MicroMsg.NewBadgeDecoder", "[carl] loadWatcher watcher == null");
        AppMethodBeat.o(150080);
        return null;
      }
      this.mxE.put(parama, localb1);
    }
    AppMethodBeat.o(150080);
    return localb1;
  }
  
  private a sd(int paramInt)
  {
    AppMethodBeat.i(150065);
    String str = (String)this.mxG.d(paramInt, null);
    if (str == null)
    {
      AppMethodBeat.o(150065);
      return null;
    }
    Object localObject = str.split("\\|");
    if (localObject.length != 3)
    {
      Log.e("MicroMsg.NewBadgeDecoder", "loadDataSource array.length != 3 content %s", new Object[] { str });
      AppMethodBeat.o(150065);
      return null;
    }
    try
    {
      localObject = a(paramInt, Integer.valueOf(localObject[0]).intValue(), unescape(localObject[1]), unescape(localObject[2]));
      AppMethodBeat.o(150065);
      return localObject;
    }
    catch (Exception localException)
    {
      Log.e("MicroMsg.NewBadgeDecoder", "exception:%s", new Object[] { Util.stackTraceToString(localException) });
      Log.e("MicroMsg.NewBadgeDecoder", "loadDataSource exception content %s", new Object[] { str });
      AppMethodBeat.o(150065);
    }
    return null;
  }
  
  private b se(int paramInt)
  {
    AppMethodBeat.i(150068);
    Object localObject = (String)this.mxG.d(paramInt, null);
    if (localObject == null)
    {
      localObject = sf(paramInt);
      AppMethodBeat.o(150068);
      return localObject;
    }
    String[] arrayOfString = ((String)localObject).split("\\|");
    if (arrayOfString.length % 2 != 0)
    {
      Log.e("MicroMsg.NewBadgeDecoder", "loadWatcher array.length %% 2 != 0 content %s", new Object[] { localObject });
      AppMethodBeat.o(150068);
      return null;
    }
    for (;;)
    {
      b localb;
      try
      {
        localb = sf(paramInt);
        paramInt = 0;
        if (paramInt < arrayOfString.length) {
          if (ER(arrayOfString[paramInt])) {
            localb.mxJ.put(Integer.valueOf(arrayOfString[paramInt]).intValue(), unescape(arrayOfString[(paramInt + 1)]));
          } else {
            localb.mxK.put(arrayOfString[paramInt], unescape(arrayOfString[(paramInt + 1)]));
          }
        }
      }
      catch (Exception localException)
      {
        Log.e("MicroMsg.NewBadgeDecoder", "exception:%s", new Object[] { Util.stackTraceToString(localException) });
        Log.e("MicroMsg.NewBadgeDecoder", "loadWatcher exception content %s", new Object[] { localObject });
        AppMethodBeat.o(150068);
        return null;
      }
      AppMethodBeat.o(150068);
      return localb;
      paramInt += 2;
    }
  }
  
  private static String unescape(String paramString)
  {
    AppMethodBeat.i(150062);
    paramString = paramString.replaceAll("%7C", "|");
    AppMethodBeat.o(150062);
    return paramString;
  }
  
  public final a a(at.a parama1, at.a parama2, int paramInt)
  {
    AppMethodBeat.i(150084);
    Log.d("MicroMsg.NewBadgeDecoder", "[carl] peek, dataSourceKey %s, watcherKey %s, type %d", new Object[] { parama1, parama2, Integer.valueOf(paramInt) });
    a locala = f(parama1);
    if (locala == null)
    {
      Log.d("MicroMsg.NewBadgeDecoder", "[carl] peek, dataSource == null");
      AppMethodBeat.o(150084);
      return null;
    }
    if ((locala.type & paramInt) == 0)
    {
      Log.d("MicroMsg.NewBadgeDecoder", "[alex] peek, dataSource.type is wrong");
      AppMethodBeat.o(150084);
      return null;
    }
    parama2 = g(parama2);
    if (parama2 != null)
    {
      String str = (String)parama2.mxK.get(parama1.name());
      if ((str != null) && (str.equals(locala.hFb)))
      {
        AppMethodBeat.o(150084);
        return null;
      }
      if (str == null)
      {
        str = aYm();
        parama2.mxK.put(parama1.name(), str);
        a(parama2);
      }
      AppMethodBeat.o(150084);
      return locala;
    }
    Log.e("MicroMsg.NewBadgeDecoder", "[carl] peek, watcher == null");
    AppMethodBeat.o(150084);
    return null;
  }
  
  final void a(b paramb)
  {
    int m = 0;
    AppMethodBeat.i(150064);
    StringBuffer localStringBuffer = new StringBuffer();
    Object localObject1 = paramb.mxK.entrySet().iterator();
    int i = 0;
    int j;
    int k;
    for (;;)
    {
      j = i;
      k = m;
      if (!((Iterator)localObject1).hasNext()) {
        break;
      }
      Object localObject2 = (Map.Entry)((Iterator)localObject1).next();
      String str = (String)((Map.Entry)localObject2).getKey();
      localObject2 = (String)((Map.Entry)localObject2).getValue();
      if (i != 0) {
        localStringBuffer.append("|");
      }
      localStringBuffer.append(str);
      localStringBuffer.append("|");
      localStringBuffer.append(EQ((String)localObject2));
      i += 1;
    }
    while (k < paramb.mxJ.size())
    {
      i = paramb.mxJ.keyAt(k);
      localObject1 = (String)paramb.mxJ.get(i);
      if (j != 0) {
        localStringBuffer.append("|");
      }
      localStringBuffer.append(i);
      localStringBuffer.append("|");
      localStringBuffer.append(EQ((String)localObject1));
      j += 1;
      k += 1;
    }
    if (paramb.mxA != null)
    {
      this.mxG.set(paramb.mxA, localStringBuffer.toString());
      AppMethodBeat.o(150064);
      return;
    }
    this.mxG.B(paramb.mxI, localStringBuffer.toString());
    AppMethodBeat.o(150064);
  }
  
  final String aYm()
  {
    AppMethodBeat.i(150070);
    String str = String.format("%d%04d", new Object[] { Long.valueOf(System.currentTimeMillis()), Integer.valueOf(this.mxF.nextInt(Math.abs(this.mxF.nextInt(2147483647))) % 10000) });
    AppMethodBeat.o(150070);
    return str;
  }
  
  public final a ac(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(150083);
    Log.d("MicroMsg.NewBadgeDecoder", "[carl] peek, dataSourceId %d, watcherId %d, type %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    a locala = sg(paramInt1);
    if (locala == null)
    {
      Log.d("MicroMsg.NewBadgeDecoder", "[carl] peek, dataSource == null");
      AppMethodBeat.o(150083);
      return null;
    }
    if ((locala.type & paramInt3) == 0)
    {
      Log.d("MicroMsg.NewBadgeDecoder", "[alex] peek, dataSource.type is wrong");
      AppMethodBeat.o(150083);
      return null;
    }
    b localb = sh(paramInt2);
    if (localb != null)
    {
      String str = (String)localb.mxJ.get(paramInt1);
      if ((str != null) && (str.equals(locala.hFb)))
      {
        AppMethodBeat.o(150083);
        return null;
      }
      if (str == null)
      {
        str = aYm();
        localb.mxJ.put(paramInt1, str);
        a(localb);
      }
      AppMethodBeat.o(150083);
      return locala;
    }
    Log.e("MicroMsg.NewBadgeDecoder", "[carl] peek, watcher == null");
    AppMethodBeat.o(150083);
    return null;
  }
  
  public final void b(at.a parama, int paramInt, String paramString)
  {
    AppMethodBeat.i(150082);
    Log.d("MicroMsg.NewBadgeDecoder", "[carl] updateDataSourceValue, dataSourceKey %s, type %d, value %s", new Object[] { parama, Integer.valueOf(paramInt), paramString });
    parama = c(parama, paramInt);
    parama.value = paramString;
    parama.type = paramInt;
    parama.hFb = aYm();
    a(parama);
    AppMethodBeat.o(150082);
  }
  
  public final void d(at.a parama1, at.a parama2)
  {
    AppMethodBeat.i(150085);
    Log.d("MicroMsg.NewBadgeDecoder", "[carl] doWatch, doWatch %s, watcherKey %s", new Object[] { parama1, parama2 });
    a locala = f(parama1);
    if (locala == null)
    {
      Log.d("MicroMsg.NewBadgeDecoder", "[carl] doWatch, dataSource == null");
      AppMethodBeat.o(150085);
      return;
    }
    b localb2 = g(parama2);
    b localb1 = localb2;
    if (localb2 == null)
    {
      Log.e("MicroMsg.NewBadgeDecoder", "[carl] doWatch, watcher == null, do some fix");
      localb1 = e(parama2);
      this.mxE.put(parama2, localb1);
    }
    localb1.mxK.put(parama1.name(), locala.hFb);
    a(localb1);
    AppMethodBeat.o(150085);
  }
  
  public final a f(at.a parama)
  {
    AppMethodBeat.i(150078);
    a locala2 = (a)this.mxC.get(parama);
    a locala1 = locala2;
    if (locala2 == null)
    {
      locala2 = c(parama);
      locala1 = locala2;
      if (locala2 != null)
      {
        this.mxC.put(parama, locala2);
        locala1 = locala2;
      }
    }
    AppMethodBeat.o(150078);
    return locala1;
  }
  
  public final void h(int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(150081);
    Log.d("MicroMsg.NewBadgeDecoder", "[carl] updateDataSourceValue, dataSourceId %d, type %d, value %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    a locala = dY(paramInt1, paramInt2);
    locala.value = paramString;
    locala.type = paramInt2;
    locala.hFb = aYm();
    a(locala);
    AppMethodBeat.o(150081);
  }
  
  final b sf(int paramInt)
  {
    AppMethodBeat.i(150071);
    b localb = new b();
    localb.mxI = paramInt;
    AppMethodBeat.o(150071);
    return localb;
  }
  
  public final a sg(int paramInt)
  {
    AppMethodBeat.i(150077);
    a locala2 = (a)this.mxB.get(paramInt);
    a locala1 = locala2;
    if (locala2 == null)
    {
      locala2 = sd(paramInt);
      locala1 = locala2;
      if (locala2 != null)
      {
        this.mxB.put(paramInt, locala2);
        locala1 = locala2;
      }
    }
    AppMethodBeat.o(150077);
    return locala1;
  }
  
  final b sh(int paramInt)
  {
    AppMethodBeat.i(150079);
    b localb2 = (b)this.mxD.get(paramInt);
    b localb1 = localb2;
    if (localb2 == null)
    {
      localb1 = se(paramInt);
      if (localb1 == null)
      {
        Log.e("MicroMsg.NewBadgeDecoder", "[carl] loadWatcher watcher == null");
        AppMethodBeat.o(150079);
        return null;
      }
      this.mxD.put(paramInt, localb1);
    }
    AppMethodBeat.o(150079);
    return localb1;
  }
  
  public final class a
  {
    String hFb;
    int mxx;
    at.a mxy;
    int type;
    public String value;
    
    public a() {}
  }
  
  public final class b
  {
    at.a mxA;
    int mxI;
    SparseArray<String> mxJ;
    HashMap<String, String> mxK;
    
    public b()
    {
      AppMethodBeat.i(150059);
      this.mxJ = new SparseArray();
      this.mxK = new HashMap();
      AppMethodBeat.o(150059);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.aa.b
 * JD-Core Version:    0.7.0.1
 */