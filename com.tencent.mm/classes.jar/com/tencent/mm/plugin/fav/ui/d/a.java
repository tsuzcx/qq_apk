package com.tencent.mm.plugin.fav.ui.d;

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
import com.tencent.mm.plugin.appbrand.service.f;
import com.tencent.mm.plugin.appbrand.service.q;
import com.tencent.mm.plugin.appbrand.service.r;
import com.tencent.mm.plugin.fav.ui.o;
import com.tencent.mm.protocal.protobuf.amj;
import com.tencent.mm.protocal.protobuf.aml;
import com.tencent.mm.protocal.protobuf.anb;
import com.tencent.mm.protocal.protobuf.and;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.widget.imageview.WeImageView;

public final class a
  extends b
{
  private final int tlc;
  
  public a(o paramo)
  {
    super(paramo);
    AppMethodBeat.i(235375);
    this.tlc = com.tencent.mm.cb.a.aG(paramo.context, 2131165369);
    AppMethodBeat.o(235375);
  }
  
  public final View a(View paramView, ViewGroup paramViewGroup, com.tencent.mm.plugin.fav.a.g paramg)
  {
    AppMethodBeat.i(235376);
    Context localContext = paramViewGroup.getContext();
    aml localaml;
    if (paramView == null)
    {
      paramViewGroup = new a();
      paramView = a(View.inflate(localContext, 2131494123, null), paramViewGroup, paramg);
      paramViewGroup.nnL = ((ImageView)paramView.findViewById(2131300468));
      paramViewGroup.tld = ((ImageView)paramView.findViewById(2131300475));
      paramViewGroup.jVO = ((TextView)paramView.findViewById(2131300526));
      a(paramViewGroup, paramg);
      localaml = com.tencent.mm.plugin.fav.a.b.c(paramg);
      String str = paramg.field_favProto.title;
      localObject = str;
      if (Util.isNullOrNil(str)) {
        localObject = localaml.title;
      }
      paramViewGroup.jVO.setText((CharSequence)localObject);
      paramViewGroup.tli.setImageResource(2131690836);
      paramViewGroup.tli.setIconColor(localContext.getResources().getColor(2131099662));
      paramViewGroup.tli.setAlpha(0.3F);
      paramViewGroup.tli.setVisibility(0);
      if ((paramg.field_favProto.Lxf == null) || (paramg.field_favProto.Lxf.subType != 1)) {
        break label311;
      }
      paramViewGroup.tld.setVisibility(0);
      label201:
      if (paramg.field_favProto.Lxf == null) {
        break label367;
      }
    }
    label311:
    label367:
    for (Object localObject = ((f)com.tencent.mm.kernel.g.af(f.class)).vN(paramg.field_favProto.Lxf.dMe);; localObject = null)
    {
      if ((localObject == null) || (Util.isNullOrNil((String)((Pair)localObject).first)))
      {
        paramViewGroup.tlj.setText(null);
        paramViewGroup.tlj.setVisibility(8);
      }
      for (;;)
      {
        o.a(paramViewGroup.nnL, 2131690178, localaml, paramg, false, this.tlc, this.tlc);
        AppMethodBeat.o(235376);
        return paramView;
        paramViewGroup = (a)paramView.getTag();
        break;
        paramViewGroup.tld.setVisibility(8);
        break label201;
        paramViewGroup.tlj.setText((CharSequence)((Pair)localObject).first);
        paramViewGroup.tlj.setBackgroundResource(((Integer)((Pair)localObject).second).intValue());
        paramViewGroup.tlj.setVisibility(0);
      }
    }
  }
  
  public final void a(View paramView, and paramand)
  {
    AppMethodBeat.i(235377);
    paramand = ((b.b)paramView.getTag()).tbr.field_favProto.Lxf;
    if (paramand == null)
    {
      Log.e("MicroMsg.FavAppBrandListItem", "onListItemClick appBrandItem null");
      AppMethodBeat.o(235377);
      return;
    }
    com.tencent.mm.plugin.appbrand.api.g localg = new com.tencent.mm.plugin.appbrand.api.g();
    localg.username = paramand.username;
    localg.appId = paramand.appId;
    localg.iOo = paramand.dMe;
    localg.version = paramand.version;
    localg.kHw = paramand.dCx;
    localg.scene = 1010;
    localg.kHF = new AppBrandLaunchReferrer();
    localg.kHF.eda = paramand.eda;
    localg.kHF.leo = 6;
    ((r)com.tencent.mm.kernel.g.af(r.class)).a(paramView.getContext(), localg);
    AppMethodBeat.o(235377);
  }
  
  protected final void a(b.b paramb)
  {
    AppMethodBeat.i(235378);
    Object localObject = paramb.kgE.getContext().getString(2131756040);
    if (paramb.tbr.field_favProto.Lxf != null)
    {
      localObject = paramb.tbr.field_favProto.Lxf.username;
      localObject = ((q)com.tencent.mm.kernel.g.af(q.class)).Xk((String)localObject);
      if (localObject == null) {
        break label87;
      }
    }
    label87:
    for (localObject = ((WxaAttributes)localObject).field_nickname;; localObject = paramb.kgE.getContext().getString(2131756040))
    {
      paramb.kgE.setText((CharSequence)localObject);
      AppMethodBeat.o(235378);
      return;
    }
  }
  
  public static final class a
    extends b.b
  {
    TextView jVO;
    ImageView nnL;
    ImageView tld;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.d.a
 * JD-Core Version:    0.7.0.1
 */