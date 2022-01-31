package com.tencent.mm.plugin.appbrand.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import com.tencent.mm.plugin.appbrand.jsapi.base.e;
import com.tencent.mm.plugin.appbrand.widget.g.a;

@SuppressLint({"AppCompatCustomView"})
public class f
  extends TextView
  implements e
{
  private boolean hnD;
  private a hob;
  
  public f(Context paramContext)
  {
    super(paramContext);
    super.setIncludeFontPadding(false);
    super.setLineSpacing(0.0F, 1.0F);
    super.setSpannableFactory(new f.1(this));
  }
  
  public final boolean ail()
  {
    return this.hnD;
  }
  
  public void setInterceptEvent(boolean paramBoolean)
  {
    this.hnD = paramBoolean;
  }
  
  public void setLineHeight(int paramInt)
  {
    if (this.hob == null) {
      this.hob = new a(paramInt);
    }
    if (!this.hob.an(paramInt)) {
      return;
    }
    invalidate();
  }
  
  public void setText(CharSequence paramCharSequence, TextView.BufferType paramBufferType)
  {
    TextView.BufferType localBufferType = paramBufferType;
    if (paramBufferType == TextView.BufferType.NORMAL) {
      localBufferType = TextView.BufferType.SPANNABLE;
    }
    super.setText(paramCharSequence, localBufferType);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.f
 * JD-Core Version:    0.7.0.1
 */