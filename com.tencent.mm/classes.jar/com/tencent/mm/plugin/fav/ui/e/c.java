package com.tencent.mm.plugin.fav.ui.e;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.x;
import com.tencent.mm.plugin.fav.a.y;
import com.tencent.mm.plugin.fav.ui.o;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.protocal.protobuf.ajx;
import com.tencent.mm.protocal.protobuf.akp;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.bq;
import com.tencent.mm.storage.bv.a;

public final class c
  extends b
{
  public c(o paramo)
  {
    super(paramo);
  }
  
  private static String a(bv.a parama)
  {
    int j = 1;
    int i = 0;
    AppMethodBeat.i(107451);
    String str = parama.fhy;
    if (bu.isNullOrNil(str))
    {
      str = parama.cUA;
      if ((!an.aUy(str)) && (!x.Am(str))) {}
    }
    for (i = 1;; i = 0)
    {
      if ((i == 0) && (!((l)com.tencent.mm.kernel.g.ab(l.class)).azF().aUH(str))) {
        i = j;
      }
      for (;;)
      {
        boolean bool = x.oq(parama.Ecg);
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
      paramView = a(View.inflate(localContext, 2131493955, null), paramViewGroup, paramg);
      paramViewGroup.mdt = ((ImageView)paramView.findViewById(2131299794));
      paramViewGroup.iYj = ((TextView)paramView.findViewById(2131299848));
      paramViewGroup.iYj.setSingleLine(false);
      paramViewGroup.iYj.setMaxLines(2);
      paramViewGroup.iFO = ((TextView)paramView.findViewById(2131299778));
      paramViewGroup.rLB = ((TextView)paramView.findViewById(2131299825));
      a(paramViewGroup, paramg);
      paramg = com.tencent.mm.plugin.fav.a.b.c(paramg);
      paramg = ((l)com.tencent.mm.kernel.g.ab(l.class)).doJ().arp(paramg.desc);
      if ((paramg.cUA == null) || (paramg.cUA.length() <= 0)) {
        ae.e("MicroMsg.FavCardListItem", "parse possible friend msg failed");
      }
      if (!bu.isNullOrNil(a(paramg))) {
        break label241;
      }
      paramViewGroup.iFO.setVisibility(8);
      label183:
      paramViewGroup.rLB.setText(2131758907);
      paramViewGroup.rLB.setVisibility(0);
      paramViewGroup = paramViewGroup.mdt;
      paramg = paramg.cUA;
      if (!bu.isNullOrNil(paramg)) {
        break label255;
      }
      paramViewGroup.setImageResource(2131231875);
    }
    for (;;)
    {
      AppMethodBeat.o(107449);
      return paramView;
      paramViewGroup = (a)paramView.getTag();
      break;
      label241:
      paramViewGroup.iFO.setText(a(paramg));
      break label183;
      label255:
      a.b.c(paramViewGroup, paramg);
    }
  }
  
  public final void a(View paramView, akp paramakp)
  {
    AppMethodBeat.i(107450);
    a locala = (a)paramView.getTag();
    paramView = paramView.getContext();
    ((y)com.tencent.mm.kernel.g.ab(y.class)).a(paramView, locala.rBM, paramakp);
    AppMethodBeat.o(107450);
  }
  
  public static final class a
    extends b.b
  {
    TextView iFO;
    TextView iYj;
    ImageView mdt;
    TextView rLB;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.e.c
 * JD-Core Version:    0.7.0.1
 */