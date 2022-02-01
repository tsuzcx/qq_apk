package com.tencent.mm.emoji.b.e;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.b.c.c.b;
import com.tencent.mm.emoji.b.c.f;
import com.tencent.mm.emoji.b.d.h;
import com.tencent.mm.graphics.MMBitmapFactory;
import com.tencent.mm.plugin.emoji.g.d;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.storage.emotion.EmojiInfo.a;
import com.tencent.mm.vfs.y;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.a.m;
import kotlin.g.b.s;
import kotlin.n.n;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/emoji/loader/task/EmojiCoverTask;", "Lcom/tencent/mm/emoji/loader/task/IEmojiLoadTask;", "Ljava/lang/Runnable;", "emojiInfo", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "(Lcom/tencent/mm/storage/emotion/EmojiInfo;)V", "dependRequest", "Lcom/tencent/mm/emoji/loader/request/Request;", "taskKey", "", "getTaskKey", "onResult", "", "success", "", "run", "plugin-emojisdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  extends c
  implements Runnable
{
  private final String mhl;
  private h<?> mhm;
  
  public a(EmojiInfo paramEmojiInfo)
  {
    super(paramEmojiInfo);
    AppMethodBeat.i(105476);
    this.mhl = s.X(paramEmojiInfo.getMd5(), "_cover");
    AppMethodBeat.o(105476);
  }
  
  public final String aUD()
  {
    return this.mhl;
  }
  
  public final void onResult(boolean paramBoolean)
  {
    AppMethodBeat.i(105475);
    h localh = this.mhm;
    if (localh != null) {
      localh.cancel();
    }
    super.onResult(paramBoolean);
    AppMethodBeat.o(105475);
  }
  
  public final void run()
  {
    AppMethodBeat.i(105474);
    super.run();
    com.tencent.mm.emoji.b.c.c localc = new com.tencent.mm.emoji.b.c.c();
    EmojiInfo localEmojiInfo = this.mgK;
    kotlin.g.a.b localb = (kotlin.g.a.b)new a.a(this);
    s.u(localEmojiInfo, "emojiInfo");
    Object localObject1 = com.tencent.mm.emoji.b.a.b.mgs;
    localObject1 = com.tencent.mm.emoji.b.a.b.Eo(localEmojiInfo.getMd5());
    int i;
    label93:
    Object localObject2;
    if (localObject1 != null)
    {
      i = 1;
      if (i != 0)
      {
        Log.d("MicroMsg.EmojiCoverFetcher", s.X("fetch: from cache ", localEmojiInfo.getMd5()));
        localb.invoke(Boolean.TRUE);
        this.mhm = null;
        AppMethodBeat.o(105474);
      }
    }
    else if ((s.p(localEmojiInfo.field_groupId, String.valueOf(EmojiGroupInfo.aklD))) || (d.apc(localEmojiInfo.getMd5())))
    {
      localObject2 = localEmojiInfo.getName();
      if (Util.isNullOrNil((String)localObject2)) {
        break label364;
      }
      s.s(localObject2, "name");
      localObject1 = (String)n.a((CharSequence)localObject2, new String[] { "." }).get(0);
      localObject2 = MMApplicationContext.getContext().getResources();
      localObject1 = MMBitmapFactory.decodeResource((Resources)localObject2, ((Resources)localObject2).getIdentifier((String)localObject1, "drawable", MMApplicationContext.getPackageName()));
    }
    label364:
    for (;;)
    {
      if (localObject1 != null)
      {
        localObject2 = com.tencent.mm.emoji.b.a.b.mgs;
        com.tencent.mm.emoji.b.a.b.put(localEmojiInfo.getMd5(), (Bitmap)localObject1);
        i = 1;
        break;
        if (!y.ZC(localEmojiInfo.kMo())) {
          break label364;
        }
        localObject1 = new BitmapFactory.Options();
        ((BitmapFactory.Options)localObject1).outWidth = 120;
        ((BitmapFactory.Options)localObject1).outHeight = 120;
        localObject2 = BitmapUtil.decodeFile(localEmojiInfo.kMo(), (BitmapFactory.Options)localObject1);
        if (localObject2 != null)
        {
          if (((Bitmap)localObject2).getWidth() <= 120)
          {
            localObject1 = localObject2;
            if (((Bitmap)localObject2).getHeight() <= 120) {
              continue;
            }
          }
          localObject2 = BitmapUtil.extractThumbNail((Bitmap)localObject2, 120, 120, false, true);
          localObject1 = localObject2;
          if (localObject2 != null) {
            continue;
          }
        }
      }
      i = 0;
      break;
      if ((MMApplicationContext.isMainProcess()) && (localEmojiInfo.kMj() == EmojiInfo.a.adme))
      {
        new f(localEmojiInfo, (m)new c.b(localb, localc, localEmojiInfo));
        break label93;
      }
      com.tencent.mm.emoji.b.c.c.a(localEmojiInfo, localb);
      break label93;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.emoji.b.e.a
 * JD-Core Version:    0.7.0.1
 */