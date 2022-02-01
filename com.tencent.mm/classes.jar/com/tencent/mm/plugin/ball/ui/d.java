package com.tencent.mm.plugin.ball.ui;

import android.animation.AnimatorListenerAdapter;
import android.os.Looper;
import android.os.ResultReceiver;
import android.view.WindowManager.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.ball.b.b;
import com.tencent.mm.plugin.ball.model.BallInfo;
import com.tencent.mm.plugin.ball.view.FloatBallView;
import com.tencent.mm.plugin.ball.view.FloatMenuView;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.List;

public class d
  implements com.tencent.mm.plugin.ball.c.d
{
  private static d vlz;
  public volatile boolean vku = false;
  public a vlA;
  private boolean vlB = false;
  
  private static boolean G(BallInfo paramBallInfo)
  {
    return (paramBallInfo.state != 0) && (!paramBallInfo.trn);
  }
  
  private void b(List<BallInfo> paramList, BallInfo paramBallInfo)
  {
    AppMethodBeat.i(184618);
    try
    {
      if (com.tencent.mm.plugin.ball.f.d.checkListNotEmpty(paramList))
      {
        if (!cZa())
        {
          Log.i("MicroMsg.FloatBallUIManager", "float ball did not create");
          cZc();
          c(paramList, paramBallInfo);
          AppMethodBeat.o(184618);
          return;
        }
        Log.i("MicroMsg.FloatBallUIManager", "float ball already created");
        c(paramList, paramBallInfo);
        AppMethodBeat.o(184618);
        return;
      }
    }
    catch (Exception paramList)
    {
      Log.e("MicroMsg.FloatBallUIManager", "onFloatBallInfoChangedInternal exp:%s", new Object[] { paramList });
      AppMethodBeat.o(184618);
      return;
    }
    Log.i("MicroMsg.FloatBallUIManager", "empty ball info list");
    cZb();
    AppMethodBeat.o(184618);
  }
  
  private void c(List<BallInfo> paramList, BallInfo paramBallInfo)
  {
    AppMethodBeat.i(184620);
    if (cZa()) {
      this.vlA.a(paramList, paramBallInfo);
    }
    AppMethodBeat.o(184620);
  }
  
  private boolean cYX()
  {
    AppMethodBeat.i(288287);
    if ((cZa()) && (this.vlA.cYX()))
    {
      AppMethodBeat.o(288287);
      return true;
    }
    AppMethodBeat.o(288287);
    return false;
  }
  
  /* Error */
  public static d cYZ()
  {
    // Byte code:
    //   0: ldc 139
    //   2: invokestatic 61	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: ldc 2
    //   7: monitorenter
    //   8: getstatic 141	com/tencent/mm/plugin/ball/ui/d:vlz	Lcom/tencent/mm/plugin/ball/ui/d;
    //   11: ifnonnull +19 -> 30
    //   14: ldc 2
    //   16: monitorenter
    //   17: new 2	com/tencent/mm/plugin/ball/ui/d
    //   20: dup
    //   21: invokespecial 142	com/tencent/mm/plugin/ball/ui/d:<init>	()V
    //   24: putstatic 141	com/tencent/mm/plugin/ball/ui/d:vlz	Lcom/tencent/mm/plugin/ball/ui/d;
    //   27: ldc 2
    //   29: monitorexit
    //   30: ldc 2
    //   32: monitorexit
    //   33: getstatic 141	com/tencent/mm/plugin/ball/ui/d:vlz	Lcom/tencent/mm/plugin/ball/ui/d;
    //   36: astore_0
    //   37: ldc 139
    //   39: invokestatic 68	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   42: aload_0
    //   43: areturn
    //   44: astore_0
    //   45: ldc 2
    //   47: monitorexit
    //   48: ldc 139
    //   50: invokestatic 68	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   53: aload_0
    //   54: athrow
    //   55: astore_0
    //   56: ldc 2
    //   58: monitorexit
    //   59: ldc 139
    //   61: invokestatic 68	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   64: aload_0
    //   65: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   36	7	0	locald	d
    //   44	10	0	localObject1	Object
    //   55	10	0	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   17	30	44	finally
    //   8	17	55	finally
    //   30	33	55	finally
    //   45	55	55	finally
  }
  
  private void cZc()
  {
    AppMethodBeat.i(184619);
    this.vlA = new a(MMApplicationContext.getContext());
    this.vlA.cYW();
    cZd();
    AppMethodBeat.o(184619);
  }
  
  private void cZd()
  {
    AppMethodBeat.i(288294);
    if (this.vlB)
    {
      this.vlA.setNeedTranslateAnimation(this.vlB);
      this.vlB = false;
    }
    AppMethodBeat.o(288294);
  }
  
  private void d(boolean paramBoolean, AnimatorListenerAdapter paramAnimatorListenerAdapter)
  {
    AppMethodBeat.i(288284);
    if (cZa())
    {
      if (cYX())
      {
        this.vlA.c(paramBoolean, paramAnimatorListenerAdapter);
        AppMethodBeat.o(288284);
        return;
      }
      if (paramAnimatorListenerAdapter != null) {
        paramAnimatorListenerAdapter.onAnimationEnd(null);
      }
    }
    AppMethodBeat.o(288284);
  }
  
  public final void a(int paramInt, BallInfo paramBallInfo)
  {
    AppMethodBeat.i(288339);
    Log.v("MicroMsg.FloatBallUIManager", "alvinluo onFloatBallAdded size: %d, state: %d, hidden: %b", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramBallInfo.state), Boolean.valueOf(paramBallInfo.trn) });
    if ((paramInt == 1) && (G(paramBallInfo))) {
      this.vlB = true;
    }
    AppMethodBeat.o(288339);
  }
  
  public final void a(final List<BallInfo> paramList, final BallInfo paramBallInfo)
  {
    AppMethodBeat.i(106313);
    Log.d("MicroMsg.FloatBallUIManager", "onFloatBallInfoChanged");
    if (Looper.getMainLooper() == Looper.myLooper())
    {
      b(paramList, paramBallInfo);
      AppMethodBeat.o(106313);
      return;
    }
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(288286);
        d.a(d.this, paramList, paramBallInfo);
        AppMethodBeat.o(288286);
      }
    });
    AppMethodBeat.o(106313);
  }
  
  public final void a(final boolean paramBoolean, final ResultReceiver paramResultReceiver)
  {
    AppMethodBeat.i(288323);
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(106305);
        if (d.this.cZa())
        {
          a locala = d.a(d.this);
          boolean bool = paramBoolean;
          ResultReceiver localResultReceiver = paramResultReceiver;
          locala.vle.owx = Util.nowMilliSecond();
          if ((locala.vla != null) && (locala.vlb != null))
          {
            locala.vla.b(false, null);
            locala.vlb.setInLongPressMode(false);
            locala.vlb.setForceShowFloatMenu(true);
            locala.vlb.d(localResultReceiver);
            locala.vlf = bool;
          }
        }
        AppMethodBeat.o(106305);
      }
    });
    AppMethodBeat.o(288323);
  }
  
  public final void b(int paramInt, BallInfo paramBallInfo)
  {
    AppMethodBeat.i(288341);
    Log.v("MicroMsg.FloatBallUIManager", "alvinluo onFloatBallRemoved size: %d, state: %d, hidden: %b", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramBallInfo.state), Boolean.valueOf(paramBallInfo.trn) });
    if ((paramInt == 0) && (cZa()) && (G(paramBallInfo))) {
      this.vlB = true;
    }
    AppMethodBeat.o(288341);
  }
  
  public final void b(final boolean paramBoolean1, final boolean paramBoolean2, final AnimatorListenerAdapter paramAnimatorListenerAdapter)
  {
    AppMethodBeat.i(184617);
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(106308);
        if (d.this.cZa())
        {
          a locala = d.a(d.this);
          boolean bool1 = paramBoolean1;
          boolean bool2 = paramBoolean2;
          AnimatorListenerAdapter localAnimatorListenerAdapter = paramAnimatorListenerAdapter;
          if (locala.vla != null)
          {
            Log.i("MicroMsg.FloatBallContainer", "resume FloatBallView, animation:%s", new Object[] { Boolean.valueOf(bool1) });
            locala.vla.c(bool1, bool2, localAnimatorListenerAdapter);
          }
          if (locala.vlb != null)
          {
            Log.i("MicroMsg.FloatBallContainer", "quickHide FloatMenuView");
            locala.vlb.e(localAnimatorListenerAdapter);
          }
        }
        AppMethodBeat.o(106308);
      }
    });
    AppMethodBeat.o(184617);
  }
  
  public final void c(final boolean paramBoolean, final AnimatorListenerAdapter paramAnimatorListenerAdapter)
  {
    AppMethodBeat.i(288328);
    if (Looper.getMainLooper() == Looper.myLooper())
    {
      d(paramBoolean, paramAnimatorListenerAdapter);
      AppMethodBeat.o(288328);
      return;
    }
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(106306);
        d.a(d.this, paramBoolean, paramAnimatorListenerAdapter);
        AppMethodBeat.o(106306);
      }
    });
    AppMethodBeat.o(288328);
  }
  
  public final void cYU()
  {
    AppMethodBeat.i(176971);
    if (cZa())
    {
      this.vlA.cYU();
      AppMethodBeat.o(176971);
      return;
    }
    Log.w("MicroMsg.FloatBallUIManager", "clearVOIPView, container is null");
    AppMethodBeat.o(176971);
  }
  
  public final boolean cYV()
  {
    AppMethodBeat.i(106310);
    if (cZa())
    {
      boolean bool = this.vlA.cYV();
      AppMethodBeat.o(106310);
      return bool;
    }
    AppMethodBeat.o(106310);
    return false;
  }
  
  public final boolean cZa()
  {
    return this.vlA != null;
  }
  
  public final void cZb()
  {
    AppMethodBeat.i(106312);
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(176969);
        Object localObject;
        boolean bool;
        FloatBallView localFloatBallView;
        if (d.this.cZa())
        {
          d.c(d.this);
          localObject = d.a(d.this);
          if ((((a)localObject).vla.getVisibility() != 0) && (((a)localObject).vlb.getVisibility() != 0)) {
            break label193;
          }
          if (((a)localObject).vla.getVisibility() != 0) {
            break label200;
          }
          bool = ((a)localObject).vla.vlB;
          Log.i("MicroMsg.FloatBallContainer", "detachFromWindow, hide floatBallView, needTranslateAnimation: %b", new Object[] { Boolean.valueOf(bool) });
          if (!bool) {
            break label184;
          }
          localFloatBallView = ((a)localObject).vla;
          localObject = new a.5((a)localObject);
          Log.i("MicroMsg.FloatBallView", "alvinluo hideByTranslation");
          localFloatBallView.setNeedTranslateAnimation(false);
          if (localFloatBallView.getVisibility() != 8) {
            break label146;
          }
          Log.i("MicroMsg.FloatBallView", "hideByTranslation float ball already hide");
        }
        for (;;)
        {
          d.d(d.this);
          AppMethodBeat.o(176969);
          return;
          label146:
          if (localFloatBallView.voq != null)
          {
            bool = localFloatBallView.FT(((WindowManager.LayoutParams)localFloatBallView.getLayoutParams()).x);
            localFloatBallView.voq.b(localFloatBallView.getCurrentStateWidth(), bool, (AnimatorListenerAdapter)localObject);
          }
        }
        label184:
        ((a)localObject).vla.b(false, null);
        for (;;)
        {
          label193:
          ((a)localObject).cYY();
          break;
          label200:
          if (((a)localObject).vlb.getVisibility() != 0) {
            break;
          }
          Log.i("MicroMsg.FloatBallContainer", "detachFromWindow, hide floatMenuView");
          ((a)localObject).vle.FH(1);
          ((a)localObject).vlb.setCanAddFloatBallWhenHide(((a)localObject).vlf);
          ((a)localObject).vlf = false;
          ((a)localObject).vlb.e(null);
        }
      }
    });
    AppMethodBeat.o(106312);
  }
  
  public final void e(final boolean paramBoolean, final AnimatorListenerAdapter paramAnimatorListenerAdapter)
  {
    AppMethodBeat.i(184616);
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(106307);
        if (d.this.cZa()) {
          d.a(d.this).b(paramBoolean, paramAnimatorListenerAdapter);
        }
        AppMethodBeat.o(106307);
      }
    });
    AppMethodBeat.o(184616);
  }
  
  public final int getPositionY()
  {
    AppMethodBeat.i(184615);
    if (cZa())
    {
      i = this.vlA.getPositionY();
      AppMethodBeat.o(184615);
      return i;
    }
    int i = com.tencent.mm.plugin.ball.f.d.cZi();
    AppMethodBeat.o(184615);
    return i;
  }
  
  public final void mn(final boolean paramBoolean)
  {
    AppMethodBeat.i(176970);
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(106303);
        if (d.this.cZa())
        {
          a locala = d.a(d.this);
          boolean bool = paramBoolean;
          if (locala.vla != null) {
            locala.vla.mn(bool);
          }
          if (!bool)
          {
            if (locala.vlb != null) {
              locala.vlb.e(null);
            }
            if (locala.vla != null) {
              locala.vla.mn(bool);
            }
          }
          if (paramBoolean) {
            d.b(d.this);
          }
        }
        AppMethodBeat.o(106303);
      }
    });
    AppMethodBeat.o(176970);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.ball.ui.d
 * JD-Core Version:    0.7.0.1
 */