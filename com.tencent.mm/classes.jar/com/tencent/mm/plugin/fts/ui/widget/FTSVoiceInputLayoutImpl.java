package com.tencent.mm.plugin.fts.ui.widget;

import android.content.Context;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.s;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.kernel.e;
import com.tencent.mm.plugin.fts.ui.p.d;
import com.tencent.mm.plugin.fts.ui.p.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;

public class FTSVoiceInputLayoutImpl
  extends VoiceInputLayout
{
  private View HDt;
  private TextView HDu;
  private b HDv;
  private boolean HDw;
  private boolean HDx;
  private long HDy;
  private View.OnLongClickListener onLongClickListener;
  private View.OnTouchListener onTouchListener;
  
  public FTSVoiceInputLayoutImpl(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(112315);
    this.HDw = false;
    this.HDx = false;
    this.onLongClickListener = new View.OnLongClickListener()
    {
      public final boolean onLongClick(View paramAnonymousView)
      {
        AppMethodBeat.i(112307);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.cH(paramAnonymousView);
        a.c("com/tencent/mm/plugin/fts/ui/widget/FTSVoiceInputLayoutImpl$2", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, localb.aYj());
        Log.d("MicroMsg.FTSVoiceInputLayoutImpl", "btn onLongClickListener currentState %s", new Object[] { Integer.valueOf(FTSVoiceInputLayoutImpl.this.currentState) });
        FTSVoiceInputLayoutImpl.a(FTSVoiceInputLayoutImpl.this, true);
        paramAnonymousView = FTSVoiceInputLayoutImpl.b(FTSVoiceInputLayoutImpl.this);
        Log.d("MicroMsg.FTSVoiceInputDrawable", "longClickState %s", new Object[] { Integer.valueOf(paramAnonymousView.currentState) });
        paramAnonymousView.currentState = 7;
        paramAnonymousView.invalidateSelf();
        a.a(true, this, "com/tencent/mm/plugin/fts/ui/widget/FTSVoiceInputLayoutImpl$2", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
        AppMethodBeat.o(112307);
        return true;
      }
    };
    this.onTouchListener = new View.OnTouchListener()
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
            FTSVoiceInputLayoutImpl.this.HFi.Ws(12);
          }
          else
          {
            FTSVoiceInputLayoutImpl.b(FTSVoiceInputLayoutImpl.this, false);
            FTSVoiceInputLayoutImpl.a(FTSVoiceInputLayoutImpl.this, false);
            FTSVoiceInputLayoutImpl.a(FTSVoiceInputLayoutImpl.this, Util.currentTicks());
            ((FTSVoiceInputLayoutImpl.a)FTSVoiceInputLayoutImpl.this.HFi).fzn();
            Log.d("MicroMsg.FTSVoiceInputLayoutImpl", "btn onTouch ACTION_DOWN currentState %s longClickStartTime %s", new Object[] { Integer.valueOf(FTSVoiceInputLayoutImpl.this.currentState), Long.valueOf(FTSVoiceInputLayoutImpl.c(FTSVoiceInputLayoutImpl.this)) });
            paramAnonymousView = FTSVoiceInputLayoutImpl.b(FTSVoiceInputLayoutImpl.this);
            Log.d("MicroMsg.FTSVoiceInputDrawable", "readyPressState %s", new Object[] { Integer.valueOf(paramAnonymousView.currentState) });
            paramAnonymousView.currentState = 6;
            paramAnonymousView.invalidateSelf();
            FTSVoiceInputLayoutImpl.this.as(false, false);
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
          FTSVoiceInputLayoutImpl.this.as(true, false);
          FTSVoiceInputLayoutImpl.a(FTSVoiceInputLayoutImpl.this, false);
          FTSVoiceInputLayoutImpl.a(FTSVoiceInputLayoutImpl.this, 0L);
        }
        for (;;)
        {
          FTSVoiceInputLayoutImpl.g(FTSVoiceInputLayoutImpl.this);
          ((FTSVoiceInputLayoutImpl.a)FTSVoiceInputLayoutImpl.this.HFi).fzm();
          break;
          FTSVoiceInputLayoutImpl.this.as(false, true);
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
    this.HDw = false;
    this.HDx = false;
    this.onLongClickListener = new View.OnLongClickListener()
    {
      public final boolean onLongClick(View paramAnonymousView)
      {
        AppMethodBeat.i(112307);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.cH(paramAnonymousView);
        a.c("com/tencent/mm/plugin/fts/ui/widget/FTSVoiceInputLayoutImpl$2", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, localb.aYj());
        Log.d("MicroMsg.FTSVoiceInputLayoutImpl", "btn onLongClickListener currentState %s", new Object[] { Integer.valueOf(FTSVoiceInputLayoutImpl.this.currentState) });
        FTSVoiceInputLayoutImpl.a(FTSVoiceInputLayoutImpl.this, true);
        paramAnonymousView = FTSVoiceInputLayoutImpl.b(FTSVoiceInputLayoutImpl.this);
        Log.d("MicroMsg.FTSVoiceInputDrawable", "longClickState %s", new Object[] { Integer.valueOf(paramAnonymousView.currentState) });
        paramAnonymousView.currentState = 7;
        paramAnonymousView.invalidateSelf();
        a.a(true, this, "com/tencent/mm/plugin/fts/ui/widget/FTSVoiceInputLayoutImpl$2", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
        AppMethodBeat.o(112307);
        return true;
      }
    };
    this.onTouchListener = new View.OnTouchListener()
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
            FTSVoiceInputLayoutImpl.this.HFi.Ws(12);
          }
          else
          {
            FTSVoiceInputLayoutImpl.b(FTSVoiceInputLayoutImpl.this, false);
            FTSVoiceInputLayoutImpl.a(FTSVoiceInputLayoutImpl.this, false);
            FTSVoiceInputLayoutImpl.a(FTSVoiceInputLayoutImpl.this, Util.currentTicks());
            ((FTSVoiceInputLayoutImpl.a)FTSVoiceInputLayoutImpl.this.HFi).fzn();
            Log.d("MicroMsg.FTSVoiceInputLayoutImpl", "btn onTouch ACTION_DOWN currentState %s longClickStartTime %s", new Object[] { Integer.valueOf(FTSVoiceInputLayoutImpl.this.currentState), Long.valueOf(FTSVoiceInputLayoutImpl.c(FTSVoiceInputLayoutImpl.this)) });
            paramAnonymousView = FTSVoiceInputLayoutImpl.b(FTSVoiceInputLayoutImpl.this);
            Log.d("MicroMsg.FTSVoiceInputDrawable", "readyPressState %s", new Object[] { Integer.valueOf(paramAnonymousView.currentState) });
            paramAnonymousView.currentState = 6;
            paramAnonymousView.invalidateSelf();
            FTSVoiceInputLayoutImpl.this.as(false, false);
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
          FTSVoiceInputLayoutImpl.this.as(true, false);
          FTSVoiceInputLayoutImpl.a(FTSVoiceInputLayoutImpl.this, false);
          FTSVoiceInputLayoutImpl.a(FTSVoiceInputLayoutImpl.this, 0L);
        }
        for (;;)
        {
          FTSVoiceInputLayoutImpl.g(FTSVoiceInputLayoutImpl.this);
          ((FTSVoiceInputLayoutImpl.a)FTSVoiceInputLayoutImpl.this.HFi).fzm();
          break;
          FTSVoiceInputLayoutImpl.this.as(false, true);
        }
      }
    };
    init(paramContext);
    AppMethodBeat.o(112314);
  }
  
  private static boolean efl()
  {
    AppMethodBeat.i(112321);
    if (((com.tencent.mm.kernel.b.h)com.tencent.mm.kernel.h.baB().bad()).bbA())
    {
      boolean bool = fzw();
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
  
  private void fzv()
  {
    AppMethodBeat.i(112319);
    runOnUiThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(112309);
        b localb = FTSVoiceInputLayoutImpl.b(FTSVoiceInputLayoutImpl.this);
        Log.d("MicroMsg.FTSVoiceInputDrawable", "disableState %s", new Object[] { Integer.valueOf(localb.currentState) });
        localb.currentState = 5;
        localb.invalidateSelf();
        AppMethodBeat.o(112309);
      }
    });
    fzJ();
    AppMethodBeat.o(112319);
  }
  
  private static boolean fzw()
  {
    AppMethodBeat.i(112320);
    int i = com.tencent.mm.kernel.h.aZW().bFQ();
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
    View localView = inflate(paramContext, p.e.fts_voice_input_layout, this);
    this.HDt = localView.findViewById(p.d.voice_search_start_btn);
    this.HDt.setLayerType(1, null);
    this.HDv = new b(paramContext);
    this.HDt.setBackground(this.HDv);
    this.HDt.setEnabled(true);
    this.HDt.setOnTouchListener(this.onTouchListener);
    this.HDt.setOnLongClickListener(this.onLongClickListener);
    this.HDu = ((TextView)localView.findViewById(p.d.fts_voice_search_hint));
    reset(true);
    if (isInEditMode())
    {
      AppMethodBeat.o(112316);
      return;
    }
    if (!efl()) {
      fzv();
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
  
  protected final void Wt(final int paramInt)
  {
    AppMethodBeat.i(112325);
    runOnUiThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(112313);
        b localb = FTSVoiceInputLayoutImpl.b(FTSVoiceInputLayoutImpl.this);
        int i = paramInt;
        Log.d("MicroMsg.FTSVoiceInputDrawable", "recordingState() called with: maxAmplitudeRate = [%s]", new Object[] { Integer.valueOf(i) });
        localb.HDc = b.Wr(i);
        localb.invalidateSelf();
        localb.HDe = i;
        AppMethodBeat.o(112313);
      }
    });
    AppMethodBeat.o(112325);
  }
  
  public final void as(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(112318);
    Log.d("MicroMsg.FTSVoiceInputLayoutImpl", "directStart currentState = %s longUp = %s clickUp = %s", new Object[] { Integer.valueOf(this.currentState), Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2) });
    if (this.currentState == 1)
    {
      if ((!paramBoolean1) && (!paramBoolean2))
      {
        fzF();
        AppMethodBeat.o(112318);
        return;
      }
      if ((paramBoolean1) && (!paramBoolean2))
      {
        this.HDv.fzj();
        AppMethodBeat.o(112318);
      }
    }
    else if (this.currentState == 2)
    {
      if (!paramBoolean2)
      {
        fzH();
        AppMethodBeat.o(112318);
        return;
      }
      this.HDv.fzj();
      bPI();
      if (this.HDp != null)
      {
        this.HDp.fzu();
        AppMethodBeat.o(112318);
      }
    }
    else
    {
      if ((!paramBoolean1) && (!paramBoolean2))
      {
        bPI();
        AppMethodBeat.o(112318);
        return;
      }
      if ((paramBoolean1) && (!paramBoolean2)) {
        this.HDv.fzj();
      }
    }
    AppMethodBeat.o(112318);
  }
  
  protected final void fzx()
  {
    AppMethodBeat.i(112322);
    runOnUiThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(112310);
        b localb = FTSVoiceInputLayoutImpl.b(FTSVoiceInputLayoutImpl.this);
        boolean bool = this.HDA;
        Log.d("MicroMsg.FTSVoiceInputDrawable", "recordingStartState() called with: maxAmplitudeRate = [%s] fromLongCkick = %s", new Object[] { Integer.valueOf(0), Boolean.valueOf(bool) });
        if (!bool) {
          localb.currentState = 3;
        }
        localb.HDc = b.Wr(0);
        localb.invalidateSelf();
        localb.HDe = 0;
        AppMethodBeat.o(112310);
      }
    });
    AppMethodBeat.o(112322);
  }
  
  protected final void fzy()
  {
    AppMethodBeat.i(112323);
    runOnUiThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(112311);
        b localb = FTSVoiceInputLayoutImpl.b(FTSVoiceInputLayoutImpl.this);
        Log.d("MicroMsg.FTSVoiceInputDrawable", "recognizingState %s", new Object[] { Integer.valueOf(localb.currentState) });
        localb.currentState = 4;
        AppMethodBeat.o(112311);
      }
    });
    AppMethodBeat.o(112323);
  }
  
  public b getVoiceInputDrawable()
  {
    return this.HDv;
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
        FTSVoiceInputLayoutImpl.b(FTSVoiceInputLayoutImpl.this).fzj();
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
    public abstract void fzm();
    
    public abstract void fzn();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.widget.FTSVoiceInputLayoutImpl
 * JD-Core Version:    0.7.0.1
 */