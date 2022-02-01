package com.tencent.mm.plugin.game.chatroom.g;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.b.e;
import com.tencent.mm.vfs.y;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/game/chatroom/loader/ChatRoomAvatarDiskCache;", "Lcom/tencent/mm/loader/cache/disk/BitmapDiskCache;", "Lcom/tencent/mm/plugin/game/chatroom/loader/ChatRoomAvatarData;", "()V", "buildFilePath", "", "url", "Lcom/tencent/mm/loader/model/data/DataItem;", "opts", "Lcom/tencent/mm/loader/cfg/ImageLoaderOptions;", "reaper", "Lcom/tencent/mm/loader/Reaper;", "Landroid/graphics/Bitmap;", "clear", "", "get", "Lcom/tencent/mm/loader/model/datasource/DataSource;", "onSaveCompleted", "", "diskResource", "Lcom/tencent/mm/loader/model/Resource;", "onSaveStarted", "httpResponse", "Lcom/tencent/mm/loader/model/Response;", "resource", "game-chatroom_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  extends com.tencent.mm.loader.cache.a.a<a>
{
  public final boolean a(com.tencent.mm.loader.g.a.a<a> parama, e parame, com.tencent.mm.loader.f<?, Bitmap> paramf)
  {
    AppMethodBeat.i(275890);
    s.u(parama, "url");
    s.u(parame, "opts");
    s.u(paramf, "reaper");
    AppMethodBeat.o(275890);
    return true;
  }
  
  public final boolean a(com.tencent.mm.loader.g.a.a<a> parama, com.tencent.mm.loader.g.f<?> paramf, e parame, com.tencent.mm.loader.f<?, Bitmap> paramf1)
  {
    AppMethodBeat.i(275882);
    s.u(parama, "url");
    s.u(paramf, "httpResponse");
    s.u(parame, "opts");
    s.u(paramf1, "reaper");
    AppMethodBeat.o(275882);
    return true;
  }
  
  public final com.tencent.mm.loader.g.b.a b(com.tencent.mm.loader.g.a.a<a> parama, e parame, com.tencent.mm.loader.f<?, Bitmap> paramf)
  {
    AppMethodBeat.i(275916);
    s.u(parama, "url");
    s.u(parame, "opts");
    s.u(paramf, "reaper");
    parama = ((a)parama.bmg()).getPath();
    if (y.ZC(parama))
    {
      parama = com.tencent.mm.loader.g.b.a.GJ(parama);
      AppMethodBeat.o(275916);
      return parama;
    }
    AppMethodBeat.o(275916);
    return null;
  }
  
  public final String c(com.tencent.mm.loader.g.a.a<a> parama, e parame, com.tencent.mm.loader.f<?, Bitmap> paramf)
  {
    AppMethodBeat.i(275899);
    s.u(parama, "url");
    s.u(parame, "opts");
    s.u(paramf, "reaper");
    parama = ((a)parama.bmg()).getPath();
    AppMethodBeat.o(275899);
    return parama;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.game.chatroom.g.b
 * JD-Core Version:    0.7.0.1
 */