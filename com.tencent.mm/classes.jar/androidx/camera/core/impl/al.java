package androidx.camera.core.impl;

import android.util.Pair;
import android.util.Size;
import androidx.camera.core.c;
import java.util.List;

public abstract interface al
  extends ba
{
  public static final ac.a<Integer> MI = ac.a.a("camerax.core.imageOutput.targetAspectRatio", c.class, null);
  public static final ac.a<Integer> MJ = ac.a.a("camerax.core.imageOutput.targetRotation", Integer.TYPE, null);
  public static final ac.a<Size> MK = ac.a.a("camerax.core.imageOutput.targetResolution", Size.class, null);
  public static final ac.a<Size> ML = ac.a.a("camerax.core.imageOutput.defaultResolution", Size.class, null);
  public static final ac.a<Size> MM = ac.a.a("camerax.core.imageOutput.maxResolution", Size.class, null);
  public static final ac.a<List<Pair<Integer, Size[]>>> MN = ac.a.a("camerax.core.imageOutput.supportedResolutions", List.class, null);
  
  public abstract boolean km();
  
  public abstract int kn();
  
  public abstract int ko();
  
  public abstract Size kp();
  
  public abstract Size kq();
  
  public abstract Size kr();
  
  public abstract List<Pair<Integer, Size[]>> ks();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     androidx.camera.core.impl.al
 * JD-Core Version:    0.7.0.1
 */