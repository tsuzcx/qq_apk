package com.tencent.mm.plugin.appbrand.widget.desktop.dynamicbackground;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Calendar;
import java.util.GregorianCalendar;

public final class a
{
  private a.b jgl;
  private a.a jgm;
  
  a()
  {
    AppMethodBeat.i(133962);
    this.jgl = new a.b(this);
    this.jgm = new a.a(this);
    this.jgl.jgr = new float[] { 0.0F, 0.0F, 0.0F, 0.0F };
    this.jgl.jgs = new float[] { 0.0F, 0.0F, 0.0F, 0.0F };
    this.jgm.jgn.jgr = qf(11064532);
    this.jgm.jgn.jgs = qf(2770276);
    this.jgm.jgo.jgr = qf(8553090);
    this.jgm.jgo.jgs = qf(0);
    this.jgm.jgp.jgr = qf(5260629);
    this.jgm.jgp.jgs = qf(0);
    AppMethodBeat.o(133962);
  }
  
  private static void a(float[] paramArrayOfFloat, a.b paramb1, a.b paramb2, int paramInt, float paramFloat)
  {
    AppMethodBeat.i(133964);
    if (paramInt == 0)
    {
      a(paramArrayOfFloat, paramb1.jgr, paramb2.jgr, paramFloat);
      AppMethodBeat.o(133964);
      return;
    }
    if (paramInt == 1) {
      a(paramArrayOfFloat, paramb1.jgs, paramb2.jgs, paramFloat);
    }
    AppMethodBeat.o(133964);
  }
  
  private static void a(float[] paramArrayOfFloat1, float[] paramArrayOfFloat2, float[] paramArrayOfFloat3, float paramFloat)
  {
    paramArrayOfFloat1[0] = (paramArrayOfFloat3[0] * paramFloat + paramArrayOfFloat2[0] * (1.0F - paramFloat));
    paramArrayOfFloat1[1] = (paramArrayOfFloat3[1] * paramFloat + paramArrayOfFloat2[1] * (1.0F - paramFloat));
    paramArrayOfFloat1[2] = (paramArrayOfFloat3[2] * paramFloat + paramArrayOfFloat2[2] * (1.0F - paramFloat));
    paramArrayOfFloat1[3] = (paramArrayOfFloat3[3] * paramFloat + paramArrayOfFloat2[3] * (1.0F - paramFloat));
  }
  
  public static int i(float[] paramArrayOfFloat)
  {
    int i = (int)(paramArrayOfFloat[0] * 255.0F);
    int j = (int)(paramArrayOfFloat[1] * 255.0F);
    int k = (int)(paramArrayOfFloat[2] * 255.0F);
    return ((i & 0xFF) << 16) + (((int)(paramArrayOfFloat[3] * 255.0F) & 0xFF) << 24) + ((j & 0xFF) << 8) + (k & 0xFF);
  }
  
  private static float[] qf(int paramInt)
  {
    return new float[] { ((0xFF0000 & paramInt) >> 16) / 255.0F, ((0xFF00 & paramInt) >> 8) / 255.0F, ((paramInt & 0xFF) >> 0) / 255.0F, 1.0F };
  }
  
  public final a.b aPE()
  {
    return this.jgl;
  }
  
  public final void aPF()
  {
    AppMethodBeat.i(133963);
    long l = System.currentTimeMillis() / 1000L;
    Object localObject = new GregorianCalendar();
    int i = ((Calendar)localObject).get(11);
    int j = ((Calendar)localObject).get(12);
    float f2 = (float)(l - (l - (((Calendar)localObject).get(13) + (i * 60 * 60 + j * 60)) + 36000L));
    float f1 = f2;
    if (f2 < 0.0F) {
      f1 = f2 + 86400.0F;
    }
    f1 = f1 * 1.0F / 28800.0F;
    a.b localb;
    if (f1 > 2.0F)
    {
      f1 -= 2.0F;
      localb = this.jgm.jgp;
      localObject = this.jgm.jgn;
    }
    for (;;)
    {
      a(this.jgl.jgr, localb, (a.b)localObject, 0, f1);
      a(this.jgl.jgs, localb, (a.b)localObject, 1, f1);
      AppMethodBeat.o(133963);
      return;
      if (f1 > 1.0F)
      {
        f1 -= 1.0F;
        localb = this.jgm.jgo;
        localObject = this.jgm.jgp;
      }
      else
      {
        localb = this.jgm.jgn;
        localObject = this.jgm.jgo;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.desktop.dynamicbackground.a
 * JD-Core Version:    0.7.0.1
 */