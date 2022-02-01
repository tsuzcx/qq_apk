package com.tencent.mm.emoji.b;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.emoji.c.d;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import com.tencent.mm.vfs.y;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/emoji/loader/EmojiGroupDiskCache;", "Lcom/tencent/mm/loader/cache/disk/BitmapDiskCache;", "Lcom/tencent/mm/emoji/loader/EmojiGroupData;", "()V", "TAG", "", "TAG$1", "buildFilePath", "url", "Lcom/tencent/mm/loader/model/data/DataItem;", "opts", "Lcom/tencent/mm/loader/cfg/ImageLoaderOptions;", "reaper", "Lcom/tencent/mm/loader/Reaper;", "Landroid/graphics/Bitmap;", "clear", "", "get", "Lcom/tencent/mm/loader/model/datasource/DataSource;", "onSaveCompleted", "", "diskResource", "Lcom/tencent/mm/loader/model/Resource;", "onSaveStarted", "httpResponse", "Lcom/tencent/mm/loader/model/Response;", "resource", "Companion", "plugin-emojisdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  extends com.tencent.mm.loader.cache.a.a<a>
{
  private static final String TAG;
  public static final b.a mge;
  private final String mgf = "MicroMsg.EmojiThumbLoader";
  
  static
  {
    AppMethodBeat.i(183953);
    mge = new b.a((byte)0);
    TAG = "MicroMsg.EmojiGroupDiskCache";
    AppMethodBeat.o(183953);
  }
  
  public final boolean a(com.tencent.mm.loader.g.a.a<a> parama, com.tencent.mm.loader.b.e parame, com.tencent.mm.loader.f<?, Bitmap> paramf)
  {
    AppMethodBeat.i(105382);
    s.u(parama, "url");
    s.u(parame, "opts");
    s.u(paramf, "reaper");
    AppMethodBeat.o(105382);
    return true;
  }
  
  public final boolean a(com.tencent.mm.loader.g.a.a<a> parama, com.tencent.mm.loader.g.f<?> paramf, com.tencent.mm.loader.b.e parame, com.tencent.mm.loader.f<?, Bitmap> paramf1)
  {
    AppMethodBeat.i(105381);
    s.u(parama, "url");
    s.u(paramf, "httpResponse");
    s.u(parame, "opts");
    s.u(paramf1, "reaper");
    AppMethodBeat.o(105381);
    return true;
  }
  
  public final com.tencent.mm.loader.g.b.a b(com.tencent.mm.loader.g.a.a<a> parama, com.tencent.mm.loader.b.e parame, com.tencent.mm.loader.f<?, Bitmap> paramf)
  {
    AppMethodBeat.i(105383);
    s.u(parama, "url");
    s.u(parame, "opts");
    s.u(paramf, "reaper");
    parame = s.X(((d)h.az(d.class)).getProvider().getAccPath(), "emoji/");
    parama = ((a)parama.bmg()).mgd.field_productID;
    s.s(parama, "url.value().groupInfo.productID");
    parama = s.X(b.a.o(parame, parama, ""), "_panel_enable");
    if (y.ZC(parama))
    {
      parama = com.tencent.mm.loader.g.b.a.GJ(parama);
      AppMethodBeat.o(105383);
      return parama;
    }
    AppMethodBeat.o(105383);
    return null;
  }
  
  public final String c(com.tencent.mm.loader.g.a.a<a> parama, com.tencent.mm.loader.b.e parame, com.tencent.mm.loader.f<?, Bitmap> paramf)
  {
    AppMethodBeat.i(242729);
    s.u(parama, "url");
    s.u(parame, "opts");
    s.u(paramf, "reaper");
    parame = s.X(((d)h.az(d.class)).getProvider().getAccPath(), "emoji/");
    parama = ((a)parama.bmg()).mgd.field_productID;
    s.s(parama, "url.value().groupInfo.productID");
    parama = s.X(b.a.o(parame, parama, ""), "_panel_enable");
    AppMethodBeat.o(242729);
    return parama;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.emoji.b.b
 * JD-Core Version:    0.7.0.1
 */