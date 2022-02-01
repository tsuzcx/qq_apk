package com.tencent.mm.plugin.appbrand.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.Spannable;
import android.text.Spannable.Factory;
import android.text.TextUtils;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.widget.g.a;

@SuppressLint({"AppCompatCustomView"})
public class e
  extends TextView
  implements com.tencent.mm.plugin.appbrand.jsapi.base.e
{
  private boolean kPn;
  private a lQh;
  
  public e(Context paramContext)
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
        if ((e.a(e.this) != null) && (!TextUtils.isEmpty(paramAnonymousCharSequence))) {
          paramAnonymousCharSequence.setSpan(e.a(e.this), 0, paramAnonymousCharSequence.length(), 18);
        }
        AppMethodBeat.o(137935);
        return paramAnonymousCharSequence;
      }
    });
    AppMethodBeat.o(137936);
  }
  
  public final boolean aYz()
  {
    return this.kPn;
  }
  
  public void setInterceptEvent(boolean paramBoolean)
  {
    this.kPn = paramBoolean;
  }
  
  public void setLineHeight(int paramInt)
  {
    AppMethodBeat.i(137937);
    if (this.lQh == null) {
      this.lQh = new a(paramInt);
    }
    if (!this.lQh.aI(paramInt))
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.e
 * JD-Core Version:    0.7.0.1
 */