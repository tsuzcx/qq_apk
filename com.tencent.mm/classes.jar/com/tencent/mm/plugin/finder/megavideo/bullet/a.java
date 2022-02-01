package com.tencent.mm.plugin.finder.megavideo.bullet;

import android.content.Context;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.danmaku.a.g;
import com.tencent.mm.danmaku.c.h;
import com.tencent.mm.danmaku.c.l.a;
import com.tencent.mm.danmaku.c.m;
import com.tencent.mm.danmaku.e.e;
import com.tencent.mm.plugin.finder.cgi.cy;
import com.tencent.mm.plugin.finder.model.bs;
import com.tencent.mm.protocal.protobuf.cwa;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/megavideo/bullet/MegaVideoBulletManager;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "bulletView", "Landroid/view/View;", "(Landroid/view/View;)V", "bulletLoader", "Lcom/tencent/mm/plugin/finder/megavideo/loader/MegaVideoBulletLoader;", "bulletLoaderListener", "com/tencent/mm/plugin/finder/megavideo/bullet/MegaVideoBulletManager$bulletLoaderListener$1", "Lcom/tencent/mm/plugin/finder/megavideo/bullet/MegaVideoBulletManager$bulletLoaderListener$1;", "getBulletView", "()Landroid/view/View;", "currentTime", "", "getCurrentTime", "()J", "setCurrentTime", "(J)V", "danmakuClickListener", "Lcom/tencent/mm/danmaku/core/DanmakuManager$IDanmakuListener;", "getDanmakuClickListener", "()Lcom/tencent/mm/danmaku/core/DanmakuManager$IDanmakuListener;", "setDanmakuClickListener", "(Lcom/tencent/mm/danmaku/core/DanmakuManager$IDanmakuListener;)V", "danmakuManager", "Lcom/tencent/mm/danmaku/core/DanmakuManager;", "getDanmakuManager", "()Lcom/tencent/mm/danmaku/core/DanmakuManager;", "setDanmakuManager", "(Lcom/tencent/mm/danmaku/core/DanmakuManager;)V", "isAttached", "", "()Z", "setAttached", "(Z)V", "megaVideoFeed", "Lcom/tencent/mm/plugin/finder/model/MegaVideoFeed;", "getMegaVideoFeed", "()Lcom/tencent/mm/plugin/finder/model/MegaVideoFeed;", "setMegaVideoFeed", "(Lcom/tencent/mm/plugin/finder/model/MegaVideoFeed;)V", "addDanmaku", "", "list", "", "Lcom/tencent/mm/protocal/protobuf/MegaVideoBulletCommentInfo;", "changeSpeed", "ratio", "", "isLandscape", "initDanmaku", "onAttach", "feed", "onConfigurationChange", "currRatio", "onDetach", "onSceneEnd", "errType", "", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "pause", "postBullet", "content", "isProfile", "restart", "timeStamp", "resume", "seek", "setProgress", "times", "stop", "Companion", "plugin-finder_release"})
public final class a
  implements i
{
  public static final a.a zvA;
  boolean ljV;
  long lwE;
  public bs zvv;
  public g zvw;
  com.tencent.mm.plugin.finder.megavideo.loader.a zvx;
  private final c zvy;
  private final View zvz;
  
  static
  {
    AppMethodBeat.i(272800);
    zvA = new a.a((byte)0);
    e.a((l.a)new a.b());
    AppMethodBeat.o(272800);
  }
  
  public a(View paramView)
  {
    AppMethodBeat.i(272799);
    this.zvz = paramView;
    paramView = this.zvz;
    Object localObject = com.tencent.mm.danmaku.c.a.azC();
    p.j(localObject, "config");
    ((m)localObject).azN();
    ((m)localObject).azO();
    ((m)localObject).setDuration(6000);
    ((m)localObject).rv(0);
    ((m)localObject).am(0.0F);
    ((m)localObject).al(4.0F);
    localObject = com.tencent.mm.danmaku.c.a.azF();
    ((com.tencent.mm.danmaku.c.a.a)localObject).a((h)new d(this));
    ((com.tencent.mm.danmaku.c.a.a)localObject).a((com.tencent.mm.danmaku.c.d)a.e.zvC);
    Context localContext = paramView.getContext();
    p.j(localContext, "bulletView.context");
    ((com.tencent.mm.danmaku.c.a.a)localObject).a((com.tencent.mm.danmaku.render.a)new d(localContext));
    this.zvw = new g(paramView, ((com.tencent.mm.danmaku.c.a.a)localObject).azG());
    this.zvy = new c(this);
    AppMethodBeat.o(272799);
  }
  
  final void ez(List<? extends cwa> paramList)
  {
    AppMethodBeat.i(272797);
    g localg = this.zvw;
    if (localg == null) {
      p.bGy("danmakuManager");
    }
    Object localObject1 = (Iterable)paramList;
    paramList = (Collection)new ArrayList(j.a((Iterable)localObject1, 10));
    localObject1 = ((Iterable)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      cwa localcwa = (cwa)((Iterator)localObject1).next();
      Object localObject2 = this.zvw;
      if (localObject2 == null) {
        p.bGy("danmakuManager");
      }
      localObject2 = ((g)localObject2).aZ(localcwa);
      p.j(localObject2, "danmaku");
      ((com.tencent.mm.danmaku.b.a)localObject2).azs();
      ((com.tencent.mm.danmaku.b.a)localObject2).ER(localcwa.TEU);
      paramList.add(localObject2);
    }
    localg.Y((List)paramList);
    AppMethodBeat.o(272797);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(272798);
    p.k(paramq, "scene");
    if ((paramq instanceof cy))
    {
      AppMethodBeat.o(272798);
      throw null;
    }
    AppMethodBeat.o(272798);
  }
  
  public final void stop()
  {
    AppMethodBeat.i(272795);
    g localg = this.zvw;
    if (localg == null) {
      p.bGy("danmakuManager");
    }
    localg.ayG();
    localg = this.zvw;
    if (localg == null) {
      p.bGy("danmakuManager");
    }
    localg.clear();
    localg = this.zvw;
    if (localg == null) {
      p.bGy("danmakuManager");
    }
    localg.quit();
    AppMethodBeat.o(272795);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/megavideo/bullet/MegaVideoBulletManager$bulletLoaderListener$1", "Lcom/tencent/mm/plugin/finder/megavideo/loader/MegaVideoBulletLoader$BulletLoadListener;", "onBulletIncrease", "", "increaseList", "", "Lcom/tencent/mm/protocal/protobuf/MegaVideoBulletCommentInfo;", "plugin-finder_release"})
  public static final class c {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "getPlayTime"})
  static final class d
    implements h
  {
    d(a parama) {}
    
    public final long azE()
    {
      return this.zvB.lwE;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.megavideo.bullet.a
 * JD-Core Version:    0.7.0.1
 */