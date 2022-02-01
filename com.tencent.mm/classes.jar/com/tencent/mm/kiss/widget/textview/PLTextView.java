package com.tencent.mm.kiss.widget.textview;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Canvas;
import android.util.AttributeSet;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public class PLTextView
  extends StaticTextView
{
  private static int jCf = 0;
  private static long kgb = 0L;
  private static int kgc = 0;
  private static long kgd = -2147483648L;
  private static long kge = 0L;
  private static int kgf = 0;
  private static long kgg = -2147483648L;
  private static long kgh = 0L;
  private static long kgi = -2147483648L;
  private static boolean kgj = false;
  
  public PLTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public PLTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  protected void G(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(141025);
    super.a(paramCharSequence, false);
    AppMethodBeat.o(141025);
  }
  
  protected void H(CharSequence paramCharSequence) {}
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(141026);
    super.onConfigurationChanged(paramConfiguration);
    if (getLayoutWrapper() != null) {
      getLayoutWrapper().kgB = false;
    }
    AppMethodBeat.o(141026);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(141024);
    long l = 0L;
    if (kgj) {
      l = System.currentTimeMillis();
    }
    super.onDraw(paramCanvas);
    if (kgj)
    {
      l = System.currentTimeMillis() - l;
      kgh += l;
      jCf += 1;
      if (l > kgi) {
        kgi = l;
      }
    }
    AppMethodBeat.o(141024);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(141023);
    long l = 0L;
    if (kgj) {
      l = System.currentTimeMillis();
    }
    super.onMeasure(paramInt1, paramInt2);
    if (kgj)
    {
      l = System.currentTimeMillis() - l;
      kge += l;
      kgf += 1;
      if (l > kgg) {
        kgg = l;
      }
    }
    AppMethodBeat.o(141023);
  }
  
  public void setText(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(141022);
    if (Util.isNullOrNil(paramCharSequence))
    {
      if (h.DEBUG) {
        Log.d("MicroMsg.PLTextView", "set null text");
      }
      AppMethodBeat.o(141022);
      return;
    }
    long l1 = 0L;
    long l2 = 0L;
    if (h.DEBUG) {
      l1 = System.currentTimeMillis();
    }
    if ((getLayoutWrapper() != null) && (getLayoutWrapper().kgB)) {
      c.kfZ.a(getConfig(), getLayoutWrapper());
    }
    f localf = c.kfZ.a(getConfig(), paramCharSequence);
    boolean bool;
    if (localf != null)
    {
      bool = true;
      H(paramCharSequence);
      setTextLayout(localf);
    }
    for (;;)
    {
      if (h.DEBUG)
      {
        l2 = System.currentTimeMillis();
        Log.d("MicroMsg.PLTextView", "setText used %fms, hitCache: %b, hashCode: %d, text: %s hitCache %s", new Object[] { Double.valueOf((l2 - l1) / 1000000.0D), Boolean.valueOf(bool), Integer.valueOf(hashCode()), paramCharSequence, Boolean.valueOf(bool) });
      }
      if (kgj)
      {
        l1 = l2 - l1;
        kgb += l1;
        kgc += 1;
        if (l1 > kgd) {
          kgd = l1;
        }
      }
      AppMethodBeat.o(141022);
      return;
      bool = false;
      G(paramCharSequence);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.kiss.widget.textview.PLTextView
 * JD-Core Version:    0.7.0.1
 */