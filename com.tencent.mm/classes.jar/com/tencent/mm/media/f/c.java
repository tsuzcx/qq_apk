package com.tencent.mm.media.f;

import a.f.b.j;
import a.l;
import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/media/mix/FrameInfo;", "", "bitmap", "Landroid/graphics/Bitmap;", "frameDuration", "", "(Landroid/graphics/Bitmap;J)V", "getBitmap", "()Landroid/graphics/Bitmap;", "getFrameDuration", "()J", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "plugin-mediaeditor_release"})
public final class c
{
  public final Bitmap bitmap;
  public final long eVx;
  
  public c(Bitmap paramBitmap, long paramLong)
  {
    AppMethodBeat.i(12992);
    this.bitmap = paramBitmap;
    this.eVx = paramLong;
    AppMethodBeat.o(12992);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(12995);
    if (this != paramObject)
    {
      if (!(paramObject instanceof c)) {
        break label68;
      }
      paramObject = (c)paramObject;
      if (!j.e(this.bitmap, paramObject.bitmap)) {
        break label68;
      }
      if (this.eVx != paramObject.eVx) {
        break label63;
      }
    }
    label63:
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(12995);
      return true;
    }
    label68:
    AppMethodBeat.o(12995);
    return false;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(12994);
    Bitmap localBitmap = this.bitmap;
    if (localBitmap != null) {}
    for (int i = localBitmap.hashCode();; i = 0)
    {
      long l = this.eVx;
      int j = (int)(l ^ l >>> 32);
      AppMethodBeat.o(12994);
      return i * 31 + j;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(12993);
    String str = "FrameInfo(bitmap=" + this.bitmap + ", frameDuration=" + this.eVx + ")";
    AppMethodBeat.o(12993);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.media.f.c
 * JD-Core Version:    0.7.0.1
 */