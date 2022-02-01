package com.tencent.mm.emoji.loader;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import com.tencent.mm.vfs.i;
import d.g.b.k;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/emoji/loader/EmojiGroupDiskCache;", "Lcom/tencent/mm/loader/cache/disk/BitmapDiskCache;", "Lcom/tencent/mm/emoji/loader/EmojiGroupData;", "()V", "TAG", "", "TAG$1", "clear", "", "opts", "Lcom/tencent/mm/loader/cfg/ImageLoaderOptions;", "reaper", "Lcom/tencent/mm/loader/Reaper;", "Landroid/graphics/Bitmap;", "get", "Lcom/tencent/mm/loader/model/datasource/DataSource;", "url", "Lcom/tencent/mm/loader/model/data/DataItem;", "onSaveCompleted", "", "diskResource", "Lcom/tencent/mm/loader/model/Resource;", "onSaveStarted", "httpResponse", "Lcom/tencent/mm/loader/model/Response;", "resource", "Companion", "plugin-emojisdk_release"})
public final class b
  extends com.tencent.mm.loader.b.a.a<a>
{
  private static final String TAG = "MicroMsg.EmojiGroupDiskCache";
  public static final a fLd;
  private final String fLc = "MicroMsg.EmojiThumbLoader";
  
  static
  {
    AppMethodBeat.i(183953);
    fLd = new a((byte)0);
    TAG = "MicroMsg.EmojiGroupDiskCache";
    AppMethodBeat.o(183953);
  }
  
  public final boolean a(com.tencent.mm.loader.h.a.a<a> parama, com.tencent.mm.loader.c.e parame, com.tencent.mm.loader.f<?, Bitmap> paramf)
  {
    AppMethodBeat.i(105382);
    k.h(parama, "url");
    k.h(parame, "opts");
    k.h(paramf, "reaper");
    AppMethodBeat.o(105382);
    return true;
  }
  
  public final boolean a(com.tencent.mm.loader.h.a.a<a> parama, com.tencent.mm.loader.h.f<?> paramf, com.tencent.mm.loader.c.e parame, com.tencent.mm.loader.f<?, Bitmap> paramf1)
  {
    AppMethodBeat.i(105381);
    k.h(parama, "url");
    k.h(paramf, "httpResponse");
    k.h(parame, "opts");
    k.h(paramf1, "reaper");
    AppMethodBeat.o(105381);
    return true;
  }
  
  public final com.tencent.mm.loader.h.b.a b(com.tencent.mm.loader.h.a.a<a> parama, com.tencent.mm.loader.c.e parame, com.tencent.mm.loader.f<?, Bitmap> paramf)
  {
    AppMethodBeat.i(105383);
    k.h(parama, "url");
    k.h(parame, "opts");
    k.h(paramf, "reaper");
    parame = new StringBuilder();
    paramf = com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.emoji.b.d.class);
    k.g(paramf, "MMKernel.plugin(IPluginEmoji::class.java)");
    paramf = ((com.tencent.mm.plugin.emoji.b.d)paramf).getProvider();
    k.g(paramf, "MMKernel.plugin(IPluginEmoji::class.java).provider");
    parame = paramf.getAccPath() + "emoji/";
    parama = ((a)parama.value()).fLb.fZJ();
    k.g(parama, "url.value().groupInfo.productID");
    parama = k.C(a.j(parame, parama, ""), "_panel_enable");
    if (i.eK(parama))
    {
      parama = com.tencent.mm.loader.h.b.a.ri(parama);
      AppMethodBeat.o(105383);
      return parama;
    }
    AppMethodBeat.o(105383);
    return null;
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/emoji/loader/EmojiGroupDiskCache$Companion;", "", "()V", "TAG", "", "getIconPath", "rootPath", "productId", "url", "getMD5", "plugin-emojisdk_release"})
  public static final class a
  {
    private static String ah(String paramString1, String paramString2)
    {
      AppMethodBeat.i(183952);
      k.h(paramString1, "productId");
      k.h(paramString2, "url");
      if ((bt.isNullOrNil(paramString1)) && (bt.isNullOrNil(paramString2)))
      {
        ad.e(b.access$getTAG$cp(), "[cpan] product id and url are null.");
        AppMethodBeat.o(183952);
        return null;
      }
      if (bt.isNullOrNil(paramString2))
      {
        paramString1 = paramString1.getBytes(d.n.d.UTF_8);
        k.g(paramString1, "(this as java.lang.String).getBytes(charset)");
      }
      for (paramString1 = com.tencent.mm.b.g.getMessageDigest(paramString1);; paramString1 = com.tencent.mm.b.g.getMessageDigest(paramString1))
      {
        AppMethodBeat.o(183952);
        return paramString1;
        paramString1 = paramString2.getBytes(d.n.d.UTF_8);
        k.g(paramString1, "(this as java.lang.String).getBytes(charset)");
      }
    }
    
    public static String j(String paramString1, String paramString2, String paramString3)
    {
      Object localObject = null;
      AppMethodBeat.i(183951);
      k.h(paramString1, "rootPath");
      k.h(paramString2, "productId");
      k.h(paramString3, "url");
      if ((bt.isNullOrNil(paramString2)) && (bt.isNullOrNil(paramString3)))
      {
        ad.w(b.access$getTAG$cp(), "[cpan] get icon path failed. productid and url are null.");
        AppMethodBeat.o(183951);
        return null;
      }
      String str = ah(paramString2, paramString3);
      paramString3 = localObject;
      if (!bt.isNullOrNil(str))
      {
        if (!bt.isNullOrNil(paramString2)) {
          break label115;
        }
        paramString1 = new StringBuilder().append(paramString1);
        if (str == null) {
          k.fvU();
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