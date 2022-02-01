package com.tencent.mm.plugin.finder.cgi.interceptor;

import com.tencent.mm.plugin.finder.cgi.m.f;
import com.tencent.mm.plugin.finder.feed.model.b;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/cgi/interceptor/IFinderStreamInterceptor;", "", "onIntercept", "", "resp", "Lcom/tencent/mm/plugin/finder/cgi/CgiFinderStream$FinderStreamResponseEx;", "onInterceptAfterStore", "loadedInfo", "Lcom/tencent/mm/plugin/finder/feed/model/CgiFinderStreamResult;", "onInterceptBeforeStore", "plugin-finder_release"})
public abstract interface e
{
  public abstract boolean a(m.f paramf);
  
  public abstract boolean a(b paramb);
  
  public abstract boolean b(b paramb);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.interceptor.e
 * JD-Core Version:    0.7.0.1
 */