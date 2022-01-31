package com.tencent.mm.plugin.appbrand.dynamic.d;

import android.os.Bundle;
import com.tencent.mm.ipcinvoker.c;
import com.tencent.mm.modelappbrand.t;

final class i$a$1
  implements t
{
  i$a$1(i.a parama, Bundle paramBundle, c paramc) {}
  
  public final void b(boolean paramBoolean, String paramString, Bundle paramBundle)
  {
    this.fVn.putBoolean("ret", paramBoolean);
    this.fVn.putString("reason", paramString);
    this.fVn.putBundle("data", paramBundle);
    this.dGE.U(this.fVn);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.d.i.a.1
 * JD-Core Version:    0.7.0.1
 */