package midas.x;

import android.content.Context;
import java.util.ArrayList;
import java.util.Iterator;

public class la
{
  private static kw.b a;
  
  public static ArrayList<kx> a(Context paramContext, ky paramky, ArrayList<kx> paramArrayList)
  {
    if (a != null) {
      return a.a(paramContext, paramky, paramArrayList);
    }
    return b(paramContext, paramky, paramArrayList);
  }
  
  private static ArrayList<kx> b(Context paramContext, ky paramky, ArrayList<kx> paramArrayList)
  {
    paramContext = new ArrayList();
    paramky = new ArrayList();
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      kx localkx = (kx)paramArrayList.next();
      if (!localkx.c()) {
        paramContext.add(localkx);
      } else {
        paramky.add(localkx);
      }
    }
    if (paramky.size() > 0)
    {
      paramArrayList = new StringBuilder();
      paramArrayList.append("filter() bad ips = ");
      paramArrayList.append(paramky);
      lc.c("Midas-IPFilter", paramArrayList.toString());
    }
    return paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.1f_171060_ba4e988cc9e36ab96c2103acb9510bd4.jar\classes.jar
 * Qualified Name:     midas.x.la
 * JD-Core Version:    0.7.0.1
 */