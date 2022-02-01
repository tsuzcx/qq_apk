package com.tencent.mm.emoji.loader.c;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory.Options;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.decode.MMGIFJNIFactory;
import com.tencent.mm.emoji.decode.MMGIFJNIFactory.Companion;
import com.tencent.mm.emoji.decode.d;
import com.tencent.mm.emoji.loader.d.i;
import com.tencent.mm.emoji.loader.d.i.a;
import com.tencent.mm.graphics.MMBitmapFactory;
import com.tencent.mm.plugin.emoji.PluginEmoji;
import com.tencent.mm.plugin.emoji.d.a;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.storage.emotion.EmojiInfo.a;
import com.tencent.mm.vfs.s;
import java.io.IOException;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.n.n;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/emoji/loader/fetcher/EmojiCoverFetcher;", "", "()V", "fetch", "Lcom/tencent/mm/emoji/loader/request/Request;", "emojiInfo", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "callback", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "success", "", "fetchInternal", "readFromCache", "Companion", "plugin-emojisdk_release"})
public final class c
{
  public static final a gWc;
  
  static
  {
    AppMethodBeat.i(105427);
    gWc = new a((byte)0);
    AppMethodBeat.o(105427);
  }
  
  private static void b(EmojiInfo paramEmojiInfo, final kotlin.g.a.b<? super Boolean, x> paramb)
  {
    AppMethodBeat.i(105426);
    if (!Util.isNullOrNil(paramEmojiInfo.field_thumbUrl))
    {
      Log.i("MicroMsg.EmojiCoverFetcher", "loadDataImp: load by url " + paramEmojiInfo.getMd5());
      com.tencent.mm.av.a.d.b localb = new a().OV(paramEmojiInfo.field_thumbUrl);
      if (localb != null) {
        localObject = localb.data;
      }
      while (localObject != null)
      {
        localObject = BitmapUtil.decodeByteArray(localb.data);
        com.tencent.mm.emoji.loader.a.b localb1 = com.tencent.mm.emoji.loader.a.b.gVU;
        com.tencent.mm.emoji.loader.a.b.put(paramEmojiInfo.getMd5(), (Bitmap)localObject);
        s.C(paramEmojiInfo.hRN(), localb.data);
        if (paramb != null)
        {
          paramb.invoke(Boolean.TRUE);
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
        paramb.invoke(Boolean.FALSE);
        AppMethodBeat.o(105426);
        return;
      }
      AppMethodBeat.o(105426);
      return;
    }
    Log.i("MicroMsg.EmojiCoverFetcher", "loadDataImp: load by gif " + paramEmojiInfo.getMd5());
    Object localObject = com.tencent.mm.emoji.loader.e.gVM;
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
  
  public final i<?> a(final EmojiInfo paramEmojiInfo, final kotlin.g.a.b<? super Boolean, x> paramb)
  {
    AppMethodBeat.i(105425);
    p.h(paramEmojiInfo, "emojiInfo");
    Object localObject1 = com.tencent.mm.emoji.loader.a.b.gVU;
    localObject1 = com.tencent.mm.emoji.loader.a.b.EP(paramEmojiInfo.getMd5());
    int i;
    if (localObject1 != null)
    {
      i = 1;
      if (i == 0) {
        break label322;
      }
      Log.d("MicroMsg.EmojiCoverFetcher", "fetch: from cache " + paramEmojiInfo.getMd5());
      paramb.invoke(Boolean.TRUE);
    }
    for (;;)
    {
      AppMethodBeat.o(105425);
      return null;
      Object localObject2;
      if ((p.j(paramEmojiInfo.avy(), String.valueOf(EmojiGroupInfo.Uum))) || (paramEmojiInfo.getGroup() == EmojiGroupInfo.Uun) || (paramEmojiInfo.getGroup() == EmojiInfo.Uuu) || (paramEmojiInfo.getGroup() == EmojiInfo.Uut))
      {
        localObject2 = paramEmojiInfo.getName();
        if (!Util.isNullOrNil((String)localObject2))
        {
          p.g(localObject2, "name");
          localObject1 = n.j((String)localObject2, ".png", "", false);
          localObject2 = MMApplicationContext.getContext();
          p.g(localObject2, "MMApplicationContext.getContext()");
          localObject2 = ((Context)localObject2).getResources();
          localObject1 = MMBitmapFactory.decodeResource((Resources)localObject2, ((Resources)localObject2).getIdentifier((String)localObject1, "drawable", MMApplicationContext.getPackageName()));
        }
      }
      for (;;)
      {
        label195:
        if (localObject1 != null)
        {
          localObject2 = com.tencent.mm.emoji.loader.a.b.gVU;
          com.tencent.mm.emoji.loader.a.b.put(paramEmojiInfo.getMd5(), (Bitmap)localObject1);
          i = 1;
          break;
          if (s.YS(paramEmojiInfo.hRN()))
          {
            localObject1 = new BitmapFactory.Options();
            ((BitmapFactory.Options)localObject1).outWidth = 120;
            ((BitmapFactory.Options)localObject1).outHeight = 120;
            localObject2 = BitmapUtil.decodeFile(paramEmojiInfo.hRN(), (BitmapFactory.Options)localObject1);
            if (localObject2 != null) {
              break label273;
            }
          }
        }
      }
      for (;;)
      {
        i = 0;
        break;
        label273:
        if (((Bitmap)localObject2).getWidth() <= 120)
        {
          localObject1 = localObject2;
          if (((Bitmap)localObject2).getHeight() <= 120) {
            break label195;
          }
        }
        localObject2 = BitmapUtil.extractThumbNail((Bitmap)localObject2, 120, 120, false, true);
        localObject1 = localObject2;
        if (localObject2 != null) {
          break label195;
        }
      }
      label322:
      if ((MMApplicationContext.isMainProcess()) && (paramEmojiInfo.hRH() == EmojiInfo.a.Osj)) {
        new f(paramEmojiInfo, (m)new b(this, paramb, paramEmojiInfo));
      } else {
        b(paramEmojiInfo, paramb);
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/emoji/loader/fetcher/EmojiCoverFetcher$Companion;", "", "()V", "ThumbSize", "", "createThumb", "", "emojiInfo", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "plugin-emojisdk_release"})
  public static final class a
  {
    public static boolean f(EmojiInfo paramEmojiInfo)
    {
      AppMethodBeat.i(105422);
      p.h(paramEmojiInfo, "emojiInfo");
      Log.i("MicroMsg.EmojiCoverFetcher", "createThumb: " + paramEmojiInfo.getMd5());
      Object localObject2 = MMGIFJNIFactory.Companion.getDecoder(paramEmojiInfo);
      if (!MMGIFJNIFactory.Companion.isValid((d)localObject2))
      {
        Log.w("MicroMsg.EmojiCoverFetcher", "createThumb: invalid decoder");
        ((d)localObject2).destroy();
        AppMethodBeat.o(105422);
        return false;
      }
      Object localObject1;
      if (((localObject2 instanceof com.tencent.mm.emoji.decode.g)) && (((d)localObject2).aup() == 1))
      {
        ((d)localObject2).destroy();
        localObject1 = com.tencent.mm.kernel.g.ah(PluginEmoji.class);
        p.g(localObject1, "MMKernel.plugin(PluginEmoji::class.java)");
        localObject1 = ((PluginEmoji)localObject1).getProvider().a(paramEmojiInfo);
        if (localObject1 == null) {
          break label291;
        }
        localObject1 = ((com.tencent.mm.plugin.emoji.b.c)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.emoji.b.c.class)).bn((byte[])localObject1);
        if (localObject1 == null) {
          break label291;
        }
        localObject1 = BitmapUtil.decodeByteArray((byte[])localObject1);
      }
      for (;;)
      {
        if (localObject1 == null)
        {
          Log.e("MicroMsg.EmojiCoverFetcher", "bitmap is null");
          AppMethodBeat.o(105422);
          return false;
          ((d)localObject2).auo();
          localObject1 = ((d)localObject2).getFrame();
          ((d)localObject2).destroy();
        }
        else
        {
          try
          {
            BitmapUtil.saveBitmapToImage((Bitmap)localObject1, 100, Bitmap.CompressFormat.PNG, paramEmojiInfo.hRN(), false);
            if (((Bitmap)localObject1).getWidth() <= 120)
            {
              localObject2 = localObject1;
              if (((Bitmap)localObject1).getHeight() <= 120) {}
            }
            else
            {
              localObject1 = BitmapUtil.extractThumbNail((Bitmap)localObject1, 120, 120, false, true);
              localObject2 = localObject1;
              if (localObject1 == null)
              {
                AppMethodBeat.o(105422);
                return false;
              }
            }
            localObject1 = com.tencent.mm.emoji.loader.a.b.gVU;
            com.tencent.mm.emoji.loader.a.b.put(paramEmojiInfo.getMd5(), (Bitmap)localObject2);
            AppMethodBeat.o(105422);
            return true;
          }
          catch (IOException paramEmojiInfo)
          {
            Log.printErrStackTrace("MicroMsg.EmojiCoverFetcher", (Throwable)paramEmojiInfo, "saveBitmapToImage failed", new Object[0]);
            AppMethodBeat.o(105422);
            return false;
          }
          label291:
          localObject1 = null;
        }
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "success", "", "config", "Lcom/tencent/mm/emoji/loader/fetcher/EmojiFetcherConfig;", "invoke"})
  static final class b
    extends q
    implements m<Boolean, e, x>
  {
    b(c paramc, kotlin.g.a.b paramb, EmojiInfo paramEmojiInfo)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/emoji/loader/fetcher/EmojiCoverFetcher$fetchInternal$1", "Lcom/tencent/mm/emoji/loader/request/Request$Callback;", "onResult", "", "success", "", "plugin-emojisdk_release"})
  public static final class c
    implements i.a
  {
    c(EmojiInfo paramEmojiInfo, kotlin.g.a.b paramb) {}
    
    public final void dQ(boolean paramBoolean)
    {
      AppMethodBeat.i(105424);
      Log.i("MicroMsg.EmojiCoverFetcher", "onResult: " + this.gWf.getMd5() + ", " + paramBoolean);
      if (paramBoolean)
      {
        localObject = c.gWc;
        if (c.a.f(this.gWf))
        {
          localObject = paramb;
          if (localObject != null)
          {
            ((kotlin.g.a.b)localObject).invoke(Boolean.TRUE);
            AppMethodBeat.o(105424);
            return;
          }
          AppMethodBeat.o(105424);
          return;
        }
        localObject = paramb;
        if (localObject != null)
        {
          ((kotlin.g.a.b)localObject).invoke(Boolean.FALSE);
          AppMethodBeat.o(105424);
          return;
        }
        AppMethodBeat.o(105424);
        return;
      }
      Object localObject = paramb;
      if (localObject != null)
      {
        ((kotlin.g.a.b)localObject).invoke(Boolean.FALSE);
        AppMethodBeat.o(105424);
        return;
      }
      AppMethodBeat.o(105424);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.emoji.loader.c.c
 * JD-Core Version:    0.7.0.1
 */