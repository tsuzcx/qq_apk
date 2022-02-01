package com.tencent.mm.media.camera.d;

import android.util.Size;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/media/camera/model/GLSize;", "", "width", "", "height", "(II)V", "getHeight", "()I", "setHeight", "(I)V", "getWidth", "setWidth", "component1", "component2", "copy", "equals", "", "other", "hashCode", "ratio", "", "toSize", "Landroid/util/Size;", "toString", "", "valid", "plugin-camera_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class h
{
  public int height;
  public int width;
  
  public h(int paramInt1, int paramInt2)
  {
    this.width = paramInt1;
    this.height = paramInt2;
  }
  
  public final boolean boj()
  {
    return (this.width > 0) && (this.height > 0);
  }
  
  public final float bok()
  {
    return this.height * 1.0F / this.width;
  }
  
  public final Size bol()
  {
    AppMethodBeat.i(237127);
    Size localSize = new Size(this.width, this.height);
    AppMethodBeat.o(237127);
    return localSize;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if (!(paramObject instanceof h)) {
        return false;
      }
      paramObject = (h)paramObject;
      if (this.width != paramObject.width) {
        return false;
      }
    } while (this.height == paramObject.height);
    return false;
  }
  
  public final int hashCode()
  {
    return this.width * 31 + this.height;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(237123);
    String str = this.width + 'x' + this.height;
    AppMethodBeat.o(237123);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.media.camera.d.h
 * JD-Core Version:    0.7.0.1
 */