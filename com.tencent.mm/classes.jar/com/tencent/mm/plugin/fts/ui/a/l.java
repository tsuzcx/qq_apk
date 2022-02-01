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
  CharSequence sEJ;
  private a.b sEK;
  a.a sEL;
  
  public l(int paramInt)
  {
    super(11, paramInt);
    AppMethodBeat.i(112095);
    this.sEK = new b();
    this.sEL = new a();
    AppMethodBeat.o(112095);
  }
  
  public final void a(Context paramContext, a.a parama, Object... paramVarArgs)
  {
    AppMethodBeat.i(112096);
    parama = TextUtils.ellipsize(this.sxM.syk, b.c.sBH, 400.0F, TextUtils.TruncateAt.MIDDLE).toString();
    this.sEJ = com.tencent.mm.plugin.fts.a.f.a(paramContext.getString(2131762920), paramContext.getString(2131762919), e.c(parama, parama)).syd;
    AppMethodBeat.o(112096);
  }
  
  public final a.b adW()
  {
    return this.sEK;
  }
  
  public final class a
    extends a.a
  {
    public View sEb;
    public TextView sEo;
    
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
      paramViewGroup = (l.a)l.this.sEL;
      paramViewGroup.sEo = ((TextView)paramContext.findViewById(2131301013));
      paramViewGroup.sEb = paramContext.findViewById(2131303131);
      paramContext.setTag(paramViewGroup);
      AppMethodBeat.o(112093);
      return paramContext;
    }
    
    public final void a(Context paramContext, a.a parama, a parama1, Object... paramVarArgs)
    {
      AppMethodBeat.i(112094);
      paramContext = (l.a)parama;
      m.a(l.this.sEJ, paramContext.sEo);
      if (l.this.position == 0)
      {
        paramContext.sEb.setVisibility(8);
        AppMethodBeat.o(112094);
        return;
      }
      paramContext.sEb.setVisibility(0);
      AppMethodBeat.o(112094);
    }
    
    public final boolean a(Context paramContext, a paramVarArgs)
    {
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.a.l
 * JD-Core Version:    0.7.0.1
 */