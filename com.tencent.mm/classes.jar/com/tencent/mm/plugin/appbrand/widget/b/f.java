package com.tencent.mm.plugin.appbrand.widget.b;

import android.annotation.SuppressLint;
import android.content.Context;
import android.widget.ImageView;

@SuppressLint({"AppCompatCustomView"})
class f
  extends ImageView
  implements com.tencent.mm.plugin.appbrand.jsapi.base.f
{
  private boolean lOj;
  
  public f(Context paramContext)
  {
    super(paramContext);
  }
  
  public boolean biZ()
  {
    return this.lOj;
  }
  
  public void setInterceptEvent(boolean paramBoolean)
  {
    this.lOj = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.b.f
 * JD-Core Version:    0.7.0.1
 */