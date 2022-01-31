package com.tencent.map.lib.gl.model;

import java.util.ArrayList;

public class f
{
  private ArrayList<e> a = new ArrayList();
  
  public e a(int paramInt)
  {
    return (e)this.a.get(paramInt);
  }
  
  public void a(e parame)
  {
    this.a.add(parame);
  }
  
  public float[] a()
  {
    float[] arrayOfFloat = new float[this.a.size() * 3];
    int i = 0;
    while (i < this.a.size())
    {
      int j = i * 3;
      arrayOfFloat[(j + 0)] = ((e)this.a.get(i)).a;
      arrayOfFloat[(j + 1)] = ((e)this.a.get(i)).b;
      arrayOfFloat[(j + 2)] = ((e)this.a.get(i)).c;
      i += 1;
    }
    return arrayOfFloat;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.map.lib.gl.model.f
 * JD-Core Version:    0.7.0.1
 */