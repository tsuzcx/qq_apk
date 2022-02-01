package com.tencent.mm.plugin.fav.ui.d;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.ab;
import com.tencent.mm.plugin.fav.a.y;
import com.tencent.mm.plugin.fav.ui.o;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.protocal.protobuf.aml;
import com.tencent.mm.protocal.protobuf.and;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storage.ca.a;

public final class c
  extends b
{
  public c(o paramo)
  {
    super(paramo);
  }
  
  private static String a(ca.a parama)
  {
    int j = 1;
    int i = 0;
    AppMethodBeat.i(107451);
    String str = parama.fMb;
    if (Util.isNullOrNil(str))
    {
      str = parama.dkU;
      if ((!as.bjx(str)) && (!ab.IR(str))) {}
    }
    for (i = 1;; i = 0)
    {
      if ((i == 0) && (!((l)com.tencent.mm.kernel.g.af(l.class)).aSN().bjG(str))) {
        i = j;
      }
      for (;;)
      {
        boolean bool = ab.rR(parama.IOs);
        if ((i != 0) || (bool))
        {
          AppMethodBeat.o(107451);
          return "";
        }
        AppMethodBeat.o(107451);
        return str;
      }
    }
  }
  
  public final View a(View paramView, ViewGroup paramViewGroup, com.tencent.mm.plugin.fav.a.g paramg)
  {
    AppMethodBeat.i(107449);
    Context localContext = paramViewGroup.getContext();
    if (paramView == null)
    {
      paramViewGroup = new a();
      paramView = a(View.inflate(localContext, 2131494124, null), paramViewGroup, paramg);
      paramViewGroup.nnL = ((ImageView)paramView.findViewById(2131300468));
      paramViewGroup.jVO = ((TextView)paramView.findViewById(2131300526));
      paramViewGroup.jVO.setSingleLine(false);
      paramViewGroup.jVO.setMaxLines(2);
      paramViewGroup.jBR = ((TextView)paramView.findViewById(2131300451));
      paramViewGroup.tln = ((TextView)paramView.findViewById(2131300503));
      a(paramViewGroup, paramg);
      paramg = com.tencent.mm.plugin.fav.a.b.c(paramg);
      paramg = ((l)com.tencent.mm.kernel.g.af(l.class)).eiy().aEK(paramg.desc);
      if ((paramg.dkU == null) || (paramg.dkU.length() <= 0)) {
        Log.e("MicroMsg.FavCardListItem", "parse possible friend msg failed");
      }
      if (!Util.isNullOrNil(a(paramg))) {
        break label241;
      }
      paramViewGroup.jBR.setVisibility(8);
      label183:
      paramViewGroup.tln.setText(2131759231);
      paramViewGroup.tln.setVisibility(0);
      paramViewGroup = paramViewGroup.nnL;
      paramg = paramg.dkU;
      if (!Util.isNullOrNil(paramg)) {
        break label255;
      }
      paramViewGroup.setImageResource(2131231957);
    }
    for (;;)
    {
      AppMethodBeat.o(107449);
      return paramView;
      paramViewGroup = (a)paramView.getTag();
      break;
      label241:
      paramViewGroup.jBR.setText(a(paramg));
      break label183;
      label255:
      a.b.c(paramViewGroup, paramg);
    }
  }
  
  public final void a(View paramView, and paramand)
  {
    AppMethodBeat.i(107450);
    a locala = (a)paramView.getTag();
    paramView = paramView.getContext();
    ((y)com.tencent.mm.kernel.g.af(y.class)).a(paramView, locala.tbr, paramand);
    AppMethodBeat.o(107450);
  }
  
  public static final class a
    extends b.b
  {
    TextView jBR;
    TextView jVO;
    ImageView nnL;
    TextView tln;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.d.c
 * JD-Core Version:    0.7.0.1
 */