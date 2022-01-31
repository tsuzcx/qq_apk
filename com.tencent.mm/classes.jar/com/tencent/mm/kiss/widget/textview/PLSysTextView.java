package com.tencent.mm.kiss.widget.textview;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.TextView.BufferType;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

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
    AppMethodBeat.i(105703);
    super.onConfigurationChanged(paramConfiguration);
    if (getLayoutWrapper() != null) {
      getLayoutWrapper().eLO = false;
    }
    AppMethodBeat.o(105703);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(105702);
    super.onDraw(paramCanvas);
    AppMethodBeat.o(105702);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(105701);
    super.onMeasure(paramInt1, paramInt2);
    AppMethodBeat.o(105701);
  }
  
  public boolean onPreDraw()
  {
    return true;
  }
  
  public void setText(CharSequence paramCharSequence, TextView.BufferType paramBufferType)
  {
    AppMethodBeat.i(105700);
    if (bo.aa(paramCharSequence))
    {
      if (h.DEBUG) {
        ab.d("MicroMsg.PLSysTextView", "set null text");
      }
      AppMethodBeat.o(105700);
      return;
    }
    long l = 0L;
    if (h.DEBUG) {
      l = System.currentTimeMillis();
    }
    if ((getLayoutWrapper() != null) && (getLayoutWrapper().eLO)) {
      c.eLm.a(getConfig(), getLayoutWrapper());
    }
    paramBufferType = c.eLm.a(getConfig(), paramCharSequence);
    if (paramBufferType != null) {
      setTextLayout(paramBufferType);
    }
    for (boolean bool = true;; bool = false)
    {
      if (h.DEBUG) {
        ab.d("MicroMsg.PLSysTextView", "setText used %fms, hitCache: %b, hashCode: %d, text: %s", new Object[] { Double.valueOf((System.currentTimeMillis() - l) / 1000000.0D), Boolean.valueOf(bool), Integer.valueOf(hashCode()), paramCharSequence });
      }
      AppMethodBeat.o(105700);
      return;
      super.setText$609c24db(paramCharSequence);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.kiss.widget.textview.PLSysTextView
 * JD-Core Version:    0.7.0.1
 */