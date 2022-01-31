package com.tencent.mm.plugin.appbrand.dynamic.d;

import android.os.Bundle;
import com.tencent.mm.ipcinvoker.c;
import com.tencent.mm.modelappbrand.t;

final class g$b$1
  implements t
{
  g$b$1(g.b paramb, Bundle paramBundle, c paramc) {}
  
  public final void b(boolean paramBoolean, String paramString, Bundle paramBundle)
  {
    this.fVn.putBoolean("ret", paramBoolean);
    this.fVn.putString("reason", paramString);
    this.fVn.putBundle("data", paramBundle);
    this.dGE.U(this.fVn);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.d.g.b.1
 * JD-Core Version:    0.7.0.1
 */