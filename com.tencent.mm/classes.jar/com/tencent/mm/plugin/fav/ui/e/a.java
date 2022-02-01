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
import com.tencent.mm.plugin.appbrand.service.p;
import com.tencent.mm.protocal.protobuf.ajv;
import com.tencent.mm.protocal.protobuf.ajx;
import com.tencent.mm.protocal.protobuf.akn;
import com.tencent.mm.protocal.protobuf.akp;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.widget.imageview.WeImageView;

public final class a
  extends b
{
  private final int rLq;
  
  public a(com.tencent.mm.plugin.fav.ui.o paramo)
  {
    super(paramo);
    AppMethodBeat.i(191102);
    this.rLq = com.tencent.mm.cb.a.ax(paramo.context, 2131165358);
    AppMethodBeat.o(191102);
  }
  
  public final View a(View paramView, ViewGroup paramViewGroup, com.tencent.mm.plugin.fav.a.g paramg)
  {
    AppMethodBeat.i(191103);
    Context localContext = paramViewGroup.getContext();
    ajx localajx;
    if (paramView == null)
    {
      paramViewGroup = new a();
      paramView = a(View.inflate(localContext, 2131496152, null), paramViewGroup, paramg);
      paramViewGroup.mdt = ((ImageView)paramView.findViewById(2131299794));
      paramViewGroup.rLr = ((ImageView)paramView.findViewById(2131299800));
      paramViewGroup.iYj = ((TextView)paramView.findViewById(2131299848));
      a(paramViewGroup, paramg);
      localajx = com.tencent.mm.plugin.fav.a.b.c(paramg);
      String str = paramg.field_favProto.title;
      localObject = str;
      if (bu.isNullOrNil(str)) {
        localObject = localajx.title;
      }
      paramViewGroup.iYj.setText((CharSequence)localObject);
      paramViewGroup.rLw.setImageResource(2131690597);
      paramViewGroup.rLw.setIconColor(localContext.getResources().getColor(2131099660));
      paramViewGroup.rLw.setAlpha(0.3F);
      paramViewGroup.rLw.setVisibility(0);
      if ((paramg.field_favProto.GBs == null) || (paramg.field_favProto.GBs.subType != 1)) {
        break label311;
      }
      paramViewGroup.rLr.setVisibility(0);
      label201:
      if (paramg.field_favProto.GBs == null) {
        break label367;
      }
    }
    label311:
    label367:
    for (Object localObject = ((com.tencent.mm.plugin.appbrand.service.f)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.appbrand.service.f.class)).rR(paramg.field_favProto.GBs.duK);; localObject = null)
    {
      if ((localObject == null) || (bu.isNullOrNil((String)((Pair)localObject).first)))
      {
        paramViewGroup.rLx.setText(null);
        paramViewGroup.rLx.setVisibility(8);
      }
      for (;;)
      {
        com.tencent.mm.plugin.fav.ui.o.a(paramViewGroup.mdt, 2131691463, localajx, paramg, false, this.rLq, this.rLq);
        AppMethodBeat.o(191103);
        return paramView;
        paramViewGroup = (a)paramView.getTag();
        break;
        paramViewGroup.rLr.setVisibility(8);
        break label201;
        paramViewGroup.rLx.setText((CharSequence)((Pair)localObject).first);
        paramViewGroup.rLx.setBackgroundResource(((Integer)((Pair)localObject).second).intValue());
        paramViewGroup.rLx.setVisibility(0);
      }
    }
  }
  
  public final void a(View paramView, akp paramakp)
  {
    AppMethodBeat.i(191104);
    paramakp = ((b.b)paramView.getTag()).rBM.field_favProto.GBs;
    if (paramakp == null)
    {
      ae.e("MicroMsg.FavAppBrandListItem", "onListItemClick appBrandItem null");
      AppMethodBeat.o(191104);
      return;
    }
    com.tencent.mm.plugin.appbrand.api.f localf = new com.tencent.mm.plugin.appbrand.api.f();
    localf.username = paramakp.username;
    localf.appId = paramakp.appId;
    localf.hSZ = paramakp.duK;
    localf.version = paramakp.version;
    localf.jFL = paramakp.dlk;
    localf.scene = 1010;
    localf.jFU = new AppBrandLaunchReferrer();
    localf.jFU.dLl = paramakp.dLl;
    localf.jFU.kbg = 6;
    ((p)com.tencent.mm.kernel.g.ab(p.class)).a(paramView.getContext(), localf);
    AppMethodBeat.o(191104);
  }
  
  protected final void a(b.b paramb)
  {
    AppMethodBeat.i(191105);
    Object localObject = paramb.jiC.getContext().getString(2131755945);
    if (paramb.rBM.field_favProto.GBs != null)
    {
      localObject = paramb.rBM.field_favProto.GBs.username;
      localObject = ((com.tencent.mm.plugin.appbrand.service.o)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.appbrand.service.o.class)).Ob((String)localObject);
      if (localObject == null) {
        break label87;
      }
    }
    label87:
    for (localObject = ((WxaAttributes)localObject).field_nickname;; localObject = paramb.jiC.getContext().getString(2131755945))
    {
      paramb.jiC.setText((CharSequence)localObject);
      AppMethodBeat.o(191105);
      return;
    }
  }
  
  public static final class a
    extends b.b
  {
    TextView iYj;
    ImageView mdt;
    ImageView rLr;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.e.a
 * JD-Core Version:    0.7.0.1
 */