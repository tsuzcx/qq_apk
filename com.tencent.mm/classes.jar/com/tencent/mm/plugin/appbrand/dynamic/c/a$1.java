package com.tencent.mm.plugin.appbrand.dynamic.c;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.f;

final class a$1
  implements Runnable
{
  a$1(a parama, String[] paramArrayOfString) {}
  
  public final void run()
  {
    AppMethodBeat.i(10793);
    String str2 = "com.tencent.mm";
    String str1 = str2;
    if (this.eut.length > 2)
    {
      str1 = str2;
      if (!TextUtils.isEmpty(this.eut[2])) {
        str1 = "com.tencent.mm" + ":" + this.eut[2];
      }
    }
    f.a(str1, null, a.a.class, null);
    AppMethodBeat.o(10793);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.c.a.1
 * JD-Core Version:    0.7.0.1
 */