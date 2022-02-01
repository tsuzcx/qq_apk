package com.tencent.mm.plugin.appbrand.widget.b;

import android.annotation.SuppressLint;
import android.content.Context;
import android.widget.ImageView;
import com.tencent.mm.plugin.appbrand.jsapi.base.e;

@SuppressLint({"AppCompatCustomView"})
class f
  extends ImageView
  implements e
{
  private boolean lqM;
  
  public f(Context paramContext)
  {
    super(paramContext);
  }
  
  public boolean bfw()
  {
    return this.lqM;
  }
  
  public void setInterceptEvent(boolean paramBoolean)
  {
    this.lqM = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.b.f
 * JD-Core Version:    0.7.0.1
 */