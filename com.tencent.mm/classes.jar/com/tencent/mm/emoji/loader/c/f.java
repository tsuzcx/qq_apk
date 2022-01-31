package com.tencent.mm.emoji.loader.c;

import a.f.b.j;
import a.l;
import a.y;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.emoji.d.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.vfs.e;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/emoji/loader/fetcher/EmojiHttpFetcher;", "Lcom/tencent/mm/emoji/loader/fetcher/EmojiFetcher;", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "callback", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "success", "", "fetcherConfig", "Lcom/tencent/mm/emoji/loader/fetcher/EmojiFetcherConfig;", "fetch", "getEmojiData", "Lcom/tencent/mm/modelimage/loader/model/Response;", "reportResult", "reportStart", "plugin-emojisdk_release"})
public final class f
  implements c
{
  private final String TAG = "MicroMsg.EmojiLoader.EmojiHttpFetcher";
  private d evu;
  private a.f.a.b<? super Boolean, y> evv;
  
  private final void ce(boolean paramBoolean)
  {
    AppMethodBeat.i(63190);
    d locald = this.evu;
    if (locald != null)
    {
      if (paramBoolean)
      {
        com.tencent.mm.plugin.emoji.c.iX(2L);
        AppMethodBeat.o(63190);
        return;
      }
      com.tencent.mm.plugin.emoji.c.iX(3L);
      switch (locald.evJ)
      {
      }
      for (;;)
      {
        AppMethodBeat.o(63190);
        return;
        com.tencent.mm.plugin.emoji.c.a(locald.evH.Al(), 4, 1, 1, locald.evH.avS(), 1, locald.evH.field_designerID);
        AppMethodBeat.o(63190);
        return;
        com.tencent.mm.plugin.emoji.c.a(locald.evH.Al(), 2, 1, 1, locald.evH.avS(), 1, locald.evH.field_designerID);
        AppMethodBeat.o(63190);
        return;
        com.tencent.mm.plugin.emoji.c.a(locald.evH.Al(), 4, 1, 1, locald.evH.avS(), 1, locald.evH.field_designerID);
      }
    }
    AppMethodBeat.o(63190);
  }
  
  public final void a(d paramd, a.f.a.b<? super Boolean, y> paramb)
  {
    AppMethodBeat.i(63189);
    j.q(paramd, "fetcherConfig");
    this.evu = paramd;
    this.evv = paramb;
    Object localObject = this.evu;
    if (localObject != null) {}
    label92:
    label104:
    int i;
    switch (((d)localObject).evJ)
    {
    default: 
      localObject = this.evu;
      if (localObject != null)
      {
        localObject = new a().tB(((d)localObject).url);
        if (localObject == null) {
          break label206;
        }
        localObject = ((com.tencent.mm.at.a.d.b)localObject).data;
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
        ab.i(this.TAG, "download fail " + paramd.evH.Al());
        ce(false);
        if (paramb != null)
        {
          paramb.S(Boolean.FALSE);
          AppMethodBeat.o(63189);
          return;
          com.tencent.mm.plugin.emoji.c.iX(1L);
          break;
          com.tencent.mm.plugin.emoji.c.iX(6L);
          break;
          com.tencent.mm.plugin.emoji.c.iX(10L);
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
        AppMethodBeat.o(63189);
        return;
      }
    }
    ab.i(this.TAG, "download success " + paramd.evH.Al() + ", " + paramd.path);
    new com.tencent.mm.vfs.b(paramd.path).dQI().mkdirs();
    e.q(paramd.path, (byte[])localObject);
    ce(true);
    if (paramb != null)
    {
      paramb.S(Boolean.TRUE);
      AppMethodBeat.o(63189);
      return;
    }
    AppMethodBeat.o(63189);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.emoji.loader.c.f
 * JD-Core Version:    0.7.0.1
 */