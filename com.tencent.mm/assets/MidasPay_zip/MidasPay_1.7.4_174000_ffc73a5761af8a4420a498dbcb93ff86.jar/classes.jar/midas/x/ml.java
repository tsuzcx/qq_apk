package midas.x;

import android.content.Context;
import java.util.ArrayList;
import java.util.Iterator;

public class ml
{
  private static mh.b a;
  
  public static ArrayList<mi> a(Context paramContext, mj parammj, ArrayList<mi> paramArrayList)
  {
    if (a != null) {
      return a.a(paramContext, parammj, paramArrayList);
    }
    return b(paramContext, parammj, paramArrayList);
  }
  
  private static ArrayList<mi> b(Context paramContext, mj parammj, ArrayList<mi> paramArrayList)
  {
    paramContext = new ArrayList();
    parammj = new ArrayList();
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      mi localmi = (mi)paramArrayList.next();
      if (!localmi.c()) {
        paramContext.add(localmi);
      } else {
        parammj.add(localmi);
      }
    }
    if (parammj.size() > 0)
    {
      paramArrayList = new StringBuilder();
      paramArrayList.append("filter() bad ips = ");
      paramArrayList.append(parammj);
      mn.c("Midas-IPFilter", paramArrayList.toString());
    }
    return paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.4_174000_ffc73a5761af8a4420a498dbcb93ff86.jar\classes.jar
 * Qualified Name:     midas.x.ml
 * JD-Core Version:    0.7.0.1
 */