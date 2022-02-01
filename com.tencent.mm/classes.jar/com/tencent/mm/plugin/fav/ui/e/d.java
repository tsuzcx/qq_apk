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
import com.tencent.mm.protocal.protobuf.ajx;
import com.tencent.mm.protocal.protobuf.akn;
import com.tencent.mm.protocal.protobuf.akp;
import com.tencent.mm.sdk.platformtools.bu;

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
      paramViewGroup.mdt = ((ImageView)paramView.findViewById(2131299794));
      paramViewGroup.iYj = ((TextView)paramView.findViewById(2131299848));
      paramViewGroup.iFO = ((TextView)paramView.findViewById(2131299781));
    }
    for (;;)
    {
      a(paramViewGroup, paramg);
      ajx localajx = com.tencent.mm.plugin.fav.a.b.c(paramg);
      String str = paramg.field_favProto.title;
      if (!bu.isNullOrNil(str))
      {
        localObject = str;
        if (paramg.rAz)
        {
          localObject = str;
          if (localajx == null) {}
        }
      }
      else
      {
        localObject = localajx.title;
      }
      paramViewGroup.iYj.setText((CharSequence)localObject);
      paramViewGroup.iFO.setText(com.tencent.mm.plugin.fav.a.b.ba((float)localajx.GzV));
      if (localajx.GAI == 2) {
        paramViewGroup.iFO.setText(">" + ((af)com.tencent.mm.kernel.g.ad(af.class)).getFileSizeLimitInMB(true) + "MB");
      }
      paramViewGroup.mdt.setImageResource(e.ahD(localajx.GzP));
      AppMethodBeat.o(107452);
      return paramView;
      paramViewGroup = (a)paramView.getTag();
    }
  }
  
  public final void a(View paramView, akp paramakp)
  {
    AppMethodBeat.i(107453);
    com.tencent.mm.plugin.fav.a.g localg = ((a)paramView.getTag()).rBM;
    paramView = paramView.getContext();
    ((y)com.tencent.mm.kernel.g.ab(y.class)).a(paramView, localg, paramakp);
    AppMethodBeat.o(107453);
  }
  
  public static final class a
    extends b.b
  {
    TextView iFO;
    TextView iYj;
    ImageView mdt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.e.d
 * JD-Core Version:    0.7.0.1
 */