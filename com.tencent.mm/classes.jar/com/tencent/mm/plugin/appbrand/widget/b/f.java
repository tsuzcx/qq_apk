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
  private boolean kPn;
  
  public f(Context paramContext)
  {
    super(paramContext);
  }
  
  public boolean aYz()
  {
    return this.kPn;
  }
  
  public void setInterceptEvent(boolean paramBoolean)
  {
    this.kPn = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.b.f
 * JD-Core Version:    0.7.0.1
 */