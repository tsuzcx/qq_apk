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
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/emojicapture/model/mix/EmojiMixManager;", "", "()V", "mixCallback", "com/tencent/mm/plugin/emojicapture/model/mix/EmojiMixManager$mixCallback$1", "Lcom/tencent/mm/plugin/emojicapture/model/mix/EmojiMixManager$mixCallback$1;", "mixQueue", "Lcom/tencent/mm/loader/loader/LoaderCore;", "Lcom/tencent/mm/plugin/emojicapture/model/mix/EmojiMixTask;", "mixTasks", "", "Lcom/tencent/mm/plugin/emojicapture/model/mix/EmojiMixInfo;", "kotlin.jvm.PlatformType", "", "stopServiceRunnable", "Lkotlin/Function0;", "", "waitingQueue", "Ljava/util/LinkedList;", "addTask", "info", "scene", "", "timeEnter", "", "videoPath", "", "retriever", "Lcom/tencent/mm/plugin/emojicapture/model/mix/EmojiFrameRetriever;", "videoPlayRate", "isRemoveBg", "", "stickerPack", "Lcom/tencent/mm/sticker/StickerPack;", "emojiInfo", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "plugin-emojicapture_release"})
public final class e
{
  private static final LinkedList<d> rpO;
  private static final com.tencent.mm.loader.g.d<h> rpP;
  private static kotlin.g.a.a<x> rpQ;
  private static final List<d> rpR;
  private static final a rpS;
  public static final e rpT;
  
  static
  {
    AppMethodBeat.i(275);
    rpT = new e();
    rpO = new LinkedList();
    rpP = new com.tencent.mm.loader.g.d((com.tencent.mm.loader.g.a.d)new com.tencent.mm.loader.g.a.f((com.tencent.mm.loader.g.a.c)new com.tencent.mm.loader.g.a.a(20), new com.tencent.mm.loader.g.a.g(1, (byte)0), 1, "EmojiMix"));
    rpQ = (kotlin.g.a.a)e.b.rpU;
    rpR = Collections.synchronizedList((List)new LinkedList());
    rpS = new a();
    rpP.a((com.tencent.mm.loader.g.f)rpS);
    AppMethodBeat.o(275);
  }
  
  public static d a(int paramInt1, long paramLong, String paramString, a parama, int paramInt2, boolean paramBoolean, com.tencent.mm.sticker.f paramf, EmojiInfo paramEmojiInfo)
  {
    AppMethodBeat.i(274);
    p.h(paramString, "videoPath");
    p.h(parama, "retriever");
    p.h(paramEmojiInfo, "emojiInfo");
    Object localObject = com.tencent.mm.plugin.emojicapture.model.d.roA;
    localObject = d.a.cIJ() + "temp_gif" + Util.nowMilliSecond();
    d.a locala = com.tencent.mm.plugin.emojicapture.model.d.roA;
    boolean bool;
    if (!com.tencent.mm.plugin.emojicapture.model.d.cIE())
    {
      bool = true;
      parama = new d(paramInt1, paramLong, paramString, (String)localObject, parama, paramInt2, paramBoolean, paramf, bool, paramEmojiInfo);
      p.h(parama, "info");
      rpR.add(parama);
      rpP.c((com.tencent.mm.loader.g.c)new h(parama));
      rpO.add(parama);
      paramString = rpQ;
      if (paramString == null) {
        break label201;
      }
      paramString = new g(paramString);
    }
    label201:
    for (;;)
    {
      MMHandlerThread.removeRunnable((Runnable)paramString);
      com.tencent.mm.br.c.m(new Intent(MMApplicationContext.getContext(), EmojiCaptureService.class), "tools");
      AppMethodBeat.o(274);
      return parama;
      bool = false;
      break;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/emojicapture/model/mix/EmojiMixManager$mixCallback$1", "Lcom/tencent/mm/loader/loader/LoaderCoreCallback;", "Lcom/tencent/mm/plugin/emojicapture/model/mix/EmojiMixTask;", "onLoaderFin", "", "task", "status", "Lcom/tencent/mm/loader/loader/WorkStatus;", "plugin-emojicapture_release"})
  public static final class a
    implements com.tencent.mm.loader.g.f<h>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.model.b.e
 * JD-Core Version:    0.7.0.1
 */