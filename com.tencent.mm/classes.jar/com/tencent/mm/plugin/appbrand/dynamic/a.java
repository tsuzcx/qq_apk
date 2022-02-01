package com.tencent.mm.plugin.appbrand.dynamic;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.mmdata.rpt.mn;
import com.tencent.mm.ipcinvoker.j;
import com.tencent.mm.ipcinvoker.type.IPCBoolean;
import com.tencent.mm.modelappbrand.u;
import com.tencent.mm.plugin.appbrand.collector.CollectSession;
import com.tencent.mm.plugin.appbrand.dynamic.f.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Map;
import junit.framework.Assert;

public final class a
{
  public String lWh;
  public String rjL;
  h rjM;
  
  public a(h paramh)
  {
    this.rjM = paramh;
  }
  
  public final void cw(String paramString, int paramInt)
  {
    AppMethodBeat.i(121136);
    if ((this.lWh == null) || (this.lWh.length() == 0))
    {
      AppMethodBeat.o(121136);
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.putString("id", paramString);
    localBundle.putInt("widgetState", paramInt);
    j.a(i.cnw().YX(paramString), localBundle, f.a.class, null);
    AppMethodBeat.o(121136);
  }
  
  public static class a
    implements com.tencent.mm.ipcinvoker.d<Bundle, Bundle>
  {}
  
  public static class b
    implements com.tencent.mm.ipcinvoker.d<Bundle, Bundle>
  {}
  
  public static class c
    implements com.tencent.mm.ipcinvoker.d<Bundle, Bundle>
  {}
  
  public static class d
    implements com.tencent.mm.ipcinvoker.d<Bundle, Bundle>
  {}
  
  public static class e
    implements com.tencent.mm.ipcinvoker.d<Bundle, Bundle>
  {}
  
  public static class f
    implements com.tencent.mm.ipcinvoker.m<Bundle, IPCBoolean>
  {}
  
  public static class g
    implements com.tencent.mm.ipcinvoker.d<Bundle, Bundle>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.a
 * JD-Core Version:    0.7.0.1
 */