package com.tencent.mm.plugin.appbrand.widget.b;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.View;
import com.tencent.mm.model.ad.b;
import com.tencent.mm.plugin.appbrand.jsapi.u.c;

@SuppressLint({"AppCompatCustomView"})
public final class e
  extends f
  implements a
{
  private c cEN = null;
  private ad.b nal;
  
  public e(Context paramContext)
  {
    super(paramContext);
  }
  
  public final ad.b getKeyValueSet()
  {
    return this.nal;
  }
  
  public final c getReferrerPolicy()
  {
    return this.cEN;
  }
  
  public final View getView()
  {
    return this;
  }
  
  public final void setImageByteArray(byte[] paramArrayOfByte) {}
  
  public final void setImageFilePath(String paramString) {}
  
  public final void setKeyValueSet(ad.b paramb)
  {
    this.nal = paramb;
  }
  
  public final void setReferrerPolicy(c paramc)
  {
    this.cEN = paramc;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.b.e
 * JD-Core Version:    0.7.0.1
 */