package com.tencent.mm.plugin.fts.ui.a;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fts.a.d;
import com.tencent.mm.plugin.fts.a.d.a.a;
import com.tencent.mm.plugin.fts.a.d.a.a.a;
import com.tencent.mm.plugin.fts.a.d.a.a.b;
import com.tencent.mm.plugin.fts.ui.m;
import com.tencent.mm.sdk.platformtools.bo;

public final class i$b
  extends a.b
{
  public i$b(i parami)
  {
    super(parami);
  }
  
  public final View a(Context paramContext, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(61995);
    paramContext = LayoutInflater.from(paramContext).inflate(2130969654, paramViewGroup, false);
    paramViewGroup = new i.a(this.mZj);
    paramViewGroup.mYs = ((TextView)paramContext.findViewById(2131821071));
    paramViewGroup.ivs = ((ImageView)paramContext.findViewById(2131821253));
    paramViewGroup.mYK = paramContext.findViewById(2131820910);
    paramViewGroup.contentView = paramContext.findViewById(2131821209);
    paramContext.setTag(paramViewGroup);
    AppMethodBeat.o(61995);
    return paramContext;
  }
  
  public final void a(Context paramContext, a.a parama, a parama1, Object... paramVarArgs)
  {
    AppMethodBeat.i(61996);
    paramContext = (i.a)parama;
    parama = (i)parama1;
    m.q(paramContext.contentView, this.mZj.mTH);
    paramContext.mYs.setText(parama.mZg);
    paramContext.ivs.setImageResource(2131231376);
    if ((this.mZj.position != 0) && (this.mZj.mZf))
    {
      paramContext.mYK.setVisibility(0);
      AppMethodBeat.o(61996);
      return;
    }
    paramContext.mYK.setVisibility(8);
    AppMethodBeat.o(61996);
  }
  
  public final boolean a(Context paramContext, a paramVarArgs)
  {
    AppMethodBeat.i(61997);
    paramVarArgs = new Intent();
    paramVarArgs.putExtra("key_talker_query", this.mZj.mRX.mSz[0]);
    paramVarArgs.putExtra("key_query", this.mZj.mRX.mSz[1]);
    paramVarArgs.putExtra("Search_Scene", this.mZj.ibk);
    if (!bo.isNullOrNil(this.mZj.mSN))
    {
      paramVarArgs.putExtra("key_conv", this.mZj.mSN);
      paramVarArgs.putExtra("detail_type", 1);
      d.c(paramContext, ".ui.FTSConvTalkerMessageUI", paramVarArgs);
    }
    for (;;)
    {
      AppMethodBeat.o(61997);
      return true;
      d.c(paramContext, ".ui.FTSTalkerMessageUI", paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.a.i.b
 * JD-Core Version:    0.7.0.1
 */