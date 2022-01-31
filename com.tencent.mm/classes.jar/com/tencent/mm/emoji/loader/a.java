package com.tencent.mm.emoji.loader;

import a.f.b.j;
import a.l;
import android.view.View;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.loader.d.h.a;
import com.tencent.mm.emoji.loader.d.i;
import com.tencent.mm.emoji.loader.d.i.a;
import com.tencent.mm.emoji.view.BaseEmojiView;
import com.tencent.mm.loader.g.d.g;
import com.tencent.mm.loader.g.f;
import com.tencent.mm.pluginsdk.ui.emoji.ChattingEmojiView;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.emotion.EmojiInfo;
import java.util.HashMap;
import java.util.Map;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/emoji/loader/EmojiLoader;", "", "()V", "TAG", "", "callback", "com/tencent/mm/emoji/loader/EmojiLoader$callback$1", "Lcom/tencent/mm/emoji/loader/EmojiLoader$callback$1;", "taskMap", "Ljava/util/HashMap;", "Lcom/tencent/mm/emoji/loader/task/IEmojiLoadTask;", "Lkotlin/collections/HashMap;", "taskQueue", "Lcom/tencent/mm/loader/loader/LoaderCore;", "addTask", "", "key", "task", "async", "", "buildCoverTask", "emojiInfo", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "buildTask", "cancel", "view", "Landroid/view/View;", "load", "Lcom/tencent/mm/emoji/loader/request/EmojiViewRequest;", "emojiView", "Lcom/tencent/mm/emoji/view/BaseEmojiView;", "Lcom/tencent/mm/emoji/loader/request/Request$Callback;", "Lcom/tencent/mm/emoji/loader/request/ChatEmojiViewRequest;", "Lcom/tencent/mm/pluginsdk/ui/emoji/ChattingEmojiView;", "cacheKey", "loadCover", "Lcom/tencent/mm/emoji/loader/request/EmojiCoverRequest;", "Landroid/widget/ImageView;", "loadFile", "Lcom/tencent/mm/emoji/loader/request/EmojiFileRequest;", "loadForRemote", "Lcom/tencent/mm/emoji/loader/request/ProcessRequest;", "notifyTaskResult", "md5", "success", "removeTask", "EmojiLoaderRetryStrategy", "plugin-emojisdk_release"})
public final class a
{
  private static final String TAG = "MicroMsg.EmojiLoader";
  private static final HashMap<String, com.tencent.mm.emoji.loader.e.c> evh;
  private static final com.tencent.mm.loader.g.d<com.tencent.mm.emoji.loader.e.c> evi;
  private static final a.b evj;
  public static final a evk;
  
  static
  {
    AppMethodBeat.i(63161);
    evk = new a();
    TAG = "MicroMsg.EmojiLoader";
    evh = new HashMap();
    evi = new com.tencent.mm.loader.g.d((com.tencent.mm.loader.g.a.d)new com.tencent.mm.loader.g.a.g((com.tencent.mm.loader.g.a.c)new a.a(), new com.tencent.mm.loader.g.a.h(2, (byte)0), 2, "EmojiLoader"));
    evj = new a.b();
    evi.a((f)evj);
    AppMethodBeat.o(63161);
  }
  
  public static com.tencent.mm.emoji.loader.d.a a(EmojiInfo paramEmojiInfo, ChattingEmojiView paramChattingEmojiView, String paramString)
  {
    AppMethodBeat.i(63153);
    j.q(paramEmojiInfo, "emojiInfo");
    j.q(paramChattingEmojiView, "emojiView");
    j.q(paramString, "cacheKey");
    ab.d(TAG, "load emoji " + paramEmojiInfo.Al());
    paramEmojiInfo = new com.tencent.mm.emoji.loader.d.a(paramEmojiInfo, paramChattingEmojiView, paramString);
    paramEmojiInfo.start(true);
    AppMethodBeat.o(63153);
    return paramEmojiInfo;
  }
  
  public static com.tencent.mm.emoji.loader.d.b a(EmojiInfo paramEmojiInfo, ImageView paramImageView)
  {
    AppMethodBeat.i(63155);
    j.q(paramEmojiInfo, "emojiInfo");
    j.q(paramImageView, "view");
    paramEmojiInfo = new com.tencent.mm.emoji.loader.d.b(paramEmojiInfo, paramImageView);
    paramEmojiInfo.start(true);
    AppMethodBeat.o(63155);
    return paramEmojiInfo;
  }
  
  public static com.tencent.mm.emoji.loader.d.d a(EmojiInfo paramEmojiInfo, boolean paramBoolean, h.a parama)
  {
    AppMethodBeat.i(151755);
    j.q(paramEmojiInfo, "emojiInfo");
    ab.i(TAG, "load emoji file " + paramEmojiInfo.Al());
    paramEmojiInfo = new com.tencent.mm.emoji.loader.d.d(paramEmojiInfo, parama);
    paramEmojiInfo.start(paramBoolean);
    AppMethodBeat.o(151755);
    return paramEmojiInfo;
  }
  
  public static com.tencent.mm.emoji.loader.d.e a(EmojiInfo paramEmojiInfo, BaseEmojiView paramBaseEmojiView, h.a parama)
  {
    AppMethodBeat.i(63152);
    j.q(paramEmojiInfo, "emojiInfo");
    j.q(paramBaseEmojiView, "emojiView");
    ab.d(TAG, "load emoji " + paramEmojiInfo.Al());
    paramEmojiInfo = new com.tencent.mm.emoji.loader.d.e(paramEmojiInfo, paramBaseEmojiView, parama);
    paramEmojiInfo.start(true);
    AppMethodBeat.o(63152);
    return paramEmojiInfo;
  }
  
  public static com.tencent.mm.emoji.loader.e.c a(EmojiInfo paramEmojiInfo)
  {
    AppMethodBeat.i(63150);
    j.q(paramEmojiInfo, "emojiInfo");
    com.tencent.mm.emoji.loader.e.c localc = (com.tencent.mm.emoji.loader.e.c)evh.get(paramEmojiInfo.Al());
    Object localObject = localc;
    if (localc == null)
    {
      localObject = com.tencent.mm.kernel.g.RI().Rj();
      j.p(localObject, "MMKernel.process().current()");
      if (!((com.tencent.mm.kernel.b.h)localObject).SD()) {
        break label73;
      }
    }
    label73:
    for (localObject = (com.tencent.mm.emoji.loader.e.c)new com.tencent.mm.emoji.loader.e.b(paramEmojiInfo);; localObject = (com.tencent.mm.emoji.loader.e.c)new com.tencent.mm.emoji.loader.e.e(paramEmojiInfo))
    {
      AppMethodBeat.o(63150);
      return localObject;
    }
  }
  
  public static void a(String paramString, com.tencent.mm.emoji.loader.e.c paramc, boolean paramBoolean)
  {
    AppMethodBeat.i(151756);
    j.q(paramString, "key");
    j.q(paramc, "task");
    ab.i(TAG, "addTask: " + paramString + ' ' + paramBoolean);
    ((Map)evh).put(paramString, paramc);
    if (paramBoolean)
    {
      evi.b((com.tencent.mm.loader.g.c)paramc);
      AppMethodBeat.o(151756);
      return;
    }
    paramc.run();
    AppMethodBeat.o(151756);
  }
  
  public static com.tencent.mm.emoji.loader.e.c b(EmojiInfo paramEmojiInfo)
  {
    AppMethodBeat.i(63151);
    j.q(paramEmojiInfo, "emojiInfo");
    Object localObject = paramEmojiInfo.Al() + "_cover";
    com.tencent.mm.emoji.loader.e.c localc = (com.tencent.mm.emoji.loader.e.c)evh.get(localObject);
    localObject = localc;
    if (localc == null) {
      localObject = (com.tencent.mm.emoji.loader.e.c)new com.tencent.mm.emoji.loader.e.a(paramEmojiInfo);
    }
    AppMethodBeat.o(63151);
    return localObject;
  }
  
  public static com.tencent.mm.emoji.loader.d.g c(EmojiInfo paramEmojiInfo)
  {
    AppMethodBeat.i(63156);
    j.q(paramEmojiInfo, "emojiInfo");
    paramEmojiInfo = new com.tencent.mm.emoji.loader.d.g(paramEmojiInfo);
    paramEmojiInfo.start(true);
    AppMethodBeat.o(63156);
    return paramEmojiInfo;
  }
  
  public static void ck(View paramView)
  {
    AppMethodBeat.i(63158);
    j.q(paramView, "view");
    ab.i(TAG, "cancel: ".concat(String.valueOf(paramView)));
    i.a locala = i.ewb;
    paramView = (com.tencent.mm.emoji.loader.d.h)paramView.getTag(i.Ow());
    if (paramView != null)
    {
      paramView.cancel();
      AppMethodBeat.o(63158);
      return;
    }
    AppMethodBeat.o(63158);
  }
  
  public static void lI(String paramString)
  {
    AppMethodBeat.i(63160);
    j.q(paramString, "key");
    ab.i(TAG, "removeTask: ".concat(String.valueOf(paramString)));
    Object localObject = (com.tencent.mm.emoji.loader.e.c)evh.remove(paramString);
    if (localObject != null)
    {
      paramString = evi;
      j.p(localObject, "it");
      localObject = (com.tencent.mm.loader.g.c)localObject;
      j.q(localObject, "t");
      com.tencent.mm.ab.b.b((a.f.a.a)new d.g(paramString, (com.tencent.mm.loader.g.c)localObject));
      AppMethodBeat.o(63160);
      return;
    }
    AppMethodBeat.o(63160);
  }
  
  public static void r(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(63157);
    j.q(paramString, "md5");
    paramString = (com.tencent.mm.emoji.loader.e.c)evh.get(paramString);
    if (paramString != null)
    {
      paramString.cd(paramBoolean);
      AppMethodBeat.o(63157);
      return;
    }
    AppMethodBeat.o(63157);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.emoji.loader.a
 * JD-Core Version:    0.7.0.1
 */