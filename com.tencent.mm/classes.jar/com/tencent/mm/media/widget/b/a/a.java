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

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/media/widget/camera2/effect/VendorFaceBeautyConfig;", "", "()V", "KEY_FB_LEVEL", "", "getKEY_FB_LEVEL", "()Ljava/lang/String;", "KEY_SKIN_RATE", "getKEY_SKIN_RATE", "KEY_SLIM_RATE", "getKEY_SLIM_RATE", "MMKV_NAME", "TAG", "getTAG", "fbLevel", "", "getFbLevel", "()I", "setFbLevel", "(I)V", "onConfigChange", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "type", "value", "", "getOnConfigChange", "()Lkotlin/jvm/functions/Function2;", "setOnConfigChange", "(Lkotlin/jvm/functions/Function2;)V", "skinLevel", "getSkinLevel", "setSkinLevel", "slimLevel", "getSlimLevel", "setSlimLevel", "setConfig", "plugin-mediaeditor_release"})
public final class a
{
  private static final String TAG = "MicroMsg.VendorConfig";
  private static final String iob = "vendor_skin_rate";
  private static final String ioc = "vendor_fb_level";
  private static final String iod = "vendor_slim_rate";
  private static int ioe;
  private static int iof;
  private static int iog;
  private static m<? super String, ? super Integer, x> ioh;
  public static final a ioi;
  
  static
  {
    AppMethodBeat.i(94181);
    ioi = new a();
    TAG = "MicroMsg.VendorConfig";
    iob = "vendor_skin_rate";
    ioc = "vendor_fb_level";
    iod = "vendor_slim_rate";
    ioe = 3;
    iof = 40;
    iog = 40;
    AppMethodBeat.o(94181);
  }
  
  public static int aPN()
  {
    return ioe;
  }
  
  public static int aPO()
  {
    return iof;
  }
  
  public static int aPP()
  {
    return iog;
  }
  
  public static void ae(String paramString, int paramInt)
  {
    AppMethodBeat.i(94180);
    p.h(paramString, "type");
    Log.i(TAG, "setConfig: " + paramString + ", " + paramInt);
    Object localObject = MultiProcessMMKV.getMMKV("vendor_effect_config");
    b.a locala = b.ipa;
    if (p.j(paramString, b.aPX()))
    {
      ioe = paramInt;
      ((MultiProcessMMKV)localObject).putInt(ioc, ioe);
    }
    for (;;)
    {
      localObject = ioh;
      if (localObject == null) {
        break;
      }
      ((m)localObject).invoke(paramString, Integer.valueOf(paramInt));
      AppMethodBeat.o(94180);
      return;
      locala = b.ipa;
      if (p.j(paramString, b.aPZ()))
      {
        iof = paramInt;
        ((MultiProcessMMKV)localObject).putInt(iob, iof);
      }
      else
      {
        locala = b.ipa;
        if (p.j(paramString, b.aPY()))
        {
          iog = paramInt;
          ((MultiProcessMMKV)localObject).putInt(iod, iog);
        }
      }
    }
    AppMethodBeat.o(94180);
  }
  
  public static void b(m<? super String, ? super Integer, x> paramm)
  {
    ioh = paramm;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.media.widget.b.a.a
 * JD-Core Version:    0.7.0.1
 */