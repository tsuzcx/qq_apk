package com.tencent.mm.plugin.appbrand.jsapi.media;

import android.content.Intent;
import com.tencent.mm.ui.MMActivity.a;
import java.io.File;

final class d$1
  implements MMActivity.a
{
  d$1(d paramd, String[] paramArrayOfString) {}
  
  public final void c(int paramInt1, int paramInt2, Intent paramIntent)
  {
    paramIntent = this.gwn;
    paramInt1 = 0;
    for (;;)
    {
      if (paramInt1 < paramIntent.length) {}
      try
      {
        new File(paramIntent[paramInt1]).delete();
        label27:
        paramInt1 += 1;
        continue;
        return;
      }
      catch (Exception localException)
      {
        break label27;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.media.d.1
 * JD-Core Version:    0.7.0.1
 */