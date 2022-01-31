package com.tencent.mm.emoji.loader.c;

import a.f.b.j;
import a.l;
import a.y;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.f;
import com.tencent.mm.i.g;
import com.tencent.mm.i.g.a;
import com.tencent.mm.storage.emotion.EmojiInfo;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/emoji/loader/fetcher/EmojiCdnFetcher;", "Lcom/tencent/mm/emoji/loader/fetcher/EmojiFetcher;", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "callback", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "success", "", "cdnCallback", "com/tencent/mm/emoji/loader/fetcher/EmojiCdnFetcher$cdnCallback$1", "Lcom/tencent/mm/emoji/loader/fetcher/EmojiCdnFetcher$cdnCallback$1;", "fetcherConfig", "Lcom/tencent/mm/emoji/loader/fetcher/EmojiFetcherConfig;", "createCdnTask", "Lcom/tencent/mm/cdn/keep_TaskInfo;", "fetch", "plugin-emojisdk_release"})
public final class a
  implements c
{
  final String TAG;
  private d evu;
  private a.f.a.b<? super Boolean, y> evv;
  private final a.a evw;
  
  public a()
  {
    AppMethodBeat.i(63174);
    this.TAG = "MicroMsg.EmojiLoader.EmojiFetcher";
    this.evw = new a.a(this);
    AppMethodBeat.o(63174);
  }
  
  public final void a(d paramd, a.f.a.b<? super Boolean, y> paramb)
  {
    AppMethodBeat.i(63173);
    j.q(paramd, "fetcherConfig");
    this.evu = paramd;
    this.evv = paramb;
    paramd = f.afO();
    paramb = new g();
    Object localObject = this.evu;
    if (localObject == null) {
      j.ays("fetcherConfig");
    }
    paramb.field_authKey = ((d)localObject).evI;
    paramb.field_fileType = 19;
    localObject = new StringBuilder().append(c.a.Ou());
    d locald = this.evu;
    if (locald == null) {
      j.ays("fetcherConfig");
    }
    paramb.field_mediaId = locald.evH.Al();
    localObject = this.evu;
    if (localObject == null) {
      j.ays("fetcherConfig");
    }
    paramb.field_fullpath = ((d)localObject).path;
    localObject = this.evu;
    if (localObject == null) {
      j.ays("fetcherConfig");
    }
    paramb.eds = ((d)localObject).url;
    paramb.edp = ((g.a)this.evw);
    paramd.d(paramb);
    AppMethodBeat.o(63173);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.emoji.loader.c.a
 * JD-Core Version:    0.7.0.1
 */