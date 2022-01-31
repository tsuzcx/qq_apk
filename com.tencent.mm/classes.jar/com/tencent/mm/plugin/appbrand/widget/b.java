package com.tencent.mm.plugin.appbrand.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.widget.ImageView;
import com.tencent.mm.plugin.appbrand.jsapi.base.e;

@SuppressLint({"AppCompatCustomView"})
public class b
  extends ImageView
  implements e
{
  private boolean hnD;
  
  public b(Context paramContext)
  {
    super(paramContext);
  }
  
  public final boolean ail()
  {
    return this.hnD;
  }
  
  public void setInterceptEvent(boolean paramBoolean)
  {
    this.hnD = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.b
 * JD-Core Version:    0.7.0.1
 */