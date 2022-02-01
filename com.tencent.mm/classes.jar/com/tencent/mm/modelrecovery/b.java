package com.tencent.mm.modelrecovery;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.vfs.k;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.w;
import java.io.IOException;

public final class b
{
  public static void aKu()
  {
    AppMethodBeat.i(20588);
    k localk = new k(ak.getContext().getFilesDir(), "/recovery/recovery.log");
    String str = null;
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (localk.exists())
    {
      localObject1 = localObject2;
      if (localk.length() > 0L) {
        localObject1 = str;
      }
    }
    try
    {
      localObject2 = o.aZT(w.B(localk.fTh()));
      localObject1 = localObject2;
      localk.delete();
      localObject1 = localObject2;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        int k;
        int i;
        int j;
        ae.printErrStackTrace("MicroMsg.Recovery.RecoveryLogUtil", localIOException, "recoveryLog", new Object[0]);
        continue;
        if (str.equals("E"))
        {
          j = 0;
          continue;
          ae.e(localIOException[1], localIOException[2]);
          continue;
          ae.i("MicroMsg.Recovery.RecoveryLogUtil", str);
        }
      }
      AppMethodBeat.o(20588);
      return;
    }
    if (!bu.isNullOrNil((String)localObject1))
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
            ae.i(localObject2[1], localObject2[2]);
            i += 1;
          }
          break;
        }
      }
    }
    label259:
    ae.i("MicroMsg.Recovery.RecoveryLogUtil", "not found recovery log");
    AppMethodBeat.o(20588);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.modelrecovery.b
 * JD-Core Version:    0.7.0.1
 */