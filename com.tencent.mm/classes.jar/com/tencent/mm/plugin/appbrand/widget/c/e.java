package com.tencent.mm.plugin.appbrand.widget.c;

import android.content.Context;
import android.view.View;
import com.tencent.mm.model.ad.b;
import com.tencent.mm.plugin.appbrand.jsapi.y.c;

public final class e
  extends f
  implements a
{
  private c eyH = null;
  private ad.b tfF;
  
  public e(Context paramContext)
  {
    super(paramContext);
  }
  
  public final ad.b getKeyValueSet()
  {
    return this.tfF;
  }
  
  public final c getReferrerPolicy()
  {
    return this.eyH;
  }
  
  public final View getView()
  {
    return this;
  }
  
  public final void setImageByteArray(byte[] paramArrayOfByte) {}
  
  public final void setImageFilePath(String paramString) {}
  
  public final void setKeyValueSet(ad.b paramb)
  {
    this.tfF = paramb;
  }
  
  public final void setReferrerPolicy(c paramc)
  {
    this.eyH = paramc;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.c.e
 * JD-Core Version:    0.7.0.1
 */