package com.tencent.mm.plugin.appbrand.dynamic.debugger;

import android.os.Bundle;
import com.tencent.mm.aa.c.e.a;
import com.tencent.mm.ipcinvoker.f;

final class a$1
  implements e.a
{
  public final void D(String paramString, int paramInt)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("id", paramString);
    localBundle.putInt("status", paramInt);
    f.a("com.tencent.mm", localBundle, a.a.class, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.debugger.a.1
 * JD-Core Version:    0.7.0.1
 */