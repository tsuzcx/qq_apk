package com.tencent.mm.plugin.appbrand.dynamic;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.f;
import com.tencent.mm.sdk.platformtools.ab;

public final class a
{
  public String equ;
  public String hmP;
  h hmQ;
  
  public a(h paramh)
  {
    this.hmQ = paramh;
  }
  
  public final void aY(String paramString, int paramInt)
  {
    AppMethodBeat.i(10655);
    if ((this.equ == null) || (this.equ.length() == 0))
    {
      AppMethodBeat.o(10655);
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.putString("id", paramString);
    localBundle.putInt("widgetState", paramInt);
    f.a(i.azB().AY(paramString), localBundle, f.a.class, null);
    AppMethodBeat.o(10655);
  }
  
  public static class b
    implements com.tencent.mm.ipcinvoker.a<Bundle, Bundle>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.a
 * JD-Core Version:    0.7.0.1
 */