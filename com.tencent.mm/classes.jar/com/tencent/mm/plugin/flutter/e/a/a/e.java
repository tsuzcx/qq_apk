package com.tencent.mm.plugin.flutter.e.a.a;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.vlog.util.a;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.util.Iterator;
import java.util.List;

public final class e
{
  public static int bAX()
  {
    AppMethodBeat.i(240952);
    try
    {
      Object localObject = (ConnectivityManager)MMApplicationContext.getContext().getSystemService("connectivity");
      if (localObject == null)
      {
        AppMethodBeat.o(240952);
        return 0;
      }
      localObject = ((ConnectivityManager)localObject).getActiveNetworkInfo();
      if (localObject != null)
      {
        boolean bool = ((NetworkInfo)localObject).isConnected();
        if (bool) {}
      }
      else
      {
        AppMethodBeat.o(240952);
        return 0;
      }
      int i = ((NetworkInfo)localObject).getType();
      if (i == 1)
      {
        AppMethodBeat.o(240952);
        return 1;
      }
      if ((((NetworkInfo)localObject).getSubtype() != 2) && (((NetworkInfo)localObject).getSubtype() != 1))
      {
        i = ((NetworkInfo)localObject).getSubtype();
        if (i != 4) {}
      }
      else
      {
        AppMethodBeat.o(240952);
        return 2;
      }
      if (((NetworkInfo)localObject).getSubtype() >= 5)
      {
        i = ((NetworkInfo)localObject).getSubtype();
        if (i < 13)
        {
          AppMethodBeat.o(240952);
          return 3;
        }
      }
      if (((NetworkInfo)localObject).getSubtype() >= 13)
      {
        i = ((NetworkInfo)localObject).getSubtype();
        if (i < 20)
        {
          AppMethodBeat.o(240952);
          return 4;
        }
      }
      i = ((NetworkInfo)localObject).getSubtype();
      if (i >= 20)
      {
        AppMethodBeat.o(240952);
        return 5;
      }
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(240952);
    }
    return 0;
  }
  
  public static String eK(List<String> paramList)
  {
    AppMethodBeat.i(240953);
    StringBuilder localStringBuilder1 = new StringBuilder();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      String str = (String)paramList.next();
      StringBuilder localStringBuilder2 = new StringBuilder();
      a locala = a.GQC;
      localStringBuilder1.append(a.aUr(str) + "#");
    }
    paramList = localStringBuilder1.toString();
    AppMethodBeat.o(240953);
    return paramList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.flutter.e.a.a.e
 * JD-Core Version:    0.7.0.1
 */