package com.tencent.luggage.sdk.b.a.a;

import com.tencent.luggage.a.e;
import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.s.a;
import com.tencent.mm.plugin.appbrand.s.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.websocket.libwcwss.WcwssNative.IWcWssReportListener;
import java.util.ArrayList;

final class d$1
  implements WcwssNative.IWcWssReportListener
{
  d$1(d paramd) {}
  
  public final int getNetworkType()
  {
    AppMethodBeat.i(146765);
    int i = d.getStatisticsNetType();
    AppMethodBeat.o(146765);
    return i;
  }
  
  public final void onIdKeyStat(int[] paramArrayOfInt1, int[] paramArrayOfInt2, int[] paramArrayOfInt3)
  {
    AppMethodBeat.i(146767);
    ae.d("Luggage.WcWssNativeInstallHelper", "MMWcWss onIdKeyStat");
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < paramArrayOfInt1.length)
    {
      localArrayList.add(new IDKey(paramArrayOfInt1[i], paramArrayOfInt2[i], paramArrayOfInt3[i]));
      i += 1;
    }
    ((a)e.L(a.class)).b(localArrayList, false);
    AppMethodBeat.o(146767);
  }
  
  public final void onKvStat(int paramInt, String paramString)
  {
    AppMethodBeat.i(146766);
    ae.d("Luggage.WcWssNativeInstallHelper", "MMWcWss onKvStat logId:%d", new Object[] { Integer.valueOf(paramInt) });
    ((b)e.L(b.class)).kvStat(paramInt, paramString);
    AppMethodBeat.o(146766);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.luggage.sdk.b.a.a.d.1
 * JD-Core Version:    0.7.0.1
 */