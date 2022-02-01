package androidx.camera.core;

import android.graphics.Rect;
import android.util.Size;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class at
  extends aa
{
  private final af Gd;
  private Rect Jg;
  private final int mHeight;
  private final int mWidth;
  
  at(ag paramag, Size paramSize, af paramaf)
  {
    super(paramag);
    AppMethodBeat.i(198309);
    if (paramSize == null) {
      this.mWidth = super.getWidth();
    }
    for (this.mHeight = super.getHeight();; this.mHeight = paramSize.getHeight())
    {
      this.Gd = paramaf;
      AppMethodBeat.o(198309);
      return;
      this.mWidth = paramSize.getWidth();
    }
  }
  
  at(ag paramag, af paramaf)
  {
    this(paramag, null, paramaf);
  }
  
  public final int getHeight()
  {
    try
    {
      int i = this.mHeight;
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final int getWidth()
  {
    try
    {
      int i = this.mWidth;
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final af it()
  {
    return this.Gd;
  }
  
  public final void setCropRect(Rect paramRect)
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(198316);
        Rect localRect = paramRect;
        if (paramRect != null)
        {
          localRect = new Rect(paramRect);
          if (!localRect.intersect(0, 0, getWidth(), getHeight())) {
            localRect.setEmpty();
          }
        }
        else
        {
          this.Jg = localRect;
          AppMethodBeat.o(198316);
          return;
        }
      }
      finally {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     androidx.camera.core.at
 * JD-Core Version:    0.7.0.1
 */