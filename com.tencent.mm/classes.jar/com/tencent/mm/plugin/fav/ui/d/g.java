package com.tencent.mm.plugin.fav.ui.d;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.fav.a.z;
import com.tencent.mm.plugin.fav.ui.FavoriteImageServer;
import com.tencent.mm.plugin.fav.ui.n;
import com.tencent.mm.plugin.fav.ui.q.e;
import com.tencent.mm.plugin.fav.ui.q.f;
import com.tencent.mm.plugin.fav.ui.q.h;
import com.tencent.mm.pluginsdk.ui.span.p;
import com.tencent.mm.protocal.protobuf.arm;
import com.tencent.mm.protocal.protobuf.arv;
import com.tencent.mm.protocal.protobuf.arx;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatBrands.Business.Entries;

public final class g
  extends b
{
  public g(FavoriteImageServer paramFavoriteImageServer)
  {
    super(paramFavoriteImageServer);
  }
  
  private static String a(arm paramarm)
  {
    AppMethodBeat.i(107458);
    if (paramarm == null)
    {
      Log.i("MicroMsg.FavBaseListItem", "getLabel but locItem is null");
      AppMethodBeat.o(107458);
      return "";
    }
    paramarm = paramarm.label;
    AppMethodBeat.o(107458);
    return paramarm;
  }
  
  private static String b(arm paramarm)
  {
    AppMethodBeat.i(107459);
    if (paramarm == null)
    {
      Log.i("MicroMsg.FavBaseListItem", "getPoiname but locItem is null");
      AppMethodBeat.o(107459);
      return "";
    }
    paramarm = paramarm.hVI;
    AppMethodBeat.o(107459);
    return paramarm;
  }
  
  public final View a(View paramView, ViewGroup paramViewGroup, com.tencent.mm.plugin.fav.a.g paramg)
  {
    AppMethodBeat.i(107457);
    Object localObject = paramViewGroup.getContext();
    if (paramView == null)
    {
      paramViewGroup = new a();
      paramView = a(View.inflate((Context)localObject, q.f.fav_listitem_comm_card, null), paramViewGroup, paramg);
      paramViewGroup.ttT = ((ImageView)paramView.findViewById(q.e.fav_icon));
      paramViewGroup.pJJ = ((TextView)paramView.findViewById(q.e.fav_title));
      paramViewGroup.plr = ((TextView)paramView.findViewById(q.e.fav_detail));
      b(paramViewGroup.pJJ, paramg);
      a(paramViewGroup, paramg);
      paramViewGroup.ttT.setImageResource(q.h.app_attach_file_icon_location);
      localObject = paramg.field_favProto.ZAh;
      paramg = paramg.field_favProto.remark;
      if (!Util.isNullOrNil(paramg)) {
        break label207;
      }
      if (!n.auz(b((arm)localObject))) {
        break label183;
      }
      paramViewGroup.pJJ.setText(b((arm)localObject));
      label153:
      paramViewGroup.plr.setText(a((arm)localObject));
    }
    for (;;)
    {
      AppMethodBeat.o(107457);
      return paramView;
      paramViewGroup = (a)paramView.getTag();
      break;
      label183:
      paramViewGroup.pJJ.setText(a((arm)localObject));
      paramViewGroup.plr.setVisibility(8);
      continue;
      label207:
      paramViewGroup.pJJ.setText(p.b(paramViewGroup.pJJ.getContext(), paramg, paramViewGroup.pJJ.getTextSize()));
      if (!n.auz(b((arm)localObject))) {
        break label153;
      }
      paramViewGroup.plr.setText(b((arm)localObject));
    }
  }
  
  public final void a(View paramView, arx paramarx)
  {
    AppMethodBeat.i(107460);
    if (!WeChatBrands.Business.Entries.SessionLocation.checkAvailable(paramView.getContext()))
    {
      AppMethodBeat.o(107460);
      return;
    }
    a locala = (a)paramView.getTag();
    paramView = paramView.getContext();
    ((z)h.ax(z.class)).a(paramView, locala.AdF, paramarx);
    AppMethodBeat.o(107460);
  }
  
  public static final class a
    extends b.b
  {
    TextView pJJ;
    TextView plr;
    ImageView ttT;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.d.g
 * JD-Core Version:    0.7.0.1
 */