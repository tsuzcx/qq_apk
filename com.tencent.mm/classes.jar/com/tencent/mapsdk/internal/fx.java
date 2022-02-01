package com.tencent.mapsdk.internal;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class fx
{
  public fz a;
  public fz b;
  public fz c;
  private ga d;
  
  public fx()
  {
    AppMethodBeat.i(221918);
    this.d = new ga();
    AppMethodBeat.o(221918);
  }
  
  public fx(fz paramfz1, fz paramfz2, fz paramfz3)
  {
    this();
    AppMethodBeat.i(221924);
    a(paramfz1, paramfz2, paramfz3);
    AppMethodBeat.o(221924);
  }
  
  public fx(float[] paramArrayOfFloat)
  {
    this();
    AppMethodBeat.i(221932);
    a(new fz(paramArrayOfFloat[0], paramArrayOfFloat[1], paramArrayOfFloat[2]), new fz(paramArrayOfFloat[3], paramArrayOfFloat[4], paramArrayOfFloat[5]), new fz(paramArrayOfFloat[6], paramArrayOfFloat[7], paramArrayOfFloat[8]));
    AppMethodBeat.o(221932);
  }
  
  private static float a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6)
  {
    AppMethodBeat.i(221961);
    paramFloat1 = (float)Math.sqrt((paramFloat1 - paramFloat4) * (paramFloat1 - paramFloat4) + (paramFloat2 - paramFloat5) * (paramFloat2 - paramFloat5) + (paramFloat3 - paramFloat6) * (paramFloat3 - paramFloat6));
    AppMethodBeat.o(221961);
    return paramFloat1;
  }
  
  private void a(fz paramfz1, fz paramfz2, fz paramfz3)
  {
    AppMethodBeat.i(221942);
    this.a = paramfz1;
    this.b = paramfz2;
    this.c = paramfz3;
    this.d.a(paramfz1);
    this.d.a(paramfz2);
    this.d.a(paramfz3);
    AppMethodBeat.o(221942);
  }
  
  private boolean a(float[] paramArrayOfFloat)
  {
    AppMethodBeat.i(221948);
    Object localObject = new fz(paramArrayOfFloat[0], paramArrayOfFloat[1], paramArrayOfFloat[2]);
    paramArrayOfFloat = new fx((fz)localObject, this.a, this.b);
    fx localfx = new fx((fz)localObject, this.a, this.c);
    localObject = new fx((fz)localObject, this.b, this.c);
    if (Math.abs(a() - (paramArrayOfFloat.a() + localfx.a() + ((fx)localObject).a())) < 0.001D)
    {
      AppMethodBeat.o(221948);
      return true;
    }
    AppMethodBeat.o(221948);
    return false;
  }
  
  private float[] b()
  {
    AppMethodBeat.i(221955);
    float[] arrayOfFloat = this.d.a();
    AppMethodBeat.o(221955);
    return arrayOfFloat;
  }
  
  public final float a()
  {
    AppMethodBeat.i(221971);
    float[] arrayOfFloat = this.d.a();
    float f1 = a(arrayOfFloat[0], arrayOfFloat[1], arrayOfFloat[2], arrayOfFloat[3], arrayOfFloat[4], arrayOfFloat[5]);
    float f2 = a(arrayOfFloat[3], arrayOfFloat[4], arrayOfFloat[5], arrayOfFloat[6], arrayOfFloat[7], arrayOfFloat[8]);
    float f3 = a(arrayOfFloat[0], arrayOfFloat[1], arrayOfFloat[2], arrayOfFloat[6], arrayOfFloat[7], arrayOfFloat[8]);
    float f4 = (f1 + f2 + f3) / 2.0F;
    f1 = (float)Math.sqrt((f4 - f3) * ((f4 - f1) * f4 * (f4 - f2)));
    AppMethodBeat.o(221971);
    return f1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mapsdk.internal.fx
 * JD-Core Version:    0.7.0.1
 */