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
import com.tencent.mm.plugin.fts.ui.o.d;
import com.tencent.mm.plugin.fts.ui.o.e;
import com.tencent.mm.plugin.fts.ui.o.g;

public final class l
  extends a
{
  CharSequence BPq;
  private a.b BPr;
  a.a BPs;
  
  public l(int paramInt)
  {
    super(11, paramInt);
    AppMethodBeat.i(112095);
    this.BPr = new b();
    this.BPs = new a();
    AppMethodBeat.o(112095);
  }
  
  public final void a(Context paramContext, a.a parama, Object... paramVarArgs)
  {
    AppMethodBeat.i(112096);
    parama = TextUtils.ellipsize(this.BHY.BIw, b.c.BLX, 400.0F, TextUtils.TruncateAt.MIDDLE).toString();
    this.BPq = f.a(paramContext.getString(o.g.search_contact_no_result_pre), paramContext.getString(o.g.search_contact_no_result_post), parama);
    AppMethodBeat.o(112096);
  }
  
  public final a.b aEw()
  {
    return this.BPr;
  }
  
  public final class a
    extends a.a
  {
    public View BOI;
    public TextView BOV;
    
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
      paramContext = LayoutInflater.from(paramContext).inflate(o.e.fts_info_item, paramViewGroup, false);
      paramViewGroup = (l.a)l.this.BPs;
      paramViewGroup.BOV = ((TextView)paramContext.findViewById(o.d.info_tv));
      paramViewGroup.BOI = paramContext.findViewById(o.d.padding_view);
      paramContext.setTag(paramViewGroup);
      AppMethodBeat.o(112093);
      return paramContext;
    }
    
    public final void a(Context paramContext, a.a parama, a parama1, Object... paramVarArgs)
    {
      AppMethodBeat.i(112094);
      paramContext = (l.a)parama;
      n.a(l.this.BPq, paramContext.BOV);
      if (l.this.position == 0)
      {
        paramContext.BOI.setVisibility(8);
        AppMethodBeat.o(112094);
        return;
      }
      paramContext.BOI.setVisibility(0);
      AppMethodBeat.o(112094);
    }
    
    public final boolean a(Context paramContext, View paramView, a paramVarArgs)
    {
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.a.l
 * JD-Core Version:    0.7.0.1
 */