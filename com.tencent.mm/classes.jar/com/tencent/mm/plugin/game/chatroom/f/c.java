package com.tencent.mm.plugin.game.chatroom.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.d.b.b;
import com.tencent.mm.loader.f.g;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/game/chatroom/loader/ChatRoomAvatarDownloader;", "Lcom/tencent/mm/loader/common/IDataFetcher;", "Lcom/tencent/mm/plugin/game/chatroom/loader/ChatRoomAvatarData;", "()V", "downloader", "Lcom/tencent/mm/loader/impr/DefaultImageDownloader;", "loadDataImp", "", "url", "Lcom/tencent/mm/loader/model/data/DataItem;", "fileNameCreator", "Lcom/tencent/mm/loader/listener/ILoadFileNameCreator;", "callback", "Lcom/tencent/mm/loader/common/IDataFetcher$IDataReady2;", "game-chatroom_release"})
public final class c
  extends com.tencent.mm.loader.d.b<a>
{
  private final com.tencent.mm.loader.e.b jGz;
  
  public c()
  {
    AppMethodBeat.i(210854);
    this.jGz = new com.tencent.mm.loader.e.b();
    AppMethodBeat.o(210854);
  }
  
  public final void a(com.tencent.mm.loader.h.a.a<a> parama, g paramg, b.b paramb)
  {
    AppMethodBeat.i(210852);
    p.k(parama, "url");
    p.k(paramg, "fileNameCreator");
    p.k(paramb, "callback");
    this.jGz.a(new com.tencent.mm.loader.h.a.a(((a)parama.aSr()).url), paramg, paramb);
    AppMethodBeat.o(210852);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.game.chatroom.f.c
 * JD-Core Version:    0.7.0.1
 */