package com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/BlendMode;", "", "jsonVal", "", "(Ljava/lang/String;II)V", "getJsonVal", "()I", "NORMAL", "DARKEN", "MULTIPLY", "COLORBURN", "LINEARBURN", "DARKERCOLOR", "LIGHTEN", "SCREEN", "COLODDODGE", "LINEARDODGE", "LIGHTCOLOR", "OVERLAY", "SOFTLIGHT", "HARDLIGHT", "VIVIDLIGHT", "LINEARLIGHT", "PINLIGHT", "HARDMIX", "DIFFERENCE", "EXCLUSION", "SUBTRACT", "DIVIDE", "HUE", "SATURATION", "LUMINOSITY", "Companion", "luggage-xweb-ext_release"}, k=1, mv={1, 5, 1}, xi=48)
public enum a
{
  public static final a.a ezR;
  public final int jsonVal;
  
  static
  {
    AppMethodBeat.i(220811);
    ezS = new a("NORMAL", 0, 0);
    ezT = new a("DARKEN", 1, 1);
    ezU = new a("MULTIPLY", 2, 2);
    ezV = new a("COLORBURN", 3, 3);
    ezW = new a("LINEARBURN", 4, 4);
    ezX = new a("DARKERCOLOR", 5, 5);
    ezY = new a("LIGHTEN", 6, 6);
    ezZ = new a("SCREEN", 7, 7);
    eAa = new a("COLODDODGE", 8, 8);
    eAb = new a("LINEARDODGE", 9, 9);
    eAc = new a("LIGHTCOLOR", 10, 10);
    eAd = new a("OVERLAY", 11, 11);
    eAe = new a("SOFTLIGHT", 12, 12);
    eAf = new a("HARDLIGHT", 13, 13);
    eAg = new a("VIVIDLIGHT", 14, 14);
    eAh = new a("LINEARLIGHT", 15, 15);
    eAi = new a("PINLIGHT", 16, 16);
    eAj = new a("HARDMIX", 17, 17);
    eAk = new a("DIFFERENCE", 18, 18);
    eAl = new a("EXCLUSION", 19, 19);
    eAm = new a("SUBTRACT", 20, 20);
    eAn = new a("DIVIDE", 21, 21);
    eAo = new a("HUE", 22, 22);
    eAp = new a("SATURATION", 23, 23);
    eAq = new a("LUMINOSITY", 24, 24);
    eAr = new a[] { ezS, ezT, ezU, ezV, ezW, ezX, ezY, ezZ, eAa, eAb, eAc, eAd, eAe, eAf, eAg, eAh, eAi, eAj, eAk, eAl, eAm, eAn, eAo, eAp, eAq };
    ezR = new a.a((byte)0);
    AppMethodBeat.o(220811);
  }
  
  private a(int paramInt)
  {
    this.jsonVal = paramInt;
  }
  
  public static final a mE(int paramInt)
  {
    AppMethodBeat.i(220801);
    a[] arrayOfa = values();
    int k = arrayOfa.length;
    int i = 0;
    while (i < k)
    {
      a locala = arrayOfa[i];
      if (paramInt == locala.jsonVal) {}
      for (int j = 1; j != 0; j = 0)
      {
        AppMethodBeat.o(220801);
        return locala;
      }
      i += 1;
    }
    AppMethodBeat.o(220801);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.a
 * JD-Core Version:    0.7.0.1
 */