package androidx.camera.core.impl;

import android.util.Size;
import android.view.Surface;

public abstract class aw
{
  public static aw a(Surface paramSurface, Size paramSize, int paramInt)
  {
    return new d(paramSurface, paramSize, paramInt);
  }
  
  public abstract Size getSize();
  
  public abstract Surface getSurface();
  
  public abstract int iw();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     androidx.camera.core.impl.aw
 * JD-Core Version:    0.7.0.1
 */