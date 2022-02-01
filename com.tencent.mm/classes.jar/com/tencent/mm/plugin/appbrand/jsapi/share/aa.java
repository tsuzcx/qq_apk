package com.tencent.mm.plugin.appbrand.jsapi.share;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/share/ShareResult;", "", "flattenVal", "", "(Ljava/lang/String;II)V", "getFlattenVal", "()I", "SUCCESS", "CANCEL", "FAIL", "Companion", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public enum aa
{
  public static final a svM;
  final int rht;
  
  static
  {
    AppMethodBeat.i(326361);
    svN = new aa("SUCCESS", 0, 0);
    svO = new aa("CANCEL", 1, 1);
    svP = new aa("FAIL", 2, 2);
    svQ = new aa[] { svN, svO, svP };
    svM = new a((byte)0);
    AppMethodBeat.o(326361);
  }
  
  private aa(int paramInt)
  {
    this.rht = paramInt;
  }
  
  public static final aa AY(int paramInt)
  {
    AppMethodBeat.i(326354);
    aa localaa = a.AY(paramInt);
    AppMethodBeat.o(326354);
    return localaa;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/share/ShareResult$Companion;", "", "()V", "from", "Lcom/tencent/mm/plugin/appbrand/jsapi/share/ShareResult;", "flattenVal", "", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    public static aa AY(int paramInt)
    {
      AppMethodBeat.i(326454);
      aa[] arrayOfaa = aa.values();
      int k = arrayOfaa.length;
      int i = 0;
      while (i < k)
      {
        aa localaa = arrayOfaa[i];
        if (paramInt == localaa.rht) {}
        for (int j = 1; j != 0; j = 0)
        {
          AppMethodBeat.o(326454);
          return localaa;
        }
        i += 1;
      }
      AppMethodBeat.o(326454);
      return null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.share.aa
 * JD-Core Version:    0.7.0.1
 */