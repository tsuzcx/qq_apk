package midas.x;

import android.content.Context;
import android.util.Pair;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

public class hd
{
  public static wc a;
  
  public static ArrayList<String> a(Context paramContext, ad paramad, ArrayList<zc> paramArrayList)
  {
    Object localObject = new ArrayList(paramArrayList);
    paramContext = new ArrayList();
    paramad = new ArrayList();
    paramArrayList = new ArrayList();
    localObject = ((ArrayList)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      zc localzc = (zc)((Iterator)localObject).next();
      if (localzc.e.intValue() > 0) {
        paramContext.add(new zc(localzc));
      } else if (((Long)localzc.b.second).longValue() > 0L) {
        paramad.add(new zc(localzc));
      } else {
        paramArrayList.add(new zc(localzc));
      }
    }
    if (paramContext.size() > 0) {
      Collections.sort(paramContext, new a());
    }
    if (paramad.size() > 0) {
      Collections.sort(paramad, new b());
    }
    if (paramArrayList.size() > 0) {
      Collections.sort(paramArrayList, new c());
    }
    paramContext.addAll(paramad);
    paramContext.addAll(paramArrayList);
    paramad = new ArrayList(paramContext.size());
    paramContext = paramContext.iterator();
    while (paramContext.hasNext()) {
      paramad.add(((zc)paramContext.next()).a);
    }
    return paramad;
  }
  
  public static ArrayList<String> a(Context paramContext, ad paramad, ArrayList<zc> paramArrayList, int paramInt)
  {
    wc localwc = a;
    if (localwc != null) {
      return localwc.a(paramContext, paramad, paramArrayList, paramInt);
    }
    return a(paramContext, paramad, paramArrayList);
  }
  
  public static void a(wc paramwc)
  {
    a = paramwc;
  }
  
  public static final class a
    implements Comparator<zc>
  {
    public int a(zc paramzc1, zc paramzc2)
    {
      return paramzc1.e.intValue() - paramzc2.e.intValue();
    }
  }
  
  public static final class b
    implements Comparator<zc>
  {
    public int a(zc paramzc1, zc paramzc2)
    {
      if (((Long)paramzc1.b.second).longValue() - ((Long)paramzc2.b.second).longValue() > 1000L) {
        return 1;
      }
      return -1;
    }
  }
  
  public static final class c
    implements Comparator<zc>
  {
    public int a(zc paramzc1, zc paramzc2)
    {
      int i = paramzc1.a(8);
      int j = paramzc2.a(8);
      if (i != j) {
        return i - j;
      }
      long l1 = paramzc1.c() - paramzc2.c();
      long l2 = Math.abs(l1);
      i = 1;
      if (l2 > 30000L)
      {
        if (l1 > 0L) {
          return 1;
        }
        return -1;
      }
      l1 = paramzc1.d() - paramzc2.d();
      if (Math.abs(l1) > 30000L)
      {
        if (l1 > 0L) {
          i = -1;
        }
        return i;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("otherList.sort().random : ");
      localStringBuilder.append(paramzc1);
      localStringBuilder.append("->");
      localStringBuilder.append(paramzc2);
      ed.a("Midas-IPSorter", localStringBuilder.toString());
      if (Math.random() > 0.5D) {
        return 1;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.9a_179010_92809280434fe4a46110cc442b537591.jar\classes.jar
 * Qualified Name:     midas.x.hd
 * JD-Core Version:    0.7.0.1
 */