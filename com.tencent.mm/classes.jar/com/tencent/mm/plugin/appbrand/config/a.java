package com.tencent.mm.plugin.appbrand.config;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/config/ActionSheetControlIndex;", "", "index", "", "(Ljava/lang/String;II)V", "getIndex", "()I", "setIndex", "(I)V", "getControlByte", "config", "Lcom/tencent/mm/plugin/appbrand/config/AppBrandSysConfigWC;", "defaultValue", "ShareToWeWork", "ShareToFriend", "CopyShortLink", "SecFlagForSinglePageMode", "ShowTradeComplaint", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public enum a
{
  private int index;
  
  static
  {
    AppMethodBeat.i(323387);
    qVt = new a("ShareToWeWork", 0, 0);
    qVu = new a("ShareToFriend", 1, 1);
    qVv = new a("CopyShortLink", 2, 2);
    qVw = new a("SecFlagForSinglePageMode", 3, 3);
    qVx = new a("ShowTradeComplaint", 4, 4);
    qVy = new a[] { qVt, qVu, qVv, qVw, qVx };
    AppMethodBeat.o(323387);
  }
  
  private a(int paramInt)
  {
    this.index = paramInt;
  }
  
  public final int a(AppBrandSysConfigWC paramAppBrandSysConfigWC)
  {
    AppMethodBeat.i(323391);
    s.u(paramAppBrandSysConfigWC, "config");
    int i = a(this, paramAppBrandSysConfigWC);
    AppMethodBeat.o(323391);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.config.a
 * JD-Core Version:    0.7.0.1
 */