package com.tencent.mm.emoji.d;

import a.f.b.j;
import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.a.g.b;
import com.tencent.mm.model.r;
import com.tencent.mm.plugin.emojicapture.api.EmojiCaptureReporter;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.at;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.storage.emotion.EmojiInfo.a;
import com.tencent.mm.storage.emotion.EmojiInfo.b;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"com/tencent/mm/emoji/upload/EmojiCaptureUploadTask$call$1", "Lcom/tencent/mm/emoji/model/EmojiUploadLogic$EmojiUploadCallback;", "uploadCallback", "", "errorCode", "", "gifMd5", "", "activityId", "plugin-emojisdk_release"})
public final class c$a
  implements g.b
{
  c$a(long paramLong) {}
  
  public final void f(int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(63295);
    ab.i(this.eyk.TAG, "uploadCallback: " + paramInt + ", " + paramString1);
    this.eyk.eyi = bo.hl(this.eyl);
    if (paramInt == 0)
    {
      paramString2 = this.eyk;
      paramInt = paramString2.evH.field_captureScene;
      paramString2.evH.a(EmojiInfo.a.yPB);
      EmojiCaptureReporter.d(paramString2.eyh, paramString2.eyi, paramInt);
      com.tencent.mm.plugin.report.service.h.qsU.e(10431, new Object[] { Integer.valueOf(7), paramString2.evH.Al(), paramString2.evH.field_designerID, paramString2.evH.avS(), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(paramString2.evH.getSize()), r.Zn(), paramString2.evH.field_activityid });
      if ((paramString2.eyj) && (!com.tencent.mm.emoji.a.h.OP()))
      {
        ab.w(paramString2.TAG, "upload wxam but not decode, load gif");
        localObject = com.tencent.mm.emoji.loader.c.g.evO;
        com.tencent.mm.emoji.loader.c.g.a(paramString2.evH, (a.f.a.b)new c.b(paramString2, paramString1));
        AppMethodBeat.o(63295);
        return;
      }
      com.tencent.mm.emoji.a.d.Oz().cm(true);
      Object localObject = com.tencent.mm.kernel.g.G(com.tencent.mm.plugin.emoji.b.d.class);
      j.p(localObject, "MMKernel.plugin(IPluginEmoji::class.java)");
      localObject = ((com.tencent.mm.plugin.emoji.b.d)localObject).getEmojiStorageMgr();
      j.p(localObject, "MMKernel.plugin(IPluginE…ass.java).emojiStorageMgr");
      ((at)localObject).aUI().J(paramString2.evH);
      paramString2.a(com.tencent.mm.loader.g.h.ePv);
      localObject = b.eyc;
      b.b(paramString2.eyh, true, paramString1);
      AppMethodBeat.o(63295);
      return;
    }
    paramString1 = this.eyk;
    paramString1.evH.a(EmojiInfo.a.yPF);
    int i = paramString1.evH.field_captureScene;
    switch (paramInt)
    {
    default: 
      EmojiCaptureReporter.f(paramString1.eyh, 3, i);
      paramString1.evH.a(EmojiInfo.b.yPN);
    }
    for (;;)
    {
      paramString2 = com.tencent.mm.kernel.g.G(com.tencent.mm.plugin.emoji.b.d.class);
      j.p(paramString2, "MMKernel.plugin(IPluginEmoji::class.java)");
      paramString2 = ((com.tencent.mm.plugin.emoji.b.d)paramString2).getEmojiStorageMgr();
      j.p(paramString2, "MMKernel.plugin(IPluginE…ass.java).emojiStorageMgr");
      paramString2.aUI().J(paramString1.evH);
      paramString2 = b.eyc;
      b.b(paramString1.eyh, false, null);
      paramString1.a(com.tencent.mm.loader.g.h.ePw);
      AppMethodBeat.o(63295);
      return;
      EmojiCaptureReporter.f(paramString1.eyh, 7, i);
      paramString1.evH.a(EmojiInfo.b.yPI);
      continue;
      EmojiCaptureReporter.f(paramString1.eyh, 8, i);
      paramString1.evH.a(EmojiInfo.b.yPJ);
      continue;
      EmojiCaptureReporter.f(paramString1.eyh, 9, i);
      paramString1.evH.a(EmojiInfo.b.yPK);
      continue;
      EmojiCaptureReporter.f(paramString1.eyh, 5, i);
      paramString1.evH.a(EmojiInfo.b.yPL);
      continue;
      EmojiCaptureReporter.f(paramString1.eyh, 1, i);
      paramString1.evH.a(EmojiInfo.b.yPM);
      continue;
      EmojiCaptureReporter.f(paramString1.eyh, 4, i);
      paramString1.evH.a(EmojiInfo.b.yPO);
      continue;
      EmojiCaptureReporter.f(paramString1.eyh, 2, i);
      paramString1.evH.a(EmojiInfo.b.yPP);
      continue;
      EmojiCaptureReporter.f(paramString1.eyh, 6, i);
      paramString1.evH.a(EmojiInfo.b.yPQ);
      continue;
      EmojiCaptureReporter.f(paramString1.eyh, 10, i);
      paramString1.evH.a(EmojiInfo.b.yPR);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.emoji.d.c.a
 * JD-Core Version:    0.7.0.1
 */