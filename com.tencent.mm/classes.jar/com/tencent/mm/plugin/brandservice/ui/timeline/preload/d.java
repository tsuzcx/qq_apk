package com.tencent.mm.plugin.brandservice.ui.timeline.preload;

import a.f.a.b;
import a.f.b.j;
import a.l;
import a.v;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.as;
import com.tencent.mm.sdk.platformtools.at;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"bundleToString", "", "bundle", "Landroid/os/Bundle;", "findProcess", "", "context", "Landroid/content/Context;", "predicate", "Lkotlin/Function1;", "Landroid/app/ActivityManager$RunningAppProcessInfo;", "getNetWorkType", "now", "", "isExpire", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "key", "duration", "isNullOrEmpty", "", "putNow", "", "toDebugString", "Landroid/content/Intent;", "toInt", "", "plugin-brandservice_release"})
public final class d
{
  public static final boolean E(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(14800);
    if (System.currentTimeMillis() - paramLong1 > paramLong2)
    {
      AppMethodBeat.o(14800);
      return true;
    }
    AppMethodBeat.o(14800);
    return false;
  }
  
  private static final String H(Bundle paramBundle)
  {
    AppMethodBeat.i(138513);
    StringBuilder localStringBuilder = new StringBuilder("Bundle[");
    if (paramBundle == null)
    {
      localStringBuilder.append("null");
      localStringBuilder.append("]");
      paramBundle = localStringBuilder.toString();
      j.p(paramBundle, "out.toString()");
      AppMethodBeat.o(138513);
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
          localStringBuilder.append(H((Bundle)localObject));
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
  
  public static final String Q(Intent paramIntent)
  {
    AppMethodBeat.i(138512);
    j.q(paramIntent, "receiver$0");
    paramIntent = paramIntent.toString() + " " + H(paramIntent.getExtras());
    AppMethodBeat.o(138512);
    return paramIntent;
  }
  
  public static final void a(as paramas, String paramString)
  {
    AppMethodBeat.i(14801);
    j.q(paramas, "receiver$0");
    j.q(paramString, "key");
    paramas.putLong(paramString, System.currentTimeMillis());
    AppMethodBeat.o(14801);
  }
  
  public static final boolean a(Context paramContext, b<? super ActivityManager.RunningAppProcessInfo, Boolean> paramb)
  {
    AppMethodBeat.i(14803);
    j.q(paramContext, "context");
    j.q(paramb, "predicate");
    paramContext = paramContext.getSystemService("activity");
    if (paramContext == null)
    {
      paramContext = new v("null cannot be cast to non-null type android.app.ActivityManager");
      AppMethodBeat.o(14803);
      throw paramContext;
    }
    paramContext = ((ActivityManager)paramContext).getRunningAppProcesses().iterator();
    while (paramContext.hasNext())
    {
      ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)paramContext.next();
      j.p(localRunningAppProcessInfo, "info");
      if (((Boolean)paramb.S(localRunningAppProcessInfo)).booleanValue())
      {
        AppMethodBeat.o(14803);
        return true;
      }
    }
    AppMethodBeat.o(14803);
    return false;
  }
  
  public static final boolean a(as paramas, String paramString, long paramLong)
  {
    AppMethodBeat.i(14802);
    j.q(paramas, "receiver$0");
    j.q(paramString, "key");
    boolean bool = E(paramas.getLong(paramString, 0L), paramLong);
    AppMethodBeat.o(14802);
    return bool;
  }
  
  public static final String aXm()
  {
    AppMethodBeat.i(14804);
    Context localContext = ah.getContext();
    if (at.isWifi(localContext))
    {
      AppMethodBeat.o(14804);
      return "wifi";
    }
    if (at.is4G(localContext))
    {
      AppMethodBeat.o(14804);
      return "4g";
    }
    if (at.is3G(localContext))
    {
      AppMethodBeat.o(14804);
      return "3g";
    }
    if (at.is2G(localContext))
    {
      AppMethodBeat.o(14804);
      return "2g";
    }
    AppMethodBeat.o(14804);
    return "none";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.preload.d
 * JD-Core Version:    0.7.0.1
 */