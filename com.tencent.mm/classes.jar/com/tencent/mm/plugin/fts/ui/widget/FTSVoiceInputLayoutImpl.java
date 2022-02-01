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
import com.tencent.mm.an.t;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.e;
import com.tencent.mm.plugin.fts.ui.o.d;
import com.tencent.mm.plugin.fts.ui.o.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;

@TargetApi(16)
public class FTSVoiceInputLayoutImpl
  extends VoiceInputLayout
{
  private View BRL;
  private TextView BRM;
  private a BRN;
  private boolean BRO;
  private boolean BRP;
  private long BRQ;
  private View.OnLongClickListener aHT;
  private View.OnTouchListener aIw;
  
  public FTSVoiceInputLayoutImpl(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(112315);
    this.BRO = false;
    this.BRP = false;
    this.aHT = new View.OnLongClickListener()
    {
      public final boolean onLongClick(View paramAnonymousView)
      {
        AppMethodBeat.i(112307);
        b localb = new b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/fts/ui/widget/FTSVoiceInputLayoutImpl$2", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, localb.aFi());
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
    this.aIw = new View.OnTouchListener()
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
            FTSVoiceInputLayoutImpl.this.BTv.SL(12);
          }
          else
          {
            FTSVoiceInputLayoutImpl.b(FTSVoiceInputLayoutImpl.this, false);
            FTSVoiceInputLayoutImpl.a(FTSVoiceInputLayoutImpl.this, false);
            FTSVoiceInputLayoutImpl.a(FTSVoiceInputLayoutImpl.this, Util.currentTicks());
            ((FTSVoiceInputLayoutImpl.a)FTSVoiceInputLayoutImpl.this.BTv).eso();
            Log.d("MicroMsg.FTSVoiceInputLayoutImpl", "btn onTouch ACTION_DOWN currentState %s longClickStartTime %s", new Object[] { Integer.valueOf(FTSVoiceInputLayoutImpl.this.currentState), Long.valueOf(FTSVoiceInputLayoutImpl.c(FTSVoiceInputLayoutImpl.this)) });
            paramAnonymousView = FTSVoiceInputLayoutImpl.b(FTSVoiceInputLayoutImpl.this);
            Log.d("MicroMsg.FTSVoiceInputDrawable", "readyPressState %s", new Object[] { Integer.valueOf(paramAnonymousView.currentState) });
            paramAnonymousView.currentState = 6;
            paramAnonymousView.invalidateSelf();
            FTSVoiceInputLayoutImpl.this.ab(false, false);
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
          FTSVoiceInputLayoutImpl.this.ab(true, false);
          FTSVoiceInputLayoutImpl.a(FTSVoiceInputLayoutImpl.this, false);
          FTSVoiceInputLayoutImpl.a(FTSVoiceInputLayoutImpl.this, 0L);
        }
        for (;;)
        {
          FTSVoiceInputLayoutImpl.g(FTSVoiceInputLayoutImpl.this);
          ((FTSVoiceInputLayoutImpl.a)FTSVoiceInputLayoutImpl.this.BTv).esn();
          break;
          FTSVoiceInputLayoutImpl.this.ab(false, true);
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
    this.BRO = false;
    this.BRP = false;
    this.aHT = new View.OnLongClickListener()
    {
      public final boolean onLongClick(View paramAnonymousView)
      {
        AppMethodBeat.i(112307);
        b localb = new b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/fts/ui/widget/FTSVoiceInputLayoutImpl$2", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, localb.aFi());
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
    this.aIw = new View.OnTouchListener()
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
            FTSVoiceInputLayoutImpl.this.BTv.SL(12);
          }
          else
          {
            FTSVoiceInputLayoutImpl.b(FTSVoiceInputLayoutImpl.this, false);
            FTSVoiceInputLayoutImpl.a(FTSVoiceInputLayoutImpl.this, false);
            FTSVoiceInputLayoutImpl.a(FTSVoiceInputLayoutImpl.this, Util.currentTicks());
            ((FTSVoiceInputLayoutImpl.a)FTSVoiceInputLayoutImpl.this.BTv).eso();
            Log.d("MicroMsg.FTSVoiceInputLayoutImpl", "btn onTouch ACTION_DOWN currentState %s longClickStartTime %s", new Object[] { Integer.valueOf(FTSVoiceInputLayoutImpl.this.currentState), Long.valueOf(FTSVoiceInputLayoutImpl.c(FTSVoiceInputLayoutImpl.this)) });
            paramAnonymousView = FTSVoiceInputLayoutImpl.b(FTSVoiceInputLayoutImpl.this);
            Log.d("MicroMsg.FTSVoiceInputDrawable", "readyPressState %s", new Object[] { Integer.valueOf(paramAnonymousView.currentState) });
            paramAnonymousView.currentState = 6;
            paramAnonymousView.invalidateSelf();
            FTSVoiceInputLayoutImpl.this.ab(false, false);
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
          FTSVoiceInputLayoutImpl.this.ab(true, false);
          FTSVoiceInputLayoutImpl.a(FTSVoiceInputLayoutImpl.this, false);
          FTSVoiceInputLayoutImpl.a(FTSVoiceInputLayoutImpl.this, 0L);
        }
        for (;;)
        {
          FTSVoiceInputLayoutImpl.g(FTSVoiceInputLayoutImpl.this);
          ((FTSVoiceInputLayoutImpl.a)FTSVoiceInputLayoutImpl.this.BTv).esn();
          break;
          FTSVoiceInputLayoutImpl.this.ab(false, true);
        }
      }
    };
    init(paramContext);
    AppMethodBeat.o(112314);
  }
  
  private static boolean dvr()
  {
    AppMethodBeat.i(112321);
    if (((com.tencent.mm.kernel.b.h)com.tencent.mm.kernel.h.aHD().aHf()).aIE())
    {
      boolean bool = esx();
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
  
  private void esw()
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
    esP();
    AppMethodBeat.o(112319);
  }
  
  private static boolean esx()
  {
    AppMethodBeat.i(112320);
    int i = com.tencent.mm.kernel.h.aGY().bih();
    if ((i == 4) || (i == 6))
    {
      AppMethodBeat.o(112320);
      return true;
    }
    AppMethodBeat.o(112320);
    return false;
  }
  
  private void init(Context paramContext)
  {
    AppMethodBeat.i(112316);
    View localView = inflate(paramContext, o.e.fts_voice_input_layout, this);
    this.BRL = localView.findViewById(o.d.voice_search_start_btn);
    this.BRL.setLayerType(1, null);
    this.BRN = new a(paramContext);
    this.BRL.setBackground(this.BRN);
    this.BRL.setEnabled(true);
    this.BRL.setOnTouchListener(this.aIw);
    this.BRL.setOnLongClickListener(this.aHT);
    this.BRM = ((TextView)localView.findViewById(o.d.fts_voice_search_hint));
    reset(true);
    if (isInEditMode())
    {
      AppMethodBeat.o(112316);
      return;
    }
    if (!dvr()) {
      esw();
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
  
  protected final void SM(final int paramInt)
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
        locala.BRu = a.SK(i);
        locala.invalidateSelf();
        locala.BRw = i;
        AppMethodBeat.o(112313);
      }
    });
    AppMethodBeat.o(112325);
  }
  
  public final void ab(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(112318);
    Log.d("MicroMsg.FTSVoiceInputLayoutImpl", "directStart currentState = %s longUp = %s clickUp = %s", new Object[] { Integer.valueOf(this.currentState), Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2) });
    if (this.currentState == 1)
    {
      if ((!paramBoolean1) && (!paramBoolean2))
      {
        esM();
        AppMethodBeat.o(112318);
        return;
      }
      if ((paramBoolean1) && (!paramBoolean2))
      {
        this.BRN.esk();
        AppMethodBeat.o(112318);
      }
    }
    else if (this.currentState == 2)
    {
      if (!paramBoolean2)
      {
        esN();
        AppMethodBeat.o(112318);
        return;
      }
      this.BRN.esk();
      bsc();
      if (this.BRH != null)
      {
        this.BRH.esv();
        AppMethodBeat.o(112318);
      }
    }
    else
    {
      if ((!paramBoolean1) && (!paramBoolean2))
      {
        bsc();
        AppMethodBeat.o(112318);
        return;
      }
      if ((paramBoolean1) && (!paramBoolean2)) {
        this.BRN.esk();
      }
    }
    AppMethodBeat.o(112318);
  }
  
  protected final void esy()
  {
    AppMethodBeat.i(112322);
    runOnUiThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(112310);
        a locala = FTSVoiceInputLayoutImpl.b(FTSVoiceInputLayoutImpl.this);
        boolean bool = this.BRS;
        Log.d("MicroMsg.FTSVoiceInputDrawable", "recordingStartState() called with: maxAmplitudeRate = [%s] fromLongCkick = %s", new Object[] { Integer.valueOf(0), Boolean.valueOf(bool) });
        if (!bool) {
          locala.currentState = 3;
        }
        locala.BRu = a.SK(0);
        locala.invalidateSelf();
        locala.BRw = 0;
        AppMethodBeat.o(112310);
      }
    });
    AppMethodBeat.o(112322);
  }
  
  protected final void esz()
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
        FTSVoiceInputLayoutImpl.b(FTSVoiceInputLayoutImpl.this).esk();
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
    public abstract void esn();
    
    public abstract void eso();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.widget.FTSVoiceInputLayoutImpl
 * JD-Core Version:    0.7.0.1
 */