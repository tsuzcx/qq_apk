package com.tencent.mm.emoji.loader;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.emoji.b.d;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import com.tencent.mm.vfs.s;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/emoji/loader/EmojiGroupDiskCache;", "Lcom/tencent/mm/loader/cache/disk/BitmapDiskCache;", "Lcom/tencent/mm/emoji/loader/EmojiGroupData;", "()V", "TAG", "", "TAG$1", "clear", "", "opts", "Lcom/tencent/mm/loader/cfg/ImageLoaderOptions;", "reaper", "Lcom/tencent/mm/loader/Reaper;", "Landroid/graphics/Bitmap;", "get", "Lcom/tencent/mm/loader/model/datasource/DataSource;", "url", "Lcom/tencent/mm/loader/model/data/DataItem;", "onSaveCompleted", "", "diskResource", "Lcom/tencent/mm/loader/model/Resource;", "onSaveStarted", "httpResponse", "Lcom/tencent/mm/loader/model/Response;", "resource", "Companion", "plugin-emojisdk_release"})
public final class b
  extends com.tencent.mm.loader.b.a.a<a>
{
  private static final String TAG = "MicroMsg.EmojiGroupDiskCache";
  public static final b.a gVC;
  private final String gVB = "MicroMsg.EmojiThumbLoader";
  
  static
  {
    AppMethodBeat.i(183953);
    gVC = new b.a((byte)0);
    TAG = "MicroMsg.EmojiGroupDiskCache";
    AppMethodBeat.o(183953);
  }
  
  public final boolean a(com.tencent.mm.loader.h.a.a<a> parama, com.tencent.mm.loader.c.e parame, com.tencent.mm.loader.f<?, Bitmap> paramf)
  {
    AppMethodBeat.i(105382);
    p.h(parama, "url");
    p.h(parame, "opts");
    p.h(paramf, "reaper");
    AppMethodBeat.o(105382);
    return true;
  }
  
  public final boolean a(com.tencent.mm.loader.h.a.a<a> parama, com.tencent.mm.loader.h.f<?> paramf, com.tencent.mm.loader.c.e parame, com.tencent.mm.loader.f<?, Bitmap> paramf1)
  {
    AppMethodBeat.i(105381);
    p.h(parama, "url");
    p.h(paramf, "httpResponse");
    p.h(parame, "opts");
    p.h(paramf1, "reaper");
    AppMethodBeat.o(105381);
    return true;
  }
  
  public final com.tencent.mm.loader.h.b.a b(com.tencent.mm.loader.h.a.a<a> parama, com.tencent.mm.loader.c.e parame, com.tencent.mm.loader.f<?, Bitmap> paramf)
  {
    AppMethodBeat.i(105383);
    p.h(parama, "url");
    p.h(parame, "opts");
    p.h(paramf, "reaper");
    parame = new StringBuilder();
    paramf = g.ah(d.class);
    p.g(paramf, "MMKernel.plugin(IPluginEmoji::class.java)");
    paramf = ((d)paramf).getProvider();
    p.g(paramf, "MMKernel.plugin(IPluginEmoji::class.java).provider");
    parame = paramf.getAccPath() + "emoji/";
    parama = ((a)parama.value()).gVA.hRu();
    p.g(parama, "url.value().groupInfo.productID");
    parama = p.I(b.a.j(parame, parama, ""), "_panel_enable");
    if (s.YS(parama))
    {
      parama = com.tencent.mm.loader.h.b.a.Hk(parama);
      AppMethodBeat.o(105383);
      return parama;
    }
    AppMethodBeat.o(105383);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.emoji.loader.b
 * JD-Core Version:    0.7.0.1
 */