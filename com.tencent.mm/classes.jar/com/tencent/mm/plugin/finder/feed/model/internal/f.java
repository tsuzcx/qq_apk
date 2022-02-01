package com.tencent.mm.plugin.finder.feed.model.internal;

import com.tencent.mm.protocal.protobuf.dzp;
import d.g.b.k;
import d.l;
import java.util.List;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataFetch;", "R", "T", "D", "Lcom/tencent/mm/plugin/finder/feed/model/internal/ILoaderData;", "", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "getContextObj", "()Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "alive", "", "call", "request", "callback", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataCallback;", "(Ljava/lang/Object;Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataCallback;)V", "callInitData", "", "init", "(Ljava/lang/Object;)Ljava/util/List;", "dead", "fetchData", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IRequest;", "initData", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IInitRequest;", "Companion", "plugin-finder_release"})
public abstract class f<R, T, D extends i>
{
  public static final boolean DEBUG = false;
  public static final String TAG = "Finder.IDataFetch";
  public static final a qzx = new a((byte)0);
  protected final dzp contextObj;
  
  public f(dzp paramdzp)
  {
    this.contextObj = paramdzp;
  }
  
  public abstract void a(T paramT, e<D> parame);
  
  public void alive() {}
  
  public abstract List<D> cX(R paramR);
  
  public void dead() {}
  
  public final void fetchData(j paramj, e<D> parame)
  {
    k.h(paramj, "request");
    k.h(parame, "callback");
    a((Object)paramj, parame);
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataFetch$Companion;", "", "()V", "DEBUG", "", "getDEBUG", "()Z", "TAG", "", "getTAG", "()Ljava/lang/String;", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.model.internal.f
 * JD-Core Version:    0.7.0.1
 */