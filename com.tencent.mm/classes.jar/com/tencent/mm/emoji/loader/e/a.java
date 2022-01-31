package com.tencent.mm.emoji.loader.e;

import a.f.b.j;
import a.l;
import a.l.m;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.loader.c.b.b;
import com.tencent.mm.emoji.loader.d.h.a;
import com.tencent.mm.graphics.MMBitmapFactory;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.vfs.e;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/emoji/loader/task/EmojiCoverTask;", "Lcom/tencent/mm/emoji/loader/task/IEmojiLoadTask;", "Ljava/lang/Runnable;", "emojiInfo", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "(Lcom/tencent/mm/storage/emotion/EmojiInfo;)V", "dependRequest", "Lcom/tencent/mm/emoji/loader/request/Request;", "taskKey", "", "getTaskKey", "onResult", "", "success", "", "run", "plugin-emojisdk_release"})
public final class a
  extends c
  implements Runnable
{
  private final String ewc;
  private com.tencent.mm.emoji.loader.d.h<?> ewd;
  
  public a(EmojiInfo paramEmojiInfo)
  {
    super(paramEmojiInfo);
    AppMethodBeat.i(63220);
    this.ewc = (paramEmojiInfo.Al() + "_cover");
    AppMethodBeat.o(63220);
  }
  
  public final String Ox()
  {
    return this.ewc;
  }
  
  public final void cd(boolean paramBoolean)
  {
    AppMethodBeat.i(63219);
    com.tencent.mm.emoji.loader.d.h localh = this.ewd;
    if (localh != null) {
      localh.cancel();
    }
    super.cd(paramBoolean);
    AppMethodBeat.o(63219);
  }
  
  public final void run()
  {
    AppMethodBeat.i(63218);
    super.run();
    new com.tencent.mm.emoji.loader.c.b();
    EmojiInfo localEmojiInfo = this.evH;
    a.f.a.b localb = (a.f.a.b)new a.a(this);
    j.q(localEmojiInfo, "emojiInfo");
    Object localObject1 = com.tencent.mm.emoji.loader.a.b.evt;
    Object localObject2 = com.tencent.mm.emoji.loader.a.b.lK(localEmojiInfo.Al());
    int i;
    if (localObject2 != null)
    {
      i = 1;
      if (i == 0) {
        break label411;
      }
      ab.d("MicroMsg.EmojiCoverFetcher", "fetch: from cache " + localEmojiInfo.Al());
      localb.S(Boolean.TRUE);
    }
    label102:
    for (localObject1 = null;; localObject1 = (com.tencent.mm.emoji.loader.d.h)com.tencent.mm.emoji.loader.a.a(localEmojiInfo, false, (h.a)new b.b(localEmojiInfo, localb)))
    {
      this.ewd = ((com.tencent.mm.emoji.loader.d.h)localObject1);
      AppMethodBeat.o(63218);
      return;
      Object localObject3;
      if ((j.e(localEmojiInfo.avS(), String.valueOf(EmojiGroupInfo.yPd))) || (localEmojiInfo.getGroup() == EmojiGroupInfo.yPe) || (localEmojiInfo.getGroup() == EmojiInfo.yPl) || (localEmojiInfo.getGroup() == EmojiInfo.yPk))
      {
        localObject3 = localEmojiInfo.getName();
        localObject1 = localObject2;
        if (!bo.isNullOrNil((String)localObject3))
        {
          j.p(localObject3, "name");
          localObject1 = m.h((String)localObject3, ".png", "", false);
          localObject2 = ah.getContext();
          j.p(localObject2, "MMApplicationContext.getContext()");
          localObject2 = ((Context)localObject2).getResources();
          localObject1 = MMBitmapFactory.decodeResource((Resources)localObject2, ((Resources)localObject2).getIdentifier((String)localObject1, "drawable", ah.getPackageName()));
        }
      }
      for (;;)
      {
        label230:
        if (localObject1 != null)
        {
          localObject2 = com.tencent.mm.emoji.loader.a.b.evt;
          com.tencent.mm.emoji.loader.a.b.c(localEmojiInfo.Al(), (Bitmap)localObject1);
          i = 1;
          break;
          localObject1 = localObject2;
          if (e.cN(localEmojiInfo.dQC())) {
            if (e.avI(localEmojiInfo.dQC()) < 1024L)
            {
              ab.w("MicroMsg.EmojiCoverFetcher", "emoji thumb size is " + e.avI(localEmojiInfo.dQC()));
              e.deleteFile(localEmojiInfo.dQC());
              com.tencent.mm.plugin.report.service.h.qsU.cT(1062, 0);
              localObject1 = localObject2;
            }
            else
            {
              localObject1 = new BitmapFactory.Options();
              ((BitmapFactory.Options)localObject1).outWidth = 120;
              ((BitmapFactory.Options)localObject1).outHeight = 120;
              localObject2 = d.decodeFile(localEmojiInfo.dQC(), (BitmapFactory.Options)localObject1);
              if (localObject2 != null) {
                break label371;
              }
            }
          }
        }
      }
      for (;;)
      {
        i = 0;
        break;
        label371:
        if (((Bitmap)localObject2).getWidth() <= 120)
        {
          localObject1 = localObject2;
          if (((Bitmap)localObject2).getHeight() <= 120) {
            break label230;
          }
        }
        localObject2 = d.a((Bitmap)localObject2, 120, 120, false, true);
        localObject1 = localObject2;
        if (localObject2 != null) {
          break label230;
        }
      }
      if (!bo.isNullOrNil(localEmojiInfo.field_thumbUrl))
      {
        ab.i("MicroMsg.EmojiCoverFetcher", "loadDataImp: load by url " + localEmojiInfo.Al());
        localObject2 = new com.tencent.mm.plugin.emoji.d.a().tB(localEmojiInfo.field_thumbUrl);
        if (localObject2 != null) {}
        for (localObject1 = ((com.tencent.mm.at.a.d.b)localObject2).data;; localObject1 = null)
        {
          if (localObject1 == null) {
            break label531;
          }
          localObject1 = d.bT(((com.tencent.mm.at.a.d.b)localObject2).data);
          localObject3 = com.tencent.mm.emoji.loader.a.b.evt;
          com.tencent.mm.emoji.loader.a.b.c(localEmojiInfo.Al(), (Bitmap)localObject1);
          e.q(localEmojiInfo.dQC(), ((com.tencent.mm.at.a.d.b)localObject2).data);
          localb.S(Boolean.TRUE);
          break;
        }
        localb.S(Boolean.FALSE);
        break label102;
      }
      ab.i("MicroMsg.EmojiCoverFetcher", "loadDataImp: load by gif " + localEmojiInfo.Al());
      localObject1 = com.tencent.mm.emoji.loader.a.evk;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.emoji.loader.e.a
 * JD-Core Version:    0.7.0.1
 */