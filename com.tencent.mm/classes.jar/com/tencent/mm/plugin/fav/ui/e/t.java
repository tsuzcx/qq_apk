package com.tencent.mm.plugin.fav.ui.e;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.fav.a.g;
import com.tencent.mm.plugin.fav.a.z;
import com.tencent.mm.plugin.fav.ui.o;
import com.tencent.mm.plugin.fav.ui.s.e;
import com.tencent.mm.plugin.fav.ui.s.f;
import com.tencent.mm.plugin.fav.ui.s.i;
import com.tencent.mm.protocal.protobuf.anm;
import com.tencent.mm.protocal.protobuf.aoe;

public final class t
  extends b
{
  public t(o paramo)
  {
    super(paramo);
  }
  
  public final View a(View paramView, ViewGroup paramViewGroup, g paramg)
  {
    AppMethodBeat.i(107501);
    Context localContext = paramViewGroup.getContext();
    int i;
    if (paramView == null)
    {
      paramViewGroup = new a();
      paramView = a(View.inflate(localContext, s.f.fav_listitem_voice, null), paramViewGroup, paramg);
      paramViewGroup.mNb = ((TextView)paramView.findViewById(s.e.fav_title));
      a(paramViewGroup, paramg);
      i = (int)com.tencent.mm.plugin.fav.a.b.GW(com.tencent.mm.plugin.fav.a.b.c(paramg).duration);
      paramg = paramViewGroup.mNb;
      paramViewGroup = this.wJr.context;
      if (i > 0) {
        break label133;
      }
    }
    label133:
    for (paramViewGroup = paramViewGroup.getString(s.i.favorite_voice_length, new Object[] { Integer.valueOf(0) });; paramViewGroup = paramViewGroup.getString(s.i.favorite_voice_length, new Object[] { Integer.valueOf(i) }))
    {
      paramg.setText(paramViewGroup);
      AppMethodBeat.o(107501);
      return paramView;
      paramViewGroup = (a)paramView.getTag();
      break;
    }
  }
  
  public final void a(View paramView, aoe paramaoe)
  {
    AppMethodBeat.i(107502);
    a locala = (a)paramView.getTag();
    paramView = paramView.getContext();
    ((z)h.ae(z.class)).a(paramView, locala.wHw, paramaoe);
    AppMethodBeat.o(107502);
  }
  
  public static final class a
    extends b.b
  {
    TextView mNb;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.e.t
 * JD-Core Version:    0.7.0.1
 */