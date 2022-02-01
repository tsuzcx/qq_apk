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
import com.tencent.mm.sdk.platformtools.bt;

public final class i
  extends a
{
  public boolean tBn;
  public CharSequence tBo;
  private b tBp;
  private a tBq;
  public String tvc;
  
  public i(int paramInt)
  {
    super(12, paramInt);
    AppMethodBeat.i(112082);
    this.tBp = new b();
    this.tBq = new a();
    this.tvU = false;
    AppMethodBeat.o(112082);
  }
  
  public final void a(Context paramContext, a.a parama, Object... paramVarArgs)
  {
    AppMethodBeat.i(112083);
    parama = TextUtils.ellipsize(this.tun.tuO[0], b.c.tyi, 200.0F, TextUtils.TruncateAt.MIDDLE);
    paramVarArgs = TextUtils.ellipsize(this.tun.tuO[1], b.c.tyi, 400.0F, TextUtils.TruncateAt.MIDDLE);
    if (bt.isNullOrNil(this.tvc))
    {
      str1 = paramContext.getString(2131762966);
      str2 = paramContext.getString(2131762967);
      paramContext = paramContext.getString(2131762968);
      i = str1.length();
      j = str1.length() + parama.length() + str2.length();
      this.tBo = f.f(f.f(str1 + parama + str2 + paramVarArgs + paramContext, i, parama.length() + i), j, paramVarArgs.length() + j);
      AppMethodBeat.o(112083);
      return;
    }
    String str1 = paramContext.getString(2131762969);
    String str2 = paramContext.getString(2131762967);
    paramContext = paramContext.getString(2131762968);
    int i = str1.length();
    int j = str1.length() + parama.length() + str2.length();
    this.tBo = f.f(f.f(str1 + parama + str2 + paramVarArgs + paramContext, i, parama.length() + i), j, paramVarArgs.length() + j);
    AppMethodBeat.o(112083);
  }
  
  public final a.b agC()
  {
    return this.tBp;
  }
  
  public final class a
    extends a.a
  {
    public View contentView;
    public ImageView lZa;
    public TextView tAA;
    public View tAS;
    
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
      paramViewGroup.tAA = ((TextView)paramContext.findViewById(2131305880));
      paramViewGroup.lZa = ((ImageView)paramContext.findViewById(2131300891));
      paramViewGroup.tAS = paramContext.findViewById(2131303131);
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
      n.q(paramContext.contentView, i.this.tvU);
      paramContext.tAA.setText(parama.tBo);
      paramContext.lZa.setImageResource(2131690258);
      if ((i.this.position != 0) && (i.this.tBn))
      {
        paramContext.tAS.setVisibility(0);
        AppMethodBeat.o(112080);
        return;
      }
      paramContext.tAS.setVisibility(8);
      AppMethodBeat.o(112080);
    }
    
    public final boolean a(Context paramContext, a paramVarArgs)
    {
      AppMethodBeat.i(112081);
      paramVarArgs = new Intent();
      paramVarArgs.putExtra("key_talker_query", i.this.tun.tuO[0]);
      paramVarArgs.putExtra("key_query", i.this.tun.tuO[1]);
      paramVarArgs.putExtra("Search_Scene", i.this.ljZ);
      if (!bt.isNullOrNil(i.this.tvc))
      {
        paramVarArgs.putExtra("key_conv", i.this.tvc);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.a.i
 * JD-Core Version:    0.7.0.1
 */