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
  private static int gRJ = 0;
  private static long hug = 0L;
  private static int huh = 0;
  private static long hui = -2147483648L;
  private static long huj = 0L;
  private static int huk = 0;
  private static long hul = -2147483648L;
  private static long hum = 0L;
  private static long hun = -2147483648L;
  private static boolean huo = false;
  
  public PLTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public PLTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  protected void A(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(141025);
    super.setText(paramCharSequence, false);
    AppMethodBeat.o(141025);
  }
  
  protected void B(CharSequence paramCharSequence) {}
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(141026);
    super.onConfigurationChanged(paramConfiguration);
    if (getLayoutWrapper() != null) {
      getLayoutWrapper().huF = false;
    }
    AppMethodBeat.o(141026);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(141024);
    long l = 0L;
    if (huo) {
      l = System.currentTimeMillis();
    }
    super.onDraw(paramCanvas);
    if (huo)
    {
      l = System.currentTimeMillis() - l;
      hum += l;
      gRJ += 1;
      if (l > hun) {
        hun = l;
      }
    }
    AppMethodBeat.o(141024);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(141023);
    long l = 0L;
    if (huo) {
      l = System.currentTimeMillis();
    }
    super.onMeasure(paramInt1, paramInt2);
    if (huo)
    {
      l = System.currentTimeMillis() - l;
      huj += l;
      huk += 1;
      if (l > hul) {
        hul = l;
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
    if ((getLayoutWrapper() != null) && (getLayoutWrapper().huF)) {
      c.hue.a(getConfig(), getLayoutWrapper());
    }
    f localf = c.hue.a(getConfig(), paramCharSequence);
    boolean bool;
    if (localf != null)
    {
      bool = true;
      B(paramCharSequence);
      setTextLayout(localf);
    }
    for (;;)
    {
      if (h.DEBUG)
      {
        l2 = System.currentTimeMillis();
        Log.d("MicroMsg.PLTextView", "setText used %fms, hitCache: %b, hashCode: %d, text: %s hitCache %s", new Object[] { Double.valueOf((l2 - l1) / 1000000.0D), Boolean.valueOf(bool), Integer.valueOf(hashCode()), paramCharSequence, Boolean.valueOf(bool) });
      }
      if (huo)
      {
        l1 = l2 - l1;
        hug += l1;
        huh += 1;
        if (l1 > hui) {
          hui = l1;
        }
      }
      AppMethodBeat.o(141022);
      return;
      bool = false;
      A(paramCharSequence);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.kiss.widget.textview.PLTextView
 * JD-Core Version:    0.7.0.1
 */