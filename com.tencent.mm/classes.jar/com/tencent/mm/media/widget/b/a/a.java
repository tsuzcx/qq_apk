package com.tencent.mm.media.widget.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.widget.b.a.a.b;
import com.tencent.mm.media.widget.b.a.a.b.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ax;
import d.g.a.m;
import d.g.b.k;
import d.l;
import d.y;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/media/widget/camera2/effect/VendorFaceBeautyConfig;", "", "()V", "KEY_FB_LEVEL", "", "getKEY_FB_LEVEL", "()Ljava/lang/String;", "KEY_SKIN_RATE", "getKEY_SKIN_RATE", "KEY_SLIM_RATE", "getKEY_SLIM_RATE", "MMKV_NAME", "TAG", "getTAG", "fbLevel", "", "getFbLevel", "()I", "setFbLevel", "(I)V", "onConfigChange", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "type", "value", "", "getOnConfigChange", "()Lkotlin/jvm/functions/Function2;", "setOnConfigChange", "(Lkotlin/jvm/functions/Function2;)V", "skinLevel", "getSkinLevel", "setSkinLevel", "slimLevel", "getSlimLevel", "setSlimLevel", "setConfig", "plugin-mediaeditor_release"})
public final class a
{
  private static final String TAG = "MicroMsg.VendorConfig";
  private static final String gzj = "vendor_skin_rate";
  private static final String gzk = "vendor_fb_level";
  private static final String gzl = "vendor_slim_rate";
  private static int gzm;
  private static int gzn;
  private static int gzo;
  private static m<? super String, ? super Integer, y> gzp;
  public static final a gzq;
  
  static
  {
    AppMethodBeat.i(94181);
    gzq = new a();
    TAG = "MicroMsg.VendorConfig";
    gzj = "vendor_skin_rate";
    gzk = "vendor_fb_level";
    gzl = "vendor_slim_rate";
    gzm = 3;
    gzn = 40;
    gzo = 40;
    AppMethodBeat.o(94181);
  }
  
  public static void S(String paramString, int paramInt)
  {
    AppMethodBeat.i(94180);
    k.h(paramString, "type");
    ad.i(TAG, "setConfig: " + paramString + ", " + paramInt);
    Object localObject = ax.aFC("vendor_effect_config");
    b.a locala = b.gAi;
    if (k.g(paramString, b.anF()))
    {
      gzm = paramInt;
      ((ax)localObject).putInt(gzk, gzm);
    }
    for (;;)
    {
      localObject = gzp;
      if (localObject == null) {
        break;
      }
      ((m)localObject).n(paramString, Integer.valueOf(paramInt));
      AppMethodBeat.o(94180);
      return;
      locala = b.gAi;
      if (k.g(paramString, b.anH()))
      {
        gzn = paramInt;
        ((ax)localObject).putInt(gzj, gzn);
      }
      else
      {
        locala = b.gAi;
        if (k.g(paramString, b.anG()))
        {
          gzo = paramInt;
          ((ax)localObject).putInt(gzl, gzo);
        }
      }
    }
    AppMethodBeat.o(94180);
  }
  
  public static int anv()
  {
    return gzm;
  }
  
  public static int anw()
  {
    return gzn;
  }
  
  public static int anx()
  {
    return gzo;
  }
  
  public static void b(m<? super String, ? super Integer, y> paramm)
  {
    gzp = paramm;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.media.widget.b.a.a
 * JD-Core Version:    0.7.0.1
 */