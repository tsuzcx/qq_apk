package com.tencent.kinda.framework.module.impl;

import com.tencent.kinda.gen.KindaWebService;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.brandservice.a.d;
import com.tencent.mm.plugin.brandservice.a.d.a;
import com.tencent.mm.sdk.platformtools.ae;
import java.util.ArrayList;
import java.util.List;

public class KindaWebServiceImpl
  implements KindaWebService
{
  private static final String TAG = "MicroMsg.KindaWebServiceImpl";
  
  public void preLoad(String paramString)
  {
    AppMethodBeat.i(193161);
    ae.i("MicroMsg.KindaWebServiceImpl", "preload Url:".concat(String.valueOf(paramString)));
    if (paramString.length() == 0)
    {
      AppMethodBeat.o(193161);
      return;
    }
    d.a locala = new d.a();
    locala.url = paramString;
    locala.obQ = 175;
    paramString = new ArrayList();
    paramString.add(locala);
    ((d)g.ab(d.class)).cf(paramString);
    AppMethodBeat.o(193161);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.kinda.framework.module.impl.KindaWebServiceImpl
 * JD-Core Version:    0.7.0.1
 */