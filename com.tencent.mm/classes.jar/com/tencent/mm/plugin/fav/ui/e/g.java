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
import com.tencent.mm.protocal.protobuf.agf;
import com.tencent.mm.protocal.protobuf.ago;
import com.tencent.mm.protocal.protobuf.agq;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;

public final class g
  extends b
{
  public g(o paramo)
  {
    super(paramo);
  }
  
  private static String a(agf paramagf)
  {
    AppMethodBeat.i(107458);
    if (paramagf == null)
    {
      ad.i("MicroMsg.FavBaseListItem", "getLabel but locItem is null");
      AppMethodBeat.o(107458);
      return "";
    }
    paramagf = paramagf.label;
    AppMethodBeat.o(107458);
    return paramagf;
  }
  
  private static String b(agf paramagf)
  {
    AppMethodBeat.i(107459);
    if (paramagf == null)
    {
      ad.i("MicroMsg.FavBaseListItem", "getPoiname but locItem is null");
      AppMethodBeat.o(107459);
      return "";
    }
    paramagf = paramagf.dtN;
    AppMethodBeat.o(107459);
    return paramagf;
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
      paramViewGroup.kXS = ((ImageView)paramView.findViewById(2131299794));
      paramViewGroup.ica = ((TextView)paramView.findViewById(2131299848));
      paramViewGroup.hJe = ((TextView)paramView.findViewById(2131299781));
      a(paramViewGroup, paramg);
      paramViewGroup.kXS.setImageResource(2131689562);
      localObject = paramg.field_favProto.DhC;
      paramg = paramg.field_favProto.iaz;
      if (!bt.isNullOrNil(paramg)) {
        break label193;
      }
      if (!n.YB(b((agf)localObject))) {
        break label169;
      }
      paramViewGroup.ica.setText(b((agf)localObject));
      label139:
      paramViewGroup.hJe.setText(a((agf)localObject));
    }
    for (;;)
    {
      AppMethodBeat.o(107457);
      return paramView;
      paramViewGroup = (a)paramView.getTag();
      break;
      label169:
      paramViewGroup.ica.setText(a((agf)localObject));
      paramViewGroup.hJe.setVisibility(8);
      continue;
      label193:
      paramViewGroup.ica.setText(k.b(paramViewGroup.ica.getContext(), paramg, paramViewGroup.ica.getTextSize()));
      if (!n.YB(b((agf)localObject))) {
        break label139;
      }
      paramViewGroup.hJe.setText(b((agf)localObject));
    }
  }
  
  public final void a(View paramView, agq paramagq)
  {
    AppMethodBeat.i(107460);
    a locala = (a)paramView.getTag();
    paramView = paramView.getContext();
    ((y)com.tencent.mm.kernel.g.ab(y.class)).a(paramView, locala.qaS, paramagq);
    AppMethodBeat.o(107460);
  }
  
  public static final class a
    extends b.b
  {
    TextView hJe;
    TextView ica;
    ImageView kXS;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.e.g
 * JD-Core Version:    0.7.0.1
 */