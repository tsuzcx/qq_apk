package com.tencent.mm.kiss.widget.textview;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Canvas;
import android.util.AttributeSet;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;

public class PLTextView
  extends StaticTextView
{
  private static boolean gHA = false;
  private static long gHs = 0L;
  private static int gHt = 0;
  private static long gHu = -2147483648L;
  private static long gHv = 0L;
  private static int gHw = 0;
  private static long gHx = -2147483648L;
  private static long gHy = 0L;
  private static long gHz;
  private static int gir = 0;
  
  static
  {
    gHz = -2147483648L;
  }
  
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
      getLayoutWrapper().gHR = false;
    }
    AppMethodBeat.o(141026);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(141024);
    long l = 0L;
    if (gHA) {
      l = System.currentTimeMillis();
    }
    super.onDraw(paramCanvas);
    if (gHA)
    {
      l = System.currentTimeMillis() - l;
      gHy += l;
      gir += 1;
      if (l > gHz) {
        gHz = l;
      }
    }
    AppMethodBeat.o(141024);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(141023);
    long l = 0L;
    if (gHA) {
      l = System.currentTimeMillis();
    }
    super.onMeasure(paramInt1, paramInt2);
    if (gHA)
    {
      l = System.currentTimeMillis() - l;
      gHv += l;
      gHw += 1;
      if (l > gHx) {
        gHx = l;
      }
    }
    AppMethodBeat.o(141023);
  }
  
  public void setText(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(141022);
    if (bu.ah(paramCharSequence))
    {
      if (h.DEBUG) {
        ae.d("MicroMsg.PLTextView", "set null text");
      }
      AppMethodBeat.o(141022);
      return;
    }
    long l1 = 0L;
    long l2 = 0L;
    if (h.DEBUG) {
      l1 = System.currentTimeMillis();
    }
    if ((getLayoutWrapper() != null) && (getLayoutWrapper().gHR)) {
      c.gHq.a(getConfig(), getLayoutWrapper());
    }
    f localf = c.gHq.a(getConfig(), paramCharSequence);
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
        ae.d("MicroMsg.PLTextView", "setText used %fms, hitCache: %b, hashCode: %d, text: %s hitCache %s", new Object[] { Double.valueOf((l2 - l1) / 1000000.0D), Boolean.valueOf(bool), Integer.valueOf(hashCode()), paramCharSequence, Boolean.valueOf(bool) });
      }
      if (gHA)
      {
        l1 = l2 - l1;
        gHs += l1;
        gHt += 1;
        if (l1 > gHu) {
          gHu = l1;
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