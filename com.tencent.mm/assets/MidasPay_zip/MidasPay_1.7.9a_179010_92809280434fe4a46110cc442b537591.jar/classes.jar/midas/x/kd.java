package midas.x;

import android.content.Context;
import java.util.ArrayList;
import java.util.Iterator;

public class kd
{
  public static ArrayList<zc> a(Context paramContext, ad paramad, ArrayList<zc> paramArrayList, int paramInt)
  {
    boolean bool1 = ud.a(paramInt);
    boolean bool2 = ud.b(paramInt);
    if ((bool1) && (bool2)) {
      return paramArrayList;
    }
    if ((bool1) && (!bool2))
    {
      paramContext = new ArrayList();
      paramad = paramArrayList.iterator();
      while (paramad.hasNext())
      {
        paramArrayList = (zc)paramad.next();
        if (ud.a(paramArrayList.a)) {
          paramContext.add(paramArrayList);
        }
      }
      return paramContext;
    }
    if ((!bool1) && (bool2))
    {
      paramContext = new ArrayList();
      paramad = paramArrayList.iterator();
      while (paramad.hasNext())
      {
        paramArrayList = (zc)paramad.next();
        if (ud.b(paramArrayList.a)) {
          paramContext.add(paramArrayList);
        }
      }
      return paramContext;
    }
    paramContext = new ArrayList();
    paramad = paramArrayList.iterator();
    while (paramad.hasNext())
    {
      paramArrayList = (zc)paramad.next();
      if (ud.a(paramArrayList.a)) {
        paramContext.add(paramArrayList);
      }
    }
    return paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.9a_179010_92809280434fe4a46110cc442b537591.jar\classes.jar
 * Qualified Name:     midas.x.kd
 * JD-Core Version:    0.7.0.1
 */