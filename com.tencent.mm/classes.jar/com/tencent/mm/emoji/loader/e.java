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
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.storage.emotion.EmojiInfo;
import d.g.b.p;
import d.l;
import java.util.HashMap;
import java.util.Map;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/emoji/loader/EmojiLoader;", "", "()V", "MockDownloadFail", "", "getMockDownloadFail", "()Z", "setMockDownloadFail", "(Z)V", "TAG", "", "callback", "com/tencent/mm/emoji/loader/EmojiLoader$callback$1", "Lcom/tencent/mm/emoji/loader/EmojiLoader$callback$1;", "taskMap", "Ljava/util/HashMap;", "Lcom/tencent/mm/emoji/loader/task/IEmojiLoadTask;", "Lkotlin/collections/HashMap;", "taskQueue", "Lcom/tencent/mm/loader/loader/LoaderCore;", "addTask", "", "key", "task", "async", "buildCoverTask", "emojiInfo", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "buildTask", "cancel", "view", "Landroid/view/View;", "load", "Lcom/tencent/mm/emoji/loader/request/EmojiViewRequest;", "emojiView", "Lcom/tencent/mm/emoji/view/BaseEmojiView;", "Lcom/tencent/mm/emoji/loader/request/Request$Callback;", "Lcom/tencent/mm/emoji/loader/request/ChatEmojiViewRequest;", "Lcom/tencent/mm/pluginsdk/ui/emoji/ChattingEmojiView;", "cacheKey", "loadCover", "Lcom/tencent/mm/emoji/loader/request/EmojiCoverRequest;", "Landroid/widget/ImageView;", "Lcom/tencent/mm/emoji/loader/request/EmojiCoverBitmapRequest;", "Lcom/tencent/mm/emoji/loader/request/Request$StateCallback;", "Landroid/graphics/Bitmap;", "loadFile", "Lcom/tencent/mm/emoji/loader/request/EmojiFileRequest;", "loadForRemote", "Lcom/tencent/mm/emoji/loader/request/ProcessRequest;", "notifyTaskResult", "md5", "success", "removeTask", "EmojiLoaderRetryStrategy", "plugin-emojisdk_release"})
public final class e
{
  private static final String TAG = "MicroMsg.EmojiLoader";
  private static final HashMap<String, com.tencent.mm.emoji.loader.e.c> gkN;
  private static final com.tencent.mm.loader.g.d<com.tencent.mm.emoji.loader.e.c> gkO;
  private static final b gkP;
  private static boolean gkQ;
  public static final e gkR;
  
  static
  {
    AppMethodBeat.i(105402);
    gkR = new e();
    TAG = "MicroMsg.EmojiLoader";
    gkN = new HashMap();
    gkO = new com.tencent.mm.loader.g.d((com.tencent.mm.loader.g.a.d)new com.tencent.mm.loader.g.a.f((com.tencent.mm.loader.g.a.c)new a(), new com.tencent.mm.loader.g.a.g(2, (byte)0), 2, "EmojiLoader"));
    gkP = new b();
    gkO.a((com.tencent.mm.loader.g.f)gkP);
    AppMethodBeat.o(105402);
  }
  
  public static com.tencent.mm.emoji.loader.d.a a(EmojiInfo paramEmojiInfo, ChattingEmojiView paramChattingEmojiView, String paramString)
  {
    AppMethodBeat.i(105392);
    p.h(paramEmojiInfo, "emojiInfo");
    p.h(paramChattingEmojiView, "emojiView");
    p.h(paramString, "cacheKey");
    ae.d(TAG, "load emoji " + paramEmojiInfo.Lj());
    paramEmojiInfo = new com.tencent.mm.emoji.loader.d.a(paramEmojiInfo, paramChattingEmojiView, paramString);
    i.a(paramEmojiInfo);
    AppMethodBeat.o(105392);
    return paramEmojiInfo;
  }
  
  public static com.tencent.mm.emoji.loader.d.b a(EmojiInfo paramEmojiInfo, i.c<Bitmap> paramc)
  {
    AppMethodBeat.i(105396);
    p.h(paramEmojiInfo, "emojiInfo");
    paramEmojiInfo = new com.tencent.mm.emoji.loader.d.b(paramEmojiInfo, paramc);
    i.a(paramEmojiInfo);
    AppMethodBeat.o(105396);
    return paramEmojiInfo;
  }
  
  public static com.tencent.mm.emoji.loader.d.c a(EmojiInfo paramEmojiInfo, ImageView paramImageView)
  {
    AppMethodBeat.i(105395);
    p.h(paramEmojiInfo, "emojiInfo");
    p.h(paramImageView, "view");
    paramEmojiInfo = new com.tencent.mm.emoji.loader.d.c(paramEmojiInfo, paramImageView);
    i.a(paramEmojiInfo);
    AppMethodBeat.o(105395);
    return paramEmojiInfo;
  }
  
  public static com.tencent.mm.emoji.loader.d.e a(EmojiInfo paramEmojiInfo, i.a parama)
  {
    AppMethodBeat.i(105393);
    p.h(paramEmojiInfo, "emojiInfo");
    paramEmojiInfo = a(paramEmojiInfo, true, parama);
    AppMethodBeat.o(105393);
    return paramEmojiInfo;
  }
  
  public static com.tencent.mm.emoji.loader.d.e a(EmojiInfo paramEmojiInfo, boolean paramBoolean, i.a parama)
  {
    AppMethodBeat.i(105394);
    p.h(paramEmojiInfo, "emojiInfo");
    ae.i(TAG, "load emoji file " + paramEmojiInfo.Lj());
    paramEmojiInfo = new com.tencent.mm.emoji.loader.d.e(paramEmojiInfo, parama);
    paramEmojiInfo.start(paramBoolean);
    AppMethodBeat.o(105394);
    return paramEmojiInfo;
  }
  
  public static com.tencent.mm.emoji.loader.d.f a(EmojiInfo paramEmojiInfo, BaseEmojiView paramBaseEmojiView, i.a parama)
  {
    AppMethodBeat.i(105391);
    p.h(paramEmojiInfo, "emojiInfo");
    p.h(paramBaseEmojiView, "emojiView");
    ae.d(TAG, "load emoji " + paramEmojiInfo.Lj());
    paramEmojiInfo = new com.tencent.mm.emoji.loader.d.f(paramEmojiInfo, paramBaseEmojiView, parama);
    i.a(paramEmojiInfo);
    AppMethodBeat.o(105391);
    return paramEmojiInfo;
  }
  
  public static void a(String paramString, com.tencent.mm.emoji.loader.e.c paramc, boolean paramBoolean)
  {
    AppMethodBeat.i(105400);
    p.h(paramString, "key");
    p.h(paramc, "task");
    ae.i(TAG, "addTask: " + paramString + ' ' + paramBoolean);
    ((Map)gkN).put(paramString, paramc);
    if (paramBoolean)
    {
      gkO.b((com.tencent.mm.loader.g.c)paramc);
      AppMethodBeat.o(105400);
      return;
    }
    paramc.run();
    AppMethodBeat.o(105400);
  }
  
  public static boolean aeN()
  {
    return gkQ;
  }
  
  public static com.tencent.mm.emoji.loader.e.c c(EmojiInfo paramEmojiInfo)
  {
    AppMethodBeat.i(105389);
    p.h(paramEmojiInfo, "emojiInfo");
    com.tencent.mm.emoji.loader.e.c localc = (com.tencent.mm.emoji.loader.e.c)gkN.get(paramEmojiInfo.Lj());
    Object localObject = localc;
    if (localc == null)
    {
      localObject = com.tencent.mm.kernel.g.ajO().ajq();
      p.g(localObject, "MMKernel.process().current()");
      if (!((com.tencent.mm.kernel.b.h)localObject).akL()) {
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
    p.h(paramView, "view");
    ae.i(TAG, "cancel: ".concat(String.valueOf(paramView)));
    j.a locala = j.glS;
    paramView = (i)paramView.getTag(j.aeU());
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
    p.h(paramEmojiInfo, "emojiInfo");
    Object localObject = paramEmojiInfo.Lj() + "_cover";
    com.tencent.mm.emoji.loader.e.c localc = (com.tencent.mm.emoji.loader.e.c)gkN.get(localObject);
    localObject = localc;
    if (localc == null) {
      localObject = (com.tencent.mm.emoji.loader.e.c)new com.tencent.mm.emoji.loader.e.a(paramEmojiInfo);
    }
    AppMethodBeat.o(105390);
    return localObject;
  }
  
  public static void de(boolean paramBoolean)
  {
    gkQ = paramBoolean;
  }
  
  public static com.tencent.mm.emoji.loader.d.h e(EmojiInfo paramEmojiInfo)
  {
    AppMethodBeat.i(105397);
    p.h(paramEmojiInfo, "emojiInfo");
    paramEmojiInfo = new com.tencent.mm.emoji.loader.d.h(paramEmojiInfo);
    i.a(paramEmojiInfo);
    AppMethodBeat.o(105397);
    return paramEmojiInfo;
  }
  
  public static void s(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(105398);
    p.h(paramString, "md5");
    paramString = (com.tencent.mm.emoji.loader.e.c)gkN.get(paramString);
    if (paramString != null)
    {
      paramString.dg(paramBoolean);
      AppMethodBeat.o(105398);
      return;
    }
    AppMethodBeat.o(105398);
  }
  
  public static void wy(String paramString)
  {
    AppMethodBeat.i(105401);
    p.h(paramString, "key");
    ae.i(TAG, "removeTask: ".concat(String.valueOf(paramString)));
    paramString = (com.tencent.mm.emoji.loader.e.c)gkN.remove(paramString);
    if (paramString != null)
    {
      com.tencent.mm.loader.g.d locald = gkO;
      p.g(paramString, "it");
      locald.c((com.tencent.mm.loader.g.c)paramString);
      AppMethodBeat.o(105401);
      return;
    }
    AppMethodBeat.o(105401);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/emoji/loader/EmojiLoader$EmojiLoaderRetryStrategy;", "Lcom/tencent/mm/loader/loader/cfg/ILoaderRetryStrategy;", "()V", "canRetry", "", "task", "Lcom/tencent/mm/loader/loader/IWorkTask;", "plugin-emojisdk_release"})
  public static final class a
    implements com.tencent.mm.loader.g.a.c
  {
    public final boolean a(com.tencent.mm.loader.g.c paramc)
    {
      AppMethodBeat.i(105387);
      p.h(paramc, "task");
      AppMethodBeat.o(105387);
      return true;
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/emoji/loader/EmojiLoader$callback$1", "Lcom/tencent/mm/loader/loader/LoaderCoreCallback;", "Lcom/tencent/mm/emoji/loader/task/IEmojiLoadTask;", "onLoaderFin", "", "task", "status", "Lcom/tencent/mm/loader/loader/WorkStatus;", "plugin-emojisdk_release"})
  public static final class b
    implements com.tencent.mm.loader.g.f<com.tencent.mm.emoji.loader.e.c>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.emoji.loader.e
 * JD-Core Version:    0.7.0.1
 */