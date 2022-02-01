package com.tencent.mm.modelrecovery;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.ah;
import com.tencent.mm.vfs.u;
import com.tencent.mm.vfs.y;
import java.io.IOException;

public final class b
{
  public static void bLJ()
  {
    AppMethodBeat.i(20588);
    u localu = new u(MMApplicationContext.getContext().getFilesDir(), "/recovery/recovery.log");
    String str = null;
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (localu.jKS())
    {
      localObject1 = localObject2;
      if (localu.length() > 0L) {
        localObject1 = str;
      }
    }
    try
    {
      localObject2 = y.bEn(ah.v(localu.jKT()));
      localObject1 = localObject2;
      localu.diJ();
      localObject1 = localObject2;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        int k;
        int i;
        int j;
        Log.printErrStackTrace("MicroMsg.Recovery.RecoveryLogUtil", localIOException, "recoveryLog", new Object[0]);
        continue;
        if (str.equals("E"))
        {
          j = 0;
          continue;
          Log.e(localIOException[1], localIOException[2]);
          continue;
          Log.i("MicroMsg.Recovery.RecoveryLogUtil", str);
        }
      }
      AppMethodBeat.o(20588);
      return;
    }
    if (!Util.isNullOrNil((String)localObject1))
    {
      localObject1 = ((String)localObject1).split("​​");
      k = localObject1.length;
      i = 0;
      for (;;)
      {
        if (i >= k) {
          break label259;
        }
        str = localObject1[i];
        localObject2 = str.split("​");
        if ((localObject2 == null) || (localObject2.length != 3)) {
          break;
        }
        str = localObject2[0];
        j = -1;
        switch (str.hashCode())
        {
        default: 
          switch (j)
          {
          default: 
            Log.i(localObject2[1], localObject2[2]);
            i += 1;
          }
          break;
        }
      }
    }
    label259:
    Log.i("MicroMsg.Recovery.RecoveryLogUtil", "not found recovery log");
    AppMethodBeat.o(20588);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.modelrecovery.b
 * JD-Core Version:    0.7.0.1
 */