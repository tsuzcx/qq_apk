package com.tencent.mm.plugin.fav.ui.e;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.fav.a.ag;
import com.tencent.mm.plugin.fav.a.g;
import com.tencent.mm.plugin.fav.a.z;
import com.tencent.mm.plugin.fav.ui.e;
import com.tencent.mm.plugin.fav.ui.o;
import com.tencent.mm.plugin.fav.ui.s.e;
import com.tencent.mm.plugin.fav.ui.s.f;
import com.tencent.mm.protocal.protobuf.anm;
import com.tencent.mm.protocal.protobuf.aoc;
import com.tencent.mm.protocal.protobuf.aoe;
import com.tencent.mm.sdk.platformtools.Util;

public final class d
  extends b
{
  public d(o paramo)
  {
    super(paramo);
  }
  
  public final View a(View paramView, ViewGroup paramViewGroup, g paramg)
  {
    AppMethodBeat.i(107452);
    Object localObject = paramViewGroup.getContext();
    if (paramView == null)
    {
      paramViewGroup = new a();
      paramView = a(View.inflate((Context)localObject, s.f.fav_listitem_comm_card, null), paramViewGroup, paramg);
      paramViewGroup.qps = ((ImageView)paramView.findViewById(s.e.fav_icon));
      paramViewGroup.mNb = ((TextView)paramView.findViewById(s.e.fav_title));
      paramViewGroup.mrM = ((TextView)paramView.findViewById(s.e.fav_detail));
    }
    for (;;)
    {
      a(paramViewGroup, paramg);
      anm localanm = com.tencent.mm.plugin.fav.a.b.c(paramg);
      String str = paramg.field_favProto.title;
      if (!Util.isNullOrNil(str))
      {
        localObject = str;
        if (paramg.wGh)
        {
          localObject = str;
          if (localanm == null) {}
        }
      }
      else
      {
        localObject = localanm.title;
      }
      paramViewGroup.mNb.setText((CharSequence)localObject);
      paramViewGroup.mrM.setText(com.tencent.mm.plugin.fav.a.b.getLengthStr((float)localanm.Syi));
      if (localanm.SyU == 2) {
        paramViewGroup.mrM.setText(">" + ((ag)h.ag(ag.class)).getFileSizeLimitInMB(true) + "MB");
      }
      paramViewGroup.qps.setImageResource(e.aAm(localanm.Syc));
      AppMethodBeat.o(107452);
      return paramView;
      paramViewGroup = (a)paramView.getTag();
    }
  }
  
  public final void a(View paramView, aoe paramaoe)
  {
    AppMethodBeat.i(107453);
    g localg = ((a)paramView.getTag()).wHw;
    paramView = paramView.getContext();
    ((z)h.ae(z.class)).a(paramView, localg, paramaoe);
    AppMethodBeat.o(107453);
  }
  
  public static final class a
    extends b.b
  {
    TextView mNb;
    TextView mrM;
    ImageView qps;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.e.d
 * JD-Core Version:    0.7.0.1
 */