package com.tencent.mm.emoji.loader;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.g;
import com.tencent.mm.kernel.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import com.tencent.mm.vfs.u;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/emoji/loader/EmojiGroupDiskCache;", "Lcom/tencent/mm/loader/cache/disk/BitmapDiskCache;", "Lcom/tencent/mm/emoji/loader/EmojiGroupData;", "()V", "TAG", "", "TAG$1", "buildFilePath", "url", "Lcom/tencent/mm/loader/model/data/DataItem;", "opts", "Lcom/tencent/mm/loader/cfg/ImageLoaderOptions;", "reaper", "Lcom/tencent/mm/loader/Reaper;", "Landroid/graphics/Bitmap;", "clear", "", "get", "Lcom/tencent/mm/loader/model/datasource/DataSource;", "onSaveCompleted", "", "diskResource", "Lcom/tencent/mm/loader/model/Resource;", "onSaveStarted", "httpResponse", "Lcom/tencent/mm/loader/model/Response;", "resource", "Companion", "plugin-emojisdk_release"})
public final class b
  extends com.tencent.mm.loader.b.a.a<a>
{
  private static final String TAG = "MicroMsg.EmojiGroupDiskCache";
  public static final a jGy;
  private final String jGx = "MicroMsg.EmojiThumbLoader";
  
  static
  {
    AppMethodBeat.i(183953);
    jGy = new a((byte)0);
    TAG = "MicroMsg.EmojiGroupDiskCache";
    AppMethodBeat.o(183953);
  }
  
  public final boolean a(com.tencent.mm.loader.h.a.a<a> parama, com.tencent.mm.loader.c.e parame, com.tencent.mm.loader.f<?, Bitmap> paramf)
  {
    AppMethodBeat.i(105382);
    p.k(parama, "url");
    p.k(parame, "opts");
    p.k(paramf, "reaper");
    AppMethodBeat.o(105382);
    return true;
  }
  
  public final boolean a(com.tencent.mm.loader.h.a.a<a> parama, com.tencent.mm.loader.h.f<?> paramf, com.tencent.mm.loader.c.e parame, com.tencent.mm.loader.f<?, Bitmap> paramf1)
  {
    AppMethodBeat.i(105381);
    p.k(parama, "url");
    p.k(paramf, "httpResponse");
    p.k(parame, "opts");
    p.k(paramf1, "reaper");
    AppMethodBeat.o(105381);
    return true;
  }
  
  public final com.tencent.mm.loader.h.b.a b(com.tencent.mm.loader.h.a.a<a> parama, com.tencent.mm.loader.c.e parame, com.tencent.mm.loader.f<?, Bitmap> paramf)
  {
    AppMethodBeat.i(105383);
    p.k(parama, "url");
    p.k(parame, "opts");
    p.k(paramf, "reaper");
    parame = new StringBuilder();
    paramf = h.ag(com.tencent.mm.plugin.emoji.b.d.class);
    p.j(paramf, "MMKernel.plugin(IPluginEmoji::class.java)");
    paramf = ((com.tencent.mm.plugin.emoji.b.d)paramf).getProvider();
    p.j(paramf, "MMKernel.plugin(IPluginEmoji::class.java).provider");
    parame = paramf.getAccPath() + "emoji/";
    parama = ((a)parama.aSr()).jGw.hBl();
    p.j(parama, "url.value().groupInfo.productID");
    parama = p.I(a.j(parame, parama, ""), "_panel_enable");
    if (u.agG(parama))
    {
      parama = com.tencent.mm.loader.h.b.a.Ov(parama);
      AppMethodBeat.o(105383);
      return parama;
    }
    AppMethodBeat.o(105383);
    return null;
  }
  
  public final String c(com.tencent.mm.loader.h.a.a<a> parama, com.tencent.mm.loader.c.e parame, com.tencent.mm.loader.f<?, Bitmap> paramf)
  {
    AppMethodBeat.i(239608);
    p.k(parama, "url");
    p.k(parame, "opts");
    p.k(paramf, "reaper");
    parame = new StringBuilder();
    paramf = h.ag(com.tencent.mm.plugin.emoji.b.d.class);
    p.j(paramf, "MMKernel.plugin(IPluginEmoji::class.java)");
    paramf = ((com.tencent.mm.plugin.emoji.b.d)paramf).getProvider();
    p.j(paramf, "MMKernel.plugin(IPluginEmoji::class.java).provider");
    parame = paramf.getAccPath() + "emoji/";
    parama = ((a)parama.aSr()).jGw.hBl();
    p.j(parama, "url.value().groupInfo.productID");
    parama = p.I(a.j(parame, parama, ""), "_panel_enable");
    AppMethodBeat.o(239608);
    return parama;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/emoji/loader/EmojiGroupDiskCache$Companion;", "", "()V", "TAG", "", "getIconPath", "rootPath", "productId", "url", "getMD5", "plugin-emojisdk_release"})
  public static final class a
  {
    private static String as(String paramString1, String paramString2)
    {
      AppMethodBeat.i(183952);
      p.k(paramString1, "productId");
      p.k(paramString2, "url");
      if ((Util.isNullOrNil(paramString1)) && (Util.isNullOrNil(paramString2)))
      {
        Log.e(b.access$getTAG$cp(), "[cpan] product id and url are null.");
        AppMethodBeat.o(183952);
        return null;
      }
      if (Util.isNullOrNil(paramString2))
      {
        paramString1 = paramString1.getBytes(kotlin.n.d.UTF_8);
        p.j(paramString1, "(this as java.lang.String).getBytes(charset)");
      }
      for (paramString1 = g.getMessageDigest(paramString1);; paramString1 = g.getMessageDigest(paramString1))
      {
        AppMethodBeat.o(183952);
        return paramString1;
        paramString1 = paramString2.getBytes(kotlin.n.d.UTF_8);
        p.j(paramString1, "(this as java.lang.String).getBytes(charset)");
      }
    }
    
    public static String j(String paramString1, String paramString2, String paramString3)
    {
      Object localObject = null;
      AppMethodBeat.i(183951);
      p.k(paramString1, "rootPath");
      p.k(paramString2, "productId");
      p.k(paramString3, "url");
      if ((Util.isNullOrNil(paramString2)) && (Util.isNullOrNil(paramString3)))
      {
        Log.w(b.access$getTAG$cp(), "[cpan] get icon path failed. productid and url are null.");
        AppMethodBeat.o(183951);
        return null;
      }
      String str = as(paramString2, paramString3);
      paramString3 = localObject;
      if (!Util.isNullOrNil(str))
      {
        if (!Util.isNullOrNil(paramString2)) {
          break label115;
        }
        paramString1 = new StringBuilder().append(paramString1);
        if (str == null) {
          p.iCn();
        }
      }
      label115:
      for (paramString3 = str;; paramString3 = paramString1 + paramString2 + "/" + str)
      {
        AppMethodBeat.o(183951);
        return paramString3;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.emoji.loader.b
 * JD-Core Version:    0.7.0.1
 */