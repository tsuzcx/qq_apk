package midas.x;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.util.Pair;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public class td
{
  public static int a(String paramString)
  {
    if (Build.VERSION.SDK_INT >= 23) {
      return pc.g.checkSelfPermission(paramString);
    }
    PackageManager localPackageManager = pc.g.getPackageManager();
    try
    {
      int i = localPackageManager.checkPermission(paramString, localPackageManager.getPackageInfo(pc.g.getPackageName(), 0).packageName);
      return i;
    }
    catch (Exception paramString)
    {
      label45:
      break label45;
    }
    return -1;
  }
  
  public static ArrayList<Pair<Long, Long>> a(zc paramzc)
  {
    ArrayList localArrayList = new ArrayList(paramzc.c.length);
    int i = 0;
    while (i < paramzc.c.length)
    {
      int j = (paramzc.d.intValue() + i) % paramzc.c.length;
      if (((Long)paramzc.c[j].first).longValue() > 0L) {
        localArrayList.add(new Pair(paramzc.c[j].first, paramzc.c[j].second));
      }
      i += 1;
    }
    return localArrayList;
  }
  
  public static void a(ArrayList<ad> paramArrayList1, ArrayList<ad> paramArrayList2)
  {
    paramArrayList2 = paramArrayList2.iterator();
    while (paramArrayList2.hasNext())
    {
      ad localad = (ad)paramArrayList2.next();
      if (paramArrayList1.contains(localad)) {
        a((ad)paramArrayList1.get(paramArrayList1.indexOf(localad)), localad);
      } else {
        paramArrayList1.add(localad);
      }
    }
  }
  
  public static void a(CopyOnWriteArrayList<zc> paramCopyOnWriteArrayList1, CopyOnWriteArrayList<zc> paramCopyOnWriteArrayList2)
  {
    paramCopyOnWriteArrayList2 = paramCopyOnWriteArrayList2.iterator();
    while (paramCopyOnWriteArrayList2.hasNext())
    {
      zc localzc = (zc)paramCopyOnWriteArrayList2.next();
      if (paramCopyOnWriteArrayList1.contains(localzc)) {
        a((zc)paramCopyOnWriteArrayList1.get(paramCopyOnWriteArrayList1.indexOf(localzc)), localzc);
      } else {
        paramCopyOnWriteArrayList1.add(localzc);
      }
    }
  }
  
  public static void a(ad paramad1, ad paramad2)
  {
    String str;
    if (TextUtils.isEmpty(paramad2.a)) {
      str = paramad1.a;
    } else {
      str = paramad2.a;
    }
    paramad1.a = str;
    paramad1.b = Long.valueOf(Math.max(paramad1.b.longValue(), paramad2.b.longValue()));
    paramad1.c = Long.valueOf(Math.max(paramad1.c.longValue(), paramad2.c.longValue()));
    if ((paramad1.d.longValue() != 0L) && (paramad2.d.longValue() != 0L)) {
      paramad1.d = Long.valueOf(Math.min(paramad1.d.longValue(), paramad2.d.longValue()));
    } else {
      paramad1.d = Long.valueOf(Math.max(paramad1.d.longValue(), paramad2.d.longValue()));
    }
    a(paramad1.e, paramad2.e);
  }
  
  public static void a(zc paramzc1, zc paramzc2)
  {
    if (TextUtils.isEmpty(paramzc2.a)) {
      localObject = paramzc1.a;
    } else {
      localObject = paramzc2.a;
    }
    paramzc1.a = ((String)localObject);
    if (((Long)paramzc2.b.first).longValue() > ((Long)paramzc1.b.first).longValue()) {
      localObject = paramzc2.b;
    } else {
      localObject = paramzc1.b;
    }
    paramzc1.b = ((Pair)localObject);
    Object localObject = a(paramzc1);
    ArrayList localArrayList = a(paramzc2);
    int k = 0;
    int i = 0;
    while (i < paramzc1.c.length)
    {
      paramzc1.c[i] = new Pair(Long.valueOf(0L), Long.valueOf(0L));
      i += 1;
    }
    paramzc1.d = Integer.valueOf(0);
    int m;
    for (int j = 0;; j = m)
    {
      if ((k >= ((ArrayList)localObject).size()) && (j >= localArrayList.size()))
      {
        if (paramzc2.e.intValue() > 0) {
          paramzc2 = paramzc2.e;
        } else {
          paramzc2 = paramzc1.e;
        }
        paramzc1.e = paramzc2;
        return;
      }
      Pair[] arrayOfPair;
      Integer localInteger;
      if ((k < ((ArrayList)localObject).size()) && (j < localArrayList.size())) {
        if (((Long)((Pair)((ArrayList)localObject).get(k)).first).longValue() < ((Long)((Pair)localArrayList.get(j)).first).longValue())
        {
          arrayOfPair = paramzc1.c;
          localInteger = paramzc1.d;
          paramzc1.d = Integer.valueOf(paramzc1.d.intValue() + 1);
          m = localInteger.intValue();
          i = k + 1;
          arrayOfPair[m] = ((Pair)((ArrayList)localObject).get(k));
        }
      }
      for (;;)
      {
        m = j;
        break;
        arrayOfPair = paramzc1.c;
        localInteger = paramzc1.d;
        paramzc1.d = Integer.valueOf(paramzc1.d.intValue() + 1);
        m = localInteger.intValue();
        i = j + 1;
        arrayOfPair[m] = ((Pair)localArrayList.get(j));
        if ((k >= ((ArrayList)localObject).size()) && (j < localArrayList.size()))
        {
          arrayOfPair = paramzc1.c;
          localInteger = paramzc1.d;
          paramzc1.d = Integer.valueOf(paramzc1.d.intValue() + 1);
          m = localInteger.intValue();
          i = j + 1;
          arrayOfPair[m] = ((Pair)localArrayList.get(j));
          m = i;
          i = k;
          break;
        }
        i = k;
        m = j;
        if (k >= ((ArrayList)localObject).size()) {
          break;
        }
        i = k;
        m = j;
        if (j < localArrayList.size()) {
          break;
        }
        arrayOfPair = paramzc1.c;
        localInteger = paramzc1.d;
        paramzc1.d = Integer.valueOf(paramzc1.d.intValue() + 1);
        m = localInteger.intValue();
        i = k + 1;
        arrayOfPair[m] = ((Pair)((ArrayList)localObject).get(k));
      }
      paramzc1.d = Integer.valueOf(paramzc1.d.intValue() % zc.f);
      k = i;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.9a_179010_92809280434fe4a46110cc442b537591.jar\classes.jar
 * Qualified Name:     midas.x.td
 * JD-Core Version:    0.7.0.1
 */