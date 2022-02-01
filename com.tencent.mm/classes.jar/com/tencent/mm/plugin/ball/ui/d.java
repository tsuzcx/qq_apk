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
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.List;

public class d
  implements e
{
  private static d nNl;
  public volatile boolean nMh = false;
  public a nNm;
  private boolean nNn = false;
  
  private static boolean H(BallInfo paramBallInfo)
  {
    return (paramBallInfo.state != 0) && (!paramBallInfo.nLv);
  }
  
  private void b(List<BallInfo> paramList, BallInfo paramBallInfo)
  {
    AppMethodBeat.i(184618);
    try
    {
      if (com.tencent.mm.plugin.ball.f.d.h(paramList))
      {
        if (!bMi())
        {
          ae.i("MicroMsg.FloatBallUIManager", "float ball did not create");
          bMk();
          c(paramList, paramBallInfo);
          AppMethodBeat.o(184618);
          return;
        }
        ae.i("MicroMsg.FloatBallUIManager", "float ball already created");
        c(paramList, paramBallInfo);
        AppMethodBeat.o(184618);
        return;
      }
    }
    catch (Exception paramList)
    {
      ae.e("MicroMsg.FloatBallUIManager", "onFloatBallInfoChangedInternal exp:%s", new Object[] { paramList });
      AppMethodBeat.o(184618);
      return;
    }
    ae.i("MicroMsg.FloatBallUIManager", "empty ball info list");
    bMj();
    AppMethodBeat.o(184618);
  }
  
  private boolean bMf()
  {
    AppMethodBeat.i(209502);
    if ((bMi()) && (this.nNm.bMf()))
    {
      AppMethodBeat.o(209502);
      return true;
    }
    AppMethodBeat.o(209502);
    return false;
  }
  
  /* Error */
  public static d bMh()
  {
    // Byte code:
    //   0: ldc 132
    //   2: invokestatic 61	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: ldc 2
    //   7: monitorenter
    //   8: getstatic 134	com/tencent/mm/plugin/ball/ui/d:nNl	Lcom/tencent/mm/plugin/ball/ui/d;
    //   11: ifnonnull +19 -> 30
    //   14: ldc 2
    //   16: monitorenter
    //   17: new 2	com/tencent/mm/plugin/ball/ui/d
    //   20: dup
    //   21: invokespecial 135	com/tencent/mm/plugin/ball/ui/d:<init>	()V
    //   24: putstatic 134	com/tencent/mm/plugin/ball/ui/d:nNl	Lcom/tencent/mm/plugin/ball/ui/d;
    //   27: ldc 2
    //   29: monitorexit
    //   30: ldc 2
    //   32: monitorexit
    //   33: getstatic 134	com/tencent/mm/plugin/ball/ui/d:nNl	Lcom/tencent/mm/plugin/ball/ui/d;
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
  
  private void bMk()
  {
    AppMethodBeat.i(184619);
    this.nNm = new a(ak.getContext());
    this.nNm.bMe();
    bMl();
    AppMethodBeat.o(184619);
  }
  
  private void bMl()
  {
    AppMethodBeat.i(209505);
    if (this.nNn)
    {
      this.nNm.setNeedTranslateAnimation(this.nNn);
      this.nNn = false;
    }
    AppMethodBeat.o(209505);
  }
  
  private void c(List<BallInfo> paramList, BallInfo paramBallInfo)
  {
    AppMethodBeat.i(184620);
    if (bMi()) {
      this.nNm.a(paramList, paramBallInfo);
    }
    AppMethodBeat.o(184620);
  }
  
  private void d(boolean paramBoolean, AnimatorListenerAdapter paramAnimatorListenerAdapter)
  {
    AppMethodBeat.i(209501);
    if (bMi())
    {
      if (bMf())
      {
        this.nNm.c(paramBoolean, paramAnimatorListenerAdapter);
        AppMethodBeat.o(209501);
        return;
      }
      if (paramAnimatorListenerAdapter != null) {
        paramAnimatorListenerAdapter.onAnimationEnd(null);
      }
    }
    AppMethodBeat.o(209501);
  }
  
  public final void a(int paramInt, BallInfo paramBallInfo)
  {
    AppMethodBeat.i(209503);
    ae.v("MicroMsg.FloatBallUIManager", "alvinluo onFloatBallAdded size: %d, state: %d, hidden: %b", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramBallInfo.state), Boolean.valueOf(paramBallInfo.nLv) });
    if ((paramInt == 1) && (H(paramBallInfo))) {
      this.nNn = true;
    }
    AppMethodBeat.o(209503);
  }
  
  public final void a(final List<BallInfo> paramList, final BallInfo paramBallInfo)
  {
    AppMethodBeat.i(106313);
    ae.d("MicroMsg.FloatBallUIManager", "onFloatBallInfoChanged");
    if (Looper.getMainLooper() == Looper.myLooper())
    {
      b(paramList, paramBallInfo);
      AppMethodBeat.o(106313);
      return;
    }
    ar.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(209498);
        d.a(d.this, paramList, paramBallInfo);
        AppMethodBeat.o(209498);
      }
    });
    AppMethodBeat.o(106313);
  }
  
  public final void a(final boolean paramBoolean, final ResultReceiver paramResultReceiver)
  {
    AppMethodBeat.i(209499);
    ar.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(106305);
        if (d.this.bMi())
        {
          a locala = d.a(d.this);
          boolean bool = paramBoolean;
          ResultReceiver localResultReceiver = paramResultReceiver;
          locala.nMP.nLI = bu.fpO();
          if ((locala.nML != null) && (locala.nMM != null))
          {
            locala.nML.b(false, null);
            locala.nMM.setInLongPressMode(false);
            locala.nMM.setForceShowFloatMenu(true);
            locala.nMM.c(localResultReceiver);
            locala.nMQ = bool;
          }
        }
        AppMethodBeat.o(106305);
      }
    });
    AppMethodBeat.o(209499);
  }
  
  public final void b(int paramInt, BallInfo paramBallInfo)
  {
    AppMethodBeat.i(209504);
    ae.v("MicroMsg.FloatBallUIManager", "alvinluo onFloatBallRemoved size: %d, state: %d, hidden: %b", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramBallInfo.state), Boolean.valueOf(paramBallInfo.nLv) });
    if ((paramInt == 0) && (bMi()) && (H(paramBallInfo))) {
      this.nNn = true;
    }
    AppMethodBeat.o(209504);
  }
  
  public final void b(final boolean paramBoolean1, final boolean paramBoolean2, final AnimatorListenerAdapter paramAnimatorListenerAdapter)
  {
    AppMethodBeat.i(184617);
    ar.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(106308);
        if (d.this.bMi())
        {
          a locala = d.a(d.this);
          boolean bool1 = paramBoolean1;
          boolean bool2 = paramBoolean2;
          AnimatorListenerAdapter localAnimatorListenerAdapter = paramAnimatorListenerAdapter;
          if (locala.nML != null)
          {
            ae.i("MicroMsg.FloatBallContainer", "resume FloatBallView, animation:%s", new Object[] { Boolean.valueOf(bool1) });
            locala.nML.c(bool1, bool2, localAnimatorListenerAdapter);
          }
          if (locala.nMM != null)
          {
            ae.i("MicroMsg.FloatBallContainer", "quickHide FloatMenuView");
            locala.nMM.d(localAnimatorListenerAdapter);
          }
        }
        AppMethodBeat.o(106308);
      }
    });
    AppMethodBeat.o(184617);
  }
  
  public final void bMc()
  {
    AppMethodBeat.i(176971);
    if (bMi())
    {
      this.nNm.bMc();
      AppMethodBeat.o(176971);
      return;
    }
    ae.w("MicroMsg.FloatBallUIManager", "clearVOIPView, container is null");
    AppMethodBeat.o(176971);
  }
  
  public final boolean bMd()
  {
    AppMethodBeat.i(106310);
    if (bMi())
    {
      boolean bool = this.nNm.bMd();
      AppMethodBeat.o(106310);
      return bool;
    }
    AppMethodBeat.o(106310);
    return false;
  }
  
  public final boolean bMi()
  {
    return this.nNm != null;
  }
  
  public final void bMj()
  {
    AppMethodBeat.i(106312);
    ar.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(176969);
        Object localObject;
        boolean bool;
        FloatBallView localFloatBallView;
        if (d.this.bMi())
        {
          d.c(d.this);
          localObject = d.a(d.this);
          if ((((a)localObject).nML.getVisibility() != 0) && (((a)localObject).nMM.getVisibility() != 0)) {
            break label193;
          }
          if (((a)localObject).nML.getVisibility() != 0) {
            break label200;
          }
          bool = ((a)localObject).nML.nNn;
          ae.i("MicroMsg.FloatBallContainer", "detachFromWindow, hide floatBallView, needTranslateAnimation: %b", new Object[] { Boolean.valueOf(bool) });
          if (!bool) {
            break label184;
          }
          localFloatBallView = ((a)localObject).nML;
          localObject = new a.5((a)localObject);
          ae.i("MicroMsg.FloatBallView", "alvinluo hideByTranslation");
          localFloatBallView.setNeedTranslateAnimation(false);
          if (localFloatBallView.getVisibility() != 8) {
            break label146;
          }
          ae.i("MicroMsg.FloatBallView", "hideByTranslation float ball already hide");
        }
        for (;;)
        {
          d.d(d.this);
          AppMethodBeat.o(176969);
          return;
          label146:
          if (localFloatBallView.nQc != null)
          {
            bool = localFloatBallView.yn(((WindowManager.LayoutParams)localFloatBallView.getLayoutParams()).x);
            localFloatBallView.nQc.a(localFloatBallView.getCurrentStateWidth(), bool, (AnimatorListenerAdapter)localObject);
          }
        }
        label184:
        ((a)localObject).nML.b(false, null);
        for (;;)
        {
          label193:
          ((a)localObject).bMg();
          break;
          label200:
          if (((a)localObject).nMM.getVisibility() != 0) {
            break;
          }
          ae.i("MicroMsg.FloatBallContainer", "detachFromWindow, hide floatMenuView");
          ((a)localObject).nMP.ya(1);
          ((a)localObject).nMM.setCanAddFloatBallWhenHide(((a)localObject).nMQ);
          ((a)localObject).nMQ = false;
          ((a)localObject).nMM.d(null);
        }
      }
    });
    AppMethodBeat.o(106312);
  }
  
  public final void c(final boolean paramBoolean, final AnimatorListenerAdapter paramAnimatorListenerAdapter)
  {
    AppMethodBeat.i(209500);
    if (Looper.getMainLooper() == Looper.myLooper())
    {
      d(paramBoolean, paramAnimatorListenerAdapter);
      AppMethodBeat.o(209500);
      return;
    }
    ar.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(106306);
        d.a(d.this, paramBoolean, paramAnimatorListenerAdapter);
        AppMethodBeat.o(106306);
      }
    });
    AppMethodBeat.o(209500);
  }
  
  public final void e(final boolean paramBoolean, final AnimatorListenerAdapter paramAnimatorListenerAdapter)
  {
    AppMethodBeat.i(184616);
    ar.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(106307);
        if (d.this.bMi()) {
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
    if (bMi())
    {
      i = this.nNm.getPositionY();
      AppMethodBeat.o(184615);
      return i;
    }
    int i = com.tencent.mm.plugin.ball.f.d.bMr();
    AppMethodBeat.o(184615);
    return i;
  }
  
  public final void iR(final boolean paramBoolean)
  {
    AppMethodBeat.i(176970);
    ar.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(106303);
        if (d.this.bMi())
        {
          a locala = d.a(d.this);
          boolean bool = paramBoolean;
          if (locala.nML != null) {
            locala.nML.iR(bool);
          }
          if (!bool)
          {
            if (locala.nMM != null) {
              locala.nMM.d(null);
            }
            if (locala.nML != null) {
              locala.nML.iR(bool);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.ball.ui.d
 * JD-Core Version:    0.7.0.1
 */