package com.tencent.mm.plugin.fts.ui.a;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
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
import com.tencent.mm.plugin.fts.a.f;
import com.tencent.mm.plugin.fts.ui.b.c;
import com.tencent.mm.plugin.fts.ui.m;
import com.tencent.mm.sdk.platformtools.bs;

public final class i
  extends a
{
  public CharSequence ruT;
  public boolean sEw;
  private b sEx;
  private a sEy;
  public String syB;
  
  public i(int paramInt)
  {
    super(12, paramInt);
    AppMethodBeat.i(112082);
    this.sEx = new b();
    this.sEy = new a();
    this.szt = false;
    AppMethodBeat.o(112082);
  }
  
  public final void a(Context paramContext, a.a parama, Object... paramVarArgs)
  {
    AppMethodBeat.i(112083);
    parama = TextUtils.ellipsize(this.sxM.syn[0], b.c.sBH, 200.0F, TextUtils.TruncateAt.MIDDLE);
    paramVarArgs = TextUtils.ellipsize(this.sxM.syn[1], b.c.sBH, 400.0F, TextUtils.TruncateAt.MIDDLE);
    if (bs.isNullOrNil(this.syB))
    {
      this.ruT = TextUtils.concat(new CharSequence[] { paramContext.getString(2131762966), f.f(parama, 0, parama.length()), paramContext.getString(2131762967), f.f(paramVarArgs, 0, paramVarArgs.length()), paramContext.getString(2131762968) });
      AppMethodBeat.o(112083);
      return;
    }
    this.ruT = TextUtils.concat(new CharSequence[] { paramContext.getString(2131762969), f.f(parama, 0, parama.length()), paramContext.getString(2131762967), f.f(paramVarArgs, 0, paramVarArgs.length()), paramContext.getString(2131762968) });
    AppMethodBeat.o(112083);
  }
  
  public final a.b adW()
  {
    return this.sEx;
  }
  
  public final class a
    extends a.a
  {
    public View contentView;
    public ImageView lzC;
    public TextView sDL;
    public View sEb;
    
    public a()
    {
      super();
    }
  }
  
  public final class b
    extends a.b
  {
    public b()
    {
      super();
    }
    
    public final View a(Context paramContext, ViewGroup paramViewGroup)
    {
      AppMethodBeat.i(112079);
      paramContext = LayoutInflater.from(paramContext).inflate(2131494196, paramViewGroup, false);
      paramViewGroup = new i.a(i.this);
      paramViewGroup.sDL = ((TextView)paramContext.findViewById(2131305880));
      paramViewGroup.lzC = ((ImageView)paramContext.findViewById(2131300891));
      paramViewGroup.sEb = paramContext.findViewById(2131303131);
      paramViewGroup.contentView = paramContext.findViewById(2131304428);
      paramContext.setTag(paramViewGroup);
      AppMethodBeat.o(112079);
      return paramContext;
    }
    
    public final void a(Context paramContext, a.a parama, a parama1, Object... paramVarArgs)
    {
      AppMethodBeat.i(112080);
      paramContext = (i.a)parama;
      parama = (i)parama1;
      m.q(paramContext.contentView, i.this.szt);
      paramContext.sDL.setText(parama.ruT);
      paramContext.lzC.setImageResource(2131690258);
      if ((i.this.position != 0) && (i.this.sEw))
      {
        paramContext.sEb.setVisibility(0);
        AppMethodBeat.o(112080);
        return;
      }
      paramContext.sEb.setVisibility(8);
      AppMethodBeat.o(112080);
    }
    
    public final boolean a(Context paramContext, a paramVarArgs)
    {
      AppMethodBeat.i(112081);
      paramVarArgs = new Intent();
      paramVarArgs.putExtra("key_talker_query", i.this.sxM.syn[0]);
      paramVarArgs.putExtra("key_query", i.this.sxM.syn[1]);
      paramVarArgs.putExtra("Search_Scene", i.this.kNw);
      if (!bs.isNullOrNil(i.this.syB))
      {
        paramVarArgs.putExtra("key_conv", i.this.syB);
        paramVarArgs.putExtra("detail_type", 1);
        d.c(paramContext, ".ui.FTSConvTalkerMessageUI", paramVarArgs);
      }
      for (;;)
      {
        AppMethodBeat.o(112081);
        return true;
        d.c(paramContext, ".ui.FTSTalkerMessageUI", paramVarArgs);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.a.i
 * JD-Core Version:    0.7.0.1
 */