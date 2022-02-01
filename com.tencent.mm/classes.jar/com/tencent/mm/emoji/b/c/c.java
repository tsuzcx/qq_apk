package com.tencent.mm.emoji.b.c;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.b.d.h.a;
import com.tencent.mm.emoji.decode.MMGIFJNIFactory;
import com.tencent.mm.emoji.decode.MMGIFJNIFactory.Companion;
import com.tencent.mm.emoji.decode.d;
import com.tencent.mm.emoji.decode.g;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.emoji.PluginEmoji;
import com.tencent.mm.plugin.emoji.d.a;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.vfs.y;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/emoji/loader/fetcher/EmojiCoverFetcher;", "", "()V", "fetch", "Lcom/tencent/mm/emoji/loader/request/Request;", "emojiInfo", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "callback", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "success", "", "fetchInternal", "readFromCache", "Companion", "plugin-emojisdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
{
  public static final a mgB;
  
  static
  {
    AppMethodBeat.i(105427);
    mgB = new a((byte)0);
    AppMethodBeat.o(105427);
  }
  
  public static void a(EmojiInfo paramEmojiInfo, final kotlin.g.a.b<? super Boolean, ah> paramb)
  {
    AppMethodBeat.i(105426);
    Object localObject;
    if (!Util.isNullOrNil(paramEmojiInfo.field_thumbUrl))
    {
      Log.i("MicroMsg.EmojiCoverFetcher", s.X("loadDataImp: load by url ", paramEmojiInfo.getMd5()));
      com.tencent.mm.modelimage.loader.c.b localb = new a().Os(paramEmojiInfo.field_thumbUrl);
      if (localb == null) {}
      for (localObject = null; localObject != null; localObject = localb.data)
      {
        localObject = BitmapUtil.decodeByteArray(localb.data);
        com.tencent.mm.emoji.b.a.b localb1 = com.tencent.mm.emoji.b.a.b.mgs;
        com.tencent.mm.emoji.b.a.b.put(paramEmojiInfo.getMd5(), (Bitmap)localObject);
        paramEmojiInfo = paramEmojiInfo.kMo();
        localObject = localb.data;
        y.f(paramEmojiInfo, (byte[])localObject, localObject.length);
        if (paramb == null) {
          break label177;
        }
        paramb.invoke(Boolean.TRUE);
        AppMethodBeat.o(105426);
        return;
      }
      if (paramb != null)
      {
        paramb.invoke(Boolean.FALSE);
        AppMethodBeat.o(105426);
      }
    }
    else
    {
      Log.i("MicroMsg.EmojiCoverFetcher", s.X("loadDataImp: load by gif ", paramEmojiInfo.getMd5()));
      localObject = com.tencent.mm.emoji.b.e.mgl;
      com.tencent.mm.emoji.b.e.a(paramEmojiInfo, false, (h.a)new c(paramEmojiInfo, paramb));
    }
    label177:
    AppMethodBeat.o(105426);
  }
  
  public static final boolean e(EmojiInfo paramEmojiInfo)
  {
    AppMethodBeat.i(105429);
    boolean bool = a.e(paramEmojiInfo);
    AppMethodBeat.o(105429);
    return bool;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/emoji/loader/fetcher/EmojiCoverFetcher$Companion;", "", "()V", "ThumbSize", "", "createThumb", "", "emojiInfo", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "plugin-emojisdk_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    public static boolean e(EmojiInfo paramEmojiInfo)
    {
      AppMethodBeat.i(105422);
      s.u(paramEmojiInfo, "emojiInfo");
      Log.i("MicroMsg.EmojiCoverFetcher", s.X("createThumb: ", paramEmojiInfo.getMd5()));
      Object localObject2 = MMGIFJNIFactory.Companion.getDecoder(paramEmojiInfo);
      if (!MMGIFJNIFactory.Companion.isValid((d)localObject2))
      {
        Log.w("MicroMsg.EmojiCoverFetcher", "createThumb: invalid decoder");
        ((d)localObject2).destroy();
        AppMethodBeat.o(105422);
        return false;
      }
      Object localObject1;
      if (((localObject2 instanceof g)) && (((d)localObject2).aUf() == 1))
      {
        ((d)localObject2).destroy();
        localObject1 = ((PluginEmoji)h.az(PluginEmoji.class)).getProvider().a(paramEmojiInfo);
        if (localObject1 == null) {
          break label273;
        }
        localObject1 = ((com.tencent.mm.plugin.emoji.c.c)h.ax(com.tencent.mm.plugin.emoji.c.c.class)).bA((byte[])localObject1);
        if (localObject1 == null) {
          break label273;
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
          ((d)localObject2).aUe();
          localObject1 = ((d)localObject2).getFrame();
          ((d)localObject2).destroy();
        }
        else
        {
          try
          {
            BitmapUtil.saveBitmapToImage((Bitmap)localObject1, 100, Bitmap.CompressFormat.PNG, paramEmojiInfo.kMo(), false);
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
            localObject1 = com.tencent.mm.emoji.b.a.b.mgs;
            com.tencent.mm.emoji.b.a.b.put(paramEmojiInfo.getMd5(), (Bitmap)localObject2);
            AppMethodBeat.o(105422);
            return true;
          }
          catch (IOException paramEmojiInfo)
          {
            Log.printErrStackTrace("MicroMsg.EmojiCoverFetcher", (Throwable)paramEmojiInfo, "saveBitmapToImage failed", new Object[0]);
            AppMethodBeat.o(105422);
            return false;
          }
          label273:
          localObject1 = null;
        }
      }
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/emoji/loader/fetcher/EmojiCoverFetcher$fetchInternal$1", "Lcom/tencent/mm/emoji/loader/request/Request$Callback;", "onResult", "", "success", "", "plugin-emojisdk_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
    implements h.a
  {
    c(EmojiInfo paramEmojiInfo, kotlin.g.a.b<? super Boolean, ah> paramb) {}
    
    public final void onResult(boolean paramBoolean)
    {
      AppMethodBeat.i(105424);
      Log.i("MicroMsg.EmojiCoverFetcher", "onResult: " + this.mgD.getMd5() + ", " + paramBoolean);
      Object localObject;
      if (paramBoolean)
      {
        localObject = c.mgB;
        if (c.a.e(this.mgD))
        {
          localObject = paramb;
          if (localObject != null)
          {
            ((kotlin.g.a.b)localObject).invoke(Boolean.TRUE);
            AppMethodBeat.o(105424);
          }
        }
        else
        {
          localObject = paramb;
          if (localObject != null)
          {
            ((kotlin.g.a.b)localObject).invoke(Boolean.FALSE);
            AppMethodBeat.o(105424);
          }
        }
      }
      else
      {
        localObject = paramb;
        if (localObject != null) {
          ((kotlin.g.a.b)localObject).invoke(Boolean.FALSE);
        }
      }
      AppMethodBeat.o(105424);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.emoji.b.c.c
 * JD-Core Version:    0.7.0.1
 */