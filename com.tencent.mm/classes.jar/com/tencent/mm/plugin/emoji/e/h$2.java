package com.tencent.mm.plugin.emoji.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.a.g.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.r;
import com.tencent.mm.plugin.emojicapture.api.EmojiCaptureReporter;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.storage.at;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.storage.emotion.EmojiInfo.a;
import com.tencent.mm.storage.emotion.EmojiInfo.b;

final class h$2
  implements g.b
{
  h$2(h paramh, EmojiInfo paramEmojiInfo, EmojiCaptureReporter paramEmojiCaptureReporter) {}
  
  public final void f(int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(139673);
    g.RO().ac(new h.2.1(this));
    ab.d("MicroMsg.emoji.EmojiMgrImpl", "uploadCaptureEmoji errorCode: " + paramInt + " gifMd5: " + paramString1 + " activityId: " + paramString2);
    if (paramInt != 0) {
      this.lfG.a(EmojiInfo.a.yPF);
    }
    switch (paramInt)
    {
    case 1: 
    default: 
      EmojiCaptureReporter.f(this.lfP.eyh, 3, this.lfG.field_captureScene);
      this.lfG.a(EmojiInfo.b.yPN);
    }
    for (;;)
    {
      ((com.tencent.mm.plugin.emoji.b.d)g.G(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiStorageMgr().yNn.J(this.lfG);
      AppMethodBeat.o(139673);
      return;
      this.lfP.lsO = System.currentTimeMillis();
      long l1 = this.lfP.lsO;
      long l2 = this.lfP.lsN;
      EmojiCaptureReporter.d(this.lfP.eyh, l1 - l2, this.lfG.field_captureScene);
      this.lfG.a(EmojiInfo.a.yPB);
      this.lfG.a(EmojiInfo.b.yPH);
      com.tencent.mm.plugin.report.service.h.qsU.e(10431, new Object[] { Integer.valueOf(7), this.lfG.Al(), this.lfG.field_designerID, this.lfG.field_groupId, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(this.lfG.field_size), r.Zn(), this.lfG.field_activityid });
      continue;
      EmojiCaptureReporter.f(this.lfP.eyh, 7, this.lfG.field_captureScene);
      this.lfG.a(EmojiInfo.b.yPI);
      continue;
      EmojiCaptureReporter.f(this.lfP.eyh, 8, this.lfG.field_captureScene);
      this.lfG.a(EmojiInfo.b.yPJ);
      continue;
      EmojiCaptureReporter.f(this.lfP.eyh, 9, this.lfG.field_captureScene);
      this.lfG.a(EmojiInfo.b.yPK);
      continue;
      EmojiCaptureReporter.f(this.lfP.eyh, 5, this.lfG.field_captureScene);
      this.lfG.a(EmojiInfo.b.yPL);
      continue;
      EmojiCaptureReporter.f(this.lfP.eyh, 1, this.lfG.field_captureScene);
      this.lfG.a(EmojiInfo.b.yPM);
      continue;
      EmojiCaptureReporter.f(this.lfP.eyh, 4, this.lfG.field_captureScene);
      this.lfG.a(EmojiInfo.b.yPO);
      continue;
      EmojiCaptureReporter.f(this.lfP.eyh, 2, this.lfG.field_captureScene);
      this.lfG.a(EmojiInfo.b.yPP);
      continue;
      EmojiCaptureReporter.f(this.lfP.eyh, 6, this.lfG.field_captureScene);
      this.lfG.a(EmojiInfo.b.yPQ);
      continue;
      EmojiCaptureReporter.f(this.lfP.eyh, 10, this.lfG.field_captureScene);
      this.lfG.a(EmojiInfo.b.yPR);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.e.h.2
 * JD-Core Version:    0.7.0.1
 */