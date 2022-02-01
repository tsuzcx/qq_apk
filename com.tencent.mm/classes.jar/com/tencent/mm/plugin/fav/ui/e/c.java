package com.tencent.mm.plugin.fav.ui.e;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.ab;
import com.tencent.mm.plugin.fav.a.g;
import com.tencent.mm.plugin.fav.a.z;
import com.tencent.mm.plugin.fav.ui.o;
import com.tencent.mm.plugin.fav.ui.s.d;
import com.tencent.mm.plugin.fav.ui.s.e;
import com.tencent.mm.plugin.fav.ui.s.f;
import com.tencent.mm.plugin.fav.ui.s.i;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.protocal.protobuf.anm;
import com.tencent.mm.protocal.protobuf.aoe;
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
    String str = parama.idS;
    if (Util.isNullOrNil(str))
    {
      str = parama.fcC;
      if ((!as.bvU(str)) && (!ab.Qk(str))) {}
    }
    for (i = 1;; i = 0)
    {
      if ((i == 0) && (!((n)h.ae(n.class)).bbL().bwd(str))) {
        i = j;
      }
      for (;;)
      {
        boolean bool = ab.uL(parama.PKJ);
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
  
  public final View a(View paramView, ViewGroup paramViewGroup, g paramg)
  {
    AppMethodBeat.i(107449);
    Context localContext = paramViewGroup.getContext();
    if (paramView == null)
    {
      paramViewGroup = new a();
      paramView = a(View.inflate(localContext, s.f.fav_listitem_appmsg, null), paramViewGroup, paramg);
      paramViewGroup.qps = ((ImageView)paramView.findViewById(s.e.fav_icon));
      paramViewGroup.mNb = ((TextView)paramView.findViewById(s.e.fav_title));
      paramViewGroup.mNb.setSingleLine(false);
      paramViewGroup.mNb.setMaxLines(2);
      paramViewGroup.mrM = ((TextView)paramView.findViewById(s.e.fav_desc));
      paramViewGroup.wRL = ((TextView)paramView.findViewById(s.e.fav_source));
      a(paramViewGroup, paramg);
      paramg = com.tencent.mm.plugin.fav.a.b.c(paramg);
      paramg = ((n)h.ae(n.class)).eSe().aOU(paramg.desc);
      if ((paramg.fcC == null) || (paramg.fcC.length() <= 0)) {
        Log.e("MicroMsg.FavCardListItem", "parse possible friend msg failed");
      }
      if (!Util.isNullOrNil(a(paramg))) {
        break label248;
      }
      paramViewGroup.mrM.setVisibility(8);
      label188:
      paramViewGroup.wRL.setText(s.i.favorite_friend_card);
      paramViewGroup.wRL.setVisibility(0);
      paramViewGroup = paramViewGroup.qps;
      paramg = paramg.fcC;
      if (!Util.isNullOrNil(paramg)) {
        break label262;
      }
      paramViewGroup.setImageResource(s.d.default_avatar);
    }
    for (;;)
    {
      AppMethodBeat.o(107449);
      return paramView;
      paramViewGroup = (a)paramView.getTag();
      break;
      label248:
      paramViewGroup.mrM.setText(a(paramg));
      break label188;
      label262:
      a.b.c(paramViewGroup, paramg);
    }
  }
  
  public final void a(View paramView, aoe paramaoe)
  {
    AppMethodBeat.i(107450);
    a locala = (a)paramView.getTag();
    paramView = paramView.getContext();
    ((z)h.ae(z.class)).a(paramView, locala.wHw, paramaoe);
    AppMethodBeat.o(107450);
  }
  
  public static final class a
    extends b.b
  {
    TextView mNb;
    TextView mrM;
    ImageView qps;
    TextView wRL;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.e.c
 * JD-Core Version:    0.7.0.1
 */