package com.tencent.mm.plugin.finder.nearby.live.square.tab;

import android.content.Context;
import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.i;
import com.tencent.mm.plugin.finder.b.j;
import com.tencent.mm.plugin.findersdk.b.g;
import com.tencent.mm.protocal.protobuf.avf;
import com.tencent.mm.protocal.protobuf.bcz;
import com.tencent.mm.protocal.protobuf.bid;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;
import kotlin.g.a.b;
import kotlin.g.a.s;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/nearby/live/square/tab/NearbyLiveSquareTabFetcher;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "context", "Landroid/content/Context;", "scene", "", "byPass", "", "encrypted_object_id", "object_nonce_id", "title", "(Landroid/content/Context;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getByPass", "()Ljava/lang/String;", "callback", "Lkotlin/Function5;", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/FinderLiveTabInfo;", "", "", "getContext", "()Landroid/content/Context;", "getEncrypted_object_id", "isRequestingLbs", "netSceneFetchSquareTabs", "Lcom/tencent/mm/plugin/finder/nearby/live/square/tab/NetSceneFetchSquareTabs;", "getObject_nonce_id", "getScene", "()I", "getTitle", "detach", "fetch", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "forcePermission", "isUseCache", "fetchLiveSquareTabs", "invokeSource", "fetchLiveSquareTabsForPermission", "fetchTabsInternal", "onSceneEnd", "errType", "errCode", "errMsg", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Companion", "plugin-finder-nearby_release"})
public final class a
  implements i
{
  public static final a zGL;
  private final Context context;
  private boolean isRequestingLbs;
  private final String object_nonce_id;
  private final int scene;
  private final String title;
  private s<? super String, ? super String, ? super String, ? super LinkedList<bcz>, ? super Boolean, x> xaT;
  private e zGI;
  private final String zGJ;
  private final String zGK;
  
  static
  {
    AppMethodBeat.i(201744);
    zGL = new a((byte)0);
    AppMethodBeat.o(201744);
  }
  
  public a(Context paramContext, int paramInt, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(201741);
    this.context = paramContext;
    this.scene = paramInt;
    this.zGJ = paramString1;
    this.zGK = paramString2;
    this.object_nonce_id = paramString3;
    this.title = paramString4;
    AppMethodBeat.o(201741);
  }
  
  private final void a(final bid parambid, int paramInt)
  {
    AppMethodBeat.i(201731);
    Log.i("NearbyLiveSquareTabFetcher", "fetchLiveSquareTabsForPermission, contextObj:" + parambid + " invokeSource:" + paramInt);
    com.tencent.mm.plugin.finder.utils.q localq = com.tencent.mm.plugin.finder.utils.q.ADH;
    com.tencent.mm.plugin.finder.utils.q.a((kotlin.g.a.a)c.zGP, (kotlin.g.a.a)new d(this, parambid), (kotlin.g.a.a)new e(this, parambid));
    AppMethodBeat.o(201731);
  }
  
  private final void a(bid parambid, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(201728);
    Log.i("NearbyLiveSquareTabFetcher", "fetchLiveSquareTabs, contextObj:" + parambid + " forcePermission:" + paramBoolean + " invokeSource:" + paramInt);
    if (paramBoolean)
    {
      a(parambid, paramInt);
      AppMethodBeat.o(201728);
      return;
    }
    c(parambid);
    AppMethodBeat.o(201728);
  }
  
  private final void c(bid parambid)
  {
    AppMethodBeat.i(201734);
    this.zGI = new e(parambid, this.scene, this.zGJ, this.title, this.zGK, this.object_nonce_id);
    parambid = this.zGI;
    if (parambid != null) {
      g.a(parambid, this.context, this.context.getResources().getString(b.j.finder_waiting));
    }
    com.tencent.mm.kernel.h.aGY().a(4210, (i)this);
    com.tencent.mm.kernel.h.aGY().b((com.tencent.mm.an.q)this.zGI);
    AppMethodBeat.o(201734);
  }
  
  public final void a(final bid parambid, final boolean paramBoolean1, boolean paramBoolean2, s<? super String, ? super String, ? super String, ? super LinkedList<bcz>, ? super Boolean, x> params)
  {
    AppMethodBeat.i(201723);
    p.k(parambid, "contextObj");
    p.k(params, "callback");
    Object localObject = com.tencent.mm.plugin.finder.nearby.trace.c.zJD;
    com.tencent.mm.plugin.finder.nearby.trace.c.dMD().aGV("startFetchTabs");
    Log.i("NearbyLiveSquareTabFetcher", "fetch forcePermission:" + paramBoolean1 + " isUseCache:" + paramBoolean2);
    this.xaT = params;
    if (paramBoolean2)
    {
      params = com.tencent.mm.plugin.finder.nearby.preload.a.zIv;
      params = com.tencent.mm.plugin.finder.nearby.preload.a.dMo();
      if (params != null)
      {
        localObject = params.zIC;
        switch (b.$EnumSwitchMapping$0[localObject.ordinal()])
        {
        }
      }
    }
    do
    {
      a(parambid, paramBoolean1, 2);
      AppMethodBeat.o(201723);
      return;
      params.N((b)new b(this, parambid, paramBoolean1));
      AppMethodBeat.o(201723);
      return;
      params = params.dMt();
    } while (params == null);
    onSceneEnd(params.errCode, params.errType, params.errMsg, (com.tencent.mm.an.q)params.BvG);
    AppMethodBeat.o(201723);
  }
  
  public final void detach()
  {
    AppMethodBeat.i(201717);
    com.tencent.mm.kernel.h.aGY().b(4210, (i)this);
    AppMethodBeat.o(201717);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, final String paramString, com.tencent.mm.an.q paramq)
  {
    AppMethodBeat.i(201738);
    p.k(paramq, "scene");
    Log.i("NearbyLiveSquareTabFetcher", "onSceneEnd handle NetSceneNearbyLiveSquareTabs, errType:" + paramInt1 + " errCode:" + paramInt2);
    com.tencent.mm.kernel.h.aGY().b(4210, (i)this);
    if (((paramInt1 == 0) && (paramInt2 == 0)) || (paramInt2 == -200008))
    {
      paramString = ((e)paramq).rr;
      if (paramString == null) {
        p.iCn();
      }
      paramString = paramString.bhY();
      if (paramString == null)
      {
        paramString = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetLiveTabsResponse");
        AppMethodBeat.o(201738);
        throw paramString;
      }
      paramString = (avf)paramString;
      paramq = com.tencent.mm.plugin.finder.nearby.trace.c.zJD;
      com.tencent.mm.plugin.finder.nearby.trace.c.dMD().aGV("fetchTabsDone");
      com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new f(this, paramString));
      AppMethodBeat.o(201738);
      return;
    }
    Log.e("NearbyLiveSquareTabFetcher", "onSceneEnd handle NetSceneNearbyLiveSquareTabs error");
    AppMethodBeat.o(201738);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/nearby/live/square/tab/NearbyLiveSquareTabFetcher$Companion;", "", "()V", "TAG", "", "plugin-finder-nearby_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/findersdk/cgi/PreloadResponse;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "invoke", "com/tencent/mm/plugin/finder/nearby/live/square/tab/NearbyLiveSquareTabFetcher$fetch$1$1"})
  static final class b
    extends kotlin.g.b.q
    implements b<com.tencent.mm.plugin.findersdk.b.h<com.tencent.mm.an.q>, x>
  {
    b(a parama, bid parambid, boolean paramBoolean)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class c
    extends kotlin.g.b.q
    implements kotlin.g.a.a<x>
  {
    public static final c zGP;
    
    static
    {
      AppMethodBeat.i(199611);
      zGP = new c();
      AppMethodBeat.o(199611);
    }
    
    c()
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class d
    extends kotlin.g.b.q
    implements kotlin.g.a.a<x>
  {
    d(a parama, bid parambid)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class e
    extends kotlin.g.b.q
    implements kotlin.g.a.a<x>
  {
    e(a parama, bid parambid)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class f
    extends kotlin.g.b.q
    implements kotlin.g.a.a<x>
  {
    f(a parama, avf paramavf)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.nearby.live.square.tab.a
 * JD-Core Version:    0.7.0.1
 */