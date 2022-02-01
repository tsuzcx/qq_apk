package com.tencent.mm.media.widget.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.widget.b.a.a.b;
import com.tencent.mm.media.widget.b.a.a.b.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ax;
import d.g.a.m;
import d.g.b.p;
import d.l;
import d.z;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/media/widget/camera2/effect/VendorFaceBeautyConfig;", "", "()V", "KEY_FB_LEVEL", "", "getKEY_FB_LEVEL", "()Ljava/lang/String;", "KEY_SKIN_RATE", "getKEY_SKIN_RATE", "KEY_SLIM_RATE", "getKEY_SLIM_RATE", "MMKV_NAME", "TAG", "getTAG", "fbLevel", "", "getFbLevel", "()I", "setFbLevel", "(I)V", "onConfigChange", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "type", "value", "", "getOnConfigChange", "()Lkotlin/jvm/functions/Function2;", "setOnConfigChange", "(Lkotlin/jvm/functions/Function2;)V", "skinLevel", "getSkinLevel", "setSkinLevel", "slimLevel", "getSlimLevel", "setSlimLevel", "setConfig", "plugin-mediaeditor_release"})
public final class a
{
  private static final String TAG = "MicroMsg.VendorConfig";
  private static final String hrM = "vendor_skin_rate";
  private static final String hrN = "vendor_fb_level";
  private static final String hrO = "vendor_slim_rate";
  private static int hrP;
  private static int hrQ;
  private static int hrR;
  private static m<? super String, ? super Integer, z> hrS;
  public static final a hrT;
  
  static
  {
    AppMethodBeat.i(94181);
    hrT = new a();
    TAG = "MicroMsg.VendorConfig";
    hrM = "vendor_skin_rate";
    hrN = "vendor_fb_level";
    hrO = "vendor_slim_rate";
    hrP = 3;
    hrQ = 40;
    hrR = 40;
    AppMethodBeat.o(94181);
  }
  
  public static void ab(String paramString, int paramInt)
  {
    AppMethodBeat.i(94180);
    p.h(paramString, "type");
    ad.i(TAG, "setConfig: " + paramString + ", " + paramInt);
    Object localObject = ax.aQz("vendor_effect_config");
    b.a locala = b.hsL;
    if (p.i(paramString, b.axk()))
    {
      hrP = paramInt;
      ((ax)localObject).putInt(hrN, hrP);
    }
    for (;;)
    {
      localObject = hrS;
      if (localObject == null) {
        break;
      }
      ((m)localObject).p(paramString, Integer.valueOf(paramInt));
      AppMethodBeat.o(94180);
      return;
      locala = b.hsL;
      if (p.i(paramString, b.axm()))
      {
        hrQ = paramInt;
        ((ax)localObject).putInt(hrM, hrQ);
      }
      else
      {
        locala = b.hsL;
        if (p.i(paramString, b.axl()))
        {
          hrR = paramInt;
          ((ax)localObject).putInt(hrO, hrR);
        }
      }
    }
    AppMethodBeat.o(94180);
  }
  
  public static int axa()
  {
    return hrP;
  }
  
  public static int axb()
  {
    return hrQ;
  }
  
  public static int axc()
  {
    return hrR;
  }
  
  public static void b(m<? super String, ? super Integer, z> paramm)
  {
    hrS = paramm;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.media.widget.b.a.a
 * JD-Core Version:    0.7.0.1
 */