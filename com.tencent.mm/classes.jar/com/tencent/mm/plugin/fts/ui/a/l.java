package com.tencent.mm.plugin.fts.ui.a;

import android.content.Context;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fts.a.a.e;
import com.tencent.mm.plugin.fts.a.a.h;
import com.tencent.mm.plugin.fts.a.d.a.a;
import com.tencent.mm.plugin.fts.a.d.a.a.a;
import com.tencent.mm.plugin.fts.a.d.a.a.b;
import com.tencent.mm.plugin.fts.ui.b.c;
import com.tencent.mm.plugin.fts.ui.m;

public final class l
  extends a
{
  CharSequence rvR;
  private a.b rvS;
  a.a rvT;
  
  public l(int paramInt)
  {
    super(11, paramInt);
    AppMethodBeat.i(112095);
    this.rvS = new b();
    this.rvT = new a();
    AppMethodBeat.o(112095);
  }
  
  public final void a(Context paramContext, a.a parama, Object... paramVarArgs)
  {
    AppMethodBeat.i(112096);
    parama = TextUtils.ellipsize(this.roS.rpq, b.c.rsN, 400.0F, TextUtils.TruncateAt.MIDDLE).toString();
    this.rvR = com.tencent.mm.plugin.fts.a.f.a(paramContext.getString(2131762920), paramContext.getString(2131762919), e.b(parama, parama)).rpj;
    AppMethodBeat.o(112096);
  }
  
  public final a.b acQ()
  {
    return this.rvS;
  }
  
  public final class a
    extends a.a
  {
    public View rvj;
    public TextView rvw;
    
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
      AppMethodBeat.i(112093);
      paramContext = LayoutInflater.from(paramContext).inflate(2131494204, paramViewGroup, false);
      paramViewGroup = (l.a)l.this.rvT;
      paramViewGroup.rvw = ((TextView)paramContext.findViewById(2131301013));
      paramViewGroup.rvj = paramContext.findViewById(2131303131);
      paramContext.setTag(paramViewGroup);
      AppMethodBeat.o(112093);
      return paramContext;
    }
    
    public final void a(Context paramContext, a.a parama, a parama1, Object... paramVarArgs)
    {
      AppMethodBeat.i(112094);
      paramContext = (l.a)parama;
      m.a(l.this.rvR, paramContext.rvw);
      if (l.this.position == 0)
      {
        paramContext.rvj.setVisibility(8);
        AppMethodBeat.o(112094);
        return;
      }
      paramContext.rvj.setVisibility(0);
      AppMethodBeat.o(112094);
    }
    
    public final boolean a(Context paramContext, a paramVarArgs)
    {
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.a.l
 * JD-Core Version:    0.7.0.1
 */