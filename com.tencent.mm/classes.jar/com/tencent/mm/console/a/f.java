package com.tencent.mm.console.a;

import android.content.Context;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.secinforeport.a.d;
import com.tencent.mm.pluginsdk.cmd.a;
import com.tencent.mm.sdk.platformtools.ae;

public final class f
  implements a
{
  static
  {
    AppMethodBeat.i(20180);
    com.tencent.mm.pluginsdk.cmd.b.a(new f(), new String[] { "//normsg" });
    AppMethodBeat.o(20180);
  }
  
  public static void init() {}
  
  public final boolean a(Context paramContext, String[] paramArrayOfString, String paramString)
  {
    AppMethodBeat.i(20179);
    if (!com.tencent.mm.sdk.a.b.fnF())
    {
      AppMethodBeat.o(20179);
      return false;
    }
    if (paramArrayOfString.length < 2)
    {
      AppMethodBeat.o(20179);
      return false;
    }
    try
    {
      if (paramArrayOfString.length >= 3) {
        Integer.valueOf(paramArrayOfString[2]).intValue();
      }
      label50:
      paramString = paramArrayOfString[1].toLowerCase();
      long l1 = System.nanoTime();
      int i = -1;
      switch (paramString.hashCode())
      {
      }
      for (;;)
      {
        switch (i)
        {
        default: 
          AppMethodBeat.o(20179);
          return false;
          if (paramString.equals("testrpp"))
          {
            i = 0;
            continue;
            if (paramString.equals("oaid")) {
              i = 1;
            }
          }
          break;
        }
      }
      d.yRQ.hw(0, 31);
      Toast.makeText(paramContext, "info is reported.", 0).show();
      for (;;)
      {
        long l2 = System.nanoTime();
        paramArrayOfString = String.format("[NorMsgTest] cmd: %s, time: %d ns.", new Object[] { paramArrayOfString[1], Long.valueOf(l2 - l1) });
        ae.i("MicroMsg.NorMsgTest", paramArrayOfString);
        Toast.makeText(paramContext, paramArrayOfString, 0).show();
        AppMethodBeat.o(20179);
        return true;
        paramString = com.tencent.mm.plugin.normsg.a.b.wJt.aaL();
        Toast.makeText(paramContext, "oaid: ".concat(String.valueOf(paramString)), 1).show();
        ae.i("MicroMsg.NorMsgTest", "[+] oaid: %s", new Object[] { paramString });
      }
    }
    catch (Exception paramString)
    {
      break label50;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.console.a.f
 * JD-Core Version:    0.7.0.1
 */