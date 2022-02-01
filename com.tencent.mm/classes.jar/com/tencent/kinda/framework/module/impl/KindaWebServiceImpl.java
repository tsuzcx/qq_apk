package com.tencent.kinda.framework.module.impl;

import com.tencent.kinda.gen.KindaWebService;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.brandservice.api.h.a;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.List;

public class KindaWebServiceImpl
  implements KindaWebService
{
  private static final String TAG = "MicroMsg.KindaWebServiceImpl";
  
  public void preLoad(String paramString)
  {
    AppMethodBeat.i(226677);
    Log.i("MicroMsg.KindaWebServiceImpl", "preload Url:".concat(String.valueOf(paramString)));
    if (paramString.length() == 0)
    {
      AppMethodBeat.o(226677);
      return;
    }
    h.a locala = new h.a();
    locala.url = paramString;
    locala.vAZ = 175;
    paramString = new ArrayList();
    paramString.add(locala);
    ((com.tencent.mm.plugin.brandservice.api.h)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.brandservice.api.h.class)).ei(paramString);
    AppMethodBeat.o(226677);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.kinda.framework.module.impl.KindaWebServiceImpl
 * JD-Core Version:    0.7.0.1
 */