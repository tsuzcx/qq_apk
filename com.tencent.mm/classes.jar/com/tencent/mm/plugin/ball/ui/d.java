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
  private static d oYh;
  public volatile boolean oXd = false;
  public a oYi;
  private boolean oYj = false;
  
  private static boolean G(BallInfo paramBallInfo)
  {
    return (paramBallInfo.state != 0) && (!paramBallInfo.nno);
  }
  
  private void b(List<BallInfo> paramList, BallInfo paramBallInfo)
  {
    AppMethodBeat.i(184618);
    try
    {
      if (com.tencent.mm.plugin.ball.f.d.h(paramList))
      {
        if (!ciY())
        {
          Log.i("MicroMsg.FloatBallUIManager", "float ball did not create");
          cja();
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
    ciZ();
    AppMethodBeat.o(184618);
  }
  
  private void c(List<BallInfo> paramList, BallInfo paramBallInfo)
  {
    AppMethodBeat.i(184620);
    if (ciY()) {
      this.oYi.a(paramList, paramBallInfo);
    }
    AppMethodBeat.o(184620);
  }
  
  private boolean ciV()
  {
    AppMethodBeat.i(217056);
    if ((ciY()) && (this.oYi.ciV()))
    {
      AppMethodBeat.o(217056);
      return true;
    }
    AppMethodBeat.o(217056);
    return false;
  }
  
  /* Error */
  public static d ciX()
  {
    // Byte code:
    //   0: ldc 139
    //   2: invokestatic 61	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: ldc 2
    //   7: monitorenter
    //   8: getstatic 141	com/tencent/mm/plugin/ball/ui/d:oYh	Lcom/tencent/mm/plugin/ball/ui/d;
    //   11: ifnonnull +19 -> 30
    //   14: ldc 2
    //   16: monitorenter
    //   17: new 2	com/tencent/mm/plugin/ball/ui/d
    //   20: dup
    //   21: invokespecial 142	com/tencent/mm/plugin/ball/ui/d:<init>	()V
    //   24: putstatic 141	com/tencent/mm/plugin/ball/ui/d:oYh	Lcom/tencent/mm/plugin/ball/ui/d;
    //   27: ldc 2
    //   29: monitorexit
    //   30: ldc 2
    //   32: monitorexit
    //   33: getstatic 141	com/tencent/mm/plugin/ball/ui/d:oYh	Lcom/tencent/mm/plugin/ball/ui/d;
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
    //   45	48	44	finally
    //   8	17	55	finally
    //   30	33	55	finally
    //   48	55	55	finally
    //   56	59	55	finally
  }
  
  private void cja()
  {
    AppMethodBeat.i(184619);
    this.oYi = new a(MMApplicationContext.getContext());
    this.oYi.ciU();
    cjb();
    AppMethodBeat.o(184619);
  }
  
  private void cjb()
  {
    AppMethodBeat.i(217059);
    if (this.oYj)
    {
      this.oYi.setNeedTranslateAnimation(this.oYj);
      this.oYj = false;
    }
    AppMethodBeat.o(217059);
  }
  
  private void d(boolean paramBoolean, AnimatorListenerAdapter paramAnimatorListenerAdapter)
  {
    AppMethodBeat.i(217055);
    if (ciY())
    {
      if (ciV())
      {
        this.oYi.c(paramBoolean, paramAnimatorListenerAdapter);
        AppMethodBeat.o(217055);
        return;
      }
      if (paramAnimatorListenerAdapter != null) {
        paramAnimatorListenerAdapter.onAnimationEnd(null);
      }
    }
    AppMethodBeat.o(217055);
  }
  
  public final void a(int paramInt, BallInfo paramBallInfo)
  {
    AppMethodBeat.i(217057);
    Log.v("MicroMsg.FloatBallUIManager", "alvinluo onFloatBallAdded size: %d, state: %d, hidden: %b", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramBallInfo.state), Boolean.valueOf(paramBallInfo.nno) });
    if ((paramInt == 1) && (G(paramBallInfo))) {
      this.oYj = true;
    }
    AppMethodBeat.o(217057);
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
        AppMethodBeat.i(217052);
        d.a(d.this, paramList, paramBallInfo);
        AppMethodBeat.o(217052);
      }
    });
    AppMethodBeat.o(106313);
  }
  
  public final void a(final boolean paramBoolean, final ResultReceiver paramResultReceiver)
  {
    AppMethodBeat.i(217053);
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(106305);
        if (d.this.ciY())
        {
          a locala = d.a(d.this);
          boolean bool = paramBoolean;
          ResultReceiver localResultReceiver = paramResultReceiver;
          locala.oXL.iOB = Util.nowMilliSecond();
          if ((locala.oXH != null) && (locala.oXI != null))
          {
            locala.oXH.b(false, null);
            locala.oXI.setInLongPressMode(false);
            locala.oXI.setForceShowFloatMenu(true);
            locala.oXI.c(localResultReceiver);
            locala.oXM = bool;
          }
        }
        AppMethodBeat.o(106305);
      }
    });
    AppMethodBeat.o(217053);
  }
  
  public final void b(int paramInt, BallInfo paramBallInfo)
  {
    AppMethodBeat.i(217058);
    Log.v("MicroMsg.FloatBallUIManager", "alvinluo onFloatBallRemoved size: %d, state: %d, hidden: %b", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramBallInfo.state), Boolean.valueOf(paramBallInfo.nno) });
    if ((paramInt == 0) && (ciY()) && (G(paramBallInfo))) {
      this.oYj = true;
    }
    AppMethodBeat.o(217058);
  }
  
  public final void b(final boolean paramBoolean1, final boolean paramBoolean2, final AnimatorListenerAdapter paramAnimatorListenerAdapter)
  {
    AppMethodBeat.i(184617);
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(106308);
        if (d.this.ciY())
        {
          a locala = d.a(d.this);
          boolean bool1 = paramBoolean1;
          boolean bool2 = paramBoolean2;
          AnimatorListenerAdapter localAnimatorListenerAdapter = paramAnimatorListenerAdapter;
          if (locala.oXH != null)
          {
            Log.i("MicroMsg.FloatBallContainer", "resume FloatBallView, animation:%s", new Object[] { Boolean.valueOf(bool1) });
            locala.oXH.c(bool1, bool2, localAnimatorListenerAdapter);
          }
          if (locala.oXI != null)
          {
            Log.i("MicroMsg.FloatBallContainer", "quickHide FloatMenuView");
            locala.oXI.e(localAnimatorListenerAdapter);
          }
        }
        AppMethodBeat.o(106308);
      }
    });
    AppMethodBeat.o(184617);
  }
  
  public final void c(final boolean paramBoolean, final AnimatorListenerAdapter paramAnimatorListenerAdapter)
  {
    AppMethodBeat.i(217054);
    if (Looper.getMainLooper() == Looper.myLooper())
    {
      d(paramBoolean, paramAnimatorListenerAdapter);
      AppMethodBeat.o(217054);
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
    AppMethodBeat.o(217054);
  }
  
  public final void ciS()
  {
    AppMethodBeat.i(176971);
    if (ciY())
    {
      this.oYi.ciS();
      AppMethodBeat.o(176971);
      return;
    }
    Log.w("MicroMsg.FloatBallUIManager", "clearVOIPView, container is null");
    AppMethodBeat.o(176971);
  }
  
  public final boolean ciT()
  {
    AppMethodBeat.i(106310);
    if (ciY())
    {
      boolean bool = this.oYi.ciT();
      AppMethodBeat.o(106310);
      return bool;
    }
    AppMethodBeat.o(106310);
    return false;
  }
  
  public final boolean ciY()
  {
    return this.oYi != null;
  }
  
  public final void ciZ()
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
        if (d.this.ciY())
        {
          d.c(d.this);
          localObject = d.a(d.this);
          if ((((a)localObject).oXH.getVisibility() != 0) && (((a)localObject).oXI.getVisibility() != 0)) {
            break label193;
          }
          if (((a)localObject).oXH.getVisibility() != 0) {
            break label200;
          }
          bool = ((a)localObject).oXH.oYj;
          Log.i("MicroMsg.FloatBallContainer", "detachFromWindow, hide floatBallView, needTranslateAnimation: %b", new Object[] { Boolean.valueOf(bool) });
          if (!bool) {
            break label184;
          }
          localFloatBallView = ((a)localObject).oXH;
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
          if (localFloatBallView.paV != null)
          {
            bool = localFloatBallView.BT(((WindowManager.LayoutParams)localFloatBallView.getLayoutParams()).x);
            localFloatBallView.paV.b(localFloatBallView.getCurrentStateWidth(), bool, (AnimatorListenerAdapter)localObject);
          }
        }
        label184:
        ((a)localObject).oXH.b(false, null);
        for (;;)
        {
          label193:
          ((a)localObject).ciW();
          break;
          label200:
          if (((a)localObject).oXI.getVisibility() != 0) {
            break;
          }
          Log.i("MicroMsg.FloatBallContainer", "detachFromWindow, hide floatMenuView");
          ((a)localObject).oXL.BF(1);
          ((a)localObject).oXI.setCanAddFloatBallWhenHide(((a)localObject).oXM);
          ((a)localObject).oXM = false;
          ((a)localObject).oXI.e(null);
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
        if (d.this.ciY()) {
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
    if (ciY())
    {
      i = this.oYi.getPositionY();
      AppMethodBeat.o(184615);
      return i;
    }
    int i = com.tencent.mm.plugin.ball.f.d.cjh();
    AppMethodBeat.o(184615);
    return i;
  }
  
  public final void jQ(final boolean paramBoolean)
  {
    AppMethodBeat.i(176970);
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(106303);
        if (d.this.ciY())
        {
          a locala = d.a(d.this);
          boolean bool = paramBoolean;
          if (locala.oXH != null) {
            locala.oXH.jQ(bool);
          }
          if (!bool)
          {
            if (locala.oXI != null) {
              locala.oXI.e(null);
            }
            if (locala.oXH != null) {
              locala.oXH.jQ(bool);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.ball.ui.d
 * JD-Core Version:    0.7.0.1
 */