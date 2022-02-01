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
import com.tencent.mm.protocal.protobuf.agx;
import com.tencent.mm.protocal.protobuf.ahn;
import com.tencent.mm.protocal.protobuf.ahp;
import com.tencent.mm.sdk.platformtools.bs;

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
      paramViewGroup.lzC = ((ImageView)paramView.findViewById(2131299794));
      paramViewGroup.iCg = ((TextView)paramView.findViewById(2131299848));
      paramViewGroup.ijE = ((TextView)paramView.findViewById(2131299781));
    }
    for (;;)
    {
      a(paramViewGroup, paramg);
      agx localagx = com.tencent.mm.plugin.fav.a.b.c(paramg);
      String str = paramg.field_favProto.title;
      if (!bs.isNullOrNil(str))
      {
        localObject = str;
        if (paramg.qIl)
        {
          localObject = str;
          if (localagx == null) {}
        }
      }
      else
      {
        localObject = localagx.title;
      }
      paramViewGroup.iCg.setText((CharSequence)localObject);
      paramViewGroup.ijE.setText(com.tencent.mm.plugin.fav.a.b.aX((float)localagx.EzA));
      if (localagx.EAn == 2) {
        paramViewGroup.ijE.setText(">" + ((af)com.tencent.mm.kernel.g.ad(af.class)).getFileSizeLimitInMB(true) + "MB");
      }
      paramViewGroup.lzC.setImageResource(e.acR(localagx.Ezu));
      AppMethodBeat.o(107452);
      return paramView;
      paramViewGroup = (a)paramView.getTag();
    }
  }
  
  public final void a(View paramView, ahp paramahp)
  {
    AppMethodBeat.i(107453);
    com.tencent.mm.plugin.fav.a.g localg = ((a)paramView.getTag()).qJy;
    paramView = paramView.getContext();
    ((y)com.tencent.mm.kernel.g.ab(y.class)).a(paramView, localg, paramahp);
    AppMethodBeat.o(107453);
  }
  
  public static final class a
    extends b.b
  {
    TextView iCg;
    TextView ijE;
    ImageView lzC;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.e.d
 * JD-Core Version:    0.7.0.1
 */