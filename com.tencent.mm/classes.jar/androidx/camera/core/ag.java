package androidx.camera.core;

import android.graphics.Rect;
import java.nio.ByteBuffer;

public abstract interface ag
  extends AutoCloseable
{
  public abstract void close();
  
  public abstract int getFormat();
  
  public abstract int getHeight();
  
  public abstract int getWidth();
  
  public abstract a[] is();
  
  public abstract af it();
  
  public abstract void setCropRect(Rect paramRect);
  
  public static abstract interface a
  {
    public abstract ByteBuffer getBuffer();
    
    public abstract int getPixelStride();
    
    public abstract int getRowStride();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     androidx.camera.core.ag
 * JD-Core Version:    0.7.0.1
 */