package com.tencent.mm.emoji.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.a.l.b;
import com.tencent.mm.emoji.a.m;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.emoji.b.d;
import com.tencent.mm.plugin.emojicapture.api.EmojiCaptureReporter;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.az;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.storage.emotion.EmojiInfo.a;
import com.tencent.mm.storage.emotion.EmojiInfo.b;
import com.tencent.mm.storage.emotion.f;
import d.g.b.k;
import d.y;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/emoji/upload/EmojiCaptureUploadTask;", "Lcom/tencent/mm/loader/loader/IWorkTask;", "emojiInfo", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "(Lcom/tencent/mm/storage/emotion/EmojiInfo;)V", "TAG", "", "getEmojiInfo", "()Lcom/tencent/mm/storage/emotion/EmojiInfo;", "isWxam", "", "()Z", "timeEnter", "", "getTimeEnter", "()J", "uploadCost", "getUploadCost", "setUploadCost", "(J)V", "call", "", "handleFail", "errorCode", "", "handleSuccess", "gifMd5", "uniqueId", "plugin-emojisdk_release"})
public final class c
  extends com.tencent.mm.loader.g.c
{
  final String TAG;
  final EmojiInfo fPB;
  final long fWr;
  long fWs;
  final boolean fWt;
  
  public c(EmojiInfo paramEmojiInfo)
  {
    AppMethodBeat.i(105776);
    this.fPB = paramEmojiInfo;
    this.TAG = "MicroMsg.EmojiCaptureUploadTask";
    this.fWr = this.fPB.field_captureEnterTime;
    this.fWt = this.fPB.fxK();
    AppMethodBeat.o(105776);
  }
  
  public final String acg()
  {
    AppMethodBeat.i(105775);
    long l = this.fWr;
    AppMethodBeat.o(105775);
    return String.valueOf(l);
  }
  
  public final void call()
  {
    AppMethodBeat.i(105774);
    final long l = bs.eWj();
    new com.tencent.mm.emoji.a.l(this.fPB, (l.b)new a(this, l));
    AppMethodBeat.o(105774);
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/emoji/upload/EmojiCaptureUploadTask$call$1", "Lcom/tencent/mm/emoji/model/EmojiUploadLogic$EmojiUploadCallback;", "uploadCallback", "", "errorCode", "", "gifMd5", "", "activityId", "plugin-emojisdk_release"})
  public static final class a
    implements l.b
  {
    a(long paramLong) {}
    
    public final void x(int paramInt, String paramString)
    {
      AppMethodBeat.i(105772);
      ac.i(this.fWu.TAG, "uploadCallback: " + paramInt + ", " + paramString);
      this.fWu.fWs = bs.Ap(l);
      Object localObject1;
      if (paramInt == 0)
      {
        localObject1 = this.fWu;
        paramInt = ((c)localObject1).fPB.field_captureScene;
        EmojiCaptureReporter.f(((c)localObject1).fWr, ((c)localObject1).fWs, paramInt);
        com.tencent.mm.plugin.report.service.h.wUl.f(10431, new Object[] { Integer.valueOf(7), ((c)localObject1).fPB.JC(), ((c)localObject1).fPB.field_designerID, ((c)localObject1).fPB.azp(), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(((c)localObject1).fPB.getSize()), u.axw(), ((c)localObject1).fPB.field_activityid });
        if ((((c)localObject1).fWt) && (!m.acx()))
        {
          ac.w(((c)localObject1).TAG, "upload wxam but not decode, load gif");
          localObject2 = com.tencent.mm.emoji.loader.c.h.fPI;
          com.tencent.mm.emoji.loader.c.h.d(((c)localObject1).fPB, (d.g.a.b)new c.b((c)localObject1, paramString));
          AppMethodBeat.o(105772);
          return;
        }
        ((c)localObject1).a(com.tencent.mm.loader.g.h.gLN);
        Object localObject2 = b.fWn;
        b.b(((c)localObject1).fWr, true, paramString);
        AppMethodBeat.o(105772);
        return;
      }
      paramString = this.fWu;
      paramString.fPB.a(EmojiInfo.a.Haz);
      int i = paramString.fPB.field_captureScene;
      switch (paramInt)
      {
      default: 
        EmojiCaptureReporter.f(paramString.fWr, 3, i);
        paramString.fPB.a(EmojiInfo.b.HaH);
      }
      for (;;)
      {
        localObject1 = g.ad(d.class);
        k.g(localObject1, "MMKernel.plugin(IPluginEmoji::class.java)");
        localObject1 = ((d)localObject1).getEmojiStorageMgr();
        k.g(localObject1, "MMKernel.plugin(IPluginE…ass.java).emojiStorageMgr");
        ((az)localObject1).bEN().L(paramString.fPB);
        localObject1 = b.fWn;
        b.b(paramString.fWr, false, null);
        paramString.a(com.tencent.mm.loader.g.h.gLO);
        AppMethodBeat.o(105772);
        return;
        EmojiCaptureReporter.f(paramString.fWr, 7, i);
        paramString.fPB.a(EmojiInfo.b.HaC);
        continue;
        EmojiCaptureReporter.f(paramString.fWr, 8, i);
        paramString.fPB.a(EmojiInfo.b.HaD);
        continue;
        EmojiCaptureReporter.f(paramString.fWr, 9, i);
        paramString.fPB.a(EmojiInfo.b.HaE);
        continue;
        EmojiCaptureReporter.f(paramString.fWr, 5, i);
        paramString.fPB.a(EmojiInfo.b.HaF);
        continue;
        EmojiCaptureReporter.f(paramString.fWr, 1, i);
        paramString.fPB.a(EmojiInfo.b.HaG);
        continue;
        EmojiCaptureReporter.f(paramString.fWr, 4, i);
        paramString.fPB.a(EmojiInfo.b.HaI);
        continue;
        EmojiCaptureReporter.f(paramString.fWr, 2, i);
        paramString.fPB.a(EmojiInfo.b.HaJ);
        continue;
        EmojiCaptureReporter.f(paramString.fWr, 6, i);
        paramString.fPB.a(EmojiInfo.b.HaK);
        continue;
        EmojiCaptureReporter.f(paramString.fWr, 10, i);
        paramString.fPB.a(EmojiInfo.b.HaL);
        continue;
        EmojiCaptureReporter.f(paramString.fWr, 3, i);
        paramString.fPB.a(EmojiInfo.b.HaL);
      }
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "", "invoke"})
  static final class b
    extends d.g.b.l
    implements d.g.a.b<Boolean, y>
  {
    b(c paramc, String paramString)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.emoji.c.c
 * JD-Core Version:    0.7.0.1
 */