package com.tencent.mm.plugin.appbrand.dynamic;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.modelappbrand.u;

public final class a
{
  public String fDK;
  public String jjX;
  h jjY;
  
  public a(h paramh)
  {
    this.jjY = paramh;
  }
  
  public final void bq(String paramString, int paramInt)
  {
    AppMethodBeat.i(121136);
    if ((this.fDK == null) || (this.fDK.length() == 0))
    {
      AppMethodBeat.o(121136);
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.putString("id", paramString);
    localBundle.putInt("widgetState", paramInt);
    com.tencent.mm.ipcinvoker.h.a(i.aVi().GW(paramString), localBundle, f.a.class, null);
    AppMethodBeat.o(121136);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.a
 * JD-Core Version:    0.7.0.1
 */