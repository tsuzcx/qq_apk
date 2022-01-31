package com.tencent.mm.plugin.appbrand.dynamic;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.h.b;
import com.tencent.mm.plugin.report.service.h;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public final class j
{
  private static j hnD;
  public Map<String, b> hnv;
  
  static
  {
    AppMethodBeat.i(10712);
    hnD = new j();
    AppMethodBeat.o(10712);
  }
  
  public j()
  {
    AppMethodBeat.i(10706);
    this.hnv = new ConcurrentHashMap();
    AppMethodBeat.o(10706);
  }
  
  private String Bb(String paramString)
  {
    AppMethodBeat.i(10710);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(10710);
      return "";
    }
    Iterator localIterator = this.hnv.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      if ((localEntry.getValue() != null) && (paramString.equals(((b)localEntry.getValue()).appId)))
      {
        paramString = (String)localEntry.getKey();
        AppMethodBeat.o(10710);
        return paramString;
      }
    }
    AppMethodBeat.o(10710);
    return "";
  }
  
  public static j azD()
  {
    return hnD;
  }
  
  public final void Ba(String paramString)
  {
    AppMethodBeat.i(10709);
    O(Bb(paramString), 626, 7);
    AppMethodBeat.o(10709);
  }
  
  public final void Bc(String paramString)
  {
    AppMethodBeat.i(10711);
    O(paramString, 626, 26);
    AppMethodBeat.o(10711);
  }
  
  public final void O(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(10708);
    b localb = (b)this.hnv.get(paramString);
    if (localb != null)
    {
      b.i("WidgetReporter_14443", "report %s, %s, %s", new Object[] { paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      h.qsU.e(14443, new Object[] { localb.appId, Integer.valueOf(0), Integer.valueOf(localb.cmE), Integer.valueOf(2), localb.cnI, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(0), Integer.valueOf(localb.fmF) });
    }
    AppMethodBeat.o(10708);
  }
  
  public final void ba(String paramString, int paramInt)
  {
    AppMethodBeat.i(10707);
    O(Bb(paramString), 626, paramInt);
    AppMethodBeat.o(10707);
  }
  
  static class a
    implements com.tencent.mm.ipcinvoker.a<Bundle, Bundle>
  {}
  
  public static final class b
    implements com.tencent.mm.ipcinvoker.d.a
  {
    String appId = "";
    int cmE;
    String cnI;
    int fmF;
    String hny = "";
    
    public b() {}
    
    public b(String paramString1, String paramString2, int paramInt1, String paramString3, int paramInt2)
    {
      this.hny = paramString1;
      this.appId = paramString2;
      this.cmE = paramInt1;
      this.cnI = paramString3;
      this.fmF = paramInt2;
    }
    
    public final void fromBundle(Bundle paramBundle)
    {
      AppMethodBeat.i(10705);
      this.hny = paramBundle.getString("widgetId");
      this.appId = paramBundle.getString("appid");
      this.cmE = paramBundle.getInt("appState");
      this.cnI = paramBundle.getString("reqKey");
      this.fmF = paramBundle.getInt("serviceType");
      AppMethodBeat.o(10705);
    }
    
    public final Bundle toBundle()
    {
      AppMethodBeat.i(10704);
      Bundle localBundle = new Bundle();
      localBundle.putString("widgetId", this.hny);
      localBundle.putString("appid", this.appId);
      localBundle.putInt("appState", this.cmE);
      localBundle.putString("reqKey", this.cnI);
      localBundle.putInt("serviceType", this.fmF);
      AppMethodBeat.o(10704);
      return localBundle;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.j
 * JD-Core Version:    0.7.0.1
 */