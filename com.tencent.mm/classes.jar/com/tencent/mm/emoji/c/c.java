package com.tencent.mm.emoji.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.a.k.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.emoji.b.d;
import com.tencent.mm.plugin.emojicapture.api.EmojiCaptureReporter;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.aw;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.storage.emotion.EmojiInfo.a;
import com.tencent.mm.storage.emotion.EmojiInfo.b;
import com.tencent.mm.storage.emotion.f;
import d.y;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/emoji/upload/EmojiCaptureUploadTask;", "Lcom/tencent/mm/loader/loader/IWorkTask;", "emojiInfo", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "(Lcom/tencent/mm/storage/emotion/EmojiInfo;)V", "TAG", "", "getEmojiInfo", "()Lcom/tencent/mm/storage/emotion/EmojiInfo;", "isWxam", "", "()Z", "timeEnter", "", "getTimeEnter", "()J", "uploadCost", "getUploadCost", "setUploadCost", "(J)V", "call", "", "handleFail", "errorCode", "", "handleSuccess", "gifMd5", "uniqueId", "plugin-emojisdk_release"})
public final class c
  extends com.tencent.mm.loader.g.c
{
  final String TAG;
  final EmojiInfo fLP;
  final long fSw;
  long fSx;
  final boolean fSy;
  
  public c(EmojiInfo paramEmojiInfo)
  {
    AppMethodBeat.i(105776);
    this.fLP = paramEmojiInfo;
    this.TAG = "MicroMsg.EmojiCaptureUploadTask";
    this.fSw = this.fLP.field_captureEnterTime;
    this.fSy = this.fLP.fZS();
    AppMethodBeat.o(105776);
  }
  
  public final String abi()
  {
    AppMethodBeat.i(105775);
    long l = this.fSw;
    AppMethodBeat.o(105775);
    return String.valueOf(l);
  }
  
  public final void call()
  {
    AppMethodBeat.i(105774);
    final long l = bt.eGO();
    new com.tencent.mm.emoji.a.k(this.fLP, (k.b)new a(this, l));
    AppMethodBeat.o(105774);
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/emoji/upload/EmojiCaptureUploadTask$call$1", "Lcom/tencent/mm/emoji/model/EmojiUploadLogic$EmojiUploadCallback;", "uploadCallback", "", "errorCode", "", "gifMd5", "", "activityId", "plugin-emojisdk_release"})
  public static final class a
    implements k.b
  {
    a(long paramLong) {}
    
    public final void x(int paramInt, String paramString)
    {
      AppMethodBeat.i(105772);
      ad.i(this.fSz.TAG, "uploadCallback: " + paramInt + ", " + paramString);
      this.fSz.fSx = bt.vM(l);
      Object localObject1;
      if (paramInt == 0)
      {
        localObject1 = this.fSz;
        paramInt = ((c)localObject1).fLP.field_captureScene;
        EmojiCaptureReporter.f(((c)localObject1).fSw, ((c)localObject1).fSx, paramInt);
        com.tencent.mm.plugin.report.service.h.vKh.f(10431, new Object[] { Integer.valueOf(7), ((c)localObject1).fLP.JS(), ((c)localObject1).fLP.field_designerID, ((c)localObject1).fLP.asy(), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(((c)localObject1).fLP.getSize()), u.aqG(), ((c)localObject1).fLP.field_activityid });
        if ((((c)localObject1).fSy) && (!com.tencent.mm.emoji.a.l.aby()))
        {
          ad.w(((c)localObject1).TAG, "upload wxam but not decode, load gif");
          localObject2 = com.tencent.mm.emoji.loader.c.h.fLW;
          com.tencent.mm.emoji.loader.c.h.d(((c)localObject1).fLP, (d.g.a.b)new c.b((c)localObject1, paramString));
          AppMethodBeat.o(105772);
          return;
        }
        ((c)localObject1).a(com.tencent.mm.loader.g.h.gla);
        Object localObject2 = b.fSs;
        b.b(((c)localObject1).fSw, true, paramString);
        AppMethodBeat.o(105772);
        return;
      }
      paramString = this.fSz;
      paramString.fLP.a(EmojiInfo.a.FBz);
      int i = paramString.fLP.field_captureScene;
      switch (paramInt)
      {
      default: 
        EmojiCaptureReporter.f(paramString.fSw, 3, i);
        paramString.fLP.a(EmojiInfo.b.FBH);
      }
      for (;;)
      {
        localObject1 = g.ad(d.class);
        d.g.b.k.g(localObject1, "MMKernel.plugin(IPluginEmoji::class.java)");
        localObject1 = ((d)localObject1).getEmojiStorageMgr();
        d.g.b.k.g(localObject1, "MMKernel.plugin(IPluginE…ass.java).emojiStorageMgr");
        ((aw)localObject1).bxR().L(paramString.fLP);
        localObject1 = b.fSs;
        b.b(paramString.fSw, false, null);
        paramString.a(com.tencent.mm.loader.g.h.glb);
        AppMethodBeat.o(105772);
        return;
        EmojiCaptureReporter.f(paramString.fSw, 7, i);
        paramString.fLP.a(EmojiInfo.b.FBC);
        continue;
        EmojiCaptureReporter.f(paramString.fSw, 8, i);
        paramString.fLP.a(EmojiInfo.b.FBD);
        continue;
        EmojiCaptureReporter.f(paramString.fSw, 9, i);
        paramString.fLP.a(EmojiInfo.b.FBE);
        continue;
        EmojiCaptureReporter.f(paramString.fSw, 5, i);
        paramString.fLP.a(EmojiInfo.b.FBF);
        continue;
        EmojiCaptureReporter.f(paramString.fSw, 1, i);
        paramString.fLP.a(EmojiInfo.b.FBG);
        continue;
        EmojiCaptureReporter.f(paramString.fSw, 4, i);
        paramString.fLP.a(EmojiInfo.b.FBI);
        continue;
        EmojiCaptureReporter.f(paramString.fSw, 2, i);
        paramString.fLP.a(EmojiInfo.b.FBJ);
        continue;
        EmojiCaptureReporter.f(paramString.fSw, 6, i);
        paramString.fLP.a(EmojiInfo.b.FBK);
        continue;
        EmojiCaptureReporter.f(paramString.fSw, 10, i);
        paramString.fLP.a(EmojiInfo.b.FBL);
        continue;
        EmojiCaptureReporter.f(paramString.fSw, 3, i);
        paramString.fLP.a(EmojiInfo.b.FBL);
      }
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "", "invoke"})
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.emoji.c.c
 * JD-Core Version:    0.7.0.1
 */