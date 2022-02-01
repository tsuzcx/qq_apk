package com.tencent.mm.kiss.widget.textview;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Canvas;
import android.util.AttributeSet;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;

public class PLTextView
  extends StaticTextView
{
  private static long gEL = 0L;
  private static int gEM = 0;
  private static long gEN = -2147483648L;
  private static long gEO = 0L;
  private static int gEP = 0;
  private static long gEQ = -2147483648L;
  private static long gER = 0L;
  private static long gES = -2147483648L;
  private static boolean gET = false;
  private static int gfZ = 0;
  
  public PLTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public PLTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(141026);
    super.onConfigurationChanged(paramConfiguration);
    if (getLayoutWrapper() != null) {
      getLayoutWrapper().gFk = false;
    }
    AppMethodBeat.o(141026);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(141024);
    long l = 0L;
    if (gET) {
      l = System.currentTimeMillis();
    }
    super.onDraw(paramCanvas);
    if (gET)
    {
      l = System.currentTimeMillis() - l;
      gER += l;
      gfZ += 1;
      if (l > gES) {
        gES = l;
      }
    }
    AppMethodBeat.o(141024);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(141023);
    long l = 0L;
    if (gET) {
      l = System.currentTimeMillis();
    }
    super.onMeasure(paramInt1, paramInt2);
    if (gET)
    {
      l = System.currentTimeMillis() - l;
      gEO += l;
      gEP += 1;
      if (l > gEQ) {
        gEQ = l;
      }
    }
    AppMethodBeat.o(141023);
  }
  
  public void setText(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(141022);
    if (bt.ai(paramCharSequence))
    {
      if (h.DEBUG) {
        ad.d("MicroMsg.PLTextView", "set null text");
      }
      AppMethodBeat.o(141022);
      return;
    }
    long l1 = 0L;
    long l2 = 0L;
    if (h.DEBUG) {
      l1 = System.currentTimeMillis();
    }
    if ((getLayoutWrapper() != null) && (getLayoutWrapper().gFk)) {
      c.gEJ.a(getConfig(), getLayoutWrapper());
    }
    f localf = c.gEJ.a(getConfig(), paramCharSequence);
    boolean bool;
    if (localf != null)
    {
      bool = true;
      y(paramCharSequence);
      setTextLayout(localf);
    }
    for (;;)
    {
      if (h.DEBUG)
      {
        l2 = System.currentTimeMillis();
        ad.d("MicroMsg.PLTextView", "setText used %fms, hitCache: %b, hashCode: %d, text: %s hitCache %s", new Object[] { Double.valueOf((l2 - l1) / 1000000.0D), Boolean.valueOf(bool), Integer.valueOf(hashCode()), paramCharSequence, Boolean.valueOf(bool) });
      }
      if (gET)
      {
        l1 = l2 - l1;
        gEL += l1;
        gEM += 1;
        if (l1 > gEN) {
          gEN = l1;
        }
      }
      AppMethodBeat.o(141022);
      return;
      bool = false;
      x(paramCharSequence);
    }
  }
  
  protected void x(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(141025);
    super.setText(paramCharSequence, false);
    AppMethodBeat.o(141025);
  }
  
  protected void y(CharSequence paramCharSequence) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.kiss.widget.textview.PLTextView
 * JD-Core Version:    0.7.0.1
 */