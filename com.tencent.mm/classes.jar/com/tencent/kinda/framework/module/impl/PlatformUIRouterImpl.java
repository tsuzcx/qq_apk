package com.tencent.kinda.framework.module.impl;

import com.tencent.kinda.gen.KPlatformUIRouter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.kt;
import com.tencent.mm.sdk.b.a;

public class PlatformUIRouterImpl
  implements KPlatformUIRouter
{
  public static final String TAG = "MicroMsg.PlatformUIRouterImpl";
  
  public void gotoExternApp(String paramString1, int paramInt1, String paramString2, String paramString3, String paramString4, int paramInt2, int paramInt3, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(18675);
    paramString3 = new kt();
    paramString3.dxQ.dqI = paramInt1;
    paramString3.dxQ.returnKey = paramString2;
    paramString3.dxQ.duW = paramString1;
    a.IbL.l(paramString3);
    AppMethodBeat.o(18675);
  }
  
  public void jointpayGotoExternApp(String paramString1, int paramInt1, String paramString2, String paramString3, String paramString4, int paramInt2, int paramInt3, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(18676);
    paramString3 = new kt();
    paramString3.dxQ.dqI = paramInt1;
    paramString3.dxQ.returnKey = paramString2;
    paramString3.dxQ.duW = paramString1;
    a.IbL.l(paramString3);
    AppMethodBeat.o(18676);
  }
  
  public void openUrlScheme(String paramString) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.kinda.framework.module.impl.PlatformUIRouterImpl
 * JD-Core Version:    0.7.0.1
 */