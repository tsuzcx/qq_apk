package com.tencent.mm.plugin.appbrand.widget;

import android.content.Context;
import android.text.Spannable;
import android.text.Spannable.Factory;
import android.text.TextPaint;
import android.text.TextUtils;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.ah.c.a;
import com.tencent.mm.plugin.appbrand.widget.j.a;

public class f
  extends TextView
  implements c.a, com.tencent.mm.plugin.appbrand.jsapi.base.f
{
  private a rTm;
  private boolean tfE;
  
  public f(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(137936);
    super.setIncludeFontPadding(false);
    super.setLineSpacing(0.0F, 1.0F);
    super.setSpannableFactory(new Spannable.Factory()
    {
      public final Spannable newSpannable(CharSequence paramAnonymousCharSequence)
      {
        AppMethodBeat.i(137935);
        paramAnonymousCharSequence = super.newSpannable(paramAnonymousCharSequence);
        if ((f.a(f.this) != null) && (!TextUtils.isEmpty(paramAnonymousCharSequence))) {
          paramAnonymousCharSequence.setSpan(f.a(f.this), 0, paramAnonymousCharSequence.length(), 18);
        }
        AppMethodBeat.o(137935);
        return paramAnonymousCharSequence;
      }
    });
    AppMethodBeat.o(137936);
  }
  
  public final boolean cqz()
  {
    return this.tfE;
  }
  
  public void setFakeBoldText(boolean paramBoolean)
  {
    AppMethodBeat.i(323939);
    getPaint().setFakeBoldText(paramBoolean);
    AppMethodBeat.o(323939);
  }
  
  public void setInterceptEvent(boolean paramBoolean)
  {
    this.tfE = paramBoolean;
  }
  
  public void setLineHeight(int paramInt)
  {
    AppMethodBeat.i(137937);
    if (this.rTm == null) {
      this.rTm = new a(paramInt, 17);
    }
    if (!this.rTm.cb(paramInt))
    {
      AppMethodBeat.o(137937);
      return;
    }
    invalidate();
    AppMethodBeat.o(137937);
  }
  
  public void setText(CharSequence paramCharSequence, TextView.BufferType paramBufferType)
  {
    AppMethodBeat.i(137938);
    TextView.BufferType localBufferType = paramBufferType;
    if (paramBufferType == TextView.BufferType.NORMAL) {
      localBufferType = TextView.BufferType.SPANNABLE;
    }
    super.setText(paramCharSequence, localBufferType);
    AppMethodBeat.o(137938);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.f
 * JD-Core Version:    0.7.0.1
 */