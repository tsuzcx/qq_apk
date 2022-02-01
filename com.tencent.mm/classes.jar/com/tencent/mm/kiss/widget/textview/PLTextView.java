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
  private static int mGA;
  private static long mGB;
  private static long mGC;
  private static int mGD;
  private static long mGE;
  private static long mGF;
  private static long mGG = -2147483648L;
  private static boolean mGH = false;
  private static long mGz = 0L;
  private static int mbS;
  
  static
  {
    mGA = 0;
    mGB = -2147483648L;
    mGC = 0L;
    mGD = 0;
    mGE = -2147483648L;
    mGF = 0L;
    mbS = 0;
  }
  
  public PLTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public PLTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  protected void K(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(141025);
    super.a(paramCharSequence, false);
    AppMethodBeat.o(141025);
  }
  
  protected void L(CharSequence paramCharSequence) {}
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(141026);
    super.onConfigurationChanged(paramConfiguration);
    if (getLayoutWrapper() != null) {
      getLayoutWrapper().mGU = false;
    }
    AppMethodBeat.o(141026);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(141024);
    long l = 0L;
    if (mGH) {
      l = System.currentTimeMillis();
    }
    super.onDraw(paramCanvas);
    if (mGH)
    {
      l = System.currentTimeMillis() - l;
      mGF += l;
      mbS += 1;
      if (l > mGG) {
        mGG = l;
      }
    }
    AppMethodBeat.o(141024);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(141023);
    long l = 0L;
    if (mGH) {
      l = System.currentTimeMillis();
    }
    super.onMeasure(paramInt1, paramInt2);
    if (mGH)
    {
      l = System.currentTimeMillis() - l;
      mGC += l;
      mGD += 1;
      if (l > mGE) {
        mGE = l;
      }
    }
    AppMethodBeat.o(141023);
  }
  
  public void setText(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(141022);
    setContentDescription(paramCharSequence);
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
    if ((getLayoutWrapper() != null) && (getLayoutWrapper().mGU)) {
      c.mGx.a(getConfig(), getLayoutWrapper());
    }
    f localf = c.mGx.a(getConfig(), paramCharSequence);
    boolean bool;
    if (localf != null)
    {
      bool = true;
      L(paramCharSequence);
      setTextLayout(localf);
    }
    for (;;)
    {
      if (h.DEBUG)
      {
        l2 = System.currentTimeMillis();
        Log.d("MicroMsg.PLTextView", "setText used %fms, hitCache: %b, hashCode: %d, text: %s hitCache %s", new Object[] { Double.valueOf((l2 - l1) / 1000000.0D), Boolean.valueOf(bool), Integer.valueOf(hashCode()), paramCharSequence, Boolean.valueOf(bool) });
      }
      if (mGH)
      {
        l1 = l2 - l1;
        mGz += l1;
        mGA += 1;
        if (l1 > mGB) {
          mGB = l1;
        }
      }
      AppMethodBeat.o(141022);
      return;
      bool = false;
      K(paramCharSequence);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.kiss.widget.textview.PLTextView
 * JD-Core Version:    0.7.0.1
 */