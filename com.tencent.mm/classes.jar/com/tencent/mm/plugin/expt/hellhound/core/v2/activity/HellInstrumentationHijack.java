package com.tencent.mm.plugin.expt.hellhound.core.v2.activity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Application;
import android.app.Instrumentation;
import android.app.Instrumentation.ActivityResult;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.IBinder;
import android.os.PersistableBundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class HellInstrumentationHijack
  extends Instrumentation
{
  private d mae;
  Instrumentation maf = null;
  
  HellInstrumentationHijack(d paramd)
  {
    this.mae = paramd;
  }
  
  @SuppressLint({"PrivateApi"})
  private Instrumentation.ActivityResult a(Context paramContext, IBinder paramIBinder1, IBinder paramIBinder2, Activity paramActivity, Intent paramIntent, int paramInt, Bundle paramBundle)
  {
    AppMethodBeat.i(73423);
    try
    {
      Method localMethod = Instrumentation.class.getDeclaredMethod("execStartActivity", new Class[] { Context.class, IBinder.class, IBinder.class, Activity.class, Intent.class, Integer.TYPE, Bundle.class });
      localMethod.setAccessible(true);
      if (this.maf != null) {
        ab.d("HellInstrumentationHijack", "execStartActivityOfSystem-0");
      }
      AppMethodBeat.o(73423);
    }
    catch (Exception paramContext)
    {
      try
      {
        paramContext = (Instrumentation.ActivityResult)localMethod.invoke(this.maf, new Object[] { paramContext, paramIBinder1, paramIBinder2, paramActivity, paramIntent, Integer.valueOf(paramInt), paramBundle });
        AppMethodBeat.o(73423);
        return paramContext;
      }
      catch (Exception paramContext)
      {
        ab.printErrStackTrace("HellInstrumentationHijack", paramContext, "execStartActivityOfSystem-1 crash", new Object[0]);
        ab.e("HellInstrumentationHijack", "gStartActivityRet-0: " + ActivityHijack.lZZ);
        k(ActivityHijack.lZZ, paramIntent);
        AppMethodBeat.o(73423);
        return null;
      }
      paramContext = paramContext;
      ab.printErrStackTrace("HellInstrumentationHijack", paramContext, "execStartActivityOfSystem-0 crash", new Object[0]);
      h.qsU.idkeyStat(932L, 27L, 1L, false);
      AppMethodBeat.o(73423);
      return null;
    }
    return null;
  }
  
  /* Error */
  @SuppressLint({"PrivateApi"})
  private Instrumentation.ActivityResult a(Context paramContext, IBinder paramIBinder1, IBinder paramIBinder2, String paramString, Intent paramIntent, int paramInt, Bundle paramBundle)
  {
    // Byte code:
    //   0: ldc 140
    //   2: invokestatic 32	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: ldc 4
    //   7: ldc 34
    //   9: bipush 7
    //   11: anewarray 36	java/lang/Class
    //   14: dup
    //   15: iconst_0
    //   16: ldc 38
    //   18: aastore
    //   19: dup
    //   20: iconst_1
    //   21: ldc 40
    //   23: aastore
    //   24: dup
    //   25: iconst_2
    //   26: ldc 40
    //   28: aastore
    //   29: dup
    //   30: iconst_3
    //   31: ldc 142
    //   33: aastore
    //   34: dup
    //   35: iconst_4
    //   36: ldc 44
    //   38: aastore
    //   39: dup
    //   40: iconst_5
    //   41: getstatic 50	java/lang/Integer:TYPE	Ljava/lang/Class;
    //   44: aastore
    //   45: dup
    //   46: bipush 6
    //   48: ldc 52
    //   50: aastore
    //   51: invokevirtual 56	java/lang/Class:getDeclaredMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   54: astore 8
    //   56: aload 8
    //   58: iconst_1
    //   59: invokevirtual 62	java/lang/reflect/Method:setAccessible	(Z)V
    //   62: aload_0
    //   63: getfield 15	com/tencent/mm/plugin/expt/hellhound/core/v2/activity/HellInstrumentationHijack:maf	Landroid/app/Instrumentation;
    //   66: ifnull +142 -> 208
    //   69: ldc 64
    //   71: ldc 144
    //   73: invokestatic 72	com/tencent/mm/sdk/platformtools/ab:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   76: aload 8
    //   78: aload_0
    //   79: getfield 15	com/tencent/mm/plugin/expt/hellhound/core/v2/activity/HellInstrumentationHijack:maf	Landroid/app/Instrumentation;
    //   82: bipush 7
    //   84: anewarray 74	java/lang/Object
    //   87: dup
    //   88: iconst_0
    //   89: aload_1
    //   90: aastore
    //   91: dup
    //   92: iconst_1
    //   93: aload_2
    //   94: aastore
    //   95: dup
    //   96: iconst_2
    //   97: aload_3
    //   98: aastore
    //   99: dup
    //   100: iconst_3
    //   101: aload 4
    //   103: aastore
    //   104: dup
    //   105: iconst_4
    //   106: aload 5
    //   108: aastore
    //   109: dup
    //   110: iconst_5
    //   111: iload 6
    //   113: invokestatic 78	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   116: aastore
    //   117: dup
    //   118: bipush 6
    //   120: aload 7
    //   122: aastore
    //   123: invokevirtual 82	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   126: checkcast 84	android/app/Instrumentation$ActivityResult
    //   129: astore_1
    //   130: ldc 140
    //   132: invokestatic 87	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   135: aload_1
    //   136: areturn
    //   137: astore_1
    //   138: ldc 64
    //   140: aload_1
    //   141: ldc 146
    //   143: iconst_0
    //   144: anewarray 74	java/lang/Object
    //   147: invokestatic 93	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   150: ldc 140
    //   152: invokestatic 87	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   155: aconst_null
    //   156: areturn
    //   157: astore_1
    //   158: ldc 64
    //   160: aload_1
    //   161: ldc 148
    //   163: iconst_0
    //   164: anewarray 74	java/lang/Object
    //   167: invokestatic 93	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   170: ldc 64
    //   172: new 111	java/lang/StringBuilder
    //   175: dup
    //   176: ldc 150
    //   178: invokespecial 116	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   181: getstatic 122	com/tencent/mm/plugin/expt/hellhound/core/v2/activity/ActivityHijack:lZZ	I
    //   184: invokevirtual 126	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   187: invokevirtual 130	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   190: invokestatic 133	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   193: getstatic 122	com/tencent/mm/plugin/expt/hellhound/core/v2/activity/ActivityHijack:lZZ	I
    //   196: aload 5
    //   198: invokestatic 137	com/tencent/mm/plugin/expt/hellhound/core/v2/activity/HellInstrumentationHijack:k	(ILjava/lang/Object;)V
    //   201: ldc 140
    //   203: invokestatic 87	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   206: aconst_null
    //   207: areturn
    //   208: ldc 140
    //   210: invokestatic 87	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   213: aconst_null
    //   214: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	215	0	this	HellInstrumentationHijack
    //   0	215	1	paramContext	Context
    //   0	215	2	paramIBinder1	IBinder
    //   0	215	3	paramIBinder2	IBinder
    //   0	215	4	paramString	String
    //   0	215	5	paramIntent	Intent
    //   0	215	6	paramInt	int
    //   0	215	7	paramBundle	Bundle
    //   54	23	8	localMethod	Method
    // Exception table:
    //   from	to	target	type
    //   5	62	137	java/lang/Exception
    //   69	130	157	java/lang/Exception
  }
  
  private static void k(int paramInt, Object paramObject)
  {
    AppMethodBeat.i(73425);
    try
    {
      Method localMethod = Instrumentation.class.getDeclaredMethod("checkStartActivityResult", new Class[] { Integer.TYPE, Object.class });
      localMethod.setAccessible(true);
      localMethod.invoke(null, new Object[] { Integer.valueOf(paramInt), paramObject });
      AppMethodBeat.o(73425);
      return;
    }
    catch (Exception paramObject)
    {
      ab.printErrStackTrace("HellInstrumentationHijack", paramObject, "_checkStartActivityResult-0", new Object[0]);
      AppMethodBeat.o(73425);
    }
  }
  
  private void s(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(73426);
    if ((paramContext == null) || (paramIntent == null))
    {
      AppMethodBeat.o(73426);
      return;
    }
    if ((paramContext instanceof Activity)) {}
    for (paramContext = (Activity)paramContext;; paramContext = null) {
      try
      {
        this.mae.a(paramContext, paramIntent);
        AppMethodBeat.o(73426);
        return;
      }
      catch (Exception paramContext)
      {
        ab.printErrStackTrace("HellInstrumentationHijack", paramContext, "Instru-callbackStartActivity callback exception", new Object[0]);
        AppMethodBeat.o(73426);
        return;
      }
    }
  }
  
  final void brK()
  {
    AppMethodBeat.i(152277);
    Field[] arrayOfField = Instrumentation.class.getDeclaredFields();
    int i = 0;
    while (i < arrayOfField.length)
    {
      arrayOfField[i].setAccessible(true);
      Object localObject = arrayOfField[i].get(this.maf);
      arrayOfField[i].set(this, localObject);
      i += 1;
    }
    AppMethodBeat.o(152277);
  }
  
  public void callActivityOnCreate(Activity paramActivity, Bundle paramBundle)
  {
    AppMethodBeat.i(73412);
    if (paramActivity == null)
    {
      AppMethodBeat.o(73412);
      return;
    }
    try
    {
      ab.i("HellInstrumentationHijack", "Instru.callActivityOnCreate: " + paramActivity.getClass().getCanonicalName());
      if (this.mae != null) {
        this.mae.d(paramActivity.getIntent(), paramActivity);
      }
      if (this.maf == null) {}
    }
    catch (Exception localException1)
    {
      for (;;)
      {
        try
        {
          this.maf.callActivityOnCreate(paramActivity, paramBundle);
          AppMethodBeat.o(73412);
          return;
        }
        catch (Exception localException2)
        {
          ab.printErrStackTrace("HellInstrumentationHijack", localException2, "Instru.callActivityOnCreate", new Object[0]);
          try
          {
            super.callActivityOnCreate(paramActivity, paramBundle);
            AppMethodBeat.o(73412);
            return;
          }
          catch (Exception paramActivity)
          {
            ab.printErrStackTrace("HellInstrumentationHijack", localException2, "Instru.callActivityOnCreate 2", new Object[0]);
            h.qsU.idkeyStat(932L, 28L, 1L, false);
            AppMethodBeat.o(73412);
            return;
          }
        }
        localException1 = localException1;
        ab.printErrStackTrace("HellInstrumentationHijack", localException1, "Instru.callActivityOnCreate callback", new Object[0]);
      }
      super.callActivityOnCreate(paramActivity, paramBundle);
      AppMethodBeat.o(73412);
    }
  }
  
  public void callActivityOnCreate(Activity paramActivity, Bundle paramBundle, PersistableBundle paramPersistableBundle)
  {
    AppMethodBeat.i(73413);
    if (paramActivity == null)
    {
      AppMethodBeat.o(73413);
      return;
    }
    ab.d("HellInstrumentationHijack", "Instru.callActivityOnCreate activity: " + paramActivity.getClass().getCanonicalName());
    try
    {
      if (this.mae != null) {
        this.mae.d(paramActivity.getIntent(), paramActivity);
      }
      if (this.maf == null) {}
    }
    catch (Exception localException1)
    {
      for (;;)
      {
        try
        {
          if (Build.VERSION.SDK_INT >= 21) {
            this.maf.callActivityOnCreate(paramActivity, paramBundle, paramPersistableBundle);
          }
          AppMethodBeat.o(73413);
          return;
        }
        catch (Exception localException2)
        {
          ab.printErrStackTrace("HellInstrumentationHijack", localException2, "Instru.callActivityOnCreate", new Object[0]);
          try
          {
            super.callActivityOnCreate(paramActivity, paramBundle, paramPersistableBundle);
            AppMethodBeat.o(73413);
            return;
          }
          catch (Exception paramActivity)
          {
            ab.printErrStackTrace("HellInstrumentationHijack", localException2, "Instru.callActivityOnCreate 2", new Object[0]);
            h.qsU.idkeyStat(932L, 29L, 1L, false);
            AppMethodBeat.o(73413);
            return;
          }
        }
        localException1 = localException1;
        ab.printErrStackTrace("HellInstrumentationHijack", localException1, "Instru.callActivityOnCreate callback", new Object[0]);
      }
      super.callActivityOnCreate(paramActivity, paramBundle, paramPersistableBundle);
      AppMethodBeat.o(73413);
    }
  }
  
  public void callActivityOnDestroy(Activity paramActivity)
  {
    AppMethodBeat.i(73418);
    if (paramActivity == null)
    {
      AppMethodBeat.o(73418);
      return;
    }
    ab.d("HellInstrumentationHijack", "Instru-callActivityOnDestroy: activity = " + paramActivity.getClass().getCanonicalName());
    try
    {
      if (this.mae != null) {
        this.mae.O(paramActivity);
      }
      if (this.maf == null) {}
    }
    catch (Exception localException1)
    {
      for (;;)
      {
        try
        {
          this.maf.callActivityOnDestroy(paramActivity);
          AppMethodBeat.o(73418);
          return;
        }
        catch (Exception localException2)
        {
          ab.printErrStackTrace("HellInstrumentationHijack", localException2, "Instru.callActivityOnDestroy", new Object[0]);
          try
          {
            super.callActivityOnDestroy(paramActivity);
            AppMethodBeat.o(73418);
            return;
          }
          catch (Exception paramActivity)
          {
            ab.printErrStackTrace("HellInstrumentationHijack", paramActivity, "Instru.callActivityOnDestroy 2", new Object[0]);
            AppMethodBeat.o(73418);
            return;
          }
        }
        localException1 = localException1;
        ab.printErrStackTrace("HellInstrumentationHijack", localException1, "Instru.callActivityOnDestroy callback", new Object[0]);
      }
      super.callActivityOnDestroy(paramActivity);
      AppMethodBeat.o(73418);
    }
  }
  
  public void callActivityOnNewIntent(Activity paramActivity, Intent paramIntent)
  {
    AppMethodBeat.i(73414);
    if (paramActivity == null)
    {
      AppMethodBeat.o(73414);
      return;
    }
    ab.d("HellInstrumentationHijack", "Instru.callActivityOnNewIntent = " + paramActivity.getClass().getCanonicalName());
    try
    {
      if (this.mae != null) {
        this.mae.e(paramIntent, paramActivity);
      }
      if (this.maf == null) {}
    }
    catch (Exception localException1)
    {
      for (;;)
      {
        try
        {
          this.maf.callActivityOnNewIntent(paramActivity, paramIntent);
          AppMethodBeat.o(73414);
          return;
        }
        catch (Exception localException2)
        {
          ab.printErrStackTrace("HellInstrumentationHijack", localException2, "Instru.callActivityOnNewIntent", new Object[0]);
          try
          {
            super.callActivityOnNewIntent(paramActivity, paramIntent);
            AppMethodBeat.o(73414);
            return;
          }
          catch (Exception paramActivity)
          {
            ab.printErrStackTrace("HellInstrumentationHijack", localException2, "Instru.callActivityOnNewIntent 2", new Object[0]);
            h.qsU.idkeyStat(932L, 30L, 1L, false);
            AppMethodBeat.o(73414);
            return;
          }
        }
        localException1 = localException1;
        ab.printErrStackTrace("HellInstrumentationHijack", localException1, "Instru.callActivityOnNewIntent callback", new Object[0]);
      }
      super.callActivityOnNewIntent(paramActivity, paramIntent);
      AppMethodBeat.o(73414);
    }
  }
  
  public void callActivityOnPause(Activity paramActivity)
  {
    AppMethodBeat.i(73416);
    if (paramActivity == null)
    {
      AppMethodBeat.o(73416);
      return;
    }
    ab.d("HellInstrumentationHijack", "Instru-callActivityOnPause: activity = " + paramActivity.getClass().getCanonicalName());
    try
    {
      if (this.mae != null) {
        this.mae.M(paramActivity);
      }
      if (this.maf == null) {}
    }
    catch (Exception localException1)
    {
      for (;;)
      {
        try
        {
          this.maf.callActivityOnPause(paramActivity);
          AppMethodBeat.o(73416);
          return;
        }
        catch (Exception localException2)
        {
          ab.printErrStackTrace("HellInstrumentationHijack", localException2, "Instru.callActivityOnPause", new Object[0]);
        }
        localException1 = localException1;
        ab.printErrStackTrace("HellInstrumentationHijack", localException1, "Instru.callActivityOnPause callback", new Object[0]);
      }
      super.callActivityOnPause(paramActivity);
      AppMethodBeat.o(73416);
    }
  }
  
  public void callActivityOnResume(Activity paramActivity)
  {
    AppMethodBeat.i(73415);
    if (paramActivity == null)
    {
      AppMethodBeat.o(73415);
      return;
    }
    ab.d("HellInstrumentationHijack", "Instru-callActivityOnResume: " + paramActivity.getClass().getCanonicalName());
    try
    {
      if (this.mae != null) {
        this.mae.L(paramActivity);
      }
      if (this.maf == null) {}
    }
    catch (Exception localException1)
    {
      for (;;)
      {
        try
        {
          this.maf.callActivityOnResume(paramActivity);
          AppMethodBeat.o(73415);
          return;
        }
        catch (Exception localException2)
        {
          ab.printErrStackTrace("HellInstrumentationHijack", localException2, "Instru.callActivityOnResume", new Object[0]);
          try
          {
            super.callActivityOnResume(paramActivity);
            AppMethodBeat.o(73415);
            return;
          }
          catch (Exception localException3)
          {
            ab.printErrStackTrace("HellInstrumentationHijack", localException3, "Instru.callActivityOnResume 2", new Object[0]);
            h.qsU.idkeyStat(932L, 31L, 1L, false);
            ab.d("HellInstrumentationHijack", "Instru:sIsTopOfTaskRet = " + ActivityHijack.lZY);
            try
            {
              Object localObject1 = Class.forName("android.app.Activity");
              Object localObject2 = ((Class)localObject1).getDeclaredField("mActivityTransitionState");
              ((Field)localObject2).setAccessible(true);
              localObject2 = ((Field)localObject2).get(paramActivity);
              Method localMethod = Class.forName("android.app.ActivityTransitionState").getDeclaredMethod("onResume", new Class[] { Activity.class, Boolean.TYPE });
              localMethod.setAccessible(true);
              localMethod.invoke(localObject2, new Object[] { paramActivity, Boolean.valueOf(ActivityHijack.lZY) });
              localObject1 = ((Class)localObject1).getDeclaredField("mCalled");
              ((Field)localObject1).setAccessible(true);
              ((Field)localObject1).set(paramActivity, Boolean.TRUE);
              AppMethodBeat.o(73415);
              return;
            }
            catch (Exception paramActivity)
            {
              ab.printErrStackTrace("HellInstrumentationHijack", paramActivity, "Instru:resume-e2", new Object[0]);
              h.qsU.idkeyStat(932L, 81L, 1L, false);
              AppMethodBeat.o(73415);
              return;
            }
          }
        }
        localException1 = localException1;
        ab.printErrStackTrace("HellInstrumentationHijack", localException1, "Instru.callActivityOnResume callback", new Object[0]);
      }
      super.callActivityOnResume(paramActivity);
      AppMethodBeat.o(73415);
    }
  }
  
  public void callActivityOnStop(Activity paramActivity)
  {
    AppMethodBeat.i(73417);
    if (paramActivity == null)
    {
      AppMethodBeat.o(73417);
      return;
    }
    ab.d("HellInstrumentationHijack", "Instru-callActivityOnStop: activity = " + paramActivity.getClass().getCanonicalName());
    try
    {
      if (this.mae != null) {
        this.mae.N(paramActivity);
      }
      if (this.maf == null) {}
    }
    catch (Exception localException1)
    {
      for (;;)
      {
        try
        {
          this.maf.callActivityOnStop(paramActivity);
          AppMethodBeat.o(73417);
          return;
        }
        catch (Exception localException2)
        {
          ab.printErrStackTrace("HellInstrumentationHijack", localException2, "Instru.callActivityOnStop", new Object[0]);
          try
          {
            super.callActivityOnStop(paramActivity);
            AppMethodBeat.o(73417);
            return;
          }
          catch (Exception paramActivity)
          {
            ab.printErrStackTrace("HellInstrumentationHijack", paramActivity, "Instru.callActivityOnStop 2", new Object[0]);
            h.qsU.idkeyStat(932L, 32L, 1L, false);
            AppMethodBeat.o(73417);
            return;
          }
        }
        localException1 = localException1;
        ab.printErrStackTrace("HellInstrumentationHijack", localException1, "Instru.callActivityOnStop callback", new Object[0]);
      }
      super.callActivityOnStop(paramActivity);
      AppMethodBeat.o(73417);
    }
  }
  
  public Instrumentation.ActivityResult execStartActivity(Context paramContext, IBinder paramIBinder1, IBinder paramIBinder2, Activity paramActivity, Intent paramIntent, int paramInt, Bundle paramBundle)
  {
    AppMethodBeat.i(73421);
    ab.i("HellInstrumentationHijack", "execStartActivity-Activity-Target, fromActivity: " + paramContext.getClass().getCanonicalName());
    s(paramContext, paramIntent);
    paramContext = a(paramContext, paramIBinder1, paramIBinder2, paramActivity, paramIntent, paramInt, paramBundle);
    AppMethodBeat.o(73421);
    return paramContext;
  }
  
  public Instrumentation.ActivityResult execStartActivity(Context paramContext, IBinder paramIBinder1, IBinder paramIBinder2, String paramString, Intent paramIntent, int paramInt, Bundle paramBundle)
  {
    AppMethodBeat.i(73422);
    ab.i("HellInstrumentationHijack", "execStartActivity-String-Target, fromActivity: " + paramContext.getClass().getCanonicalName());
    s(paramContext, paramIntent);
    paramContext = a(paramContext, paramIBinder1, paramIBinder2, paramString, paramIntent, paramInt, paramBundle);
    AppMethodBeat.o(73422);
    return paramContext;
  }
  
  public Activity newActivity(Class<?> paramClass, Context paramContext, IBinder paramIBinder, Application paramApplication, Intent paramIntent, ActivityInfo paramActivityInfo, CharSequence paramCharSequence, Activity paramActivity, String paramString, Object paramObject)
  {
    AppMethodBeat.i(73420);
    if (this.maf != null) {
      try
      {
        Activity localActivity = this.maf.newActivity(paramClass, paramContext, paramIBinder, paramApplication, paramIntent, paramActivityInfo, paramCharSequence, paramActivity, paramString, paramObject);
        AppMethodBeat.o(73420);
        return localActivity;
      }
      catch (Exception localException)
      {
        ab.printErrStackTrace("HellInstrumentationHijack", localException, "Instru.newActivity", new Object[0]);
        try
        {
          paramClass = super.newActivity(paramClass, paramContext, paramIBinder, paramApplication, paramIntent, paramActivityInfo, paramCharSequence, paramActivity, paramString, paramObject);
          AppMethodBeat.o(73420);
          return paramClass;
        }
        catch (Exception paramClass)
        {
          ab.printErrStackTrace("HellInstrumentationHijack", localException, "Instru.newActivity 2", new Object[0]);
          h.qsU.idkeyStat(932L, 34L, 1L, false);
          AppMethodBeat.o(73420);
          return null;
        }
      }
    }
    paramClass = super.newActivity(paramClass, paramContext, paramIBinder, paramApplication, paramIntent, paramActivityInfo, paramCharSequence, paramActivity, paramString, paramObject);
    AppMethodBeat.o(73420);
    return paramClass;
  }
  
  public Activity newActivity(ClassLoader paramClassLoader, String paramString, Intent paramIntent)
  {
    AppMethodBeat.i(73419);
    ab.d("HellInstrumentationHijack", "Instru-newActivity: ".concat(String.valueOf(paramString)));
    if (this.maf != null) {
      try
      {
        Activity localActivity = this.maf.newActivity(paramClassLoader, paramString, paramIntent);
        AppMethodBeat.o(73419);
        return localActivity;
      }
      catch (Exception localException)
      {
        ab.printErrStackTrace("HellInstrumentationHijack", localException, "Instru.newActivity", new Object[0]);
        try
        {
          paramClassLoader = super.newActivity(paramClassLoader, paramString, paramIntent);
          AppMethodBeat.o(73419);
          return paramClassLoader;
        }
        catch (Exception paramClassLoader)
        {
          ab.printErrStackTrace("HellInstrumentationHijack", localException, "Instru.newActivity 1", new Object[0]);
          h.qsU.idkeyStat(932L, 33L, 1L, false);
          AppMethodBeat.o(73419);
          return null;
        }
      }
    }
    paramClassLoader = super.newActivity(paramClassLoader, paramString, paramIntent);
    AppMethodBeat.o(73419);
    return paramClassLoader;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.core.v2.activity.HellInstrumentationHijack
 * JD-Core Version:    0.7.0.1
 */