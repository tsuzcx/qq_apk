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

public class lr
{
  public static int a(String paramString)
  {
    if (Build.VERSION.SDK_INT >= 23) {
      return kv.a.checkSelfPermission(paramString);
    }
    PackageManager localPackageManager = kv.a.getPackageManager();
    try
    {
      int i = localPackageManager.checkPermission(paramString, localPackageManager.getPackageInfo(kv.a.getPackageName(), 0).packageName);
      return i;
    }
    catch (Exception paramString)
    {
      label45:
      break label45;
    }
    return -1;
  }
  
  private static ArrayList<Pair<Long, Long>> a(kx paramkx)
  {
    ArrayList localArrayList = new ArrayList(paramkx.c.length);
    int i = 0;
    while (i < paramkx.c.length)
    {
      int j = (paramkx.d.intValue() + i) % paramkx.c.length;
      if (((Long)paramkx.c[j].first).longValue() > 0L) {
        localArrayList.add(new Pair(paramkx.c[j].first, paramkx.c[j].second));
      }
      i += 1;
    }
    return localArrayList;
  }
  
  public static void a(ArrayList<ky> paramArrayList1, ArrayList<ky> paramArrayList2)
  {
    paramArrayList2 = paramArrayList2.iterator();
    while (paramArrayList2.hasNext())
    {
      ky localky = (ky)paramArrayList2.next();
      if (paramArrayList1.contains(localky)) {
        a((ky)paramArrayList1.get(paramArrayList1.indexOf(localky)), localky);
      } else {
        paramArrayList1.add(localky);
      }
    }
  }
  
  public static void a(CopyOnWriteArrayList<kx> paramCopyOnWriteArrayList1, CopyOnWriteArrayList<kx> paramCopyOnWriteArrayList2)
  {
    paramCopyOnWriteArrayList2 = paramCopyOnWriteArrayList2.iterator();
    while (paramCopyOnWriteArrayList2.hasNext())
    {
      kx localkx = (kx)paramCopyOnWriteArrayList2.next();
      if (paramCopyOnWriteArrayList1.contains(localkx)) {
        a((kx)paramCopyOnWriteArrayList1.get(paramCopyOnWriteArrayList1.indexOf(localkx)), localkx);
      } else {
        paramCopyOnWriteArrayList1.add(localkx);
      }
    }
  }
  
  public static void a(kx paramkx1, kx paramkx2)
  {
    if (TextUtils.isEmpty(paramkx2.a)) {
      localObject = paramkx1.a;
    } else {
      localObject = paramkx2.a;
    }
    paramkx1.a = ((String)localObject);
    if (((Long)paramkx2.b.first).longValue() > ((Long)paramkx1.b.first).longValue()) {
      localObject = paramkx2.b;
    } else {
      localObject = paramkx1.b;
    }
    paramkx1.b = ((Pair)localObject);
    Object localObject = a(paramkx1);
    ArrayList localArrayList = a(paramkx2);
    int k = 0;
    int i = 0;
    while (i < paramkx1.c.length)
    {
      paramkx1.c[i] = new Pair(Long.valueOf(0L), Long.valueOf(0L));
      i += 1;
    }
    paramkx1.d = Integer.valueOf(0);
    int m;
    for (int j = 0;; j = m)
    {
      if ((k >= ((ArrayList)localObject).size()) && (j >= localArrayList.size()))
      {
        if (paramkx2.e.intValue() > 0) {
          paramkx2 = paramkx2.e;
        } else {
          paramkx2 = paramkx1.e;
        }
        paramkx1.e = paramkx2;
        return;
      }
      Pair[] arrayOfPair;
      Integer localInteger;
      if ((k < ((ArrayList)localObject).size()) && (j < localArrayList.size())) {
        if (((Long)((Pair)((ArrayList)localObject).get(k)).first).longValue() < ((Long)((Pair)localArrayList.get(j)).first).longValue())
        {
          arrayOfPair = paramkx1.c;
          localInteger = paramkx1.d;
          paramkx1.d = Integer.valueOf(paramkx1.d.intValue() + 1);
          m = localInteger.intValue();
          i = k + 1;
          arrayOfPair[m] = ((Pair)((ArrayList)localObject).get(k));
        }
      }
      for (;;)
      {
        m = j;
        break;
        arrayOfPair = paramkx1.c;
        localInteger = paramkx1.d;
        paramkx1.d = Integer.valueOf(paramkx1.d.intValue() + 1);
        m = localInteger.intValue();
        i = j + 1;
        arrayOfPair[m] = ((Pair)localArrayList.get(j));
        for (;;)
        {
          m = i;
          i = k;
          break label544;
          if ((k < ((ArrayList)localObject).size()) || (j >= localArrayList.size())) {
            break;
          }
          arrayOfPair = paramkx1.c;
          localInteger = paramkx1.d;
          paramkx1.d = Integer.valueOf(paramkx1.d.intValue() + 1);
          m = localInteger.intValue();
          i = j + 1;
          arrayOfPair[m] = ((Pair)localArrayList.get(j));
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
        arrayOfPair = paramkx1.c;
        localInteger = paramkx1.d;
        paramkx1.d = Integer.valueOf(paramkx1.d.intValue() + 1);
        m = localInteger.intValue();
        i = k + 1;
        arrayOfPair[m] = ((Pair)((ArrayList)localObject).get(k));
      }
      label544:
      paramkx1.d = Integer.valueOf(paramkx1.d.intValue() % kx.f);
      k = i;
    }
  }
  
  public static void a(ky paramky1, ky paramky2)
  {
    String str;
    if (TextUtils.isEmpty(paramky2.a)) {
      str = paramky1.a;
    } else {
      str = paramky2.a;
    }
    paramky1.a = str;
    paramky1.b = Long.valueOf(Math.max(paramky1.b.longValue(), paramky2.b.longValue()));
    paramky1.c = Long.valueOf(Math.max(paramky1.c.longValue(), paramky2.c.longValue()));
    if ((paramky1.d.longValue() != 0L) && (paramky2.d.longValue() != 0L)) {
      paramky1.d = Long.valueOf(Math.min(paramky1.d.longValue(), paramky2.d.longValue()));
    } else {
      paramky1.d = Long.valueOf(Math.max(paramky1.d.longValue(), paramky2.d.longValue()));
    }
    a(paramky1.e, paramky2.e);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.1f_171060_ba4e988cc9e36ab96c2103acb9510bd4.jar\classes.jar
 * Qualified Name:     midas.x.lr
 * JD-Core Version:    0.7.0.1
 */