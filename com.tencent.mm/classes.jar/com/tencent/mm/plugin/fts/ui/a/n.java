package com.tencent.mm.plugin.fts.ui.a;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fts.a.a.h;
import com.tencent.mm.plugin.fts.a.d;
import com.tencent.mm.plugin.fts.a.d.a.a;
import com.tencent.mm.plugin.fts.a.d.a.a.a;
import com.tencent.mm.plugin.fts.a.d.a.a.b;
import com.tencent.mm.plugin.fts.ui.m;
import com.tencent.mm.sdk.platformtools.ac;

public class n
  extends a
{
  public String ikc;
  private b sES;
  private a sET;
  
  public n(int paramInt)
  {
    super(8, paramInt);
    AppMethodBeat.i(112105);
    this.sES = new b();
    this.sET = new a();
    AppMethodBeat.o(112105);
  }
  
  public void a(Context paramContext, a.a parama, Object... paramVarArgs)
  {
    AppMethodBeat.i(112106);
    parama = m.FI(this.pil);
    if (parama == null) {}
    for (this.ikc = "";; this.ikc = paramContext.getResources().getString(2131762914, new Object[] { parama }))
    {
      ac.i("MicroMsg.FTS.FTSMoreDataItem", "fillDataItem: tip=%s", new Object[] { this.ikc });
      AppMethodBeat.o(112106);
      return;
    }
  }
  
  public a.b adW()
  {
    return this.sES;
  }
  
  public final class a
    extends a.a
  {
    public View contentView;
    public ImageView lzC;
    public TextView sDL;
    
    public a()
    {
      super();
    }
  }
  
  public class b
    extends a.b
  {
    public b()
    {
      super();
    }
    
    public final View a(Context paramContext, ViewGroup paramViewGroup)
    {
      AppMethodBeat.i(112102);
      paramContext = LayoutInflater.from(paramContext).inflate(2131494216, paramViewGroup, false);
      paramViewGroup = new n.a(n.this);
      paramViewGroup.sDL = ((TextView)paramContext.findViewById(2131305880));
      paramViewGroup.lzC = ((ImageView)paramContext.findViewById(2131300891));
      paramViewGroup.contentView = paramContext.findViewById(2131304428);
      paramContext.setTag(paramViewGroup);
      AppMethodBeat.o(112102);
      return paramContext;
    }
    
    public final void a(Context paramContext, a.a parama, a parama1, Object... paramVarArgs)
    {
      AppMethodBeat.i(112103);
      paramContext = (n.a)parama;
      parama = (n)parama1;
      m.q(paramContext.contentView, n.this.szt);
      paramContext.sDL.setText(parama.ikc);
      paramContext.lzC.setImageResource(2131690258);
      AppMethodBeat.o(112103);
    }
    
    public boolean a(Context paramContext, a paramVarArgs)
    {
      AppMethodBeat.i(112104);
      paramVarArgs = new Intent();
      paramVarArgs.putExtra("detail_query", n.this.sxM.syk);
      paramVarArgs.putExtra("detail_type", n.this.pil);
      paramVarArgs.putExtra("Search_Scene", n.this.kNw);
      d.c(paramContext, ".ui.FTSDetailUI", paramVarArgs);
      AppMethodBeat.o(112104);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.a.n
 * JD-Core Version:    0.7.0.1
 */