package com.tencent.mm.plugin.appbrand.dynamic;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.d.a;
import com.tencent.mm.plugin.report.service.g;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public final class j
{
  private static j kiz;
  public Map<String, b> kir;
  
  static
  {
    AppMethodBeat.i(121193);
    kiz = new j();
    AppMethodBeat.o(121193);
  }
  
  public j()
  {
    AppMethodBeat.i(121187);
    this.kir = new ConcurrentHashMap();
    AppMethodBeat.o(121187);
  }
  
  private String Pf(String paramString)
  {
    AppMethodBeat.i(121191);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(121191);
      return "";
    }
    Iterator localIterator = this.kir.entrySet().iterator();
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
  
  public static j bgu()
  {
    return kiz;
  }
  
  public final void M(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(121189);
    b localb = (b)this.kir.get(paramString);
    if (localb != null)
    {
      com.tencent.mm.ipcinvoker.h.b.i("WidgetReporter_14443", "report %s, %s, %s", new Object[] { paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      g.yxI.f(14443, new Object[] { localb.appId, Integer.valueOf(0), Integer.valueOf(localb.dli), Integer.valueOf(2), localb.dmw, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(0), Integer.valueOf(localb.cRx) });
    }
    AppMethodBeat.o(121189);
  }
  
  public final void Pe(String paramString)
  {
    AppMethodBeat.i(121190);
    M(Pf(paramString), 626, 7);
    AppMethodBeat.o(121190);
  }
  
  public final void Pg(String paramString)
  {
    AppMethodBeat.i(121192);
    M(paramString, 626, 26);
    AppMethodBeat.o(121192);
  }
  
  public final void bB(String paramString, int paramInt)
  {
    AppMethodBeat.i(121188);
    M(Pf(paramString), 626, paramInt);
    AppMethodBeat.o(121188);
  }
  
  static class a
    implements com.tencent.mm.ipcinvoker.b<Bundle, Bundle>
  {}
  
  public static final class b
    implements a
  {
    String appId = "";
    int cRx;
    int dli;
    String dmw;
    String kiu = "";
    
    public b() {}
    
    public b(String paramString1, String paramString2, int paramInt1, String paramString3, int paramInt2)
    {
      this.kiu = paramString1;
      this.appId = paramString2;
      this.dli = paramInt1;
      this.dmw = paramString3;
      this.cRx = paramInt2;
    }
    
    public final void fromBundle(Bundle paramBundle)
    {
      AppMethodBeat.i(121186);
      this.kiu = paramBundle.getString("widgetId");
      this.appId = paramBundle.getString("appid");
      this.dli = paramBundle.getInt("appState");
      this.dmw = paramBundle.getString("reqKey");
      this.cRx = paramBundle.getInt("serviceType");
      AppMethodBeat.o(121186);
    }
    
    public final Bundle toBundle()
    {
      AppMethodBeat.i(121185);
      Bundle localBundle = new Bundle();
      localBundle.putString("widgetId", this.kiu);
      localBundle.putString("appid", this.appId);
      localBundle.putInt("appState", this.dli);
      localBundle.putString("reqKey", this.dmw);
      localBundle.putInt("serviceType", this.cRx);
      AppMethodBeat.o(121185);
      return localBundle;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.j
 * JD-Core Version:    0.7.0.1
 */