package com.tencent.kinda.framework;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import com.tencent.kinda.framework.api.IPluginWxKindaApi;
import com.tencent.kinda.framework.app.SubCoreKinda;
import com.tencent.kinda.framework.boot.KindaApp;
import com.tencent.kinda.gen.IAppKinda;
import com.tencent.kinda.gen.ITransmitKvData;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.AppForegroundDelegate;
import com.tencent.mm.framework.app.UIPageFragmentActivity;
import com.tencent.mm.kernel.api.bucket.ApplicationLifeCycleBucket;
import com.tencent.mm.kernel.api.bucket.c;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.f.c;
import com.tencent.mm.model.y;
import com.tencent.mm.pluginsdk.wallet.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.threadpool.i;

public class PluginWxKindaApi
  extends f
  implements IPluginWxKindaApi, ApplicationLifeCycleBucket, c
{
  private static final String TAG = "MicroMsg.PluginWxKindaApi";
  
  public void configure(g paramg)
  {
    AppMethodBeat.i(18262);
    if (paramg.bbA())
    {
      pin(new y(SubCoreKinda.class));
      com.tencent.mm.kernel.h.b(a.class, new WxCrossServices());
    }
    AppMethodBeat.o(18262);
  }
  
  public void dependency() {}
  
  public void execute(g paramg)
  {
    AppMethodBeat.i(18263);
    AppMethodBeat.o(18263);
  }
  
  public void installed()
  {
    AppMethodBeat.i(18261);
    alias(PluginWxKindaApi.class);
    AppMethodBeat.o(18261);
  }
  
  public boolean isKindaScene(Activity paramActivity)
  {
    return paramActivity instanceof UIPageFragmentActivity;
  }
  
  public String name()
  {
    return "plugin-wxkindaapi";
  }
  
  public void onAccountInitialized(f.c paramc)
  {
    AppMethodBeat.i(226313);
    WxCrossServices.judgeReprot();
    com.tencent.threadpool.h.ahAA.bm(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(226286);
        try
        {
          if ((((com.tencent.mm.kernel.b.h)com.tencent.mm.kernel.h.baB().bad()).bbA()) && (WxCrossServices.isKindaEnabled())) {
            KindaApp.appKinda().applicationRestart();
          }
          AppMethodBeat.o(226286);
          return;
        }
        catch (Exception localException)
        {
          Log.printErrStackTrace("MicroMsg.PluginWxKindaApi", localException, "", new Object[0]);
          AppMethodBeat.o(226286);
          return;
        }
        catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
        {
          label39:
          break label39;
        }
      }
    });
    AppMethodBeat.o(226313);
  }
  
  public void onAccountRelease() {}
  
  public void onBaseContextAttached(Context paramContext) {}
  
  public void onConfigurationChanged(Configuration paramConfiguration) {}
  
  public void onCreate() {}
  
  public void onLowMemory()
  {
    AppMethodBeat.i(226327);
    com.tencent.threadpool.h.ahAA.bm(new Runnable()
    {
      /* Error */
      public void run()
      {
        // Byte code:
        //   0: ldc 26
        //   2: invokestatic 32	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
        //   5: invokestatic 38	com/tencent/mm/kernel/h:baB	()Lcom/tencent/mm/kernel/e;
        //   8: invokevirtual 44	com/tencent/mm/kernel/e:bad	()Lcom/tencent/mm/kernel/b/g;
        //   11: checkcast 46	com/tencent/mm/kernel/b/h
        //   14: invokevirtual 50	com/tencent/mm/kernel/b/h:bbA	()Z
        //   17: ifeq +61 -> 78
        //   20: invokestatic 55	com/tencent/kinda/framework/WxCrossServices:isKindaEnabled	()Z
        //   23: ifeq +55 -> 78
        //   26: invokestatic 61	com/tencent/kinda/gen/ITransmitKvData:create	()Lcom/tencent/kinda/gen/ITransmitKvData;
        //   29: astore_2
        //   30: new 63	java/lang/StringBuilder
        //   33: dup
        //   34: invokespecial 64	java/lang/StringBuilder:<init>	()V
        //   37: astore_3
        //   38: getstatic 70	com/tencent/mm/app/AppForegroundDelegate:heY	Lcom/tencent/mm/app/AppForegroundDelegate;
        //   41: getfield 74	com/tencent/mm/app/AppForegroundDelegate:eLx	Z
        //   44: ifeq +40 -> 84
        //   47: iconst_1
        //   48: istore_1
        //   49: aload_2
        //   50: ldc 76
        //   52: aload_3
        //   53: iload_1
        //   54: invokevirtual 80	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
        //   57: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   60: invokevirtual 88	com/tencent/kinda/gen/ITransmitKvData:putString	(Ljava/lang/String;Ljava/lang/String;)V
        //   63: aload_2
        //   64: ldc 90
        //   66: ldc 92
        //   68: invokevirtual 88	com/tencent/kinda/gen/ITransmitKvData:putString	(Ljava/lang/String;Ljava/lang/String;)V
        //   71: invokestatic 98	com/tencent/kinda/framework/boot/KindaApp:appKinda	()Lcom/tencent/kinda/gen/IAppKinda;
        //   74: aload_2
        //   75: invokevirtual 104	com/tencent/kinda/gen/IAppKinda:applicationReceiveMemoryWarning	(Lcom/tencent/kinda/gen/ITransmitKvData;)V
        //   78: ldc 26
        //   80: invokestatic 107	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   83: return
        //   84: iconst_0
        //   85: istore_1
        //   86: goto -37 -> 49
        //   89: astore_2
        //   90: ldc 109
        //   92: aload_2
        //   93: ldc 111
        //   95: iconst_0
        //   96: anewarray 4	java/lang/Object
        //   99: invokestatic 117	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
        //   102: ldc 26
        //   104: invokestatic 107	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   107: return
        //   108: astore_2
        //   109: goto -19 -> 90
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	112	0	this	2
        //   48	38	1	i	int
        //   29	46	2	localITransmitKvData	ITransmitKvData
        //   89	4	2	localException	Exception
        //   108	1	2	localUnsatisfiedLinkError	UnsatisfiedLinkError
        //   37	16	3	localStringBuilder	java.lang.StringBuilder
        // Exception table:
        //   from	to	target	type
        //   5	47	89	java/lang/Exception
        //   49	78	89	java/lang/Exception
        //   5	47	108	java/lang/UnsatisfiedLinkError
        //   49	78	108	java/lang/UnsatisfiedLinkError
      }
    });
    AppMethodBeat.o(226327);
  }
  
  public void onTerminate()
  {
    AppMethodBeat.i(226339);
    com.tencent.threadpool.h.ahAA.bm(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(226289);
        try
        {
          if ((((com.tencent.mm.kernel.b.h)com.tencent.mm.kernel.h.baB().bad()).bbA()) && (WxCrossServices.isKindaEnabled()))
          {
            ITransmitKvData localITransmitKvData = ITransmitKvData.create();
            localITransmitKvData.putString("foreground", AppForegroundDelegate.heY.eLx);
            localITransmitKvData.putString("emulator", "1");
            KindaApp.appKinda().applicationWillTerminate(localITransmitKvData);
          }
          AppMethodBeat.o(226289);
          return;
        }
        catch (Exception localException)
        {
          Log.printErrStackTrace("MicroMsg.PluginWxKindaApi", localException, "", new Object[0]);
          AppMethodBeat.o(226289);
          return;
        }
        catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
        {
          label77:
          break label77;
        }
      }
    });
    AppMethodBeat.o(226339);
  }
  
  public void onTrimMemory(final int paramInt)
  {
    AppMethodBeat.i(226334);
    if (paramInt <= 20)
    {
      AppMethodBeat.o(226334);
      return;
    }
    com.tencent.threadpool.h.ahAA.bm(new Runnable()
    {
      /* Error */
      public void run()
      {
        // Byte code:
        //   0: ldc 31
        //   2: invokestatic 36	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
        //   5: invokestatic 42	com/tencent/mm/kernel/h:baB	()Lcom/tencent/mm/kernel/e;
        //   8: invokevirtual 48	com/tencent/mm/kernel/e:bad	()Lcom/tencent/mm/kernel/b/g;
        //   11: checkcast 50	com/tencent/mm/kernel/b/h
        //   14: invokevirtual 54	com/tencent/mm/kernel/b/h:bbA	()Z
        //   17: ifeq +84 -> 101
        //   20: invokestatic 59	com/tencent/kinda/framework/WxCrossServices:isKindaEnabled	()Z
        //   23: ifeq +78 -> 101
        //   26: invokestatic 65	com/tencent/kinda/gen/ITransmitKvData:create	()Lcom/tencent/kinda/gen/ITransmitKvData;
        //   29: astore_2
        //   30: new 67	java/lang/StringBuilder
        //   33: dup
        //   34: invokespecial 68	java/lang/StringBuilder:<init>	()V
        //   37: astore_3
        //   38: getstatic 74	com/tencent/mm/app/AppForegroundDelegate:heY	Lcom/tencent/mm/app/AppForegroundDelegate;
        //   41: getfield 78	com/tencent/mm/app/AppForegroundDelegate:eLx	Z
        //   44: ifeq +63 -> 107
        //   47: iconst_1
        //   48: istore_1
        //   49: aload_2
        //   50: ldc 80
        //   52: aload_3
        //   53: iload_1
        //   54: invokevirtual 84	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
        //   57: invokevirtual 88	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   60: invokevirtual 92	com/tencent/kinda/gen/ITransmitKvData:putString	(Ljava/lang/String;Ljava/lang/String;)V
        //   63: aload_2
        //   64: ldc 94
        //   66: ldc 96
        //   68: invokevirtual 92	com/tencent/kinda/gen/ITransmitKvData:putString	(Ljava/lang/String;Ljava/lang/String;)V
        //   71: aload_2
        //   72: ldc 98
        //   74: new 67	java/lang/StringBuilder
        //   77: dup
        //   78: invokespecial 68	java/lang/StringBuilder:<init>	()V
        //   81: aload_0
        //   82: getfield 21	com/tencent/kinda/framework/PluginWxKindaApi$3:val$level	I
        //   85: invokevirtual 84	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
        //   88: invokevirtual 88	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   91: invokevirtual 92	com/tencent/kinda/gen/ITransmitKvData:putString	(Ljava/lang/String;Ljava/lang/String;)V
        //   94: invokestatic 104	com/tencent/kinda/framework/boot/KindaApp:appKinda	()Lcom/tencent/kinda/gen/IAppKinda;
        //   97: aload_2
        //   98: invokevirtual 110	com/tencent/kinda/gen/IAppKinda:applicationReceiveMemoryWarning	(Lcom/tencent/kinda/gen/ITransmitKvData;)V
        //   101: ldc 31
        //   103: invokestatic 113	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   106: return
        //   107: iconst_0
        //   108: istore_1
        //   109: goto -60 -> 49
        //   112: astore_2
        //   113: ldc 115
        //   115: aload_2
        //   116: ldc 117
        //   118: iconst_0
        //   119: anewarray 4	java/lang/Object
        //   122: invokestatic 123	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
        //   125: ldc 31
        //   127: invokestatic 113	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   130: return
        //   131: astore_2
        //   132: goto -19 -> 113
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	135	0	this	3
        //   48	61	1	i	int
        //   29	69	2	localITransmitKvData	ITransmitKvData
        //   112	4	2	localException	Exception
        //   131	1	2	localUnsatisfiedLinkError	UnsatisfiedLinkError
        //   37	16	3	localStringBuilder	java.lang.StringBuilder
        // Exception table:
        //   from	to	target	type
        //   5	47	112	java/lang/Exception
        //   49	101	112	java/lang/Exception
        //   5	47	131	java/lang/UnsatisfiedLinkError
        //   49	101	131	java/lang/UnsatisfiedLinkError
      }
    });
    AppMethodBeat.o(226334);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.kinda.framework.PluginWxKindaApi
 * JD-Core Version:    0.7.0.1
 */