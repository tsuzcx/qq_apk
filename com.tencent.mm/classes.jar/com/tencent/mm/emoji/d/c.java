package com.tencent.mm.emoji.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.b.k;
import com.tencent.mm.emoji.b.n;
import com.tencent.mm.emoji.b.n.b;
import com.tencent.mm.emoji.b.o;
import com.tencent.mm.loader.g.j;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.emoji.b.d;
import com.tencent.mm.plugin.emojicapture.api.EmojiCaptureReporter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.bj;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.storage.emotion.EmojiInfo.a;
import com.tencent.mm.storage.emotion.EmojiInfo.b;
import com.tencent.mm.storage.emotion.f;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/emoji/upload/EmojiCaptureUploadTask;", "Lcom/tencent/mm/loader/loader/IWorkTask;", "emojiInfo", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "(Lcom/tencent/mm/storage/emotion/EmojiInfo;)V", "TAG", "", "getEmojiInfo", "()Lcom/tencent/mm/storage/emotion/EmojiInfo;", "isWxam", "", "()Z", "timeEnter", "", "getTimeEnter", "()J", "uploadCost", "getUploadCost", "setUploadCost", "(J)V", "call", "", "handleFail", "errorCode", "", "handleSuccess", "gifMd5", "uniqueId", "plugin-emojisdk_release"})
public final class c
  extends com.tencent.mm.loader.g.c
{
  final String TAG;
  final EmojiInfo jHh;
  final long jPf;
  long jPg;
  final boolean jPh;
  
  public c(EmojiInfo paramEmojiInfo)
  {
    AppMethodBeat.i(105776);
    this.jHh = paramEmojiInfo;
    this.TAG = "MicroMsg.EmojiCaptureUploadTask";
    this.jPf = this.jHh.field_captureEnterTime;
    this.jPh = this.jHh.hBw();
    AppMethodBeat.o(105776);
  }
  
  public final String aBG()
  {
    AppMethodBeat.i(105775);
    long l = this.jPf;
    AppMethodBeat.o(105775);
    return String.valueOf(l);
  }
  
  public final void call()
  {
    AppMethodBeat.i(105774);
    final long l = Util.nowMilliSecond();
    new n(this.jHh, (n.b)new a(this, l));
    AppMethodBeat.o(105774);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/emoji/upload/EmojiCaptureUploadTask$call$1", "Lcom/tencent/mm/emoji/model/EmojiUploadLogic$EmojiUploadCallback;", "uploadCallback", "", "errorCode", "", "gifMd5", "", "activityId", "plugin-emojisdk_release"})
  public static final class a
    implements n.b
  {
    a(long paramLong) {}
    
    public final void A(int paramInt, String paramString)
    {
      AppMethodBeat.i(105772);
      Log.i(this.jPi.TAG, "uploadCallback: " + paramInt + ", " + paramString);
      this.jPi.jPg = Util.milliSecondsToNow(l);
      Object localObject1;
      if (paramInt == 0)
      {
        localObject1 = this.jPi;
        paramInt = ((c)localObject1).jHh.field_captureScene;
        EmojiCaptureReporter.g(((c)localObject1).jPf, ((c)localObject1).jPg, paramInt);
        com.tencent.mm.plugin.report.service.h.IzE.a(10431, new Object[] { Integer.valueOf(7), ((c)localObject1).jHh.getMd5(), ((c)localObject1).jHh.field_designerID, ((c)localObject1).jHh.aCt(), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(((c)localObject1).jHh.getSize()), z.bcZ(), ((c)localObject1).jHh.field_activityid });
        if ((((c)localObject1).jPh) && (!o.aBY()))
        {
          Log.w(((c)localObject1).TAG, "upload wxam but not decode, load gif");
          localObject2 = com.tencent.mm.emoji.loader.c.h.jHn;
          com.tencent.mm.emoji.loader.c.h.c(((c)localObject1).jHh, (kotlin.g.a.b)new c.b((c)localObject1, paramString));
          AppMethodBeat.o(105772);
          return;
        }
        ((c)localObject1).a(j.kQd);
        Object localObject2 = b.jPc;
        b.b(((c)localObject1).jPf, true, paramString);
        AppMethodBeat.o(105772);
        return;
      }
      paramString = this.jPi;
      paramString.jHh.a(EmojiInfo.a.VIm);
      int i = paramString.jHh.field_captureScene;
      switch (paramInt)
      {
      default: 
        EmojiCaptureReporter.f(paramString.jPf, 3, i);
        paramString.jHh.a(EmojiInfo.b.VIu);
      }
      for (;;)
      {
        k.aBH().ew(true);
        localObject1 = com.tencent.mm.kernel.h.ag(d.class);
        p.j(localObject1, "MMKernel.plugin(IPluginEmoji::class.java)");
        localObject1 = ((d)localObject1).getEmojiStorageMgr();
        p.j(localObject1, "MMKernel.plugin(IPluginE…ass.java).emojiStorageMgr");
        ((bj)localObject1).ctY().M(paramString.jHh);
        localObject1 = b.jPc;
        b.b(paramString.jPf, false, null);
        paramString.a(j.kQe);
        AppMethodBeat.o(105772);
        return;
        EmojiCaptureReporter.f(paramString.jPf, 7, i);
        paramString.jHh.a(EmojiInfo.b.VIp);
        continue;
        EmojiCaptureReporter.f(paramString.jPf, 8, i);
        paramString.jHh.a(EmojiInfo.b.VIq);
        continue;
        EmojiCaptureReporter.f(paramString.jPf, 9, i);
        paramString.jHh.a(EmojiInfo.b.VIr);
        continue;
        EmojiCaptureReporter.f(paramString.jPf, 5, i);
        paramString.jHh.a(EmojiInfo.b.VIs);
        continue;
        EmojiCaptureReporter.f(paramString.jPf, 1, i);
        paramString.jHh.a(EmojiInfo.b.VIt);
        continue;
        EmojiCaptureReporter.f(paramString.jPf, 4, i);
        paramString.jHh.a(EmojiInfo.b.VIv);
        continue;
        EmojiCaptureReporter.f(paramString.jPf, 2, i);
        paramString.jHh.a(EmojiInfo.b.VIw);
        continue;
        EmojiCaptureReporter.f(paramString.jPf, 6, i);
        paramString.jHh.a(EmojiInfo.b.VIx);
        continue;
        EmojiCaptureReporter.f(paramString.jPf, 10, i);
        paramString.jHh.a(EmojiInfo.b.VIy);
        continue;
        EmojiCaptureReporter.f(paramString.jPf, 3, i);
        paramString.jHh.a(EmojiInfo.b.VIy);
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "", "invoke"})
  static final class b
    extends q
    implements kotlin.g.a.b<Boolean, x>
  {
    b(c paramc, String paramString)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.emoji.d.c
 * JD-Core Version:    0.7.0.1
 */