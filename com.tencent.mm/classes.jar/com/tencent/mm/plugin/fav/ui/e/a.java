package com.tencent.mm.plugin.fav.ui.e;

import android.content.Context;
import android.content.res.Resources;
import android.util.Pair;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.a.f;
import com.tencent.mm.plugin.appbrand.config.AppBrandLaunchReferrer;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.service.m;
import com.tencent.mm.plugin.appbrand.service.n;
import com.tencent.mm.plugin.fav.ui.o;
import com.tencent.mm.protocal.protobuf.afw;
import com.tencent.mm.protocal.protobuf.afy;
import com.tencent.mm.protocal.protobuf.ago;
import com.tencent.mm.protocal.protobuf.agq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.widget.imageview.WeImageView;

public final class a
  extends b
{
  private final int qkA;
  
  public a(o paramo)
  {
    super(paramo);
    AppMethodBeat.i(186941);
    this.qkA = com.tencent.mm.cd.a.ao(paramo.context, 2131165358);
    AppMethodBeat.o(186941);
  }
  
  public final View a(View paramView, ViewGroup paramViewGroup, com.tencent.mm.plugin.fav.a.g paramg)
  {
    AppMethodBeat.i(186942);
    Context localContext = paramViewGroup.getContext();
    afy localafy;
    if (paramView == null)
    {
      paramViewGroup = new a();
      paramView = a(View.inflate(localContext, 2131496152, null), paramViewGroup, paramg);
      paramViewGroup.kXS = ((ImageView)paramView.findViewById(2131299794));
      paramViewGroup.qkB = ((ImageView)paramView.findViewById(2131299800));
      paramViewGroup.ica = ((TextView)paramView.findViewById(2131299848));
      a(paramViewGroup, paramg);
      localafy = com.tencent.mm.plugin.fav.a.b.c(paramg);
      String str = paramg.field_favProto.title;
      localObject = str;
      if (bt.isNullOrNil(str)) {
        localObject = localafy.title;
      }
      paramViewGroup.ica.setText((CharSequence)localObject);
      paramViewGroup.qkG.setImageResource(2131690597);
      paramViewGroup.qkG.setIconColor(localContext.getResources().getColor(2131099660));
      paramViewGroup.qkG.setAlpha(0.3F);
      paramViewGroup.qkG.setVisibility(0);
      if ((paramg.field_favProto.DhR == null) || (paramg.field_favProto.DhR.subType != 1)) {
        break label311;
      }
      paramViewGroup.qkB.setVisibility(0);
      label201:
      if (paramg.field_favProto.DhR == null) {
        break label367;
      }
    }
    label311:
    label367:
    for (Object localObject = ((com.tencent.mm.plugin.appbrand.service.g)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.appbrand.service.g.class)).qB(paramg.field_favProto.DhR.dkC);; localObject = null)
    {
      if ((localObject == null) || (bt.isNullOrNil((String)((Pair)localObject).first)))
      {
        paramViewGroup.qkH.setText(null);
        paramViewGroup.qkH.setVisibility(8);
      }
      for (;;)
      {
        o.a(paramViewGroup.kXS, 2131691463, localafy, paramg, false, this.qkA, this.qkA);
        AppMethodBeat.o(186942);
        return paramView;
        paramViewGroup = (a)paramView.getTag();
        break;
        paramViewGroup.qkB.setVisibility(8);
        break label201;
        paramViewGroup.qkH.setText((CharSequence)((Pair)localObject).first);
        paramViewGroup.qkH.setBackgroundResource(((Integer)((Pair)localObject).second).intValue());
        paramViewGroup.qkH.setVisibility(0);
      }
    }
  }
  
  public final void a(View paramView, agq paramagq)
  {
    AppMethodBeat.i(186943);
    paramagq = ((b.b)paramView.getTag()).qaS.field_favProto.DhR;
    f localf = new f();
    localf.username = paramagq.username;
    localf.appId = paramagq.appId;
    localf.gXn = paramagq.dkC;
    localf.version = paramagq.version;
    localf.iJb = paramagq.dbu;
    localf.scene = 1010;
    localf.iJk = new AppBrandLaunchReferrer();
    localf.iJk.dzY = paramagq.dzY;
    localf.iJk.jdC = 6;
    ((n)com.tencent.mm.kernel.g.ab(n.class)).a(paramView.getContext(), localf);
    AppMethodBeat.o(186943);
  }
  
  protected final void a(b.b paramb)
  {
    AppMethodBeat.i(186944);
    Object localObject = paramb.imt.getContext().getString(2131755945);
    if (paramb.qaS.field_favProto.DhR != null)
    {
      localObject = paramb.qaS.field_favProto.DhR.username;
      localObject = ((m)com.tencent.mm.kernel.g.ab(m.class)).FW((String)localObject);
      if (localObject == null) {
        break label87;
      }
    }
    label87:
    for (localObject = ((WxaAttributes)localObject).field_nickname;; localObject = paramb.imt.getContext().getString(2131755945))
    {
      paramb.imt.setText((CharSequence)localObject);
      AppMethodBeat.o(186944);
      return;
    }
  }
  
  public static final class a
    extends b.b
  {
    TextView ica;
    ImageView kXS;
    ImageView qkB;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.e.a
 * JD-Core Version:    0.7.0.1
 */