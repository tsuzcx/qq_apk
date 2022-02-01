package com.tencent.mm.plugin.fav.ui.e;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fav.a.y;
import com.tencent.mm.plugin.fav.ui.n;
import com.tencent.mm.plugin.fav.ui.o;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.protocal.protobuf.ake;
import com.tencent.mm.protocal.protobuf.akn;
import com.tencent.mm.protocal.protobuf.akp;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;

public final class g
  extends b
{
  public g(o paramo)
  {
    super(paramo);
  }
  
  private static String a(ake paramake)
  {
    AppMethodBeat.i(107458);
    if (paramake == null)
    {
      ae.i("MicroMsg.FavBaseListItem", "getLabel but locItem is null");
      AppMethodBeat.o(107458);
      return "";
    }
    paramake = paramake.label;
    AppMethodBeat.o(107458);
    return paramake;
  }
  
  private static String b(ake paramake)
  {
    AppMethodBeat.i(107459);
    if (paramake == null)
    {
      ae.i("MicroMsg.FavBaseListItem", "getPoiname but locItem is null");
      AppMethodBeat.o(107459);
      return "";
    }
    paramake = paramake.dEv;
    AppMethodBeat.o(107459);
    return paramake;
  }
  
  @SuppressLint({"ResourceType"})
  public final View a(View paramView, ViewGroup paramViewGroup, com.tencent.mm.plugin.fav.a.g paramg)
  {
    AppMethodBeat.i(107457);
    Object localObject = paramViewGroup.getContext();
    if (paramView == null)
    {
      paramViewGroup = new a();
      paramView = a(View.inflate((Context)localObject, 2131493956, null), paramViewGroup, paramg);
      paramViewGroup.mdt = ((ImageView)paramView.findViewById(2131299794));
      paramViewGroup.iYj = ((TextView)paramView.findViewById(2131299848));
      paramViewGroup.iFO = ((TextView)paramView.findViewById(2131299781));
      a(paramViewGroup, paramg);
      paramViewGroup.mdt.setImageResource(2131689562);
      localObject = paramg.field_favProto.GBd;
      paramg = paramg.field_favProto.iWF;
      if (!bu.isNullOrNil(paramg)) {
        break label193;
      }
      if (!n.ahJ(b((ake)localObject))) {
        break label169;
      }
      paramViewGroup.iYj.setText(b((ake)localObject));
      label139:
      paramViewGroup.iFO.setText(a((ake)localObject));
    }
    for (;;)
    {
      AppMethodBeat.o(107457);
      return paramView;
      paramViewGroup = (a)paramView.getTag();
      break;
      label169:
      paramViewGroup.iYj.setText(a((ake)localObject));
      paramViewGroup.iFO.setVisibility(8);
      continue;
      label193:
      paramViewGroup.iYj.setText(k.b(paramViewGroup.iYj.getContext(), paramg, paramViewGroup.iYj.getTextSize()));
      if (!n.ahJ(b((ake)localObject))) {
        break label139;
      }
      paramViewGroup.iFO.setText(b((ake)localObject));
    }
  }
  
  public final void a(View paramView, akp paramakp)
  {
    AppMethodBeat.i(107460);
    a locala = (a)paramView.getTag();
    paramView = paramView.getContext();
    ((y)com.tencent.mm.kernel.g.ab(y.class)).a(paramView, locala.rBM, paramakp);
    AppMethodBeat.o(107460);
  }
  
  public static final class a
    extends b.b
  {
    TextView iFO;
    TextView iYj;
    ImageView mdt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.e.g
 * JD-Core Version:    0.7.0.1
 */