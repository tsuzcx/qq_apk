package com.tencent.mm.plugin.ball.ui;

import android.animation.AnimatorListenerAdapter;
import android.os.Looper;
import android.os.ResultReceiver;
import android.view.WindowManager.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.ball.b.b;
import com.tencent.mm.plugin.ball.c.e;
import com.tencent.mm.plugin.ball.model.BallInfo;
import com.tencent.mm.plugin.ball.view.FloatBallView;
import com.tencent.mm.plugin.ball.view.FloatMenuView;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.List;

public class d
  implements e
{
  private static d mFh;
  public volatile boolean mEd = false;
  public a mFi;
  private boolean mFj = false;
  
  private static boolean E(BallInfo paramBallInfo)
  {
    return (paramBallInfo.state != 0) && (!paramBallInfo.mDv);
  }
  
  private void b(List<BallInfo> paramList, BallInfo paramBallInfo)
  {
    AppMethodBeat.i(184618);
    try
    {
      if (com.tencent.mm.plugin.ball.f.d.h(paramList))
      {
        if (!bAf())
        {
          ad.i("MicroMsg.FloatBallUIManager", "float ball did not create");
          bAh();
          c(paramList, paramBallInfo);
          AppMethodBeat.o(184618);
          return;
        }
        ad.i("MicroMsg.FloatBallUIManager", "float ball already created");
        c(paramList, paramBallInfo);
        AppMethodBeat.o(184618);
        return;
      }
    }
    catch (Exception paramList)
    {
      ad.e("MicroMsg.FloatBallUIManager", "onFloatBallInfoChangedInternal exp:%s", new Object[] { paramList });
      AppMethodBeat.o(184618);
      return;
    }
    ad.i("MicroMsg.FloatBallUIManager", "empty ball info list");
    bAg();
    AppMethodBeat.o(184618);
  }
  
  private boolean bAc()
  {
    AppMethodBeat.i(190663);
    if ((bAf()) && (this.mFi.bAc()))
    {
      AppMethodBeat.o(190663);
      return true;
    }
    AppMethodBeat.o(190663);
    return false;
  }
  
  /* Error */
  public static d bAe()
  {
    // Byte code:
    //   0: ldc 132
    //   2: invokestatic 61	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: ldc 2
    //   7: monitorenter
    //   8: getstatic 134	com/tencent/mm/plugin/ball/ui/d:mFh	Lcom/tencent/mm/plugin/ball/ui/d;
    //   11: ifnonnull +19 -> 30
    //   14: ldc 2
    //   16: monitorenter
    //   17: new 2	com/tencent/mm/plugin/ball/ui/d
    //   20: dup
    //   21: invokespecial 135	com/tencent/mm/plugin/ball/ui/d:<init>	()V
    //   24: putstatic 134	com/tencent/mm/plugin/ball/ui/d:mFh	Lcom/tencent/mm/plugin/ball/ui/d;
    //   27: ldc 2
    //   29: monitorexit
    //   30: ldc 2
    //   32: monitorexit
    //   33: getstatic 134	com/tencent/mm/plugin/ball/ui/d:mFh	Lcom/tencent/mm/plugin/ball/ui/d;
    //   36: astore_0
    //   37: ldc 132
    //   39: invokestatic 68	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   42: aload_0
    //   43: areturn
    //   44: astore_0
    //   45: ldc 2
    //   47: monitorexit
    //   48: ldc 132
    //   50: invokestatic 68	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   53: aload_0
    //   54: athrow
    //   55: astore_0
    //   56: ldc 2
    //   58: monitorexit
    //   59: ldc 132
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
  
  private void bAh()
  {
    AppMethodBeat.i(184619);
    this.mFi = new a(aj.getContext());
    this.mFi.bAb();
    bAi();
    AppMethodBeat.o(184619);
  }
  
  private void bAi()
  {
    AppMethodBeat.i(190666);
    if (this.mFj)
    {
      this.mFi.setNeedTranslateAnimation(this.mFj);
      this.mFj = false;
    }
    AppMethodBeat.o(190666);
  }
  
  private void c(List<BallInfo> paramList, BallInfo paramBallInfo)
  {
    AppMethodBeat.i(184620);
    if (bAf()) {
      this.mFi.a(paramList, paramBallInfo);
    }
    AppMethodBeat.o(184620);
  }
  
  private void d(boolean paramBoolean, AnimatorListenerAdapter paramAnimatorListenerAdapter)
  {
    AppMethodBeat.i(190662);
    if (bAf())
    {
      if (bAc())
      {
        this.mFi.c(paramBoolean, paramAnimatorListenerAdapter);
        AppMethodBeat.o(190662);
        return;
      }
      if (paramAnimatorListenerAdapter != null) {
        paramAnimatorListenerAdapter.onAnimationEnd(null);
      }
    }
    AppMethodBeat.o(190662);
  }
  
  public final void a(int paramInt, BallInfo paramBallInfo)
  {
    AppMethodBeat.i(190664);
    ad.v("MicroMsg.FloatBallUIManager", "alvinluo onFloatBallAdded size: %d, state: %d, hidden: %b", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramBallInfo.state), Boolean.valueOf(paramBallInfo.mDv) });
    if ((paramInt == 1) && (E(paramBallInfo))) {
      this.mFj = true;
    }
    AppMethodBeat.o(190664);
  }
  
  public final void a(final List<BallInfo> paramList, final BallInfo paramBallInfo)
  {
    AppMethodBeat.i(106313);
    ad.d("MicroMsg.FloatBallUIManager", "onFloatBallInfoChanged");
    if (Looper.getMainLooper() == Looper.myLooper())
    {
      b(paramList, paramBallInfo);
      AppMethodBeat.o(106313);
      return;
    }
    aq.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(190659);
        d.a(d.this, paramList, paramBallInfo);
        AppMethodBeat.o(190659);
      }
    });
    AppMethodBeat.o(106313);
  }
  
  public final void a(final boolean paramBoolean, final ResultReceiver paramResultReceiver)
  {
    AppMethodBeat.i(190660);
    aq.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(106305);
        if (d.this.bAf())
        {
          a locala = d.a(d.this);
          boolean bool = paramBoolean;
          ResultReceiver localResultReceiver = paramResultReceiver;
          locala.mEM.mDF = bt.eGO();
          if ((locala.mEI != null) && (locala.mEJ != null))
          {
            locala.mEI.b(false, null);
            locala.mEJ.setInLongPressMode(false);
            locala.mEJ.setForceShowFloatMenu(true);
            locala.mEJ.c(localResultReceiver);
            locala.mEN = bool;
          }
        }
        AppMethodBeat.o(106305);
      }
    });
    AppMethodBeat.o(190660);
  }
  
  public final void b(int paramInt, BallInfo paramBallInfo)
  {
    AppMethodBeat.i(190665);
    ad.v("MicroMsg.FloatBallUIManager", "alvinluo onFloatBallRemoved size: %d, state: %d, hidden: %b", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramBallInfo.state), Boolean.valueOf(paramBallInfo.mDv) });
    if ((paramInt == 0) && (bAf()) && (E(paramBallInfo))) {
      this.mFj = true;
    }
    AppMethodBeat.o(190665);
  }
  
  public final void b(final boolean paramBoolean1, final boolean paramBoolean2, final AnimatorListenerAdapter paramAnimatorListenerAdapter)
  {
    AppMethodBeat.i(184617);
    aq.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(106308);
        if (d.this.bAf())
        {
          a locala = d.a(d.this);
          boolean bool1 = paramBoolean1;
          boolean bool2 = paramBoolean2;
          AnimatorListenerAdapter localAnimatorListenerAdapter = paramAnimatorListenerAdapter;
          if (locala.mEI != null)
          {
            ad.i("MicroMsg.FloatBallContainer", "resume FloatBallView, animation:%s", new Object[] { Boolean.valueOf(bool1) });
            locala.mEI.c(bool1, bool2, localAnimatorListenerAdapter);
          }
          if (locala.mEJ != null)
          {
            ad.i("MicroMsg.FloatBallContainer", "quickHide FloatMenuView");
            locala.mEJ.d(localAnimatorListenerAdapter);
          }
        }
        AppMethodBeat.o(106308);
      }
    });
    AppMethodBeat.o(184617);
  }
  
  public final boolean bAa()
  {
    AppMethodBeat.i(106310);
    if (bAf())
    {
      boolean bool = this.mFi.bAa();
      AppMethodBeat.o(106310);
      return bool;
    }
    AppMethodBeat.o(106310);
    return false;
  }
  
  public final boolean bAf()
  {
    return this.mFi != null;
  }
  
  public final void bAg()
  {
    AppMethodBeat.i(106312);
    aq.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(176969);
        Object localObject;
        boolean bool;
        FloatBallView localFloatBallView;
        if (d.this.bAf())
        {
          d.c(d.this);
          localObject = d.a(d.this);
          if ((((a)localObject).mEI.getVisibility() != 0) && (((a)localObject).mEJ.getVisibility() != 0)) {
            break label193;
          }
          if (((a)localObject).mEI.getVisibility() != 0) {
            break label200;
          }
          bool = ((a)localObject).mEI.mFj;
          ad.i("MicroMsg.FloatBallContainer", "detachFromWindow, hide floatBallView, needTranslateAnimation: %b", new Object[] { Boolean.valueOf(bool) });
          if (!bool) {
            break label184;
          }
          localFloatBallView = ((a)localObject).mEI;
          localObject = new a.5((a)localObject);
          ad.i("MicroMsg.FloatBallView", "alvinluo hideByTranslation");
          localFloatBallView.setNeedTranslateAnimation(false);
          if (localFloatBallView.getVisibility() != 8) {
            break label146;
          }
          ad.i("MicroMsg.FloatBallView", "hideByTranslation float ball already hide");
        }
        for (;;)
        {
          d.d(d.this);
          AppMethodBeat.o(176969);
          return;
          label146:
          if (localFloatBallView.mHV != null)
          {
            bool = localFloatBallView.ut(((WindowManager.LayoutParams)localFloatBallView.getLayoutParams()).x);
            localFloatBallView.mHV.a(localFloatBallView.getCurrentStateWidth(), bool, (AnimatorListenerAdapter)localObject);
          }
        }
        label184:
        ((a)localObject).mEI.b(false, null);
        for (;;)
        {
          label193:
          ((a)localObject).bAd();
          break;
          label200:
          if (((a)localObject).mEJ.getVisibility() != 0) {
            break;
          }
          ad.i("MicroMsg.FloatBallContainer", "detachFromWindow, hide floatMenuView");
          ((a)localObject).mEM.wz(1);
          ((a)localObject).mEJ.setCanAddFloatBallWhenHide(((a)localObject).mEN);
          ((a)localObject).mEN = false;
          ((a)localObject).mEJ.d(null);
        }
      }
    });
    AppMethodBeat.o(106312);
  }
  
  public final void bzZ()
  {
    AppMethodBeat.i(176971);
    if (bAf())
    {
      this.mFi.bzZ();
      AppMethodBeat.o(176971);
      return;
    }
    ad.w("MicroMsg.FloatBallUIManager", "clearVOIPView, container is null");
    AppMethodBeat.o(176971);
  }
  
  public final void c(final boolean paramBoolean, final AnimatorListenerAdapter paramAnimatorListenerAdapter)
  {
    AppMethodBeat.i(190661);
    if (Looper.getMainLooper() == Looper.myLooper())
    {
      d(paramBoolean, paramAnimatorListenerAdapter);
      AppMethodBeat.o(190661);
      return;
    }
    aq.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(106306);
        d.a(d.this, paramBoolean, paramAnimatorListenerAdapter);
        AppMethodBeat.o(106306);
      }
    });
    AppMethodBeat.o(190661);
  }
  
  public final void e(final boolean paramBoolean, final AnimatorListenerAdapter paramAnimatorListenerAdapter)
  {
    AppMethodBeat.i(184616);
    aq.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(106307);
        if (d.this.bAf()) {
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
    if (bAf())
    {
      i = this.mFi.getPositionY();
      AppMethodBeat.o(184615);
      return i;
    }
    int i = com.tencent.mm.plugin.ball.f.d.bAo();
    AppMethodBeat.o(184615);
    return i;
  }
  
  public final void ij(final boolean paramBoolean)
  {
    AppMethodBeat.i(176970);
    aq.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(106303);
        if (d.this.bAf())
        {
          a locala = d.a(d.this);
          boolean bool = paramBoolean;
          if (locala.mEI != null) {
            locala.mEI.ij(bool);
          }
          if (!bool)
          {
            if (locala.mEJ != null) {
              locala.mEJ.d(null);
            }
            if (locala.mEI != null) {
              locala.mEI.ij(bool);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.ball.ui.d
 * JD-Core Version:    0.7.0.1
 */