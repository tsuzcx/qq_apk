package com.tencent.mm.plugin.fav.ui.d;

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
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.protocal.protobuf.ams;
import com.tencent.mm.protocal.protobuf.anb;
import com.tencent.mm.protocal.protobuf.and;
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
  
  private static String a(ams paramams)
  {
    AppMethodBeat.i(107458);
    if (paramams == null)
    {
      Log.i("MicroMsg.FavBaseListItem", "getLabel but locItem is null");
      AppMethodBeat.o(107458);
      return "";
    }
    paramams = paramams.label;
    AppMethodBeat.o(107458);
    return paramams;
  }
  
  private static String b(ams paramams)
  {
    AppMethodBeat.i(107459);
    if (paramams == null)
    {
      Log.i("MicroMsg.FavBaseListItem", "getPoiname but locItem is null");
      AppMethodBeat.o(107459);
      return "";
    }
    paramams = paramams.dWi;
    AppMethodBeat.o(107459);
    return paramams;
  }
  
  @SuppressLint({"ResourceType"})
  public final View a(View paramView, ViewGroup paramViewGroup, com.tencent.mm.plugin.fav.a.g paramg)
  {
    AppMethodBeat.i(107457);
    Object localObject = paramViewGroup.getContext();
    if (paramView == null)
    {
      paramViewGroup = new a();
      paramView = a(View.inflate((Context)localObject, 2131494125, null), paramViewGroup, paramg);
      paramViewGroup.nnL = ((ImageView)paramView.findViewById(2131300468));
      paramViewGroup.jVO = ((TextView)paramView.findViewById(2131300526));
      paramViewGroup.jBR = ((TextView)paramView.findViewById(2131300454));
      a(paramViewGroup, paramg);
      paramViewGroup.nnL.setImageResource(2131689565);
      localObject = paramg.field_favProto.LwQ;
      paramg = paramg.field_favProto.remark;
      if (!Util.isNullOrNil(paramg)) {
        break label193;
      }
      if (!n.asr(b((ams)localObject))) {
        break label169;
      }
      paramViewGroup.jVO.setText(b((ams)localObject));
      label139:
      paramViewGroup.jBR.setText(a((ams)localObject));
    }
    for (;;)
    {
      AppMethodBeat.o(107457);
      return paramView;
      paramViewGroup = (a)paramView.getTag();
      break;
      label169:
      paramViewGroup.jVO.setText(a((ams)localObject));
      paramViewGroup.jBR.setVisibility(8);
      continue;
      label193:
      paramViewGroup.jVO.setText(l.b(paramViewGroup.jVO.getContext(), paramg, paramViewGroup.jVO.getTextSize()));
      if (!n.asr(b((ams)localObject))) {
        break label139;
      }
      paramViewGroup.jBR.setText(b((ams)localObject));
    }
  }
  
  public final void a(View paramView, and paramand)
  {
    AppMethodBeat.i(107460);
    if (!WeChatBrands.Business.Entries.SessionLocation.checkAvailable(paramView.getContext()))
    {
      AppMethodBeat.o(107460);
      return;
    }
    a locala = (a)paramView.getTag();
    paramView = paramView.getContext();
    ((y)com.tencent.mm.kernel.g.af(y.class)).a(paramView, locala.tbr, paramand);
    AppMethodBeat.o(107460);
  }
  
  public static final class a
    extends b.b
  {
    TextView jBR;
    TextView jVO;
    ImageView nnL;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.d.g
 * JD-Core Version:    0.7.0.1
 */