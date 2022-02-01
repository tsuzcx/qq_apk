package midas.x;

import android.content.Context;
import android.util.Pair;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

public class lf
{
  private static kw.g a;
  
  private static ArrayList<String> a(Context paramContext, ky paramky, ArrayList<kx> paramArrayList)
  {
    Object localObject = new ArrayList(paramArrayList);
    paramContext = new ArrayList();
    paramky = new ArrayList();
    paramArrayList = new ArrayList();
    localObject = ((ArrayList)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      kx localkx = (kx)((Iterator)localObject).next();
      if (localkx.e.intValue() > 0) {
        paramContext.add(new kx(localkx));
      } else if (((Long)localkx.b.second).longValue() > 0L) {
        paramky.add(new kx(localkx));
      } else {
        paramArrayList.add(new kx(localkx));
      }
    }
    if (paramContext.size() > 0) {
      Collections.sort(paramContext, new Comparator()
      {
        public int a(kx paramAnonymouskx1, kx paramAnonymouskx2)
        {
          return paramAnonymouskx1.e.intValue() - paramAnonymouskx2.e.intValue();
        }
      });
    }
    if (paramky.size() > 0) {
      Collections.sort(paramky, new Comparator()
      {
        public int a(kx paramAnonymouskx1, kx paramAnonymouskx2)
        {
          if (((Long)paramAnonymouskx1.b.second).longValue() - ((Long)paramAnonymouskx2.b.second).longValue() > 1000L) {
            return 1;
          }
          return -1;
        }
      });
    }
    if (paramArrayList.size() > 0) {
      Collections.sort(paramArrayList, new Comparator()
      {
        public int a(kx paramAnonymouskx1, kx paramAnonymouskx2)
        {
          int i = paramAnonymouskx1.a(8);
          int j = paramAnonymouskx2.a(8);
          if (i != j) {
            return i - j;
          }
          long l1 = paramAnonymouskx1.d() - paramAnonymouskx2.d();
          long l2 = Math.abs(l1);
          i = -1;
          if (l2 > 30000L)
          {
            if (l1 > 0L) {
              i = 1;
            }
            return i;
          }
          l1 = paramAnonymouskx1.e() - paramAnonymouskx2.e();
          if (Math.abs(l1) > 30000L)
          {
            if (l1 > 0L) {
              return -1;
            }
            return 1;
          }
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("otherList.sort().random : ");
          localStringBuilder.append(paramAnonymouskx1);
          localStringBuilder.append("->");
          localStringBuilder.append(paramAnonymouskx2);
          lc.b("Midas-IPSorter", localStringBuilder.toString());
          if (Math.random() > 0.5D) {
            i = 1;
          }
          return i;
        }
      });
    }
    paramContext.addAll(paramky);
    paramContext.addAll(paramArrayList);
    paramky = new ArrayList(paramContext.size());
    paramContext = paramContext.iterator();
    while (paramContext.hasNext()) {
      paramky.add(((kx)paramContext.next()).a);
    }
    return paramky;
  }
  
  public static ArrayList<String> a(Context paramContext, ky paramky, ArrayList<kx> paramArrayList, int paramInt)
  {
    if (a != null) {
      return a.a(paramContext, paramky, paramArrayList, paramInt);
    }
    return a(paramContext, paramky, paramArrayList);
  }
  
  public static void a(kw.g paramg)
  {
    a = paramg;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.1f_171060_ba4e988cc9e36ab96c2103acb9510bd4.jar\classes.jar
 * Qualified Name:     midas.x.lf
 * JD-Core Version:    0.7.0.1
 */