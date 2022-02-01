package midas.x;

import android.content.Context;
import android.util.Pair;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

public class mq
{
  private static mh.g a;
  
  private static ArrayList<String> a(Context paramContext, mj parammj, ArrayList<mi> paramArrayList)
  {
    Object localObject = new ArrayList(paramArrayList);
    paramContext = new ArrayList();
    parammj = new ArrayList();
    paramArrayList = new ArrayList();
    localObject = ((ArrayList)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      mi localmi = (mi)((Iterator)localObject).next();
      if (localmi.e.intValue() > 0) {
        paramContext.add(new mi(localmi));
      } else if (((Long)localmi.b.second).longValue() > 0L) {
        parammj.add(new mi(localmi));
      } else {
        paramArrayList.add(new mi(localmi));
      }
    }
    if (paramContext.size() > 0) {
      Collections.sort(paramContext, new Comparator()
      {
        public int a(mi paramAnonymousmi1, mi paramAnonymousmi2)
        {
          return paramAnonymousmi1.e.intValue() - paramAnonymousmi2.e.intValue();
        }
      });
    }
    if (parammj.size() > 0) {
      Collections.sort(parammj, new Comparator()
      {
        public int a(mi paramAnonymousmi1, mi paramAnonymousmi2)
        {
          if (((Long)paramAnonymousmi1.b.second).longValue() - ((Long)paramAnonymousmi2.b.second).longValue() > 1000L) {
            return 1;
          }
          return -1;
        }
      });
    }
    if (paramArrayList.size() > 0) {
      Collections.sort(paramArrayList, new Comparator()
      {
        public int a(mi paramAnonymousmi1, mi paramAnonymousmi2)
        {
          int i = paramAnonymousmi1.a(8);
          int j = paramAnonymousmi2.a(8);
          if (i != j) {
            return i - j;
          }
          long l1 = paramAnonymousmi1.d() - paramAnonymousmi2.d();
          long l2 = Math.abs(l1);
          i = -1;
          if (l2 > 30000L)
          {
            if (l1 > 0L) {
              i = 1;
            }
            return i;
          }
          l1 = paramAnonymousmi1.e() - paramAnonymousmi2.e();
          if (Math.abs(l1) > 30000L)
          {
            if (l1 > 0L) {
              return -1;
            }
            return 1;
          }
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("otherList.sort().random : ");
          localStringBuilder.append(paramAnonymousmi1);
          localStringBuilder.append("->");
          localStringBuilder.append(paramAnonymousmi2);
          mn.b("Midas-IPSorter", localStringBuilder.toString());
          if (Math.random() > 0.5D) {
            i = 1;
          }
          return i;
        }
      });
    }
    paramContext.addAll(parammj);
    paramContext.addAll(paramArrayList);
    parammj = new ArrayList(paramContext.size());
    paramContext = paramContext.iterator();
    while (paramContext.hasNext()) {
      parammj.add(((mi)paramContext.next()).a);
    }
    return parammj;
  }
  
  public static ArrayList<String> a(Context paramContext, mj parammj, ArrayList<mi> paramArrayList, int paramInt)
  {
    if (a != null) {
      return a.a(paramContext, parammj, paramArrayList, paramInt);
    }
    return a(paramContext, parammj, paramArrayList);
  }
  
  public static void a(mh.g paramg)
  {
    a = paramg;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.4_174000_ffc73a5761af8a4420a498dbcb93ff86.jar\classes.jar
 * Qualified Name:     midas.x.mq
 * JD-Core Version:    0.7.0.1
 */