package com.tencent.mm.plugin.fav.ui.e;

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
import com.tencent.mm.plugin.appbrand.service.f;
import com.tencent.mm.plugin.appbrand.service.q;
import com.tencent.mm.plugin.appbrand.service.r;
import com.tencent.mm.plugin.fav.ui.o;
import com.tencent.mm.plugin.fav.ui.s.b;
import com.tencent.mm.plugin.fav.ui.s.c;
import com.tencent.mm.plugin.fav.ui.s.e;
import com.tencent.mm.plugin.fav.ui.s.f;
import com.tencent.mm.plugin.fav.ui.s.h;
import com.tencent.mm.plugin.fav.ui.s.i;
import com.tencent.mm.protocal.protobuf.ank;
import com.tencent.mm.protocal.protobuf.anm;
import com.tencent.mm.protocal.protobuf.aoc;
import com.tencent.mm.protocal.protobuf.aoe;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.widget.imageview.WeImageView;

public final class a
  extends b
{
  private final int wRA;
  
  public a(o paramo)
  {
    super(paramo);
    AppMethodBeat.i(232084);
    this.wRA = com.tencent.mm.ci.a.aY(paramo.context, s.c.FavIconSize);
    AppMethodBeat.o(232084);
  }
  
  public final View a(View paramView, ViewGroup paramViewGroup, com.tencent.mm.plugin.fav.a.g paramg)
  {
    AppMethodBeat.i(232086);
    Context localContext = paramViewGroup.getContext();
    anm localanm;
    if (paramView == null)
    {
      paramViewGroup = new a();
      paramView = a(View.inflate(localContext, s.f.fav_listitem_app_brand, null), paramViewGroup, paramg);
      paramViewGroup.qps = ((ImageView)paramView.findViewById(s.e.fav_icon));
      paramViewGroup.wRB = ((ImageView)paramView.findViewById(s.e.fav_icon_video_mask));
      paramViewGroup.mNb = ((TextView)paramView.findViewById(s.e.fav_title));
      a(paramViewGroup, paramg);
      localanm = com.tencent.mm.plugin.fav.a.b.c(paramg);
      String str = paramg.field_favProto.title;
      localObject = str;
      if (Util.isNullOrNil(str)) {
        localObject = localanm.title;
      }
      paramViewGroup.mNb.setText((CharSequence)localObject);
      paramViewGroup.wRG.setImageResource(s.h.icons_outlined_mini_program);
      paramViewGroup.wRG.setIconColor(localContext.getResources().getColor(s.b.BW_0_Alpha_0_3));
      paramViewGroup.wRG.setAlpha(0.3F);
      paramViewGroup.wRG.setVisibility(0);
      if ((paramg.field_favProto.SzE == null) || (paramg.field_favProto.SzE.subType != 1)) {
        break label318;
      }
      paramViewGroup.wRB.setVisibility(0);
      label207:
      if (paramg.field_favProto.SzE == null) {
        break label374;
      }
    }
    label318:
    label374:
    for (Object localObject = ((f)h.ae(f.class)).yY(paramg.field_favProto.SzE.fES);; localObject = null)
    {
      if ((localObject == null) || (Util.isNullOrNil((String)((Pair)localObject).first)))
      {
        paramViewGroup.wRH.setText(null);
        paramViewGroup.wRH.setVisibility(8);
      }
      for (;;)
      {
        o.a(paramViewGroup.qps, s.h.fav_list_icon_miniprogram_default, localanm, paramg, false, this.wRA, this.wRA);
        AppMethodBeat.o(232086);
        return paramView;
        paramViewGroup = (a)paramView.getTag();
        break;
        paramViewGroup.wRB.setVisibility(8);
        break label207;
        paramViewGroup.wRH.setText((CharSequence)((Pair)localObject).first);
        paramViewGroup.wRH.setBackgroundResource(((Integer)((Pair)localObject).second).intValue());
        paramViewGroup.wRH.setVisibility(0);
      }
    }
  }
  
  public final void a(View paramView, aoe paramaoe)
  {
    AppMethodBeat.i(232087);
    paramaoe = ((b.b)paramView.getTag()).wHw.field_favProto.SzE;
    if (paramaoe == null)
    {
      Log.e("MicroMsg.FavAppBrandListItem", "onListItemClick appBrandItem null");
      AppMethodBeat.o(232087);
      return;
    }
    com.tencent.mm.plugin.appbrand.api.g localg = new com.tencent.mm.plugin.appbrand.api.g();
    localg.username = paramaoe.username;
    localg.appId = paramaoe.appId;
    localg.cBU = paramaoe.fES;
    localg.version = paramaoe.version;
    localg.nBq = paramaoe.fve;
    localg.scene = 1010;
    localg.nBz = new AppBrandLaunchReferrer();
    localg.nBz.fXg = paramaoe.fXg;
    localg.nBz.nYB = 6;
    ((r)h.ae(r.class)).a(paramView.getContext(), localg);
    AppMethodBeat.o(232087);
  }
  
  protected final void a(b.b paramb)
  {
    AppMethodBeat.i(232089);
    Object localObject = paramb.mYd.getContext().getString(s.i.appbrand_app_name);
    if (paramb.wHw.field_favProto.SzE != null)
    {
      localObject = paramb.wHw.field_favProto.SzE.username;
      localObject = ((q)h.ae(q.class)).aeW((String)localObject);
      if (localObject == null) {
        break label87;
      }
    }
    label87:
    for (localObject = ((WxaAttributes)localObject).field_nickname;; localObject = paramb.mYd.getContext().getString(s.i.appbrand_app_name))
    {
      paramb.mYd.setText((CharSequence)localObject);
      AppMethodBeat.o(232089);
      return;
    }
  }
  
  public static final class a
    extends b.b
  {
    TextView mNb;
    ImageView qps;
    ImageView wRB;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.e.a
 * JD-Core Version:    0.7.0.1
 */