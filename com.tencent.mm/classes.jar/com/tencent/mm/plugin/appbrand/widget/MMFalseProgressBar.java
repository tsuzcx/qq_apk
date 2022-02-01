package com.tencent.mm.plugin.appbrand.widget;

import android.content.Context;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.widget.ProgressBar;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.ay;

public class MMFalseProgressBar
  extends ProgressBar
{
  private float aae;
  private float lQA;
  private boolean lQB;
  private float lQx;
  private float lQy;
  private float lQz;
  private ap mHandler;
  private boolean mIsStart;
  
  public MMFalseProgressBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public MMFalseProgressBar(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(135398);
    this.mIsStart = false;
    this.aae = 0.0F;
    this.lQB = true;
    this.mHandler = new ap(Looper.getMainLooper())
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
    if (ay.iD(aj.getContext()))
    {
      this.lQx = 4.0F;
      this.lQy = 1.0F;
      this.lQz = 0.3F;
      this.lQA = 50.0F;
      AppMethodBeat.o(135398);
      return;
    }
    this.lQx = 2.0F;
    this.lQy = 0.5F;
    this.lQz = 0.15F;
    this.lQA = 50.0F;
    AppMethodBeat.o(135398);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.MMFalseProgressBar
 * JD-Core Version:    0.7.0.1
 */