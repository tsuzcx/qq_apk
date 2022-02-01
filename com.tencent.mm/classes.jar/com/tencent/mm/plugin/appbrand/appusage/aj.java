package com.tencent.mm.plugin.appbrand.appusage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/appusage/NotifyType;", "", "value", "", "(Ljava/lang/String;II)V", "getValue", "()I", "MODIFY_HISTORY_LIST", "MODIFY_STAR_LIST", "DELETE_HISTORY_LIST", "DELETE_STAR_LIST", "Companion", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public enum aj
{
  public static final a qQg;
  final int value;
  
  static
  {
    AppMethodBeat.i(319381);
    qQh = new aj("MODIFY_HISTORY_LIST", 0, 1);
    qQi = new aj("MODIFY_STAR_LIST", 1, 2);
    qQj = new aj("DELETE_HISTORY_LIST", 2, 3);
    qQk = new aj("DELETE_STAR_LIST", 3, 4);
    qQl = new aj[] { qQh, qQi, qQj, qQk };
    qQg = new a((byte)0);
    AppMethodBeat.o(319381);
  }
  
  private aj(int paramInt)
  {
    this.value = paramInt;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/appusage/NotifyType$Companion;", "", "()V", "getByValue", "Lcom/tencent/mm/plugin/appbrand/appusage/NotifyType;", "value", "", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    public static aj zy(int paramInt)
    {
      AppMethodBeat.i(319329);
      aj[] arrayOfaj = aj.values();
      int k = arrayOfaj.length;
      int i = 0;
      while (i < k)
      {
        aj localaj = arrayOfaj[i];
        if (localaj.value == paramInt) {}
        for (int j = 1; j != 0; j = 0)
        {
          AppMethodBeat.o(319329);
          return localaj;
        }
        i += 1;
      }
      AppMethodBeat.o(319329);
      return null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appusage.aj
 * JD-Core Version:    0.7.0.1
 */