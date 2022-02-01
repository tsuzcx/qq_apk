package com.tencent.mm.plugin.appbrand.jsapi.share;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/jsapi/share/ShareResult;", "", "flattenVal", "", "(Ljava/lang/String;II)V", "getFlattenVal", "()I", "SUCCESS", "CANCEL", "FAIL", "Companion", "plugin-appbrand-integration_release"})
public enum ac
{
  public static final a prh;
  final int prg;
  
  static
  {
    AppMethodBeat.i(280393);
    ac localac1 = new ac("SUCCESS", 0, 0);
    prc = localac1;
    ac localac2 = new ac("CANCEL", 1, 1);
    prd = localac2;
    ac localac3 = new ac("FAIL", 2, 2);
    pre = localac3;
    prf = new ac[] { localac1, localac2, localac3 };
    prh = new a((byte)0);
    AppMethodBeat.o(280393);
  }
  
  private ac(int paramInt)
  {
    this.prg = paramInt;
  }
  
  public static final ac AK(int paramInt)
  {
    AppMethodBeat.i(280397);
    ac localac = a.AK(paramInt);
    AppMethodBeat.o(280397);
    return localac;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/jsapi/share/ShareResult$Companion;", "", "()V", "from", "Lcom/tencent/mm/plugin/appbrand/jsapi/share/ShareResult;", "flattenVal", "", "plugin-appbrand-integration_release"})
  public static final class a
  {
    public static ac AK(int paramInt)
    {
      AppMethodBeat.i(282143);
      ac[] arrayOfac = ac.values();
      int k = arrayOfac.length;
      int i = 0;
      while (i < k)
      {
        ac localac = arrayOfac[i];
        if (paramInt == localac.prg) {}
        for (int j = 1; j != 0; j = 0)
        {
          AppMethodBeat.o(282143);
          return localac;
        }
        i += 1;
      }
      AppMethodBeat.o(282143);
      return null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.share.ac
 * JD-Core Version:    0.7.0.1
 */