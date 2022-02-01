package com.tencent.mm.emoji.loader.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.emoji.c;
import com.tencent.mm.plugin.emoji.d.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.vfs.i;
import d.g.b.p;
import d.l;
import d.z;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/emoji/loader/fetcher/EmojiHttpFetcher;", "Lcom/tencent/mm/emoji/loader/fetcher/EmojiFetcher;", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "callback", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "success", "", "fetcherConfig", "Lcom/tencent/mm/emoji/loader/fetcher/EmojiFetcherConfig;", "fetch", "getEmojiData", "Lcom/tencent/mm/modelimage/loader/model/Response;", "reportResult", "reportStart", "plugin-emojisdk_release"})
public final class g
  implements d
{
  private final String TAG = "MicroMsg.EmojiLoader.EmojiHttpFetcher";
  private e giJ;
  private d.g.a.b<? super Boolean, z> giK;
  
  private final void df(boolean paramBoolean)
  {
    AppMethodBeat.i(105440);
    e locale = this.giJ;
    if (locale != null)
    {
      if (paramBoolean)
      {
        c.up(2L);
        AppMethodBeat.o(105440);
        return;
      }
      c.up(3L);
      switch (locale.gjd)
      {
      }
      for (;;)
      {
        AppMethodBeat.o(105440);
        return;
        c.a(locale.gjb.Lb(), 4, 1, 1, locale.gjb.afw(), 1, locale.gjb.field_designerID);
        AppMethodBeat.o(105440);
        return;
        c.a(locale.gjb.Lb(), 2, 1, 1, locale.gjb.afw(), 1, locale.gjb.field_designerID);
        AppMethodBeat.o(105440);
        return;
        c.a(locale.gjb.Lb(), 4, 1, 1, locale.gjb.afw(), 1, locale.gjb.field_designerID);
      }
    }
    AppMethodBeat.o(105440);
  }
  
  public final void a(e parame, d.g.a.b<? super Boolean, z> paramb)
  {
    AppMethodBeat.i(105439);
    p.h(parame, "fetcherConfig");
    this.giJ = parame;
    this.giK = paramb;
    Object localObject = this.giJ;
    if (localObject != null) {}
    label92:
    label104:
    int i;
    switch (((e)localObject).gjd)
    {
    default: 
      localObject = this.giJ;
      if (localObject != null)
      {
        localObject = new a().FH(((e)localObject).url);
        if (localObject == null) {
          break label206;
        }
        localObject = ((com.tencent.mm.aw.a.d.b)localObject).data;
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
        ad.i(this.TAG, "download fail " + parame.gjb.Lb());
        df(false);
        if (paramb != null)
        {
          paramb.invoke(Boolean.FALSE);
          AppMethodBeat.o(105439);
          return;
          c.up(1L);
          break;
          c.up(6L);
          break;
          c.up(10L);
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
    ad.i(this.TAG, "download success " + parame.gjb.Lb() + ", " + parame.path);
    new com.tencent.mm.vfs.e(parame.path).fOJ().mkdirs();
    i.C(parame.path, (byte[])localObject);
    df(true);
    if (paramb != null)
    {
      paramb.invoke(Boolean.TRUE);
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