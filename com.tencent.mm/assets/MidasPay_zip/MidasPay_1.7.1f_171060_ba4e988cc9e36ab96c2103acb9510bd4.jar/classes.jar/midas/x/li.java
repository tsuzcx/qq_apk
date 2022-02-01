package midas.x;

import android.content.Context;
import java.util.ArrayList;
import java.util.Iterator;

public class li
{
  public static ArrayList<kx> a(Context paramContext, ky paramky, ArrayList<kx> paramArrayList, int paramInt)
  {
    boolean bool1 = ls.a(paramInt);
    boolean bool2 = ls.b(paramInt);
    if ((bool1) && (bool2)) {
      return paramArrayList;
    }
    if ((bool1) && (!bool2))
    {
      paramContext = new ArrayList();
      paramky = paramArrayList.iterator();
      while (paramky.hasNext())
      {
        paramArrayList = (kx)paramky.next();
        if (ls.a(paramArrayList.a)) {
          paramContext.add(paramArrayList);
        }
      }
      return paramContext;
    }
    if ((!bool1) && (bool2))
    {
      paramContext = new ArrayList();
      paramky = paramArrayList.iterator();
      while (paramky.hasNext())
      {
        paramArrayList = (kx)paramky.next();
        if (ls.b(paramArrayList.a)) {
          paramContext.add(paramArrayList);
        }
      }
      return paramContext;
    }
    paramContext = new ArrayList();
    paramky = paramArrayList.iterator();
    while (paramky.hasNext())
    {
      paramArrayList = (kx)paramky.next();
      if (ls.a(paramArrayList.a)) {
        paramContext.add(paramArrayList);
      }
    }
    return paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.1f_171060_ba4e988cc9e36ab96c2103acb9510bd4.jar\classes.jar
 * Qualified Name:     midas.x.li
 * JD-Core Version:    0.7.0.1
 */