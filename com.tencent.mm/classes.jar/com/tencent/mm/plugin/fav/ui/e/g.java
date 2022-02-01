package com.tencent.mm.plugin.fav.ui.e;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.fav.a.z;
import com.tencent.mm.plugin.fav.ui.n;
import com.tencent.mm.plugin.fav.ui.o;
import com.tencent.mm.plugin.fav.ui.s.e;
import com.tencent.mm.plugin.fav.ui.s.f;
import com.tencent.mm.plugin.fav.ui.s.h;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.protocal.protobuf.ant;
import com.tencent.mm.protocal.protobuf.aoc;
import com.tencent.mm.protocal.protobuf.aoe;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatBrands.Business.Entries;

public final class g
  extends b
{
  public g(o paramo)
  {
    super(paramo);
  }
  
  private static String a(ant paramant)
  {
    AppMethodBeat.i(107458);
    if (paramant == null)
    {
      Log.i("MicroMsg.FavBaseListItem", "getLabel but locItem is null");
      AppMethodBeat.o(107458);
      return "";
    }
    paramant = paramant.label;
    AppMethodBeat.o(107458);
    return paramant;
  }
  
  private static String b(ant paramant)
  {
    AppMethodBeat.i(107459);
    if (paramant == null)
    {
      Log.i("MicroMsg.FavBaseListItem", "getPoiname but locItem is null");
      AppMethodBeat.o(107459);
      return "";
    }
    paramant = paramant.fPN;
    AppMethodBeat.o(107459);
    return paramant;
  }
  
  @SuppressLint({"ResourceType"})
  public final View a(View paramView, ViewGroup paramViewGroup, com.tencent.mm.plugin.fav.a.g paramg)
  {
    AppMethodBeat.i(107457);
    Object localObject = paramViewGroup.getContext();
    if (paramView == null)
    {
      paramViewGroup = new a();
      paramView = a(View.inflate((Context)localObject, s.f.fav_listitem_comm_card, null), paramViewGroup, paramg);
      paramViewGroup.qps = ((ImageView)paramView.findViewById(s.e.fav_icon));
      paramViewGroup.mNb = ((TextView)paramView.findViewById(s.e.fav_title));
      paramViewGroup.mrM = ((TextView)paramView.findViewById(s.e.fav_detail));
      a(paramViewGroup, paramg);
      paramViewGroup.qps.setImageResource(s.h.app_attach_file_icon_location);
      localObject = paramg.field_favProto.Szp;
      paramg = paramg.field_favProto.remark;
      if (!Util.isNullOrNil(paramg)) {
        break label198;
      }
      if (!n.aAs(b((ant)localObject))) {
        break label174;
      }
      paramViewGroup.mNb.setText(b((ant)localObject));
      label144:
      paramViewGroup.mrM.setText(a((ant)localObject));
    }
    for (;;)
    {
      AppMethodBeat.o(107457);
      return paramView;
      paramViewGroup = (a)paramView.getTag();
      break;
      label174:
      paramViewGroup.mNb.setText(a((ant)localObject));
      paramViewGroup.mrM.setVisibility(8);
      continue;
      label198:
      paramViewGroup.mNb.setText(l.b(paramViewGroup.mNb.getContext(), paramg, paramViewGroup.mNb.getTextSize()));
      if (!n.aAs(b((ant)localObject))) {
        break label144;
      }
      paramViewGroup.mrM.setText(b((ant)localObject));
    }
  }
  
  public final void a(View paramView, aoe paramaoe)
  {
    AppMethodBeat.i(107460);
    if (!WeChatBrands.Business.Entries.SessionLocation.checkAvailable(paramView.getContext()))
    {
      AppMethodBeat.o(107460);
      return;
    }
    a locala = (a)paramView.getTag();
    paramView = paramView.getContext();
    ((z)h.ae(z.class)).a(paramView, locala.wHw, paramaoe);
    AppMethodBeat.o(107460);
  }
  
  public static final class a
    extends b.b
  {
    TextView mNb;
    TextView mrM;
    ImageView qps;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.e.g
 * JD-Core Version:    0.7.0.1
 */