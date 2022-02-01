package com.tencent.mm.plugin.livelist.a;

import com.tencent.mm.plugin.livelist.i;
import kotlin.g.b.p;
import kotlin.l;
import kotlinx.coroutines.ak;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/livelist/datasource/BaseSearchDataSource;", "T", "Lcom/tencent/mm/plugin/livelist/IMMLiveListItem;", "Q", "Lcom/tencent/mm/plugin/livelist/datasource/BaseDataSource;", "()V", "getData", "Lkotlinx/coroutines/flow/Flow;", "Lcom/tencent/mm/plugin/livelist/datasource/DataResponse;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "request", "Lcom/tencent/mm/plugin/livelist/datasource/DataRequest;", "getSearchData", "Lcom/tencent/mm/plugin/livelist/SearchDataRequest;", "stopSearch", "", "plugin-livelist_release"})
public abstract class b<T extends com.tencent.mm.plugin.livelist.b, Q>
  extends a<T>
{
  public final kotlinx.coroutines.b.b<d<T>> a(ak paramak, c<T> paramc)
  {
    p.k(paramak, "scope");
    p.k(paramc, "request");
    return a(paramak, (i)paramc);
  }
  
  public abstract kotlinx.coroutines.b.b<d<T>> a(ak paramak, i<T, Q> parami);
  
  public abstract void erx();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.livelist.a.b
 * JD-Core Version:    0.7.0.1
 */