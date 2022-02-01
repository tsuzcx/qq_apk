package com.tencent.mm.kiss.widget.textview;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Canvas;
import android.util.AttributeSet;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;

public class PLTextView
  extends StaticTextView
{
  private static int fMz = 0;
  private static long glb = 0L;
  private static int glc = 0;
  private static long gld = -2147483648L;
  private static long gle = 0L;
  private static int glf = 0;
  private static long glg = -2147483648L;
  private static long glh = 0L;
  private static long gli = -2147483648L;
  private static boolean glj = false;
  
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
      getLayoutWrapper().glA = false;
    }
    AppMethodBeat.o(141026);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(141024);
    long l = 0L;
    if (glj) {
      l = System.currentTimeMillis();
    }
    super.onDraw(paramCanvas);
    if (glj)
    {
      l = System.currentTimeMillis() - l;
      glh += l;
      fMz += 1;
      if (l > gli) {
        gli = l;
      }
    }
    AppMethodBeat.o(141024);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(141023);
    long l = 0L;
    if (glj) {
      l = System.currentTimeMillis();
    }
    super.onMeasure(paramInt1, paramInt2);
    if (glj)
    {
      l = System.currentTimeMillis() - l;
      gle += l;
      glf += 1;
      if (l > glg) {
        glg = l;
      }
    }
    AppMethodBeat.o(141023);
  }
  
  public void setText(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(141022);
    if (bs.aj(paramCharSequence))
    {
      if (h.DEBUG) {
        ac.d("MicroMsg.PLTextView", "set null text");
      }
      AppMethodBeat.o(141022);
      return;
    }
    long l1 = 0L;
    long l2 = 0L;
    if (h.DEBUG) {
      l1 = System.currentTimeMillis();
    }
    if ((getLayoutWrapper() != null) && (getLayoutWrapper().glA)) {
      c.gkZ.a(getConfig(), getLayoutWrapper());
    }
    f localf = c.gkZ.a(getConfig(), paramCharSequence);
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
        ac.d("MicroMsg.PLTextView", "setText used %fms, hitCache: %b, hashCode: %d, text: %s hitCache %s", new Object[] { Double.valueOf((l2 - l1) / 1000000.0D), Boolean.valueOf(bool), Integer.valueOf(hashCode()), paramCharSequence, Boolean.valueOf(bool) });
      }
      if (glj)
      {
        l1 = l2 - l1;
        glb += l1;
        glc += 1;
        if (l1 > gld) {
          gld = l1;
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