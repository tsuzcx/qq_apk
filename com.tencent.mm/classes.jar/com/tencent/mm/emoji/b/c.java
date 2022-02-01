package com.tencent.mm.emoji.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.c.b.b;
import com.tencent.mm.loader.e.g;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/emoji/loader/EmojiGroupDownloader;", "Lcom/tencent/mm/loader/common/IDataFetcher;", "Lcom/tencent/mm/emoji/loader/EmojiGroupData;", "()V", "downloader", "Lcom/tencent/mm/loader/impr/DefaultImageDownloader;", "loadDataImp", "", "url", "Lcom/tencent/mm/loader/model/data/DataItem;", "fileNameCreator", "Lcom/tencent/mm/loader/listener/ILoadFileNameCreator;", "callback", "Lcom/tencent/mm/loader/common/IDataFetcher$IDataReady2;", "plugin-emojisdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
  extends com.tencent.mm.loader.c.b<a>
{
  private final com.tencent.mm.loader.d.b mgg;
  
  public c()
  {
    AppMethodBeat.i(105385);
    this.mgg = new com.tencent.mm.loader.d.b();
    AppMethodBeat.o(105385);
  }
  
  public final void a(com.tencent.mm.loader.g.a.a<a> parama, g paramg, b.b paramb)
  {
    AppMethodBeat.i(105384);
    s.u(parama, "url");
    s.u(paramg, "fileNameCreator");
    s.u(paramb, "callback");
    this.mgg.a(new com.tencent.mm.loader.g.a.a(((a)parama.bmg()).mgd.field_packGrayIconUrl), paramg, paramb);
    AppMethodBeat.o(105384);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.emoji.b.c
 * JD-Core Version:    0.7.0.1
 */