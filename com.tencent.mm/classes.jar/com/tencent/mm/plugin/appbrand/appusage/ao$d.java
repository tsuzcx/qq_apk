package com.tencent.mm.plugin.appbrand.appusage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/appusage/WxaDesktopHeaderEntranceLogic$ShowCaseType;", "", "(Ljava/lang/String;I)V", "TYPE_NULL", "TYPE_WORDING", "TYPE_ICON_WORDING", "TYPE_ICON_WORDING_ICON2", "TYPE_WORDING_ICON", "Companion", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public enum ao$d
{
  public static final ao.d.a qQw;
  
  static
  {
    AppMethodBeat.i(180439);
    qQx = new d("TYPE_NULL", 0);
    qQy = new d("TYPE_WORDING", 1);
    qQz = new d("TYPE_ICON_WORDING", 2);
    qQA = new d("TYPE_ICON_WORDING_ICON2", 3);
    qQB = new d("TYPE_WORDING_ICON", 4);
    qQC = new d[] { qQx, qQy, qQz, qQA, qQB };
    qQw = new ao.d.a((byte)0);
    AppMethodBeat.o(180439);
  }
  
  private ao$d() {}
  
  public static final d zz(int paramInt)
  {
    AppMethodBeat.i(180442);
    d[] arrayOfd = values();
    int j = arrayOfd.length;
    int i = 0;
    while (i < j)
    {
      d locald = arrayOfd[i];
      if (paramInt == locald.ordinal())
      {
        AppMethodBeat.o(180442);
        return locald;
      }
      i += 1;
    }
    AppMethodBeat.o(180442);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appusage.ao.d
 * JD-Core Version:    0.7.0.1
 */