package android.support.design.f;

import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.RectF;
import java.util.ArrayList;
import java.util.List;

public final class d
{
  public float jn;
  public float jo;
  public float jp;
  public float jq;
  private final List<c> jr = new ArrayList();
  
  public d()
  {
    bm();
  }
  
  public final void a(Matrix paramMatrix, Path paramPath)
  {
    int j = this.jr.size();
    int i = 0;
    while (i < j)
    {
      ((c)this.jr.get(i)).a(paramMatrix, paramPath);
      i += 1;
    }
  }
  
  public final void addArc(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6)
  {
    a locala = new a(paramFloat1, paramFloat2, paramFloat3, paramFloat4);
    locala.js = paramFloat5;
    locala.jt = paramFloat6;
    this.jr.add(locala);
    this.jp = ((paramFloat1 + paramFloat3) * 0.5F + (paramFloat3 - paramFloat1) / 2.0F * (float)Math.cos(Math.toRadians(paramFloat5 + paramFloat6)));
    this.jq = ((paramFloat2 + paramFloat4) * 0.5F + (paramFloat4 - paramFloat2) / 2.0F * (float)Math.sin(Math.toRadians(paramFloat5 + paramFloat6)));
  }
  
  public final void bm()
  {
    this.jn = 0.0F;
    this.jo = 0.0F;
    this.jp = 0.0F;
    this.jq = 0.0F;
    this.jr.clear();
  }
  
  public final void g(float paramFloat)
  {
    b localb = new b();
    localb.x = paramFloat;
    localb.y = 0.0F;
    this.jr.add(localb);
    this.jp = paramFloat;
    this.jq = 0.0F;
  }
  
  public static final class a
    extends d.c
  {
    private static final RectF eU = new RectF();
    public float bottom;
    public float js;
    public float jt;
    public float left;
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
      Matrix localMatrix = this.dY;
      paramMatrix.invert(localMatrix);
      paramPath.transform(localMatrix);
      eU.set(this.left, this.top, this.right, this.bottom);
      paramPath.arcTo(eU, this.js, this.jt, false);
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
      Matrix localMatrix = this.dY;
      paramMatrix.invert(localMatrix);
      paramPath.transform(localMatrix);
      paramPath.lineTo(this.x, this.y);
      paramPath.transform(paramMatrix);
    }
  }
  
  public static abstract class c
  {
    protected final Matrix dY = new Matrix();
    
    public abstract void a(Matrix paramMatrix, Path paramPath);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     android.support.design.f.d
 * JD-Core Version:    0.7.0.1
 */