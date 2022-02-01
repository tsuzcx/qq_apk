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
  private static j kfj;
  public Map<String, b> kfb;
  
  static
  {
    AppMethodBeat.i(121193);
    kfj = new j();
    AppMethodBeat.o(121193);
  }
  
  public j()
  {
    AppMethodBeat.i(121187);
    this.kfb = new ConcurrentHashMap();
    AppMethodBeat.o(121187);
  }
  
  private String Ox(String paramString)
  {
    AppMethodBeat.i(121191);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(121191);
      return "";
    }
    Iterator localIterator = this.kfb.entrySet().iterator();
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
  
  public static j bfM()
  {
    return kfj;
  }
  
  public final void M(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(121189);
    b localb = (b)this.kfb.get(paramString);
    if (localb != null)
    {
      com.tencent.mm.ipcinvoker.h.b.i("WidgetReporter_14443", "report %s, %s, %s", new Object[] { paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      g.yhR.f(14443, new Object[] { localb.appId, Integer.valueOf(0), Integer.valueOf(localb.dkg), Integer.valueOf(2), localb.dlu, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(0), Integer.valueOf(localb.cQN) });
    }
    AppMethodBeat.o(121189);
  }
  
  public final void Ow(String paramString)
  {
    AppMethodBeat.i(121190);
    M(Ox(paramString), 626, 7);
    AppMethodBeat.o(121190);
  }
  
  public final void Oy(String paramString)
  {
    AppMethodBeat.i(121192);
    M(paramString, 626, 26);
    AppMethodBeat.o(121192);
  }
  
  public final void by(String paramString, int paramInt)
  {
    AppMethodBeat.i(121188);
    M(Ox(paramString), 626, paramInt);
    AppMethodBeat.o(121188);
  }
  
  static class a
    implements com.tencent.mm.ipcinvoker.b<Bundle, Bundle>
  {}
  
  public static final class b
    implements a
  {
    String appId = "";
    int cQN;
    int dkg;
    String dlu;
    String kfe = "";
    
    public b() {}
    
    public b(String paramString1, String paramString2, int paramInt1, String paramString3, int paramInt2)
    {
      this.kfe = paramString1;
      this.appId = paramString2;
      this.dkg = paramInt1;
      this.dlu = paramString3;
      this.cQN = paramInt2;
    }
    
    public final void fromBundle(Bundle paramBundle)
    {
      AppMethodBeat.i(121186);
      this.kfe = paramBundle.getString("widgetId");
      this.appId = paramBundle.getString("appid");
      this.dkg = paramBundle.getInt("appState");
      this.dlu = paramBundle.getString("reqKey");
      this.cQN = paramBundle.getInt("serviceType");
      AppMethodBeat.o(121186);
    }
    
    public final Bundle toBundle()
    {
      AppMethodBeat.i(121185);
      Bundle localBundle = new Bundle();
      localBundle.putString("widgetId", this.kfe);
      localBundle.putString("appid", this.appId);
      localBundle.putInt("appState", this.dkg);
      localBundle.putString("reqKey", this.dlu);
      localBundle.putInt("serviceType", this.cQN);
      AppMethodBeat.o(121185);
      return localBundle;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.j
 * JD-Core Version:    0.7.0.1
 */