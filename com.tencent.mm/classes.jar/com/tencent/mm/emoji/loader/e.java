package com.tencent.mm.emoji.loader;

import android.graphics.Bitmap;
import android.view.View;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.loader.d.i;
import com.tencent.mm.emoji.loader.d.i.a;
import com.tencent.mm.emoji.loader.d.i.c;
import com.tencent.mm.emoji.loader.d.j;
import com.tencent.mm.emoji.loader.d.j.a;
import com.tencent.mm.emoji.view.BaseEmojiView;
import com.tencent.mm.loader.g.a.g;
import com.tencent.mm.pluginsdk.ui.emoji.ChattingEmojiView;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.emotion.EmojiInfo;
import java.util.HashMap;
import java.util.Map;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/emoji/loader/EmojiLoader;", "", "()V", "MockDownloadFail", "", "getMockDownloadFail", "()Z", "setMockDownloadFail", "(Z)V", "TAG", "", "callback", "com/tencent/mm/emoji/loader/EmojiLoader$callback$1", "Lcom/tencent/mm/emoji/loader/EmojiLoader$callback$1;", "taskMap", "Ljava/util/HashMap;", "Lcom/tencent/mm/emoji/loader/task/IEmojiLoadTask;", "Lkotlin/collections/HashMap;", "taskQueue", "Lcom/tencent/mm/loader/loader/LoaderCore;", "addTask", "", "key", "task", "async", "buildCoverTask", "emojiInfo", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "buildTask", "cancel", "view", "Landroid/view/View;", "load", "Lcom/tencent/mm/emoji/loader/request/EmojiViewRequest;", "emojiView", "Lcom/tencent/mm/emoji/view/BaseEmojiView;", "Lcom/tencent/mm/emoji/loader/request/Request$Callback;", "Lcom/tencent/mm/emoji/loader/request/ChatEmojiViewRequest;", "Lcom/tencent/mm/pluginsdk/ui/emoji/ChattingEmojiView;", "cacheKey", "loadCover", "Lcom/tencent/mm/emoji/loader/request/EmojiCoverRequest;", "Landroid/widget/ImageView;", "Lcom/tencent/mm/emoji/loader/request/EmojiCoverBitmapRequest;", "Lcom/tencent/mm/emoji/loader/request/Request$StateCallback;", "Landroid/graphics/Bitmap;", "loadFile", "Lcom/tencent/mm/emoji/loader/request/EmojiFileRequest;", "loadForRemote", "Lcom/tencent/mm/emoji/loader/request/ProcessRequest;", "notifyTaskResult", "md5", "success", "removeTask", "EmojiLoaderRetryStrategy", "plugin-emojisdk_release"})
public final class e
{
  private static final String TAG = "MicroMsg.EmojiLoader";
  private static final HashMap<String, com.tencent.mm.emoji.loader.e.c> jGE;
  private static final com.tencent.mm.loader.g.d<com.tencent.mm.emoji.loader.e.c> jGF;
  private static final b jGG;
  private static boolean jGH;
  public static final e jGI;
  
  static
  {
    AppMethodBeat.i(105402);
    jGI = new e();
    TAG = "MicroMsg.EmojiLoader";
    jGE = new HashMap();
    jGF = new com.tencent.mm.loader.g.d((com.tencent.mm.loader.g.a.d)new com.tencent.mm.loader.g.a.f((com.tencent.mm.loader.g.a.c)new e.a(), new g(5, (byte)0), 2, "EmojiLoader"));
    jGG = new b();
    jGF.a((com.tencent.mm.loader.g.f)jGG);
    AppMethodBeat.o(105402);
  }
  
  public static void LG(String paramString)
  {
    AppMethodBeat.i(105401);
    p.k(paramString, "key");
    Log.i(TAG, "removeTask: ".concat(String.valueOf(paramString)));
    paramString = (com.tencent.mm.emoji.loader.e.c)jGE.remove(paramString);
    if (paramString != null)
    {
      com.tencent.mm.loader.g.d locald = jGF;
      p.j(paramString, "it");
      locald.c((com.tencent.mm.loader.g.c)paramString);
      AppMethodBeat.o(105401);
      return;
    }
    AppMethodBeat.o(105401);
  }
  
  public static com.tencent.mm.emoji.loader.d.a a(EmojiInfo paramEmojiInfo, ChattingEmojiView paramChattingEmojiView, String paramString)
  {
    AppMethodBeat.i(105392);
    p.k(paramEmojiInfo, "emojiInfo");
    p.k(paramChattingEmojiView, "emojiView");
    p.k(paramString, "cacheKey");
    Log.d(TAG, "load emoji " + paramEmojiInfo.getMd5());
    paramEmojiInfo = new com.tencent.mm.emoji.loader.d.a(paramEmojiInfo, paramChattingEmojiView, paramString);
    i.a(paramEmojiInfo);
    AppMethodBeat.o(105392);
    return paramEmojiInfo;
  }
  
  public static com.tencent.mm.emoji.loader.d.b a(EmojiInfo paramEmojiInfo, i.c<Bitmap> paramc)
  {
    AppMethodBeat.i(105396);
    p.k(paramEmojiInfo, "emojiInfo");
    paramEmojiInfo = new com.tencent.mm.emoji.loader.d.b(paramEmojiInfo, paramc);
    i.a(paramEmojiInfo);
    AppMethodBeat.o(105396);
    return paramEmojiInfo;
  }
  
  public static com.tencent.mm.emoji.loader.d.c a(EmojiInfo paramEmojiInfo, ImageView paramImageView)
  {
    AppMethodBeat.i(105395);
    p.k(paramEmojiInfo, "emojiInfo");
    p.k(paramImageView, "view");
    paramEmojiInfo = new com.tencent.mm.emoji.loader.d.c(paramEmojiInfo, paramImageView);
    i.a(paramEmojiInfo);
    AppMethodBeat.o(105395);
    return paramEmojiInfo;
  }
  
  public static com.tencent.mm.emoji.loader.d.e a(EmojiInfo paramEmojiInfo, i.a parama)
  {
    AppMethodBeat.i(105393);
    p.k(paramEmojiInfo, "emojiInfo");
    paramEmojiInfo = a(paramEmojiInfo, true, parama);
    AppMethodBeat.o(105393);
    return paramEmojiInfo;
  }
  
  public static com.tencent.mm.emoji.loader.d.e a(EmojiInfo paramEmojiInfo, boolean paramBoolean, i.a parama)
  {
    AppMethodBeat.i(105394);
    p.k(paramEmojiInfo, "emojiInfo");
    Log.i(TAG, "load emoji file " + paramEmojiInfo.getMd5());
    paramEmojiInfo = new com.tencent.mm.emoji.loader.d.e(paramEmojiInfo, parama);
    paramEmojiInfo.start(paramBoolean);
    AppMethodBeat.o(105394);
    return paramEmojiInfo;
  }
  
  public static com.tencent.mm.emoji.loader.d.f a(EmojiInfo paramEmojiInfo, BaseEmojiView paramBaseEmojiView, i.a parama)
  {
    AppMethodBeat.i(105391);
    p.k(paramEmojiInfo, "emojiInfo");
    p.k(paramBaseEmojiView, "emojiView");
    Log.d(TAG, "load emoji " + paramEmojiInfo.getMd5());
    paramEmojiInfo = new com.tencent.mm.emoji.loader.d.f(paramEmojiInfo, paramBaseEmojiView, parama);
    i.a(paramEmojiInfo);
    AppMethodBeat.o(105391);
    return paramEmojiInfo;
  }
  
  public static void a(String paramString, com.tencent.mm.emoji.loader.e.c paramc, boolean paramBoolean)
  {
    AppMethodBeat.i(105400);
    p.k(paramString, "key");
    p.k(paramc, "task");
    Log.i(TAG, "addTask: " + paramString + ' ' + paramBoolean);
    ((Map)jGE).put(paramString, paramc);
    if (paramBoolean)
    {
      jGF.b((com.tencent.mm.loader.g.c)paramc);
      AppMethodBeat.o(105400);
      return;
    }
    paramc.run();
    AppMethodBeat.o(105400);
  }
  
  public static boolean aBw()
  {
    return jGH;
  }
  
  public static com.tencent.mm.emoji.loader.e.c c(EmojiInfo paramEmojiInfo)
  {
    AppMethodBeat.i(105389);
    p.k(paramEmojiInfo, "emojiInfo");
    com.tencent.mm.emoji.loader.e.c localc = (com.tencent.mm.emoji.loader.e.c)jGE.get(paramEmojiInfo.getMd5());
    Object localObject = localc;
    if (localc == null)
    {
      localObject = com.tencent.mm.kernel.h.aHD().aHf();
      p.j(localObject, "MMKernel.process().current()");
      if (!((com.tencent.mm.kernel.b.h)localObject).aIE()) {
        break label76;
      }
    }
    label76:
    for (localObject = (com.tencent.mm.emoji.loader.e.c)new com.tencent.mm.emoji.loader.e.b(paramEmojiInfo);; localObject = (com.tencent.mm.emoji.loader.e.c)new com.tencent.mm.emoji.loader.e.e(paramEmojiInfo))
    {
      AppMethodBeat.o(105389);
      return localObject;
    }
  }
  
  public static void cD(View paramView)
  {
    AppMethodBeat.i(105399);
    p.k(paramView, "view");
    Log.i(TAG, "cancel: ".concat(String.valueOf(paramView)));
    j.a locala = j.jHG;
    paramView = (i)paramView.getTag(j.aBE());
    if (paramView != null)
    {
      paramView.cancel();
      AppMethodBeat.o(105399);
      return;
    }
    AppMethodBeat.o(105399);
  }
  
  public static com.tencent.mm.emoji.loader.e.c d(EmojiInfo paramEmojiInfo)
  {
    AppMethodBeat.i(105390);
    p.k(paramEmojiInfo, "emojiInfo");
    Object localObject = paramEmojiInfo.getMd5() + "_cover";
    com.tencent.mm.emoji.loader.e.c localc = (com.tencent.mm.emoji.loader.e.c)jGE.get(localObject);
    localObject = localc;
    if (localc == null) {
      localObject = (com.tencent.mm.emoji.loader.e.c)new com.tencent.mm.emoji.loader.e.a(paramEmojiInfo);
    }
    AppMethodBeat.o(105390);
    return localObject;
  }
  
  public static com.tencent.mm.emoji.loader.d.h e(EmojiInfo paramEmojiInfo)
  {
    AppMethodBeat.i(105397);
    p.k(paramEmojiInfo, "emojiInfo");
    paramEmojiInfo = new com.tencent.mm.emoji.loader.d.h(paramEmojiInfo);
    i.a(paramEmojiInfo);
    AppMethodBeat.o(105397);
    return paramEmojiInfo;
  }
  
  public static void en(boolean paramBoolean)
  {
    jGH = paramBoolean;
  }
  
  public static void v(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(105398);
    p.k(paramString, "md5");
    paramString = (com.tencent.mm.emoji.loader.e.c)jGE.get(paramString);
    if (paramString != null)
    {
      paramString.ep(paramBoolean);
      AppMethodBeat.o(105398);
      return;
    }
    AppMethodBeat.o(105398);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/emoji/loader/EmojiLoader$callback$1", "Lcom/tencent/mm/loader/loader/LoaderCoreCallback;", "Lcom/tencent/mm/emoji/loader/task/IEmojiLoadTask;", "onLoaderFin", "", "task", "status", "Lcom/tencent/mm/loader/loader/WorkStatus;", "plugin-emojisdk_release"})
  public static final class b
    implements com.tencent.mm.loader.g.f<com.tencent.mm.emoji.loader.e.c>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.emoji.loader.e
 * JD-Core Version:    0.7.0.1
 */