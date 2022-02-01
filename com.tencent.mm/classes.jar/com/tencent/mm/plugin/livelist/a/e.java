package com.tencent.mm.plugin.livelist.a;

import kotlin.l;
import kotlinx.coroutines.ak;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/livelist/datasource/IDataSource;", "T", "Lcom/tencent/mm/plugin/livelist/IMMLiveListItem;", "Req", "Resp", "", "checkDataSourceCondition", "", "item", "(Lcom/tencent/mm/plugin/livelist/IMMLiveListItem;)Z", "combine", "dataSource", "getData", "Lkotlinx/coroutines/flow/Flow;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "request", "(Lkotlinx/coroutines/CoroutineScope;Ljava/lang/Object;)Lkotlinx/coroutines/flow/Flow;", "getPriority", "", "isInDataSource", "onCreate", "", "plugin-livelist_release"})
public abstract interface e<T extends com.tencent.mm.plugin.livelist.b, Req, Resp>
{
  public abstract kotlinx.coroutines.b.b<Resp> a(ak paramak, Req paramReq);
  
  public abstract int getPriority();
  
  public abstract void onCreate();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.livelist.a.e
 * JD-Core Version:    0.7.0.1
 */