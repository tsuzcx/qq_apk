package com.tencent.mm.plugin.fav.ui.d;

import android.content.Context;
import android.content.res.Resources;
import android.util.Pair;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.appbrand.config.AppBrandLaunchReferrer;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.service.s;
import com.tencent.mm.plugin.appbrand.service.t;
import com.tencent.mm.plugin.fav.ui.FavoriteImageServer;
import com.tencent.mm.plugin.fav.ui.q.b;
import com.tencent.mm.plugin.fav.ui.q.c;
import com.tencent.mm.plugin.fav.ui.q.e;
import com.tencent.mm.plugin.fav.ui.q.f;
import com.tencent.mm.plugin.fav.ui.q.h;
import com.tencent.mm.plugin.fav.ui.q.i;
import com.tencent.mm.protocal.protobuf.ard;
import com.tencent.mm.protocal.protobuf.arf;
import com.tencent.mm.protocal.protobuf.arv;
import com.tencent.mm.protocal.protobuf.arx;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.widget.imageview.WeImageView;

public final class a
  extends b
{
  private final int Aod;
  
  public a(FavoriteImageServer paramFavoriteImageServer)
  {
    super(paramFavoriteImageServer);
    AppMethodBeat.i(274431);
    this.Aod = com.tencent.mm.cd.a.br(paramFavoriteImageServer.context, q.c.FavIconSize);
    AppMethodBeat.o(274431);
  }
  
  public final View a(View paramView, ViewGroup paramViewGroup, com.tencent.mm.plugin.fav.a.g paramg)
  {
    AppMethodBeat.i(274432);
    Context localContext = paramViewGroup.getContext();
    arf localarf;
    if (paramView == null)
    {
      paramViewGroup = new a();
      paramView = a(View.inflate(localContext, q.f.fav_listitem_app_brand, null), paramViewGroup, paramg);
      paramViewGroup.ttT = ((ImageView)paramView.findViewById(q.e.fav_icon));
      paramViewGroup.Aoe = ((ImageView)paramView.findViewById(q.e.fav_icon_video_mask));
      paramViewGroup.pJJ = ((TextView)paramView.findViewById(q.e.fav_title));
      a(paramViewGroup, paramg);
      localarf = com.tencent.mm.plugin.fav.a.b.c(paramg);
      String str = paramg.field_favProto.title;
      localObject = str;
      if (Util.isNullOrNil(str)) {
        localObject = localarf.title;
      }
      paramViewGroup.pJJ.setText((CharSequence)localObject);
      paramViewGroup.Aoj.setImageResource(q.h.icons_outlined_mini_program);
      paramViewGroup.Aoj.setIconColor(localContext.getResources().getColor(q.b.BW_0_Alpha_0_3));
      paramViewGroup.Aoj.setAlpha(0.3F);
      paramViewGroup.Aoj.setVisibility(0);
      if ((paramg.field_favProto.ZAw == null) || (paramg.field_favProto.ZAw.subType != 1)) {
        break label318;
      }
      paramViewGroup.Aoe.setVisibility(0);
      label207:
      if (paramg.field_favProto.ZAw == null) {
        break label374;
      }
    }
    label318:
    label374:
    for (Object localObject = ((com.tencent.mm.plugin.appbrand.service.g)h.ax(com.tencent.mm.plugin.appbrand.service.g.class)).zl(paramg.field_favProto.ZAw.hJK);; localObject = null)
    {
      if ((localObject == null) || (Util.isNullOrNil((String)((Pair)localObject).first)))
      {
        paramViewGroup.Aok.setText(null);
        paramViewGroup.Aok.setVisibility(8);
      }
      for (;;)
      {
        FavoriteImageServer.a(paramViewGroup.ttT, q.h.fav_list_icon_miniprogram_default, localarf, paramg, false, this.Aod, this.Aod);
        AppMethodBeat.o(274432);
        return paramView;
        paramViewGroup = (a)paramView.getTag();
        break;
        paramViewGroup.Aoe.setVisibility(8);
        break label207;
        paramViewGroup.Aok.setText((CharSequence)((Pair)localObject).first);
        paramViewGroup.Aok.setBackgroundResource(((Integer)((Pair)localObject).second).intValue());
        paramViewGroup.Aok.setVisibility(0);
      }
    }
  }
  
  public final void a(View paramView, arx paramarx)
  {
    AppMethodBeat.i(274433);
    paramarx = ((b.b)paramView.getTag()).AdF.field_favProto.ZAw;
    if (paramarx == null)
    {
      Log.e("MicroMsg.FavAppBrandListItem", "onListItemClick appBrandItem null");
      AppMethodBeat.o(274433);
      return;
    }
    com.tencent.mm.plugin.appbrand.api.g localg = new com.tencent.mm.plugin.appbrand.api.g();
    localg.username = paramarx.username;
    localg.appId = paramarx.appId;
    localg.euz = paramarx.hJK;
    localg.version = paramarx.version;
    localg.qAF = paramarx.hzy;
    localg.scene = 1010;
    localg.qAO = new AppBrandLaunchReferrer();
    localg.qAO.idf = paramarx.idf;
    localg.qAO.qYE = 6;
    ((t)h.ax(t.class)).a(paramView.getContext(), localg);
    AppMethodBeat.o(274433);
  }
  
  protected final void a(b.b paramb)
  {
    AppMethodBeat.i(274435);
    Object localObject = paramb.pUL.getContext().getString(q.i.appbrand_app_name);
    if (paramb.AdF.field_favProto.ZAw != null)
    {
      localObject = paramb.AdF.field_favProto.ZAw.username;
      localObject = ((s)h.ax(s.class)).Xy((String)localObject);
      if (localObject == null) {
        break label87;
      }
    }
    label87:
    for (localObject = ((WxaAttributes)localObject).field_nickname;; localObject = paramb.pUL.getContext().getString(q.i.appbrand_app_name))
    {
      paramb.pUL.setText((CharSequence)localObject);
      AppMethodBeat.o(274435);
      return;
    }
  }
  
  public static final class a
    extends b.b
  {
    ImageView Aoe;
    TextView pJJ;
    ImageView ttT;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.d.a
 * JD-Core Version:    0.7.0.1
 */