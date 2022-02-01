package com.tencent.mm.openim.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.k.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.zero.b.a;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/openim/util/OpenImKefuConfigManager;", "", "()V", "TAG", "", "contactUpdateIntervalInSeconds", "", "getContactUpdateInterval", "plugin-comm_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
{
  public static final b pvM;
  private static long pvN;
  
  static
  {
    AppMethodBeat.i(235732);
    pvM = new b();
    pvN = 86400L;
    int i = ((a)h.ax(a.class)).aRC().getInt("OpenImKefuContactUpdateInterval_Second", 86400);
    if (i > 0) {
      pvN = i;
    }
    Log.i("MicroMsg.OpenImKefuConfigManager", "alvinluo initOpenImKefuConfig configUpdateInterval: " + i + ", finalUpdateInterval: " + pvN);
    AppMethodBeat.o(235732);
  }
  
  public static final long bSE()
  {
    return pvN;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.openim.f.b
 * JD-Core Version:    0.7.0.1
 */