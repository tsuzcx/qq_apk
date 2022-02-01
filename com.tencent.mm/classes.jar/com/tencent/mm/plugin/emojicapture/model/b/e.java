package com.tencent.mm.plugin.emojicapture.model.b;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.emojicapture.model.d.a;
import com.tencent.mm.plugin.emojicapture.proxy.EmojiCaptureService;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.emotion.EmojiInfo;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/emojicapture/model/mix/EmojiMixManager;", "", "()V", "mixCallback", "com/tencent/mm/plugin/emojicapture/model/mix/EmojiMixManager$mixCallback$1", "Lcom/tencent/mm/plugin/emojicapture/model/mix/EmojiMixManager$mixCallback$1;", "mixQueue", "Lcom/tencent/mm/loader/loader/LoaderCore;", "Lcom/tencent/mm/plugin/emojicapture/model/mix/EmojiMixTask;", "mixTasks", "", "Lcom/tencent/mm/plugin/emojicapture/model/mix/EmojiMixInfo;", "kotlin.jvm.PlatformType", "", "stopServiceRunnable", "Lkotlin/Function0;", "", "waitingQueue", "Ljava/util/LinkedList;", "addTask", "info", "scene", "", "timeEnter", "", "videoPath", "", "retriever", "Lcom/tencent/mm/plugin/emojicapture/model/mix/EmojiFrameRetriever;", "videoPlayRate", "isRemoveBg", "", "stickerPack", "Lcom/tencent/mm/sticker/StickerPack;", "emojiInfo", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "plugin-emojicapture_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class e
{
  public static final e yhW;
  private static final LinkedList<d> yhX;
  private static final com.tencent.mm.loader.f.d<g> yhY;
  private static kotlin.g.a.a<ah> yhZ;
  private static final List<d> yia;
  private static final a yib;
  
  static
  {
    AppMethodBeat.i(275);
    yhW = new e();
    yhX = new LinkedList();
    yhY = new com.tencent.mm.loader.f.d((com.tencent.mm.loader.f.a.d)new com.tencent.mm.loader.f.a.f((com.tencent.mm.loader.f.a.c)new com.tencent.mm.loader.f.a.a(20), new com.tencent.mm.loader.f.a.g(1, (byte)0), 1, "EmojiMix"));
    yhZ = (kotlin.g.a.a)e.b.yic;
    yia = Collections.synchronizedList((List)new LinkedList());
    yib = new a();
    yhY.a((com.tencent.mm.loader.f.e)yib);
    AppMethodBeat.o(275);
  }
  
  public static d a(int paramInt1, long paramLong, String paramString, a parama, int paramInt2, boolean paramBoolean, com.tencent.mm.sticker.f paramf, EmojiInfo paramEmojiInfo)
  {
    AppMethodBeat.i(274);
    s.u(paramString, "videoPath");
    s.u(parama, "retriever");
    s.u(paramEmojiInfo, "emojiInfo");
    Object localObject = com.tencent.mm.plugin.emojicapture.model.d.ygM;
    localObject = d.a.dDI() + "temp_gif" + Util.nowMilliSecond();
    d.a locala = com.tencent.mm.plugin.emojicapture.model.d.ygM;
    if (!com.tencent.mm.plugin.emojicapture.model.d.dDD()) {}
    for (boolean bool = true;; bool = false)
    {
      paramString = new d(paramInt1, paramLong, paramString, (String)localObject, parama, paramInt2, paramBoolean, paramf, bool, paramEmojiInfo);
      s.u(paramString, "info");
      yia.add(paramString);
      yhY.c((com.tencent.mm.loader.f.c)new g(paramString));
      yhX.add(paramString);
      MMHandlerThread.removeRunnable(new e..ExternalSyntheticLambda0(yhZ));
      com.tencent.mm.br.c.n(new Intent(MMApplicationContext.getContext(), EmojiCaptureService.class), "tools");
      AppMethodBeat.o(274);
      return paramString;
    }
  }
  
  private static final void aM(kotlin.g.a.a parama)
  {
    AppMethodBeat.i(269410);
    s.u(parama, "$tmp0");
    parama.invoke();
    AppMethodBeat.o(269410);
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/emojicapture/model/mix/EmojiMixManager$mixCallback$1", "Lcom/tencent/mm/loader/loader/LoaderCoreCallback;", "Lcom/tencent/mm/plugin/emojicapture/model/mix/EmojiMixTask;", "onLoaderFin", "", "task", "status", "Lcom/tencent/mm/loader/loader/WorkStatus;", "plugin-emojicapture_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    implements com.tencent.mm.loader.f.e<g>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.model.b.e
 * JD-Core Version:    0.7.0.1
 */