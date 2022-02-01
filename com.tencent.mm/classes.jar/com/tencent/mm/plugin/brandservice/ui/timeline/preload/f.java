package com.tencent.mm.plugin.brandservice.ui.timeline.preload;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMSlotKt;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.g.a.b;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"bundleToString", "", "bundle", "Landroid/os/Bundle;", "findProcess", "", "context", "Landroid/content/Context;", "predicate", "Lkotlin/Function1;", "Landroid/app/ActivityManager$RunningAppProcessInfo;", "getNetWorkType", "isExpire", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "key", "duration", "", "isNullOrEmpty", "", "putNow", "", "toDebugString", "Landroid/content/Intent;", "toInt", "", "plugin-brandservice_release"}, k=2, mv={1, 5, 1}, xi=48)
public final class f
{
  public static final boolean a(MultiProcessMMKV paramMultiProcessMMKV, String paramString, long paramLong)
  {
    AppMethodBeat.i(6577);
    s.u(paramMultiProcessMMKV, "<this>");
    s.u(paramString, "key");
    boolean bool = MMSlotKt.isExpire(paramMultiProcessMMKV.getLong(paramString, 0L), paramLong);
    AppMethodBeat.o(6577);
    return bool;
  }
  
  public static final String ai(Intent paramIntent)
  {
    AppMethodBeat.i(6580);
    s.u(paramIntent, "<this>");
    paramIntent = paramIntent.toString() + ' ' + aj(paramIntent.getExtras());
    AppMethodBeat.o(6580);
    return paramIntent;
  }
  
  private static final String aj(Bundle paramBundle)
  {
    AppMethodBeat.i(6581);
    StringBuilder localStringBuilder = new StringBuilder("Bundle[");
    if (paramBundle == null)
    {
      localStringBuilder.append("null");
      localStringBuilder.append("]");
      paramBundle = localStringBuilder.toString();
      s.s(paramBundle, "out.toString()");
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
          localStringBuilder.append(aj((Bundle)localObject));
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
  
  public static final void b(MultiProcessMMKV paramMultiProcessMMKV, String paramString)
  {
    AppMethodBeat.i(6576);
    s.u(paramMultiProcessMMKV, "<this>");
    s.u(paramString, "key");
    paramMultiProcessMMKV.putLong(paramString, MMSlotKt.now());
    AppMethodBeat.o(6576);
  }
  
  public static final boolean e(Context paramContext, b<? super ActivityManager.RunningAppProcessInfo, Boolean> paramb)
  {
    AppMethodBeat.i(6578);
    s.u(paramContext, "context");
    s.u(paramb, "predicate");
    paramContext = paramContext.getSystemService("activity");
    if (paramContext == null)
    {
      paramContext = new NullPointerException("null cannot be cast to non-null type android.app.ActivityManager");
      AppMethodBeat.o(6578);
      throw paramContext;
    }
    paramContext = ((ActivityManager)paramContext).getRunningAppProcesses().iterator();
    while (paramContext.hasNext())
    {
      ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)paramContext.next();
      s.s(localRunningAppProcessInfo, "info");
      if (((Boolean)paramb.invoke(localRunningAppProcessInfo)).booleanValue())
      {
        AppMethodBeat.o(6578);
        return true;
      }
    }
    AppMethodBeat.o(6578);
    return false;
  }
  
  public static final String getNetWorkType()
  {
    AppMethodBeat.i(6579);
    Context localContext = MMApplicationContext.getContext();
    if (NetStatusUtil.isWifi(localContext))
    {
      AppMethodBeat.o(6579);
      return "wifi";
    }
    if (NetStatusUtil.is5G(localContext))
    {
      AppMethodBeat.o(6579);
      return "5g";
    }
    if (NetStatusUtil.is4G(localContext))
    {
      AppMethodBeat.o(6579);
      return "4g";
    }
    if (NetStatusUtil.is3G(localContext))
    {
      AppMethodBeat.o(6579);
      return "3g";
    }
    if (NetStatusUtil.is2G(localContext))
    {
      AppMethodBeat.o(6579);
      return "2g";
    }
    AppMethodBeat.o(6579);
    return "none";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.preload.f
 * JD-Core Version:    0.7.0.1
 */