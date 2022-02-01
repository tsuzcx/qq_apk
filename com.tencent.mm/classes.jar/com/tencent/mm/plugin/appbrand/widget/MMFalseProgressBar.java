package com.tencent.mm.plugin.appbrand.widget;

import android.content.Context;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.widget.ProgressBar;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.ax;

public class MMFalseProgressBar
  extends ProgressBar
{
  private float aaZ;
  private ao mHandler;
  private boolean mIsStart;
  private float msA;
  private float msB;
  private float msC;
  private float msD;
  private boolean msE;
  
  public MMFalseProgressBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public MMFalseProgressBar(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(135398);
    this.mIsStart = false;
    this.aaZ = 0.0F;
    this.msE = true;
    this.mHandler = new ao(Looper.getMainLooper())
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(135397);
        switch (paramAnonymousMessage.what)
        {
        }
        for (;;)
        {
          AppMethodBeat.o(135397);
          return;
          MMFalseProgressBar.a(MMFalseProgressBar.this);
          AppMethodBeat.o(135397);
          return;
          MMFalseProgressBar.b(MMFalseProgressBar.this);
          AppMethodBeat.o(135397);
          return;
          MMFalseProgressBar.c(MMFalseProgressBar.this);
          AppMethodBeat.o(135397);
          return;
          MMFalseProgressBar.d(MMFalseProgressBar.this);
        }
      }
    };
    setMax(1000);
    if (ax.iO(ai.getContext()))
    {
      this.msA = 4.0F;
      this.msB = 1.0F;
      this.msC = 0.3F;
      this.msD = 50.0F;
      AppMethodBeat.o(135398);
      return;
    }
    this.msA = 2.0F;
    this.msB = 0.5F;
    this.msC = 0.15F;
    this.msD = 50.0F;
    AppMethodBeat.o(135398);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.MMFalseProgressBar
 * JD-Core Version:    0.7.0.1
 */