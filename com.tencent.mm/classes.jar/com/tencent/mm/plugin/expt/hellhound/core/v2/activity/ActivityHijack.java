package com.tencent.mm.plugin.expt.hellhound.core.v2.activity;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.IBinder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.hellhound.core.a.a.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

final class ActivityHijack
  implements InvocationHandler
{
  static boolean lZY = true;
  static int lZZ = 0;
  Object lZV;
  private Method lZW;
  private c lZX;
  
  @SuppressLint({"PrivateApi"})
  ActivityHijack(c paramc)
  {
    AppMethodBeat.i(73392);
    this.lZX = paramc;
    try
    {
      this.lZW = a.a(a.brz(), "getActivity", new Class[] { IBinder.class });
      AppMethodBeat.o(73392);
      return;
    }
    catch (Exception paramc)
    {
      ab.printErrStackTrace("ActivityHijack", paramc, "ActivityHijack", new Object[0]);
      h.qsU.idkeyStat(932L, 2L, 1L, false);
      AppMethodBeat.o(73392);
    }
  }
  
  private Intent c(Method paramMethod, Object[] paramArrayOfObject)
  {
    AppMethodBeat.i(73394);
    try
    {
      paramMethod = a.a(this.lZV, paramMethod, paramArrayOfObject);
      if ((paramMethod instanceof Intent))
      {
        paramMethod = (Intent)paramMethod;
        AppMethodBeat.o(73394);
        return paramMethod;
      }
    }
    catch (Exception paramMethod)
    {
      ab.i("ActivityHijack", "AHijack: getIntentForIntentSender: %s", new Object[] { paramMethod.getMessage() });
      h.qsU.idkeyStat(932L, 96L, 1L, false);
      h.qsU.idkeyStat(932L, 97L, 1L, false);
      paramMethod = new Intent();
      AppMethodBeat.o(73394);
    }
    return paramMethod;
  }
  
  @TargetApi(19)
  private void i(int paramInt, Object[] paramArrayOfObject)
  {
    AppMethodBeat.i(152273);
    paramArrayOfObject = o(paramArrayOfObject);
    if (paramArrayOfObject == null)
    {
      AppMethodBeat.o(152273);
      return;
    }
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(152273);
      return;
      try
      {
        this.lZX.H(paramArrayOfObject);
        AppMethodBeat.o(152273);
        return;
      }
      catch (Exception paramArrayOfObject)
      {
        ab.printErrStackTrace("ActivityHijack", paramArrayOfObject, "ActivityThread.activityEvent", new Object[0]);
        h.qsU.idkeyStat(932L, 1L, 1L, false);
        AppMethodBeat.o(152273);
        return;
      }
      this.lZX.I(paramArrayOfObject);
    }
  }
  
  private static Intent n(Object[] paramArrayOfObject)
  {
    if ((paramArrayOfObject == null) || (paramArrayOfObject.length <= 0)) {
      return null;
    }
    int i = 0;
    while (i < paramArrayOfObject.length)
    {
      if ((paramArrayOfObject[i] != null) && ((paramArrayOfObject[i] instanceof Intent))) {
        return (Intent)paramArrayOfObject[i];
      }
      i += 1;
    }
    return null;
  }
  
  private Activity o(Object[] paramArrayOfObject)
  {
    int i = 0;
    AppMethodBeat.i(73395);
    if ((paramArrayOfObject == null) || (paramArrayOfObject.length <= 0))
    {
      AppMethodBeat.o(73395);
      return null;
    }
    do
    {
      i += 1;
      if (i >= paramArrayOfObject.length) {
        break;
      }
    } while ((paramArrayOfObject[i] == null) || (!(paramArrayOfObject[i] instanceof IBinder)));
    for (paramArrayOfObject = (IBinder)paramArrayOfObject[i];; paramArrayOfObject = null)
    {
      if (paramArrayOfObject == null)
      {
        AppMethodBeat.o(73395);
        return null;
      }
      try
      {
        paramArrayOfObject = (Activity)a.a(a.bry(), this.lZW, new Object[] { paramArrayOfObject });
        AppMethodBeat.o(73395);
        return paramArrayOfObject;
      }
      catch (Exception paramArrayOfObject)
      {
        for (;;)
        {
          paramArrayOfObject = null;
        }
      }
    }
  }
  
  public final Object invoke(Object paramObject, Method paramMethod, Object[] paramArrayOfObject)
  {
    AppMethodBeat.i(73393);
    paramObject = paramMethod.getName();
    try
    {
      if (!"moveActivityTaskToBack".equals(paramObject)) {
        break label110;
      }
      localObject1 = o(paramArrayOfObject);
      j = paramArrayOfObject.length;
      i = 0;
    }
    catch (Exception localException1)
    {
      for (;;)
      {
        try
        {
          int j;
          int i;
          Object localObject1 = a.a(this.lZV, paramMethod, paramArrayOfObject);
          AppMethodBeat.o(73393);
          return localObject1;
          i += 1;
          continue;
          if ("finishActivity".equals(paramObject))
          {
            localObject1 = o(paramArrayOfObject);
            this.lZX.B((Activity)localObject1);
            continue;
            localException1 = localException1;
            ab.printErrStackTrace("ActivityHijack", localException1, "AHijack.invoke-method", new Object[0]);
            h.qsU.idkeyStat(932L, 0L, 1L, false);
            continue;
          }
        }
        catch (Exception localException2)
        {
          Object localObject4;
          ab.printErrStackTrace("ActivityHijack", localException2, "AHijack.invoke-new", new Object[0]);
          h.qsU.idkeyStat(932L, 63L, 1L, false);
          if ("isTopOfTask".equals(paramObject))
          {
            try
            {
              localObject2 = (Boolean)a.a(this.lZV, paramMethod, paramArrayOfObject);
              if (localObject2 != null) {
                lZY = ((Boolean)localObject2).booleanValue();
              }
              ab.d("ActivityHijack", "AHijack:isTopOfTask: " + lZY);
              AppMethodBeat.o(73393);
              return localObject2;
            }
            catch (Exception localException3)
            {
              Object localObject2;
              ab.printErrStackTrace("ActivityHijack", localException3, "AHijack:isTopOfTask-e1 crash", new Object[0]);
              h.qsU.idkeyStat(932L, 80L, 1L, false);
              try
              {
                localObject3 = o(paramArrayOfObject);
                if (localObject3 == null) {
                  continue;
                }
                localObject4 = a.a(Activity.class, "isTopOfTask", null);
                if (localObject4 == null) {
                  continue;
                }
                localObject3 = (Boolean)a.a(localObject3, (Method)localObject4, null);
                if (localObject3 == null) {
                  continue;
                }
                lZY = ((Boolean)localObject3).booleanValue();
                AppMethodBeat.o(73393);
                return localObject3;
              }
              catch (Exception localException4)
              {
                ab.printErrStackTrace("ActivityHijack", localException4, "AHijack:isTopOfTask-e2 crash", new Object[0]);
                h.qsU.idkeyStat(932L, 85L, 1L, false);
                lZY = true;
              }
            }
            if ("getIntentForIntentSender".equals(paramObject))
            {
              localObject2 = c(paramMethod, paramArrayOfObject);
              AppMethodBeat.o(73393);
              return localObject2;
            }
            if ("activityResumed".equals(paramObject))
            {
              i(100, paramArrayOfObject);
              continue;
            }
            if (!"activityPaused".equals(paramObject)) {
              continue;
            }
            i(101, paramArrayOfObject);
            continue;
          }
          try
          {
            Object localObject3;
            if ("startActivity".equals(paramObject))
            {
              Integer localInteger = (Integer)a.a(this.lZV, paramMethod, paramArrayOfObject);
              if (localInteger != null) {
                lZZ = localInteger.intValue();
              }
              ab.d("ActivityHijack", "AHijack:startActivityRet: " + lZZ);
              AppMethodBeat.o(73393);
              return localInteger;
            }
          }
          catch (Exception localException5)
          {
            ab.printErrStackTrace("ActivityHijack", localException5, "AHijack:startActivity crash-3", new Object[0]);
            h.qsU.idkeyStat(932L, 86L, 1L, false);
            lZZ = 0;
            try
            {
              if ("broadcastIntent".equals(paramObject))
              {
                h.qsU.idkeyStat(932L, 64L, 1L, false);
                ab.i("ActivityHijack", "handleSonyBroadcastIntent Build.MODEL / Build.BRAND: " + Build.MODEL + " / " + Build.BRAND);
                paramObject = n(paramArrayOfObject);
                if (paramObject != null) {
                  continue;
                }
                ab.d("ActivityHijack", "handleSonyBroadcastIntent intent == null");
                paramObject = a.a(this.lZV, paramMethod, paramArrayOfObject);
                AppMethodBeat.o(73393);
                return paramObject;
              }
            }
            catch (Exception paramObject)
            {
              ab.printErrStackTrace("ActivityHijack", paramObject, "AHijack.broadcastIntent", new Object[0]);
              h.qsU.idkeyStat(932L, 65L, 1L, false);
              paramObject = a.a(this.lZV, paramMethod, paramArrayOfObject);
              AppMethodBeat.o(73393);
              return paramObject;
            }
            paramObject = paramObject.getAction();
            ab.d("ActivityHijack", "handleSonyBroadcastIntent action = ".concat(String.valueOf(paramObject)));
            if ("com.sonymobile.media.AUDIO_MODE_CHANGED_ACTION".equals(paramObject))
            {
              ab.e("ActivityHijack", "Sony-Phone, What the fuck !!!");
              AppMethodBeat.o(73393);
              return Integer.valueOf(0);
            }
            paramObject = a.a(this.lZV, paramMethod, paramArrayOfObject);
            AppMethodBeat.o(73393);
            return paramObject;
          }
        }
        boolean bool = false;
      }
    }
    if (i < j)
    {
      localObject4 = paramArrayOfObject[i];
      if ((localObject4 != null) && ((localObject4 instanceof Boolean)))
      {
        bool = ((Boolean)localObject4).booleanValue();
        this.lZX.a((Activity)localObject1, bool);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.core.v2.activity.ActivityHijack
 * JD-Core Version:    0.7.0.1
 */