package com.tencent.mm.plugin.gamelife.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.c.b.b;
import com.tencent.mm.loader.e.g;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/gamelife/loader/GameLifeAvatarDownloader;", "Lcom/tencent/mm/loader/common/IDataFetcher;", "Lcom/tencent/mm/plugin/gamelife/loader/GameLifeAvatarData;", "()V", "downloader", "Lcom/tencent/mm/loader/impr/DefaultImageDownloader;", "loadDataImp", "", "url", "Lcom/tencent/mm/loader/model/data/DataItem;", "fileNameCreator", "Lcom/tencent/mm/loader/listener/ILoadFileNameCreator;", "callback", "Lcom/tencent/mm/loader/common/IDataFetcher$IDataReady2;", "plugin-gamelife_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
  extends com.tencent.mm.loader.c.b<a>
{
  private final com.tencent.mm.loader.d.b mgg;
  
  public c()
  {
    AppMethodBeat.i(268134);
    this.mgg = new com.tencent.mm.loader.d.b();
    AppMethodBeat.o(268134);
  }
  
  public final void a(com.tencent.mm.loader.g.a.a<a> parama, g paramg, b.b paramb)
  {
    AppMethodBeat.i(268144);
    s.u(parama, "url");
    s.u(paramg, "fileNameCreator");
    s.u(paramb, "callback");
    this.mgg.a(new com.tencent.mm.loader.g.a.a(((a)parama.bmg()).url), paramg, paramb);
    AppMethodBeat.o(268144);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.gamelife.g.c
 * JD-Core Version:    0.7.0.1
 */