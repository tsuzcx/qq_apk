package com.tencent.mm.plugin.fav.ui.d;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.t;
import com.tencent.mm.plugin.fav.a.y;
import com.tencent.mm.plugin.fav.ui.l;
import com.tencent.mm.plugin.messenger.foundation.a.a.h;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.protocal.protobuf.aca;
import com.tencent.mm.protocal.protobuf.acs;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.bi.a;

public final class b
  extends a
{
  public b(l paraml)
  {
    super(paraml);
  }
  
  private static String a(bi.a parama)
  {
    int j = 1;
    int i = 0;
    AppMethodBeat.i(74617);
    String str = parama.dCJ;
    if (bo.isNullOrNil(str))
    {
      str = parama.tac;
      if ((!ad.ari(str)) && (!t.nS(str))) {}
    }
    for (i = 1;; i = 0)
    {
      if ((i == 0) && (!((j)com.tencent.mm.kernel.g.E(j.class)).YA().arr(str))) {
        i = j;
      }
      for (;;)
      {
        boolean bool = t.ku(parama.uOT);
        if ((i != 0) || (bool))
        {
          AppMethodBeat.o(74617);
          return "";
        }
        AppMethodBeat.o(74617);
        return str;
      }
    }
  }
  
  public final View a(View paramView, ViewGroup paramViewGroup, com.tencent.mm.plugin.fav.a.g paramg)
  {
    AppMethodBeat.i(74615);
    Context localContext = paramViewGroup.getContext();
    if (paramView == null)
    {
      paramViewGroup = new a();
      paramView = a(View.inflate(localContext, 2130969539, null), paramViewGroup, paramg);
      paramViewGroup.ivs = ((ImageView)paramView.findViewById(2131821517));
      paramViewGroup.gpL = ((TextView)paramView.findViewById(2131820619));
      paramViewGroup.gpL.setSingleLine(false);
      paramViewGroup.gpL.setMaxLines(2);
      paramViewGroup.gpM = ((TextView)paramView.findViewById(2131820602));
      paramViewGroup.mCZ = ((TextView)paramView.findViewById(2131820615));
      a(paramViewGroup, paramg);
      paramg = com.tencent.mm.plugin.fav.a.b.c(paramg);
      paramg = ((j)com.tencent.mm.kernel.g.E(j.class)).bPQ().Ty(paramg.desc);
      if ((paramg.tac == null) || (paramg.tac.length() <= 0)) {
        ab.e("MicroMsg.FavCardListItem", "parse possible friend msg failed");
      }
      if (!bo.isNullOrNil(a(paramg))) {
        break label241;
      }
      paramViewGroup.gpM.setVisibility(8);
      label183:
      paramViewGroup.mCZ.setText(2131299735);
      paramViewGroup.mCZ.setVisibility(0);
      paramViewGroup = paramViewGroup.ivs;
      paramg = paramg.tac;
      if (!bo.isNullOrNil(paramg)) {
        break label255;
      }
      paramViewGroup.setImageResource(2130838493);
    }
    for (;;)
    {
      AppMethodBeat.o(74615);
      return paramView;
      paramViewGroup = (a)paramView.getTag();
      break;
      label241:
      paramViewGroup.gpM.setText(a(paramg));
      break label183;
      label255:
      com.tencent.mm.pluginsdk.ui.a.b.c(paramViewGroup, paramg);
    }
  }
  
  public final void a(View paramView, acs paramacs)
  {
    AppMethodBeat.i(74616);
    a locala = (a)paramView.getTag();
    paramView = paramView.getContext();
    ((y)com.tencent.mm.kernel.g.E(y.class)).a(paramView, locala.muk, paramacs);
    AppMethodBeat.o(74616);
  }
  
  public static final class a
    extends a.b
  {
    TextView gpL;
    TextView gpM;
    ImageView ivs;
    TextView mCZ;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.d.b
 * JD-Core Version:    0.7.0.1
 */