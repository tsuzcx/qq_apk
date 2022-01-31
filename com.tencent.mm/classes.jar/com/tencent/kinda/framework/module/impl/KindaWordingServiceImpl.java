package com.tencent.kinda.framework.module.impl;

import com.tencent.kinda.gen.KWordingService;
import com.tencent.kinda.gen.Wording;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class KindaWordingServiceImpl
  implements KWordingService
{
  public Wording getWording(String paramString1, String paramString2)
  {
    AppMethodBeat.i(144548);
    paramString1 = new Wording(false, "entryTip", "title", "subtitle", "desc", "subdesc");
    AppMethodBeat.o(144548);
    return paramString1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.kinda.framework.module.impl.KindaWordingServiceImpl
 * JD-Core Version:    0.7.0.1
 */