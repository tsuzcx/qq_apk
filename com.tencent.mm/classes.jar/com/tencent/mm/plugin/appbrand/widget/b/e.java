package com.tencent.mm.plugin.appbrand.widget.b;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.View;
import com.tencent.mm.plugin.appbrand.jsapi.s.c;

@SuppressLint({"AppCompatCustomView"})
public final class e
  extends f
  implements a
{
  private c crU = null;
  
  public e(Context paramContext)
  {
    super(paramContext);
  }
  
  public final c getReferrerPolicy()
  {
    return this.crU;
  }
  
  public final View getView()
  {
    return this;
  }
  
  public final void setImageByteArray(byte[] paramArrayOfByte) {}
  
  public final void setImageFilePath(String paramString) {}
  
  public final void setReferrerPolicy(c paramc)
  {
    this.crU = paramc;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.b.e
 * JD-Core Version:    0.7.0.1
 */