package com.tencent.mm.plugin.fts.ui.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.g.a.so;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fts.a.d.a.a.a;
import com.tencent.mm.plugin.fts.a.d.a.a.b;
import com.tencent.mm.plugin.fts.a.e;
import com.tencent.mm.plugin.fts.ui.c.d;
import com.tencent.mm.plugin.fts.ui.m;
import com.tencent.mm.protocal.protobuf.buq;
import com.tencent.mm.protocal.protobuf.dbe;

public final class s$b
  extends a.b
{
  public s$b(s params)
  {
    super(params);
  }
  
  public final View a(Context paramContext, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(152157);
    paramContext = LayoutInflater.from(paramContext).inflate(2130969678, paramViewGroup, false);
    paramViewGroup = (s.a)this.naa.mZX;
    paramViewGroup.mZY = ((ImageView)paramContext.findViewById(2131821549));
    paramViewGroup.gpL = ((TextView)paramContext.findViewById(2131821212));
    paramViewGroup.gpM = ((TextView)paramContext.findViewById(2131821007));
    paramViewGroup.mYs = ((TextView)paramContext.findViewById(2131821071));
    paramViewGroup.mZZ = ((ImageView)paramContext.findViewById(2131824405));
    paramContext.setTag(paramViewGroup);
    AppMethodBeat.o(152157);
    return paramContext;
  }
  
  public final void a(Context paramContext, a.a parama, com.tencent.mm.plugin.fts.a.d.a.a parama1, Object... paramVarArgs)
  {
    AppMethodBeat.i(152158);
    parama = (s.a)parama;
    parama.gpL.setText(this.naa.mZU);
    parama.gpM.setText(this.naa.mZV);
    parama.mYs.setText(this.naa.gpH);
    m.a(paramContext, parama.mZY, this.naa.thumbUrl, null, 2131231384, parama.mZY.getMeasuredWidth(), parama.mZY.getMeasuredHeight());
    if (this.naa.mCu)
    {
      parama.mZZ.setVisibility(0);
      AppMethodBeat.o(152158);
      return;
    }
    parama.mZZ.setVisibility(8);
    AppMethodBeat.o(152158);
  }
  
  public final boolean a(Context paramContext, com.tencent.mm.plugin.fts.a.d.a.a paramVarArgs)
  {
    AppMethodBeat.i(152159);
    paramContext = (s)paramVarArgs;
    paramVarArgs = new buq();
    paramVarArgs.fKw = paramContext.mZR.fKw;
    paramVarArgs.Scene = 25;
    paramVarArgs.xIh = e.mRl;
    paramVarArgs.xIm = e.mRk;
    paramVarArgs.xCj = System.currentTimeMillis();
    paramVarArgs.xIl = paramContext.position;
    paramVarArgs.xpv = ((int)(paramVarArgs.xCj - paramContext.mZT));
    paramVarArgs.xIi = paramContext.mZS;
    paramVarArgs.xIk = 1;
    paramContext = new d(paramVarArgs);
    g.Rc().a(paramContext, 0);
    paramContext = new so();
    paramContext.cIQ.userName = this.naa.mZR.jJA;
    paramContext.cIQ.scene = 1027;
    paramContext.cIQ.cmF = ("$CASSP$B" + e.mRl + "|" + this.naa.mZR.yhl);
    com.tencent.mm.sdk.b.a.ymk.l(paramContext);
    AppMethodBeat.o(152159);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.a.s.b
 * JD-Core Version:    0.7.0.1
 */