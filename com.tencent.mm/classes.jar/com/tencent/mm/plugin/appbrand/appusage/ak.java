package com.tencent.mm.plugin.appbrand.appusage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/appusage/NotifyType;", "", "value", "", "(Ljava/lang/String;II)V", "getValue", "()I", "MODIFY_HISTORY_LIST", "MODIFY_STAR_LIST", "DELETE_HISTORY_LIST", "DELETE_STAR_LIST", "Companion", "plugin-appbrand-integration_release"})
public enum ak
{
  public static final a nQw;
  final int value;
  
  static
  {
    AppMethodBeat.i(274183);
    ak localak1 = new ak("MODIFY_HISTORY_LIST", 0, 1);
    nQr = localak1;
    ak localak2 = new ak("MODIFY_STAR_LIST", 1, 2);
    nQs = localak2;
    ak localak3 = new ak("DELETE_HISTORY_LIST", 2, 3);
    nQt = localak3;
    ak localak4 = new ak("DELETE_STAR_LIST", 3, 4);
    nQu = localak4;
    nQv = new ak[] { localak1, localak2, localak3, localak4 };
    nQw = new a((byte)0);
    AppMethodBeat.o(274183);
  }
  
  private ak(int paramInt)
  {
    this.value = paramInt;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/appusage/NotifyType$Companion;", "", "()V", "getByValue", "Lcom/tencent/mm/plugin/appbrand/appusage/NotifyType;", "value", "", "plugin-appbrand-integration_release"})
  public static final class a
  {
    public static ak zl(int paramInt)
    {
      AppMethodBeat.i(258304);
      ak[] arrayOfak = ak.values();
      int k = arrayOfak.length;
      int i = 0;
      while (i < k)
      {
        ak localak = arrayOfak[i];
        if (localak.value == paramInt) {}
        for (int j = 1; j != 0; j = 0)
        {
          AppMethodBeat.o(258304);
          return localak;
        }
        i += 1;
      }
      AppMethodBeat.o(258304);
      return null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appusage.ak
 * JD-Core Version:    0.7.0.1
 */