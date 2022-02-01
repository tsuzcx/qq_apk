package com.tencent.mm.plugin.appbrand.shortlink;

import com.tencent.mm.plugin.appbrand.shortlink.cgi.WxaShortLinkInfo;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/shortlink/IShortLinkInfoCache;", "", "clear", "", "shortLink", "", "clearAll", "get", "Lcom/tencent/mm/plugin/appbrand/shortlink/cgi/WxaShortLinkInfo;", "store", "info", "luggage-wechat-full-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract interface a
{
  public abstract void a(String paramString, WxaShortLinkInfo paramWxaShortLinkInfo);
  
  public abstract WxaShortLinkInfo agb(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.shortlink.a
 * JD-Core Version:    0.7.0.1
 */