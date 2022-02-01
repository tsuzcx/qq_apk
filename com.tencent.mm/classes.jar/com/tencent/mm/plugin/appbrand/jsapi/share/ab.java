package com.tencent.mm.plugin.appbrand.jsapi.share;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/jsapi/share/ShareResult;", "", "flattenVal", "", "(Ljava/lang/String;II)V", "getFlattenVal", "()I", "SUCCESS", "CANCEL", "FAIL", "Companion", "plugin-appbrand-integration_release"})
public enum ab
{
  public static final a msY;
  final int msX;
  
  static
  {
    AppMethodBeat.i(228550);
    ab localab1 = new ab("SUCCESS", 0, 0);
    msT = localab1;
    ab localab2 = new ab("CANCEL", 1, 1);
    msU = localab2;
    ab localab3 = new ab("FAIL", 2, 2);
    msV = localab3;
    msW = new ab[] { localab1, localab2, localab3 };
    msY = new a((byte)0);
    AppMethodBeat.o(228550);
  }
  
  private ab(int paramInt)
  {
    this.msX = paramInt;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/jsapi/share/ShareResult$Companion;", "", "()V", "from", "Lcom/tencent/mm/plugin/appbrand/jsapi/share/ShareResult;", "flattenVal", "", "plugin-appbrand-integration_release"})
  public static final class a
  {
    public static ab xo(int paramInt)
    {
      AppMethodBeat.i(228549);
      ab[] arrayOfab = ab.values();
      int k = arrayOfab.length;
      int i = 0;
      while (i < k)
      {
        ab localab = arrayOfab[i];
        if (paramInt == localab.msX) {}
        for (int j = 1; j != 0; j = 0)
        {
          AppMethodBeat.o(228549);
          return localab;
        }
        i += 1;
      }
      AppMethodBeat.o(228549);
      return null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.share.ab
 * JD-Core Version:    0.7.0.1
 */