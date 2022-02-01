package com.tencent.mm.emoji.loader.c;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory.Options;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.decode.MMGIFJNIFactory;
import com.tencent.mm.emoji.decode.MMGIFJNIFactory.Companion;
import com.tencent.mm.emoji.loader.d.i.a;
import com.tencent.mm.graphics.MMBitmapFactory;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.emoji.PluginEmoji;
import com.tencent.mm.plugin.emoji.d.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.storage.emotion.EmojiInfo.a;
import d.g.a.m;
import d.g.b.k;
import d.n.n;
import d.y;
import java.io.IOException;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/emoji/loader/fetcher/EmojiCoverFetcher;", "", "()V", "fetch", "Lcom/tencent/mm/emoji/loader/request/Request;", "emojiInfo", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "callback", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "success", "", "fetchInternal", "readFromCache", "Companion", "plugin-emojisdk_release"})
public final class c
{
  public static final a fLF;
  
  static
  {
    AppMethodBeat.i(105427);
    fLF = new a((byte)0);
    AppMethodBeat.o(105427);
  }
  
  private static void b(EmojiInfo paramEmojiInfo, final d.g.a.b<? super Boolean, y> paramb)
  {
    AppMethodBeat.i(105426);
    if (!bt.isNullOrNil(paramEmojiInfo.field_thumbUrl))
    {
      ad.i("MicroMsg.EmojiCoverFetcher", "loadDataImp: load by url " + paramEmojiInfo.JS());
      com.tencent.mm.aw.a.d.b localb = new a().yy(paramEmojiInfo.field_thumbUrl);
      if (localb != null) {
        localObject = localb.data;
      }
      while (localObject != null)
      {
        localObject = com.tencent.mm.sdk.platformtools.f.cl(localb.data);
        com.tencent.mm.emoji.loader.a.b localb1 = com.tencent.mm.emoji.loader.a.b.fLw;
        com.tencent.mm.emoji.loader.a.b.c(paramEmojiInfo.JS(), (Bitmap)localObject);
        com.tencent.mm.vfs.i.B(paramEmojiInfo.gab(), localb.data);
        if (paramb != null)
        {
          paramb.aA(Boolean.TRUE);
          AppMethodBeat.o(105426);
          return;
          localObject = null;
        }
        else
        {
          AppMethodBeat.o(105426);
          return;
        }
      }
      if (paramb != null)
      {
        paramb.aA(Boolean.FALSE);
        AppMethodBeat.o(105426);
        return;
      }
      AppMethodBeat.o(105426);
      return;
    }
    ad.i("MicroMsg.EmojiCoverFetcher", "loadDataImp: load by gif " + paramEmojiInfo.JS());
    Object localObject = com.tencent.mm.emoji.loader.e.fLn;
    com.tencent.mm.emoji.loader.e.a(paramEmojiInfo, false, (i.a)new c(paramEmojiInfo, paramb));
    AppMethodBeat.o(105426);
  }
  
  public static final boolean f(EmojiInfo paramEmojiInfo)
  {
    AppMethodBeat.i(105429);
    boolean bool = a.f(paramEmojiInfo);
    AppMethodBeat.o(105429);
    return bool;
  }
  
  public final com.tencent.mm.emoji.loader.d.i<?> a(final EmojiInfo paramEmojiInfo, final d.g.a.b<? super Boolean, y> paramb)
  {
    AppMethodBeat.i(105425);
    k.h(paramEmojiInfo, "emojiInfo");
    Object localObject1 = com.tencent.mm.emoji.loader.a.b.fLw;
    localObject1 = com.tencent.mm.emoji.loader.a.b.pT(paramEmojiInfo.JS());
    int i;
    if (localObject1 != null)
    {
      i = 1;
      if (i == 0) {
        break label321;
      }
      ad.d("MicroMsg.EmojiCoverFetcher", "fetch: from cache " + paramEmojiInfo.JS());
      paramb.aA(Boolean.TRUE);
    }
    for (;;)
    {
      AppMethodBeat.o(105425);
      return null;
      Object localObject2;
      if ((k.g(paramEmojiInfo.asy(), String.valueOf(EmojiGroupInfo.LBN))) || (paramEmojiInfo.getGroup() == EmojiGroupInfo.LBO) || (paramEmojiInfo.getGroup() == EmojiInfo.LBV) || (paramEmojiInfo.getGroup() == EmojiInfo.LBU))
      {
        localObject2 = paramEmojiInfo.getName();
        if (!bt.isNullOrNil((String)localObject2))
        {
          k.g(localObject2, "name");
          localObject1 = n.h((String)localObject2, ".png", "", false);
          localObject2 = aj.getContext();
          k.g(localObject2, "MMApplicationContext.getContext()");
          localObject2 = ((Context)localObject2).getResources();
          localObject1 = MMBitmapFactory.decodeResource((Resources)localObject2, ((Resources)localObject2).getIdentifier((String)localObject1, "drawable", aj.getPackageName()));
        }
      }
      for (;;)
      {
        label194:
        if (localObject1 != null)
        {
          localObject2 = com.tencent.mm.emoji.loader.a.b.fLw;
          com.tencent.mm.emoji.loader.a.b.c(paramEmojiInfo.JS(), (Bitmap)localObject1);
          i = 1;
          break;
          if (com.tencent.mm.vfs.i.eK(paramEmojiInfo.gab()))
          {
            localObject1 = new BitmapFactory.Options();
            ((BitmapFactory.Options)localObject1).outWidth = 120;
            ((BitmapFactory.Options)localObject1).outHeight = 120;
            localObject2 = com.tencent.mm.sdk.platformtools.f.decodeFile(paramEmojiInfo.gab(), (BitmapFactory.Options)localObject1);
            if (localObject2 != null) {
              break label272;
            }
          }
        }
      }
      for (;;)
      {
        i = 0;
        break;
        label272:
        if (((Bitmap)localObject2).getWidth() <= 120)
        {
          localObject1 = localObject2;
          if (((Bitmap)localObject2).getHeight() <= 120) {
            break label194;
          }
        }
        localObject2 = com.tencent.mm.sdk.platformtools.f.a((Bitmap)localObject2, 120, 120, false, true);
        localObject1 = localObject2;
        if (localObject2 != null) {
          break label194;
        }
      }
      label321:
      if ((aj.cbe()) && (paramEmojiInfo.fZV() == EmojiInfo.a.FBv)) {
        new f(paramEmojiInfo, (m)new b(this, paramb, paramEmojiInfo));
      } else {
        b(paramEmojiInfo, paramb);
      }
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/emoji/loader/fetcher/EmojiCoverFetcher$Companion;", "", "()V", "ThumbSize", "", "createThumb", "", "emojiInfo", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "plugin-emojisdk_release"})
  public static final class a
  {
    public static boolean f(EmojiInfo paramEmojiInfo)
    {
      AppMethodBeat.i(105422);
      k.h(paramEmojiInfo, "emojiInfo");
      ad.i("MicroMsg.EmojiCoverFetcher", "createThumb: " + paramEmojiInfo.JS());
      Object localObject2 = MMGIFJNIFactory.Companion.getDecoder(paramEmojiInfo);
      if (!MMGIFJNIFactory.Companion.isValid((com.tencent.mm.emoji.decode.c)localObject2))
      {
        ad.w("MicroMsg.EmojiCoverFetcher", "createThumb: invalid decoder");
        ((com.tencent.mm.emoji.decode.c)localObject2).destroy();
        AppMethodBeat.o(105422);
        return false;
      }
      Object localObject1;
      if (((localObject2 instanceof com.tencent.mm.emoji.decode.f)) && (((com.tencent.mm.emoji.decode.c)localObject2).aaT() == 1))
      {
        ((com.tencent.mm.emoji.decode.c)localObject2).destroy();
        localObject1 = g.ad(PluginEmoji.class);
        k.g(localObject1, "MMKernel.plugin(PluginEmoji::class.java)");
        localObject1 = ((PluginEmoji)localObject1).getProvider().a(paramEmojiInfo);
        if (localObject1 == null) {
          break label291;
        }
        localObject1 = ((com.tencent.mm.plugin.emoji.b.c)g.ab(com.tencent.mm.plugin.emoji.b.c.class)).aV((byte[])localObject1);
        if (localObject1 == null) {
          break label291;
        }
        localObject1 = com.tencent.mm.sdk.platformtools.f.cl((byte[])localObject1);
      }
      for (;;)
      {
        if (localObject1 == null)
        {
          ad.e("MicroMsg.EmojiCoverFetcher", "bitmap is null");
          AppMethodBeat.o(105422);
          return false;
          ((com.tencent.mm.emoji.decode.c)localObject2).aaR();
          localObject1 = ((com.tencent.mm.emoji.decode.c)localObject2).aaS();
          ((com.tencent.mm.emoji.decode.c)localObject2).destroy();
        }
        else
        {
          try
          {
            com.tencent.mm.sdk.platformtools.f.a((Bitmap)localObject1, 100, Bitmap.CompressFormat.PNG, paramEmojiInfo.gab(), false);
            if (((Bitmap)localObject1).getWidth() <= 120)
            {
              localObject2 = localObject1;
              if (((Bitmap)localObject1).getHeight() <= 120) {}
            }
            else
            {
              localObject1 = com.tencent.mm.sdk.platformtools.f.a((Bitmap)localObject1, 120, 120, false, true);
              localObject2 = localObject1;
              if (localObject1 == null)
              {
                AppMethodBeat.o(105422);
                return false;
              }
            }
            localObject1 = com.tencent.mm.emoji.loader.a.b.fLw;
            com.tencent.mm.emoji.loader.a.b.c(paramEmojiInfo.JS(), (Bitmap)localObject2);
            AppMethodBeat.o(105422);
            return true;
          }
          catch (IOException paramEmojiInfo)
          {
            ad.printErrStackTrace("MicroMsg.EmojiCoverFetcher", (Throwable)paramEmojiInfo, "saveBitmapToImage failed", new Object[0]);
            AppMethodBeat.o(105422);
            return false;
          }
          label291:
          localObject1 = null;
        }
      }
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "success", "", "config", "Lcom/tencent/mm/emoji/loader/fetcher/EmojiFetcherConfig;", "invoke"})
  static final class b
    extends d.g.b.l
    implements m<Boolean, e, y>
  {
    b(c paramc, d.g.a.b paramb, EmojiInfo paramEmojiInfo)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/emoji/loader/fetcher/EmojiCoverFetcher$fetchInternal$1", "Lcom/tencent/mm/emoji/loader/request/Request$Callback;", "onResult", "", "success", "", "plugin-emojisdk_release"})
  public static final class c
    implements i.a
  {
    c(EmojiInfo paramEmojiInfo, d.g.a.b paramb) {}
    
    public final void df(boolean paramBoolean)
    {
      AppMethodBeat.i(105424);
      ad.i("MicroMsg.EmojiCoverFetcher", "onResult: " + this.fLI.JS() + ", " + paramBoolean);
      if (paramBoolean)
      {
        localObject = c.fLF;
        if (c.a.f(this.fLI))
        {
          localObject = paramb;
          if (localObject != null)
          {
            ((d.g.a.b)localObject).aA(Boolean.TRUE);
            AppMethodBeat.o(105424);
            return;
          }
          AppMethodBeat.o(105424);
          return;
        }
        localObject = paramb;
        if (localObject != null)
        {
          ((d.g.a.b)localObject).aA(Boolean.FALSE);
          AppMethodBeat.o(105424);
          return;
        }
        AppMethodBeat.o(105424);
        return;
      }
      Object localObject = paramb;
      if (localObject != null)
      {
        ((d.g.a.b)localObject).aA(Boolean.FALSE);
        AppMethodBeat.o(105424);
        return;
      }
      AppMethodBeat.o(105424);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.emoji.loader.c.c
 * JD-Core Version:    0.7.0.1
 */