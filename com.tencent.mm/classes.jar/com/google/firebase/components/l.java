package com.google.firebase.components;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ServiceInfo;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

final class l
  implements m
{
  private static Bundle ah(Context paramContext)
  {
    AppMethodBeat.i(10618);
    try
    {
      PackageManager localPackageManager = paramContext.getPackageManager();
      if (localPackageManager == null)
      {
        AppMethodBeat.o(10618);
        return null;
      }
      paramContext = localPackageManager.getServiceInfo(new ComponentName(paramContext, ComponentDiscoveryService.class), 128);
      if (paramContext == null)
      {
        AppMethodBeat.o(10618);
        return null;
      }
      paramContext = paramContext.metaData;
      AppMethodBeat.o(10618);
      return paramContext;
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      AppMethodBeat.o(10618);
    }
    return null;
  }
  
  public final List<String> ag(Context paramContext)
  {
    AppMethodBeat.i(10617);
    paramContext = ah(paramContext);
    if (paramContext == null)
    {
      paramContext = Collections.emptyList();
      AppMethodBeat.o(10617);
      return paramContext;
    }
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = paramContext.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if (("com.google.firebase.components.ComponentRegistrar".equals(paramContext.get(str))) && (str.startsWith("com.google.firebase.components:"))) {
        localArrayList.add(str.substring(31));
      }
    }
    AppMethodBeat.o(10617);
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.google.firebase.components.l
 * JD-Core Version:    0.7.0.1
 */