package com.tencent.mm.emoji.loader.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.emoji.c;
import com.tencent.mm.plugin.emoji.d.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.vfs.i;
import d.g.b.k;
import d.l;
import d.y;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/emoji/loader/fetcher/EmojiHttpFetcher;", "Lcom/tencent/mm/emoji/loader/fetcher/EmojiFetcher;", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "callback", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "success", "", "fetcherConfig", "Lcom/tencent/mm/emoji/loader/fetcher/EmojiFetcherConfig;", "fetch", "getEmojiData", "Lcom/tencent/mm/modelimage/loader/model/Response;", "reportResult", "reportStart", "plugin-emojisdk_release"})
public final class g
  implements d
{
  private final String TAG = "MicroMsg.EmojiLoader.EmojiHttpFetcher";
  private e fLx;
  private d.g.a.b<? super Boolean, y> fLy;
  
  private final void de(boolean paramBoolean)
  {
    AppMethodBeat.i(105440);
    e locale = this.fLx;
    if (locale != null)
    {
      if (paramBoolean)
      {
        c.oF(2L);
        AppMethodBeat.o(105440);
        return;
      }
      c.oF(3L);
      switch (locale.fLR)
      {
      }
      for (;;)
      {
        AppMethodBeat.o(105440);
        return;
        c.a(locale.fLP.JS(), 4, 1, 1, locale.fLP.asy(), 1, locale.fLP.field_designerID);
        AppMethodBeat.o(105440);
        return;
        c.a(locale.fLP.JS(), 2, 1, 1, locale.fLP.asy(), 1, locale.fLP.field_designerID);
        AppMethodBeat.o(105440);
        return;
        c.a(locale.fLP.JS(), 4, 1, 1, locale.fLP.asy(), 1, locale.fLP.field_designerID);
      }
    }
    AppMethodBeat.o(105440);
  }
  
  public final void a(e parame, d.g.a.b<? super Boolean, y> paramb)
  {
    AppMethodBeat.i(105439);
    k.h(parame, "fetcherConfig");
    this.fLx = parame;
    this.fLy = paramb;
    Object localObject = this.fLx;
    if (localObject != null) {}
    label92:
    label104:
    int i;
    switch (((e)localObject).fLR)
    {
    default: 
      localObject = this.fLx;
      if (localObject != null)
      {
        localObject = new a().yy(((e)localObject).url);
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
        ad.i(this.TAG, "download fail " + parame.fLP.JS());
        de(false);
        if (paramb != null)
        {
          paramb.aA(Boolean.FALSE);
          AppMethodBeat.o(105439);
          return;
          c.oF(1L);
          break;
          c.oF(6L);
          break;
          c.oF(10L);
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
    ad.i(this.TAG, "download success " + parame.fLP.JS() + ", " + parame.path);
    new com.tencent.mm.vfs.e(parame.path).fhT().mkdirs();
    i.B(parame.path, (byte[])localObject);
    de(true);
    if (paramb != null)
    {
      paramb.aA(Boolean.TRUE);
      AppMethodBeat.o(105439);
      return;
    }
    AppMethodBeat.o(105439);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.emoji.loader.c.g
 * JD-Core Version:    0.7.0.1
 */