package com.tencent.mm.plugin.appbrand.dynamic;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.ej;
import com.tencent.mm.ipcinvoker.type.IPCBoolean;
import com.tencent.mm.modelappbrand.u;
import com.tencent.mm.plugin.appbrand.collector.CollectSession;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.Map;
import junit.framework.Assert;

public final class a
{
  public String gaR;
  public String kev;
  h kew;
  
  public a(h paramh)
  {
    this.kew = paramh;
  }
  
  public final void bw(String paramString, int paramInt)
  {
    AppMethodBeat.i(121136);
    if ((this.gaR == null) || (this.gaR.length() == 0))
    {
      AppMethodBeat.o(121136);
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.putString("id", paramString);
    localBundle.putInt("widgetState", paramInt);
    com.tencent.mm.ipcinvoker.h.a(i.bfK().Ou(paramString), localBundle, f.a.class, null);
    AppMethodBeat.o(121136);
  }
  
  public static class a
    implements com.tencent.mm.ipcinvoker.b<Bundle, Bundle>
  {}
  
  public static class b
    implements com.tencent.mm.ipcinvoker.b<Bundle, Bundle>
  {}
  
  public static class c
    implements com.tencent.mm.ipcinvoker.b<Bundle, Bundle>
  {}
  
  public static class d
    implements com.tencent.mm.ipcinvoker.b<Bundle, Bundle>
  {}
  
  public static class e
    implements com.tencent.mm.ipcinvoker.b<Bundle, Bundle>
  {}
  
  public static class f
    implements com.tencent.mm.ipcinvoker.k<Bundle, IPCBoolean>
  {}
  
  public static class g
    implements com.tencent.mm.ipcinvoker.b<Bundle, Bundle>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.a
 * JD-Core Version:    0.7.0.1
 */