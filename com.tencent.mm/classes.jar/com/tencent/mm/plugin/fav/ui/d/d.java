package com.tencent.mm.plugin.fav.ui.d;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fav.a.af;
import com.tencent.mm.plugin.fav.a.y;
import com.tencent.mm.plugin.fav.ui.e;
import com.tencent.mm.plugin.fav.ui.o;
import com.tencent.mm.protocal.protobuf.aml;
import com.tencent.mm.protocal.protobuf.anb;
import com.tencent.mm.protocal.protobuf.and;
import com.tencent.mm.sdk.platformtools.Util;

public final class d
  extends b
{
  public d(o paramo)
  {
    super(paramo);
  }
  
  public final View a(View paramView, ViewGroup paramViewGroup, com.tencent.mm.plugin.fav.a.g paramg)
  {
    AppMethodBeat.i(107452);
    Object localObject = paramViewGroup.getContext();
    if (paramView == null)
    {
      paramViewGroup = new a();
      paramView = a(View.inflate((Context)localObject, 2131494125, null), paramViewGroup, paramg);
      paramViewGroup.nnL = ((ImageView)paramView.findViewById(2131300468));
      paramViewGroup.jVO = ((TextView)paramView.findViewById(2131300526));
      paramViewGroup.jBR = ((TextView)paramView.findViewById(2131300454));
    }
    for (;;)
    {
      a(paramViewGroup, paramg);
      aml localaml = com.tencent.mm.plugin.fav.a.b.c(paramg);
      String str = paramg.field_favProto.title;
      if (!Util.isNullOrNil(str))
      {
        localObject = str;
        if (paramg.tad)
        {
          localObject = str;
          if (localaml == null) {}
        }
      }
      else
      {
        localObject = localaml.title;
      }
      paramViewGroup.jVO.setText((CharSequence)localObject);
      paramViewGroup.jBR.setText(com.tencent.mm.plugin.fav.a.b.getLengthStr((float)localaml.LvI));
      if (localaml.Lwv == 2) {
        paramViewGroup.jBR.setText(">" + ((af)com.tencent.mm.kernel.g.ah(af.class)).getFileSizeLimitInMB(true) + "MB");
      }
      paramViewGroup.nnL.setImageResource(e.asl(localaml.LvC));
      AppMethodBeat.o(107452);
      return paramView;
      paramViewGroup = (a)paramView.getTag();
    }
  }
  
  public final void a(View paramView, and paramand)
  {
    AppMethodBeat.i(107453);
    com.tencent.mm.plugin.fav.a.g localg = ((a)paramView.getTag()).tbr;
    paramView = paramView.getContext();
    ((y)com.tencent.mm.kernel.g.af(y.class)).a(paramView, localg, paramand);
    AppMethodBeat.o(107453);
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
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.d.d
 * JD-Core Version:    0.7.0.1
 */