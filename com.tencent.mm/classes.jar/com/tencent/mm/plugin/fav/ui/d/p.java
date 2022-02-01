package com.tencent.mm.plugin.fav.ui.d;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.fav.a.g;
import com.tencent.mm.plugin.fav.a.z;
import com.tencent.mm.plugin.fav.ui.FavoriteImageServer;
import com.tencent.mm.plugin.fav.ui.q.e;
import com.tencent.mm.plugin.fav.ui.q.f;
import com.tencent.mm.protocal.protobuf.arv;
import com.tencent.mm.protocal.protobuf.arx;

public final class p
  extends b
{
  public p(FavoriteImageServer paramFavoriteImageServer)
  {
    super(paramFavoriteImageServer);
  }
  
  public final View a(View paramView, ViewGroup paramViewGroup, g paramg)
  {
    AppMethodBeat.i(107489);
    paramViewGroup = paramViewGroup.getContext();
    View localView;
    if (paramView == null)
    {
      paramView = new a();
      localView = a(View.inflate(paramViewGroup, q.f.fav_listitem_text, null), paramView, paramg);
      paramView.lNZ = ((TextView)localView.findViewById(q.e.fav_text));
      paramViewGroup = paramView;
    }
    for (;;)
    {
      a(paramViewGroup, paramg);
      if ((paramg.field_favProto.desc != null) && (paramg.field_favProto.desc.length() > 0)) {
        break;
      }
      paramViewGroup.lNZ.setText("");
      AppMethodBeat.o(107489);
      return localView;
      paramViewGroup = (a)paramView.getTag();
      localView = paramView;
    }
    paramViewGroup.lNZ.setText(com.tencent.mm.pluginsdk.ui.span.p.b(paramViewGroup.lNZ.getContext(), paramg.field_favProto.desc, paramViewGroup.lNZ.getTextSize()));
    AppMethodBeat.o(107489);
    return localView;
  }
  
  public final void a(View paramView, arx paramarx)
  {
    AppMethodBeat.i(107490);
    a locala = (a)paramView.getTag();
    paramView = paramView.getContext();
    ((z)h.ax(z.class)).a(paramView, locala.AdF, paramarx);
    AppMethodBeat.o(107490);
  }
  
  public static final class a
    extends b.b
  {
    TextView lNZ;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.d.p
 * JD-Core Version:    0.7.0.1
 */