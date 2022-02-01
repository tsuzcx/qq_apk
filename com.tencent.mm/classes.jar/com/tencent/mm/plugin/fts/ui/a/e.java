package com.tencent.mm.plugin.fts.ui.a;

import android.content.Context;
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
import com.tencent.mm.plugin.fts.ui.b.c;
import com.tencent.mm.plugin.fts.ui.m;

public final class e
  extends k
{
  public int count;
  private a rvg;
  b rvh;
  public String talker;
  
  public e(int paramInt)
  {
    super(paramInt);
    AppMethodBeat.i(112064);
    this.rvg = new a();
    this.rvh = new b();
    AppMethodBeat.o(112064);
  }
  
  public final void a(Context paramContext, a.a parama, Object... paramVarArgs)
  {
    AppMethodBeat.i(112065);
    this.header = paramContext.getString(2131762965, new Object[] { TextUtils.ellipsize(d.XV(this.talker), b.c.rsN, 500.0F, TextUtils.TruncateAt.MIDDLE) });
    AppMethodBeat.o(112065);
  }
  
  public final com.tencent.mm.plugin.fts.a.d.a.a.b acQ()
  {
    return this.rvg;
  }
  
  public final a.a cye()
  {
    return this.rvh;
  }
  
  public final class a
    extends com.tencent.mm.plugin.fts.a.d.a.a.b
  {
    public a()
    {
      super();
    }
    
    public final View a(Context paramContext, ViewGroup paramViewGroup)
    {
      AppMethodBeat.i(112062);
      paramContext = LayoutInflater.from(paramContext).inflate(2131494193, paramViewGroup, false);
      paramViewGroup = (e.b)e.this.rvh;
      paramViewGroup.nOq = ((TextView)paramContext.findViewById(2131300734));
      paramViewGroup.contentView = paramContext.findViewById(2131304428);
      paramViewGroup.rvj = paramContext.findViewById(2131303131);
      paramViewGroup.frr = ((ImageView)paramContext.findViewById(2131297008));
      paramContext.setTag(paramViewGroup);
      AppMethodBeat.o(112062);
      return paramContext;
    }
    
    public final void a(Context paramContext, a.a parama, a parama1, Object... paramVarArgs)
    {
      AppMethodBeat.i(112063);
      paramContext = (e.b)parama;
      m.a(e.this.header, paramContext.nOq);
      paramContext.contentView.setBackgroundResource(2131232878);
      com.tencent.mm.pluginsdk.ui.a.b.c(paramContext.frr, e.this.talker);
      if (e.this.position == 0)
      {
        paramContext.rvj.setVisibility(8);
        AppMethodBeat.o(112063);
        return;
      }
      paramContext.rvj.setVisibility(0);
      AppMethodBeat.o(112063);
    }
    
    public final boolean a(Context paramContext, a paramVarArgs)
    {
      return false;
    }
  }
  
  public final class b
    extends a.a
  {
    public View contentView;
    public ImageView frr;
    public TextView nOq;
    public View rvj;
    
    public b()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.a.e
 * JD-Core Version:    0.7.0.1
 */