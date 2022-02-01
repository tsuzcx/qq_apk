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
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.List;

public class d
  implements e
{
  private static d nhm;
  public volatile boolean ngj = false;
  public a nhn;
  private boolean nho = false;
  
  private static boolean E(BallInfo paramBallInfo)
  {
    return (paramBallInfo.state != 0) && (!paramBallInfo.nfC);
  }
  
  private void b(List<BallInfo> paramList, BallInfo paramBallInfo)
  {
    AppMethodBeat.i(184618);
    try
    {
      if (com.tencent.mm.plugin.ball.f.d.h(paramList))
      {
        if (!bHb())
        {
          ac.i("MicroMsg.FloatBallUIManager", "float ball did not create");
          bHd();
          c(paramList, paramBallInfo);
          AppMethodBeat.o(184618);
          return;
        }
        ac.i("MicroMsg.FloatBallUIManager", "float ball already created");
        c(paramList, paramBallInfo);
        AppMethodBeat.o(184618);
        return;
      }
    }
    catch (Exception paramList)
    {
      ac.e("MicroMsg.FloatBallUIManager", "onFloatBallInfoChangedInternal exp:%s", new Object[] { paramList });
      AppMethodBeat.o(184618);
      return;
    }
    ac.i("MicroMsg.FloatBallUIManager", "empty ball info list");
    bHc();
    AppMethodBeat.o(184618);
  }
  
  private boolean bGY()
  {
    AppMethodBeat.i(208028);
    if ((bHb()) && (this.nhn.bGY()))
    {
      AppMethodBeat.o(208028);
      return true;
    }
    AppMethodBeat.o(208028);
    return false;
  }
  
  /* Error */
  public static d bHa()
  {
    // Byte code:
    //   0: ldc 132
    //   2: invokestatic 61	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: ldc 2
    //   7: monitorenter
    //   8: getstatic 134	com/tencent/mm/plugin/ball/ui/d:nhm	Lcom/tencent/mm/plugin/ball/ui/d;
    //   11: ifnonnull +19 -> 30
    //   14: ldc 2
    //   16: monitorenter
    //   17: new 2	com/tencent/mm/plugin/ball/ui/d
    //   20: dup
    //   21: invokespecial 135	com/tencent/mm/plugin/ball/ui/d:<init>	()V
    //   24: putstatic 134	com/tencent/mm/plugin/ball/ui/d:nhm	Lcom/tencent/mm/plugin/ball/ui/d;
    //   27: ldc 2
    //   29: monitorexit
    //   30: ldc 2
    //   32: monitorexit
    //   33: getstatic 134	com/tencent/mm/plugin/ball/ui/d:nhm	Lcom/tencent/mm/plugin/ball/ui/d;
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
  
  private void bHd()
  {
    AppMethodBeat.i(184619);
    this.nhn = new a(ai.getContext());
    this.nhn.bGX();
    bHe();
    AppMethodBeat.o(184619);
  }
  
  private void bHe()
  {
    AppMethodBeat.i(208031);
    if (this.nho)
    {
      this.nhn.setNeedTranslateAnimation(this.nho);
      this.nho = false;
    }
    AppMethodBeat.o(208031);
  }
  
  private void c(List<BallInfo> paramList, BallInfo paramBallInfo)
  {
    AppMethodBeat.i(184620);
    if (bHb()) {
      this.nhn.a(paramList, paramBallInfo);
    }
    AppMethodBeat.o(184620);
  }
  
  private void d(boolean paramBoolean, AnimatorListenerAdapter paramAnimatorListenerAdapter)
  {
    AppMethodBeat.i(208027);
    if (bHb())
    {
      if (bGY())
      {
        this.nhn.c(paramBoolean, paramAnimatorListenerAdapter);
        AppMethodBeat.o(208027);
        return;
      }
      if (paramAnimatorListenerAdapter != null) {
        paramAnimatorListenerAdapter.onAnimationEnd(null);
      }
    }
    AppMethodBeat.o(208027);
  }
  
  public final void a(int paramInt, BallInfo paramBallInfo)
  {
    AppMethodBeat.i(208029);
    ac.v("MicroMsg.FloatBallUIManager", "alvinluo onFloatBallAdded size: %d, state: %d, hidden: %b", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramBallInfo.state), Boolean.valueOf(paramBallInfo.nfC) });
    if ((paramInt == 1) && (E(paramBallInfo))) {
      this.nho = true;
    }
    AppMethodBeat.o(208029);
  }
  
  public final void a(final List<BallInfo> paramList, final BallInfo paramBallInfo)
  {
    AppMethodBeat.i(106313);
    ac.d("MicroMsg.FloatBallUIManager", "onFloatBallInfoChanged");
    if (Looper.getMainLooper() == Looper.myLooper())
    {
      b(paramList, paramBallInfo);
      AppMethodBeat.o(106313);
      return;
    }
    ap.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(208024);
        d.a(d.this, paramList, paramBallInfo);
        AppMethodBeat.o(208024);
      }
    });
    AppMethodBeat.o(106313);
  }
  
  public final void a(final boolean paramBoolean, final ResultReceiver paramResultReceiver)
  {
    AppMethodBeat.i(208025);
    ap.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(106305);
        if (d.this.bHb())
        {
          a locala = d.a(d.this);
          boolean bool = paramBoolean;
          ResultReceiver localResultReceiver = paramResultReceiver;
          locala.ngR.nfL = bs.eWj();
          if ((locala.ngN != null) && (locala.ngO != null))
          {
            locala.ngN.b(false, null);
            locala.ngO.setInLongPressMode(false);
            locala.ngO.setForceShowFloatMenu(true);
            locala.ngO.c(localResultReceiver);
            locala.ngS = bool;
          }
        }
        AppMethodBeat.o(106305);
      }
    });
    AppMethodBeat.o(208025);
  }
  
  public final void b(int paramInt, BallInfo paramBallInfo)
  {
    AppMethodBeat.i(208030);
    ac.v("MicroMsg.FloatBallUIManager", "alvinluo onFloatBallRemoved size: %d, state: %d, hidden: %b", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramBallInfo.state), Boolean.valueOf(paramBallInfo.nfC) });
    if ((paramInt == 0) && (bHb()) && (E(paramBallInfo))) {
      this.nho = true;
    }
    AppMethodBeat.o(208030);
  }
  
  public final void b(final boolean paramBoolean1, final boolean paramBoolean2, final AnimatorListenerAdapter paramAnimatorListenerAdapter)
  {
    AppMethodBeat.i(184617);
    ap.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(106308);
        if (d.this.bHb())
        {
          a locala = d.a(d.this);
          boolean bool1 = paramBoolean1;
          boolean bool2 = paramBoolean2;
          AnimatorListenerAdapter localAnimatorListenerAdapter = paramAnimatorListenerAdapter;
          if (locala.ngN != null)
          {
            ac.i("MicroMsg.FloatBallContainer", "resume FloatBallView, animation:%s", new Object[] { Boolean.valueOf(bool1) });
            locala.ngN.c(bool1, bool2, localAnimatorListenerAdapter);
          }
          if (locala.ngO != null)
          {
            ac.i("MicroMsg.FloatBallContainer", "quickHide FloatMenuView");
            locala.ngO.d(localAnimatorListenerAdapter);
          }
        }
        AppMethodBeat.o(106308);
      }
    });
    AppMethodBeat.o(184617);
  }
  
  public final void bGV()
  {
    AppMethodBeat.i(176971);
    if (bHb())
    {
      this.nhn.bGV();
      AppMethodBeat.o(176971);
      return;
    }
    ac.w("MicroMsg.FloatBallUIManager", "clearVOIPView, container is null");
    AppMethodBeat.o(176971);
  }
  
  public final boolean bGW()
  {
    AppMethodBeat.i(106310);
    if (bHb())
    {
      boolean bool = this.nhn.bGW();
      AppMethodBeat.o(106310);
      return bool;
    }
    AppMethodBeat.o(106310);
    return false;
  }
  
  public final boolean bHb()
  {
    return this.nhn != null;
  }
  
  public final void bHc()
  {
    AppMethodBeat.i(106312);
    ap.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(176969);
        Object localObject;
        boolean bool;
        FloatBallView localFloatBallView;
        if (d.this.bHb())
        {
          d.c(d.this);
          localObject = d.a(d.this);
          if ((((a)localObject).ngN.getVisibility() != 0) && (((a)localObject).ngO.getVisibility() != 0)) {
            break label193;
          }
          if (((a)localObject).ngN.getVisibility() != 0) {
            break label200;
          }
          bool = ((a)localObject).ngN.nho;
          ac.i("MicroMsg.FloatBallContainer", "detachFromWindow, hide floatBallView, needTranslateAnimation: %b", new Object[] { Boolean.valueOf(bool) });
          if (!bool) {
            break label184;
          }
          localFloatBallView = ((a)localObject).ngN;
          localObject = new a.5((a)localObject);
          ac.i("MicroMsg.FloatBallView", "alvinluo hideByTranslation");
          localFloatBallView.setNeedTranslateAnimation(false);
          if (localFloatBallView.getVisibility() != 8) {
            break label146;
          }
          ac.i("MicroMsg.FloatBallView", "hideByTranslation float ball already hide");
        }
        for (;;)
        {
          d.d(d.this);
          AppMethodBeat.o(176969);
          return;
          label146:
          if (localFloatBallView.nka != null)
          {
            bool = localFloatBallView.xE(((WindowManager.LayoutParams)localFloatBallView.getLayoutParams()).x);
            localFloatBallView.nka.a(localFloatBallView.getCurrentStateWidth(), bool, (AnimatorListenerAdapter)localObject);
          }
        }
        label184:
        ((a)localObject).ngN.b(false, null);
        for (;;)
        {
          label193:
          ((a)localObject).bGZ();
          break;
          label200:
          if (((a)localObject).ngO.getVisibility() != 0) {
            break;
          }
          ac.i("MicroMsg.FloatBallContainer", "detachFromWindow, hide floatMenuView");
          ((a)localObject).ngR.xq(1);
          ((a)localObject).ngO.setCanAddFloatBallWhenHide(((a)localObject).ngS);
          ((a)localObject).ngS = false;
          ((a)localObject).ngO.d(null);
        }
      }
    });
    AppMethodBeat.o(106312);
  }
  
  public final void c(final boolean paramBoolean, final AnimatorListenerAdapter paramAnimatorListenerAdapter)
  {
    AppMethodBeat.i(208026);
    if (Looper.getMainLooper() == Looper.myLooper())
    {
      d(paramBoolean, paramAnimatorListenerAdapter);
      AppMethodBeat.o(208026);
      return;
    }
    ap.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(106306);
        d.a(d.this, paramBoolean, paramAnimatorListenerAdapter);
        AppMethodBeat.o(106306);
      }
    });
    AppMethodBeat.o(208026);
  }
  
  public final void e(final boolean paramBoolean, final AnimatorListenerAdapter paramAnimatorListenerAdapter)
  {
    AppMethodBeat.i(184616);
    ap.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(106307);
        if (d.this.bHb()) {
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
    if (bHb())
    {
      i = this.nhn.getPositionY();
      AppMethodBeat.o(184615);
      return i;
    }
    int i = com.tencent.mm.plugin.ball.f.d.bHk();
    AppMethodBeat.o(184615);
    return i;
  }
  
  public final void iJ(final boolean paramBoolean)
  {
    AppMethodBeat.i(176970);
    ap.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(106303);
        if (d.this.bHb())
        {
          a locala = d.a(d.this);
          boolean bool = paramBoolean;
          if (locala.ngN != null) {
            locala.ngN.iJ(bool);
          }
          if (!bool)
          {
            if (locala.ngO != null) {
              locala.ngO.d(null);
            }
            if (locala.ngN != null) {
              locala.ngN.iJ(bool);
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