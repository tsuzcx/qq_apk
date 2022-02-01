package com.tencent.mm.media.widget.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.widget.b.a.a.b;
import com.tencent.mm.media.widget.b.a.a.b.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.m;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/media/widget/camera2/effect/VendorFaceBeautyConfig;", "", "()V", "KEY_FB_LEVEL", "", "getKEY_FB_LEVEL", "()Ljava/lang/String;", "KEY_SKIN_RATE", "getKEY_SKIN_RATE", "KEY_SLIM_RATE", "getKEY_SLIM_RATE", "MMKV_NAME", "TAG", "getTAG", "fbLevel", "", "getFbLevel", "()I", "setFbLevel", "(I)V", "onConfigChange", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "type", "value", "", "getOnConfigChange", "()Lkotlin/jvm/functions/Function2;", "setOnConfigChange", "(Lkotlin/jvm/functions/Function2;)V", "skinLevel", "getSkinLevel", "setSkinLevel", "slimLevel", "getSlimLevel", "setSlimLevel", "setConfig", "plugin-mediaeditor_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
{
  private static final String TAG;
  public static final a nHT;
  private static final String nHU;
  private static final String nHV;
  private static final String nHW;
  private static int nHX;
  private static int nHY;
  private static int nHZ;
  private static m<? super String, ? super Integer, ah> nIa;
  
  static
  {
    AppMethodBeat.i(94181);
    nHT = new a();
    TAG = "MicroMsg.VendorConfig";
    nHU = "vendor_skin_rate";
    nHV = "vendor_fb_level";
    nHW = "vendor_slim_rate";
    nHX = 3;
    nHY = 40;
    nHZ = 40;
    AppMethodBeat.o(94181);
  }
  
  public static void aF(String paramString, int paramInt)
  {
    AppMethodBeat.i(94180);
    s.u(paramString, "type");
    Log.i(TAG, "setConfig: " + paramString + ", " + paramInt);
    Object localObject = MultiProcessMMKV.getMMKV("vendor_effect_config");
    b.a locala = b.nIE;
    if (s.p(paramString, b.btN()))
    {
      nHX = paramInt;
      ((MultiProcessMMKV)localObject).putInt(nHV, nHX);
    }
    for (;;)
    {
      localObject = nIa;
      if (localObject != null) {
        ((m)localObject).invoke(paramString, Integer.valueOf(paramInt));
      }
      AppMethodBeat.o(94180);
      return;
      locala = b.nIE;
      if (s.p(paramString, b.btP()))
      {
        nHY = paramInt;
        ((MultiProcessMMKV)localObject).putInt(nHU, nHY);
      }
      else
      {
        locala = b.nIE;
        if (s.p(paramString, b.btO()))
        {
          nHZ = paramInt;
          ((MultiProcessMMKV)localObject).putInt(nHW, nHZ);
        }
      }
    }
  }
  
  public static int btD()
  {
    return nHX;
  }
  
  public static int btE()
  {
    return nHY;
  }
  
  public static int btF()
  {
    return nHZ;
  }
  
  public static void i(m<? super String, ? super Integer, ah> paramm)
  {
    nIa = paramm;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.media.widget.b.a.a
 * JD-Core Version:    0.7.0.1
 */