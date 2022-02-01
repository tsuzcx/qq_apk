package com.tencent.mm.loader.d;

import com.tencent.mm.loader.h.a.a;
import d.g.b.k;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/loader/common/IDataFetcher;", "T", "", "()V", "loadData", "", "url", "Lcom/tencent/mm/loader/model/data/DataItem;", "fileNameCreator", "Lcom/tencent/mm/loader/listener/ILoadFileNameCreator;", "loader", "Lcom/tencent/mm/loader/loader/ITaskLoader;", "callback", "Lcom/tencent/mm/loader/common/IDataFetcher$IDataReady;", "loadDataImp", "Lcom/tencent/mm/loader/common/IDataFetcher$IDataReady2;", "IDataReady", "IDataReady2", "libimageloader_release"})
public abstract class b<T>
{
  protected abstract void a(a<T> parama, com.tencent.mm.loader.f.f paramf, b paramb);
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/loader/common/IDataFetcher$IDataReady;", "", "onDataReady", "", "resp", "Lcom/tencent/mm/loader/model/Response;", "onError", "onTransferToBatchGet", "libimageloader_release"})
  public static abstract interface a
  {
    public abstract void a(com.tencent.mm.loader.h.f<?> paramf);
    
    public abstract void onError();
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/loader/common/IDataFetcher$IDataReady2;", "", "onDataReady", "", "resp", "Lcom/tencent/mm/loader/model/Response;", "onError", "onTransferToBatchGet", "libimageloader_release"})
  public static abstract interface b
  {
    public abstract void a(com.tencent.mm.loader.h.f<?> paramf);
    
    public abstract void onError();
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "T", "run"})
  public static final class c
    implements Runnable
  {
    public c(b paramb, com.tencent.mm.loader.g.b paramb1, a parama, com.tencent.mm.loader.f.f paramf, b.a parama1) {}
    
    public final void run()
    {
      this.gjV.execute((Runnable)new Runnable()
      {
        public final void run()
        {
          this.gjZ.gjU.a(this.gjZ.gjW, this.gjZ.gjX, (b.b)new b.b()
          {
            public final void a(com.tencent.mm.loader.h.f<?> paramAnonymous2f)
            {
              k.h(paramAnonymous2f, "resp");
              this.gka.gjZ.gjY.a(paramAnonymous2f);
            }
            
            public final void onError()
            {
              this.gka.gjZ.gjY.onError();
            }
          });
        }
      });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.loader.d.b
 * JD-Core Version:    0.7.0.1
 */