package com.tencent.mm.plugin.appbrand.dynamic.c;

import android.text.TextUtils;
import com.tencent.mm.ipcinvoker.f;

final class a$1
  implements Runnable
{
  a$1(a parama, String[] paramArrayOfString) {}
  
  public final void run()
  {
    String str2 = "com.tencent.mm";
    String str1 = str2;
    if (this.dAS.length > 2)
    {
      str1 = str2;
      if (!TextUtils.isEmpty(this.dAS[2])) {
        str1 = "com.tencent.mm" + ":" + this.dAS[2];
      }
    }
    f.a(str1, null, a.a.class, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.c.a.1
 * JD-Core Version:    0.7.0.1
 */