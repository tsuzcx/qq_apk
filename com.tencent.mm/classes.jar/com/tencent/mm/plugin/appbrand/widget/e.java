package com.tencent.mm.plugin.appbrand.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.widget.h.a;

@SuppressLint({"AppCompatCustomView"})
public class e
  extends TextView
  implements com.tencent.mm.plugin.appbrand.jsapi.base.e
{
  private boolean ios;
  private a jan;
  
  public e(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(126658);
    super.setIncludeFontPadding(false);
    super.setLineSpacing(0.0F, 1.0F);
    super.setSpannableFactory(new e.1(this));
    AppMethodBeat.o(126658);
  }
  
  public final boolean aCe()
  {
    return this.ios;
  }
  
  public void setInterceptEvent(boolean paramBoolean)
  {
    this.ios = paramBoolean;
  }
  
  public void setLineHeight(int paramInt)
  {
    AppMethodBeat.i(126659);
    if (this.jan == null) {
      this.jan = new a(paramInt);
    }
    if (!this.jan.aF(paramInt))
    {
      AppMethodBeat.o(126659);
      return;
    }
    invalidate();
    AppMethodBeat.o(126659);
  }
  
  public void setText(CharSequence paramCharSequence, TextView.BufferType paramBufferType)
  {
    AppMethodBeat.i(126660);
    TextView.BufferType localBufferType = paramBufferType;
    if (paramBufferType == TextView.BufferType.NORMAL) {
      localBufferType = TextView.BufferType.SPANNABLE;
    }
    super.setText(paramCharSequence, localBufferType);
    AppMethodBeat.o(126660);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.e
 * JD-Core Version:    0.7.0.1
 */