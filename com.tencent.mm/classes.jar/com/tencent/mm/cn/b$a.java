package com.tencent.mm.cn;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.ipcinvoker.i;
import com.tencent.mm.ipcinvoker.type.IPCString;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.e;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.ArrayList;

final class b$a
  implements i<IPCString, Bundle>
{
  private static Bundle f(IPCString paramIPCString)
  {
    AppMethodBeat.i(80382);
    Bundle localBundle = new Bundle();
    for (;;)
    {
      try
      {
        ArrayList localArrayList = new ArrayList();
        if (!bo.isNullOrNil(paramIPCString.value))
        {
          i = g.RK().eHt.ftA.getHostByName(paramIPCString.value, localArrayList);
          localBundle.putStringArrayList("ipList", localArrayList);
          localBundle.putInt("result", i);
          AppMethodBeat.o(80382);
          return localBundle;
        }
      }
      catch (Exception paramIPCString)
      {
        ab.printErrStackTrace("GetHostByNameTask", paramIPCString, "GetHostByNameTask", new Object[0]);
        AppMethodBeat.o(80382);
        return localBundle;
      }
      int i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.cn.b.a
 * JD-Core Version:    0.7.0.1
 */