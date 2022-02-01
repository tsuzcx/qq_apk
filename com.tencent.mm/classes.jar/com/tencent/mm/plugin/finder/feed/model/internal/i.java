package com.tencent.mm.plugin.finder.feed.model.internal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataFetch;", "D", "Lcom/tencent/mm/plugin/finder/feed/model/internal/ILoaderData;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "setTAG", "(Ljava/lang/String;)V", "alive", "", "dead", "fetch", "request", "callback", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataCallback;", "fetchInit", "fetchLoadMore", "fetchPreload", "fetchRefresh", "Companion", "plugin-finder-base_release"})
public abstract class i<D extends k>
{
  public static final a Companion = new a((byte)0);
  private static final boolean DEBUG = false;
  private String TAG;
  
  public i()
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
    Log.i(getTAG(), "alive.");
  }
  
  public void dead()
  {
    Log.i(getTAG(), "dead.");
  }
  
  public void fetch(Object paramObject, h<D> paramh)
  {
    p.k(paramh, "callback");
  }
  
  public abstract void fetchInit(h<D> paramh);
  
  public abstract void fetchLoadMore(h<D> paramh);
  
  public void fetchPreload(h<D> paramh)
  {
    p.k(paramh, "callback");
  }
  
  public abstract void fetchRefresh(h<D> paramh);
  
  public String getTAG()
  {
    return this.TAG;
  }
  
  public void setTAG(String paramString)
  {
    p.k(paramString, "<set-?>");
    this.TAG = paramString;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataFetch$Companion;", "", "()V", "DEBUG", "", "getDEBUG", "()Z", "plugin-finder-base_release"})
  public static final class a
  {
    public static boolean getDEBUG()
    {
      AppMethodBeat.i(259063);
      boolean bool = i.access$getDEBUG$cp();
      AppMethodBeat.o(259063);
      return bool;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.model.internal.i
 * JD-Core Version:    0.7.0.1
 */