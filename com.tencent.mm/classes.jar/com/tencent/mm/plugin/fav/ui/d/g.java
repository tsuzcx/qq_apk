package com.tencent.mm.plugin.fav.ui.d;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fav.a.b;
import com.tencent.mm.plugin.fav.a.y;
import com.tencent.mm.plugin.fav.ui.l;
import com.tencent.mm.protocal.protobuf.aca;
import com.tencent.mm.protocal.protobuf.acs;
import java.util.HashSet;
import java.util.Set;

public final class g
  extends a
{
  private final int mDa;
  private Set<ImageView> mDd;
  private View.OnClickListener mDe;
  
  public g(l paraml)
  {
    super(paraml);
    AppMethodBeat.i(74629);
    this.mDe = new g.1(this);
    this.mDa = com.tencent.mm.cb.a.ao(paraml.context, 2131427652);
    this.mDd = new HashSet();
    AppMethodBeat.o(74629);
  }
  
  public final View a(View paramView, ViewGroup paramViewGroup, com.tencent.mm.plugin.fav.a.g paramg)
  {
    AppMethodBeat.i(74630);
    Object localObject = paramViewGroup.getContext();
    if (paramView == null)
    {
      paramViewGroup = new g.a();
      paramView = a(View.inflate((Context)localObject, 2130969539, null), paramViewGroup, paramg);
      paramViewGroup.ivs = ((ImageView)paramView.findViewById(2131821517));
      paramViewGroup.gpL = ((TextView)paramView.findViewById(2131820619));
      paramViewGroup.gpM = ((TextView)paramView.findViewById(2131820602));
      paramViewGroup.mDg = ((ImageView)paramView.findViewById(2131821518));
      paramViewGroup.mCZ = ((TextView)paramView.findViewById(2131820615));
      paramViewGroup.mCZ.setVisibility(8);
      paramViewGroup.mDg.setOnClickListener(this.mDe);
      paramViewGroup.mDg.setVisibility(0);
      this.mDd.add(paramViewGroup.mDg);
      a(paramViewGroup, paramg);
      localObject = b.c(paramg);
      paramViewGroup.gpL.setText(((aca)localObject).title);
      paramViewGroup.gpM.setText(((aca)localObject).desc);
      paramViewGroup.gpM.setVisibility(0);
      this.mvC.a(paramViewGroup.ivs, (aca)localObject, paramg, 2131230809, this.mDa, this.mDa);
      paramViewGroup.mDg.setTag(paramg);
      if (!b.e((aca)localObject)) {
        break label256;
      }
      paramViewGroup.mDg.setImageResource(2130839751);
    }
    for (;;)
    {
      AppMethodBeat.o(74630);
      return paramView;
      paramViewGroup = (g.a)paramView.getTag();
      break;
      label256:
      paramViewGroup.mDg.setImageResource(2130839753);
    }
  }
  
  public final void a(View paramView, acs paramacs)
  {
    AppMethodBeat.i(74631);
    g.a locala = (g.a)paramView.getTag();
    paramView = paramView.getContext();
    ((y)com.tencent.mm.kernel.g.E(y.class)).a(paramView, locala.muk, paramacs);
    AppMethodBeat.o(74631);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.d.g
 * JD-Core Version:    0.7.0.1
 */