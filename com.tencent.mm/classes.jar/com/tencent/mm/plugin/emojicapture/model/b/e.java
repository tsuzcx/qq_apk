package com.tencent.mm.plugin.emojicapture.model.b;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.emojicapture.model.d.a;
import com.tencent.mm.plugin.emojicapture.proxy.EmojiCaptureService;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.emotion.EmojiInfo;
import d.g.b.p;
import d.l;
import d.z;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/emojicapture/model/mix/EmojiMixManager;", "", "()V", "mixCallback", "com/tencent/mm/plugin/emojicapture/model/mix/EmojiMixManager$mixCallback$1", "Lcom/tencent/mm/plugin/emojicapture/model/mix/EmojiMixManager$mixCallback$1;", "mixQueue", "Lcom/tencent/mm/loader/loader/LoaderCore;", "Lcom/tencent/mm/plugin/emojicapture/model/mix/EmojiMixTask;", "mixTasks", "", "Lcom/tencent/mm/plugin/emojicapture/model/mix/EmojiMixInfo;", "kotlin.jvm.PlatformType", "", "stopServiceRunnable", "Lkotlin/Function0;", "", "waitingQueue", "Ljava/util/LinkedList;", "addTask", "info", "scene", "", "timeEnter", "", "videoPath", "", "retriever", "Lcom/tencent/mm/plugin/emojicapture/model/mix/EmojiFrameRetriever;", "videoPlayRate", "isRemoveBg", "", "stickerPack", "Lcom/tencent/mm/sticker/StickerPack;", "emojiInfo", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "plugin-emojicapture_release"})
public final class e
{
  private static final LinkedList<d> pSm;
  private static final com.tencent.mm.loader.g.d<h> pSn;
  private static d.g.a.a<z> pSo;
  private static final List<d> pSp;
  private static final a pSq;
  public static final e pSr;
  
  static
  {
    AppMethodBeat.i(275);
    pSr = new e();
    pSm = new LinkedList();
    pSn = new com.tencent.mm.loader.g.d((com.tencent.mm.loader.g.a.d)new com.tencent.mm.loader.g.a.f((com.tencent.mm.loader.g.a.c)new com.tencent.mm.loader.g.a.a(20), new com.tencent.mm.loader.g.a.g(1, (byte)0), 1, "EmojiMix"));
    pSo = (d.g.a.a)e.b.pSs;
    pSp = Collections.synchronizedList((List)new LinkedList());
    pSq = new a();
    pSn.a((com.tencent.mm.loader.g.f)pSq);
    AppMethodBeat.o(275);
  }
  
  public static d a(int paramInt1, long paramLong, String paramString, a parama, int paramInt2, boolean paramBoolean, com.tencent.mm.sticker.f paramf, EmojiInfo paramEmojiInfo)
  {
    AppMethodBeat.i(274);
    p.h(paramString, "videoPath");
    p.h(parama, "retriever");
    p.h(paramEmojiInfo, "emojiInfo");
    Object localObject = com.tencent.mm.plugin.emojicapture.model.d.pQW;
    localObject = d.a.cjr() + "temp_gif" + bt.flT();
    d.a locala = com.tencent.mm.plugin.emojicapture.model.d.pQW;
    boolean bool;
    if (!com.tencent.mm.plugin.emojicapture.model.d.cjm())
    {
      bool = true;
      parama = new d(paramInt1, paramLong, paramString, (String)localObject, parama, paramInt2, paramBoolean, paramf, bool, paramEmojiInfo);
      p.h(parama, "info");
      pSp.add(parama);
      pSn.b((com.tencent.mm.loader.g.c)new h(parama));
      pSm.add(parama);
      paramString = pSo;
      if (paramString == null) {
        break label201;
      }
      paramString = new g(paramString);
    }
    label201:
    for (;;)
    {
      aq.aA((Runnable)paramString);
      com.tencent.mm.bs.d.l(new Intent(aj.getContext(), EmojiCaptureService.class), "tools");
      AppMethodBeat.o(274);
      return parama;
      bool = false;
      break;
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/emojicapture/model/mix/EmojiMixManager$mixCallback$1", "Lcom/tencent/mm/loader/loader/LoaderCoreCallback;", "Lcom/tencent/mm/plugin/emojicapture/model/mix/EmojiMixTask;", "onLoaderFin", "", "task", "status", "Lcom/tencent/mm/loader/loader/WorkStatus;", "plugin-emojicapture_release"})
  public static final class a
    implements com.tencent.mm.loader.g.f<h>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.model.b.e
 * JD-Core Version:    0.7.0.1
 */