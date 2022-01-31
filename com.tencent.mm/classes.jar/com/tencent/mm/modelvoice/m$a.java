package com.tencent.mm.modelvoice;

import android.content.Context;
import com.tencent.mm.pluginsdk.cmd.a;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

final class m$a
  implements a
{
  public final boolean a(Context paramContext, String[] paramArrayOfString)
  {
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
      return false;
      if (!paramContext.equals("//voicetrymore")) {
        break;
      }
      i = 0;
      break;
    } while ((paramArrayOfString.length <= 1) || (paramArrayOfString[1] == null));
    i = bk.getInt(paramArrayOfString[1], 1);
    if (i == 1) {}
    for (boolean bool = true;; bool = false)
    {
      com.tencent.mm.f.b.i.bEb = bool;
      y.i("MicroMsg.SubCoreVoice", "summervoicetrymore enable[%d]", new Object[] { Integer.valueOf(i) });
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.modelvoice.m.a
 * JD-Core Version:    0.7.0.1
 */