package android.support.design.f;

import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.RectF;
import java.util.ArrayList;
import java.util.List;

public final class d
{
  public float me;
  public float mf;
  public float mg;
  public float mh;
  private final List<c> mi = new ArrayList();
  
  public d()
  {
    bK();
  }
  
  public final void a(Matrix paramMatrix, Path paramPath)
  {
    int j = this.mi.size();
    int i = 0;
    while (i < j)
    {
      ((c)this.mi.get(i)).a(paramMatrix, paramPath);
      i += 1;
    }
  }
  
  public final void addArc(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6)
  {
    a locala = new a(paramFloat1, paramFloat2, paramFloat3, paramFloat4);
    locala.mj = paramFloat5;
    locala.mk = paramFloat6;
    this.mi.add(locala);
    this.mg = ((paramFloat1 + paramFloat3) * 0.5F + (paramFloat3 - paramFloat1) / 2.0F * (float)Math.cos(Math.toRadians(paramFloat5 + paramFloat6)));
    this.mh = ((paramFloat2 + paramFloat4) * 0.5F + (paramFloat4 - paramFloat2) / 2.0F * (float)Math.sin(Math.toRadians(paramFloat5 + paramFloat6)));
  }
  
  public final void bK()
  {
    this.me = 0.0F;
    this.mf = 0.0F;
    this.mg = 0.0F;
    this.mh = 0.0F;
    this.mi.clear();
  }
  
  public final void j(float paramFloat)
  {
    b localb = new b();
    localb.x = paramFloat;
    localb.y = 0.0F;
    this.mi.add(localb);
    this.mg = paramFloat;
    this.mh = 0.0F;
  }
  
  public static final class a
    extends d.c
  {
    private static final RectF hO = new RectF();
    public float bottom;
    public float left;
    public float mj;
    public float mk;
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
      Matrix localMatrix = this.gT;
      paramMatrix.invert(localMatrix);
      paramPath.transform(localMatrix);
      hO.set(this.left, this.top, this.right, this.bottom);
      paramPath.arcTo(hO, this.mj, this.mk, false);
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
      Matrix localMatrix = this.gT;
      paramMatrix.invert(localMatrix);
      paramPath.transform(localMatrix);
      paramPath.lineTo(this.x, this.y);
      paramPath.transform(paramMatrix);
    }
  }
  
  public static abstract class c
  {
    protected final Matrix gT = new Matrix();
    
    public abstract void a(Matrix paramMatrix, Path paramPath);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     android.support.design.f.d
 * JD-Core Version:    0.7.0.1
 */