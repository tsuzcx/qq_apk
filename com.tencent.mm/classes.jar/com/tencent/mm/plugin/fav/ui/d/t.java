package com.tencent.mm.plugin.fav.ui.d;

import android.content.Context;
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
import com.tencent.mm.plugin.fav.ui.q.i;
import com.tencent.mm.protocal.protobuf.arf;
import com.tencent.mm.protocal.protobuf.arx;

public final class t
  extends b
{
  public t(FavoriteImageServer paramFavoriteImageServer)
  {
    super(paramFavoriteImageServer);
  }
  
  public final View a(View paramView, ViewGroup paramViewGroup, g paramg)
  {
    AppMethodBeat.i(107501);
    Object localObject = paramViewGroup.getContext();
    int i;
    TextView localTextView;
    if (paramView == null)
    {
      paramViewGroup = new a();
      paramView = a(View.inflate((Context)localObject, q.f.fav_listitem_voice, null), paramViewGroup, paramg);
      paramViewGroup.pJJ = ((TextView)paramView.findViewById(q.e.fav_title));
      a(paramViewGroup, paramg);
      i = (int)com.tencent.mm.plugin.fav.a.b.jh(com.tencent.mm.plugin.fav.a.b.c(paramg).duration);
      localTextView = paramViewGroup.pJJ;
      localObject = this.AfM.context;
      if (i > 0) {
        break label148;
      }
    }
    label148:
    for (localObject = ((Context)localObject).getString(q.i.favorite_voice_length, new Object[] { Integer.valueOf(0) });; localObject = ((Context)localObject).getString(q.i.favorite_voice_length, new Object[] { Integer.valueOf(i) }))
    {
      localTextView.setText((CharSequence)localObject);
      b(paramViewGroup.pJJ, paramg);
      AppMethodBeat.o(107501);
      return paramView;
      paramViewGroup = (a)paramView.getTag();
      break;
    }
  }
  
  public final void a(View paramView, arx paramarx)
  {
    AppMethodBeat.i(107502);
    a locala = (a)paramView.getTag();
    paramView = paramView.getContext();
    ((z)h.ax(z.class)).a(paramView, locala.AdF, paramarx);
    AppMethodBeat.o(107502);
  }
  
  public static final class a
    extends b.b
  {
    TextView pJJ;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.d.t
 * JD-Core Version:    0.7.0.1
 */