package com.tencent.mm.loader.c;

import com.tencent.mm.loader.e.g;
import com.tencent.mm.loader.g.a.a;
import com.tencent.mm.loader.g.f;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/loader/common/IDataFetcher;", "T", "", "()V", "loadData", "", "url", "Lcom/tencent/mm/loader/model/data/DataItem;", "fileNameCreator", "Lcom/tencent/mm/loader/listener/ILoadFileNameCreator;", "loader", "Lcom/tencent/mm/loader/loader/ITaskLoader;", "callback", "Lcom/tencent/mm/loader/common/IDataFetcher$IDataReady;", "loadDataImp", "Lcom/tencent/mm/loader/common/IDataFetcher$IDataReady2;", "IDataReady", "IDataReady2", "libimageloader_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class b<T>
{
  private static final void a(b paramb, a parama, g paramg, a parama1)
  {
    s.u(paramb, "this$0");
    s.u(parama, "$url");
    s.u(paramg, "$fileNameCreator");
    s.u(parama1, "$callback");
    paramb.a(parama, paramg, (b)new c(parama1));
  }
  
  private static final void a(com.tencent.mm.loader.f.b paramb, b paramb1, a parama, g paramg, a parama1)
  {
    s.u(paramb, "$loader");
    s.u(paramb1, "this$0");
    s.u(parama, "$url");
    s.u(paramg, "$fileNameCreator");
    s.u(parama1, "$callback");
    paramb.execute(new b..ExternalSyntheticLambda0(paramb1, parama, paramg, parama1));
  }
  
  protected abstract void a(a<T> parama, g paramg, b paramb);
  
  public final void a(a<T> parama, g paramg, com.tencent.mm.loader.f.b paramb, a parama1)
  {
    s.u(parama, "url");
    s.u(paramg, "fileNameCreator");
    s.u(paramb, "loader");
    s.u(parama1, "callback");
    paramb.I(new b..ExternalSyntheticLambda1(paramb, this, parama, paramg, parama1));
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/loader/common/IDataFetcher$IDataReady;", "", "onDataReady", "", "resp", "Lcom/tencent/mm/loader/model/Response;", "onError", "onTransferToBatchGet", "libimageloader_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract interface a
  {
    public abstract void a(f<?> paramf);
    
    public abstract void atR();
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/loader/common/IDataFetcher$IDataReady2;", "", "onDataReady", "", "resp", "Lcom/tencent/mm/loader/model/Response;", "onError", "onTransferToBatchGet", "libimageloader_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract interface b
  {
    public abstract void a(f<?> paramf);
    
    public abstract void atR();
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/loader/common/IDataFetcher$loadData$1$1$1", "Lcom/tencent/mm/loader/common/IDataFetcher$IDataReady2;", "onDataReady", "", "resp", "Lcom/tencent/mm/loader/model/Response;", "onError", "onTransferToBatchGet", "libimageloader_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
    implements b.b
  {
    c(b.a parama) {}
    
    public final void a(f<?> paramf)
    {
      s.u(paramf, "resp");
      this.nqu.a(paramf);
    }
    
    public final void atR()
    {
      this.nqu.atR();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.loader.c.b
 * JD-Core Version:    0.7.0.1
 */