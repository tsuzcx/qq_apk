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
import com.tencent.mm.protocal.protobuf.aju;
import com.tencent.mm.protocal.protobuf.akd;
import com.tencent.mm.protocal.protobuf.akf;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;

public final class g
  extends b
{
  public g(o paramo)
  {
    super(paramo);
  }
  
  private static String a(aju paramaju)
  {
    AppMethodBeat.i(107458);
    if (paramaju == null)
    {
      ad.i("MicroMsg.FavBaseListItem", "getLabel but locItem is null");
      AppMethodBeat.o(107458);
      return "";
    }
    paramaju = paramaju.label;
    AppMethodBeat.o(107458);
    return paramaju;
  }
  
  private static String b(aju paramaju)
  {
    AppMethodBeat.i(107459);
    if (paramaju == null)
    {
      ad.i("MicroMsg.FavBaseListItem", "getPoiname but locItem is null");
      AppMethodBeat.o(107459);
      return "";
    }
    paramaju = paramaju.dDq;
    AppMethodBeat.o(107459);
    return paramaju;
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
      paramViewGroup.lZa = ((ImageView)paramView.findViewById(2131299794));
      paramViewGroup.iVq = ((TextView)paramView.findViewById(2131299848));
      paramViewGroup.iCV = ((TextView)paramView.findViewById(2131299781));
      a(paramViewGroup, paramg);
      paramViewGroup.lZa.setImageResource(2131689562);
      localObject = paramg.field_favProto.Giu;
      paramg = paramg.field_favProto.iTM;
      if (!bt.isNullOrNil(paramg)) {
        break label193;
      }
      if (!n.agM(b((aju)localObject))) {
        break label169;
      }
      paramViewGroup.iVq.setText(b((aju)localObject));
      label139:
      paramViewGroup.iCV.setText(a((aju)localObject));
    }
    for (;;)
    {
      AppMethodBeat.o(107457);
      return paramView;
      paramViewGroup = (a)paramView.getTag();
      break;
      label169:
      paramViewGroup.iVq.setText(a((aju)localObject));
      paramViewGroup.iCV.setVisibility(8);
      continue;
      label193:
      paramViewGroup.iVq.setText(k.b(paramViewGroup.iVq.getContext(), paramg, paramViewGroup.iVq.getTextSize()));
      if (!n.agM(b((aju)localObject))) {
        break label139;
      }
      paramViewGroup.iCV.setText(b((aju)localObject));
    }
  }
  
  public final void a(View paramView, akf paramakf)
  {
    AppMethodBeat.i(107460);
    a locala = (a)paramView.getTag();
    paramView = paramView.getContext();
    ((y)com.tencent.mm.kernel.g.ab(y.class)).a(paramView, locala.rtA, paramakf);
    AppMethodBeat.o(107460);
  }
  
  public static final class a
    extends b.b
  {
    TextView iCV;
    TextView iVq;
    ImageView lZa;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.e.g
 * JD-Core Version:    0.7.0.1
 */