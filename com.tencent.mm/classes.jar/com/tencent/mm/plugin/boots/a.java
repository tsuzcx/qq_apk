package com.tencent.mm.plugin.boots;

import android.content.Context;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.boots.a.c;
import com.tencent.mm.sdk.a.b;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Iterator;
import java.util.List;

public final class a
  implements com.tencent.mm.pluginsdk.cmd.a
{
  public final boolean a(Context paramContext, String[] paramArrayOfString)
  {
    paramContext = paramArrayOfString[1];
    int i;
    if (b.cqk())
    {
      i = -1;
      switch (paramContext.hashCode())
      {
      }
    }
    for (;;)
    {
      switch (i)
      {
      default: 
        paramContext.hashCode();
        return false;
        if (paramContext.equals("showall"))
        {
          i = 0;
          continue;
          if (paramContext.equals("apkg")) {
            i = 1;
          }
        }
        break;
      }
    }
    paramContext = ((c)g.r(c.class)).awD();
    if (!paramContext.isEmpty())
    {
      y.e("MicroMsg.Boots.BootsCommand", "start day active keys");
      paramContext = paramContext.iterator();
      while (paramContext.hasNext())
      {
        paramArrayOfString = (com.tencent.mm.plugin.boots.a.a)paramContext.next();
        y.i("MicroMsg.Boots.BootsCommand", "key:%s active:%d", new Object[] { Integer.toHexString(paramArrayOfString.field_key), Integer.valueOf(paramArrayOfString.field_dau) });
      }
    }
    return true;
    if (paramArrayOfString.length < 5) {
      y.i("MicroMsg.Boots.BootsCommand", "must include url,md5 and appId");
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.boots.a
 * JD-Core Version:    0.7.0.1
 */