package com.tencent.mm.plugin.emojicapture.e;

import a.a.n;
import a.d.b.g;
import a.e.d;
import android.graphics.Matrix;
import android.view.MotionEvent;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public final class f
{
  private final String TAG = "TouchTracker";
  float apq = 10.0F;
  float apr = 0.1F;
  public Matrix aqv = new Matrix();
  int height;
  ArrayList<Integer> jng = new ArrayList();
  ArrayList<Integer> jnh = new ArrayList();
  float[] jni = new float[2];
  float[] jnj = new float[4];
  float[] jnk = new float[2];
  f.b jnl = f.b.jnq;
  a jnm = a.jnn;
  int width;
  
  public f()
  {
    this.aqv.setScale(1.0F, 1.0F);
  }
  
  final void B(MotionEvent paramMotionEvent)
  {
    if (this.jng.size() == 1)
    {
      this.jnl = f.b.jnr;
      localObject1 = this.jni;
      localObject2 = this.jnh.get(0);
      g.j(localObject2, "pIndices[0]");
      localObject1[0] = paramMotionEvent.getX(((Number)localObject2).intValue());
      localObject1 = this.jni;
      localObject2 = this.jnh.get(0);
      g.j(localObject2, "pIndices[0]");
      localObject1[1] = paramMotionEvent.getY(((Number)localObject2).intValue());
    }
    while (this.jng.size() != 2) {
      return;
    }
    this.jnl = f.b.jns;
    if (g.e(this.jnm, a.jno)) {
      this.aqv.mapPoints(this.jnk, new float[] { this.width / 2.0F, this.height / 2.0F });
    }
    Object localObject1 = new Matrix();
    this.aqv.invert((Matrix)localObject1);
    C(paramMotionEvent);
    Object localObject2 = this.jnj;
    Object localObject3 = this.jnh.get(0);
    g.j(localObject3, "pIndices[0]");
    float f1 = paramMotionEvent.getX(((Number)localObject3).intValue());
    localObject3 = this.jnh.get(0);
    g.j(localObject3, "pIndices[0]");
    float f2 = paramMotionEvent.getY(((Number)localObject3).intValue());
    localObject3 = this.jnh.get(1);
    g.j(localObject3, "pIndices[1]");
    float f3 = paramMotionEvent.getX(((Number)localObject3).intValue());
    localObject3 = this.jnh.get(1);
    g.j(localObject3, "pIndices[1]");
    ((Matrix)localObject1).mapPoints((float[])localObject2, new float[] { f1, f2, f3, paramMotionEvent.getY(((Number)localObject3).intValue()) });
  }
  
  final void C(MotionEvent paramMotionEvent)
  {
    Object localObject1 = (Collection)this.jng;
    g.k(localObject1, "$receiver");
    localObject1 = ((Iterable)new d(0, ((Collection)localObject1).size() - 1)).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      int i = ((n)localObject1).nextInt();
      ArrayList localArrayList = this.jnh;
      Object localObject2 = this.jng.get(i);
      g.j(localObject2, "pIds[i]");
      localArrayList.set(i, Integer.valueOf(paramMotionEvent.findPointerIndex(((Number)localObject2).intValue())));
    }
  }
  
  public static enum a
  {
    static
    {
      a locala1 = new a("FREE", 0);
      jnn = locala1;
      a locala2 = new a("CENTER", 1);
      jno = locala2;
      jnp = new a[] { locala1, locala2 };
    }
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.e.f
 * JD-Core Version:    0.7.0.1
 */