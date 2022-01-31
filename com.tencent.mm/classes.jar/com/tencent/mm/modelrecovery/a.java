package com.tencent.mm.modelrecovery;

import android.content.Context;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.vfs.b;
import com.tencent.mm.vfs.e;
import com.tencent.mm.vfs.j;
import java.io.IOException;

public final class a
{
  public static void PM()
  {
    b localb = new b(ae.getContext().getFilesDir(), "/recovery/recovery.log");
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
      localObject2 = e.bP(j.n(localb.cLr()));
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
        y.printErrStackTrace("MicroMsg.Recovery.RecoveryLogUtil", localIOException, "recoveryLog", new Object[0]);
        continue;
        if (str.equals("E"))
        {
          j = 0;
          continue;
          y.e(localIOException[1], localIOException[2]);
          continue;
          y.i("MicroMsg.Recovery.RecoveryLogUtil", str);
        }
      }
      y.i("MicroMsg.Recovery.RecoveryLogUtil", "not found recovery log");
    }
    if (!bk.bl((String)localObject1))
    {
      localObject1 = ((String)localObject1).split("​​");
      k = localObject1.length;
      i = 0;
      for (;;)
      {
        if (i >= k) {
          return;
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
            y.i(localObject2[1], localObject2[2]);
            i += 1;
          }
          break;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.modelrecovery.a
 * JD-Core Version:    0.7.0.1
 */