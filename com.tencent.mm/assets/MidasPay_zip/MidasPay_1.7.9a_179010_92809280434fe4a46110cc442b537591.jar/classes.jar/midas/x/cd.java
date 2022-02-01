package midas.x;

import android.content.Context;
import java.util.ArrayList;
import java.util.Iterator;

public class cd
{
  public static rc a;
  
  public static ArrayList<zc> a(Context paramContext, ad paramad, ArrayList<zc> paramArrayList)
  {
    paramContext = new ArrayList();
    paramad = new ArrayList();
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      zc localzc = (zc)paramArrayList.next();
      if (!localzc.b()) {
        paramContext.add(localzc);
      } else {
        paramad.add(localzc);
      }
    }
    if (paramad.size() > 0)
    {
      paramArrayList = new StringBuilder();
      paramArrayList.append("filter() bad ips = ");
      paramArrayList.append(paramad);
      ed.c("Midas-IPFilter", paramArrayList.toString());
    }
    return paramContext;
  }
  
  public static ArrayList<zc> b(Context paramContext, ad paramad, ArrayList<zc> paramArrayList)
  {
    rc localrc = a;
    if (localrc != null) {
      return localrc.a(paramContext, paramad, paramArrayList);
    }
    return a(paramContext, paramad, paramArrayList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.9a_179010_92809280434fe4a46110cc442b537591.jar\classes.jar
 * Qualified Name:     midas.x.cd
 * JD-Core Version:    0.7.0.1
 */