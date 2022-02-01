package com.tencent.mm.plugin.gamelife.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.d.b.b;
import com.tencent.mm.loader.f.g;
import d.g.b.p;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/gamelife/loader/GameLifeAvatarDownloader;", "Lcom/tencent/mm/loader/common/IDataFetcher;", "Lcom/tencent/mm/plugin/gamelife/loader/GameLifeAvatarData;", "()V", "downloader", "Lcom/tencent/mm/loader/impr/DefaultImageDownloader;", "loadDataImp", "", "url", "Lcom/tencent/mm/loader/model/data/DataItem;", "fileNameCreator", "Lcom/tencent/mm/loader/listener/ILoadFileNameCreator;", "callback", "Lcom/tencent/mm/loader/common/IDataFetcher$IDataReady2;", "plugin-gamelife_release"})
public final class c
  extends com.tencent.mm.loader.d.b<a>
{
  private final com.tencent.mm.loader.e.b giq;
  
  public c()
  {
    AppMethodBeat.i(211374);
    this.giq = new com.tencent.mm.loader.e.b();
    AppMethodBeat.o(211374);
  }
  
  public final void a(com.tencent.mm.loader.h.a.a<a> parama, g paramg, b.b paramb)
  {
    AppMethodBeat.i(211373);
    p.h(parama, "url");
    p.h(paramg, "fileNameCreator");
    p.h(paramb, "callback");
    this.giq.a(new com.tencent.mm.loader.h.a.a(((a)parama.value()).url), paramg, paramb);
    AppMethodBeat.o(211373);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.gamelife.f.c
 * JD-Core Version:    0.7.0.1
 */