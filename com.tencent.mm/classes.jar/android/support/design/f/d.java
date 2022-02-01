package android.support.design.f;

import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.RectF;
import java.util.ArrayList;
import java.util.List;

public final class d
{
  public float mc;
  public float md;
  public float me;
  public float mf;
  private final List<c> mg = new ArrayList();
  
  public d()
  {
    bI();
  }
  
  public final void a(Matrix paramMatrix, Path paramPath)
  {
    int j = this.mg.size();
    int i = 0;
    while (i < j)
    {
      ((c)this.mg.get(i)).a(paramMatrix, paramPath);
      i += 1;
    }
  }
  
  public final void addArc(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6)
  {
    a locala = new a(paramFloat1, paramFloat2, paramFloat3, paramFloat4);
    locala.mh = paramFloat5;
    locala.mi = paramFloat6;
    this.mg.add(locala);
    this.me = ((paramFloat1 + paramFloat3) * 0.5F + (paramFloat3 - paramFloat1) / 2.0F * (float)Math.cos(Math.toRadians(paramFloat5 + paramFloat6)));
    this.mf = ((paramFloat2 + paramFloat4) * 0.5F + (paramFloat4 - paramFloat2) / 2.0F * (float)Math.sin(Math.toRadians(paramFloat5 + paramFloat6)));
  }
  
  public final void bI()
  {
    this.mc = 0.0F;
    this.md = 0.0F;
    this.me = 0.0F;
    this.mf = 0.0F;
    this.mg.clear();
  }
  
  public final void j(float paramFloat)
  {
    b localb = new b();
    localb.x = paramFloat;
    localb.y = 0.0F;
    this.mg.add(localb);
    this.me = paramFloat;
    this.mf = 0.0F;
  }
  
  public static final class a
    extends d.c
  {
    private static final RectF hM = new RectF();
    public float bottom;
    public float left;
    public float mh;
    public float mi;
    public float right;
    public float top;
    
    public a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
    {
      this.left = paramFloat1;
      this.top = paramFloat2;
      this.right = paramFloat3;
      this.bottom = paramFloat4;
    }
    
    public final void a(Matrix paramMatrix, Path paramPath)
    {
      Matrix localMatrix = this.gR;
      paramMatrix.invert(localMatrix);
      paramPath.transform(localMatrix);
      hM.set(this.left, this.top, this.right, this.bottom);
      paramPath.arcTo(hM, this.mh, this.mi, false);
      paramPath.transform(paramMatrix);
    }
  }
  
  public static final class b
    extends d.c
  {
    float x;
    float y;
    
    public final void a(Matrix paramMatrix, Path paramPath)
    {
      Matrix localMatrix = this.gR;
      paramMatrix.invert(localMatrix);
      paramPath.transform(localMatrix);
      paramPath.lineTo(this.x, this.y);
      paramPath.transform(paramMatrix);
    }
  }
  
  public static abstract class c
  {
    protected final Matrix gR = new Matrix();
    
    public abstract void a(Matrix paramMatrix, Path paramPath);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     android.support.design.f.d
 * JD-Core Version:    0.7.0.1
 */