package com.tencent.mm.emoji.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.b.m;
import com.tencent.mm.emoji.b.m.b;
import com.tencent.mm.emoji.b.n;
import com.tencent.mm.kernel.g;
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

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/emoji/upload/EmojiCaptureUploadTask;", "Lcom/tencent/mm/loader/loader/IWorkTask;", "emojiInfo", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "(Lcom/tencent/mm/storage/emotion/EmojiInfo;)V", "TAG", "", "getEmojiInfo", "()Lcom/tencent/mm/storage/emotion/EmojiInfo;", "isWxam", "", "()Z", "timeEnter", "", "getTimeEnter", "()J", "uploadCost", "getUploadCost", "setUploadCost", "(J)V", "call", "", "handleFail", "errorCode", "", "handleSuccess", "gifMd5", "uniqueId", "plugin-emojisdk_release"})
public final class c
  extends com.tencent.mm.loader.g.c
{
  final String TAG;
  final EmojiInfo gWm;
  long hdA;
  final boolean hdB;
  final long hdz;
  
  public c(EmojiInfo paramEmojiInfo)
  {
    AppMethodBeat.i(105776);
    this.gWm = paramEmojiInfo;
    this.TAG = "MicroMsg.EmojiCaptureUploadTask";
    this.hdz = this.gWm.field_captureEnterTime;
    this.hdB = this.gWm.hRD();
    AppMethodBeat.o(105776);
  }
  
  public final String auK()
  {
    AppMethodBeat.i(105775);
    long l = this.hdz;
    AppMethodBeat.o(105775);
    return String.valueOf(l);
  }
  
  public final void call()
  {
    AppMethodBeat.i(105774);
    final long l = Util.nowMilliSecond();
    new m(this.gWm, (m.b)new a(this, l));
    AppMethodBeat.o(105774);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/emoji/upload/EmojiCaptureUploadTask$call$1", "Lcom/tencent/mm/emoji/model/EmojiUploadLogic$EmojiUploadCallback;", "uploadCallback", "", "errorCode", "", "gifMd5", "", "activityId", "plugin-emojisdk_release"})
  public static final class a
    implements m.b
  {
    a(long paramLong) {}
    
    public final void z(int paramInt, String paramString)
    {
      AppMethodBeat.i(105772);
      Log.i(this.hdC.TAG, "uploadCallback: " + paramInt + ", " + paramString);
      this.hdC.hdA = Util.milliSecondsToNow(l);
      Object localObject1;
      if (paramInt == 0)
      {
        localObject1 = this.hdC;
        paramInt = ((c)localObject1).gWm.field_captureScene;
        EmojiCaptureReporter.f(((c)localObject1).hdz, ((c)localObject1).hdA, paramInt);
        com.tencent.mm.plugin.report.service.h.CyF.a(10431, new Object[] { Integer.valueOf(7), ((c)localObject1).gWm.getMd5(), ((c)localObject1).gWm.field_designerID, ((c)localObject1).gWm.avy(), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(((c)localObject1).gWm.getSize()), z.aTY(), ((c)localObject1).gWm.field_activityid });
        if ((((c)localObject1).hdB) && (!n.avd()))
        {
          Log.w(((c)localObject1).TAG, "upload wxam but not decode, load gif");
          localObject2 = com.tencent.mm.emoji.loader.c.h.gWs;
          com.tencent.mm.emoji.loader.c.h.d(((c)localObject1).gWm, (kotlin.g.a.b)new c.b((c)localObject1, paramString));
          AppMethodBeat.o(105772);
          return;
        }
        ((c)localObject1).a(j.ibw);
        Object localObject2 = b.hdv;
        b.b(((c)localObject1).hdz, true, paramString);
        AppMethodBeat.o(105772);
        return;
      }
      paramString = this.hdC;
      paramString.gWm.a(EmojiInfo.a.Osn);
      int i = paramString.gWm.field_captureScene;
      switch (paramInt)
      {
      default: 
        EmojiCaptureReporter.f(paramString.hdz, 3, i);
        paramString.gWm.a(EmojiInfo.b.Osv);
      }
      for (;;)
      {
        localObject1 = g.ah(d.class);
        p.g(localObject1, "MMKernel.plugin(IPluginEmoji::class.java)");
        localObject1 = ((d)localObject1).getEmojiStorageMgr();
        p.g(localObject1, "MMKernel.plugin(IPluginE…ass.java).emojiStorageMgr");
        ((bj)localObject1).cgN().L(paramString.gWm);
        localObject1 = b.hdv;
        b.b(paramString.hdz, false, null);
        paramString.a(j.ibx);
        AppMethodBeat.o(105772);
        return;
        EmojiCaptureReporter.f(paramString.hdz, 7, i);
        paramString.gWm.a(EmojiInfo.b.Osq);
        continue;
        EmojiCaptureReporter.f(paramString.hdz, 8, i);
        paramString.gWm.a(EmojiInfo.b.Osr);
        continue;
        EmojiCaptureReporter.f(paramString.hdz, 9, i);
        paramString.gWm.a(EmojiInfo.b.Oss);
        continue;
        EmojiCaptureReporter.f(paramString.hdz, 5, i);
        paramString.gWm.a(EmojiInfo.b.Ost);
        continue;
        EmojiCaptureReporter.f(paramString.hdz, 1, i);
        paramString.gWm.a(EmojiInfo.b.Osu);
        continue;
        EmojiCaptureReporter.f(paramString.hdz, 4, i);
        paramString.gWm.a(EmojiInfo.b.Osw);
        continue;
        EmojiCaptureReporter.f(paramString.hdz, 2, i);
        paramString.gWm.a(EmojiInfo.b.Osx);
        continue;
        EmojiCaptureReporter.f(paramString.hdz, 6, i);
        paramString.gWm.a(EmojiInfo.b.Osy);
        continue;
        EmojiCaptureReporter.f(paramString.hdz, 10, i);
        paramString.gWm.a(EmojiInfo.b.Osz);
        continue;
        EmojiCaptureReporter.f(paramString.hdz, 3, i);
        paramString.gWm.a(EmojiInfo.b.Osz);
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "", "invoke"})
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.emoji.d.c
 * JD-Core Version:    0.7.0.1
 */