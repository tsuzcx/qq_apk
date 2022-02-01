package com.tencent.mm.loader.d;

import com.tencent.mm.loader.f.g;
import com.tencent.mm.loader.h.a.a;
import com.tencent.mm.loader.h.f;
import d.g.b.p;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/loader/common/IDataFetcher;", "T", "", "()V", "loadData", "", "url", "Lcom/tencent/mm/loader/model/data/DataItem;", "fileNameCreator", "Lcom/tencent/mm/loader/listener/ILoadFileNameCreator;", "loader", "Lcom/tencent/mm/loader/loader/ITaskLoader;", "callback", "Lcom/tencent/mm/loader/common/IDataFetcher$IDataReady;", "loadDataImp", "Lcom/tencent/mm/loader/common/IDataFetcher$IDataReady2;", "IDataReady", "IDataReady2", "libimageloader_release"})
public abstract class b<T>
{
  protected abstract void a(a<T> parama, g paramg, b paramb);
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/loader/common/IDataFetcher$IDataReady;", "", "onDataReady", "", "resp", "Lcom/tencent/mm/loader/model/Response;", "onError", "onTransferToBatchGet", "libimageloader_release"})
  public static abstract interface a
  {
    public abstract void a(f<?> paramf);
    
    public abstract void onError();
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/loader/common/IDataFetcher$IDataReady2;", "", "onDataReady", "", "resp", "Lcom/tencent/mm/loader/model/Response;", "onError", "onTransferToBatchGet", "libimageloader_release"})
  public static abstract interface b
  {
    public abstract void a(f<?> paramf);
    
    public abstract void onError();
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "T", "run"})
  public static final class c
    implements Runnable
  {
    public c(b paramb, com.tencent.mm.loader.g.b paramb1, a parama, g paramg, b.a parama1) {}
    
    public final void run()
    {
      this.het.execute((Runnable)new Runnable()
      {
        public final void run()
        {
          this.hex.hes.a(this.hex.heu, this.hex.hev, (b.b)new b.b()
          {
            public final void a(f<?> paramAnonymous2f)
            {
              p.h(paramAnonymous2f, "resp");
              this.hey.hex.hew.a(paramAnonymous2f);
            }
            
            public final void onError()
            {
              this.hey.hex.hew.onError();
            }
          });
        }
      });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.loader.d.b
 * JD-Core Version:    0.7.0.1
 */