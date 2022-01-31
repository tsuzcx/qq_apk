package com.tencent.mm.plugin.fts.ui.a;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fts.a.a.g;
import com.tencent.mm.plugin.fts.a.d;
import com.tencent.mm.plugin.fts.a.d.a.a;
import com.tencent.mm.plugin.fts.a.d.a.a.a;
import com.tencent.mm.plugin.fts.a.d.a.a.b;
import com.tencent.mm.plugin.fts.ui.m;

public class n$b
  extends a.b
{
  public n$b(n paramn)
  {
    super(paramn);
  }
  
  public final View a(Context paramContext, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(62018);
    paramContext = LayoutInflater.from(paramContext).inflate(2130969673, paramViewGroup, false);
    paramViewGroup = new n.a(this.mZG);
    paramViewGroup.mYs = ((TextView)paramContext.findViewById(2131821071));
    paramViewGroup.ivs = ((ImageView)paramContext.findViewById(2131821253));
    paramViewGroup.contentView = paramContext.findViewById(2131821209);
    paramContext.setTag(paramViewGroup);
    AppMethodBeat.o(62018);
    return paramContext;
  }
  
  public final void a(Context paramContext, a.a parama, a parama1, Object... paramVarArgs)
  {
    AppMethodBeat.i(62019);
    paramContext = (n.a)parama;
    parama = (n)parama1;
    m.q(paramContext.contentView, this.mZG.mTH);
    paramContext.mYs.setText(parama.mZD);
    paramContext.ivs.setImageResource(2131231376);
    AppMethodBeat.o(62019);
  }
  
  public boolean a(Context paramContext, a paramVarArgs)
  {
    AppMethodBeat.i(62020);
    paramVarArgs = new Intent();
    paramVarArgs.putExtra("detail_query", this.mZG.mRX.mSw);
    paramVarArgs.putExtra("detail_type", this.mZG.lox);
    paramVarArgs.putExtra("Search_Scene", this.mZG.ibk);
    d.c(paramContext, ".ui.FTSDetailUI", paramVarArgs);
    AppMethodBeat.o(62020);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.a.n.b
 * JD-Core Version:    0.7.0.1
 */