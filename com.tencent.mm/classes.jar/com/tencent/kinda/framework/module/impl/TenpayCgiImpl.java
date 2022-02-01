package com.tencent.kinda.framework.module.impl;

import com.tencent.kinda.gen.TenpayCgi;
import com.tencent.kinda.gen.TenpayCgiCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.q;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.g;
import java.util.HashMap;

public class TenpayCgiImpl
  implements TenpayCgi
{
  private static final String TAG = "WXP";
  
  public void request(int paramInt, HashMap<String, String> paramHashMap1, HashMap<String, String> paramHashMap2, TenpayCgiCallback paramTenpayCgiCallback)
  {
    AppMethodBeat.i(18681);
    String.format("requestTenpay: cgiId:%d", new Object[] { Integer.valueOf(paramInt) });
    paramHashMap1 = new NetSceneTenpay(paramInt, paramHashMap1, paramHashMap2, paramTenpayCgiCallback);
    g.ajD();
    g.ajB().gAO.a(paramHashMap1, 0);
    String.format("MMCore.getNetSceneQueue().doScene %s", new Object[] { paramHashMap1 });
    AppMethodBeat.o(18681);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.kinda.framework.module.impl.TenpayCgiImpl
 * JD-Core Version:    0.7.0.1
 */