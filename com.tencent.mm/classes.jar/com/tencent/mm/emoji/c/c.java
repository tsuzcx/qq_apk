package com.tencent.mm.emoji.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.a.l.b;
import com.tencent.mm.emoji.a.m;
import com.tencent.mm.emoji.loader.c.h;
import com.tencent.mm.loader.g.j;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.emoji.b.d;
import com.tencent.mm.plugin.emojicapture.api.EmojiCaptureReporter;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.storage.emotion.EmojiInfo.a;
import com.tencent.mm.storage.emotion.EmojiInfo.b;
import com.tencent.mm.storage.emotion.f;
import d.g.b.p;
import d.g.b.q;
import d.z;

@d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/emoji/upload/EmojiCaptureUploadTask;", "Lcom/tencent/mm/loader/loader/IWorkTask;", "emojiInfo", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "(Lcom/tencent/mm/storage/emotion/EmojiInfo;)V", "TAG", "", "getEmojiInfo", "()Lcom/tencent/mm/storage/emotion/EmojiInfo;", "isWxam", "", "()Z", "timeEnter", "", "getTimeEnter", "()J", "uploadCost", "getUploadCost", "setUploadCost", "(J)V", "call", "", "handleFail", "errorCode", "", "handleSuccess", "gifMd5", "uniqueId", "plugin-emojisdk_release"})
public final class c
  extends com.tencent.mm.loader.g.c
{
  final String TAG;
  final EmojiInfo gjb;
  final long gpU;
  long gpV;
  final boolean gpW;
  
  public c(EmojiInfo paramEmojiInfo)
  {
    AppMethodBeat.i(105776);
    this.gjb = paramEmojiInfo;
    this.TAG = "MicroMsg.EmojiCaptureUploadTask";
    this.gpU = this.gjb.field_captureEnterTime;
    this.gpW = this.gjb.gzH();
    AppMethodBeat.o(105776);
  }
  
  public final String aeK()
  {
    AppMethodBeat.i(105775);
    long l = this.gpU;
    AppMethodBeat.o(105775);
    return String.valueOf(l);
  }
  
  public final void call()
  {
    AppMethodBeat.i(105774);
    final long l = bt.flT();
    new com.tencent.mm.emoji.a.l(this.gjb, (l.b)new a(this, l));
    AppMethodBeat.o(105774);
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/emoji/upload/EmojiCaptureUploadTask$call$1", "Lcom/tencent/mm/emoji/model/EmojiUploadLogic$EmojiUploadCallback;", "uploadCallback", "", "errorCode", "", "gifMd5", "", "activityId", "plugin-emojisdk_release"})
  public static final class a
    implements l.b
  {
    a(long paramLong) {}
    
    public final void x(int paramInt, String paramString)
    {
      AppMethodBeat.i(105772);
      ad.i(this.gpX.TAG, "uploadCallback: " + paramInt + ", " + paramString);
      this.gpX.gpV = bt.Df(l);
      Object localObject1;
      if (paramInt == 0)
      {
        localObject1 = this.gpX;
        paramInt = ((c)localObject1).gjb.field_captureScene;
        EmojiCaptureReporter.f(((c)localObject1).gpU, ((c)localObject1).gpV, paramInt);
        com.tencent.mm.plugin.report.service.g.yhR.f(10431, new Object[] { Integer.valueOf(7), ((c)localObject1).gjb.Lb(), ((c)localObject1).gjb.field_designerID, ((c)localObject1).gjb.afw(), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(((c)localObject1).gjb.getSize()), u.aAm(), ((c)localObject1).gjb.field_activityid });
        if ((((c)localObject1).gpW) && (!m.afb()))
        {
          ad.w(((c)localObject1).TAG, "upload wxam but not decode, load gif");
          localObject2 = h.gji;
          h.d(((c)localObject1).gjb, (d.g.a.b)new c.b((c)localObject1, paramString));
          AppMethodBeat.o(105772);
          return;
        }
        ((c)localObject1).a(j.hfK);
        Object localObject2 = b.gpQ;
        b.b(((c)localObject1).gpU, true, paramString);
        AppMethodBeat.o(105772);
        return;
      }
      paramString = this.gpX;
      paramString.gjb.a(EmojiInfo.a.INO);
      int i = paramString.gjb.field_captureScene;
      switch (paramInt)
      {
      default: 
        EmojiCaptureReporter.f(paramString.gpU, 3, i);
        paramString.gjb.a(EmojiInfo.b.INX);
      }
      for (;;)
      {
        localObject1 = com.tencent.mm.kernel.g.ad(d.class);
        p.g(localObject1, "MMKernel.plugin(IPluginEmoji::class.java)");
        localObject1 = ((d)localObject1).getEmojiStorageMgr();
        p.g(localObject1, "MMKernel.plugin(IPluginE…ass.java).emojiStorageMgr");
        ((bd)localObject1).bIW().K(paramString.gjb);
        localObject1 = b.gpQ;
        b.b(paramString.gpU, false, null);
        paramString.a(j.hfL);
        AppMethodBeat.o(105772);
        return;
        EmojiCaptureReporter.f(paramString.gpU, 7, i);
        paramString.gjb.a(EmojiInfo.b.INR);
        continue;
        EmojiCaptureReporter.f(paramString.gpU, 8, i);
        paramString.gjb.a(EmojiInfo.b.INS);
        continue;
        EmojiCaptureReporter.f(paramString.gpU, 9, i);
        paramString.gjb.a(EmojiInfo.b.INU);
        continue;
        EmojiCaptureReporter.f(paramString.gpU, 5, i);
        paramString.gjb.a(EmojiInfo.b.INV);
        continue;
        EmojiCaptureReporter.f(paramString.gpU, 1, i);
        paramString.gjb.a(EmojiInfo.b.INW);
        continue;
        EmojiCaptureReporter.f(paramString.gpU, 4, i);
        paramString.gjb.a(EmojiInfo.b.INY);
        continue;
        EmojiCaptureReporter.f(paramString.gpU, 2, i);
        paramString.gjb.a(EmojiInfo.b.INZ);
        continue;
        EmojiCaptureReporter.f(paramString.gpU, 6, i);
        paramString.gjb.a(EmojiInfo.b.IOa);
        continue;
        EmojiCaptureReporter.f(paramString.gpU, 10, i);
        paramString.gjb.a(EmojiInfo.b.IOb);
        continue;
        EmojiCaptureReporter.f(paramString.gpU, 3, i);
        paramString.gjb.a(EmojiInfo.b.IOb);
      }
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "", "invoke"})
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.emoji.c.c
 * JD-Core Version:    0.7.0.1
 */