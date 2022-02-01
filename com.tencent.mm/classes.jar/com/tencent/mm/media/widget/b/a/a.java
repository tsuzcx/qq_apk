package com.tencent.mm.media.widget.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.widget.b.a.a.b;
import com.tencent.mm.media.widget.b.a.a.b.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ay;
import d.g.a.m;
import d.g.b.p;
import d.l;
import d.z;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/media/widget/camera2/effect/VendorFaceBeautyConfig;", "", "()V", "KEY_FB_LEVEL", "", "getKEY_FB_LEVEL", "()Ljava/lang/String;", "KEY_SKIN_RATE", "getKEY_SKIN_RATE", "KEY_SLIM_RATE", "getKEY_SLIM_RATE", "MMKV_NAME", "TAG", "getTAG", "fbLevel", "", "getFbLevel", "()I", "setFbLevel", "(I)V", "onConfigChange", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "type", "value", "", "getOnConfigChange", "()Lkotlin/jvm/functions/Function2;", "setOnConfigChange", "(Lkotlin/jvm/functions/Function2;)V", "skinLevel", "getSkinLevel", "setSkinLevel", "slimLevel", "getSlimLevel", "setSlimLevel", "setConfig", "plugin-mediaeditor_release"})
public final class a
{
  private static final String TAG = "MicroMsg.VendorConfig";
  private static final String huA = "vendor_skin_rate";
  private static final String huB = "vendor_fb_level";
  private static final String huC = "vendor_slim_rate";
  private static int huD;
  private static int huE;
  private static int huF;
  private static m<? super String, ? super Integer, z> huG;
  public static final a huH;
  
  static
  {
    AppMethodBeat.i(94181);
    huH = new a();
    TAG = "MicroMsg.VendorConfig";
    huA = "vendor_skin_rate";
    huB = "vendor_fb_level";
    huC = "vendor_slim_rate";
    huD = 3;
    huE = 40;
    huF = 40;
    AppMethodBeat.o(94181);
  }
  
  public static void ac(String paramString, int paramInt)
  {
    AppMethodBeat.i(94180);
    p.h(paramString, "type");
    ae.i(TAG, "setConfig: " + paramString + ", " + paramInt);
    Object localObject = ay.aRW("vendor_effect_config");
    b.a locala = b.hvz;
    if (p.i(paramString, b.axz()))
    {
      huD = paramInt;
      ((ay)localObject).putInt(huB, huD);
    }
    for (;;)
    {
      localObject = huG;
      if (localObject == null) {
        break;
      }
      ((m)localObject).p(paramString, Integer.valueOf(paramInt));
      AppMethodBeat.o(94180);
      return;
      locala = b.hvz;
      if (p.i(paramString, b.axB()))
      {
        huE = paramInt;
        ((ay)localObject).putInt(huA, huE);
      }
      else
      {
        locala = b.hvz;
        if (p.i(paramString, b.axA()))
        {
          huF = paramInt;
          ((ay)localObject).putInt(huC, huF);
        }
      }
    }
    AppMethodBeat.o(94180);
  }
  
  public static int axp()
  {
    return huD;
  }
  
  public static int axq()
  {
    return huE;
  }
  
  public static int axr()
  {
    return huF;
  }
  
  public static void b(m<? super String, ? super Integer, z> paramm)
  {
    huG = paramm;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.media.widget.b.a.a
 * JD-Core Version:    0.7.0.1
 */