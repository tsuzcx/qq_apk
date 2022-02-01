package com.tencent.mm.plugin.finder.feed.model.internal;

import com.tencent.mm.sdk.platformtools.ad;
import d.g.b.p;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataFetch;", "D", "Lcom/tencent/mm/plugin/finder/feed/model/internal/ILoaderData;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "setTAG", "(Ljava/lang/String;)V", "alive", "", "dead", "fetch", "request", "callback", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataCallback;", "fetchInit", "fetchLoadMore", "fetchRefresh", "Companion", "plugin-finder_release"})
public abstract class g<D extends i>
{
  public static final a Companion = new a((byte)0);
  private static final boolean DEBUG = false;
  private String TAG;
  
  public g()
  {
    StringBuilder localStringBuilder = new StringBuilder("Finder.");
    String str2 = getClass().getSimpleName();
    String str1 = str2;
    if (str2 == null) {
      str1 = "IDataFetch";
    }
    this.TAG = (str1 + '_' + hashCode());
  }
  
  public void alive()
  {
    ad.i(getTAG(), "alive.");
  }
  
  public void dead()
  {
    ad.i(getTAG(), "dead.");
  }
  
  public void fetch(Object paramObject, f<D> paramf)
  {
    p.h(paramf, "callback");
  }
  
  public abstract void fetchInit(f<D> paramf);
  
  public abstract void fetchLoadMore(f<D> paramf);
  
  public abstract void fetchRefresh(f<D> paramf);
  
  public String getTAG()
  {
    return this.TAG;
  }
  
  public void setTAG(String paramString)
  {
    p.h(paramString, "<set-?>");
    this.TAG = paramString;
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataFetch$Companion;", "", "()V", "DEBUG", "", "getDEBUG", "()Z", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.model.internal.g
 * JD-Core Version:    0.7.0.1
 */