package com.tencent.mm.plugin.datapreloader.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlinx.coroutines.ay;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/datapreloader/cache/SimpleDataCache;", "_key", "_result", "Lcom/tencent/mm/plugin/datapreloader/cache/IDataCache;", "key", "(Ljava/lang/Object;)V", "cacheTimestamp", "", "getCacheTimestamp", "()J", "setCacheTimestamp", "(J)V", "data", "getData", "()Ljava/lang/Object;", "setData", "Ljava/lang/Object;", "preloadingJob", "Lkotlinx/coroutines/Deferred;", "getPreloadingJob", "()Lkotlinx/coroutines/Deferred;", "setPreloadingJob", "(Lkotlinx/coroutines/Deferred;)V", "checkCacheAvailable", "", "clearCache", "", "clearJob", "getJob", "recycleCache", "result", "removeCache", "needRecycle", "(Z)Ljava/lang/Object;", "requestCache", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "saveCache", "timestamp", "(Ljava/lang/Object;J)V", "saveJob", "preloadJob", "plugin-datapreloader_release"}, k=1, mv={1, 5, 1}, xi=48)
public class c<_key, _result>
  extends b<_key, _result>
{
  private _result cpt;
  private long xfV;
  private ay<? extends _result> xfW;
  
  public c(_key param_key)
  {
    super(param_key);
  }
  
  public final void a(ay<? extends _result> paramay)
  {
    AppMethodBeat.i(260477);
    s.u(paramay, "preloadJob");
    this.xfW = paramay;
    AppMethodBeat.o(260477);
  }
  
  public Object aa(kotlin.d.d<? super _result> paramd)
  {
    AppMethodBeat.i(260486);
    paramd = a(this, paramd);
    AppMethodBeat.o(260486);
    return paramd;
  }
  
  public final void clearCache()
  {
    this.cpt = null;
    this.xfV = 0L;
  }
  
  public final ay<_result> dtj()
  {
    return this.xfW;
  }
  
  public final void dtk()
  {
    this.xfW = null;
  }
  
  protected final ay<_result> dtl()
  {
    return this.xfW;
  }
  
  public boolean dtm()
  {
    return true;
  }
  
  protected final _result getData()
  {
    return this.cpt;
  }
  
  public final _result nx(boolean paramBoolean)
  {
    AppMethodBeat.i(260489);
    Object localObject = this.cpt;
    if ((paramBoolean) && (this.cpt != null)) {
      s.checkNotNull(this.cpt);
    }
    this.cpt = null;
    AppMethodBeat.o(260489);
    return localObject;
  }
  
  public void r(_result param_result, long paramLong)
  {
    this.cpt = param_result;
    this.xfV = paramLong;
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends kotlin.d.b.a.d
  {
    Object L$0;
    int label;
    
    a(c<_key, _result> paramc, kotlin.d.d<? super a> paramd)
    {
      super();
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(260436);
      this.result = paramObject;
      this.label |= 0x80000000;
      paramObject = c.a(this.xfX, (kotlin.d.d)this);
      AppMethodBeat.o(260436);
      return paramObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.datapreloader.a.c
 * JD-Core Version:    0.7.0.1
 */