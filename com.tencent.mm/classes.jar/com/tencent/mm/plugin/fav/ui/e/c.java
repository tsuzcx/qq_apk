package com.tencent.mm.plugin.fav.ui.e;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.fav.a.y;
import com.tencent.mm.plugin.fav.ui.o;
import com.tencent.mm.plugin.messenger.foundation.a.a.h;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.protocal.protobuf.agx;
import com.tencent.mm.protocal.protobuf.ahp;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.bj;
import com.tencent.mm.storage.bo.a;

public final class c
  extends b
{
  public c(o paramo)
  {
    super(paramo);
  }
  
  private static String a(bo.a parama)
  {
    int j = 1;
    int i = 0;
    AppMethodBeat.i(107451);
    String str = parama.eNf;
    if (bs.isNullOrNil(str))
    {
      str = parama.zTO;
      if ((!ai.aNf(str)) && (!w.wF(str))) {}
    }
    for (i = 1;; i = 0)
    {
      if ((i == 0) && (!((k)com.tencent.mm.kernel.g.ab(k.class)).awB().aNo(str))) {
        i = j;
      }
      for (;;)
      {
        boolean bool = w.nN(parama.Chb);
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
      paramViewGroup.lzC = ((ImageView)paramView.findViewById(2131299794));
      paramViewGroup.iCg = ((TextView)paramView.findViewById(2131299848));
      paramViewGroup.iCg.setSingleLine(false);
      paramViewGroup.iCg.setMaxLines(2);
      paramViewGroup.ijE = ((TextView)paramView.findViewById(2131299778));
      paramViewGroup.qTn = ((TextView)paramView.findViewById(2131299825));
      a(paramViewGroup, paramg);
      paramg = com.tencent.mm.plugin.fav.a.b.c(paramg);
      paramg = ((k)com.tencent.mm.kernel.g.ab(k.class)).dcr().alw(paramg.desc);
      if ((paramg.zTO == null) || (paramg.zTO.length() <= 0)) {
        ac.e("MicroMsg.FavCardListItem", "parse possible friend msg failed");
      }
      if (!bs.isNullOrNil(a(paramg))) {
        break label241;
      }
      paramViewGroup.ijE.setVisibility(8);
      label183:
      paramViewGroup.qTn.setText(2131758907);
      paramViewGroup.qTn.setVisibility(0);
      paramViewGroup = paramViewGroup.lzC;
      paramg = paramg.zTO;
      if (!bs.isNullOrNil(paramg)) {
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
      paramViewGroup.ijE.setText(a(paramg));
      break label183;
      label255:
      a.b.c(paramViewGroup, paramg);
    }
  }
  
  public final void a(View paramView, ahp paramahp)
  {
    AppMethodBeat.i(107450);
    a locala = (a)paramView.getTag();
    paramView = paramView.getContext();
    ((y)com.tencent.mm.kernel.g.ab(y.class)).a(paramView, locala.qJy, paramahp);
    AppMethodBeat.o(107450);
  }
  
  public static final class a
    extends b.b
  {
    TextView iCg;
    TextView ijE;
    ImageView lzC;
    TextView qTn;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.e.c
 * JD-Core Version:    0.7.0.1
 */