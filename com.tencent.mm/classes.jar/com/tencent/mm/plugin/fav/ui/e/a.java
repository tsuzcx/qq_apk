package com.tencent.mm.plugin.fav.ui.e;

import android.content.Context;
import android.content.res.Resources;
import android.util.Pair;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.AppBrandLaunchReferrer;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.service.n;
import com.tencent.mm.protocal.protobuf.ajl;
import com.tencent.mm.protocal.protobuf.ajn;
import com.tencent.mm.protocal.protobuf.akd;
import com.tencent.mm.protocal.protobuf.akf;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.widget.imageview.WeImageView;

public final class a
  extends b
{
  private final int rDf;
  
  public a(com.tencent.mm.plugin.fav.ui.o paramo)
  {
    super(paramo);
    AppMethodBeat.i(218827);
    this.rDf = com.tencent.mm.cc.a.ax(paramo.context, 2131165358);
    AppMethodBeat.o(218827);
  }
  
  public final View a(View paramView, ViewGroup paramViewGroup, com.tencent.mm.plugin.fav.a.g paramg)
  {
    AppMethodBeat.i(218828);
    Context localContext = paramViewGroup.getContext();
    ajn localajn;
    if (paramView == null)
    {
      paramViewGroup = new a();
      paramView = a(View.inflate(localContext, 2131496152, null), paramViewGroup, paramg);
      paramViewGroup.lZa = ((ImageView)paramView.findViewById(2131299794));
      paramViewGroup.rDg = ((ImageView)paramView.findViewById(2131299800));
      paramViewGroup.iVq = ((TextView)paramView.findViewById(2131299848));
      a(paramViewGroup, paramg);
      localajn = com.tencent.mm.plugin.fav.a.b.c(paramg);
      String str = paramg.field_favProto.title;
      localObject = str;
      if (bt.isNullOrNil(str)) {
        localObject = localajn.title;
      }
      paramViewGroup.iVq.setText((CharSequence)localObject);
      paramViewGroup.rDl.setImageResource(2131690597);
      paramViewGroup.rDl.setIconColor(localContext.getResources().getColor(2131099660));
      paramViewGroup.rDl.setAlpha(0.3F);
      paramViewGroup.rDl.setVisibility(0);
      if ((paramg.field_favProto.GiJ == null) || (paramg.field_favProto.GiJ.subType != 1)) {
        break label311;
      }
      paramViewGroup.rDg.setVisibility(0);
      label201:
      if (paramg.field_favProto.GiJ == null) {
        break label367;
      }
    }
    label311:
    label367:
    for (Object localObject = ((com.tencent.mm.plugin.appbrand.service.f)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.appbrand.service.f.class)).rO(paramg.field_favProto.GiJ.dtF);; localObject = null)
    {
      if ((localObject == null) || (bt.isNullOrNil((String)((Pair)localObject).first)))
      {
        paramViewGroup.rDm.setText(null);
        paramViewGroup.rDm.setVisibility(8);
      }
      for (;;)
      {
        com.tencent.mm.plugin.fav.ui.o.a(paramViewGroup.lZa, 2131691463, localajn, paramg, false, this.rDf, this.rDf);
        AppMethodBeat.o(218828);
        return paramView;
        paramViewGroup = (a)paramView.getTag();
        break;
        paramViewGroup.rDg.setVisibility(8);
        break label201;
        paramViewGroup.rDm.setText((CharSequence)((Pair)localObject).first);
        paramViewGroup.rDm.setBackgroundResource(((Integer)((Pair)localObject).second).intValue());
        paramViewGroup.rDm.setVisibility(0);
      }
    }
  }
  
  public final void a(View paramView, akf paramakf)
  {
    AppMethodBeat.i(218829);
    paramakf = ((b.b)paramView.getTag()).rtA.field_favProto.GiJ;
    if (paramakf == null)
    {
      ad.e("MicroMsg.FavAppBrandListItem", "onListItemClick appBrandItem null");
      AppMethodBeat.o(218829);
      return;
    }
    com.tencent.mm.plugin.appbrand.api.f localf = new com.tencent.mm.plugin.appbrand.api.f();
    localf.username = paramakf.username;
    localf.appId = paramakf.appId;
    localf.hQh = paramakf.dtF;
    localf.version = paramakf.version;
    localf.jCN = paramakf.dki;
    localf.scene = 1010;
    localf.jCW = new AppBrandLaunchReferrer();
    localf.jCW.dJW = paramakf.dJW;
    localf.jCW.jXR = 6;
    ((com.tencent.mm.plugin.appbrand.service.o)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.appbrand.service.o.class)).a(paramView.getContext(), localf);
    AppMethodBeat.o(218829);
  }
  
  protected final void a(b.b paramb)
  {
    AppMethodBeat.i(218830);
    Object localObject = paramb.jfJ.getContext().getString(2131755945);
    if (paramb.rtA.field_favProto.GiJ != null)
    {
      localObject = paramb.rtA.field_favProto.GiJ.username;
      localObject = ((n)com.tencent.mm.kernel.g.ab(n.class)).Nt((String)localObject);
      if (localObject == null) {
        break label87;
      }
    }
    label87:
    for (localObject = ((WxaAttributes)localObject).field_nickname;; localObject = paramb.jfJ.getContext().getString(2131755945))
    {
      paramb.jfJ.setText((CharSequence)localObject);
      AppMethodBeat.o(218830);
      return;
    }
  }
  
  public static final class a
    extends b.b
  {
    TextView iVq;
    ImageView lZa;
    ImageView rDg;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.e.a
 * JD-Core Version:    0.7.0.1
 */