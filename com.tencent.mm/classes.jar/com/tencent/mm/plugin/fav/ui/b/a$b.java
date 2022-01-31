package com.tencent.mm.plugin.fav.ui.b;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.gi;
import com.tencent.mm.g.a.gi.a;
import com.tencent.mm.plugin.fts.a.a.l;
import com.tencent.mm.plugin.fts.ui.m;
import com.tencent.mm.protocal.protobuf.acs;
import com.tencent.mm.ui.MMImageView;

public final class a$b
  extends com.tencent.mm.plugin.fts.a.d.a.a.b
{
  public a$b(a parama)
  {
    super(parama);
  }
  
  public final View a(Context paramContext, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(74489);
    paramContext = LayoutInflater.from(paramContext).inflate(2130969658, paramViewGroup, false);
    paramViewGroup = (a.a)this.mBP.mBL;
    paramViewGroup.mBM = ((MMImageView)paramContext.findViewById(2131821210));
    paramViewGroup.gpL = ((TextView)paramContext.findViewById(2131821212));
    paramViewGroup.mBN = ((TextView)paramContext.findViewById(2131824327));
    paramViewGroup.mBO = ((TextView)paramContext.findViewById(2131824328));
    paramViewGroup.gqg = paramContext.findViewById(2131821148);
    paramContext.setTag(paramViewGroup);
    AppMethodBeat.o(74489);
    return paramContext;
  }
  
  public final void a(Context paramContext, com.tencent.mm.plugin.fts.a.d.a.a.a parama, com.tencent.mm.plugin.fts.a.d.a.a parama1, Object... paramVarArgs)
  {
    AppMethodBeat.i(74490);
    parama = (a.a)parama;
    parama1 = (a)parama1;
    m.a(paramContext, parama.mBM, parama1.gGm, parama1.mBI, parama1.mBJ, parama.mBM.getMeasuredWidth(), parama.mBM.getMeasuredHeight());
    a.a(parama.gpL, parama.mBN, this.mBP.mBF, this.mBP.mBG);
    m.a(this.mBP.mBH, parama.mBO);
    if (this.mBP.mBE)
    {
      parama.gqg.setVisibility(0);
      AppMethodBeat.o(74490);
      return;
    }
    parama.gqg.setVisibility(8);
    AppMethodBeat.o(74490);
  }
  
  public final boolean a(Context paramContext, com.tencent.mm.plugin.fts.a.d.a.a paramVarArgs)
  {
    AppMethodBeat.i(74491);
    paramVarArgs = (a)paramVarArgs;
    gi localgi = new gi();
    localgi.cuX.type = 10;
    localgi.cuX.cpM = paramVarArgs.hrL.mSZ;
    localgi.cuX.context = paramContext;
    localgi.cuX.cvi = new acs();
    if (this.mBP.pageType == 1) {}
    for (localgi.cuX.cvi.scene = 3;; localgi.cuX.cvi.scene = 4)
    {
      localgi.cuX.cvi.kbN = 3;
      localgi.cuX.cvi.index = this.mBP.mTJ;
      com.tencent.mm.sdk.b.a.ymk.l(localgi);
      AppMethodBeat.o(74491);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.b.a.b
 * JD-Core Version:    0.7.0.1
 */