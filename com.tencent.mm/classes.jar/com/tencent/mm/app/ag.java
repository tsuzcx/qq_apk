package com.tencent.mm.app;

import android.app.Application;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.ApplicationInfo;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.j.a;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.au;
import com.tencent.mm.sdk.platformtools.au.c;
import com.tencent.tinker.entry.ApplicationLike;
import com.tencent.tinker.lib.e.b;

public final class ag
{
  volatile boolean cVe;
  boolean cVf;
  private au.c cVg;
  ApplicationLike mAppLike;
  private volatile boolean mInstalled;
  
  public ag()
  {
    AppMethodBeat.i(125030);
    this.mAppLike = null;
    this.mInstalled = false;
    this.cVe = false;
    this.cVf = false;
    this.cVg = new au.c()
    {
      public final void a(au arg1, String paramAnonymousString, Throwable paramAnonymousThrowable)
      {
        AppMethodBeat.i(207439);
        if (!b.d(ag.this.mAppLike))
        {
          AppMethodBeat.o(207439);
          return;
        }
        if ((!(paramAnonymousThrowable instanceof NoClassDefFoundError)) && (!(paramAnonymousThrowable instanceof VerifyError)) && (!(paramAnonymousThrowable instanceof IncompatibleClassChangeError)) && (!(paramAnonymousThrowable instanceof InternalError)))
        {
          AppMethodBeat.o(207439);
          return;
        }
        if (!ag.this.cVf)
        {
          AppMethodBeat.o(207439);
          return;
        }
        paramAnonymousString = ag.this.mAppLike.getApplication().getSharedPreferences("tinker_ensurance_info", 4);
        synchronized (ag.this)
        {
          int i;
          if (!ag.this.cVe)
          {
            i = paramAnonymousString.getInt("tinker_crash_count", 0);
            if (i > 3)
            {
              paramAnonymousThrowable = a.hgG + "_clean_patch_count";
              i = paramAnonymousString.getInt(paramAnonymousThrowable, 0);
              paramAnonymousString.edit().putInt(paramAnonymousThrowable, i + 1).putInt("tinker_crash_count", 0).commit();
              b.f(ag.this.mAppLike);
              ad.w("MicroMsg.TinkerEnsuranceOnFault", "[tomys] clean patch by ensurance logic!!");
              ad.fkv();
            }
          }
          else
          {
            AppMethodBeat.o(207439);
            return;
          }
          paramAnonymousString.edit().putInt("tinker_crash_count", i + 1).commit();
        }
      }
    };
    AppMethodBeat.o(125030);
  }
  
  public static ag MB()
  {
    return a.cVi;
  }
  
  /* Error */
  private boolean MF()
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_2
    //   2: aload_0
    //   3: monitorenter
    //   4: ldc 54
    //   6: invokestatic 28	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: aload_0
    //   10: getfield 30	com/tencent/mm/app/ag:mAppLike	Lcom/tencent/tinker/entry/ApplicationLike;
    //   13: invokevirtual 60	com/tencent/tinker/entry/ApplicationLike:getApplication	()Landroid/app/Application;
    //   16: ldc 62
    //   18: iconst_4
    //   19: invokevirtual 68	android/app/Application:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   22: new 70	java/lang/StringBuilder
    //   25: dup
    //   26: invokespecial 71	java/lang/StringBuilder:<init>	()V
    //   29: getstatic 77	com/tencent/mm/loader/j/a:hgG	Ljava/lang/String;
    //   32: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   35: ldc 83
    //   37: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   40: invokevirtual 87	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   43: iconst_0
    //   44: invokeinterface 93 3 0
    //   49: istore_1
    //   50: iload_1
    //   51: ifle +34 -> 85
    //   54: iload_2
    //   55: ifeq +35 -> 90
    //   58: ldc 95
    //   60: ldc 97
    //   62: iconst_1
    //   63: anewarray 4	java/lang/Object
    //   66: dup
    //   67: iconst_0
    //   68: iload_1
    //   69: invokestatic 103	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   72: aastore
    //   73: invokestatic 109	com/tencent/mm/sdk/platformtools/ad:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   76: ldc 54
    //   78: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   81: aload_0
    //   82: monitorexit
    //   83: iload_2
    //   84: ireturn
    //   85: iconst_0
    //   86: istore_2
    //   87: goto -33 -> 54
    //   90: ldc 95
    //   92: ldc 111
    //   94: invokestatic 114	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   97: goto -21 -> 76
    //   100: astore_3
    //   101: aload_0
    //   102: monitorexit
    //   103: aload_3
    //   104: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	105	0	this	ag
    //   49	20	1	i	int
    //   1	86	2	bool	boolean
    //   100	4	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   4	50	100	finally
    //   58	76	100	finally
    //   76	81	100	finally
    //   90	97	100	finally
  }
  
  /* Error */
  private boolean MG()
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_1
    //   2: aload_0
    //   3: monitorenter
    //   4: ldc 116
    //   6: invokestatic 28	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: aload_0
    //   10: getfield 30	com/tencent/mm/app/ag:mAppLike	Lcom/tencent/tinker/entry/ApplicationLike;
    //   13: invokevirtual 60	com/tencent/tinker/entry/ApplicationLike:getApplication	()Landroid/app/Application;
    //   16: ldc 62
    //   18: iconst_4
    //   19: invokevirtual 68	android/app/Application:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   22: new 70	java/lang/StringBuilder
    //   25: dup
    //   26: invokespecial 71	java/lang/StringBuilder:<init>	()V
    //   29: getstatic 77	com/tencent/mm/loader/j/a:hgG	Ljava/lang/String;
    //   32: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   35: ldc 118
    //   37: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   40: invokevirtual 87	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   43: iconst_0
    //   44: invokeinterface 93 3 0
    //   49: ifeq +14 -> 63
    //   52: iconst_1
    //   53: istore_1
    //   54: ldc 116
    //   56: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   59: aload_0
    //   60: monitorexit
    //   61: iload_1
    //   62: ireturn
    //   63: ldc 116
    //   65: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   68: goto -9 -> 59
    //   71: astore_2
    //   72: aload_0
    //   73: monitorexit
    //   74: aload_2
    //   75: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	76	0	this	ag
    //   1	61	1	bool	boolean
    //   71	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   4	52	71	finally
    //   54	59	71	finally
    //   63	68	71	finally
  }
  
  /* Error */
  private boolean MH()
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_1
    //   2: aload_0
    //   3: monitorenter
    //   4: ldc 120
    //   6: invokestatic 28	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: aload_0
    //   10: getfield 30	com/tencent/mm/app/ag:mAppLike	Lcom/tencent/tinker/entry/ApplicationLike;
    //   13: invokevirtual 60	com/tencent/tinker/entry/ApplicationLike:getApplication	()Landroid/app/Application;
    //   16: ldc 62
    //   18: iconst_4
    //   19: invokevirtual 68	android/app/Application:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   22: new 70	java/lang/StringBuilder
    //   25: dup
    //   26: invokespecial 71	java/lang/StringBuilder:<init>	()V
    //   29: getstatic 77	com/tencent/mm/loader/j/a:hgG	Ljava/lang/String;
    //   32: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   35: ldc 122
    //   37: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   40: invokevirtual 87	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   43: iconst_0
    //   44: invokeinterface 93 3 0
    //   49: ifeq +14 -> 63
    //   52: iconst_1
    //   53: istore_1
    //   54: ldc 120
    //   56: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   59: aload_0
    //   60: monitorexit
    //   61: iload_1
    //   62: ireturn
    //   63: ldc 120
    //   65: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   68: goto -9 -> 59
    //   71: astore_2
    //   72: aload_0
    //   73: monitorexit
    //   74: aload_2
    //   75: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	76	0	this	ag
    //   1	61	1	bool	boolean
    //   71	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   4	52	71	finally
    //   54	59	71	finally
    //   63	68	71	finally
  }
  
  public final void MC()
  {
    try
    {
      this.cVe = false;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final void MD()
  {
    try
    {
      this.cVe = true;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  /* Error */
  public final boolean ME()
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_1
    //   2: aload_0
    //   3: monitorenter
    //   4: ldc 126
    //   6: invokestatic 28	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: aload_0
    //   10: getfield 30	com/tencent/mm/app/ag:mAppLike	Lcom/tencent/tinker/entry/ApplicationLike;
    //   13: invokevirtual 60	com/tencent/tinker/entry/ApplicationLike:getApplication	()Landroid/app/Application;
    //   16: ldc 62
    //   18: iconst_4
    //   19: invokevirtual 68	android/app/Application:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   22: new 70	java/lang/StringBuilder
    //   25: dup
    //   26: invokespecial 71	java/lang/StringBuilder:<init>	()V
    //   29: getstatic 77	com/tencent/mm/loader/j/a:hgG	Ljava/lang/String;
    //   32: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   35: ldc 83
    //   37: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   40: invokevirtual 87	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   43: iconst_0
    //   44: invokeinterface 93 3 0
    //   49: iconst_3
    //   50: if_icmpgt +5 -> 55
    //   53: iconst_1
    //   54: istore_1
    //   55: iload_1
    //   56: ifeq +19 -> 75
    //   59: ldc 95
    //   61: ldc 128
    //   63: invokestatic 114	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   66: ldc 126
    //   68: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   71: aload_0
    //   72: monitorexit
    //   73: iload_1
    //   74: ireturn
    //   75: ldc 95
    //   77: ldc 130
    //   79: invokestatic 132	com/tencent/mm/sdk/platformtools/ad:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   82: goto -16 -> 66
    //   85: astore_2
    //   86: aload_0
    //   87: monitorexit
    //   88: aload_2
    //   89: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	90	0	this	ag
    //   1	73	1	bool	boolean
    //   85	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   4	9	85	finally
    //   9	53	85	finally
    //   59	66	85	finally
    //   66	71	85	finally
    //   75	82	85	finally
  }
  
  public final void MI()
  {
    try
    {
      AppMethodBeat.i(125036);
      SharedPreferences localSharedPreferences = this.mAppLike.getApplication().getSharedPreferences("tinker_ensurance_info", 4);
      if ((!MG()) && (MF()))
      {
        e.ygI.idkeyStat(338L, 231L, 1L, false);
        localSharedPreferences.edit().putInt(a.hgG + "_clean_patch_reported", 1).apply();
      }
      if ((!MH()) && (!ME()))
      {
        e.ygI.idkeyStat(338L, 232L, 1L, false);
        localSharedPreferences.edit().putInt(a.hgG + "_block_apply_patch_reported", 1).apply();
      }
      AppMethodBeat.o(125036);
      return;
    }
    finally {}
  }
  
  public final void b(ApplicationLike paramApplicationLike)
  {
    for (;;)
    {
      String str;
      try
      {
        AppMethodBeat.i(125031);
        if (this.mInstalled)
        {
          AppMethodBeat.o(125031);
          return;
        }
        this.mAppLike = paramApplicationLike;
        au.a(this.cVg);
        this.cVf = this.mAppLike.getApplication().getPackageName().equals(this.mAppLike.getApplication().getApplicationInfo().processName);
        paramApplicationLike = this.mAppLike.getApplication().getSharedPreferences("tinker_ensurance_info", 4);
        str = paramApplicationLike.getString("tinker_last_clientversion", null);
        if (str == null)
        {
          paramApplicationLike.edit().putString("tinker_last_clientversion", a.hgG).commit();
          this.mInstalled = true;
          AppMethodBeat.o(125031);
          continue;
        }
        if (a.hgG.equals(str)) {
          continue;
        }
      }
      finally {}
      paramApplicationLike.edit().remove(str + "_clean_patch_count").putString("tinker_last_clientversion", a.hgG).commit();
    }
  }
  
  public static final class a
  {
    public static final ag cVi;
    
    static
    {
      AppMethodBeat.i(125029);
      cVi = new ag();
      AppMethodBeat.o(125029);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.app.ag
 * JD-Core Version:    0.7.0.1
 */