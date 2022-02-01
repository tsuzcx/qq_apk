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
import com.tencent.mm.al.q;
import com.tencent.mm.kernel.b.h;
import com.tencent.mm.kernel.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.bt;

@TargetApi(16)
public class FTSVoiceInputLayoutImpl
  extends VoiceInputLayout
{
  private View.OnLongClickListener aNt;
  private View rxZ;
  private TextView rya;
  private a ryb;
  private boolean ryc;
  private boolean ryd;
  private long rye;
  private View.OnTouchListener ryf;
  
  public FTSVoiceInputLayoutImpl(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(112315);
    this.ryc = false;
    this.ryd = false;
    this.aNt = new View.OnLongClickListener()
    {
      public final boolean onLongClick(View paramAnonymousView)
      {
        AppMethodBeat.i(112307);
        ad.d("MicroMsg.FTSVoiceInputLayoutImpl", "btn onLongClickListener currentState %s", new Object[] { Integer.valueOf(FTSVoiceInputLayoutImpl.this.currentState) });
        FTSVoiceInputLayoutImpl.a(FTSVoiceInputLayoutImpl.this, true);
        paramAnonymousView = FTSVoiceInputLayoutImpl.b(FTSVoiceInputLayoutImpl.this);
        ad.d("MicroMsg.FTSVoiceInputDrawable", "longClickState %s", new Object[] { Integer.valueOf(paramAnonymousView.currentState) });
        paramAnonymousView.currentState = 7;
        paramAnonymousView.invalidateSelf();
        AppMethodBeat.o(112307);
        return true;
      }
    };
    this.ryf = new View.OnTouchListener()
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
          if (!ay.isConnected(FTSVoiceInputLayoutImpl.this.getContext()))
          {
            FTSVoiceInputLayoutImpl.b(FTSVoiceInputLayoutImpl.this, true);
            FTSVoiceInputLayoutImpl.this.rzB.DP(12);
          }
          else
          {
            FTSVoiceInputLayoutImpl.b(FTSVoiceInputLayoutImpl.this, false);
            FTSVoiceInputLayoutImpl.a(FTSVoiceInputLayoutImpl.this, false);
            FTSVoiceInputLayoutImpl.a(FTSVoiceInputLayoutImpl.this, bt.GC());
            ((FTSVoiceInputLayoutImpl.a)FTSVoiceInputLayoutImpl.this.rzB).cyv();
            ad.d("MicroMsg.FTSVoiceInputLayoutImpl", "btn onTouch ACTION_DOWN currentState %s longClickStartTime %s", new Object[] { Integer.valueOf(FTSVoiceInputLayoutImpl.this.currentState), Long.valueOf(FTSVoiceInputLayoutImpl.c(FTSVoiceInputLayoutImpl.this)) });
            paramAnonymousView = FTSVoiceInputLayoutImpl.b(FTSVoiceInputLayoutImpl.this);
            ad.d("MicroMsg.FTSVoiceInputDrawable", "readyPressState %s", new Object[] { Integer.valueOf(paramAnonymousView.currentState) });
            paramAnonymousView.currentState = 6;
            paramAnonymousView.invalidateSelf();
            FTSVoiceInputLayoutImpl.this.M(false, false);
            FTSVoiceInputLayoutImpl.d(FTSVoiceInputLayoutImpl.this);
            continue;
            if (!FTSVoiceInputLayoutImpl.e(FTSVoiceInputLayoutImpl.this)) {
              break;
            }
            FTSVoiceInputLayoutImpl.b(FTSVoiceInputLayoutImpl.this, false);
          }
        }
        ad.d("MicroMsg.FTSVoiceInputLayoutImpl", "btn onTouch ACTION_UP currentState %s longClickDown %s", new Object[] { Integer.valueOf(FTSVoiceInputLayoutImpl.this.currentState), Boolean.valueOf(FTSVoiceInputLayoutImpl.f(FTSVoiceInputLayoutImpl.this)) });
        if (FTSVoiceInputLayoutImpl.f(FTSVoiceInputLayoutImpl.this))
        {
          FTSVoiceInputLayoutImpl.this.M(true, false);
          FTSVoiceInputLayoutImpl.a(FTSVoiceInputLayoutImpl.this, false);
          FTSVoiceInputLayoutImpl.a(FTSVoiceInputLayoutImpl.this, 0L);
        }
        for (;;)
        {
          FTSVoiceInputLayoutImpl.g(FTSVoiceInputLayoutImpl.this);
          ((FTSVoiceInputLayoutImpl.a)FTSVoiceInputLayoutImpl.this.rzB).cyu();
          break;
          FTSVoiceInputLayoutImpl.this.M(false, true);
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
    this.ryc = false;
    this.ryd = false;
    this.aNt = new View.OnLongClickListener()
    {
      public final boolean onLongClick(View paramAnonymousView)
      {
        AppMethodBeat.i(112307);
        ad.d("MicroMsg.FTSVoiceInputLayoutImpl", "btn onLongClickListener currentState %s", new Object[] { Integer.valueOf(FTSVoiceInputLayoutImpl.this.currentState) });
        FTSVoiceInputLayoutImpl.a(FTSVoiceInputLayoutImpl.this, true);
        paramAnonymousView = FTSVoiceInputLayoutImpl.b(FTSVoiceInputLayoutImpl.this);
        ad.d("MicroMsg.FTSVoiceInputDrawable", "longClickState %s", new Object[] { Integer.valueOf(paramAnonymousView.currentState) });
        paramAnonymousView.currentState = 7;
        paramAnonymousView.invalidateSelf();
        AppMethodBeat.o(112307);
        return true;
      }
    };
    this.ryf = new View.OnTouchListener()
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
          if (!ay.isConnected(FTSVoiceInputLayoutImpl.this.getContext()))
          {
            FTSVoiceInputLayoutImpl.b(FTSVoiceInputLayoutImpl.this, true);
            FTSVoiceInputLayoutImpl.this.rzB.DP(12);
          }
          else
          {
            FTSVoiceInputLayoutImpl.b(FTSVoiceInputLayoutImpl.this, false);
            FTSVoiceInputLayoutImpl.a(FTSVoiceInputLayoutImpl.this, false);
            FTSVoiceInputLayoutImpl.a(FTSVoiceInputLayoutImpl.this, bt.GC());
            ((FTSVoiceInputLayoutImpl.a)FTSVoiceInputLayoutImpl.this.rzB).cyv();
            ad.d("MicroMsg.FTSVoiceInputLayoutImpl", "btn onTouch ACTION_DOWN currentState %s longClickStartTime %s", new Object[] { Integer.valueOf(FTSVoiceInputLayoutImpl.this.currentState), Long.valueOf(FTSVoiceInputLayoutImpl.c(FTSVoiceInputLayoutImpl.this)) });
            paramAnonymousView = FTSVoiceInputLayoutImpl.b(FTSVoiceInputLayoutImpl.this);
            ad.d("MicroMsg.FTSVoiceInputDrawable", "readyPressState %s", new Object[] { Integer.valueOf(paramAnonymousView.currentState) });
            paramAnonymousView.currentState = 6;
            paramAnonymousView.invalidateSelf();
            FTSVoiceInputLayoutImpl.this.M(false, false);
            FTSVoiceInputLayoutImpl.d(FTSVoiceInputLayoutImpl.this);
            continue;
            if (!FTSVoiceInputLayoutImpl.e(FTSVoiceInputLayoutImpl.this)) {
              break;
            }
            FTSVoiceInputLayoutImpl.b(FTSVoiceInputLayoutImpl.this, false);
          }
        }
        ad.d("MicroMsg.FTSVoiceInputLayoutImpl", "btn onTouch ACTION_UP currentState %s longClickDown %s", new Object[] { Integer.valueOf(FTSVoiceInputLayoutImpl.this.currentState), Boolean.valueOf(FTSVoiceInputLayoutImpl.f(FTSVoiceInputLayoutImpl.this)) });
        if (FTSVoiceInputLayoutImpl.f(FTSVoiceInputLayoutImpl.this))
        {
          FTSVoiceInputLayoutImpl.this.M(true, false);
          FTSVoiceInputLayoutImpl.a(FTSVoiceInputLayoutImpl.this, false);
          FTSVoiceInputLayoutImpl.a(FTSVoiceInputLayoutImpl.this, 0L);
        }
        for (;;)
        {
          FTSVoiceInputLayoutImpl.g(FTSVoiceInputLayoutImpl.this);
          ((FTSVoiceInputLayoutImpl.a)FTSVoiceInputLayoutImpl.this.rzB).cyu();
          break;
          FTSVoiceInputLayoutImpl.this.M(false, true);
        }
      }
    };
    init(paramContext);
    AppMethodBeat.o(112314);
  }
  
  private void cyD()
  {
    AppMethodBeat.i(112319);
    runOnUiThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(112309);
        a locala = FTSVoiceInputLayoutImpl.b(FTSVoiceInputLayoutImpl.this);
        ad.d("MicroMsg.FTSVoiceInputDrawable", "disableState %s", new Object[] { Integer.valueOf(locala.currentState) });
        locala.currentState = 5;
        locala.invalidateSelf();
        AppMethodBeat.o(112309);
      }
    });
    cyQ();
    AppMethodBeat.o(112319);
  }
  
  private static boolean cyE()
  {
    AppMethodBeat.i(112320);
    int i = g.aeS().auR();
    if ((i == 4) || (i == 6))
    {
      AppMethodBeat.o(112320);
      return true;
    }
    AppMethodBeat.o(112320);
    return false;
  }
  
  private static boolean cyF()
  {
    AppMethodBeat.i(112321);
    if (((h)g.afy().aeZ()).agu())
    {
      boolean bool = cyE();
      AppMethodBeat.o(112321);
      return bool;
    }
    if (ay.isConnected(aj.getContext())) {}
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
    View localView = inflate(paramContext, 2131494221, this);
    this.rxZ = localView.findViewById(2131306533);
    this.rxZ.setLayerType(1, null);
    this.ryb = new a(paramContext);
    this.rxZ.setBackground(this.ryb);
    this.rxZ.setEnabled(true);
    this.rxZ.setOnTouchListener(this.ryf);
    this.rxZ.setOnLongClickListener(this.aNt);
    this.rya = ((TextView)localView.findViewById(2131300319));
    reset(true);
    if (isInEditMode())
    {
      AppMethodBeat.o(112316);
      return;
    }
    if (!cyF()) {
      cyD();
    }
    AppMethodBeat.o(112316);
  }
  
  private static void runOnUiThread(Runnable paramRunnable)
  {
    AppMethodBeat.i(112326);
    if (Thread.currentThread() != Looper.getMainLooper().getThread())
    {
      aq.f(paramRunnable);
      AppMethodBeat.o(112326);
      return;
    }
    paramRunnable.run();
    AppMethodBeat.o(112326);
  }
  
  protected final void DQ(final int paramInt)
  {
    AppMethodBeat.i(112325);
    runOnUiThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(112313);
        a locala = FTSVoiceInputLayoutImpl.b(FTSVoiceInputLayoutImpl.this);
        int i = paramInt;
        ad.d("MicroMsg.FTSVoiceInputDrawable", "recordingState() called with: maxAmplitudeRate = [%s]", new Object[] { Integer.valueOf(i) });
        locala.rxI = a.DO(i);
        locala.invalidateSelf();
        locala.rxK = i;
        AppMethodBeat.o(112313);
      }
    });
    AppMethodBeat.o(112325);
  }
  
  public final void M(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(112318);
    ad.d("MicroMsg.FTSVoiceInputLayoutImpl", "directStart currentState = %s longUp = %s clickUp = %s", new Object[] { Integer.valueOf(this.currentState), Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2) });
    if (this.currentState == 1)
    {
      if ((!paramBoolean1) && (!paramBoolean2))
      {
        cyN();
        AppMethodBeat.o(112318);
        return;
      }
      if ((paramBoolean1) && (!paramBoolean2))
      {
        this.ryb.cyr();
        AppMethodBeat.o(112318);
      }
    }
    else if (this.currentState == 2)
    {
      if (!paramBoolean2)
      {
        cyO();
        AppMethodBeat.o(112318);
        return;
      }
      this.ryb.cyr();
      aDZ();
      if (this.rxV != null)
      {
        this.rxV.cyC();
        AppMethodBeat.o(112318);
      }
    }
    else
    {
      if ((!paramBoolean1) && (!paramBoolean2))
      {
        aDZ();
        AppMethodBeat.o(112318);
        return;
      }
      if ((paramBoolean1) && (!paramBoolean2)) {
        this.ryb.cyr();
      }
    }
    AppMethodBeat.o(112318);
  }
  
  protected final void cyG()
  {
    AppMethodBeat.i(112322);
    runOnUiThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(112310);
        a locala = FTSVoiceInputLayoutImpl.b(FTSVoiceInputLayoutImpl.this);
        boolean bool = this.ryh;
        ad.d("MicroMsg.FTSVoiceInputDrawable", "recordingStartState() called with: maxAmplitudeRate = [%s] fromLongCkick = %s", new Object[] { Integer.valueOf(0), Boolean.valueOf(bool) });
        if (!bool) {
          locala.currentState = 3;
        }
        locala.rxI = a.DO(0);
        locala.invalidateSelf();
        locala.rxK = 0;
        AppMethodBeat.o(112310);
      }
    });
    AppMethodBeat.o(112322);
  }
  
  protected final void cyH()
  {
    AppMethodBeat.i(112323);
    runOnUiThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(112311);
        a locala = FTSVoiceInputLayoutImpl.b(FTSVoiceInputLayoutImpl.this);
        ad.d("MicroMsg.FTSVoiceInputDrawable", "recognizingState %s", new Object[] { Integer.valueOf(locala.currentState) });
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
        FTSVoiceInputLayoutImpl.b(FTSVoiceInputLayoutImpl.this).cyr();
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
    public abstract void cyu();
    
    public abstract void cyv();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.widget.FTSVoiceInputLayoutImpl
 * JD-Core Version:    0.7.0.1
 */