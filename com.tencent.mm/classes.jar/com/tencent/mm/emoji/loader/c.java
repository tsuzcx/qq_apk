package com.tencent.mm.emoji.loader;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.d.b.b;
import com.tencent.mm.loader.f.f;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import d.g.b.k;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/emoji/loader/EmojiGroupDownloader;", "Lcom/tencent/mm/loader/common/IDataFetcher;", "Lcom/tencent/mm/emoji/loader/EmojiGroupData;", "()V", "downloader", "Lcom/tencent/mm/loader/impr/DefaultImageDownloader;", "loadDataImp", "", "url", "Lcom/tencent/mm/loader/model/data/DataItem;", "fileNameCreator", "Lcom/tencent/mm/loader/listener/ILoadFileNameCreator;", "callback", "Lcom/tencent/mm/loader/common/IDataFetcher$IDataReady2;", "plugin-emojisdk_release"})
public final class c
  extends com.tencent.mm.loader.d.b<a>
{
  private final com.tencent.mm.loader.e.b fLe;
  
  public c()
  {
    AppMethodBeat.i(105385);
    this.fLe = new com.tencent.mm.loader.e.b();
    AppMethodBeat.o(105385);
  }
  
  public final void a(com.tencent.mm.loader.h.a.a<a> parama, f paramf, b.b paramb)
  {
    AppMethodBeat.i(105384);
    k.h(parama, "url");
    k.h(paramf, "fileNameCreator");
    k.h(paramb, "callback");
    this.fLe.a(new com.tencent.mm.loader.h.a.a(((a)parama.value()).fLb.fZK()), paramf, paramb);
    AppMethodBeat.o(105384);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.emoji.loader.c
 * JD-Core Version:    0.7.0.1
 */