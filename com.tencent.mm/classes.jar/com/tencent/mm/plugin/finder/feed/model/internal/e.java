package com.tencent.mm.plugin.finder.feed.model.internal;

import com.tencent.mm.protocal.protobuf.anm;
import d.g.b.k;
import d.l;
import java.util.List;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataFetch;", "R", "T", "D", "Lcom/tencent/mm/plugin/finder/feed/model/internal/ILoaderData;", "", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "getContextObj", "()Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "alive", "", "call", "request", "callback", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataCallback;", "(Ljava/lang/Object;Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataCallback;)V", "callInitData", "", "init", "(Ljava/lang/Object;)Ljava/util/List;", "dead", "fetchData", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IRequest;", "initData", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IInitRequest;", "Companion", "plugin-finder_release"})
public abstract class e<R, T, D extends h>
{
  public static final boolean DEBUG = false;
  public static final String TAG = "Finder.IDataFetch";
  public static final e.a rop = new e.a((byte)0);
  protected final anm contextObj;
  
  public e(anm paramanm)
  {
    this.contextObj = paramanm;
  }
  
  public abstract void a(T paramT, d<D> paramd);
  
  public void alive() {}
  
  public abstract List<D> cX(R paramR);
  
  public void dead() {}
  
  public final void fetchData(i parami, d<D> paramd)
  {
    k.h(parami, "request");
    k.h(paramd, "callback");
    a((Object)parami, paramd);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.model.internal.e
 * JD-Core Version:    0.7.0.1
 */