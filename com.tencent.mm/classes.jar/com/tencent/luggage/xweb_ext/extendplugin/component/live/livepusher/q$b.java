package com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/LipStickInfoV2$LipStickType;", "", "jsonVal", "", "(Ljava/lang/String;II)V", "getJsonVal", "()I", "MATTE", "SATIN", "MOIST", "HIGH_LIGHT", "PEARL", "METALLIC_LIGHT", "NEON_LIGHT", "Companion", "luggage-xweb-ext_release"}, k=1, mv={1, 5, 1}, xi=48)
public enum q$b
{
  public static final a eBd;
  public final int jsonVal;
  
  static
  {
    AppMethodBeat.i(220745);
    eBe = new b("MATTE", 0, 0);
    eBf = new b("SATIN", 1, 1);
    eBg = new b("MOIST", 2, 2);
    eBh = new b("HIGH_LIGHT", 3, 3);
    eBi = new b("PEARL", 4, 4);
    eBj = new b("METALLIC_LIGHT", 5, 5);
    eBk = new b("NEON_LIGHT", 6, 6);
    eBl = new b[] { eBe, eBf, eBg, eBh, eBi, eBj, eBk };
    eBd = new a((byte)0);
    AppMethodBeat.o(220745);
  }
  
  private q$b(int paramInt)
  {
    this.jsonVal = paramInt;
  }
  
  public static final b mG(int paramInt)
  {
    AppMethodBeat.i(220738);
    b[] arrayOfb = values();
    int k = arrayOfb.length;
    int i = 0;
    while (i < k)
    {
      b localb = arrayOfb[i];
      if (paramInt == localb.jsonVal) {}
      for (int j = 1; j != 0; j = 0)
      {
        AppMethodBeat.o(220738);
        return localb;
      }
      i += 1;
    }
    AppMethodBeat.o(220738);
    return null;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/LipStickInfoV2$LipStickType$Companion;", "", "()V", "from", "Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/LipStickInfoV2$LipStickType;", "typeInt", "", "luggage-xweb-ext_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.q.b
 * JD-Core Version:    0.7.0.1
 */