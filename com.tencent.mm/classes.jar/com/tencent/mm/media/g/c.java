package com.tencent.mm.media.g;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.k;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/media/mix/FrameInfo;", "", "bitmap", "Landroid/graphics/Bitmap;", "frameDuration", "", "(Landroid/graphics/Bitmap;J)V", "getBitmap", "()Landroid/graphics/Bitmap;", "getFrameDuration", "()J", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "plugin-mediaeditor_release"})
public final class c
{
  public final Bitmap bitmap;
  public final long grP;
  
  public c(Bitmap paramBitmap, long paramLong)
  {
    AppMethodBeat.i(93719);
    this.bitmap = paramBitmap;
    this.grP = paramLong;
    AppMethodBeat.o(93719);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(93722);
    if (this != paramObject)
    {
      if ((paramObject instanceof c))
      {
        paramObject = (c)paramObject;
        if ((!k.g(this.bitmap, paramObject.bitmap)) || (this.grP != paramObject.grP)) {}
      }
    }
    else
    {
      AppMethodBeat.o(93722);
      return true;
    }
    AppMethodBeat.o(93722);
    return false;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(93721);
    Bitmap localBitmap = this.bitmap;
    if (localBitmap != null) {}
    for (int i = localBitmap.hashCode();; i = 0)
    {
      long l = this.grP;
      int j = (int)(l ^ l >>> 32);
      AppMethodBeat.o(93721);
      return i * 31 + j;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(93720);
    String str = "FrameInfo(bitmap=" + this.bitmap + ", frameDuration=" + this.grP + ")";
    AppMethodBeat.o(93720);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.media.g.c
 * JD-Core Version:    0.7.0.1
 */