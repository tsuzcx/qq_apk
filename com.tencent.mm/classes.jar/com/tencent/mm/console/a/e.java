package com.tencent.mm.console.a;

import android.content.Context;
import android.widget.Toast;
import com.tencent.mm.plugin.secinforeport.a.d;
import com.tencent.mm.pluginsdk.cmd.a;
import com.tencent.mm.sdk.platformtools.y;

public final class e
  implements a
{
  static
  {
    com.tencent.mm.pluginsdk.cmd.b.a(new e(), new String[] { "//normsg" });
  }
  
  public static void init() {}
  
  public final boolean a(Context paramContext, String[] paramArrayOfString)
  {
    if (!com.tencent.mm.sdk.a.b.cqk()) {}
    while (paramArrayOfString.length < 2) {
      return false;
    }
    try
    {
      if (paramArrayOfString.length >= 3) {
        Integer.valueOf(paramArrayOfString[2]).intValue();
      }
      label30:
      String str = paramArrayOfString[1].toLowerCase();
      long l1 = System.nanoTime();
      int i = -1;
      switch (str.hashCode())
      {
      }
      for (;;)
      {
        switch (i)
        {
        default: 
          return false;
        }
        d.nQr.dI(0, 15);
        Toast.makeText(paramContext, "info is reported.", 0).show();
        long l2 = System.nanoTime();
        paramArrayOfString = String.format("[NorMsgTest] cmd: %s, time: %d ns.", new Object[] { paramArrayOfString[1], Long.valueOf(l2 - l1) });
        y.i("MicroMsg.NorMsgTest", paramArrayOfString);
        Toast.makeText(paramContext, paramArrayOfString, 0).show();
        return true;
        if (str.equals("testrpp")) {
          i = 0;
        }
      }
    }
    catch (Exception localException)
    {
      break label30;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.console.a.e
 * JD-Core Version:    0.7.0.1
 */