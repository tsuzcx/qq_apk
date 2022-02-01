package com.tencent.mm.plugin.finder.nearby.newlivesquare.adapter.main;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.nearby.newlivesquare.adapter.main.viewconvert.e;
import com.tencent.mm.plugin.finder.nearby.newlivesquare.adapter.main.viewconvert.g;
import com.tencent.mm.plugin.finder.nearby.newlivesquare.adapter.main.viewconvert.k;
import com.tencent.mm.plugin.finder.nearby.newlivesquare.adapter.main.viewconvert.l;
import com.tencent.mm.plugin.finder.utils.at;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.bd;
import com.tencent.mm.view.recyclerview.f;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.m;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/nearby/newlivesquare/adapter/main/NewEntranceItemConvertFactory;", "Lcom/tencent/mm/plugin/finder/nearby/newlivesquare/adapter/main/BaseFactory;", "context", "Lcom/tencent/mm/ui/MMActivity;", "isForceNightMode", "", "isLocalCityPage", "commentScene", "", "outsideOperator", "Lcom/tencent/mm/plugin/finder/nearby/newlivesquare/InnerAdapterLinkOutsideOperator;", "autoPlayChecker", "Lcom/tencent/mm/plugin/finder/nearby/newlivesquare/OutsideEventCallListener;", "(Lcom/tencent/mm/ui/MMActivity;ZZILcom/tencent/mm/plugin/finder/nearby/newlivesquare/InnerAdapterLinkOutsideOperator;Lcom/tencent/mm/plugin/finder/nearby/newlivesquare/OutsideEventCallListener;)V", "leftRightMargin", "livingWidth", "screenWidth", "getScreenWidth", "()I", "getItemConvert", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "type", "jumpProfile", "", "Landroid/content/Context;", "feedId", "", "username", "", "plugin-finder-nearby_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class i
  extends c
{
  final int AJo;
  private final boolean ALp;
  private final boolean ANc;
  private final com.tencent.mm.plugin.finder.nearby.newlivesquare.b ENg;
  private final int ENj;
  private final int ENk;
  private final com.tencent.mm.plugin.finder.nearby.newlivesquare.h ENm;
  final MMActivity lzt;
  private final int sJv;
  
  public i(MMActivity paramMMActivity, com.tencent.mm.plugin.finder.nearby.newlivesquare.b paramb, com.tencent.mm.plugin.finder.nearby.newlivesquare.h paramh)
  {
    AppMethodBeat.i(340603);
    this.lzt = paramMMActivity;
    this.ALp = false;
    this.ANc = false;
    this.AJo = 0;
    this.ENg = paramb;
    this.ENm = paramh;
    paramMMActivity = at.GiI;
    this.sJv = at.getScreenWidth();
    this.ENj = bd.fromDPToPix(MMApplicationContext.getContext(), 0);
    if (aw.ato()) {
      paramMMActivity = MMApplicationContext.getContext();
    }
    for (int i = bd.fromDPToPix(paramMMActivity, paramMMActivity.getResources().getConfiguration().screenWidthDp);; i = this.sJv)
    {
      this.ENk = ((i - this.ENj * 3) / 2);
      AppMethodBeat.o(340603);
      return;
    }
  }
  
  public final f<?> yF(int paramInt)
  {
    AppMethodBeat.i(340636);
    switch (paramInt)
    {
    default: 
      localf = (f)eFP();
      AppMethodBeat.o(340636);
      return localf;
    case -5000: 
      localf = (f)new com.tencent.mm.plugin.finder.nearby.newlivesquare.adapter.main.viewconvert.h(this.ENg);
      AppMethodBeat.o(340636);
      return localf;
    case 4: 
      localf = (f)new g(this.ENk, this.ENg, (m)new i.a(this));
      AppMethodBeat.o(340636);
      return localf;
    case 6: 
      localf = (f)new k(this.ENk, this.ENg, (m)new b(this), (byte)0);
      AppMethodBeat.o(340636);
      return localf;
    case 5: 
      localf = (f)new com.tencent.mm.plugin.finder.nearby.newlivesquare.adapter.main.viewconvert.b(this.ENm, this.ENg);
      AppMethodBeat.o(340636);
      return localf;
    case 1: 
      localf = (f)new e(this.ENm, this.ENg);
      AppMethodBeat.o(340636);
      return localf;
    case 2: 
      localf = (f)new com.tencent.mm.plugin.finder.nearby.newlivesquare.adapter.main.viewconvert.c(this.ENm, this.ENg);
      AppMethodBeat.o(340636);
      return localf;
    }
    f localf = (f)new l(this.ENm, this.ENg);
    AppMethodBeat.o(340636);
    return localf;
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "feedId", "", "username", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements m<Long, String, ah>
  {
    b(i parami)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.nearby.newlivesquare.adapter.main.i
 * JD-Core Version:    0.7.0.1
 */