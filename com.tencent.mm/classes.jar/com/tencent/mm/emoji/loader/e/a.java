package com.tencent.mm.emoji.loader.e;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.loader.c.c.b;
import com.tencent.mm.emoji.loader.c.f;
import com.tencent.mm.emoji.loader.d.i;
import com.tencent.mm.graphics.MMBitmapFactory;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.storage.emotion.EmojiInfo.a;
import com.tencent.mm.vfs.u;
import java.util.List;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/emoji/loader/task/EmojiCoverTask;", "Lcom/tencent/mm/emoji/loader/task/IEmojiLoadTask;", "Ljava/lang/Runnable;", "emojiInfo", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "(Lcom/tencent/mm/storage/emotion/EmojiInfo;)V", "dependRequest", "Lcom/tencent/mm/emoji/loader/request/Request;", "taskKey", "", "getTaskKey", "onResult", "", "success", "", "run", "plugin-emojisdk_release"})
public final class a
  extends c
  implements Runnable
{
  private final String jHH;
  private i<?> jHI;
  
  public a(EmojiInfo paramEmojiInfo)
  {
    super(paramEmojiInfo);
    AppMethodBeat.i(105476);
    this.jHH = (paramEmojiInfo.getMd5() + "_cover");
    AppMethodBeat.o(105476);
  }
  
  public final String aBF()
  {
    return this.jHH;
  }
  
  public final void ep(boolean paramBoolean)
  {
    AppMethodBeat.i(105475);
    i locali = this.jHI;
    if (locali != null) {
      locali.cancel();
    }
    super.ep(paramBoolean);
    AppMethodBeat.o(105475);
  }
  
  public final void run()
  {
    AppMethodBeat.i(105474);
    super.run();
    com.tencent.mm.emoji.loader.c.c localc = new com.tencent.mm.emoji.loader.c.c();
    EmojiInfo localEmojiInfo = this.jHh;
    kotlin.g.a.b localb = (kotlin.g.a.b)new a.a(this);
    p.k(localEmojiInfo, "emojiInfo");
    Object localObject1 = com.tencent.mm.emoji.loader.a.b.jGQ;
    localObject1 = com.tencent.mm.emoji.loader.a.b.LI(localEmojiInfo.getMd5());
    int i;
    label103:
    Object localObject2;
    if (localObject1 != null)
    {
      i = 1;
      if (i != 0)
      {
        Log.d("MicroMsg.EmojiCoverFetcher", "fetch: from cache " + localEmojiInfo.getMd5());
        localb.invoke(Boolean.TRUE);
        this.jHI = null;
        AppMethodBeat.o(105474);
      }
    }
    else if ((p.h(localEmojiInfo.aCt(), String.valueOf(EmojiGroupInfo.YCu))) || (com.tencent.mm.plugin.emoji.i.b.avc(localEmojiInfo.getMd5())))
    {
      localObject2 = localEmojiInfo.getName();
      if (Util.isNullOrNil((String)localObject2)) {
        break label385;
      }
      p.j(localObject2, "name");
      localObject1 = (String)n.a((CharSequence)localObject2, new String[] { "." }).get(0);
      localObject2 = MMApplicationContext.getContext();
      p.j(localObject2, "MMApplicationContext.getContext()");
      localObject2 = ((Context)localObject2).getResources();
      localObject1 = MMBitmapFactory.decodeResource((Resources)localObject2, ((Resources)localObject2).getIdentifier((String)localObject1, "drawable", MMApplicationContext.getPackageName()));
    }
    label385:
    for (;;)
    {
      label217:
      if (localObject1 != null)
      {
        localObject2 = com.tencent.mm.emoji.loader.a.b.jGQ;
        com.tencent.mm.emoji.loader.a.b.put(localEmojiInfo.getMd5(), (Bitmap)localObject1);
        i = 1;
        break;
        if (!u.agG(localEmojiInfo.ifi())) {
          break label385;
        }
        localObject1 = new BitmapFactory.Options();
        ((BitmapFactory.Options)localObject1).outWidth = 120;
        ((BitmapFactory.Options)localObject1).outHeight = 120;
        localObject2 = BitmapUtil.decodeFile(localEmojiInfo.ifi(), (BitmapFactory.Options)localObject1);
        if (localObject2 != null) {
          break label289;
        }
      }
      for (;;)
      {
        i = 0;
        break;
        label289:
        if (((Bitmap)localObject2).getWidth() <= 120)
        {
          localObject1 = localObject2;
          if (((Bitmap)localObject2).getHeight() <= 120) {
            break label217;
          }
        }
        localObject2 = BitmapUtil.extractThumbNail((Bitmap)localObject2, 120, 120, false, true);
        localObject1 = localObject2;
        if (localObject2 != null) {
          break label217;
        }
      }
      if ((MMApplicationContext.isMainProcess()) && (localEmojiInfo.hBB() == EmojiInfo.a.VIi))
      {
        new f(localEmojiInfo, (m)new c.b(localc, localb, localEmojiInfo));
        break label103;
      }
      com.tencent.mm.emoji.loader.c.c.a(localEmojiInfo, localb);
      break label103;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.emoji.loader.e.a
 * JD-Core Version:    0.7.0.1
 */