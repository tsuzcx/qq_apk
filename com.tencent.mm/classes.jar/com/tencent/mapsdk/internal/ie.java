package com.tencent.mapsdk.internal;

import android.view.animation.Interpolator;
import java.util.ArrayList;

public abstract class ie
  implements Cloneable
{
  ArrayList<a> a = null;
  
  private ArrayList<a> i()
  {
    return this.a;
  }
  
  private void j()
  {
    if (this.a != null)
    {
      this.a.clear();
      this.a = null;
    }
  }
  
  public void a() {}
  
  public abstract void a(long paramLong);
  
  public abstract void a(Interpolator paramInterpolator);
  
  public final void a(a parama)
  {
    if (this.a == null) {
      this.a = new ArrayList();
    }
    this.a.add(parama);
  }
  
  public abstract ie b(long paramLong);
  
  public void b() {}
  
  public final void b(a parama)
  {
    if (this.a == null) {}
    do
    {
      return;
      this.a.remove(parama);
    } while (this.a.size() != 0);
    this.a = null;
  }
  
  public void c() {}
  
  public abstract long d();
  
  public abstract long e();
  
  public abstract boolean f();
  
  public boolean g()
  {
    return f();
  }
  
  public ie h()
  {
    try
    {
      ie localie = (ie)super.clone();
      if (this.a != null)
      {
        ArrayList localArrayList = this.a;
        localie.a = new ArrayList();
        int j = localArrayList.size();
        int i = 0;
        while (i < j)
        {
          localie.a.add(localArrayList.get(i));
          i += 1;
        }
      }
      return localCloneNotSupportedException;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      throw new AssertionError();
    }
  }
  
  public static abstract interface a
  {
    public abstract void a();
    
    public abstract void a(ie paramie);
    
    public abstract void b();
    
    public abstract void b(ie paramie);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mapsdk.internal.ie
 * JD-Core Version:    0.7.0.1
 */