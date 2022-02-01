package com.google.android.material.h;

import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.RectF;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;

public final class d
{
  public float cxD;
  public float cxE;
  public float dxj;
  public float dxk;
  private final List<c> dxl;
  
  public d()
  {
    AppMethodBeat.i(209596);
    this.dxl = new ArrayList();
    WT();
    AppMethodBeat.o(209596);
  }
  
  public final void WT()
  {
    AppMethodBeat.i(209614);
    this.cxD = 0.0F;
    this.cxE = 0.0F;
    this.dxj = 0.0F;
    this.dxk = 0.0F;
    this.dxl.clear();
    AppMethodBeat.o(209614);
  }
  
  public final void a(Matrix paramMatrix, Path paramPath)
  {
    AppMethodBeat.i(209640);
    int j = this.dxl.size();
    int i = 0;
    while (i < j)
    {
      ((c)this.dxl.get(i)).a(paramMatrix, paramPath);
      i += 1;
    }
    AppMethodBeat.o(209640);
  }
  
  public final void bb(float paramFloat)
  {
    AppMethodBeat.i(209622);
    b localb = new b();
    localb.x = paramFloat;
    localb.y = 0.0F;
    this.dxl.add(localb);
    this.dxj = paramFloat;
    this.dxk = 0.0F;
    AppMethodBeat.o(209622);
  }
  
  public final void d(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6)
  {
    AppMethodBeat.i(209632);
    a locala = new a(paramFloat1, paramFloat2, paramFloat3, paramFloat4);
    locala.dxm = paramFloat5;
    locala.dxn = paramFloat6;
    this.dxl.add(locala);
    this.dxj = ((paramFloat1 + paramFloat3) * 0.5F + (paramFloat3 - paramFloat1) / 2.0F * (float)Math.cos(Math.toRadians(paramFloat5 + paramFloat6)));
    this.dxk = ((paramFloat2 + paramFloat4) * 0.5F + (paramFloat4 - paramFloat2) / 2.0F * (float)Math.sin(Math.toRadians(paramFloat5 + paramFloat6)));
    AppMethodBeat.o(209632);
  }
  
  public static final class a
    extends d.c
  {
    private static final RectF avO;
    public float bottom;
    public float dxm;
    public float dxn;
    public float left;
    public float right;
    public float top;
    
    static
    {
      AppMethodBeat.i(209630);
      avO = new RectF();
      AppMethodBeat.o(209630);
    }
    
    public a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
    {
      this.left = paramFloat1;
      this.top = paramFloat2;
      this.right = paramFloat3;
      this.bottom = paramFloat4;
    }
    
    public final void a(Matrix paramMatrix, Path paramPath)
    {
      AppMethodBeat.i(209636);
      Matrix localMatrix = this.matrix;
      paramMatrix.invert(localMatrix);
      paramPath.transform(localMatrix);
      avO.set(this.left, this.top, this.right, this.bottom);
      paramPath.arcTo(avO, this.dxm, this.dxn, false);
      paramPath.transform(paramMatrix);
      AppMethodBeat.o(209636);
    }
  }
  
  public static final class b
    extends d.c
  {
    float x;
    float y;
    
    public final void a(Matrix paramMatrix, Path paramPath)
    {
      AppMethodBeat.i(209608);
      Matrix localMatrix = this.matrix;
      paramMatrix.invert(localMatrix);
      paramPath.transform(localMatrix);
      paramPath.lineTo(this.x, this.y);
      paramPath.transform(paramMatrix);
      AppMethodBeat.o(209608);
    }
  }
  
  public static abstract class c
  {
    protected final Matrix matrix = new Matrix();
    
    public abstract void a(Matrix paramMatrix, Path paramPath);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.google.android.material.h.d
 * JD-Core Version:    0.7.0.1
 */