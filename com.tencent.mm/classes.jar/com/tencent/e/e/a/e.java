package com.tencent.e.e.a;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.util.SparseArray;
import com.tencent.e.e.a.a.f;
import com.tencent.e.e.a.a.g;
import com.tencent.e.e.a.a.g.a;
import com.tencent.e.e.a.a.h;
import com.tencent.e.e.a.a.k;
import com.tencent.e.f.j;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.ArrayList;
import java.util.List;

public final class e
{
  private static final j<e> Bky;
  private final List<k> BkA;
  private d BkB;
  private b BkC;
  private com.tencent.e.e.a.a.d BkD;
  private final Runnable BkE;
  private final e.a BkF;
  private g Bkz;
  private boolean ajS;
  private final Handler mHandler;
  
  static
  {
    AppMethodBeat.i(114551);
    Bky = new e.1();
    AppMethodBeat.o(114551);
  }
  
  private e()
  {
    AppMethodBeat.i(114545);
    this.ajS = false;
    this.BkA = new ArrayList();
    this.BkE = new e.2(this);
    this.BkF = new e.a(this, (byte)0);
    HandlerThread localHandlerThread = new HandlerThread("TuringMMCore");
    try
    {
      localHandlerThread.setPriority(2);
      localHandlerThread.start();
      this.mHandler = new Handler(localHandlerThread.getLooper());
      AppMethodBeat.o(114545);
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        ab.printErrStackTrace("MicroMsg.TMM", localThrowable, "", new Object[0]);
      }
    }
  }
  
  public static e dUE()
  {
    AppMethodBeat.i(114544);
    e locale = (e)Bky.get();
    AppMethodBeat.o(114544);
    return locale;
  }
  
  public final boolean Ez()
  {
    boolean bool = false;
    for (;;)
    {
      try
      {
        AppMethodBeat.i(114547);
        if (!this.ajS)
        {
          AppMethodBeat.o(114547);
          bool = true;
          return bool;
        }
        this.ajS = false;
        if (this.BkB == null)
        {
          AppMethodBeat.o(114547);
          continue;
        }
        this.mHandler.removeCallbacks(this.BkE);
      }
      finally {}
      this.mHandler.removeCallbacks(this.BkF);
      if (this.Bkz != null)
      {
        this.Bkz.dUI();
        if ((int)(this.Bkz.BkW.dUL() / f.BkP) < 3) {
          AppMethodBeat.o(114547);
        }
      }
      else
      {
        AppMethodBeat.o(114547);
        bool = true;
        continue;
      }
      SparseArray localSparseArray1 = this.Bkz.dUJ();
      if (localSparseArray1.size() == 0)
      {
        AppMethodBeat.o(114547);
      }
      else
      {
        ArrayList localArrayList;
        synchronized (this.BkA)
        {
          localArrayList = new ArrayList(this.BkA);
          if (localArrayList.size() < 3) {
            AppMethodBeat.o(114547);
          }
        }
        int i = this.BkB.Bkw;
        int j = this.BkB.action;
        int k = this.BkB.requestType;
        this.mHandler.post(new e.3(this, i, j, k, localSparseArray2, localArrayList));
        AppMethodBeat.o(114547);
        bool = true;
      }
    }
  }
  
  public final void a(Context paramContext, String paramString, com.tencent.e.e.a.a.e parame)
  {
    try
    {
      AppMethodBeat.i(114548);
      h localh = h.dUM();
      if (!localh.mInit) {
        localh.init(paramContext);
      }
      this.mHandler.post(new e.4(this, parame, paramString));
      AppMethodBeat.o(114548);
      return;
    }
    finally {}
  }
  
  /* Error */
  public final boolean a(d paramd)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_2
    //   2: aload_0
    //   3: monitorenter
    //   4: ldc_w 270
    //   7: invokestatic 37	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   10: aload_1
    //   11: getfield 274	com/tencent/e/e/a/d:context	Landroid/content/Context;
    //   14: astore_3
    //   15: aload_3
    //   16: ifnonnull +15 -> 31
    //   19: iconst_0
    //   20: istore_2
    //   21: ldc_w 270
    //   24: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   27: aload_0
    //   28: monitorexit
    //   29: iload_2
    //   30: ireturn
    //   31: invokestatic 256	com/tencent/e/e/a/a/h:dUM	()Lcom/tencent/e/e/a/a/h;
    //   34: astore 4
    //   36: aload 4
    //   38: getfield 259	com/tencent/e/e/a/a/h:mInit	Z
    //   41: ifne +9 -> 50
    //   44: aload 4
    //   46: aload_3
    //   47: invokevirtual 263	com/tencent/e/e/a/a/h:init	(Landroid/content/Context;)V
    //   50: aload_0
    //   51: getfield 54	com/tencent/e/e/a/e:ajS	Z
    //   54: ifeq +8 -> 62
    //   57: aload_0
    //   58: invokevirtual 276	com/tencent/e/e/a/e:Ez	()Z
    //   61: pop
    //   62: aload_0
    //   63: aload_1
    //   64: putfield 111	com/tencent/e/e/a/e:BkB	Lcom/tencent/e/e/a/d;
    //   67: aload_0
    //   68: iconst_1
    //   69: putfield 54	com/tencent/e/e/a/e:ajS	Z
    //   72: aload_0
    //   73: getfield 182	com/tencent/e/e/a/e:Bkz	Lcom/tencent/e/e/a/a/g;
    //   76: ifnonnull +14 -> 90
    //   79: aload_0
    //   80: new 195	com/tencent/e/e/a/a/g
    //   83: dup
    //   84: invokespecial 277	com/tencent/e/e/a/a/g:<init>	()V
    //   87: putfield 182	com/tencent/e/e/a/e:Bkz	Lcom/tencent/e/e/a/a/g;
    //   90: aload_0
    //   91: getfield 182	com/tencent/e/e/a/e:Bkz	Lcom/tencent/e/e/a/a/g;
    //   94: ifnull +27 -> 121
    //   97: aload_0
    //   98: getfield 182	com/tencent/e/e/a/e:Bkz	Lcom/tencent/e/e/a/a/g;
    //   101: astore 4
    //   103: aload 4
    //   105: getfield 281	com/tencent/e/e/a/a/g:BkU	Landroid/util/SparseArray;
    //   108: astore_3
    //   109: aload_3
    //   110: monitorenter
    //   111: aload 4
    //   113: getfield 281	com/tencent/e/e/a/a/g:BkU	Landroid/util/SparseArray;
    //   116: invokevirtual 284	android/util/SparseArray:clear	()V
    //   119: aload_3
    //   120: monitorexit
    //   121: aload_0
    //   122: getfield 59	com/tencent/e/e/a/e:BkA	Ljava/util/List;
    //   125: astore_3
    //   126: aload_3
    //   127: monitorenter
    //   128: aload_0
    //   129: getfield 59	com/tencent/e/e/a/e:BkA	Ljava/util/List;
    //   132: invokeinterface 285 1 0
    //   137: aload_3
    //   138: monitorexit
    //   139: aload_0
    //   140: getfield 95	com/tencent/e/e/a/e:mHandler	Landroid/os/Handler;
    //   143: aload_0
    //   144: getfield 66	com/tencent/e/e/a/e:BkE	Ljava/lang/Runnable;
    //   147: aload_1
    //   148: getfield 288	com/tencent/e/e/a/d:yoo	J
    //   151: invokevirtual 292	android/os/Handler:postDelayed	(Ljava/lang/Runnable;J)Z
    //   154: pop
    //   155: ldc_w 270
    //   158: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   161: goto -134 -> 27
    //   164: astore_1
    //   165: aload_0
    //   166: monitorexit
    //   167: aload_1
    //   168: athrow
    //   169: astore_1
    //   170: aload_3
    //   171: monitorexit
    //   172: ldc_w 270
    //   175: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   178: aload_1
    //   179: athrow
    //   180: astore_1
    //   181: aload_3
    //   182: monitorexit
    //   183: ldc_w 270
    //   186: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   189: aload_1
    //   190: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	191	0	this	e
    //   0	191	1	paramd	d
    //   1	29	2	bool	boolean
    //   34	78	4	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   4	15	164	finally
    //   21	27	164	finally
    //   31	50	164	finally
    //   50	62	164	finally
    //   62	90	164	finally
    //   90	111	164	finally
    //   121	128	164	finally
    //   139	161	164	finally
    //   172	180	164	finally
    //   183	191	164	finally
    //   111	121	169	finally
    //   170	172	169	finally
    //   128	139	180	finally
    //   181	183	180	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.e.e.a.e
 * JD-Core Version:    0.7.0.1
 */