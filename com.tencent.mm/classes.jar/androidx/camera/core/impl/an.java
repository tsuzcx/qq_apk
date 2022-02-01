package androidx.camera.core.impl;

import android.view.Surface;
import androidx.camera.core.ag;
import java.util.concurrent.Executor;

public abstract interface an
{
  public abstract void a(a parama, Executor paramExecutor);
  
  public abstract void close();
  
  public abstract int getHeight();
  
  public abstract Surface getSurface();
  
  public abstract int getWidth();
  
  public abstract ag iu();
  
  public abstract ag iv();
  
  public abstract int iw();
  
  public abstract int ix();
  
  public abstract void iy();
  
  public static abstract interface a
  {
    public abstract void onImageAvailable(an paraman);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     androidx.camera.core.impl.an
 * JD-Core Version:    0.7.0.1
 */