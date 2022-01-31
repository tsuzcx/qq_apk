package com.tencent.mm.plugin.appbrand.jsapi.media;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.MMActivity.a;
import java.io.File;

final class i$1
  implements MMActivity.a
{
  i$1(i parami, String[] paramArrayOfString) {}
  
  public final void c(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(131297);
    paramIntent = this.hSi;
    paramInt1 = 0;
    for (;;)
    {
      if (paramInt1 < paramIntent.length) {}
      try
      {
        new File(paramIntent[paramInt1]).delete();
        label32:
        paramInt1 += 1;
        continue;
        AppMethodBeat.o(131297);
        return;
      }
      catch (Exception localException)
      {
        break label32;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.media.i.1
 * JD-Core Version:    0.7.0.1
 */