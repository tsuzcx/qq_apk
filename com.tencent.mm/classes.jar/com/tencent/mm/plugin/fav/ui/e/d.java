package com.tencent.mm.plugin.fav.ui.e;

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
import com.tencent.mm.protocal.protobuf.afy;
import com.tencent.mm.protocal.protobuf.ago;
import com.tencent.mm.protocal.protobuf.agq;
import com.tencent.mm.sdk.platformtools.bt;

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
      paramView = a(View.inflate((Context)localObject, 2131493956, null), paramViewGroup, paramg);
      paramViewGroup.kXS = ((ImageView)paramView.findViewById(2131299794));
      paramViewGroup.ica = ((TextView)paramView.findViewById(2131299848));
      paramViewGroup.hJe = ((TextView)paramView.findViewById(2131299781));
    }
    for (;;)
    {
      a(paramViewGroup, paramg);
      afy localafy = com.tencent.mm.plugin.fav.a.b.c(paramg);
      String str = paramg.field_favProto.title;
      if (!bt.isNullOrNil(str))
      {
        localObject = str;
        if (paramg.pZE)
        {
          localObject = str;
          if (localafy == null) {}
        }
      }
      else
      {
        localObject = localafy.title;
      }
      paramViewGroup.ica.setText((CharSequence)localObject);
      paramViewGroup.hJe.setText(com.tencent.mm.plugin.fav.a.b.aS((float)localafy.Dgu));
      if (localafy.Dhh == 2) {
        paramViewGroup.hJe.setText(">" + ((af)com.tencent.mm.kernel.g.ad(af.class)).getFileSizeLimitInMB(true) + "MB");
      }
      paramViewGroup.kXS.setImageResource(e.Yv(localafy.Dgo));
      AppMethodBeat.o(107452);
      return paramView;
      paramViewGroup = (a)paramView.getTag();
    }
  }
  
  public final void a(View paramView, agq paramagq)
  {
    AppMethodBeat.i(107453);
    com.tencent.mm.plugin.fav.a.g localg = ((a)paramView.getTag()).qaS;
    paramView = paramView.getContext();
    ((y)com.tencent.mm.kernel.g.ab(y.class)).a(paramView, localg, paramagq);
    AppMethodBeat.o(107453);
  }
  
  public static final class a
    extends b.b
  {
    TextView hJe;
    TextView ica;
    ImageView kXS;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.e.d
 * JD-Core Version:    0.7.0.1
 */