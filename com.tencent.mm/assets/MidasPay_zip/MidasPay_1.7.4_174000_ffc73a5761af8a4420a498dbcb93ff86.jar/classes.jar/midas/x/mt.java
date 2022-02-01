package midas.x;

import android.content.Context;
import java.util.ArrayList;
import java.util.Iterator;

public class mt
{
  public static ArrayList<mi> a(Context paramContext, mj parammj, ArrayList<mi> paramArrayList, int paramInt)
  {
    boolean bool1 = nd.a(paramInt);
    boolean bool2 = nd.b(paramInt);
    if ((bool1) && (bool2)) {
      return paramArrayList;
    }
    if ((bool1) && (!bool2))
    {
      paramContext = new ArrayList();
      parammj = paramArrayList.iterator();
      while (parammj.hasNext())
      {
        paramArrayList = (mi)parammj.next();
        if (nd.a(paramArrayList.a)) {
          paramContext.add(paramArrayList);
        }
      }
      return paramContext;
    }
    if ((!bool1) && (bool2))
    {
      paramContext = new ArrayList();
      parammj = paramArrayList.iterator();
      while (parammj.hasNext())
      {
        paramArrayList = (mi)parammj.next();
        if (nd.b(paramArrayList.a)) {
          paramContext.add(paramArrayList);
        }
      }
      return paramContext;
    }
    paramContext = new ArrayList();
    parammj = paramArrayList.iterator();
    while (parammj.hasNext())
    {
      paramArrayList = (mi)parammj.next();
      if (nd.a(paramArrayList.a)) {
        paramContext.add(paramArrayList);
      }
    }
    return paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.4_174000_ffc73a5761af8a4420a498dbcb93ff86.jar\classes.jar
 * Qualified Name:     midas.x.mt
 * JD-Core Version:    0.7.0.1
 */