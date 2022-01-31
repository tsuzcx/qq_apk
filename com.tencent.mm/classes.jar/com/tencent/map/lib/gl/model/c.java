package com.tencent.map.lib.gl.model;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class c
{
  private e a;
  private e b;
  private e c;
  private f d;
  
  public c()
  {
    AppMethodBeat.i(98144);
    this.d = new f();
    AppMethodBeat.o(98144);
  }
  
  public c(e parame1, e parame2, e parame3)
  {
    this();
    AppMethodBeat.i(98145);
    a(parame1, parame2, parame3);
    AppMethodBeat.o(98145);
  }
  
  public c(float[] paramArrayOfFloat)
  {
    this();
    AppMethodBeat.i(98146);
    a(new e(paramArrayOfFloat[0], paramArrayOfFloat[1], paramArrayOfFloat[2]), new e(paramArrayOfFloat[3], paramArrayOfFloat[4], paramArrayOfFloat[5]), new e(paramArrayOfFloat[6], paramArrayOfFloat[7], paramArrayOfFloat[8]));
    AppMethodBeat.o(98146);
  }
  
  private float a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6)
  {
    AppMethodBeat.i(98151);
    paramFloat1 = (float)Math.sqrt((paramFloat1 - paramFloat4) * (paramFloat1 - paramFloat4) + (paramFloat2 - paramFloat5) * (paramFloat2 - paramFloat5) + (paramFloat3 - paramFloat6) * (paramFloat3 - paramFloat6));
    AppMethodBeat.o(98151);
    return paramFloat1;
  }
  
  private void a(e parame1, e parame2, e parame3)
  {
    AppMethodBeat.i(98147);
    this.a = parame1;
    this.b = parame2;
    this.c = parame3;
    this.d.a(parame1);
    this.d.a(parame2);
    this.d.a(parame3);
    AppMethodBeat.o(98147);
  }
  
  private float b()
  {
    AppMethodBeat.i(98150);
    float[] arrayOfFloat = this.d.a();
    float f1 = a(arrayOfFloat[0], arrayOfFloat[1], arrayOfFloat[2], arrayOfFloat[3], arrayOfFloat[4], arrayOfFloat[5]);
    float f2 = a(arrayOfFloat[3], arrayOfFloat[4], arrayOfFloat[5], arrayOfFloat[6], arrayOfFloat[7], arrayOfFloat[8]);
    float f3 = a(arrayOfFloat[0], arrayOfFloat[1], arrayOfFloat[2], arrayOfFloat[6], arrayOfFloat[7], arrayOfFloat[8]);
    float f4 = (f1 + f2 + f3) / 2.0F;
    f1 = (float)Math.sqrt((f4 - f3) * ((f4 - f1) * f4 * (f4 - f2)));
    AppMethodBeat.o(98150);
    return f1;
  }
  
  public boolean a(float[] paramArrayOfFloat)
  {
    AppMethodBeat.i(98148);
    Object localObject = new e(paramArrayOfFloat[0], paramArrayOfFloat[1], paramArrayOfFloat[2]);
    paramArrayOfFloat = new c((e)localObject, this.a, this.b);
    c localc = new c((e)localObject, this.a, this.c);
    localObject = new c((e)localObject, this.b, this.c);
    if (Math.abs(b() - (paramArrayOfFloat.b() + localc.b() + ((c)localObject).b())) < 0.001D)
    {
      AppMethodBeat.o(98148);
      return true;
    }
    AppMethodBeat.o(98148);
    return false;
  }
  
  public float[] a()
  {
    AppMethodBeat.i(98149);
    float[] arrayOfFloat = this.d.a();
    AppMethodBeat.o(98149);
    return arrayOfFloat;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.map.lib.gl.model.c
 * JD-Core Version:    0.7.0.1
 */