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
import com.tencent.mm.pluginsdk.ui.emoji.ChattingEmojiView;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.emotion.EmojiInfo;
import d.g.b.k;
import d.l;
import java.util.HashMap;
import java.util.Map;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/emoji/loader/EmojiLoader;", "", "()V", "MockDownloadFail", "", "getMockDownloadFail", "()Z", "setMockDownloadFail", "(Z)V", "TAG", "", "callback", "com/tencent/mm/emoji/loader/EmojiLoader$callback$1", "Lcom/tencent/mm/emoji/loader/EmojiLoader$callback$1;", "taskMap", "Ljava/util/HashMap;", "Lcom/tencent/mm/emoji/loader/task/IEmojiLoadTask;", "Lkotlin/collections/HashMap;", "taskQueue", "Lcom/tencent/mm/loader/loader/LoaderCore;", "addTask", "", "key", "task", "async", "buildCoverTask", "emojiInfo", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "buildTask", "cancel", "view", "Landroid/view/View;", "load", "Lcom/tencent/mm/emoji/loader/request/EmojiViewRequest;", "emojiView", "Lcom/tencent/mm/emoji/view/BaseEmojiView;", "Lcom/tencent/mm/emoji/loader/request/Request$Callback;", "Lcom/tencent/mm/emoji/loader/request/ChatEmojiViewRequest;", "Lcom/tencent/mm/pluginsdk/ui/emoji/ChattingEmojiView;", "cacheKey", "loadCover", "Lcom/tencent/mm/emoji/loader/request/EmojiCoverRequest;", "Landroid/widget/ImageView;", "Lcom/tencent/mm/emoji/loader/request/EmojiCoverBitmapRequest;", "Lcom/tencent/mm/emoji/loader/request/Request$StateCallback;", "Landroid/graphics/Bitmap;", "loadFile", "Lcom/tencent/mm/emoji/loader/request/EmojiFileRequest;", "loadForRemote", "Lcom/tencent/mm/emoji/loader/request/ProcessRequest;", "notifyTaskResult", "md5", "success", "removeTask", "EmojiLoaderRetryStrategy", "plugin-emojisdk_release"})
public final class e
{
  private static final String TAG = "MicroMsg.EmojiLoader";
  private static final HashMap<String, com.tencent.mm.emoji.loader.e.c> fLj;
  private static final com.tencent.mm.loader.g.d<com.tencent.mm.emoji.loader.e.c> fLk;
  private static final b fLl;
  private static boolean fLm;
  public static final e fLn;
  
  static
  {
    AppMethodBeat.i(105402);
    fLn = new e();
    TAG = "MicroMsg.EmojiLoader";
    fLj = new HashMap();
    fLk = new com.tencent.mm.loader.g.d((com.tencent.mm.loader.g.a.d)new com.tencent.mm.loader.g.a.f((com.tencent.mm.loader.g.a.c)new a(), new com.tencent.mm.loader.g.a.g(2, (byte)0), 2, "EmojiLoader"));
    fLl = new b();
    fLk.a((com.tencent.mm.loader.g.f)fLl);
    AppMethodBeat.o(105402);
  }
  
  public static com.tencent.mm.emoji.loader.d.a a(EmojiInfo paramEmojiInfo, ChattingEmojiView paramChattingEmojiView, String paramString)
  {
    AppMethodBeat.i(105392);
    k.h(paramEmojiInfo, "emojiInfo");
    k.h(paramChattingEmojiView, "emojiView");
    k.h(paramString, "cacheKey");
    ad.d(TAG, "load emoji " + paramEmojiInfo.JS());
    paramEmojiInfo = new com.tencent.mm.emoji.loader.d.a(paramEmojiInfo, paramChattingEmojiView, paramString);
    i.a(paramEmojiInfo);
    AppMethodBeat.o(105392);
    return paramEmojiInfo;
  }
  
  public static com.tencent.mm.emoji.loader.d.b a(EmojiInfo paramEmojiInfo, i.c<Bitmap> paramc)
  {
    AppMethodBeat.i(105396);
    k.h(paramEmojiInfo, "emojiInfo");
    paramEmojiInfo = new com.tencent.mm.emoji.loader.d.b(paramEmojiInfo, paramc);
    i.a(paramEmojiInfo);
    AppMethodBeat.o(105396);
    return paramEmojiInfo;
  }
  
  public static com.tencent.mm.emoji.loader.d.c a(EmojiInfo paramEmojiInfo, ImageView paramImageView)
  {
    AppMethodBeat.i(105395);
    k.h(paramEmojiInfo, "emojiInfo");
    k.h(paramImageView, "view");
    paramEmojiInfo = new com.tencent.mm.emoji.loader.d.c(paramEmojiInfo, paramImageView);
    i.a(paramEmojiInfo);
    AppMethodBeat.o(105395);
    return paramEmojiInfo;
  }
  
  public static com.tencent.mm.emoji.loader.d.e a(EmojiInfo paramEmojiInfo, i.a parama)
  {
    AppMethodBeat.i(105393);
    k.h(paramEmojiInfo, "emojiInfo");
    paramEmojiInfo = a(paramEmojiInfo, true, parama);
    AppMethodBeat.o(105393);
    return paramEmojiInfo;
  }
  
  public static com.tencent.mm.emoji.loader.d.e a(EmojiInfo paramEmojiInfo, boolean paramBoolean, i.a parama)
  {
    AppMethodBeat.i(105394);
    k.h(paramEmojiInfo, "emojiInfo");
    ad.i(TAG, "load emoji file " + paramEmojiInfo.JS());
    paramEmojiInfo = new com.tencent.mm.emoji.loader.d.e(paramEmojiInfo, parama);
    paramEmojiInfo.start(paramBoolean);
    AppMethodBeat.o(105394);
    return paramEmojiInfo;
  }
  
  public static com.tencent.mm.emoji.loader.d.f a(EmojiInfo paramEmojiInfo, BaseEmojiView paramBaseEmojiView, i.a parama)
  {
    AppMethodBeat.i(105391);
    k.h(paramEmojiInfo, "emojiInfo");
    k.h(paramBaseEmojiView, "emojiView");
    ad.d(TAG, "load emoji " + paramEmojiInfo.JS());
    paramEmojiInfo = new com.tencent.mm.emoji.loader.d.f(paramEmojiInfo, paramBaseEmojiView, parama);
    i.a(paramEmojiInfo);
    AppMethodBeat.o(105391);
    return paramEmojiInfo;
  }
  
  public static void a(String paramString, com.tencent.mm.emoji.loader.e.c paramc, boolean paramBoolean)
  {
    AppMethodBeat.i(105400);
    k.h(paramString, "key");
    k.h(paramc, "task");
    ad.i(TAG, "addTask: " + paramString + ' ' + paramBoolean);
    ((Map)fLj).put(paramString, paramc);
    if (paramBoolean)
    {
      fLk.b((com.tencent.mm.loader.g.c)paramc);
      AppMethodBeat.o(105400);
      return;
    }
    paramc.run();
    AppMethodBeat.o(105400);
  }
  
  public static boolean aaY()
  {
    return fLm;
  }
  
  public static com.tencent.mm.emoji.loader.e.c c(EmojiInfo paramEmojiInfo)
  {
    AppMethodBeat.i(105389);
    k.h(paramEmojiInfo, "emojiInfo");
    com.tencent.mm.emoji.loader.e.c localc = (com.tencent.mm.emoji.loader.e.c)fLj.get(paramEmojiInfo.JS());
    Object localObject = localc;
    if (localc == null)
    {
      localObject = com.tencent.mm.kernel.g.afy().aeZ();
      k.g(localObject, "MMKernel.process().current()");
      if (!((com.tencent.mm.kernel.b.h)localObject).agu()) {
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
  
  public static void cv(View paramView)
  {
    AppMethodBeat.i(105399);
    k.h(paramView, "view");
    ad.i(TAG, "cancel: ".concat(String.valueOf(paramView)));
    j.a locala = j.fMo;
    paramView = (i)paramView.getTag(j.abg());
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
    k.h(paramEmojiInfo, "emojiInfo");
    Object localObject = paramEmojiInfo.JS() + "_cover";
    com.tencent.mm.emoji.loader.e.c localc = (com.tencent.mm.emoji.loader.e.c)fLj.get(localObject);
    localObject = localc;
    if (localc == null) {
      localObject = (com.tencent.mm.emoji.loader.e.c)new com.tencent.mm.emoji.loader.e.a(paramEmojiInfo);
    }
    AppMethodBeat.o(105390);
    return localObject;
  }
  
  public static void dd(boolean paramBoolean)
  {
    fLm = paramBoolean;
  }
  
  public static com.tencent.mm.emoji.loader.d.h e(EmojiInfo paramEmojiInfo)
  {
    AppMethodBeat.i(105397);
    k.h(paramEmojiInfo, "emojiInfo");
    paramEmojiInfo = new com.tencent.mm.emoji.loader.d.h(paramEmojiInfo);
    i.a(paramEmojiInfo);
    AppMethodBeat.o(105397);
    return paramEmojiInfo;
  }
  
  public static void pR(String paramString)
  {
    AppMethodBeat.i(105401);
    k.h(paramString, "key");
    ad.i(TAG, "removeTask: ".concat(String.valueOf(paramString)));
    paramString = (com.tencent.mm.emoji.loader.e.c)fLj.remove(paramString);
    if (paramString != null)
    {
      com.tencent.mm.loader.g.d locald = fLk;
      k.g(paramString, "it");
      locald.c((com.tencent.mm.loader.g.c)paramString);
      AppMethodBeat.o(105401);
      return;
    }
    AppMethodBeat.o(105401);
  }
  
  public static void s(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(105398);
    k.h(paramString, "md5");
    paramString = (com.tencent.mm.emoji.loader.e.c)fLj.get(paramString);
    if (paramString != null)
    {
      paramString.df(paramBoolean);
      AppMethodBeat.o(105398);
      return;
    }
    AppMethodBeat.o(105398);
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/emoji/loader/EmojiLoader$EmojiLoaderRetryStrategy;", "Lcom/tencent/mm/loader/loader/cfg/ILoaderRetryStrategy;", "()V", "canRetry", "", "task", "Lcom/tencent/mm/loader/loader/IWorkTask;", "plugin-emojisdk_release"})
  public static final class a
    implements com.tencent.mm.loader.g.a.c
  {
    public final boolean a(com.tencent.mm.loader.g.c paramc)
    {
      AppMethodBeat.i(105387);
      k.h(paramc, "task");
      AppMethodBeat.o(105387);
      return true;
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/emoji/loader/EmojiLoader$callback$1", "Lcom/tencent/mm/loader/loader/LoaderCoreCallback;", "Lcom/tencent/mm/emoji/loader/task/IEmojiLoadTask;", "onLoaderFin", "", "task", "status", "Lcom/tencent/mm/loader/loader/WorkStatus;", "plugin-emojisdk_release"})
  public static final class b
    implements com.tencent.mm.loader.g.f<com.tencent.mm.emoji.loader.e.c>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.emoji.loader.e
 * JD-Core Version:    0.7.0.1
 */