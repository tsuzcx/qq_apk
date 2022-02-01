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
import com.tencent.mm.plugin.fts.ui.n;
import com.tencent.mm.sdk.platformtools.bu;

public final class i
  extends a
{
  public String tFT;
  public boolean tMe;
  public CharSequence tMf;
  private b tMg;
  private a tMh;
  
  public i(int paramInt)
  {
    super(12, paramInt);
    AppMethodBeat.i(112082);
    this.tMg = new b();
    this.tMh = new a();
    this.tGL = false;
    AppMethodBeat.o(112082);
  }
  
  public final void a(Context paramContext, a.a parama, Object... paramVarArgs)
  {
    AppMethodBeat.i(112083);
    parama = TextUtils.ellipsize(this.tFe.tFF[0], b.c.tIZ, 200.0F, TextUtils.TruncateAt.MIDDLE);
    paramVarArgs = TextUtils.ellipsize(this.tFe.tFF[1], b.c.tIZ, 400.0F, TextUtils.TruncateAt.MIDDLE);
    if (bu.isNullOrNil(this.tFT))
    {
      str1 = paramContext.getString(2131762966);
      str2 = paramContext.getString(2131762967);
      paramContext = paramContext.getString(2131762968);
      i = str1.length();
      j = str1.length() + parama.length() + str2.length();
      this.tMf = f.f(f.f(str1 + parama + str2 + paramVarArgs + paramContext, i, parama.length() + i), j, paramVarArgs.length() + j);
      AppMethodBeat.o(112083);
      return;
    }
    String str1 = paramContext.getString(2131762969);
    String str2 = paramContext.getString(2131762967);
    paramContext = paramContext.getString(2131762968);
    int i = str1.length();
    int j = str1.length() + parama.length() + str2.length();
    this.tMf = f.f(f.f(str1 + parama + str2 + paramVarArgs + paramContext, i, parama.length() + i), j, paramVarArgs.length() + j);
    AppMethodBeat.o(112083);
  }
  
  public final a.b agQ()
  {
    return this.tMg;
  }
  
  public final class a
    extends a.a
  {
    public View contentView;
    public ImageView mdt;
    public View tLJ;
    public TextView tLr;
    
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
      paramViewGroup.tLr = ((TextView)paramContext.findViewById(2131305880));
      paramViewGroup.mdt = ((ImageView)paramContext.findViewById(2131300891));
      paramViewGroup.tLJ = paramContext.findViewById(2131303131);
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
      n.q(paramContext.contentView, i.this.tGL);
      paramContext.tLr.setText(parama.tMf);
      paramContext.mdt.setImageResource(2131690258);
      if ((i.this.position != 0) && (i.this.tMe))
      {
        paramContext.tLJ.setVisibility(0);
        AppMethodBeat.o(112080);
        return;
      }
      paramContext.tLJ.setVisibility(8);
      AppMethodBeat.o(112080);
    }
    
    public final boolean a(Context paramContext, a paramVarArgs)
    {
      AppMethodBeat.i(112081);
      paramVarArgs = new Intent();
      paramVarArgs.putExtra("key_talker_query", i.this.tFe.tFF[0]);
      paramVarArgs.putExtra("key_query", i.this.tFe.tFF[1]);
      paramVarArgs.putExtra("Search_Scene", i.this.lox);
      if (!bu.isNullOrNil(i.this.tFT))
      {
        paramVarArgs.putExtra("key_conv", i.this.tFT);
        paramVarArgs.putExtra("detail_type", 1);
        d.d(paramContext, ".ui.FTSConvTalkerMessageUI", paramVarArgs);
      }
      for (;;)
      {
        AppMethodBeat.o(112081);
        return true;
        d.d(paramContext, ".ui.FTSTalkerMessageUI", paramVarArgs);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.a.i
 * JD-Core Version:    0.7.0.1
 */