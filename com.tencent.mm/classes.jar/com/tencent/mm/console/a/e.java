package com.tencent.mm.console.a;

import android.content.Context;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.secinforeport.a.d;
import com.tencent.mm.pluginsdk.cmd.a;
import com.tencent.mm.sdk.platformtools.ab;

public final class e
  implements a
{
  static
  {
    AppMethodBeat.i(16133);
    com.tencent.mm.pluginsdk.cmd.b.a(new e(), new String[] { "//normsg" });
    AppMethodBeat.o(16133);
  }
  
  public static void init() {}
  
  public final boolean a(Context paramContext, String[] paramArrayOfString, String paramString)
  {
    AppMethodBeat.i(16132);
    if (!com.tencent.mm.sdk.a.b.dsf())
    {
      AppMethodBeat.o(16132);
      return false;
    }
    if (paramArrayOfString.length < 2)
    {
      AppMethodBeat.o(16132);
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
          AppMethodBeat.o(16132);
          return false;
          if (paramString.equals("testrpp")) {
            i = 0;
          }
          break;
        }
      }
      d.qEo.fq(0, 15);
      Toast.makeText(paramContext, "info is reported.", 0).show();
      long l2 = System.nanoTime();
      paramArrayOfString = String.format("[NorMsgTest] cmd: %s, time: %d ns.", new Object[] { paramArrayOfString[1], Long.valueOf(l2 - l1) });
      ab.i("MicroMsg.NorMsgTest", paramArrayOfString);
      Toast.makeText(paramContext, paramArrayOfString, 0).show();
      AppMethodBeat.o(16132);
      return true;
    }
    catch (Exception paramString)
    {
      break label50;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.console.a.e
 * JD-Core Version:    0.7.0.1
 */