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

public class nc
{
  public static int a(String paramString)
  {
    if (Build.VERSION.SDK_INT >= 23) {
      return mg.a.checkSelfPermission(paramString);
    }
    PackageManager localPackageManager = mg.a.getPackageManager();
    try
    {
      int i = localPackageManager.checkPermission(paramString, localPackageManager.getPackageInfo(mg.a.getPackageName(), 0).packageName);
      return i;
    }
    catch (Exception paramString)
    {
      label45:
      break label45;
    }
    return -1;
  }
  
  private static ArrayList<Pair<Long, Long>> a(mi parammi)
  {
    ArrayList localArrayList = new ArrayList(parammi.c.length);
    int i = 0;
    while (i < parammi.c.length)
    {
      int j = (parammi.d.intValue() + i) % parammi.c.length;
      if (((Long)parammi.c[j].first).longValue() > 0L) {
        localArrayList.add(new Pair(parammi.c[j].first, parammi.c[j].second));
      }
      i += 1;
    }
    return localArrayList;
  }
  
  public static void a(ArrayList<mj> paramArrayList1, ArrayList<mj> paramArrayList2)
  {
    paramArrayList2 = paramArrayList2.iterator();
    while (paramArrayList2.hasNext())
    {
      mj localmj = (mj)paramArrayList2.next();
      if (paramArrayList1.contains(localmj)) {
        a((mj)paramArrayList1.get(paramArrayList1.indexOf(localmj)), localmj);
      } else {
        paramArrayList1.add(localmj);
      }
    }
  }
  
  public static void a(CopyOnWriteArrayList<mi> paramCopyOnWriteArrayList1, CopyOnWriteArrayList<mi> paramCopyOnWriteArrayList2)
  {
    paramCopyOnWriteArrayList2 = paramCopyOnWriteArrayList2.iterator();
    while (paramCopyOnWriteArrayList2.hasNext())
    {
      mi localmi = (mi)paramCopyOnWriteArrayList2.next();
      if (paramCopyOnWriteArrayList1.contains(localmi)) {
        a((mi)paramCopyOnWriteArrayList1.get(paramCopyOnWriteArrayList1.indexOf(localmi)), localmi);
      } else {
        paramCopyOnWriteArrayList1.add(localmi);
      }
    }
  }
  
  public static void a(mi parammi1, mi parammi2)
  {
    if (TextUtils.isEmpty(parammi2.a)) {
      localObject = parammi1.a;
    } else {
      localObject = parammi2.a;
    }
    parammi1.a = ((String)localObject);
    if (((Long)parammi2.b.first).longValue() > ((Long)parammi1.b.first).longValue()) {
      localObject = parammi2.b;
    } else {
      localObject = parammi1.b;
    }
    parammi1.b = ((Pair)localObject);
    Object localObject = a(parammi1);
    ArrayList localArrayList = a(parammi2);
    int k = 0;
    int i = 0;
    while (i < parammi1.c.length)
    {
      parammi1.c[i] = new Pair(Long.valueOf(0L), Long.valueOf(0L));
      i += 1;
    }
    parammi1.d = Integer.valueOf(0);
    int m;
    for (int j = 0;; j = m)
    {
      if ((k >= ((ArrayList)localObject).size()) && (j >= localArrayList.size()))
      {
        if (parammi2.e.intValue() > 0) {
          parammi2 = parammi2.e;
        } else {
          parammi2 = parammi1.e;
        }
        parammi1.e = parammi2;
        return;
      }
      Pair[] arrayOfPair;
      Integer localInteger;
      if ((k < ((ArrayList)localObject).size()) && (j < localArrayList.size())) {
        if (((Long)((Pair)((ArrayList)localObject).get(k)).first).longValue() < ((Long)((Pair)localArrayList.get(j)).first).longValue())
        {
          arrayOfPair = parammi1.c;
          localInteger = parammi1.d;
          parammi1.d = Integer.valueOf(parammi1.d.intValue() + 1);
          m = localInteger.intValue();
          i = k + 1;
          arrayOfPair[m] = ((Pair)((ArrayList)localObject).get(k));
        }
      }
      for (;;)
      {
        m = j;
        break;
        arrayOfPair = parammi1.c;
        localInteger = parammi1.d;
        parammi1.d = Integer.valueOf(parammi1.d.intValue() + 1);
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
          arrayOfPair = parammi1.c;
          localInteger = parammi1.d;
          parammi1.d = Integer.valueOf(parammi1.d.intValue() + 1);
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
        arrayOfPair = parammi1.c;
        localInteger = parammi1.d;
        parammi1.d = Integer.valueOf(parammi1.d.intValue() + 1);
        m = localInteger.intValue();
        i = k + 1;
        arrayOfPair[m] = ((Pair)((ArrayList)localObject).get(k));
      }
      label544:
      parammi1.d = Integer.valueOf(parammi1.d.intValue() % mi.f);
      k = i;
    }
  }
  
  public static void a(mj parammj1, mj parammj2)
  {
    String str;
    if (TextUtils.isEmpty(parammj2.a)) {
      str = parammj1.a;
    } else {
      str = parammj2.a;
    }
    parammj1.a = str;
    parammj1.b = Long.valueOf(Math.max(parammj1.b.longValue(), parammj2.b.longValue()));
    parammj1.c = Long.valueOf(Math.max(parammj1.c.longValue(), parammj2.c.longValue()));
    if ((parammj1.d.longValue() != 0L) && (parammj2.d.longValue() != 0L)) {
      parammj1.d = Long.valueOf(Math.min(parammj1.d.longValue(), parammj2.d.longValue()));
    } else {
      parammj1.d = Long.valueOf(Math.max(parammj1.d.longValue(), parammj2.d.longValue()));
    }
    a(parammj1.e, parammj2.e);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.4_174000_ffc73a5761af8a4420a498dbcb93ff86.jar\classes.jar
 * Qualified Name:     midas.x.nc
 * JD-Core Version:    0.7.0.1
 */