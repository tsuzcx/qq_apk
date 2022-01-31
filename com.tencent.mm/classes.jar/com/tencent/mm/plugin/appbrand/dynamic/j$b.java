package com.tencent.mm.plugin.appbrand.dynamic;

import android.os.Bundle;
import com.tencent.mm.ipcinvoker.d.a;

public final class j$b
  implements a
{
  String appId = "";
  int bFu;
  String bMX;
  int dWx;
  String fTW = "";
  
  public j$b() {}
  
  public j$b(String paramString1, String paramString2, int paramInt1, String paramString3, int paramInt2)
  {
    this.fTW = paramString1;
    this.appId = paramString2;
    this.bFu = paramInt1;
    this.bMX = paramString3;
    this.dWx = paramInt2;
  }
  
  public final void fromBundle(Bundle paramBundle)
  {
    this.fTW = paramBundle.getString("widgetId");
    this.appId = paramBundle.getString("appid");
    this.bFu = paramBundle.getInt("appState");
    this.bMX = paramBundle.getString("reqKey");
    this.dWx = paramBundle.getInt("serviceType");
  }
  
  public final Bundle toBundle()
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("widgetId", this.fTW);
    localBundle.putString("appid", this.appId);
    localBundle.putInt("appState", this.bFu);
    localBundle.putString("reqKey", this.bMX);
    localBundle.putInt("serviceType", this.dWx);
    return localBundle;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.j.b
 * JD-Core Version:    0.7.0.1
 */