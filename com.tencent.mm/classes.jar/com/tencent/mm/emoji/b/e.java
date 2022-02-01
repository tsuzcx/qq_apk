package com.tencent.mm.emoji.b;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.b.d.h.a;
import com.tencent.mm.emoji.b.d.h.c;
import com.tencent.mm.emoji.b.d.i;
import com.tencent.mm.emoji.b.d.i.a;
import com.tencent.mm.emoji.view.BaseEmojiView;
import com.tencent.mm.loader.f.a.g;
import com.tencent.mm.pluginsdk.ui.emoji.ChattingEmojiView;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.emotion.EmojiInfo;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/emoji/loader/EmojiLoader;", "", "()V", "MockDownloadFail", "", "getMockDownloadFail", "()Z", "setMockDownloadFail", "(Z)V", "TAG", "", "callback", "com/tencent/mm/emoji/loader/EmojiLoader$callback$1", "Lcom/tencent/mm/emoji/loader/EmojiLoader$callback$1;", "taskMap", "Ljava/util/HashMap;", "Lcom/tencent/mm/emoji/loader/task/IEmojiLoadTask;", "Lkotlin/collections/HashMap;", "taskQueue", "Lcom/tencent/mm/loader/loader/LoaderCore;", "addTask", "", "key", "task", "async", "buildCoverTask", "emojiInfo", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "buildTask", "cancel", "view", "Landroid/view/View;", "load", "Lcom/tencent/mm/emoji/loader/request/EmojiViewRequest;", "emojiView", "Lcom/tencent/mm/emoji/view/BaseEmojiView;", "Lcom/tencent/mm/emoji/loader/request/Request$Callback;", "Lcom/tencent/mm/emoji/loader/request/ChatEmojiViewRequest;", "Lcom/tencent/mm/pluginsdk/ui/emoji/ChattingEmojiView;", "cacheKey", "loadCover", "Lcom/tencent/mm/emoji/loader/request/EmojiCoverRequest;", "Landroid/widget/ImageView;", "emptyDrawable", "Landroid/graphics/drawable/Drawable;", "Lcom/tencent/mm/emoji/loader/request/EmojiCoverBitmapRequest;", "Lcom/tencent/mm/emoji/loader/request/Request$StateCallback;", "Landroid/graphics/Bitmap;", "loadFile", "Lcom/tencent/mm/emoji/loader/request/EmojiFileRequest;", "notifyTaskResult", "md5", "success", "removeTask", "EmojiLoaderRetryStrategy", "plugin-emojisdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class e
{
  private static final String TAG;
  public static final e mgl;
  private static final HashMap<String, com.tencent.mm.emoji.b.e.c> mgm;
  private static final com.tencent.mm.loader.f.d<com.tencent.mm.emoji.b.e.c> mgn;
  private static final b mgo;
  private static boolean mgp;
  
  static
  {
    AppMethodBeat.i(105402);
    mgl = new e();
    TAG = "MicroMsg.EmojiLoader";
    mgm = new HashMap();
    mgn = new com.tencent.mm.loader.f.d((com.tencent.mm.loader.f.a.d)new com.tencent.mm.loader.f.a.f((com.tencent.mm.loader.f.a.c)new a(), new g(5, (byte)0), 2, "EmojiLoader"));
    mgo = new b();
    mgn.a((com.tencent.mm.loader.f.e)mgo);
    AppMethodBeat.o(105402);
  }
  
  public static void Em(String paramString)
  {
    AppMethodBeat.i(105401);
    s.u(paramString, "key");
    Log.i(TAG, s.X("removeTask: ", paramString));
    paramString = (com.tencent.mm.emoji.b.e.c)mgm.remove(paramString);
    if (paramString != null) {
      mgn.d((com.tencent.mm.loader.f.c)paramString);
    }
    AppMethodBeat.o(105401);
  }
  
  public static com.tencent.mm.emoji.b.d.a a(EmojiInfo paramEmojiInfo, ChattingEmojiView paramChattingEmojiView, String paramString)
  {
    AppMethodBeat.i(105392);
    s.u(paramEmojiInfo, "emojiInfo");
    s.u(paramChattingEmojiView, "emojiView");
    s.u(paramString, "cacheKey");
    Log.d(TAG, s.X("load emoji ", paramEmojiInfo.getMd5()));
    paramEmojiInfo = new com.tencent.mm.emoji.b.d.a(paramEmojiInfo, paramChattingEmojiView, paramString);
    com.tencent.mm.emoji.b.d.h.a((com.tencent.mm.emoji.b.d.h)paramEmojiInfo);
    AppMethodBeat.o(105392);
    return paramEmojiInfo;
  }
  
  public static com.tencent.mm.emoji.b.d.b a(EmojiInfo paramEmojiInfo, h.c<Bitmap> paramc)
  {
    AppMethodBeat.i(105396);
    s.u(paramEmojiInfo, "emojiInfo");
    paramEmojiInfo = new com.tencent.mm.emoji.b.d.b(paramEmojiInfo, paramc);
    com.tencent.mm.emoji.b.d.h.a((com.tencent.mm.emoji.b.d.h)paramEmojiInfo);
    AppMethodBeat.o(105396);
    return paramEmojiInfo;
  }
  
  public static com.tencent.mm.emoji.b.d.c a(EmojiInfo paramEmojiInfo, ImageView paramImageView, Drawable paramDrawable)
  {
    AppMethodBeat.i(242734);
    s.u(paramEmojiInfo, "emojiInfo");
    s.u(paramImageView, "view");
    paramEmojiInfo = new com.tencent.mm.emoji.b.d.c(paramEmojiInfo, paramImageView, paramDrawable);
    com.tencent.mm.emoji.b.d.h.a((com.tencent.mm.emoji.b.d.h)paramEmojiInfo);
    AppMethodBeat.o(242734);
    return paramEmojiInfo;
  }
  
  public static com.tencent.mm.emoji.b.d.e a(EmojiInfo paramEmojiInfo, h.a parama)
  {
    AppMethodBeat.i(105393);
    s.u(paramEmojiInfo, "emojiInfo");
    paramEmojiInfo = a(paramEmojiInfo, true, parama);
    AppMethodBeat.o(105393);
    return paramEmojiInfo;
  }
  
  public static com.tencent.mm.emoji.b.d.e a(EmojiInfo paramEmojiInfo, boolean paramBoolean, h.a parama)
  {
    AppMethodBeat.i(105394);
    s.u(paramEmojiInfo, "emojiInfo");
    Log.i(TAG, s.X("load emoji file ", paramEmojiInfo.getMd5()));
    paramEmojiInfo = new com.tencent.mm.emoji.b.d.e(paramEmojiInfo, parama);
    paramEmojiInfo.start(paramBoolean);
    AppMethodBeat.o(105394);
    return paramEmojiInfo;
  }
  
  public static com.tencent.mm.emoji.b.d.f a(EmojiInfo paramEmojiInfo, BaseEmojiView paramBaseEmojiView, h.a parama)
  {
    AppMethodBeat.i(105391);
    s.u(paramEmojiInfo, "emojiInfo");
    s.u(paramBaseEmojiView, "emojiView");
    Log.d(TAG, s.X("load emoji ", paramEmojiInfo.getMd5()));
    paramEmojiInfo = new com.tencent.mm.emoji.b.d.f(paramEmojiInfo, paramBaseEmojiView, parama);
    com.tencent.mm.emoji.b.d.h.a((com.tencent.mm.emoji.b.d.h)paramEmojiInfo);
    AppMethodBeat.o(105391);
    return paramEmojiInfo;
  }
  
  public static void a(String paramString, com.tencent.mm.emoji.b.e.c paramc, boolean paramBoolean)
  {
    AppMethodBeat.i(105400);
    s.u(paramString, "key");
    s.u(paramc, "task");
    Log.i(TAG, "addTask: " + paramString + ' ' + paramBoolean);
    ((Map)mgm).put(paramString, paramc);
    if (paramBoolean)
    {
      mgn.c((com.tencent.mm.loader.f.c)paramc);
      AppMethodBeat.o(105400);
      return;
    }
    paramc.run();
    AppMethodBeat.o(105400);
  }
  
  public static boolean aUu()
  {
    return mgp;
  }
  
  public static com.tencent.mm.emoji.b.e.c c(EmojiInfo paramEmojiInfo)
  {
    AppMethodBeat.i(105389);
    s.u(paramEmojiInfo, "emojiInfo");
    com.tencent.mm.emoji.b.e.c localc2 = (com.tencent.mm.emoji.b.e.c)mgm.get(paramEmojiInfo.getMd5());
    com.tencent.mm.emoji.b.e.c localc1 = localc2;
    if (localc2 == null) {
      if (!((com.tencent.mm.kernel.b.h)com.tencent.mm.kernel.h.baB().bad()).bbA()) {
        break label67;
      }
    }
    label67:
    for (localc1 = (com.tencent.mm.emoji.b.e.c)new com.tencent.mm.emoji.b.e.b(paramEmojiInfo);; localc1 = (com.tencent.mm.emoji.b.e.c)new com.tencent.mm.emoji.b.e.e(paramEmojiInfo))
    {
      AppMethodBeat.o(105389);
      return localc1;
    }
  }
  
  public static void cX(View paramView)
  {
    AppMethodBeat.i(105399);
    s.u(paramView, "view");
    Log.i(TAG, s.X("cancel: ", paramView));
    i.a locala = i.mhi;
    paramView = (com.tencent.mm.emoji.b.d.h)paramView.getTag(i.aUC());
    if (paramView != null) {
      paramView.cancel();
    }
    AppMethodBeat.o(105399);
  }
  
  public static com.tencent.mm.emoji.b.e.c d(EmojiInfo paramEmojiInfo)
  {
    AppMethodBeat.i(105390);
    s.u(paramEmojiInfo, "emojiInfo");
    Object localObject = s.X(paramEmojiInfo.getMd5(), "_cover");
    com.tencent.mm.emoji.b.e.c localc = (com.tencent.mm.emoji.b.e.c)mgm.get(localObject);
    localObject = localc;
    if (localc == null) {
      localObject = (com.tencent.mm.emoji.b.e.c)new com.tencent.mm.emoji.b.e.a(paramEmojiInfo);
    }
    AppMethodBeat.o(105390);
    return localObject;
  }
  
  public static void fa(boolean paramBoolean)
  {
    mgp = paramBoolean;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/emoji/loader/EmojiLoader$EmojiLoaderRetryStrategy;", "Lcom/tencent/mm/loader/loader/cfg/ILoaderRetryStrategy;", "()V", "canRetry", "", "task", "Lcom/tencent/mm/loader/loader/IWorkTask;", "plugin-emojisdk_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    implements com.tencent.mm.loader.f.a.c
  {
    public final boolean a(com.tencent.mm.loader.f.c paramc)
    {
      AppMethodBeat.i(105387);
      s.u(paramc, "task");
      AppMethodBeat.o(105387);
      return true;
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/emoji/loader/EmojiLoader$callback$1", "Lcom/tencent/mm/loader/loader/LoaderCoreCallback;", "Lcom/tencent/mm/emoji/loader/task/IEmojiLoadTask;", "onLoaderFin", "", "task", "status", "Lcom/tencent/mm/loader/loader/WorkStatus;", "plugin-emojisdk_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    implements com.tencent.mm.loader.f.e<com.tencent.mm.emoji.b.e.c>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.emoji.b.e
 * JD-Core Version:    0.7.0.1
 */