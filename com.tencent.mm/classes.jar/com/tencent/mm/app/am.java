package com.tencent.mm.app;

import android.app.Application;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.ApplicationInfo;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.i.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMUncaughtExceptionHandler;
import com.tencent.mm.sdk.platformtools.MMUncaughtExceptionHandler.IOnUncaughtExceptionListener;
import com.tencent.tinker.entry.ApplicationLike;

public final class am
{
  volatile boolean hiR;
  boolean hiS;
  private MMUncaughtExceptionHandler.IOnUncaughtExceptionListener hiT;
  ApplicationLike mAppLike;
  private volatile boolean mInstalled;
  
  public am()
  {
    AppMethodBeat.i(125030);
    this.mAppLike = null;
    this.mInstalled = false;
    this.hiR = false;
    this.hiS = false;
    this.hiT = new MMUncaughtExceptionHandler.IOnUncaughtExceptionListener()
    {
      /* Error */
      public final void uncaughtException(MMUncaughtExceptionHandler arg1, String paramAnonymousString, java.lang.Throwable paramAnonymousThrowable)
      {
        // Byte code:
        //   0: ldc 21
        //   2: invokestatic 27	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
        //   5: aload_0
        //   6: getfield 14	com/tencent/mm/app/am$1:hiU	Lcom/tencent/mm/app/am;
        //   9: getfield 31	com/tencent/mm/app/am:mAppLike	Lcom/tencent/tinker/entry/ApplicationLike;
        //   12: invokestatic 37	com/tencent/tinker/lib/e/b:c	(Lcom/tencent/tinker/entry/ApplicationLike;)Z
        //   15: ifne +9 -> 24
        //   18: ldc 21
        //   20: invokestatic 40	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   23: return
        //   24: aload_3
        //   25: instanceof 42
        //   28: ifne +30 -> 58
        //   31: aload_3
        //   32: instanceof 44
        //   35: ifne +23 -> 58
        //   38: aload_3
        //   39: instanceof 46
        //   42: ifne +16 -> 58
        //   45: aload_3
        //   46: instanceof 48
        //   49: ifne +9 -> 58
        //   52: ldc 21
        //   54: invokestatic 40	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   57: return
        //   58: aload_0
        //   59: getfield 14	com/tencent/mm/app/am$1:hiU	Lcom/tencent/mm/app/am;
        //   62: getfield 52	com/tencent/mm/app/am:hiS	Z
        //   65: ifne +9 -> 74
        //   68: ldc 21
        //   70: invokestatic 40	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   73: return
        //   74: aload_0
        //   75: getfield 14	com/tencent/mm/app/am$1:hiU	Lcom/tencent/mm/app/am;
        //   78: getfield 31	com/tencent/mm/app/am:mAppLike	Lcom/tencent/tinker/entry/ApplicationLike;
        //   81: invokevirtual 58	com/tencent/tinker/entry/ApplicationLike:getApplication	()Landroid/app/Application;
        //   84: ldc 60
        //   86: iconst_4
        //   87: invokevirtual 66	android/app/Application:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
        //   90: astore_2
        //   91: aload_0
        //   92: getfield 14	com/tencent/mm/app/am$1:hiU	Lcom/tencent/mm/app/am;
        //   95: astore_1
        //   96: aload_1
        //   97: monitorenter
        //   98: aload_0
        //   99: getfield 14	com/tencent/mm/app/am$1:hiU	Lcom/tencent/mm/app/am;
        //   102: getfield 69	com/tencent/mm/app/am:hiR	Z
        //   105: ifne +102 -> 207
        //   108: aload_2
        //   109: ldc 71
        //   111: iconst_0
        //   112: invokeinterface 77 3 0
        //   117: istore 4
        //   119: iload 4
        //   121: iconst_3
        //   122: if_icmple +115 -> 237
        //   125: new 79	java/lang/StringBuilder
        //   128: dup
        //   129: invokespecial 80	java/lang/StringBuilder:<init>	()V
        //   132: getstatic 86	com/tencent/mm/loader/i/a:CLIENT_VERSION	Ljava/lang/String;
        //   135: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   138: ldc 92
        //   140: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   143: invokevirtual 96	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   146: astore_3
        //   147: aload_2
        //   148: aload_3
        //   149: iconst_0
        //   150: invokeinterface 77 3 0
        //   155: istore 4
        //   157: aload_2
        //   158: invokeinterface 100 1 0
        //   163: aload_3
        //   164: iload 4
        //   166: iconst_1
        //   167: iadd
        //   168: invokeinterface 106 3 0
        //   173: ldc 71
        //   175: iconst_0
        //   176: invokeinterface 106 3 0
        //   181: invokeinterface 110 1 0
        //   186: pop
        //   187: aload_0
        //   188: getfield 14	com/tencent/mm/app/am$1:hiU	Lcom/tencent/mm/app/am;
        //   191: getfield 31	com/tencent/mm/app/am:mAppLike	Lcom/tencent/tinker/entry/ApplicationLike;
        //   194: invokestatic 114	com/tencent/tinker/lib/e/b:e	(Lcom/tencent/tinker/entry/ApplicationLike;)V
        //   197: ldc 116
        //   199: ldc 118
        //   201: invokestatic 124	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
        //   204: invokestatic 127	com/tencent/mm/sdk/platformtools/Log:appenderFlushSync	()V
        //   207: aload_1
        //   208: monitorexit
        //   209: ldc 21
        //   211: invokestatic 40	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   214: return
        //   215: astore_1
        //   216: ldc 116
        //   218: aload_1
        //   219: ldc 129
        //   221: iconst_0
        //   222: anewarray 4	java/lang/Object
        //   225: invokestatic 133	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
        //   228: invokestatic 127	com/tencent/mm/sdk/platformtools/Log:appenderFlushSync	()V
        //   231: ldc 21
        //   233: invokestatic 40	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   236: return
        //   237: aload_2
        //   238: invokeinterface 100 1 0
        //   243: ldc 71
        //   245: iload 4
        //   247: iconst_1
        //   248: iadd
        //   249: invokeinterface 106 3 0
        //   254: invokeinterface 110 1 0
        //   259: pop
        //   260: goto -53 -> 207
        //   263: astore_2
        //   264: aload_1
        //   265: monitorexit
        //   266: ldc 21
        //   268: invokestatic 40	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   271: aload_2
        //   272: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	273	0	this	1
        //   0	273	2	paramAnonymousString	String
        //   0	273	3	paramAnonymousThrowable	java.lang.Throwable
        //   117	132	4	i	int
        // Exception table:
        //   from	to	target	type
        //   74	98	215	finally
        //   209	214	215	finally
        //   264	273	215	finally
        //   98	119	263	finally
        //   125	207	263	finally
        //   207	209	263	finally
        //   237	260	263	finally
      }
    };
    AppMethodBeat.o(125030);
  }
  
  private boolean aDi()
  {
    boolean bool2 = false;
    boolean bool1 = false;
    for (;;)
    {
      try
      {
        AppMethodBeat.i(125033);
        if (!this.mInstalled)
        {
          Log.w("MicroMsg.TinkerEnsuranceOnFault", "[!] Uninitialized or install failed, isCleanPatchTriggered will return false.");
          AppMethodBeat.o(125033);
          return bool1;
        }
        int i = this.mAppLike.getApplication().getSharedPreferences("tinker_ensurance_info", 4).getInt(a.CLIENT_VERSION + "_clean_patch_count", 0);
        bool1 = bool2;
        if (i > 0) {
          bool1 = true;
        }
        if (bool1)
        {
          Log.w("MicroMsg.TinkerEnsuranceOnFault", "[tomys] ensurance logic says: we have cleaned patch by %s times !!", new Object[] { Integer.valueOf(i) });
          AppMethodBeat.o(125033);
        }
        else
        {
          Log.i("MicroMsg.TinkerEnsuranceOnFault", "[tomys] ensurance logic says: clean patch logic is not being triggered.");
        }
      }
      finally {}
    }
  }
  
  private boolean aDj()
  {
    boolean bool = false;
    for (;;)
    {
      try
      {
        AppMethodBeat.i(125034);
        if (!this.mInstalled)
        {
          Log.w("MicroMsg.TinkerEnsuranceOnFault", "[!] Uninitialized or install failed, isCleanPatchReported will return false.");
          AppMethodBeat.o(125034);
          return bool;
        }
        if (this.mAppLike.getApplication().getSharedPreferences("tinker_ensurance_info", 4).getInt(a.CLIENT_VERSION + "_clean_patch_reported", 0) != 0)
        {
          bool = true;
          AppMethodBeat.o(125034);
        }
        else
        {
          AppMethodBeat.o(125034);
        }
      }
      finally {}
    }
  }
  
  private boolean aDk()
  {
    boolean bool = false;
    for (;;)
    {
      try
      {
        AppMethodBeat.i(125035);
        if (!this.mInstalled)
        {
          Log.w("MicroMsg.TinkerEnsuranceOnFault", "[!] Uninitialized or install failed, isBlockApplyPatchReported will return false.");
          AppMethodBeat.o(125035);
          return bool;
        }
        if (this.mAppLike.getApplication().getSharedPreferences("tinker_ensurance_info", 4).getInt(a.CLIENT_VERSION + "_block_apply_patch_reported", 0) != 0)
        {
          bool = true;
          AppMethodBeat.o(125035);
        }
        else
        {
          AppMethodBeat.o(125035);
        }
      }
      finally {}
    }
  }
  
  public final void aDf()
  {
    try
    {
      this.hiR = false;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final void aDg()
  {
    try
    {
      this.hiR = true;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final boolean aDh()
  {
    boolean bool2 = true;
    boolean bool1 = true;
    for (;;)
    {
      try
      {
        AppMethodBeat.i(125032);
        if (!this.mInstalled)
        {
          Log.w("MicroMsg.TinkerEnsuranceOnFault", "[!] Uninitialized or install failed, canApplyPatch will return true.");
          AppMethodBeat.o(125032);
          return bool1;
        }
        if (this.mAppLike.getApplication().getSharedPreferences("tinker_ensurance_info", 4).getInt(a.CLIENT_VERSION + "_clean_patch_count", 0) <= 3)
        {
          bool1 = bool2;
          if (!bool1) {
            break label109;
          }
          Log.i("MicroMsg.TinkerEnsuranceOnFault", "[tomys] ensurance logic says: we can apply patch.");
          AppMethodBeat.o(125032);
          continue;
        }
        bool1 = false;
      }
      finally {}
      continue;
      label109:
      Log.w("MicroMsg.TinkerEnsuranceOnFault", "[tomys] ensurance logic says: we CANNOT apply patch !!");
    }
  }
  
  /* Error */
  public final void aDl()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 135
    //   4: invokestatic 27	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_0
    //   8: getfield 31	com/tencent/mm/app/am:mInstalled	Z
    //   11: ifne +18 -> 29
    //   14: ldc 49
    //   16: ldc 137
    //   18: invokestatic 57	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   21: ldc 135
    //   23: invokestatic 43	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   26: aload_0
    //   27: monitorexit
    //   28: return
    //   29: aload_0
    //   30: getfield 29	com/tencent/mm/app/am:mAppLike	Lcom/tencent/tinker/entry/ApplicationLike;
    //   33: invokevirtual 63	com/tencent/tinker/entry/ApplicationLike:getApplication	()Landroid/app/Application;
    //   36: ldc 65
    //   38: iconst_4
    //   39: invokevirtual 71	android/app/Application:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   42: astore_1
    //   43: aload_0
    //   44: invokespecial 139	com/tencent/mm/app/am:aDj	()Z
    //   47: ifne +62 -> 109
    //   50: aload_0
    //   51: invokespecial 141	com/tencent/mm/app/am:aDi	()Z
    //   54: ifeq +55 -> 109
    //   57: getstatic 147	com/tencent/mm/plugin/report/f:Ozc	Lcom/tencent/mm/plugin/report/f;
    //   60: ldc2_w 148
    //   63: ldc2_w 150
    //   66: lconst_1
    //   67: iconst_0
    //   68: invokevirtual 155	com/tencent/mm/plugin/report/f:idkeyStat	(JJJZ)V
    //   71: aload_1
    //   72: invokeinterface 159 1 0
    //   77: new 73	java/lang/StringBuilder
    //   80: dup
    //   81: invokespecial 74	java/lang/StringBuilder:<init>	()V
    //   84: getstatic 80	com/tencent/mm/loader/i/a:CLIENT_VERSION	Ljava/lang/String;
    //   87: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   90: ldc 117
    //   92: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   95: invokevirtual 90	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   98: iconst_1
    //   99: invokeinterface 165 3 0
    //   104: invokeinterface 168 1 0
    //   109: aload_0
    //   110: invokespecial 170	com/tencent/mm/app/am:aDk	()Z
    //   113: ifne +62 -> 175
    //   116: aload_0
    //   117: invokevirtual 172	com/tencent/mm/app/am:aDh	()Z
    //   120: ifne +55 -> 175
    //   123: getstatic 147	com/tencent/mm/plugin/report/f:Ozc	Lcom/tencent/mm/plugin/report/f;
    //   126: ldc2_w 148
    //   129: ldc2_w 173
    //   132: lconst_1
    //   133: iconst_0
    //   134: invokevirtual 155	com/tencent/mm/plugin/report/f:idkeyStat	(JJJZ)V
    //   137: aload_1
    //   138: invokeinterface 159 1 0
    //   143: new 73	java/lang/StringBuilder
    //   146: dup
    //   147: invokespecial 74	java/lang/StringBuilder:<init>	()V
    //   150: getstatic 80	com/tencent/mm/loader/i/a:CLIENT_VERSION	Ljava/lang/String;
    //   153: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   156: ldc 123
    //   158: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   161: invokevirtual 90	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   164: iconst_1
    //   165: invokeinterface 165 3 0
    //   170: invokeinterface 168 1 0
    //   175: ldc 135
    //   177: invokestatic 43	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   180: goto -154 -> 26
    //   183: astore_1
    //   184: aload_0
    //   185: monitorexit
    //   186: aload_1
    //   187: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	188	0	this	am
    //   42	96	1	localSharedPreferences	SharedPreferences
    //   183	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	26	183	finally
    //   29	109	183	finally
    //   109	175	183	finally
    //   175	180	183	finally
  }
  
  public final void b(ApplicationLike paramApplicationLike)
  {
    boolean bool;
    label21:
    try
    {
      AppMethodBeat.i(125031);
    }
    finally {}
    try
    {
      bool = this.mInstalled;
      if (!bool) {
        break label24;
      }
      AppMethodBeat.o(125031);
    }
    finally
    {
      Log.printErrStackTrace("MicroMsg.TinkerEnsuranceOnFault", paramApplicationLike, "[-] Exception occurred.", new Object[0]);
      this.mInstalled = false;
      AppMethodBeat.o(125031);
      break label21;
    }
    return;
    label24:
    this.mAppLike = paramApplicationLike;
    this.hiS = this.mAppLike.getApplication().getPackageName().equals(this.mAppLike.getApplication().getApplicationInfo().processName);
    paramApplicationLike = this.mAppLike.getApplication().getSharedPreferences("tinker_ensurance_info", 4);
    String str = paramApplicationLike.getString("tinker_last_clientversion", null);
    if (str == null) {
      paramApplicationLike.edit().putString("tinker_last_clientversion", a.CLIENT_VERSION).commit();
    }
    for (;;)
    {
      MMUncaughtExceptionHandler.addOnUncaughtExceptionListener(this.hiT);
      this.mInstalled = true;
      AppMethodBeat.o(125031);
      break;
      if (!a.CLIENT_VERSION.equals(str)) {
        paramApplicationLike.edit().remove(str + "_clean_patch_count").putString("tinker_last_clientversion", a.CLIENT_VERSION).commit();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.app.am
 * JD-Core Version:    0.7.0.1
 */