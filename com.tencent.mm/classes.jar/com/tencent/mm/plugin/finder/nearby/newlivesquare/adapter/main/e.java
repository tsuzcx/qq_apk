package com.tencent.mm.plugin.finder.nearby.newlivesquare.adapter.main;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.nearby.newlivesquare.adapter.main.viewconvert.g;
import com.tencent.mm.plugin.finder.nearby.newlivesquare.b;
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

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/nearby/newlivesquare/adapter/main/BigBannerItemConvertFactory;", "Lcom/tencent/mm/plugin/finder/nearby/newlivesquare/adapter/main/BaseFactory;", "context", "Lcom/tencent/mm/ui/MMActivity;", "isForceNightMode", "", "isLocalCityPage", "commentScene", "", "outsideOperator", "Lcom/tencent/mm/plugin/finder/nearby/newlivesquare/InnerAdapterLinkOutsideOperator;", "(Lcom/tencent/mm/ui/MMActivity;ZZILcom/tencent/mm/plugin/finder/nearby/newlivesquare/InnerAdapterLinkOutsideOperator;)V", "leftRightMargin", "livingWidth", "screenWidth", "getScreenWidth", "()I", "getItemConvert", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "type", "jumpProfile", "", "Landroid/content/Context;", "feedId", "", "username", "", "plugin-finder-nearby_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class e
  extends c
{
  final int AJo;
  private final boolean ALp;
  private final boolean ANc;
  private final b ENg;
  private final int ENj;
  private final int ENk;
  final MMActivity lzt;
  private final int sJv;
  
  public e(MMActivity paramMMActivity, b paramb)
  {
    AppMethodBeat.i(340426);
    this.lzt = paramMMActivity;
    this.ALp = false;
    this.ANc = false;
    this.AJo = 0;
    this.ENg = paramb;
    paramMMActivity = at.GiI;
    this.sJv = at.getScreenWidth();
    this.ENj = bd.fromDPToPix(MMApplicationContext.getContext(), 0);
    if (aw.ato()) {
      paramMMActivity = MMApplicationContext.getContext();
    }
    for (int i = bd.fromDPToPix(paramMMActivity, paramMMActivity.getResources().getConfiguration().screenWidthDp);; i = this.sJv)
    {
      this.ENk = (i - this.ENj * 2);
      AppMethodBeat.o(340426);
      return;
    }
  }
  
  public final f<?> yF(int paramInt)
  {
    AppMethodBeat.i(340433);
    if (paramInt == 2)
    {
      localf = (f)new g(this.ENk, 1.0F, this.ENg, (m)new a(this));
      AppMethodBeat.o(340433);
      return localf;
    }
    f localf = (f)eFP();
    AppMethodBeat.o(340433);
    return localf;
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "feedId", "", "username", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements m<Long, String, ah>
  {
    a(e parame)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.nearby.newlivesquare.adapter.main.e
 * JD-Core Version:    0.7.0.1
 */