package com.tencent.mm.dynamicbackground.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.p;
import d.l;
import java.util.GregorianCalendar;

@l(gfx={1, 1, 11}, gfy={""}, gfz={"Lcom/tencent/mm/dynamicbackground/util/DynamicBackgroundColorHelper;", "", "()V", "bgSystemColorConfig", "Lcom/tencent/mm/dynamicbackground/util/DynamicBackgroundColorHelper$BgSystemColorConfig;", "color", "Lcom/tencent/mm/dynamicbackground/util/DynamicBackgroundColorHelper$ColorConfig;", "getColor", "()Lcom/tencent/mm/dynamicbackground/util/DynamicBackgroundColorHelper$ColorConfig;", "updateColor", "", "BgSystemColorConfig", "ColorConfig", "Companion", "dynamicbg_release"})
public final class a
{
  private static final String TAG = "MicroMsg.DynamicBackgroundColorHelper";
  public static final c gfC;
  public final b gfA;
  private final a gfB;
  
  static
  {
    AppMethodBeat.i(103090);
    gfC = new c((byte)0);
    TAG = "MicroMsg.DynamicBackgroundColorHelper";
    AppMethodBeat.o(103090);
  }
  
  public a()
  {
    AppMethodBeat.i(103089);
    this.gfA = new b();
    this.gfB = new a();
    this.gfA.h(new float[] { 0.0F, 0.0F, 0.0F, 0.0F });
    this.gfA.i(new float[] { 0.0F, 0.0F, 0.0F, 0.0F });
    this.gfB.gfD.h(c.lR(11064532));
    this.gfB.gfD.i(c.lR(2770276));
    this.gfB.gfE.h(c.lR(8553090));
    this.gfB.gfE.i(c.lR(0));
    this.gfB.gfF.h(c.lR(5260629));
    this.gfB.gfF.i(c.lR(0));
    AppMethodBeat.o(103089);
  }
  
  public final void adV()
  {
    AppMethodBeat.i(103088);
    long l = System.currentTimeMillis() / 1000L;
    Object localObject = new GregorianCalendar();
    int i = ((GregorianCalendar)localObject).get(11);
    int j = ((GregorianCalendar)localObject).get(12);
    float f2 = (float)(l - (l - (((GregorianCalendar)localObject).get(13) + (i * 60 * 60 + j * 60)) + 36000L));
    float f1 = f2;
    if (f2 < 0.0F) {
      f1 = f2 + 86400.0F;
    }
    f1 = f1 * 1.0F / 28800.0F;
    b localb;
    if (f1 > 2.0F)
    {
      f1 -= 2.0F;
      localb = this.gfB.gfF;
      localObject = this.gfB.gfD;
    }
    for (;;)
    {
      c.b(this.gfA.gfH, localb, (b)localObject, 0, f1);
      c.b(this.gfA.gfI, localb, (b)localObject, 1, f1);
      AppMethodBeat.o(103088);
      return;
      if (f1 > 1.0F)
      {
        f1 -= 1.0F;
        localb = this.gfB.gfE;
        localObject = this.gfB.gfF;
      }
      else
      {
        localb = this.gfB.gfD;
        localObject = this.gfB.gfE;
      }
    }
  }
  
  @l(gfx={1, 1, 11}, gfy={""}, gfz={"Lcom/tencent/mm/dynamicbackground/util/DynamicBackgroundColorHelper$BgSystemColorConfig;", "", "(Lcom/tencent/mm/dynamicbackground/util/DynamicBackgroundColorHelper;)V", "endColorConfig", "Lcom/tencent/mm/dynamicbackground/util/DynamicBackgroundColorHelper$ColorConfig;", "Lcom/tencent/mm/dynamicbackground/util/DynamicBackgroundColorHelper;", "getEndColorConfig", "()Lcom/tencent/mm/dynamicbackground/util/DynamicBackgroundColorHelper$ColorConfig;", "setEndColorConfig", "(Lcom/tencent/mm/dynamicbackground/util/DynamicBackgroundColorHelper$ColorConfig;)V", "middleColorConfig", "getMiddleColorConfig", "setMiddleColorConfig", "startColorConfig", "getStartColorConfig", "setStartColorConfig", "dynamicbg_release"})
  public final class a
  {
    a.b gfD;
    a.b gfE;
    a.b gfF;
    
    public a()
    {
      AppMethodBeat.i(103081);
      this.gfD = new a.b(this$1);
      this.gfE = new a.b(this$1);
      this.gfF = new a.b(this$1);
      AppMethodBeat.o(103081);
    }
  }
  
  @l(gfx={1, 1, 11}, gfy={""}, gfz={"Lcom/tencent/mm/dynamicbackground/util/DynamicBackgroundColorHelper$ColorConfig;", "", "(Lcom/tencent/mm/dynamicbackground/util/DynamicBackgroundColorHelper;)V", "bgColor1", "", "getBgColor1", "()[F", "setBgColor1", "([F)V", "bgColor2", "getBgColor2", "setBgColor2", "dynamicbg_release"})
  public final class b
  {
    public float[] gfH;
    public float[] gfI;
    
    public b()
    {
      AppMethodBeat.i(103084);
      this.gfH = new float[4];
      this.gfI = new float[4];
      AppMethodBeat.o(103084);
    }
    
    public final void h(float[] paramArrayOfFloat)
    {
      AppMethodBeat.i(103082);
      p.h(paramArrayOfFloat, "<set-?>");
      this.gfH = paramArrayOfFloat;
      AppMethodBeat.o(103082);
    }
    
    public final void i(float[] paramArrayOfFloat)
    {
      AppMethodBeat.i(103083);
      p.h(paramArrayOfFloat, "<set-?>");
      this.gfI = paramArrayOfFloat;
      AppMethodBeat.o(103083);
    }
  }
  
  @l(gfx={1, 1, 11}, gfy={""}, gfz={"Lcom/tencent/mm/dynamicbackground/util/DynamicBackgroundColorHelper$Companion;", "", "()V", "TAG", "", "colorArrayToInt", "", "color", "", "getBGColorFromStartConfig", "", "result", "startConfig", "Lcom/tencent/mm/dynamicbackground/util/DynamicBackgroundColorHelper$ColorConfig;", "Lcom/tencent/mm/dynamicbackground/util/DynamicBackgroundColorHelper;", "endConfig", "colorIndex", "portion", "", "getVector4ColorFromHex", "hex", "alpha", "mixColorWithA", "aColor", "bColor", "dynamicbg_release"})
  public static final class c
  {
    private static void a(float[] paramArrayOfFloat, a.b paramb1, a.b paramb2, int paramInt, float paramFloat)
    {
      AppMethodBeat.i(103086);
      if (paramInt == 0)
      {
        if (paramArrayOfFloat == null) {
          p.gfZ();
        }
        paramb1 = paramb1.gfH;
        if (paramb1 == null) {
          p.gfZ();
        }
        paramb2 = paramb2.gfH;
        if (paramb2 == null) {
          p.gfZ();
        }
        a(paramArrayOfFloat, paramb1, paramb2, paramFloat);
        AppMethodBeat.o(103086);
        return;
      }
      if (paramInt == 1)
      {
        if (paramArrayOfFloat == null) {
          p.gfZ();
        }
        paramb1 = paramb1.gfI;
        if (paramb1 == null) {
          p.gfZ();
        }
        paramb2 = paramb2.gfI;
        if (paramb2 == null) {
          p.gfZ();
        }
        a(paramArrayOfFloat, paramb1, paramb2, paramFloat);
      }
      AppMethodBeat.o(103086);
    }
    
    private static void a(float[] paramArrayOfFloat1, float[] paramArrayOfFloat2, float[] paramArrayOfFloat3, float paramFloat)
    {
      paramArrayOfFloat1[0] = (paramArrayOfFloat3[0] * paramFloat + paramArrayOfFloat2[0] * (1.0F - paramFloat));
      paramArrayOfFloat1[1] = (paramArrayOfFloat3[1] * paramFloat + paramArrayOfFloat2[1] * (1.0F - paramFloat));
      paramArrayOfFloat1[2] = (paramArrayOfFloat3[2] * paramFloat + paramArrayOfFloat2[2] * (1.0F - paramFloat));
      paramArrayOfFloat1[3] = (paramArrayOfFloat3[3] * paramFloat + paramArrayOfFloat2[3] * (1.0F - paramFloat));
    }
    
    public static int j(float[] paramArrayOfFloat)
    {
      AppMethodBeat.i(103085);
      p.h(paramArrayOfFloat, "color");
      int i = (int)(paramArrayOfFloat[0] * 255.0F);
      int j = (int)(paramArrayOfFloat[1] * 255.0F);
      int k = (int)(paramArrayOfFloat[2] * 255.0F);
      int m = (int)(paramArrayOfFloat[3] * 255.0F);
      AppMethodBeat.o(103085);
      return ((i & 0xFF) << 16) + ((m & 0xFF) << 24) + ((j & 0xFF) << 8) + (k & 0xFF);
    }
    
    static float[] lR(int paramInt)
    {
      return new float[] { ((0xFF0000 & paramInt) >> 16) / 255.0F, ((0xFF00 & paramInt) >> 8) / 255.0F, ((paramInt & 0xFF) >> 0) / 255.0F, 1.0F };
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.dynamicbackground.a.a
 * JD-Core Version:    0.7.0.1
 */