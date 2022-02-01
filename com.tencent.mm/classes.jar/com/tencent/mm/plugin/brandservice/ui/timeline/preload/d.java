package com.tencent.mm.plugin.brandservice.ui.timeline.preload;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.as;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.sdk.platformtools.ay;
import d.g.a.b;
import d.g.b.k;
import d.l;
import d.v;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"bundleToString", "", "bundle", "Landroid/os/Bundle;", "findProcess", "", "context", "Landroid/content/Context;", "predicate", "Lkotlin/Function1;", "Landroid/app/ActivityManager$RunningAppProcessInfo;", "getNetWorkType", "isExpire", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "key", "duration", "", "isNullOrEmpty", "", "putNow", "", "toDebugString", "Landroid/content/Intent;", "toInt", "", "plugin-brandservice_release"})
public final class d
{
  private static final String N(Bundle paramBundle)
  {
    AppMethodBeat.i(6581);
    StringBuilder localStringBuilder = new StringBuilder("Bundle[");
    if (paramBundle == null)
    {
      localStringBuilder.append("null");
      localStringBuilder.append("]");
      paramBundle = localStringBuilder.toString();
      k.g(paramBundle, "out.toString()");
      AppMethodBeat.o(6581);
      return paramBundle;
    }
    for (;;)
    {
      Object localObject;
      try
      {
        Iterator localIterator = paramBundle.keySet().iterator();
        i = 1;
        if (!localIterator.hasNext()) {
          break;
        }
        localObject = (String)localIterator.next();
        if (i == 0) {
          localStringBuilder.append(", ");
        }
        localStringBuilder.append((String)localObject).append('=');
        localObject = paramBundle.get((String)localObject);
        if ((localObject instanceof Object[])) {
          localStringBuilder.append(Arrays.toString((Object[])localObject));
        } else if ((localObject instanceof Bundle)) {
          localStringBuilder.append(N((Bundle)localObject));
        }
      }
      catch (Exception paramBundle)
      {
        localStringBuilder.append("can not read bundle");
      }
      break;
      localStringBuilder.append(localObject);
      int i = 0;
    }
  }
  
  public static final boolean a(ax paramax, String paramString, long paramLong)
  {
    AppMethodBeat.i(6577);
    k.h(paramax, "$this$isExpire");
    k.h(paramString, "key");
    boolean bool = as.au(paramax.getLong(paramString, 0L), paramLong);
    AppMethodBeat.o(6577);
    return bool;
  }
  
  public static final String ae(Intent paramIntent)
  {
    AppMethodBeat.i(6580);
    k.h(paramIntent, "$this$toDebugString");
    paramIntent = paramIntent.toString() + " " + N(paramIntent.getExtras());
    AppMethodBeat.o(6580);
    return paramIntent;
  }
  
  public static final void b(ax paramax, String paramString)
  {
    AppMethodBeat.i(6576);
    k.h(paramax, "$this$putNow");
    k.h(paramString, "key");
    paramax.putLong(paramString, System.currentTimeMillis());
    AppMethodBeat.o(6576);
  }
  
  public static final boolean b(Context paramContext, b<? super ActivityManager.RunningAppProcessInfo, Boolean> paramb)
  {
    AppMethodBeat.i(6578);
    k.h(paramContext, "context");
    k.h(paramb, "predicate");
    paramContext = paramContext.getSystemService("activity");
    if (paramContext == null)
    {
      paramContext = new v("null cannot be cast to non-null type android.app.ActivityManager");
      AppMethodBeat.o(6578);
      throw paramContext;
    }
    paramContext = ((ActivityManager)paramContext).getRunningAppProcesses().iterator();
    while (paramContext.hasNext())
    {
      ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)paramContext.next();
      k.g(localRunningAppProcessInfo, "info");
      if (((Boolean)paramb.aA(localRunningAppProcessInfo)).booleanValue())
      {
        AppMethodBeat.o(6578);
        return true;
      }
    }
    AppMethodBeat.o(6578);
    return false;
  }
  
  public static final String bDp()
  {
    AppMethodBeat.i(6579);
    Context localContext = aj.getContext();
    if (ay.isWifi(localContext))
    {
      AppMethodBeat.o(6579);
      return "wifi";
    }
    if (ay.is4G(localContext))
    {
      AppMethodBeat.o(6579);
      return "4g";
    }
    if (ay.is3G(localContext))
    {
      AppMethodBeat.o(6579);
      return "3g";
    }
    if (ay.is2G(localContext))
    {
      AppMethodBeat.o(6579);
      return "2g";
    }
    AppMethodBeat.o(6579);
    return "none";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.preload.d
 * JD-Core Version:    0.7.0.1
 */