package com.tencent.mm.plugin.datapreloader.a;

import kotlin.Metadata;
import kotlin.d.d;
import kotlinx.coroutines.ay;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/datapreloader/cache/IDataCache;", "_key", "_result", "", "key", "(Ljava/lang/Object;)V", "getKey", "()Ljava/lang/Object;", "Ljava/lang/Object;", "checkCacheAvailable", "", "clearCache", "", "clearJob", "getJob", "Lkotlinx/coroutines/Deferred;", "recycleCache", "removeCache", "needRecycle", "(Z)Ljava/lang/Object;", "requestCache", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "saveCache", "result", "timestamp", "", "(Ljava/lang/Object;J)V", "saveJob", "preloadJob", "plugin-datapreloader_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class b<_key, _result>
{
  private final _key key;
  
  public b(_key param_key)
  {
    this.key = param_key;
  }
  
  public abstract void a(ay<? extends _result> paramay);
  
  public abstract Object aa(d<? super _result> paramd);
  
  public abstract ay<_result> dtj();
  
  public abstract void dtk();
  
  public abstract _result nx(boolean paramBoolean);
  
  public abstract void r(_result param_result, long paramLong);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.datapreloader.a.b
 * JD-Core Version:    0.7.0.1
 */