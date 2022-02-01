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

public final class af
{
  volatile boolean cMG;
  boolean cMH;
  private au.c cMI;
  ApplicationLike mAppLike;
  private volatile boolean mInstalled;
  
  public af()
  {
    AppMethodBeat.i(125030);
    this.mAppLike = null;
    this.mInstalled = false;
    this.cMG = false;
    this.cMH = false;
    this.cMI = new au.c()
    {
      public final void b(String arg1, Throwable paramAnonymousThrowable)
      {
        AppMethodBeat.i(125028);
        if (!b.c(af.this.mAppLike))
        {
          AppMethodBeat.o(125028);
          return;
        }
        if ((!(paramAnonymousThrowable instanceof NoClassDefFoundError)) && (!(paramAnonymousThrowable instanceof VerifyError)) && (!(paramAnonymousThrowable instanceof IncompatibleClassChangeError)) && (!(paramAnonymousThrowable instanceof InternalError)))
        {
          AppMethodBeat.o(125028);
          return;
        }
        if (!af.this.cMH)
        {
          AppMethodBeat.o(125028);
          return;
        }
        paramAnonymousThrowable = af.this.mAppLike.getApplication().getSharedPreferences("tinker_ensurance_info", 4);
        synchronized (af.this)
        {
          int i;
          if (!af.this.cMG)
          {
            i = paramAnonymousThrowable.getInt("tinker_crash_count", 0);
            if (i > 3)
            {
              String str = a.glW + "_clean_patch_count";
              i = paramAnonymousThrowable.getInt(str, 0);
              paramAnonymousThrowable.edit().putInt(str, i + 1).putInt("tinker_crash_count", 0).commit();
              b.e(af.this.mAppLike);
              ad.w("MicroMsg.TinkerEnsuranceOnFault", "[tomys] clean patch by ensurance logic!!");
              ad.eFx();
            }
          }
          else
          {
            AppMethodBeat.o(125028);
            return;
          }
          paramAnonymousThrowable.edit().putInt("tinker_crash_count", i + 1).commit();
        }
      }
    };
    AppMethodBeat.o(125030);
  }
  
  /* Error */
  private boolean KZ()
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_2
    //   2: aload_0
    //   3: monitorenter
    //   4: ldc 48
    //   6: invokestatic 28	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: aload_0
    //   10: getfield 30	com/tencent/mm/app/af:mAppLike	Lcom/tencent/tinker/entry/ApplicationLike;
    //   13: invokevirtual 54	com/tencent/tinker/entry/ApplicationLike:getApplication	()Landroid/app/Application;
    //   16: ldc 56
    //   18: iconst_4
    //   19: invokevirtual 62	android/app/Application:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   22: new 64	java/lang/StringBuilder
    //   25: dup
    //   26: invokespecial 65	java/lang/StringBuilder:<init>	()V
    //   29: getstatic 71	com/tencent/mm/loader/j/a:glW	Ljava/lang/String;
    //   32: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   35: ldc 77
    //   37: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   40: invokevirtual 81	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   43: iconst_0
    //   44: invokeinterface 87 3 0
    //   49: istore_1
    //   50: iload_1
    //   51: ifle +34 -> 85
    //   54: iload_2
    //   55: ifeq +35 -> 90
    //   58: ldc 89
    //   60: ldc 91
    //   62: iconst_1
    //   63: anewarray 4	java/lang/Object
    //   66: dup
    //   67: iconst_0
    //   68: iload_1
    //   69: invokestatic 97	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   72: aastore
    //   73: invokestatic 103	com/tencent/mm/sdk/platformtools/ad:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   76: ldc 48
    //   78: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   81: aload_0
    //   82: monitorexit
    //   83: iload_2
    //   84: ireturn
    //   85: iconst_0
    //   86: istore_2
    //   87: goto -33 -> 54
    //   90: ldc 89
    //   92: ldc 105
    //   94: invokestatic 108	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   97: goto -21 -> 76
    //   100: astore_3
    //   101: aload_0
    //   102: monitorexit
    //   103: aload_3
    //   104: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	105	0	this	af
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
  private boolean La()
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_1
    //   2: aload_0
    //   3: monitorenter
    //   4: ldc 110
    //   6: invokestatic 28	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: aload_0
    //   10: getfield 30	com/tencent/mm/app/af:mAppLike	Lcom/tencent/tinker/entry/ApplicationLike;
    //   13: invokevirtual 54	com/tencent/tinker/entry/ApplicationLike:getApplication	()Landroid/app/Application;
    //   16: ldc 56
    //   18: iconst_4
    //   19: invokevirtual 62	android/app/Application:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   22: new 64	java/lang/StringBuilder
    //   25: dup
    //   26: invokespecial 65	java/lang/StringBuilder:<init>	()V
    //   29: getstatic 71	com/tencent/mm/loader/j/a:glW	Ljava/lang/String;
    //   32: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   35: ldc 112
    //   37: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   40: invokevirtual 81	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   43: iconst_0
    //   44: invokeinterface 87 3 0
    //   49: ifeq +14 -> 63
    //   52: iconst_1
    //   53: istore_1
    //   54: ldc 110
    //   56: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   59: aload_0
    //   60: monitorexit
    //   61: iload_1
    //   62: ireturn
    //   63: ldc 110
    //   65: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   68: goto -9 -> 59
    //   71: astore_2
    //   72: aload_0
    //   73: monitorexit
    //   74: aload_2
    //   75: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	76	0	this	af
    //   1	61	1	bool	boolean
    //   71	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   4	52	71	finally
    //   54	59	71	finally
    //   63	68	71	finally
  }
  
  /* Error */
  private boolean Lb()
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_1
    //   2: aload_0
    //   3: monitorenter
    //   4: ldc 114
    //   6: invokestatic 28	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: aload_0
    //   10: getfield 30	com/tencent/mm/app/af:mAppLike	Lcom/tencent/tinker/entry/ApplicationLike;
    //   13: invokevirtual 54	com/tencent/tinker/entry/ApplicationLike:getApplication	()Landroid/app/Application;
    //   16: ldc 56
    //   18: iconst_4
    //   19: invokevirtual 62	android/app/Application:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   22: new 64	java/lang/StringBuilder
    //   25: dup
    //   26: invokespecial 65	java/lang/StringBuilder:<init>	()V
    //   29: getstatic 71	com/tencent/mm/loader/j/a:glW	Ljava/lang/String;
    //   32: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   35: ldc 116
    //   37: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   40: invokevirtual 81	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   43: iconst_0
    //   44: invokeinterface 87 3 0
    //   49: ifeq +14 -> 63
    //   52: iconst_1
    //   53: istore_1
    //   54: ldc 114
    //   56: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   59: aload_0
    //   60: monitorexit
    //   61: iload_1
    //   62: ireturn
    //   63: ldc 114
    //   65: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   68: goto -9 -> 59
    //   71: astore_2
    //   72: aload_0
    //   73: monitorexit
    //   74: aload_2
    //   75: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	76	0	this	af
    //   1	61	1	bool	boolean
    //   71	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   4	52	71	finally
    //   54	59	71	finally
    //   63	68	71	finally
  }
  
  public final void KW()
  {
    try
    {
      this.cMG = false;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final void KX()
  {
    try
    {
      this.cMG = true;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  /* Error */
  public final boolean KY()
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_1
    //   2: aload_0
    //   3: monitorenter
    //   4: ldc 120
    //   6: invokestatic 28	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: aload_0
    //   10: getfield 30	com/tencent/mm/app/af:mAppLike	Lcom/tencent/tinker/entry/ApplicationLike;
    //   13: invokevirtual 54	com/tencent/tinker/entry/ApplicationLike:getApplication	()Landroid/app/Application;
    //   16: ldc 56
    //   18: iconst_4
    //   19: invokevirtual 62	android/app/Application:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   22: new 64	java/lang/StringBuilder
    //   25: dup
    //   26: invokespecial 65	java/lang/StringBuilder:<init>	()V
    //   29: getstatic 71	com/tencent/mm/loader/j/a:glW	Ljava/lang/String;
    //   32: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   35: ldc 77
    //   37: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   40: invokevirtual 81	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   43: iconst_0
    //   44: invokeinterface 87 3 0
    //   49: iconst_3
    //   50: if_icmpgt +5 -> 55
    //   53: iconst_1
    //   54: istore_1
    //   55: iload_1
    //   56: ifeq +19 -> 75
    //   59: ldc 89
    //   61: ldc 122
    //   63: invokestatic 108	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   66: ldc 120
    //   68: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   71: aload_0
    //   72: monitorexit
    //   73: iload_1
    //   74: ireturn
    //   75: ldc 89
    //   77: ldc 124
    //   79: invokestatic 126	com/tencent/mm/sdk/platformtools/ad:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   82: goto -16 -> 66
    //   85: astore_2
    //   86: aload_0
    //   87: monitorexit
    //   88: aload_2
    //   89: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	90	0	this	af
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
  
  public final void Lc()
  {
    try
    {
      AppMethodBeat.i(125036);
      SharedPreferences localSharedPreferences = this.mAppLike.getApplication().getSharedPreferences("tinker_ensurance_info", 4);
      if ((!La()) && (KZ()))
      {
        e.vIY.idkeyStat(338L, 231L, 1L, false);
        localSharedPreferences.edit().putInt(a.glW + "_clean_patch_reported", 1).apply();
      }
      if ((!Lb()) && (!KY()))
      {
        e.vIY.idkeyStat(338L, 232L, 1L, false);
        localSharedPreferences.edit().putInt(a.glW + "_block_apply_patch_reported", 1).apply();
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
        au.a(this.cMI);
        this.cMH = this.mAppLike.getApplication().getPackageName().equals(this.mAppLike.getApplication().getApplicationInfo().processName);
        paramApplicationLike = this.mAppLike.getApplication().getSharedPreferences("tinker_ensurance_info", 4);
        str = paramApplicationLike.getString("tinker_last_clientversion", null);
        if (str == null)
        {
          paramApplicationLike.edit().putString("tinker_last_clientversion", a.glW).commit();
          this.mInstalled = true;
          AppMethodBeat.o(125031);
          continue;
        }
        if (a.glW.equals(str)) {
          continue;
        }
      }
      finally {}
      paramApplicationLike.edit().remove(str + "_clean_patch_count").putString("tinker_last_clientversion", a.glW).commit();
    }
  }
  
  public static final class a
  {
    public static final af cMK;
    
    static
    {
      AppMethodBeat.i(125029);
      cMK = new af();
      AppMethodBeat.o(125029);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.app.af
 * JD-Core Version:    0.7.0.1
 */