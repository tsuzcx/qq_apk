package com.tencent.mm.kiss.widget.textview;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.TextView.BufferType;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;

public class PLSysTextView
  extends SysTextView
{
  public PLSysTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public PLSysTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(141021);
    super.onConfigurationChanged(paramConfiguration);
    if (getLayoutWrapper() != null) {
      getLayoutWrapper().gFk = false;
    }
    AppMethodBeat.o(141021);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(141020);
    super.onDraw(paramCanvas);
    AppMethodBeat.o(141020);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(141019);
    super.onMeasure(paramInt1, paramInt2);
    AppMethodBeat.o(141019);
  }
  
  public boolean onPreDraw()
  {
    return true;
  }
  
  public void setText(CharSequence paramCharSequence, TextView.BufferType paramBufferType)
  {
    AppMethodBeat.i(141018);
    if (bt.ai(paramCharSequence))
    {
      if (h.DEBUG) {
        ad.d("MicroMsg.PLSysTextView", "set null text");
      }
      AppMethodBeat.o(141018);
      return;
    }
    long l = 0L;
    if (h.DEBUG) {
      l = System.currentTimeMillis();
    }
    if ((getLayoutWrapper() != null) && (getLayoutWrapper().gFk)) {
      c.gEJ.a(getConfig(), getLayoutWrapper());
    }
    paramBufferType = c.gEJ.a(getConfig(), paramCharSequence);
    if (paramBufferType != null) {
      setTextLayout(paramBufferType);
    }
    for (boolean bool = true;; bool = false)
    {
      if (h.DEBUG) {
        ad.d("MicroMsg.PLSysTextView", "setText used %fms, hitCache: %b, hashCode: %d, text: %s", new Object[] { Double.valueOf((System.currentTimeMillis() - l) / 1000000.0D), Boolean.valueOf(bool), Integer.valueOf(hashCode()), paramCharSequence });
      }
      AppMethodBeat.o(141018);
      return;
      super.setText$609c24db(paramCharSequence);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.kiss.widget.textview.PLSysTextView
 * JD-Core Version:    0.7.0.1
 */