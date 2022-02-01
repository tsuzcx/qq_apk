package com.tencent.mm.emoji.loader.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.emoji.c;
import com.tencent.mm.plugin.emoji.d.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.vfs.i;
import d.g.b.k;
import d.l;
import d.y;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/emoji/loader/fetcher/EmojiHttpFetcher;", "Lcom/tencent/mm/emoji/loader/fetcher/EmojiFetcher;", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "callback", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "success", "", "fetcherConfig", "Lcom/tencent/mm/emoji/loader/fetcher/EmojiFetcherConfig;", "fetch", "getEmojiData", "Lcom/tencent/mm/modelimage/loader/model/Response;", "reportResult", "reportStart", "plugin-emojisdk_release"})
public final class g
  implements d
{
  private final String TAG = "MicroMsg.EmojiLoader.EmojiHttpFetcher";
  private e fPj;
  private d.g.a.b<? super Boolean, y> fPk;
  
  private final void dd(boolean paramBoolean)
  {
    AppMethodBeat.i(105440);
    e locale = this.fPj;
    if (locale != null)
    {
      if (paramBoolean)
      {
        c.sr(2L);
        AppMethodBeat.o(105440);
        return;
      }
      c.sr(3L);
      switch (locale.fPD)
      {
      }
      for (;;)
      {
        AppMethodBeat.o(105440);
        return;
        c.a(locale.fPB.JC(), 4, 1, 1, locale.fPB.azp(), 1, locale.fPB.field_designerID);
        AppMethodBeat.o(105440);
        return;
        c.a(locale.fPB.JC(), 2, 1, 1, locale.fPB.azp(), 1, locale.fPB.field_designerID);
        AppMethodBeat.o(105440);
        return;
        c.a(locale.fPB.JC(), 4, 1, 1, locale.fPB.azp(), 1, locale.fPB.field_designerID);
      }
    }
    AppMethodBeat.o(105440);
  }
  
  public final void a(e parame, d.g.a.b<? super Boolean, y> paramb)
  {
    AppMethodBeat.i(105439);
    k.h(parame, "fetcherConfig");
    this.fPj = parame;
    this.fPk = paramb;
    Object localObject = this.fPj;
    if (localObject != null) {}
    label92:
    label104:
    int i;
    switch (((e)localObject).fPD)
    {
    default: 
      localObject = this.fPj;
      if (localObject != null)
      {
        localObject = new a().CD(((e)localObject).url);
        if (localObject == null) {
          break label206;
        }
        localObject = ((com.tencent.mm.av.a.d.b)localObject).data;
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
        ac.i(this.TAG, "download fail " + parame.fPB.JC());
        dd(false);
        if (paramb != null)
        {
          paramb.ay(Boolean.FALSE);
          AppMethodBeat.o(105439);
          return;
          c.sr(1L);
          break;
          c.sr(6L);
          break;
          c.sr(10L);
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
    ac.i(this.TAG, "download success " + parame.fPB.JC() + ", " + parame.path);
    new com.tencent.mm.vfs.e(parame.path).fxU().mkdirs();
    i.B(parame.path, (byte[])localObject);
    dd(true);
    if (paramb != null)
    {
      paramb.ay(Boolean.TRUE);
      AppMethodBeat.o(105439);
      return;
    }
    AppMethodBeat.o(105439);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.emoji.loader.c.g
 * JD-Core Version:    0.7.0.1
 */