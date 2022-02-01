package com.tencent.mm.plugin.finder.nearby.live.square.tab;

import android.content.Context;
import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.am.p;
import com.tencent.mm.plugin.finder.e.h;
import com.tencent.mm.plugin.finder.utils.v;
import com.tencent.mm.plugin.findersdk.b.i;
import com.tencent.mm.protocal.protobuf.bad;
import com.tencent.mm.protocal.protobuf.bnn;
import com.tencent.mm.protocal.protobuf.bui;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/nearby/live/square/tab/NearbyLiveSquareTabFetcher;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "context", "Landroid/content/Context;", "scene", "", "byPass", "", "encrypted_object_id", "object_nonce_id", "title", "(Landroid/content/Context;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getByPass", "()Ljava/lang/String;", "callback", "Lkotlin/Function5;", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/FinderLiveTabInfo;", "", "", "getContext", "()Landroid/content/Context;", "getEncrypted_object_id", "isRequestingLbs", "netSceneFetchSquareTabs", "Lcom/tencent/mm/plugin/finder/nearby/live/square/tab/NetSceneFetchSquareTabs;", "getObject_nonce_id", "getScene", "()I", "getTitle", "detach", "fetch", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "forcePermission", "isUseCache", "fetchLiveSquareTabs", "invokeSource", "fetchLiveSquareTabsForPermission", "fetchTabsInternal", "onSceneEnd", "errType", "errCode", "errMsg", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Companion", "plugin-finder-nearby_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  implements com.tencent.mm.am.h
{
  public static final a EMc;
  private kotlin.g.a.s<? super String, ? super String, ? super String, ? super LinkedList<bnn>, ? super Boolean, ah> Azf;
  private final String ELy;
  private final String EMd;
  private c EMe;
  private final Context context;
  private boolean isRequestingLbs;
  private final String object_nonce_id;
  private final int scene;
  private final String title;
  
  static
  {
    AppMethodBeat.i(341364);
    EMc = new a((byte)0);
    AppMethodBeat.o(341364);
  }
  
  public a(Context paramContext, int paramInt, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(341297);
    this.context = paramContext;
    this.scene = paramInt;
    this.ELy = paramString1;
    this.EMd = paramString2;
    this.object_nonce_id = paramString3;
    this.title = paramString4;
    AppMethodBeat.o(341297);
  }
  
  private final void a(final bui parambui, int paramInt)
  {
    AppMethodBeat.i(341322);
    Log.i("NearbyLiveSquareTabFetcher", "fetchLiveSquareTabsForPermission, contextObj:" + parambui + " invokeSource:" + paramInt);
    v localv = v.GgU;
    v.a((kotlin.g.a.a)d.EMh, (kotlin.g.a.a)new e(this, parambui), (kotlin.g.a.a)new f(this, parambui));
    AppMethodBeat.o(341322);
  }
  
  private final void a(bui parambui, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(341317);
    Log.i("NearbyLiveSquareTabFetcher", "fetchLiveSquareTabs, contextObj:" + parambui + " forcePermission:" + paramBoolean + " invokeSource:" + paramInt);
    if (paramBoolean)
    {
      a(parambui, paramInt);
      AppMethodBeat.o(341317);
      return;
    }
    c(parambui);
    AppMethodBeat.o(341317);
  }
  
  private final void c(bui parambui)
  {
    AppMethodBeat.i(341328);
    this.EMe = new c(parambui, this.scene, this.ELy, this.title, this.EMd, this.object_nonce_id);
    parambui = this.EMe;
    if (parambui != null) {
      com.tencent.mm.plugin.findersdk.b.h.a((com.tencent.mm.plugin.findersdk.b.h)parambui, this.context, this.context.getResources().getString(e.h.finder_waiting));
    }
    com.tencent.mm.kernel.h.aZW().a(4210, (com.tencent.mm.am.h)this);
    com.tencent.mm.kernel.h.aZW().a((p)this.EMe, 0);
    AppMethodBeat.o(341328);
  }
  
  public final void a(final bui parambui, final boolean paramBoolean1, boolean paramBoolean2, kotlin.g.a.s<? super String, ? super String, ? super String, ? super LinkedList<bnn>, ? super Boolean, ah> params)
  {
    AppMethodBeat.i(341379);
    kotlin.g.b.s.u(parambui, "contextObj");
    kotlin.g.b.s.u(params, "callback");
    Object localObject = com.tencent.mm.plugin.finder.nearby.trace.c.ERD;
    com.tencent.mm.plugin.finder.nearby.trace.c.eGR().aDn("startFetchTabs");
    Log.i("NearbyLiveSquareTabFetcher", "fetch forcePermission:" + paramBoolean1 + " isUseCache:" + paramBoolean2);
    this.Azf = params;
    if (paramBoolean2)
    {
      params = com.tencent.mm.plugin.finder.nearby.preload.a.EPD;
      params = com.tencent.mm.plugin.finder.nearby.preload.a.eGt();
      if (params != null)
      {
        localObject = com.tencent.mm.plugin.finder.nearby.report.b.EQs;
        if (params.EPU != com.tencent.mm.plugin.finder.nearby.preload.firstpage.a.a.EQa) {
          break label166;
        }
        paramBoolean2 = true;
        com.tencent.mm.plugin.finder.nearby.report.b.sT(paramBoolean2);
        localObject = params.EPU;
        switch (b.$EnumSwitchMapping$0[localObject.ordinal()])
        {
        }
      }
    }
    label166:
    do
    {
      a(parambui, paramBoolean1, 2);
      AppMethodBeat.o(341379);
      return;
      paramBoolean2 = false;
      break;
      params.at((kotlin.g.a.b)new c(this, parambui, paramBoolean1));
      AppMethodBeat.o(341379);
      return;
      params = params.eGz();
    } while (params == null);
    onSceneEnd(params.errCode, params.errType, params.errMsg, (p)params.hKP);
    AppMethodBeat.o(341379);
  }
  
  public final void detach()
  {
    AppMethodBeat.i(341370);
    com.tencent.mm.kernel.h.aZW().b(4210, (com.tencent.mm.am.h)this);
    AppMethodBeat.o(341370);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(341388);
    kotlin.g.b.s.u(paramp, "scene");
    Log.i("NearbyLiveSquareTabFetcher", "onSceneEnd handle NetSceneNearbyLiveSquareTabs, errType:" + paramInt1 + " errCode:" + paramInt2);
    com.tencent.mm.kernel.h.aZW().b(4210, (com.tencent.mm.am.h)this);
    if (((paramInt1 == 0) && (paramInt2 == 0)) || (paramInt2 == -200008))
    {
      paramString = ((c)paramp).eFE();
      paramp = com.tencent.mm.plugin.finder.nearby.trace.c.ERD;
      com.tencent.mm.plugin.finder.nearby.trace.c.eGR().aDn("fetchTabsDone");
      d.uiThread((kotlin.g.a.a)new g(paramString, this));
      AppMethodBeat.o(341388);
      return;
    }
    Log.e("NearbyLiveSquareTabFetcher", "onSceneEnd handle NetSceneNearbyLiveSquareTabs error");
    AppMethodBeat.o(341388);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/nearby/live/square/tab/NearbyLiveSquareTabFetcher$Companion;", "", "()V", "TAG", "", "plugin-finder-nearby_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/findersdk/cgi/PreloadResponse;", "Lcom/tencent/mm/modelbase/NetSceneBase;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements kotlin.g.a.b<i<p>, ah>
  {
    c(a parama, bui parambui, boolean paramBoolean)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements kotlin.g.a.a<ah>
  {
    public static final d EMh;
    
    static
    {
      AppMethodBeat.i(341228);
      EMh = new d();
      AppMethodBeat.o(341228);
    }
    
    d()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends u
    implements kotlin.g.a.a<ah>
  {
    e(a parama, bui parambui)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class f
    extends u
    implements kotlin.g.a.a<ah>
  {
    f(a parama, bui parambui)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class g
    extends u
    implements kotlin.g.a.a<ah>
  {
    g(bad parambad, a parama)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.nearby.live.square.tab.a
 * JD-Core Version:    0.7.0.1
 */