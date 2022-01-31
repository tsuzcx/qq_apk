package com.tencent.mm.plugin.emojicapture.model.b;

import a.f.b.j;
import a.l;
import a.y;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.g.f;
import com.tencent.mm.plugin.emojicapture.model.c.a;
import com.tencent.mm.plugin.emojicapture.proxy.EmojiCaptureService;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.emotion.EmojiInfo;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/emojicapture/model/mix/EmojiMixManager;", "", "()V", "mixCallback", "com/tencent/mm/plugin/emojicapture/model/mix/EmojiMixManager$mixCallback$1", "Lcom/tencent/mm/plugin/emojicapture/model/mix/EmojiMixManager$mixCallback$1;", "mixQueue", "Lcom/tencent/mm/loader/loader/LoaderCore;", "Lcom/tencent/mm/plugin/emojicapture/model/mix/EmojiMixTask;", "mixTasks", "", "Lcom/tencent/mm/plugin/emojicapture/model/mix/EmojiMixInfo;", "kotlin.jvm.PlatformType", "", "stopServiceRunnable", "Lkotlin/Function0;", "", "addTask", "info", "scene", "", "timeEnter", "", "videoPath", "", "retriever", "Lcom/tencent/mm/plugin/emojicapture/model/mix/EmojiFrameRetriever;", "videoPlayRate", "isRemoveBg", "", "hasSticker", "emojiInfo", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "plugin-emojicapture_release"})
public final class e
{
  private static final com.tencent.mm.loader.g.d<h> luA;
  private static a.f.a.a<y> luB;
  private static final List<d> luC;
  private static final e.a luD;
  public static final e luE;
  
  static
  {
    AppMethodBeat.i(2675);
    luE = new e();
    luA = new com.tencent.mm.loader.g.d((com.tencent.mm.loader.g.a.d)new com.tencent.mm.loader.g.a.g((com.tencent.mm.loader.g.a.c)new com.tencent.mm.loader.g.a.a(20), new com.tencent.mm.loader.g.a.h(1, (byte)0), 1, "EmojiMix"));
    luB = (a.f.a.a)e.b.luF;
    luC = Collections.synchronizedList((List)new LinkedList());
    luD = new e.a();
    luA.a((f)luD);
    AppMethodBeat.o(2675);
  }
  
  public static d a(int paramInt1, long paramLong, String paramString, a parama, int paramInt2, boolean paramBoolean1, boolean paramBoolean2, EmojiInfo paramEmojiInfo)
  {
    AppMethodBeat.i(2674);
    j.q(paramString, "videoPath");
    j.q(parama, "retriever");
    j.q(paramEmojiInfo, "emojiInfo");
    Object localObject = com.tencent.mm.plugin.emojicapture.model.c.ltu;
    localObject = c.a.bnR() + "temp_gif" + bo.aoy();
    c.a locala = com.tencent.mm.plugin.emojicapture.model.c.ltu;
    boolean bool;
    if (!com.tencent.mm.plugin.emojicapture.model.c.bnN())
    {
      bool = true;
      parama = new d(paramInt1, paramLong, paramString, (String)localObject, parama, paramInt2, paramBoolean1, paramBoolean2, bool, paramEmojiInfo);
      j.q(parama, "info");
      luC.add(parama);
      luA.b((com.tencent.mm.loader.g.c)new h(parama));
      paramString = luB;
      if (paramString == null) {
        break label192;
      }
      paramString = new g(paramString);
    }
    label192:
    for (;;)
    {
      al.ae((Runnable)paramString);
      com.tencent.mm.bq.d.j(new Intent(ah.getContext(), EmojiCaptureService.class), "tools");
      AppMethodBeat.o(2674);
      return parama;
      bool = false;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.model.b.e
 * JD-Core Version:    0.7.0.1
 */