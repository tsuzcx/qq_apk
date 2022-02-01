package com.tencent.mm.plugin.fts.ui.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.t;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.b.h;
import com.tencent.mm.kernel.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;

@TargetApi(16)
public class FTSVoiceInputLayoutImpl
  extends VoiceInputLayout
{
  private View.OnLongClickListener aYy;
  private View.OnTouchListener aZa;
  private View xfA;
  private TextView xfB;
  private a xfC;
  private boolean xfD;
  private boolean xfE;
  private long xfF;
  
  public FTSVoiceInputLayoutImpl(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(112315);
    this.xfD = false;
    this.xfE = false;
    this.aYy = new View.OnLongClickListener()
    {
      public final boolean onLongClick(View paramAnonymousView)
      {
        AppMethodBeat.i(112307);
        b localb = new b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/fts/ui/widget/FTSVoiceInputLayoutImpl$2", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, localb.axR());
        Log.d("MicroMsg.FTSVoiceInputLayoutImpl", "btn onLongClickListener currentState %s", new Object[] { Integer.valueOf(FTSVoiceInputLayoutImpl.this.currentState) });
        FTSVoiceInputLayoutImpl.a(FTSVoiceInputLayoutImpl.this, true);
        paramAnonymousView = FTSVoiceInputLayoutImpl.b(FTSVoiceInputLayoutImpl.this);
        Log.d("MicroMsg.FTSVoiceInputDrawable", "longClickState %s", new Object[] { Integer.valueOf(paramAnonymousView.currentState) });
        paramAnonymousView.currentState = 7;
        paramAnonymousView.invalidateSelf();
        com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/fts/ui/widget/FTSVoiceInputLayoutImpl$2", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
        AppMethodBeat.o(112307);
        return true;
      }
    };
    this.aZa = new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(112308);
        switch (paramAnonymousMotionEvent.getAction())
        {
        }
        for (;;)
        {
          AppMethodBeat.o(112308);
          return false;
          if (!NetStatusUtil.isConnected(FTSVoiceInputLayoutImpl.this.getContext()))
          {
            FTSVoiceInputLayoutImpl.b(FTSVoiceInputLayoutImpl.this, true);
            FTSVoiceInputLayoutImpl.this.xhi.Nx(12);
          }
          else
          {
            FTSVoiceInputLayoutImpl.b(FTSVoiceInputLayoutImpl.this, false);
            FTSVoiceInputLayoutImpl.a(FTSVoiceInputLayoutImpl.this, false);
            FTSVoiceInputLayoutImpl.a(FTSVoiceInputLayoutImpl.this, Util.currentTicks());
            ((FTSVoiceInputLayoutImpl.a)FTSVoiceInputLayoutImpl.this.xhi).dPP();
            Log.d("MicroMsg.FTSVoiceInputLayoutImpl", "btn onTouch ACTION_DOWN currentState %s longClickStartTime %s", new Object[] { Integer.valueOf(FTSVoiceInputLayoutImpl.this.currentState), Long.valueOf(FTSVoiceInputLayoutImpl.c(FTSVoiceInputLayoutImpl.this)) });
            paramAnonymousView = FTSVoiceInputLayoutImpl.b(FTSVoiceInputLayoutImpl.this);
            Log.d("MicroMsg.FTSVoiceInputDrawable", "readyPressState %s", new Object[] { Integer.valueOf(paramAnonymousView.currentState) });
            paramAnonymousView.currentState = 6;
            paramAnonymousView.invalidateSelf();
            FTSVoiceInputLayoutImpl.this.T(false, false);
            FTSVoiceInputLayoutImpl.d(FTSVoiceInputLayoutImpl.this);
            continue;
            if (!FTSVoiceInputLayoutImpl.e(FTSVoiceInputLayoutImpl.this)) {
              break;
            }
            FTSVoiceInputLayoutImpl.b(FTSVoiceInputLayoutImpl.this, false);
          }
        }
        Log.d("MicroMsg.FTSVoiceInputLayoutImpl", "btn onTouch ACTION_UP currentState %s longClickDown %s", new Object[] { Integer.valueOf(FTSVoiceInputLayoutImpl.this.currentState), Boolean.valueOf(FTSVoiceInputLayoutImpl.f(FTSVoiceInputLayoutImpl.this)) });
        if (FTSVoiceInputLayoutImpl.f(FTSVoiceInputLayoutImpl.this))
        {
          FTSVoiceInputLayoutImpl.this.T(true, false);
          FTSVoiceInputLayoutImpl.a(FTSVoiceInputLayoutImpl.this, false);
          FTSVoiceInputLayoutImpl.a(FTSVoiceInputLayoutImpl.this, 0L);
        }
        for (;;)
        {
          FTSVoiceInputLayoutImpl.g(FTSVoiceInputLayoutImpl.this);
          ((FTSVoiceInputLayoutImpl.a)FTSVoiceInputLayoutImpl.this.xhi).dPO();
          break;
          FTSVoiceInputLayoutImpl.this.T(false, true);
        }
      }
    };
    init(paramContext);
    AppMethodBeat.o(112315);
  }
  
  public FTSVoiceInputLayoutImpl(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(112314);
    this.xfD = false;
    this.xfE = false;
    this.aYy = new View.OnLongClickListener()
    {
      public final boolean onLongClick(View paramAnonymousView)
      {
        AppMethodBeat.i(112307);
        b localb = new b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/fts/ui/widget/FTSVoiceInputLayoutImpl$2", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, localb.axR());
        Log.d("MicroMsg.FTSVoiceInputLayoutImpl", "btn onLongClickListener currentState %s", new Object[] { Integer.valueOf(FTSVoiceInputLayoutImpl.this.currentState) });
        FTSVoiceInputLayoutImpl.a(FTSVoiceInputLayoutImpl.this, true);
        paramAnonymousView = FTSVoiceInputLayoutImpl.b(FTSVoiceInputLayoutImpl.this);
        Log.d("MicroMsg.FTSVoiceInputDrawable", "longClickState %s", new Object[] { Integer.valueOf(paramAnonymousView.currentState) });
        paramAnonymousView.currentState = 7;
        paramAnonymousView.invalidateSelf();
        com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/fts/ui/widget/FTSVoiceInputLayoutImpl$2", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
        AppMethodBeat.o(112307);
        return true;
      }
    };
    this.aZa = new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(112308);
        switch (paramAnonymousMotionEvent.getAction())
        {
        }
        for (;;)
        {
          AppMethodBeat.o(112308);
          return false;
          if (!NetStatusUtil.isConnected(FTSVoiceInputLayoutImpl.this.getContext()))
          {
            FTSVoiceInputLayoutImpl.b(FTSVoiceInputLayoutImpl.this, true);
            FTSVoiceInputLayoutImpl.this.xhi.Nx(12);
          }
          else
          {
            FTSVoiceInputLayoutImpl.b(FTSVoiceInputLayoutImpl.this, false);
            FTSVoiceInputLayoutImpl.a(FTSVoiceInputLayoutImpl.this, false);
            FTSVoiceInputLayoutImpl.a(FTSVoiceInputLayoutImpl.this, Util.currentTicks());
            ((FTSVoiceInputLayoutImpl.a)FTSVoiceInputLayoutImpl.this.xhi).dPP();
            Log.d("MicroMsg.FTSVoiceInputLayoutImpl", "btn onTouch ACTION_DOWN currentState %s longClickStartTime %s", new Object[] { Integer.valueOf(FTSVoiceInputLayoutImpl.this.currentState), Long.valueOf(FTSVoiceInputLayoutImpl.c(FTSVoiceInputLayoutImpl.this)) });
            paramAnonymousView = FTSVoiceInputLayoutImpl.b(FTSVoiceInputLayoutImpl.this);
            Log.d("MicroMsg.FTSVoiceInputDrawable", "readyPressState %s", new Object[] { Integer.valueOf(paramAnonymousView.currentState) });
            paramAnonymousView.currentState = 6;
            paramAnonymousView.invalidateSelf();
            FTSVoiceInputLayoutImpl.this.T(false, false);
            FTSVoiceInputLayoutImpl.d(FTSVoiceInputLayoutImpl.this);
            continue;
            if (!FTSVoiceInputLayoutImpl.e(FTSVoiceInputLayoutImpl.this)) {
              break;
            }
            FTSVoiceInputLayoutImpl.b(FTSVoiceInputLayoutImpl.this, false);
          }
        }
        Log.d("MicroMsg.FTSVoiceInputLayoutImpl", "btn onTouch ACTION_UP currentState %s longClickDown %s", new Object[] { Integer.valueOf(FTSVoiceInputLayoutImpl.this.currentState), Boolean.valueOf(FTSVoiceInputLayoutImpl.f(FTSVoiceInputLayoutImpl.this)) });
        if (FTSVoiceInputLayoutImpl.f(FTSVoiceInputLayoutImpl.this))
        {
          FTSVoiceInputLayoutImpl.this.T(true, false);
          FTSVoiceInputLayoutImpl.a(FTSVoiceInputLayoutImpl.this, false);
          FTSVoiceInputLayoutImpl.a(FTSVoiceInputLayoutImpl.this, 0L);
        }
        for (;;)
        {
          FTSVoiceInputLayoutImpl.g(FTSVoiceInputLayoutImpl.this);
          ((FTSVoiceInputLayoutImpl.a)FTSVoiceInputLayoutImpl.this.xhi).dPO();
          break;
          FTSVoiceInputLayoutImpl.this.T(false, true);
        }
      }
    };
    init(paramContext);
    AppMethodBeat.o(112314);
  }
  
  private void dPX()
  {
    AppMethodBeat.i(112319);
    runOnUiThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(112309);
        a locala = FTSVoiceInputLayoutImpl.b(FTSVoiceInputLayoutImpl.this);
        Log.d("MicroMsg.FTSVoiceInputDrawable", "disableState %s", new Object[] { Integer.valueOf(locala.currentState) });
        locala.currentState = 5;
        locala.invalidateSelf();
        AppMethodBeat.o(112309);
      }
    });
    dQp();
    AppMethodBeat.o(112319);
  }
  
  private static boolean dPY()
  {
    AppMethodBeat.i(112320);
    int i = g.azz().aYS();
    if ((i == 4) || (i == 6))
    {
      AppMethodBeat.o(112320);
      return true;
    }
    AppMethodBeat.o(112320);
    return false;
  }
  
  private static boolean dzA()
  {
    AppMethodBeat.i(112321);
    if (((h)g.aAe().azG()).aBb())
    {
      boolean bool = dPY();
      AppMethodBeat.o(112321);
      return bool;
    }
    if (NetStatusUtil.isConnected(MMApplicationContext.getContext())) {}
    for (int i = 6; i == 6; i = 0)
    {
      AppMethodBeat.o(112321);
      return true;
    }
    AppMethodBeat.o(112321);
    return false;
  }
  
  private void init(Context paramContext)
  {
    AppMethodBeat.i(112316);
    View localView = inflate(paramContext, 2131494777, this);
    this.xfA = localView.findViewById(2131309993);
    this.xfA.setLayerType(1, null);
    this.xfC = new a(paramContext);
    this.xfA.setBackground(this.xfC);
    this.xfA.setEnabled(true);
    this.xfA.setOnTouchListener(this.aZa);
    this.xfA.setOnLongClickListener(this.aYy);
    this.xfB = ((TextView)localView.findViewById(2131301812));
    reset(true);
    if (isInEditMode())
    {
      AppMethodBeat.o(112316);
      return;
    }
    if (!dzA()) {
      dPX();
    }
    AppMethodBeat.o(112316);
  }
  
  private static void runOnUiThread(Runnable paramRunnable)
  {
    AppMethodBeat.i(112326);
    if (Thread.currentThread() != Looper.getMainLooper().getThread())
    {
      MMHandlerThread.postToMainThread(paramRunnable);
      AppMethodBeat.o(112326);
      return;
    }
    paramRunnable.run();
    AppMethodBeat.o(112326);
  }
  
  protected final void Ny(final int paramInt)
  {
    AppMethodBeat.i(112325);
    runOnUiThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(112313);
        a locala = FTSVoiceInputLayoutImpl.b(FTSVoiceInputLayoutImpl.this);
        int i = paramInt;
        Log.d("MicroMsg.FTSVoiceInputDrawable", "recordingState() called with: maxAmplitudeRate = [%s]", new Object[] { Integer.valueOf(i) });
        locala.xfj = a.Nw(i);
        locala.invalidateSelf();
        locala.xfl = i;
        AppMethodBeat.o(112313);
      }
    });
    AppMethodBeat.o(112325);
  }
  
  public final void T(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(112318);
    Log.d("MicroMsg.FTSVoiceInputLayoutImpl", "directStart currentState = %s longUp = %s clickUp = %s", new Object[] { Integer.valueOf(this.currentState), Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2) });
    if (this.currentState == 1)
    {
      if ((!paramBoolean1) && (!paramBoolean2))
      {
        dQm();
        AppMethodBeat.o(112318);
        return;
      }
      if ((paramBoolean1) && (!paramBoolean2))
      {
        this.xfC.dPL();
        AppMethodBeat.o(112318);
      }
    }
    else if (this.currentState == 2)
    {
      if (!paramBoolean2)
      {
        dQn();
        AppMethodBeat.o(112318);
        return;
      }
      this.xfC.dPL();
      biE();
      if (this.xfw != null)
      {
        this.xfw.dPW();
        AppMethodBeat.o(112318);
      }
    }
    else
    {
      if ((!paramBoolean1) && (!paramBoolean2))
      {
        biE();
        AppMethodBeat.o(112318);
        return;
      }
      if ((paramBoolean1) && (!paramBoolean2)) {
        this.xfC.dPL();
      }
    }
    AppMethodBeat.o(112318);
  }
  
  protected final void dPZ()
  {
    AppMethodBeat.i(112322);
    runOnUiThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(112310);
        a locala = FTSVoiceInputLayoutImpl.b(FTSVoiceInputLayoutImpl.this);
        boolean bool = this.xfH;
        Log.d("MicroMsg.FTSVoiceInputDrawable", "recordingStartState() called with: maxAmplitudeRate = [%s] fromLongCkick = %s", new Object[] { Integer.valueOf(0), Boolean.valueOf(bool) });
        if (!bool) {
          locala.currentState = 3;
        }
        locala.xfj = a.Nw(0);
        locala.invalidateSelf();
        locala.xfl = 0;
        AppMethodBeat.o(112310);
      }
    });
    AppMethodBeat.o(112322);
  }
  
  protected final void dQa()
  {
    AppMethodBeat.i(112323);
    runOnUiThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(112311);
        a locala = FTSVoiceInputLayoutImpl.b(FTSVoiceInputLayoutImpl.this);
        Log.d("MicroMsg.FTSVoiceInputDrawable", "recognizingState %s", new Object[] { Integer.valueOf(locala.currentState) });
        locala.currentState = 4;
        AppMethodBeat.o(112311);
      }
    });
    AppMethodBeat.o(112323);
  }
  
  protected final void onReset()
  {
    AppMethodBeat.i(112324);
    runOnUiThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(112312);
        FTSVoiceInputLayoutImpl.g(FTSVoiceInputLayoutImpl.this);
        FTSVoiceInputLayoutImpl.b(FTSVoiceInputLayoutImpl.this).dPL();
        AppMethodBeat.o(112312);
      }
    });
    AppMethodBeat.o(112324);
  }
  
  public void setFTSVoiceDetectListener(a parama)
  {
    AppMethodBeat.i(112317);
    super.setVoiceDetectListener(parama);
    AppMethodBeat.o(112317);
  }
  
  public static abstract interface a
    extends VoiceInputLayout.b
  {
    public abstract void dPO();
    
    public abstract void dPP();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.widget.FTSVoiceInputLayoutImpl
 * JD-Core Version:    0.7.0.1
 */