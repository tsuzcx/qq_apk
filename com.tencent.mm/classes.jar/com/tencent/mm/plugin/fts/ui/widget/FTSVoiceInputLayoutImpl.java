package com.tencent.mm.plugin.fts.ui.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import android.widget.TextView;
import com.tencent.mm.ah.p;
import com.tencent.mm.kernel.b.h;
import com.tencent.mm.kernel.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fts.ui.n.d;
import com.tencent.mm.plugin.fts.ui.n.e;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.y;

@TargetApi(16)
public class FTSVoiceInputLayoutImpl
  extends VoiceInputLayout
{
  private View.OnLongClickListener aqp = new FTSVoiceInputLayoutImpl.1(this);
  private View kFk;
  private TextView kFl;
  private c kFm;
  private boolean kFn = false;
  private long kFo;
  private FTSVoiceInputLayoutImpl.a kFp;
  private View.OnTouchListener kFq = new FTSVoiceInputLayoutImpl.2(this);
  private View.OnClickListener kFr = new FTSVoiceInputLayoutImpl.3(this);
  
  public FTSVoiceInputLayoutImpl(Context paramContext)
  {
    super(paramContext);
    init(paramContext);
  }
  
  public FTSVoiceInputLayoutImpl(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init(paramContext);
  }
  
  public FTSVoiceInputLayoutImpl(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init(paramContext);
  }
  
  private void init(Context paramContext)
  {
    View localView = inflate(paramContext, n.e.fts_voice_input_layout, this);
    this.kFk = localView.findViewById(n.d.voice_search_start_btn);
    this.kFk.setLayerType(1, null);
    this.kFm = new c(paramContext);
    this.kFk.setBackground(this.kFm);
    this.kFk.setEnabled(true);
    this.kFk.setOnTouchListener(this.kFq);
    this.kFk.setOnLongClickListener(this.aqp);
    this.kFl = ((TextView)localView.findViewById(n.d.fts_voice_search_hint));
    localView.findViewById(n.d.fts_voice_close_btn1).setOnClickListener(this.kFr);
    reset(true);
    if (isInEditMode()) {}
    for (;;)
    {
      return;
      int i;
      if (((h)g.DM().Dr()).Ex())
      {
        i = g.Dk().KG();
        if ((i == 4) || (i == 6)) {
          i = 1;
        }
      }
      while (i == 0)
      {
        runOnUiThread(new FTSVoiceInputLayoutImpl.4(this));
        I(12, -1, -1);
        return;
        i = 0;
        continue;
        if (aq.isConnected(ae.getContext())) {}
        for (i = 6;; i = 0)
        {
          if (i != 6) {
            break label215;
          }
          i = 1;
          break;
        }
        label215:
        i = 0;
      }
    }
  }
  
  private static void runOnUiThread(Runnable paramRunnable)
  {
    if (Thread.currentThread() != Looper.getMainLooper().getThread())
    {
      ai.d(paramRunnable);
      return;
    }
    paramRunnable.run();
  }
  
  protected final void aWS()
  {
    runOnUiThread(new FTSVoiceInputLayoutImpl.5(this));
  }
  
  protected final void aWT()
  {
    runOnUiThread(new FTSVoiceInputLayoutImpl.6(this));
  }
  
  protected final void onReset()
  {
    runOnUiThread(new FTSVoiceInputLayoutImpl.7(this));
  }
  
  protected final void rH(int paramInt)
  {
    runOnUiThread(new FTSVoiceInputLayoutImpl.8(this, paramInt));
  }
  
  public void setCloseListener(FTSVoiceInputLayoutImpl.a parama)
  {
    this.kFp = parama;
  }
  
  public final void y(boolean paramBoolean1, boolean paramBoolean2)
  {
    y.d("MicroMsg.VoiceInputLayoutImp", "directStart currentState = %s longUp = %s clickUp = %s", new Object[] { Integer.valueOf(this.kFU), Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2) });
    if (this.kFU == 1) {
      if ((!paramBoolean1) && (!paramBoolean2)) {
        aWV();
      }
    }
    do
    {
      do
      {
        do
        {
          return;
        } while ((!paramBoolean1) || (paramBoolean2));
        this.kFm.aWU();
        return;
        if (this.kFU != 2) {
          break;
        }
        if (!paramBoolean2)
        {
          aWW();
          return;
        }
        this.kFm.aWU();
        TG();
      } while (this.kFa == null);
      this.kFa.aWR();
      return;
      if ((!paramBoolean1) && (!paramBoolean2))
      {
        TG();
        return;
      }
    } while ((!paramBoolean1) || (paramBoolean2));
    this.kFm.aWU();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.widget.FTSVoiceInputLayoutImpl
 * JD-Core Version:    0.7.0.1
 */