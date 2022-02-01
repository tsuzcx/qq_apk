package com.tencent.mm.loader.d;

import com.tencent.mm.loader.f.g;
import com.tencent.mm.loader.h.a.a;
import com.tencent.mm.loader.h.f;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/loader/common/IDataFetcher;", "T", "", "()V", "loadData", "", "url", "Lcom/tencent/mm/loader/model/data/DataItem;", "fileNameCreator", "Lcom/tencent/mm/loader/listener/ILoadFileNameCreator;", "loader", "Lcom/tencent/mm/loader/loader/ITaskLoader;", "callback", "Lcom/tencent/mm/loader/common/IDataFetcher$IDataReady;", "loadDataImp", "Lcom/tencent/mm/loader/common/IDataFetcher$IDataReady2;", "IDataReady", "IDataReady2", "libimageloader_release"})
public abstract class b<T>
{
  protected abstract void a(a<T> parama, g paramg, b paramb);
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/loader/common/IDataFetcher$IDataReady2;", "", "onDataReady", "", "resp", "Lcom/tencent/mm/loader/model/Response;", "onError", "onTransferToBatchGet", "libimageloader_release"})
  public static abstract interface b
  {
    public abstract void a(f<?> paramf);
    
    public abstract void onError();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.loader.d.b
 * JD-Core Version:    0.7.0.1
 */