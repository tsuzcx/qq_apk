package com.tencent.mm.plugin.gallery.picker.view;

import android.graphics.Matrix;
import android.graphics.Rect;
import androidx.compose.a.q.a..ExternalSyntheticBackport0;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/gallery/picker/view/MMMediaCropLayout$CropInfo;", "", "mediaId", "", "(J)V", "contentRect", "Landroid/graphics/Rect;", "getContentRect", "()Landroid/graphics/Rect;", "setContentRect", "(Landroid/graphics/Rect;)V", "cropRect", "getCropRect", "setCropRect", "matrix", "Landroid/graphics/Matrix;", "getMatrix", "()Landroid/graphics/Matrix;", "setMatrix", "(Landroid/graphics/Matrix;)V", "viewRect", "getViewRect", "setViewRect", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "plugin-gallery_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class MMMediaCropLayout$b
{
  Rect Gl;
  private final long HIr;
  Matrix matrix;
  Rect viewRect;
  Rect yok;
  
  public MMMediaCropLayout$b(long paramLong)
  {
    AppMethodBeat.i(164925);
    this.HIr = paramLong;
    this.matrix = new Matrix();
    this.viewRect = new Rect();
    AppMethodBeat.o(164925);
  }
  
  public final boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if (!(paramObject instanceof b)) {
        return false;
      }
      paramObject = (b)paramObject;
    } while (this.HIr == paramObject.HIr);
    return false;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(289400);
    int i = q.a..ExternalSyntheticBackport0.m(this.HIr);
    AppMethodBeat.o(289400);
    return i;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(164926);
    String str = "CropInfo(mediaId=" + this.HIr + ')';
    AppMethodBeat.o(164926);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.picker.view.MMMediaCropLayout.b
 * JD-Core Version:    0.7.0.1
 */