package com.tencent.mm.plugin.finder.nearby.newlivesquare.adapter.main;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.nearby.newlivesquare.adapter.main.viewconvert.g;
import com.tencent.mm.plugin.finder.nearby.newlivesquare.adapter.main.viewconvert.i;
import com.tencent.mm.plugin.finder.nearby.newlivesquare.adapter.main.viewconvert.j;
import com.tencent.mm.plugin.finder.nearby.newlivesquare.adapter.main.viewconvert.k;
import com.tencent.mm.plugin.finder.nearby.newlivesquare.b;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.bd;
import kotlin.Metadata;
import kotlin.g.a.m;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/nearby/newlivesquare/adapter/main/SpecialColumnItemConvertFactory;", "Lcom/tencent/mm/plugin/finder/nearby/newlivesquare/adapter/main/BaseFactory;", "context", "Lcom/tencent/mm/ui/MMActivity;", "isForceNightMode", "", "isLocalCityPage", "commentScene", "", "outsideOperator", "Lcom/tencent/mm/plugin/finder/nearby/newlivesquare/InnerAdapterLinkOutsideOperator;", "(Lcom/tencent/mm/ui/MMActivity;ZZILcom/tencent/mm/plugin/finder/nearby/newlivesquare/InnerAdapterLinkOutsideOperator;)V", "livingWidth", "getItemConvert", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "type", "jumpProfile", "", "Landroid/content/Context;", "feedId", "", "username", "", "plugin-finder-nearby_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class l
  extends c
{
  final int AJo;
  private final boolean ALp;
  private final boolean ANc;
  private final b ENg;
  private final int ENk;
  final MMActivity lzt;
  
  public l(MMActivity paramMMActivity, b paramb)
  {
    AppMethodBeat.i(340420);
    this.lzt = paramMMActivity;
    this.ALp = false;
    this.ANc = false;
    this.AJo = 0;
    this.ENg = paramb;
    this.ENk = bd.fromDPToPix(MMApplicationContext.getContext(), 162);
    AppMethodBeat.o(340420);
  }
  
  public final com.tencent.mm.view.recyclerview.f<?> yF(int paramInt)
  {
    AppMethodBeat.i(340434);
    switch (paramInt)
    {
    default: 
      localf = (com.tencent.mm.view.recyclerview.f)eFP();
      AppMethodBeat.o(340434);
      return localf;
    case 4: 
      localf = (com.tencent.mm.view.recyclerview.f)new g(this.ENk, this.ENg, (m)new l.a(this));
      AppMethodBeat.o(340434);
      return localf;
    case 6: 
      localf = (com.tencent.mm.view.recyclerview.f)new k(this.ENk, this.ENg, (m)new l.b(this), (byte)0);
      AppMethodBeat.o(340434);
      return localf;
    case 5: 
      localf = (com.tencent.mm.view.recyclerview.f)new j();
      AppMethodBeat.o(340434);
      return localf;
    case -1000: 
      localf = (com.tencent.mm.view.recyclerview.f)new i(this.ENg);
      AppMethodBeat.o(340434);
      return localf;
    }
    com.tencent.mm.view.recyclerview.f localf = (com.tencent.mm.view.recyclerview.f)new com.tencent.mm.plugin.finder.nearby.newlivesquare.adapter.main.viewconvert.f(this.ENg);
    AppMethodBeat.o(340434);
    return localf;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.nearby.newlivesquare.adapter.main.l
 * JD-Core Version:    0.7.0.1
 */