package com.tencent.kinda.framework.module.impl;

import com.tencent.kinda.gen.KindaWebService;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.brandservice.a.e;
import com.tencent.mm.plugin.brandservice.a.e.a;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.List;

public class KindaWebServiceImpl
  implements KindaWebService
{
  private static final String TAG = "MicroMsg.KindaWebServiceImpl";
  
  public void preLoad(String paramString)
  {
    AppMethodBeat.i(214452);
    Log.i("MicroMsg.KindaWebServiceImpl", "preload Url:".concat(String.valueOf(paramString)));
    if (paramString.length() == 0)
    {
      AppMethodBeat.o(214452);
      return;
    }
    e.a locala = new e.a();
    locala.url = paramString;
    locala.pmM = 175;
    paramString = new ArrayList();
    paramString.add(locala);
    ((e)g.af(e.class)).cu(paramString);
    AppMethodBeat.o(214452);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.kinda.framework.module.impl.KindaWebServiceImpl
 * JD-Core Version:    0.7.0.1
 */