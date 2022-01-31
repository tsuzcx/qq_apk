package com.tencent.mm.plugin.appbrand.widget.c;

import android.annotation.SuppressLint;
import android.content.Context;
import android.widget.ImageView;
import com.tencent.mm.plugin.appbrand.jsapi.base.e;

@SuppressLint({"AppCompatCustomView"})
class f
  extends ImageView
  implements e
{
  private boolean ios;
  
  public f(Context paramContext)
  {
    super(paramContext);
  }
  
  public boolean aCe()
  {
    return this.ios;
  }
  
  public void setInterceptEvent(boolean paramBoolean)
  {
    this.ios = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.c.f
 * JD-Core Version:    0.7.0.1
 */