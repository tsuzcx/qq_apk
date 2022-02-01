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
import com.tencent.mm.sdk.platformtools.Util;

public final class i
  extends a
{
  public String wWS;
  public boolean xdf;
  public CharSequence xdg;
  private b xdh;
  private a xdi;
  
  public i(int paramInt)
  {
    super(12, paramInt);
    AppMethodBeat.i(112082);
    this.xdh = new b();
    this.xdi = new a();
    this.wXK = false;
    AppMethodBeat.o(112082);
  }
  
  public final void a(Context paramContext, a.a parama, Object... paramVarArgs)
  {
    AppMethodBeat.i(112083);
    parama = TextUtils.ellipsize(this.wWd.wWE[0], b.c.wZY, 200.0F, TextUtils.TruncateAt.MIDDLE);
    paramVarArgs = TextUtils.ellipsize(this.wWd.wWE[1], b.c.wZY, 400.0F, TextUtils.TruncateAt.MIDDLE);
    if (Util.isNullOrNil(this.wWS))
    {
      str1 = paramContext.getString(2131765103);
      str2 = paramContext.getString(2131765104);
      paramContext = paramContext.getString(2131765105);
      i = str1.length();
      j = str1.length() + parama.length() + str2.length();
      this.xdg = f.f(f.f(str1 + parama + str2 + paramVarArgs + paramContext, i, parama.length() + i), j, paramVarArgs.length() + j);
      AppMethodBeat.o(112083);
      return;
    }
    String str1 = paramContext.getString(2131765106);
    String str2 = paramContext.getString(2131765104);
    paramContext = paramContext.getString(2131765105);
    int i = str1.length();
    int j = str1.length() + parama.length() + str2.length();
    this.xdg = f.f(f.f(str1 + parama + str2 + paramVarArgs + paramContext, i, parama.length() + i), j, paramVarArgs.length() + j);
    AppMethodBeat.o(112083);
  }
  
  public final a.b axc()
  {
    return this.xdh;
  }
  
  public final class a
    extends a.a
  {
    public View contentView;
    public ImageView nnL;
    public View xcK;
    public TextView xcs;
    
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
      paramContext = LayoutInflater.from(paramContext).inflate(2131494749, paramViewGroup, false);
      paramViewGroup = new i.a(i.this);
      paramViewGroup.xcs = ((TextView)paramContext.findViewById(2131309163));
      paramViewGroup.nnL = ((ImageView)paramContext.findViewById(2131302497));
      paramViewGroup.xcK = paramContext.findViewById(2131305768);
      paramViewGroup.contentView = paramContext.findViewById(2131307399);
      paramContext.setTag(paramViewGroup);
      AppMethodBeat.o(112079);
      return paramContext;
    }
    
    public final void a(Context paramContext, a.a parama, a parama1, Object... paramVarArgs)
    {
      AppMethodBeat.i(112080);
      paramContext = (i.a)parama;
      parama = (i)parama1;
      n.r(paramContext.contentView, i.this.wXK);
      paramContext.xcs.setText(parama.xdg);
      paramContext.nnL.setImageResource(2131690354);
      if ((i.this.position != 0) && (i.this.xdf))
      {
        paramContext.xcK.setVisibility(0);
        AppMethodBeat.o(112080);
        return;
      }
      paramContext.xcK.setVisibility(8);
      AppMethodBeat.o(112080);
    }
    
    public final boolean a(Context paramContext, View paramView, a paramVarArgs)
    {
      AppMethodBeat.i(235400);
      paramView = new Intent();
      paramView.putExtra("key_talker_query", i.this.wWd.wWE[0]);
      paramView.putExtra("key_query", i.this.wWd.wWE[1]);
      paramView.putExtra("Search_Scene", i.this.mve);
      if (!Util.isNullOrNil(i.this.wWS))
      {
        paramView.putExtra("key_conv", i.this.wWS);
        paramView.putExtra("detail_type", 1);
        d.d(paramContext, ".ui.FTSConvTalkerMessageUI", paramView);
      }
      for (;;)
      {
        AppMethodBeat.o(235400);
        return true;
        d.d(paramContext, ".ui.FTSTalkerMessageUI", paramView);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.a.i
 * JD-Core Version:    0.7.0.1
 */