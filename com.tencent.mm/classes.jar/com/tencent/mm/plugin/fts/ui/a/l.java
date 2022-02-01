package com.tencent.mm.plugin.fts.ui.a;

import android.content.Context;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fts.a.a.h;
import com.tencent.mm.plugin.fts.a.d.a.a;
import com.tencent.mm.plugin.fts.a.d.a.a.a;
import com.tencent.mm.plugin.fts.a.d.a.a.b;
import com.tencent.mm.plugin.fts.a.f;
import com.tencent.mm.plugin.fts.ui.b.c;
import com.tencent.mm.plugin.fts.ui.n;

public final class l
  extends a
{
  CharSequence xds;
  private a.b xdt;
  a.a xdu;
  
  public l(int paramInt)
  {
    super(11, paramInt);
    AppMethodBeat.i(112095);
    this.xdt = new b();
    this.xdu = new a();
    AppMethodBeat.o(112095);
  }
  
  public final void a(Context paramContext, a.a parama, Object... paramVarArgs)
  {
    AppMethodBeat.i(112096);
    parama = TextUtils.ellipsize(this.wWd.wWB, b.c.wZY, 400.0F, TextUtils.TruncateAt.MIDDLE).toString();
    this.xds = f.a(paramContext.getString(2131765056), paramContext.getString(2131765055), parama);
    AppMethodBeat.o(112096);
  }
  
  public final a.b axc()
  {
    return this.xdt;
  }
  
  public final class a
    extends a.a
  {
    public View xcK;
    public TextView xcX;
    
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
      paramContext = LayoutInflater.from(paramContext).inflate(2131494757, paramViewGroup, false);
      paramViewGroup = (l.a)l.this.xdu;
      paramViewGroup.xcX = ((TextView)paramContext.findViewById(2131302657));
      paramViewGroup.xcK = paramContext.findViewById(2131305768);
      paramContext.setTag(paramViewGroup);
      AppMethodBeat.o(112093);
      return paramContext;
    }
    
    public final void a(Context paramContext, a.a parama, a parama1, Object... paramVarArgs)
    {
      AppMethodBeat.i(112094);
      paramContext = (l.a)parama;
      n.a(l.this.xds, paramContext.xcX);
      if (l.this.position == 0)
      {
        paramContext.xcK.setVisibility(8);
        AppMethodBeat.o(112094);
        return;
      }
      paramContext.xcK.setVisibility(0);
      AppMethodBeat.o(112094);
    }
    
    public final boolean a(Context paramContext, View paramView, a paramVarArgs)
    {
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.a.l
 * JD-Core Version:    0.7.0.1
 */