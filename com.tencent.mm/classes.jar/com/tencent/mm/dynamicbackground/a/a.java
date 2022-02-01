package com.tencent.mm.dynamicbackground.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.GregorianCalendar;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(bv={1, 0, 2}, d1={""}, d2={"Lcom/tencent/mm/dynamicbackground/util/DynamicBackgroundColorHelper;", "", "()V", "bgSystemColorConfig", "Lcom/tencent/mm/dynamicbackground/util/DynamicBackgroundColorHelper$BgSystemColorConfig;", "color", "Lcom/tencent/mm/dynamicbackground/util/DynamicBackgroundColorHelper$ColorConfig;", "getColor", "()Lcom/tencent/mm/dynamicbackground/util/DynamicBackgroundColorHelper$ColorConfig;", "updateColor", "", "BgSystemColorConfig", "ColorConfig", "Companion", "dynamicbg_release"}, k=1, mv={1, 1, 11})
public final class a
{
  private static final String TAG = "MicroMsg.DynamicBackgroundColorHelper";
  public static final c mbv;
  public final b mbt;
  private final a mbu;
  
  static
  {
    AppMethodBeat.i(103090);
    mbv = new c((byte)0);
    TAG = "MicroMsg.DynamicBackgroundColorHelper";
    AppMethodBeat.o(103090);
  }
  
  public a()
  {
    AppMethodBeat.i(103089);
    this.mbt = new b();
    this.mbu = new a();
    this.mbt.q(new float[] { 0.0F, 0.0F, 0.0F, 0.0F });
    this.mbt.r(new float[] { 0.0F, 0.0F, 0.0F, 0.0F });
    this.mbu.mbw.q(c.ry(11064532));
    this.mbu.mbw.r(c.ry(2770276));
    this.mbu.mbx.q(c.ry(8553090));
    this.mbu.mbx.r(c.ry(0));
    this.mbu.mby.q(c.ry(5260629));
    this.mbu.mby.r(c.ry(0));
    AppMethodBeat.o(103089);
  }
  
  public final void aTB()
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
      localb = this.mbu.mby;
      localObject = this.mbu.mbw;
    }
    for (;;)
    {
      c.b(this.mbt.mbA, localb, (b)localObject, 0, f1);
      c.b(this.mbt.mbB, localb, (b)localObject, 1, f1);
      AppMethodBeat.o(103088);
      return;
      if (f1 > 1.0F)
      {
        f1 -= 1.0F;
        localb = this.mbu.mbx;
        localObject = this.mbu.mby;
      }
      else
      {
        localb = this.mbu.mbw;
        localObject = this.mbu.mbx;
      }
    }
  }
  
  @Metadata(bv={1, 0, 2}, d1={""}, d2={"Lcom/tencent/mm/dynamicbackground/util/DynamicBackgroundColorHelper$BgSystemColorConfig;", "", "(Lcom/tencent/mm/dynamicbackground/util/DynamicBackgroundColorHelper;)V", "endColorConfig", "Lcom/tencent/mm/dynamicbackground/util/DynamicBackgroundColorHelper$ColorConfig;", "Lcom/tencent/mm/dynamicbackground/util/DynamicBackgroundColorHelper;", "getEndColorConfig", "()Lcom/tencent/mm/dynamicbackground/util/DynamicBackgroundColorHelper$ColorConfig;", "setEndColorConfig", "(Lcom/tencent/mm/dynamicbackground/util/DynamicBackgroundColorHelper$ColorConfig;)V", "middleColorConfig", "getMiddleColorConfig", "setMiddleColorConfig", "startColorConfig", "getStartColorConfig", "setStartColorConfig", "dynamicbg_release"}, k=1, mv={1, 1, 11})
  public final class a
  {
    a.b mbw;
    a.b mbx;
    a.b mby;
    
    public a()
    {
      AppMethodBeat.i(103081);
      this.mbw = new a.b(this$1);
      this.mbx = new a.b(this$1);
      this.mby = new a.b(this$1);
      AppMethodBeat.o(103081);
    }
  }
  
  @Metadata(bv={1, 0, 2}, d1={""}, d2={"Lcom/tencent/mm/dynamicbackground/util/DynamicBackgroundColorHelper$ColorConfig;", "", "(Lcom/tencent/mm/dynamicbackground/util/DynamicBackgroundColorHelper;)V", "bgColor1", "", "getBgColor1", "()[F", "setBgColor1", "([F)V", "bgColor2", "getBgColor2", "setBgColor2", "dynamicbg_release"}, k=1, mv={1, 1, 11})
  public final class b
  {
    public float[] mbA;
    public float[] mbB;
    
    public b()
    {
      AppMethodBeat.i(103084);
      this.mbA = new float[4];
      this.mbB = new float[4];
      AppMethodBeat.o(103084);
    }
    
    public final void q(float[] paramArrayOfFloat)
    {
      AppMethodBeat.i(103082);
      s.t(paramArrayOfFloat, "<set-?>");
      this.mbA = paramArrayOfFloat;
      AppMethodBeat.o(103082);
    }
    
    public final void r(float[] paramArrayOfFloat)
    {
      AppMethodBeat.i(103083);
      s.t(paramArrayOfFloat, "<set-?>");
      this.mbB = paramArrayOfFloat;
      AppMethodBeat.o(103083);
    }
  }
  
  @Metadata(bv={1, 0, 2}, d1={""}, d2={"Lcom/tencent/mm/dynamicbackground/util/DynamicBackgroundColorHelper$Companion;", "", "()V", "TAG", "", "colorArrayToInt", "", "color", "", "getBGColorFromStartConfig", "", "result", "startConfig", "Lcom/tencent/mm/dynamicbackground/util/DynamicBackgroundColorHelper$ColorConfig;", "Lcom/tencent/mm/dynamicbackground/util/DynamicBackgroundColorHelper;", "endConfig", "colorIndex", "portion", "", "getVector4ColorFromHex", "hex", "alpha", "mixColorWithA", "aColor", "bColor", "dynamicbg_release"}, k=1, mv={1, 1, 11})
  public static final class c
  {
    private static void a(float[] paramArrayOfFloat, a.b paramb1, a.b paramb2, int paramInt, float paramFloat)
    {
      AppMethodBeat.i(103086);
      if (paramInt == 0)
      {
        if (paramArrayOfFloat == null) {
          s.klw();
        }
        paramb1 = paramb1.mbA;
        if (paramb1 == null) {
          s.klw();
        }
        paramb2 = paramb2.mbA;
        if (paramb2 == null) {
          s.klw();
        }
        a(paramArrayOfFloat, paramb1, paramb2, paramFloat);
        AppMethodBeat.o(103086);
        return;
      }
      if (paramInt == 1)
      {
        if (paramArrayOfFloat == null) {
          s.klw();
        }
        paramb1 = paramb1.mbB;
        if (paramb1 == null) {
          s.klw();
        }
        paramb2 = paramb2.mbB;
        if (paramb2 == null) {
          s.klw();
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
    
    static float[] ry(int paramInt)
    {
      return new float[] { ((0xFF0000 & paramInt) >> 16) / 255.0F, ((0xFF00 & paramInt) >> 8) / 255.0F, ((paramInt & 0xFF) >> 0) / 255.0F, 1.0F };
    }
    
    public static int s(float[] paramArrayOfFloat)
    {
      AppMethodBeat.i(103085);
      s.t(paramArrayOfFloat, "color");
      int i = (int)(paramArrayOfFloat[0] * 255.0F);
      int j = (int)(paramArrayOfFloat[1] * 255.0F);
      int k = (int)(paramArrayOfFloat[2] * 255.0F);
      int m = (int)(paramArrayOfFloat[3] * 255.0F);
      AppMethodBeat.o(103085);
      return ((i & 0xFF) << 16) + ((m & 0xFF) << 24) + ((j & 0xFF) << 8) + (k & 0xFF);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.dynamicbackground.a.a
 * JD-Core Version:    0.7.0.1
 */