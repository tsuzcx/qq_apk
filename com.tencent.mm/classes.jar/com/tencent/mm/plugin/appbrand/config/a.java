package com.tencent.mm.plugin.appbrand.config;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/config/ActionSheetControlIndex;", "", "index", "", "(Ljava/lang/String;II)V", "getIndex", "()I", "setIndex", "(I)V", "getControlByte", "config", "Lcom/tencent/mm/plugin/appbrand/config/AppBrandSysConfigWC;", "ShareToWeWork", "ShareToFriend", "CopyShortLink", "plugin-appbrand-integration_release"})
public enum a
{
  private int index;
  
  static
  {
    AppMethodBeat.i(228162);
    a locala1 = new a("ShareToWeWork", 0, 0);
    lbD = locala1;
    a locala2 = new a("ShareToFriend", 1, 1);
    lbE = locala2;
    a locala3 = new a("CopyShortLink", 2, 2);
    lbF = locala3;
    lbG = new a[] { locala1, locala2, locala3 };
    AppMethodBeat.o(228162);
  }
  
  private a(int paramInt)
  {
    this.index = paramInt;
  }
  
  public final int a(AppBrandSysConfigWC paramAppBrandSysConfigWC)
  {
    AppMethodBeat.i(228163);
    p.h(paramAppBrandSysConfigWC, "config");
    paramAppBrandSysConfigWC = paramAppBrandSysConfigWC.leL;
    int i;
    if (paramAppBrandSysConfigWC == null)
    {
      i = 1;
      if ((i == 0) && (paramAppBrandSysConfigWC.length - 1 >= this.index)) {
        break label89;
      }
      i = 0;
    }
    for (;;)
    {
      Log.i("MicroMsg.ActionSheetControlIndex", "getControlByte for " + name() + " [" + i + ']');
      AppMethodBeat.o(228163);
      return i;
      i = 0;
      break;
      label89:
      i = paramAppBrandSysConfigWC[this.index];
      if (i < 0) {}
      while (2 < i)
      {
        i = 0;
        break;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.config.a
 * JD-Core Version:    0.7.0.1
 */