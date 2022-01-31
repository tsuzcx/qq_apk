package com.tencent.map.lib.gl.model;

public class c
{
  private e a;
  private e b;
  private e c;
  private f d = new f();
  
  public c() {}
  
  public c(e parame1, e parame2, e parame3)
  {
    this();
    a(parame1, parame2, parame3);
  }
  
  public c(float[] paramArrayOfFloat)
  {
    this();
    a(new e(paramArrayOfFloat[0], paramArrayOfFloat[1], paramArrayOfFloat[2]), new e(paramArrayOfFloat[3], paramArrayOfFloat[4], paramArrayOfFloat[5]), new e(paramArrayOfFloat[6], paramArrayOfFloat[7], paramArrayOfFloat[8]));
  }
  
  private float a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6)
  {
    return (float)Math.sqrt((paramFloat1 - paramFloat4) * (paramFloat1 - paramFloat4) + (paramFloat2 - paramFloat5) * (paramFloat2 - paramFloat5) + (paramFloat3 - paramFloat6) * (paramFloat3 - paramFloat6));
  }
  
  private void a(e parame1, e parame2, e parame3)
  {
    this.a = parame1;
    this.b = parame2;
    this.c = parame3;
    this.d.a(parame1);
    this.d.a(parame2);
    this.d.a(parame3);
  }
  
  private float b()
  {
    float[] arrayOfFloat = this.d.a();
    float f1 = a(arrayOfFloat[0], arrayOfFloat[1], arrayOfFloat[2], arrayOfFloat[3], arrayOfFloat[4], arrayOfFloat[5]);
    float f2 = a(arrayOfFloat[3], arrayOfFloat[4], arrayOfFloat[5], arrayOfFloat[6], arrayOfFloat[7], arrayOfFloat[8]);
    float f3 = a(arrayOfFloat[0], arrayOfFloat[1], arrayOfFloat[2], arrayOfFloat[6], arrayOfFloat[7], arrayOfFloat[8]);
    float f4 = (f1 + f2 + f3) / 2.0F;
    return (float)Math.sqrt((f4 - f3) * ((f4 - f1) * f4 * (f4 - f2)));
  }
  
  public boolean a(float[] paramArrayOfFloat)
  {
    Object localObject = new e(paramArrayOfFloat[0], paramArrayOfFloat[1], paramArrayOfFloat[2]);
    paramArrayOfFloat = new c((e)localObject, this.a, this.b);
    c localc = new c((e)localObject, this.a, this.c);
    localObject = new c((e)localObject, this.b, this.c);
    return Math.abs(b() - (paramArrayOfFloat.b() + localc.b() + ((c)localObject).b())) < 0.001D;
  }
  
  public float[] a()
  {
    return this.d.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.map.lib.gl.model.c
 * JD-Core Version:    0.7.0.1
 */