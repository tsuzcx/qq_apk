package com.tencent.mm.plugin.appbrand.dynamic;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.ipcinvoker.d.a;
import com.tencent.mm.ipcinvoker.h.c;
import com.tencent.mm.plugin.report.service.h;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public final class j
{
  private static j ogT;
  public Map<String, b> ogL;
  
  static
  {
    AppMethodBeat.i(121193);
    ogT = new j();
    AppMethodBeat.o(121193);
  }
  
  public j()
  {
    AppMethodBeat.i(121187);
    this.ogL = new ConcurrentHashMap();
    AppMethodBeat.o(121187);
  }
  
  private String age(String paramString)
  {
    AppMethodBeat.i(121191);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(121191);
      return "";
    }
    Iterator localIterator = this.ogL.entrySet().iterator();
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
  
  public static j bNj()
  {
    return ogT;
  }
  
  public final void P(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(121189);
    b localb = (b)this.ogL.get(paramString);
    if (localb != null)
    {
      c.i("WidgetReporter_14443", "report %s, %s, %s", new Object[] { paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      h.IzE.a(14443, new Object[] { localb.appId, Integer.valueOf(0), Integer.valueOf(localb.fvc), Integer.valueOf(2), localb.fwv, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(0), Integer.valueOf(localb.serviceType) });
    }
    AppMethodBeat.o(121189);
  }
  
  public final void agd(String paramString)
  {
    AppMethodBeat.i(121190);
    P(age(paramString), 626, 7);
    AppMethodBeat.o(121190);
  }
  
  public final void agf(String paramString)
  {
    AppMethodBeat.i(121192);
    P(paramString, 626, 26);
    AppMethodBeat.o(121192);
  }
  
  public final void cb(String paramString, int paramInt)
  {
    AppMethodBeat.i(121188);
    P(age(paramString), 626, paramInt);
    AppMethodBeat.o(121188);
  }
  
  static class a
    implements d<Bundle, Bundle>
  {}
  
  public static final class b
    implements a
  {
    String appId = "";
    int fvc;
    String fwv;
    String ogO = "";
    int serviceType;
    
    public b() {}
    
    public b(String paramString1, String paramString2, int paramInt1, String paramString3, int paramInt2)
    {
      this.ogO = paramString1;
      this.appId = paramString2;
      this.fvc = paramInt1;
      this.fwv = paramString3;
      this.serviceType = paramInt2;
    }
    
    public final void fromBundle(Bundle paramBundle)
    {
      AppMethodBeat.i(121186);
      this.ogO = paramBundle.getString("widgetId");
      this.appId = paramBundle.getString("appid");
      this.fvc = paramBundle.getInt("appState");
      this.fwv = paramBundle.getString("reqKey");
      this.serviceType = paramBundle.getInt("serviceType");
      AppMethodBeat.o(121186);
    }
    
    public final Bundle toBundle()
    {
      AppMethodBeat.i(121185);
      Bundle localBundle = new Bundle();
      localBundle.putString("widgetId", this.ogO);
      localBundle.putString("appid", this.appId);
      localBundle.putInt("appState", this.fvc);
      localBundle.putString("reqKey", this.fwv);
      localBundle.putInt("serviceType", this.serviceType);
      AppMethodBeat.o(121185);
      return localBundle;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.j
 * JD-Core Version:    0.7.0.1
 */