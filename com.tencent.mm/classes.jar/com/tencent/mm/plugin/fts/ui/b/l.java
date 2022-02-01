package com.tencent.mm.plugin.fts.ui.b;

import android.content.Context;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.fts.a.d.a.a;
import com.tencent.mm.plugin.fts.a.d.a.a.a;
import com.tencent.mm.plugin.fts.a.d.a.a.b;
import com.tencent.mm.plugin.fts.a.f;
import com.tencent.mm.plugin.fts.ui.b.c;
import com.tencent.mm.plugin.fts.ui.o;
import com.tencent.mm.plugin.fts.ui.p.d;
import com.tencent.mm.plugin.fts.ui.p.e;
import com.tencent.mm.plugin.fts.ui.p.g;

public final class l
  extends a
{
  CharSequence HBi;
  private a.b HBj;
  a.a HBk;
  
  public l(int paramInt)
  {
    super(11, paramInt);
    AppMethodBeat.i(112095);
    this.HBj = new b();
    this.HBk = new a();
    AppMethodBeat.o(112095);
  }
  
  public final void a(Context paramContext, a.a parama, Object... paramVarArgs)
  {
    AppMethodBeat.i(112096);
    parama = TextUtils.ellipsize(this.FWt.Hte, b.c.HwT, 400.0F, TextUtils.TruncateAt.MIDDLE).toString();
    this.HBi = f.a(paramContext.getString(p.g.search_contact_no_result_pre), paramContext.getString(p.g.search_contact_no_result_post), parama);
    AppMethodBeat.o(112096);
  }
  
  public final a.b aXA()
  {
    return this.HBj;
  }
  
  public final class a
    extends a.a
  {
    public TextView HAL;
    public View HAy;
    
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
      paramContext = LayoutInflater.from(paramContext).inflate(p.e.fts_info_item, paramViewGroup, false);
      paramViewGroup = (l.a)l.this.HBk;
      paramViewGroup.HAL = ((TextView)paramContext.findViewById(p.d.info_tv));
      paramViewGroup.HAy = paramContext.findViewById(p.d.padding_view);
      paramContext.setTag(paramViewGroup);
      AppMethodBeat.o(112093);
      return paramContext;
    }
    
    public final void a(Context paramContext, a.a parama, a parama1, Object... paramVarArgs)
    {
      AppMethodBeat.i(112094);
      paramContext = (l.a)parama;
      o.a(l.this.HBi, paramContext.HAL);
      if (l.this.position == 0)
      {
        paramContext.HAy.setVisibility(8);
        AppMethodBeat.o(112094);
        return;
      }
      paramContext.HAy.setVisibility(0);
      AppMethodBeat.o(112094);
    }
    
    public final boolean a(Context paramContext, View paramView, a paramVarArgs)
    {
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.b.l
 * JD-Core Version:    0.7.0.1
 */