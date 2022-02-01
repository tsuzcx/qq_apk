package com.tencent.mapsdk.engine.jni.models;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class IconImageInfo
{
  public float anchorPointX1;
  public float anchorPointY1;
  public Bitmap bitmap;
  public float scale;
  
  public String toString()
  {
    AppMethodBeat.i(221110);
    StringBuffer localStringBuffer1 = new StringBuffer("IconImageInfo{");
    StringBuffer localStringBuffer2 = localStringBuffer1.append("bitmap=");
    if (this.bitmap != null) {}
    for (String str = this.bitmap.getWidth() + ":" + this.bitmap.getHeight();; str = null)
    {
      localStringBuffer2.append(str);
      localStringBuffer1.append(", scale=").append(this.scale);
      localStringBuffer1.append(", anchorPointX1=").append(this.anchorPointX1);
      localStringBuffer1.append(", anchorPointY1=").append(this.anchorPointY1);
      localStringBuffer1.append('}');
      str = localStringBuffer1.toString();
      AppMethodBeat.o(221110);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mapsdk.engine.jni.models.IconImageInfo
 * JD-Core Version:    0.7.0.1
 */