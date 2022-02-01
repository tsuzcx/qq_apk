package androidx.camera.core;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.media.Image;
import android.media.Image.Plane;
import androidx.camera.core.impl.bi;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.ByteBuffer;

final class a
  implements ag
{
  private final Image Gb;
  private final a[] Gc;
  private final af Gd;
  
  a(Image paramImage)
  {
    AppMethodBeat.i(198476);
    this.Gb = paramImage;
    Image.Plane[] arrayOfPlane = paramImage.getPlanes();
    if (arrayOfPlane != null)
    {
      this.Gc = new a[arrayOfPlane.length];
      int i = 0;
      while (i < arrayOfPlane.length)
      {
        this.Gc[i] = new a(arrayOfPlane[i]);
        i += 1;
      }
    }
    this.Gc = new a[0];
    this.Gd = aj.a(bi.kA(), paramImage.getTimestamp(), 0, new Matrix());
    AppMethodBeat.o(198476);
  }
  
  public final void close()
  {
    try
    {
      AppMethodBeat.i(198481);
      this.Gb.close();
      AppMethodBeat.o(198481);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final int getFormat()
  {
    try
    {
      AppMethodBeat.i(198491);
      int i = this.Gb.getFormat();
      AppMethodBeat.o(198491);
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final int getHeight()
  {
    try
    {
      AppMethodBeat.i(198495);
      int i = this.Gb.getHeight();
      AppMethodBeat.o(198495);
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
      AppMethodBeat.i(198499);
      int i = this.Gb.getWidth();
      AppMethodBeat.o(198499);
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final ag.a[] is()
  {
    try
    {
      a[] arrayOfa = this.Gc;
      return arrayOfa;
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
    try
    {
      AppMethodBeat.i(198487);
      this.Gb.setCropRect(paramRect);
      AppMethodBeat.o(198487);
      return;
    }
    finally
    {
      paramRect = finally;
      throw paramRect;
    }
  }
  
  static final class a
    implements ag.a
  {
    private final Image.Plane Ge;
    
    a(Image.Plane paramPlane)
    {
      this.Ge = paramPlane;
    }
    
    public final ByteBuffer getBuffer()
    {
      try
      {
        AppMethodBeat.i(198401);
        ByteBuffer localByteBuffer = this.Ge.getBuffer();
        AppMethodBeat.o(198401);
        return localByteBuffer;
      }
      finally
      {
        localObject = finally;
        throw localObject;
      }
    }
    
    public final int getPixelStride()
    {
      try
      {
        AppMethodBeat.i(198386);
        int i = this.Ge.getPixelStride();
        AppMethodBeat.o(198386);
        return i;
      }
      finally
      {
        localObject = finally;
        throw localObject;
      }
    }
    
    public final int getRowStride()
    {
      try
      {
        AppMethodBeat.i(198369);
        int i = this.Ge.getRowStride();
        AppMethodBeat.o(198369);
        return i;
      }
      finally
      {
        localObject = finally;
        throw localObject;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     androidx.camera.core.a
 * JD-Core Version:    0.7.0.1
 */