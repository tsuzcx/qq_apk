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
import com.tencent.mm.plugin.appbrand.service.m;
import com.tencent.mm.plugin.appbrand.service.n;
import com.tencent.mm.plugin.fav.ui.o;
import com.tencent.mm.protocal.protobuf.agv;
import com.tencent.mm.protocal.protobuf.agx;
import com.tencent.mm.protocal.protobuf.ahn;
import com.tencent.mm.protocal.protobuf.ahp;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.widget.imageview.WeImageView;

public final class a
  extends b
{
  private final int qTc;
  
  public a(o paramo)
  {
    super(paramo);
    AppMethodBeat.i(209509);
    this.qTc = com.tencent.mm.cc.a.au(paramo.context, 2131165358);
    AppMethodBeat.o(209509);
  }
  
  public final View a(View paramView, ViewGroup paramViewGroup, com.tencent.mm.plugin.fav.a.g paramg)
  {
    AppMethodBeat.i(209510);
    Context localContext = paramViewGroup.getContext();
    agx localagx;
    if (paramView == null)
    {
      paramViewGroup = new a();
      paramView = a(View.inflate(localContext, 2131496152, null), paramViewGroup, paramg);
      paramViewGroup.lzC = ((ImageView)paramView.findViewById(2131299794));
      paramViewGroup.qTd = ((ImageView)paramView.findViewById(2131299800));
      paramViewGroup.iCg = ((TextView)paramView.findViewById(2131299848));
      a(paramViewGroup, paramg);
      localagx = com.tencent.mm.plugin.fav.a.b.c(paramg);
      String str = paramg.field_favProto.title;
      localObject = str;
      if (bs.isNullOrNil(str)) {
        localObject = localagx.title;
      }
      paramViewGroup.iCg.setText((CharSequence)localObject);
      paramViewGroup.qTi.setImageResource(2131690597);
      paramViewGroup.qTi.setIconColor(localContext.getResources().getColor(2131099660));
      paramViewGroup.qTi.setAlpha(0.3F);
      paramViewGroup.qTi.setVisibility(0);
      if ((paramg.field_favProto.EAX == null) || (paramg.field_favProto.EAX.subType != 1)) {
        break label311;
      }
      paramViewGroup.qTd.setVisibility(0);
      label201:
      if (paramg.field_favProto.EAX == null) {
        break label367;
      }
    }
    label311:
    label367:
    for (Object localObject = ((com.tencent.mm.plugin.appbrand.service.f)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.appbrand.service.f.class)).ro(paramg.field_favProto.EAX.dib);; localObject = null)
    {
      if ((localObject == null) || (bs.isNullOrNil((String)((Pair)localObject).first)))
      {
        paramViewGroup.qTj.setText(null);
        paramViewGroup.qTj.setVisibility(8);
      }
      for (;;)
      {
        o.a(paramViewGroup.lzC, 2131691463, localagx, paramg, false, this.qTc, this.qTc);
        AppMethodBeat.o(209510);
        return paramView;
        paramViewGroup = (a)paramView.getTag();
        break;
        paramViewGroup.qTd.setVisibility(8);
        break label201;
        paramViewGroup.qTj.setText((CharSequence)((Pair)localObject).first);
        paramViewGroup.qTj.setBackgroundResource(((Integer)((Pair)localObject).second).intValue());
        paramViewGroup.qTj.setVisibility(0);
      }
    }
  }
  
  public final void a(View paramView, ahp paramahp)
  {
    AppMethodBeat.i(209511);
    paramahp = ((b.b)paramView.getTag()).qJy.field_favProto.EAX;
    if (paramahp == null)
    {
      ac.e("MicroMsg.FavAppBrandListItem", "onListItemClick appBrandItem null");
      AppMethodBeat.o(209511);
      return;
    }
    com.tencent.mm.plugin.appbrand.a.f localf = new com.tencent.mm.plugin.appbrand.a.f();
    localf.username = paramahp.username;
    localf.appId = paramahp.appId;
    localf.hxM = paramahp.dib;
    localf.version = paramahp.version;
    localf.jjf = paramahp.cYQ;
    localf.scene = 1010;
    localf.jjo = new AppBrandLaunchReferrer();
    localf.jjo.dxK = paramahp.dxK;
    localf.jjo.jDQ = 6;
    ((n)com.tencent.mm.kernel.g.ab(n.class)).a(paramView.getContext(), localf);
    AppMethodBeat.o(209511);
  }
  
  protected final void a(b.b paramb)
  {
    AppMethodBeat.i(209512);
    Object localObject = paramb.iMz.getContext().getString(2131755945);
    if (paramb.qJy.field_favProto.EAX != null)
    {
      localObject = paramb.qJy.field_favProto.EAX.username;
      localObject = ((m)com.tencent.mm.kernel.g.ab(m.class)).Ka((String)localObject);
      if (localObject == null) {
        break label87;
      }
    }
    label87:
    for (localObject = ((WxaAttributes)localObject).field_nickname;; localObject = paramb.iMz.getContext().getString(2131755945))
    {
      paramb.iMz.setText((CharSequence)localObject);
      AppMethodBeat.o(209512);
      return;
    }
  }
  
  public static final class a
    extends b.b
  {
    TextView iCg;
    ImageView lzC;
    ImageView qTd;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.e.a
 * JD-Core Version:    0.7.0.1
 */