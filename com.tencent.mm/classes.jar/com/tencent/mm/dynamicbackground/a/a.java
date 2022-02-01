package com.tencent.mm.dynamicbackground.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.k;
import d.l;
import java.util.GregorianCalendar;

@l(fNY={1, 1, 11}, fNZ={""}, fOa={"Lcom/tencent/mm/dynamicbackground/util/DynamicBackgroundColorHelper;", "", "()V", "bgSystemColorConfig", "Lcom/tencent/mm/dynamicbackground/util/DynamicBackgroundColorHelper$BgSystemColorConfig;", "color", "Lcom/tencent/mm/dynamicbackground/util/DynamicBackgroundColorHelper$ColorConfig;", "getColor", "()Lcom/tencent/mm/dynamicbackground/util/DynamicBackgroundColorHelper$ColorConfig;", "updateColor", "", "BgSystemColorConfig", "ColorConfig", "Companion", "dynamicbg_release"})
public final class a
{
  private static final String TAG = "MicroMsg.DynamicBackgroundColorHelper";
  public static final c fMc;
  public final b fMa;
  private final a fMb;
  
  static
  {
    AppMethodBeat.i(103090);
    fMc = new c((byte)0);
    TAG = "MicroMsg.DynamicBackgroundColorHelper";
    AppMethodBeat.o(103090);
  }
  
  public a()
  {
    AppMethodBeat.i(103089);
    this.fMa = new b();
    this.fMb = new a();
    this.fMa.h(new float[] { 0.0F, 0.0F, 0.0F, 0.0F });
    this.fMa.i(new float[] { 0.0F, 0.0F, 0.0F, 0.0F });
    this.fMb.fMd.h(c.ls(11064532));
    this.fMb.fMd.i(c.ls(2770276));
    this.fMb.fMe.h(c.ls(8553090));
    this.fMb.fMe.i(c.ls(0));
    this.fMb.fMf.h(c.ls(5260629));
    this.fMb.fMf.i(c.ls(0));
    AppMethodBeat.o(103089);
  }
  
  public final void abr()
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
      localb = this.fMb.fMf;
      localObject = this.fMb.fMd;
    }
    for (;;)
    {
      c.b(this.fMa.fMh, localb, (b)localObject, 0, f1);
      c.b(this.fMa.fMi, localb, (b)localObject, 1, f1);
      AppMethodBeat.o(103088);
      return;
      if (f1 > 1.0F)
      {
        f1 -= 1.0F;
        localb = this.fMb.fMe;
        localObject = this.fMb.fMf;
      }
      else
      {
        localb = this.fMb.fMd;
        localObject = this.fMb.fMe;
      }
    }
  }
  
  @l(fNY={1, 1, 11}, fNZ={""}, fOa={"Lcom/tencent/mm/dynamicbackground/util/DynamicBackgroundColorHelper$BgSystemColorConfig;", "", "(Lcom/tencent/mm/dynamicbackground/util/DynamicBackgroundColorHelper;)V", "endColorConfig", "Lcom/tencent/mm/dynamicbackground/util/DynamicBackgroundColorHelper$ColorConfig;", "Lcom/tencent/mm/dynamicbackground/util/DynamicBackgroundColorHelper;", "getEndColorConfig", "()Lcom/tencent/mm/dynamicbackground/util/DynamicBackgroundColorHelper$ColorConfig;", "setEndColorConfig", "(Lcom/tencent/mm/dynamicbackground/util/DynamicBackgroundColorHelper$ColorConfig;)V", "middleColorConfig", "getMiddleColorConfig", "setMiddleColorConfig", "startColorConfig", "getStartColorConfig", "setStartColorConfig", "dynamicbg_release"})
  public final class a
  {
    a.b fMd;
    a.b fMe;
    a.b fMf;
    
    public a()
    {
      AppMethodBeat.i(103081);
      this.fMd = new a.b(this$1);
      this.fMe = new a.b(this$1);
      this.fMf = new a.b(this$1);
      AppMethodBeat.o(103081);
    }
  }
  
  @l(fNY={1, 1, 11}, fNZ={""}, fOa={"Lcom/tencent/mm/dynamicbackground/util/DynamicBackgroundColorHelper$ColorConfig;", "", "(Lcom/tencent/mm/dynamicbackground/util/DynamicBackgroundColorHelper;)V", "bgColor1", "", "getBgColor1", "()[F", "setBgColor1", "([F)V", "bgColor2", "getBgColor2", "setBgColor2", "dynamicbg_release"})
  public final class b
  {
    public float[] fMh;
    public float[] fMi;
    
    public b()
    {
      AppMethodBeat.i(103084);
      this.fMh = new float[4];
      this.fMi = new float[4];
      AppMethodBeat.o(103084);
    }
    
    public final void h(float[] paramArrayOfFloat)
    {
      AppMethodBeat.i(103082);
      k.h(paramArrayOfFloat, "<set-?>");
      this.fMh = paramArrayOfFloat;
      AppMethodBeat.o(103082);
    }
    
    public final void i(float[] paramArrayOfFloat)
    {
      AppMethodBeat.i(103083);
      k.h(paramArrayOfFloat, "<set-?>");
      this.fMi = paramArrayOfFloat;
      AppMethodBeat.o(103083);
    }
  }
  
  @l(fNY={1, 1, 11}, fNZ={""}, fOa={"Lcom/tencent/mm/dynamicbackground/util/DynamicBackgroundColorHelper$Companion;", "", "()V", "TAG", "", "colorArrayToInt", "", "color", "", "getBGColorFromStartConfig", "", "result", "startConfig", "Lcom/tencent/mm/dynamicbackground/util/DynamicBackgroundColorHelper$ColorConfig;", "Lcom/tencent/mm/dynamicbackground/util/DynamicBackgroundColorHelper;", "endConfig", "colorIndex", "portion", "", "getVector4ColorFromHex", "hex", "alpha", "mixColorWithA", "aColor", "bColor", "dynamicbg_release"})
  public static final class c
  {
    private static void a(float[] paramArrayOfFloat, a.b paramb1, a.b paramb2, int paramInt, float paramFloat)
    {
      AppMethodBeat.i(103086);
      if (paramInt == 0)
      {
        if (paramArrayOfFloat == null) {
          k.fOy();
        }
        paramb1 = paramb1.fMh;
        if (paramb1 == null) {
          k.fOy();
        }
        paramb2 = paramb2.fMh;
        if (paramb2 == null) {
          k.fOy();
        }
        a(paramArrayOfFloat, paramb1, paramb2, paramFloat);
        AppMethodBeat.o(103086);
        return;
      }
      if (paramInt == 1)
      {
        if (paramArrayOfFloat == null) {
          k.fOy();
        }
        paramb1 = paramb1.fMi;
        if (paramb1 == null) {
          k.fOy();
        }
        paramb2 = paramb2.fMi;
        if (paramb2 == null) {
          k.fOy();
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
      k.h(paramArrayOfFloat, "color");
      int i = (int)(paramArrayOfFloat[0] * 255.0F);
      int j = (int)(paramArrayOfFloat[1] * 255.0F);
      int k = (int)(paramArrayOfFloat[2] * 255.0F);
      int m = (int)(paramArrayOfFloat[3] * 255.0F);
      AppMethodBeat.o(103085);
      return ((i & 0xFF) << 16) + ((m & 0xFF) << 24) + ((j & 0xFF) << 8) + (k & 0xFF);
    }
    
    static float[] ls(int paramInt)
    {
      return new float[] { ((0xFF0000 & paramInt) >> 16) / 255.0F, ((0xFF00 & paramInt) >> 8) / 255.0F, ((paramInt & 0xFF) >> 0) / 255.0F, 1.0F };
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.dynamicbackground.a.a
 * JD-Core Version:    0.7.0.1
 */