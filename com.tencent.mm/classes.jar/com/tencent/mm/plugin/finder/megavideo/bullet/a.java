package com.tencent.mm.plugin.finder.megavideo.bullet;

import android.content.Context;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.danmaku.a.g;
import com.tencent.mm.danmaku.c.h;
import com.tencent.mm.danmaku.c.l.a;
import com.tencent.mm.danmaku.c.m;
import com.tencent.mm.danmaku.e.e;
import com.tencent.mm.g.a.hn;
import com.tencent.mm.plugin.finder.cgi.cs;
import com.tencent.mm.plugin.finder.model.bm;
import com.tencent.mm.plugin.finder.report.af;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.protocal.protobuf.cng;
import com.tencent.mm.protocal.protobuf.cni;
import com.tencent.mm.protocal.protobuf.cnj;
import com.tencent.mm.protocal.protobuf.cnl;
import com.tencent.mm.protocal.protobuf.cns;
import com.tencent.mm.protocal.protobuf.cod;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/megavideo/bullet/MegaVideoBulletManager;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "bulletView", "Landroid/view/View;", "(Landroid/view/View;)V", "bulletLoader", "Lcom/tencent/mm/plugin/finder/megavideo/loader/MegaVideoBulletLoader;", "bulletLoaderListener", "com/tencent/mm/plugin/finder/megavideo/bullet/MegaVideoBulletManager$bulletLoaderListener$1", "Lcom/tencent/mm/plugin/finder/megavideo/bullet/MegaVideoBulletManager$bulletLoaderListener$1;", "getBulletView", "()Landroid/view/View;", "currentTime", "", "getCurrentTime", "()J", "setCurrentTime", "(J)V", "danmakuClickListener", "Lcom/tencent/mm/danmaku/core/DanmakuManager$IDanmakuListener;", "getDanmakuClickListener", "()Lcom/tencent/mm/danmaku/core/DanmakuManager$IDanmakuListener;", "setDanmakuClickListener", "(Lcom/tencent/mm/danmaku/core/DanmakuManager$IDanmakuListener;)V", "danmakuManager", "Lcom/tencent/mm/danmaku/core/DanmakuManager;", "getDanmakuManager", "()Lcom/tencent/mm/danmaku/core/DanmakuManager;", "setDanmakuManager", "(Lcom/tencent/mm/danmaku/core/DanmakuManager;)V", "isAttached", "", "()Z", "setAttached", "(Z)V", "megaVideoFeed", "Lcom/tencent/mm/plugin/finder/model/MegaVideoFeed;", "getMegaVideoFeed", "()Lcom/tencent/mm/plugin/finder/model/MegaVideoFeed;", "setMegaVideoFeed", "(Lcom/tencent/mm/plugin/finder/model/MegaVideoFeed;)V", "addDanmaku", "", "list", "", "Lcom/tencent/mm/protocal/protobuf/MegaVideoBulletCommentInfo;", "initDanmaku", "onAttach", "feed", "onConfigurationChange", "isLandscape", "onDetach", "onSceneEnd", "errType", "", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "pause", "postBullet", "content", "restart", "timeStamp", "resume", "seek", "setProgress", "times", "stop", "Companion", "plugin-finder_release"})
public final class a
  implements i
{
  public static final a uJT;
  long iGC;
  boolean iuM;
  public bm uJO;
  public g uJP;
  com.tencent.mm.plugin.finder.megavideo.loader.a uJQ;
  private final c uJR;
  private final View uJS;
  
  static
  {
    AppMethodBeat.i(248258);
    uJT = new a((byte)0);
    e.a((l.a)new a.b());
    AppMethodBeat.o(248258);
  }
  
  public a(View paramView)
  {
    AppMethodBeat.i(248257);
    this.uJS = paramView;
    paramView = this.uJS;
    Object localObject = com.tencent.mm.danmaku.c.a.asO();
    p.g(localObject, "config");
    ((m)localObject).asZ();
    ((m)localObject).atb();
    ((m)localObject).ata();
    ((m)localObject).pa(0);
    ((m)localObject).an(0.0F);
    ((m)localObject).am(4.0F);
    localObject = com.tencent.mm.danmaku.c.a.asR();
    ((com.tencent.mm.danmaku.c.a.a)localObject).a((h)new d(this));
    ((com.tencent.mm.danmaku.c.a.a)localObject).a((com.tencent.mm.danmaku.c.d)e.uJV);
    Context localContext = paramView.getContext();
    p.g(localContext, "bulletView.context");
    ((com.tencent.mm.danmaku.c.a.a)localObject).a((com.tencent.mm.danmaku.render.a)new d(localContext));
    this.uJP = new g(paramView, ((com.tencent.mm.danmaku.c.a.a)localObject).asS());
    this.uJR = new c(this);
    AppMethodBeat.o(248257);
  }
  
  final void eg(List<? extends cni> paramList)
  {
    AppMethodBeat.i(248255);
    g localg = this.uJP;
    if (localg == null) {
      p.btv("danmakuManager");
    }
    Object localObject1 = (Iterable)paramList;
    paramList = (Collection)new ArrayList(j.a((Iterable)localObject1, 10));
    localObject1 = ((Iterable)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      cni localcni = (cni)((Iterator)localObject1).next();
      Object localObject2 = this.uJP;
      if (localObject2 == null) {
        p.btv("danmakuManager");
      }
      localObject2 = ((g)localObject2).aW(localcni);
      p.g(localObject2, "danmaku");
      ((com.tencent.mm.danmaku.b.a)localObject2).asE();
      ((com.tencent.mm.danmaku.b.a)localObject2).setTime(localcni.MtO);
      paramList.add(localObject2);
    }
    localg.ab((List)paramList);
    AppMethodBeat.o(248255);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    long l2 = 0L;
    int i = 1;
    int j = 0;
    AppMethodBeat.i(248256);
    p.h(paramq, "scene");
    long l1;
    Object localObject1;
    Object localObject2;
    if ((paramq instanceof cs))
    {
      l1 = ((cs)paramq).twG;
      localObject1 = this.uJO;
      if (localObject1 == null) {
        p.btv("megaVideoFeed");
      }
      if (l1 != ((bm)localObject1).lT())
      {
        AppMethodBeat.o(248256);
        return;
      }
      localObject1 = ((cs)paramq).rr.aYK();
      if (localObject1 == null)
      {
        paramString = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.MegaVideoBulletCommentResponse");
        AppMethodBeat.o(248256);
        throw paramString;
      }
      localObject1 = ((cnj)localObject1).MtP;
      if ((paramInt1 != 0) || (paramInt2 != 0)) {
        break label608;
      }
      if (localObject1 != null)
      {
        paramString = this.uJO;
        if (paramString == null) {
          p.btv("megaVideoFeed");
        }
        paramString.ej(j.listOf(localObject1));
      }
      paramString = this.uJP;
      if (paramString == null) {
        p.btv("danmakuManager");
      }
      paramString = paramString.aW(localObject1);
      p.g(paramString, "danmaku");
      paramString.asE();
      localObject2 = this.uJP;
      if (localObject2 == null) {
        p.btv("danmakuManager");
      }
      ((g)localObject2).d(paramString);
      paramString = new StringBuilder("postBullet onSceneEnd: addDanmaku ");
      localObject2 = this.uJO;
      if (localObject2 == null) {
        p.btv("megaVideoFeed");
      }
      Log.i("MegaVideoBulletManager", ((bm)localObject2).lT());
      paramString = this.uJO;
      if (paramString == null) {
        p.btv("megaVideoFeed");
      }
      paramString = paramString.tuP;
      if (paramString == null) {
        break label603;
      }
      paramInt1 = paramString.MtK;
      paramString = this.uJO;
      if (paramString == null) {
        p.btv("megaVideoFeed");
      }
      paramString = paramString.tuP;
      if (paramString != null) {
        paramString.MtK = (paramInt1 + 1);
      }
      paramString = new hn();
      paramString.dLW.id = ((cs)paramq).twG;
      paramString.dLW.dMb = 1;
      paramString.dLW.dLK = 1;
      paramString.dLW.type = 10;
      EventCenter.instance.publish((IEvent)paramString);
      paramInt1 = i;
      label383:
      paramString = af.viA;
      paramString = this.uJO;
      if (paramString == null) {
        p.btv("megaVideoFeed");
      }
      paramString = paramString.tuP;
      if (paramString == null) {
        break label715;
      }
      paramString = paramString.MtI;
      if (paramString == null) {
        break label715;
      }
      l1 = paramString.hFK;
      label426:
      paramString = com.tencent.mm.ac.d.zs(l1);
      paramq = this.uJO;
      if (paramq == null) {
        p.btv("megaVideoFeed");
      }
      paramq = com.tencent.mm.ac.d.zs(paramq.lT());
      localObject2 = this.uJO;
      if (localObject2 == null) {
        p.btv("megaVideoFeed");
      }
      localObject2 = ((bm)localObject2).tuP;
      if (localObject2 == null) {
        break label721;
      }
      localObject2 = ((cng)localObject2).MtG;
      if (localObject2 == null) {
        break label721;
      }
      localObject2 = ((cnl)localObject2).media;
      if (localObject2 == null) {
        break label721;
      }
      localObject2 = (cod)j.kt((List)localObject2);
      if (localObject2 == null) {
        break label721;
      }
    }
    label715:
    label721:
    for (paramInt2 = ((cod)localObject2).Mur;; paramInt2 = 0)
    {
      i = j;
      if (localObject1 != null)
      {
        localObject2 = ((cni)localObject1).content;
        i = j;
        if (localObject2 != null) {
          i = ((String)localObject2).length();
        }
      }
      l1 = l2;
      if (localObject1 != null) {
        l1 = ((cni)localObject1).MtO;
      }
      af.a(paramString, paramq, paramInt2, i, l1, paramInt1);
      AppMethodBeat.o(248256);
      return;
      label603:
      paramInt1 = 0;
      break;
      label608:
      if (paramInt2 == -8000)
      {
        paramString = y.vXH;
        paramString = this.uJS.getContext();
        p.g(paramString, "bulletView.context");
        paramq = this.uJS.getContext().getString(2131763005);
        p.g(paramq, "bulletView.context.getSt…_bullet_has_closed_toast)");
        y.aF(paramString, paramq);
        paramInt1 = 2;
        break label383;
      }
      Log.e("MegaVideoBulletManager", "NetSceneMegaVideoBulletPost: errType=" + paramInt1 + ", errCode=" + paramInt2 + ", errMsg=" + paramString);
      paramInt1 = 2;
      break label383;
      l1 = 0L;
      break label426;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/megavideo/bullet/MegaVideoBulletManager$Companion;", "", "()V", "DURATION_THRESHOLD", "", "LANDSCAPE_BULLET_DURATION", "", "PORTRAIT_BULLET_DURATION", "TAG", "", "plugin-finder_release"})
  public static final class a {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/megavideo/bullet/MegaVideoBulletManager$bulletLoaderListener$1", "Lcom/tencent/mm/plugin/finder/megavideo/loader/MegaVideoBulletLoader$BulletLoadListener;", "onBulletIncrease", "", "increaseList", "", "Lcom/tencent/mm/protocal/protobuf/MegaVideoBulletCommentInfo;", "plugin-finder_release"})
  public static final class c
    implements com.tencent.mm.plugin.finder.megavideo.loader.a.a
  {
    public final void eh(List<? extends cni> paramList)
    {
      AppMethodBeat.i(248252);
      p.h(paramList, "increaseList");
      a locala = this.uJU;
      bm localbm = this.uJU.uJO;
      if (localbm == null) {
        p.btv("megaVideoFeed");
      }
      a.a(locala, localbm.ej(paramList));
      AppMethodBeat.o(248252);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "getPlayTime"})
  static final class d
    implements h
  {
    d(a parama) {}
    
    public final long asQ()
    {
      return this.uJU.iGC;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Lcom/tencent/mm/plugin/finder/megavideo/bullet/TextDanmaku;", "danmakuContext", "Lcom/tencent/mm/danmaku/inject/DanmakuContext;", "kotlin.jvm.PlatformType", "danmakuType", "", "createDanmaku"})
  static final class e
    implements com.tencent.mm.danmaku.c.d
  {
    public static final e uJV;
    
    static
    {
      AppMethodBeat.i(248254);
      uJV = new e();
      AppMethodBeat.o(248254);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.megavideo.bullet.a
 * JD-Core Version:    0.7.0.1
 */