package com.tencent.mm.plugin.datapreloader;

import kotlin.Metadata;
import kotlin.d.d;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/datapreloader/IDataFuture;", "_key", "_value", "", "cancelTask", "", "getKey", "()Ljava/lang/Object;", "hitPreloadCache", "value", "(Ljava/lang/Object;)V", "runTask", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "plugin-datapreloader_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract interface b<_key, _value>
{
  public abstract Object Z(d<? super _value> paramd);
  
  public abstract void ez(_value param_value);
  
  public abstract _key getKey();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.datapreloader.b
 * JD-Core Version:    0.7.0.1
 */