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
  private static j jkL;
  public Map<String, b> jkD;
  
  static
  {
    AppMethodBeat.i(121193);
    jkL = new j();
    AppMethodBeat.o(121193);
  }
  
  public j()
  {
    AppMethodBeat.i(121187);
    this.jkD = new ConcurrentHashMap();
    AppMethodBeat.o(121187);
  }
  
  private String GZ(String paramString)
  {
    AppMethodBeat.i(121191);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(121191);
      return "";
    }
    Iterator localIterator = this.jkD.entrySet().iterator();
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
  
  public static j aVk()
  {
    return jkL;
  }
  
  public final void GY(String paramString)
  {
    AppMethodBeat.i(121190);
    L(GZ(paramString), 626, 7);
    AppMethodBeat.o(121190);
  }
  
  public final void Ha(String paramString)
  {
    AppMethodBeat.i(121192);
    L(paramString, 626, 26);
    AppMethodBeat.o(121192);
  }
  
  public final void L(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(121189);
    b localb = (b)this.jkD.get(paramString);
    if (localb != null)
    {
      com.tencent.mm.ipcinvoker.h.b.i("WidgetReporter_14443", "report %s, %s, %s", new Object[] { paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      h.vKh.f(14443, new Object[] { localb.appId, Integer.valueOf(0), Integer.valueOf(localb.dbs), Integer.valueOf(2), localb.dcE, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(0), Integer.valueOf(localb.cIB) });
    }
    AppMethodBeat.o(121189);
  }
  
  public final void bs(String paramString, int paramInt)
  {
    AppMethodBeat.i(121188);
    L(GZ(paramString), 626, paramInt);
    AppMethodBeat.o(121188);
  }
  
  static class a
    implements com.tencent.mm.ipcinvoker.b<Bundle, Bundle>
  {}
  
  public static final class b
    implements a
  {
    String appId = "";
    int cIB;
    int dbs;
    String dcE;
    String jkG = "";
    
    public b() {}
    
    public b(String paramString1, String paramString2, int paramInt1, String paramString3, int paramInt2)
    {
      this.jkG = paramString1;
      this.appId = paramString2;
      this.dbs = paramInt1;
      this.dcE = paramString3;
      this.cIB = paramInt2;
    }
    
    public final void fromBundle(Bundle paramBundle)
    {
      AppMethodBeat.i(121186);
      this.jkG = paramBundle.getString("widgetId");
      this.appId = paramBundle.getString("appid");
      this.dbs = paramBundle.getInt("appState");
      this.dcE = paramBundle.getString("reqKey");
      this.cIB = paramBundle.getInt("serviceType");
      AppMethodBeat.o(121186);
    }
    
    public final Bundle toBundle()
    {
      AppMethodBeat.i(121185);
      Bundle localBundle = new Bundle();
      localBundle.putString("widgetId", this.jkG);
      localBundle.putString("appid", this.appId);
      localBundle.putInt("appState", this.dbs);
      localBundle.putString("reqKey", this.dcE);
      localBundle.putInt("serviceType", this.cIB);
      AppMethodBeat.o(121185);
      return localBundle;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.j
 * JD-Core Version:    0.7.0.1
 */