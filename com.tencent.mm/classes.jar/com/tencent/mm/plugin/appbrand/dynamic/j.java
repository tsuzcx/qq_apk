package com.tencent.mm.plugin.appbrand.dynamic;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.d.a;
import com.tencent.mm.plugin.report.service.h;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public final class j
{
  private static j jKY;
  public Map<String, b> jKQ;
  
  static
  {
    AppMethodBeat.i(121193);
    jKY = new j();
    AppMethodBeat.o(121193);
  }
  
  public j()
  {
    AppMethodBeat.i(121187);
    this.jKQ = new ConcurrentHashMap();
    AppMethodBeat.o(121187);
  }
  
  private String Ld(String paramString)
  {
    AppMethodBeat.i(121191);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(121191);
      return "";
    }
    Iterator localIterator = this.jKQ.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      if ((localEntry.getValue() != null) && (paramString.equals(((b)localEntry.getValue()).appId)))
      {
        paramString = (String)localEntry.getKey();
        AppMethodBeat.o(121191);
        return paramString;
      }
    }
    AppMethodBeat.o(121191);
    return "";
  }
  
  public static j bci()
  {
    return jKY;
  }
  
  public final void K(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(121189);
    b localb = (b)this.jKQ.get(paramString);
    if (localb != null)
    {
      com.tencent.mm.ipcinvoker.h.b.i("WidgetReporter_14443", "report %s, %s, %s", new Object[] { paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      h.wUl.f(14443, new Object[] { localb.appId, Integer.valueOf(0), Integer.valueOf(localb.cYO), Integer.valueOf(2), localb.dac, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(0), Integer.valueOf(localb.cFI) });
    }
    AppMethodBeat.o(121189);
  }
  
  public final void Lc(String paramString)
  {
    AppMethodBeat.i(121190);
    K(Ld(paramString), 626, 7);
    AppMethodBeat.o(121190);
  }
  
  public final void Le(String paramString)
  {
    AppMethodBeat.i(121192);
    K(paramString, 626, 26);
    AppMethodBeat.o(121192);
  }
  
  public final void bw(String paramString, int paramInt)
  {
    AppMethodBeat.i(121188);
    K(Ld(paramString), 626, paramInt);
    AppMethodBeat.o(121188);
  }
  
  static class a
    implements com.tencent.mm.ipcinvoker.b<Bundle, Bundle>
  {}
  
  public static final class b
    implements a
  {
    String appId = "";
    int cFI;
    int cYO;
    String dac;
    String jKT = "";
    
    public b() {}
    
    public b(String paramString1, String paramString2, int paramInt1, String paramString3, int paramInt2)
    {
      this.jKT = paramString1;
      this.appId = paramString2;
      this.cYO = paramInt1;
      this.dac = paramString3;
      this.cFI = paramInt2;
    }
    
    public final void fromBundle(Bundle paramBundle)
    {
      AppMethodBeat.i(121186);
      this.jKT = paramBundle.getString("widgetId");
      this.appId = paramBundle.getString("appid");
      this.cYO = paramBundle.getInt("appState");
      this.dac = paramBundle.getString("reqKey");
      this.cFI = paramBundle.getInt("serviceType");
      AppMethodBeat.o(121186);
    }
    
    public final Bundle toBundle()
    {
      AppMethodBeat.i(121185);
      Bundle localBundle = new Bundle();
      localBundle.putString("widgetId", this.jKT);
      localBundle.putString("appid", this.appId);
      localBundle.putInt("appState", this.cYO);
      localBundle.putString("reqKey", this.dac);
      localBundle.putInt("serviceType", this.cFI);
      AppMethodBeat.o(121185);
      return localBundle;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.j
 * JD-Core Version:    0.7.0.1
 */