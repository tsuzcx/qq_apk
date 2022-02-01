package com.tencent.mm.modelvoice;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.cmd.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

final class o$a
  implements a
{
  public final boolean a(Context paramContext, String[] paramArrayOfString, String paramString)
  {
    AppMethodBeat.i(148437);
    paramContext = paramArrayOfString[0];
    int i = -1;
    switch (paramContext.hashCode())
    {
    default: 
      switch (i)
      {
      }
      break;
    }
    do
    {
      AppMethodBeat.o(148437);
      return false;
      if (!paramContext.equals("//voicetrymore")) {
        break;
      }
      i = 0;
      break;
    } while ((paramArrayOfString.length <= 1) || (paramArrayOfString[1] == null));
    i = Util.getInt(paramArrayOfString[1], 1);
    if (i == 1) {}
    for (boolean bool = true;; bool = false)
    {
      com.tencent.mm.audio.b.i.ftw = bool;
      Log.i("MicroMsg.SubCoreVoice", "summervoicetrymore enable[%d]", new Object[] { Integer.valueOf(i) });
      AppMethodBeat.o(148437);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.modelvoice.o.a
 * JD-Core Version:    0.7.0.1
 */