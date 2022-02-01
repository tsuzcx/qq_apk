package com.tencent.mm.emoji.loader.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.emoji.c;
import com.tencent.mm.plugin.emoji.d.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.vfs.k;
import com.tencent.mm.vfs.o;
import d.g.b.p;
import d.l;
import d.z;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/emoji/loader/fetcher/EmojiHttpFetcher;", "Lcom/tencent/mm/emoji/loader/fetcher/EmojiFetcher;", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "callback", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "success", "", "fetcherConfig", "Lcom/tencent/mm/emoji/loader/fetcher/EmojiFetcherConfig;", "fetch", "getEmojiData", "Lcom/tencent/mm/modelimage/loader/model/Response;", "reportResult", "reportStart", "plugin-emojisdk_release"})
public final class g
  implements d
{
  private final String TAG = "MicroMsg.EmojiLoader.EmojiHttpFetcher";
  private e glb;
  private d.g.a.b<? super Boolean, z> glc;
  
  private final void df(boolean paramBoolean)
  {
    AppMethodBeat.i(105440);
    e locale = this.glb;
    if (locale != null)
    {
      if (paramBoolean)
      {
        c.uG(2L);
        AppMethodBeat.o(105440);
        return;
      }
      c.uG(3L);
      switch (locale.glv)
      {
      }
      for (;;)
      {
        AppMethodBeat.o(105440);
        return;
        c.a(locale.glt.Lj(), 4, 1, 1, locale.glt.afK(), 1, locale.glt.field_designerID);
        AppMethodBeat.o(105440);
        return;
        c.a(locale.glt.Lj(), 2, 1, 1, locale.glt.afK(), 1, locale.glt.field_designerID);
        AppMethodBeat.o(105440);
        return;
        c.a(locale.glt.Lj(), 4, 1, 1, locale.glt.afK(), 1, locale.glt.field_designerID);
      }
    }
    AppMethodBeat.o(105440);
  }
  
  public final void a(e parame, d.g.a.b<? super Boolean, z> paramb)
  {
    AppMethodBeat.i(105439);
    p.h(parame, "fetcherConfig");
    this.glb = parame;
    this.glc = paramb;
    Object localObject = this.glb;
    if (localObject != null) {}
    label92:
    label104:
    int i;
    switch (((e)localObject).glv)
    {
    default: 
      localObject = this.glb;
      if (localObject != null)
      {
        localObject = new a().Gj(((e)localObject).url);
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
        ae.i(this.TAG, "download fail " + parame.glt.Lj());
        df(false);
        if (paramb != null)
        {
          paramb.invoke(Boolean.FALSE);
          AppMethodBeat.o(105439);
          return;
          c.uG(1L);
          break;
          c.uG(6L);
          break;
          c.uG(10L);
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
    ae.i(this.TAG, "download success " + parame.glt.Lj() + ", " + parame.path);
    new k(parame.path).fTg().mkdirs();
    o.C(parame.path, (byte[])localObject);
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