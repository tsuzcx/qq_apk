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
import com.tencent.mm.protocal.protobuf.ahe;
import com.tencent.mm.protocal.protobuf.ahn;
import com.tencent.mm.protocal.protobuf.ahp;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;

public final class g
  extends b
{
  public g(o paramo)
  {
    super(paramo);
  }
  
  private static String a(ahe paramahe)
  {
    AppMethodBeat.i(107458);
    if (paramahe == null)
    {
      ac.i("MicroMsg.FavBaseListItem", "getLabel but locItem is null");
      AppMethodBeat.o(107458);
      return "";
    }
    paramahe = paramahe.label;
    AppMethodBeat.o(107458);
    return paramahe;
  }
  
  private static String b(ahe paramahe)
  {
    AppMethodBeat.i(107459);
    if (paramahe == null)
    {
      ac.i("MicroMsg.FavBaseListItem", "getPoiname but locItem is null");
      AppMethodBeat.o(107459);
      return "";
    }
    paramahe = paramahe.dry;
    AppMethodBeat.o(107459);
    return paramahe;
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
      paramViewGroup.lzC = ((ImageView)paramView.findViewById(2131299794));
      paramViewGroup.iCg = ((TextView)paramView.findViewById(2131299848));
      paramViewGroup.ijE = ((TextView)paramView.findViewById(2131299781));
      a(paramViewGroup, paramg);
      paramViewGroup.lzC.setImageResource(2131689562);
      localObject = paramg.field_favProto.EAI;
      paramg = paramg.field_favProto.iAC;
      if (!bs.isNullOrNil(paramg)) {
        break label193;
      }
      if (!n.acX(b((ahe)localObject))) {
        break label169;
      }
      paramViewGroup.iCg.setText(b((ahe)localObject));
      label139:
      paramViewGroup.ijE.setText(a((ahe)localObject));
    }
    for (;;)
    {
      AppMethodBeat.o(107457);
      return paramView;
      paramViewGroup = (a)paramView.getTag();
      break;
      label169:
      paramViewGroup.iCg.setText(a((ahe)localObject));
      paramViewGroup.ijE.setVisibility(8);
      continue;
      label193:
      paramViewGroup.iCg.setText(k.b(paramViewGroup.iCg.getContext(), paramg, paramViewGroup.iCg.getTextSize()));
      if (!n.acX(b((ahe)localObject))) {
        break label139;
      }
      paramViewGroup.ijE.setText(b((ahe)localObject));
    }
  }
  
  public final void a(View paramView, ahp paramahp)
  {
    AppMethodBeat.i(107460);
    a locala = (a)paramView.getTag();
    paramView = paramView.getContext();
    ((y)com.tencent.mm.kernel.g.ab(y.class)).a(paramView, locala.qJy, paramahp);
    AppMethodBeat.o(107460);
  }
  
  public static final class a
    extends b.b
  {
    TextView iCg;
    TextView ijE;
    ImageView lzC;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.e.g
 * JD-Core Version:    0.7.0.1
 */