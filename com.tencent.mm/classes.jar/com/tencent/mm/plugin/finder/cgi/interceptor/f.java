package com.tencent.mm.plugin.finder.cgi.interceptor;

import com.tencent.mm.plugin.finder.cgi.aa.f;
import com.tencent.mm.plugin.finder.feed.model.b;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/cgi/interceptor/IFinderStreamInterceptor;", "", "onIntercept", "", "resp", "Lcom/tencent/mm/plugin/finder/cgi/CgiFinderStream$FinderStreamResponseEx;", "tabType", "", "onInterceptAfterStore", "loadedInfo", "Lcom/tencent/mm/plugin/finder/feed/model/CgiFinderStreamResult;", "onInterceptBeforeStore", "plugin-finder_release"})
public abstract interface f
{
  public abstract boolean a(aa.f paramf);
  
  public abstract boolean a(b paramb);
  
  public abstract boolean b(b paramb, int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.interceptor.f
 * JD-Core Version:    0.7.0.1
 */