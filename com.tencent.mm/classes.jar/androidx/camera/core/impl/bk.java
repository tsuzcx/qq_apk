package androidx.camera.core.impl;

import androidx.camera.core.a.f;
import androidx.camera.core.a.h;
import androidx.camera.core.ax;
import androidx.camera.core.q;
import androidx.camera.core.x;

public abstract interface bk<T extends ax>
  extends f<T>, h, ak
{
  public static final ac.a<bb> NF = ac.a.a("camerax.core.useCase.defaultSessionConfig", bb.class, null);
  public static final ac.a<z> NG = ac.a.a("camerax.core.useCase.defaultCaptureConfig", z.class, null);
  public static final ac.a<bb.d> NH = ac.a.a("camerax.core.useCase.sessionConfigUnpacker", bb.d.class, null);
  public static final ac.a<z.b> NI = ac.a.a("camerax.core.useCase.captureConfigUnpacker", z.b.class, null);
  public static final ac.a<Integer> NJ = ac.a.a("camerax.core.useCase.surfaceOccupancyPriority", Integer.TYPE, null);
  public static final ac.a<q> NK = ac.a.a("camerax.core.useCase.cameraSelector", q.class, null);
  
  public abstract bb kF();
  
  public abstract z kG();
  
  public abstract bb.d kH();
  
  public abstract z.b kI();
  
  public abstract int kJ();
  
  public abstract q kK();
  
  public static abstract interface a<T extends ax, C extends bk<T>, B>
    extends x<T>
  {
    public abstract C iT();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     androidx.camera.core.impl.bk
 * JD-Core Version:    0.7.0.1
 */