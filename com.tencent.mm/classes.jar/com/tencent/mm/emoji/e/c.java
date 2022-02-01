package com.tencent.mm.emoji.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.b.c.g;
import com.tencent.mm.emoji.c.l;
import com.tencent.mm.emoji.c.n;
import com.tencent.mm.emoji.c.n.b;
import com.tencent.mm.emoji.c.o;
import com.tencent.mm.loader.f.i;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.emoji.c.d;
import com.tencent.mm.plugin.emojicapture.api.EmojiCaptureReporter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.bl;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.storage.emotion.EmojiInfo.a;
import com.tencent.mm.storage.emotion.EmojiInfo.b;
import com.tencent.mm.storage.emotion.f;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/emoji/upload/EmojiCaptureUploadTask;", "Lcom/tencent/mm/loader/loader/IWorkTask;", "emojiInfo", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "(Lcom/tencent/mm/storage/emotion/EmojiInfo;)V", "TAG", "", "getEmojiInfo", "()Lcom/tencent/mm/storage/emotion/EmojiInfo;", "isWxam", "", "()Z", "timeEnter", "", "getTimeEnter", "()J", "uploadCost", "getUploadCost", "setUploadCost", "(J)V", "call", "", "handleFail", "errorCode", "", "handleSuccess", "gifMd5", "uniqueId", "plugin-emojisdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
  extends com.tencent.mm.loader.f.c
{
  final String TAG;
  final EmojiInfo mgK;
  final long mnX;
  long mnY;
  final boolean mnZ;
  
  public c(EmojiInfo paramEmojiInfo)
  {
    AppMethodBeat.i(105776);
    this.mgK = paramEmojiInfo;
    this.TAG = "MicroMsg.EmojiCaptureUploadTask";
    this.mnX = this.mgK.field_captureEnterTime;
    this.mnZ = this.mgK.kMg();
    AppMethodBeat.o(105776);
  }
  
  public final String aUE()
  {
    AppMethodBeat.i(105775);
    long l = this.mnX;
    AppMethodBeat.o(105775);
    return String.valueOf(l);
  }
  
  public final void call()
  {
    AppMethodBeat.i(105774);
    final long l = Util.nowMilliSecond();
    new n(this.mgK, (n.b)new a(this, l));
    AppMethodBeat.o(105774);
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/emoji/upload/EmojiCaptureUploadTask$call$1", "Lcom/tencent/mm/emoji/model/EmojiUploadLogic$EmojiUploadCallback;", "uploadCallback", "", "errorCode", "", "gifMd5", "", "activityId", "plugin-emojisdk_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    implements n.b
  {
    a(c paramc, long paramLong) {}
    
    public final void A(int paramInt, String paramString)
    {
      AppMethodBeat.i(105772);
      Log.i(this.moa.TAG, "uploadCallback: " + paramInt + ", " + paramString);
      this.moa.mnY = Util.milliSecondsToNow(l);
      Object localObject1;
      if (paramInt == 0)
      {
        localObject1 = this.moa;
        paramInt = ((c)localObject1).mgK.field_captureScene;
        EmojiCaptureReporter.i(((c)localObject1).mnX, ((c)localObject1).mnY, paramInt);
        com.tencent.mm.plugin.report.service.h.OAn.b(10431, new Object[] { Integer.valueOf(7), ((c)localObject1).mgK.getMd5(), ((c)localObject1).mgK.field_designerID, ((c)localObject1).mgK.field_groupId, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(((c)localObject1).mgK.field_size), z.bAM(), ((c)localObject1).mgK.field_activityid });
        if ((((c)localObject1).mnZ) && (!o.aUV()))
        {
          Log.w(((c)localObject1).TAG, "upload wxam but not decode, load gif");
          localObject2 = g.mgQ;
          g.c(((c)localObject1).mgK, (kotlin.g.a.b)new c.b((c)localObject1, paramString));
          AppMethodBeat.o(105772);
          return;
        }
        ((c)localObject1).a(i.nrG);
        Object localObject2 = b.mnS;
        b.b(((c)localObject1).mnX, true, paramString);
        AppMethodBeat.o(105772);
        return;
      }
      paramString = this.moa;
      paramString.mgK.a(EmojiInfo.a.admi);
      int i = paramString.mgK.field_captureScene;
      switch (paramInt)
      {
      default: 
        EmojiCaptureReporter.h(paramString.mnX, 3, i);
        paramString.mgK.a(EmojiInfo.b.admq);
      }
      for (;;)
      {
        l.aUF().fi(true);
        ((d)com.tencent.mm.kernel.h.az(d.class)).getEmojiStorageMgr().adju.M(paramString.mgK);
        localObject1 = b.mnS;
        b.b(paramString.mnX, false, null);
        paramString.a(i.nrH);
        AppMethodBeat.o(105772);
        return;
        EmojiCaptureReporter.h(paramString.mnX, 7, i);
        paramString.mgK.a(EmojiInfo.b.adml);
        continue;
        EmojiCaptureReporter.h(paramString.mnX, 8, i);
        paramString.mgK.a(EmojiInfo.b.admm);
        continue;
        EmojiCaptureReporter.h(paramString.mnX, 9, i);
        paramString.mgK.a(EmojiInfo.b.admn);
        continue;
        EmojiCaptureReporter.h(paramString.mnX, 5, i);
        paramString.mgK.a(EmojiInfo.b.admo);
        continue;
        EmojiCaptureReporter.h(paramString.mnX, 1, i);
        paramString.mgK.a(EmojiInfo.b.admp);
        continue;
        EmojiCaptureReporter.h(paramString.mnX, 4, i);
        paramString.mgK.a(EmojiInfo.b.admr);
        continue;
        EmojiCaptureReporter.h(paramString.mnX, 2, i);
        paramString.mgK.a(EmojiInfo.b.adms);
        continue;
        EmojiCaptureReporter.h(paramString.mnX, 6, i);
        paramString.mgK.a(EmojiInfo.b.admt);
        continue;
        EmojiCaptureReporter.h(paramString.mnX, 10, i);
        paramString.mgK.a(EmojiInfo.b.admu);
        continue;
        EmojiCaptureReporter.h(paramString.mnX, 3, i);
        paramString.mgK.a(EmojiInfo.b.admu);
      }
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.b<Boolean, ah>
  {
    b(c paramc, String paramString)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.emoji.e.c
 * JD-Core Version:    0.7.0.1
 */