package com.tencent.mm.plugin.emojicapture.model.b;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.emojicapture.model.d.a;
import com.tencent.mm.plugin.emojicapture.proxy.EmojiCaptureService;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.emotion.EmojiInfo;
import d.g.b.k;
import d.l;
import d.y;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/emojicapture/model/mix/EmojiMixManager;", "", "()V", "mixCallback", "com/tencent/mm/plugin/emojicapture/model/mix/EmojiMixManager$mixCallback$1", "Lcom/tencent/mm/plugin/emojicapture/model/mix/EmojiMixManager$mixCallback$1;", "mixQueue", "Lcom/tencent/mm/loader/loader/LoaderCore;", "Lcom/tencent/mm/plugin/emojicapture/model/mix/EmojiMixTask;", "mixTasks", "", "Lcom/tencent/mm/plugin/emojicapture/model/mix/EmojiMixInfo;", "kotlin.jvm.PlatformType", "", "stopServiceRunnable", "Lkotlin/Function0;", "", "waitingQueue", "Ljava/util/LinkedList;", "addTask", "info", "scene", "", "timeEnter", "", "videoPath", "", "retriever", "Lcom/tencent/mm/plugin/emojicapture/model/mix/EmojiFrameRetriever;", "videoPlayRate", "isRemoveBg", "", "stickerPack", "Lcom/tencent/mm/sticker/StickerPack;", "emojiInfo", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "plugin-emojicapture_release"})
public final class e
{
  private static final LinkedList<d> oLr;
  private static final com.tencent.mm.loader.g.d<h> oLs;
  private static d.g.a.a<y> oLt;
  private static final List<d> oLu;
  private static final a oLv;
  public static final e oLw;
  
  static
  {
    AppMethodBeat.i(275);
    oLw = new e();
    oLr = new LinkedList();
    oLs = new com.tencent.mm.loader.g.d((com.tencent.mm.loader.g.a.d)new com.tencent.mm.loader.g.a.f((com.tencent.mm.loader.g.a.c)new com.tencent.mm.loader.g.a.a(20), new com.tencent.mm.loader.g.a.g(1, (byte)0), 1, "EmojiMix"));
    oLt = (d.g.a.a)e.b.oLx;
    oLu = Collections.synchronizedList((List)new LinkedList());
    oLv = new a();
    oLs.a((com.tencent.mm.loader.g.f)oLv);
    AppMethodBeat.o(275);
  }
  
  public static d a(int paramInt1, long paramLong, String paramString, a parama, int paramInt2, boolean paramBoolean, com.tencent.mm.sticker.e parame, EmojiInfo paramEmojiInfo)
  {
    AppMethodBeat.i(274);
    k.h(paramString, "videoPath");
    k.h(parama, "retriever");
    k.h(paramEmojiInfo, "emojiInfo");
    Object localObject = com.tencent.mm.plugin.emojicapture.model.d.oJY;
    localObject = d.a.bXB() + "temp_gif" + bt.eGO();
    d.a locala = com.tencent.mm.plugin.emojicapture.model.d.oJY;
    boolean bool;
    if (!com.tencent.mm.plugin.emojicapture.model.d.bXw())
    {
      bool = true;
      parama = new d(paramInt1, paramLong, paramString, (String)localObject, parama, paramInt2, paramBoolean, parame, bool, paramEmojiInfo);
      k.h(parama, "info");
      oLu.add(parama);
      oLs.b((com.tencent.mm.loader.g.c)new h(parama));
      oLr.add(parama);
      paramString = oLt;
      if (paramString == null) {
        break label201;
      }
      paramString = new g(paramString);
    }
    label201:
    for (;;)
    {
      aq.az((Runnable)paramString);
      com.tencent.mm.bs.d.l(new Intent(aj.getContext(), EmojiCaptureService.class), "tools");
      AppMethodBeat.o(274);
      return parama;
      bool = false;
      break;
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/emojicapture/model/mix/EmojiMixManager$mixCallback$1", "Lcom/tencent/mm/loader/loader/LoaderCoreCallback;", "Lcom/tencent/mm/plugin/emojicapture/model/mix/EmojiMixTask;", "onLoaderFin", "", "task", "status", "Lcom/tencent/mm/loader/loader/WorkStatus;", "plugin-emojicapture_release"})
  public static final class a
    implements com.tencent.mm.loader.g.f<h>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.model.b.e
 * JD-Core Version:    0.7.0.1
 */