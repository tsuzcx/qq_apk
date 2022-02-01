package com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/LipStickInfo$LipStickType;", "", "jsonVal", "", "(Ljava/lang/String;II)V", "getJsonVal", "()I", "MATTE", "SATIN", "MOIST", "HIGH_LIGHT", "PEARL", "METALLIC_LIGHT", "NEON_LIGHT", "Companion", "luggage-xweb-ext_release"})
public enum o$b
{
  public static final a cHO;
  public final int jsonVal;
  
  static
  {
    AppMethodBeat.i(228594);
    b localb1 = new b("MATTE", 0, 0);
    cHG = localb1;
    b localb2 = new b("SATIN", 1, 1);
    cHH = localb2;
    b localb3 = new b("MOIST", 2, 2);
    cHI = localb3;
    b localb4 = new b("HIGH_LIGHT", 3, 3);
    cHJ = localb4;
    b localb5 = new b("PEARL", 4, 4);
    cHK = localb5;
    b localb6 = new b("METALLIC_LIGHT", 5, 5);
    cHL = localb6;
    b localb7 = new b("NEON_LIGHT", 6, 6);
    cHM = localb7;
    cHN = new b[] { localb1, localb2, localb3, localb4, localb5, localb6, localb7 };
    cHO = new a((byte)0);
    AppMethodBeat.o(228594);
  }
  
  private o$b(int paramInt)
  {
    this.jsonVal = paramInt;
  }
  
  public static final b jd(int paramInt)
  {
    AppMethodBeat.i(228609);
    b[] arrayOfb = values();
    int k = arrayOfb.length;
    int i = 0;
    while (i < k)
    {
      b localb = arrayOfb[i];
      if (paramInt == localb.jsonVal) {}
      for (int j = 1; j != 0; j = 0)
      {
        AppMethodBeat.o(228609);
        return localb;
      }
      i += 1;
    }
    AppMethodBeat.o(228609);
    return null;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/LipStickInfo$LipStickType$Companion;", "", "()V", "from", "Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/LipStickInfo$LipStickType;", "typeInt", "", "luggage-xweb-ext_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.o.b
 * JD-Core Version:    0.7.0.1
 */