package com.tencent.mm.media.widget.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.widget.b.a.a.b;
import com.tencent.mm.media.widget.b.a.a.b.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/media/widget/camera2/effect/VendorFaceBeautyConfig;", "", "()V", "KEY_FB_LEVEL", "", "getKEY_FB_LEVEL", "()Ljava/lang/String;", "KEY_SKIN_RATE", "getKEY_SKIN_RATE", "KEY_SLIM_RATE", "getKEY_SLIM_RATE", "MMKV_NAME", "TAG", "getTAG", "fbLevel", "", "getFbLevel", "()I", "setFbLevel", "(I)V", "onConfigChange", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "type", "value", "", "getOnConfigChange", "()Lkotlin/jvm/functions/Function2;", "setOnConfigChange", "(Lkotlin/jvm/functions/Function2;)V", "skinLevel", "getSkinLevel", "setSkinLevel", "slimLevel", "getSlimLevel", "setSlimLevel", "setConfig", "plugin-mediaeditor_release"})
public final class a
{
  private static final String TAG = "MicroMsg.VendorConfig";
  private static final String ldg = "vendor_skin_rate";
  private static final String ldh = "vendor_fb_level";
  private static final String ldi = "vendor_slim_rate";
  private static int ldj;
  private static int ldk;
  private static int ldl;
  private static m<? super String, ? super Integer, x> ldm;
  public static final a ldn;
  
  static
  {
    AppMethodBeat.i(94181);
    ldn = new a();
    TAG = "MicroMsg.VendorConfig";
    ldg = "vendor_skin_rate";
    ldh = "vendor_fb_level";
    ldi = "vendor_slim_rate";
    ldj = 3;
    ldk = 40;
    ldl = 40;
    AppMethodBeat.o(94181);
  }
  
  public static int aYE()
  {
    return ldj;
  }
  
  public static int aYF()
  {
    return ldk;
  }
  
  public static int aYG()
  {
    return ldl;
  }
  
  public static void aw(String paramString, int paramInt)
  {
    AppMethodBeat.i(94180);
    p.k(paramString, "type");
    Log.i(TAG, "setConfig: " + paramString + ", " + paramInt);
    Object localObject = MultiProcessMMKV.getMMKV("vendor_effect_config");
    b.a locala = b.lef;
    if (p.h(paramString, b.aYO()))
    {
      ldj = paramInt;
      ((MultiProcessMMKV)localObject).putInt(ldh, ldj);
    }
    for (;;)
    {
      localObject = ldm;
      if (localObject == null) {
        break;
      }
      ((m)localObject).invoke(paramString, Integer.valueOf(paramInt));
      AppMethodBeat.o(94180);
      return;
      locala = b.lef;
      if (p.h(paramString, b.aYQ()))
      {
        ldk = paramInt;
        ((MultiProcessMMKV)localObject).putInt(ldg, ldk);
      }
      else
      {
        locala = b.lef;
        if (p.h(paramString, b.aYP()))
        {
          ldl = paramInt;
          ((MultiProcessMMKV)localObject).putInt(ldi, ldl);
        }
      }
    }
    AppMethodBeat.o(94180);
  }
  
  public static void b(m<? super String, ? super Integer, x> paramm)
  {
    ldm = paramm;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.media.widget.b.a.a
 * JD-Core Version:    0.7.0.1
 */