package com.tencent.luggage.h;

import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/luggage/skyline/SkylineConfig;", "", "()V", "FLUTTER_SUR", "", "FLUTTER_TEX", "TAG", "", "WEBVIEW", "value", "renderBackend", "getRenderBackend$annotations", "getRenderBackend", "()I", "setRenderBackend", "(I)V", "sMMKV", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "isSkyline", "", "isSkylineSurfaceView", "isSkylineTextureView", "isWebView", "luggage-skyline-ext_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
{
  public static final c evV;
  private static final MultiProcessMMKV evW;
  
  static
  {
    AppMethodBeat.i(220027);
    evV = new c();
    MultiProcessMMKV localMultiProcessMMKV = MultiProcessMMKV.getMMKV("SkylineConfig", 2);
    s.checkNotNull(localMultiProcessMMKV);
    evW = localMultiProcessMMKV;
    AppMethodBeat.o(220027);
  }
  
  public static final int asS()
  {
    AppMethodBeat.i(219997);
    int i = evW.getInt("renderBackend", 0);
    AppMethodBeat.o(219997);
    return i;
  }
  
  public static boolean asT()
  {
    AppMethodBeat.i(220010);
    if (asS() == 0)
    {
      AppMethodBeat.o(220010);
      return true;
    }
    AppMethodBeat.o(220010);
    return false;
  }
  
  public static boolean asU()
  {
    AppMethodBeat.i(220016);
    if (!asV()) {
      if (asS() != 2) {
        break label31;
      }
    }
    label31:
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(220016);
      return true;
    }
    AppMethodBeat.o(220016);
    return false;
  }
  
  public static boolean asV()
  {
    AppMethodBeat.i(220021);
    if (asS() == 1)
    {
      AppMethodBeat.o(220021);
      return true;
    }
    AppMethodBeat.o(220021);
    return false;
  }
  
  public static final void mw(int paramInt)
  {
    AppMethodBeat.i(220005);
    evW.putInt("renderBackend", paramInt).commit();
    AppMethodBeat.o(220005);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.luggage.h.c
 * JD-Core Version:    0.7.0.1
 */