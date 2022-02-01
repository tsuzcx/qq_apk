package com.tencent.mm.plugin.finder.cgi.interceptor;

import com.tencent.mm.plugin.finder.cgi.aq.d;
import com.tencent.mm.plugin.finder.feed.model.d;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/cgi/interceptor/IFinderStreamInterceptor;", "", "onIntercept", "", "resp", "Lcom/tencent/mm/plugin/finder/cgi/CgiFinderStream$FinderStreamResponseEx;", "tabType", "", "onInterceptAfterStore", "loadedInfo", "Lcom/tencent/mm/plugin/finder/feed/model/CgiFinderStreamResult;", "onInterceptBeforeStore", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract interface g
{
  public abstract boolean a(aq.d paramd, int paramInt);
  
  public abstract boolean a(d paramd);
  
  public abstract boolean b(d paramd, int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.interceptor.g
 * JD-Core Version:    0.7.0.1
 */