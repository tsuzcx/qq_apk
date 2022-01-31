package com.tencent.mm.modelrecovery;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.vfs.b;
import com.tencent.mm.vfs.e;
import com.tencent.mm.vfs.j;
import java.io.IOException;

public final class a
{
  public static void aiR()
  {
    AppMethodBeat.i(16543);
    b localb = new b(ah.getContext().getFilesDir(), "/recovery/recovery.log");
    String str = null;
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (localb.exists())
    {
      localObject1 = localObject2;
      if (localb.length() > 0L) {
        localObject1 = str;
      }
    }
    try
    {
      localObject2 = e.cS(j.p(localb.dQJ()));
      localObject1 = localObject2;
      localb.delete();
      localObject1 = localObject2;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        int k;
        int i;
        int j;
        ab.printErrStackTrace("MicroMsg.Recovery.RecoveryLogUtil", localIOException, "recoveryLog", new Object[0]);
        continue;
        if (str.equals("E"))
        {
          j = 0;
          continue;
          ab.e(localIOException[1], localIOException[2]);
          continue;
          ab.i("MicroMsg.Recovery.RecoveryLogUtil", str);
        }
      }
      AppMethodBeat.o(16543);
      return;
    }
    if (!bo.isNullOrNil((String)localObject1))
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
            ab.i(localObject2[1], localObject2[2]);
            i += 1;
          }
          break;
        }
      }
    }
    label259:
    ab.i("MicroMsg.Recovery.RecoveryLogUtil", "not found recovery log");
    AppMethodBeat.o(16543);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.modelrecovery.a
 * JD-Core Version:    0.7.0.1
 */