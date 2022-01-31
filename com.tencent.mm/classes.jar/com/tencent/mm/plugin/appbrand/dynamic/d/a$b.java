package com.tencent.mm.plugin.appbrand.dynamic.d;

import android.os.Bundle;
import com.tencent.mm.ipcinvoker.a;
import com.tencent.mm.ipcinvoker.c;

class a$b
  implements a<Bundle, Bundle>
{
  private static final String[] fVd = { "scope.userLocation" };
  
  private static void a(c<Bundle> paramc, boolean paramBoolean, String paramString)
  {
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("ret", paramBoolean);
    localBundle.putString("reason", paramString);
    paramc.U(localBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.d.a.b
 * JD-Core Version:    0.7.0.1
 */