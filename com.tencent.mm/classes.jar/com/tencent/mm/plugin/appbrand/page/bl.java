package com.tencent.mm.plugin.appbrand.page;

import com.tencent.matrix.trace.core.AppMethodBeat;

 enum bl
{
  static
  {
    AppMethodBeat.i(140969);
    izZ = new bl("NONE", 0);
    iAa = new bl("ON_PRELOAD", 1);
    iAb = new bl("ON_INIT", 2);
    iAc = new bl("ON_RECYCLE", 3);
    iAd = new bl("ON_FOREGROUND", 4);
    iAe = new bl("ON_BACKGROUND", 5);
    iAf = new bl("ON_EVALUATE", 6);
    iAg = new bl("PAGE_FRAME_READY", 7);
    iAh = new bl[] { izZ, iAa, iAb, iAc, iAd, iAe, iAf, iAg };
    AppMethodBeat.o(140969);
  }
  
  private bl() {}
  
  public static bl pn(int paramInt)
  {
    AppMethodBeat.i(140967);
    Object localObject = values();
    int j = localObject.length;
    int i = 0;
    while (i < j)
    {
      bl localbl = localObject[i];
      if (localbl.po(paramInt))
      {
        AppMethodBeat.o(140967);
        return localbl;
      }
      i += 1;
    }
    localObject = izZ;
    AppMethodBeat.o(140967);
    return localObject;
  }
  
  public final boolean po(int paramInt)
  {
    AppMethodBeat.i(140968);
    if (ordinal() == paramInt)
    {
      AppMethodBeat.o(140968);
      return true;
    }
    AppMethodBeat.o(140968);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.bl
 * JD-Core Version:    0.7.0.1
 */