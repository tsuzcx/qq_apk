package com.tencent.mm.media.widget.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.widget.b.a.a.b;
import com.tencent.mm.media.widget.b.a.a.b.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.aw;
import d.g.a.m;
import d.g.b.k;
import d.l;
import d.y;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/media/widget/camera2/effect/VendorFaceBeautyConfig;", "", "()V", "KEY_FB_LEVEL", "", "getKEY_FB_LEVEL", "()Ljava/lang/String;", "KEY_SKIN_RATE", "getKEY_SKIN_RATE", "KEY_SLIM_RATE", "getKEY_SLIM_RATE", "MMKV_NAME", "TAG", "getTAG", "fbLevel", "", "getFbLevel", "()I", "setFbLevel", "(I)V", "onConfigChange", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "type", "value", "", "getOnConfigChange", "()Lkotlin/jvm/functions/Function2;", "setOnConfigChange", "(Lkotlin/jvm/functions/Function2;)V", "skinLevel", "getSkinLevel", "setSkinLevel", "slimLevel", "getSlimLevel", "setSlimLevel", "setConfig", "plugin-mediaeditor_release"})
public final class a
{
  private static final String TAG = "MicroMsg.VendorConfig";
  private static final String gZG = "vendor_skin_rate";
  private static final String gZH = "vendor_fb_level";
  private static final String gZI = "vendor_slim_rate";
  private static int gZJ;
  private static int gZK;
  private static int gZL;
  private static m<? super String, ? super Integer, y> gZM;
  public static final a gZN;
  
  static
  {
    AppMethodBeat.i(94181);
    gZN = new a();
    TAG = "MicroMsg.VendorConfig";
    gZG = "vendor_skin_rate";
    gZH = "vendor_fb_level";
    gZI = "vendor_slim_rate";
    gZJ = 3;
    gZK = 40;
    gZL = 40;
    AppMethodBeat.o(94181);
  }
  
  public static void X(String paramString, int paramInt)
  {
    AppMethodBeat.i(94180);
    k.h(paramString, "type");
    ac.i(TAG, "setConfig: " + paramString + ", " + paramInt);
    Object localObject = aw.aKT("vendor_effect_config");
    b.a locala = b.haF;
    if (k.g(paramString, b.aux()))
    {
      gZJ = paramInt;
      ((aw)localObject).putInt(gZH, gZJ);
    }
    for (;;)
    {
      localObject = gZM;
      if (localObject == null) {
        break;
      }
      ((m)localObject).n(paramString, Integer.valueOf(paramInt));
      AppMethodBeat.o(94180);
      return;
      locala = b.haF;
      if (k.g(paramString, b.auz()))
      {
        gZK = paramInt;
        ((aw)localObject).putInt(gZG, gZK);
      }
      else
      {
        locala = b.haF;
        if (k.g(paramString, b.auy()))
        {
          gZL = paramInt;
          ((aw)localObject).putInt(gZI, gZL);
        }
      }
    }
    AppMethodBeat.o(94180);
  }
  
  public static int aun()
  {
    return gZJ;
  }
  
  public static int auo()
  {
    return gZK;
  }
  
  public static int aup()
  {
    return gZL;
  }
  
  public static void b(m<? super String, ? super Integer, y> paramm)
  {
    gZM = paramm;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.media.widget.b.a.a
 * JD-Core Version:    0.7.0.1
 */