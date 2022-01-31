package com.tencent.mm.kiss.widget.textview;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Canvas;
import android.util.AttributeSet;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public class PLTextView
  extends StaticTextView
{
  private static long eLo = 0L;
  private static int eLp = 0;
  private static long eLq = -2147483648L;
  private static long eLr = 0L;
  private static int eLs = 0;
  private static long eLt = -2147483648L;
  private static long eLu = 0L;
  private static int eLv = 0;
  private static long eLw = -2147483648L;
  private static boolean eLx = false;
  
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
    AppMethodBeat.i(105708);
    super.onConfigurationChanged(paramConfiguration);
    if (getLayoutWrapper() != null) {
      getLayoutWrapper().eLO = false;
    }
    AppMethodBeat.o(105708);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(105706);
    long l = 0L;
    if (eLx) {
      l = System.currentTimeMillis();
    }
    super.onDraw(paramCanvas);
    if (eLx)
    {
      l = System.currentTimeMillis() - l;
      eLu += l;
      eLv += 1;
      if (l > eLw) {
        eLw = l;
      }
    }
    AppMethodBeat.o(105706);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(105705);
    long l = 0L;
    if (eLx) {
      l = System.currentTimeMillis();
    }
    super.onMeasure(paramInt1, paramInt2);
    if (eLx)
    {
      l = System.currentTimeMillis() - l;
      eLr += l;
      eLs += 1;
      if (l > eLt) {
        eLt = l;
      }
    }
    AppMethodBeat.o(105705);
  }
  
  public void setText(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(105704);
    if (bo.aa(paramCharSequence))
    {
      if (h.DEBUG) {
        ab.d("MicroMsg.PLTextView", "set null text");
      }
      AppMethodBeat.o(105704);
      return;
    }
    long l1 = 0L;
    long l2 = 0L;
    if (h.DEBUG) {
      l1 = System.currentTimeMillis();
    }
    if ((getLayoutWrapper() != null) && (getLayoutWrapper().eLO)) {
      c.eLm.a(getConfig(), getLayoutWrapper());
    }
    f localf = c.eLm.a(getConfig(), paramCharSequence);
    boolean bool;
    if (localf != null)
    {
      bool = true;
      u(paramCharSequence);
      setTextLayout(localf);
    }
    for (;;)
    {
      if (h.DEBUG)
      {
        l2 = System.currentTimeMillis();
        ab.d("MicroMsg.PLTextView", "setText used %fms, hitCache: %b, hashCode: %d, text: %s hitCache %s", new Object[] { Double.valueOf((l2 - l1) / 1000000.0D), Boolean.valueOf(bool), Integer.valueOf(hashCode()), paramCharSequence, Boolean.valueOf(bool) });
      }
      if (eLx)
      {
        l1 = l2 - l1;
        eLo += l1;
        eLp += 1;
        if (l1 > eLq) {
          eLq = l1;
        }
      }
      AppMethodBeat.o(105704);
      return;
      bool = false;
      t(paramCharSequence);
    }
  }
  
  protected void t(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(105707);
    super.setText(paramCharSequence, false);
    AppMethodBeat.o(105707);
  }
  
  protected void u(CharSequence paramCharSequence) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.kiss.widget.textview.PLTextView
 * JD-Core Version:    0.7.0.1
 */