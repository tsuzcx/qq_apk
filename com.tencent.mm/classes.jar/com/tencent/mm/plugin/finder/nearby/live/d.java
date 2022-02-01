package com.tencent.mm.plugin.finder.nearby.live;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.convert.ad;
import com.tencent.mm.plugin.finder.convert.ae;
import com.tencent.mm.plugin.finder.convert.bs;
import com.tencent.mm.plugin.finder.convert.bt;
import com.tencent.mm.plugin.finder.convert.n;
import com.tencent.mm.plugin.finder.convert.z;
import com.tencent.mm.plugin.finder.model.cc;
import com.tencent.mm.plugin.finder.utils.at;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.bd;
import com.tencent.mm.view.recyclerview.f;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.m;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/nearby/live/NearbyLiveItemConvertFactory;", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "baseContext", "Lcom/tencent/mm/ui/MMActivity;", "presenter", "Lcom/tencent/mm/plugin/finder/nearby/live/NearbyLiveContract$Presenter;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "isForceNightMode", "", "isLocalCityPage", "commentScene", "", "(Lcom/tencent/mm/ui/MMActivity;Lcom/tencent/mm/plugin/finder/nearby/live/NearbyLiveContract$Presenter;ZZI)V", "screenWidth", "getScreenWidth", "()I", "createBigCardLiveConvert", "Lcom/tencent/mm/plugin/finder/nearby/newlivesquare/adapter/main/viewconvert/LivingConvert;", "createFinderEmptyConvert", "Lcom/tencent/mm/plugin/finder/convert/FinderEmptyConvert;", "createFinderFeedEmptyConvert", "Lcom/tencent/mm/plugin/finder/convert/FinderFeedEmptyConvert;", "createFinderFeedSameCityLiveConvert", "Lcom/tencent/mm/plugin/finder/convert/FinderFeedSameCityLiveConvert;", "createNearbyFinderSquareLiveFeedConvert", "Lcom/tencent/mm/plugin/finder/nearby/live/convert/NearbyFinderSquareLiveFeedConvert;", "createRelatedLiveFeedConvert", "Lcom/tencent/mm/plugin/finder/nearby/live/convert/NearbyFinderRelatedLivingConvert;", "getItemConvert", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "type", "jumpProfile", "", "context", "Landroid/content/Context;", "feedId", "", "username", "", "plugin-finder-nearby_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d
  implements com.tencent.mm.view.recyclerview.g
{
  final int AJo;
  private final boolean ALp;
  private final boolean ANc;
  final MMActivity AZo;
  final b.a<cc> EIR;
  private final int sJv;
  
  public d(MMActivity paramMMActivity, b.a<cc> parama, boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    AppMethodBeat.i(340632);
    this.AZo = paramMMActivity;
    this.EIR = parama;
    this.ALp = paramBoolean1;
    this.ANc = paramBoolean2;
    this.AJo = paramInt;
    paramMMActivity = at.GiI;
    this.sJv = at.getScreenWidth();
    AppMethodBeat.o(340632);
  }
  
  private final int getScreenWidth()
  {
    AppMethodBeat.i(370424);
    if (aw.ato())
    {
      Context localContext = MMApplicationContext.getContext();
      i = bd.fromDPToPix(localContext, localContext.getResources().getConfiguration().screenWidthDp);
      AppMethodBeat.o(370424);
      return i;
    }
    int i = this.sJv;
    AppMethodBeat.o(370424);
    return i;
  }
  
  public final f<?> yF(int paramInt)
  {
    AppMethodBeat.i(340646);
    switch (paramInt)
    {
    default: 
      if ((BuildInfo.DEBUG) || (BuildInfo.IS_FLAVOR_PURPLE) || (BuildInfo.IS_FLAVOR_RED))
      {
        localObject = new RuntimeException("type invalid");
        AppMethodBeat.o(340646);
        throw ((Throwable)localObject);
      }
      break;
    case 9: 
      paramInt = this.AJo;
      localObject = com.tencent.mm.plugin.finder.nearby.live.base.a.EJF;
      localObject = (f)new com.tencent.mm.plugin.finder.nearby.live.convert.b(paramInt, com.tencent.mm.plugin.finder.nearby.live.base.a.eEP() * 3.0F, this.ALp, this.ANc, (Context)this.AZo);
      AppMethodBeat.o(340646);
      return localObject;
    case -10: 
      localObject = (f)new ad((kotlin.g.a.b)new c(this));
      AppMethodBeat.o(340646);
      return localObject;
    case -3: 
      localObject = (f)new ae();
      AppMethodBeat.o(340646);
      return localObject;
    case -5: 
      localObject = (f)new z();
      AppMethodBeat.o(340646);
      return localObject;
    case 6: 
      localObject = (f)new bt(this.ALp);
      AppMethodBeat.o(340646);
      return localObject;
    case 4: 
      localObject = (f)new bs(this.ALp);
      AppMethodBeat.o(340646);
      return localObject;
    case -1: 
      localObject = (f)new n((kotlin.g.a.a)new a(this), (kotlin.g.a.a)new b(this), this.ALp);
      AppMethodBeat.o(340646);
      return localObject;
    case 2021: 
      localObject = (f)new com.tencent.mm.plugin.finder.nearby.live.convert.a(getScreenWidth(), (m)new d(this), (byte)0);
      AppMethodBeat.o(340646);
      return localObject;
    case 2022: 
      new d.f();
      localObject = new d.g();
      paramInt = bd.fromDPToPix(MMApplicationContext.getContext(), 0);
      localObject = (f)new com.tencent.mm.plugin.finder.nearby.newlivesquare.adapter.main.viewconvert.g(getScreenWidth() - paramInt * 2, 1.0F, (com.tencent.mm.plugin.finder.nearby.newlivesquare.b)localObject, (m)new d.e(this));
      AppMethodBeat.o(340646);
      return localObject;
    }
    Log.printInfoStack("RecyclerViewAdapterEx", "type invalid", new Object[0]);
    Object localObject = (f)new com.tencent.mm.plugin.finder.convert.g();
    AppMethodBeat.o(340646);
    return localObject;
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements kotlin.g.a.a<ah>
  {
    a(d paramd)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.a<ah>
  {
    b(d paramd)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Landroid/view/View;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements kotlin.g.a.b<View, ah>
  {
    c(d paramd)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "feedId", "", "username", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements m<Long, String, ah>
  {
    d(d paramd)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.nearby.live.d
 * JD-Core Version:    0.7.0.1
 */