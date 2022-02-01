package com.tencent.mm.plugin.livelist.a;

import com.tencent.mm.plugin.livelist.b;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/livelist/datasource/BaseDataSource;", "T", "Lcom/tencent/mm/plugin/livelist/IMMLiveListItem;", "Lcom/tencent/mm/plugin/livelist/datasource/IDataSource;", "Lcom/tencent/mm/plugin/livelist/datasource/DataRequest;", "Lcom/tencent/mm/plugin/livelist/datasource/DataResponse;", "()V", "combine", "dataSource", "plugin-livelist_release"})
public abstract class a<T extends b>
  implements e<T, c<T>, d<T>>
{
  public e<T, c<T>, d<T>> a(e<T, c<T>, d<T>> parame)
  {
    p.k(parame, "dataSource");
    return (e)new f(new e[] { (e)this, parame });
  }
  
  public int getPriority()
  {
    return 0;
  }
  
  public void onCreate() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.livelist.a.a
 * JD-Core Version:    0.7.0.1
 */