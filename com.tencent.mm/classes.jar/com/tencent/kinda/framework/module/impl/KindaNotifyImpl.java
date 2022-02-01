package com.tencent.kinda.framework.module.impl;

import com.tencent.kinda.gen.KindaNotify;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.nj;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;

public class KindaNotifyImpl
  implements KindaNotify
{
  public static final String TAG = "MicroMsg.KindaNotifyImpl";
  
  public void notify(String paramString, HashMap<String, String> paramHashMap)
  {
    AppMethodBeat.i(18645);
    Log.i("MicroMsg.KindaNotifyImpl", "key:%s, value:%s", new Object[] { paramString, paramHashMap.toString() });
    nj localnj = new nj();
    localnj.hPK.key = paramString;
    localnj.hPK.hPL = paramHashMap;
    localnj.publish();
    AppMethodBeat.o(18645);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.kinda.framework.module.impl.KindaNotifyImpl
 * JD-Core Version:    0.7.0.1
 */