package com.tencent.mm.plugin.finder.live.olympic;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.utils.bm;
import com.tencent.mm.plugin.thumbplayer.e.d;
import com.tencent.mm.plugin.thumbplayer.e.d.a;
import com.tencent.mm.plugin.thumbplayer.view.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.vfs.y;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/olympic/FinderLiveBgmPlayer;", "", "()V", "TAG", "", "bgmUrls", "", "count", "", "mPlayer", "Lcom/tencent/mm/plugin/thumbplayer/player/MMCdnTPPlayer;", "generateMediaInfo", "Lcom/tencent/mm/plugin/thumbplayer/api/TPMediaInfo;", "url", "getNextUrl", "innerPrepare", "", "pause", "play", "prepare", "urls", "", "release", "resume", "setMute", "mute", "", "stop", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
{
  public final com.tencent.mm.plugin.thumbplayer.e.b CNh;
  public final List<String> CNi;
  public final String TAG;
  private int count;
  
  public b()
  {
    AppMethodBeat.i(360507);
    this.TAG = "Finder.FinderLiveBgmPlayer";
    Object localObject = d.TFK;
    localObject = MMApplicationContext.getContext();
    s.s(localObject, "getContext()");
    this.CNh = d.a.ks((Context)localObject);
    this.CNi = ((List)new ArrayList());
    AppMethodBeat.o(360507);
  }
  
  private final com.tencent.mm.plugin.thumbplayer.a.b awK(String paramString)
  {
    AppMethodBeat.i(360517);
    com.tencent.mm.plugin.thumbplayer.a.b localb = new com.tencent.mm.plugin.thumbplayer.a.b();
    localb.url = paramString;
    bm localbm = bm.GlZ;
    localb.mediaId = bm.ar("bgm", "", paramString);
    localbm = bm.GlZ;
    localb.path = bm.ap("bgm", "", paramString);
    Log.i(this.TAG, "generateMediaInfo for " + paramString + ", mediaId:" + localb.mediaId + ", path:" + localb.path + ", export path:" + y.n(localb.path, false));
    AppMethodBeat.o(360517);
    return localb;
  }
  
  public final void awJ(String paramString)
  {
    AppMethodBeat.i(360531);
    Log.i(this.TAG, s.X("innerPrepare, ", paramString));
    paramString = awK(paramString);
    this.CNh.setMediaInfo(paramString);
    this.CNh.setLoop(false);
    this.CNh.akjm = true;
    this.CNh.Flr = true;
    AppMethodBeat.o(360531);
  }
  
  public final String enq()
  {
    AppMethodBeat.i(360524);
    int i = this.count;
    int j = this.CNi.size();
    this.count += 1;
    String str = (String)p.ae(this.CNi, i % j);
    if (str == null)
    {
      str = (String)p.oL(this.CNi);
      if (str == null)
      {
        AppMethodBeat.o(360524);
        return "";
      }
      AppMethodBeat.o(360524);
      return str;
    }
    AppMethodBeat.o(360524);
    return str;
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/thumbplayer/player/MMCdnTPPlayer;"}, k=3, mv={1, 5, 1}, xi=48)
  public static final class a
    extends u
    implements kotlin.g.a.b<com.tencent.mm.plugin.thumbplayer.e.b, ah>
  {
    public a(b paramb)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.olympic.b
 * JD-Core Version:    0.7.0.1
 */