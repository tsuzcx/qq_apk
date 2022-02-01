package com.tencent.mm.emoji.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.a.l.b;
import com.tencent.mm.emoji.a.m;
import com.tencent.mm.emoji.loader.c.h;
import com.tencent.mm.loader.g.j;
import com.tencent.mm.model.v;
import com.tencent.mm.plugin.emoji.b.d;
import com.tencent.mm.plugin.emojicapture.api.EmojiCaptureReporter;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.be;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.storage.emotion.EmojiInfo.a;
import com.tencent.mm.storage.emotion.EmojiInfo.b;
import com.tencent.mm.storage.emotion.f;
import d.g.b.p;
import d.g.b.q;
import d.z;

@d.l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/emoji/upload/EmojiCaptureUploadTask;", "Lcom/tencent/mm/loader/loader/IWorkTask;", "emojiInfo", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "(Lcom/tencent/mm/storage/emotion/EmojiInfo;)V", "TAG", "", "getEmojiInfo", "()Lcom/tencent/mm/storage/emotion/EmojiInfo;", "isWxam", "", "()Z", "timeEnter", "", "getTimeEnter", "()J", "uploadCost", "getUploadCost", "setUploadCost", "(J)V", "call", "", "handleFail", "errorCode", "", "handleSuccess", "gifMd5", "uniqueId", "plugin-emojisdk_release"})
public final class c
  extends com.tencent.mm.loader.g.c
{
  final String TAG;
  final EmojiInfo glt;
  final long gsp;
  long gsq;
  final boolean gsr;
  
  public c(EmojiInfo paramEmojiInfo)
  {
    AppMethodBeat.i(105776);
    this.glt = paramEmojiInfo;
    this.TAG = "MicroMsg.EmojiCaptureUploadTask";
    this.gsp = this.glt.field_captureEnterTime;
    this.gsr = this.glt.fxt();
    AppMethodBeat.o(105776);
  }
  
  public final String aeW()
  {
    AppMethodBeat.i(105775);
    long l = this.gsp;
    AppMethodBeat.o(105775);
    return String.valueOf(l);
  }
  
  public final void call()
  {
    AppMethodBeat.i(105774);
    final long l = bu.fpO();
    new com.tencent.mm.emoji.a.l(this.glt, (l.b)new a(this, l));
    AppMethodBeat.o(105774);
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/emoji/upload/EmojiCaptureUploadTask$call$1", "Lcom/tencent/mm/emoji/model/EmojiUploadLogic$EmojiUploadCallback;", "uploadCallback", "", "errorCode", "", "gifMd5", "", "activityId", "plugin-emojisdk_release"})
  public static final class a
    implements l.b
  {
    a(long paramLong) {}
    
    public final void x(int paramInt, String paramString)
    {
      AppMethodBeat.i(105772);
      ae.i(this.gss.TAG, "uploadCallback: " + paramInt + ", " + paramString);
      this.gss.gsq = bu.DD(l);
      Object localObject1;
      if (paramInt == 0)
      {
        localObject1 = this.gss;
        paramInt = ((c)localObject1).glt.field_captureScene;
        EmojiCaptureReporter.f(((c)localObject1).gsp, ((c)localObject1).gsq, paramInt);
        com.tencent.mm.plugin.report.service.g.yxI.f(10431, new Object[] { Integer.valueOf(7), ((c)localObject1).glt.Lj(), ((c)localObject1).glt.field_designerID, ((c)localObject1).glt.afK(), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(((c)localObject1).glt.getSize()), v.aAC(), ((c)localObject1).glt.field_activityid });
        if ((((c)localObject1).gsr) && (!m.afp()))
        {
          ae.w(((c)localObject1).TAG, "upload wxam but not decode, load gif");
          localObject2 = h.glA;
          h.d(((c)localObject1).glt, (d.g.a.b)new c.b((c)localObject1, paramString));
          AppMethodBeat.o(105772);
          return;
        }
        ((c)localObject1).a(j.hiy);
        Object localObject2 = b.gsl;
        b.b(((c)localObject1).gsp, true, paramString);
        AppMethodBeat.o(105772);
        return;
      }
      paramString = this.gss;
      paramString.glt.a(EmojiInfo.a.Jiv);
      int i = paramString.glt.field_captureScene;
      switch (paramInt)
      {
      default: 
        EmojiCaptureReporter.f(paramString.gsp, 3, i);
        paramString.glt.a(EmojiInfo.b.JiD);
      }
      for (;;)
      {
        localObject1 = com.tencent.mm.kernel.g.ad(d.class);
        p.g(localObject1, "MMKernel.plugin(IPluginEmoji::class.java)");
        localObject1 = ((d)localObject1).getEmojiStorageMgr();
        p.g(localObject1, "MMKernel.plugin(IPluginE…ass.java).emojiStorageMgr");
        ((be)localObject1).bJU().K(paramString.glt);
        localObject1 = b.gsl;
        b.b(paramString.gsp, false, null);
        paramString.a(j.hiz);
        AppMethodBeat.o(105772);
        return;
        EmojiCaptureReporter.f(paramString.gsp, 7, i);
        paramString.glt.a(EmojiInfo.b.Jiy);
        continue;
        EmojiCaptureReporter.f(paramString.gsp, 8, i);
        paramString.glt.a(EmojiInfo.b.Jiz);
        continue;
        EmojiCaptureReporter.f(paramString.gsp, 9, i);
        paramString.glt.a(EmojiInfo.b.JiA);
        continue;
        EmojiCaptureReporter.f(paramString.gsp, 5, i);
        paramString.glt.a(EmojiInfo.b.JiB);
        continue;
        EmojiCaptureReporter.f(paramString.gsp, 1, i);
        paramString.glt.a(EmojiInfo.b.JiC);
        continue;
        EmojiCaptureReporter.f(paramString.gsp, 4, i);
        paramString.glt.a(EmojiInfo.b.JiE);
        continue;
        EmojiCaptureReporter.f(paramString.gsp, 2, i);
        paramString.glt.a(EmojiInfo.b.JiF);
        continue;
        EmojiCaptureReporter.f(paramString.gsp, 6, i);
        paramString.glt.a(EmojiInfo.b.JiG);
        continue;
        EmojiCaptureReporter.f(paramString.gsp, 10, i);
        paramString.glt.a(EmojiInfo.b.JiH);
        continue;
        EmojiCaptureReporter.f(paramString.gsp, 3, i);
        paramString.glt.a(EmojiInfo.b.JiH);
      }
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "", "invoke"})
  static final class b
    extends q
    implements d.g.a.b<Boolean, z>
  {
    b(c paramc, String paramString)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.emoji.c.c
 * JD-Core Version:    0.7.0.1
 */