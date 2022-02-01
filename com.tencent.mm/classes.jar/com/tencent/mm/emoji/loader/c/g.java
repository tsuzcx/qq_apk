package com.tencent.mm.emoji.loader.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.emoji.d.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.vfs.q;
import com.tencent.mm.vfs.u;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/emoji/loader/fetcher/EmojiHttpFetcher;", "Lcom/tencent/mm/emoji/loader/fetcher/EmojiFetcher;", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "callback", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "success", "", "fetcherConfig", "Lcom/tencent/mm/emoji/loader/fetcher/EmojiFetcherConfig;", "fetch", "getEmojiData", "Lcom/tencent/mm/modelimage/loader/model/Response;", "reportResult", "reportStart", "plugin-emojisdk_release"})
public final class g
  implements d
{
  private final String TAG = "MicroMsg.EmojiLoader.EmojiHttpFetcher";
  private kotlin.g.a.b<? super Boolean, x> callback;
  private e jGR;
  
  private final void eo(boolean paramBoolean)
  {
    AppMethodBeat.i(105440);
    e locale = this.jGR;
    if (locale != null)
    {
      if (paramBoolean)
      {
        com.tencent.mm.plugin.emoji.d.IT(2L);
        AppMethodBeat.o(105440);
        return;
      }
      com.tencent.mm.plugin.emoji.d.IT(3L);
      switch (locale.jHi)
      {
      }
      for (;;)
      {
        AppMethodBeat.o(105440);
        return;
        com.tencent.mm.plugin.emoji.d.a(locale.jHh.getMd5(), 4, 1, 1, locale.jHh.aCt(), 1, locale.jHh.field_designerID);
        AppMethodBeat.o(105440);
        return;
        com.tencent.mm.plugin.emoji.d.a(locale.jHh.getMd5(), 2, 1, 1, locale.jHh.aCt(), 1, locale.jHh.field_designerID);
        AppMethodBeat.o(105440);
        return;
        com.tencent.mm.plugin.emoji.d.a(locale.jHh.getMd5(), 4, 1, 1, locale.jHh.aCt(), 1, locale.jHh.field_designerID);
      }
    }
    AppMethodBeat.o(105440);
  }
  
  public final void a(e parame, kotlin.g.a.b<? super Boolean, x> paramb)
  {
    AppMethodBeat.i(105439);
    p.k(parame, "fetcherConfig");
    this.jGR = parame;
    this.callback = paramb;
    Object localObject = this.jGR;
    if (localObject != null) {}
    label92:
    label104:
    int i;
    switch (((e)localObject).jHi)
    {
    default: 
      localObject = this.jGR;
      if (localObject != null)
      {
        localObject = new a().Wt(((e)localObject).url);
        if (localObject == null) {
          break label206;
        }
        localObject = ((com.tencent.mm.ay.a.d.b)localObject).data;
        if (localObject != null)
        {
          if (localObject.length != 0) {
            break label212;
          }
          i = 1;
        }
      }
      break;
    }
    for (;;)
    {
      if (i != 0)
      {
        Log.i(this.TAG, "download fail " + parame.jHh.getMd5());
        eo(false);
        if (paramb != null)
        {
          paramb.invoke(Boolean.FALSE);
          AppMethodBeat.o(105439);
          return;
          com.tencent.mm.plugin.emoji.d.IT(1L);
          break;
          com.tencent.mm.plugin.emoji.d.IT(6L);
          break;
          com.tencent.mm.plugin.emoji.d.IT(10L);
          break;
          localObject = null;
          break label92;
          label206:
          localObject = null;
          break label104;
          label212:
          i = 0;
          continue;
        }
        AppMethodBeat.o(105439);
        return;
      }
    }
    Log.i(this.TAG, "download success " + parame.jHh.getMd5() + ", " + parame.path);
    q localq = new q(parame.path).ifB();
    if (localq != null) {
      localq.ifL();
    }
    u.H(parame.path, (byte[])localObject);
    eo(true);
    if (paramb != null)
    {
      paramb.invoke(Boolean.TRUE);
      AppMethodBeat.o(105439);
      return;
    }
    AppMethodBeat.o(105439);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.emoji.loader.c.g
 * JD-Core Version:    0.7.0.1
 */