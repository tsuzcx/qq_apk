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
  private static int fIT = 0;
  private static long ggA;
  private static long ggB;
  private static long ggC = -2147483648L;
  private static boolean ggD = false;
  private static long ggv = 0L;
  private static int ggw = 0;
  private static long ggx = -2147483648L;
  private static long ggy = 0L;
  private static int ggz = 0;
  
  static
  {
    ggA = -2147483648L;
    ggB = 0L;
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
      getLayoutWrapper().ggU = false;
    }
    AppMethodBeat.o(141026);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(141024);
    long l = 0L;
    if (ggD) {
      l = System.currentTimeMillis();
    }
    super.onDraw(paramCanvas);
    if (ggD)
    {
      l = System.currentTimeMillis() - l;
      ggB += l;
      fIT += 1;
      if (l > ggC) {
        ggC = l;
      }
    }
    AppMethodBeat.o(141024);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(141023);
    long l = 0L;
    if (ggD) {
      l = System.currentTimeMillis();
    }
    super.onMeasure(paramInt1, paramInt2);
    if (ggD)
    {
      l = System.currentTimeMillis() - l;
      ggy += l;
      ggz += 1;
      if (l > ggA) {
        ggA = l;
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
    if ((getLayoutWrapper() != null) && (getLayoutWrapper().ggU)) {
      c.ggt.a(getConfig(), getLayoutWrapper());
    }
    f localf = c.ggt.a(getConfig(), paramCharSequence);
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
      if (ggD)
      {
        l1 = l2 - l1;
        ggv += l1;
        ggw += 1;
        if (l1 > ggx) {
          ggx = l1;
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