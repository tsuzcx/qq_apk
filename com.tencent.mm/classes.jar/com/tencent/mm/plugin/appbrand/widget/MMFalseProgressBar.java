package com.tencent.mm.plugin.appbrand.widget;

import android.content.Context;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.widget.ProgressBar;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.az;

public class MMFalseProgressBar
  extends ProgressBar
{
  private aq mHandler;
  private boolean mIsStart;
  private float mProgress;
  private float mYo;
  private float mYp;
  private float mYq;
  private float mYr;
  private boolean mYs;
  
  public MMFalseProgressBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public MMFalseProgressBar(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(135398);
    this.mIsStart = false;
    this.mProgress = 0.0F;
    this.mYs = true;
    this.mHandler = new aq(Looper.getMainLooper())
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
    if (az.jd(ak.getContext()))
    {
      this.mYo = 4.0F;
      this.mYp = 1.0F;
      this.mYq = 0.3F;
      this.mYr = 50.0F;
      AppMethodBeat.o(135398);
      return;
    }
    this.mYo = 2.0F;
    this.mYp = 0.5F;
    this.mYq = 0.15F;
    this.mYr = 50.0F;
    AppMethodBeat.o(135398);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.MMFalseProgressBar
 * JD-Core Version:    0.7.0.1
 */