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
import com.tencent.mm.sdk.platformtools.bt;

public final class i
  extends a
{
  public CharSequence qDE;
  public String rpH;
  public boolean rvE;
  private b rvF;
  private a rvG;
  
  public i(int paramInt)
  {
    super(12, paramInt);
    AppMethodBeat.i(112082);
    this.rvF = new b();
    this.rvG = new a();
    this.rqz = false;
    AppMethodBeat.o(112082);
  }
  
  public final void a(Context paramContext, a.a parama, Object... paramVarArgs)
  {
    AppMethodBeat.i(112083);
    parama = TextUtils.ellipsize(this.roS.rpt[0], b.c.rsN, 200.0F, TextUtils.TruncateAt.MIDDLE);
    paramVarArgs = TextUtils.ellipsize(this.roS.rpt[1], b.c.rsN, 400.0F, TextUtils.TruncateAt.MIDDLE);
    if (bt.isNullOrNil(this.rpH))
    {
      this.qDE = TextUtils.concat(new CharSequence[] { paramContext.getString(2131762966), f.f(parama, 0, parama.length()), paramContext.getString(2131762967), f.f(paramVarArgs, 0, paramVarArgs.length()), paramContext.getString(2131762968) });
      AppMethodBeat.o(112083);
      return;
    }
    this.qDE = TextUtils.concat(new CharSequence[] { paramContext.getString(2131762969), f.f(parama, 0, parama.length()), paramContext.getString(2131762967), f.f(paramVarArgs, 0, paramVarArgs.length()), paramContext.getString(2131762968) });
    AppMethodBeat.o(112083);
  }
  
  public final a.b acQ()
  {
    return this.rvF;
  }
  
  public final class a
    extends a.a
  {
    public View contentView;
    public ImageView kXS;
    public TextView ruT;
    public View rvj;
    
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
      paramViewGroup.ruT = ((TextView)paramContext.findViewById(2131305880));
      paramViewGroup.kXS = ((ImageView)paramContext.findViewById(2131300891));
      paramViewGroup.rvj = paramContext.findViewById(2131303131);
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
      m.q(paramContext.contentView, i.this.rqz);
      paramContext.ruT.setText(parama.qDE);
      paramContext.kXS.setImageResource(2131690258);
      if ((i.this.position != 0) && (i.this.rvE))
      {
        paramContext.rvj.setVisibility(0);
        AppMethodBeat.o(112080);
        return;
      }
      paramContext.rvj.setVisibility(8);
      AppMethodBeat.o(112080);
    }
    
    public final boolean a(Context paramContext, a paramVarArgs)
    {
      AppMethodBeat.i(112081);
      paramVarArgs = new Intent();
      paramVarArgs.putExtra("key_talker_query", i.this.roS.rpt[0]);
      paramVarArgs.putExtra("key_query", i.this.roS.rpt[1]);
      paramVarArgs.putExtra("Search_Scene", i.this.kme);
      if (!bt.isNullOrNil(i.this.rpH))
      {
        paramVarArgs.putExtra("key_conv", i.this.rpH);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.a.i
 * JD-Core Version:    0.7.0.1
 */